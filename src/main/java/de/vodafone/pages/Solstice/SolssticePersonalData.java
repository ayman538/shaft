package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class SolssticePersonalData {
    private SHAFT.GUI.WebDriver driver;
    public static By Anrede_textBox  = By.xpath("(//*[@value='Herr'])[1]");
    public static By Vorname_textBox  = By.xpath("//*[@automation-id='firstnameField_et']");
    public static By Nachname_textBox   = By.xpath("//*[@automation-id='lastnameField_et']");
    public static By Weiter_button = By.xpath("//*[text()='Weiter']");
    public static By Phone_textBox = By.xpath("//*[@automation-id='phoneField_et']");
    public static By Password_textBox = By.xpath("//*[@automation-id='olPasswordInput_et']");
    public static By ConfirmPass_textBox = By.xpath("//*[@automation-id='repeatPasswordField_et']");
    public static By Captcha_inputField = By.xpath("//*[@automation-id='captchaField_et']");
    public static By Speichern_button = By.xpath("//*[text()='Speichern ']");



    public SolssticePersonalData(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SolssticePersonalData ChooseAnrede() {
        new ElementActions(driver.getDriver()).click(Anrede_textBox);
        return this;
    }
    public SolssticePersonalData enterVorname(String FirstName ) {
        new ElementActions(driver.getDriver()).type(Vorname_textBox, FirstName);
        return this;
    }
    public SolssticePersonalData enterNachname(String LastName ) {
        new ElementActions(driver.getDriver()).type(Nachname_textBox, LastName);
        return this;
    }
    public SolssticePersonalData clickWeiterButton() {
        new ElementActions(driver.getDriver()).click(Weiter_button);
        return this;
    }
    public SolssticePersonalData enterPhoneNumber(String phoneNumber) {
        new ElementActions(driver.getDriver()).type(Phone_textBox, phoneNumber);
        return this;
    }
    public SolssticePersonalData enterPass(String password) {
        new ElementActions(driver.getDriver()).typeSecure(Password_textBox, password);
        return this;
    }
    public SolssticePersonalData enterConfirmPass(String password) {
        new ElementActions(driver.getDriver()).typeSecure(ConfirmPass_textBox, password);
        return this;
    }
    public SolssticePersonalData enterCaptcha(String captcha) {
        new ElementActions(driver.getDriver()).type(Captcha_inputField, captcha);
        return this;
    }
    public SolsticePersonalDataReview clickSpeichern() {
        new ElementActions(driver.getDriver()).click(Speichern_button);
        return new SolsticePersonalDataReview(driver);
    }
}