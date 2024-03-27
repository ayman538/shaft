package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class SolsticeAusladen {
    private SHAFT.GUI.WebDriver driver;

    public static By PageHeader_text = By.xpath("//*[text()='Vertragsverwaltung beenden']");
    public static final String PageHeader = "Vertragsverwaltung beenden";
    public static By PageTitle_text = By.xpath("//*[@automation-id='tg-head-isContract_tv']");
    public static final String PageTitle = "Die folgende Person soll Deinen Vertrag nicht mehr verwalten.";
    public  static By PageDescription_text = By.xpath("//*[@automation-id='standard-form-isContract_tv']");
    public static final String PageDescription = "Klick auf \"Person ausladen\", wenn die Person Deinen Vertrag nicht mehr verwalten soll.";
    public static By PersonAusladen_button = By.xpath("//*[@automation-id='fm-buttons_tv']");




    public SolsticeAusladen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SolsticeAusladenConfirmation clickOnAusladen() {
        driver.element().click( PersonAusladen_button);
        return new SolsticeAusladenConfirmation(driver);
    }
}
