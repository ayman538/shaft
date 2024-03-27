package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticeChangePersonalData {

    private SHAFT.GUI.WebDriver driver;

    public static By PersonalDataHeader = By.xpath("//*[text()='Meine persönlichen Daten']");


    public static String PersonalDataHeader_text = "Meine persönlichen Daten";




    public SolsticeChangePersonalData(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


}
