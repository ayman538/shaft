package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-12252")

public class WFCT_12252 extends ST_BillingSetup {

    String itemizedBillBlockingIconRowNum;
    String itemizedBillWarningIconRowNum;

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;
    Rechnungen rechnungen;
    InvoiceHelpPage invoiceHelpPage;

    @Test(description = "GC01 - peter user has no itemized bill booked check kostenubersicht tab")
    @TmsLink("WFCT-12475")
    public void GC01_PeterUserHasNoItemizedBillBookedCheckKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnPeterNotBookedItemizedBillTableDescription();
        kostenubersicht.assertOnNotBookedLinkCl();
        kostenubersicht.assertThatConnectionOverviewColumnDoesNotExist();
        kostenubersicht.clickOnNotBookedLink();
        invoiceHelpPage.assertThatInvoiceHelpPageLoaded();
    }

    @Test(description = "GC02 - peter user has itemized bill booked but no usage for a month or service doesn`t deliver check kostenubersicht tab")
    @TmsLink("WFCT-12476")
    public void GC02_PeterUserHasItemizedBillBookedButNoUsageCheckKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnPeterNotRetrievedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        kostenubersicht.assertOnWarningIconCl(itemizedBillWarningIconRowNum);

    }

    @Test(description = "GC03 - peter user has itemized bill partialy booked check kostenubersicht tab")
    @TmsLink("WFCT-12477")
    public void GC03_PeterUserHasItemizedBillPartiallyBookedCheckKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnPeterPartiallyBookedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatBlockingIconExists(itemizedBillBlockingIconRowNum);
        kostenubersicht.assertOnBlockingIconCl(itemizedBillBlockingIconRowNum);
    }

    @Test(description = "GC04 - peter user has itemized bill partially booked with pdf not retrieved check kostenubersicht tab")
    @TmsLink("WFCT-12478")
    public void GC04_PeterUserHasItemizedBillPartiallyBookedWithPdfNotRetrievedCheckKostenubersichtTab() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.assertOnPeterPartiallyBookedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        kostenubersicht.assertThatBlockingIconExists(itemizedBillBlockingIconRowNum);

    }

    @Test(description = "GC05 - bart has no itemized bill booked check kostenubersicht tab")
    @TmsLink("WFCT-12479")
    public void GC05_BartUserHasNoItemizedBillBookedCheckKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnKayAndBartNotBookedItemizedBillTableDescription();
        kostenubersicht.assertOnNotBookedLinkCl();
        kostenubersicht.assertThatConnectionOverviewColumnDoesNotExist();
        kostenubersicht.clickOnNotBookedLink();
        invoiceHelpPage.assertThatInvoiceHelpPageLoaded();
    }

    @Test(description = "GC06 - kay has itemized bill booked but no usage for a subscriber or service doesn`t deliver check kostenubersicht tab")
    @TmsLink("WFCT-12480")
    public void GC06_KayUserHasItemizedBillBookedButNoUsageCheckKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnKayAndBartNotRetrievedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        kostenubersicht.assertOnWarningIconCl(itemizedBillWarningIconRowNum);
    }

    @Test(description = "GC07 - kay has itemized bill partially booked check kostenubersicht tab")
    @TmsLink("WFCT-12481")
    public void GC07_KayUserHasItemizedBillPartiallyBookedCheckKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnKayAndBartPartiallyBookedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatBlockingIconExists(itemizedBillBlockingIconRowNum);
        kostenubersicht.assertOnBlockingIconCl(itemizedBillBlockingIconRowNum);
    }

    @Test(description = "GC08 - bart user itemized bill partialy booked with pdf not retreived check kostenubersicht tab")
    @TmsLink("WFCT-12482")
    public void GC08_BartUserHasItemizedBillPartiallyBookedWithPdfNotRetrievedCheckKostenubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnKayAndBartPartiallyBookedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        kostenubersicht.assertThatBlockingIconExists(itemizedBillBlockingIconRowNum);
    }

    @Test(description = "ST - GC11 - marie has itemized bill partially booked with pdf not retrieved check rechnungen tab")
    @TmsLink("WFCT-12134")
    public void GC11_marieHasItemizedBillPartiallyBookedWithPdfNotRetrievedCheckRechnungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickRechnungTab();
        rechnungen.assertOnPartiallyBookedItemizedBillTableDescription();
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
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        invoiceHelpPage = new InvoiceHelpPage(driver);
        rechnungen = new Rechnungen(driver);

    }

}
