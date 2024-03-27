package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticeDeleteAccount {

    private SHAFT.GUI.WebDriver driver;

    public static By AccDeletionPageHeader = By.xpath("//*[text()='MeinVodafone-Konto löschen']");


    public static String AccDeletionPageHeader_text = "MeinVodafone-Konto löschen";




    public SolsticeDeleteAccount(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
