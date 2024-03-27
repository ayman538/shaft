package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_5340")
public class WFDT_5340 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-5425")
    @Test(description = "GC01 || Verify download data file and Validate CSV file format",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .validateDownloadCustomerDataBtnText()
                .clickOnDownloadCustomerDataButton()
                .clickOnDownloadCustomerDataAsCSVButton();
    }

    @TmsLink("WFDT-5820")
    @Test(description = "GC02 || SOHO - Verify download data file and Validate CSV file format",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .validateDownloadCustomerDataBtnText()
                .clickOnDownloadCustomerDataButton()
                .clickOnDownloadCustomerDataAsCSVButton();
    }

}
