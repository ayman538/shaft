
package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class GigaTVDeleteDevice {
    private SHAFT.GUI.WebDriver driver;

    // CLS
    private static String deleteMessageInformationTitle_Cl = "Gut zu wissen";
    private static String deleteMessageInformationDescription_Cl = "Sobald Du dieses Gerät entfernst, musst Du 30 Tage warten, bis Du wieder ein Gerät entfernen kannst.";
    private static String confirmDeleteMessageTitle_Cl = "Geschafft";
    private static String confirmDeleteMessageDescription_Cl = "Das Gerät wurde entfernt.";

    private static String deleteMessageInformationTitle_Cl2 = "Gut zu wissen";
    private static String deleteErrorMessageTitle_Cl= "Das hat leider nicht geklappt";
    private static String deleteErrorMessageDescription_Cl = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    //Locators
    private By deleteMessageTitle_label = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By deleteMessageDescription_label = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By existDevice= By.xpath("//div[@automation-id='undefined_tv1']");
    private By confirmationDelete_button = By.xpath("//button[@automation-id='review_gigaTv_btn']");
    private By ubersicht_label = By.xpath("(//li[@automation-id='productData_acc']//span)[1]");

    //constructor
    public GigaTVDeleteDevice(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public GigaTVDeleteDevice clickOnConfirmationDeleteButton() {
        driver.element().click(confirmationDelete_button);
        return this;
    }

    //Validations
    @Step("validate Delete Giga TV device Information Message.")
    public GigaTVDeleteDevice validateDeleteDeviceInformationMessage() {
        driver.verifyThat()
                .element(deleteMessageDescription_label)
                .textTrimmed()
                .contains(deleteMessageInformationDescription_Cl)
                .withCustomReportMessage("Validate confirmation message description")
                .perform();

        driver.verifyThat()
                .element(deleteMessageTitle_label)
                .textTrimmed()
                .contains(deleteMessageInformationTitle_Cl2)
                .withCustomReportMessage("Validate confirmation message title")
                .perform();
        return this;
    }

    @Step("validate Delete Giga TV device Information Message.")
    public GigaTVDeleteDevice validateDeleteDeviceInformationMessageIncaseOfFailure() {
        driver.verifyThat()
                .element(deleteMessageDescription_label)
                .textTrimmed()
                .contains(deleteMessageInformationDescription_Cl)
                .withCustomReportMessage("Validate confirmation message description")
                .perform();

        driver.verifyThat()
                .element(deleteMessageTitle_label)
                .textTrimmed()
                .contains(deleteMessageInformationTitle_Cl)
                .withCustomReportMessage("Validate confirmation message title")
                .perform();
        return this;
    }

    @Step("validate Delete Giga TV device Confirmation Message.")
    public GigaTVDeleteDevice validateDeleteDeviceConfirmationMessage() {
        driver.verifyThat().element(existDevice)
                .doesNotExist()
                .withCustomReportMessage("Confirm that user navigate to the other page")
                .perform();

        driver.element().isElementDisplayed(ubersicht_label);
        driver.verifyThat()
                .element(deleteMessageTitle_label)
                .textTrimmed()
                .contains(confirmDeleteMessageTitle_Cl)
                .withCustomReportMessage("Validate confirmation message title")
                .perform();

        driver.verifyThat()
                .element(deleteMessageDescription_label)
                .textTrimmed()
                .contains(confirmDeleteMessageDescription_Cl)
                .withCustomReportMessage("Validate confirmation message description")
                .perform();
        return this;
    }

    @Step("validate Delete Giga TV device Failure Message.")
    public GigaTVDeleteDevice validateDeleteDeviceErrorMessage() {
        driver.verifyThat().element(existDevice)
                .doesNotExist()
                .withCustomReportMessage("Confirm that user navigate to the other page")
                .perform();

        driver.verifyThat()
                .element(deleteMessageDescription_label)
                .textTrimmed()
                .contains(deleteErrorMessageDescription_Cl)
                .withCustomReportMessage("Validate Failure message description")
                .perform();

        driver.verifyThat()
                .element(deleteMessageTitle_label)
                .textTrimmed()
                .contains(deleteErrorMessageTitle_Cl)
                .withCustomReportMessage("Validate Failure message title")
                .perform();
        return this;
    }
}