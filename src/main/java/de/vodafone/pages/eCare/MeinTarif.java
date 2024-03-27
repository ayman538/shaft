package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeinTarif {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private By firstKündigen_btn = By.xpath("(//extra-tiles//a[contains(.,' Jetzt stornieren')])[1]");
    private By cancelButton_btn = By.xpath("//extra-tiles//a[contains(.,' Kündigen')]");
    private By buchbareOptionen_acc = By.xpath("//li[@automation-id='meine-buchbaren-optionen_acc']");
    private By buchbareOptionenTitle_txt = By.xpath("(//div[@class='multi-select-tags pl'])[1]/h3");
    private By firstJetztBuchen_btn = By.xpath("(//div[@class='card-button'])[1]");
    private By secondJetztBuchen_btn = By.xpath("(//div[@class='card-button'])[3]");
    private By TariffnotificationText = By.xpath("(//div[@automation-id='successMsg_tv'])[2]");
    private By Tariffandern = By.xpath("//div[@automation-id='option_2_rb']");
    private By closePopUpButton = By.xpath("(//span[@class='icon'])[21]");

    // constructor
    public MeinTarif(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // keywords
    @Step("Click on Kündigen Button")
    public MeinTarif clickOnKündigenButton() {
        driver.element().click(firstKündigen_btn);
        return this;
    }

    @Step("Click on Kündigen Button")
    public MeinTarif clickOnCancelButton() {
        driver.element().click(cancelButton_btn);
        return this;
    }

    @Step("expand BuchbareOptionen Accordion")
    public MeinTarif expandBuchbareOptionenAccordion() {
        driver.element().click(buchbareOptionen_acc);
        return this;
    }

    @Step("Click on Jetzt Buchen button")
    public MeinTarif clickOnJetztBuchen() {
        driver.element().click(firstJetztBuchen_btn);
        return this;
    }

    @Step("Click on Jetzt Buchen button")
    public MeinTarif clickOnBookingBuchen() {
        driver.element().click(secondJetztBuchen_btn);
        return this;
    }

    @Step("close popup message")
    public MeinTarif CLosePopUpMessage() {
        driver.element().verifyThat(closePopUpButton).exists().perform();
        driver.element().click(closePopUpButton);
        return this;
    }

    @Step("Validate that BuchbareOptionen Accordion is expanded")
    public MeinTarif validateBuchbareOptionenAccordionExpanded() {
        driver.verifyThat()
                .element(buchbareOptionenTitle_txt)
                .isVisible()
                .perform();
        return this;
    }

    @Step("Validate mein tariff notification text")
    public MeinTarif validateTariffNotificationText(String expectedNotificationText) {
        driver.verifyThat()
                .element(TariffnotificationText)
                .text()
                .contains(expectedNotificationText)
                .perform();
        return this;
    }
    @Step("Validate mein tariff notification text")
    public MeinTarif validateTariffNotificationNotExist(String expectedNotificationText) {
        driver.verifyThat()
                .element(TariffnotificationText)
                .text()
                .doesNotContain(expectedNotificationText)
                .perform();
        return this;
    }
    @Step("click on tariff adndern")
    public MeinTarif clickOnTariffAndern(){
        driver.element().click(Tariffandern);
        return this;
    }

}
