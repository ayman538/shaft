package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ASPReportDefect {

    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By reportDefect_Header_CL = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    public static final By polarbear_HW_reportDefect_BTN = By.xpath("//div[@automation-id='undefined_rb']");
    public static final By backBrowser_Link = By.xpath("//a[@automation-id='back_Link']");

    // Constructor
    public ASPReportDefect(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void clickOn_polarbear_HWReportDefect (){

        new ElementActions(driver.getDriver()).click(polarbear_HW_reportDefect_BTN);
    }
    public void clickOn_backBrowser(){
        new ElementActions(driver.getDriver()).click(backBrowser_Link);
    }

}
