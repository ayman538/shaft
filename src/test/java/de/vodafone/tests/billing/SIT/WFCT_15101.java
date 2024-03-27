package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-15101")

public class WFCT_15101 extends SIT_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String detailsPageOrder;
    String contractOrder;
    String unPaidAmount;
    String amountToPay;



    @BeforeMethod
    public void testDataSetup(Method method) {
        detailsPageOrder = testData.getTestData(method.getName() + ".detailsPageOrder");
        unPaidAmount = testData.getTestData(method.getName() + ".unPaidAmount");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        amountToPay = testData.getTestData(method.getName() + ".amountToPay");
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);

    }

    @Test(description = "GC01 - Ute user checks invoice summary page")
    @TmsLink("WFCT-15116")
    public void GC01_UteUserChecksInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.clickDetailsPage(detailsPageOrder);
        invoiceSummary.assertOnTheUnPaidAmountForOldMonths();
        invoiceSummary.assertOnTheUnPaidAmount(unPaidAmount);
        invoiceSummary.assertOnAmountToPay(amountToPay);
        invoiceSummary.assertOnAmountToPayLabel();
    }
}
