package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Einstellungen;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Epic("Billing")
@Feature("ST")

public class WFCT_10051 extends ST_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    Einstellungen einstellungen;

    @BeforeMethod
    public void beforeMethod() {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        einstellungen = new Einstellungen(driver);
    }

    @Test(description = "GC01-Bart User with only paper bill checks Meine Rechnungen Page")
    @TmsLink("WFCT-10335")
    public void GC01_BartUserWithOnlyPaperBillChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnPaperOnlyNotificationColor();
        rechnungen.assertOnPaperOnlyNotificationTitle();
        rechnungen.assertOnPaperOnlyNotificationBody();
        rechnungen.assertOnPaperNotificationLink();
        rechnungen.clickBillingSettingLink();
        einstellungen.assertThatUserNavigatedToPage();
    }

    @Test(description = "GC02-Kay user has paper invoices with old online bills checks Meine Rechnungen Page")
    @TmsLink("WFCT-10349")
    @Issue("WFCT-15568")
    public void GC02_KayUserHasPaperInvoicesWithOldOnlineBillsChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnOldOnlineNotificationColor();
        rechnungen.assertOnOldOnlineNotificationTitle();
        rechnungen.assertOnOldOnlineNotificationBody();
        rechnungen.assertOnPaperNotificationLink();
        rechnungen.assertOnOldOnlineBarHeight();
        rechnungen.clickBillingSettingLink();
        einstellungen.assertThatUserNavigatedToPage();

    }

    @Test(description = "GC03-Marie user with paper and online bills checks Meine Rechnungen Page")
    @TmsLink("WFCT-10350")
    @Issue("WFCT-15557")
    public void GC03_MarieUserWithPaperAndOnlineBillsChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnPaperAndOnlineNotificationTitle();
        rechnungen.assertOnPaperAndOnlineNotificationBody();
        rechnungen.assertOnPaperAndOnlineNotificationColor();
        rechnungen.assertOnPaperAndOnlineBarHeight();
        rechnungen.assertOnPaperNotificationLink();
        rechnungen.clickBillingSettingLink();
        einstellungen.assertThatUserNavigatedToPage();
    }
}
