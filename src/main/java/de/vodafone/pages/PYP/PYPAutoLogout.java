package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class PYPAutoLogout {

    private SHAFT.GUI.WebDriver driver;
    public static By NotificationTitle_text = By.xpath("//*[@class='flexDiv']");
    public static final String NotificationTitle = "Automatischer Logout";
    public static By NotificationDescription_text = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    public static final String NotificationDescription = "Du wirst immer zur Sicherheit abgemeldet, wenn Du länger nichts machst.";

    public PYPAutoLogout(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
