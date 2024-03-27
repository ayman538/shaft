package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
public class WFDT_5340 extends ST_KableDeutschlandSetup {
    //Test
    @TmsLink("WFDT-5420")
    @Test(description = "Verify download data file and Validate CSV file format",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).validateDownloadCustomerDataBtnText();
        new MeineDaten(driver).clickOnDownloadCustomerDataButton();
        new MeineDaten(driver).validateDownloadCustomerDataPage();
        new MeineDaten(driver).clickOnDownloadCustomerDataAsCSVButton();
    }

    @TmsLink("WFDT-5421")
    @Test(description = "SOHO - Verify download data file and Validate CSV file format",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).validateDownloadCustomerDataBtnText();
        new MeineDaten(driver).clickOnDownloadCustomerDataButton();
        new MeineDaten(driver).validateDownloadCustomerDataPage();
        new MeineDaten(driver).clickOnDownloadCustomerDataAsCSVButton();
    }
}
