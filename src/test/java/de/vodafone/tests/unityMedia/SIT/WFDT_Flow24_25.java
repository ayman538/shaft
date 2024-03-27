package de.vodafone.tests.unityMedia.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.SIM_Karte_Einstellungen;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow24_25 extends SIT_UnityMediaSetup {


    @Test
    @Description("SIT24 - KAY - Check the improved user experience" +
            " for blocking the 0900s phone numbers in the call")



    private void gc01() {
        new Dashboard(driver).isBEWOverlayfound();
        new Dashboard(driver).ReloadCurrentPage();
        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).clickOnKAY_User_109919273();
        new Dashboard(driver).clickOnBrgrMenuMobilfunk_01622137497();
        new Dashboard(driver).clickOnSIM_KarteAndEinstellungen();
        new SIM_Karte_Einstellungen(driver).clickOnRufnummern_Bereiche();

        Validations.assertThat().element(driver.getDriver(),SIM_Karte_Einstellungen.page_Title).exists();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCHeader)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCHeader_CL)
                .withCustomReportMessage("Verify Header of Rufnummern_Bereiche Accordion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCFooter)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCFooter_CL)
                .withCustomReportMessage("Verify Footer of Rufnummern_Bereiche Accordion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgTitle)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgTitleCL)
                .withCustomReportMessage("Verify Title of info message")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgText)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgTextCL)
                .withCustomReportMessage("Verify Text of info message")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgBtn).isEnabled();
        new SIM_Karte_Einstellungen(driver).clickOnRufnummern_BereicheACC_Info_MsgBtn();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.page_Title).exists();
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.backButton).exists();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.stepperHeader)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.stepperHeader_CL)
                .withCustomReportMessage("Verify Header of Stepper")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.stepperTitle)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.stepperTitle_CL)
                .withCustomReportMessage("Verify Title of Stepper")
                .perform();

        /* block all series's of 0900 numbers from the toggles and confirm */

        new SIM_Karte_Einstellungen(driver).changetoggle1();
        new SIM_Karte_Einstellungen(driver).changetoggle2();
        new SIM_Karte_Einstellungen(driver).changetoggle3();
        new SIM_Karte_Einstellungen(driver).changetoggle4();

        /*Click on confirm Button*/
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.confirmationBtn).isEnabled();
        new SIM_Karte_Einstellungen(driver).clickOnConfirmationBtn();

        new SIM_Karte_Einstellungen(driver).FeedbackMsgFound();

        /* enable all series's of 0900 numbers from the toggles and confirm */
        new SIM_Karte_Einstellungen(driver).changetoggle1();
        new SIM_Karte_Einstellungen(driver).changetoggle2();
        new SIM_Karte_Einstellungen(driver).changetoggle3();
        new SIM_Karte_Einstellungen(driver).changetoggle4();

        /*Click on confirm Button*/
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.confirmationBtn).isEnabled();
        new SIM_Karte_Einstellungen(driver).clickOnConfirmationBtn();

    }





    @Test
    @Description("SIT25 - PAUL - Check the improved user experience" +
            " for blocking the 0900s phone numbers in the call")
    private void gc02() {
        new Dashboard(driver).isBEWOverlayfound();
        new Dashboard(driver).ReloadCurrentPage();
        new Dashboard(driver).ignoreDashboardNotifications();
        new Dashboard(driver).clickOnPaul_User_109919273();
        new Dashboard(driver).clickOnBrgrMenuMobilfunk_015201587421();
        new Dashboard(driver).clickOnSIM_KarteAndEinstellungen_015201587421();
        new SIM_Karte_Einstellungen(driver).clickOnRufnummern_Bereiche();

        Validations.assertThat().element(driver.getDriver(),SIM_Karte_Einstellungen.page_Title).exists();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCHeader)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCHeader_CL)
                .withCustomReportMessage("Verify Header of Rufnummern_Bereiche Accordion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCFooter)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACCFooter_CL)
                .withCustomReportMessage("Verify Footer of Rufnummern_Bereiche Accordion")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgTitle)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgTitleCL)
                .withCustomReportMessage("Verify Title of info message")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgText)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgTextCL)
                .withCustomReportMessage("Verify Text of info message")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.rufnummern_Bereiche_ACC_Info_MsgBtn).isEnabled();
        new SIM_Karte_Einstellungen(driver).clickOnRufnummern_BereicheACC_Info_MsgBtn();

        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.page_Title).exists();
        driver.element().isElementDisplayed(SIM_Karte_Einstellungen.backButton);


        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.stepperHeader)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.stepperHeader_CL)
                .withCustomReportMessage("Verify Header of Stepper")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.stepperTitle)
                .text()
                .isEqualTo(SIM_Karte_Einstellungen.stepperTitle_CL)
                .withCustomReportMessage("Verify Title of Stepper")
                .perform();

        /* block all series's of 0900 numbers from the toggles and confirm */

        new SIM_Karte_Einstellungen(driver).changetoggle1();
        new SIM_Karte_Einstellungen(driver).changetoggle2();
        new SIM_Karte_Einstellungen(driver).changetoggle3();
        new SIM_Karte_Einstellungen(driver).changetoggle4();

        /*Click on confirm Button*/
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.confirmationBtn).isEnabled();
        new SIM_Karte_Einstellungen(driver).clickOnConfirmationBtn();

        new SIM_Karte_Einstellungen(driver).FeedbackMsgFound();

        /* enable all series's of 0900 numbers from the toggles and confirm */
        new SIM_Karte_Einstellungen(driver).changetoggle1();
        new SIM_Karte_Einstellungen(driver).changetoggle2();
        new SIM_Karte_Einstellungen(driver).changetoggle3();
        new SIM_Karte_Einstellungen(driver).changetoggle4();

        /*Click on confirm Button*/
        Validations.assertThat()
                .element(driver.getDriver(), SIM_Karte_Einstellungen.confirmationBtn).isEnabled();
        new SIM_Karte_Einstellungen(driver).clickOnConfirmationBtn();

    } }