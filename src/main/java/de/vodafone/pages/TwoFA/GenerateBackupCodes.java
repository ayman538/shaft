package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class GenerateBackupCodes {

    private static SHAFT.GUI.WebDriver driver;

    public GenerateBackupCodes(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By passwordFiled = By.xpath("//input[@automation-id='passwordField_et']");
    private By submitButton = By.xpath("//button[@automation-id='submitpassword_btn']");



    public GenerateBackupCodes typePasscode( String userPassword) {
        driver.element()
                .typeSecure(passwordFiled, userPassword)
                .click(submitButton);
        return this;
    }
}
