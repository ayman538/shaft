package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Billing")
@Feature("ST")

public class WFCT_10008 extends ST_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;

    @BeforeMethod
    public void beforeMethod() {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
    }

    @Test(description = "GC01 - Ute user with invoice summary downloads Rechnung pdf from the invoice summary page while only Rechnung pdf retrieved")
    @TmsLinks({@TmsLink("WFCT-10796"), @TmsLink("WFCT-10841")})
    public void GC01_UteUserDownloadsRechnungPdfFromTheInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.downloadInvoicePDF();
        invoiceSummary.assertThatItemizedPdfBtnNotExist();
//        invoiceSummary.waitForFileToBeDownloaded();
//        invoiceSummary.assertThatInvoicePdfDownloaded();

    }

    @Test(description = "GC02 - Ute user with invoice summary downloads Verbindungsübersicht pdf from the invoice summary page while only Verbindungsübersicht pdf retrieved")
    @TmsLink("WFCT-10797")
    public void GC02_UteUserDownloadsItemizedPdfFromTheInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.downloadItemizedPDF();
        invoiceSummary.assertThatInvoicePdfBtnNotExist();
//        invoiceSummary.waitForFileToBeDownloaded();
//        invoiceSummary.assertThatItemizedPdfDownloaded();

    }

    @Test(description = "ST - GC03 - Ute user with invoice summary downloads Rechnung pdf and Verbindungsübersicht pdf from the invoice summary page while both retrieved")
    @TmsLink("WFCT-10841")
    public void GC03_UteUserDownloadsInvoiceAndItemizedPdfFromTheInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.downloadInvoicePDF();
        invoiceSummary.downloadItemizedPDF();
//        invoiceSummary.waitForFileToBeDownloaded();
//        invoiceSummary.waitForFileToBeDownloaded();
//        invoiceSummary.assertThatInvoicePdfDownloaded();
//        invoiceSummary.assertThatItemizedPdfDownloaded();

    }

    @Test(description = "GC04 - Ute user with invoice summary downloads Rechnung pdf and Verbindungsübersicht pdf from the invoice summary page while BE response is error")
    @TmsLink("WFCT-10873")
    public void GC04_UteUserDownloadsInvoiceAndItemizedPdfFromTheInvoiceSummaryPageWithErrorBE() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.downloadInvoicePDF();
        invoiceSummary.assertOnErrorNotificationTitle();
        invoiceSummary.assertOnErrorNotificationBody();
    }

}
