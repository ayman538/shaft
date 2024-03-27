package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class ReserveAppointmentPage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//*[@class='check-and-care-headline mb-20']");
    public static final By subHeadlineText_Cl = By.xpath("//*[@class='page-subHeadline mb-20'][1]");
    public static final By terminAussuchen_Button = By.xpath("//*[@automation-id='undefined_Link']");



    //constructor
    public ReserveAppointmentPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //keywords
    public CalendarPage clickOn_TerminAussuchenButton () {
        driver.element().click(terminAussuchen_Button);
        return new CalendarPage(driver);
    }
}
