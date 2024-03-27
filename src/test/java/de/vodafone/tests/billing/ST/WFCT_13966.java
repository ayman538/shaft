package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-13966")

// Scope Deprecate
public class WFCT_13966 extends ST_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    Kostenubersicht kostenubersicht;
    int i;
    String subscriberOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        kostenubersicht = new Kostenubersicht(driver);
        i = Integer.parseInt(testData.getTestData(method.getName() + ".i"));
        subscriberOrder = testData.getTestData(method.getName()+".subscriberOrder");


    }


    @Test(description = "WFCT_13966 | BC01 - Marie user with service error checks the invoice summary page" , enabled = false)
    @TmsLink("WFCT-14054")
    public void BC01_MarieUserWithServiceErrorChecksTheInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnErrorNotificationHeadline();
        invoiceSummary.assertOnErrorBody();
        invoiceSummary.assertThatNeuLadenBtnNotExists();
    }

    @Test(description = "WFCT_13966 | BC02 - peter user with service error checks the invoice summary page" , enabled = false)
    @TmsLink("WFCT-14055")
    public void BC02_PeterUserWithServiceErrorChecksTheInvoiceSummaryPage() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        invoiceSummary.assertOnErrorNotificationHeadline();
        invoiceSummary.assertOnErrorBody();
        invoiceSummary.assertThatNeuLadenBtnNotExists();

    }

    @Test(description = "WFCT_13966 | BC03 - Ute user with service error checks the invoice summary page", enabled = false)
    @TmsLink("WFCT-14056")
    public void BC03_UteUserWithServiceErrorChecksTheInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        invoiceSummary.assertOnErrorNotificationHeadline();
        invoiceSummary.assertOnErrorBody();
        invoiceSummary.assertThatNeuLadenBtnNotExists();
    }

    @Test(description = "WFCT_13966 | GC01 - Kay user checks invoice summary page while some of the card values descriptions are not returned", enabled = false)
    @TmsLink("WFCT-14062")
    public void GC01_KayChecksInvoiceSummaryPageWhileSomeOfTheCardValuesDescriptionsNotReturned(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.clickOnShowMoreButton(subscriberOrder);
        assertOnSummaryCardLabels(i, method);
    }

    @Test(description = "WFCT_13966 | GC02 - Peter user checks invoice summary page while some of the card values descriptions are not returned", enabled = false)
    @TmsLink("WFCT-14063")
    public void GC02_PeterChecksInvoiceSummaryPageWhileSomeOfTheCardValuesDescriptionsNotReturned(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        assertOnSummaryCardLabels(i, method);
    }

    @Test(description = "WFCT_13966 | GC03 - Marie user checks invoice summary page while all of the card values descriptions are not returned", enabled = false)
    @TmsLink("WFCT-14066")
    public void GC03_MarieChecksInvoiceSummaryPageWhileAllOfTheCardValuesDescriptionsNotReturned(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        assertOnSummaryCardLabels(i, method);
    }

    @Test(description = "WFCT_13966 | GC04 - Peter user checks invoice summary page while all of the card values descriptions are not returned", enabled = false)
    @TmsLink("WFCT-14067")
    public void GC04_PeterChecksInvoiceSummaryPageWhileAllOfTheCardValuesDescriptionsNotReturned(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        assertOnSummaryCardLabels(i, method);
    }



    public void assertOnSummaryCardLabels(int i, Method method) {
        for (int x = 1; x <= i; x++) {
            driver.verifyThat().element(invoiceSummary.getInvoiceDetailsLabelsLocator(x)).textTrimmed().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Name")).withCustomReportMessage("assert on invoice details name #" + x).perform();
        }
    }
}

