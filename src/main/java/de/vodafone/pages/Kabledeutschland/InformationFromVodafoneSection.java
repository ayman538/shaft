package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class InformationFromVodafoneSection {
    //variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    public static String pageTitleCL   = "Datenschutz-Einstellungen";
    public static String sectionTitleCL   = "Informationen von Vodafone";
    public static String emailPermissionCL   = "E-Mail";
    public static String persmissionDescription1CL   = "Vodafone darf Dich per E-Mail kontaktieren, um Dich über Produkte und Services zu informieren und Dir aktuelle Angebote und Empfehlungen zu geben, die auf Deine Bedürfnisse zugeschnitten sind.";
    public static String sMSmMsPermissionCL   = "SMS/MMS";
    public static String persmissionDescription2CL   = "Vodafone darf Dich per SMS/MMS kontaktieren, um Dich über Produkte und Services zu informieren und Dir aktuelle Angebote und Empfehlungen zu geben, die auf Deine Bedürfnisse zugeschnitten sind.";
    public static String postPermissionCL   = "Post";
    public static String persmissionDescription3CL   = "Vodafone darf Dich per Brief kontaktieren, um Dich über Produkte und Services zu informieren und Dir aktuelle Angebote und Empfehlungen zu geben, die auf Deine Bedürfnisse zugeschnitten sind.";
    public static String anrufPermissionCL   = "Anruf";
    public static String persmissionDescription4CL   = "Vodafone darf Dich anrufen, um Dich über Produkte und Services zu informieren und Dir aktuelle Angebote und Empfehlungen zu geben, die auf Deine Bedürfnisse zugeschnitten sind.";
    public static String lastChangeLabelCL   = "Letzte Änderung:";
    public static String notificationTitleCL   = "Achtung!";
    public static String notificationDescriptionCL   = "Wenn Du diese Einstellung ausschaltest, verzichtest Du auf Vorteile. Du bekommst dann z.B. keine persönlich zugeschnittenen Angebote mehr.";
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
    public static By emailPermission = By.xpath("(//*[@class='displayinlineblock vertical-align-middle']/h3)[1]");
    public static By lastChangeLabel1 = By.xpath("(//*[@class='fl noBold'])[1]");
    public static By lastChangeDate1 = By.xpath("(//*[@class='fr w-18 width-23'])[1]");
    public static By persmissionDescription1 = By.xpath("(//*[@class='clear']/p)[2]");
    public static By toggleBtn1On = By.xpath("(//*[@class='on-text'])[1]");
    public static By toggleBtn1Off = By.xpath("(//*[@class='off-text'])[1]");
    public static By sMSmMsPermission = By.xpath("(//*[@class='displayinlineblock vertical-align-middle']/h3)[2]");
    public static By lastChangeLabel2 = By.xpath("(//*[@class='fl noBold'])[2]");
    public static By lastChangeDate2 = By.xpath("(//*[@class='fr w-18 width-23'])[2]");
    public static By persmissionDescription2 = By.xpath("(//*[@class='clear']/p)[4]");
    public static By toggleBtn2On = By.xpath("(//*[@class='on-text'])[2]");
    public static By toggleBtn2Off = By.xpath("(//*[@class='off-text'])[2]");
    public static By postPermission = By.xpath("(//*[@class='displayinlineblock vertical-align-middle']/h3)[3]");
    public static By lastChangeLabel3 = By.xpath("(//*[@class='fl noBold'])[3]");
    public static By lastChangeDate3 = By.xpath("(//*[@class='fr w-18 width-23'])[3]");
    public static By persmissionDescription3 = By.xpath("(//*[@class='clear']/p)[6]");
    public static By toggleBtn3On = By.xpath("(//*[@class='on-text'])[3]");
    public static By toggleBtn3Off = By.xpath("(//*[@class='off-text'])[3]");
    public static By anrufPermission = By.xpath("(//*[@class='displayinlineblock vertical-align-middle']/h3)[4]");
    public static By lastChangeLabel4 = By.xpath("(//*[@class='fl noBold'])[4]");
    public static By lastChangeDate4 = By.xpath("(//*[@class='fr w-18 width-23'])[4]");
    public static By persmissionDescription4 = By.xpath("(//*[@class='clear']/p)[8]");
    public static By toggleBtn4On = By.xpath("(//*[@class='on-text'])[4]");
    public static By toggleBtn4Off = By.xpath("(//*[@class='off-text'])[4]");
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
    public InformationFromVodafoneSection(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Methods
    public InformationFromVodafoneSection changeEmailToggleBtn()
    {
        if ( driver.element().isElementDisplayed(toggleBtn1On))
        {
            driver.element().click(toggleBtn1On);
        }
        else
        {
            driver.element().click(toggleBtn1Off);
        }
        return this;
    }

    public InformationFromVodafoneSection changeSmsMmsToggleBtn()
    {
        if ( driver.element().isElementDisplayed(toggleBtn2On))

        {
            driver.element().click(toggleBtn2On);
        }
        else
        {  driver.element().click(toggleBtn2Off);
        }
        return this;
    }

    public InformationFromVodafoneSection changePostToggleBtn()
    {
        if ( driver.element().isElementDisplayed(toggleBtn3On))
        {
            driver.element().click(toggleBtn3On);
        }
        else
        {
            driver.element().click(toggleBtn3Off);
        }
        return this;
    }

    public InformationFromVodafoneSection changeAnrufToggleBtn()
    {
        if ( driver.element().isElementDisplayed(toggleBtn4On))
        {
                   driver.element().click(toggleBtn4On);
        }
        else
        {
            driver.element().click(toggleBtn4Off);
        }
        return this;
    }

    public InformationFromVodafoneSection clickUndoneBtn(){
        driver.element().click(notificationUndoneBtn);
        return this;
    }
    public InformationFromVodafoneSection changeInformationFromvodafoneToggels(){
        changeEmailToggleBtn();
        if (driver.element().isElementDisplayed(toggleBtn1Off))
        {
            new ConnectionDataSection(driver).validateWarningMsgAfterChangingToggle();
            clickContinueBtn();
        }
        changeSmsMmsToggleBtn();
        if (driver.element().isElementDisplayed(toggleBtn2Off))
        {
            new ConnectionDataSection(driver).validateWarningMsgAfterChangingToggle();
            clickContinueBtn();
        }
        changePostToggleBtn();
        if (driver.element().isElementDisplayed(toggleBtn3Off)){
            new ConnectionDataSection(driver).validateWarningMsgAfterChangingToggle();
            clickUndoneBtn();
        }
        changeAnrufToggleBtn();
        if (driver.element().isElementDisplayed(toggleBtn4Off)){
            new ConnectionDataSection(driver).validateWarningMsgAfterChangingToggle();
            clickUndoneBtn();
        }
        return this;
    }
    public InformationFromVodafoneSection clickContinueBtn(){
        driver.element().click(notificationContinueBtn);
        return this;
    }
    public InformationFromVodafoneSection clickConfirmBtn(){
        driver.element().click(confirmBtn);
        return this;
    }
    public InformationFromVodafoneSection clickSaveChangesBtn(){
        driver.element().click(notificationSaveChangesBtn);
        return this;
    }

    public InformationFromVodafoneSection validateInformationFromVodafonePermissions(){
        driver.verifyThat().element(sectionTitle)
                .textTrimmed().isEqualTo(sectionTitleCL)
                .withCustomReportMessage("Verify section title")
                .perform();
        //Verify Email section
        driver.verifyThat().element(emailPermission)
                .textTrimmed().isEqualTo(emailPermissionCL)
                .withCustomReportMessage("Verify email permission")
                .perform();
        driver.verifyThat().element(lastChangeLabel1)
                .textTrimmed().isEqualTo(lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(lastChangeDate1).exists().perform();
        driver.verifyThat().element(persmissionDescription1)
                .textTrimmed().isEqualTo(persmissionDescription1CL)
                .withCustomReportMessage("Verify permission description")
                .perform();
        //Verify SMS/MMS section
        driver.verifyThat().element(sMSmMsPermission)
                .textTrimmed().isEqualTo(sMSmMsPermissionCL)
                .withCustomReportMessage("Verify sms/mms permission")
                .perform();
        driver.verifyThat().element(lastChangeLabel2)
                .textTrimmed().isEqualTo(lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(lastChangeDate2).exists().perform();
        driver.verifyThat().element(persmissionDescription2)
                .textTrimmed().isEqualTo(persmissionDescription2CL)
                .withCustomReportMessage("Verify permission description")
                .perform();
        //verify post permmision
        driver.verifyThat().element(postPermission)
                .textTrimmed().isEqualTo(postPermissionCL)
                .withCustomReportMessage("Verify post permission")
                .perform();
        driver.verifyThat().element(lastChangeLabel3)
                .textTrimmed().isEqualTo(lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(lastChangeDate3).exists().perform();
        driver.verifyThat().element(persmissionDescription3)
                .textTrimmed().isEqualTo(persmissionDescription3CL)
                .withCustomReportMessage("Verify permission description")
                .perform();
        //verify Anruf permission
        driver.verifyThat().element(anrufPermission)
                .textTrimmed().isEqualTo(anrufPermissionCL)
                .withCustomReportMessage("Verify anruf permission")
                .perform();
        driver.verifyThat().element(lastChangeLabel4)
                .textTrimmed().isEqualTo(lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(lastChangeDate4).exists().perform();
        driver.verifyThat().element(persmissionDescription4)
                .textTrimmed().isEqualTo(persmissionDescription4CL)
                .withCustomReportMessage("Verify permission description")
                .perform();
        return this;
    }

}
