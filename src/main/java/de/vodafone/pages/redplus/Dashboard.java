package de.vodafone.pages.redplus;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class Dashboard {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Element Locators
    //Owner with limited data
    private By closeNotification_Button = By.xpath("//*[@class='icon-close-i-xxsml i-xxsml']");
    private By limitedContract_Acc = By.xpath( "//*[contains(text(),'108307218')]");
    private By limitedSubscriber1_Acc = By.xpath("//*[contains(text(),'01520 048 88 41')]");
    private By limitedSubscriber2_Acc = By.xpath("//*[contains(text(),'01520 048 88 44')]");
    private By limitedRedPlusOwner_SO = By.xpath("//*[@automation-id='RedPlusOwner_so']//h5");
    private By limitedRedPlusMember_SO = By.xpath("//*[@banner-text='Red+ Mitglied']//h5");

    //Owner with Flat data
    private By flatContract_Acc = By.xpath("//*[contains(text(),'108332703')]");
    private By flatRedPlusOwner_SO = By.xpath("//*[@automation-id='RedPlusOwner_so']");

    //Constructors
    public Dashboard (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Methods
    public Dashboard openLimitedContract() {
        driver.element().click( limitedContract_Acc);
        return this;
    }
    public Dashboard clickOnLimitedSubscriber1Acc() {
        driver.element().click( limitedSubscriber1_Acc);
        return this;
    }
    public Dashboard clickOnLimitedSubscriber2Acc() {
        driver.element().click( limitedSubscriber2_Acc);
        return this;
    }
    public QuickCheckPage clickOnLimitedRedPlusOwnerSO() {
        driver.element().click( limitedRedPlusOwner_SO);
        return new QuickCheckPage(driver);
    }

    public QuickCheckPage clickOnLimitedRedPlusMemberSO() {
        driver.element().click( limitedRedPlusMember_SO);
        return new QuickCheckPage(driver);
    }

    public Dashboard openFlatContract() {
        driver.element().click( flatContract_Acc);
        return this;
    }

    public QuickCheckPage clickOnFlatRedPlusOwnerSO() {
        driver.element().click( flatRedPlusOwner_SO);
        return new QuickCheckPage(driver);
    }
    public Dashboard closeNotificationMessage() {
        driver.element().waitToBeReady(closeNotification_Button);
        driver.element().click( closeNotification_Button);
        return this;
    }
}