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
@Story("WFCT-10305")

public class WFCT_10305 extends SIT_BillingSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    String contractOrder;
    String cost_RowOrder;
    String cost_ColOrder;
    String itemized_RowOrder;
    String itemized_ColOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");

        itemized_RowOrder = testData.getTestData(method.getName() + ".itemized_RowOrder");
        itemized_ColOrder = testData.getTestData(method.getName() + ".itemized_ColOrder");
        cost_ColOrder = testData.getTestData(method.getName() + ".cost_ColOrder");
        cost_RowOrder = testData.getTestData(method.getName() + ".cost_RowOrder");


    }


    @Test(description = "GC01-Kay user checks Kostenübersicht Tab in Meine Rechnungen page while connection overview PDF could not retrieved")
    @TmsLink("WFCT-10513")
    public void GC01_KayConnectionPdfNotRetrievedChecksKostenubersichtTab() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.clickShowMore();
        kostenubersicht.assertOnNotRetrievedPdfWarningIcon(itemized_RowOrder, itemized_ColOrder);
        kostenubersicht.assertOnNotRetrievedConnectionPdfWarningText(itemized_RowOrder, itemized_ColOrder);
    }

    @Test(description = "GC02-Bart user checks Kostenübersicht Tab in Meine Rechnungen page while connection overview and Kostenübersicht PDF could not retrieved")
    @TmsLink("WFCT-10514")
    public void GC02_BartWithNotReturnedCostAndConnectionPdfChecksKostenubersichtTab() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.clickShowMore();
        kostenubersicht.assertOnNotRetrievedPdfWarningIcon(cost_RowOrder, cost_ColOrder);
        kostenubersicht.assertOnCostOverViewErrorIconText(cost_RowOrder, cost_ColOrder);
        kostenubersicht.assertOnNotRetrievedPdfWarningIcon(itemized_RowOrder, itemized_ColOrder);
        kostenubersicht.assertOnNotRetrievedConnectionPdfWarningText(itemized_RowOrder, itemized_ColOrder);

    }
}
