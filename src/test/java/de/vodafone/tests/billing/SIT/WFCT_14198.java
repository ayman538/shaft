package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-14198")

public class WFCT_14198 extends SIT_BillingSetup {

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Verbindungsubersicht verbindungsubersicht;
    String totalAmount,notificationBody,notificationTitle
            ,notificationColor,contractOrder,billCycle,number;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        verbindungsubersicht = new Verbindungsubersicht(driver);
        totalAmount = testData.getTestData(method.getName()+".totalAmount");
        notificationTitle = testData.getTestData((method.getName()+".notificationTitle"));
        notificationBody = testData.getTestData((method.getName()+".notificationBody"));
        notificationColor = testData.getTestData((method.getName()+".notificationColor"));
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
        billCycle = testData.getTestData(method.getName()+".billCycle");
        number = testData.getTestData(method.getName()+".number");
    }


    @Test(description = "GC09 - Kay with no usage at certain bill cycle checks connection overview tab")
    @TmsLink("WFCT-14563")
    public void GC09_KayWithNoUsageAtCertainBillCycleChecksConnectionOverviewTab() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.selectNumberFromFilter(number)
                            .selectBillPeriodFromFilter(billCycle);
        verbindungsubersicht.assertOnNoUsageNotificationMessageTitle(notificationTitle)
                .assertOnNoUsageNotificationMessageBody(notificationBody)
                .assertOnNoUsageNotificationMessageColor(notificationColor)
                .assertOnTotalAmountValue(totalAmount)
                .assertOnCsvDownloadButtonIsDimmed()
                .assertOnCsvDownloadButtonColor()
                .assertOnCsvDownloadButtonTextColor()
                .assertOnPdfDownloadButtonIsDimmed()
                .assertOnPdfDownloadButtonColor()
                .assertOnPdfDownloadButtonTextColor();
        verbindungsubersicht.assertOnSelectedBillCycle(billCycle);
    }

    @Test(description = "GC11 - Peter user booked itemized bill checks connection overview tab")
    @TmsLink("WFCT-14565")
    public void GC11_PeterUserBookedItemizedBillChecksConnectionOverviewTab() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnBrandNewCustomerNotificationMessageTitle(notificationTitle)
                .assertOnBrandNewCustomerNotificationMessageBody(notificationBody)
                .assertOnBrandNewCustomerNotificationMessageColor(notificationColor);
    }
}
