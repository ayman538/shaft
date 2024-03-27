package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_10305 extends ST_BillingSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    String notReturnedNum;
    String rowOrder;
    String columnOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        notReturnedNum = testData.getTestData(method.getName()+".notReturnedNum");
        rowOrder = testData.getTestData(method.getName() + ".rowOrder");
        columnOrder = testData.getTestData(method.getName() + ".columnOrder");
    }

    @Test(description = " Kay user checks Kostenübersicht Tab in Meine Rechnungen page while amount and bill cycle are not retrieved")
    @TmsLink("WFCT-10505")
    public void GC01_kayAmountAndBillCycleNotRetrievedChecksKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnNotReturnedAmountText();
    }


    @Test(description = "Kay user checks Kostenübersicht Tab in Meine Rechnungen page while connection overview PDF could not retrieved")
    @TmsLink("WFCT-10507")
    public void GC03_KayConnectionPdfNotRetrievedChecksKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnNotRetrievedConnectionPdfWarningIcon();
        kostenubersicht.assertOnNotRetrievedConnectionPdfWarningText();
    }

    @Test(description = "Bart user checks Kostenübersicht Tab in Meine Rechnungen page while connection overview and Kostenübersicht PDF could not retrieved")
    @TmsLink("WFCT-10508")
    public void GC04_BartWithNotReturnedCostAndConnectionPdfChecksKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnErrorIcon(rowOrder, columnOrder);
        kostenubersicht.assertOnCostOverViewErrorIconText(rowOrder, columnOrder);
        kostenubersicht.assertOnNotRetrievedConnectionPdfWarningIcon();
        kostenubersicht.assertOnNotRetrievedConnectionPdfWarningText();

    }

    @Test(description = "Kay user checks Kostenübersicht Tab in Meine Rechnungen page while complete information missing for one month for one MSISDN")
    @TmsLink("WFCT-10509")
    public void GC05_KayMissingOneMonthInfoOneMSISDNChecksKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnNotReturnedNumber(notReturnedNum);
    }

    @Test(description = "Bart user checks Kostenübersicht Tab in Meine Rechnungen page while complete information missing for all MSISDN")
    @TmsLink("WFCT-10510")
    public void GC06_BartMissingInfoAllMSISDNChecksKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnMissingAllInfoNotificationTitleText();
        kostenubersicht.assertOnMissingAllInfoNotificationBodyText();
    }


    @Test(description = "Kay user checks Kostenübersicht Tab in Meine Rechnungen page while BE response is empty")
    @TmsLink("WFCT-10511")
    public void GC07_KayBEResponseEmptyChecksKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnEmptyBeNotificationTitleText();
        kostenubersicht.assertOnEmptyBeNotificationBodyText();

    }


    @Test(description = "Bart user checks Kostenübersicht Tab in Meine Rechnungen page while BE response is error")
    @TmsLink("WFCT-10512")
    public void GC08_BartBEResponseErrorChecksKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnErrorNotificationTitleText();
        kostenubersicht.assertOnErrorNotificationBodyText();

    }
}
