package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.FSKPinActivation;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Epic;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_6115")
public class WFDT_6115 extends ST_KableDeutschlandSetup
{
    @TmsLink("WFDT-6394")
    @Test(description = "GC01 || Martin - Verify FSK 18 PIN activation in case all activations is succeeded",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).NavigateToTVSettingsPage();
        new FSKPinActivation(driver)
                .ExpandFSKActivationAccordion()
                .ValidateFSKActivationSection()
                .NavigateToFSKActivationFlow()
                .ValidateFSKActivationFlow()
                .ConfirmFSKActivationFlow()
                .ValidateFSKActivationConfirmationAllSuccess();
    }

    @TmsLink("WFDT-6395")
    @Test(description = "GC02 || Martin - Verify FSK 18 PIN activation in case all activations is partially succeeded",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).NavigateToTVSettingsPage();
        new FSKPinActivation(driver)
                .ExpandFSKActivationAccordion()
                .NavigateToFSKActivationFlow()
                .ConfirmFSKActivationFlow()
                .ValidateFSKActivationConfirmationPartialSuccess()
                .ClickOnPartiallyFailedButton()
                .ValidateBackToFSKAccordion();
    }

    @TmsLink("WFDT-6396")
    @Test(description = "GC03 || Martin - Verify FSK 18 PIN activation in case all activations is failed",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).NavigateToTVSettingsPage();
        new FSKPinActivation(driver)
                .ExpandFSKActivationAccordion()
                .NavigateToFSKActivationFlow()
                .ConfirmFSKActivationFlow()
                .ValidateFSKActivationConfirmationAllFailed()
                .ClickOnActivationFailedButton()
                .ValidateBackToFSKAccordion();
    }

    @TmsLink("WFDT-6397")
    @Test(description = "GC04 || Martin - Verify FSK 18 PIN activation for second time within 30 minutes from last activation",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).NavigateToTVSettingsPage();
        new FSKPinActivation(driver)
                .ExpandFSKActivationAccordion()
                .NavigateToFSKActivationFlow()
                .ConfirmFSKActivationFlow()
                .ValidateFSKActivationConfirmationAllSuccess ()
                .NavigateBackToFSKAccordion()
                .NavigateToFSKActivationFlow()
                .ValidateFSKActivationInProgress();
    }

}
