package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class KablePersonalOfferPrivacy {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By meineDatenButton = By.xpath("//a[@automation-id='Meine Daten_btn']");
    public static final By Privacy_SO = By.xpath("//*[@automation-id=\"datenschutz_so\"]");
    public static final By Privacy_Accordion = By.xpath("//*[@automation-id=\"datenschutz-einstellungen_acc\"]");
    public static final By Personal_Offer_Section = By.xpath("//*[@automation-id=\"PERSONAL_OFFERS_tv\"]");
    public static final By Personal_Offer_Title = By.xpath("//*[@automation-id=\"PERSONAL_OFFERS_tv\"]/h4");
    public static final By Personal_Offer_Text = By.xpath("//*[@automation-id=\"PERSONAL_OFFERS_tv\"]/p");
    public static final By Personal_Offer_Button = By.xpath("//*[@automation-id=\"PERSONAL_OFFERS_tv\"]/a");
    public static final By Edit_Privacy_Page_Header = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1");
    public static final By Edit_Accordion_Title = By.xpath("//*[@class=\"tg-head tg-active\"]/h3");
    public static final By Edit_Privacy_Card_Header = By.xpath("//*[@class=\"white-box col w-60 mb-20 standard-form\"]/div/h3");
    public static final By Edit_Privacy_Card_Toggle_ON = By.xpath("//*[@class=\"white-box col w-60 mb-20 standard-form\"]/switcher/div/label/span[1]");
    public static final By Edit_Privacy_Card_Toggle_OFF = By.xpath("//*[@class=\"white-box col w-60 mb-20 standard-form\"]/switcher/div/label/span[2]");
    public static final By Last_Date_Title = By.xpath("//*[@class=\"white-box col w-60 mb-20 standard-form\"]/div/h4");
    public static final By Last_Date_Content = By.xpath("(//*[@class=\"white-box col w-60 mb-20 standard-form\"]/div/p)[1]");
    public static final By Edit_Privacy_Card_Text = By.xpath("(//*[@class=\"white-box col w-60 mb-20 standard-form\"]/div/p)[2]");
    public static final By LinkOut_Text = By.xpath("//*[@automation-id=\"undefined_description_tv\"]");
    public static final By Edit_Privacy_Card_Button = By.xpath("//*[@class=\"link-padding\"]/button");
    public static final By Warning_Message_Box = By.xpath("//*[@class=\"alert noselect mt-40 clear warning\"]");
    public static final By Warning_Message_Icon = By.xpath("//*[@class=\"i-sml i-orange\"]");
    public static final By Warning_Message_Title = By.xpath("//*[@class=\"alert noselect mt-40 clear warning\"]//*[@class=\"flexDiv\"]");
    public static final By Warning_Message_Body = By.xpath("//*[@class=\"alert noselect mt-40 clear warning\"]/div/p");
    public static final By Warning_Message_Confirm_Btn = By.xpath("//*[@automation-id=\"switcher_confirmation_notification_btn\"][1]");
    public static final By Warning_Message_Cancel_Btn = By.xpath("//*[@automation-id=\"switcher_confirmation_notification_btn\"][2]");
    public static final By Success_Message = By.xpath("//*[@class=\"flexDiv\"]");

    //CLS
    public static String Personal_Offer_Title_CL = "Persönliche Angebote";
    public static String Personal_Offer_Text_CL = "Leg hier fest, ob Du von uns persönliche Angebote im Web und in den Apps angezeigt bekommen möchtest.";
    public static String Personal_Offer_Button_CL = "Bearbeiten";
    public static String Edit_Privacy_Page_Header_CL = "Datenschutz-Einstellungen";
    public static String Edit_Accordion_Title_CL = "Persönliche Angebote anzeigen";
    public static String Edit_Privacy_Card_Header_CL = "Persönliche Angebote anzeigen";
    public static String Edit_Privacy_Card_Toggle_ON_CL = "ein";
    public static String Edit_Privacy_Card_Toggle_OFF_CL = "aus";
    public static String Last_Date_Title_CL = "Letzte Änderung:";
    public static String Edit_Privacy_Card_Text_CL = "Wir dürfen Dir auf Dich zugeschnittene Angebote im Web und in den Apps anzeigen.";
    public static String LinkOut_Text_CL = "Pass hier die Einstellung für alle Verträge und Teilnehmer auf einmal an.";
    public static String Edit_Privacy_Card_Button_CL = "Bestätigen";
    public static String Warning_Message_Title_CL = "Wichtig!";
    public static String Warning_Message_Body_CL = "Schaltest Du diese Einstellung aus, dürfen wir Dir keine maßgeschneiderten Angebote oder Rabatte im Web und in den Apps mehr machen. Möchtest Du Persönliche Angebote trotzdem ausschalten?";
    public static String Warning_Message_Confirm_Btn_CL = "Weiter";
    public static String Warning_Message_Cancel_Btn_CL = "Zurück";
    public static String Success_Message_CL = "Deine Änderungen haben wir gespeichert.";

    //constructor
    public KablePersonalOfferPrivacy(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public KablePersonalOfferPrivacy NavigateToPrivacyAccordion(){
        driver.element().click(meineDatenButton);
        driver.element().click( Privacy_SO);
        return this;
    }

    public KablePersonalOfferPrivacy changePersonalOfferPrivacyToggle(){
        if (
            driver.element().isElementDisplayed( Edit_Privacy_Card_Toggle_ON)) {
            SetPrivacyToggleOff();
            AssertEditPersonalOfferWarningMessage();
            ConfirmWarningMessage();
        }
        else
            SetPrivacyToggleOn();

        return this;
    }

    public KablePersonalOfferPrivacy NavigateToEditPersonalOfferPrivacy(){
        driver.element().click(Personal_Offer_Button);
        return this;
    }

    public KablePersonalOfferPrivacy SetPrivacyToggleOff(){
        driver.element().click( Edit_Privacy_Card_Toggle_ON);
        return this;
    }

    public KablePersonalOfferPrivacy SetPrivacyToggleOn(){
        driver.element().click( Edit_Privacy_Card_Toggle_OFF);
        return this;
    }

    public KablePersonalOfferPrivacy ConfirmWarningMessage(){
        driver.element().click( Warning_Message_Confirm_Btn);
        return this;
    }

    public KablePersonalOfferPrivacy ConfirmEditChanges(){
        driver.element().click( Edit_Privacy_Card_Button);
        return this;
    }

    public KablePersonalOfferPrivacy AssertPersonalOfferSection()
    {
        driver.verifyThat()
                .element(Personal_Offer_Title).textTrimmed().isEqualTo(Personal_Offer_Title_CL)
                .withCustomReportMessage("Check that Personal offer Section Title is exist and correct CL")
                .perform();
        driver.verifyThat().element( KablePersonalOfferPrivacy.Personal_Offer_Text).textTrimmed()
                .isEqualTo(Personal_Offer_Text_CL)
                .withCustomReportMessage("Check that Personal offer Section Text is exist and correct CL")
                .perform();
        driver.verifyThat().element(Personal_Offer_Button).textTrimmed()
                .isEqualTo(Personal_Offer_Button_CL)
                .withCustomReportMessage("Check that Personal offer Section Button is exist and correct CL")
                .perform();
        return this;
    }

    public KablePersonalOfferPrivacy AssertEditPersonalOfferPage()
    {
        driver.verifyThat().element(Edit_Accordion_Title).textTrimmed()
                .isEqualTo(KablePersonalOfferPrivacy.Edit_Accordion_Title_CL)
                .withCustomReportMessage("Check that Edit_Accordion_Title_CL is exist and correct CL")
                .perform();
        driver.verifyThat().element(Edit_Privacy_Page_Header).textTrimmed()
                .isEqualTo(Edit_Privacy_Page_Header_CL)
                .withCustomReportMessage("Check that Edit_Privacy_Page_Header_CL is exist and correct CL")
                .perform();

        driver.verifyThat().element(Edit_Accordion_Title).textTrimmed()
                .isEqualTo(Edit_Accordion_Title_CL)
                .withCustomReportMessage("Check that Edit_Accordion_Title_CL2 is exist and correct CL")
                .perform();

        driver.verifyThat().element( KablePersonalOfferPrivacy.Edit_Privacy_Card_Toggle_ON).textTrimmed()
                .isEqualTo(Edit_Privacy_Card_Toggle_ON_CL)
                .withCustomReportMessage("Check that Toggle status is exist and correct CL")
                .perform();
        driver.verifyThat().element(Edit_Privacy_Card_Header).textTrimmed()
                .isEqualTo(Edit_Privacy_Card_Header_CL)
                .withCustomReportMessage("Check that Title of edit Personal offer Section is exist and correct CL")
                .perform();

        driver.verifyThat().element(Edit_Privacy_Card_Text).textTrimmed()
                .isEqualTo(Edit_Privacy_Card_Text_CL)
                .withCustomReportMessage("Check that Text of edit Personal offer Section is exist and correct CL")
                .perform();

        driver.verifyThat().element(Last_Date_Title)
                .textTrimmed().isEqualTo(Last_Date_Title_CL)
                .withCustomReportMessage("Check that Title of last update date is exist and correct CL")
                .perform();

        driver.verifyThat().element(Last_Date_Content)
                .exists()
                .withCustomReportMessage("Check that Last update date is exist")
                .perform();

        driver.verifyThat()
                .element(LinkOut_Text)
                .textTrimmed()
                .isEqualTo(LinkOut_Text_CL)
                .withCustomReportMessage("Check that Text of Link out is exist and correct CL")
                .perform();

        driver.verifyThat()
                .element(Edit_Privacy_Card_Button)
                .textTrimmed()
                .isEqualTo(Edit_Privacy_Card_Button_CL)
                .withCustomReportMessage("Check that Button of edit Personal offer Section is exist and correct CL")
                .perform();
        return this;
    }

    public KablePersonalOfferPrivacy AssertEditPersonalOfferWarningMessage()
    {
        driver.verifyThat().element(Warning_Message_Icon).exists()
                .withCustomReportMessage("Check that Warning message icon is exist")
                .perform();

        driver.verifyThat().element(Warning_Message_Title).textTrimmed()
                .isEqualTo(KablePersonalOfferPrivacy.Warning_Message_Title_CL)
                .withCustomReportMessage("Check that Warning message title is exist and correct CL")
                .perform();
        driver.verifyThat().element(Warning_Message_Body).textTrimmed().isEqualTo(Warning_Message_Body_CL)
                .withCustomReportMessage("Check that Warning message Body is exist and correct CL")
                .perform();
        driver.verifyThat().element( KablePersonalOfferPrivacy.Warning_Message_Confirm_Btn).textTrimmed()
                .isEqualTo(Warning_Message_Confirm_Btn_CL)
                .withCustomReportMessage("Check that Warning message Confirm Button is exist and correct CL")
                .perform();
        driver.verifyThat().element(KablePersonalOfferPrivacy.Warning_Message_Cancel_Btn)
                .textTrimmed().isEqualTo(KablePersonalOfferPrivacy.Warning_Message_Cancel_Btn_CL)
                .withCustomReportMessage("Check that Warning message Cancel Button is exist and correct CL")
                .perform();
        return this;
    }
    public KablePersonalOfferPrivacy AssertEditPersonalOfferSuccessMessage()
    {
        driver.verifyThat()
                .element(Success_Message).textTrimmed().isEqualTo(Success_Message_CL)
                .withCustomReportMessage("Check that Success message is exist and correct CL")
                .perform();
        return this;
    }
}

