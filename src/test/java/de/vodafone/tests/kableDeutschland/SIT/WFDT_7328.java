package de.vodafone.tests.kableDeutschland.SIT;
import de.vodafone.pages.Kabledeutschland.AnonymousCallSettings;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_7328")
public class WFDT_7328 extends SIT_KableDeutschlandSetup {
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
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .clickOnTelephoneSettingsAcc()
                .clickOnAnonymousCardChangeBtn();

        new AnonymousCallSettings(driver)
                .validateAnonymousCallSettingsPageNonHomebox()
                .changeFirstLineToggleToOFF()
                .clickOnConfirmationBtn()
                .validateSuccessConfirmationPageNonHomeBox();
    }

}