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
@Story("WFCT-14006")

public class WFCT_14006 extends SIT_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    Kostenubersicht kostenubersicht;
    int i;
    String subscriberOrder;
    String amountToBePaid;
    String cardTotalAmount;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        kostenubersicht = new Kostenubersicht(driver);
        i = Integer.parseInt(testData.getTestData(method.getName() + ".i"));
        subscriberOrder = testData.getTestData(method.getName()+".subscriberOrder");
        amountToBePaid = testData.getTestData(method.getName()+".amountToBePaid");
        cardTotalAmount = testData.getTestData(method.getName()+".cardTotalAmount");
        contractOrder = testData.getTestData(method.getName()+".contractOrder");


    }


    @Test(description = "WFCT_14006 | GC03 - Marie user with total amount at the top = Zero checks the invoice summary page")
    @TmsLink("WFCT-14295")
    public void GC03_MarieUserWithTotalAmountAtTheTopZeroChecksTheInvoiceSummarypage(Method method) {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.assertOnAmountToBePaid(amountToBePaid);
    }

    @Test(description = "WFCT_14006 | GC04 - Kay user with credit from last month = Zero checks invoice summary page")
    @TmsLink("WFCT-14296")
    public void GC04_KayUserWithCreditFromLastMonthZeroChecksInvoiceSummaryPage(Method method) {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.clickOnTheUnderlinedAmount();
        assertOnSummaryCardLabels(i, method);
    }



    public void assertOnSummaryCardLabels(int i, Method method) {
        for (int x = 1; x <= i; x++) {
            driver.verifyThat().element(invoiceSummary.getInvoiceDetailsLabelsLocator(x)).textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Name")).withCustomReportMessage("assert on invoice details name #" + x).perform();
        }
    }
}
