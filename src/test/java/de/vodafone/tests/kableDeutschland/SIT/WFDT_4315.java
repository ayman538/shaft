package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_4315")
public class WFDT_4315 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-4832")
    @Test(description = "GC01 || Martin-Verify Kontaktdaten smart object added to Meine Daten page",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).validateKontaktDatennSOandAccordion();
    }

}
