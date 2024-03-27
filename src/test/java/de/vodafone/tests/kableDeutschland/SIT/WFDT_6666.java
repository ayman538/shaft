package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_6666")
public class WFDT_6666 extends SIT_KableDeutschlandSetup{
    @TmsLink("WFDT-6738")
    @Test(description = "GC01 || Martin - Verify IBAN regex with invalid and valid syntax",groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();

        new BankDetails(driver)
                .EditFirstBankDetails()
                .ValidateIBanRegex();
    }

    @TmsLink("WFDT-6778")
    @Test(description = "GC03 || Martin - Validate edit bank account in case of entering wrong Iban",groups = {"eCare"})
    private void gc03(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();

        new BankDetails(driver).
                EditFirstBankDetails()
                .ValidateWrongIbanRegex();
    }

}
