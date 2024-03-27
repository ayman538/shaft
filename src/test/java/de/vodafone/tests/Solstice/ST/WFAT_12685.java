package de.vodafone.tests.Solstice.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.ChangeUsernameConfirmation;
import de.vodafone.pages.Solstice.ChangeUsernameStep1;
import de.vodafone.pages.Solstice.ChangeUsernameStep2;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12685")
public class WFAT_12685 extends SolsticeSTSetup {

    @TmsLink("WFAT-12790")
    @Test(description = "WFAT-12790 Solstice User completes transaction when both checkboxes are selected and updated successfully")
    private void GC01() throws InterruptedException {
        new SolsticeDashboard(driver)//.closeEmailNotification()
                .chooseLoginDatenFromMeinKonto().changeUsername();

        changeUsernameStep1PageClAssertions();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep1.SubmitButton).isDisabled();

        new ChangeUsernameStep1(driver).typeUsername().typeCaptcha();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep1.SubmitButton).isEnabled();

        new ChangeUsernameStep1(driver).selectCheckbox1().selectCheckbox2();

        new ChangeUsernameStep1(driver).submit();

        changeUsernameStep2PageClAssertions();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep2.SubmitTanCodeButton).isDisabled();

        new ChangeUsernameStep2(driver).typeTanCode();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep2.SubmitTanCodeButton).isEnabled();

        new ChangeUsernameStep2(driver).submitTanCode();

        changeUsernameConfirmationPageClAssertions();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfNotText)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfNotTextCL)
                .withCustomReportMessage("Check Success Notification Text")
                .perform();

        //Reset password section assertion
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfSummaryRP)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfSummaryRPCL)
                .withCustomReportMessage("Check Reset Password CL")
                .perform();

        //Billing notification section assertion
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfSummaryBN)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfSummaryBNCL)
                .withCustomReportMessage("Check Billing Notification CL")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.BackButton)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.BackButtonCL)
                .withCustomReportMessage("Check Back Button CL")
                .perform();

        new ChangeUsernameConfirmation(driver).clickBackButton();

        Validations.assertThat()
                .element(driver.getDriver(), By.xpath("//*[@automation-id='manageAccountData_acc']")).text().contains("Login-Daten").withCustomReportMessage("Check Back Button redirection").perform();
    }

    @TmsLink("WFAT-12791")
    @Test(description = "WFAT-12791 Solstice User completes transaction when billing checkbox is selected but not updated successfully")
    private void GC02() {
        new SolsticeDashboard(driver)//.closeEmailNotification()
                .chooseLoginDatenFromMeinKonto().changeUsername();

        changeUsernameStep1PageClAssertions();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep1.SubmitButton).isDisabled().perform();

        new ChangeUsernameStep1(driver).typeUsername().typeCaptcha().selectCheckbox2();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep1.SubmitButton).isEnabled().perform();

        new ChangeUsernameStep1(driver).submit();

        changeUsernameStep2PageClAssertions();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep2.SubmitTanCodeButton).isDisabled().perform();

        new ChangeUsernameStep2(driver).typeTanCode();

        Validations.assertThat().element(driver.getDriver(), ChangeUsernameStep2.SubmitTanCodeButton).isEnabled().perform();

        new ChangeUsernameStep2(driver).submitTanCode();

        changeUsernameConfirmationPageClAssertions();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfNotText)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfNotTextCL2)
                .withCustomReportMessage("Check Success Notification Text")
                .perform();

        Validations.assertThat()
               .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfSummaryBN)
               .text()
               .isEqualTo(ChangeUsernameConfirmation.CUConfSummaryBNCL)
               .withCustomReportMessage("Check Billing Notification CL")
               .perform();

        Validations.assertThat()
               .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfSummaryBNValue)
               .text()
               .isEqualTo(ChangeUsernameConfirmation.CUConfSummaryNoUpdateCL)
               .withCustomReportMessage("Check Billing Notification Error CL")
               .perform();
    }

    private void changeUsernameStep1PageClAssertions(){
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1PageHeadline)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1PageHeadlineCL)
                .withCustomReportMessage("Check Page Headline")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1Header)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1HeaderCL)
                .withCustomReportMessage("Check Step 1 header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep2Header)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep2HeaderCL)
                .withCustomReportMessage("Check Step 2 header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1Text)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1TextCL)
                .withCustomReportMessage("Check Text 1 in step 1")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1ExistingUN)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1ExistingUNCL)
                .withCustomReportMessage("Check Existing Username Header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1InputFieldHeader)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1InputFieldHeaderCL)
                .withCustomReportMessage("Check Username input field title")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1Text2)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1Text2CL)
                .withCustomReportMessage("Check Text 2 in step 1")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1CaptchaHeader)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1CaptchaHeaderCL)
                .withCustomReportMessage("Check Captcha header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1Checkbox1)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1Checkbox1CL)
                .withCustomReportMessage("Check Step1 Checkbox1 CL")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.CUStep1Checkbox2)
                .text()
                .isEqualTo(ChangeUsernameStep1.CUStep1Checkbox2CL)
                .withCustomReportMessage("Check Step1 Checkbox2 CL")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.Pflichtfelder)
                .text()
                .isEqualTo(ChangeUsernameStep1.PflichtfelderCL)
                .withCustomReportMessage("Check Pflichtfelder Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep1.SubmitButton)
                .text()
                .isEqualTo(ChangeUsernameStep1.SubmitButtonCL)
                .withCustomReportMessage("Check Submit Button Text")
                .perform();


    }
    private void changeUsernameStep2PageClAssertions(){
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.CUStep2PageHeadline)
                .text()
                .isEqualTo(ChangeUsernameStep2.CUStep2PageHeadlineCL)
                .withCustomReportMessage("Check Page Headline")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.CUStep1Header)
                .text()
                .isEqualTo(ChangeUsernameStep2.CUStep1HeaderCL)
                .withCustomReportMessage("Check Step 1 header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.CUStep2Header)
                .text()
                .isEqualTo(ChangeUsernameStep2.CUStep2HeaderCL)
                .withCustomReportMessage("Check Step 2 header")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.CUStep2NotHeadline)
                .text()
                .isEqualTo(ChangeUsernameStep2.CUStep2NotHeadlineCL)
                .withCustomReportMessage("Check Step 2 Notification Headline")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.CUStep2NotText)
                .text()
                .isEqualTo(ChangeUsernameStep2.CUStep2NotTextCL)
                .withCustomReportMessage("Check Step 2 Notification Text")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.CUStep2TextBoxTitle)
                .text()
                .isEqualTo(ChangeUsernameStep2.CUStep2TextBoxTitleCL)
                .withCustomReportMessage("Check Textbox Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.ResendTanCodeEmailButton)
                .text()
                .isEqualTo(ChangeUsernameStep2.ResendTanCodeEmailButtonCL)
                .withCustomReportMessage("Check Resend Tan Code Email Button CL")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.SubmitTanCodeButton)
                .text()
                .isEqualTo(ChangeUsernameStep2.SubmitTanCodeButtonCL)
                .withCustomReportMessage("Check Submit Tan Code Button CL")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.CUStep2NotText)
                .text()
                .isEqualTo(ChangeUsernameStep2.CUStep2NotTextCL)
                .withCustomReportMessage("Check Step 2 Notification Text")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameStep2.Pflichtfelder)
                .text()
                .isEqualTo(ChangeUsernameStep2.PflichtfelderCL)
                .withCustomReportMessage("Check Pflichtfelder Text")
                .perform();


    }
    private void changeUsernameConfirmationPageClAssertions(){
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfSummaryUN)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfSummaryUNCL)
                .withCustomReportMessage("Check Username CL")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfPageHeadline)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfPageHeadlineCL)
                .withCustomReportMessage("Check Page Headline")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfNotHeadline)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfNotHeadlineCL)
                .withCustomReportMessage("Check Success Notification Headline")
                .perform();



        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfSummaryHeader)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfSummaryHeaderCL)
                .withCustomReportMessage("Check Summary Section Header")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ChangeUsernameConfirmation.CUConfSummaryHeadline)
                .text()
                .isEqualTo(ChangeUsernameConfirmation.CUConfSummaryHeadlineCL)
                .withCustomReportMessage("Check Summary Section Title")
                .perform();


    }

}
