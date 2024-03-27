package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.FSKPinActivation;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_6208")
public class WFDT_6208 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6386")
    @Test(description = "GC01 || Martin - Verify FSK 18 PIN activation's smart object and accordion",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).NavigateToTVSettingsPage();
        new FSKPinActivation(driver)
                .ValidateFSKAccordion();
    }

    @TmsLink("WFDT-6388")
    @Test(description = "GC02 || Martin - Verify guideline message for users who didn't book FSK PIN yet",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).NavigateToTVSettingsPage();
        new FSKPinActivation(driver)
                .ExpandFSKActivationAccordion()
                .ValidateNoFSKMessage();
    }
}
