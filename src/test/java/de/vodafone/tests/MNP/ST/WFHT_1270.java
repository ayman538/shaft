package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.LandingPage;
import de.vodafone.pages.MNP.PortingWODocumentsPostpaidPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-1270")
public class WFHT_1270 extends ST_MNP_Setup{
    private String deeplink;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());

        driver= new SHAFT.GUI.WebDriver();

        new LoginPage(driver).
                navigateST().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @TmsLink("WFHT-1443")
    @Test(description = "GC01 - Postpaid not terminated Vodafone user - Verify that new section is displayed to check If the user has informed the previous provider upon selecting ASAP.")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnNoCancelledRadioButton()
                .clickOnWeiterButton2()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton();
    }

    @TmsLink("WFHT-1442")
    @Test(description = "GC02 - Postpaid not terminated Vodafone user - Verify that user can procced in the form in case the previous provider is informed.")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnNoCancelledRadioButton()
                .clickOnWeiterButton2()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton()
                .validateInformedMsg()
                .clickOnWeiterButton3();
    }

    @TmsLink("1441")
    @Test(description = "GC03 - Postpaid not terminated Vodafone user - Verify error message appeared in case the previous provider is not informed.")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnNoCancelledRadioButton()
                .clickOnWeiterButton2()

                .clickOnASARadioButton()
                .clickOnNotInformedRadioButton()
                .validateNotInformedMsg()
                .validateWeiterCTAIsDimmed2();
    }

    @TmsLink("WFHT-1444")
    @Test(description = "GC04 - Postpaid not terminated Vodafone user - verify error message in case At the end of the contract.")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnNoCancelledRadioButton()
                .clickOnWeiterButton2()

                .clickOnASARadioButton()
                .clickOnEOCRadioButton()
                .validateEndOfContractMsg()
                .validateWeiterCTAIsDimmed2();
    }

    @TmsLink("WFHT-1445")
    @Test(description = "GC05 - Postpaid not terminated Vodafone user - validate that every accordion Step can be expanded, collapsed, and has edit icon")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnNoCancelledRadioButton()
                .clickOnWeiterButton2()
                .clickOnASARadioButton()
                .expandAndCollapsePostpaidAccordion();

    }
    @TmsLink("WFHT-1446")
    @Test(description = "GC06 -Postpaid not terminated Vodafone user - validate that Each step has proceed CTA button redirects the user to the next step")
    public void GC06() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnCancelButton();
    }

    @TmsLink("WFHT-1447")
    @Test(description = "GC07 - Postpaid not terminated Vodafone user - validate that Each step has cancel CTA button redirects the user to MNP start Page the user to the next step")
    public void GC07() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .fillLaufzeitVertragRadioButton()
                .clickOnWeiterButton()
                .clickOnNoCancelledRadioButton()
                .clickOnWeiterButton2()
                .clickOnASARadioButton()
                .clickOnYesInformedRadioButton();
    }

    @TmsLink("WFHT-1448")
    @Test(description = "BC01- Postpaid new Vodafone user with no document - validate error page in case of service failure.")
    public void BC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPostpaidPage(driver)
                .validateErrorMsgForServiceFailure();
    }
}







