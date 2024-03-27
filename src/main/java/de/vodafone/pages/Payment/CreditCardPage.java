package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CreditCardPage {
    SHAFT.GUI.WebDriver driver;
    private By cardNumberFieldLocator = By.id("cardNumber");
    private By monthSelectorLocator = By.xpath("//button[@automation-id='month-chooser_btn']");
    private By yearSelectorLocator = By.xpath("//button[@automation-id='years-chooser_btn']");
    private By cvcFieldLocator = By.id("cvc");
    private By nameFieldLocator = By.id("name");
    private By D_SecureFieldLocator = By.xpath("//input[@class='input-field' ] ");
    private By D_SecureSubmitBtnLocator = By.id("buttonSubmit");
    private By D_SecureCancelBtnLocator = By.id("buttonCancel");

    public CreditCardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public void enterCardNum(String cardNum) {
        driver.element().type( cardNumberFieldLocator, cardNum);
    }



    public By getYearValueLocator(String year) {
        return By.xpath("//ul[@automation-id=\"years-chooser_lv\"]/li[contains(.,'" + year + "')]");
    }

    public By getMonthValueLocator(String month) {
        return By.xpath("//ul[@automation-id=\"month-chooser_lv\"]/li[contains(.,'" + month + "')]");
    }

    public void selectMonth(String month) {
        driver.element().click( monthSelectorLocator);
        driver.element().click( getMonthValueLocator(month));
    }

    public void selectYear(String year) {
        driver.element().click( yearSelectorLocator);
        driver.element().click( getYearValueLocator(year));
    }

    public void enterCVC(String cvc) {
        driver.element().type( cvcFieldLocator, cvc);
    }

    public void enterName(String name) {
        driver.element().type( nameFieldLocator, name);
    }

    public void enter3DSecure(String secureNum) {
        driver.element().type( D_SecureFieldLocator, secureNum);
    }

    public void submit3DSecure() {
        driver.element().click( D_SecureSubmitBtnLocator);
    }

    @Step("Entering Credit Cared Credentials")
    public void enterCreditCardCredentials(String cardNum, String month, String year, String cvc, String name) {
        enterCardNum(cardNum);
        selectMonth(month);
        selectYear(year);
        enterCVC(cvc);
        enterName(name);
        new TopupGPP(driver).payWithCreditCard();
    }

    public void enter3DSecureCredentials(String secureNum) {
        enter3DSecure(secureNum);
        submit3DSecure();
    }

    public void cancel3DSecure() {
        driver.element().click( D_SecureCancelBtnLocator);
    }
}
