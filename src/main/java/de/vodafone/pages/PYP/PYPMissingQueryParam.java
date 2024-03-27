package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class PYPMissingQueryParam {
    // Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static By pypPageHeader = By.xpath("//*[@automation-id='pageHeader_tv']");
    public static By pypErrorHeader = By.xpath("//*[text()='Ein Fehler ist aufgetreten']");
    public static By pypErrorBody = By.xpath("//*[text()='Bitte versuche es später noch einmal.']");
    public static By pypButton = By.xpath("//*[@automation-id='304414_btn']");




    public static final String pypPageHeader_text = "Vodafone OneNumber Car";
    public static final String errorHeader_text = "Ein Fehler ist aufgetreten";
    public static final String pypErrorBody_text = "Bitte versuche es später noch einmal.";


    //constructor
    public PYPMissingQueryParam(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
