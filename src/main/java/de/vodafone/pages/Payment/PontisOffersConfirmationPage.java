package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PontisOffersConfirmationPage {


    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By accordion_Locator = By.xpath("//*[@automation-id='accordion0_acc']");
    private By accordionHeadLine_Locator = By.xpath("//*[@automation-id='accordion0_acc']//span");
    private By accordionTitle_Locator = By.xpath("//*[@automation-id='accordion0_acc']//h3");
    private By accordionDescription_Locator = By.xpath("//*[@automation-id='accordion0_acc']//p");
    private By notificationTitle_Locator = By.xpath("//*[@automation-id='pontisOfferBookedNotification_nt']//h4");
    private By notificationDescription_Locator = By.xpath("//*[@automation-id='pontisOfferBookedNotification_nt']//p");
    private By schliesenBtn_Locator = By.xpath("");
    private By abbrecheBtn_Locator = By.xpath("");

    //CLs
    private String accordionHeadLine_CL = "Übersicht";
    private String successNotificationTitle_CL = "Du hast das Angebot bestellt";
    private String successNotificationDescription_CL = "Du hast Dein Angebot erfolgreich gebucht. Du bekommst bald eine Bestätigung zugeschickt..";
    private String failureNotificationTitle_CL = "Das hat leider nicht geklappt";
    private String failureNotificationDescription_CL = "Entschuldige bitte, unser Fehler. Versuch es einfach später nochmal.";

    //Methods
    public PontisOffersConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Click abbrechen button")
    public PontisOffersConfirmationPage clickAbbrechendBtn() {
        driver.element().click(abbrecheBtn_Locator);
        return this;
    }

    @Step("Click schliesen button")
    public PontisOffersConfirmationPage clickSchliesenBtn() {
        driver.element().click(schliesenBtn_Locator);
        return this;
    }

    @Step("expand accordion")
    public PontisOffersConfirmationPage expandAccordion(){
        driver.element().click(accordion_Locator);
        return this;
    }

    //Assertions
    public PontisOffersConfirmationPage assertOnOfferTitle(String title) {
        driver.verifyThat().element(accordionTitle_Locator).textTrimmed().isEqualTo(title).withCustomReportMessage("Assert on accordion title").perform();
        return this;
    }

    public PontisOffersConfirmationPage assertOnOfferDescription(String description) {
        driver.verifyThat().element(accordionDescription_Locator).textTrimmed().isEqualTo(description).withCustomReportMessage("Assert on accordion description").perform();
        return this;
    }

    public PontisOffersConfirmationPage assertOnSuccessNotificationTitle() {
        driver.verifyThat().element(notificationTitle_Locator).textTrimmed().isEqualTo(successNotificationTitle_CL).withCustomReportMessage("Assert on success notification title").perform();
        return this;
    }

    public PontisOffersConfirmationPage assertOnSuccessNotificationDescription() {
        driver.verifyThat().element(notificationDescription_Locator).textTrimmed().isEqualTo(successNotificationDescription_CL).withCustomReportMessage("Assert on success notification description").perform();
        return this;
    }

    public PontisOffersConfirmationPage assertOnFailureNotificationTitle() {
        driver.verifyThat().element(notificationTitle_Locator).textTrimmed().isEqualTo(failureNotificationTitle_CL).withCustomReportMessage("Assert on failure notification title").perform();
        return this;
    }

    public PontisOffersConfirmationPage assertOnFailureNotificationDescription() {
        driver.verifyThat().element(notificationDescription_Locator).textTrimmed().isEqualTo(failureNotificationDescription_CL).withCustomReportMessage("Assert on failure notification description").perform();
        return this;
    }

    public PontisOffersConfirmationPage assertOnAccordionHeadline(){
        driver.verifyThat().element(accordionHeadLine_Locator).textTrimmed().isEqualTo(accordionHeadLine_CL).withCustomReportMessage("Assert on accordion headline").perform();
        return this;
    }
}
