package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeineRechnungen {
    SHAFT.GUI.WebDriver driver;


    private static By rechnungTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Rechnungen\")]");
    private static By kostenübersichtTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Kostenübersicht\")]");
    private static By VerbindungsübersichtTabLocator = By.xpath("//div[@class=\"title\"][contains(.,'Verbindungsübersicht')]");
    private static By kostenkontrolleTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Kostenkontrolle\")]");
    private static By mobilesBezahlenTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Mobiles Bezahlen\")]");
    private static By einstellungenTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Einstellungen\")]");



    public MeineRechnungen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the Rechnung tab")
    public Rechnungen clickRechnungTab() {
        driver.element().click( rechnungTabLocator);
        return new Rechnungen(driver);
    }

    @Step("Click on kostenubersicht tab")
    public Kostenubersicht clickKostenübersichtTab() {
        driver.element().click( kostenübersichtTabLocator);
        return new Kostenubersicht(driver);
    }

    @Step("Click on einstellungen tab")
    public Einstellungen clickEinstellungenTab() {
        driver.element().click( einstellungenTabLocator);
        return new Einstellungen(driver);
    }
    @Step("Click on Verbindungsübersicht tab")
    public Verbindungsubersicht clickVerbindungsübersichtTab() {
        driver.element().click(VerbindungsübersichtTabLocator);
        return new Verbindungsubersicht(driver);
    }



}
