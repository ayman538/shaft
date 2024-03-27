package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class InternetUsageSection {
    //variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    public static String pageTitleCL   = "Datenschutz-Einstellungen";
    public static String sectionTitleCL   = "Internet-Nutzung";
    public static String PermissionCL   = "Webtracking auf VF- oder Kooperationspartnerseiten";
    public static String persmissionDescriptionCL1 = "Vodafone darf Deine Nutzungsdaten zur Optimierung seines Netzes und seiner Produkte und Services nutzen sowie für gezielte Angebote und Beratung.";
    public static String persmissionDescriptionCL2   = "Nutzungsdaten sind dabei Infos über Art, Umfang und Zeitpunkt der Nutzung von Vodafone-Webseiten und Online-Inhalten von Vodafone auf Webseiten von Kooperations- und Werbepartnern.";
    public static String persmissionDescriptionCL3   = "Die Daten identifizieren Dich oder Dein Gerät direkt und sind zum Teil in Deinem Gerät gespeichert, z.B. als Cookies.";
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
    public static By Permission = By.xpath("(//*[@class='displayinlineblock vertical-align-middle']/h3)[1]");
    public static By lastChangeLabel = By.xpath("(//*[@class='fl noBold'])[1]");
    public static By lastChangeDate1 = By.xpath("(//*[@class='fr w-18 width-23'])[1]");
    public static By persmissionDescription = By.xpath("(//*[@class='clear']/p)[2]");
    public static By toggleBtnOn = By.xpath("(//*[@class='on-text'])[1]");
    public static By toggleBtnOff = By.xpath("(//*[@class='off-text'])[1]");
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
    public InternetUsageSection(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Methods
    public InternetUsageSection changeToggleBtn()
    {
        if (driver.element().isElementDisplayed(toggleBtnOn))
        {
            driver.element().click(toggleBtnOn);
        }
        else
        {
            driver.element().click(toggleBtnOff);
        }
        return this;
    }

    public InternetUsageSection clickUndoneBtn(){
        driver.element().click(notificationUndoneBtn);
        return this;
    }

    public InternetUsageSection clickContinueBtn(){
        driver.element().click(notificationContinueBtn);
        return this;
    }

    public InternetUsageSection clickConfrimBtn(){
        driver.element().isElementClickable(confirmBtn);
        driver.element().click(confirmBtn);
        return this;
    }

    public InternetUsageSection clickSaveChangesBtn(){
        driver.element().click(notificationSaveChangesBtn);
        return this;
    }

    public InternetUsageSection changeInternetUsagePermissions(){
        new InternetUsageSection(driver).changeToggleBtn();
        if ( driver.element().isElementDisplayed(toggleBtnOff))
        {
            new ConnectionDataSection(driver).validateWarningMsgAfterChangingToggle();
            new InternetUsageSection(driver).clickContinueBtn();
        }
        return this;
    }

    public InternetUsageSection verifyInternetUsagePermissions(){
        //Verify Internet usage section
        driver.verifyThat().element(sectionTitle)
                .textTrimmed().isEqualTo(sectionTitleCL)
                .withCustomReportMessage("Verify section title")
                .perform();
        //Verify Webtracking auf VF- oder Kooperationspartnerseiten section
        driver.verifyThat().element(Permission)
                .textTrimmed().isEqualTo(PermissionCL)
                .withCustomReportMessage("Verify permission CL")
                .perform();
        driver.verifyThat().element(lastChangeLabel)
                .textTrimmed().isEqualTo(lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(lastChangeDate1).exists().perform();

        driver.verifyThat().element(persmissionDescription)
                .textTrimmed().contains(persmissionDescriptionCL1)
                .withCustomReportMessage("Verify permission description")
                .perform();
        driver.verifyThat().element(persmissionDescription)
                .textTrimmed().contains(persmissionDescriptionCL2)
                .withCustomReportMessage("Verify permission description")
                .perform();
        driver.verifyThat().element(persmissionDescription)
                .textTrimmed().contains(persmissionDescriptionCL3)
                .withCustomReportMessage("Verify permission description")
                .perform();
        return this;
    }

}
