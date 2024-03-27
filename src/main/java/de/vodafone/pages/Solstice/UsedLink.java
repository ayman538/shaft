package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class UsedLink {


    // Variables
    private SHAFT.GUI.WebDriver driver;
    public static By usedLinkTitle_text = By.xpath("//*[text()='Schon erledigt!']");
    public static By invalidLinkDescription_text = By.xpath("//*[text()='Du hast den ersten Login schon gemacht. Log Dich einfach mit Deinen Zugangsdaten ein.']");

    public static String usedLinkTitle = "Schon erledigt!";
    public static String invalidLinkDescription = "Du hast den ersten Login schon gemacht. Log Dich einfach mit Deinen Zugangsdaten ein.";


    //constructor
    public UsedLink (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
