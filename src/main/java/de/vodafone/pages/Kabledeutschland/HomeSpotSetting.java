package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomeSpotSetting {
    private SHAFT.GUI.WebDriver driver;

    private String homeSpotConfirmationScreenURL = "meinvodafone/services/meine-produkte/internet-phone/geraete-einstellungen?accordion=homespot-service";
    private String homeSpotSuccessScreenURL = "meinvodafone/services/meine-produkte/internet-phone/geraete-einstellungen?accordion=homespot-service";

    //CLs
    private String homeSpotSettingPageActivationTitle_CL = "Homespot aktivieren";
    private String homeSpotSettingPageDeactivationTitle_CL = "Homespot deaktivieren";
    private String homeSpotSettingPageSubTitle_CL = "Homespot";

    private String homeSpotSettingPageActivationConfirmationMSG_CL1 = "Wichtig: Mit Deinem Klick bestätigst Du, dass Du die";
    private String homeSpotSettingPageActivationConfirmationMSG_CL2 = "Besonderen Geschäftsbedingungen Vodafone Homespot gelesen und akzeptiert hast.";

    private String homeSpotSettingPageDeactivationConfirmationMSG_CL = "Du kannst Deinen Homespot jederzeit wieder aktivieren.";

    private String ConfirmBTNInActivationFlow_CL = "Homespot aktivieren";
    private String ConfirmBTNInDeactivationFlow_CL = "Homespot deaktivieren";

    private String homeSpotSettingPageSuccessMSGTitle_CL = "Geschafft";
    private String homeSpotSettingPageFailureMSGTitle_CL = "Das hat leider nicht geklappt";

    private String homeSpotSettingPageActivationSuccessMSGDescription_CL1 = "Der Router startet jetzt neu und Dein Homespot wird aktiviert. Das kann bis zu 24 Stunden dauern.";
    private String homeSpotSettingPageActivationSuccessMSGDescription_CL2 = "Der Router startet nicht automatisch neu? Schalte ihn bitte einmal aus und wieder ein.";

    private String homeSpotSettingPageDeactivationSuccessMSGDescription_CL1 = "Der Router startet jetzt neu und Dein Homespot wird deaktiviert. Das dauert nur wenige Minuten.";
    private String homeSpotSettingPageDeactivationSuccessMSGDescription_CL2 = "Der Router startet nicht automatisch neu? Schalte ihn bitte einmal aus und wieder ein.";


    private String homeSpotSettingPageFailureMSGDescription_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    //Locators
    private By homeSpotSettingPage_title = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By homeSpotSettingPage_subTitle =By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private By homeSpotSettingPage_ActivationConfirmationMSG = By.xpath("(//div[@automation-id='homespotActivation_tv']/p)[2]");
    private By homeSpotSettingPage_DeActivationConfirmationMSG = By.xpath("//div[@automation-id='homespotActivation_tv']/p");

    private By back_btn= By.xpath("//a[@automation-id='back_Link']");
    private By confirm_btn= By.xpath("//button[@automation-id='homespotActivationConfirm_btn']");

    private By message_title= By.xpath("(//div[@automation-id='successMsg_tv']/div/div)[2]");
    private By message_description= By.xpath("//div[@automation-id='successMsg_tv']/p");


    //constructor
    public HomeSpotSetting(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Actions
    public HomeSpotSetting clickOnBackBTN() {
        driver.element().click(back_btn);
        return this;
    }

    public HomeSpotSetting clickOnConfirmBTN() {
        driver.element().click(confirm_btn);
        return this;
    }

    //Validations
    @Step("validate HomeSpot Setting Page Sub-Title")
    public HomeSpotSetting validateHomeSpotSettingMainPage() {
        driver.verifyThat()
                .element(homeSpotSettingPage_subTitle)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageSubTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Sub-Title")
                .perform();
        return this;
    }

    @Step("validate HomeSpot Setting Page In Activation Flow")
    public HomeSpotSetting validateHomeSpotSettingPageInActivationFlow() {
        driver.verifyThat()
                .element(homeSpotSettingPage_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageActivationTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Title In Activation Flow")
                .perform();
        driver.verifyThat()
                .element(homeSpotSettingPage_ActivationConfirmationMSG)
                .textTrimmed()
                .contains(homeSpotSettingPageActivationConfirmationMSG_CL1)
                .withCustomReportMessage("Validate HomeSpot Setting Page Activation Confirmation MSG In Activation Flow")
                .perform();
        driver.verifyThat()
                .element(homeSpotSettingPage_ActivationConfirmationMSG)
                .textTrimmed()
                .contains(homeSpotSettingPageActivationConfirmationMSG_CL2)
                .withCustomReportMessage("Validate HomeSpot Setting Page Activation Confirmation MSG In Activation Flow")
                .perform();

        driver.verifyThat()
                .element(confirm_btn)
                .textTrimmed()
                .isEqualTo(ConfirmBTNInActivationFlow_CL)
                .withCustomReportMessage("Validate Confirm Button Exist in the HomeSpot Setting Page In The Activation Flow")
                .perform();

        return this;
    }

    @Step("validate HomeSpot Setting Page In Deactivation Flow")
    public HomeSpotSetting validateHomeSpotSettingPageInDeactivationFlow() {
        driver.verifyThat()
                .element(homeSpotSettingPage_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageDeactivationTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Title In Deactivation Flow")
                .perform();

        driver.verifyThat()
                .element(homeSpotSettingPage_DeActivationConfirmationMSG)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageDeactivationConfirmationMSG_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Deactivation Confirmation MSG In Deactivation Flow")
                .perform();

        driver.verifyThat()
                .element(confirm_btn)
                .textTrimmed()
                .isEqualTo(ConfirmBTNInDeactivationFlow_CL)
                .withCustomReportMessage("Validate Confirm Button Exist in the HomeSpot Setting Page In The Deactivation Flow")
                .perform();


        return this;
    }

    @Step("validate HomeSpot Setting Page After Activation Successfully")
    public HomeSpotSetting validateHomeSpotSettingPageAfterActivationSuccessfully() {
        driver.verifyThat()
                .element(message_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageSuccessMSGTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Success Page Title After Activation Successfully ")
                .perform();

        driver.verifyThat()
                .element(message_description)
                .textTrimmed()
                .contains(homeSpotSettingPageActivationSuccessMSGDescription_CL1)
                .withCustomReportMessage("Validate HomeSpot Setting Success Page Description After Activation Successfully ")
                .perform();
        driver.verifyThat()
                .element(message_description)
                .textTrimmed()
                .contains(homeSpotSettingPageActivationSuccessMSGDescription_CL2)
                .withCustomReportMessage("Validate HomeSpot Setting Success Page Description After Activation Successfully ")
                .perform();

        return this;
    }

    @Step("validate HomeSpot Setting Page After Deactivation Successfully")
    public HomeSpotSetting validateHomeSpotSettingPageAfterDeactivationSuccessfully() {
        driver.verifyThat()
                .element(message_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageSuccessMSGTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Success Page Title After Deactivation Successfully ")
                .perform();

        driver.verifyThat()
                .element(message_description)
                .textTrimmed()
                .contains(homeSpotSettingPageDeactivationSuccessMSGDescription_CL1)
                .withCustomReportMessage("Validate HomeSpot Setting Success Page Description After Deactivation Successfully ")
                .perform();
        driver.verifyThat()
                .element(message_description)
                .textTrimmed()
                .contains(homeSpotSettingPageDeactivationSuccessMSGDescription_CL2)
                .withCustomReportMessage("Validate HomeSpot Setting Success Page Description After Deactivation Successfully ")
                .perform();

        return this;
    }

    @Step("validate HomeSpot Setting Page Activation After Translation Failure")
    public HomeSpotSetting validateHomeSpotSettingPageAfterActivationFailure() {
        driver.verifyThat()
                .element(message_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageFailureMSGTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Title After Translation Failure")
                .perform();

        driver.verifyThat()
                .element(message_description)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageFailureMSGDescription_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Description After Translation Failure")
                .perform();

        driver.verifyThat()
                .element(homeSpotSettingPage_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageActivationTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Error Page Title In Activation Flow")
                .perform();

        return this;
    }

    @Step("validate HomeSpot Setting Page DeActivation After Translation Failure")
    public HomeSpotSetting validateHomeSpotSettingPageAfterDeActivationFailure() {
        driver.verifyThat()
                .element(message_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageFailureMSGTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Title After Translation Failure")
                .perform();

        driver.verifyThat()
                .element(message_description)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageFailureMSGDescription_CL)
                .withCustomReportMessage("Validate HomeSpot Setting Page Description After Translation Failure")
                .perform();

        driver.verifyThat()
                .element(homeSpotSettingPage_title)
                .textTrimmed()
                .isEqualTo(homeSpotSettingPageDeactivationTitle_CL)
                .withCustomReportMessage("Validate HomeSpot Error Page Title In DeActivation Flow")
                .perform();

        return this;
    }

    public HomeSpotSetting ValidateDeeplinkIsBlockedInConfirmationScreen()
    {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") +homeSpotConfirmationScreenURL);
        new KIPSettings(driver).validateHomespotActiveButton();
        //driver.browser().closeCurrentWindow();

        return this;
    }

    public HomeSpotSetting ValidateDeeplinkIsBlockedInSuccessScreen()
    {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + homeSpotSuccessScreenURL );
        new KIPSettings(driver).validateHomespotActiveButton();

        return this;
    }

}
