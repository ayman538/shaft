package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_10132 extends ST_BillingSetup {

    String itemizedBillBlockingIconRowNum;
    String itemizedBillWarningIconRowNum,itemizedBillTableDescription;

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Rechnungen rechnungen;

    @Test(description = "ST - GC01 - marie has no itemized bill booked check rechnungen tab")
    @TmsLink("WFCT-12131")
    public void GC01_marieHasNoItemizedBillBookedCheckRechnungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickRechnungTab();
        rechnungen.assertOnNotBookedItemizedBillTableDescription();
        rechnungen.assertThatNotRetrievedItemizedBillNotificationDoesNotExist();
        rechnungen.assertThatPartiallyBookedItemizedBillNotificationDoesNotExist();
        rechnungen.assertThatItemizedBillColumnDoesNotExist();
    }

    @Test(description = "ST - GC02 - marie has itemized bill booked but no usage for a month or service doesn`t deliver check rechnungen tab")
    @TmsLink("WFCT-12132")
    public void GC02_marieHasItemizedBillBookedButNoUsageCheckRechnungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickRechnungTab();
        rechnungen.assertOnNotRetrievedItemizedBillTableDescription();
        rechnungen.assertThatNotRetrievedItemizedBillNotificationExists();
        rechnungen.assertOnNotRetrievedItemizedBillNotificationCl();
        rechnungen.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        rechnungen.assertOnWarningIconCl(itemizedBillWarningIconRowNum);
    }

    @Test(description = "ST - GC03 - marie has itemized bill partially booked check rechnungen tab")
    @TmsLink("WFCT-12133")
    public void GC03_marieHasItemizedBillPartiallyBookedCheckRechnungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickRechnungTab();
        rechnungen.assertOnNotRetrievedItemizedBillTableDescription();
        rechnungen.assertThatPartiallyBookedItemizedBillNotificationExists();
        rechnungen.assertOnPartiallyBookedItemizedBillNotificationCl();
        rechnungen.assertThatBlockingIconExists(itemizedBillBlockingIconRowNum);
        rechnungen.assertOnBlockingIconCl(itemizedBillBlockingIconRowNum);
    }

    @Test(description = "ST - GC04 - marie has itemized bill partially booked with pdf not retrieved check rechnungen tab")
    @TmsLink("WFCT-12134")
    public void GC04_marieHasItemizedBillPartiallyBookedWithPdfNotRetrievedCheckRechnungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickRechnungTab();
        rechnungen.assertOnNotRetrievedItemizedBillTableDescription();
        rechnungen.assertThatPartiallyBookedItemizedBillNotificationExists();
        rechnungen.assertThatNotRetrievedItemizedBillNotificationExists();
        rechnungen.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        rechnungen.assertThatBlockingIconExists(itemizedBillBlockingIconRowNum);
        rechnungen.closePartiallyBookedItemizedBillNotification();
        rechnungen.assertThatNotRetrievedItemizedBillNotificationExists();
        rechnungen.closeNotRetrievedItemizedBillNotification();
        rechnungen.assertThatPartiallyBookedItemizedBillNotificationDoesNotExist();
        rechnungen.assertThatNotRetrievedItemizedBillNotificationDoesNotExist();
    }

    @BeforeMethod
    public void testDataSetup(Method method) {
        itemizedBillWarningIconRowNum = testData.getTestData(method.getName() + ".itemizedBillWarningIconRowNum");
        itemizedBillBlockingIconRowNum = testData.getTestData(method.getName() + ".itemizedBillBlockingIconRowNum");
        itemizedBillTableDescription = testData.getTestData(method.getName() + ".itemizedBillTableDescription");
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        rechnungen = new Rechnungen(driver);
    }
}
