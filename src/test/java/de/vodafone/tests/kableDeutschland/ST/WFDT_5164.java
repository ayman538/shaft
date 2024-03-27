package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.ActivateSmartCardEntryPoint;
import de.vodafone.pages.Kabledeutschland.ActivateTVSmartCard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_5164")
public class WFDT_5164 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-5301")
    @Test(description = "GC01 - Martin - Verify succeeded smart card activation in case no activation happened within the last 30 minutes",groups = {"eCare"})
    private void gc01() {
        new ActivateSmartCardEntryPoint(driver)
                .ExpandTVProductAccordion()
                .NavigateToActivateSmartCardAccordionFromDashboard();

        new ActivateTVSmartCard(driver)
                .VerifyActivationAccordion()
                .VerifySuccessActivationFlow();
    }

    @TmsLink("WFDT-5302")
    @Test(description = "GC02 - Martin - Verify smart card activation accordion after a successful activation within the last 30 minutes",groups = {"eCare"})
    private void gc02() {
        new ActivateSmartCardEntryPoint(driver)
                .ExpandTVProductAccordion()
                .NavigateToActivateSmartCardAccordionFromDashboard();

        new ActivateTVSmartCard(driver)
                .VerifyInProgressActivationFlow();
    }

    @TmsLink("WFDT-5303")
    @Test(description = "GC03 - Martin - Verify failed smart card activation in case no activation happened within the last 30 minutes",groups = {"eCare"})
    private void gc03() {
        new ActivateSmartCardEntryPoint(driver)
                .ExpandTVProductAccordion()
                .NavigateToActivateSmartCardAccordionFromDashboard();

        new ActivateTVSmartCard(driver)
                .VerifyFailureActivationFlow();
    }

    @TmsLink("WFDT-5304")
    @Test(description = "GC04 - Martin - Verify partially succeeded smart card activation in case no activation happened within the last 30 minutes",groups = {"eCare"})
    private void gc04() {
        new ActivateSmartCardEntryPoint(driver)
                .ExpandTVProductAccordion()
                .NavigateToActivateSmartCardAccordionFromDashboard();

        new ActivateTVSmartCard(driver)
                .VerifyPartiallyFailureActivationFlow();
    }

}