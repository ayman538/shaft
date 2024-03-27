package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_6207")
public class WFDT_6207 extends SIT_KableDeutschlandSetup{
    @TmsLink("WFDT-7149")
    @Test(description = "GC01 || Martin - Validate edit billing address in case all invoices has the same address ",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).expandAddressesAccordion();

        new EditBillingAddress(driver)
                .EditFirstBillingDetails()
                .ValidateFirstStepEditBillingAddress()
                .ValidateFuzzyLogicWithoutSuggestedAddress()
                .ValidateFuzzyLogicWithSuggestedAddress()
                .ValidateSecondStepEditBillingAddress()
                .ValidateLastStepEditBillingAddressSingle();
    }

    @TmsLink("WFDT-7150 ")
    @Test(description = "GC03 || Martin - Validate edit billing address in case all invoices has no addresses",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).expandAddressesAccordion();
        new EditBillingAddress(driver).ValidateNoBillingAddressCase();
    }
}
