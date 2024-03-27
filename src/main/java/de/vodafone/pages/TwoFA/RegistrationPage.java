package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RegistrationPage {
    private SHAFT.GUI.WebDriver driver;

    public RegistrationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By requestActivationCodeCTA = By.xpath("//a[@automation-id='request-activationCode_Link']");


    public RegistrationPage clickOnRequestActivationCode() {
//        driver.element().click(requestActivationCodeCTA);
        driver.element().clickUsingJavascript(requestActivationCodeCTA);
        return this;
    }
}
