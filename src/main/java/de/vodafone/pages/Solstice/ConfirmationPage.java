package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ConfirmationPage {


    // Variables
    private SHAFT.GUI.WebDriver driver;
    public static By firstLoginHeader_text = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    public static By confirmationTitle_text = By.xpath("//*[text()='Geschafft!']");
    public static By confirmationDescription_text = By.xpath("//*[text()='Mit Deinem Vodafone-Passwort hast Du jetzt Zugang zu all Deinen Vodafone-Diensten. Viel Spaß damit!']");
    public static By toHomePage_button = By.xpath("//*[@automation-id='firstLoginSuccessMessage_btn']");

    public static String confirmationTitle = "Geschafft!";
    public static String confirmationDescription = "Mit Deinem Vodafone-Passwort hast Du jetzt Zugang zu all Deinen Vodafone-Diensten. Viel Spaß damit!";
    public static String toHomePage = "Zur Startseite";


    //constructor
    public ConfirmationPage (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
