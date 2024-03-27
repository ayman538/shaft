package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class TwoFADeactivation {

    private static SHAFT.GUI.WebDriver driver;

    public TwoFADeactivation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By checkBox = By.xpath("//input[@automation-id='checkboxItemModel.id_tv']");
    private By passwordFiled = By.xpath("//input[@automation-id='deactivatePasswordField_et']");
    private By submitButton = By.xpath("//button[@automation-id='submiAuthenticate_btn']");


    public TwoFADeactivation clickCheckBox() {
        driver.element().click(checkBox);
        return this;
    }
    public TwoFADeactivation typePW( String userPassword) {
        driver.element()
                .typeSecure(passwordFiled, userPassword)
                .click(submitButton);
        return this;
    }
}
