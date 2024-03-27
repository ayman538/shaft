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
public class WFDT_Flow27 extends SIT_UnityMediaSetup {
    @Test
    @Description("SIT27 - Kay - Check notification message at confirmation step," +
            " when user has Homezone address and changes, add, delete subscriber address")

    private void gc01() {
        new Dashboard(driver).isBEWOverlayfound();
        new Dashboard(driver).ReloadCurrentPage();
        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).clickOnKAY_User_109919277();
        new Dashboard(driver).clickOnMeineDaten_109919277();
        new MeineDaten(driver).clickOnAddressenSO();
        new MeineDaten(driver).clickOnEditAdressenButton();
        new MeineDaten(driver).clickOnChangeAdressButton();
        Validations.assertThat()
                .element(driver.getDriver(), MeineDaten.secondEditButton).isEnabled();
        new MeineDaten(driver).clickOnSecondEditButton();
        /*Edit Vorname Field*/
        new MeineDaten(driver).deletevornametextbox(MeineDaten.teilnehmer_Adresse_vorname);
        new MeineDaten(driver).Editvorname(MeineDaten.editvorName);
        new MeineDaten(driver).clickOnSubmitButton();
        /*validate that third step -Daten überprüfen- accordion is expanded*/
        Validations.assertThat().
                element(driver.getDriver(), MeineDaten.confirmationStepTwo).exists();
        /*click on Speichern Button*/
        new MeineDaten(driver).clickOnConfirmationButton();

        Validations.assertThat()
                .element(driver.getDriver(), MeineDaten.success_Message)
                .text()
                .isEqualTo(MeineDaten.success_MessageCL)
                .withCustomReportMessage("Verify Header of Success Message")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), MeineDaten.informative_Message)
                .text()
                .isEqualTo(MeineDaten.informative_MessageCL)
                .withCustomReportMessage("Verify Header of Informative Message")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), MeineDaten.confirmEditButton)
                .text()
                .isEqualTo(MeineDaten.confirmEditButtonCL)
                .withCustomReportMessage("Verify confirm edit button text")
                .perform();

    }


    }