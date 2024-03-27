package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_5829")
public class WFDT_5829 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6740")
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

    @TmsLink("WFDT-6741")
    @Test(description = "GC02 || Validate Bank details for consumer has multi products in multi invoices with single direct debit pay",groups = {"eCare"})
    private void gc02() {
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
                .validateBankSecondProduct()
                .validateBankReferenceAccount0002()
                .validateBankThirdProduct()
                .checkBankInfoIconForProduct3()
                .validateChangeBankAccountButton()
                .validateStoreDifferentBankAccountsLink();
    }

    @TmsLink("WFDT-6742")
    @Test(description = "GC03 || Validate Bank details for consumer has multi products in multi invoices with multi direct debit pay",groups = {"eCare"})
    private void gc03() {
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
                 .validateBankReferenceAccount0002()
                 .validateBankSecondProduct()
                 .checkBankInfoIconForProduct2()
                 .validateChangeBankAccountButton()
                 .validateStoreDifferentBankAccountsLink()
                 .validateAccountOwnerForCustomer2()
                 .validateIBAN2()
                 .validateBIC2()
                 .validateBankName2()
                 .validateDirectDebitAuthorization2()
                 .validateBankUsedForLabel2()
                 .validateBankReferenceAccount0003()
                 .validateBankThirdProduct()
                 .checkBankInfoIconForProduct3()
                 .validateChangeBankAccountButton2();
    }

    @TmsLink("WFDT-6743")
    @Test(description = "GC04 || Validate Bank details for consumer with method self payer and single old direct debit and single product",groups = {"eCare"})
    private void gc04() {
         new MeineDaten(driver)
                 .navigateToBankDetailsAccordion()
                 .validateBankAccordionTitleAndDescription()
                 .validateSelfPayerNotification()
                 .validateAccountOwnerForCustomer()
                 .validateIBAN()
                 .validateBIC()
                 .validateBankName()
                 .validateDirectDebitAuthorization()
                 .validateBankUsedForLabel()
                 .validateBankReferenceAccount0001()
                 .validateBankFirstProduct()
                 .checkBankInfoIconForProduct1();
    }

    @TmsLink("WFDT-6744")
    @Test(description = "GC05 || Validate Bank details for consumer with method self payer and multi old direct debit and mutli products",groups = {"eCare"})
    private void gc05() {
         new MeineDaten(driver)
                 .navigateToBankDetailsAccordion()
                 .validateBankAccordionTitleAndDescription()
                 .validateSelfPayerNotification()
                 .validateAccountOwnerForCustomer()
                 .validateIBAN()
                 .validateBIC()
                 .validateBankName()
                 .validateDirectDebitAuthorization()
                 .validateBankUsedForLabel()
                 .validateBankReferenceAccount0001()
                 .validateBankFirstProduct()
                 .checkBankInfoIconForProduct1()
                 .validateBankReferenceAccount0002()
                 .validateBankSecondProduct()
                 .checkBankInfoIconForProduct2()
                 .validateSelfPayerNotification2()
                 .validateAccountOwnerForCustomer2()
                 .validateIBAN2()
                 .validateBIC2()
                 .validateBankName2()
                 .validateDirectDebitAuthorization2()
                 .validateBankUsedForLabel2()
                 .validateBankReferenceAccount0003()
                 .validateBankThirdProduct()
                 .checkBankInfoIconForProduct3();
    }

    @TmsLink("WFDT-6745")
    @Test(description = "GC06 || Validate Bank details for consumer with method self payer without bank account and have single invoice",groups = {"eCare"})
    private void gc06() {
         new MeineDaten(driver)
                 .navigateToBankDetailsAccordion()
                 .validateBankAccordionTitleAndDescription()
                 .validateSelfPayerNotification()
                 .validateDirectDebitAuthorization()
                 .validateBankUsedForLabel()
                 .validateBankReferenceAccount0001()
                 .validateBankFirstProduct()
                 .checkBankInfoIconForProduct1();
    }

    @TmsLink("WFDT-6747")
    @Test(description = "GC07 || Validate Bank details for consumer with method direct debit in dunning state with single invoice",groups = {"eCare"})
    private void gc07() {
         new MeineDaten(driver)
                 .navigateToBankDetailsAccordion()
                 .validateBankAccordionTitleAndDescription()
                 .validateBankDunningNotification()
                 .validateAccountOwnerForCustomer()
                 .validateIBAN()
                 .validateBIC()
                 .validateBankName()
                 .validateDirectDebitAuthorization()
                 .validateBankUsedForLabel()
                 .validateBankReferenceAccount0001()
                 .validateBankFirstProduct()
                 .checkBankInfoIconForProduct1()
                 .validateChangeBankAccountButton()
                 .validateDimmedChangeBankAccountButton();
    }

    @TmsLink("WFDT-6748")
    @Test(description = "GC08 || Validate Bank details for consumer with method direct debit in dunning state with multi invoices",groups = {"eCare"})
    private void gc08() {
         new MeineDaten(driver)
                 .navigateToBankDetailsAccordion()
                 .validateBankAccordionTitleAndDescription()
                 .validateBankDunningNotification()
                 .validateAccountOwnerForCustomer()
                 .validateIBAN()
                 .validateBIC()
                 .validateBankName()
                 .validateDirectDebitAuthorization()
                 .validateBankUsedForLabel()
                 .validateBankReferenceAccount0001()
                 .validateBankFirstProduct()
                 .checkBankInfoIconForProduct1()
                 .validateBankReferenceAccount0002()
                 .validateBankSecondProduct()
                 .checkBankInfoIconForProduct2()
                 .validateChangeBankAccountButton()
                 .validateDimmedChangeBankAccountButton()
                 .validateAccountOwnerForCustomer2()
                 .validateIBAN2()
                 .validateBIC2()
                 .validateBankName2()
                 .validateDirectDebitAuthorization2()
                 .validateBankUsedForLabel2()
                 .validateBankReferenceAccount0003()
                 .validateBankThirdProduct()
                 .checkBankInfoIconForProduct3()
                 .validateChangeBankAccountButton2()
                 .validateDimmedChangeBankAccountButton2();
    }

    @TmsLink("WFDT-6749")
    @Test(description = "GC09 || Validate Bank details for consumer with method self payer in dunning state and have old direct debit with single invoice",groups = {"eCare"})
    private void gc09() {
        new MeineDaten(driver)
                .navigateToBankDetailsAccordion()
                .validateBankAccordionTitleAndDescription()
                .validateBankDunningNotification()
                .validateAccountOwnerForCustomer()
                .validateIBAN()
                .validateBIC()
                .validateBankName()
                .validateDirectDebitAuthorization()
                .validateBankUsedForLabel()
                .validateBankReferenceAccount0001()
                .validateBankFirstProduct()
                .checkBankInfoIconForProduct1();
    }

    @TmsLink("WFDT-6750")
    @Test(description = "GC10 || Validate Bank details for consumer with method self payer in dunning state and have old direct debit with multi invoices",groups = {"eCare"})
    private void gc10() {
        new MeineDaten(driver)
                .navigateToBankDetailsAccordion()
                .validateBankAccordionTitleAndDescription()
                .validateBankDunningNotification()
                .validateAccountOwnerForCustomer()
                .validateIBAN()
                .validateBIC()
                .validateBankName()
                .validateDirectDebitAuthorization()
                .validateBankUsedForLabel()
                .validateBankReferenceAccount0001()
                .validateBankFirstProduct()
                .checkBankInfoIconForProduct1()
                .validateBankReferenceAccount0002()
                .validateBankSecondProduct()
                .checkBankInfoIconForProduct2()
                .validateAccountOwnerForCustomer2()
                .validateIBAN2()
                .validateBIC2()
                .validateBankName2()
                .validateDirectDebitAuthorization2()
                .validateBankUsedForLabel2()
                .validateBankReferenceAccount0003()
                .validateBankThirdProduct()
                .checkBankInfoIconForProduct3();
    }

    @TmsLink("WFDT-6751")
    @Test(description = "GC11 || Validate Bank details for consumer with method self payer in dunning state without bank account with single invoice",groups = {"eCare"})
    private void gc11() {
        new MeineDaten(driver)
                .navigateToBankDetailsAccordion()
                .validateBankAccordionTitleAndDescription()
                .validateBankDunningNotification()
                .validateDirectDebitAuthorization()
                .validateBankUsedForLabel()
                .validateBankReferenceAccount0001()
                .validateBankFirstProduct()
                .checkBankInfoIconForProduct1();
    }

    @TmsLink("WFDT-6753")
    @Test(description = "GC12 || SOHO - Validate Bank details for customer has multi products in multi invoices with single direct debit",groups = {"eCare"})
    private void gc12() {
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
                 .validateBankSecondProduct()
                 .checkBankInfoIconForProduct2()
                 .validateBankThirdProduct()
                 .checkBankInfoIconForProduct3()
                 .validateChangeBankAccountButton();
    }

    @TmsLink("WFDT-6754")
    @Test(description = "GC13 || SOHO - Validate Bank details for customer with method self payer and multi old direct debit and mutli products",groups = {"eCare"})
    private void gc13() {
         new MeineDaten(driver)
                 .navigateToBankDetailsAccordion()
                 .validateBankAccordionTitleAndDescription()
                 .validateSelfPayerNotification()
                 .validateAccountOwnerForSOHO()
                 .validateIBAN()
                 .validateBIC()
                 .validateBankName()
                 .validateDirectDebitAuthorization()
                 .validateBankUsedForLabel()
                 .validateBankReferenceAccount0001()
                 .validateBankFirstProduct()
                 .checkBankInfoIconForProduct1()
                 .validateBankReferenceAccount0002()
                 .validateBankSecondProduct()
                 .checkBankInfoIconForProduct2()
                 .validateSelfPayerNotification2()
                 .validateAccountOwnerForSOHO2()
                 .validateIBAN2()
                 .validateBIC2()
                 .validateBankName2()
                 .validateDirectDebitAuthorization2()
                 .validateBankUsedForLabel2()
                 .validateBankReferenceAccount0003()
                 .validateBankThirdProduct()
                 .checkBankInfoIconForProduct3();
    }

    @TmsLink("WFDT-6762")
    @Test(description = "GC15 || Validate Bank details for consumer has multi products in multi invoices in direct debit and single product in single invoice in self payer",groups = {"eCare"})
    private void gc15() {
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
                 .validateBankReferenceAccount0002()
                 .validateBankSecondProduct()
                 .checkBankInfoIconForProduct2()
                 .validateChangeBankAccountButton()
                 .validateStoreDifferentBankAccountsLink()
                 .validateSelfPayerNotification()
                 .validateAccountOwnerForCustomer2()
                 .validateIBAN2()
                 .validateBIC2()
                 .validateBankName2()
                 .validateDirectDebitAuthorization2()
                 .validateBankUsedForLabel2()
                 .validateBankReferenceAccount0003()
                 .validateBankThirdProduct()
                 .checkBankInfoIconForProduct3();
    }

    @TmsLink("WFDT-6757")
    @Test(description = "BC01 || Check 'Information von Vodafone' section in Privacy accordion incase saving changes failed",groups = {"eCare"})
    private void bc01() {
        new MeineDaten(driver)
                .navigateToBankDetailsAccordion()
                .validateBadCaseNotification();
    }

}
