package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Verbindungsubersicht;
import de.vodafone.tests.billing.ST.ST_BillingSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-11159")
public class WFCT_11159 extends SIT_BillingSetup {
    Verbindungsubersicht verbindungsubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    String totalAmount;
    String phoneNumber;
    String billPeriod;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        verbindungsubersicht = new Verbindungsubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        totalAmount = testData.getTestData(method.getName() + ".totalAmount");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        billPeriod = testData.getTestData(method.getName() + ".billPeriod");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
    }

    @Test(description = "GC06 - bart user checks using both filters togther")
    @TmsLink("WFCT-14489")
    public void GC06_BartUserChecksUsingBothFiltersTogther() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.selectNumberFromFilter(phoneNumber)
                .selectBillPeriodFromFilter(billPeriod)
                .assertOnTotalAmountValue(totalAmount);
    }
}
