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
@Story("WFCT-13965")

public class WFCT_13965 extends SIT_BillingSetup{
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    Kostenubersicht kostenubersicht;
    String contractOrder;
    String subscriberCount;
    String endDate;

    @Test(description = "GC01 - kay with one subscriber check the view on invoice summary page")
    @TmsLink("WFCT-14034")
    public void GC01_KayUserWithOneSubscriberCheckTheViewOnInvoiceSummaryPage() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.waitPageToBeLoaded();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.checkSubscriberCount(subscriberCount);
        invoiceSummary.assertThatShowMoreButtonDoesNotExist();
        invoiceSummary.assertThatDateMappedFromEndDate(endDate);
        invoiceSummary.downloadItemizedBill();
        invoiceSummary.downloadCustomerBill();
    }

    @Test(description = "GC04 - marie check the date mapping in invoice summary page")
    @TmsLink("WFCT-14037")
    public void GC04_MarieUserCheckTheDateMappingInInvoiceSummaryPage() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.waitPageToBeLoaded();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.assertThatDateMappedFromEndDate(endDate);


    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        kostenubersicht = new Kostenubersicht(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        subscriberCount = testData.getTestData(method.getName() + ".subscriberCount");
        endDate = testData.getTestData(method.getName() + ".endDate");
    }
}
