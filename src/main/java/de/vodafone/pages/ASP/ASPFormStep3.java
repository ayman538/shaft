package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ASPFormStep3 {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ASPFormStep3(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By EmailAddressHeader = By.xpath("//*[@formcontrolname='emailAddress']/div/div/label");
    private By PhoneNumberTextBox = By.xpath("//*[@automation-id='mainPhone_et']");
    private By CustomerNumberTextBox = By.xpath("//*[@automation-id='CustomerNumber_et']");
    private By ProductNumberTextBox = By.xpath("//*[@automation-id='contractNumber_et']");
    private By PhoneNumberFieldError = By.xpath("//*[@automation-id='mainPhone_patternErrorMessage_et']");
    private By CustomerNumberFieldError = By.xpath("//*[@automation-id='CustomerNumber_patternErrorMessage_et']");
    private By ProductNumberFieldError = By.xpath("//*[@automation-id='contractNumber_patternErrorMessage_et']");
    private By PhoneNumberFieldGreen = By.xpath("//*[@formcontrolname='mainPhone']//*[local-name()='svg' and @class='icon field-icon i-sml i-green']");
    private By CustomerNumberFieldGreen = By.xpath("//*[@formcontrolname='customerNumber']//*[local-name()='svg' and @class='icon field-icon i-sml i-green']");
    private By ProductNumberFieldGreen = By.xpath("//*[@formcontrolname='contractNumber']//*[local-name()='svg' and @class='icon field-icon i-sml i-green']");
    private By EmailAddressContiner = By.xpath("(//*[@id='emailAddress'])");
    private By customernumber = By.xpath("//*[@formcontrolname='customerNumber']/div/div[1]");
    private By customernumberContiner = By.xpath("//*[@id='CustomerNumber']");
    private By contractnumber = By.xpath("//*[@formcontrolname='contractNumber']/div/div[1]");
    private By contractnumberContiner = By.xpath("//*[@id='contractNumber']");
    private By Areacode = By.xpath("//*[@formcontrolname='phonePrefix']/div/div[1]");
    private By AreacodeContiner = By.xpath("//*[@id='PhonePrefix']");
    private By Phonenumber = By.xpath("//*[@formcontrolname='mainPhone']/div/div[1]");
    private By PhonenumberContiner = By.xpath("//*[@id='mainPhone']");
    private By Producttype = By.xpath("//*[@class='fm-checkbox fm-bloc fm-data']/legend");
    private By TVtitle = By.xpath(" (//*[@automation-id='checkboxItemModel.id_label_tv'])[1]");
    private By TVCheckbox = By.xpath("//*[@id='tv']");
    private By Internettitle = By.xpath(" (//*[@automation-id='checkboxItemModel.id_label_tv'])[2]");
    private By InternetCheckbox = By.xpath("//*[@id='internet']");
    private By Othertitle = By.xpath(" (//*[@automation-id='checkboxItemModel.id_label_tv'])[3]");
    private By Othercheckbox = By.xpath("(//*[@id='other'])[1]");
    private By Othercheckbox_terminition = By.xpath("(//*[@id='other'])[2]");
    private By Othercontiner = By.xpath("//*[@formcontrolname='otherProduct']");
    private By TerminationReasons = By.xpath("(//*[@id='olRadioGroup']/legend)[1]");
    private By Reason1Label = By.xpath("//*[@id='dissatisfied-With-Tarrif']");
    private By Reason2label = By.xpath("//*[@automation-id='techincalProblem_rb']");
    private By Reason3label = By.xpath("//*[@id='death']");
    private By Reason4label = By.xpath("(//*[@id='other'])[1]");
    private By Reason1Radiobutton = By.xpath("(//*[@class='bgdiv'])[1]");
    private By Reason2Radiobutton = By.xpath("(//*[@class='bgdiv'])[2]");
    private By Reason3Radiobutton = By.xpath("(//*[@class='bgdiv'])[3]");
    private By Reason4Radiobutton = By.xpath("(//*[@class='bgdiv'])[4]");
    private By Reason4continer = By.xpath(" //*[@formcontrolname='terminationOtherReason']");
    private By CaptchaHeader = By.xpath("//*[@automation-id='captchaHeader_tv']");
    private By Captchalapel = By.xpath("//*[@formcontrolname='captchaField']/div/div[1]");
    private By Captchacontiner = By.xpath("//*[@id='captcha']");
    private By Submitlapel = By.xpath("//*[@automation-id='additional-label_tv']");
    private By Submitbutton = By.xpath("//*[@automation-id='submitButton_btn']");
    private By popupbutton = By.xpath("//*[@class='overlay-link']");
    private By popupHeader = By.xpath("(//*[@class='overlay-content']/h1)[2]");
    private By EmailAdressInfoIcon = By.xpath("(//*[@class='i-xsml'])[1]");
    private By EmailAdressInfomsg = By.xpath("(//*[@automation-id='undefined_tv'])[1]");
    private By customerNumberInfoIcon = By.xpath("(//*[@class='i-xsml'])[3]");
    private By customerNumberInfomsg = By.xpath("(//*[@automation-id='undefined_tv'])[2]");
    private By contractNumberInfoIcon = By.xpath("(//*[@class='i-xsml'])[5]");
    private By contractNumberInfomsg = By.xpath("(//*[@automation-id='undefined_tv'])[3]");
    private By AreaCodeInfoIcon = By.xpath("(//*[@class='i-xsml'])[7]");
    private By AreaCodeInfomsg = By.xpath("(//*[@automation-id='undefined_tv'])[4]");
    private By PhoneNumberInfoIcon = By.xpath("(//*[@class='i-xsml'])[9]");
    private By PhoneNumberInfomsg = By.xpath("(//*[@automation-id='undefined_tv'])[5]");
    private By EmailAdresseroromsg = By.xpath("//*[@automation-id='emailAddress_patternErrorMessage_et']");
    private By customerNumbereroromsg = By.xpath("//*[@automation-id='CustomerNumber_patternErrorMessage_et']");
    private By ContractNumbereroromsg = By.xpath("//*[@automation-id='contractNumber_patternErrorMessage_et']");
    private By AreaCodeeroromsg = By.xpath("//*[@automation-id='PhonePrefix_patternErrorMessage_et']");
    private By PhoneNumbereroromsg = By.xpath("//*[@automation-id='mainPhone_patternErrorMessage_et']");
    private By Captchaeroromsg = By.xpath("//*[@automation-id='captcharequiredErrorMessage_et']");
    private By desiredTerminationDateQuestion = By.xpath("//ol-radio-group[@formcontrolname='cancellationDesiredDate']//legend[@class='forms-head']");
    private By terminateAtDesiredDateRadioBtn = By.xpath("//label[@for='Zu einem späteren Termin kündigen']//div[@class='bgdiv']");
    private By terminateAtEndDateRadioBtn = By.xpath("//label[@for='Zum Laufzeitende kündigen']//div[@class='bgdiv']");
    private By terminateAtDesiredDateLabel = By.xpath("//label[@for='Zu einem späteren Termin kündigen']//p");
    private By terminationDateField = By.id("dsldatePickerRadio");
    private By dateIcon = By.xpath("//*[local-name()='svg' and @class='icon field-icon i-sml i-grey-20']");
    private By calendarOverlay = By.xpath("//div[@class='mat-calendar-content']");
    private By nextMonthButton = By.xpath("//button[@aria-label='Next month']");
    private By terminationDateFieldErrorMsg = By.xpath("//ol-radio-group[@formcontrolname='cancellationDesiredDate']//div[@class='fm-formerror error-body']");

    //CL
    private String EmailAddressHeaderCL = "E-Mail-Adresse *";

    private String customerNumberCL = "Kundennummer";
    private String contractNumberCL = "Vertragsnummer";
    private String AreaCodeCL = "Vorwahl *";
    private String PhoneNumberCL = "Rufnummer für Rückfragen *";
    private String ProducttypeCL = "Wähl bitte das Produkt aus, das Du kündigen möchtest (Du kannst " +
            "mehrere auswählen). *";
    private String TVCL = "TV";
    private String InternetCL = "Internet & Festnetz";
    private String OtherCL = "Andere";
    private String TerminationReasons_CL = "Wähl bitte einen Kündigungsgrund. *";
    private String Reason1CL = "Unzufrieden mit dem Tarif";
    private String Reason2CL = "Technische Probleme";
    private String Reason3CL = "Sterbefall";
    private String Reason4CL = "Anderer Grund";
    private String CapthcaheadreCL = "Gib zum Schutz Deiner Benutzerdaten bitte den Sicherheitscode ein. Du kannst nichts erkennen? Klick auf das Pfeil-Symbol, um einen neuen Sicherheitscode " +
            "zu laden.";
    private String CapthcaLabelCL = "Sicherheitscode *";
    private String RequiredFieldCL = "* Pflichtfelder";
    private String SubmitButtonCL = "Speichern";
    private String popupHeaderCL = "Hier findest Du Deine Kundendaten";
    private String EmailAdressInfomsgCL = "An diese E-Mail-Adresse bekommst Du den QR-Code oder den Retourenschein für Deine Rücksendung.";
    private String customerNumberInfomsgCL = "Deine Kundennummer besteht aus 9 oder 10 Ziffern. Du findest sie auf Deiner Auftragsbestätigung und Rechnung.";
    private String contractNumberInfomsgCL = "Deine Vertragsnummer besteht aus 9 oder 10 Ziffern. Du findest sie auf Deinem Vertrag, Deiner Papierrechnung oder in MeinVodafone.";
    private String AreaCodeInfomsgCL = "Deine Rufnummer benötigen wir für mögliche Rückfragen.";
    private String PhoneNumberInfomsgCL = "Deine Rufnummer benötigen wir für mögliche Rückfragen.";
    private String EmailAdressErorrmsgCL = "Überprüf bitte Deine E-Mail-Adresse. Es muss ein '@' sowie ein '.' enthalten sein. Komma und Leerzeichen sind nicht erlaubt.";
    private String customerNumberErorrmsgCL = "Deine Kundennummer muss min. 9 Ziffern enthalten.";
    private String contractNumberErorrmsgCL = "Deine Vertragsnummer muss min. 9 Ziffern enthalten.";
    private String AreaCodeErorrmsgCL = "Gib bitte eine gültige Vorwahl ein.";
    private String PhoneNumberErorrmsgCL = "Gib bitte eine gültige Rufnummer ein.";
    private String CaptchaErorrmsgCL = "Trag hier den Code ein, der unter diesem Eingabefeld steht.";
    private String desiredTerminationDateQuestionCL = "Zu wann möchtest Du kündigen? *";
    private String terminateAtDesiredDateLabelCL = "Zu einem späteren Termin kündigen";


    //Validations
    @Step("Validate that Phone Number Error form step 3 is visible")
    public ASPFormStep3 validatePhoneNumberErrorVisibility() {
        driver.element().keyPress(PhoneNumberTextBox, Keys.TAB);
        driver.verifyThat().element(PhoneNumberFieldError).isVisible().perform();
        driver.verifyThat().element(PhoneNumberFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }

    @Step("Validate that Customer Number Error form step 3 is visible")
    public ASPFormStep3 validateCustomerNumberErrorVisibility() {
        driver.element().keyPress(CustomerNumberTextBox, Keys.TAB);
        driver.verifyThat().element(CustomerNumberFieldError).isVisible().perform();
        driver.verifyThat().element(CustomerNumberFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }

    @Step("Validate that Product Number Error form step 3 is visible")
    public ASPFormStep3 validateProductNumberErrorVisibility() {
        driver.element().keyPress(ProductNumberTextBox, Keys.TAB);
        driver.verifyThat().element(ProductNumberFieldError).isVisible().perform();
        driver.verifyThat().element(ProductNumberFieldError).cssProperty("color").contains("230, 0, 0").perform();
        return this;
    }

    @Step("Validate that Phone Number Green form step 3 is visible")
    public ASPFormStep3 validatePhoneNumberGreenVisibility() {
        driver.element().keyPress(PhoneNumberTextBox, Keys.TAB);
        driver.verifyThat().element(PhoneNumberFieldGreen).isVisible().perform();
        return this;
    }

    @Step("Validate that Customer Number Green form step 3 is visible")
    public ASPFormStep3 validateCustomerNumberGreenVisibility() {
        driver.element().keyPress(CustomerNumberTextBox, Keys.TAB);
        driver.verifyThat().element(CustomerNumberFieldGreen).isVisible().perform();
        return this;
    }

    @Step("Validate that Product Number Green form step 3 is visible")
    public ASPFormStep3 validateProductNumberGreenVisibility() {
        driver.element().keyPress(ProductNumberTextBox, Keys.TAB);
        driver.verifyThat().element(ProductNumberFieldGreen).isVisible().perform();
        return this;
    }

    public ASPFormStep3 InsertCaptcha() {
        driver.element().type(Captchacontiner, "xlwy");
        return this;
    }

    public ASPFormStep3 SelectProduct() {
        driver.element().click(TVCheckbox);
        return this;
    }

    public ASPFormStep3 SelectReasonOFtermination() {
        driver.element().click(Reason1Radiobutton);
        return this;
    }

    public ASPSummaryofReturnPage clickSubmit() {
        driver.element().click(Submitbutton);
        return new ASPSummaryofReturnPage(driver);
    }

    public ASPFormStep3 CLickPopup() {
        driver.element().click(popupbutton);
        return this;
    }

    public ASPFormStep3 CLickAndere() {
        driver.element().click(Othercheckbox);
        return this;
    }

    public ASPFormStep3 CLickAndereGrund() {
        driver.element().click(Reason4Radiobutton);
        return this;
    }

    public ASPSummaryofReturnPage FillForm3Giraffe(String EmailAddress, String CustomerNumber, String AreaCode, String PhoneNumber) {
        driver.element().type(EmailAddressContiner, EmailAddress);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(AreacodeContiner, AreaCode);
        driver.element().type(PhonenumberContiner, PhoneNumber);
        SelectProduct();
        InsertCaptcha();
        clickSubmit();
        return new ASPSummaryofReturnPage(driver);
    }

    public ASPSummaryofReturnPage FillForm3Camel(String EmailAddress, String CustomerNumber, String ContractNumber, String AreaCode, String PhoneNumber) {

        driver.element().type(EmailAddressContiner, EmailAddress);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(AreacodeContiner, AreaCode);
        driver.element().type(PhonenumberContiner, PhoneNumber);
        driver.element().type(contractnumberContiner, ContractNumber);
        SelectProduct();
        InsertCaptcha();
        clickSubmit();
        return new ASPSummaryofReturnPage(driver);
    }

    public ASPSummaryofReturnPage FillForm3Deer(String EmailAddress, String CustomerNumber, String AreaCode, String PhoneNumber) {
        driver.element().type(EmailAddressContiner, EmailAddress);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(AreacodeContiner, AreaCode);
        driver.element().type(PhonenumberContiner, PhoneNumber);
        SelectProduct();
        SelectReasonOFtermination();
        selectTerminateContractAtEndDate();
        InsertCaptcha();
        clickSubmit();
        return new ASPSummaryofReturnPage(driver);
    }

    public ASPSummaryofReturnPage FillForm3DeerSpecificTerminationDate(String EmailAddress, String CustomerNumber, String AreaCode, String PhoneNumber,String terminationDate) throws InterruptedException {
        Thread.sleep(5000);
        driver.element().type(EmailAddressContiner, EmailAddress);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(AreacodeContiner, AreaCode);
        driver.element().type(PhonenumberContiner, PhoneNumber);
        SelectReasonOFtermination();
        selectTerminateContractAtDesiredDate(terminationDate);
        SelectProduct();
        InsertCaptcha();
        clickSubmit();
        return new ASPSummaryofReturnPage(driver);
    }

    public ASPSummaryofReturnPage FillForm3Fox(String EmailAddress, String CustomerNumber, String ContractNumber, String AreaCode, String PhoneNumber) {
        driver.element().type(EmailAddressContiner, EmailAddress);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(AreacodeContiner, AreaCode);
        driver.element().type(PhonenumberContiner, PhoneNumber);
        driver.element().type(contractnumberContiner, ContractNumber);
        SelectProduct();
        SelectReasonOFtermination();
        selectTerminateContractAtEndDate();
        InsertCaptcha();
        clickSubmit();

        return new ASPSummaryofReturnPage(driver);
    }

    public ASPSummaryofReturnPage FillForm3FoxSpecificTerminationDate(String EmailAddress, String CustomerNumber, String ContractNumber, String AreaCode, String PhoneNumber, String terminationDate) throws InterruptedException {
        Thread.sleep(5000);
        driver.element().type(EmailAddressContiner, EmailAddress);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(customernumberContiner, CustomerNumber);
        driver.element().type(AreacodeContiner, AreaCode);
        driver.element().type(PhonenumberContiner, PhoneNumber);
        driver.element().type(contractnumberContiner, ContractNumber);
        SelectProduct();
        SelectReasonOFtermination();
        selectTerminateContractAtDesiredDate(terminationDate);
        InsertCaptcha();
        clickSubmit();

        return new ASPSummaryofReturnPage(driver);
    }

    public ASPFormStep3 fillInvaildData_KD() {
        driver.element().type(EmailAddressContiner, "TEST");
        driver.element().type(customernumberContiner, "TEST");
        driver.element().type(contractnumberContiner, "TEST");
        driver.element().type(AreacodeContiner, "00");
        driver.element().type(PhonenumberContiner, "010");
        driver.element().keyPress(Captchacontiner, Keys.TAB);

        return this;
    }


    //Actions

    public ASPFormStep3 typeCustomPhoneNumber(String phoneNumber) {
        driver.element().type(PhoneNumberTextBox, phoneNumber);
        return this;
    }

    public ASPFormStep3 typeCustomCustomerNumber(String customerNumber) {
        driver.element().type(CustomerNumberTextBox, customerNumber);
        return this;
    }

    public ASPFormStep3 typeCustomProductNumber(String productNumber) {
        driver.element().type(ProductNumberTextBox, productNumber);
        return this;
    }

    public ASPFormStep3 selectTerminateContractAtDesiredDate(String terminationDate){
        driver.element().click(terminateAtDesiredDateRadioBtn);
        driver.element().type(terminationDateField,terminationDate);
        driver.element().click(terminateAtEndDateRadioBtn);
        return this;
    }

    public ASPFormStep3 selectTerminateContractAtEndDate(){
        driver.element().click(terminateAtEndDateRadioBtn);
        return this;
    }

    @Step(" verify popup displayed")
    public void popupValidation() {
        driver.verifyThat().element(popupHeader).text().isEqualTo(popupHeaderCL).perform();
    }

    @Step("Validate Andere field is displayed ")
    public void AndereValidation() {
        driver.verifyThat().element(Othercontiner).isVisible();
    }

    @Step("Validate fields Erorr Message ")
    public void ErorrMsgValidation_KD() {
        driver.verifyThat().element(EmailAdresseroromsg).text().isEqualTo(EmailAdressErorrmsgCL).perform();
        driver.verifyThat().element(customerNumbereroromsg).text().isEqualTo(customerNumberErorrmsgCL).perform();
        driver.verifyThat().element(ContractNumbereroromsg).text().isEqualTo(contractNumberErorrmsgCL).perform();
        driver.verifyThat().element(AreaCodeeroromsg).text().isEqualTo(AreaCodeErorrmsgCL).perform();
        driver.verifyThat().element(PhoneNumbereroromsg).text().isEqualTo(PhoneNumberErorrmsgCL).perform();
        driver.verifyThat().element(Captchaeroromsg).text().isEqualTo(CaptchaErorrmsgCL).perform();
    }

    @Step("Validate Anderer Grund field is displayed ")
    public void AndereGrundValidation() {
        driver.verifyThat().element(Reason4continer).isVisible().perform();
    }

    @Step("Click on info icon and validate Information message ")
    public void ClickandValidateInfomessgae() {
        driver.element().click(EmailAdressInfoIcon);
        driver.verifyThat().element(EmailAdressInfomsg).text().isEqualTo(EmailAdressInfomsgCL).perform();
        driver.element().click(customerNumberInfoIcon);
        driver.verifyThat().element(customerNumberInfomsg).text().isEqualTo(customerNumberInfomsgCL).perform();
        driver.element().click(contractNumberInfoIcon);
        driver.verifyThat().element(contractNumberInfomsg).text().isEqualTo(contractNumberInfomsgCL).perform();
        driver.element().click(AreaCodeInfoIcon);
        driver.verifyThat().element(AreaCodeInfomsg).text().isEqualTo(AreaCodeInfomsgCL).perform();
        driver.element().click(PhoneNumberInfoIcon);
        driver.verifyThat().element(PhoneNumberInfomsg).text().isEqualTo(PhoneNumberInfomsgCL).perform();
    }
    @Step("Validate desired termination date question CLs")
    public ASPFormStep3 desiredTerminationDateValidation(){
        driver.verifyThat().element(desiredTerminationDateQuestion).text().isEqualTo(desiredTerminationDateQuestionCL).perform();
        driver.verifyThat().element(terminateAtDesiredDateLabel).text().isEqualTo(terminateAtDesiredDateLabelCL).perform();
        return this;
    }

    @Step("Validate that the calendar overlay is visible")
    public void calendarOverlayValidation(){
        driver.element().click(terminateAtDesiredDateRadioBtn);
        driver.element().click(dateIcon);
        driver.element().click(nextMonthButton);
        driver.verifyThat().element(calendarOverlay).isVisible().perform();
    }

    @Step("Validate date field error message")
    public void dateFieldErrorValidation(){
        driver.element().click(terminateAtDesiredDateRadioBtn);
        driver.element().click(terminationDateField);
        driver.element().keyPress(terminationDateField, Keys.TAB);
        driver.verifyThat().element(terminationDateFieldErrorMsg).isVisible().perform();
        driver.verifyThat().element(terminationDateField).cssProperty("color").contains("230, 0, 0").perform();
    }

    @Step("Validate date field error message wrong input")
    public void dateFieldInputErrorValidation(String terminationDate){
        driver.element().click(terminateAtDesiredDateRadioBtn);
        driver.element().type(terminationDateField,terminationDate);
        driver.element().keyPress(terminationDateField, Keys.TAB);
        driver.verifyThat().element(terminationDateFieldErrorMsg).isVisible().perform();
        driver.verifyThat().element(terminationDateField).cssProperty("color").contains("230, 0, 0").perform();
    }
    public void emailAddressHeaderValidation() {
        driver.verifyThat().element(EmailAddressHeader).text().contains(EmailAddressHeaderCL).perform();
    }

    @Step("Validate Giraffe fields displayed ")
    public ASPFormStep3 GiraffeUserfieldsValidation() {
        driver.verifyThat().element(EmailAddressHeader).textTrimmed().isEqualTo(EmailAddressHeaderCL).perform();
        driver.verifyThat().element(customernumber).textTrimmed().isEqualTo(customerNumberCL).perform();
        driver.verifyThat().element(Areacode).textTrimmed().isEqualTo(AreaCodeCL).perform();
        driver.verifyThat().element(Phonenumber).textTrimmed().isEqualTo(PhoneNumberCL).perform();
        driver.verifyThat().element(Producttype).textTrimmed().isEqualTo(ProducttypeCL).perform();
        driver.verifyThat().element(TVtitle).textTrimmed().isEqualTo(TVCL).perform();
        driver.verifyThat().element(Internettitle).textTrimmed().isEqualTo(InternetCL).perform();
        driver.verifyThat().element(Othertitle).textTrimmed().isEqualTo(OtherCL).perform();
        driver.verifyThat().element(CaptchaHeader).textTrimmed().isEqualTo(CapthcaheadreCL).perform();
        driver.verifyThat().element(Captchalapel).textTrimmed().isEqualTo(CapthcaLabelCL).perform();
        driver.verifyThat().element(Submitbutton).textTrimmed().isEqualTo(SubmitButtonCL).perform();
        driver.verifyThat().element(Submitlapel).textTrimmed().isEqualTo(RequiredFieldCL).perform();
        driver.verifyThat().element(EmailAddressContiner).isVisible();
        driver.verifyThat().element(customernumberContiner).isVisible();
        driver.verifyThat().element(AreacodeContiner).isVisible();
        driver.verifyThat().element(PhonenumberContiner).isVisible();
        return this;

    }

    @Step("Validate Camel fields displayed ")
    public ASPFormStep3 CamelUserfieldsValidation() {
        driver.verifyThat().element(EmailAddressHeader).text().isEqualTo(EmailAddressHeaderCL).perform();
        driver.verifyThat().element(customernumber).text().isEqualTo(customerNumberCL).perform();
        driver.verifyThat().element(contractnumber).text().isEqualTo(contractNumberCL).perform();
        driver.verifyThat().element(Areacode).text().isEqualTo(AreaCodeCL).perform();
        driver.verifyThat().element(Phonenumber).text().isEqualTo(PhoneNumberCL).perform();
        driver.verifyThat().element(Producttype).text().isEqualTo(ProducttypeCL).perform();
        driver.verifyThat().element(TVtitle).text().isEqualTo(TVCL).perform();
        driver.verifyThat().element(Internettitle).text().isEqualTo(InternetCL).perform();
        driver.verifyThat().element(Othertitle).text().isEqualTo(OtherCL).perform();
        driver.verifyThat().element(CaptchaHeader).text().isEqualTo(CapthcaheadreCL).perform();
        driver.verifyThat().element(Captchalapel).text().isEqualTo(CapthcaLabelCL).perform();
        driver.verifyThat().element(Submitbutton).text().isEqualTo(SubmitButtonCL).perform();
        driver.verifyThat().element(Submitlapel).text().isEqualTo(RequiredFieldCL).perform();
        driver.verifyThat().element(EmailAddressContiner).isVisible();
        driver.verifyThat().element(customernumberContiner).isVisible();
        driver.verifyThat().element(contractnumberContiner).isVisible();
        driver.verifyThat().element(AreacodeContiner).isVisible();
        driver.verifyThat().element(PhonenumberContiner).isVisible();
        return this;
    }

    @Step("Validate Deer fields displayed ")
    public ASPFormStep3 DeerUserfieldsValidation() {
        driver.verifyThat().element(EmailAddressHeader).textTrimmed().isEqualTo(EmailAddressHeaderCL).perform();
        driver.verifyThat().element(customernumber).textTrimmed().isEqualTo(customerNumberCL).perform();
        driver.verifyThat().element(Areacode).textTrimmed().isEqualTo(AreaCodeCL).perform();
        driver.verifyThat().element(Phonenumber).text().isEqualTo(PhoneNumberCL).perform();
        driver.verifyThat().element(TerminationReasons).text().isEqualTo(TerminationReasons_CL).perform();
        driver.verifyThat().element(Reason1Label).text().isEqualTo(Reason1CL).perform();
        driver.verifyThat().element(Reason2label).text().isEqualTo(Reason2CL).perform();
        driver.verifyThat().element(Reason3label).text().isEqualTo(Reason3CL).perform();
        driver.verifyThat().element(Reason4label).text().isEqualTo(Reason4CL).perform();
        driver.verifyThat().element(Producttype).text().isEqualTo(ProducttypeCL).perform();
        driver.verifyThat().element(TVtitle).text().isEqualTo(TVCL).perform();
        driver.verifyThat().element(Internettitle).text().isEqualTo(InternetCL).perform();
        driver.verifyThat().element(Othertitle).text().isEqualTo(OtherCL).perform();
        driver.verifyThat().element(CaptchaHeader).text().isEqualTo(CapthcaheadreCL).perform();
        driver.verifyThat().element(Captchalapel).text().isEqualTo(CapthcaLabelCL).perform();
        driver.verifyThat().element(Submitbutton).text().isEqualTo(SubmitButtonCL).perform();
        driver.verifyThat().element(Submitlapel).text().isEqualTo(RequiredFieldCL).perform();
        driver.verifyThat().element(EmailAddressContiner).isVisible();
        driver.verifyThat().element(customernumberContiner).isVisible();
        driver.verifyThat().element(AreacodeContiner).isVisible();
        driver.verifyThat().element(PhonenumberContiner).isVisible();
        return this;
    }

    @Step("Validate Fox fields displayed ")
    public ASPFormStep3 FoxUserfiledsValidation() {
        driver.verifyThat().element(EmailAddressHeader).textTrimmed().contains(EmailAddressHeaderCL).perform();
        driver.verifyThat().element(customernumber).text().isEqualTo(customerNumberCL).perform();
        driver.verifyThat().element(contractnumber).text().isEqualTo(contractNumberCL).perform();
        driver.verifyThat().element(Areacode).textTrimmed().isEqualTo(AreaCodeCL).perform();
        driver.verifyThat().element(Phonenumber).textTrimmed().isEqualTo(PhoneNumberCL).perform();
        driver.verifyThat().element(TerminationReasons).textTrimmed().isEqualTo(TerminationReasons_CL).perform();
        driver.verifyThat().element(Reason1Label).text().isEqualTo(Reason1CL).perform();
        driver.verifyThat().element(Reason2label).text().isEqualTo(Reason2CL).perform();
        driver.verifyThat().element(Reason3label).text().isEqualTo(Reason3CL).perform();
        driver.verifyThat().element(Reason4label).text().isEqualTo(Reason4CL).perform();
        driver.verifyThat().element(Producttype).text().isEqualTo(ProducttypeCL).perform();
        driver.verifyThat().element(TVtitle).text().isEqualTo(TVCL).perform();
        driver.verifyThat().element(Internettitle).text().isEqualTo(InternetCL).perform();
        driver.verifyThat().element(Othertitle).text().isEqualTo(OtherCL).perform();
        driver.verifyThat().element(CaptchaHeader).text().isEqualTo(CapthcaheadreCL).perform();
        driver.verifyThat().element(Captchalapel).text().isEqualTo(CapthcaLabelCL).perform();
        driver.verifyThat().element(Submitbutton).text().isEqualTo(SubmitButtonCL).perform();
        driver.verifyThat().element(Submitlapel).text().isEqualTo(RequiredFieldCL).perform();
        driver.verifyThat().element(EmailAddressContiner).isVisible();
        driver.verifyThat().element(customernumberContiner).isVisible();
        driver.verifyThat().element(AreacodeContiner).isVisible();
        driver.verifyThat().element(PhonenumberContiner).isVisible();
        driver.verifyThat().element(contractnumberContiner).isVisible();
        return this;
    }

}
