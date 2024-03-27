package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class RevocationSelectionPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By revocationSelection_Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By first_ChangedHw_BTN = By.xpath("(//div[@class='checkbox-label'])[1]");
    public static final By second_ChangedHw_BTN = By.xpath("(//div[@class='checkbox-label'])[2]");
    public static final By wieter_BTN = By.xpath("//button[@automation-id='SelectionsSubmit_btn']");


    // Constructor
    public RevocationSelectionPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void select_changedHW (){

        new ElementActions(driver.getDriver()).click(first_ChangedHw_BTN);
        new ElementActions(driver.getDriver()).click(second_ChangedHw_BTN);
    }

    public void clickOn_Weiter(){

        new ElementActions(driver.getDriver()).click(wieter_BTN);
    }

}
