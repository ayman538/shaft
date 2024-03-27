package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.KIPSettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_7866")
public class WFDT_7866 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-8090")
    @Test(description = "GC01|| Martin Consumer - Validate Phone Book Settings SO & ACC in case the user has KIP.",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

        new KIPSettings(driver)
                .validatePhoneSettingSoAppears()
                .clickOnPhoneSettingSO()
                .validatePhoneSettingAccAppears()
                .validatePhoneSettingNotification();
    }

    @TmsLink("WFDT-8099")
    @Test(description = "GC02|| Martin Consumer - Validate Phone Book Settings SO & ACC in case the user has no KIP.",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).expandTorstenAccordionForSITCases();
        new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
        new KIPSettings(driver).validatePhoneSettingSoAndAccNotDisplayed();
    }

}
