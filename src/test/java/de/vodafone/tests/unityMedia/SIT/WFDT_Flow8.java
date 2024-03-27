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
public class WFDT_Flow8 extends SIT_UnityMediaSetup {


    @Test
    @Description("GC08 - Ute - Check Top navigation URLs elements at the header of unity media related pages")
    private void gc01() {


       // new Dashboard(driver).openMeineKundenDatenTile(Dashboard.DashboardSmartObject.meineDaten_Tile);

            new Dashboard(driver).clickOnMeineDaten();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.pageTitle)
                .text().isEqualTo(MeineDaten.meineDatenText)
                .withCustomReportMessage("Validate Page Title Text ")
                .perform();


        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav1Locator)
                .text().isEqualTo(MeineDaten.topNav1CL)
                .withCustomReportMessage("Validate First index in TopNavigation('Meine Rechnungen') ")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav2Locator)
                .text().isEqualTo(MeineDaten.topNav2CL)
                .withCustomReportMessage("Validate 2nd index in TopNavigation('Kabel-TV - Tarif') ")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav3Locator)
                .text().isEqualTo(MeineDaten.topNav3CL)
                .withCustomReportMessage("Validate 3rd index in TopNavigation ('Internet & Phone - Tarif')")
                .perform();



//Navigating to 'Meine Rechnungen'
        new MeineDaten(driver).clickOnTopNav1();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.pageSubTitle)
                .text().isEqualTo(MeineDaten.subTitleCL)
                .withCustomReportMessage("Validate Page sub title text ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.pageTitle)
                .text().isEqualTo(MeineDaten.topNav1CL)
                .withCustomReportMessage("Validate Page Title 'Meine Rechnungen' ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav1Locator)
                .text().isEqualTo(MeineDaten.topNav4CL)
                .withCustomReportMessage("Validate First index in TopNavigation is 'Meine Daten' ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav2Locator)
                .text().isEqualTo(MeineDaten.topNav2CL)
                .withCustomReportMessage("Validate 2nd index in TopNavigation('Kabel-TV - Tarif') ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav3Locator)
                .text().isEqualTo(MeineDaten.topNav3CL)
                .withCustomReportMessage("Validate 3rd index in TopNavigation is 'Internet & Phone - Tarif' ")
                .perform();


        //Navigation to 'Kabel-TV - Tarif'
        new MeineDaten(driver).clickOnTopNav2();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.pageSubTitle)
                .text().isEqualTo(MeineDaten.subTitleCL)
                .withCustomReportMessage("Validate Page sub title text ")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.kabelTVTarif).exists();
        Validations.assertThat().element(driver.getDriver(), Edit_HomezoneAddress.Back_Button).exists();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.pageTitle)
                .text().isEqualTo(MeineDaten.kabelTVTraifTitleCL)
                .withCustomReportMessage("Validate Page Title 'Kabel-TV – Tarif' ").perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav1Locator)
                .text().isEqualTo(MeineDaten.topNav4CL)
                .withCustomReportMessage("Validate First index in TopNavigation ")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav2Locator)
                .text().isEqualTo(MeineDaten.topNav1CL)
                .withCustomReportMessage("Validate 2nd index in TopNavigation ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav3Locator)
                .text().isEqualTo(MeineDaten.topNav3CL)
                .withCustomReportMessage("Validate 3rd index in TopNavigation ")
                .perform();



        //Navigation to ' Internet & Phone – Tarif '
        new MeineDaten(driver).clickOnTopNav3();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.pageSubTitle)
                .text().isEqualTo(MeineDaten.subTitleCL)
                .withCustomReportMessage("Validate Page sub title text ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.pageTitle)
                .text().isEqualTo(MeineDaten.internetAndPhoneTariftitleCL)
                .withCustomReportMessage("Validate Page Title 'Internet & Phone – Tarif' ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav1Locator)
                .text().isEqualTo(MeineDaten.topNav4CL)
                .withCustomReportMessage("Validate First index in TopNavigation 'Meine Daten' ")
                .perform();
        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav2Locator)
                .text().isEqualTo(MeineDaten.topNav1CL)
                .withCustomReportMessage("Validate 2nd index in TopNavigation 'Meine Rechnungen' ")
                .perform();

        Validations.assertThat().element(driver.getDriver(), MeineDaten.topNav3Locator)
                .text().isEqualTo(MeineDaten.topNav2CL)
                .withCustomReportMessage("Validate 3rd index in TopNavigation 'Kabel-TV - Tarif ' ")
                .perform();




    }
}

