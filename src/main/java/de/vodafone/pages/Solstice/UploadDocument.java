package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class UploadDocument {
    private SHAFT.GUI.WebDriver driver;

    public static By PageHeader_text = By.xpath("//*[text()='Deine Legitimation für unsere Kinder- & Jugend-Angebote']");
    protected static final String PageHeader = "Deine Legitimation für unsere Kinder- & Jugend-Angebote";


    public UploadDocument (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

}
