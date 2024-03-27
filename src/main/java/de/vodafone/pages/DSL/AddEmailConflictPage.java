package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddEmailConflictPage {

    //Variables
    SHAFT.GUI.WebDriver driver;

    //Constructor
    public AddEmailConflictPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By addEmailHeader = By.xpath("//*[@automation-id='no-dsl-contact-email_nt']//h4");
    private By addEmailBody = By.xpath("//*[@automation-id='no-dsl-contact-email_nt']//p");
    private By addEmailCTA = By.xpath("//button[@automation-id='no-dsl-contact-email_btn']");

    //CLs
    private String  addEmailHeaderCL = "Wir brauchen Deine E-Mail-Adresse";
    private String  addEmailBodyCL = "Gib uns bitte Deine E-Mail-Adresse. Ohne sie können wir Secure Net+ nicht buchen.";
    private String  addEmailCTACL = "E-Mail-Adresse hinzufügen";

    //Methods
    @Step("Validate Email Conflict Page")
    public AddEmailConflictPage validateEmailConflictPage(){
        driver.verifyThat().element(addEmailHeader).textTrimmed().isEqualTo(addEmailHeaderCL).perform();
        driver.verifyThat().element(addEmailBody).textTrimmed().isEqualTo(addEmailBodyCL).perform();
        driver.verifyThat().element(addEmailCTA).textTrimmed().isEqualTo(addEmailCTACL).perform();
        return this;
    }
}