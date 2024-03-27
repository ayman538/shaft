package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ServicePIN {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    // Locators
    private static By servicePinPageHeader = By.xpath("//h1[contains(text(), 'Service-PIN')]");
    private static By servicePinHeader = By.xpath("//button[@automation-id='reset-PIN-btn_btn']");
    private static By serviceDetailsFirstPart = By.xpath("//P[@automation-id='ansehen-Service-PIN-details-1_tv']");
    private static By serviceDetailsSecondPart = By.xpath("//P[@automation-id='ansehen-Service-PIN-details-2_tv']");
    private static By ansehenServicePinMessage = By.xpath("//P[@automation-id='ansehen-Service-PIN-secureMsgPIN_tv']");

    private static By neuePINanfordernButton = By.xpath("//button[@automation-id='reset-PIN-btn_btn']");
    private static By errorHeader500  = By.xpath("//h4[contains(text(), 'Entschuldigung, da ist was schiefgelaufen.')]");
    private static By errorBody500  = By.xpath("//p[contains(text(), 'Bitte versuchen Sie es später nochmal.')]");
    private static By servicePINAnsehenaccordionTitle = By.xpath("//h3[@automation-id='ansehen-Service-PIN-headline_tv']");
    private static By servicePINAnsehenaccordionDetailsFirstPart = By.xpath("//p[@automation-id='ansehen-Service-PIN-details-1_tv']");
    private static By servicePINAnsehenaccordionDetailsSecondPart = By.xpath("//p[@automation-id='ansehen-Service-PIN-details-2_tv']");
    private static By banNumber = By.xpath("//div[@automation-id='pageHeader_tv']//h2");



    public ServicePIN (SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    @Step("Validate ServicePinPageMainHeader")
    public ServicePIN validateServicePinPageMainHeader(String expectedServicePinPageHeader) {
        driver.verifyThat()
                .element(servicePinPageHeader)
                .text()
                .contains(expectedServicePinPageHeader)
                .perform();
        return this;
    }

    @Step("Validate ServicePINAnsehenaccordion")
    public ServicePIN validateServicePINAnsehenAccordion(String expectedServicePINAnsehenaccordionTitle, String expectedServicePINAnsehenaccordionDetailsFirstPart, String expectedServicePINAnsehenaccordionDetailsSecondPart   ) {
        driver.verifyThat()
                .element(servicePINAnsehenaccordionTitle)
                .text()
                .contains(expectedServicePINAnsehenaccordionTitle)
                .perform();
        driver.verifyThat()
                .element(servicePINAnsehenaccordionDetailsFirstPart)
                .text()
                .contains(expectedServicePINAnsehenaccordionDetailsFirstPart)
                .perform();
        driver.verifyThat()
                .element(servicePINAnsehenaccordionDetailsSecondPart)
                .text()
                .contains(expectedServicePINAnsehenaccordionDetailsSecondPart)
                .perform();
        return this;
    }

    @Step("Validate ServicePinHeader")
    public ServicePIN validateServicePinHeader(String expectedServicePinHeader) {
        driver.verifyThat()
                .element(servicePinHeader)
                .text()
                .contains(expectedServicePinHeader)
                .perform();
        return this;
    }
    @Step("Validate validateServiceDetails")
    public ServicePIN validateServiceDetails(String expectedServiceDetailsFirstPart, String expectedServiceDetailsSecondPart) {
        driver.verifyThat()
                .element(serviceDetailsFirstPart)
                .text()
                .contains(expectedServiceDetailsFirstPart)
                .perform();
        driver.verifyThat()
                .element(serviceDetailsSecondPart)
                .text()
                .contains(expectedServiceDetailsSecondPart)
                .perform();
        return this;
    }
    @Step("Validate ServiceDetailsSecondPart")
    public ServicePIN validateServiceDetailsSecondPart(String expectedServiceDetailsSecondPart) {
        driver.verifyThat()
                .element(serviceDetailsSecondPart)
                .text()
                .contains(expectedServiceDetailsSecondPart)
                .perform();
        return this;
    }
    @Step("Validate ansehenServicePinMessage")
    public ServicePIN validateansehenServicePinMessage(String expectedansehenServicePinMessage) {
        driver.verifyThat()
                .element(ansehenServicePinMessage)
                .text()
                .contains(expectedansehenServicePinMessage)
                .perform();
        return this;
    }

    @Step("Validate NeuePINanfordernButton")
    public ServicePIN validateNeuePINanfordernButton(String expectedNeuePINanfordernButton) {
        driver.verifyThat()
                .element(neuePINanfordernButton)
                .text()
                .contains(expectedNeuePINanfordernButton)
                .perform();
        return this;
    }
    @Step("Validate BanNumber exist")
    public ServicePIN validateBanNumberExist() {
        driver.element().assertThat(banNumber).exists().perform();
        return this;
    }

    @Step("Validate ErrorHeader in case of network status 403")
    public ServicePIN errorMessageTitle403(String expectederrorHeader403, String expectederrorBody403) {
        driver.verifyThat()
                .element(errorHeader500)
                .text()
                .contains(expectederrorHeader403)
                .perform();
        driver.verifyThat()
                .element(errorBody500)
                .text()
                .contains(expectederrorBody403)
                .perform();
        return this;
    }
    @Step("Validate ErrorBody in case of network status 500")
    public ServicePIN errorMessageBody500(String expectederrorBody500) {
        driver.verifyThat()
                .element(errorBody500)
                .text()
                .contains(expectederrorBody500)
                .perform();
        return this;
    }

    @Step("Click on NeuePINanfordernButton")
    public void clickNeuePINanfordernButton() {
        driver.element().click(neuePINanfordernButton);
    }


}
