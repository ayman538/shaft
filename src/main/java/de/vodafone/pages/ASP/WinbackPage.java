package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class WinbackPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    private By  whatsAppButton = By.xpath("//ul[@automation-id='ChatPage_lv']");
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By cancelContract_SELECT = By.xpath("//*[@automation-id='review-page_title_tv']");
    public static final By gigacube_cancelContract_BTN = By.xpath("//h4[@automation-id='gigacube-review-page_title_tv']");
    public static final By winderrufen_BTN = By.xpath("//button[@automation-id='undefined_btn']");

    // Constructor
    public WinbackPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_CancelContract (){

        new ElementActions(driver.getDriver()).click(cancelContract_SELECT);
    }
    public void clickOn_GigaCubeCancelContract () {
        new ElementActions(driver.getDriver()).click(gigacube_cancelContract_BTN);
    }
    public void clickOn_winderrufen(){
        new ElementActions(driver.getDriver()).click(winderrufen_BTN);
    }

    public WinbackPage clickOn_WhatsAppbutton () {
        driver.element().click(whatsAppButton);

    return this;
    }

}