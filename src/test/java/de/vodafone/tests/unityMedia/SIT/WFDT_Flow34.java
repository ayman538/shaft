package de.vodafone.tests.unityMedia.SIT;

import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.Neue_SIM_Karte_bestellen;
import de.vodafone.pages.unityMedia.SIM_Karte_Einstellungen;
import de.vodafone.pages.unityMedia.Zusatzliche_SIM_Karte;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow34 extends SIT_UnityMediaSetup {
    @TmsLink("WFDT-5158")
    @Test
    @Description("SIT34 - Paul - Verify available options for eligible" +
            " Prepaid user has available free slots")



    private void gc01() {
        // new Dashboard(driver).isBEWOverlayfound();
        //  new Dashboard(driver).ReloadCurrentPage();

        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).expandPaulContract();
        new Dashboard(driver).clickOnPaulBurgerMenu();
        new Dashboard(driver).clickOnSIMKarte_Option();
        new SIM_Karte_Einstellungen(driver).clickOnNeue_SIM_KarteSO();
        new Neue_SIM_Karte_bestellen(driver).validatePageTitle();
        new Neue_SIM_Karte_bestellen(driver).clickOnNeue_SIM_Karte_bestellen_Tile();
        new Zusatzliche_SIM_Karte(driver).validatePagetitle();
       new Zusatzliche_SIM_Karte(driver).validatePreparidErrorMsg();
    }
}
