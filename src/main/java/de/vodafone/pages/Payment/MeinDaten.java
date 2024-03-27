package de.vodafone.pages.Payment;


import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

public class MeinDaten {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
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
    private By bankVerveindungAccordion_Locator = By.xpath("//div[@automation-id='bankDetails_so']");
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
    private By internetPasswortBtn_Locator = By.xpath("(//a[@class='btn btn-em mb-0'])[1]");
    private By installationsCodesBtn_Locator = By.xpath("(//a[@class='btn btn-em mb-0'])[2]");
    private By bankAccordionNotificationHL_AutoTopUP = By.xpath("//div[@class='alert noselect inProgress']//h4");
    private By bankAccordionNotificationHL_NoIBAN = By.xpath("//h4[@class='flexDiv'][contains(.,'Du willst eine automatische Aufladung per Lastschrift einrichten?')]");

    private By bankAccordionNotificationBody_AutoTopUp = By.xpath("//div[@class='alert noselect inProgress']//p");
    private By bankAccordionNotificationBody_NoAutoTopUp = By.xpath("//p[@class='notification-text mb-10 mt-10'][contains(.,'Das geht ganz einfach: Klick unten auf den Button und richte die automatische Aufladung mit der Bezahlmethode Sofort mit Deiner neuen')]");
    private By bankAccordionNotificationBody_NoIBAN = By.xpath("//p[@class='notification-text mb-10 mt-10'][contains(.,'Hast Du schon eine automatische Aufladung ohne Bankverbindung aktiviert (z. B. mit PayPal)? Dann musst Du diese zuerst löschen. Erst danach kannst Du die neue Aufladung wie oben beschrieben einrichten.')]");
    private By bankAccordionCTABtn = By.xpath("//*[@type='mobile']//span//a[@class='btn btn-sml']");
    private By errorFailedBankServiceNotification_HL = By.xpath("//div[@automation-id='bankDetailsError_nt']//h4");

    private By errorFailedBankServiceNotification_Body = By.xpath("//div[@automation-id='bankDetailsError_nt']//p");
    private By errorNotificationDiv = By.xpath("//div[@automation-id='bankDetailsError_nt']");
    private By notificationDiv = By.xpath("//div[@class='alert noselect inProgress']");

    //Methods
    public MeinDaten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
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

    @Step("expand adressen accordion")
    public void expandAdressenAcc() {
        driver.element().click(adressenAccordion_Locator);
    }

    @Step("expand VertragsDaten Accordion")
    public void expandVertragsDatenAccordion() {
        driver.element().click(vertragsDatenAccordion_Locator);
    }

    @Step("Expand Bank VerveindungAccordion")
    public void expandBankVerveindungAccordion() {
        driver.element().click(bankVerveindungAccordion_Locator);
    }

    @Step("Expand Kenwort accordion")
    public void expandKenwortAccordion() {
        driver.element().click(kenwortAccordion_Locator);
    }

    @Step("Click on info icon")
    public void clickOnInfoIcon() {
        driver.element().click(firstInfoIcon);
    }

    //CLs
    private String infoIconText_CL = "Neuerdings verlängert sich Dein Vertrag nach Ablauf der Mindestvertragslaufzeit automatisch auf unbestimmte Zeit, aber die Kündigungsfrist beträgt nur noch 1 Monat.";

    private String bankVerbindungAccDescriptionText_CL = "Hier findest Du Deine Bankverbindungen. Du kannst zu jedem Produkt eine eigene Bankverbindung angeben.";

    private String bankVerbindungAccTitleText_CL = "Deine Bankverbindung";
    private String bankVerbindunAccAutoTopUpNotificationHL_CL = "Du willst Deine Bankverbindung ändern?";
    private String bankVerbindunAccAutoTopUpNotificationBody_CL = "Das geht ganz einfach: Klick unten auf den Button und lösch zuerst Deine bestehende Bezahlmethode für die automatische Aufladung. Aktiviere als nächstes eine neue automatische Aufladung mit der Bezahlmethode Sofort mit Deiner neuen Bankverbindung. Achte darauf, dass Du die Bezahlmethode speicherst. Das Feld dafür ist schon automatisch ausgewählt. Danach kannst Du Deine Bankverbindung hier in der Übersicht sehen.";
    private String bankServiceFailureNotification_HL = "Das hat leider nicht geklappt";
    private String bankServiceFailureNotification_Body = "Entschuldige bitte, das war unser Fehler. Versuch es bitte später nochmal.";


    //Methods
    @Step("Clicks On Bank Accordion Notification Button and Navigates User To GPP")
    public void clicksOnBankAccordionCTAButtonAndRedirectedToGPP() {
        driver.element().click(bankAccordionCTABtn);
    }

    @Step("Click On Bankverbindung CTA Button")
    public void clickBankAccordionCTABtn_IBAN_AutoTopUp() {
        driver.element().click(bankAccordionCTABtn);
    }


    //Validations
    @Step("Assert on Smart objects number")
    public void assertOnSmartObjectsNumbre(String num) {
        SHAFT.Validations.verifyThat().object(getSmartObjectsNumber()).isEqualTo(num).withCustomReportMessage("assert that samrt objects number = " + num).perform();
    }

    @Step("Assert on dokumente link")
    public void assertOnDokumenteLink() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(dokumenteLink_Locator)).isEqualTo("Dokumente").perform();
    }

    @Step("Assert on Rufnummern link")
    public void assertOnRufnummernLink() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(rufnummernLink_Locator)).isEqualTo("Rufnummern-Mitnahme zu einem anderen Anbieter").perform();
    }

    @Step("Assert on telefon bucheintrag link")
    public void assertOnTelefonBucheintragLink() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(telefonbucheintragLink_Locator)).isEqualTo("Telefonbucheintrag anlegen, ändern oder löschen").perform();
    }

    @Step("Assert on teilnehmer link ")
    public void assertOnTeilnehmerLink() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(teilnehmerLink_Locator)).isEqualTo("Was ist die Teilnehmer-Adresse?").perform();
    }

    @Step("Assert on einzugsermaechtigung link")
    public void assertOnEinzugsermaechtigungLink() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(einzugsermaechtigungLink_Locator)).isEqualTo("Wie erteile ich eine Einzugsermächtigung?").perform();
    }

    @Step("Assert on bankverbindung link")
    public void assertOnBankverbindungLink() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(bankverbindungLink_Locator)).isEqualTo("Wie ändere ich meine Bankverbindung?").perform();
    }

    @Step("Assert That the kunden kontaktdaten section exists")
    public void assertThatKundenKntaktDatenSectionExist() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(kundenKnotaktDatenTitle_Locator)).contains("Kunden-Kontaktdaten").perform();
    }

    @Step("Assert That the login daten section exists")
    public void assertThatLoginDatenSectionExist() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(loginDatenTitle_Locator)).contains("Login-Daten").perform();
    }

    @Step("Assert on kontakt daten button navigation")
    public void assertOnKontaktDatenBtnNavigation() {
        SHAFT.Validations.verifyThat().object(driver.browser().getCurrentURL()).contains("kontaktdaten/kunden-kontaktdatendsl").perform();

    }

    @Step("Assert on login daten button navigation")
    public void assertOnLoginDatenBtnNavigation() {
        SHAFT.Validations.verifyThat().object(driver.element().getAttribute(loginDatenBtn_Locator, "href")).contains("/meinvodafone/account/verwaltung/ueberblick?accordion=manageAccountData").perform();
    }

    @Step("Assert that rechnungsAdresse section exists")
    public void assertThatRechnungsAdresseSectionExists() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(rechnungsAdresseTitle_Locator)).contains("Rechnungsadresse").perform();
    }

    @Step("Assert thatanschlussAdresse section exists")
    public void assertThatAnschlussAdresseSectionExists() {
        SHAFT.Validations.verifyThat().object(driver.element().getText(anschlussAdresseTitle_Locator)).contains("Anschlussadresse").perform();
    }

    @Step("Assert on umzug button navigation")
    public void assertOnUmzugBtnNavigation() {
        SHAFT.Validations.verifyThat().object(driver.element().getAttribute(umzugBtn_Locator, "href")).contains("https://dsl.vodafone.de/vfksc/umz/umz_auswahl.html").perform();
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
        driver.verifyThat().element(firstInfoIconText_Locator).textTrimmed().isEqualTo(infoIconText_CL).perform();
    }

    @Step("assert on bank verbindung description text")
    public void assertOnBankVerbindungDescriptionText() {
        driver.verifyThat().element(bankVerbindungAccDescription_Locator).textTrimmed().isEqualTo(bankVerbindungAccDescriptionText_CL).perform();
    }

    @Step("assert on bank verbindung title text")
    public void assertOnBankVerbindungTitleText() {
        driver.verifyThat().element(bankVerbindungTitle_Locator).textTrimmed().isEqualTo(bankVerbindungAccTitleText_CL).perform();
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

    @Step("Assert on internet passwort button navigation")
    public void assertOnInternetPasswortBtnNavigation() {
        driver.verifyThat().element(internetPasswortBtn_Locator).attribute("href").contains("/meinvodafone/account/verwaltung/ueberblick?accordion=manageAccountData").perform();
    }

    @Step("Assert on installations codes button navigation")
    public void assertOnInstallationsCodesBtnNavigation() {
        driver.verifyThat().element(installationsCodesBtn_Locator).attribute("href").contains("/meinvodafone/services/installationscode/installationscode-anfordern").perform();
    }


    public void assertOnbankVerbindunAccordionAutoTopUpNotificationHL_CL(String autoTopUpNotificationHL) {
        driver.verifyThat().element(bankAccordionNotificationHL_AutoTopUP).textTrimmed().isEqualTo(autoTopUpNotificationHL)
                .withCustomReportMessage("Assert On BankVerbindun Accordion Auto TopUp Notification HL_CL").perform();
    }


    public void assertOnbankVerbindunAccordionAutoTopUpNotificationBody_CL(String autoTopUpNotificationBody) {
        driver.verifyThat().element(bankAccordionNotificationBody_AutoTopUp).textTrimmed().contains(autoTopUpNotificationBody)
                .withCustomReportMessage("Assert On BankVerbindun Accordion Auto TopUp Notification Body_CL")
                .perform();
    }


    public void assertOnBankVerbindunAccAutoTopUpBtnText(String bankAccordionCTA) {
        driver.element().waitUntilElementTextToBe(bankAccordionCTABtn,bankAccordionCTA);
        driver.verifyThat().element(bankAccordionCTABtn).textTrimmed().isEqualTo(bankAccordionCTA)
                .withCustomReportMessage("Assert On BankVerbindun Accordion CTA Button Text")
                .perform();
    }


    public void assertThatBankAccordionCTADoesNotExist() {
        driver.verifyThat().element(bankAccordionCTABtn).doesNotExist()
                .withCustomReportMessage("Assert That Bank Accordion CTA Does Not Exist").perform();
    }


    public void assertOnBankServiceFailureNotification_HL() {
        Actions actions = new Actions(driver.getDriver());
        actions.keyDown(Keys.CONTROL)
                .keyDown(Keys.SHIFT)
                .sendKeys("r")
                .keyUp(Keys.CONTROL)
                .keyUp(Keys.SHIFT)
                .build()
                .perform();
        driver.verifyThat().element(errorFailedBankServiceNotification_HL).textTrimmed()
                .isEqualTo(bankServiceFailureNotification_HL)
                .withCustomReportMessage("Assert On Bank Details Service Failure Notification Headline").perform();
    }


    public void assertOnBankServiceFailureNotification_Body() {
        driver.verifyThat().element(errorFailedBankServiceNotification_Body).textTrimmed()
                .isEqualTo(bankServiceFailureNotification_Body)
                .withCustomReportMessage("Assert On Bank Details Service Failure Notification Body").perform();
    }

    public void assertOnErrorNotificationDoesNotExist(){
        driver.verifyThat().element(errorNotificationDiv).doesNotExist()
                .withCustomReportMessage("Assert On Error Notification Does Not Exist").perform();
    }

    public void assertThatTheNotificationDoesNotExist() {
        driver.verifyThat().element(notificationDiv).doesNotExist()
                .withCustomReportMessage("Assert That The Notification Does Not Exist").perform();
    }


}
