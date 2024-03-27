package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class TwoFAloginPage {


    private static SHAFT.GUI.WebDriver driver;

    public TwoFAloginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By username = By.xpath("//input[@id='txtUsername']");
    private By password=By.xpath("//input[@id='txtPassword']");

    private By pageHeader = By.xpath("//div[@class='content-wrap']/h1");
    private By  subHeader = By.xpath("//div[@class='content-wrap']/h2");
    private By notificationMsg = By.xpath("//h4[@class='flexDiv']");
    private By notificationSubline = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By informationMsg = By.xpath("//p[@automation-id='totpcodeTxt_tv']");
    private By codelabel = By.xpath("(//div[@class='tg-label']/label)[1]");
    private By codefield = By.xpath("//input[@id='totpcontrol']");

    private By loginButton = By.xpath("(//button[@class='btn login-btn'])[1]");
    private By backupButton = By.xpath("//a[@automation-id='toggleBtn_btn']");
    private By twoFAButton = By.xpath("//a[@automation-id='toggleTOTPCodeBtn_btn']");

    private By codeEmptymsg = By.xpath("//p[@automation-id='totpcontrolrequiredErrorMessage_et']");
    private By wrongRegexmsg = By.xpath("//p[@automation-id='totpcontrol_patternErrorMessage_et']");
    private By wrongCodemsgHedear = By.xpath("(//div[@class='flex-disply'])[2]");
    private By wrongCodemsgsubHedear = By.xpath("(//p[@class='notification-text mb-10 mt-10'])[2]");
    private By backuplabel = By.xpath("(//div[@class='tg-label']/label)[1]");

    private String pageHeader_CL = "Willkommen bei MeinVodafone";
    private By informationMsgBUC = By.xpath("//p[@automation-id='loginWithBUCCode_tv']");
    private By bucField = By.xpath("//input[@automation-id='bucCodeField_et']");
    private By emptyFieldBucError = By.xpath("//p[@automation-id='bucCodeFieldrequiredErrorMessage_et']");
    private By wrongRegexBucError = By.xpath("//p[@automation-id='bucCodeField_patternErrorMessage_et']");
    private By invalidBucMsgHeader = By.xpath("(//h4[@class='flexDiv'])[2]");
    private By invalidBucMsgSubHeader = By.xpath("(//p[@class='notification-text mb-10 mt-10'])[2]");
    private By blockedBucMsgHeader = By.xpath("(//div[@class='flex-disply'])[2]");
    private By blockedBucMsgSubHeader = By.xpath("(//p[@class='notification-text mb-10 mt-10'])[2]");
    private String subHeader_CL = "Dein persönliches Service-Portal";
    private String notificationMsg_CL = "Ab jetzt verwaltest Du alle Verträge und Services in MeinVodafone.";
    private String notificationSubline_CL = "Du hast Fragen oder Probleme? Hier bekommst Du Hilfe.";
    private String informationMsg_CL = "Gib hier den 6-stelligen Zahlen-Code aus Deiner Authentifizierungs-App ein.";
    private String codelabel_CL = "Zahlen-Code *";
    private String backuplabel_CL = "Backup-Code *";
    private String loginButton_CL = "Login";

    private String backButton_CL = "Abbrechen";
    private String backupbutton_CL = "Mit Backup-Code einloggen";
    private String codeEmptymsg_CL = "Das Feld darf nicht leer sein. Gib bitte einen gültigen Code ein.";
    private String wrongRegexmsg_CL = "Gib bitte einen gültigen Code ein. Er besteht aus 6 Zahlen.";
    private String wrongCodemsgHedear_CL = "Hier stimmt was nicht";
    private String wrongCodemsgsubHedear_CL = "Du hast den Zahlen-Code falsch eingegeben. Versuch es bitte nochmal.";
    private String errormsgHedear_CL = "Zugang gesperrt";
    private String errormsgsubHedear_CL = "Leider hast Du die Login-Daten wiederholt falsch eingegeben. Aus Sicherheitsgründen haben wir den Zugang für 24 Stunden gesperrt.";
    private String informationMsgBUC_CL = "Gib hier Deinen 10-stelligen Backup-Code ein.";
    private String twoFAButton_CL = "Mit Authentifizierungs-App einloggen";
    private String emptyFieldBucError_CL = "Das Feld darf nicht leer sein. Gib bitte einen gültigen Code ein.";
    private String wrongRegexBucError_CL = "Gib bitte einen gültigen Code ein. Er besteht aus 10 Zahlen.";
    private String blockedBucMsgHeader_CL = "Zugang gesperrt";
    private String blockedBucMsgSubHeader_CL = "Leider hast Du die Login-Daten wiederholt falsch eingegeben. Aus Sicherheitsgründen haben wir den Zugang für 24 Stunden gesperrt.";
    private String invalidBucMsgHeader_CL = "Hier stimmt was nicht";
    private String invalidBucMsgSubHeader_CL = "Dein Backup-Code ist falsch. Versuch es bitte nochmal.";




    public TwoFAloginPage login2FA(String userName, String userPassword) {
        driver.element()
                .type(username, userName)
                .typeSecure(password, userPassword)
                .click(loginButton);
        return this;
    }
    public TwoFAloginPage  loginwithbuc() {
        driver.element().click(backupButton);
        return this;
    }
    public TwoFAloginPage  loginwith2fa() {
        driver.element().click(twoFAButton);
        return this;
    }

    public TwoFAloginPage  clicklogin() {
        driver.element().click(loginButton);
        return this;
    }
    public TwoFAloginPage  insertcode(String code) {
        driver.element().type(codefield, code);
        return this;
    }
    public TwoFAloginPage typeBUC(String code) {
        driver.element().type(bucField, code);
        return this;
    }
    public TwoFAloginPage emptyBucField() {
        driver.element().keyPress(bucField, Keys.TAB);
        return this;
    }

    public TwoFAloginPage clickemptycodeField() {
        driver.element().keyPress(codefield, Keys.TAB);
        return this;
    }

    @Step("Verify 2FA step1 page")
    public void loginPageValidation() {
        driver.verifyThat().element(pageHeader).text().isEqualTo(pageHeader_CL).perform();
        driver.verifyThat().element(subHeader).text().isEqualTo(subHeader_CL).perform();
        driver.verifyThat().element(notificationMsg).text().isEqualTo(notificationMsg_CL).perform();
        driver.verifyThat().element(notificationSubline).text().isEqualTo(notificationSubline_CL).perform();
        driver.verifyThat().element(informationMsg).text().isEqualTo(informationMsg_CL).perform();
        driver.verifyThat().element(codelabel).text().isEqualTo(codelabel_CL).perform();
        driver.verifyThat().element(loginButton).text().isEqualTo(loginButton_CL).perform();
        driver.verifyThat().element(codefield).isVisible().perform();
    }
    @Step("Verify Error msg when code field is empty")
    public void emptycodeValidation() {
        driver.verifyThat().element(codeEmptymsg).textTrimmed().isEqualTo(codeEmptymsg_CL).perform();

    }
    @Step("Verify Error msg in case of worng code regex")
    public void codeRegexValidation() {
        driver.verifyThat().element(wrongRegexmsg).textTrimmed().isEqualTo(wrongRegexmsg_CL).perform();

    }
    @Step("Verify Error msg when code is incorrect")
    public void wrongcodeValidation() {
        driver.verifyThat().element(wrongCodemsgHedear).textTrimmed().isEqualTo(wrongCodemsgHedear_CL).perform();
        driver.verifyThat().element(wrongCodemsgsubHedear).textTrimmed().isEqualTo(wrongCodemsgsubHedear_CL).perform();

    }
    @Step("Verify Error msg when user is terminated")
    public void terminatedValidation() {
        driver.verifyThat().element(wrongCodemsgHedear).textTrimmed().isEqualTo(errormsgHedear_CL).perform();
        driver.verifyThat().element(wrongCodemsgsubHedear).textTrimmed().isEqualTo(errormsgsubHedear_CL).perform();

    }
    @Step("Verify backup label is displayed")
    public void backuplabelValidation() {
        driver.verifyThat().element(backuplabel).textTrimmed().isEqualTo(backuplabel_CL).perform();


    }
    @Step("Verify 2fa label is displayed")
    public void twoFAlabelValidation() {
        driver.verifyThat().element(codelabel).textTrimmed().isEqualTo(codelabel_CL).perform();
    }

    @Step("Verify Cl in login with backup code page")
    public void loginWithBucPageValidation(){
        driver.verifyThat().element(informationMsgBUC).textTrimmed().isEqualTo(informationMsgBUC_CL).perform();
        driver.verifyThat().element(backuplabel).textTrimmed().isEqualTo(backuplabel_CL).perform();
        driver.verifyThat().element(loginButton).textTrimmed().isEqualTo(loginButton_CL).perform();
        driver.verifyThat().element(twoFAButton).textTrimmed().isEqualTo(twoFAButton_CL).perform();
    }

    @Step("Check error msg for empty BUC field")
    public void validateEmptyBucFieldError() {
        driver.verifyThat().element(emptyFieldBucError).textTrimmed().isEqualTo(emptyFieldBucError_CL).perform();
    }

    @Step("Check error msg for wrong BUC regex")
    public void validateWrongRegexBucFieldError() {
        driver.verifyThat().element(wrongRegexBucError).textTrimmed().isEqualTo(wrongRegexBucError_CL).perform();
    }

    @Step("Check error notification for blocked BUC when user enters invalid buc too many times")
    public void validateBlockedBucErrorMsg() {
        driver.verifyThat().element(blockedBucMsgHeader).textTrimmed().isEqualTo(blockedBucMsgHeader_CL).perform();
        driver.verifyThat().element(blockedBucMsgSubHeader).textTrimmed().isEqualTo(blockedBucMsgSubHeader_CL).perform();
        driver.verifyThat().element(username).isVisible().perform();
    }

    @Step("Check error notification for invalid BUC code")
    public void validateInvalidBucErrorMsg() {
        driver.verifyThat().element(invalidBucMsgHeader).textTrimmed().isEqualTo(invalidBucMsgHeader_CL).perform();
        driver.verifyThat().element(invalidBucMsgSubHeader).textTrimmed().isEqualTo(invalidBucMsgSubHeader_CL).perform();
        driver.verifyThat().element(backuplabel).isVisible().perform();
    }
}

