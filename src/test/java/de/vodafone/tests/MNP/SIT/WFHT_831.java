package de.vodafone.tests.MNP.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.MNP.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("SIT")
@Story("WFHT-831")
public class WFHT_831 extends SIT_MNP_Setup {
    private SHAFT.GUI.WebDriver driver;
    private String deeplink;
    private String contactNumber;
    private String smsNumber;
    private JSONFileManager cookieMap;
    private JSONFileManager testData;
    private HashMap<String,String> cookieSwitcherMap;
    private String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        contactNumber = testData.getTestData(method.getName() + ".contactNumber");
        smsNumber = testData.getTestData(method.getName() + ".smsNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver).
                navigateSIT().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/SIT/SIT_" + className + "_CookieSwitcher.json");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "MNP/SIT/" + className + ".json");
        cookieSwitcherMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/SIT/SIT_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
    }
    @TmsLink("WFHT-1051")
    @Test(description = "GC01 - logged in Vodafone User - Verify Page Header and Vodafone Number Displayed when User Ports to MNP without documents")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink)
                .clickMitHandyNummerEinLoggenButton();

        new LoginPage(driver)
                .enterVodafoneNumber(contactNumber)
                .enterSmsNumber(smsNumber);

        new FormPage(driver)
                .choosePortingWithoutDocsButton();

        new StartPage(driver)
                .validatePageTitleDisplayed();

        new LoginPage(driver)
                .validateVodafoneNumberCLDisplayed()
                .validateVodafoneNumberExists(contactNumber)
                .validateInformationMessage2CL(contactNumber);
    }

    @TmsLink("WFHT-1052")
    @Test(description = "GC02 - logged in Vodafone User - Verify Redirection when choosing Contract type as Postpaid")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink)
                .clickMitHandyNummerEinLoggenButton();

        new LoginPage(driver)
                .enterVodafoneNumber(contactNumber)
                .enterSmsNumber(smsNumber);

        new FormPage(driver)
                .choosePortingWithoutDocsButton();

        new LoginPage(driver)
                .validateInformationMessage2CL(contactNumber)
                .clickPostpaidContractRadioButton()
                .clickWeiterButton()
                .verifyPostPaidWeiterButtonOptionRedirection();
    }

    @TmsLink("WFHT-1053")
    @Test(description = "GC03 - logged in Vodafone User - Verify Redirection when choosing Contract type as Prepaid")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink)
                .clickMitHandyNummerEinLoggenButton();

        new LoginPage(driver)
                .enterVodafoneNumber(contactNumber)
                .enterSmsNumber(smsNumber);

        new FormPage(driver)
                .choosePortingWithoutDocsButton();

        new LoginPage(driver)
                .validateInformationMessage2CL(contactNumber)
                .clickPrepaidContractRadioButton()
                .clickWeiterButton()
                .verifyPrePaidWeiterButtonRedirection();
    }

    @TmsLink("WFHT-1054")
    @Test(description = "GC04 - logged in Vodafone User - Verify Redirection when clicking on Abbrechen Button")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink)
                .clickMitHandyNummerEinLoggenButton();

        new LoginPage(driver)
                .enterVodafoneNumber(contactNumber)
                .enterSmsNumber(smsNumber);

        new FormPage(driver)
                .choosePortingWithoutDocsButton();

        new LoginPage(driver)
                .validateInformationMessage2CL(contactNumber)
                .clickPrepaidContractRadioButton()
                .clickAbbrechenButton()
                .verifyAbbrechenButtonRedirection();
    }

    @TmsLink("WFHT-1056")
    @Test(description = "GC06 - logged in Vodafone User - Verify Logout Behavior")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink)
                .clickMitHandyNummerEinLoggenButton();

        new LoginPage(driver)
                .enterVodafoneNumber(contactNumber)
                .enterSmsNumber(smsNumber);

        new FormPage(driver)
                .choosePortingWithoutDocsButton();

        new StartPage(driver)
                .verifyErrorPageRedirection();
    }

    @TmsLink("WFHT-1232")
    @Test(description = "GC07 - logged in Vodafone User - Verify General Error Page Behavior")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink)
                .clickMitHandyNummerEinLoggenButton();

        new LoginPage(driver)
                .enterVodafoneNumber(contactNumber)
                .enterSmsNumber(smsNumber);

        new FormPage(driver)
                .choosePortingWithoutDocsButton();

        new StartPage(driver)
                .validateErrorPageTitleDisplayed()
                .validateErrorMessage1IfPageFailed();
    }
}








