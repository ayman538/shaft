package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EditNotificationSettings {
    private SHAFT.GUI.WebDriver driver;

    public EditNotificationSettings(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    // Locators
    private By pageTitle_Locator = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    private By notificationAccTitle_Locator = By.xpath("//*[@automation-id='Header_tv']");
    private By emailSectionTitle_Locator = By.xpath("//*[@automation-id='emailHeadline_tv']");
    private By emailSectionDescription_Locator = By.xpath("//*[@automation-id='emailDescription_tv']");
    private By emailSectionNotificationTitle_Locator = By.xpath("//*[@automation-id='emailNotiification_tv']//h4");
    private By emailSectionNotificationDescription_Locator = By.xpath("//*[@automation-id='emailNotiification_tv']//p");
    private By emailSectionNotification_Locator = By.xpath("//*[@automation-id='emailNotiification_tv']");
    private By emailNotificationToggleBtn_Locator = By.xpath("//*[@automation-id='emailCheck_tv']//label");
    private By emailNotificationToggleBtnDiv_Locator = By.xpath("(//*[@automation-id='emailCheck_tv']/div)[1]");
    private By smsSectionTitle_Locator = By.xpath("//*[@automation-id='smsHeadline_tv']");
    private By smsSectionDescription_Locator = By.xpath("//*[@automation-id='smsDescription_tv']");
    private By numbersDropDown_Locator = By.xpath("//*[@automation-id='dropDownList_tv']");
    private By smsErrorNotificationTitle_Locator = By.xpath("//*[@class='alert noselect error mt-10 mb-0']//h4");
    private By smsErrorNotificationDescription_Locator = By.xpath("//*[@class='alert noselect error mt-10 mb-0']//p");
    private By smsMore20NumbersNotification_Locator = By.xpath("//*[@id='notification_confirmation']");
    private By smsNotificationToggleBtn_Locator = By.xpath("//*[@automation-id='smsCheck_tv']//label");
    private By smsNotificationToggleBtnDiv_Locator = By.xpath("//*[@automation-id='smsCheck_tv']");
    private By successConfirmationNotificationTitle_Locator = By.xpath("//*[@id='notification_confirmation']//h4");
    private By successConfirmationNotificationDescription_Locator = By.xpath("//*[@id='notification_confirmation']//p");
    private By emailStatusLabel_Locator = By.xpath("(//*[@automation-id='summaryTitle_tv'])[1]");
    private By smsStatusLabel_Locator = By.xpath("(//*[@automation-id='summaryTitle_tv'])[2]");
    private By numberStatusLabel_Locator = By.xpath("(//*[@automation-id='summaryTitle_tv'])[3]");
    private By emailStatusValue_Locator = By.xpath("(//*[@automation-id='summarySubTitle_tv'])[1]");
    private By smsStatusValue_Locator = By.xpath("(//*[@automation-id='summarySubTitle_tv'])[2]");
    private By numberStatusValue_Locator = By.xpath("(//*[@automation-id='summarySubTitle_tv'])[3]");
    private By errorConfirmationNotificationTitle_Locator = By.xpath("//*[@class='alert noselect error mb-24']//h4");
    private By errorConfirmationNotificationDescription_Locator = By.xpath("//*[@class='alert noselect error mb-24']//p");
    private By confirmButton_Locator = By.xpath("//*[@automation-id='confirmBtn_btn']");
    private By checkBox_Locator = By.xpath("//input[@automation-id='checkboxItemModel.id_tv']");
    private By pdfField_Locator = By.xpath("//div[@class='flex-wrap socs mt-15']/div[@automation-id='summaryTitle_tv']");
    private By pdfFieldValue_Locator = By.xpath("//div[@class='flex-wrap socs mt-15']/div[@automation-id='summarySubTitle_tv']");

    // CLs
    private String pageTitle_CL = "Benachrichtigung bearbeiten";
    private String notificationAccTitle_CL = "Benachrichtigung ändern";
    private String emailSectionTitle_CL = "E-Mail-Benachrichtigung";
    private String emailSectionDescription_CL = "Du bekommst Deine monatliche Rechnungsbenachrichtigung per E-Mail zugeschickt.";
    private String smsSectionTitle_CL = "SMS-Benachrichtigung";
    private String smsSectionDescription_CL = "Du bekommst Deine monatliche Rechnungsbenachrichtigung per SMS zugeschickt.";
    private String smsErrorNotificationTitle_CL = "Das hat leider nicht geklappt";
    private String smsErrorNotificationDescription_CL = "Du kannst grad nicht Deine Telefonnummer wechseln. Versuch es bitte später nochmal.";
    private String smsMore20NumbersNotification_CL = "Du hast mehr als 20 Teilnehmer-Rufnummern. Leider können wir Dir hier maximal 20 Deiner Rufnummern zur Auswahl anzeigen.";
    private String successConfirmationNotificationTitle_CL = "Vielen Dank!";
    private String successConfirmationNotificationDescription_CL = "Wir haben Deine Änderungen gespeichert. Es kann einen Augenblick dauern, bis alles vollständig aktiviert ist und Du per E-Mail benachrichtigt wirst oder bis es vollständig deaktiviert ist.";
    private String emailStatusLabel_CL = "E-Mail-Benachrichtigung";
    private String smsStatusLabel_CL = "SMS-Benachrichtigung";
    private String numberStatusLabel_CL = "Telefonnummer";
    private String errorConfirmationNotificationTitle_CL = "Das hat leider nicht geklappt";
    private String errorConfirmationNotificationDescription_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private String emailSectionNotificationTitle_CL = "Gut zu wissen";
    private String emailSectionNotificationDescription_CL = "Deine E-Mail-Benachrichtigung muss aktiviert sein, da du deine Rechnung online bekommst.";
    private String pdfNotificationStatusField_CL = "PDF-Rechnung per E-Mail";

    // Methods

    @Step("Uncheck The Checkbox")
    public EditNotificationSettings unCheckTheCheckbox(){
        driver.element().click(checkBox_Locator);
        return this;
    }

    @Step("Check On Checkbox")
    public EditNotificationSettings checkTheCheckbox(){
        driver.element().click(checkBox_Locator);
        return this;
    }


    @Step("click confirm button")
    public EditNotificationSettings clickOnConfirmBtn(){
        driver.element().click(confirmButton_Locator);
        return this;
    }
    @Step("click on email notification toggle button")
    public EditNotificationSettings clickOnEmailNotificationToggleBtn(){
        driver.element().click(emailNotificationToggleBtn_Locator);
        return this;
    }
    @Step("Select number from the drop down menu")
    public EditNotificationSettings selectNumberFromDropDown(String number){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(30));
        wait.until(ExpectedConditions.attributeToBe(numbersDropDown_Locator,"class","fm-select fm-required custom-dropdown mt-10"));
        driver.element().click(numbersDropDown_Locator);
        driver.element().click(By.xpath("(//option[contains(.,'"+number+"')])[1]"));
        return this;
    }
    @Step("click on SMS notification toggle button")
    public EditNotificationSettings clickOnSmsNotificationToggleBtn(){
        driver.element().click(smsNotificationToggleBtn_Locator);
        return this;
    }

    // Assertions

    public EditNotificationSettings assertThatPdfClAndChecboxDoesNotExist(){
        driver.verifyThat().element(checkBox_Locator).doesNotExist()
                .withCustomReportMessage("Assert That PDF CL And  Checkbox Does not Exist")
                .perform();
        return this;
    }

    public EditNotificationSettings assertOnPdfFieldStatusValueAndCl(String pdfStatusValue){
        driver.verifyThat().element(pdfFieldValue_Locator).textTrimmed()
                .isEqualTo(pdfStatusValue)
                .withCustomReportMessage("assert On PDF Field Status Value")
                .perform();
        driver.verifyThat().element(pdfField_Locator).exists()
                .withCustomReportMessage("assert On PDF Field Existance")
                .perform();
        return this;
    }


    public EditNotificationSettings assertOnPageTitle(){
        driver.verifyThat().element(pageTitle_Locator).textTrimmed().isEqualTo(pageTitle_CL).withCustomReportMessage("assert on the page title").perform();
        return this;
    }

    public EditNotificationSettings assertOnAccordionTitle(){
        driver.verifyThat().element(notificationAccTitle_Locator).textTrimmed().isEqualTo(notificationAccTitle_CL).withCustomReportMessage("assert on the accordion title").perform();
        return this;
    }

    public EditNotificationSettings assertOnEmailSectionTitle(){
        driver.verifyThat().element(emailSectionTitle_Locator).text().contains(emailSectionTitle_CL).withCustomReportMessage("assert on the email section title").perform();
        return this;
    }


    public EditNotificationSettings assertOnEmailSectionDescription(){
        driver.verifyThat().element(emailSectionDescription_Locator).textTrimmed().isEqualTo(emailSectionDescription_CL).withCustomReportMessage("assert on the email section Description").perform();
        return this;
    }

    public EditNotificationSettings assertOnEmailSectionNotification(){
        driver.verifyThat().element(emailSectionNotificationTitle_Locator).textTrimmed().isEqualTo(emailSectionNotificationTitle_CL).withCustomReportMessage("assert on the email section notification title").perform();

        driver.verifyThat().element(emailSectionNotificationDescription_Locator).textTrimmed().isEqualTo(emailSectionNotificationDescription_CL).withCustomReportMessage("assert on the email section notification Description").perform();

        return this;
    }

    public EditNotificationSettings assertThatEmailSectionNotificationNotDisplayed(){
        driver.verifyThat().element(emailSectionNotification_Locator).doesNotExist().withCustomReportMessage("assert that email section notification is not displayed").perform();
        return this;
    }

    public EditNotificationSettings assertThatEmailNotificationToggleBtnNotActive(){
        driver.verifyThat().element(emailNotificationToggleBtnDiv_Locator).attribute("class").contains("Disabled").withCustomReportMessage("assert that email section notification toggle button is disabled ").perform();
        return this;
    }

    public EditNotificationSettings assertOnSmsSectionTitle(){
        driver.verifyThat().element(smsSectionTitle_Locator).textTrimmed().isEqualTo(smsSectionTitle_CL).withCustomReportMessage("assert on sms section title").perform();
        return this;
    }

    public EditNotificationSettings assertOnSmsSectionDescription(){
        driver.verifyThat().element(smsSectionDescription_Locator).textTrimmed().isEqualTo(smsSectionDescription_CL).withCustomReportMessage("assert on sms section Description").perform();
        return this;
    }


    public EditNotificationSettings assertThatDropDownNotDisplayed(){
        driver.verifyThat().element(numbersDropDown_Locator).attribute("class").contains("displayNone").withCustomReportMessage("assert that dropdown not exist").perform();
        return this;
    }

    public EditNotificationSettings assertThatDropDownIsDisabled(){
        driver.verifyThat().element(numbersDropDown_Locator).cssProperty("disabled").isEqualTo("").withCustomReportMessage("assert that dropdown is disabled").perform();
        return this;
    }

    public EditNotificationSettings assertOnSmsErrorNotification(){
        driver.verifyThat().element(smsErrorNotificationTitle_Locator).textTrimmed().isEqualTo(smsErrorNotificationTitle_CL).withCustomReportMessage("assert on sms error notification title").perform();
        driver.verifyThat().element(smsErrorNotificationDescription_Locator).textTrimmed().isEqualTo(smsErrorNotificationDescription_CL).withCustomReportMessage("assert on sms error notification description").perform();
        return this;
    }


    public EditNotificationSettings assertThat20NumbersNotificationNotDisplayed(){
        driver.verifyThat().element(smsMore20NumbersNotification_Locator).doesNotExist().withCustomReportMessage("assert that 20 numbers notification does not exist").perform();
        return this;
    }

    public EditNotificationSettings assertThatSmsNotificationToggleBtnNotActive(){
        driver.verifyThat().element(smsNotificationToggleBtnDiv_Locator).attribute("class").contains("dimmed").withCustomReportMessage("assert that SMS section notification toggle button is disabled ").perform();
        return this;
    }
    public EditNotificationSettings assertThatSmsNotificationToggleBtnIsActive(){
        driver.verifyThat().element(smsNotificationToggleBtn_Locator).isEnabled().withCustomReportMessage("assert that SMS section notification toggle button is enabled ").perform();
        return this;
    }

    public EditNotificationSettings assertOnSuccessConfirmationNotification(){
        driver.verifyThat().element(successConfirmationNotificationTitle_Locator).textTrimmed().isEqualTo(successConfirmationNotificationTitle_CL).withCustomReportMessage("assert on success notification title").perform();
        driver.verifyThat().element(successConfirmationNotificationDescription_Locator).textTrimmed().isEqualTo(successConfirmationNotificationDescription_CL).withCustomReportMessage("assert on success notification description").perform();
        return this;
    }

    public EditNotificationSettings assertOnEmailStatusLabel(){
        driver.verifyThat().element(emailStatusLabel_Locator).textTrimmed().contains(emailStatusLabel_CL).withCustomReportMessage("assert on email status label").perform();
        return this;
    }
    public EditNotificationSettings assertOnSmsStatusLabel(){
        driver.verifyThat().element(smsStatusLabel_Locator).textTrimmed().contains(smsStatusLabel_CL).withCustomReportMessage("assert on sms status label").perform();
        return this;
    }
    public EditNotificationSettings assertOnNumberStatusLabel(){
        driver.verifyThat().element(numberStatusLabel_Locator).textTrimmed().isEqualTo(numberStatusLabel_CL).withCustomReportMessage("assert on number status label").perform();
        return this;
    }

    public EditNotificationSettings assertOnEmailStatusValue( String emailStatus){
        driver.verifyThat().element(emailStatusValue_Locator).textTrimmed().isEqualTo(emailStatus).withCustomReportMessage("assert on email status value").perform();
        return this;
    }
    public EditNotificationSettings assertOnSmsStatusValue(String smsStatus){
        driver.verifyThat().element(smsStatusValue_Locator).textTrimmed().isEqualTo(smsStatus).withCustomReportMessage("assert on sms status value").perform();
        return this;
    }
    public EditNotificationSettings assertOnNumberValue(String numValue){
        driver.verifyThat().element(numberStatusValue_Locator).textTrimmed().isEqualTo(numValue).withCustomReportMessage("assert on number value").perform();
        return this;
    }

    public EditNotificationSettings assertOnErrorConfirmationNotification(){
        driver.verifyThat().element(errorConfirmationNotificationTitle_Locator).textTrimmed().isEqualTo(errorConfirmationNotificationTitle_CL).withCustomReportMessage("assert on error confirmation notification title").perform();
        driver.verifyThat().element(errorConfirmationNotificationDescription_Locator).textTrimmed().isEqualTo(errorConfirmationNotificationDescription_CL).withCustomReportMessage("assert on error confirmation notification Description").perform();
        return this;
    }


}
