package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class SolsticePersonEinladen {
    private SHAFT.GUI.WebDriver driver;
    public static By Anrede_textBox  = By.xpath("(//*[@value='Herr'])[1]");
    public static By Vorname_textBox  = By.xpath("//*[@automation-id='firstnameField_et']");
    public static By Nachname_textBox   = By.xpath("//*[@automation-id='lastnameField_et']");
    public static By Mail_textBox  = By.xpath("//*[@automation-id='emailField_et']");
    public static By Einladen_button = By.xpath("//*[text()='Einladung senden']");
    public static By VornameError_text = By.xpath("//*[@automation-id='firstnameFieldrequiredErrorMessage_et']");
    public static By NachError_text = By.xpath("//*[@automation-id='lastnameFieldrequiredErrorMessage_et']");
    public static By EmailError_text = By.xpath("//*[@automation-id='emailFieldrequiredErrorMessage_et']");
    public static String VornameError = "Gib bitte einen Vornamen ein.";
    public static String NachError = "Gib bitte einen Nachnamen ein.";
    public static String EmailError = "Gib bitte eine gültige E-Mail-Adresse ein.";

    public SolsticePersonEinladen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public SolsticePersonEinladen chooseAnrede() {
        new ElementActions(driver.getDriver()).click(Anrede_textBox);
        return this;
    }
    public SolsticePersonEinladen enterVorname(String FirstName ) {
        new ElementActions(driver.getDriver()).type(Vorname_textBox, FirstName);
        return this;
    }
    public SolsticePersonEinladen enterNachname(String LastName ) {
        new ElementActions(driver.getDriver()).type(Nachname_textBox, LastName);
        return this;
    }
    public SolsticePersonEinladen enterEmail(String Email ) {
        new ElementActions(driver.getDriver()).type(Mail_textBox, Email);
        return this;
    }

    public SolsticeEinladenConfirmation clickOnEinladen() {
        new ElementActions(driver.getDriver()).click(Einladen_button);
        return new SolsticeEinladenConfirmation(driver);
    }
    public SolsticePersonEinladen removeFirstNameField() {
        (new ElementActions(driver.getDriver())).click(Vorname_textBox);
        return this;
    }
    public SolsticePersonEinladen removeLastNameField() {
        (new ElementActions(driver.getDriver())).click(Nachname_textBox);
        return this;
    }
    public SolsticePersonEinladen removeEmailField( ) {
        (new ElementActions(driver.getDriver())).click(Mail_textBox);
        return this;
    }


}
