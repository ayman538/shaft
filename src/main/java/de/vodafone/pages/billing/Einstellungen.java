package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Einstellungen {
    private SHAFT.GUI.WebDriver driver;
    public Einstellungen(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    public String getURL(){
        return driver.browser().getCurrentURL();
    }
    //CL
    String pageName = "einstellungen";
    private String billTypeTitle_Cl = "Du bekommst Deine Rechnung als:";
    private String infoIconMessage_Cl = "Du möchtest wieder Papier-Rechnungen bekommen? Meld Dich einfach beim Kundenservice.";
    private String billNotificationIndicationTitle_Cl = "Deine Rechnungsbenachrichtigung:";
    private String billNotificationIndicationSubTitle_Cl = "Momentan senden wir Dir die Benachrichtigung über eine neue Rechnung an:";
    private String editNotificationsButton_Cl = "Benachrichtigung bearbeiten";
    private String confirmEmailNotificationHeader_Cl="Bestätige bitte Deine E-Mail-Adresse";
    private String confirmEmailNotificationBody_Cl="Wir haben Dir eine E-Mail zum Bestätigen der verwendeten Adresse geschickt. Folg bitte den Anweisungen in der E-Mail.";
    private String noContactDetailsNotificationHeader_Cl = "Du hast keine Kontaktdaten hinterlegt";
    private String noContactDetailsNotificationBody_Cl = "Damit wir Dich über die neuesten Rechnungen informieren können, solltest Du uns unbedingt eine E-Mail-Adresse oder Telefon-Nr. für SMS angeben.";
    private String createEmailButton_Cl = "E-Mail-Adresse anlegen";
    private String undeliverableEmailNotificationBody_Cl = "Die E-Mail, die wir die gesendet haben, konnte nicht zugestellt werden. Bitte kontrolliere deine E-Mail-Adresse auf richtigkeit und korrigiere diese.";
    private String generalErrorMessageHeader_Cl = "Das hat leider nicht geklappt";
    private String generalErrorMessageBody_Cl = "Wir können Deine Einstellungen zu Rechnungsart und Rechnungsversand im Moment nicht anzeigen. Versuch es bitte später nochmal.";
    private String gkoAccountNotificationHeader_Cl = "Gut zu wissen";
    private String gkoAccountNotificationBody_Cl = "Sie können hier keine Änderungen durchführen. Änderungen können Sie im Service-Portal vornehmen.";
    private String firstRadioButotn_Cl = "Online-Rechnung";
    private String addressSectionTitle_Cl = "Deine Rechnungsart";
    private String addressSectionDescription_Cl = "Momentan senden wir Dir die Papierrechnung an Deine Rechnungsadresse:";
    private String billingAddressNoteCl = "Bitte überprüfe Deine Rechnungsadresse auf ihre Richtigkeit.";
    private String changeToOnlineBillNotificationBodyCl = "Du bekommst im Moment Online- und Papier-Rechnungen für Deine Verträge. Wenn Du Online-Rechnung auswählst, bekommst Du für alle Deine Verträge Online-Rechnungen. Wenn Du dann wieder Papier-Rechnungen bekommen möchtest, musst Du Dich beim Kundenservice melden.";
    private String noBillingNotificationMsgCl = "Du erhälst deine Rechnung per Post. Aus diesem Grund erhälst du keine Rechnungsbnachrichtigung" ;
    private String notificationServiceNotActiveCl = "Benachrichtigungsservice ist nicht aktiviert";
    private String rechnungsadresseEinsehenLink_Cl = "Rechnungsadresse einsehen";
    private String emailLabel_Cl = "Per E-Mail an:";
    private String smsLabel_Cl= "Per SMS an:";
    private String editEmailButton_Cl = "E-Mail-Adresse bearbeiten";
    private String thankYouMessageBody_Cl = "Deine Änderungen haben wir gespeichert.";
    private String thankYouMessageHeader_Cl = "Vielen Dank!";
    private String noEmailGiven_Cl = "Du hast keine E-Mail-Adresse angegeben";
    private String changePaperToOnlineNotificationHeader_Cl = "Gut zu wissen";
    private String changePaperToOnlineNotificationBody_Cl = "Wenn Du wieder Papier-Rechnungen bekommen willst, meld Dich einfach beim Kundenservice. Ebenso wird deine Rechnungsbenachrichtung aktiviert.";
    private String transactionErrorMessageBody_Cl = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private By reschnungsversandandernBtn = By.xpath("//a[@class='btn btn-black box-shadow mb-0']");
    private By billTypeTitleLocator = By.xpath("//h4[@automation-id='invoiceTypeHeadline_tv']");
    private By infoIconLocator = By.xpath("//*[local-name()='svg' and @automation-id='Tooltip-icon_svg']");
    private By billTypeSubTitle_Locator = By.xpath("//span[@automation-id='onlineRechuning_tv']");
    private By infoIconMessage_Locator = By.xpath("//div[@class='ws10-tooltip-bubble__content']");
    private By billNotificationIndicationTitle_Locator = By.xpath("//h4[@automation-id='emailHeader_tv']");
    private By billNotificationIndicationSubTitle_Locator = By.xpath("//p[@automation-id='emailSubHeader_tv']");
    private By emailLocator = By.xpath("//span[@automation-id='email_tv']");
    private By emailStatus_Locator = By.xpath("//span[@automation-id='emailStatues_tv']");
    private By smsStatus_Locator = By.xpath("//span[@automation-id='smsStatues_tv']");
    private By number_Locator = By.xpath("//span[@automation-id='smsNum_tv']");
    private By editEmailButton_Locator = By.xpath("//a[@automation-id='navigateToEditEmail_tv']");
    private By editEmailButtonOnline_Locator = By.xpath("//button[@automation-id='navigateToEditEmail_tv']");
    private By editNotificationsButton_Locator = By.xpath("//a[@automation-id='editNotification_tv']");
    private By confirmEmailNotificationHeader_Locator = By.xpath("//notification[@automation-id='notVerifiedNotification_tv']//h4");
    private By confirmEmailNotificationBody_Locator = By.xpath("//notification[@automation-id='notVerifiedNotification_tv']//p");
    private By sendConfirmationEmailButton = By.xpath("//a[@automation-id='navigateToConfirmationEmail_tv']");
    private By noContactDetailsNotificationHeader_Locator = By.xpath("//notification[@automation-id='notReturnedNotification_tv']//h4");
    private By noContactDetailsNotificationBody_Locator = By.xpath("//notification[@automation-id='notReturnedNotification_tv']//p");
    private By undeliverableEmailNotificationHeader_locator = By.xpath("//notification[@automation-id='bouncedNotification_tv']//h4");
    private By createEmailButton_Locator = By.xpath("//a[@automation-id='navigateToEditEmail_tv']");
    private By undeliverableEmailNotificationBody_Locator = By.xpath("//notification[@automation-id='bouncedNotification_tv']//p");
    private By generalErrorMessageHeaderBody_Locator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By generalErrorMessageHeader_Locator = By.xpath("//h4[contains(.,'Das hat leider nicht geklappt')]");
    private By gkoAccountNotificationHeader_Locator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By gkoAccountNotificationBody_Locator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By firstRadioButton = By.xpath("//label[@for='dunningAmount']");
    private By secondRadioButton = By.xpath("//label[@for='arBalanceAmount']");
    private By firstRadioButtonCl_Locator = By.xpath("//label[@for='dunningAmount']//span");
    private By secondRadioButtonCl_Locator = By.xpath("//label[@for='arBalanceAmount']//span");
    private By saveChangesButton_Locator = By.xpath("//button[@automation-id='saveChanges_tv']");
    private By addressSectionTitlePaperOnline_Locator = By.xpath("(//h4[@automation-id='invoiceTypeHeadline_tv'])[2]");
    private By addressSectionTitlePaper_Locator = By.xpath("//h4[@automation-id='headerNoBillNotification_tv']");
    private By addressSectionDescriptionPaperOnline_Locator = By.xpath("//p[@automation-id='invoiceTypeSubHeadline_tv']");
    private By addressSectionDescriptionPaper_Locator = By.xpath("//p[@automation-id='subHeaderNoBillNotification_tv']");
    private By billingAddressNoteLocator = By.xpath("//notification[@automation-id='noBillNotification_tv']//h4");
    private By changeToOnlineBillNotificationBodyLocator = By.xpath("//notification[@automation-id='warning_tv']//h4");
    private By noBillingNotificationMsgLocator = By.xpath("//notification[@automation-id='addressNote_tv']//h4");
    private By notificationServiceNotActiveLocator = By.xpath("//notification[@automation-id='notActiveNotification_tv']//h4");
    private By rechnungsadresseEinsehenLink_LocatorPaperOnline = By.xpath("//notification[@automation-id='addressNotePaperAndOnline_tv']//a");
    private By rechnungsadresseEinsehenLinkPaper_Locator = By.xpath("//notification[@automation-id='noBillNotification_tv']//a");
    private By emailLabel_Locator = By.xpath("//span[@automation-id='emaillabel_tv']");
    private By smsLabel_Locator = By.xpath("//span[@automation-id='smsLabel_tv']");
    private By emailCheckMark = By.xpath("//*[local-name()='svg' and @automation-id='emailRightCheck_tv']");
    private By emailXMark = By.xpath("//*[local-name()='svg' and @automation-id='emailWrongCheck_tv']");
    private By smsCheckMark = By.xpath("//*[local-name()='svg' and @automation-id='smsRightCheck_tv']");
    private By smsXMark = By.xpath("//span[@automation-id='smsWrongCheck_tv']");
    private By thankYouMessageBody_Locator = By.xpath("//notification[@automation-id='successChange_tv']//p");
    private By thankYouMessageHeader_Locator = By.xpath("//notification[@automation-id='successChange_tv']//h4");
    private By noEmailGivenStatus = By.xpath("//p[@automation-id='emailNotReturned_tv']");
    private By changePaperToOnlineNotificationHeader_Locator = By.xpath("//notification[@automation-id='success_tv']//h4");
    private By changePaperToOnlineNotificationBody_Locator = By.xpath("//notification[@automation-id='success_tv']//p");
    private By transactionErrorMessageBody_Locator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By transactionErrorMessageHeader_Locator = By.xpath("//h4[contains(.,'Das hat leider nicht geklappt')]");
    private By pdfClLocator = By.xpath("//*[@automation-id='billPdfChecked_tv']");
    private By notLoggedInNotificationBody_Locator = By.xpath("");
    private By notLoggedInNotificationHeaderLocator = By.xpath("");
    private By getNotLoggedInNotificationLocator = By.xpath("");
    private By loginButtonInNotification = By.xpath("");
    private By rechnungsadresseEinsehenLink_Locator = By.xpath("");
    private By editNotificationBtn_Locator = By.xpath("//*[@automation-id='editNotification_tv']");
    private By gkoPortalRedirectionBtn_Locator = By.xpath("//button[@automation-id='undefined_btn']");


    //Methods
    @Step("click on 'edit email' button")
    public void clickOnEditEmailBtn(){
        driver.element().click(editEmailButton_Locator);
    }
    @Step("click on 'create email' button")
    public void clickOnCreateEmailBtn(){
        driver.element().click(createEmailButton_Locator);
    }
    @Step("Click on 'save changes' button")
    public void clickOnSaveChangesBtn(){
        driver.element().click(saveChangesButton_Locator);
    }
    @Step("Click on 'online bill' radio button")
    public void clickOnOnlineBillRadioBtn(){
        driver.element().click(firstRadioButton);
    }
    @Step("Click on the second radio button")
    public void clickOnSecondRadioBtn(){
        driver.element().click(secondRadioButton);
    }
    @Step("Click on Rechnungsadresse einsehen")
    public void clickOnRechnungsadresseEinsehen(){
        driver.element().click(rechnungsadresseEinsehenLink_LocatorPaperOnline);
    }
    @Step("Click on info icon")
    public void clickOnInfoIcon(){
        driver.element().click(infoIconLocator);
    }
    @Step("Click on send confirmation email button")
    public void ClickOnsendConfirmationEmailBtn(){
        driver.element().click(sendConfirmationEmailButton);
    }
    @Step("Navigate back to einstellungen page")
    public void navigateToEinstellungenPage() {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/ihre-rechnungen/einstellungen");
    }
    @Step("click on 'edit email' button")
    public void clickOnEditEmailBtnInOnlineCase(){
        driver.element().click(editEmailButtonOnline_Locator);}
    @Step("Click edit notification button")
    public Einstellungen clickEditNotificationButton(){
        driver.element().click(editNotificationBtn_Locator);
        return this;
    }

    //Validations

    public void assertThatGkoRedirectionBtnExist() {
        driver.verifyThat().element(gkoPortalRedirectionBtn_Locator).exists()
                .withCustomReportMessage("assert That Gko Redirection Btn Exist")
                .perform();
    }

    public void assertOnPdfStatusDescriptionCL(String PdfCl){
        driver.verifyThat().element(pdfClLocator).textTrimmed()
                .isEqualTo(PdfCl).withCustomReportMessage("assert On Pdf Text")
                .perform();
    }

    public void assertThatPdfStatusDoesNotExist(){
        driver.verifyThat().element(pdfClLocator).doesNotExist()
                .withCustomReportMessage("assert That Pdf Status Does Not Exist")
                .perform();
    }

    public void assertThatUserNavigatedToPage(){
        driver.verifyThat()
                .browser()
                .url()
                .contains(pageName)
                .withCustomReportMessage("Assert that user has been navigated to the Bill setting page")
                .perform();
    }

    public void assertThatreschnungsversandandernBtnDoesNotExist(){
        driver.verifyThat().element(reschnungsversandandernBtn).doesNotExist()
                .withCustomReportMessage("check that reschnungsversandandern Btn Does Not Exist ")
                .perform();
    }
    public void assertOnBillType(String billType){
        driver.verifyThat().element(billTypeTitleLocator).textTrimmed().isEqualTo(billTypeTitle_Cl)
                .withCustomReportMessage("Assertion on bill details title")
                .perform();
        driver.verifyThat().element(billTypeSubTitle_Locator).textTrimmed().isEqualTo(billType)
            .withCustomReportMessage("Assertion on bill type")
            .perform();
    }
    public void assertOnInfoIconMessage(){
        driver.verifyThat().element(infoIconMessage_Locator).textTrimmed().isEqualTo(infoIconMessage_Cl)
                .withCustomReportMessage("Assertion on info icon message")
                .perform();
    }
    public void assertOnBillNotificationIndicationTitle(){
        driver.verifyThat().element(billNotificationIndicationTitle_Locator).textTrimmed().isEqualTo(billNotificationIndicationTitle_Cl)
                .withCustomReportMessage("Assertion on bill notification title")
                .perform();
        driver.verifyThat().element(billNotificationIndicationSubTitle_Locator).textTrimmed().isEqualTo(billNotificationIndicationSubTitle_Cl)
                .withCustomReportMessage("Assertion on bill notification description")
                .perform();
    }
    public void assertOnEmailColor(String emailColor){
        driver.verifyThat().element(emailLocator).cssProperty("color").contains(emailColor)
                .withCustomReportMessage("Assert on email color")
                .perform();
    }
    public void assertOnEmailStatus(String emailStatus){
        driver.verifyThat().element(emailStatus_Locator).textTrimmed().isEqualTo(emailStatus)
                .withCustomReportMessage("Assert on email status")
                .perform();
    }
    public void assertOnSMSStatus(String smsStatus){
        driver.verifyThat().element(smsStatus_Locator).textTrimmed().isEqualTo(smsStatus)
                .withCustomReportMessage("Assert on SMS status")
                .perform();
    }
    public void assertThatMobileNumberExists(String mobileNumber){
        driver.verifyThat().element(number_Locator).textTrimmed().isEqualTo(mobileNumber).withCustomReportMessage("Assert on mobile number value").perform();
    }
    public void assertThatMobileNumberDoesNotExist(){
        driver.verifyThat().element(number_Locator).doesNotExist().withCustomReportMessage("Mobile number does not exist").perform();
    }
    public void assertOnConfirmEmailNotification(){
        driver.verifyThat().element(confirmEmailNotificationHeader_Locator).textTrimmed().isEqualTo(confirmEmailNotificationHeader_Cl)
                .withCustomReportMessage("Assert on confirm email notification header")
                .perform();
        driver.verifyThat().element(confirmEmailNotificationBody_Locator).textTrimmed().isEqualTo(confirmEmailNotificationBody_Cl)
                .withCustomReportMessage("Assert on confirm email notification body")
                .perform();
    }
    public void assertOnNoContactDetailsNotification(){
        driver.verifyThat().element(noContactDetailsNotificationHeader_Locator).textTrimmed().isEqualTo(noContactDetailsNotificationHeader_Cl)
                .withCustomReportMessage("Assert on no contact details notification header")
                .perform();
        driver.verifyThat().element(noContactDetailsNotificationBody_Locator).textTrimmed().isEqualTo(noContactDetailsNotificationBody_Cl)
                .withCustomReportMessage("Assert on no contact details notification body")
                .perform();
    }
    public void assertOnCreateEmailButton(){
        driver.verifyThat().element(createEmailButton_Locator).textTrimmed().isEqualTo(createEmailButton_Cl)
                .withCustomReportMessage("Assert on create email button Cl")
                .perform();
        driver.verifyThat().element(createEmailButton_Locator).cssProperty("background").contains("51, 51, 51")
                .withCustomReportMessage("Assert on create email button color").perform();
    }
    public void assertOnUndeliverableEmailNotification(){
        driver.verifyThat().element(undeliverableEmailNotificationHeader_locator).textTrimmed().isEqualTo(confirmEmailNotificationHeader_Cl)
                .withCustomReportMessage("Assert on confirm undeliverable email notification header")
                .perform();
        driver.verifyThat().element(undeliverableEmailNotificationBody_Locator).textTrimmed().isEqualTo(undeliverableEmailNotificationBody_Cl)
                .withCustomReportMessage("Assert on undeliverable email notification body")
                .perform();
    }
    public void assertOnGeneralErrorMessage(){
        driver.verifyThat().element(generalErrorMessageHeader_Locator).textTrimmed().isEqualTo(generalErrorMessageHeader_Cl)
                .withCustomReportMessage("Assert on general error message header")
                .perform();
        driver.verifyThat().element(generalErrorMessageHeaderBody_Locator).textTrimmed().isEqualTo(generalErrorMessageBody_Cl)
                .withCustomReportMessage("Assert on general error message body")
                .perform();
    }
    public void assertOnGKoNotification(){
        driver.verifyThat().element(gkoAccountNotificationHeader_Locator).textTrimmed().isEqualTo(gkoAccountNotificationHeader_Cl)
                .withCustomReportMessage("Assert on GKO notification header")
                .perform();
        driver.verifyThat().element(gkoAccountNotificationBody_Locator).textTrimmed().isEqualTo(gkoAccountNotificationBody_Cl)
                .withCustomReportMessage("Assert on GKO notification body")
                .perform();
    }
    public void assertOnRadioButtonsCLs(String billType){
        driver.verifyThat().element(firstRadioButtonCl_Locator).textTrimmed().isEqualTo(firstRadioButotn_Cl)
                .withCustomReportMessage("Assert on online bill radio button Cl")
                .perform();
        driver.verifyThat().element(secondRadioButtonCl_Locator).textTrimmed().isEqualTo(billType)
                .withCustomReportMessage("Assert on current bill type Cl")
                .perform();
    }
    public void assertThatTheCurrentBillTypeIsSelected(){
        driver.verifyThat().element(secondRadioButton).isSelected();
    }
    public void assertThatSaveChangeBtnIsDimmed(){
        driver.verifyThat().element(saveChangesButton_Locator).isDisabled();
    }
    public void assertOnAddressSection(){

        driver.verifyThat().element(addressSectionTitlePaper_Locator).textTrimmed().isEqualTo(addressSectionTitle_Cl)
                .withCustomReportMessage("Assert on address section title ")
                .perform();
        driver.verifyThat().element(addressSectionDescriptionPaper_Locator).textTrimmed().isEqualTo(addressSectionDescription_Cl)
                .withCustomReportMessage("Assert on address section description ")
                .perform();
    }
    public void assertOnChangingToOnlineBillNotification(){
        driver.verifyThat().element(changeToOnlineBillNotificationBodyLocator).textTrimmed().contains(changeToOnlineBillNotificationBodyCl)
                .withCustomReportMessage("Assert on Online Bill Notification ")
                .perform();
    }

    public void assertThatRadioButtonsDoesNotExist(){
        driver.verifyThat().element(firstRadioButton).doesNotExist()
                .withCustomReportMessage("Assert that first radio button does not exist")
                .perform();
        driver.verifyThat().element(secondRadioButton).doesNotExist()
                .withCustomReportMessage("Assert that first radio button does not exist")
                .perform();
    }
    public void assertOnBillingAddressNote(){
        driver.verifyThat().element(billingAddressNoteLocator).textTrimmed().isEqualTo(billingAddressNoteCl)
                .withCustomReportMessage("Assert on billing address note Cl")
                .perform();
        driver.verifyThat().element(rechnungsadresseEinsehenLinkPaper_Locator).textTrimmed().isEqualTo(rechnungsadresseEinsehenLink_Cl)
                .withCustomReportMessage("Assert on view billing address hyperlink")
                .perform();

    }
    public void assertOnEditNotificationSettingsBtnCl(){
        driver.verifyThat().element(editNotificationsButton_Locator).textTrimmed().isEqualTo(editNotificationsButton_Cl)
                .withCustomReportMessage("Assert on edit notification settings Cl")
                .perform();
    }
    public void assertOnNoBillingNotificationMsgCl(){
        driver.verifyThat().element(noBillingNotificationMsgLocator).textTrimmed().isEqualTo(noBillingNotificationMsgCl)
                .withCustomReportMessage("Assert on no billing notification message Cl")
                .perform();
    }
    public void assertOnNotificationServiceNotActiveMsg(){
        driver.verifyThat().element(notificationServiceNotActiveLocator).textTrimmed().isEqualTo(notificationServiceNotActiveCl)
                .withCustomReportMessage("Assert on notification not active msg Cl")
                .perform();
    }
    public void assertThatUserIsRedirectedToSendValidationEmailAgainPage(){
        driver.verifyThat().browser().url().contains(System.getProperty("de.vodafone.baseUrl.sit")+"meinvodafone/services/kontaktdaten/Neue-Bestatigungs-Mail");
    }
    public void assertOnEmailLabel(){
        driver.verifyThat().element(emailLabel_Locator).textTrimmed().isEqualTo(emailLabel_Cl)
                .withCustomReportMessage("Assert on email label")
                .perform();
    }
    public void assertOnSMSLabel(){
        driver.verifyThat().element(smsLabel_Locator).textTrimmed().isEqualTo(smsLabel_Cl)
                .withCustomReportMessage("Assert on SMS label")
                .perform();
    }
    public void assertOnEmailCheckMarkIcon(){
        driver.verifyThat().element(emailCheckMark).exists();
    }
    public void assertOnEmailXMarkIcon(){
        driver.verifyThat().element(emailXMark).exists();
    }
    public void assertOnSmsCheckMarkIcon(){
        driver.verifyThat().element(smsCheckMark).exists();
    }
    public void assertOnSmsXMarkIcon(){
        driver.verifyThat().element(smsXMark).exists();
    }
    public void assertOnEditEmailButton(String buttonColor){
        driver.verifyThat().element(editEmailButton_Locator).textTrimmed().isEqualTo(editEmailButton_Cl)
                .withCustomReportMessage("Assert on edit email button Cl")
                .perform();
        driver.verifyThat().element(editEmailButton_Locator).cssProperty("background").contains(buttonColor)
                .withCustomReportMessage("Assert on edit email button color").perform();
    }
    public void assertOnThankYouMessage(){
        driver.verifyThat().element(thankYouMessageBody_Locator).textTrimmed().isEqualTo(thankYouMessageBody_Cl)
                .withCustomReportMessage("Assert on thank you message Cl")
                .perform();
        driver.verifyThat().element(thankYouMessageHeader_Locator).textTrimmed().isEqualTo(thankYouMessageHeader_Cl)
                .withCustomReportMessage("Assert on thank you message Cl")
                .perform();
    }
    public void assertOnNoEmailGivenCl(){
        driver.verifyThat().element(noEmailGivenStatus).textTrimmed().isEqualTo(noEmailGiven_Cl)
                .withCustomReportMessage("Assert on no email was given Cl")
                .perform();
        driver.verifyThat().element(noEmailGivenStatus).cssProperty("color")
                .contains("230, 0, 0")
                .withCustomReportMessage("Assert on no email given color")
                .perform();
    }
    public void assertOnEditEmailButtonInOnlineCase(String buttonColor){
        driver.verifyThat().element(editEmailButtonOnline_Locator).textTrimmed().isEqualTo(editEmailButton_Cl)
                .withCustomReportMessage("Assert on edit email button Cl")
                .perform();
        driver.verifyThat().element(editEmailButtonOnline_Locator).cssProperty("background").contains(buttonColor)
                .withCustomReportMessage("Assert on edit email button color").perform();
    }
    public void assertOnChangeFromPaperToOnlineNotification(){
        driver.verifyThat().element(changePaperToOnlineNotificationHeader_Locator).textTrimmed()
                .isEqualTo(changePaperToOnlineNotificationHeader_Cl)
                .withCustomReportMessage("Assert on change from paper to online bill notification header")
                .perform();
        driver.verifyThat().element(changePaperToOnlineNotificationBody_Locator).textTrimmed()
                .isEqualTo(changePaperToOnlineNotificationBody_Cl)
                .withCustomReportMessage("Assert on change from paper to online bill notification body")
                .perform();
    }
    public void assertOnTransactionErrorMessage(){
        driver.verifyThat().element(transactionErrorMessageHeader_Locator).textTrimmed().isEqualTo(generalErrorMessageHeader_Cl)
                .withCustomReportMessage("Assert on general error message header")
                .perform();
        driver.verifyThat().element(transactionErrorMessageBody_Locator).textTrimmed().isEqualTo(transactionErrorMessageBody_Cl)
                .withCustomReportMessage("Assert on general error message body")
                .perform();
    }

}
