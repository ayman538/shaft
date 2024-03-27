package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.*;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-832")
public class WFHT_832 extends ST_MNP_Setup{
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
                .navigateDeeplinkST(deeplink);

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








