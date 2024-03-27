package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.HomeSpotSetting;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT-8123")
public class WFDT_8123 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-8985")
    @Test(description = "GC01 || Martin SOHO - Validate Homespot activation flow.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                    .clickOnHomeSpotAccordion()
                    .clickOnHomespotActiveButton();

        new HomeSpotSetting(driver)
                    .validateHomeSpotSettingMainPage()
                    .validateHomeSpotSettingPageInActivationFlow()
                    .clickOnConfirmBTN()
                    .validateHomeSpotSettingPageAfterActivationSuccessfully();
        }

    @TmsLink("WFDT-8986")
    @Test(description = "GC02 || Martin SOHO - Validate Homespot de-activation flow.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .clickOnHomespotDeActiveButton();

        new HomeSpotSetting(driver)
                .validateHomeSpotSettingMainPage()
                .validateHomeSpotSettingPageInDeactivationFlow()
                .clickOnConfirmBTN()
                .validateHomeSpotSettingPageAfterDeactivationSuccessfully();
    }

    @TmsLink("WFDT-8987")
    @Test(description = "GC03 || Martin Consumer - Validate that Deeplinkig for Homespot activation/deactivation is disabled.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .clickOnHomespotActiveButton();

        new HomeSpotSetting(driver)
                .validateHomeSpotSettingMainPage()
                .validateHomeSpotSettingPageInActivationFlow()
                .ValidateDeeplinkIsBlockedInConfirmationScreen();

        new KIPSettings(driver)
                .clickOnHomespotActiveButton();

        new HomeSpotSetting(driver)
                .validateHomeSpotSettingMainPage()
                .validateHomeSpotSettingPageInActivationFlow()
                .clickOnConfirmBTN()
                .validateHomeSpotSettingPageAfterActivationSuccessfully()
                .ValidateDeeplinkIsBlockedInSuccessScreen();
    }

    @TmsLink("WFDT-8991")
    @Test(description = "BC01 || Martin Consumer - Validate Homespot activation flow when service fail.",groups = {"eCare"})
    private void bc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .clickOnHomespotActiveButton();

        new HomeSpotSetting(driver)
                .validateHomeSpotSettingMainPage()
                .validateHomeSpotSettingPageInActivationFlow()
                .clickOnConfirmBTN()
                .validateHomeSpotSettingPageAfterActivationFailure();
    }

    @TmsLink("WFDT-8992")
    @Test(description = "BC02 || Martin SOHO - Validate Homespot de-activation flow when service fail.",groups = {"eCare"})
    private void bc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnHomeSpotAccordion()
                .clickOnHomespotDeActiveButton();

        new HomeSpotSetting(driver)
                .validateHomeSpotSettingMainPage()
                .validateHomeSpotSettingPageInDeactivationFlow()
                .clickOnConfirmBTN()
                .validateHomeSpotSettingPageAfterDeActivationFailure();
    }

}