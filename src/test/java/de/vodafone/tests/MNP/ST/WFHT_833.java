package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.LandingPage;
import de.vodafone.pages.MNP.StatusPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-833")
public class WFHT_833 extends ST_MNP_Setup {
    private String deeplink;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver = new SHAFT.GUI.WebDriver();

        new LoginPage(driver).
                navigateST().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @TmsLink("WFHT-1061")
    @Test(description = "GC01 - Logged in new Vodafone User - Validate the page header and transaction title.")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateHeaderCL();
    }

    @TmsLink("WFHT-1062")
    @Test(description = "GC02 - Logged in new Vodafone User- Validate the info message for customer has Successfully transmitted to D2 status.")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateErfolgreichanD2uebermitteltStatus();
    }

    @TmsLink("WFHT-1063")
    @Test(description = "GC03 - Logged in new Vodafone User- Validate the info message for customer has Ready for credit check status.")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateBereitzurBonitaetspruefungStatus();
    }

    @TmsLink("WFHT-1064")
    @Test(description = "GC04 - Logged in new Vodafone User- Validate the info message for customer has Manual testing status.")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateManuellePruefungStatus();
    }

    @TmsLink("WFHT-1065")
    @Test(description = "GC05 - Logged in new Vodafone User- Validate the info message for customer has 'completed' status.")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateerledigtStatus();
    }

    @TmsLink("WFHT-1066")
    @Test(description = "GC06 - Logged in new Vodafone User- Validate the info message for customer has Export booked status.")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateExportgebuchtStatus();
    }

    @TmsLink("WFHT-1067")
    @Test(description = "GC07 - Logged in new Vodafone User- Validate the info message for customer has other status default status.")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateDefaultStatus();
    }

    @TmsLink("WFHT-1072")
    @Test(description = "GC12 -logged in new Vodafone User- Validate the status in case there is an ERRORCODE in orderStatusInportPUT response.")
    public void GC12() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateErrorCodeStatus();
    }

    @TmsLink("WFHT-1073")
    @Test(description = "BC01 -Logged in new Vodafone User- Verify error message in case of service failure.")
    public void BC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateServiceFailure();
    }

    @TmsLink("WFHT-1099")
    @Test(description = "BC02 -Logged in new Vodafone User- Verify error message in case of missing data.")
    public void BC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateMissingData();
    }

    @TmsLink("WFHT-1100")
    @Test(description = "BC03 -Logged in new Vodafone User- Verify error message in case it's too early to check the status.")
    public void BC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateTooEarlyErrorMsg();
    }

    @TmsLink("WFHT-1101")
    @Test(description = "BC04 -Logged in new Vodafone User- Verify error message in case the phone number is currently unavailable.")
    public void BC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateCurrentlyUnavailableMsg();
    }

    @TmsLink("WFHT-1102")
    @Test(description = "BC05 -Logged in new Vodafone User- Verify error message in case no port status could be found for this credential.")
    public void BC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validatenoPortStatusFoundErrorMsg();
    }

    @TmsLink("WFHT-1103")
    @Test(description = "BC06 -Logged in new Vodafone User- Verify error message in case no port job could be found for these credentials.")
    public void BC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validatenoPortjobFoundErrorMsg();
    }

    @TmsLink("WFHT-1347")
    @Test(description = "BC07 - Not Logged in new Vodafone User- Verify error message in case unauthorized user.")
    public void BC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new StatusPage(driver)
                .validateUnauthorizedUserMsg()
                .validateClickOnLandingPageCTA();
    }
}







