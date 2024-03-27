package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeineRechnungen {
    SHAFT.GUI.WebDriver driver;


    private static By rechnungTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Rechnungen\")]");
    private static By kostenübersichtTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Kostenübersicht\")]");
    private static By kostenkontrolleTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Kostenkontrolle\")]");
    private static By mobilesBezahlenTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Mobiles Bezahlen\")]");
    private static By einstellungenTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Einstellungen\")]");
    private static By kontostandTabLocator = By.xpath("//div[@class=\"title\"][contains(.,\"Kontostand\")]");



    public MeineRechnungen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click on the Einstellungen tab")
    public Einstellungen clickEinstellungenTab() {
        driver.element().click(einstellungenTabLocator);
        return new Einstellungen(driver);

    }
    @Step("Click on konstostand tab")
    public void clickOnKontostandTab(){
        driver.element().click(kontostandTabLocator);
    }




}
