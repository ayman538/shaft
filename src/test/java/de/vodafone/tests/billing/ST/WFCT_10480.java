package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import io.qameta.allure.TmsLinks;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_10480 extends ST_BillingSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    String rowOrder;
    String columnOrder;
    String month;

    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        rowOrder = testData.getTestData(method.getName() + ".rowOrder");
        columnOrder = testData.getTestData(method.getName() + ".columnOrder");
        month = testData.getTestData(method.getName() + ".month");
    }

    @Test(description = "GC01 Bart user checks kostenubersicht when his costs PDF is not booked or not retrieved")
    @TmsLink("WFCT-12109")
    public void GC01_BartUserChecksKostenubersichtWhenHisCostsPDFIsNotBookedOrNotRetrieved(Method method) {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnErrorNotificationNotDisplayed();
        kostenubersicht.chooseMonthFilter(month);
        kostenubersicht.assertOnNotRetrievedErrorNotificationTitle();
        kostenubersicht.assertOnNotRetrievedErrorNotificationText();
        kostenubersicht.assertOnErrorIcon(rowOrder, columnOrder);
        kostenubersicht.assertOnCostOverViewErrorIconText(rowOrder, columnOrder);
    }

    @Test(description = "GC02 Kay user checks kostenubersicht when his costs PDF is not booked or not retrieved")
    @TmsLinks({@TmsLink("WFCT-12110"), @TmsLink("WFCT-10506")})
    public void GC02_KayUserChecksKostenubersichtWhenHisCostsPDFIsNotBookedOrNotRetrieved() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnNotRetrievedErrorNotificationTitle();
        kostenubersicht.assertOnNotRetrievedErrorNotificationText();
        kostenubersicht.assertOnErrorIcon(rowOrder, columnOrder);
        kostenubersicht.assertOnCostOverViewErrorIconText(rowOrder, columnOrder);

    }

    @Test(description = "GC03 Peter user checks kostenubersicht when his costs PDF is not booked or not retrieved")
    @TmsLink("WFCT-12111")
    public void GC03_PeterUserChecksKostenubersichtWhenHisCostsPDFIsNotBookedOrNotRetrieved() {
        dashboard.clickMeineKostenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnNotRetrievedErrorNotificationTitle();
        kostenubersicht.assertOnNotRetrievedErrorNotificationText();
        kostenubersicht.assertOnErrorIcon(rowOrder, columnOrder);
        kostenubersicht.assertOnCostOverViewErrorIconText(rowOrder, columnOrder);
    }

}
