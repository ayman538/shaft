package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")

public class WFCT_10480 extends SIT_BillingSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    String contractOrder;
    String rowOrder;
    String columnOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
        rowOrder = testData.getTestData(method.getName()+".rowOrder");
        columnOrder = testData.getTestData(method.getName()+".columnOrder");
    }


    @Test(description = "Kay user checks kostenubersicht when his costs PDF is not booked or not retrieved")
    @TmsLink("WFCT-12115")
    public void GC01_KayUserChecksKostenubersichtWhenHisCostsPDFIsNotBookedOrNotRetrieved(Method method) {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.clickShowMore();
        kostenubersicht.assertOnNotRetrievedErrorNotificationTitle();
        kostenubersicht.assertOnNotRetrievedErrorNotificationText();
        kostenubersicht.assertOnErrorIcon(rowOrder,columnOrder);
        kostenubersicht.assertOnCostOverViewErrorIconText(rowOrder,columnOrder);
    }

}
