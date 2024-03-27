package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class SmartcardAktivieren {
    private SHAFT.GUI.WebDriver driver;

//CLs
public static String SmartcardAktivierenPageTitle_CL= "Smartcard aktivieren";
    public static String SmartcardAktivierenAccordionHeader_CL= "Smartcard aktivieren";
    public static String StepsTitle_CL= "So geht's:";
    public static String  SmartcardAktivierenPageSubTitle_CL="Unity Media Horizon Go Test (Kundennummer: 341449201)";
    public static String  GobackButton_CL="Schließen";
    public  static String smartcardaktivierenButton_CL ="Smartcard aktivieren";
    private static String smartcardAktivieren_ConfirmationMsgTitle_CL ="Aktivierung läuft ...";
    private static String  smartcardAktivieren_ConfirmationMsgBody_CL="Deine Smartcard oder Smartcards sind jetzt bereit. Innerhalb der nächsten Stunde werden Deine Sender freigeschaltet. Denk bitte dran:";
    private static String  SmartcardAktivieren_ConfirmationMsgTitle_SecondTry_CL="Aktivierung läuft …";
    private static String smartcardAktivieren_ConfirmationMsgText_SecondTry_CL ="Wir aktivieren gerade Deine Smartcard. In spätestens einer Stunde sind Deine Sender freigeschaltet.";





    //Locators
    public static final By smartcardAktivierenPageTitle = By.xpath("//*[@automation-id='pageHeader_tv']/h1");

    private static final By smartcardAktivierenPageSubTitle = By.xpath("//*[@automation-id='pageHeader_tv']/h2");
    private static final By smartcardAktivierenAccordionHeader= By.xpath("//*[@automation-id='oneStepStepperHeader_tv']");
    private static final By stepsTitle= By.xpath("//*[@automation-id='instructionbody_tv']");
    private static final By smartcardAktivierenAccButton = By.xpath("//*[@class='btn btn-sml disable-opacity']");
    private static final By smartcardAktivieren_ConfirmationMsgBody = By.xpath("//*[@id='content']//navigation/app-activate-tv-smart-cards-confirmation//div[2]/p");
    private static final By smartcardAktivieren_ConfirmationMsgTitle = By.xpath("//*[@id='content']/div[2]//app-activate-tv-smart-cards-confirmation//div[2]//h4");
    public static final By GoBackButton= By.xpath("//*[@id='content']/div[2]//app-activate-tv-smart-cards-confirmation//div[2]//h4");
    private static final By smartcardAktivieren_ConfirmationMsgTitle_SecondTry = By.xpath("//*[@id='smart-card']//notification//div[2]/h4");
    private static final By smartcardAktivieren_ConfirmationMsgText_SecondTry = By.xpath("//*[@id='smart-card']//notification//div[2]/p");
    private static final By smartcardAktivieren_ConfirmationMsgButton_SecondTry = By.xpath("//*[@id='smart-card']//button");
    public SmartcardAktivieren(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public void validateConfirmationMsgContent(){
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgTitle_SecondTry)
                .text().isEqualTo(SmartcardAktivieren.SmartcardAktivieren_ConfirmationMsgTitle_SecondTry_CL)
                .withCustomReportMessage("Validate Confirmation Message Second_Try Title")
                .perform();
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgText_SecondTry)
                .text().isEqualTo(SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgText_SecondTry_CL)
                .withCustomReportMessage("Validate Confirmation Message Second_Try Text")
                .perform();
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgButton_SecondTry)
                .text().isEqualTo(SmartcardAktivieren.smartcardaktivierenButton_CL)
                .withCustomReportMessage("Validate SmartcardaktivierenButton Text")
                .perform();
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgButton_SecondTry).isDisabled();

    }

    public void clickOnSmartcardAktivierenAccButton()
    {
        driver.element().click( smartcardAktivierenAccButton); }

    public void clickOnGoBackButton()
    {driver.element().click(GoBackButton); }
    public void validateCnofirmMsg(){
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgTitle)
                .text().isEqualTo(SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgTitle_CL)
                .withCustomReportMessage("Validate Confirmation Message Title")
                .perform();
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivieren_ConfirmationMsgBody).exists();
    }
    public void validateSmartAktivationBtnIsDisabled(){
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivierenAccButton).isDisabled();
    }
    public void validatePageTitle(){
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivierenPageSubTitle)
                .text().isEqualTo(SmartcardAktivieren.SmartcardAktivierenPageSubTitle_CL)
                .withCustomReportMessage("Validate PageSub title")
                .perform();
        Validations.assertThat().element(driver.getDriver(),SmartcardAktivieren.smartcardAktivierenPageTitle)
                .text().isEqualTo(SmartcardAktivieren.SmartcardAktivierenPageTitle_CL)
                .withCustomReportMessage("Validate Page title")
                .perform();

    }

}
