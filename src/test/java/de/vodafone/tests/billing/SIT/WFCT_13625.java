package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-13625")
public class WFCT_13625 extends SIT_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;
    InvoiceSummary invoiceSummary;
    Rechnungen rechnungen;
    SubscriberSummary subscriberSummary;
    String contractNumber;

    @Test(description = "GC01- peter user check back button in invoice summary page")
    @TmsLink("WFCT-13704")
    public void GC01_peterUserCheckBackButtonInInvoiceSummaryPage() {
        dashboard.expandContracts(contractNumber);
        dashboard.clickMeineKostenTile(contractNumber);
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
        rechnungen.assertThatRechnungenPageIsLoaded();



    }
    @BeforeMethod
    public void testDataSetup(Method method) {

        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        invoiceSummary = new InvoiceSummary(driver);
        rechnungen = new Rechnungen(driver);
        subscriberSummary = new SubscriberSummary(driver);
        contractNumber = testData.getTestData(method.getName() + ".contractNumber");

    }
}
