package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NeueServicePINFailure {
    private SHAFT.GUI.WebDriver driver;
    // Locators
    private static By failureHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private static By failureNotificationHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static By failureNotificationContent = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static By banNumber = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private static By backLink_lnk = By.xpath("//span[contains(text(), 'Schließen')]");


    public NeueServicePINFailure (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("Validate FailurePageMainHeader")
    public NeueServicePINFailure validateFailurePageMainHeader(String expectedFailurePageHeader) {
        driver.verifyThat()
                .element(failureHeader)
                .text()
                .contains(expectedFailurePageHeader)
                .perform();
        return this;
    }

    @Step("Validate FailureNotification Box")
    public NeueServicePINFailure validateFailureNotificationBox(String expectedFailureNotificationHeader, String expectedFailureNotificationContent) {
        driver.verifyThat()
                .element(failureNotificationHeader)
                .text()
                .contains(expectedFailureNotificationHeader)
                .perform();
        driver.verifyThat()
                .element(failureNotificationContent)
                .text()
                .contains(expectedFailureNotificationContent)
                .perform();
        return this;
    }

    @Step("Validate BackLink")
    public NeueServicePINFailure validateBackLink(String expectedBackLink) {
        driver.verifyThat()
                .element(backLink_lnk)
                .text()
                .contains(expectedBackLink)
                .perform();
        return this;
    }

    @Step("Validate BanNumber exist")
    public NeueServicePINFailure validateBanNumberExist() {
        driver.element().assertThat(banNumber).exists().perform();
        return this;
    }





}
