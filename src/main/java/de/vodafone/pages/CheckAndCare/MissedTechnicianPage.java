package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class MissedTechnicianPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//*[@automation-id='text-headline_et']");
    public static final By text_Cl = By.xpath("//*[@automation-id='text-content-start_et']");
    public static final By technikerTerminAussuchen_Button = By.xpath("//*[@automation-id='select-technical-appointment_btn_Link']//span");

    //constructor
    public MissedTechnicianPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public CalendarPage clickOn_TechnikerTerminAussuchen () {
        driver.element().click(technikerTerminAussuchen_Button);
        return new CalendarPage(driver);
    }
}
