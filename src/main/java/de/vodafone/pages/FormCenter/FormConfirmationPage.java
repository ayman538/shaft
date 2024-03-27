package de.vodafone.pages.FormCenter;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FormConfirmationPage {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    //Locators
    private By ConfirmationMsgLocator = By.xpath("//*[@class='ws10-headline--center ws10-headline--h2']");

    //CLs
    private String ConfirmationMsgCL = "Geschafft!";
    private String GeneralErrorMsg = "Das hat leider nicht geklappt";


    //constructor
    public FormConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //keywords

    @Step("Validate Form confirmation MSG")
    public void validateFormConfirmationMsg() {
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmationMsgLocator)
                .text().isEqualTo(ConfirmationMsgCL).perform();
    }

    @Step("Validate Form general error MSG")
    public void validateFormGeneralErrorMsg() {
        Validations.assertThat()
                .element(driver.getDriver(), ConfirmationMsgLocator)
                .text().isEqualTo(GeneralErrorMsg).perform();
    }


}