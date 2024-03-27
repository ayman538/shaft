package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NeueServicePINConfirmation {
    private SHAFT.GUI.WebDriver driver;
    // Locators
    private static By confirmationHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private static By confirmationNotificationHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static By confirmationNotificationContent = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static By ubersichtHeader = By.xpath("//li[@automation-id='accordion0_acc']//a//span");
    private static By ubersichtHeadline = By.xpath("//h5[@automation-id='newPinPassword_tv']");
    private static By ubersichtSubHeadline = By.xpath("//password[@id='newPin']//label");
    private static By banNumber = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private static By backLink_lnk = By.xpath("//span[contains(text(), 'Schließen')]");

    public NeueServicePINConfirmation (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("Validate ConfirmationPageMainHeader")
    public NeueServicePINConfirmation validateConfirmationPageMainHeader(String expectedConfirmationPageHeader) {
        driver.verifyThat()
                .element(confirmationHeader)
                .text()
                .contains(expectedConfirmationPageHeader)
                .perform();
        return this;
    }

    @Step("Validate SuccessNotification Box")
    public NeueServicePINConfirmation validateSuccessNotificationBox(String expectedConfirmationNotificationHeader, String expectedConfirmationNotificationContent) {
        driver.verifyThat()
                .element(confirmationNotificationHeader)
                .text()
                .contains(expectedConfirmationNotificationHeader)
                .perform();
        driver.verifyThat()
                .element(confirmationNotificationContent)
                .text()
                .contains(expectedConfirmationNotificationContent)
                .perform();
        return this;
    }

    @Step("Validate SuccessNotification Box")
    public NeueServicePINConfirmation validateÜbersichtAccordion(String expectedÜbersichtHeader, String expectedÜbersichtHeadline , String expectedÜbersichtSubHeadline ) {
        driver.verifyThat()
                .element(ubersichtHeader)
                .text()
                .contains(expectedÜbersichtHeader)
                .perform();
        driver.verifyThat()
                .element(ubersichtHeadline)
                .text()
                .contains(expectedÜbersichtHeadline)
                .perform();
        driver.verifyThat()
                .element(ubersichtSubHeadline)
                .text()
                .contains(expectedÜbersichtSubHeadline)
                .perform();
        return this;
    }
    @Step("Validate BackLink")
    public NeueServicePINConfirmation validateBackLink(String expectedBackLink) {
        driver.verifyThat()
                .element(backLink_lnk)
                .text()
                .contains(expectedBackLink)
                .perform();
        return this;
    }
    @Step("Validate BanNumber exist")
    public NeueServicePINConfirmation validateBanNumberExist() {
        driver.element().assertThat(banNumber).exists().perform();
        return this;
    }

}
