package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-831")
public class WFHT_831 extends ST_MNP_Setup{
    private String deeplink;
    private String contactNumber;
    private String smsNumber;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        contactNumber = testData.getTestData(method.getName() + ".contactNumber");
        smsNumber = testData.getTestData(method.getName() + ".smsNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver).
                navigateST().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @TmsLink("WFHT-1051")
    @Test(description = "GC01 - logged in Vodafone User - Verify Page Header and Vodafone Number Displayed when User Ports to MNP without documents")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

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
                .navigateDeeplinkST(deeplink);

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
                .navigateDeeplinkST(deeplink);

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
                .navigateDeeplinkST(deeplink);

        new LoginPage(driver)
                .validateInformationMessage2CL(contactNumber)
                .clickPostpaidContractRadioButton()
                .clickAbbrechenButton()
                .verifyAbbrechenButtonRedirection();
    }

    @TmsLink("WFHT-1056")
    @Test(description = "GC06 - logged in Vodafone User - Verify Logout Behavior")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .verifyErrorPageRedirection();
    }

    @TmsLink("WFHT-1232")
    @Test(description = "GC07 - logged in Vodafone User - Verify General Error Page Behavior")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);

        new StartPage(driver)
                .validateErrorPageTitleDisplayed()
                .verifyServiceFailureMessage1();
    }
}








