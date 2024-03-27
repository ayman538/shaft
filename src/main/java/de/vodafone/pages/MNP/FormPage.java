package de.vodafone.pages.MNP;

import com.google.i18n.phonenumbers.Phonenumber;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.text.Normalizer;

public class FormPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By jaDasMöchteIchButton = By.xpath("//*[@data-automation-id='subHeader_tv']");
    private static By notificationMsgHeader = By.xpath("//*[@data-automation-id='portingData_nt']//h5");
    private static By notificationMsgBody = By.xpath("//*[@data-automation-id='portingData_nt']//p");
    private static By phoneNumber = By.xpath("//input[@data-automation-id='phoneNumber_et']");
    private static By emptySpace = By.xpath("(//*[@id='previousProvider_acc']//h5)[2]");
    private static By customerNumber = By.xpath("//input[@data-automation-id='customerNumber_et']");
    private static By providerCode = By.xpath("//*[@data-automation-id='provider_ddl']");
    private static By wrongMSISDNMsg = By.xpath("(//*[@id='previousProvider_acc']//span)[1]");
    private static By customerType = By.xpath("//*[@data-automation-id='customerType_rb']//h5");
    private static By privateCustomerType = By.xpath("(//*[@data-automation-id='customerType_rb']//input)[1]");
    private static By businessCustomerType = By.xpath("(//*[@data-automation-id='customerType_rb']//input)[2]");
    private static By customerName = By.xpath("(//div[@id='previousProvider_acc']//h5)[5]");
    private static By customerFirstName = By.xpath("//input[@data-automation-id='firstName_et']");
    private static By customerLastName = By.xpath("//input[@data-automation-id='lastName_et']");
    private static By customerFirstNameError = By.xpath("(//*[@id='previousProvider_acc']//span)[1]");
    private static By customerLastNameError = By.xpath("(//*[@id='previousProvider_acc']//span)[2]");
    private static By geburtsdatum = By.xpath("//input[@data-automation-id='birthDate_et']");
    private static By birthdateQ = By.xpath("(//*[@id='previousProvider_acc']//h5)[6]");
    private static By birthdateFormatError = By.xpath("(//*[@id='previousProvider_acc']//span)[3]");
    private static By companyName = By.xpath("//input[@data-automation-id='companyName_et']");
    private static By endOfContractNotificationMsgHeader = By.xpath("(//*[@id='previousProvider_acc']//h3)[3]");
    private static By endOfContractNotificationMsgBody = By.xpath("(//*[@id='previousProvider_acc']//p)[2]");
    private static By endOfContractNotificationMsgHeader_Business = By.xpath("(//*[@id='previousProvider_acc']//h3)[3]");
    private static By endOfContractNotificationMsgBody_Business = By.xpath("(//*[@id='previousProvider_acc']//p)[2]");
    private static By endOfContractDateLabel = By.xpath("(//*[@id='previousProvider_acc']//h5)[7]");
    private static By endOfContractDate = By.xpath("//input[@data-automation-id='endOfContract_et']");
    private static By optInDateLabel = By.xpath("(//*[@id='previousProvider_acc']//h5)[8]");
    private static By optInDate = By.xpath("//input[@data-automation-id='optInDate_et']");
    private static By weiterCTA = By.xpath("(//*[@data-automation-id='next_btn'])[1]");
    private static By JaDasMöchteIchCTA = By.xpath("//*[@data-automation-id='goToWithoutDocument_btn']");
    private static By yourDataFromPreviousProvider = By.xpath("//*[@id='previousProvider_acc']//h2");
    private static By customerNumberError = By.xpath("(//*[@data-automation-id='portingWithDocument_acc']//span)[1]");

    //CL
    private static String notificationMsgHeader_CL = "Wichtig";
    private static String notificationMsgBody_CL = "Gib nun die Daten aus Deinem Portierungs-Dokument in den entsprechenden Feldern an. Das Portierungsdaten-Dokument bekommst Du von Deinem bisherigen Anbieter, entweder per E-Mail oder Du findest es im Kundenportal . Es enthält alle Daten, die für Deine Rufnummernmitnahme wichtig sind. Bitte korrigiere nichts, auch wenn Daten offensichtlich vertauscht wurden oder falsch sind.";
    private static String ErfolgreichanD2uebermittelStatusHeader_CL = "Wir arbeiten dran";
    private static String wrongMSISDNMsg_CL = "Bitte gib eine gültige Handy-Nummer ein.";
    private static String providerCodeOption = "DOKO";
    private static String customerType_CL = "Bist Du Privat- oder Geschäftskunde?";
    private static String customername_CL = "Auf welchen Namen läuft der bisherige Vertrag?";
    private static String customerFirstNameError_CL = "Bitte füll noch das Feld aus.";
    private static String customerNumberError_CL = "Bitte gib eine gültige Handy-Nummer ein.";
    private static String birthdateQ_CL = "Welches Geburtsdatum steht im bisherigen Vertrag?";
    private static String birthdateFormatError_CL = "Bitte gib ein gültiges Datum ein: TT.MM.JJJJ";
    private static String endOfContractNotificationMsgHeader_CL = "Vertragsende bei Deinem bisherigen Anbieter";
    private static String endOfContractNotificationMsgBody_CL = "Wird in Deinem Portierungsdaten-Dokument keine Angabe zum \"Vertragsende\" oder zum \"Gültigkeitsdatum Opt-In\" gemacht, dann lass das betreffende Feld leer.";
    private static String endOfContractNotificationMsgBody_Business_CL = "Wird in Deinem Portierungsdaten-Dokument keine Angabe zum \"Vertragsende\" oder zum \"Gültigkeitsdatum Opt-In\" gemacht, dann lass das betreffende Feld leer.";
    private static String endOfContractDateLabel_CL = "Zu welchem Datum hast Du Deinen bisherigen Vertrag gekündigt?";
    private static String optInDateLabel_CL = "Gültigkeitsdatum Opt-In?";
    private static String yourDataFromPreviousProvider_CL = "Deine Daten bei Deinem bisherigen Anbieter";

    // DeepLinks
    private static String portingWithoutDocumentsURL = "hilfe/rufnummernmitnahme/bisheriger-anbieter";


    public FormPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click Porting Without Docs Button")
    public FormPage choosePortingWithoutDocsButton() {

        driver.element().click(jaDasMöchteIchButton);
        return this;
    }

    @Step("Validate notification msg")
    public FormPage validateNotificationMsg() {
        driver.verifyThat().element(notificationMsgHeader).text().isEqualTo(notificationMsgHeader_CL).perform();
        driver.verifyThat().element(notificationMsgBody).textTrimmed().contains(notificationMsgBody_CL).perform();
        return this;
    }

    @Step("fill MSISDN field")
    public FormPage fillPhoneNumberField(String phoneNumber) {
        driver.element().type(FormPage.phoneNumber,phoneNumber);
        return this;
    }

    @Step("fill MSISDN wit wrong format number")
    public FormPage fillWRONGPhoneNumberField(String wrongPhoneNumber) {
        driver.element().type(FormPage.phoneNumber,wrongPhoneNumber);
        driver.element().click(emptySpace);
        driver.element().waitToBeReady(wrongMSISDNMsg,true);
        driver.verifyThat().element(wrongMSISDNMsg).text().isEqualTo(wrongMSISDNMsg_CL).perform();
        return this;
    }

    @Step("choose previous company code from drop down menu")
    public FormPage choosePreviousCompanyCode() {
        driver.element().select(providerCode,providerCodeOption);
        return this;
    }

    @Step("choose customer type - private")
    public FormPage chooseCustomerTypeRadioButton() {
        driver.verifyThat().element(customerType).text().isEqualTo(customerType_CL).perform();
        driver.element().click(privateCustomerType);
        return this;
    }

    @Step("fill first name field")
    public FormPage fillCustomerFirstName(String vorname) {
        driver.verifyThat().element(customerName).text().isEqualTo(customername_CL).perform();
        driver.element().type(FormPage.customerFirstName,vorname);
        return this;
    }

    @Step("Leave first name field empty ")
    public FormPage leaveFirstNameEmpty() {
        WebElement firstName = driver.getDriver().findElement(customerFirstName);
        String text=firstName.getAttribute("value");
        while(!text.isEmpty()) {
            firstName.sendKeys(Keys.BACK_SPACE);
            text=firstName.getAttribute("value");
        }
        return this;
    }

    @Step("Validate mandatory error msg for First Name")
    public FormPage validateMandatoryErrorFirstName() {
        driver.verifyThat().element(customerFirstNameError).textTrimmed().contains(customerFirstNameError_CL).perform();
        return this;
    }

    @Step("fill last name field")
    public FormPage fillCustomerLastName(String nachname ) {
        driver.element().type(FormPage.customerLastName,nachname);
        return this;
    }

    @Step("leave last name field empty")
    public FormPage leaveLastNameEmpty() {
        WebElement lastName = driver.getDriver().findElement(customerLastName);
        String text=lastName.getAttribute("value");
        while(!text.isEmpty()) {
            lastName.sendKeys(Keys.BACK_SPACE);
            text=lastName.getAttribute("value");
        }
        return this;
    }

    @Step("Validate mandatory error msg for Last Name")
    public FormPage validateMandatoryErrorLastName(){
        driver.verifyThat().element(customerLastNameError).textTrimmed().contains(customerFirstNameError_CL).perform();
        return this;
    }

    @Step("fill birth date with right format")
    public FormPage fillBirthdate(String geburtsdatum) {
        driver.verifyThat().element(birthdateQ).text().isEqualTo(birthdateQ_CL).perform();
        driver.element().type(FormPage.geburtsdatum,geburtsdatum);
        return this;
    }

    @Step("fill end of contract date")
    public FormPage fillEndOfContractDate(String geburtsdatum) {
        driver.verifyThat().element(endOfContractDateLabel).text().isEqualTo(endOfContractDateLabel_CL).perform();
        driver.element().type(FormPage.endOfContractDate,geburtsdatum);
        return this;
    }

    @Step("fill OptIn date with right format")
    public FormPage fillOptInDate(String geburtsdatum) {
        driver.verifyThat().element(optInDateLabel).text().isEqualTo(optInDateLabel_CL).perform();
        driver.element().type(FormPage.optInDate,geburtsdatum);
        return this;
    }

    @Step("fill birthday field with wrong format")
    public FormPage fillWrongFormatBirthdate(String wrongFormatGeburtsdatum) {
        driver.element().type(FormPage.geburtsdatum,wrongFormatGeburtsdatum);
        return this;
    }

    @Step("Validate mandatory error msg for Birthdate Wrong Format")
    public FormPage validateMandatoryErrorBirthdate(){
        driver.verifyThat().element(birthdateFormatError).textTrimmed().contains(birthdateFormatError_CL).perform();
        return this;
    }

    @Step("fill company name field")
    public FormPage fillCompanyName(String firmenname) {
        driver.element().click(businessCustomerType);
        driver.element().type(FormPage.companyName,firmenname);
        return this;
    }

    @Step("leave company name field empty")
    public FormPage clearCompanyName() {
        WebElement firmenName = driver.getDriver().findElement(companyName);
        String text=firmenName.getAttribute("value");
        while(!text.isEmpty()) {
            firmenName.sendKeys(Keys.BACK_SPACE);
            text=firmenName.getAttribute("value");
        }
        return this;
    }

    @Step("Validate mandatory error msg for Company Name")
    public FormPage validateMandatoryErrorCompanyName(){
        driver.verifyThat().element(customerFirstNameError).textTrimmed().contains(customerFirstNameError_CL).perform();
        return this;
    }

    @Step("fill customer number with right format")
    public FormPage fillCustomerNumberField(String phoneNumber) {
        driver.element().click(businessCustomerType);
        driver.element().type(FormPage.customerNumber,phoneNumber);
        return this;
    }

    @Step("Try wrong customer number")
    public FormPage fillWrongCustomerNumberField(String wrongPhoneNumber) {
        driver.element().click(businessCustomerType);
        driver.element().type(FormPage.customerNumber,wrongPhoneNumber);
        return this;
    }

    @Step("Validate mandatory error msg for Customer number")
    public FormPage validateMandatoryErrorCustomerNumber(){
        driver.verifyThat().element(customerNumberError).textTrimmed().contains(customerNumberError_CL).perform();
        return this;
    }

    @Step("validate end of contract notification msg")
    public FormPage validateEndOfContractNotificationMsg() {
        driver.verifyThat().element(endOfContractNotificationMsgHeader).text().isEqualTo(endOfContractNotificationMsgHeader_CL).perform();
        driver.verifyThat().element(endOfContractNotificationMsgBody).text().isEqualTo(endOfContractNotificationMsgBody_CL).perform();
        return this;
    }

    @Step("validate end of contract notification msg for business customer")
    public FormPage validateEndOfContractNotificationMsg_Business() {
        driver.element().click(businessCustomerType);
        driver.verifyThat().element(endOfContractNotificationMsgHeader_Business).text().isEqualTo(endOfContractNotificationMsgHeader_CL).perform();
        driver.verifyThat().element(endOfContractNotificationMsgBody_Business).text().isEqualTo(endOfContractNotificationMsgBody_Business_CL).perform();
        return this;
    }

    @Step("Click on Weiter CTA yo proceed to next step")
    public FormPage clickOnWeiterCTA() {
        driver.element().click(weiterCTA);
        return this;
    }

    @Step("Validate Step 2 Appear")
    public FormPage validateStep2() {
        driver.verifyThat().element(yourDataFromPreviousProvider).text().isEqualTo(yourDataFromPreviousProvider_CL).perform();
        driver.element().click(yourDataFromPreviousProvider);
        driver.verifyThat().element(notificationMsgHeader).exists().perform();

        return this;
    }

    @Step("Click Porting Without Docs Button")
    public FormPage clickOnPortingWODocumentCTA() {
        driver.element().click(JaDasMöchteIchCTA);
        driver.verifyThat().browser().url().contains(portingWithoutDocumentsURL).perform();
        return this;
    }
}