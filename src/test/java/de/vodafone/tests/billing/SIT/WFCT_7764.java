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
@Story("WFCT-7764")
public class WFCT_7764 extends SIT_BillingSetup{
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String contractOrder;
    String msisdn;
    String cardName;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        msisdn = testData.getTestData(method.getName() + ".msisdn");
        cardName = testData.getTestData(method.getName() + ".cardName");
    }

    @Test(description = "GC01 - Marie user checks invoice detailed view page then downloads itemized bill.")
    @TmsLink("WFCT-13565")
    public void gC01_MarieUserChecksInvoiceSummaryPageThenDownloadBill() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnCardHeaderMSISDNCardNAmeSIT(cardName,msisdn);
        invoiceSummary.assertOnCustomerBillExistance();
        invoiceSummary.assertingOnOpenReceivableCL();
    }


}

