package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class RequestActivationCodePage {
    private SHAFT.GUI.WebDriver driver;

    public RequestActivationCodePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By title = By.xpath("//span[@automation-id=\"oneStepStepperHeader_tv\"]");
    private By descriprion = By.xpath("//p[@automation-id=\"solsticeAdditionalNumberstv\"]");
    private By federalStateTitle = By.xpath("(//div[@class=\"fm-data\"]//label)[1]");
    private By federalStatePlaceHolder = By.xpath("//button[@class=\"select-toggle\"]");
    private By federalStateDropdown = By.xpath("//button[@automation-id=\"stateField_btn\"]");
    private By federalStateInfoCTA = By.xpath("(//a[@class=\"tg-icon\"])[1]");
    private By federalStateInfoText = By.xpath("(//p[@automation-id=\"undefined_tv\"])[1]");
    private By customerNumberTitle = By.xpath("(//div[@class=\"fm-data\"]//label)[2]");
    private By customerNumberInputField = By.xpath("//input[@automation-id=\"customerNumber_et\"]");
    private By customerNumberInfoCTA = By.xpath("(//a[@class=\"tg-icon\"])[2]");
    private By customerNumberInfoText = By.xpath("(//p[@automation-id=\"undefined_tv\"])[2]");
    private By postalCodeTitle = By.xpath("(//div[@class=\"fm-data\"]//label)[3]");
    private By postalCodeInputField = By.xpath("//input[@automation-id=\"postalCode_et\"]");
    private By postalCodeInfoCTA = By.xpath("(//a[@class=\"tg-icon\"])[3]");
    private By postalCodeInfoText = By.xpath("(//p[@automation-id=\"undefined_tv\"])[3]");
    private By requiredFieldsMsg = By.xpath("//span[@automation-id=\"additional-label_tv\"]");
    private By continueCTA = By.xpath("//button[@automation-id=\"submit_tv\"]");
    private By backCTA = By.xpath("//a[@automation-id=\"back_Link\"]");
    private By captchaTitle = By.xpath("(//div[@class=\"fm-data\"]//label)[4]");
    private By captcha = By.xpath("//img[@class=\"captcha width-200 mr-10\"]");
    private By captchaInputField = By.xpath("//input[@automation-id=\"captcha_et\"]");
    private By emptyCustomerNumberErrorMsg = By.xpath("//p[@automation-id=\"customerNumberrequiredErrorMessage_et\"]");
    private By emptyPostalCodeErrorMsg = By.xpath("//p[@automation-id=\"postalCoderequiredErrorMessage_et\"]");
    private By emptyCaptchaErrorMsg = By.xpath("//p[@automation-id=\"captcharequiredErrorMessage_et\"]");
    private By wrongCustomerNumberErrorMsg = By.xpath("//p[@automation-id=\"customerNumber_patternErrorMessage_et\"]");
    private By wrongPostalCodeErrorMsg = By.xpath("//p[@automation-id=\"postalCode_patternErrorMessage_et\"]");

    private String titleCL = "Wähl einen neuen Benutzernamen";
    private String descriprionCL = "Gib bitte Deine Kundennummer und Deine Postleitzahl ein.";
    private String federalStateTitleCL = "Bundesland *";
    private String federalStatePlaceHolderCL = "Bitte auswählen";
    private String federalStateInfoIconCL = "Wähl bitte das Bundesland aus, in dem Du wohnst. Oder in dem Dein ehemaliger Unitymedia-Vertrag gültig ist.";
    private String customerNumberTitleCL = "Kundennummer *";
    private String customerNumberInfoIconCL = "Deine Kundennummer besteht aus höchstens 10 Ziffern - keine Buchstaben, Leerzeichen oder Sonderzeichen. Du findest sie auf Deinen Unitymedia- oder Vodafone- Vertragsunterlagen und auf Deiner Rechnung.";
    private String postalCodeTitleCL = "Postleitzahl *";
    private String postalCodeInfoIconCL = "Die Postleitzahl ist 5-stellig - keine Buchstaben, Leerzeichen oder Sonderzeichen.";
    private String requiredFieldsCL = "* Pflichtfelder";
    private String continueCTA_CL = "Prüfen";
    private String cancelCTA_CL = "Abbrechen";
    private String captchaTitleCL = "Sicherheitscode *";
    private String emptyCustomerNumberErrorMsgCL = "Das Feld darf nicht leer sein.";
    private String emptyPostalCodeErrorMsgCL = "Das Feld darf nicht leer sein.";
    private String emptyCaptchaErrorMsgCL = "Gib bitte den Sicherheitscode ein.";
    private String wrongCustomerNumberErrorMsgCL = "Die Kundennummer darf nur Zahlen enthalten - keine Leerzeichen, Buchstaben oder Sonderzeichen.";
    private String wrongPostalCodeErrorMsgCL = "Die Postleitzahl ist 5-stellig.";


    @Step("get Federal state locator")
    public By getFederalStateLocator(String federalState) {
        return By.xpath("//button[text()='" + federalState + "']");
    }

    @Step("Fill the required fields with valid data")
    public RequestActivationCodePage fillRequiredFieldsAsLoggedUMUser(String federalState, String customerNumber, String postalCode) {
        driver.element().click(federalStateDropdown).click(getFederalStateLocator(federalState))
                .type(customerNumberInputField, customerNumber)
                .type(postalCodeInputField, postalCode);
        return this;
    }

    @Step("Fill the required fields with valid data")
    public RequestActivationCodePage fillRequiredFieldsAsUnauthorizedUser(String federalState, String customerNumber, String postalCode, String captcha) {
        fillRequiredFieldsAsLoggedUMUser(federalState, customerNumber, postalCode);
        driver.element().type(captchaInputField, captcha);
        return this;
    }

    @Step("Fill the required fields with valid data")
    public RequestActivationCodePage leaveBundeslandFieldEmpty() {
        driver.element().click(federalStateDropdown).click(postalCodeInputField);
        return this;
    }

    @Step("Click on Continue CTA")
    public RequestActivationCodePage clickOnContinueCTA() {
        driver.element().click(continueCTA);
        return this;
    }

    @Step("Click on Cancel CTA")
    public RequestActivationCodePage clickOnCancelCTA() {
        driver.element().click(backCTA);
        return this;
    }

    @Step("Verify Request Activation code page CLs as Logged in UM user")
    public void verifyLoggedUMUserRequestActivationCodeCLs() {
        driver.verifyThat().element(title).text().isEqualTo(titleCL).perform();
        driver.verifyThat().element(descriprion).text().isEqualTo(descriprionCL).perform();
        driver.verifyThat().element(federalStateTitle).text().isEqualTo(federalStateTitleCL).perform();
        driver.verifyThat().element(federalStatePlaceHolder).text().isEqualTo(federalStatePlaceHolderCL).perform();
        driver.verifyThat().element(customerNumberTitle).text().isEqualTo(customerNumberTitleCL).perform();
        driver.verifyThat().element(postalCodeTitle).text().isEqualTo(postalCodeTitleCL).perform();
        driver.verifyThat().element(requiredFieldsMsg).text().isEqualTo(requiredFieldsCL).perform();
        driver.verifyThat().element(continueCTA).text().isEqualTo(continueCTA_CL).perform();
        driver.verifyThat().element(backCTA).text().isEqualTo(cancelCTA_CL).perform();
    }

    @Step("Verify Info icon CLs as Logged in UM user")
    public RequestActivationCodePage verifyInfoIconCLs() {
        driver.element().click(federalStateInfoCTA).verifyThat(federalStateInfoText).text().isEqualTo(federalStateInfoIconCL).perform();
        driver.element().click(customerNumberInfoCTA).verifyThat(customerNumberInfoText).text().isEqualTo(customerNumberInfoIconCL).perform();
        driver.element().click(postalCodeInfoCTA).verifyThat(postalCodeInfoText).text().isEqualTo(postalCodeInfoIconCL).perform();
        return this;
    }

    @Step("Verify Request Activation code page CLs as Unauthorized UM user")
    public void verifyUnauthorizedActivationPageCLs() {
        verifyLoggedUMUserRequestActivationCodeCLs();
        driver.verifyThat().element(captcha).exists().withCustomReportMessage("Captcha is displayed successfully").perform();
        driver.verifyThat().element(captchaTitle).text().isEqualTo(captchaTitleCL).perform();
    }

    @Step("Validate Empty Federal state behaviour")
    public RequestActivationCodePage validateEmptyFederalState() {
        driver.verifyThat().element(continueCTA).isDisabled().perform();
        driver.assertThat()
                .element(federalStateDropdown)
                .cssProperty("border-bottom-color")
                .contains("230, 0, 0")
                .perform();
        return this;
    }

    @Step("Validate Empty Customer Number Error Message")
    public RequestActivationCodePage validateEmptyCustomerNumberErrorMsg() {
        driver.verifyThat().element(emptyCustomerNumberErrorMsg).exists();
        driver.verifyThat().element(emptyCustomerNumberErrorMsg).textTrimmed().isEqualTo(emptyCustomerNumberErrorMsgCL).perform();
        return this;
    }

    @Step("Validate Empty Postal code Error Message")
    public RequestActivationCodePage validateEmptyPostalCodeErrorMsg() {
        driver.element().keyPress(postalCodeInputField, Keys.TAB);
        driver.verifyThat().element(emptyPostalCodeErrorMsg).exists().withCustomReportMessage("Empty customer number Error Message appeared successfully");
        driver.verifyThat().element(emptyPostalCodeErrorMsg).textTrimmed().isEqualTo(emptyPostalCodeErrorMsgCL).perform();
        return this;
    }

    @Step("Validate Empty captcha Error Message")
    public RequestActivationCodePage validateEmptyCaptchaErrorMsg() {
        driver.element().keyPress(captchaInputField,Keys.TAB);
        driver.verifyThat().element(emptyCaptchaErrorMsg).exists().perform();
        driver.verifyThat().element(emptyCaptchaErrorMsg).textTrimmed().isEqualTo(emptyCaptchaErrorMsgCL).perform();
        return this;
    }

    @Step("Validate Wrong Customer Number Error Message")
    public RequestActivationCodePage validateWrongCustomerNumberErrorMsg() {
        driver.verifyThat().element(wrongCustomerNumberErrorMsg).exists().perform();
        driver.verifyThat().element(wrongCustomerNumberErrorMsg).textTrimmed().isEqualTo(wrongCustomerNumberErrorMsgCL).perform();
        return this;
    }

    @Step("Validate Wrong Postal Code Error Message")
    public RequestActivationCodePage validateWrongPostalcodeErrorMsg() {
        driver.element().keyPress(postalCodeInputField,Keys.TAB);
        driver.verifyThat().element(wrongPostalCodeErrorMsg).exists().perform();
        driver.verifyThat().element(wrongPostalCodeErrorMsg).textTrimmed().isEqualTo(wrongPostalCodeErrorMsgCL).perform();
        return this;
    }
}