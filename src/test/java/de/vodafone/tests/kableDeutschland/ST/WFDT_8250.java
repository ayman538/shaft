package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT-8250")
public class WFDT_8250 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-9087")
    @Test(description = "GC01 || Martin SOHO - Validate bridge mode accordion in case that Homspot is activated.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnBridgeModeSO()
                .validateBridgeModeAccIfHomeSpotIsEnabled();
    }

    @TmsLink("WFDT-9088")
    @Test(description = "GC02 || Martin Consumer - Validate bridge mode accordion in case that Homspot is activated.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnBridgeModeSO()
                .validateBridgeModeAccIfHomeSpotIsEnabled();
    }

}