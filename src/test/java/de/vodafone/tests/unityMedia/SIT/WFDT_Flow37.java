package de.vodafone.tests.unityMedia.SIT;

import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.SIM_Karte_Einstellungen;
import de.vodafone.pages.unityMedia.eSIM_activation;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow37 extends SIT_UnityMediaSetup {
   @TmsLink("WFDT-5161")
    @Test (description = "SIT37 - Kay - Check copy credentials functionality for eSIM activation flow" )
    private void gc01() {
        //new Dashboard(driver).isBEWOverlayfound();
        //  new Dashboard(driver).ReloadCurrentPage();

        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).clickOn_KayBurgerMenu();
        new Dashboard(driver).clickOnSIMKarte_KayUser();
        new Dashboard(driver).clickOnignoreNotfMsg();
        new SIM_Karte_Einstellungen(driver).clickOnSIMKarteSO();
        new SIM_Karte_Einstellungen(driver).clickOnSubscriberPIN();
        new eSIM_activation(driver).validatePageContent();
    }
}