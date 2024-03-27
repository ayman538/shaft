package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PayPalPage {
    SHAFT.GUI.WebDriver driver;

    public PayPalPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By emailFieldLocator = By.id("email");
    private By passwordFieldLocator = By.id("password");
    private By saveAndContinueBtnLocator = By.id("consentButton");
    private By acceptCookiesBtnLocator = By.id("acceptAllButton");
    private By nextBtnLocator = By.id("btnNext");
    private By loginBtnLocator = By.id("btnLogin");

    public void acceptCookies() {
        if (driver.element().getElementsCount(acceptCookiesBtnLocator) == 1) {
            driver.element().click( acceptCookiesBtnLocator);
        }
        if (driver.element().getElementsCount(acceptCookiesBtnLocator) == 1) {
            driver.element().click( acceptCookiesBtnLocator);
        }
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

    public void clickLoginBtn() {
        driver.element().click( loginBtnLocator);
    }

    public void clickSaveAndContinue() {
        driver.element().click( saveAndContinueBtnLocator);
    }

    @Step("Enter Paypal credentials")
    public void enterPayPalCredentials(String email, String password) {
        acceptCookies();
        enterEmail(email);
        clickNextBtn();
        enterPassword(password);
        clickLoginBtn();
        clickSaveAndContinue();
    }

}
