package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_5829")
public class WFDT_5829 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-6934")
    @Test(description = "GC01 || Validate Bank details for consumer has single product with single direct debit pay",groups = {"eCare"})
    private void gc01() {
        new MeineDaten(driver)
                .navigateToBankDetailsAccordion()
                .validateBankAccordionTitleAndDescription()
                .validateAccountOwnerForCustomer()
                .validateIBAN()
                .validateBIC()
                .validateBankName()
                .validateDirectDebitAuthorization()
                .validateBankUsedForLabel()
                .validateBankReferenceAccount0001()
                .validateBankFirstProduct()
                .checkBankInfoIconForProduct1()
                .validateChangeBankAccountButton();
    }

    @TmsLink("WFDT-6937")
    @Test(description = "GC04 || SOHO - Validate Bank details for consumer has single product with single direct debit pay",groups = {"eCare"})
    private void gc04() {
         new MeineDaten(driver)
                 .navigateToBankDetailsAccordion()
                 .validateBankAccordionTitleAndDescription()
                 .validateAccountOwnerForSOHO()
                 .validateIBAN()
                 .validateBIC()
                 .validateBankName()
                 .validateDirectDebitAuthorization()
                 .validateBankUsedForLabel()
                 .validateBankReferenceAccount0001()
                 .validateBankFirstProduct()
                 .checkBankInfoIconForProduct1()
                 .validateChangeBankAccountButton();
    }

}
