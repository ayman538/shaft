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
@Story("WFDT_7976")
public class WFDT_7976 extends ST_KableDeutschlandSetup {

        @TmsLink("WFDT-8077")
        @Test(description = "GC01 || Martin consumer- Validate new section for phoneline settings",groups = {"eCare"})
        public void gc01 () {
            new Dashboard(driver).ignoreDashboardNotifications();
            new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
            new KIPSettings(driver).clickOnTelephoneSettingsAcc();
            new KIPSettings(driver).validatePhonelineNotification();
        }

        @TmsLink("WFDT-8078")
        @Test(description = "GC02 || Martin SOHO- Validate new section for phoneline settings",groups = {"eCare"})
        public void gc02 () {
            new Dashboard(driver).ignoreDashboardNotifications();
            new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();
            new KIPSettings(driver).clickOnTelephoneSettingsAcc();
            new KIPSettings(driver).validatePhonelineNotification();
        }
    }
