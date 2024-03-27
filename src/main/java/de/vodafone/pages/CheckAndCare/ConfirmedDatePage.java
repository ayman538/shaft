package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ConfirmedDatePage {

    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//date-choice-confirmation//*[@class='check-and-care-headline']");

    //constructor
    public ConfirmedDatePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
