package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class PersonalDataSection {
    //variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    public static String pageTitleCL   = "Datenschutz-Einstellungen";
    public static String sectionTitleCL   = "Persönliche Daten";
    public static String PermissionCL   = "Austausch Bestands-/Vertragsdaten zu Werbezwecken";
    public static String persmissionDescriptionCL   = "Vodafone darf Deine Bestands-/Vertragsdaten zur Optimierung seines Netzes und seiner Produkte und Services nutzen sowie für gezielte Angebote und Beratung. Die inländischen Vodafone-Unternehmen tauschen diese Daten zu diesem Zweck auch untereinander aus. Deine Bestands-/Vertragsdaten sind Angaben rund um Dein Vertragsverhältnis, Deine Tarife, Optionen und Services sowie Informationen, die Dich als Person identifizieren, wie z.B. Name, Post- und E-Mail-Adresse, Rufnummer, Geburtsdatum und IBAN. Wenn wir besser verstehen, wie Du unsere Produkte und Services nutzt, können wir Dir Angebote schicken, die besser zu Dir passen.";
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
    public static By notificationContinueBtn = By.xpath("(//*[@automation-id='switcher_confirmation_notification_btn'])[1]");
    public static By notificationUndoneBtn = By.xpath("(//*[@automation-id='switcher_confirmation_notification_btn'])[2]");
    public static By notificationSaveChangesBtn = By.xpath("(//*[@automation-id='final_confirmation_notification_btn'])[1]");
    public static By notificationDontSaveChangesBtn = By.xpath("(//*[@automation-id='final_confirmation_notification_btn'])[2]");
    public static By saveChangesDescription1 = By.xpath("(//*[@class='notification-text mb-10 mt-10']/p)[1]");
    public static By saveChangesDescription2 = By.xpath("(//*[@class='notification-text mb-10 mt-10']/p)[2]");
    public static By successMsg = By.xpath("(//*[@automation-id='success_notification_nt'])/div/div[2]/div[1]/div[2]/h4");


    //Constructor
    public PersonalDataSection(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Methods
    public void changeToggleBtn() {
        if (driver.element().isElementDisplayed(toggleBtnOn)) {
            driver.element().click(toggleBtnOn);
        } else {
            driver.element().click(toggleBtnOff);
        }
    }
//    public void changeToggleBtn(){
//        driver.element().click(toggleBtnOff);
//    }

    public void clickUndoneBtn(){
        driver.element().click(notificationUndoneBtn);}

    public void clickContinueBtn(){
        driver.element().click(notificationContinueBtn);}


    public void clickConfrimBtn(){
        driver.element().click(confirmBtn);}

    public void clickSaveChangesBtn(){
        driver.element().click(notificationSaveChangesBtn);}
}
