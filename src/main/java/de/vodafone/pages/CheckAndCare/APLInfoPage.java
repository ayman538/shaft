package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class APLInfoPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//*[@automation-id='headline_tv']");
    public static final By subHeader_Cl = By.xpath("//*[@automation-id='subHeadline_tv']");

    public static final By firstAcc_Button = By.xpath("//*[@id='accordion0']//span");
    public static final By firstAccInfo_Cl = By.xpath("//*[@id='ws10-accordion-item__content-accordion0']//p");
    public static final By secondAcc_Button = By.xpath("//*[@id='accordion1']//span");
    public static final By secondAccInfo_Cl = By.xpath("//*[@id='ws10-accordion-item__content-accordion1']//p");
    public static final By neuenTerminAussuchen_Button = By.xpath("//*[@automation-id='undefined_Link']//span");

    //constructor
    public APLInfoPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public void clickOn_firstAcc() {
        driver.element().click(firstAcc_Button);
    }
    public void clickOn_secondAcc() {
        driver.element().click(secondAcc_Button);
    }
    public CalendarPage clickOn_NeuenTerminAussuchen () {
        driver.element().click(neuenTerminAussuchen_Button);
        return new CalendarPage(driver);
    }

}
