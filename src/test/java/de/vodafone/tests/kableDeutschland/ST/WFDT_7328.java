package de.vodafone.tests.kableDeutschland.ST;
import de.vodafone.pages.Kabledeutschland.AnonymousCallSettings;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_7328")
public class WFDT_7328 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-7578")
    @Test( description = "GC01 || Martin - Validate new section 'Anonyme Anrufe blockieren",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .validateAnonymousCallsSettingsCard()
                .clickOnAnonymousCardChangeBtn();

        new AnonymousCallSettings(driver).validateRedirectionToAnonymousCallSettingPage();
    }

    @TmsLink("WFDT-7580")
    @Test(description = "GC02 || Martin SOHO - Validate anonymous calls settings in case user has a Home-box router",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnAnonymousCardChangeBtn();

        new AnonymousCallSettings(driver)
                .validateAnonymousCallSettingsPageHomebox()
                .changeFirstNumberToggleToOFF()
                .changeSecondNumberToggleToOn()
                .clickOnConfirmationBtn()
                .validateSuccessConfirmationPageHomeBox();
    }

    @TmsLink("WFDT-7581")
    @Test(description = "GC03 || Martin - Validate anonymous calls settings in case user has a non Home-box router",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnAnonymousCardChangeBtn();

        new AnonymousCallSettings(driver)
                .validateAnonymousCallSettingsPageNonHomebox()
                .changeFirstLineToggleToOFF()
                .changeSecondLineToggleToOn()
                .clickOnConfirmationBtn()
                .validateSuccessConfirmationPageNonHomeBox();
    }

    @TmsLink("WFDT-7582")
    @Test(description = "GC04 || Martin - Validate deep linking to the anonymous call settings",groups = {"eCare"})
    private void gc04() {
        new KIPSettings(driver)
                .deeplinkToAnonymousCallSettingsPage()
                .validateDeeplinikingIsDisabled();
    }

    @TmsLink("WFDT-7583")
    @Test(description = "BC01 || Martin - Validate service failure of anonymous calls settings in  case user has Home-box router",groups = {"eCare"})
    private void gc05() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnAnonymousCardChangeBtn();

        new AnonymousCallSettings(driver)
                .changeFirstNumberToggleToOFF()
                .changeSecondNumberToggleToOn()
                .clickOnConfirmationBtn()
                .validateFailureOfConfirmationPageHomeBox();
    }

    @TmsLink("WFDT-7584")
    @Test(description = "BC02 || SOHO Martin - Validate service failure of anonymous calls settings in case user has a non Home-box route",groups = {"eCare"})
    private void gc06() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnAnonymousCardChangeBtn();

        new AnonymousCallSettings(driver)
                .changeFirstLineToggleToOFF()
                .changeSecondLineToggleToOn()
                .clickOnConfirmationBtn()
                .validateFailureOfConfirmationPageNonHomeBox();
    }

}