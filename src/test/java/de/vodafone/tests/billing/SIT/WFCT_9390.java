package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.SubscriberSummary;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-9390")

public class WFCT_9390 extends SIT_BillingSetup {
    Dashboard dashboard;
    SubscriberSummary subscriberSummary;
    Kostenubersicht kostenubersicht;
    String invoiceMonth;
    String invoiceAmount;
    String accountNumber;
    String billPeriod;
    String billDate;
    int i ;

    @BeforeMethod
    public void testDataSetup(Method method) {
        dashboard = new Dashboard(driver);
        kostenubersicht = new Kostenubersicht(driver);
        subscriberSummary = new SubscriberSummary(driver);
        invoiceMonth = testData.getTestData(method.getName() + ".invoiceMonth");
        invoiceAmount = testData.getTestData(method.getName() + ".invoiceAmount");
        accountNumber = testData.getTestData(method.getName() + ".accountNumber");
        billPeriod = testData.getTestData(method.getName() + ".billPeriod");
        billDate = testData.getTestData(method.getName() + ".billDate");
        i =Integer.parseInt(testData.getTestData(method.getName() + ".i")) ;
    }

    @Test(description = "WFCT-9390 | SIT - GC01 - Peter user checks the invoice summary page")
    @TmsLink("WFCT-11019")
    public void GC01_PeterUserChecksTheInvoiceSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        subscriberSummary.assertOnHeaderComponents();
        subscriberSummary.assertOnTheAboveSummaryCardComponents(method, invoiceMonth, invoiceAmount, accountNumber, billPeriod, billDate);
        assertOnSummaryCardComponents(i,method);

    }


    public void assertOnSummaryCardComponents(int i, Method method) {
        for (int x = 1; x <= i; x++) {
            driver.verifyThat().element(SubscriberSummary.getInvoiceDetailsLocator(x)).text().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Name")).withCustomReportMessage("assert on invoice details name #"+x).perform();
            driver.verifyThat().element(SubscriberSummary.getInvoiceDetails1_ValueLocator(x)).text().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Value")).withCustomReportMessage("assert on invoice details value #"+x).perform();
        }

}
}
