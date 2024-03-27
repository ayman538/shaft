package de.vodafone.tests.kableDeutschland.ST;


import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.GigaTVSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFDT_8291")
public class WFDT_8291 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-8354")
    @Test(description = "GC01 || Martin Consumer - Validate Giga TV SO & ACC in case the user has TV product incase type:TV",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver)
                .expandKabelTVAccordion()
                .validateGigaTvSO()
                .openGigaTVSettingsPageUsingBurgerMenuLinkout();

        new GigaTVSettings(driver)
                .validateGigaTvSOAppears()
                .clickOnGigaTVSmartObject()
                .validateGigaTVAccAppears();
    }

    @TmsLink("WFDT-8356")
    @Test(description = "GC02 || Martin SOHO - Validate Giga TV SO & ACC in case the user has TV product incase type:TV",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new GigaTVSettings(driver)
                .validateGigaTvSOAppears()
                .clickOnGigaTVSmartObject()
                .validateGigaTVAccAppears();
    }

    @TmsLink("WFDT-8476")
    @Test(description = "GC04 || Martin Consumer - Validate Giga TV SO & ACC in case the user has TV product incase type:STA",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver)
                .expandKabelTVAccordion()
                .validateGigaTvSO()
                .openGigaTVSettingsPageUsingBurgerMenuLinkout();

        new GigaTVSettings(driver)
                .validateGigaTvSOAppears()
                .clickOnGigaTVSmartObject()
                .validateGigaTVAccAppears();
    }

    @TmsLink("WFDT-8477")
    @Test(description = "GC05 || Martin SOHO - Validate Giga TV SO & ACC in case the user has TV product incase type:STA",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openGigaTVSettingsPageUsingBurgerMenuLinkout();
        new GigaTVSettings(driver)
                .validateGigaTvSOAppears()
                .clickOnGigaTVSmartObject()
                .validateGigaTVAccAppears();
    }

}

