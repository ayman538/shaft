package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class GenerateSIP {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By GenerateSIP_Title = By.xpath("//*[@automation-id=\"generate_SIP_nt\"]//h4");
    public static final By GenerateSIP_Body = By.xpath("//*[@automation-id=\"generate_SIP_nt\"]//p");
    public static final By GenerateSIP_BTN = By.xpath("//*[@automation-id=\"generate_SIP_btn\"]");
    public static final By GenerateSIP_Page_Title = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1");
    public static final By GenerateSIP_Stepper_Title = By.xpath("//*[@automation-id=\"oneStepStepperHeader_tv\"]");
    public static final By GenerateSIP_Stepper_Icon = By.xpath("//*[@class=\"icon-pin-sim-i-xsml i-xsml ac-icon\"]");
    public static final By GenerateSIP_Stepper_Text = By.xpath("//*[@automation-id=\"cableSipCredentialsInfo_tv\"]");
    public static final By GenerateSIP_Stepper_BTN = By.xpath("//*[@automation-id=\"generateCableSipCredentials_btn\"]");
    public static final By GenerateSIP_SuccessMSG_Title = By.xpath("//*[@automation-id=\"success_nt\"]//h4");
    public static final By GenerateSIP_SuccessMSG_Body = By.xpath("//*[@automation-id=\"success_nt\"]//p");
    public static final By GenerateSIP_SuccessMSG_ICON = By.xpath("//*[@class=\"i-sml i-green\"]");
    public static final By NewSIP_Title = By.xpath("//*[@automation-id=\"newPassword_tv\"]");
    public static final By NewSIP_Field = By.xpath("//*[@automation-id=\"sipPassword_et\"]");
    public static final By NewSIP_Eye_Icon = By.xpath("//*[@class=\"icon field-icon i-sml\"]");
    public static final By NewSIP_HiddenToken = By.xpath("//*[@automation-id=\"sipPassword_et\"]");
    public static final By NewSIP_Token = By.xpath("//*[@automation-id=\"sipPassword_et\"]");
    public static final By NewSIP_Inline_MSG = By.xpath("//*[@automation-id=\"passwordInfo_tv\"]");
    public static final By GenerateSIP_FailMSG_Title = By.xpath("//*[@automation-id=\"undefined_nt\"]//h4");
    public static final By GenerateSIP_FailMSG_Body = By.xpath("//*[@automation-id=\"undefined_nt\"]//p");
    public static final By GenerateSIP_FailMSG_ICON = By.xpath("(//*[@class=\"i-sml i-red\"])[1]");


    //CLs
    public static String GenerateSIP_Title_CL = "SIP-Kennwort";
    public static String GenerateSIP_Body_CL = "Als Du Deinen Router eingerichtet hast, wurde Dir bereits ein SIP-Kennwort angezeigt. Wenn Du Dein SIP-Kennwort vergessen hast, kannst Du Dir hier ein neues erzeugen.";
    public static String GenerateSIP_BTN_CL = "SIP-Kennwort erzeugen";
    public static String GenerateSIP_Page_Title_CL = "SIP-Kennwort erzeugen";
    public static String GenerateSIP_Stepper_Title_CL = "SIP-Kennwort";
    public static String GenerateSIP_Stepper_Text_CL = "Gut zu wissen: Bewahr Deine SIP-Zugangsdaten sicher auf. So schützt Du Dich vor Datendiebstahl.";
    public static String GenerateSIP_Stepper_BTN_CL = "SIP-Kennwort erzeugen";
    public static String GenerateSIP_SuccessMSG_Title_CL = "Geschafft";
    public static String GenerateSIP_SuccessMSG_Body_CL = "Dein neues SIP-Kennwort wurde erfolgreich erzeugt. Es kann wenige Minuten dauern, bis Dein SIP-Kennwort aktiv ist und Du Deinen Router einrichten kannst.";
    public static String NewSIP_Title_CL = "Dein neues SIP-Kennwort";
    public static String NewSIP_Inline_MSG_CL = "Stell sicher, dass niemand mitlesen kann. Klick dann auf das Augensymbol.";
    public static String GenerateSIP_FailMSG_Title_CL = "Das hat leider nicht geklappt";
    public static String GenerateSIP_FailMSG_Body_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    //constructor
    public GenerateSIP(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public GenerateSIP ValidateGenerateSIPSection() {
        driver.verifyThat().element(GenerateSIP_Title).textTrimmed()
                .isEqualTo(GenerateSIP_Title_CL)
                .withCustomReportMessage("Check that GenerateSIP_Title text is correct")
                .perform();
        driver.verifyThat().element(GenerateSIP_Body).textTrimmed()
                .isEqualTo(GenerateSIP_Body_CL)
                .withCustomReportMessage("Check that GenerateSIP_Body text is correct")
                .perform();
        driver.verifyThat().element(GenerateSIP_BTN).textTrimmed()
                .isEqualTo(GenerateSIP_BTN_CL)
                .withCustomReportMessage("Check that GenerateSIP_BTN text is correct")
                .perform();
        return this;
    }

    public GenerateSIP NavigateToGenerateSIPPage() {
        driver.element().click(GenerateSIP_BTN);
        return this;
    }

    public GenerateSIP ValidateGenerateSIPPage() {
        driver.verifyThat().element(GenerateSIP_Stepper_Title).textTrimmed()
                .isEqualTo(GenerateSIP_Stepper_Title_CL)
                .withCustomReportMessage("Check that GenerateSIP_Stepper_Title text is correct")
                .perform();

        driver.verifyThat().element(GenerateSIP_Page_Title).textTrimmed()
                .isEqualTo(GenerateSIP_Page_Title_CL)
                .withCustomReportMessage("Check that GenerateSIP_Page_Title text is correct")
                .perform();

        driver.verifyThat().element(GenerateSIP_Stepper_Icon).exists()
                .withCustomReportMessage("Check that Icon of GenerateSIP_Stepper is exist")
                .perform();
        driver.verifyThat().element(GenerateSIP_Stepper_Text).textTrimmed()
                .isEqualTo(GenerateSIP_Stepper_Text_CL)
                .withCustomReportMessage("Check that GenerateSIP_Stepper_Text text is correct")
                .perform();
        driver.verifyThat().element(GenerateSIP_Stepper_BTN).textTrimmed()
                .isEqualTo(GenerateSIP_Stepper_BTN_CL)
                .withCustomReportMessage("Check that GenerateSIP_Stepper_BTN text is correct")
                .perform();
        return this;
    }

    public GenerateSIP ClickOnGenerateSIPCredentials() {
        driver.element().click(GenerateSIP_Stepper_BTN);
        return this;
    }

    public GenerateSIP ValidateGenerateSIPSuccessMessage() {
        driver.verifyThat().element(GenerateSIP_SuccessMSG_Title).textTrimmed()
                .isEqualTo(GenerateSIP_SuccessMSG_Title_CL)
                .withCustomReportMessage("Check that GenerateSIP_SuccessMSG text is correct")
                .perform();
        driver.verifyThat().element(GenerateSIP_SuccessMSG_Body).textTrimmed()
                .isEqualTo(GenerateSIP_SuccessMSG_Body_CL)
                .withCustomReportMessage("Check that GenerateSIP_SuccessMSG_Body text is correct")
                .perform();
        driver.verifyThat().element(GenerateSIP_SuccessMSG_ICON).exists()
                .withCustomReportMessage("Check that Icon of GenerateSIP_SuccessMSG is exist")
                .perform();
        return this;
    }

    public GenerateSIP ValidateNewSIPSection() {
        driver.verifyThat().element(NewSIP_Title).textTrimmed()
                .isEqualTo(NewSIP_Title_CL)
                .withCustomReportMessage("Check that NewSIP_Title text is correct")
                .perform();
        driver.verifyThat().element(NewSIP_Inline_MSG).textTrimmed()
                .isEqualTo(NewSIP_Inline_MSG_CL)
                .withCustomReportMessage("Check that NewSIP_Inline_MSG text is correct")
                .perform();
        driver.verifyThat().element(NewSIP_Field).exists()
                .withCustomReportMessage("Check that Icon of NewSIP_Field is exist")
                .perform();
        driver.verifyThat().element(NewSIP_Eye_Icon).exists()
                .withCustomReportMessage("Check that Icon of NewSIP_Eye_Icon is exist")
                .perform();

        driver.verifyThat().element(NewSIP_HiddenToken).exists()
                .withCustomReportMessage("Check that Icon of NewSIP_HiddenToken is exist")
                .perform();
        driver.element().click(NewSIP_Eye_Icon);
        driver.verifyThat().element(NewSIP_Token).exists()
                .withCustomReportMessage("Check that Icon of NewSIP_Token is exist")
                .perform();
        return this;
    }

    public GenerateSIP ValidateGenerateSIPFailureMessage() {
        driver.verifyThat().element(GenerateSIP_FailMSG_Title).textTrimmed()
                .isEqualTo(GenerateSIP_FailMSG_Title_CL)
                .withCustomReportMessage("Check that GenerateSIP_FailMSG text is correct")
                .perform();
        driver.verifyThat().element(GenerateSIP_FailMSG_Body).textTrimmed()
                .isEqualTo(GenerateSIP_FailMSG_Body_CL)
                .withCustomReportMessage("Check that GenerateSIP_FailMSG_Body text is correct")
                .perform();
        driver.verifyThat().element(GenerateSIP_FailMSG_ICON).exists()
                .withCustomReportMessage("Check that Icon of GenerateSIP_FailMSG is exist")
                .perform();
        return this;
    }

    public GenerateSIP ValidateDeeplinkBlocking()
    {
        driver.browser().navigateToURL("https://simplicity.wf-de.vodafone.com/meinvodafone/services/sipkennwort/erzeugen");

        driver.verifyThat().element(GenerateSIP_BTN).exists()
                .withCustomReportMessage("Check that generation button Exists")
                .perform();
        return this;
    }
}
