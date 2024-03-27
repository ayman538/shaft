package de.vodafone.tests.billing.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.SubscriberSummary;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_9390 extends ST_BillingSetup {

    Dashboard dashboard;
    Kostenubersicht kostenubersicht;
    SubscriberSummary subscriberSummary;
    String invoiceMonth;
    String invoiceAmount;
    String accountNumber;
    String billPeriod;
    String billDate;
    int i;

    @BeforeMethod()
    public void beforeMethod(Method method) {
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

    @Test(description = "ST - GC01 - Peter user checks the invoice summary page")
    @TmsLink("WFCT-10997")
    @Issue("WFCT-14509")
    public void GC01_PeterUserChecksTheSubSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        subscriberSummary.assertOnHeaderComponents();
        subscriberSummary.assertOnPositiveSumText();
        subscriberSummary.assertOnTheAboveSummaryCardComponents(method, invoiceMonth, invoiceAmount, accountNumber, billPeriod, billDate);
        assertOnSummaryCardComponents(i, method);

    }

    @Test(description = "ST - GC02 - Peter user with credit checks the invoice summary page - ST - GC03 - Peter user with some invoice details not returned from the BE checks the invoice summary page")
    @TmsLinks({@TmsLink("WFCT-10998"),@TmsLink("WFCT-10999")})
    public void GC02_PeterUserWithCreditChecksTheSubSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        subscriberSummary.assertOnCreditAmountLabelText();
        subscriberSummary.assertOnNegativeSumText();
        subscriberSummary.assertOnTheAboveSummaryCardComponents(method, invoiceMonth, invoiceAmount, accountNumber, billPeriod, billDate);
        assertOnSummaryCardComponents(i, method);

    }

    @Test(description = "ST - GC04 - Peter user with no kostenubersicht document check the invoice summary page")
    @TmsLink("WFCT-11000")
    public void GC04_PeterUserWithNoItemizedPDFChecksTheSubSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        subscriberSummary.assertThatOnlyOneDownloadBtnDisplayed();
        subscriberSummary.assertOnInvoicePdfDownloadBtnText();
    }

    @Test(description = "ST - GC05 - Peter user with no kostenubersicht document check the invoice summary page")
    @TmsLink("WFCT-11001")
    public void GC05_PeterUserWithNoInvoicePDFChecksTheSubSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        subscriberSummary.assertThatOnlyOneDownloadBtnDisplayed();
        subscriberSummary.assertOnItemizedPdfDownloadBtnText();
    }

    @Test(description = "ST - GC06 - Peter user with kostenubersicht and verbindungsubersicht documents are not availablet checks the invoice summary page")
    @TmsLink("WFCT-11002")
    public void GC06_PeterUserWithNoPDFChecksTheSubSummaryPage(Method method) {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        subscriberSummary.assertThatNoDownloadBtnDisplayed();
    }


    public void assertOnSummaryCardComponents(int i, Method method) {
        for (int x = 1; x <= i; x++) {
            driver.verifyThat().element(SubscriberSummary.getInvoiceDetailsLocator(x)).text().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Name")).withCustomReportMessage("assert on invoice details name #"+x).perform();
            driver.verifyThat().element(SubscriberSummary.getInvoiceDetails1_ValueLocator(x)).text().isEqualTo(testData.getTestData(method.getName() + ".invoiceDetails" + x + "_Value")).withCustomReportMessage("assert on invoice details value #"+x).perform();
        }

    }
}
