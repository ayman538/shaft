package de.vodafone.pages.CheckAndCare;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class RecallConfirmationPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By header_Cl = By.xpath("//thank-you-confirmation//*[@class='check-and-care-headline']");
    public static final By header2_Cl = By.xpath("//*[@automation-id='headline_tv']");

    public static final By subHeader_Cl = By.xpath("//*[@class='check-and-care-headline']");


    //constructor
    public RecallConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
