package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticeEinladenConfirmation {
    private SHAFT.GUI.WebDriver driver;
    public static By ConfirmationHeader_Text = By.xpath("//*[text()='Einladung verschickt']");
    public static String ConfirmationHeader = "Einladung verschickt";
    public static By ConfirmationTitle_Text  = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    public static String ConfirmationTitle= "Die Person hat 7 Tage, um die Einladung anzunehmen.";






    public SolsticeEinladenConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
