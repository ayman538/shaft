package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import de.vodafone.pages.TwoFA.RegistrationPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DSLRegisterationPage {


    private SHAFT.GUI.WebDriver driver;

    public DSLRegisterationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By addContract = By.xpath("(//div[@class='fm-tile eq-height miniheight bigBtn'])[2]");
    private By dslContract = By.xpath("(//div[@class='fm-tile eq-height miniheight bigBtn'])[2]");
    private By pageHeader = By.xpath("//div[@class='title-ecare overview']");
    private By pageSubHeader = By.xpath("//div[@class='tg-head tg-active']");
    private By pageSubTitle = By.xpath("//div[@class='contract-chooser-tiles-holder']/p");
    private By onlineCodeLabel = By.xpath("(//div[@class='tg-label'])[1]");
    private By requiredLabel = By.xpath("//span[@class='additional-label']");
    private By submitButton = By.xpath("//button[@class='btn btn-em btn-sml']");
    private By requestActivationCodeCTA = By.xpath("//a[@automation-id='request-activationCode_Link']");

    private String pageHeader_CL = "Neues MeinVodafone-Konto";
    private String pageSubHeader_CL = "Registrierungscode eingeben";
    private String pageSubTitle_CL = "Gib bitte Deinen Online-Registrierungscode ein. Du hast ihn in dem Brief mit den Zugangsdaten bekommen.";
    private String onlineCodeLabel_CL = "Online-Registrierungscode *";
    private String requiredLabel_CL = "* Pflichtfelder";
    private String submitButton_CL = "Weiter";
    private String requestActivationCodeCTA_CL = "Du hast kein Online-Registrierungscode? Jetzt anfordern!";

    @Step("Verify DSL Register page")
    public void DSLcodeValidation() {
        driver.verifyThat().element(pageHeader).textTrimmed().isEqualTo(pageHeader_CL).perform();
        driver.verifyThat().element(pageSubHeader).textTrimmed().isEqualTo(pageSubHeader_CL).perform();
        driver.verifyThat().element(pageSubTitle).textTrimmed().isEqualTo(pageSubTitle_CL).perform();
        driver.verifyThat().element(onlineCodeLabel).textTrimmed().isEqualTo(onlineCodeLabel_CL).perform();
        driver.verifyThat().element(requiredLabel).textTrimmed().isEqualTo(requiredLabel_CL).perform();
        driver.verifyThat().element(submitButton).textTrimmed().isEqualTo(submitButton_CL).perform();
        driver.verifyThat().element(requestActivationCodeCTA).textTrimmed().isEqualTo(requestActivationCodeCTA_CL).perform();

    }

    public DSLRegisterationPage clickOnRequestCode() {
        driver.element().click(requestActivationCodeCTA);
        return this;

    }

    public DSLRegisterationPage clickAddContract() {
        driver.element().click(addContract);
        return this;

    }

    public DSLRegisterationPage clickDSLContract() {
        driver.element().click(dslContract);
        return this;

    }
}