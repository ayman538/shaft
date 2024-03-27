package de.vodafone.tests.kableDeutschland.ST;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("ST")
@Story("WFDT_4315")
public class WFDT_4315 extends ST_KableDeutschlandSetup {

    //Test
    @TmsLink("WFDT-4588")
    @Test(description = "GC01 || Martin-Verify Kontaktdaten smart object added to Meine Daten page",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver).validateKontaktDatennSOandAccordion();
    }

    @TmsLink("WFDT-4589")
    @Test(description = "GC02 || Martin - Verify Accordion after clicking on the \"Kontaktdaten\" smart object",groups = {"eCare"})
    private void gc02() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .validateKontaktDatennSOandAccordion()
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN);
    }

}