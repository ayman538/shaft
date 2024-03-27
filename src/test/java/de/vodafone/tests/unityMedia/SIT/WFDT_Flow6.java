package de.vodafone.tests.unityMedia.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.MeineDaten;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow6 extends SIT_UnityMediaSetup {


    @Test
    @Description("ST06 - Suspended Ute - Check Notification message")
    private void gc01() {
        new Dashboard(driver);
        Validations.assertThat().element(driver.getDriver(),Dashboard.suspendedMsgTitle)
                .text().isEqualTo(Dashboard.suspendedMsgTitleCL)
                .withCustomReportMessage("Validate suspended message title ")
                .perform();
        Validations.assertThat().element(driver.getDriver(),Dashboard.suspendedMsgText)
                .text().isEqualTo(Dashboard.suspendedMsgTextCL)
                .withCustomReportMessage("Validate suspended message text ")
                .perform();
        Validations.assertThat().element(driver.getDriver(),Dashboard.aktuelleRechnungTile_Title)
                .text().isEqualTo(Dashboard.aktuelleRechnungTile_TitleCL)
                .withCustomReportMessage("Validate AktuelleRechnungTile SO ")
                .perform();
        Validations.assertThat().element(driver.getDriver(),Dashboard.meineRechnungenTile_Title)
                .text().isEqualTo(Dashboard.meineRechnungenTile_TitleCL)
                .withCustomReportMessage("Validate MeineRechnungenTile SO")
                .perform();
        Validations.assertThat().element(driver.getDriver(),Dashboard.meineProdukte)
                .text().isEqualTo(Dashboard.meineProdukteCL)
                .withCustomReportMessage("Validate MeineProdukte section Header")
                .perform();


        Validations.assertThat().element(driver.getDriver(),Dashboard.internetandPhoneBurgerMenu).exists();
        new Dashboard(driver).ClickOnInternetandPhoneBurgerMenu();
       // new Dashboard(driver).ClickOnInternetandPhone_GeräteandEinstellungen();


        /*navigate to MeineDaten and check Adressen Accordion content*/
        new Dashboard(driver).clickOnMeineDaten();
        new MeineDaten(driver).clickOnAdressenAcc();


        Validations.assertThat().element(driver.getDriver(),MeineDaten.adressenAcc_Title)
                .text().isEqualTo(MeineDaten.adressenAccTitleCL)
                .withCustomReportMessage("Validate Adressen accordion title")
                .perform();

        Validations.assertThat().element(driver.getDriver(),MeineDaten.adressenAcc_Text)
                .text().isEqualTo(MeineDaten.adressenAccTextCL)
                .withCustomReportMessage("Validate Adressen accordion text")
                .perform();


        Validations.assertThat().element(driver.getDriver(),MeineDaten.suspendedMsg_Billing_Address_Title)
                .text().isEqualTo(MeineDaten.suspendedMsg_Billing_Address_TitleCL)
                .withCustomReportMessage("Validate Suspended message Title of Billing Address Section")
                .perform();

        Validations.assertThat().element(driver.getDriver(),MeineDaten.suspendedMsg_Billing_Address_Text)
                .text().isEqualTo(MeineDaten.suspendedMsg_Billing_Address_TextCL)
                .withCustomReportMessage("Validate Suspended message text of Billing Address Section")
                .perform();


        Validations.assertThat().element(driver.getDriver(),MeineDaten.suspendedMsg_Service_Address_Title)
                .text().isEqualTo(MeineDaten.suspendedMsg_Service_Address_TitleCL)
                .withCustomReportMessage("Validate Suspended message Title of Service Address Section")
                .perform();

        Validations.assertThat().element(driver.getDriver(),MeineDaten.suspendedMsg_Service_Address_Text)
                .text().isEqualTo(MeineDaten.suspendedMsg_Service_Address_TextCL)
                .withCustomReportMessage("Validate Suspended message text of Service Address Section")
                .perform();


        new MeineDaten(driver).clickOnRechnungLinkout();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.headerRechnungen)
                .text().isEqualTo(MeineDaten.headerCL)
                .withCustomReportMessage("Validate Page sub title text ")

                .perform();        Validations.assertThat().element(driver.getDriver(),MeineDaten.pageTitle)
                .text().isEqualTo(MeineDaten.topNav1CL)
                .withCustomReportMessage("Validate Page Title is Meine Rechnungen")
                .perform();



    }
}
