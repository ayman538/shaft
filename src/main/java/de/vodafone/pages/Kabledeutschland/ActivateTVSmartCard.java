package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ActivateTVSmartCard {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By SmartCard_ActiveAcc_Title = By.xpath("//*[@automation-id=\"smartcard_acc\"]/a/h4");
    public static final By SmartCard_ActiveAcc_Desc = By.xpath("//*[@automation-id=\"smartcard_acc\"]/a/h5");

    public static final By SmartCard_Default_MSGTitle = By.xpath("//*[@automation-id=\"activateSMCardHeader_tv\"]");
    public static final By SmartCard_Default_MSGBody = By.xpath("//*[@automation-id=\"activateSMCardbody_tv\"]");
    public static final By SmartCard_Default_MSGButton = By.xpath("//button[@automation-id='activateSMCardTrans_btn']");
    public static final By smartCardActivationButton = By.xpath("//button[@class='btn btn-sml disable-opacity']");
    public static final By ActivationFlow_Page_Title = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1");
    public static final By ActivationFlow_container_Title = By.xpath("//*[@automation-id=\"oneStepStepperHeader_tv\"]");
    public static final By ActivationFlow_container_Icon = By.xpath("//*[@class=\"icon-pin-sim-i-xsml i-xsml ac-icon\"]");
    public static final By ActivationFlow_InfoMSG_Title = By.xpath("//*[@automation-id=\"instructionHeader_tv\"]");
    public static final By ActivationFlow_InfoMSG_Body = By.xpath("//*[@class=\"mb-20\"]/span");
    public static final By ActivationFlow_Instructions_Title = By.xpath("//*[@automation-id=\"instructionbody_tv\"]");
    public static final By ActivationFlow_Instructions_Body = By.xpath("//*[@id='smart-card']//div[2]//div");
    public static final By ActivationFlow_Confirm_Button = By.xpath("//*[@class=\"btn btn-sml disable-opacity\"]");

    public static final By ActivationResult_SuccessMSG_Title = By.xpath("//*[@automation-id=\"successful_nt\"]/div/div/div/div/h4");
    public static final By ActivationResult_SuccessMSG_Body = By.xpath("//*[@automation-id=\"successful_nt\"]/div/div/p");

    public static final By ActivationResult_FailMSG_Title = By.xpath("//*[@class=\"alert-content\"]/div/div/h4");
    public static final By ActivationResult_FailMSG_Body = By.xpath("(//*[@class=\"alert-content\"]/p)[1]");
    public static final By ActivationResult_FailMSG_Button = By.xpath("//button[@automation-id='succFailed_btn']");

    public static final By ActivationResult_PartFailMSG_Title = By.xpath("//*[@class=\"alert-content\"]/div/div/h4");
    public static final By ActivationResult_PartFailMSG_Body = By.xpath("(//*[@class=\"alert-content\"]/p)[1]");
    public static final By ActivationResult_PartFailMSG_Button = By.xpath("//*[@automation-id=\"succFailed_btn\"]");

    public static final By ActivationInProgressMSG_Title = By.xpath("//*[@class=\"alert-content\"]/div/div/h4");
    public static final By ActivationInProgressMSG_Body = By.xpath("(//*[@class=\"alert-content\"]/p)[1]");
    public static final By ActivationInProgressMSG_Icon = By.xpath(" //div[@automation-id='successMsg_tv']/div/div[1]");
    public static final By BackToDashboard_Button = By.xpath("//*[@automation-id=\"back_Link\"]");

    //CLs
    public static String SmartCard_ActiveAcc_Title_CL = "Smartcard aktivieren";
    public static String SmartCard_ActiveAcc_Desc_CL = "Wie Du Deine Smartcard selbst freischaltest";
    public static String SmartCard_Default_MSGTitle_CL = "Smartcard(s) ganz einfach selbst freischalten";
    public static String SmartCard_Default_MSGBody_CL = "Du erhältst auf von Dir abonnierten Sendern einen Hinweis mit der Nummer 9, 10 oder 310? Die Freischaltung dieser Sender kannst Du ganz einfach selbst vornehmen!";
    public static String SmartCard_Default_MSGButton_CL = "Zur Aktivierung";
    //    public static String SmartCard_ISActive_MSGTitle_CL = "";
//    public static String SmartCard_ISActive_MSGBody_CL = "";
//    public static String SmartCard_ISActive_MSGButton_CL = "";
//    public static String SmartCard_ISNotActive_MSGTitle_CL = "";
//    public static String SmartCard_ISNotActive_MSGBody_CL = "";
//    public static String SmartCard_ISNotActive_MSGButton_CL = "";
    public static String ActivationFlow_Page_Title_CL = "Smartcard aktivieren";
    public static String ActivationFlow_InfoMSG_Title_CL = "Smartcard(s) ganz einfach selbst freischalten";
    public static String ActivationFlow_InfoMSG_Body_CL = "Du erhältst auf von Dir abonnierten Sendern einen Hinweis mit der Nummer 9, 10 oder 310? Die Freischaltung dieser Sender kannst Du ganz einfach selbst vornehmen!";
    public static String ActivationFlow_Instructions_Title_CL = "Anleitung:";
    public static String ActivationFlow_Instructions_Body_CL1 = "1. Schalt Deinen Digital-Receiver an.";
    public static String ActivationFlow_Instructions_Body_CL2 = "2. Wähl ein von Dir abonniertes Programm aus.";
    public static String ActivationFlow_Instructions_Body_CL3 = "3. Die Hinweismeldung wird angezeigt. Klick auf";
    public static String ActivationFlow_Confirm_Button_CL = "Smartcard aktivieren";
    public static String ActivationResult_SuccessMSG_Title_CL = "Deine Smartcard(s) wurde erfolgreich aktiviert!";
    public static String ActivationResult_SuccessMSG_Body_CL1 = "Die Freischaltung sollte innerhalb einer Stunde erfolgen.";
    public static String ActivationResult_SuccessMSG_Body_CL2 = "Bitte Stell in dieser Zeit sicher, dass die Smartcard korrekt im Kartenschiltz deines Digital Receivers steckt, dieser eingeschaltet ist und eines der Programme deines digitalen Kabelanschluss oder zusätzlich gebuchten Programmpakets ausgewählt is.";
    public static String ActivationResult_SuccessMSG_Body_CL3 = "Viel Spaß mit Deinen neuen Programmen";
    public static String ActivationResult_FailMSG_Title_CL = "Fehler bei der Aktivierung Deiner Smartcard(s)";
    public static String ActivationResult_FailMSG_Body_CL1 = "Die Aktivierung Deiner Smartcard war leider nicht erfolgreich.";
    public static String ActivationResult_FailMSG_Body_CL2 = "Mögliche Gründe können sein:";
    public static String ActivationResult_FailMSG_Body_CL3 = "1. Deine Smartcard ist nicht erreichbar.";
    public static String ActivationResult_FailMSG_Body_CL4 = "2. Fehler bei der Übertragung.";
    public static String ActivationResult_FailMSG_Body_CL5 = "Bitte stell sicher, dass Du alle Schritte der Anleitung eingehalten hast und versuche es nochmal. Wenn Du unsicher bist, wähl den Schnupperkanal aus. Nach maximal einer Stunde sollte der Sender sichtbar werden.";
    public static String ActivationResult_FailMSG_Body_CL6 = "Deine SmartCard ist dann aktiviert. Sollte der Fehler weiterhin bestehen, Kontaktiere unseren Kundenservice.";
    public static String ActivationResult_FailMSG_Button_CL = "Erneut versuchen";
    public static String ActivationResult_PartFailMSG_Title_CL = "Es konnten nicht alle Deine SmartCards aktiviert werden";
    public static String ActivationResult_PartFailMSG_Body_CL1 = "Nicht alle deine Smartcards konnten erfolgreich aktiviert werden.";
    public static String ActivationResult_PartFailMSG_Body_CL2 = "Mögliche Gründe können sein:";
    public static String ActivationResult_PartFailMSG_Body_CL3 = "1. Deine Smartcard ist nicht erreichbar.";
    public static String ActivationResult_PartFailMSG_Body_CL4 = "2. Fehler bei der Übertragung.";
    public static String ActivationResult_PartFailMSG_Body_CL5 = "Bitte stell sicher, dass Du alle Schritte der Anleitung eingehalten hast und versuche es nochmal.";
    public static String ActivationResult_PartFailMSG_Body_CL6 = "Wenn Du unsicher bist, wähl den Schnupperkanal aus. Nach maximal einer Stunde sollte der Sender sichtbar werden";
    public static String ActivationResult_PartFailMSG_Body_CL7 = "Deine SmartCard ist dann aktiviert. Sollte der Fehler weiterhin bestehen, Kontaktiere unseren Kundenservice.";
    public static String ActivationResult_PartFailMSG_Button_CL = "Erneut versuchen";
    public static String ActivationInProgressMSG_Title_CL = "Aktivierung läuft …";
    public static String ActivationInProgressMSG_Body_CL = "Wir aktivieren gerade Deine Smartcard. In spätestens einer Stunde sind Deine Sender freigeschaltet.";

    public ActivateTVSmartCard (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public ActivateTVSmartCard VerifyActivationAccordion() {
        driver.verifyThat().element(SmartCard_ActiveAcc_Title)
                .textTrimmed().isEqualTo(SmartCard_ActiveAcc_Title_CL)
                .perform();
        driver.verifyThat().element(SmartCard_ActiveAcc_Desc)
                .textTrimmed().isEqualTo(SmartCard_ActiveAcc_Desc_CL)
                .perform();
        return this;
    }

    public ActivateTVSmartCard VerifySuccessActivationFlow() {
        //Verify Step "1"
        driver.verifyThat().element(SmartCard_Default_MSGTitle)
                .textTrimmed().isEqualTo(SmartCard_Default_MSGTitle_CL)
                .perform();
        driver.verifyThat().element(SmartCard_Default_MSGBody)
                .textTrimmed().isEqualTo(SmartCard_Default_MSGBody_CL)
                .perform();
        driver.verifyThat().element(SmartCard_Default_MSGButton)
                .textTrimmed().isEqualTo(SmartCard_Default_MSGButton_CL)
                .perform();
        driver.verifyThat().element(SmartCard_Default_MSGButton).isEnabled().perform();
        driver.element().click(SmartCard_Default_MSGButton);

        //Verify Step "2"
        driver.verifyThat().element(ActivationFlow_InfoMSG_Title)
                .textTrimmed().isEqualTo(ActivationFlow_InfoMSG_Title_CL)
                .perform();
         driver.verifyThat().element(ActivationFlow_InfoMSG_Body)
                .textTrimmed().isEqualTo(ActivationFlow_InfoMSG_Body_CL)
                .perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Title)
                .textTrimmed().isEqualTo(ActivationFlow_Instructions_Title_CL)
                .perform();

        driver.verifyThat().element(ActivationFlow_Instructions_Body)
                .textTrimmed().contains(ActivationFlow_Instructions_Body_CL1)
                .perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Body)
                .textTrimmed().contains(ActivationFlow_Instructions_Body_CL2)
                .perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Body)
                .textTrimmed().contains(ActivationFlow_Instructions_Body_CL3)
                .perform();

        driver.verifyThat().element(ActivationFlow_Confirm_Button)
                .textTrimmed().isEqualTo(ActivationFlow_Confirm_Button_CL)
                .perform();
        driver.verifyThat().element(smartCardActivationButton).isEnabled().perform();
        driver.element().click(smartCardActivationButton);
        //Verify Step "3"
        driver.verifyThat().element(ActivationResult_SuccessMSG_Title)
                .textTrimmed().isEqualTo(ActivationResult_SuccessMSG_Title_CL)
                .perform();

        driver.verifyThat().element(ActivationResult_SuccessMSG_Body)
                .textTrimmed().contains(ActivationResult_SuccessMSG_Body_CL1)
                .perform();
        driver.verifyThat().element(ActivationResult_SuccessMSG_Body)
                .textTrimmed().contains(ActivationResult_SuccessMSG_Body_CL2)
                .perform();
        driver.verifyThat().element(ActivationResult_SuccessMSG_Body)
                .textTrimmed().contains(ActivationResult_SuccessMSG_Body_CL3)
                .perform();
        return this;
    }

    public ActivateTVSmartCard VerifyFailureActivationFlow() {
        driver.verifyThat().element(SmartCard_Default_MSGButton).isEnabled().perform();
        driver.element().click(SmartCard_Default_MSGButton);
        driver.verifyThat().element(ActivationFlow_InfoMSG_Title).exists().perform();
        driver.verifyThat().element(ActivationFlow_InfoMSG_Body).exists().perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Title).exists().perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Body).exists().perform();
        driver.verifyThat().element(ActivationFlow_Confirm_Button).exists().perform();
        driver.verifyThat().element(smartCardActivationButton).isEnabled().perform();
        driver.element().click(smartCardActivationButton);

        //Verify Step "3"
        driver.verifyThat().element(ActivationResult_FailMSG_Title).exists().perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Body).exists().perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Button).exists().perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Title)
                .textTrimmed().isEqualTo(ActivationResult_FailMSG_Title_CL)
                .perform();

        driver.verifyThat().element(ActivationResult_FailMSG_Body)
                .textTrimmed().contains(ActivationResult_FailMSG_Body_CL1)
                .perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Body)
                .textTrimmed().contains(ActivationResult_FailMSG_Body_CL2)
                .perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Body)
                .textTrimmed().contains(ActivationResult_FailMSG_Body_CL3)
                .perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Body)
                .textTrimmed().contains(ActivationResult_FailMSG_Body_CL4)
                .perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Body)
                .textTrimmed().contains(ActivationResult_FailMSG_Body_CL5)
                .perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Body)
                .textTrimmed().contains(ActivationResult_FailMSG_Body_CL6)
                .perform();

        driver.verifyThat().element(ActivationResult_FailMSG_Button)
                .textTrimmed().isEqualTo(ActivationResult_FailMSG_Button_CL)
                .perform();
        driver.verifyThat().element(ActivationResult_FailMSG_Button).isEnabled().perform();
        driver.element().click(ActivationResult_FailMSG_Button);
        driver.verifyThat().element(ActivationFlow_Confirm_Button).exists().perform();
        return this;
    }

    public ActivateTVSmartCard VerifyPartiallyFailureActivationFlow() {
        driver.verifyThat().element(SmartCard_Default_MSGTitle).exists().perform();
        driver.verifyThat().element(SmartCard_Default_MSGBody).exists().perform();
        driver.verifyThat().element(SmartCard_Default_MSGButton).exists().perform();

        driver.verifyThat().element(SmartCard_Default_MSGButton).isEnabled().perform();
        driver.element().click(SmartCard_Default_MSGButton);

        driver.verifyThat().element(ActivationFlow_InfoMSG_Title).exists().perform();
        driver.verifyThat().element(ActivationFlow_InfoMSG_Body).exists().perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Title).exists().perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Body).exists().perform();
        driver.verifyThat().element(ActivationFlow_Confirm_Button).exists().perform();

        driver.verifyThat().element(smartCardActivationButton).isEnabled().perform();
        driver.element().click(smartCardActivationButton);

        //Verify Step "3"
        driver.verifyThat().element(ActivationResult_PartFailMSG_Title).exists().perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Body).exists().perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Button).exists().perform();

        driver.verifyThat().element(ActivationResult_PartFailMSG_Title)
                .textTrimmed().isEqualTo(ActivationResult_PartFailMSG_Title_CL)
                .perform();

        driver.verifyThat().element(ActivationResult_PartFailMSG_Body)
                .textTrimmed().contains(ActivationResult_PartFailMSG_Body_CL1)
                .perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Body)
                .textTrimmed().contains(ActivationResult_PartFailMSG_Body_CL2)
                .perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Body)
                .textTrimmed().contains(ActivationResult_PartFailMSG_Body_CL3)
                .perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Body)
                .textTrimmed().contains(ActivationResult_PartFailMSG_Body_CL4)
                .perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Body)
                .textTrimmed().contains(ActivationResult_PartFailMSG_Body_CL5)
                .perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Body)
                .textTrimmed().contains(ActivationResult_PartFailMSG_Body_CL6)
                .perform();
        driver.verifyThat().element(ActivationResult_PartFailMSG_Body)
                .textTrimmed().contains(ActivationResult_PartFailMSG_Body_CL7)
                .perform();

        driver.verifyThat().element(ActivationResult_PartFailMSG_Button)
                .textTrimmed().isEqualTo(ActivationResult_PartFailMSG_Button_CL)
                .perform();

        driver.verifyThat().element(ActivationResult_PartFailMSG_Button).isEnabled().perform();
        driver.element().click(ActivationResult_PartFailMSG_Button);
        driver.verifyThat().element(ActivationFlow_Confirm_Button).exists().perform();
        return this;
    }

    public ActivateTVSmartCard VerifyInProgressActivationFlow() {

        driver.verifyThat().element(SmartCard_Default_MSGTitle).exists().perform();
        driver.verifyThat().element(SmartCard_Default_MSGBody).exists().perform();
        driver.verifyThat().element(SmartCard_Default_MSGButton).exists().perform();

        driver.verifyThat().element(SmartCard_Default_MSGButton).isEnabled().perform();
        driver.element().click(SmartCard_Default_MSGButton);

        driver.verifyThat().element(ActivationFlow_InfoMSG_Title).exists().perform();
        driver.verifyThat().element(ActivationFlow_InfoMSG_Body).exists().perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Title).exists().perform();
        driver.verifyThat().element(ActivationFlow_Instructions_Body).exists().perform();
        driver.verifyThat().element(ActivationFlow_Confirm_Button).exists().perform();

        driver.verifyThat().element(smartCardActivationButton).isEnabled().perform();

        driver.element().click(smartCardActivationButton);

        driver.verifyThat().element(ActivationResult_SuccessMSG_Title).exists().perform();
        driver.verifyThat().element(ActivationResult_SuccessMSG_Body).exists().perform();

        driver.element().click(BackToDashboard_Button);

        driver.verifyThat().element(SmartCard_ActiveAcc_Title).exists().perform();
        driver.element().click(SmartCard_Default_MSGButton);

        driver.verifyThat().element(ActivationFlow_Page_Title).exists().perform();
        driver.verifyThat().element(ActivationInProgressMSG_Title).exists().perform();
        driver.verifyThat().element(ActivationInProgressMSG_Body).exists().perform();
        driver.verifyThat().element(ActivationInProgressMSG_Icon).exists().perform();

        driver.verifyThat().element(ActivationInProgressMSG_Body)
                .textTrimmed().isEqualTo(ActivationInProgressMSG_Body_CL)
                .perform();
        return this;
    }
}