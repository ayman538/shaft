package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class CheckAddressPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static By headline_text = By.xpath("//*[@automation-id='headline_tv']");
    public static By SubHeadline_text = By.xpath("//*[@automation-id='subHeadline_tv']");
    public static By address_text = By.xpath("//*[@id='content']//welcome-page/div/p[1]");
    public static By secondSubHeadline_text = By.xpath("//*[@automation-id='page_subHeadline_tv']");
    public static By jaButton_btn = By.xpath("//*[@automation-id='yes_btn_Link']//span");
    public static By neinButton_btn = By.xpath("//*[@automation-id='no_btn_Link']//span");

    //constructor
    public CheckAddressPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords

    public ConfirmAddressPage clickOnJaButton() {
        driver.element().click(jaButton_btn);
        return new ConfirmAddressPage(driver);
    };
    public RecallPage clickOnNeinButton() {
        driver.element().click(neinButton_btn);
        return new RecallPage(driver);
    };
}
