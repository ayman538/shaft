
package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import de.vodafone.pages.billing.ContractChooserPage;


public class WFCT_12051 extends SIT_BillingSetup {
    String latestMonth;
    String lastMonthEligibleForItemizedBill;
    String firstMonthNotEligibleForItemizedBill;
    String firstConnectionRow;
    String lastConnectionRow;
    String amountRow;
    String contract_number;
    String contractIndex;
    String msisdn;
    ContractChooserPage contractChooserPage;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;

    @Test(description = "GC01 - Kay user checks the itemized bills for all numbers (latest 6 months) in Kostenübersicht tab")
    @TmsLink("WFCT-12279")
    public void GC01_KayUserChecksTheItemizedBillsForAllNumbersInLatest6MonthsInKostenübersichtTab() {
        dashboard.expandContracts(contract_number);
        dashboard.clickMeineRechnungenTile(contract_number);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(latestMonth);
        kostenubersicht.assertThatConnectionOverviewBillsExist(firstConnectionRow);
        kostenubersicht.assertThatConnectionOverviewBillsExist(lastConnectionRow);
        kostenubersicht.chooseMonthFilter(lastMonthEligibleForItemizedBill);
        kostenubersicht.assertThatConnectionOverviewBillsExist(firstConnectionRow);
        kostenubersicht.assertThatConnectionOverviewBillsExist(lastConnectionRow);
    }


    @Test(description = "GC02- Bart user checks the itemized bills CTA/Column in month 7")
    @TmsLink("WFCT-12280")
    public void GC02_BartUserChecksTheItemizedBillsCtaAndColumnInMonth7InKostenübersichtTab() {
        dashboard.expandContracts(contract_number);
        dashboard.clickMeineRechnungenTile(contract_number);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(latestMonth);
        kostenubersicht.assertThatConnectionOverviewBillsExist(firstConnectionRow);
        kostenubersicht.assertThatConnectionOverviewBillsExist(lastConnectionRow);
        kostenubersicht.chooseMonthFilter(firstMonthNotEligibleForItemizedBill);
        kostenubersicht.waitForMonthToBeSelected();
        kostenubersicht.assertThatConnectionOverviewColumnDoesNotExist();


    }


    @Test(description = "GC03- peter user checks Credit amount in Cost overview page")
    @TmsLink("WFCT-12281")
    public void GC03_peterUserChecksCreditAmountInCostOverviewPage() {
        dashboard.clickMeineKostenTile();
        contractChooserPage.clickContractFromContractChooser(contractIndex);
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
        contract_number = testData.getTestData(method.getName() + ".contract_number");
        firstConnectionRow = testData.getTestData(method.getName() + ".firstConnectionOverViewPreviewIconRowNum");
        lastConnectionRow = testData.getTestData(method.getName() + ".lastConnectionOverViewPreviewIconRowNum");
        contractIndex = testData.getTestData(method.getName() + ".contractIndex");
        msisdn = testData.getTestData(method.getName() + ".msisdn");
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        contractChooserPage = new ContractChooserPage(driver);
    }
}
