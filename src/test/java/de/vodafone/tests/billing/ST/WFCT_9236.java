package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-9236")
public class WFCT_9236 extends ST_BillingSetup {
    Dashboard dashboard;
    Kostenubersicht kostenubersicht;
    String itemizedBillWarningIconRowNum;
    String firstOrder;
    String secondOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        kostenubersicht = new Kostenubersicht(driver);
        itemizedBillWarningIconRowNum = testData.getTestData(method.getName() + ".itemizedBillWarningIconRowNum");
        firstOrder = testData.getTestData(method.getName() + ".tableRowOrder");
        secondOrder = testData.getTestData(method.getName() + ".secondRowOrder");
    }

    @Test(description = "ST- GC01- peter user with less than 12 bills check Kostenübersicht Tab")
    @TmsLink("WFCT-10462")
    public void GC01_peterLessThan12BillChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionTextForPeter();
        kostenubersicht.assertOnMonthTitleText();
        kostenubersicht.assertOnKostenTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnCostPdfDownloadIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheCostPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheConnectionPdfDownloadIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheConnectionPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertThatShowMoreBtnDoesNotExist();
    }

    @Test(description = ("ST- GC02- peter user has 12 bills check Kostenübersicht Tab"))
    @TmsLink("WFCT-10463")
    public void GC02_peterWith12BillChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionTextForPeter();
        kostenubersicht.assertOnMonthTitleText();
        kostenubersicht.assertOnKostenTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnCostPdfDownloadIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheCostPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheConnectionPdfDownloadIcon_Peter(secondOrder);
        kostenubersicht.assertOnTheConnectionPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertThatShowMoreBtnDoesNotExist();
    }

    @Test(description = "ST- GC03- peter user with more than 12 bills check Kostenübersicht Tab")
    @TmsLink("WFCT-10464")
    public void GC03_peterMoreThan12BillChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionTextForPeter();
        kostenubersicht.assertOnMonthTitleText();
        kostenubersicht.assertOnKostenTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnCostPdfDownloadIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheCostPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheConnectionPdfDownloadIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheConnectionPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertOnShowMoreBtnText();
        kostenubersicht.assertThatInvoicesNumEquals12();
        kostenubersicht.clickShowMore();
        kostenubersicht.waitForShowMoreBtnTextChange();
        kostenubersicht.assertThatInvoicesNumMoreThan12();
        kostenubersicht.assertOnShowLessBtnText();
        kostenubersicht.clickShowLess();
        kostenubersicht.assertOnShowMoreBtnText();
    }


    @Test(description = "ST- GC04- peter user has bill with amount and date not retrieved check Kostenübersicht Tab")
    @TmsLink("WFCT-10465")
    public void GC04_peterAmountDateNotRetrievedChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionTextForPeter();
        kostenubersicht.assertOnMonthTitleText();
        kostenubersicht.assertOnKostenTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertOnCostPdfDownloadIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheCostPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheConnectionPdfDownloadIcon_Peter(firstOrder);
        kostenubersicht.assertOnTheConnectionPdfPreviewIcon_Peter(firstOrder);
        kostenubersicht.assertOnNotReturnedMonthText();
        kostenubersicht.assertOnNotReturnedAmountText();


    }

    @Test(description = "ST- GC05- peter user has Connection overview bill with PDF not retrieved check Kostenübersicht Tab")
    @TmsLink("WFCT-10466")
    public void GC05_peterConnectionOverviewPDFNotRetrievedChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnWarningIconCl(itemizedBillWarningIconRowNum);

    }

    @Test(description = "ST- GC06- peter user has bill with Kostenübersicht PDF not retrieved check Kostenübersicht Tab")
    @TmsLink("WFCT-10467")
    public void GC06_peterCostOverviewPDFNotRetrievedChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnNotReturnedCostOverViewIconText_Peter();
    }

    @Test(description = "ST- GC07- peter user has bill with Kostenübersicht and Connection overview PDF not retrieved check Kostenübersicht Tab")
    @TmsLink("WFCT-10468")
    public void GC07_peterConnectionAndCostOverviewPDFSBothNotRetrievedChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnWarningIconCl(itemizedBillWarningIconRowNum);
        kostenubersicht.assertOnNotReturnedCostOverViewIconText_Peter();

    }

    @Test(description = "ST- GC08- peter user check Kostenübersicht Tab while Connection overview missing or not booked")
    @TmsLink("WFCT-10469")
    public void GC08_peterWithoutConnectionOverviewChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnPeterNotBookedItemizedBillTableDescription();
        kostenubersicht.assertOnNotBookedLinkCl();
        kostenubersicht.assertOnMonthTitleText();
        kostenubersicht.assertOnKostenTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertThatConnectionOverviewColumnNotExist();
        kostenubersicht.assertThatShowMoreBtnDoesNotExist();
    }

    @Test(description = "ST- GC09 peter user has no invoice check Kostenübersicht Tab")
    @TmsLink("WFCT-10470")
    public void GC09_peterWithNoInvoicesChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnEmptyResponseNotificationTitle_Peter();
        kostenubersicht.assertOnEmptyResponseNotificationDescription_Peter();
    }

    @Test(description = "ST- GC10- peter user check Kostenübersicht Tab while Back-End Response = error")
    @TmsLink("WFCT-10471")
    public void GC10_peterWithInvoiceWhileServiceErrorChecksKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnErrorServiceNotificationTitle_Peter();
        kostenubersicht.assertOnErrorServiceNotificationDescription_Peter();
    }
}