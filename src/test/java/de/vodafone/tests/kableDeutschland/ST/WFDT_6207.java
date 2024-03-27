package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.EditBillingAddress;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_6207")
public class WFDT_6207 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-6587")
    @Test(description = "GC01 || Martin - Validate edit billing address in case all invoices has the same address ",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).expandAddressesAccordion();

        new EditBillingAddress(driver)
                .EditFirstBillingDetails()
                .ValidateFirstStepEditBillingAddress()
                .changeBillingAddressInfo()
                .clickProceedBtnFirstStep()
                .ValidateFuzzyLogicWithSuggestedAddress()
                .chooseSuggestedAddress()
                .ValidateSecondStepEditBillingAddress()
                .clickProceedBtnSecondStep()
                .ValidateLastStepEditBillingAddressSingle();
    }

    @TmsLink("WFDT-6588")
    @Test(description = "GC02 || Multi Martin - Validate edit billing address in case all invoices has different addresses",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).expandAddressesAccordion();

        new EditBillingAddress(driver)
                .clickChangeAllAddressBtn()
                .ValidateFirstStepEditBillingAddress()
                .fillBillingAddressInfo()
                .clickProceedBtnFirstStep()
                .ValidateFuzzyLogicWithSuggestedAddress()
                .chooseSuggestedAddress()
                .clickProceedBtnSecondStep();
    }

    @TmsLink("WFDT-6589")
    @Test(description = "GC03 || Martin - Validate edit billing address in case all invoices has no addresses",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).expandAddressesAccordion();
        new EditBillingAddress(driver).ValidateNoBillingAddressCase();
    }

    @TmsLink("WFDT-6591")
    @Test(description = "GC05 || Martin SOHO- Validate edit billing address in case all invoices has the same address ",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).expandAddressesAccordion();

        new EditBillingAddress(driver)
                .EditFirstBillingDetails()
                .ValidateFirstStepEditBillingAddress()
                .changeBillingAddressInfo()
                .clickProceedBtnFirstStep()
                .ValidateFuzzyLogicWithSuggestedAddress()
                .chooseSuggestedAddress()
                .clickProceedBtnSecondStep();
    }

}
