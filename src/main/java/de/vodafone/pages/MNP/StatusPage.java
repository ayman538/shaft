package de.vodafone.pages.MNP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class StatusPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By pageHeader = By.xpath("//*[@id='root']//h1");
    private static By ErfolgreichanD2uebermittelStatusHeader = By.xpath("//*[@data-automation-id='statusView_nt']//h5");
    private static By ErfolgreichanD2uebermittelStatusBody = By.xpath("//*[@data-automation-id='statusView_nt']//p");
    private static By BereitzurBonitaetspruefungStatusHeader = By.xpath("//*[@data-automation-id='statusView_nt']//h5");
    private static By BereitzurBonitaetspruefungStatusBody = By.xpath("//*[@data-automation-id='statusView_nt']//p");
    private static By ManuellePruefungStatusHeader = By.xpath("//*[@data-automation-id='statusView_nt']//h5");
    private static By ManuellePruefungStatusBody = By.xpath("//*[@data-automation-id='statusView_nt']//p");
    private static By erledigtStatusHeader = By.xpath("//*[@data-automation-id='statusView_nt']//h5");
    private static By erledigtStatusBody = By.xpath("//*[@data-automation-id='statusView_nt']//p");
    private static By exportgebuchtStatusHeader = By.xpath("//*[@data-automation-id='statusView_nt']//h5");
    private static By exportgebuchtStatusBody = By.xpath("//*[@data-automation-id='statusView_nt']//p");
    private static By defaultStatusHeader = By.xpath("//*[@data-automation-id='statusView_nt']//h5");
    private static By defaultStatusBody = By.xpath("//*[@data-automation-id='statusView_nt']//p");
    private static By errorCodeStatusHeader = By.xpath("//*[@data-automation-id='statusView_nt']//h5");
    private static By errorCodeStatusBody = By.xpath("//*[@data-automation-id='statusView_nt']//p");
    private static By serviceFailureMsgHeader = By.xpath("//*[@data-automation-id='error_nt']//h5");
    private static By serviceFailureMsgBody = By.xpath("//*[@data-automation-id='error_nt']//p");
    private static By missingDataHeader = By.xpath("//*[@data-automation-id='missingData_nt']//h5");
    private static By missingDataBody = By.xpath("//*[@data-automation-id='missingData_nt']//p");
    private static By unathorizedUserCTA = By.xpath("//a[@id='25893']");
    private static By tooEarlyStatusHeader = By.xpath("//*[@data-automation-id='error_nt']//h5");
    private static By tooEarlyStatusBody = By.xpath("//*[@data-automation-id='error_nt']//p");
    private static By unAuthorizedStatusHeader = By.xpath("//*[@data-automation-id='landingPage_nt']//h5");
    private static By unAuthorizedStatusBody = By.xpath("//*[@data-automation-id='landingPage_nt']//p");


    // CLs
    private static String pageHeader_CL = "Status Deiner Rufnummern-Mitnahme";
    private static String ErfolgreichanD2uebermittelStatusHeader_CL = "Wir arbeiten dran";
    private static String ErfolgreichanD2uebermittelStatusBody_CL = "Deine Rufnummern-Mitnahme bearbeiten wir schon. Hier siehst Du, wenn sich Dein Status ändert. Falls wir Fragen haben, melden wir uns bei Dir.";
    private static String BereitzurBonitaetspruefungStatusHeader_CL = "Wir arbeiten dran";
    private static String BereitzurBonitaetspruefungStatusBody_CL = "Sobald wir von Deinem bisherigen Anbieter eine Antwort haben, bekommst Du eine SMS von uns und weitere Infos per E-Mail.";
    private static String ManuellePruefungStatusHeader_CL = "Wir arbeiten dran";
    private static String ManuellePruefungStatusBody_CL = "Deine Rufnummern-Mitnahme bearbeiten wir schon. Wir informieren Dich, wenn sich der Status ändert. Falls wir Fragen haben, melden wir uns bei Dir.";
    private static String erledigtStatusHeader_CL = "Wir arbeiten dran";
    private static String erledigtStatusBody_CL = "Deine Rufnummern-Mitnahme bearbeiten wir schon. Wir informieren Dich, wenn sich der Status ändert. Falls wir Fragen haben, melden wir uns";
    private static String exportgebuchtStatusHeader_CL = "Deine Rufnummern-Mitnahme ist bestätigt";
    private static String exportgebuchtStatusBody_CL = "Deinen Auftrag zur Rufnummern-Mitnahme haben wir bearbeitet. Wenn Du Deine Rufnummern-Mitnahme online beauftragt hast, dann bekommst Du von uns eine E-Mail mit dem Datum, an dem Deine Rufnummer zu Vodafone übertragen wird.";
    private static String defaultStatusHeader_CL = "Wir können Deinen Status leider nicht anzeigen";
    private static String defaultStatusBody_CL = "Wenn Du einen Auftrag online oder im Shop erteilt hast, dann melden wir uns bald bei Dir.";
    private static String errorCodeStatusHeader_CL = "Dein Termin steht fest";
    private static String errorCodeStatusBody_CL = "Am kommt Deine Rufnummer 0162 250 86 47 von Deinem bisherigen Anbieter zu uns. Falls Du Deine Vodafone-SIM-Karte noch nicht in Dein Gerät gelegt hast, tue das bitte an diesem Tag.";
    private static String serviceFailureMsgHeader_CL = "Es ist ein Fehler aufgetreten!";
    private static String serviceFailureMsgBody_CL = "Es ist bei der Statusabfrage zur Rufnummernportierung ein Fehler aufgetreten, bitte versuchen Sie es später noch ein Mal.";
    private static String missingDataHeader_CL = "Es ist ein Fehler aufgetreten!";
    private static String missingDataBody_CL = "Aufgrund fehlender Daten konnte kein Status ermittelt werden";
    private static String tooEarlyHeader_CL = "Zu früh";
    private static String tooEarlyBody_CL = "Den Status Ihres Auftrags können Sie erst in etwa einer Stunde sehen. Versuchen Sie es bitte noch mal.";
    private static String unathorizedUserMsgHeader_CL = "Du willst Deinen Status zu Deiner Rufnummern-Mitnahme abfragen?";
    private static String unathorizedUserMsgBody_CL = "Melde Dich mit Deiner Vodafone-Handy-Nummer (nicht mit der Handy-Nummer, die Du zu uns mitbringen möchtest) per SMS-Code-Verfahren an, um den aktuellen Status zu sehen!";
    private static String unathorizedUserCTA_CL = "Vodafone-Handy-Nummer und mTAN";
    private static String currentlyUnavailableMsgBody_CL = "Die Rufnummer zu diesen Anmeldeinformationen ist zur Zeit nicht aktiv.";
    private static String noPortStatusMsgBody_CL = "Es konnte kein Portierungsstatus zu diesen Anmeldeinformationen gefunden werden.";
    private static String noPortJobMsgBody_CL = "Es konnte kein Portierungsauftrag zu diesen Anmeldeinformationen gefunden werden." ;


    public StatusPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("validate status")
    public StatusPage validateErfolgreichanD2uebermitteltStatus() {
        driver.verifyThat().element(ErfolgreichanD2uebermittelStatusHeader).text().isEqualTo(ErfolgreichanD2uebermittelStatusHeader_CL).perform();
        driver.verifyThat().element(ErfolgreichanD2uebermittelStatusBody).text().contains(ErfolgreichanD2uebermittelStatusBody_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validateBereitzurBonitaetspruefungStatus() {
        driver.verifyThat().element(BereitzurBonitaetspruefungStatusHeader).text().isEqualTo(BereitzurBonitaetspruefungStatusHeader_CL).perform();
        driver.verifyThat().element(BereitzurBonitaetspruefungStatusBody).text().contains(BereitzurBonitaetspruefungStatusBody_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validateManuellePruefungStatus() {
        driver.verifyThat().element(ManuellePruefungStatusHeader).text().isEqualTo(ManuellePruefungStatusHeader_CL).perform();
        driver.verifyThat().element(ManuellePruefungStatusBody).text().contains(ManuellePruefungStatusBody_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validateerledigtStatus() {
        driver.verifyThat().element(erledigtStatusHeader).text().isEqualTo(erledigtStatusHeader_CL).perform();
        driver.verifyThat().element(erledigtStatusBody).text().contains(erledigtStatusBody_CL).perform();
        return this;
    }
    @Step("validate status")
    public StatusPage validateMissingData() {
        driver.verifyThat().element(missingDataHeader).text().isEqualTo(missingDataHeader_CL).perform();
        driver.verifyThat().element(missingDataBody).text().contains(missingDataBody_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validateExportgebuchtStatus() {
        driver.verifyThat().element(exportgebuchtStatusHeader).text().isEqualTo(exportgebuchtStatusHeader_CL).perform();
        driver.verifyThat().element(exportgebuchtStatusBody).text().contains(exportgebuchtStatusBody_CL).perform();
        return this;
    }
    @Step("validate status")
    public StatusPage validateErrorCodeStatus() {
        driver.verifyThat().element(errorCodeStatusHeader).text().isEqualTo(errorCodeStatusHeader_CL).perform();
        driver.verifyThat().element(errorCodeStatusBody).text().contains(errorCodeStatusBody_CL).perform();
        return this;
    }
    @Step("validate status")
    public StatusPage validateServiceFailure() {
        driver.verifyThat().element(serviceFailureMsgHeader).text().isEqualTo(serviceFailureMsgHeader_CL).perform();
        driver.verifyThat().element(serviceFailureMsgBody).text().contains(serviceFailureMsgBody_CL).perform();
        return this;
    }
    @Step("validate status")
    public StatusPage validateDefaultStatus() {
        driver.verifyThat().element(defaultStatusHeader).text().isEqualTo(defaultStatusHeader_CL).perform();
        driver.verifyThat().element(defaultStatusBody).text().contains(defaultStatusBody_CL).perform();
        return this;
    }
    @Step("Validate Device list page Header and sub header CL")
    public StatusPage validateHeaderCL() {
        driver.verifyThat().element(pageHeader).text().isEqualTo(pageHeader_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validateTooEarlyErrorMsg() {
        driver.verifyThat().element(tooEarlyStatusHeader).text().isEqualTo(tooEarlyHeader_CL).perform();
        driver.verifyThat().element(tooEarlyStatusBody).text().contains(tooEarlyBody_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validateUnauthorizedUserMsg() {
        driver.verifyThat().element(unAuthorizedStatusHeader).text().isEqualTo(unathorizedUserMsgHeader_CL).perform();
        driver.verifyThat().element(unAuthorizedStatusBody).text().contains(unathorizedUserMsgBody_CL).perform();
        return this;
    }
    @Step("validate status")
    public StatusPage validateClickOnLandingPageCTA() {
        driver.element().click(unathorizedUserCTA);
        return this;
    }
    @Step("validate status")
    public StatusPage validateCurrentlyUnavailableMsg() {
        driver.verifyThat().element(serviceFailureMsgHeader).text().isEqualTo(serviceFailureMsgHeader_CL).perform();
        driver.verifyThat().element(serviceFailureMsgBody).text().contains(currentlyUnavailableMsgBody_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validatenoPortStatusFoundErrorMsg() {
        driver.verifyThat().element(serviceFailureMsgHeader).text().isEqualTo(serviceFailureMsgHeader_CL).perform();
        driver.verifyThat().element(serviceFailureMsgBody).text().contains(noPortStatusMsgBody_CL).perform();
        return this;
    }

    @Step("validate status")
    public StatusPage validatenoPortjobFoundErrorMsg() {
        driver.verifyThat().element(serviceFailureMsgHeader).text().isEqualTo(serviceFailureMsgHeader_CL).perform();
        driver.verifyThat().element(serviceFailureMsgBody).text().contains(noPortJobMsgBody_CL).perform();
        return this;
    }
}