package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MergeAccountsSetNewPasswordStep {
    private static SHAFT.GUI.WebDriver driver;
    public MergeAccountsSetNewPasswordStep(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private By password1Input = By.xpath("//input[@automation-id='passwordField_et']");
    private By password2Input = By.xpath("//input[@automation-id='repeatPasswordField_et']");
    private By weiterButton = By.xpath("//button[@class='btn btn-sml']");

    public MergeAccountsSetNewPasswordStep typePassword1(String username){
        driver.element().type(password1Input, username);
        return this;
    }
    public MergeAccountsSetNewPasswordStep typePassword2(String password){
        driver.element().type(password2Input, password);
        return this;
    }
    public MergeAccountsSetNewPasswordStep clickWeiterButton() {
        driver.element().click(weiterButton);
        return this;
    }

}
