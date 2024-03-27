package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.ASP.ASPFormStep1;
import org.openqa.selenium.By;

public class MergeAccountsCredentialsStep {
    private static SHAFT.GUI.WebDriver driver;
    public MergeAccountsCredentialsStep(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    private By usernameInput = By.xpath("//input[@automation-id='txtUsername_et']");
    private By passwordInput = By.xpath("//input[@automation-id='txtPassword_et']");
    private By weiterButton = By.xpath("//button[@class='btn btn-em btn-sml']");

    public MergeAccountsCredentialsStep typeUsername(String username){
        driver.element().type(usernameInput, username);
        return this;
    }
    public MergeAccountsCredentialsStep typePassword(String password){
        driver.element().type(passwordInput, password);
        return this;
    }
    public MergeAccountsCredentialsStep clickWeiterButton() {
        driver.element().click(weiterButton);
        return this;
    }

}
