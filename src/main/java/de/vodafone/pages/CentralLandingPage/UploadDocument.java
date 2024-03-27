package de.vodafone.pages.CentralLandingPage;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class UploadDocument {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public UploadDocument (SHAFT.GUI.WebDriver driver) { this.driver = driver; }

    //Locators
    public static By PageHeader_text = By.xpath("//*[text()='Deine Legitimation für unsere Kinder- & Jugend-Angebote']");

    //CLs
    public static String PageHeader = "Deine Legitimation für unsere Kinder- & Jugend-Angebote";
}
