package de.vodafone.pages.MNP;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PortingWODocumentsPrepaidPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By yesInformed = By.xpath("//*[@data-automation-id='providerInformed_rb']//input[@label='Ja']");
    private static By notInformed = By.xpath("//*[@data-automation-id='providerInformed_rb']//input[@label='Nein']");
    private static By notInformedErrorMsgHeader = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//h5");
    private static By notInformedErrorMsgBody = By.xpath("//*[@data-automation-id='timeOfPortabilityStep_nt']//p");
    private static By weiterCTA = By.xpath("(//*[@data-automation-id='contractButtons_gc'])//button[2]");
    private static By weiterCTA2 = By.xpath("(//*[@data-automation-id='timeOfPortabilityStepNext_btn'])");
    private static By cancelCTA = By.xpath("(//*[@data-automation-id='contractButtons_gc'])//button[1]");
    private static By cancelCTA2 = By.xpath("(//*[@data-automation-id='timeOfPortabilityStepCancel_btn'])");
    private static By serviceFailureMsgHeader = By.xpath("//*[@data-automation-id='error_nt']//h5");
    private static By serviceFailureMsgBody = By.xpath("//*[@data-automation-id='error_nt']//p");
    private static By prepaidAccordion = By.xpath("//*[@id='timeOfPortability_acc']");
    private static By prepaidKarteRadioButton = By.xpath("//*[@data-automation-id='contractTypesRadio_rb']//input[@id='contract-type-prepaid-contract']");

    // CLs
    private static String notInformedMsgHeader_CL = "Bevor Du Deine Rufnummern-Mitnahme bei uns beauftragst:";
    private static String notInformedMsgBody_CL = " Manche Anbieter verlangen eine schriftliche Information, z.B. eine Verzichtserklärung, anderen Anbietern reicht eine telefonische Information.";
    private static String serviceFailureMsgHeader_CL = "Rufnummern-Mitnahme nicht möglich";
    private static String serviceFailureBody_CL = "Ups! Die Technik hakt grad. Sorry, unser Fehler. Deine Rufnummern-Mitnahme können wir im Moment nicht bearbeiten. Bitte versuch's später nochmal. Danke für Dein Verständnis!";

    // DeepLinks
    private static String startPageURL = "hilfe/rufnummernmitnahme/start";


    public PortingWODocumentsPrepaidPage(SHAFT.GUI.WebDriver driver) { this.driver = driver;}

    @Step("click on yes informed radio button")
    public PortingWODocumentsPrepaidPage clickOnYesInformedRadioButton(){
        driver.element().click(yesInformed);
        return this;
    }
    @Step("click on NOT informed radio button")
    public PortingWODocumentsPrepaidPage clickOnNOTInformedRadioButton(){
        driver.element().click(notInformed);
        return this;
    }

    @Step("validate that Weiter is dimmed in case not informed")
    public PortingWODocumentsPrepaidPage validateWeiterCTAIsDimmed(){
        driver.verifyThat().element(weiterCTA).isDisabled().perform();
        return this;
    }

    @Step("validate that Weiter is dimmed in case not informed")
    public PortingWODocumentsPrepaidPage validateWeiterCTAIsDimmed2(){
        driver.verifyThat().element(weiterCTA2).isDisabled().perform();
        return this;
    }

    @Step("validate not informed message")
    public PortingWODocumentsPrepaidPage validateNotInformedMsg(){
        driver.verifyThat().element(notInformedErrorMsgHeader).text().isEqualTo(notInformedMsgHeader_CL).perform();
        driver.verifyThat().element(notInformedErrorMsgBody).text().contains(notInformedMsgBody_CL).perform();

        return this;
    }
    @Step("click on Wieter button to proceed ro next step")
    public PortingWODocumentsPrepaidPage clickOnWeiterButton(){
        driver.element().click(weiterCTA);
        //driver.verifyThat().element(prepaidAccordion).exists().perform();


        return this;
    }

    @Step("click on Wieter button to proceed ro next step")
    public PortingWODocumentsPrepaidPage clickOnWeiterButton2(){
        driver.element().click(weiterCTA2);
        //driver.verifyThat().element(prepaidAccordion).exists().perform();


        return this;
    }

    @Step("click on Cancel button to navigate to start page")
    public PortingWODocumentsPrepaidPage clickOnCancelButton(){
        driver.element().click(cancelCTA);
        driver.verifyThat().browser().url().contains(startPageURL).perform();
        return this;
    }

    @Step("click on Cancel button")
    public PortingWODocumentsPrepaidPage clickOnCancelButton2(){
        driver.element().click(cancelCTA2);
        driver.verifyThat().browser().url().contains(startPageURL).perform();
        return this;
    }

    @Step("validate error msg")
    public PortingWODocumentsPrepaidPage validateErrorMsgForServiceFailure(){
        driver.verifyThat().element(serviceFailureMsgHeader).text().isEqualTo(serviceFailureMsgHeader_CL).perform();
        driver.verifyThat().element(serviceFailureMsgBody).text().contains(serviceFailureBody_CL).perform();
        return this;
    }

    @Step("click on Cancel button to navigate to start page")
    public PortingWODocumentsPrepaidPage expandAndCollapsePrepaidAccordion(){
        driver.element().click(prepaidAccordion);
        driver.verifyThat().element(yesInformed).exists().perform();
        driver.element().click(prepaidAccordion);
        driver.verifyThat().element(yesInformed).doesNotExist().perform();
        return this;
    }

    @Step("click on Prepaid Radio button")
    public PortingWODocumentsPrepaidPage fillPrepaidKarteRadioButton() {
        driver.element().click(prepaidKarteRadioButton);
        return this;
    }
}