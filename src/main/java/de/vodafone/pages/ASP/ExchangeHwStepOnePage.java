package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ExchangeHwStepOnePage {

    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By HWName_CL = By.xpath("(//device-overview//div[@class='h2'])[1]");

    public static final By selectHW_BTN = By.xpath("(//div[@class='selectionCheck buttonText'])[1]");
    public static final By weiter_BTN = By.xpath("(//div[@class='fm-buttons'])[1]//button");


    // Constructor
    public ExchangeHwStepOnePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void SelectHW (){

        new ElementActions(driver.getDriver()).click(selectHW_BTN);
    }
    public void clickOn_Weiter (){

        new ElementActions(driver.getDriver()).click(weiter_BTN);
    }
}
