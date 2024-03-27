package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-9236")

public class WFCT_9236 extends SIT_BillingSetup {
    String rowOrder;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;


    @BeforeMethod
    public void testDataSetup(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        rowOrder = testData.getTestData(method.getName() + ".rowOrder");
    }

    @Test(description = "WFCT-9236 | GC02 peter user with more than 12 bills check Kostenübersicht Tab ")
    @TmsLink("WFCT-10473")
    public void GC02_peterWithMoreThan12BillsChecksKostenübersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionTextForPeter();
        kostenubersicht.assertOnMonthTitleText();
        kostenubersicht.assertOnKostenTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnCostPdfDownloadIcon_Peter(rowOrder);
        kostenubersicht.assertOnTheCostPdfPreviewIcon_Peter(rowOrder);
        kostenubersicht.assertThatInvoicesNumEquals12();
        kostenubersicht.assertOnShowMoreBtnText();
        kostenubersicht.clickShowMore();
        kostenubersicht.waitForShowMoreBtnTextChange();
        kostenubersicht.assertThatInvoicesNumMoreThan12();
        kostenubersicht.assertOnShowLessBtnText();
        kostenubersicht.clickShowLess();
        kostenubersicht.assertOnShowMoreBtnText();

    }

}
