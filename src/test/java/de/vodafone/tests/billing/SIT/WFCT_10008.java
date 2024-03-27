package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-10008")

public class WFCT_10008 extends SIT_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        contractOrder =testData.getTestData(method.getName()+".contractOrder");

    }

    @Test(description = "GC01 - Ute user with invoice summary downloads Rechnung pdf from the invoice summary page while only Rechnung pdf retrieved")
    @TmsLink("WFCT-10798")
    public void GC01_UteUserDownloadsRechnungPdfFromTheInvoiceSummaryPage() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.downloadInvoicePDF();
        invoiceSummary.assertThatItemizedPdfBtnNotExist();
        invoiceSummary.waitForFileToBeDownloaded();
        invoiceSummary.assertThatInvoicePdfDownloaded();
    }



}
