package de.vodafone.tests.unityMedia.SIT;
import com.shaft.validation.Validations;
import de.vodafone.pages.unityMedia.Bankverbindung_bearbeiten;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.MeineDaten;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow3 extends SIT_UnityMediaSetup {


    @Test
    @Description("SIT03 - Ute - Check Bank Account Details (Direct Debit Details)")
    private void gc01() {
        // new Dashboard(driver).isBEWOverlayfound();
        //  new Dashboard(driver).ReloadCurrentPage();
        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).clickOnUte_contract_341449201();
        new Dashboard(driver).clickOnMeineDaten_341449201();
        new MeineDaten(driver).clickOnBankDetailsSO();
        Validations.assertThat()
                .element(driver.getDriver(), MeineDaten.bank_DetailsSO_Header)
                .text()
                .isEqualTo(MeineDaten.bank_DetailsSO_HeaderCL)
                .withCustomReportMessage("Verify bank details SO Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MeineDaten.bank_DetailsSO_Footer)
                .text()
                .isEqualTo(MeineDaten.bankDetailsSOAccDescriptionCL)
                .withCustomReportMessage("Verify bank details SO Footer")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.ownerName_field).exists();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.iban_field).exists();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.btc_Field).exists();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.bankName_field).exists();
        new MeineDaten(driver).clickOnEditBankDetails_Btn();

        Validations.assertThat()
                .element(driver.getDriver(), Bankverbindung_bearbeiten.pageSubTitle)
                .text()
                .isEqualTo(Bankverbindung_bearbeiten.pageSubTitleCL)
                .withCustomReportMessage("Verify Page title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Bankverbindung_bearbeiten.PageTitle)
                .text()
                .isEqualTo(Bankverbindung_bearbeiten.pageTitleCL)
                .withCustomReportMessage("Verify Page Sub title")
                .perform();
        Validations.assertThat().element(driver.getDriver(), Bankverbindung_bearbeiten.ownerName_field).isDisabled();
        new Bankverbindung_bearbeiten(driver).editIBAN(Bankverbindung_bearbeiten.new_IBAN);
        new Bankverbindung_bearbeiten(driver).clickOnContinueBtn();
        new Bankverbindung_bearbeiten(driver).clickOnCheckBox();
        new Bankverbindung_bearbeiten(driver).clickOnSaveBtn();
        Validations.assertThat()
                .element(driver.getDriver(), Bankverbindung_bearbeiten.notificationMsg_Title)
                .text()
                .isEqualTo(Bankverbindung_bearbeiten.notificationMsg_TitleCL)
                .withCustomReportMessage("Verify Notification Msg's title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Bankverbindung_bearbeiten.notificationMsg_Text)
                .text()
                .isEqualTo(Bankverbindung_bearbeiten.notificationMsg_textCL)
                .withCustomReportMessage("Verify Notification Msg's text")
                .perform();


    }
}