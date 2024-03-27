package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ExchangeHwStepTwoPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By HWName_CL = By.xpath("//div[@class='mod product-detail-images one-image']//h3");

    public static final By weiter_BTN = By.xpath("//button[@class='btn btn-em btn-sml']");


    // Constructor
    public ExchangeHwStepTwoPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_Weiter (){

        new ElementActions(driver.getDriver()).click(weiter_BTN);
    }
}
