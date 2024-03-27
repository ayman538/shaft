package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class RecallPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static By headline_text = By.xpath("//*[@automation-id='headline_tv']");
    public static By firstSubHeadline_text = By.xpath("//arrange-a-recall//*[@automation-id='subHeadline_tv']");
    public static By secondSubHeadline_text = By.xpath("//arrange-a-recall//*[@automation-id='text_body_tv']");
    public static By recallBoxHeadline_text = By.xpath("//*[@id='content']//welcome-page/div/p[2]");
    public static By phoneNumber_textarea = By.id("phoneNumber");
    public static By AbschickenButton_btn = By.xpath("//*[@automation-id='send_off_btn_Link']//span");
    public static By AbschickenButton2_btn = By.xpath("//a[@automation-id='send_Link']//span");

    //span[@class='ws10-button__text']
    //constructor
    public RecallPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords

    public void enterPhoneNumberText(String text) {
        driver.element().type(phoneNumber_textarea,text);
    };

    public RecallConfirmationPage clickOnTerminAuswählenButton() {
        driver.element().click(AbschickenButton_btn);
        return new RecallConfirmationPage(driver);
    };

    public RecallConfirmationPage clickOnTerminAuswählenButtonupdated() {
        driver.element().click(AbschickenButton2_btn);
        return new RecallConfirmationPage(driver);
    };
}
