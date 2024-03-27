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
public class WFDT_Flow33 extends SIT_UnityMediaSetup {
    @TmsLink("WFDT-5157")
    @Test
    @Description("SIT33 - Kay - Verify booking additional Vodafone one number card" +
            " in case user has available slots")
    private void gc01() {
         // new Dashboard(driver).isBEWOverlayfound();
        //  new Dashboard(driver).ReloadCurrentPage();

        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).expandKaywithAvaliableSlots();
        new Dashboard(driver).clickOnBurgerMenu_AvailableSlots();
        new Dashboard(driver).clickOnSIMKarte_AvailableSlots();
        new SIM_Karte_Einstellungen(driver).clickOnNeue_SIM_KarteSO();
        new Neue_SIM_Karte_bestellen(driver).validatePageTitle();
        new Neue_SIM_Karte_bestellen(driver).clickOnNeue_SIM_Karte_bestellen_Tile();
        new Zusatzliche_SIM_Karte(driver).validatePagetitle();
        new Zusatzliche_SIM_Karte(driver).validateVodafoneOneNumberCard();
        new Zusatzliche_SIM_Karte(driver).validateRedPartnerkarteCard();
        new Zusatzliche_SIM_Karte(driver).validateVodafoneOneNumberCarCard();
        new Zusatzliche_SIM_Karte(driver).validateNeuenVertragCard();
    }
}
