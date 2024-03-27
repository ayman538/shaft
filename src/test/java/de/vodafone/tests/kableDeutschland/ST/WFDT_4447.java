package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import de.vodafone.pages.Kabledeutschland.PrivacySettings;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4447")
public class WFDT_4447 extends ST_KableDeutschlandSetup {
    @TmsLink("WFDT-6079")
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
