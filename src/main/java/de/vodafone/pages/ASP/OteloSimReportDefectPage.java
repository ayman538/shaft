package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class OteloSimReportDefectPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By otelo_BTN = By.xpath("//*[@automation-id='pageHeader_tv']//h1");


    // Constructor
    public OteloSimReportDefectPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void navigateToOteloPortal(){
        new ElementActions(driver.getDriver()).click(otelo_BTN);
    }
}
