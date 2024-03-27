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
@Story("WFDT_4298")
public class WFDT_4298 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-4831")
    @Test(description = "GC01 || Martin - Verify Login-Daten section with given and validated Login e-Mail address",groups = {"eCare"})
    private void gc01(){
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);
        new MeineDaten(driver)
                .clickOnSmartObject(MeineDaten.MeineDatenSmartObjects.KONTAKTDATEN)
                .AssertLoginDataInCaseValidatedEmail();
    }

}

