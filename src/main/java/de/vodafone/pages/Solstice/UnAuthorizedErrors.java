package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class UnAuthorizedErrors {
    private SHAFT.GUI.WebDriver driver;
    public static By peterHeader_text = By.xpath("//*[text()='Das geht leider nicht']");
    public static By peterDescription_text =  By.cssSelector("p[class='notification-text mb-10 mt-10']");
    public static By addContract_button = By.xpath("//*[@automation-id='undefined_btn']");

    public static final String peterHeader = "Das geht leider nicht";
    public static final String peterDescription = "Du hast nicht die notwendigen Rechte. Füg Deinen Vertrag mit Deiner Kundennummer hinzu.";
    public static final String generalDescription = "Füg zuerst Deinen Vertrag oder Teilnehmer in MeinVodafone hinzu. Versuch es danach bitte nochmal.";
     public static final String addContract = "Vertrag/Rufnummer hinzufügen";

    public UnAuthorizedErrors(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }




}
