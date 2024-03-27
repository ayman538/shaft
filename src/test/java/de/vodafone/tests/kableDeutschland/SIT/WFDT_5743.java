package de.vodafone.tests.kableDeutschland.SIT;

import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.MeineDaten;
import de.vodafone.pages.Kabledeutschland.MyDocuments;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("kableDeutschland")
@Feature("SIT")
@Story("WFDT_5743")
public class WFDT_5743 extends SIT_KableDeutschlandSetup {
    @TmsLink("WFDT-5997")
    @Test(description = "GC01 || Martin - Check 'Meine Dokumente' SO, link out in 'Meine Daten' page and redirection",groups = {"eCare"})
    private void gc01() {
        new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.MEINEKUNDENDATEN);

        new MeineDaten(driver)
                .validateMeineDokumenteSOandLinkout()
                .clickOnDokumenteLinkout();

        new MyDocuments(driver)
                .validateMeineDokumenteLinkoutRedirection()
                .clickOnBackButton();

        new MeineDaten(driver)
                .validateMeinDokumenteSOheader()
                .clickOnMeineDokumenteSO();

        new MyDocuments(driver).validateMeineDokumenteSOredirection();
    }

}
