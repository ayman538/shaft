package de.vodafone.pages.CableMigration;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeinVodafoneDashboard {

    // Variables
    private SHAFT.GUI.WebDriver driver;
    public static final By firstContract_acc = By.xpath("(//a[@accordion-id='dashboard:cable'])[1]");
    public static final By meinRechnungen_btn = By.xpath("(//a[@automation-id='Meine Rechnungen_btn'])[1]");
    private By ute_MeinRechnungen_btn = By.xpath("(//div[@class='tiles tiles-lrg cf']//a)[2]");

    private By TV_Video_accordion = By.xpath("//ul/li[2]/div[1]/div[@class='onclick-menu']");
    private By Kostenkontrolle_Tab = By.xpath("//div[5]/smart-object//div[@automation-id='_so']");

    //constructor
    public MeinVodafoneDashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public MeinVodafoneDashboard expandFirstAccordion() {
        (new ElementActions(driver.getDriver())).click(firstContract_acc);
        return this;
    }

    public MeinRechnungPage navigateToMeinReshnungPage(){

        (new ElementActions(driver.getDriver())).click(meinRechnungen_btn);
        return new MeinRechnungPage(driver);
    }
    public MeinRechnungPage ute_NavigateToMeinReshnungPage(){

        (new ElementActions(driver.getDriver())).click(ute_MeinRechnungen_btn);
        return new MeinRechnungPage(driver);
    }
    //WFFT-2894
    @Step("Clink on the Video accordion")
    public MeinVodafoneDashboard ClickOnTVandVideo() {
        driver.element().click(TV_Video_accordion);
        return new MeinVodafoneDashboard(driver);
    }
    @Step("Clink on the Kostenkontrolle tab")
    public KostenkontrollePage ClickOnKostenkontrolleTab() {
        driver.element().click(Kostenkontrolle_Tab);
        return new KostenkontrollePage(driver);
    }

}
