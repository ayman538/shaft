package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class BridgeModeSettings {
    private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String serviceFailureMsgText_CL ="Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String serviceFailureMsgTitle_CL = "Das hat leider nicht geklappt";
    private static String activationConfirmationMsg_Text_CL = "Der Router startet jetzt neu und der Bridge-Mode wird aktiviert. Das dauert nur wenige Minuten.";
    private static String deactivationConfirmationMsg_Text_CL = "Der Router startet jetzt neu und der Bridge-Mode wird deaktiviert. Das dauert nur wenige Minuten.";
    private static String confirmationMsg_Title_CL = "Geschafft";
    private static String activationSectionTitle_CL = "Bridge-Mode aktivieren";
    private static String deactivationSectionTitle_CL = "Bridge-Mode deaktivieren";
    private static String deactivationPageTitle_CL = "Bridge-Mode deaktivieren";
    private static String activationPageTitle_CL = "Bridge-Mode aktivieren";
    private static String bridgeModeActivationBtn_CL = "Bridge-Mode aktivieren";
    private static String bridgeModeDeactivationBtn_CL = "Bridge-Mode deaktivieren";
    private static String bridgeModeActivationText1_CL1 ="Gut zu wissen: Du brauchst den Bridge-Mode nur, wenn Du zwei Router gleichzeitig nutzen möchtest. Wir empfehlen Dir, nur unseren mitgelieferten Router zu verwenden.";
    private static String bridgeModeActivationText1_CL2 ="Das WLAN in Deinem Vodafone-Router wird bei aktiviertem Bridge-Mode deaktiviert.";

    private static String bridgeModeDeactivationText_CL = "Gut zu wissen: Du kannst den Bridge-Mode jederzeit wieder aktivieren.";

    //Locators
    private static final By activationPageTitle = By.xpath("//div[@automation-id=\"pageHeader_tv\"]//h1");
    private static final By deactivationPageTitle = By.xpath("//div[@automation-id=\"pageHeader_tv\"]//h1");
    private static final By backBtn = By.xpath("//a[@automation-id='back_Link']");
    private static final By serviceFailureMsgText = By.xpath("//div[@automation-id='undefined_nt']//p");
    private static final By serviceFailureMsgTitle = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private static final By activationConfirmationMsg_Text = By.xpath("//div[@automation-id=\"success_activate_bridge_mode_nt\"]//p");
    private static final By deactivationConfirmationMsg_Text = By.xpath("//div[@automation-id=\"success_deactivate_bridge_mode_nt\"]//p");
    private static final By confirmationMsg_Title = By.xpath("//div[@automation-id=\"success_deactivate_bridge_mode_nt\"]//h4");
    private static final By actConfirmationMsg_Title = By.xpath("//div[@automation-id=\"success_activate_bridge_mode_nt\"]//h4");
    private static final By activationSectionTitle = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private static final By deactivationSectionTitle = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private static final By pageSubTitle = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private static final By bridgeModeActivationBtn = By.xpath("//button[@automation-id='activate_bridge_mode_submit_btn']");
    private static final By bridgeModeDeactivationBtn = By.xpath("//button[@automation-id='deActivate_bridge_mode_submit_btn']");
    private static final By bridgeModeActivationText = By.xpath("//p[@automation-id='activate_bridge_mode_submit_tv']");
    private static final By bridgeModeDeactivationText = By.xpath("//p[@automation-id='deactivate_bridge_mode_submit_tv']");

    //constructor
    public BridgeModeSettings (SHAFT.GUI.WebDriver shaftDriver)
    {
        this.driver = shaftDriver;
    }

    //methods
    @Step("validate Activation Bridge-Mode Page")
    public BridgeModeSettings validateActivationBridgeModePage (){
        driver.verifyThat().element(backBtn).exists().perform();
        driver.verifyThat().element(pageSubTitle).exists().perform();
        driver.element().isElementDisplayed(activationSectionTitle);
        driver.verifyThat().element(activationSectionTitle).textTrimmed().contains(activationSectionTitle_CL)
                .withCustomReportMessage("Validate Section Title")
                .perform();
        driver.verifyThat().element(activationPageTitle).textTrimmed().contains(activationPageTitle_CL)
                .withCustomReportMessage("Validate activation Page Title ")
                .perform();
        driver.verifyThat().element(bridgeModeActivationText).textTrimmed().contains(bridgeModeActivationText1_CL1)
                .withCustomReportMessage("Validate bridgeMode Activation section's first Text1 ")
                .perform();
        driver.verifyThat().element(bridgeModeActivationText).textTrimmed().contains(bridgeModeActivationText1_CL2)
                .withCustomReportMessage("Validate bridgeMode Activation section's first Text2 ")
                .perform();
        driver.verifyThat().element(bridgeModeActivationBtn).textTrimmed().contains(bridgeModeActivationBtn_CL)
                .withCustomReportMessage("Validate bridgeMode Activation section's Button ")
                .perform();
        driver.verifyThat().element(bridgeModeActivationBtn).isEnabled().perform();
        return this;
    }

    @Step("click On Activation Bridge-Mode CTA Btn")
    public BridgeModeSettings clickOnActivationBridgeModeBtn (){
        driver.element().click(bridgeModeActivationBtn);
        return this;
    }

    @Step("validate Confirmation Success Msg of Activation Bridge-Mode")
    public BridgeModeSettings validateActivationConfirmationSuccessMsg (){
        driver.verifyThat().element(actConfirmationMsg_Title).textTrimmed().contains(confirmationMsg_Title_CL)
                .withCustomReportMessage("Validate confirmation msg's title ")
                .perform();
        driver.verifyThat().element(activationConfirmationMsg_Text).textTrimmed().contains(activationConfirmationMsg_Text_CL)
                .withCustomReportMessage("Validate confirmation msg's text")
                .perform();
        return this;
    }

    @Step("validate Deactivation Bridge-Mode Page")
    public BridgeModeSettings validateDeactivationBridgeModePage (){
        driver.verifyThat().element(backBtn).exists().perform();
        driver.verifyThat().element(pageSubTitle).exists().perform();
        driver.element().isElementDisplayed(deactivationSectionTitle);
        driver.verifyThat().element(deactivationSectionTitle).textTrimmed().contains(deactivationSectionTitle_CL)
                .withCustomReportMessage("Validate Section Title")
                .perform();
        driver.verifyThat().element(deactivationPageTitle).textTrimmed().contains(deactivationPageTitle_CL)
                .withCustomReportMessage("Validate activation Page Title ")
                .perform();
        driver.verifyThat().element(bridgeModeDeactivationText).textTrimmed().contains(bridgeModeDeactivationText_CL)
                .withCustomReportMessage("Validate bridgeMode deaktivieren section's Text ")
                .perform();
        driver.verifyThat().element(bridgeModeDeactivationBtn).textTrimmed().contains(bridgeModeDeactivationBtn_CL)
                .withCustomReportMessage("Validate bridgeMode deaktivieren section's Button ")
                .perform();
        driver.verifyThat().element(bridgeModeDeactivationBtn).isEnabled().perform();
        return this;
    }

    @Step("click On Deactivation Bridge-Mode CTA Btn")
    public BridgeModeSettings clickOnDeactivationBridgeModeBtn (){
        driver.element().click(bridgeModeDeactivationBtn);
        return this;
    }

    @Step("validate Confirmation Success Msg of Deactivation Bridge-Mode")
    public BridgeModeSettings validateDeactivationConfirmationSuccessMsg (){
        driver.verifyThat().element(confirmationMsg_Title).textTrimmed().contains(confirmationMsg_Title_CL)
                .withCustomReportMessage("Validate confirmation msg's title ")
                .perform();
        driver.verifyThat().element(deactivationConfirmationMsg_Text).textTrimmed().contains(deactivationConfirmationMsg_Text_CL)
                .withCustomReportMessage("Validate confirmation msg's text")
                .perform();
        return this;
    }

    @Step("validate Failure of confirmation step of  de/activation Bridge-Mode ")
    public BridgeModeSettings validateConfirmationFailureMsg(){
        driver.element().isElementDisplayed(serviceFailureMsgTitle);
        driver.verifyThat().element(serviceFailureMsgTitle).textTrimmed().contains(serviceFailureMsgTitle_CL)
                .withCustomReportMessage("Validate service Failure notification msg's Title")
                .perform();
        driver.verifyThat().element(serviceFailureMsgText).textTrimmed().contains(serviceFailureMsgText_CL)
                .withCustomReportMessage("Validate service Failure notification msg's text")
                .perform();
        return this;
    }

}

