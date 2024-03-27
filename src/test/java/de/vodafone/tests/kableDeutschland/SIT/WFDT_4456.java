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
@Story("WFDT_4456")
public class WFDT_4456 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-4920")
    @Test(description = "GC01 || Given I am a KD contract owner When I navigate to meine kundendaten section of my contract Then I should see a new accordion 'Datenschutz&Werbeeinstellungen'together with a smart object",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new Dashboard(driver).validateDatenschutzAndWerbeeinstellungenSO();
        new MeineDaten(driver).pressOnSmartObject(MeineDaten.MeineDatenSmartObjects.DATENSCHUTZWERBEEINSTELLUNGEN);
    }

}
