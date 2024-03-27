package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class GooglePayPage {
    SHAFT.GUI.WebDriver driver;
    private By emailFieldLocator = By.id("identifierId");
    private By passwordFieldLocator = By.xpath("//input[@type='password']");
    private By nextBtnLocator = By.xpath("//span[contains(.,'Next')]");
    private By payBtnLocator = By.xpath("//div[@role=\"button\"]");

    public GooglePayPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void enterEmail(String email) {
        driver.element().type( emailFieldLocator, email);
    }

    public void clickNextBtn() {
        driver.element().click( nextBtnLocator);
    }

    public void enterPassword(String password) {
        driver.element().type( passwordFieldLocator, password);
    }

    public void clickPayBtn() {
        driver.element().click( payBtnLocator);
    }

    public void enterGooglePayCredentials(String email, String password) {
        enterEmail(email);
        clickNextBtn();
        enterPassword(password);
        clickNextBtn();
        clickPayBtn();
    }
}
