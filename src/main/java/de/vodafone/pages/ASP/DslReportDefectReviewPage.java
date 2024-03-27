package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class DslReportDefectReviewPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By sendBack_BTN = By.xpath("(//button[@class='btn'])[2]");

    // Constructor
    public DslReportDefectReviewPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_sendBackDevice(){
        new ElementActions(driver.getDriver()).click(sendBack_BTN);
    }
}
