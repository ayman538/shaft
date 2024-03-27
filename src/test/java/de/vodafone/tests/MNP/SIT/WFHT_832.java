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
@Story("WFHT-832")
public class WFHT_832 extends SIT_MNP_Setup {
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

    @TmsLink("WFHT-1057")
    @Test(description = "GC01 - non logged in Vodafone User - Deeplink to MNP request page - Verify MNP Login Page Details Displayed")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new LoginPage(driver)
                .validateHeaderAndSubHeaderCL()
                .validateMTanLoginButtonCL()
                .validateStatusPageButtonCL()
                .validateInformationMessageCL()
                .clickMoreInfoButton()
                .verifyMoreInfoButtonRedirection();
    }

    @TmsLink("WFHT-1058")
    @Test(description = "GC02 - logged in Vodafone User - Click on Button from Help Form - Verify MNP Start Page Details Displayed")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink)
                .clickMitHandyNummerEinLoggenButton();

        new LoginPage(driver)
                .enterVodafoneNumber(contactNumber)
                .enterSmsNumber(smsNumber);

        new StartPage(driver)
                .validatePageHeaderCL()
                .validateVodafoneNumberCLDisplayed()
                .validateVodafoneNumberExists(contactNumber)
                .validateInformationMessage3CL(contactNumber)
                .clickJetztRufNummernMitnahmeStartenButton()
                .verifyJetztRufNummernMitnahmeStartenButtonRedirection();

        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .clickAbbrechenButton()
                .verifyAbbrechenButtonRedirection();
    }

    @TmsLink("WFHT-1059")
    @Test(description = "GC03 - non logged in Vodafone User - Click on Button from MNP landing page - Verify MNP Error Page Details Displayed")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .validateErrorPageTitleDisplayed()
                .validateErrorMessage1IfPageFailed()
                .verifyJetztRufNummernMitnahmeStartenButtonIsDimmed()
                .clickAbbrechenButton()
                .verifyAbbrechenButtonRedirection();
    }

    @TmsLink("WFHT-1237")
    @Test(description = "GC05 - non logged in Vodafone User - Deeplink to MNP request page - Verify Logout Behavior")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .verifyErrorPageRedirection();
    }

}








