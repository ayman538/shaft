package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class ConnectionDataSection {
    //variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    public static String pageTitleCL   = "Datenschutz-Einstellungen";
    public static String sectionTitleCL   = "Verbindungsdaten";
    public static String Permission1CL   = "Verkehrsdaten";
    public static String persmissionDescription1CL1 = "Vodafone darf Deine Verkehrsdaten zur Optimierung seines Netzes und seiner Produkte und Services nutzen sowie für gezielte Angebote und Beratung.";
    public static String persmissionDescription1CL2 = "Die Verkehrsdaten sind z.B. die Art des genutzten Telekommunikationsdienstes, Anfang, Ende und Dauer der Verbindungen, das genutzte Datenvolumen, an der Kommunikation beteiligte Personen, Geräte oder Anschlüsse sowie weitere Verkehrsdaten, die erhoben werden, auch wenn Dein Gerät inaktiv ist.";
    public static String persmissionDescription1CL3 = "Auf Basis der Verkehrsdaten können wir die Leistung unseres Netzes verbessern, Deine Services verbessern und Dir Angebote und Empfehlungen schicken, von denen Du mehr hast.";
    public static String Permission2CL   = "Standortdaten (zellbasiert)";
    public static String persmissionDescription2CL1 = "Vodafone darf Deine zellbasierten Standortdaten zur Optimierung seines Netzes und seiner Produkte und Services nutzen sowie für gezielte Angebote und Beratung.";
    public static String persmissionDescription2CL2   = "Über die Mobilfunk-Zelle, die Du nutzt, können wir ungefähr Deinen Standort bestimmen.";
    public static String persmissionDescription2CL3   = "So können wir Dir Angebote und Services empfehlen, die an Deinem Standort vielleicht interessant für Dich sind.";
    public static String lastChangeLabelCL   = "Letzte Änderung:";
    public static String notificationTitleCL   = "Achtung!";
    public static String notificationDescriptionCL1 = "Wenn Du diese Einstellung ausschaltest, verzichtest Du auf Vorteile.";
    public static String notificationDescriptionCL2 = "Du bekommst dann z.B. keine persönlich zugeschnittenen Angebote mehr.";
    public static String notificationContinueBtnCL   = "Fortfahren";
    public static String notificationUndoneBtnCL   = "Rückgängig";
    public static String saveChangesDescriptionCL1   = "Du hast Deine Datenschutz- & Werbeeinstellungen geändert.";
    public static String saveChangesDescriptionCL2   = "Änderungen speichern?";
    public static String notificationSaveChangesBtnCL   = "Ja, Änderungen speichern";
    public static String notificationDontSaveChangesBtnCL   = "Nein, Änderungen nicht speichern";
    public static String successMsgCL   = "Deine Änderungen wurden gespeichert.";


    //Locators
    public static By pageTitle = By.xpath("//*[@automation-id='pageHeader_tv']");
    public static By sectionTitle = By.xpath("//*[@automation-id='cpm_permissions_acc']/div/div/div/span[2]/strong");
    public static By Permission1 = By.xpath("(//*[@class='displayinlineblock vertical-align-middle']/h3)[1]");
    public static By lastChangeLabel1 = By.xpath("(//*[@class='fl noBold'])[1]");
    public static By lastChangeDate1 = By.xpath("(//*[@class='fr w-18 width-23'])[1]");
    public static By persmission1Description = By.xpath("(//*[@class='clear']/p)[2]");
    public static By toggleBtn1On = By.xpath("(//*[@class='on-text'])[1]");
    public static By toggleBtn1Off = By.xpath("(//*[@class='off-text'])[1]");
    public static By Permission2 = By.xpath("(//*[@class='displayinlineblock vertical-align-middle']/h3)[2]");
    public static By lastChangeLabel2 = By.xpath("(//*[@class='fl noBold'])[2]");
    public static By lastChangeDate2 = By.xpath("(//*[@class='fr w-18 width-23'])[2]");
    public static By persmission2Description = By.xpath("(//*[@class='clear']/p)[4]");
    public static By toggleBtn2On = By.xpath("(//*[@class='on-text'])[2]");
    public static By toggleBtn2Off = By.xpath("(//*[@class='off-text'])[2]");
    public static By confirmBtn = By.xpath("//*[@automation-id='edit_permissions_btn']");
    public static By notificationIcon = By.xpath("(//*[@class='i-sml i-orange'])");
    public static By notificationTitle = By.xpath("(//*[@class='flexDiv'])");
    public static By notificationDescription = By.xpath("(//*[@class='notification-text mb-10 mt-10'])");
    public static By notificationContinueBtn = By.xpath("(//*[@class='notification-body notification-body-margin']//button)[1]");
    public static By notificationUndoneBtn = By.xpath("(//*[@class='notification-body notification-body-margin']//button)[2]");
    public static By notificationSaveChangesBtn = By.xpath("(//*[@automation-id='final_confirmation_notification_btn'])[1]");
    public static By notificationDontSaveChangesBtn = By.xpath("(//*[@automation-id='final_confirmation_notification_btn'])[2]");
    public static By saveChangesDescription1 = By.xpath("(//*[@class='notification-text mb-10 mt-10']/p)[1]");
    public static By saveChangesDescription2 = By.xpath("(//*[@class='notification-text mb-10 mt-10']/p)[2]");
    public static By successMsg = By.xpath("(//*[@automation-id='success_notification_nt'])/div/div[2]/div[1]/div[2]/h4");


    //Constructor
    public ConnectionDataSection(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Methods
    public ConnectionDataSection changeToggleBtn1()
    {
        if (driver.element().isElementDisplayed(toggleBtn1On))
        {
                    driver.element().click(toggleBtn1On); }
        else
        {
            driver.element().click(toggleBtn1Off);
        }
        return this;
    }

    public ConnectionDataSection saveToggleChanges()
    {
        driver.element().click(notificationContinueBtn);
        return this;
    }

    public ConnectionDataSection clickUndoneBtn(){
        driver.element().click(notificationUndoneBtn);
        return this;
    }

    public ConnectionDataSection clickConfrimBtn(){
        driver.element().click(confirmBtn);
        return this;
    }

    public ConnectionDataSection clickSaveChangesBtn(){
        driver.element().click(notificationSaveChangesBtn);
        return this;
    }
    public ConnectionDataSection validateWarningMsgAfterChangingToggle() {
        driver.verifyThat().element(notificationTitle)
                .textTrimmed().isEqualTo(notificationTitleCL)
                .withCustomReportMessage("Verify Continue button")
                .perform();

        driver.verifyThat().element(notificationDescription)
                .textTrimmed().contains(notificationDescriptionCL1)
                .withCustomReportMessage("Verify Continue button")
                .perform();
        driver.verifyThat().element(notificationDescription)
                .textTrimmed().contains(notificationDescriptionCL2)
                .withCustomReportMessage("Verify Continue button")
                .perform();

        driver.verifyThat().element(notificationContinueBtn)
                .textTrimmed().isEqualTo(notificationContinueBtnCL)
                .withCustomReportMessage("Verify Continue button")
                .perform();
        driver.verifyThat().element(notificationUndoneBtn)
                .textTrimmed().isEqualTo(notificationUndoneBtnCL)
                .withCustomReportMessage("Verify Undone button")
                .perform();
        return this;
    }

    public ConnectionDataSection verifyConnectionDataPermissions(){
        driver.verifyThat().element(sectionTitle)
                .textTrimmed().isEqualTo(sectionTitleCL)
                .withCustomReportMessage("Verify section title")
                .perform();

        //Verify Verkehrsdaten section
        driver.verifyThat().element(Permission1)
                .textTrimmed().isEqualTo(Permission1CL)
                .withCustomReportMessage("Verify Verkehrsdaten permission CL")
                .perform();
        driver.verifyThat().element(lastChangeLabel1)
                .textTrimmed().isEqualTo(lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(lastChangeDate1).exists().perform();

        driver.verifyThat().element(persmission1Description)
                .textTrimmed().contains(persmissionDescription1CL1)
                .withCustomReportMessage("Verify permission description")
                .perform();
        driver.verifyThat().element(persmission1Description)
                .textTrimmed().contains(persmissionDescription1CL2)
                .withCustomReportMessage("Verify permission description")
                .perform();
        driver.verifyThat().element(persmission1Description)
                .textTrimmed().contains(persmissionDescription1CL3)
                .withCustomReportMessage("Verify permission description")
                .perform();

        //Verify Standortdaten (zellbasiert) section
        driver.verifyThat().element(Permission2)
                .textTrimmed().isEqualTo(Permission2CL)
                .withCustomReportMessage("Verify Standortdaten (zellbasiert) permission CL")
                .perform();
        driver.verifyThat().element(lastChangeLabel2)
                .textTrimmed().isEqualTo(lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(lastChangeDate2).exists().perform();

        driver.verifyThat().element(persmission2Description)
                .textTrimmed().contains(persmissionDescription2CL1)
                .withCustomReportMessage("Verify permission description")
                .perform();
        driver.verifyThat().element(persmission2Description)
                .textTrimmed().contains(persmissionDescription2CL2)
                .withCustomReportMessage("Verify permission description")
                .perform();
        driver.verifyThat().element(persmission2Description)
                .textTrimmed().contains(persmissionDescription2CL3)
                .withCustomReportMessage("Verify permission description")
                .perform();
        return this;
    }

    public ConnectionDataSection validateSaveChangesMSG()
     {
         driver.verifyThat().element(notificationIcon)
              .exists().perform();
        driver.verifyThat().element(notificationTitle)
                .textTrimmed().isEqualTo(notificationTitleCL)
                .withCustomReportMessage("Verify notification title")
                .perform();
        driver.element().isElementDisplayed(saveChangesDescription1);
        driver.verifyThat().element(saveChangesDescription1)
                .textTrimmed().isEqualTo(saveChangesDescriptionCL1)
                .withCustomReportMessage("Verify notification description")
                .perform();
        driver.verifyThat().element(saveChangesDescription2)
                .textTrimmed().isEqualTo(saveChangesDescriptionCL2)
                .withCustomReportMessage("Verify notification description")
                .perform();
        driver.verifyThat().element(notificationSaveChangesBtn)
                .textTrimmed().isEqualTo(notificationSaveChangesBtnCL)
                .withCustomReportMessage("Verify Save changes button")
                .perform();
        driver.verifyThat().element(notificationDontSaveChangesBtn)
                .textTrimmed().isEqualTo(notificationDontSaveChangesBtnCL)
                .withCustomReportMessage("Verify Don't save changes button")
                .perform();
         return this;
    }

    public ConnectionDataSection validateSuccessMSG() {
        driver.verifyThat().element(successMsg)
                .textTrimmed().isEqualTo(successMsgCL)
                .withCustomReportMessage("Verify Success Message")
                .perform();
        return this;
    }

    public ConnectionDataSection changeConnectionDataPermissions(){
        changeToggleBtn1();
        if ( driver.element().isElementDisplayed(toggleBtn1Off))
        {
            validateWarningMsgAfterChangingToggle();
            saveToggleChanges();
        }
        return this;
    }

}
