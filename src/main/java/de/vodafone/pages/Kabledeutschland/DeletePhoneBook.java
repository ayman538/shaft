package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeletePhoneBook {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String deletePageTitle_CL = "Telefonbuch-Eintrag löschen";
    private static String deletePageDescription_CL0 = "Wichtig:";
    private static String deletePageDescription_CL1 = "Den Telefonbuch-Eintrag kannst Du kostenlos löschen.";
    private static String deletePageDescription_CL2 = "Ein neuer Eintrag ist dann jedoch kostenpflichtig. Die Preise findest Du in der Preisliste.";
    private static String confirmationMessageTittle_CL = "Geschafft";
    private static String confirmationMessageDescription_CL="Deine Änderung wurde gespeichert. Es kann noch wenige Minuten dauern, bis Du die Änderung siehst.";
    private static String errorMessageTittle_CL = "Das hat leider nicht geklappt";
    private static String errorMessageDescription_CL="Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    //Locators
    private static final By deletePage_title = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private static final By deletePage_description = By.xpath("//p[@automation-id='Delete_description_tv']");
    private static final By deleteEntry_button = By.xpath("//button[@automation-id='deletePhoneBook_btn']");
    private static final By deleteMessage_tittle = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static final By deleteMessage_description = By.xpath("//div[@automation-id='successMsg_tv']//p");

    //constructor
    public DeletePhoneBook(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //Actions
    public DeletePhoneBook clickOnDeletePhoneBookEntry ()
    {
        driver.element().click(deleteEntry_button);
        return this;
    }

    //Validations
    @Step("Validate Delete Phone Book Review Page")
    public DeletePhoneBook validateDeletePageReview ()
    {

        driver.verifyThat()
                .element(deletePage_description)
                .textTrimmed()
                .contains(deletePageDescription_CL0)
                .withCustomReportMessage("Validate Page Description")
                .perform();
        driver.verifyThat()
                .element(deletePage_description)
                .textTrimmed()
                .contains(deletePageDescription_CL1)
                .withCustomReportMessage("Validate Page Description")
                .perform();
        driver.verifyThat()
                .element(deletePage_description)
                .textTrimmed()
                .contains(deletePageDescription_CL2)
                .withCustomReportMessage("Validate Page Description")
                .perform();

        driver.verifyThat()
                .element(deletePage_title)
                .textTrimmed()
                .isEqualTo(deletePageTitle_CL)
                .withCustomReportMessage("Validate Page Title")
                .perform();
        return this;
    }

    @Step("validate Delete phone book Success confirmation message.")
    public DeletePhoneBook validateDeletePhoneBookConformationMessage()
    {
        driver.verifyThat()
                .element(deleteMessage_tittle)
                .textTrimmed()
                .isEqualTo(confirmationMessageTittle_CL)
                .withCustomReportMessage("Validate confirmation message title")
                .perform();

        driver.verifyThat()
                .element(deleteMessage_description)
                .textTrimmed()
                .contains(confirmationMessageDescription_CL)
                .withCustomReportMessage("Validate confirmation message description")
                .perform();
        return this;
    }
    @Step("validate Delete phone book Failure message.")
    public DeletePhoneBook validateDeletePhoneBookErrorMessage()
    {
        driver.verifyThat()
                .element(deleteMessage_tittle)
                .textTrimmed()
                .isEqualTo(errorMessageTittle_CL)
                .withCustomReportMessage("Validate Failure message title")
                .perform();

        driver.verifyThat()
                .element(deleteMessage_description)
                .textTrimmed()
                .contains(errorMessageDescription_CL)
                .withCustomReportMessage("Validate Failure message description")
                .perform();
        return this;
    }

}
