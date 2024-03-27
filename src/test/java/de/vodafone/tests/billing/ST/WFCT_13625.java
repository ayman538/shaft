package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.*;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-13625")
public class WFCT_13625 extends ST_BillingSetup{
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;
    InvoiceSummary invoiceSummary;
    Rechnungen rechnungen;
    SubscriberSummary subscriberSummary;

    @Test(description = "GC01- peter user check back button in invoice summary page")
    @TmsLink("WFCT-13704")
    @Issue("")
    public void GC01_peterUserCheckBackButtonInInvoiceSummaryPage() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        subscriberSummary.assertOnBackButtonText();
        subscriberSummary.clickOnSubscriberSummaryBackPageBackButton();
        kostenubersicht.assertThatKostenubersichtPageIsLoaded();
    }

    @Test(description = "GC02- ute user check back button in invoice summary page")
    @TmsLink("WFCT-13705")
    public void GC02_UteUserCheckBackButtonInInvoiceSummaryPage()
    {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.assertOnBackButtonText();
        invoiceSummary.clickOnInvoiceSummaryBackPageBackButton();
        rechnungen.assertThatUserNavigatedToRechnungen();
    }
    @BeforeMethod
    public void testDataSetup(Method method) {

        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        invoiceSummary = new InvoiceSummary(driver);
        rechnungen = new Rechnungen(driver);
        subscriberSummary = new SubscriberSummary(driver);
    }
}
