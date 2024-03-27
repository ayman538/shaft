package de.vodafone.pages.MNP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By pageHeader = By.xpath("//*[@data-automation-id='pageHeader_tv']");
    private static By pageSubHeader = By.xpath("//*[@data-automation-id='subHeadline_tv']");
    private static By mitHandyNummerEinLoggenButton = By.xpath("//*[@data-automation-id='start_btn']");
    private static By zumStatusDeinerRufnummernMitnahmeButton = By.xpath("//*[@data-automation-id='status_btn']");
    private static By informationMessage = By.xpath("//*[@data-automation-id='warning_nt']/h5");
    private static By informationMessageDetails = By.xpath("//*[@data-automation-id='warning_nt']/p");
    private static By informationMessage2Title = By.xpath("//*[@data-automation-id='infoNotification_nt']/h5");
    private static By informationMessage2Number = By.xpath("//*[@data-automation-id='infoNotification_nt']/p");
    private static By vodafoneNumberInputField = By.xpath("//*[@id='phone-number-input']");
    private static By smsCodeAnfordernButton = By.xpath("//*[@id='validate-phone-btn-container']");
    private static By smsInputField = By.xpath("//*[@id='sms-input']");
    private static By anmeldenButton = By.xpath("//*[@id='authenticate-btn-container']/button");
    private static By moreInfoButton = By.xpath("//*[@data-automation-id='helpAndSupport_btn']");
    private static By acceptCookiesButtonLocator = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private static By abbrechenButton = By.xpath("(//*[@data-automation-id='contractButtons_gc'])//button[1]");
    private static By contractPrePaidRadioButton = By.xpath("(//div[@data-automation-id='contractTypesRadio_rb']//input[@label='Prepaid-Karte'])");
    private static By contractPostPaidRadioButton = By.xpath("(//div[@data-automation-id='contractTypesRadio_rb']//input[@label='Laufzeit-Vertrag'])");
    private static By weiterButton = By.xpath("(//*[@data-automation-id='contractButtons_gc'])//button[2]");
    private static By vodafoneNumber = By.xpath("//p[@data-automation-id='msisdn_tv']");
    private static By vodafoneNumberText = By.xpath("//p[@data-automation-id='msisdn_tv']");
    private static By mehrInfosZurRufnummernMitnahmeButton = By.xpath("//*[@data-automation-id='subHeader_tv']");
    private static By errorInformationMessage = By.xpath("//*[@data-automation-id='subHeader_tv']");
    private static By informationMessage2 = By.xpath("//*[@data-automation-id='subHeader_tv']");
    private static By jetztRufNummernMitnahmeStartenButton = By.xpath("//*[@data-automation-id='subHeader_tv']");
    private static By jaDasMöchteIchButton = By.xpath("//*[@data-automation-id='subHeader_tv']");

    // CLs
    private static String pageHeader_CL = "Rufnummer online mitbringen";
    private static String pageSubHeader_CL = "Melde Dich bitte an, um Deine Rufnummern-Mitnahme zu beauftragen. Warum? Damit Deine Daten geschützt sind.";
    private static String mitHandyNummerEinLoggenButtonCL = "Mit Handy-Nummer einloggen";
    private static String zumStatusDeinerRufnummernMitnahmeButtonCL = "Zum Status Deiner Rufnummern-Mitnahme";
    private static String informationMessageCL = "Schön, dass Du Deine Rufnummer zu uns mitbringen willst. Das klappt, wenn Du";
    private static String informationMessageDetailsCL = "schon Kund:in bei uns bist und einen Mobilfunk-Vertrag mit einer Mindestlaufzeit hast. Wenn Du CallYa hast, einen Geschäftskundenvertrag oder Kund:in in einem Rahmenvertrag bist, kannst Du Deine Rufnummer leider nicht nachträglich mitbringen. Das hat technische Gründe. schon Deine SIM-Karte mit Deiner Vodafone-Rufnummer von uns bekommen und in Dein Handy eingelegt hast. Nur dann kannst Du den SMS-Code empfangen. schon Dein Portierungsdaten-Dokument von Deinem bisherigen Anbieter eingeholt hast. Es enthält alle Daten, die für Deine Rufnummern-Mitnahme wichtig sind.";
    private static String informationMessage2CL = "Du ersetzt diese Rufnummer:";
    private static String vodafoneNumberTextCL = "Deine Vodafone-Rufnummer:";
    private static String errorInformationMessageCL = "Zum Status Deiner Rufnummern-Mitnahme";

    // DeepLinks
    private static String postPaidWeiterButtonURL = "hilfe/rufnummernmitnahme/vertrag-gekuendigt";
    private static String prePaidWeiterButtonURL = "hilfe/rufnummernmitnahme/fragebogen";
    private static String startPageURL = "hilfe/rufnummernmitnahme/start";
    private static String moreInfoButtonURL = "hilfe/bestellen/anbieterwechsel";

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate page Header and sub header CL")
    public LoginPage validateHeaderAndSubHeaderCL(){
        driver.verifyThat().element(pageHeader).textTrimmed().contains(pageHeader_CL).perform();
        driver.verifyThat().element(pageSubHeader).textTrimmed().contains(pageSubHeader_CL).perform();
        return this;
    }

    @Step("Validate mTan Login Button CL")
    public LoginPage validateMTanLoginButtonCL(){
        driver.verifyThat().element(mitHandyNummerEinLoggenButton).textTrimmed().contains(mitHandyNummerEinLoggenButtonCL).perform();
        return this;
    }

    @Step("Validate Status Page Button CL")
    public LoginPage validateStatusPageButtonCL(){
        driver.verifyThat().element(zumStatusDeinerRufnummernMitnahmeButton).textTrimmed().contains(zumStatusDeinerRufnummernMitnahmeButtonCL).perform();
        return this;
    }

    @Step("Validate Information Message CL")
    public LoginPage validateInformationMessageCL(){
        driver.verifyThat().element(informationMessage).textTrimmed().contains(informationMessageCL).perform();
        driver.verifyThat().element(informationMessageDetails).textTrimmed().contains(informationMessageDetailsCL).perform();
        return this;
    }

    @Step("Enter Vodafone Number")
    public LoginPage enterVodafoneNumber(String text){
        driver.verifyThat().element(vodafoneNumberInputField).isVisible().perform();
        driver.element().type(vodafoneNumberInputField,text);
        driver.element().click(smsCodeAnfordernButton);
        return this;
    }

    @Step("Enter SMS Number")
    public LoginPage enterSmsNumber(String text){
        driver.verifyThat().element(smsInputField).isVisible().perform();
        driver.element().type(smsInputField,text);
        driver.element().click(anmeldenButton);
        return this;
    }

    @Step("Click More Info Button")
    public LoginPage clickMoreInfoButton(){
        driver.element().click(moreInfoButton);
        return this;
    }

    @Step("Verify More Info Button Redirection")
    public LoginPage verifyMoreInfoButtonRedirection(){
        driver.verifyThat().browser().url().contains(moreInfoButtonURL).perform();
        return this;
    }

    @Step("Accept Cookies Button Click")
    public LoginPage acceptCookies() {
        driver.element().click(acceptCookiesButtonLocator);
        return this;
    }

    @Step("Click Weiter Button and Verify Redirection")
    public LoginPage clickWeiterButton(){
        driver.element().click(weiterButton);
        return this;
    }

    @Step("Select PrePaid  Contract Radio Button")
    public LoginPage clickPrepaidContractRadioButton() {
        driver.element().click(contractPrePaidRadioButton);
        return this;
    }

    @Step("Select PostPaid Contract Radio Button")
    public LoginPage clickPostpaidContractRadioButton() {
        driver.element().click(contractPostPaidRadioButton);
        return this;
    }

    @Step("Select Radio Button Option and Verify Redirection")
    public LoginPage verifyPrePaidWeiterButtonRedirection(){
        driver.verifyThat().browser().url().contains(prePaidWeiterButtonURL).perform();
        return this;
    }

    @Step("Select Radio Button Option and Verify Redirection")
    public LoginPage verifyPostPaidWeiterButtonOptionRedirection(){
        driver.verifyThat().browser().url().contains(postPaidWeiterButtonURL).perform();
        return this;
    }

    @Step("Click Abbrechen Button and Verify Redirection")
    public LoginPage clickAbbrechenButton(){
        driver.element().click(abbrechenButton);
        return this;
    }

    @Step("Verify Abbrechen Button Redirection")
    public LoginPage verifyAbbrechenButtonRedirection(){
        driver.verifyThat().browser().url().contains(startPageURL).perform();
        return this;
    }

    @Step("Validate Information Message CL")
    public LoginPage validateInformationMessage2CL(String number){
        driver.verifyThat().element(informationMessage2Title).textTrimmed().contains(informationMessage2CL).perform();
        driver.verifyThat().element(informationMessage2Number).textTrimmed().contains(number).perform();
        return this;
    }

    @Step("validate Vodafone Number exists")
    public LoginPage validateVodafoneNumberExists(String number){
        driver.verifyThat().element(vodafoneNumber).textTrimmed().contains(number).perform();
        return this;
    }

    @Step("Validate Vodafone Number CL Displayed")
    public LoginPage validateVodafoneNumberCLDisplayed() {
        driver.verifyThat().element(vodafoneNumberText).textTrimmed().contains(vodafoneNumberTextCL).perform();
        return this;
    }

    @Step("validate Mehr Infos zur Rufnummern-Mitnahme Button Is Clickable")
    public LoginPage validateMoreInfoButtonClickable(){
        driver.element().click(mehrInfosZurRufnummernMitnahmeButton);
        driver.verifyThat().browser().url().contains("/hilfe/").perform();
        return this;
    }

    @Step("Validate Vodafone Number Displayed")
    public String getVodafoneNumber() {
        String number = driver.element().getText(vodafoneNumber);
        return number;
    }

    @Step("validate Vodafone Number exists")
    public LoginPage validateVodafoneNumberExists(){
        driver.verifyThat().element(vodafoneNumber).textTrimmed().contains(getVodafoneNumber()).perform();
        return this;
    }

    @Step("Validate Information Message CL")
    public LoginPage validateErrorInformationMessageCL(){
        driver.verifyThat().element(errorInformationMessage).textTrimmed().contains(errorInformationMessageCL).perform();
        return this;
    }

    @Step("Validate Information Message CL")
    public LoginPage validateInformationMessage2CL(){
        driver.verifyThat().element(informationMessage2).textTrimmed().contains(informationMessage2CL).perform();
        return this;
    }

    @Step("Verify Jetzt Rufnummern-Mitnahme starten Button is dimmed")
    public LoginPage verifyJetztRufNummernMitnahmeStartenButtonIsDimmed(){
        driver.verifyThat().element(jetztRufNummernMitnahmeStartenButton).isDisabled().perform();
        return this;
    }

    @Step("Navigate to Deeplink - ST")
    public LoginPage choosePortingWithoutDocsButton() {

        driver.element().click(jaDasMöchteIchButton);
        return this;
    }
}