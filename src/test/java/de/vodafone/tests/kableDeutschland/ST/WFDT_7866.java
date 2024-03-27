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
@Story("WFDT_7866")
public class WFDT_7866 extends ST_KableDeutschlandSetup {

    @TmsLink("WFDT-8090")
    @Test(description = "GC01|| Martin Consumer - Validate Phone Book Settings SO & ACC in case the user has KIP.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .validatePhoneSettingSoAppears()
                .clickOnPhoneSettingSO()
                .validatePhoneSettingAccAppears();

    }

    @TmsLink("WFDT-8099")
    @Test(description = "GC02|| Martin Consumer - Validate Phone Book Settings SO & ACC in case the user has no KIP.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).validatePhoneSettingSoAndAccNotDisplayed();

    }

    @TmsLink("WFDT-8101")
    @Test(description = "GC03|| Martin SOHO - Validate Phone Book Settings SO & ACC in case the user has KIP.",groups = {"eCare"})
    private void gc03() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .validatePhoneSettingSoAppears()
                .clickOnPhoneSettingSO()
                .validatePhoneSettingAccAppears();

    }

    @TmsLink("WFDT-8103")
    @Test(description = "BC01 || Martin Consumer - Validate Phone Book Settings Accordion in case of service failure.",groups = {"eCare"})
    private void bc04() {
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver)
                .clickOnPhoneSettingSO()
                .validatePhoneSettingSoFailure();

    }

}
