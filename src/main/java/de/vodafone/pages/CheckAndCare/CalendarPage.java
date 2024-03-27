package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class CalendarPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//*[@class='check-and-care-headline']");
  //public static final By Calendar_Table = By.xpath("//*[@class='DayPicker-Months']");
    public static final By availableDate_Select = By.xpath("//button[@class='mat-calendar-body-cell mat-calendar-body-active']");
    public static final By morning_CheckBox = By.xpath("//ws10-radio-button/div/div[1]/label");
    public static final By evening_CheckBox = By.xpath("//*[@for='afternoon']/span");
    public static final By weiter_Button = By.xpath("//*[@automation-id='undefined_Link']");


    //constructor
    public CalendarPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public void selectAvailableDate(){
        driver.element().click(availableDate_Select);
    }
    public void selectMorningCheck(){
        driver.element().click(morning_CheckBox);
    }
    public ReviewDatePage clickOn_Weiter (){
        driver.element().click(weiter_Button);
        return new ReviewDatePage(driver);
    }
}
