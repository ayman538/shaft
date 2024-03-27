package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class SolsticeChangeNumber {
    private SHAFT.GUI.WebDriver driver;

    public static By notificationHeader_text = By.cssSelector("h4.flexDiv");
    public static By notificationDescription_text = By.xpath("//*[text()='Du änderst hier gleichzeitig Deine Hauptrufnummer.']");
    private static By phoneNumber_inputField = By.id("numberField");
    private static By weiter_button = By.cssSelector("button[automation-id='btnSubmitForm_btn']");
    private static By smsCode_iputField = By.id("textboxMTan");
    private static By lastWeiter_button = By.xpath("//button[text()='Weiter']");
    public static final String changePhoneNumberHeader = "Wichtig!";
    public static final String changePhoneNumberDescription = "Du änderst hier gleichzeitig Deine Hauptrufnummer.";


    public SolsticeChangeNumber(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public SolsticeChangeNumber changePhoneNumberActions(String phoneNumber) {

        (new ElementActions(driver.getDriver())).type(phoneNumber_inputField, phoneNumber + "3")
                .keyPress(phoneNumber_inputField, Keys.BACK_SPACE)
                .click(weiter_button);
        return this;
    }

    public SolsticePhoneNumberConfirmation addSmsCode(String smsCode) {
        (new ElementActions(driver.getDriver())).type(smsCode_iputField, smsCode)
                .click(lastWeiter_button);
        return new SolsticePhoneNumberConfirmation(driver);
    }


}
