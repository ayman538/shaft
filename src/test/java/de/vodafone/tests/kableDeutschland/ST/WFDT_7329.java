package de.vodafone.tests.kableDeutschland.ST;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import de.vodafone.pages.Kabledeutschland.VisibilityCallSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_7329")
public class WFDT_7329 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-7579")
    @Test(description = "GC01 || Martin - Validate new section 'Rufnummerunterdrueckung aendern",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .validateTelephoneSettingsAcc()
                .validateVisibilityCallsSettingsAcc()
                .clickOnVisibilityCardChangeBtn();

        new VisibilityCallSettings(driver).validateRedirectionToVisibilityCallSettingPage();

    }

    @TmsLink("WFDT-7585")
    @Test(description = "GC02 || Martin SOHO - Validate number visibility settings in case user has Home-box router",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnVisibilityCardChangeBtn();

        new VisibilityCallSettings(driver)
                .validateVisibilityCallSettingsPageHomebox()
                .changeFirstNumberToggleToOn()
                .changeSecondNumberToggleToOn()
                .clickOnConfirmationBtn()
                .validateSuccessOfConfirmationPageHomeBox();
    }

    @TmsLink("WFDT-7586")
    @Test(description = "GC03 || Martin - Validate number visibility settings in case user has a non home-box router",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnVisibilityCardChangeBtn();

        new VisibilityCallSettings(driver)
                .validateVisibilityCallSettingsPageNonHomebox()
                .changeFirstLineToggleToOFF()
                .changeSecondLineToggleToOn()
                .clickOnConfirmationBtn()
                .validateSuccessConfirmationPageNonHomeBox();
    }

    @TmsLink("WFDT-7587")
    @Test(description = "GC04 || Martin - Verify deep-linking to the number visibility settings",groups = {"eCare"})
    private void gc04() {
        new KIPSettings(driver)
                .deeplinkToVisibilityCallSettingsPage()
                .validateDeeplinikingIsDisabled();
    }

    @TmsLink("WFDT-7589")
    @Test(description = "BC01 || Martin- Validate service failure of number visibility settings in case user has Home-box router",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver).
                clickOnTelephoneSettingsAcc()
                .clickOnVisibilityCardChangeBtn();

        new VisibilityCallSettings(driver)
                .validateVisibilityCallSettingsPageHomebox()
                .changeFirstNumberToggleToOn()
                .changeSecondNumberToggleToOn()
                .clickOnConfirmationBtn()
                .validateFailureOfConfirmationPageHomeBox();
    }

    @TmsLink("WFDT-7590")
    @Test(description = "BC02 || Martin SOHO - Validate service failure of number visibility settings in case user has a non Home-box router",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnVisibilityCardChangeBtn();

        new VisibilityCallSettings(driver)
                .changeFirstLineToggleToOFF()
                .changeSecondLineToggleToOn()
                .clickOnConfirmationBtn()
                .validateFailureOfConfirmationPageNonHomeBox();
    }

}
