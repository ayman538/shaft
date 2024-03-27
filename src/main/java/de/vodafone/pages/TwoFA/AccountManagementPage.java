package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AccountManagementPage {
    private static SHAFT.GUI.WebDriver driver;

    public AccountManagementPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //SO
    private By mergeAccountsSO = By.xpath("//div[@automation-id='mergeAccounts_so']");

    //login Data Accordion
    private By loginDataHeader = By.xpath("//*[@automation-id='loginDataHeader_tv']");
    private By recoveryDataHeader = By.xpath("//*[@automation-id='recoveryHeadline_tv']");
    private By personalDataHeader = By.xpath("//*[@automation-id='personalData_tv']");
    private By accountHandlingHeader = By.xpath("//*[@automation-id='deleteAccountHeadline_tv']");

    private By username = By.xpath("//*[@automation-id='userName_tv']");
    private By password = By.xpath("//*[@automation-id='changePasswordHeader_tv']");
    private By number = By.xpath("//*[@automation-id='phoneNumberLabel_tv']");
    private By email = By.xpath("//*[@automation-id='availableEmailHeader_tv']");
    private By nameandTitle = By.xpath("//*[@automation-id='nameAndTitle_tv']");

    private By twoFAHeader = By.xpath("//p[@automation-id='2FAHeader_tv']/strong");
    private By twoFAText = By.xpath("//p[@automation-id='2FABody_tv']");
    private By twoFALearnMore = By.xpath("//a[@automation-id='moreInfo_Link']/strong");
    private By twoFAStatus = By.xpath("//p[@automation-id='2FAStatus_tv']");
    private By twoFAActivateCTA = By.xpath("//a[@automation-id='navigateToActivate2FA_Link']");
    private By twoFADeactivateCTA = By.xpath("//a[@automation-id='navigateToDeactivate2FA_Link']");

    private By backUpCodesHeader = By.xpath("//p[@automation-id='BackUpCodeHeader_tv']");
    private By backUpCodesText = By.xpath("//p[@automation-id='BackUpCodeBody_tv']");
    private By backUpCodesStatus = By.xpath("//p[@automation-id='BackUpCodeCount_tv']");
    private By backUpCodesCount = By.xpath("//p[@automation-id='BackUpCodeCount_tv']");
    private By backUpCodesDate = By.xpath("//div[@automation-id='BackUpCodeDate_tv']/strong");
    private By backUpCodesCTA = By.xpath("//button[@automation-id='navigateToGenerateBackUp_Link']");
    private By addContractCTA = By.xpath("//div[@automation-id='addContract_so']");

    private String loginDataHeaderCL = "Login-Daten";
    private String recoveryDataHeaderCL = "Daten zur Wiederherstellung Deines Kontos";
    private String personalDataHeaderCL = "Persönliche Daten";
    private String accountHandlingHeaderCL = "MeinVodafone-Konto löschen?";

    private String twoFAHeaderCL = "2-Faktor-Authentifizierung";
    private String twoFATextCL = "Schütz Dein Konto zusätzlich vor nicht berechtigtem Zugriff. Nutz eine 2-Faktor-Authentifizierung.";
    private String twoFALearnMoreCL = "Mehr erfahren";
    private String twoFANotActivatedCL = "2-Faktor-Authentifizierung ist noch nicht aktiviert";
    private String twoFAActivatedCL = "2-Faktor-Authentifizierung ist aktiviert";
    private String twoFAActivateCTACL = "Aktivieren";
    private String twoFADeactivateCTACL = "Deaktivieren";

    private String backUpCodesHeaderCL = "Backup-Codes";
    private String backUpCodesTextCL = "Falls die 2-Faktor-Authentifzierung mal nicht klappt: Hol Dir jetzt zusätzliche Backup-Codes. Mit denen loggst Du Dich dann ein.";
    private String backUpCodesNotRequestedCL = "Du hast noch keine Backup-Codes erstellt.";
    private String backUpCodesDateCL = "Backup-Codes wurden am 19. April 2023 erstellt.";
    private String backUpCodes10CL = "Du hast noch 10 Backup-Codes übrig.";
    private String backUpCodes2CL = "Du hast noch 2 Backup-Codes übrig.";
    private String backUpCodes0CL = "Du hast noch keine Backup-Codes erstellt.";
    private String backUpCodesCTACL = "Backup-Codes erstellen";
    private String backUpCodesNewCTACL = "Neue Backup-Codes erstellen";
    private String accountManagementURL = "meinvodafone/services/vertragsdaten";


    @Step("Check CL for group headers in Logon Data accordion")
    public void loginDataCLValidation() {
        driver.verifyThat().element(loginDataHeader).text().isEqualTo(loginDataHeaderCL).perform();
        driver.verifyThat().element(recoveryDataHeader).text().isEqualTo(recoveryDataHeaderCL).perform();
        driver.verifyThat().element(personalDataHeader).text().isEqualTo(personalDataHeaderCL).perform();
        driver.verifyThat().element(accountHandlingHeader).text().contains(accountHandlingHeaderCL).perform();
    }

    @Step("Verify that all sections are displayed in new sections")
    public void loginDataSectionsValidations() {
        driver.verifyThat().element(username).exists().perform();
        driver.verifyThat().element(password).exists().perform();
        driver.verifyThat().element(number).exists().perform();
        driver.verifyThat().element(email).exists().perform();
    }

    @Step("Verify 2FA section CL when user is not yet activated")
    public void twoFANotActivatedSectionValidation() {
        driver.verifyThat().element(twoFAHeader).text().isEqualTo(twoFAHeaderCL).perform();
        driver.verifyThat().element(twoFAText).text().isEqualTo(twoFATextCL).perform();
        driver.verifyThat().element(twoFALearnMore).text().isEqualTo(twoFALearnMoreCL).perform();
        driver.verifyThat().element(twoFAStatus).text().isEqualTo(twoFANotActivatedCL).perform();
        driver.verifyThat().element(twoFAActivateCTA).text().isEqualTo(twoFAActivateCTACL).perform();
    }

    @Step("Verify 2FA section CL when user is activated")
    public void twoFAActivatedSectionValidation() {
        driver.verifyThat().element(twoFAHeader).text().isEqualTo(twoFAHeaderCL).perform();
        driver.verifyThat().element(twoFAText).text().isEqualTo(twoFATextCL).perform();
        driver.verifyThat().element(twoFALearnMore).text().isEqualTo(twoFALearnMoreCL).perform();
        driver.verifyThat().element(twoFAStatus).text().isEqualTo(twoFAActivatedCL).perform();
        driver.verifyThat().element(twoFADeactivateCTA).text().isEqualTo(twoFADeactivateCTACL).perform();
    }

    @Step("Check that backup code section is not displayed")
    public void backupCodesSectionNotDisplayedValidation() {
        driver.verifyThat().element(backUpCodesHeader).doesNotExist().perform();
    }

    @Step("Check backup codes section when no codes have been requested yet")
    public void backupCodesSectionNotRequestedValidation() {
        driver.verifyThat().element(backUpCodesHeader).text().isEqualTo(backUpCodesHeaderCL).perform();
        driver.verifyThat().element(backUpCodesText).text().isEqualTo(backUpCodesTextCL).perform();
        driver.verifyThat().element(backUpCodesStatus).text().isEqualTo(backUpCodesNotRequestedCL).perform();
        driver.verifyThat().element(backUpCodesCTA).text().isEqualTo(backUpCodesCTACL).perform();
    }

    @Step("Check backup codes when 10 codes are left for the user to use")
    public void backupCodesSection10CodesValidation() {
        driver.verifyThat().element(backUpCodesHeader).text().isEqualTo(backUpCodesHeaderCL).perform();
        driver.verifyThat().element(backUpCodesText).text().isEqualTo(backUpCodesTextCL).perform();
        driver.verifyThat().element(backUpCodesCount).text().isEqualTo(backUpCodes10CL).perform();
        driver.verifyThat().element(backUpCodesDate).text().isEqualTo(backUpCodesDateCL).perform();
        driver.verifyThat().element(backUpCodesCTA).text().isEqualTo(backUpCodesNewCTACL).perform();
    }

    @Step("Check backup codes when 2 codes are left for the user to use")
    public void backupCodesSection2CodesValidation() {
        driver.verifyThat().element(backUpCodesHeader).text().isEqualTo(backUpCodesHeaderCL).perform();
        driver.verifyThat().element(backUpCodesText).text().isEqualTo(backUpCodesTextCL).perform();
        driver.verifyThat().element(backUpCodesDate).text().isEqualTo(backUpCodesDateCL).perform();
        driver.verifyThat().element(backUpCodesCount).text().isEqualTo(backUpCodes2CL).perform();
        driver.verifyThat().element(backUpCodesCTA).text().isEqualTo(backUpCodesNewCTACL).perform();
    }

    @Step("Check backup codes when no codes are left for the user to use")
    public void backupCodesSection0CodesValidation() {
        driver.verifyThat().element(backUpCodesHeader).text().isEqualTo(backUpCodesHeaderCL).perform();
        driver.verifyThat().element(backUpCodesText).text().isEqualTo(backUpCodesTextCL).perform();
        driver.verifyThat().element(backUpCodesDate).doesNotExist().perform();
        driver.verifyThat().element(backUpCodesCount).text().isEqualTo(backUpCodes0CL).perform();
        driver.verifyThat().element(backUpCodesCTA).text().isEqualTo(backUpCodesCTACL).perform();
    }

    // click
    public AccountManagementPage clickActivate2FA() {
        driver.element().click(twoFAActivateCTA);
        return this;
    }

    public AccountManagementPage clickMergeAccountsSO() {
        driver.element().click(mergeAccountsSO);
        return this;
    }

    public AccountManagementPage clickAddContract() {
        driver.element().click(addContractCTA);
        return this;
    }

    public AccountManagementPage validateURL() {
        driver.verifyThat().browser().url().contains(accountManagementURL);
        return this;
    }
    public AccountManagementPage clickDeactiavte2FA() {
        driver.element().click(twoFADeactivateCTA);
        return this;
    }
    public AccountManagementPage clickBackupCode() {
        driver.element().click(backUpCodesCTA);
        return this;
    }
}
