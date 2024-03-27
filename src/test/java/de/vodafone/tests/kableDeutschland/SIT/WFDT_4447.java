package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import de.vodafone.pages.Kabledeutschland.PrivacySettings;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_4447")
public class WFDT_4447 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-6080")
    @Test(description = "GC01 || Martin - Verify link outs display and direction in the privacy accordion",groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .validateMeinDatenPageTitle()
                .pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN)
                .clickOnInitialPermissionLinkout();

        new PrivacySettings(driver)
                .validatePrivacyPageTitle()
                .clickBackbutton();

        new MeineDaten(driver).clickOnDataProtectionLinkout();
        new PrivacySettings(driver).validateDataProtectionLinkOut();
    }

}
