package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.EditServiceAddress;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_8746")
public class WFDT_8746 extends ST_KableDeutschlandSetup{
    @TmsLink("WFDT-8934")
    @Test(description = "GC01 || Martin SOHO- Validate edit Service address Inside Germany in case DSL connection is available.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .expandAddressesAccordion()
                .clickOnEditServiceAddressButton();

        new EditServiceAddress(driver)
                .validateNonCheckedOutSideGermany()
                .SelectNewServiceAddressdate()
                .clearHouseNumber()
                .changeHouseNumberCaseThree()
                .clickOnContinueBtn()
                .selectSuggestedAddress2()
                .validateDSLConnectionView();
    }
}
