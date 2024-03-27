package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT-8249")
public class WFDT_8249 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-8971")
    @Test(description = "GC01 || Martin Consumer - Validate Homespot Accordion in Activation Case.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotActiveButton();
    }

    @TmsLink("WFDT-8972")
    @Test(description = "GC02 || Martin SOHO - Validate Homespot Accordion in Deactivation Case.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotDeActiveButton();
    }

    @TmsLink("WFDT-8973")
    @Test(description = "GC03 || Martin Consumer- Validate Homespot Accordion within 24h of activation process.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotActivationWithinDay();
    }

    @TmsLink("WFDT-8974")
    @Test(description = "GC04 || Martin Consumer - Validate Homespot Accordion within 7days of deactivation process.",groups = {"eCare"})
    private void gc04() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotDeActivationWithinSevenDays();
    }

    @TmsLink("WFDT-8975")
    @Test(description = "GC05 || Martin Consumer - Validate Homsespot Accordion in case user has no Wifi option.",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotNonEligibleCase();
    }

    @TmsLink("WFDT-8976")
    @Test(description = "GC06 || Martin SOHO- Validate Homsespot Accordion in case that the Bridge mode is activated.",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotBridgeModeCase();
    }

    @TmsLink("WFDT-8977")
    @Test(description = "GC07 || Martin Consumer Validate Homespot Accordion in case the user has no internet product.",groups = {"eCare"})
    private void gc07() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).validateHomespotAccNotDisplayed();
    }

    @TmsLink("WFDT-8978")
    @Test(description = "GC08 || Martin SOHO Validate Homespot Accordion in case the user have no Homebox router.",groups = {"eCare"})
    private void gc08() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotNonEligibleCase();
    }

    @TmsLink("WFDT-8979")
    @Test(description = "BC01 || Martin SOHO - Validate Homespot Accordion in case that the activation failed.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotActiveDeActiveFailed();
    }

    @TmsLink("WFDT-8980")
    @Test(description = "BC02 || Martin SOHO - Validate Homespot Accordion in case that the deactivation failed.",groups = {"eCare"})
    private void bc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .validateHomespotActiveDeActiveFailed();
    }

}
