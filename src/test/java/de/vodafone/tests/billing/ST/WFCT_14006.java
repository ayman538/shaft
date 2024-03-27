package de.vodafone.tests.billing.ST;


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
@Feature("ST")
@Story("WFCT-14006")

public class WFCT_14006 extends ST_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    Kostenubersicht kostenubersicht;
    int i;
    String subscriberOrder;
    String amountToBePaid;
    String cardTotalAmount;

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


    }


    @Test(description = "WFCT_14006 | GC01 - Marie user with all values in the common section returned with Zero amount checks invoice summary page")
    @TmsLink("WFCT-14293")
    public void GC01_MarieUserWithAllValuesInTheCommonSectionReturnedWithZeroAmountChecksInvoiceSummaryPage(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        assertOnSummaryCardLabels(i, method);
    }

    @Test(description = "WFCT_14006 | GC02 - Kay user with some of the card amounts = Zero and card total amount = Zero checks invoice summary page")
    @TmsLink("WFCT-14294")
    public void GC02_KayUserWithSomeOfTheCardAmountsZeroAndCardTotalAmountZeroChecksInvoiceSummaryPage(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.clickOnShowMoreButton(subscriberOrder);
        assertOnSummaryCardLabels(i, method);
        invoiceSummary.assertOnCardTotalAmount(subscriberOrder,cardTotalAmount);

    }

    @Test(description = "WFCT_14006 | GC03 - Marie user with total amount at the top = Zero checks the invoice summary page")
    @TmsLink("WFCT-14295")
    public void GC03_MarieUserWithTotalAmountAtTheTopZeroChecksTheInvoiceSummarypage(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnAmountToBePaid(amountToBePaid);
    }

    @Test(description = "WFCT_14006 | GC04 - Kay user with credit from last month = Zero checks invoice summary page")
    @TmsLink("WFCT-14296")
    public void GC04_KayUserWithCreditFromLastMonthZeroChecksInvoiceSummaryPage(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.clickOnShowMoreButton(subscriberOrder);
        assertOnSummaryCardLabels(i, method);
    }

    @Test(description = "WFCT_14006| GC05 - Peter user with some amounts and total amount in the card = zero checks invoice summary page")
    @TmsLink("WFCT-14297")
    public void GC05_PeterUserWithSomeAmountsAndTotalAmountInTheCardZeroChecksInvoiceSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        assertOnSummaryCardLabels(i, method);
    }

    @Test(description = "WFCT_14006 | GC06 - Peter user with total amount at the top of the page = Zero checks the invoice summary page")
    @TmsLink("WFCT-14298")
    public void GC06_PeterUserWithTotalAmountAtTheTopOfThePageZeroChecksTheInvoiceSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        invoiceSummary.assertOnAmountToBePaid(amountToBePaid);

    }


    public void assertOnSummaryCardLabels(int i, Method method) {
        for (int x = 1; x <= i; x++) {
            driver.verifyThat().element(invoiceSummary.getInvoiceDetailsLabelsLocator(x)).textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Name")).withCustomReportMessage("assert on invoice details name #" + x).perform();
        }
    }
}
