package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SolsticeMyAccount {
    private SHAFT.GUI.WebDriver driver;

    public static By rufnummerändern_button = By.xpath("//*[text()='Rufnummer ändern']");
    public static By PersonalDataTitle = By.xpath("//*[text()='Anrede und Name:']");
    public static By PersonalDataBtn = By.xpath("//*[text()='Persönliche Daten ändern']");
    public static By MyAccountHeader = By.xpath("//*[@class='content-wrap'  and contains (., 'Mein Konto')]");
    public static By ErrorMsgTitle = By.xpath("//*[text()='Gut zu wissen']");
    public static By ErrorMsgBody = By.xpath("//*[text()='Du kannst Deine persönlichen Daten hier nicht ändern. Dein Konto wird von einem anderen Vodafone-Service verwendet.']");
    public static By DeletionTitle = By.xpath("//*[text()='MeinVodafone-Konto löschen?   ']");
    public static By DeletionBody = By.xpath("//*[text()=' Du möchtest uns verlassen? Hier kannst Du Deinen Zugang zu MeinVodafone löschen.    ']");
    public static By DeletionBtn = By.xpath("//*[text()='MeinVodafone-Konto löschen ']");
    public static By DeletionErrorTitle = By.xpath("//*[text()='Das geht leider nicht']");
    public static By DeletionErrorBody = By.xpath("//*[text()='Du kannst Dein Vodafone-Konto nicht löschen, weil es von einem oder einer anderen Teilnehmer:in genutzt wird.']");
    public static By UserNotEmailError = By.xpath("//*[@automation-id='notEmailNotification_nt']");
    public static By UserNotEmailErrorHeader = By.xpath("//*[@automation-id='notEmailNotification_nt']//h4");
    public static By UserNotEmailErrorBody = By.xpath("//*[@automation-id='notEmailNotification_nt']//p");
    public static By ChangeUsernameSectionText = By.xpath("//*[@id='changeLoginDataContent']//div[1]//p");
    public static By UsernameHeaderAndUsername = By.xpath("//*[@id='changeLoginDataContent']//div[1]//p[2]");
    //public static By ChangeUsernameCTA = By.xpath("//*[@id='changeLoginDataContent']//a");
    public static By ChangeUsernameCTA = By.xpath("//*[text()='Benutzernamen ändern']");
    public static By ChangePasswordCTA = By.xpath("//*[@class='btn btn-em btn-sml'  and contains (., 'Passwort ändern')]");

    public static String PersonalDataTitle_text = "Anrede und Name:";
    public static String MyAccountHeader_text = "Mein Konto";
    public static String ErrorMsgTitle_text = "Gut zu wissen";
    public static String ErrorMsgBody_text = "Du kannst Deine persönlichen Daten hier nicht ändern. Dein Konto wird von einem anderen Vodafone-Service verwendet.";
    public static String DeletionTitle_text = "MeinVodafone-Konto löschen?";
    public static String DeletionBody_text = "Du möchtest uns verlassen? Hier kannst Du Deinen Zugang zu MeinVodafone löschen.";
    public static String DeletionErrorTitle_text = "Das geht leider nicht";
    public static String DeletionErrorBody_text = "Du kannst Dein Vodafone-Konto nicht löschen, weil es von einem oder einer anderen Teilnehmer:in genutzt wird.";

    protected static String ChangeUsernameSectionText_text = "Diese Daten sind in Deinem MeinVodafone-Konto gespeichert.";
    protected static String UsernameHeaderAndUsername_text = "Benutzername:\n john.david";
    protected static String ChangeUsernameCTA_text = "Benutzernamen ändern";
    private String UserNotEmailErrorHeaderCL = "Wichtig für Dich";
    private String UserNotEmailErrorBodyCL = "Ändere Deinen Benutzernamen bitte in eine E-Mail-Adresse.";




//12205
    private By AdditionalPhoneNumbersCTA = By.xpath("//*[@automation-id='navigateToAdditionalSolsticeNumbers_Link']");
    private String AdditionalPhoneNumbersCTACL = "Weitere Rufnummern";
    @Step("Validate Cl for Additional Phone Numbers CTA")
    public void validateAdditionalPhoneNumberCTACL(){
        driver.verifyThat().element(AdditionalPhoneNumbersCTA).text().isEqualTo(AdditionalPhoneNumbersCTACL).perform();
    }
    public AdditionalPhoneNumbers clickAdditionalPhoneNumbersCTA(){
        driver.element().click(AdditionalPhoneNumbersCTA);
        return new AdditionalPhoneNumbers(driver);
    }
//end of 12205

    public SolsticeMyAccount(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SolsticeChangeNumber changePhoneNumberOption() {
        driver.element().click( rufnummerändern_button);
        return new SolsticeChangeNumber(driver);
    }

    public SolsticeChangePersonalData changePersonalData() {
        driver.element().click( PersonalDataBtn);
        return new SolsticeChangePersonalData(driver);
    }

    public SolsticeDeleteAccount Accountdeletion() {
        driver.element().click( DeletionBtn);
        return new SolsticeDeleteAccount(driver);
    }



    public ChangePassword changePassword() {
        driver.element().click( ChangePasswordCTA);
        return new ChangePassword(driver);

    }

    public SolsticeMyAccount waitUntilMienKontoOpen(){
        driver.element().waitToBeReady(MyAccountHeader);
        return this;
    }

    public ChangeUsernameStep1 changeUsername() {
        driver.element().click( ChangeUsernameCTA);
        return new ChangeUsernameStep1(driver);

    }
    @Step("Validate Username not Email Error Visibility and CLS")
    public void validateUsernameNotEmailError(){
        driver.verifyThat().element(UserNotEmailError).isVisible().perform();
        driver.verifyThat().element(UserNotEmailErrorHeader).text().isEqualTo(UserNotEmailErrorHeaderCL).perform();
        driver.verifyThat().element(UserNotEmailErrorBody).text().isEqualTo(UserNotEmailErrorBodyCL).perform();
    }
    @Step("Validate Username not Email Error is not visible")
    public void validateUsernameNotEmailErrorNotVisible(){
        driver.verifyThat().element(UserNotEmailError).doesNotExist().perform();
    }
}
