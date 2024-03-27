package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Dashboard {

    // Variables
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By meineRechnungTileLocator = By.xpath("//div[@class='subTitle'][contains(.,'QuickCheck, Kontostand, Jahresübersicht')]");//div[@class='subTitle'][contains(.,'Adressen, Bankdaten, Dokumente')]
    private static By meineDatenTileLocator = By.xpath("//div[@class='subTitle'][contains(.,'Adressen, Bankdaten, Dokumente')]");
    private By closePopUpButton = By.xpath("//div[@ng-if='canClose']");
    private static By meineTariffTileLocator = By.xpath("//h4[@class='tarrifCardName ucmTariff dimm-header-text']");
    private By overLayHeader_txt = By.xpath("//div[@class='overlay']//div[2]//h1");
    private By overLayContent_txt = By.xpath("//div[@class='overlay']//div[2]/p");
    private By notificationHeader_txt = By.xpath("(//div[@class='alert warning ']//h4)[1]");
    private By notificationContent_txt = By.xpath("(//div[@class='alert warning ']//p)[1]");
    private By notificationHeader_SecondAcc_txt = By.xpath("(//div[@class='alert warning ']//h4)[2]");
    private By notificationContent_SecondAcc_txt = By.xpath("(//div[@class='alert warning ']//p)[2]");
    private static By meineOptionenTile2Locator = By.xpath("//*[@id='content']//div[7]/smart-object/a/div");
    private static By meineDatenAccordion = By.xpath("//a[@automation-id='Meine Daten_btn']");
    private static By meineDatenAccordionSIT = By.xpath("(//a[@automation-id='Meine Daten_btn'])[2]");

    private static By meineKundendaten = By.xpath("//a[@automation-id='Meine Kundendaten_btn']");
    private static By banNumber = By.xpath("//div[@automation-id='pageHeader_tv']//h2");


    public By getMeineRechnungOrderedTileLocator(String contractOrder) {
        return By.xpath("(//div[@class='subTitle'][contains(.,'QuickCheck, Kontostand, Jahresübersicht')])[" + contractOrder + "]");
    }

    public By getMeineDatenTileLocator(String contractOrder) {
        return By.xpath("(//div[@class='subTitle'][contains(.,'Adressen, Bankdaten, Dokumente')])[" + contractOrder + "]");
    }

    public Dashboard (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("Expand contract")
    public Dashboard expandContract(String contractsOrder) {
        driver.element().click(By.xpath("(//h2[@class='contractName'])[" + contractsOrder + "]"));
        try{
            Thread.sleep(10000);
        }
        catch (Exception e)
        {

        }
        return this;
    }

    @Step("Click on meine Rechnungen tile")
    public void clickMeineRechnungenTile() {
        driver.element().click(meineRechnungTileLocator);

    }

    @Step("click on mein tariff smart object")
    public Dashboard ClickOnMeinTariffTile() {
        driver.element().click(meineTariffTileLocator);
        return this;
    }

    @Step("Click on CLosePopUpMessage")
    public Dashboard CLosePopUpMessage() {
        driver.element().verifyThat(closePopUpButton).exists();
        driver.element().click(closePopUpButton);
        return this;
    }

    @Step("Click on Meine Optionen tile")
    public Dashboard clickMeineOptionenTile()
    {
        driver.element().click(meineOptionenTile2Locator);
        return this;
    }

    @Step("Click on Meine Rechnungen Tile")
    public void clickMeineRechnungenTile(String contractOrder) {
        driver.element().click(getMeineRechnungOrderedTileLocator(contractOrder));

    }

    @Step("Click on meine Daten tile")
    public void clickMeineDatenTile() {
        driver.element().click(meineDatenTileLocator);
    }

    @Step("Click on Meine Daten Tile")
    public void clickMeineDatenTile(String contractOrder) {
        driver.element().click(getMeineDatenTileLocator(contractOrder));

    }

    @Step("Click on burger menu")
    public void clickBurgerMenuIcon(String burgerMenuOrder) {
        driver.element().click(burgerMenuLocator(burgerMenuOrder));
    }

    @Step("Click on Quickcheck")
    public void clickQuickCheckList(String quickCheckListOrder) {
        driver.element().click(quickCheckListOrderLocator(quickCheckListOrder));
    }

    public static By burgerMenuLocator(String burgerMenuOrder) {
        return By.xpath("(//div[@class='expert-mode dots-menu'])[" + burgerMenuOrder + "]");
    }

    public static By quickCheckListOrderLocator(String quickCheckListOrder) {
        return By.xpath("(//span[contains(.,'QuickCheck')])[" + quickCheckListOrder + "]");
    }

    @Step("Validate Overlay message Exist")
    public Dashboard validateOverLayMsgExist(String expectedOverlayHeaderText,String expectedexpectedOverlayContentText) {
        driver.verifyThat()
                .element(overLayHeader_txt)
                .text()
                .contains(expectedOverlayHeaderText)
                .perform();
        driver.verifyThat()
                .element(overLayContent_txt)
                .text()
                .contains(expectedexpectedOverlayContentText)
                .perform();
        return this;
    }

    @Step("Validate NotificationBox Exist")
    public Dashboard validateNotificationBoxExist(String expectedNotificationHeaderText,String expectedNotificationContentText) {
        driver.verifyThat()
                .element(notificationHeader_txt)
                .text()
                .contains(expectedNotificationHeaderText)
                .perform();
        driver.verifyThat()
                .element(notificationContent_txt)
                .text()
                .contains(expectedNotificationContentText)
                .perform();
        return this;
    }

    @Step("Validate NotificationBox Not Exist")
    public Dashboard validateNotificationBoxNotExist() {
        driver.verifyThat()
                .element(notificationHeader_txt)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(notificationContent_txt)
                .doesNotExist()
                .perform();
        return this;
    }

    @Step("Validate Overlay message not Exist")
    public Dashboard validateOverLayMsgNotExist() {
        driver.verifyThat()
                .element(overLayHeader_txt)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(overLayContent_txt)
                .doesNotExist()
                .perform();
        return this;
    }

    @Step("Validate Notification Box for Second Accordion Exist")
    public Dashboard validateSecondAccordionNotificationBoxExist(String expectedNotificationHeaderText,String expectedNotificationContentText) {
        driver.verifyThat()
                .element(notificationHeader_SecondAcc_txt)
                .text()
                .contains(expectedNotificationHeaderText)
                .perform();
        driver.verifyThat()
                .element(notificationContent_SecondAcc_txt)
                .text()
                .contains(expectedNotificationContentText)
                .perform();
        return this;
    }
    @Step("Validate BanNumber exist")
    public Dashboard validateBanNumberExist() {
        driver.element().assertThat(banNumber).exists().perform();
        return this;
    }

    @Step("Click on MeineDaten")
    public Dashboard clickMeineDaten() {
        driver.element().click(meineDatenAccordion);
        return this;
    }
    @Step("Click on MeineDaten")
    public Dashboard clickMeineDatenSIT() {
        driver.element().click(meineDatenAccordionSIT);
        return this;
    }
    @Step("Click on MeineKundendaten")
    public Dashboard clickMeineKundendaten() {
        driver.element().click(meineKundendaten);
        return this;
    }

}
