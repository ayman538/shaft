package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChangeInternetPassword {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By oldPasswordField_Locator = By.xpath("//input[@id='old_password']");
    private By newPasswordField_Locator = By.xpath("//input[@id='new_password']");
    private By repeatPasswordField_Locator = By.xpath("//input[@id='repeat_password']");
    private By submitPasswordBtn_Locator = By.xpath("//button[@automation-id = 'submitNewPassword_btn']");
    private By notificationTitle_Locator = By.xpath("(//div[@class='item-2 w-100']//h4)[1]");
    private By notificationDescription_Locator = By.xpath("(//div[@class='alert-content']//p)[1]");
    private By zuruckBtn_Locator = By.xpath("//a[@automation-id='back_Link']");
    private By loginDatenAccordion_Locator = By.xpath("//li[@automation-id='manageAccountData_acc']/a");


    //Methods
    public ChangeInternetPassword(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("insert old password")
    public void insertOldPassword(String oldPassword){
        driver.element().type(oldPasswordField_Locator,oldPassword);
    }

    @Step("insert new password")
    public void insertNewPassword(String newPassword){
        driver.element().type(newPasswordField_Locator,newPassword);
    }

    @Step("repeate new password")
    public void repeatNewPassword(String newPassword){
        driver.element().type(repeatPasswordField_Locator,newPassword);
    }

    @Step("Click on submit password button")
    public void clickSubmitPasswordBtn(){
        driver.element().click(submitPasswordBtn_Locator);
    }

    @Step("Click on zuruck button")
    public void clickZuruckBtn(){
        driver.element().click(zuruckBtn_Locator);
    }



    //CLs
    private String notificationTitleText_CL = "Vielen Dank!";
    private String notificationDescriptionText_CL = "Dein Internet-Passwort wurde geändert und gilt ab sofort.";

    //Validations

    @Step("Assert on notification title text")
    public void assertOnNotificationTitle(){
        driver.verifyThat().element(notificationTitle_Locator).text().contains(notificationTitleText_CL).perform();
    }

    @Step("Assert on notification description text")
    public void assertOnNotificationDescription(){
        driver.verifyThat().element(notificationDescription_Locator).text().contains(notificationDescriptionText_CL).perform();
    }

    @Step("Assert on Zuruck button navigation")
    public void assertOnZuruckBtnNavigation(){
        driver.verifyThat().element(loginDatenAccordion_Locator).attribute("class").isEqualTo("ac-head ac-active").perform();
    }
}
