package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ExchangeHwStepThreePage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By gerateTauschen_BTN = By.xpath("//div[@class='device-overview']//button");


    // Constructor
    public ExchangeHwStepThreePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_GerateTauschen (){

        new ElementActions(driver.getDriver()).click(gerateTauschen_BTN);
    }
}
