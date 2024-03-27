package de.vodafone.tests.unityMedia.SIT;

import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.Tarif_andern;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow22 extends SIT_UnityMediaSetup {
    @TmsLink("WFDT-5146")
    @Test
    @Description("SIT22 - Paul - EECC Contract Summary for changing tariff Callya user")
    private void gc01() {
        //new Dashboard(driver).isBEWOverlayfound();
        //new Dashboard(driver).ReloadCurrentPage();
        new Dashboard(driver).ignoreDashboardNotifications();
        //new Dashboard(driver).clickOnignoreNotfMsg();
        new Dashboard(driver).expandPaulContract();
        new Dashboard(driver).clickOnPaulBurgerMenu();
        new Dashboard(driver).clickOnTarif_option();
        new Dashboard(driver).clickOnMeineTarifAcc();
        new Dashboard(driver).clickOnChangeTariff();
        new Tarif_andern(driver).clickOnWeiterBtn();
        new Tarif_andern(driver).validateCallYaPage();
        new Tarif_andern(driver).validateKostenpflichtinBtnExist();
        new Tarif_andern(driver).validateBackButtonExist();

    }
}

