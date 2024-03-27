package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;


public class FSKPinActivation {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By FSK_Activate_SO = By.xpath("//*[@automation-id=\"fsk18Pin_so\"]");
    public static final By FSK_Activate_SO_Title = By.xpath("//*[@automation-id=\"fsk18Pin_so\"]//h3");
    public static final By FSK_Activate_SO_Desc = By.xpath("//*[@automation-id=\"fsk18Pin_so\"]//*[@class=\"sb-block-footer\"]");
    public static final By FSK_Activate_SO_Icon = By.xpath("//*[@automation-id=\"fsk18Pin_so\"]//*[@class=\"icon-circle-i-mdm i-grey w-70\"]");
    public static final By FSK_Activate_Accordion = By.xpath("//*[@automation-id=\"fsk18Pin_acc\"]");
    public static final By Back_ToFSKAcc_Btn = By.xpath("//a[@automation-id='back_Link']");

    public static final By FSK_ActiveAcc_Title = By.xpath("//*[@automation-id=\"fsk18Pin_acc\"]//h4");
    public static final By FSK_ActiveAcc_Desc = By.xpath("//*[@automation-id=\"fsk18Pin_acc\"]//h5");
    public static final By FSK_ActiveAcc_Icon = By.xpath("//*[@automation-id=\"fsk18Pin_acc\"]//*[@class=\"ac-icon i-main_icn_settings_02-sml i-sml\"]");

    public static final By FSK_NotBooked_MSGTitle = By.xpath("//*[@automation-id=\"fsk18Pin-unbooked_nt\"]//h4");
    public static final By FSK_NotBooked_MSGBody = By.xpath("//*[@automation-id=\"fsk18Pin-unbooked_nt\"]//p");
    public static final By FSK_NotBooked_Icon = By.xpath("//*[@automation-id=\"fsk18Pin-unbooked_nt\"]//*[@class=\"i-sml i-blue\"]");

    public static final By FSK_Default_MSGTitle = By.xpath("//*[@automation-id=\"fsk18Pin_tv\"]//h4");
    public static final By FSK_Default_MSGBody = By.xpath("//*[@automation-id=\"fsk18Pin_tv\"]//p");
    public static final By FSK_Default_MSGButton = By.xpath("//*[@automation-id=\"fsk18Pin_btn\"]");

    public static final By FSK_ActivationFlow_Page_Title = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1");
    public static final By FSK_ActivationFlow_container_Title = By.xpath("//*[@automation-id=\"oneStepStepperHeader_tv\"]");
    public static final By FSK_ActivationFlow_container_Icon = By.xpath("//*[@class=\"icon-pin-sim-i-xsml i-xsml ac-icon\"]");
    public static final By FSK_ActivationFlow_InfoMSG_Title = By.xpath("//*[@automation-id=\"fsk18_tv\"]/h4");
    public static final By FSK_ActivationFlow_InfoMSG_Body = By.xpath("//*[@automation-id=\"fsk18_tv\"]/span");
    public static final By FSK_ActivationFlow_Instructions_Title = By.xpath("//*[@automation-id=\"fskInstructions_tv\"]/h4");
    public static final By FSK_ActivationFlow_Instructions_Body = By.xpath("//*[@automation-id=\"fskInstructions_tv\"]/div");
    public static final By FSK_ActivationFlow_Confirm_Button = By.xpath("//*[@automation-id=\"activate_btn\"]");

    public static final By FSK_ActivationResult_SuccessMSG_Title = By.xpath("//*[@automation-id=\"successful_nt\"]/div/div/div/div/h4");
    public static final By FSK_ActivationResult_SuccessMSG_Body = By.xpath("//*[@automation-id=\"successful_nt\"]/div/div/p");
    public static final By FSK_ActivationResult_SuccessMSG_Icon = By.xpath("//*[@automation-id=\"successful_nt\"]//*[@class=\"i-sml\"]");

    public static final By FSK_ActivationResult_FailMSG_Title = By.xpath("//*[@automation-id=\"succFailed_nt\"]//h4");
    public static final By FSK_ActivationResult_FailMSG_Body = By.xpath("//*[@automation-id=\"succFailed_nt\"]//p");
    public static final By FSK_ActivationResult_FailMSG_Button = By.xpath("//*[@automation-id=\"succFailed_btn\"]");
    public static final By FSK_ActivationResult_FailMSG_Icon = By.xpath("//*[@automation-id=\"succFailed_nt\"]//*[@class=\"item-1\"]");

    public static final By FSK_ActivationResult_PartFailMSG_Title = By.xpath("//*[@automation-id=\"succFailed_nt\"]//h4");
    public static final By FSK_ActivationResult_PartFailMSG_Body = By.xpath("//*[@automation-id=\"succFailed_nt\"]/div/div/p");
    public static final By FSK_ActivationResult_PartFailMSG_Button = By.xpath("//*[@automation-id=\"succFailed_btn\"]");
    public static final By FSK_ActivationResult_PartFailMSG_Icon = By.xpath("//*[@automation-id=\"succFailed_nt\"]//*[@class=\"i-sml i-orange\"]");

    public static final By FSK_ActivationInProgressMSG_Title = By.xpath("//*[@automation-id=\"blockActivation_nt\"]//h4");
    public static final By FSK_ActivationInProgressMSG_Body = By.xpath("//*[@automation-id=\"blockActivation_nt\"]//p");
    public static final By FSK_ActivationInProgressMSG_Icon = By.xpath("//*[@automation-id=\"blockActivation_nt\"]//*[@class=\"i-sml i-blue\"]");


    //CLs
    public static String FSK_Activate_SO_Title_CL = "FSK18-PIN aktivieren";
    public static String FSK_Activate_SO_Desc_CL = "Verschlüsselte TV-Inhalte freischalten";
    public static String FSK_ActiveAcc_Title_CL = "FSK18-PIN aktivieren";
    public static String FSK_ActiveAcc_Desc_CL = "Verschlüsselte TV-Inhalte freischalten";

    public static String FSK_NotBooked_MSGTitle_CL = "Du hast keine FSK18-PIN gebucht";
    public static String FSK_NotBooked_MSGBody_CL = "Die FSK18-PIN kannst Du nur telefonisch buchen. Ruf uns einfach unter 0800 172 1212 an, kostenlos aus allen deutschen Netzen. Rund um die Uhr.";

    public static String FSK_Default_MSGTitle_CL = "FSK18-PIN aktivieren";
    public static String FSK_Default_MSGBody_CL = "Die FSK18-PIN brauchst Du für Inhalte, die gesetzlich erst ab 18 Jahren freigegeben sind.";
    public static String FSK_Default_MSGButton_CL = "FSK18-PIN aktivieren";

    public static String FSK_ActivationFlow_Page_Title_CL = "FSK18-PIN aktivieren";
    public static String FSK_ActivationFlow_container_Title_CL = "FSK18-PIN aktivieren";
    public static String FSK_ActivationFlow_InfoMSG_Title_CL = "FSK18-PIN aktivieren";
    public static String FSK_ActivationFlow_InfoMSG_Body_CL = "Du kannst die FSK18-PIN ganz einfach selbst aktivieren, um verschlüsselte TV-Inhalte sehen zu können. Bevor Du sie aktivierst, stell bitte sicher, dass Deine Smartcard eingelegt ist.";
    public static String FSK_ActivationFlow_Instructions_Title_CL = "Anleitung";
    public static String FSK_ActivationFlow_Instructions_Body_CL1 = "1. Setz die Smartcard in den Kartenschlitz Deines Digital-/HD-Receivers ein. (Nicht nötig, wenn Du eine Horizon Box hast.)";
    public static String FSK_ActivationFlow_Instructions_Body_CL2 = "2. Stell sicher, dass Dein Gerät eingeschaltet ist.";
    public static String FSK_ActivationFlow_Instructions_Body_CL3 = "3. Wähl ein Programm Deines Kabelanschlusses oder zusätzlich gebuchten Programmpakets aus.";
    public static String FSK_ActivationFlow_Confirm_Button_CL = "FSK18-PIN aktivieren";

    public static String FSK_ActivationResult_SuccessMSG_Title_CL = "Deine FSK18-PIN ist aktiviert";
    public static String FSK_ActivationResult_SuccessMSG_Body_CL1 = "Die Freischaltung sollte innerhalb einer Stunde erfolgen. Du kannst die FSK18-PIN dann einfach über Deine Fernbedienung eingeben.";
    public static String FSK_ActivationResult_SuccessMSG_Body_CL2 = "Bitte stell in dieser Zeit sicher, dass die Smartcard richtig im Kartenschlitz Deines Digital Receivers steckt, dieser eingeschaltet ist und ein Programm Deines digitalen Kabelanschlusses oder zusätzlich gebuchten Programmpakets ausgewählt ist.";

    public static String FSK_ActivationResult_FailMSG_Title_CL = "Deine FSK18-PIN konnte leider nicht freigeschaltet werden.";
    public static String FSK_ActivationResult_FailMSG_Body_CL1 = "Mögliche Gründe dafür sind:";
    public static String FSK_ActivationResult_FailMSG_Body_CL2 = "1. Deine Smartcard ist nicht erreichbar.";
    public static String FSK_ActivationResult_FailMSG_Body_CL3 = "2. Fehler bei der Übertragung.";
    public static String FSK_ActivationResult_FailMSG_Body_CL4 ="Bitte stell sicher, dass Du alle Schritte der Anleitung eingehalten hast und versuch es nochmal. Wenn es nicht klappt, ruf uns einfach kostenlos unter der 0800 172 1212 an.";
    public static String FSK_ActivationResult_FailMSG_Button_CL = "Nochmal versuchen";
    public static String FSK_ActivationResult_PartFailMSG_Title_CL = "Deine FSK18-PIN konnte nicht für all Deine Smartcards aktiviert werden.";
    public static String FSK_ActivationResult_PartFailMSG_Body_CL1 = "Mögliche Gründe dafür sind:";
    public static String FSK_ActivationResult_PartFailMSG_Body_CL2 = "1. Deine Smartcard ist nicht erreichbar.";
    public static String FSK_ActivationResult_PartFailMSG_Body_CL3 = "2. Fehler bei der Übertragung.";
    public static String FSK_ActivationResult_PartFailMSG_Body_CL4 ="Bitte stell sicher, dass Du alle Schritte der Anleitung eingehalten hast und versuch es nochmal. Wenn es nicht klappt, ruf uns einfach kostenlos unter der 0800 172 1212 an.";

    public static String FSK_ActivationResult_PartFailMSG_Button_CL = "Nochmal versuchen";

    public static String FSK_ActivationInProgressMSG_Title_CL = "Wir sind gerade dabei Deine FSK18-PIN zu aktivieren";
    public static String FSK_ActivationInProgressMSG_Body_CL = "Bitte hab noch etwas Geduld, innerhalb einer Stunde sollte die FSK18-PIN aktiviert sein.";

    //constructor
    public FSKPinActivation(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public FSKPinActivation ExpandFSKActivationAccordion() {
        driver.element().isElementClickable(FSK_Activate_SO);
        driver.element().click(FSK_Activate_SO);
        return this;
    }

    public FSKPinActivation ValidateFSKActivationSection() {
        driver.verifyThat().element(FSK_Default_MSGTitle).textTrimmed()
                .isEqualTo(FSK_Default_MSGTitle_CL)
                .withCustomReportMessage("Check that Title of FSK activation default message is correct")
                .perform();

        driver.verifyThat().element(FSK_Default_MSGBody).textTrimmed()
                .isEqualTo(FSK_Default_MSGBody_CL)
                .withCustomReportMessage("Check that Body of FSK activation default message is correct")
                .perform();

        driver.verifyThat().element(FSK_Default_MSGButton).textTrimmed()
                .isEqualTo(FSK_Default_MSGButton_CL)
                .withCustomReportMessage("Check that Text of FSK activation default message button is correct")
                .perform();
        return this;
    }

    public FSKPinActivation NavigateToFSKActivationFlow() {
        driver.element().isElementClickable(FSK_Default_MSGButton);
        driver.element().click(FSK_Default_MSGButton);
        return this;
    }

    public FSKPinActivation ValidateFSKActivationFlow() {
        driver.verifyThat().element(FSK_ActivationFlow_container_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation container is exist")
                .perform();
        driver.verifyThat().element(FSK_ActivationFlow_Page_Title).textTrimmed()
                .isEqualTo(FSK_ActivationFlow_Page_Title_CL)
                .withCustomReportMessage("Check that title of FSK Activation flow page is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationFlow_container_Title).textTrimmed()
                .isEqualTo(FSK_ActivationFlow_container_Title_CL)
                .withCustomReportMessage("Check that title of FSK Activation container is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationFlow_container_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation container is exist")
                .perform();
        driver.verifyThat()
                .element(FSK_ActivationFlow_InfoMSG_Title).textTrimmed()
                .isEqualTo(FSK_ActivationFlow_InfoMSG_Title_CL)
                .withCustomReportMessage("Check that message title of FSK Activation Flow is correct")
                .perform();
        driver.verifyThat()
                .element(FSK_ActivationFlow_InfoMSG_Body).textTrimmed()
                .isEqualTo(FSK_ActivationFlow_InfoMSG_Body_CL)
                .withCustomReportMessage("Check that message body of FSK Activation Flow is correct")
                .perform();

        driver.verifyThat()
                .element(FSK_ActivationFlow_Instructions_Title)
                .textTrimmed()
                .isEqualTo(FSK_ActivationFlow_Instructions_Title_CL)
                .withCustomReportMessage("Check that instructions title of FSK Activation Flow is correct")
                .perform();


        driver.verifyThat()
                .element(FSK_ActivationFlow_Instructions_Body).textTrimmed()
                .contains(FSK_ActivationFlow_Instructions_Body_CL1)
                .withCustomReportMessage("Check that instructions body of FSK Activation Flow is correct")
                .perform();
        driver.verifyThat()
                .element(FSK_ActivationFlow_Instructions_Body).textTrimmed()
                .contains(FSK_ActivationFlow_Instructions_Body_CL2)
                .withCustomReportMessage("Check that instructions body of FSK Activation Flow is correct")
                .perform();
        driver.verifyThat()
                .element(FSK_ActivationFlow_Instructions_Body).textTrimmed()
                .contains(FSK_ActivationFlow_Instructions_Body_CL3)
                .withCustomReportMessage("Check that instructions body of FSK Activation Flow is correct")
                .perform();

        driver.verifyThat()
                .element(FSK_ActivationFlow_Confirm_Button).textTrimmed()
                .isEqualTo(FSK_ActivationFlow_Confirm_Button_CL)
                .withCustomReportMessage("Check that text of confirmation button of FSK Activation Flow is correct")
                .perform();
        return this;
    }

    public FSKPinActivation ConfirmFSKActivationFlow() {
        driver.element().isElementClickable(FSK_ActivationFlow_Confirm_Button);
        driver.element().click(FSK_ActivationFlow_Confirm_Button);
        return this;
    }

    public FSKPinActivation ValidateFSKActivationConfirmationAllSuccess() {
        driver.verifyThat().element(FSK_ActivationResult_SuccessMSG_Title).textTrimmed()
                .isEqualTo(FSK_ActivationResult_SuccessMSG_Title_CL)
                .withCustomReportMessage("Check that title of FSK Activation Success message is correct")
                .perform();

        driver.verifyThat()
                .element(FSK_ActivationResult_SuccessMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_SuccessMSG_Body_CL1)
                .withCustomReportMessage("Check that Body of FSK Activation Success message1 is correct")
                .perform();
        driver.verifyThat()
                .element(FSK_ActivationResult_SuccessMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_SuccessMSG_Body_CL2)
                .withCustomReportMessage("Check that Body of FSK Activation Success message2 is correct")
                .perform();


        driver.verifyThat().element(FSK_ActivationResult_SuccessMSG_Icon)
                .exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation success message is exist")
                .perform();
        return this;
    }

    public FSKPinActivation ValidateFSKActivationConfirmationAllFailed () {
        driver.verifyThat().element(FSK_ActivationResult_FailMSG_Title).textTrimmed()
                .isEqualTo(FSK_ActivationResult_FailMSG_Title_CL)
                .withCustomReportMessage("Check that title of FSK Activation Failed message is correct")
                .perform();

        driver.verifyThat().element(FSK_ActivationResult_FailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_FailMSG_Body_CL1)
                .withCustomReportMessage("Check that Body of FSK Activation Failed message is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationResult_FailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_FailMSG_Body_CL2)
                .withCustomReportMessage("Check that Body of FSK Activation Failed message is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationResult_FailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_FailMSG_Body_CL3)
                .withCustomReportMessage("Check that Body of FSK Activation Failed message is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationResult_FailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_FailMSG_Body_CL4)
                .withCustomReportMessage("Check that Body of FSK Activation Failed message is correct")
                .perform();

        driver.verifyThat().element(FSK_ActivationResult_FailMSG_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation Failed message is exist")
                .perform();

        driver.assertThat().element(FSK_ActivationResult_FailMSG_Button).textTrimmed()
                .isEqualTo(FSKPinActivation.FSK_ActivationResult_FailMSG_Button_CL)
                .withCustomReportMessage("Check that button's text of FSK Activation Failed message is correct")
                .perform();
        return this;
    }

    public FSKPinActivation ValidateFSKActivationConfirmationPartialSuccess () {
        driver.verifyThat().element(FSK_ActivationResult_PartFailMSG_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation partially success message is exist")
                .perform();
        driver.verifyThat()
                .element(FSK_ActivationResult_PartFailMSG_Title).textTrimmed()
                .isEqualTo(FSK_ActivationResult_PartFailMSG_Title_CL)
                .withCustomReportMessage("Check that title of FSK Activation partially Success message is correct")
                .perform();

        driver.verifyThat().element(FSK_ActivationResult_PartFailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_PartFailMSG_Body_CL1)
                .withCustomReportMessage("Check that Body of FSK Activation partially Success message is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationResult_PartFailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_PartFailMSG_Body_CL2)
                .withCustomReportMessage("Check that Body of FSK Activation partially Success message is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationResult_PartFailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_PartFailMSG_Body_CL3)
                .withCustomReportMessage("Check that Body of FSK Activation partially Success message is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationResult_PartFailMSG_Body).textTrimmed()
                .contains(FSK_ActivationResult_PartFailMSG_Body_CL4)
                .withCustomReportMessage("Check that Body of FSK Activation partially Success message is correct")
                .perform();

        driver.verifyThat().element(FSK_ActivationResult_PartFailMSG_Button).textTrimmed()
                .isEqualTo(FSK_ActivationResult_PartFailMSG_Button_CL)
                .withCustomReportMessage("Check that button's text of FSK Activation partially Success message is correct")
                .perform();
        return this;
    }

    public FSKPinActivation ClickOnPartiallyFailedButton(){
        driver.element().isElementClickable(FSK_ActivationResult_PartFailMSG_Button);
        driver.element().click(FSK_ActivationResult_PartFailMSG_Button);
    return this;
    }

    public FSKPinActivation ClickOnActivationFailedButton(){
        driver.element().isElementClickable(FSK_ActivationResult_FailMSG_Button);
        driver.element().click(FSK_ActivationResult_FailMSG_Button);
    return this;
    }

    public FSKPinActivation NavigateBackToFSKAccordion(){
        driver.element().isElementClickable(Back_ToFSKAcc_Btn);
        driver.element().click(Back_ToFSKAcc_Btn);
    return this;
    }

    public FSKPinActivation ValidateBackToFSKAccordion () {
        driver.element().isElementDisplayed(FSK_ActivationFlow_Confirm_Button);
        driver.verifyThat().element(FSKPinActivation.FSK_ActivationFlow_Confirm_Button).exists()
                .withCustomReportMessage("Check that when click on partially failed message's button it's back to TV settings page")
                .perform();
        return this;
    }

    public FSKPinActivation ValidateFSKActivationInProgress () {
        driver.verifyThat().element(FSK_ActivationInProgressMSG_Title).textTrimmed()
                .isEqualTo(FSK_ActivationInProgressMSG_Title_CL)
                .withCustomReportMessage("Check that title of FSK Activation in progress message is correct")
                .perform();
        driver.verifyThat().element(FSKPinActivation.FSK_ActivationInProgressMSG_Body).textTrimmed()
                .isEqualTo(FSK_ActivationInProgressMSG_Body_CL)
                .withCustomReportMessage("Check that Body of FSK Activation in progress message is correct")
                .perform();
        driver.verifyThat().element(FSK_ActivationInProgressMSG_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation in progress message is exist")
                .perform();
        return this;
    }

    //WFDT-6208
    public FSKPinActivation ValidateFSKAccordion ()
    {
        driver.verifyThat().element(FSK_Activate_SO).exists()
                .withCustomReportMessage("Check that FSK 18 activation smart object is exist")
                .perform();
        driver.verifyThat().element(FSK_Activate_Accordion).exists()
                .withCustomReportMessage("Check that FSK 18 activation accordion is exist")
                .perform();

        driver.verifyThat().element(FSK_Activate_SO_Title).textTrimmed()
                .isEqualTo(FSK_Activate_SO_Title_CL)
                .withCustomReportMessage("Check that Title of FSK activation smart object is correct")
                .perform();
        driver.verifyThat().element(FSK_Activate_SO_Desc).textTrimmed().isEqualTo(FSK_Activate_SO_Desc_CL)
                .withCustomReportMessage("Check that description of FSK activation smart object is correct")
                .perform();
        driver.verifyThat().element(FSK_Activate_SO_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation SO is exist")
                .perform();

        driver.verifyThat().element(FSK_ActiveAcc_Title).textTrimmed()
                .isEqualTo(FSKPinActivation.FSK_ActiveAcc_Title_CL)
                .withCustomReportMessage("Check that Title of FSK activation Accordion is correct")
                .perform();

        driver.verifyThat().element(FSK_ActiveAcc_Desc).textTrimmed()
                .isEqualTo(FSK_ActiveAcc_Desc_CL)
                .withCustomReportMessage("Check that description of FSK activation accordion is correct")
                .perform();

        driver.verifyThat().element(FSK_ActiveAcc_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 activation accordion is exist")
                .perform();
        return this;
    }

    public FSKPinActivation ValidateNoFSKMessage ()
    {
        driver.verifyThat()
                .element(FSK_NotBooked_MSGTitle).textTrimmed()
                .isEqualTo(FSK_NotBooked_MSGTitle_CL)
                .withCustomReportMessage("Check that Title of FSK activation not booked message is correct")
                .perform();
        driver.verifyThat()
                .element(FSK_NotBooked_MSGBody).textTrimmed().isEqualTo(FSK_NotBooked_MSGBody_CL)
                .withCustomReportMessage("Check that Body of FSK activation not booked message is correct")
                .perform();
        driver.verifyThat().element(FSK_NotBooked_Icon).exists()
                .withCustomReportMessage("Check that Icon of FSK 18 not booked message is exist")
                .perform();
        return this;
    }

}
