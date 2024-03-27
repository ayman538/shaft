package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class SpecifyingDefectPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    public static final By Header_CL = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static final By firstReason_BTN = By.xpath("(//button[@automation-id='undefined_btn'])[1]");
    public static final By firstReason_SELECT = By.xpath("(//*[@id='anchor_child'])[1]");

    public static final By secondReason_BTN = By.xpath("(//button[@automation-id='undefined_btn'])[2]");
    public static final By secondReason_SELECT = By.xpath("(//*[@id='anchor_child'])[10]");

    public static final By weiter_BTN = By.xpath("(//button[@class='btn btn-em'])[2]");
    public static final By CheckBox = By.xpath("//*[@class='span-box']");


    // Constructor
    public SpecifyingDefectPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public void selectFirstDefectReason (){

        new ElementActions(driver.getDriver()).click(firstReason_BTN);
        new ElementActions(driver.getDriver()).click(firstReason_SELECT);

    }
    public void selectSecondDefectReason (){

        new ElementActions(driver.getDriver()).click(secondReason_BTN);
        new ElementActions(driver.getDriver()).click(secondReason_SELECT);

    }
    public void clickOn_Weiter (){

        new ElementActions(driver.getDriver()).click(weiter_BTN);
    }
    public void selectCheckBox() {
        JavascriptExecutor executor = (JavascriptExecutor) driver.getDriver();
        executor.executeScript("arguments[0].click();", driver.getDriver().findElement(CheckBox));
    }
}
