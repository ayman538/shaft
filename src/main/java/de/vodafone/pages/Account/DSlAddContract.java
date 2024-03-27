package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DSlAddContract {
    private SHAFT.GUI.WebDriver driver;

    public DSlAddContract(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By pageSubHeader = By.xpath("(//div[@class='text-wrap'])[1]");
    private By pageSubTitle = By.xpath("//p[@automation-id='addDslContract_tv']");
    private By onlineCodeLabel = By.xpath("(//div[@class='tg-label'])[1]");
    private By requiredLabel = By.xpath("//span[@class='additional-label']");
    private By submitButton = By.xpath("//button[@class='btn btn-em btn-sml']");
    private By requestActivationCodeCTA = By.xpath("//a[@automation-id='onlineRegistration_Link']");

    private String pageHeader_CL = "DSL-Vertrag hinzufügen";
    private String pageSubHeader_CL = "Kundendaten eingeben";
    private String pageSubTitle_CL = "Gib bitte Deinen Online-Registrierungscode ein. Du hast ihn in dem Brief mit den Zugangsdaten bekommen.";
    private String onlineCodeLabel_CL = "Online-Registrierungscode *";
    private String  requiredLabel_CL = "* Pflichtfelder";
    private String  submitButton_CL = "Weiter";
    private String requestActivationCodeCTA_CL = "Du hast kein Online-Registrierungscode? Jetzt anfordern!";

    @Step("Verify DSL code page")
    public void DSLcodeValidation() {
        driver.verifyThat().element(pageHeader).textTrimmed().isEqualTo(pageHeader_CL).perform();
        driver.verifyThat().element(pageSubHeader).textTrimmed().isEqualTo(pageSubHeader_CL).perform();
        driver.verifyThat().element(pageSubTitle ).textTrimmed().isEqualTo(pageSubTitle_CL).perform();
        driver.verifyThat().element(onlineCodeLabel).textTrimmed().isEqualTo(onlineCodeLabel_CL).perform();
        driver.verifyThat().element(requiredLabel).textTrimmed().isEqualTo(requiredLabel_CL).perform();
        driver.verifyThat().element( submitButton).textTrimmed().isEqualTo(submitButton_CL).perform();
        driver.verifyThat().element(requestActivationCodeCTA).textTrimmed().isEqualTo( requestActivationCodeCTA_CL).perform();

    }
    public DSlAddContract clickOnRequestCode() {
        driver.element().click(requestActivationCodeCTA);
        return this;

    }
}
