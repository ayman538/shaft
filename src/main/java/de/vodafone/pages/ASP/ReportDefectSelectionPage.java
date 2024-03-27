package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ReportDefectSelectionPage {

    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By defectSelection_Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By first_DefectedHw_BTN = By.xpath("(//div[@class='checkbox-label'])[1]");
    public static final By second_DefectedHw_BTN = By.xpath("(//div[@class='checkbox-label'])[2]");
    public static final By wieter_BTN = By.xpath("//button[@automation-id='defectReturn_btn']");
    public static final By firstReason_BTN = By.xpath("(//button[@automation-id='undefined_btn'])[1]");
    public static final By firstReason_SELECT = By.xpath("(//*[@id='anchor_child'])[1]");

    public static final By secondReason_BTN = By.xpath("(//button[@automation-id='undefined_btn'])[2]");
    public static final By secondReason_SELECT = By.xpath("(//*[@id='anchor_child'])[10]");

    // Constructor
    public ReportDefectSelectionPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void select_DefectedHW (){

        new ElementActions(driver.getDriver()).click(first_DefectedHw_BTN);

    }
    public void selectFirstDefectReason (){

        new ElementActions(driver.getDriver()).click(firstReason_BTN);
        new ElementActions(driver.getDriver()).click(firstReason_SELECT);

    }
    public void selectSecondDefectReason (){

        new ElementActions(driver.getDriver()).click(secondReason_BTN);
        new ElementActions(driver.getDriver()).click(secondReason_SELECT);

    }

    public void clickOn_Weiter(){

        new ElementActions(driver.getDriver()).click(wieter_BTN);
    }

}
