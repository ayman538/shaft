package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SofortPage {
    SHAFT.GUI.WebDriver driver;
    
    private By accountNumFieldLocator = By.id("BackendFormLOGINNAMEUSERID");
    private By pinFieldLocator = By.id("BackendFormUSERPIN");
    private By continueBtnLocator = By.xpath("//button[@class='button-right primary has-indicator']");
    private By acceptCookiesBtnLocator = By.xpath("(//div[@id='modal-button-container']//button[@class='cookie-modal-deny-all button-tertiary'])[2]");
    private By demoBankLabelLocator = By.xpath("//p[@data-label='demo-bank']");
    private By tanBtnLocator = By.id("BackendFormTan");
    private By closeSofortIconLocator = By.xpath("//a[@class='back-to-merchant cancel-transaction']");
    private By confirmCancelling = By.id("CancelTransaction");

    public SofortPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private void acceptCookies() {
        if (driver.element().getElementsCount(acceptCookiesBtnLocator) == 1) {
            driver.element().click( acceptCookiesBtnLocator);
        }
    }

    private void clickDemoBankLabel() {
        driver.element().click( demoBankLabelLocator);
    }

    private void enterAccountNum(String accountNum) {
        driver.element().type( accountNumFieldLocator, accountNum);
    }

    private void enterPin(String pin) {
        driver.element().type( pinFieldLocator, pin);
    }

    private void clickContinueBtn() {
        driver.element().click( continueBtnLocator);
    }

    private void enterTan(String tan) {
        driver.element().type( tanBtnLocator, tan);
    }

    @Step("enter sofort credentials and pay")
    public void enterSofortCredentials(String accountNum, String pin, String tan) {
        acceptCookies();
        clickDemoBankLabel();
        enterAccountNum(accountNum);
        enterPin(pin);
        clickContinueBtn();
        clickContinueBtn();
        enterTan(tan);
        clickContinueBtn();
    }
    @Step("cancel sofort payment")
    public void cancelSofortPayment(){
        driver.element().click(closeSofortIconLocator);
        driver.element().click(confirmCancelling);
    }
}
