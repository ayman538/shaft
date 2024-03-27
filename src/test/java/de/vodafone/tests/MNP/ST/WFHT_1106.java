package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.MNP.LandingPage;
import de.vodafone.pages.MNP.PortingWODocumentsPrepaidPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("ST")
@Story("WFHT-1106")
public class WFHT_1106 extends ST_MNP_Setup{
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

    @TmsLink("WFHT-1435")
    @Test(description = "GC01 - Prepaid new Vodafone user with no document - Verify error message appeared in case the previous provider is not informed.")
    public void GC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPrepaidPage(driver)
                .fillPrepaidKarteRadioButton()
                .clickOnWeiterButton()
                .clickOnNOTInformedRadioButton()
                .validateNotInformedMsg()
                .validateWeiterCTAIsDimmed2();
    }

    @TmsLink("WFHT-1436")
    @Test(description = "GC02 - Prepaid new Vodafone user with no document - Verify that user can proceed in the form in case the previous provider is informed.")
    public void GC02() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPrepaidPage(driver)
                .fillPrepaidKarteRadioButton()
                .clickOnWeiterButton()
                .clickOnYesInformedRadioButton()
                .clickOnWeiterButton2();
    }

    @TmsLink("1437")
    @Test(description = "GC03 - Prepaid new Vodafone user with no document - validate that every accordion Step can be expanded, collapsed, and has edit icon")
    public void GC03() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPrepaidPage(driver)
                .fillPrepaidKarteRadioButton()
                .clickOnWeiterButton()
                .clickOnYesInformedRadioButton()
                .clickOnWeiterButton2()
                .expandAndCollapsePrepaidAccordion();
    }

    @TmsLink("WFHT-1438")
    @Test(description = "GC04 - Prepaid new Vodafone user with no document - validate that Each step has proceed CTA button redirects the user to the next step")
    public void GC04() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPrepaidPage(driver)
                .fillPrepaidKarteRadioButton()
                .clickOnWeiterButton()
                .clickOnYesInformedRadioButton()
                .clickOnWeiterButton2();
    }

    @TmsLink("WFHT-1439")
    @Test(description = "GC05 - Prepaid new Vodafone user with no document - validate that Each step has cancel CTA button redirects the user to MNP start Page the user to the next step")
    public void GC05() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPrepaidPage(driver)
                .fillPrepaidKarteRadioButton()
                .clickOnWeiterButton()
                .clickOnCancelButton2();

    }

    @TmsLink("WFHT-1440")
    @Test(description = "BC01- Prepaid new Vodafone user with no document - validate error page in case of service failure.")
    public void BC01() {
        new LandingPage(driver)
                .navigateDeeplinkST(deeplink);
        new PortingWODocumentsPrepaidPage(driver)
                .validateErrorMsgForServiceFailure();
    }
}







