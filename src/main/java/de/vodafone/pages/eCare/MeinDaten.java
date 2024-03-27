package de.vodafone.pages.eCare;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MeinDaten {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private String internetPasswortBtn_Link = "/meinvodafone/account/verwaltung/ueberblick?accordion=manageAccountData";
    private String installationsCodesBtn_Link = "/meinvodafone/services/installationscode/installationscode-anfordern";
    private String dokumenteLink_Link = "/meinvodafone/services/notifizierung/dokumente";
    private String loginDatenBtn_Link = "/meinvodafone/account/verwaltung/ueberblick?accordion=manageAccountData";
    private String umzugBtn_Link = "https://dsl.vodafone.de/vfksc/umz/umz_auswahl.html";

    //Locators
    private By closeNotification_Locator = By.xpath("(//*[@class='icon-close-i-xxsml i-xxsml'])[1]");
    private By allNotificationsClose_Locator = By.cssSelector("[class='icon-close-i-xxsml i-xxsml']");
    private By smartObjectsCommon_Locator = By.xpath("//smart-object-wrapper");
    private By dokumenteLink_Locator = By.xpath("(//a[@class='ac-head accordion-state'])[1]");
    private By rufnummernLink_Locator = By.id("portierungsdaten");
    private By telefonbucheintragLink_Locator = By.id("dsl-telefonbucheintrag");
    private By teilnehmerLink_Locator = By.id("was-ist-die-teilnehmer-adresse");
    private By einzugsermaechtigungLink_Locator = By.id("wie-erteile-ich-eine-einzugsermaechtigung");
    private By bankverbindungLink_Locator = By.id("wie-aendere-ich-meine-bankverbindung");
    private By kundenKnotaktDatenTitle_Locator = By.xpath("(//div[@class='contactData']/h3)[1]");
    private By loginDatenTitle_Locator = By.xpath("(//h3[@automation-id='contactDetails_login_headline_tv'])[1]");
    private By kontaktDatenBtn_Locator = By.xpath("(//button[contains(.,'Kontaktdaten')])[1]");
    private By loginDatenBtn_Locator = By.xpath("(//a[@automation-id='contactDetails_emailValidated_Link'])[1]");
    private By kontaktDatenAccordion_Locator = By.xpath("(//li[@automation-id='kontaktdaten_acc'])[1]");
    private By adressenAccordion_Locator = By.xpath("//li[@automation-id='adressen_acc']");
    private By vertragsDatenAccordion_Locator = By.xpath("//li[@automation-id='vertrage-und-teilnehmer-verwaltens_acc']");
    private By bankVerveindungAccordion_Locator = By.xpath("//li[@automation-id='bankverbindung_acc']");
    private By kenwortAccordion_Locator = By.xpath("//li[@automation-id='kennwort-aendern_acc']");
    private By datenSchutzAccordion_Locator = By.xpath("(//li[@automation-id='datenschutz-einstellungen_acc'])[1]");
    private By rechnungsAdresseTitle_Locator = By.xpath("(//div[@class='addresses white-box cf']/h4)[1]");
    private By anschlussAdresseTitle_Locator = By.xpath("//div[@class='addresses white-box cf']/div/h4");
    private By andernBtn_Locator = By.xpath("//button[contains(.,'Ändern')]");
    private By umzugBtn_Locator = By.xpath("(//a[contains(.,'Umzug beauftragen')])[2]");
    private By rechnungAdressePageTitle_Locatopr = By.xpath("//div[@class='title-ecare overview']//h1");
    private By gigaZuhausTitle_Locator = By.xpath("//h3[contains(.,'GigaZuhause 100 DSL')]");
    private By vodafoneSpracheTitle_Locator = By.xpath("//h3[contains(.,'Vodafone-Sprache')]");
    private By vodafoneInternetTitle_Locator = By.xpath("//h3[contains(.,'Vodafone-Internet')]");
    private By vodafoneTvTitle_Locator = By.xpath("//h3[contains(.,'Vodafone TV')]");
    private By firstInfoIcon = By.xpath("(//a[@class='tg-icon'])[1]");
    private By firstInfoIconText_Locator = By.xpath("(//div[@class='wysiwyg']/p)[1]");
    private By bankVerbindungAccDescription_Locator = By.xpath("//bank-details-view/div/h4");
    private By bankVerbindungTitle_Locator = By.xpath("//h3[contains(.,'Deine Bankverbindung')]");
    private By einzugsermächtigungSection_Locator = By.xpath("//p[@automation-id='directDepit_tv']");
    private By bankVerbindungLinkSection_Locator = By.xpath("//ul[@class='static-accordion ecare-accordion-small help-support-link']");
    private By internetPasswortSectionTilte_Locator = By.xpath("(//h4[contains(.,'Internet-Passwort')])[1]");
    private By installationCodesSectionTitle_Locator = By.xpath("(//h4[contains(.,'Installationscodes anfordern')])[1]");
    private By internetZugansDatenSectionTitle_Locator = By.xpath("(//h4[contains(.,'Internet-Zugangsdaten')])[1]");
    private By kundenKenwortSectionTitle_Locator = By.xpath("(//h4[contains(.,'Kunden-Kennwort')])[1]");
    private By teilnhemerSectionTitle_Locator = By.xpath("(//h4[contains(.,'Teilnehmer-Kennwort')])[1]");
    private By internetPasswortBtn_Locator = By.xpath("(//a[@class='btn btn-em mb-0'])[1]");
    private By installationsCodesBtn_Locator = By.xpath("(//a[@class='btn btn-em mb-0'])[2]");
    private By internetZugangsBtn_Locator = By.xpath("(//a[@class='btn btn-em mb-0'])[3]");
    private By kundenKenwortBtn_Locator = By.xpath("//app-display-manage-passphrase/div[1]/div[4]/span/a");
    private By internetZugangsdatenPageTitle_Locator = By.xpath("//h1[contains(.,'Online-Zugangsdaten')]");
    private By informationenVonVodafoneSectionTitle_Locator = By.xpath("//h4[text()='Informationen von Vodafone']");
    private By personalicheDatenSectionTitle_Locator = By.xpath("(//h4[@class='serviceName'])[2]");
    private By verbindungsDatenSectionTitle_Locator = By.xpath("(//h4[@class='serviceName'])[3]");
    private By internetNutzungSectionTitle_Locator = By.xpath("(//h4[@class='serviceName'])[4]");
    private By personalicheAngeboteSectionTitle_Locator = By.xpath("(//h4[@class='serviceName'])[5]");
    private By informationenVonVodafoneBtn_Locator = By.xpath("(//div[@class='white-box']/a[@class='btn btn-sml btn-em'])[1]");
    private By personalicheDatenBtn_Locator = By.xpath("(//div[@class='white-box']/a[@class='btn btn-sml btn-em'])[2]");
    private By verbindungsDatenBtn_Locator = By.xpath("(//div[@class='white-box']/a[@class='btn btn-sml btn-em'])[3]");
    private By internetNutzungBtn_Locator = By.xpath("(//div[@class='white-box']/a[@class='btn btn-sml btn-em'])[4]");
    private By datenSchutzPageAccordionTitle_Locator = By.xpath("//div[@class='pt-10']/span/strong");
    private By bankDeatilsAccDescription_Locator = By.xpath("//bank-details-view/div/h4");
    private By bankDeatilsAccHeadLine_Locator = By.xpath("//bank-details-view//h3");
    private By accOwnerNameLabel_Locator = By.xpath("//p[@automation-id='accountOwnerName_tv']/strong");
    private By iBanLabel_Locator = By.xpath("//div[@automation-id='iban_tv']/strong");
    private By bicLabel_Locator = By.xpath("//p[@automation-id='bic_tv']/strong");
    private By bankNameLabel_Locator = By.xpath("//p[@automation-id='bankName_tv']/strong");
    private By directDebitLabel_Locator = By.xpath("//p[@automation-id='directDepit_tv']/strong");
    private By bankDetailsBtn_Locator = By.xpath("//a[@automation-id='bankDetails_Link']");
    private By bankDetailsLinkOut_Locator = By.xpath("//ul[@class='static-accordion ecare-accordion-small help-support-link']");
    private By savedAddressesSectionDescription_Locator = By.xpath("//app-address-view/div/h4");
    private By homeZoneAddressesSectionDescription_Locator = By.xpath("//address-details//span/h4");
    private By editAddressBtn_Locator = By.xpath("//address-details//button");
    private By editAddressPageTitle_Locator = By.xpath("//h1[contains(.,'Zuhause-Adresse bearbeiten')]");
    private By internetPasswortWeiterBtn_Locator = By.xpath("(//div[@id='displayManagePassphraseAccordionId']//div[contains(.,'Internet-Passwort')]//a)[5]");
    private By kundenKenwortPageTitle_Locator = By.xpath("//h1[contains(.,'Kunden-Kennwort ändern')]");
    private By abbrechenBtn_Locator = By.xpath("//a[@automation-id='back_Link']");
    private By teilnehmerBtn_Locator = By.xpath("//a[@automation-id='subscriberPassword_Link']");
    private By teilnehmerPageTitle_Locator = By.xpath("//h1[contains(.,'Teilnehmer-Kennwort ändern')]");
    private By kundenKontaktDatenPageTitle_Locator = By.xpath("//h1[contains(.,'Kunden-Kontaktdaten')]");
    private By rufnummernPageTitle_Locator = By.xpath("//h1[contains(.,'Rufnummern-Mitnahme')]");
    private By telefonBucheintragPageTitle_Locator = By.xpath("//h1[contains(.,'Telefonbucheintrag')]");
    private By bankVerbindungExpandedSection_Locator = By.id("wie-aendere-ich-meine-bankverbindung");
    private By bankValue_Locator = By.xpath("(//div/p/span)[3]");
    private By bicValue_Locator = By.xpath("(//div/p/span)[2]");
    private By iBanValue_Locator = By.xpath("//div[@automation-id='iban_tv']/span");
    private By kontoinhaberValue_Locator = By.xpath("(//div/p/span)[1]");
    private static By kennwörterPINsSmartObject  = By.xpath("//h3[contains(text(), 'Kennwörter & PINs')]");
    //PIN ansehen click
    private static By PINansehen_btn  = By.xpath("//button[@automation-id='view-PIN-btn_btn']");

    //cl for smart object and accordion are the same
    private static By kennwörterPINsSmartObjectTitle  = By.xpath("//h3[contains(text(), 'Kennwörter & PINs')]");
    private static By kennwörterPINsSmartObjectDetails  = By.xpath("//div[contains(text(), 'Kennwörter & PINs bearbeiten')]");
    private static By kennwörterPINsAccordionTitle  = By.xpath("//h4[contains(text(), 'Kennwörter & PINs')]");
    private static By kennwörterPINsAccordionDetails = By.xpath("//h5[contains(text(), 'Hier kannst Du Deine Kennwörter & PINs bearbeiten')]");
    private static By banNumber = By.xpath("//div[@automation-id='pageHeader_tv']//h2");



    private static By deineServicePINTitle  = By.xpath("//h4[@automation-id='pin-accordion-title_tv']");
    private static By deineServicePINDetailsFirstPart  = By.xpath("//P[@automation-id='pin-accordion-details-1_tv']");
    private static By deineServicePINDetailsSecondPart  = By.xpath("//P[@automation-id='pin-accordion-details-2_tv']");

    // in case of user exceeds 3 trials
    private static By errorTitleExceeds3Trials  = By.xpath("//h4[contains(text(), 'Dein PIN ist deaktiviert')]");

    private static By errorDetailsExceeds3Trials  = By.xpath("//p[contains(text(), 'Dein PIN ist deaktiviert. Nach 24 Stunden ist er wieder aktiv.')]");
    // in case of user has no pin
    private static By errorTitleNopin  = By.xpath("//h4[@class='flexDiv']");

    private static By errorDetailsNopin  = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    // in case of user exceeds 3 trials deep link

    private static By errorTitleExceeds3TrialsDeepLink  = By.xpath("//h4[contains(text(), 'Dein Limit ist erreicht')]");
    private static By errorDetailsExceeds3TrialsDeepLink  = By.xpath("//p[contains(text(), 'Du hast Dir Deine PIN heute schon 3x anzeigen lassen. Damit ist Dein Limit dafür erreicht. Morgen geht es wieder.')]");

    //error message in case of 500 network response
    private static By errorHeader500  = By.xpath("//h4[contains(text(), 'Entschuldigung, da ist was schiefgelaufen.')]");
    private static By errorBody500  = By.xpath("//p[contains(text(), 'Bitte versuchen Sie es später nochmal.')]");



    //Methods
    public MeinDaten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Navigate to daten schutz accordion")
    public void navigateToDatenSchutzAccordion() {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit") + "meinvodafone/services/vertragsdaten?accordion=datenschutz-einstellungen");
    }


    @Step("Get smart objects number")
    public String getSmartObjectsNumber() {
        return Integer.toString(driver.element().getElementsCount(smartObjectsCommon_Locator));
    }

    @Step("expand kontaktdaten accordion")
    public void expandKontaktDatedAcc() {
        driver.element().click(kontaktDatenAccordion_Locator);
    }

    @Step("Click on kontakt daten button")
    public void clickOnKontaktDatenBtn() {
        driver.element().click(kontaktDatenBtn_Locator);
    }

    @Step("Click on anderen button")
    public void clickOnAnderenBtn() {
        driver.element().click(andernBtn_Locator);
    }

    @Step("Click on internet zugangs button")
    public void clickOnInternetZugangsBtn() {
        driver.element().click(internetZugangsBtn_Locator);
    }

    @Step("expand adressen accordion")
    public void expandAdressenAcc() {
        driver.element().click(adressenAccordion_Locator);
    }

    @Step("expand VertragsDaten Accordion")
    public void expandVertragsDatenAccordion() {
        driver.element().click(vertragsDatenAccordion_Locator);
    }

    @Step("Expand Bank Verveindung Accordion")
    public void expandBankVerveindungAccordion() {
        driver.element().click(bankVerveindungAccordion_Locator);
    }

    @Step("Expand Kenwort accordion")
    public void expandKenwortAccordion() {
        driver.element().click(kenwortAccordion_Locator);
    }

    @Step("Expand  daten schutz accordion")
    public void expandDatenSchutzAccordion() {
        driver.element().click(datenSchutzAccordion_Locator);
    }

    @Step("Click on info icon")
    public void clickOnInfoIcon() {
        driver.element().click(firstInfoIcon);
    }

    @Step("Click informationen Von Vodafone Btn")
    public void clickInformationenVonVodafoneBtn() {
        driver.element().click(informationenVonVodafoneBtn_Locator);
    }

    @Step("Click Personaliche daten Btn")
    public void clickPersonalicheDatenBtn() {
        driver.element().click(personalicheDatenBtn_Locator);
    }

    @Step("Click verbindungs daten Btn")
    public void clickVerbindungsDatenBtn() {
        driver.element().click(verbindungsDatenBtn_Locator);
    }

    @Step("Click internetNutzung Btn")
    public void clickInernetNutzungBtn() {
        driver.element().click(internetNutzungBtn_Locator);
    }

    @Step("Click on edit bank details button")
    public void clickOnEditBankDetailsBtn() {
        driver.element().click(bankDetailsBtn_Locator);
    }

    @Step("Close notifications")
    public void closeNotification() {
        if (driver.element().getElementsCount(closeNotification_Locator) == 1) {
            driver.element().click(closeNotification_Locator);
            List<WebElement> elements = driver.getDriver().findElements(allNotificationsClose_Locator);
            for (WebElement e : elements) {
                driver.element().click(closeNotification_Locator);
            }
        }
    }

    @Step("Click on edit address button")
    public void clickOnEditAddressBtn() {
        driver.element().click(editAddressBtn_Locator);
    }

    @Step("Navigate to quick check page")
    public void navigateToQuickCheckPage() {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit") + "meinvodafone/services/teilnehmer/quickcheck");
    }

    @Step("Navigate to mein daten page")
    public void navigateToMeinDatenPage() {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit") + "meinvodafone/services/vertragsdaten");
    }

    @Step("click on internet password weiter button")
    public void clickInternetPasswortWeiterBtn() {
        driver.element().click(internetPasswortWeiterBtn_Locator);
    }

    @Step("Click on kunden-kenwort button")
    public void clickOnKundenKenwortBtn() {
        driver.element().click(kundenKenwortBtn_Locator);
    }

    @Step("Click on Bank Verbindung Link")
    public void clickBankVerbindungLink(){
        driver.element().click(bankVerbindungLinkSection_Locator);
    }

    @Step("Click on Abbrechen button")
    public void clickAbbrechenBtn() {
        driver.element().click(abbrechenBtn_Locator);
    }

    @Step("Click on Teilnehmer button")
    public void clickTeilnehmerBtn() {
        driver.element().click(teilnehmerBtn_Locator);
    }

    @Step("Click on rufnummern link")
    public void clickRufnummernLink() {
        driver.element().click(rufnummernLink_Locator);
    }

    @Step("Click on telefonbucheintrag link")
    public void clickTelefonbucheintragLink() {
        driver.element().click(telefonbucheintragLink_Locator);
    }

    //CLs
    private String infoIconText_CL = "Neuerdings verlängert sich Dein Vertrag nach Ablauf der Mindestvertragslaufzeit automatisch auf unbestimmte Zeit, aber die Kündigungsfrist beträgt nur noch 1 Monat.";

    private String bankVerbindungAccDescriptionText_CL = "Hier findest Du Deine Bankverbindungen. Du kannst zu jedem Produkt eine eigene Bankverbindung angeben.";

    private String bankVerbindungAccTitleText_CL = "Deine Bankverbindung";

    private String informationenVonVodafoneSectionText_CL = "Informationen von Vodafone";

    private String personalicheDatenSectionText_CL = "Persönliche Daten";

    private String verbindungsDatenSectionText_CL = "Verbindungsdaten";

    private String internetNutzungSectionText_CL = "Internet-Nutzung";

    private String personalicheAngeboteSectionText_CL = "Persönliche Angebote";

    private String bankDeatilsAccDescriptionText_CL = "Hier findest Du Deine Bankverbindungen. Du kannst zu jedem Produkt eine eigene Bankverbindung angeben.";

    private String bankDeatilsAccHeadLineText_CL = "Deine Bankverbindung";

    private String accOwnerNameLabelText_CL = "Kontoinhaber";

    private String iBanLabelText_CL = "IBAN";

    private String bicLabelText_CL = "BIC";

    private String bankNameLabelText_CL = "Bank";

    private String directDebitLavelText_CL = "Einzugsermächtigung";

    private String savedAddressesSectionDescriptionText_CL = "Hier kannst Du alle Adressen zu diesem Vertrag einsehen und bearbeiten.";

    private String homeZoneAddressesSectionDescriptionText_CL = "Hier kannst Du alle Zuhause-Adressen zu diesem Vertrag einsehen und bearbeiten.";
    private String teilnehmerLink_CL = "Was ist die Teilnehmer-Adresse?";

    private String einzugsermaechtigungLink_CL = "Wie erteile ich eine Einzugsermächtigung?";

    private String bankverbindungLink_CL = "Wie ändere ich meine Bankverbindung?";

    private String kundenKnotaktDatenTitle_CL = "Kunden-Kontaktdaten";

    private String loginDatenTitle_CL = "Login-Daten";

    private String rechnungsAdresseTitle_CL = "Rechnungsadresse";

    private String anschlussAdresseTitle_CL = "Anschlussadresse";

    //Validations

    @Step("Assert on Smart objects number")
    public void assertOnSmartObjectsNumber(String num) {
        Validations.verifyThat().object(getSmartObjectsNumber()).isEqualTo(num).withCustomReportMessage("assert that samrt objects number = " + num).perform();
    }

    @Step("Assert on dokumente link navigation")
    public void assertOnDokumenteLinkNavigation() {
        driver.verifyThat().element(dokumenteLink_Locator).attribute("href").contains(dokumenteLink_Link).perform();
    }

    @Step("Assert on Rufnummern link navigation")
    public void assertOnRufnummernLinkNavigation() {
        driver.verifyThat().element(rufnummernPageTitle_Locator).exists().withCustomReportMessage("Assert on rufnummern link navigation").perform();
    }

    @Step("Assert on telefon bucheintrag link navigation")
    public void assertOnTelefonBucheintragLinkNavigation() {
        driver.verifyThat().element(telefonBucheintragPageTitle_Locator).exists().withCustomReportMessage("Assert on TelefonBucheintrag link navigation").perform();
    }

    @Step("Assert on teilnehmer link navigation")
    public void assertOnTeilnehmerLinkNavigation() {
        driver.element().click(teilnehmerLink_Locator);
        driver.verifyThat().element(teilnehmerLink_Locator).attribute("class").isEqualTo("ac-head ac-active").perform();
    }

    @Step("Assert on einzugsermaechtigung link navigation")
    public void assertOnEinzugsermaechtigungLinkNavigation() {
        driver.element().click(einzugsermaechtigungLink_Locator);
        driver.verifyThat().element(einzugsermaechtigungLink_Locator).attribute("class").isEqualTo("ac-head ac-active").perform();
    }

    @Step("Assert on bankverbindung link navigation")
    public void assertOnBankverbindungLinkNavigation() {
        driver.element().click(bankverbindungLink_Locator);
        driver.verifyThat().element(bankverbindungLink_Locator).attribute("class").isEqualTo("ac-head ac-active").perform();
    }

    @Step("Assert That the kunden kontaktdaten section exists")
    public void assertThatKundenKntaktDatenSectionExist() {
        driver.verifyThat().element(kundenKnotaktDatenTitle_Locator).text().contains(kundenKnotaktDatenTitle_CL).perform();
    }

    @Step("Assert That the login daten section exists")
    public void assertThatLoginDatenSectionExist() {
        driver.verifyThat().element(loginDatenTitle_Locator).text().contains(loginDatenTitle_CL).perform();
    }

    @Step("Assert on kontakt daten button navigation")
    public void assertOnKontaktDatenBtnNavigation() {
        driver.verifyThat().element(kundenKontaktDatenPageTitle_Locator).exists().perform();

    }

    @Step("Assert on login daten button navigation")
    public void assertOnLoginDatenBtnNavigation() {
        driver.verifyThat().element(loginDatenBtn_Locator).attribute( "href").contains(loginDatenBtn_Link).perform();
    }

    @Step("Assert that rechnungsAdresse section exists")
    public void assertThatRechnungsAdresseSectionExists() {
        driver.verifyThat().element(rechnungsAdresseTitle_Locator).text().contains(rechnungsAdresseTitle_CL).perform();
    }

    @Step("Assert thatanschlussAdresse section exists")
    public void assertThatAnschlussAdresseSectionExists() {
        driver.verifyThat().element(anschlussAdresseTitle_Locator).text().contains(anschlussAdresseTitle_CL).perform();
    }

    @Step("Assert on umzug button navigation")
    public void assertOnUmzugBtnNavigation() {
        driver.verifyThat().element(umzugBtn_Locator).attribute( "href").contains(umzugBtn_Link).perform();
    }

    @Step("Assert on Anderen button navigation")
    public void assertOnAnderenBtnNavigation() {
        driver.verifyThat().element(rechnungAdressePageTitle_Locatopr).exists().perform();
    }

    @Step("Assert that gigaZuhaus section exists")
    public void assertThatGigaZuhausSectionExists() {
        driver.verifyThat().element(gigaZuhausTitle_Locator).exists().perform();
    }

    @Step("Assert that Vodafone sprache section exists")
    public void assertThatVodafoneSpracheSectionExists() {
        driver.verifyThat().element(vodafoneSpracheTitle_Locator).exists().perform();
    }

    @Step("Assert that Vodafone internet section exists")
    public void assertThatVodafoneInternetSectionExists() {
        driver.verifyThat().element(vodafoneInternetTitle_Locator).exists().perform();
    }

    @Step("Assert that Vodafone TV section exists")
    public void assertThatVodafoneTvSectionExists() {
        driver.verifyThat().element(vodafoneTvTitle_Locator).exists().perform();
    }

    @Step("Assert on info icon text")
    public void assertOnInfoIconText() {
        driver.verifyThat().element(firstInfoIconText_Locator).text().isEqualTo(infoIconText_CL).perform();
    }

    @Step("assert on bank verbindung description text")
    public void assertOnBankVerbindungDescriptionText() {
        driver.verifyThat().element(bankVerbindungAccDescription_Locator).text().isEqualTo(bankVerbindungAccDescriptionText_CL).perform();
    }

    @Step("assert on bank verbindung title text")
    public void assertOnBankVerbindungTitleText() {
        driver.verifyThat().element(bankVerbindungTitle_Locator).text().isEqualTo(bankVerbindungAccTitleText_CL).perform();
    }

    @Step("assert that einzugsermächtigung section exists")
    public void assertThatEinzugsermächtigungSectionExists() {
        driver.verifyThat().element(einzugsermächtigungSection_Locator).exists().perform();
    }

    @Step("assert that bank verbindung link section exists")
    public void assertThatBankVerbindungLinkSectionExists() {
        driver.verifyThat().element(bankVerbindungLinkSection_Locator).exists().perform();
    }

    @Step("assert that internet-passwort section exists")
    public void assertThatInternetPasswortSectionExists() {
        driver.verifyThat().element(internetPasswortSectionTilte_Locator).exists().perform();
    }

    @Step("assert that installation codes section exists")
    public void assertThatInstallationCodesSectionExists() {
        driver.verifyThat().element(installationCodesSectionTitle_Locator).exists().perform();
    }

    @Step("assert that internet zugansdaten section exists")
    public void assertThatInternetZugansDatenSectionExists() {
        driver.verifyThat().element(internetZugansDatenSectionTitle_Locator).exists().perform();
    }

    @Step("assert that kunden-kenwort section exists")
    public void assertThatKundenKenwortSectionExists() {
        driver.verifyThat().element(kundenKenwortSectionTitle_Locator).exists().perform();
    }

    @Step("assert thatTeilnehmer section exists")
    public void assertThatTeilnehmerSectionExists() {
        driver.verifyThat().element(teilnhemerSectionTitle_Locator).exists().perform();
    }

    @Step("Assert on internet passwort button navigation")
    public void assertOnInternetPasswortBtnNavigation() {
        driver.verifyThat().element(internetPasswortBtn_Locator).attribute("href").contains(internetPasswortBtn_Link).perform();
    }


    @Step("Assert on installations codes button navigation")
    public void assertOnInstallationsCodesBtnNavigation() {
        driver.verifyThat().element(installationsCodesBtn_Locator).attribute("href").contains(installationsCodesBtn_Link).perform();
    }

    @Step("Assert on internet zugangs button navigation")
    public void assertOnInternetZugangsBtnNavigation() {
        driver.verifyThat().element(internetZugangsdatenPageTitle_Locator).exists().perform();
    }

    @Step("Assert on kunden kenwort button navigation")
    public void assertOnKundenKenwortBtnNavigation() {
        driver.verifyThat().element(kundenKenwortPageTitle_Locator).exists().perform();
    }

    @Step("Assert on Teilnehmer button navigation")
    public void assertOnTeilnehmerBtnNavigation() {
        driver.verifyThat().element(teilnehmerPageTitle_Locator).exists().perform();
    }

    @Step("Assert that informationen von vodafone section exists")
    public void assertThatInformationenVonVodafoneSectionExists() {
        driver.verifyThat().element(informationenVonVodafoneSectionTitle_Locator).text().isEqualTo(informationenVonVodafoneSectionText_CL).perform();
    }

    @Step("Assert that personaliche daten section exists")
    public void assertThatPersonalicheDatenSectionExists() {
        driver.verifyThat().element(personalicheDatenSectionTitle_Locator).text().isEqualTo(personalicheDatenSectionText_CL).perform();
    }

    @Step("Assert that verbindungs daten section exists")
    public void assertThatVerbindungsDatenSectionExists() {
        driver.verifyThat().element(verbindungsDatenSectionTitle_Locator).text().isEqualTo(verbindungsDatenSectionText_CL).perform();
    }

    @Step("Assert that internet nutzung section exists")
    public void assertThatInternetNutzungSectionExists() {
        driver.verifyThat().element(internetNutzungSectionTitle_Locator).text().isEqualTo(internetNutzungSectionText_CL).perform();
    }

    @Step("Assert that personaliche angebote section exists")
    public void assertThatPersonalicheAngeboteSectionExists() {
        driver.verifyThat().element(personalicheAngeboteSectionTitle_Locator).text().isEqualTo(personalicheAngeboteSectionText_CL).perform();
    }

    @Step("Assert on informationen von vodafone button navigation")
    public void assertOnInformationenVonVodafoneBtnNavigation() {
        driver.verifyThat().element(datenSchutzPageAccordionTitle_Locator).text().isEqualTo(informationenVonVodafoneSectionText_CL).perform();
    }

    @Step("Assert on personaliche daten button navigation")
    public void assertOnPersonalicheDatenBtnNavigation() {
        driver.verifyThat().element(datenSchutzPageAccordionTitle_Locator).text().isEqualTo(personalicheDatenSectionText_CL).perform();
    }

    @Step("Assert on verbindungs daten button navigation")
    public void assertOnVerbindungsDatenBtnNavigation() {
        driver.verifyThat().element(datenSchutzPageAccordionTitle_Locator).text().isEqualTo(verbindungsDatenSectionText_CL).perform();
    }

    @Step("Assert on internet nutzung button navigation")
    public void assertOnInternetNutzungBtnNavigation() {
        driver.verifyThat().element(datenSchutzPageAccordionTitle_Locator).text().isEqualTo(internetNutzungSectionText_CL).perform();
    }

    @Step("Assert on bank details description text")
    public void assertOnBankDetailsDescriptionText() {
        driver.verifyThat().element(bankDeatilsAccDescription_Locator).text().isEqualTo(bankDeatilsAccDescriptionText_CL).perform();
    }

    @Step("Assert on bank details headline text")
    public void assertOnBankDetailsHeadLineText() {
        driver.verifyThat().element(bankDeatilsAccHeadLine_Locator).text().isEqualTo(bankDeatilsAccHeadLineText_CL).perform();
    }

    @Step("Assert on account owner label text")
    public void assertOnAccOwnerNameLabelText() {
        driver.verifyThat().element(accOwnerNameLabel_Locator).text().isEqualTo(accOwnerNameLabelText_CL).perform();
    }

    @Step("Assert on IBAN label text")
    public void assertOnIbanLabelText() {
        driver.verifyThat().element(iBanLabel_Locator).text().isEqualTo(iBanLabelText_CL).perform();
    }

    @Step("Assert on BIC label text")
    public void assertOnBicLabelText() {
        driver.verifyThat().element(bicLabel_Locator).text().isEqualTo(bicLabelText_CL).perform();
    }

    @Step("Assert on Bank name label text")
    public void assertOnBankNameLabelText() {
        driver.verifyThat().element(bankNameLabel_Locator).text().isEqualTo(bankNameLabelText_CL).perform();
    }

    @Step("Assert on direct debit label text")
    public void assertOnDirectDebitLabelText() {
        driver.verifyThat().element(directDebitLabel_Locator).text().isEqualTo(directDebitLavelText_CL).perform();
    }

    @Step("Assert that bank details button exists")
    public void assertThatBankDetailsBtnExists() {
        driver.verifyThat().element(bankDetailsBtn_Locator).exists().perform();
    }

    @Step("Assert on bank details link out navigation")
    public void assertOnBankDetailsLinkOutNavigation() {
        driver.element().click(bankDetailsLinkOut_Locator);
        driver.verifyThat().element(bankverbindungLink_Locator).attribute("class").isEqualTo("ac-head ac-active").perform();

    }

    @Step("Assert that saved addresses section exists")
    public void assertThatSavedAddressesSectionExists() {
        driver.verifyThat().element(savedAddressesSectionDescription_Locator).text().isEqualTo(savedAddressesSectionDescriptionText_CL).perform();
    }

    @Step("Assert that home zone addresses section exists")
    public void assertThatHomeZoneAddressesSectionExists() {
        driver.verifyThat().element(homeZoneAddressesSectionDescription_Locator).text().isEqualTo(homeZoneAddressesSectionDescriptionText_CL).perform();
    }

    @Step("Assert on edit address button navigation")
    public void assertOnEditAddressBtnNavigation() {
        driver.verifyThat().element(editAddressPageTitle_Locator).exists().perform();
    }

    @Step("Assert on bank verbindung link navigation")
    public void assertOnBankVerbindungLinkNavigation() {
        driver.verifyThat().element(bankVerbindungExpandedSection_Locator).attribute("class").isEqualTo("ac-head ac-active").perform();
    }

    public void assertOnKontoinhaberValue(String value){
        driver.verifyThat().element(kontoinhaberValue_Locator).text().contains(value).withCustomReportMessage("Assert on Kontoinhaber value").perform();
    }


    public void assertOnIbanValue(String value){
        driver.verifyThat().element(iBanValue_Locator).text().contains(value).withCustomReportMessage("Assert on IBAN value").perform();
    }

    public void assertOnBicValue(String value){
        driver.verifyThat().element(bicValue_Locator).text().contains(value).withCustomReportMessage("Assert on BIC value").perform();
    }

    public void assertOnBankValue(String value){
        driver.verifyThat().element(bankValue_Locator).text().contains(value).withCustomReportMessage("Assert on Bank value").perform();
    }

    // smart object validations
    @Step("Validate KennwörterPINsSmartObject")
    public MeinDaten validateKennwörterPINsSmartObject(String expectedKennwörterPINsSmartObjectTitle, String expectedKennwörterPINsSmartObjectDetails) {
        driver.verifyThat()
                .element(kennwörterPINsSmartObjectTitle)
                .text()
                .contains(expectedKennwörterPINsSmartObjectTitle)
                .perform();
        driver.verifyThat()
                .element(kennwörterPINsSmartObjectDetails)
                .text()
                .contains(expectedKennwörterPINsSmartObjectDetails)
                .perform();
        return this;
    }
    @Step("Validate KennwörterPINsSmartObjectDetails")
    public MeinDaten validateKennwörterPINsSmartObjectDetails(String expectedKennwörterPINsSmartObjectDetails) {
        driver.verifyThat()
                .element(kennwörterPINsSmartObjectDetails)
                .text()
                .contains(expectedKennwörterPINsSmartObjectDetails)
                .perform();
        return this;
    }
    //accordion validations
    @Step("Validate validateKennwörterPINsAccordion")
    public MeinDaten validateKennwörterPINsAccordion(String expectedKennwörterPINsAccordionTitle, String expectedKennwörterPINsAccordionDetails) {
        driver.verifyThat()
                .element(kennwörterPINsAccordionTitle)
                .text()
                .contains(expectedKennwörterPINsAccordionTitle)
                .perform();
        driver.verifyThat()
                .element(kennwörterPINsAccordionDetails)
                .text()
                .contains(expectedKennwörterPINsAccordionDetails)
                .perform();
        return this;
    }
    @Step("Validate KennwörterPINsAccordionDetails")
    public MeinDaten validateKennwörterPINsAccordionDetails(String expectedKennwörterPINsAccordionDetails) {
        driver.verifyThat()
                .element(kennwörterPINsAccordionDetails)
                .text()
                .contains(expectedKennwörterPINsAccordionDetails)
                .perform();
        return this;
    }
    @Step("Validate BanNumber exist")
    public MeinDaten validateBanNumberExist() {
        driver.element().assertThat(banNumber).exists().perform();
        return this;
    }
    // validate Deine Service PIN (normal case)
    @Step("Validate validateDeineServicePIN")
    public MeinDaten validateDeineServicePIN(String expectedDeineServicePINTitle, String expectedDeineServicePINDetailsFirstPart, String expectedDeineServicePINDetailsSecondPart) {
        driver.verifyThat()
                .element(deineServicePINTitle)
                .text()
                .contains(expectedDeineServicePINTitle)
                .perform();
        driver.verifyThat()
                .element(deineServicePINDetailsFirstPart)
                .text()
                .contains(expectedDeineServicePINDetailsFirstPart)
                .perform();
        driver.verifyThat()
                .element(deineServicePINDetailsSecondPart)
                .text()
                .contains(expectedDeineServicePINDetailsSecondPart)
                .perform();
        return this;
    }
    @Step("Validate DeineServicePINDetailsfirstPart")
    public MeinDaten validateDeineServicePINDetailsFirstPart(String expectedDeineServicePINDetailsFirstPart) {
        driver.verifyThat()
                .element(deineServicePINDetailsFirstPart)
                .text()
                .contains(expectedDeineServicePINDetailsFirstPart)
                .perform();
        return this;
    }
    @Step("Validate DeineServicePINDetailsSecodPart")
    public MeinDaten validateDeineServicePINDetailsSecondPart(String expectedDeineServicePINDetailsSecondPart) {
        driver.verifyThat()
                .element(deineServicePINDetailsSecondPart)
                .text()
                .contains(expectedDeineServicePINDetailsSecondPart)
                .perform();
        return this;
    }
    // validate Deine Service PIN in case of user exceeds 3 trials
    @Step("Validate ErrorExceeds3Trials")
    public MeinDaten validateErrorExceeds3Trials(String expectedErrorTitleExceeds3Trials, String expectedErrorDetailsExceeds3Trials) {
        driver.verifyThat()
                .element(errorTitleExceeds3Trials)
                .text()
                .contains(expectedErrorTitleExceeds3Trials)
                .perform();
        driver.verifyThat()
                .element(errorDetailsExceeds3Trials)
                .text()
                .contains(expectedErrorDetailsExceeds3Trials)
                .perform();
        return this;
    }
    @Step("Validate ErrorDetailsExceeds3Trials")
    public MeinDaten validateErrorDetailsExceeds3Trials(String expectedErrorDetailsExceeds3Trials) {
        driver.verifyThat()
                .element(errorDetailsExceeds3Trials)
                .text()
                .contains(expectedErrorDetailsExceeds3Trials)
                .perform();
        return this;
    }
    //validate Deine Service PIN in case of user has no pin

    @Step("Validate ErrorNopin")
    public MeinDaten validateErrorNopin(String expectedErrorTitleNopin, String expectedErrorDetailsNopin) {
        driver.verifyThat()
                .element(errorTitleNopin)
                .text()
                .contains(expectedErrorTitleNopin)
                .perform();
        driver.verifyThat()
                .element(errorDetailsNopin)
                .text()
                .contains(expectedErrorDetailsNopin)
                .perform();
        return this;
    } @Step("Validate ErrorDetailsNopin")
    public MeinDaten validateErrorDetailsNopin(String expectedErrorDetailsNopin) {
        driver.verifyThat()
                .element(errorDetailsNopin)
                .text()
                .contains(expectedErrorDetailsNopin)
                .perform();
        return this;
    }
    // validate Deine Service PIN in case of user exceeds 3 trials (DEEP LINK)

    @Step("Validate ErrorTitleExceeds3TrialsDeepLink")
    public MeinDaten errorTitleExceeds3TrialsDeepLinkDeepLink(String expectedErrorTitleExceeds3TrialsDeepLink, String expectedErrorDetailsExceeds3TrialsDeepLink) {
        driver.verifyThat()
                .element(errorTitleExceeds3TrialsDeepLink)
                .text()
                .contains(expectedErrorTitleExceeds3TrialsDeepLink)
                .perform();
        driver.verifyThat()
                .element(errorDetailsExceeds3TrialsDeepLink)
                .text()
                .contains(expectedErrorDetailsExceeds3TrialsDeepLink)
                .perform();
        return this;
    }
    @Step("Validate ErrorDetailsExceeds3TrialsDeepLink")
    public MeinDaten validateErrorDetailsExceeds3TrialsDeepLink(String expectedErrorDetailsExceeds3TrialsDeepLink) {
        driver.verifyThat()
                .element(errorDetailsExceeds3TrialsDeepLink)
                .text()
                .contains(expectedErrorDetailsExceeds3TrialsDeepLink)
                .perform();
        return this;
    }
    // validate error message in case of network response 403
    @Step("Validate ErrorHeader in case of network status 403")
    public MeinDaten errorMessageTitle403(String expectederrorHeader403, String expectederrorBody403) {
        driver.verifyThat()
                .element(errorHeader500)
                .text()
                .contains(expectederrorHeader403)
                .perform();
        driver.verifyThat()
                .element(errorBody500)
                .text()
                .contains(expectederrorBody403)
                .perform();
        return this;
    }
    @Step("Validate ErrorBody in case of network status 403")
    public MeinDaten errorMessageBody500(String expectederrorBody500) {
        driver.verifyThat()
                .element(errorBody500)
                .text()
                .contains(expectederrorBody500)
                .perform();
        return this;
    }
    // validate PINansehen_btn name
    @Step("Validate PINansehen_btn name")
    public MeinDaten validatePINansehenBtn(String expectedPINansehenBtn) {
        driver.verifyThat()
                .element(PINansehen_btn)
                .text()
                .contains(expectedPINansehenBtn)
                .perform();
        return this;
    }

    @Step("deeplink to mein daten in case")
    public MeinDaten deepLinkToServicePin() {
        driver.browser().switchToNewTab("https://simplicity.wf-de.vodafone.com/meinvodafone/services/vertragsdaten/ansehen-servicePIN");
        return this;
    }
    @Step("Click on KennwörterPINsSmartObject")
    public MeinDaten clickKennwörterPINsSmartObject() {
        driver.element().click(kennwörterPINsSmartObject);
        try{
            Thread.sleep(10000);
        } catch (Exception e) {
        }
        return this;
    }
    @Step("Click on KennwörterPINsSmartObject")
    public MeinDaten clickPINansehen() {
        driver.element().click(PINansehen_btn);
        return this;
    }

}
