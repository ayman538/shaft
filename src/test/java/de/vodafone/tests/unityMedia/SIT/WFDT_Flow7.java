package de.vodafone.tests.unityMedia.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.InternetAndPhone;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

@Epic("Unity Media")
@Feature("SIT")
public class WFDT_Flow7 extends SIT_UnityMediaSetup {



    //Test
    @Test
    @Description("SIT07 - Ute - Check Phone Number Listing SO and Accordion content")
    private void gc01() {

        new Dashboard(driver).openAccordion(Dashboard.DashboardInternetandPhoneAccordion.INTERNETANDPHONE)
                .openSmartObject(Dashboard.DashboardInternetAndPhoneSmartObject.EINSTELLUNGEN)
                .openCard(InternetAndPhone.InternetAndPhoneCards.TELEPHONBUCHEINTRAG);

      //Validations of SmartObject Title&Text
        Validations.assertThat().element(driver.getDriver(),InternetAndPhone.TelefonbuchEintragSOTitle)
                .text().isEqualTo(InternetAndPhone.TelefonbuchEintragTitleCL)
                .withCustomReportMessage("Validate SmartObject Title ")
                .perform();
        Validations.assertThat().element(driver.getDriver(),InternetAndPhone.TelefonbuchEintragSOText)
                .text().isEqualTo(InternetAndPhone.TelefonbuchEintragTextCL)
                .withCustomReportMessage("Validate SmartObject Text ")
                .perform();


        //Validations of Accordion Title&Text
        Validations.assertThat().element(driver.getDriver(),InternetAndPhone.TelefonbuchEintragAccTitle)
                .text().isEqualTo(InternetAndPhone.TelefonbuchEintragTitleCL)
                .withCustomReportMessage("Validate Accordion Title ")
                .perform();
        Validations.assertThat().element(driver.getDriver(),InternetAndPhone.TelefonbuchEintragAccText)
                .text().isEqualTo(InternetAndPhone.TelefonbuchEintragTextCL)
                .withCustomReportMessage("Validate Accordion Text ")
                .perform();

        // Acc Content Validations
        new InternetAndPhone(driver).clickOnTelefonbuchEintragAcc();

        Validations.assertThat().element(driver.getDriver(),InternetAndPhone.TelefonbuchEintragAccCol1)
                .text().isEqualTo(InternetAndPhone.TelefonbuchEintragAccCol1CL)
                .withCustomReportMessage("validate TelefonbuchEintrag Column1 Title")
                .perform();
        Validations.assertThat().element(driver.getDriver(),InternetAndPhone.TelefonbuchEintragAccCol2)
                .text().isEqualTo(InternetAndPhone.TelefonbuchEintragAccCol2CL)
                .withCustomReportMessage("validate TelefonbuchEintrag Column2 Title")
                .perform();

        Validations.assertThat().element(driver.getDriver(),InternetAndPhone.TelefonbuchEintragAccSubText)
                .text().isEqualTo(InternetAndPhone.TelefonbuchEintragAccSubTextCL)
                .withCustomReportMessage("validate TelefonbuchEintrag SubText")
                .perform();
       new InternetAndPhone(driver).clickOnTelefonbuchEintragBodyLink();
    }
}