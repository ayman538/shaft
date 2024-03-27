package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_6967")
public class WFDT_6967 extends ST_KableDeutschlandSetup {

    //Test
    @TmsLink("WFDT-7164")
    @Test(description = "Validate Bank details for consumer has single product with single direct debit pay",groups = {"eCare"})
    private void gc01() {
        new MeineDaten(driver).navigateToBankDetailsAccordion();
        new MeineDaten(driver).validateAccountOwnerForCustomer();
        new MeineDaten(driver).validateAccountOwnerForCustomer2();
        new MeineDaten(driver).validateIBAN();
        new MeineDaten(driver).validateIBAN2();
        new MeineDaten(driver).validateDirectDebitAuthorization();
        new MeineDaten(driver).validateDirectDebitAuthorization2();
        new MeineDaten(driver).validateCTAForChangeBankDetailsForAllRefKontosAtOnce();
    }
    @TmsLink("WFDT-7165")
    @Test(description = "SOHO - Validate Bank details for consumer has single product with single direct debit pay",groups = {"eCare"})
    private void gc02() {
        new MeineDaten(driver).navigateToBankDetailsAccordion();
        new MeineDaten(driver).validateIBAN();
        new MeineDaten(driver).validateIBAN2();
        new MeineDaten(driver).validateDirectDebitAuthorization();
        new MeineDaten(driver).validateDirectDebitAuthorization2();
        new MeineDaten(driver).validateCTAForChangeBankDetailsForAllRefKontosAtOnce();
    }

}
