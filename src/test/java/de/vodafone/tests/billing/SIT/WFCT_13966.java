package de.vodafone.tests.billing.SIT;



import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Kostenubersicht;
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
@Story("WFCT-13966")

// Scope Deprecated
@Test(enabled = false)
public class WFCT_13966 extends SIT_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    Kostenubersicht kostenubersicht;
    int i;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        kostenubersicht = new Kostenubersicht(driver);
        i = Integer.parseInt(testData.getTestData(method.getName() + ".i"));

    }

    @Test(description = "WFCT_13966 | GC01 - Kay user checks invoice summary page while some of the card values descriptions are not returned")
    @TmsLink("WFCT-14062")
    public void GC01_KayChecksInvoiceSummaryPageWhileSomeOfTheCardValuesDescriptionsNotReturned(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        assertOnSummaryCardLabels(i, method);
    }

    public void assertOnSummaryCardLabels(int i, Method method) {
        for (int x = 1; x <= i; x++) {
            driver.verifyThat().element(invoiceSummary.getInvoiceDetailsLabelsLocator(x)).textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Name")).withCustomReportMessage("assert on invoice details name #" + x).perform();
        }
}
}
