package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NeueServicePIN {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    // Locators
    private static By neueServicePinPageHeader = By.xpath("//h1[contains(text(), 'Neue Service-PIN')]");
    private static By neueServicePinHeader = By.xpath("//h3[@automation-id='Neue_Service-headline_tv']");
    private static By neueServiceDetailsHeader = By.xpath("//h4[@automation-id='Neue_Service-title_tv']");
    private static By neueServiceDetailsContent = By.xpath("//P[@automation-id='Neue_Service_Details_tv']");
    private static By jetztBestätigenButton = By.xpath("//button[@automation-id='confirm-Neue_Service_btn']");
    private static By errorTitleExceeds3TrialsDeepLink = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static By errorDetailsExceeds3TrialsDeepLink = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static By banNumber = By.xpath("//div[@automation-id='pageHeader_tv']//h2");

    public NeueServicePIN (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("Validate NeueServicePINPageMainHeader")
    public NeueServicePIN validateNeueServicePinPageMainHeader(String expectedNeueServicePinPageHeader) {
        driver.verifyThat()
                .element(neueServicePinPageHeader)
                .text()
                .contains(expectedNeueServicePinPageHeader)
                .perform();
        return this;
    }

    @Step("Validate DeineServicePIN Section")
    public NeueServicePIN validateDeineServicePINSection(String expectedNeueServicePinHeader, String expectedNeueServiceDetailsHeader, String expectedNeueServiceDetailsContent , String expectedJetztBestätigenButton) {
        driver.verifyThat()
                .element(neueServicePinHeader)
                .text()
                .contains(expectedNeueServicePinHeader)
                .perform();
        driver.verifyThat()
                .element(neueServiceDetailsHeader)
                .text()
                .contains(expectedNeueServiceDetailsHeader)
                .perform();
        driver.verifyThat()
                .element(neueServiceDetailsContent)
                .text()
                .contains(expectedNeueServiceDetailsContent)
                .perform();
        driver.verifyThat()
                .element(jetztBestätigenButton)
                .text()
                .contains(expectedJetztBestätigenButton)
                .perform();
        return this;
    }

    @Step("Validate ErrorTitleExceeds3TrialsDeepLink")
    public NeueServicePIN errorTitleExceeds3TrialsDeepLinkDeepLink(String expectedErrorTitleExceeds3TrialsDeepLink, String expectedErrorDetailsExceeds3TrialsDeepLink) {
        driver.verifyThat()
                .element(errorTitleExceeds3TrialsDeepLink)
                .text()
                .contains(expectedErrorTitleExceeds3TrialsDeepLink)
                .perform();
        driver.verifyThat()
                .element(errorDetailsExceeds3TrialsDeepLink)
                .text()
                .contains(expectedErrorDetailsExceeds3TrialsDeepLink)
                .perform();
        return this;
    }
    @Step("Validate BanNumber exist")
    public NeueServicePIN validateBanNumberExist() {
        //driver.element().waitToBeReady(BanNumber);
        driver.element().assertThat(banNumber).exists().perform();
        return this;
    }
    @Step("Click on NeuePINanfordernButton")
    public void clickOnJetztBestätigenButton() {
        driver.element().click(jetztBestätigenButton);
    }

    @Step("deeplink to Deeplink to Reset PIN page after exceeding no. of resetting")
    public NeueServicePIN deepLinkToResetPin() {
        //driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st.exceed3trials"));
        driver.browser().switchToNewTab("https://simplicity.wf-de.vodafone.com/meinvodafone/services/vertragsdaten/neue-servicePIN");
        return this;
    }
}
