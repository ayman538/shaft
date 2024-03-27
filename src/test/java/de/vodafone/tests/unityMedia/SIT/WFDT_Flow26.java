package de.vodafone.tests.unityMedia.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.Edit_HomezoneAddress;
import de.vodafone.pages.unityMedia.MeineDaten;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow26 extends SIT_UnityMediaSetup {
    @Test
    @Description("SIT26 - Kay - Check Fuzzy logic incase updating Home Zone Address" +
            " with Invalid Address ")

    private void gc01() {


        new Dashboard(driver).isBEWOverlayfound();
        new Dashboard(driver).ReloadCurrentPage();
        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).clickOnKAY_User_109919277();
        new Dashboard(driver).clickOnMeineDaten_109919277();
        new MeineDaten(driver).clickOnAddressenSO();
        Validations.assertThat().element(driver.getDriver(),MeineDaten.homezoneAddressSectionTitle).exists();
        Validations.assertThat().element(driver.getDriver(),MeineDaten.homezoneAddressSectionHeader).exists();
        Validations.assertThat().element(driver.getDriver(),MeineDaten.homezoneAddress_Telfon).exists();
        Validations.assertThat().element(driver.getDriver(),MeineDaten.homezoneAddressText).exists();


        Validations.assertThat().element(driver.getDriver(),MeineDaten.homezoneAddressSection_EditButton).isEnabled();
        new MeineDaten(driver).clickOnHomezoneAddress_EditButton();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.Edit_HomeZoneAddress_page_Header)
                .text()
                .isEqualTo(Edit_HomezoneAddress.Edit_HomeZoneAddress_page_HeaderCL)
                .withCustomReportMessage("Verify Header of Edit-Homezone-Address Page")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.Edit_HomeZoneAddress_page_title)
                .text()
                .isEqualTo(Edit_HomezoneAddress.Edit_HomeZoneAddress_page_titleCL)
                .withCustomReportMessage("Verify title of Edit-Homezone-Address Page")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.FirstAccordion_Title)
                .text()
                .isEqualTo(Edit_HomezoneAddress.FirstAccordion_TitleCL)
                .withCustomReportMessage("Verify first acc text ")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.SecondAccordion_Title)
                .text()
                .isEqualTo(Edit_HomezoneAddress.SecondAccordion_TitleCL)
                .withCustomReportMessage("Verify 2nd acc text ")
                .perform();

        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.Back_Button).exists();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.FirstBox_Straße_Street).exists();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.SecondBox_Hausnummer_HouseNumber).exists();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.ThirddBox_PLZ_PostalCode).exists();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.FourthdBox_Ort_Location).exists();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.Fifth_Land_Country).exists();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.Continue_Weiter_Button).isEnabled();
        new Edit_HomezoneAddress(driver).deleteStreetBox(Edit_HomezoneAddress.FirstBox_Straße_Street);
        new Edit_HomezoneAddress(driver).EditStreetBox(Edit_HomezoneAddress.EditedStreet);

        new Edit_HomezoneAddress(driver).deleteCountryBox(Edit_HomezoneAddress.FourthdBox_Ort_Location);
        new Edit_HomezoneAddress(driver).EditCountrytBox(Edit_HomezoneAddress.EditedCountry);

        new Edit_HomezoneAddress(driver).clickOnContinueButton();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.ErrorMsg_Title)
                .text()
                .isEqualTo(Edit_HomezoneAddress.ErrorMsg_TitleCL)
                .withCustomReportMessage("Verify Error Msg Title")
                .perform();

        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.ErrorMsg_Text).exists();

        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.ErrorMsg_Button)
                .text()
                .isEqualTo(Edit_HomezoneAddress.ErrorMsg_ButtonCL)
                .withCustomReportMessage("Verify Error Msg Button")
                .perform();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.ErrorMsg_Button).isEnabled();

        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.SuggestedAddressTitle)
                .text()
                .isEqualTo(Edit_HomezoneAddress.SuggestedAddressTitleCL)
                .withCustomReportMessage("Verify Suggested Address Title")
                .perform();

        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.SuggestedAddressBtn).isEnabled();

        new Edit_HomezoneAddress(driver).clickOnEditAddressButton();
        new Edit_HomezoneAddress(driver).deleteStreetBox(Edit_HomezoneAddress.FirstBox_Straße_Street);
        new Edit_HomezoneAddress(driver).EditStreetBox(Edit_HomezoneAddress.EditedStreet2);

        new Edit_HomezoneAddress(driver).deleteCountryBox(Edit_HomezoneAddress.FourthdBox_Ort_Location);
        new Edit_HomezoneAddress(driver).EditCountrytBox(Edit_HomezoneAddress.EditedCountry2);
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.SuggestedAddressBtn).isEnabled();
        new Edit_HomezoneAddress(driver).clickOnEditAddressButton2();


        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.SuggestedAddressBtn).isEnabled();


        new Edit_HomezoneAddress(driver).clickOnSuggestedAddressButton();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.ConfirmationAcc_Title)
                .text()
                .isEqualTo(Edit_HomezoneAddress.ConfirmationAcc_TitleCL)
                .withCustomReportMessage("Verify Confirmation ACC Title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.ConfirmationAcc_Button)
                .text()
                .isEqualTo(Edit_HomezoneAddress.ConfirmationAcc_ButtonCL)
                .withCustomReportMessage("Verify Confirmation ACC Button")
                .perform();
        Validations.assertThat().element(driver.getDriver(),Edit_HomezoneAddress.ConfirmationAcc_Button).isEnabled();

        new Edit_HomezoneAddress(driver).clickOnConfirmationAccButton();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.PagesubTitle)
                .text()
                .isEqualTo(Edit_HomezoneAddress.PagesubTitlCL)
                .withCustomReportMessage("Verify Confirmation Page Title")
                .perform();
       /* Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.PageTitle)
                .text()
                .isEqualTo(Edit_HomezoneAddress.PageTitlCL)
                .withCustomReportMessage("Verify Confirmation Page Title")
                .perform();*/
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.Back_button)
                .text()
                .isEqualTo(Edit_HomezoneAddress.Back_buttonCL)
                .withCustomReportMessage("Verify back Button")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), Edit_HomezoneAddress.ConfirmationMsgText)
                .text()
                .isEqualTo(Edit_HomezoneAddress.ConfirmationMsgTextCL)
                .withCustomReportMessage("Verify Confirmation message ")
                .perform();







    }
}
