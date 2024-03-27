
package de.vodafone.tests.unityMedia;

import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.KabelTV;
import de.vodafone.pages.unityMedia.SmartcardAktivieren;
import de.vodafone.tests.unityMedia.ST.ST_UnityMediaSetup;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("Unity Media")
public class WFDT_Flow10 extends ST_UnityMediaSetup {
   @TmsLink("WFDT-5126")
    @Test
    @Description("SIT10 - Ute - Check TV Smart Cards Activation ")
    private void gc01() {
        new Dashboard(driver).openAccordion(Dashboard.DashboardKabelTVAccordion.DASHBOARD_KABEL_TV_ACCORDION);
        new Dashboard(driver).validateSmartCardActivationSO();
        new Dashboard(driver).openSmartObject(Dashboard.DashboardKabelTVSmartObject.CardAktivieren);
        new Dashboard(driver).validateCardActivationSOandACC();
        new KabelTV(driver).clickOnSmartcardaktivierenCTA();
        new SmartcardAktivieren(driver).validatePageTitle();
        new SmartcardAktivieren(driver).validateSmartAktivationBtnIsDisabled();
        new SmartcardAktivieren(driver).clickOnSmartcardAktivierenAccButton();
        new SmartcardAktivieren(driver).validateCnofirmMsg();
        //Step13,Go-Back and Try Again within 30 minutes
        new SmartcardAktivieren(driver).clickOnGoBackButton();
        new Dashboard(driver).openSmartObject(Dashboard.DashboardKabelTVSmartObject.CardAktivieren);
        new KabelTV(driver).clickOnSmartcardaktivierenCTA();
        //successful activation within the last 30 minutes
        new SmartcardAktivieren(driver).validateConfirmationMsgContent();
       }
    }
