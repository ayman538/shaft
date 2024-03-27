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
@Story("WFDT_7976")
public class WFDT_7976 extends SIT_KableDeutschlandSetup {
        @TmsLink("WFDT-8077")
        @Test(description = "GC01 || Martin consumer- Validate new section for phoneline settings",groups = {"eCare"})
        public void gc01 () {
            new Dashboard(driver).expandTorstenAccordionForSITCases();
            new Dashboard(driver).openKIPSettingsPageUsingBurgerMenuLinkout();

            new KIPSettings(driver)
                    .clickOnTelephoneSettingsAcc()
                    .validatePhonelineNotification();
        }

}
