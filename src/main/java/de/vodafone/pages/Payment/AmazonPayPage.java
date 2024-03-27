package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AmazonPayPage {
    SHAFT.GUI.WebDriver driver;
    public AmazonPayPage (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }
    private By emailFieldLocator = By.id("ap_email");
    private By passwordFieldLocator = By.id("ap_password");
    private By signInBtnLocator = By.id("signInSubmit");
    private By payNowBtnLocator = By.xpath("//span[@id='a-autoid-0']//input");
    private By cancelLocator = By.xpath("//*[@id='return_back_to_merchant_link']");

    public void enterEmail(String email){
        driver.element().type(emailFieldLocator,email);
    }
    public void enterPassword(String password){
        driver.element().type(passwordFieldLocator,password);
    }
    public void clickSignIn(){
        driver.element().click(signInBtnLocator);
    }
    public void clickPayNow(){
        driver.element().click(payNowBtnLocator);
    }
    public void clickCancelFlow(){
        driver.element().click(cancelLocator);
    }

    public void enterAmazonPayCredentials(String email , String password){
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
        clickPayNow();
    }
    public void cancelAmazonFlow(String email , String password){
        enterEmail(email);
        enterPassword(password);
        clickSignIn();
        clickCancelFlow();
    }
}
