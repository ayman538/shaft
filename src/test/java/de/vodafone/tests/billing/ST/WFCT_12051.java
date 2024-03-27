
package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


public class WFCT_12051 extends ST_BillingSetup {
    String latestMonth;
    String lastMonthEligibleForItemizedBill;
    String firstMonthNotEligibleForItemizedBill;
    String firstConnectionRow;
    String lastConnectionRow;
    String amountRow;
    String msisdn;

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;

    @Test(description = "GC01 - Kay user checks the itemized bills for all numbers (latest 6 months) in Kostenübersicht tab")
    @TmsLink("WFCT-12279")
    public void GC01_KayUserChecksTheItemizedBillsForAllNumbersInLatest6MonthsInKostenübersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(latestMonth);
        kostenubersicht.assertThatConnectionOverviewBillsExist(firstConnectionRow);
        kostenubersicht.assertThatConnectionOverviewBillsExist(lastConnectionRow);
        kostenubersicht.chooseMonthFilter(lastMonthEligibleForItemizedBill);
        kostenubersicht.assertThatConnectionOverviewBillsExist(firstConnectionRow);
        kostenubersicht.assertThatConnectionOverviewBillsExist(lastConnectionRow);
    }


    @Test(description = "GC02- Bart user checks the itemized bills Column in month 7")
    @TmsLink("WFCT-12280")
    @Issue("WFCT-13174")
    public void GC02_BartUserChecksTheItemizedBillsCtaAndColumnInMonth7InKostenübersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(latestMonth);
        kostenubersicht.assertThatConnectionOverviewBillsExist(firstConnectionRow);
        kostenubersicht.assertThatConnectionOverviewBillsExist(lastConnectionRow);
        kostenubersicht.chooseMonthFilter(firstMonthNotEligibleForItemizedBill);
        kostenubersicht.waitForMonthToBeSelected();
        kostenubersicht.assertThatConnectionOverviewColumnDoesNotExist();
        kostenubersicht.choosePhoneNumberFilter(msisdn);
        kostenubersicht.assertThatConnectionOverviewColumnDoesNotExist();
    }


    @Test(description = "GC03- peter user checks Credit amount in Cost overview page")
    @TmsLink("WFCT-12281")
    public void GC03_peterUserChecksCreditAmountInCostOverviewPage() {
        dashboard.clickMeineKostenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertThatCreditAmountWrittenInGreen(amountRow);
        kostenubersicht.hoverOnCreditAmountIcon();
        kostenubersicht.assertThatCreditIconNotificationTitleIsCorrect(amountRow);
        kostenubersicht.assertThatCreditIconNotificationDescriptionIsCorrect(amountRow);

    }

    @BeforeMethod
    public void testDataSetup(Method method) {
        amountRow = testData.getTestData(method.getName() + ".amountRowNum");
        latestMonth = testData.getTestData(method.getName() + ".latestMonth");
        lastMonthEligibleForItemizedBill = testData.getTestData(method.getName() + ".lastMonthEligibleForItemizedBill");
        firstMonthNotEligibleForItemizedBill = testData.getTestData(method.getName() + ".firstMonthNotEligibleForItemizedBill");
        firstConnectionRow = testData.getTestData(method.getName() + ".firstConnectionOverViewPreviewIconRowNum");
        lastConnectionRow = testData.getTestData(method.getName() + ".lastConnectionOverViewPreviewIconRowNum");
        msisdn = testData.getTestData(method.getName() + ".msisdn");
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
    }
}
