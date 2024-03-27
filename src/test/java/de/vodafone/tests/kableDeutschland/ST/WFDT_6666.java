package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.BankDetails;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_6666")
public class WFDT_6666 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6738")
    @Test(description = "GC01 || Martin - Verify IBAN regex with invalid and valid syntax" ,groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();

        new BankDetails(driver)
                .EditFirstBankDetails()
                .ValidateIBanRegex();
    }

    @TmsLink("WFDT-6739")
    @Test(description = "GC02 || SOHO Martin - Verify IBAN regex with invalid and valid syntax",groups = {"eCare"})
    private void gc02(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();

        new BankDetails(driver)
                .EditFirstBankDetails()
                .ValidateIBanRegex();
    }

}
