package de.vodafone.tests.kableDeutschland.SIT;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import de.vodafone.pages.Kabledeutschland.VisibilityCallSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_7329")
public class WFDT_7329 extends SIT_KableDeutschlandSetup {
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
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnVisibilityCardChangeBtn();

        new VisibilityCallSettings(driver)
                .validateVisibilityCallSettingsPageNonHomebox()
                .changeFirstLineToggleToOFF()
                .clickOnConfirmationBtn()
                .validateSuccessConfirmationPageNonHomeBox();
    }

}
