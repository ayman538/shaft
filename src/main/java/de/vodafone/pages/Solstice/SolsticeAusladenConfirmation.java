package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticeAusladenConfirmation {

    private SHAFT.GUI.WebDriver driver;

    public static By NotificationTitle_text = By.xpath("//*[@class='flexDiv']");
    public static final String NotificationTitle = "Geschafft";
    public static By NotificationDescription_text = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    public static final String NotificationDescription = "Die genannte Person verwaltet Deinen Vertrag nicht mehr.";

    public SolsticeAusladenConfirmation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
}
