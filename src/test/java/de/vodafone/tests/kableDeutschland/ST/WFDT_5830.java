package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.BankDetails;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_5830")
public class WFDT_5830 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6765")
    @Test(description = "GC01 || Martin - Validate edit bank account details in case user has single invoice with single bank account",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        new BankDetails(driver)
                .EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .ValidateConfirmationAccordionDetails();
    }

    @TmsLink("WFDT-6766")
    @Test(description = "GC02 || Martin - Validate edit bank account details in case user has multi invoices with same bank account and all succeeded",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        new BankDetails(driver).clickEditOneByOneInvoicesBtn1()
                .ValidateInvoiceChooserPage()
                .EditFirstInvoiceBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .ValidateInvoiceProductsDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract();
        new Dashboard(driver).returnBackToDashboard();
        new BankDetails(driver).clickEditOneByOneInvoicesBtn1()
                .EditSecondInvoiceBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .ValidateInvoiceProductsDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .expandConfirmationDetailsSection()
                .ValidateConfirmationAccordionDetails();
    }

    @TmsLink("WFDT-6767")
    @Test(description = "GC03 || Martin - Validate edit bank account details in case user has multi invoices with same bank account and partially succeeded",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        new BankDetails(driver).EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails();
//        Hash below in case of SOHO
        new BankDetails(driver).validateSecondStepInCaseOfSOHO();
        //driver.element().click( BankDetails.ReviewCheckBox);
        new BankDetails(driver).SubmitSecondStepOfEditBank()
                .ValidateConfirmationPartiallyFailMessage();
    }

    @TmsLink("WFDT-6768")
    @Test(description = "GC04 || Multi Martin - Validate edit bank account details in case user has multi invoices with same bank account and all succeeded",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).expandSecondContractInMultiMartin();
        new Dashboard(driver).clickOnMeineDatenSecondContract();
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        new BankDetails(driver).clickEditOneByOneInvoicesBtn1()
                .ValidateInvoiceChooserPage()
                .EditFirstInvoiceBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .ValidateInvoiceProductsDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForMultiContracts();
        new Dashboard(driver).returnBackToDashboard();
        new BankDetails(driver).clickEditOneByOneInvoicesBtn1()
                .EditSecondInvoiceBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .ValidateInvoiceProductsDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForMultiContracts()
                .expandConfirmationDetailsSection()
                .ValidateConfirmationAccordionDetails();
    }

    @TmsLink("WFDT-6769")
    @Test(description = "GC05 || Martin - Validate edit bank account details in case user has multi invoice with multi bank account",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();

        //Validate Edit Details for First Bank
        new BankDetails(driver).EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract();
        new Dashboard(driver).returnBackToDashboard();
        new BankDetails(driver).EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .expandConfirmationDetailsSection()
                .ValidateConfirmationAccordionDetails();
        new Dashboard(driver).returnBackToDashboard();

        //Repeat same steps for second bank account
        new BankDetails(driver).clickEditOneByOneInvoicesBtn2()
                .ValidateInvoiceChooserPage()
                .EditFirstInvoiceBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract();
        new Dashboard(driver).returnBackToDashboard();
        new BankDetails(driver).clickEditOneByOneInvoicesBtn2()
                .EditSecondInvoiceBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .expandConfirmationDetailsSection()
                .ValidateConfirmationAccordionDetails();
    }

    @TmsLink("WFDT-6770")
    @Test(description = "GC06 || Martin SOHO - Validate edit bank account details in case user has multi Invoices with same bank account and all succeeded",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        new BankDetails(driver).EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract();
        new Dashboard(driver).returnBackToDashboard();
        new BankDetails(driver).clickEditOneByOneInvoicesBtn1()
                .EditSecondInvoiceBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .expandConfirmationDetailsSection()
                . ValidateConfirmationAccordionDetails();
    }

    @TmsLink("WFDT-6771")
    @Test(description = "GC07 || Multi Martin SOHO - Validate edit bank account details in case user has multi invoices with same bank account and all succeeded",groups = {"eCare"})
    private void gc07() {
        new Dashboard(driver).expandFirstContractInMultiMartin();
        new Dashboard(driver).clickOnMeineDatenFirstContract();
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        new BankDetails(driver).EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForMultiContracts();
    }

    @TmsLink("WFDT-6772")
    @Test(description = "GC08 || Martin SOHO - Validate edit bank account details in case user has multi Invoices with multi bank account",groups = {"eCare"})
    private void gc08() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        //Validate Edit Details for First Bank
        new BankDetails(driver).EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract()
                .clickBackButton()
                .clickEditOneByOneInvoicesBtn2()
                .ValidateInvoiceChooserPage()
                .selectEditBtnInvoiceChooser()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationSuccessForSingleContract();
    }

    @TmsLink("WFDT-6774")
    @Test(description = "GC10 || Martin - Verify edit bank account details in case of all changes failed",groups = {"eCare"})
    private void gc10() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        new BankDetails(driver).EditFirstBankDetails()
                .ValidateFirstStepOfEditBankDetails()
                .SubmitFirstStepOfEditBank()
                .ValidateSecondStepOfEditBankDetails()
                .SubmitSecondStepOfEditBank()
                .ValidateConfirmationAllFailedMessage();
    }

}
