package de.vodafone.tests.CableMigration.ST;

import de.vodafone.pages.CableMigration.KostenkontrollePage;
import de.vodafone.pages.CableMigration.MeinVodafoneDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Cable Migration")
@Feature("ST")
@Story("WFFT_3341 Billing | Error Handling for One Service failure")
public class WFFT_3341 extends CableMigrationSTSetup {
    MeinVodafoneDashboard meinVodafoneDashboard;
    KostenkontrollePage kostenkontrollePage;

    @Test(description = "GC01- Verify the Kostenkontrolle tab in case the Telephone and TV services have failed (Desktop)")
    @TmsLink("WFFT-3447")
    private void GC01() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.ValidateAll_ServiceError();
    }
    @Test(description = "GC02- Verify the Kostenkontrolle tab while only the Telephone service has failed. (Desktop)")
    @TmsLink("WFFT-3450")
    private void GC02() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.ValidateTelephone_ServiceError();
    }
    @Test(description = "GC03- Verify the Kostenkontrolle tab while only the TV & Video service has failed. (Desktop)")
    @TmsLink("WFFT-3451")
    private void GC03() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.ValidateTV_ServiceError();
    }
    @Test(description = "GC04- Verify the Kostenkontrolle tab in case only one service has failed while the other service is not booked. (Desktop)")
    @TmsLink("WFFT-3452")
    private void GC04() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.ValidateNotBooked_ServiceError();
    }
    @Test(description = "GC05- Verify the Kostenkontrolle tab in case the two services are not booked (Desktop)")
    @TmsLink("WFFT-3453")
    private void GC05() {
        meinVodafoneDashboard = new MeinVodafoneDashboard(driver);
        meinVodafoneDashboard.navigateToMeinReshnungPage();
        kostenkontrollePage = new KostenkontrollePage(driver);
        kostenkontrollePage.ClickOnKostenkontrolleTab();
        kostenkontrollePage.ValidateNotBookedNotification();
    }
}
