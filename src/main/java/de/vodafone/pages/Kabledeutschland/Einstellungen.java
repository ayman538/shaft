package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Einstellungen {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By pageHeader_Locator = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By subTitle_Locator = By.xpath("//cable-bills-list/p");
    private By editSectionHeader_Locator = By.xpath("//h3[@automation-id='itemizedBillSingleNumberDataHeadline_tv']");
    private By editSectionUpperDescription_Locator = By.xpath("//p[@automation-id='itemizedBillSingleNumberDataText_tv']");
    private By editSectionMiddleDescription_Locator = By.xpath("//p[@automation-id='itemizedBillSingleNumberDataBillNumber_tv']");
    private By editSectionLowerDescription_Locator = By.xpath("//p[@automation-id='itemizedBillSingleNumberDataDisplayText_tv']");
    private By bearbeitenBtn_Locator = By.xpath("//button[@automation-id='itemizedBillSingleNumberDataButton_btn']");
    private By optionSectionTitle_Locator = By.xpath("//div[@class='tg-head tg-active']/span");
    private By blackMessageText_Locator = By.xpath("//div[@automation-id='itemNotSelected_tv']");
    private By keineEinzelverbindungenOption_Locator = By.xpath("(//radio-item)[1]");
    private By umDieLetzten3ZiffernGekurztOption_Locator = By.xpath("(//radio-item)[2]");
    private By vollstandigOption_Locator = By.xpath("(//radio-item)[3]");
    private By shortenedOption_Locator = By.xpath("(//radio-item)[2]");
    private By noIndividualOption_Locator = By.xpath("(//radio-item)[1]");
    private By anderungenSpeichernBtn_Locator = By.xpath("//button[@automation-id='singleButton_btn']");
    private By checkbox_Locator = By.xpath("//input[@automation-id='checkboxItemModel.id_tv']");
    private By checkboxMessageHeader_Locator = By.xpath("//div[@automation-id='checkboxText_chk']");
    private By checkboxMessageBody_Locator = By.xpath("//div[@automation-id='checkboxBody_chk']");
    private By optionsCommon_Locator = By.xpath("//input[@id='undefined']");
    private By errorNotificationTitle_Locator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By errorNotificationDescription_Locator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By itemizedBillSection_Locator = By.xpath("//div[@automation-id='itemizedBillSingleNumberData_tv']");
    //WFCT_12502
    private By invoiceTypeSectionHeader_Locator = By.xpath("//*[@automation-id='invoiceTypeHeadline_tv']");
    private By onlineTypeLabel_Locator = By.xpath("//p[text()='Online-Rechnung']");
    private By paperTypeLabel_Locator = By.xpath("//p[text()='Papier-Rechnung']");
    private By paperAndOnlineTypeLabel_Locator = By.xpath("//p[text()='Online- und Papier-Rechnung']");
    private By toolTipText_locator = By.xpath("//div[@class='tooltip-dialog']/div");
    private By emailSectionHeader_Locator = By.xpath("//*[@automation-id='emailHeadlineKD_tv']");
    private By emailSectionSubTitle_Locator = By.xpath("//*[@automation-id='emailSubHeadlineKD_tv']");
    private By emailAddressLabel_Locator = By.xpath("(//*[@automation-id='emailAdressKD_tv']/span)[1]");
    private By emailAddressValue_Locator = By.xpath("(//*[@automation-id='emailAdressKD_tv']/span)[2]");
    private By checkIcon_Locator = By.xpath("//*[@automation-id='emailCheckKD_tv']");
    private By crossIcon_Locator = By.xpath("//*[@automation-id='emailXKD_tv']");
    private By emailStatus_Locator = By.xpath("//*[@class='ml-10']");
    private By emailAddressBearbeitenBtn_Locator = By.xpath("//*[text()='E-Mail-Adresse bearbeiten']");
    private By benachrichtigungDeaktivierenBtn_Locator = By.xpath("//*[@automation-id='deactivateNotificationKD_btn']");
    private By editEmailPageHeader_Locator = By.xpath("//h1[contains(.,'Kunden-Kontaktdaten')]");
    private By editNotificationSettingsPageHeader_Locator = By.xpath("//h1[contains(.,'E-Mail-Benachrichtigung')]");
    private By sendNewConfirmationPageHeader_Locator = By.xpath("//h1[contains(.,'Neue Bestätigungs-Mail anfordern')]");
    private By onlineRadioBtn_Locator = By.id("onlineBill");
    private By paperRadioBtn_Locator = By.id("paperBill");
    private By paperAndOnlineRadioBtn_Locator = By.id("paperAndOnlineBill");
    private By anderungSpeichernBtn_Locator = By.xpath("//*[@automation-id='changeInvoiceTypeKD_btn']");
    private By billTypeSectionHeader_Locator = By.xpath("//*[@automation-id='paperInvoiceHeadline_tv']");
    private By billTypeSectionDescription_Locator = By.xpath("//*[@automation-id='paperInvoiceSubHeadline_tv']");
    private By billTypeSectionNotificationText_Locator = By.xpath("//*[@automation-id='invoicePaperNotificationKD_nt']//*[@class='notification-text']");
    private By billTypeSectionNotificationLink_Locator = By.xpath("//*[@automation-id='invoicePaperNotificationKD_nt']//*[@class='link1a']");
    private By notActivatedNotificationText_Locator = By.xpath("//*[@automation-id='deactivatedNotificationKD_nt']//h4");
    private By benachrichtigungAktivierenBtn_Locator = By.xpath("//*[@automation-id='editEmailKDNotification_btn']");
    private By noEmailValueText_Locator = By.xpath("//span[@class='i-red']");
    private By changeToOnlineNotificationHeader_Locator = By.xpath("//*[@automation-id='changeToOnlineNotificationKD_nt']//h4");
    private By changeToOnlineNotificationDescription_Locator = By.xpath("//*[@automation-id='changeToOnlineNotificationKD_nt']//p");
    private By confirmationNotificationHeader_Locator = By.xpath("//*[@automation-id='changeToOnlineSuccessKD_nt']//h4");
    private By confirmationNotificationDescription_Locator = By.xpath("//*[@automation-id='changeToOnlineSuccessKD_nt']//p");
    private By dispatchErrorNotificationHeader_Locator = By.xpath("//*[@automation-id='invoiceSettingsErrorKD_nt']//h4");
    private By dispatchErrorNotificationDescription_Locator = By.xpath("//*[@automation-id='invoiceSettingsErrorKD_nt']//p");
    private By paperAndOnlineNotification_Locator = By.xpath("//*[@automation-id='changeToOnlineNotificationKD_nt']//p");
    private By notVerifiedEmailNotificationHeader_Locator = By.xpath("//*[@automation-id='nonVerifiedEmailNotificationKD_nt']//h4");
    private By notVerifiedEmailNotificationDescription_Locator = By.xpath("//*[@automation-id='nonVerifiedEmailNotificationKD_nt']//p");
    private By neueBestatigungsmailBekommenBtn_Locator = By.xpath("//*[@automation-id='resendEmailKD_btn']");
    private By noEmailNotificationHeader_Locator = By.xpath("//*[@automation-id='noEmailNotificationKD_nt']//h4");
    private By noEmailNotificationDescription_Locator = By.xpath("//*[@automation-id='noEmailNotificationKD_nt']//p");
    private By emailAdresseEintragenBtn_Locator = By.xpath("//*[@automation-id='noEmailNotificationKD_btn']");
    private By billTypeLabel_Locator = By.xpath("//*[@automation-id='itemizedBillSingleNumberDataBillNumberTExt_tv']");
    private By bearbeitenInMeinKabel_Locator = By.xpath("//*[@automation-id='itemizedBillSingleNumberDataButton_Link']");
    private By settingsOptionsAccordion_Locator = By.xpath("//div[@class='tg-accord tg-accord-lrg simple-accord ecare-accord']");
    private By billTypeSection_Locator = By.xpath("//div[@class='white-box mt-10']");
    private By productAndItemizedErrorNotificationTitle_Locator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By productAndItemizedErrorNotificationBody_Locator = By.xpath("(//div[@automation-id='successMsg_tv']/p)[1]");
    private By productAndItemizedErrorNotification_Locator = By.xpath("//div[@automation-id='itemizedBillErrorNotification_nt']");

    /* *******WFCT-12607***** */
    private By invoiceSettings_Rechnungseinstellungen_Locator = By.xpath("//a[@automation-id='Einstellungen_Link']");
    private By invoiceTypeHeaderLocator = By.xpath("//*[@automation-id='invoiceTypeHeadline_tv']");
    private By invoiceEmailHeaderLocator = By.xpath("//strong[@automation-id='emailHeadlineKD_tv']");
    private By invoiceEmailBodyLocator = By.xpath("//p[@automation-id='emailSubHeadlineKD_tv']");
    private By emailAddressLocator = By.xpath("//p[@automation-id='emailAdressKD_tv']/span[1]");
    private By emailAddressColorLocator = By.xpath("//span[@class='i-green']");
    private By emailAddressVerifiedLocator = By.xpath("//span[@class='ml-10']");
    private By invoiceTypeLocator = By.xpath("//*[@automation-id='onlineInvoiceTextKD_tv']");
    private By editCTALocator = By.xpath("//button[@automation-id='deactivateNotificationKD_btn']");
    private By editCTALocator_ActivateBtn = By.xpath("//a[@automation-id='editEmailKDNotification_btn']");
    private By backBtn = By.xpath("//a[@automation-id='back_Link']");
    private By noBillNotification = By.xpath("//div[@class='item-2 w-100']/h4");
    private By editAddressAccordion_Locator = By.xpath("//accordion[@id='adressen']//li/a");



    //CL
    private String pageHeader_CL = "Meine Rechnungen";
    private String subTitle_CL = "Hier findest Du alles zu Deinen Rechnungen";
    private String editSectionHeader_CL = "Einzelverbindungsnachweise";
    private String editSectionUpperDescription_CL = "Du kannst Einzelverbindungsnachweise nur für Anrufe bekommen, durch die zusätzliche Kosten entstanden sind, z.B. für Sonderrufnummern oder Auslandsgespräche.";
    private String editSectionMiddleDescription_CL = "Hier kannst Du bearbeiten, welche Art des Einzelverbindungsnachweises Du bekommst. Deine Änderungen werden für alle Rufnummern dieses Kontos übernommen. Deine aktuelle Einstellung:";
    private String optionSectionTitle_CL = "Art des Verbindungsnachweises";
    private String blackMessage_CL = "Auf dem Einzelverbindungsnachweis sollen meine Verbindungen so angezeigt werden:";
    private String checkboxMessageHeader_CL = "Mitbenutzer:innen-Erklärung";
    private String checkboxMessageBody_CL = "Ich habe alle aktuellen Mitbenutzer:innen des Anschlusses darüber informiert, dass ich einen Einzelverbindungsnachweis bekomme. Jede:n neue:n Mitbenutzer:in werde ich auch sofort darüber informieren.";
    private String errorNotificationTitle_CL = "Das hat leider nicht geklappt";
    private String errorNotificationDescription_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private String onlineType_CL = "Online-Rechnung";
    private String paperType_CL = "Papier-Rechnung";
    private String paperAndOnlineType_CL = "Online- und Papier-Rechnung";
    private String toolTip_CL = "Du möchtest wieder Papier-Rechnungen bekommen? Meld Dich einfach beim Kundenservice.";
    private String invoiceTypeSectionHeader_CL = "Du bekommst Deine Rechnung als:";
    private String emailSectionHeader_CL = "Deine Rechnungsbenachrichtigung";
    private String emailSectionSubTitle_CL = "Wenn eine neue Rechnung da ist, schicken wir Dir eine E-Mail.";
    private String emailAddressLabel_CL = "E-Mail-Adresse:";
    private String emailVerified_CL = "E-Mail-Adresse verifiziert";
    private String emailNotVerified_CL = "E-Mail-Adresse nicht verifiziert";
    private String billTypeSectionHeader_CL = "Deine Rechnungsart";
    private String billTypeSectionDescription_CL = "Im Moment senden wir Dir die Papier-Rechnung an Deine Rechnungsadresse.";
    private String billTypeSectionNotificationText_CL = "Überprüf bitte, ob Deine Rechnungsadresse richtig eingetragen ist.";
    private String billTypeSectionNotificationLink_CL = "Rechnungsadresse prüfen";
    private String notActivatedNotificationText_CL = "Du hast die Rechnungsbenachrichtigung nicht aktiviert";
    private String notVerifiedEmailNotificationHeader_CL = "Bestätige bitte Deine E-Mail-Adresse";
    private String notVerifiedEmailNotificationDescription_CL = "Wir haben Dir eine E-Mail mit einem Link geschickt. Bestätige Deine E-Mail-Adresse durch Klick auf den Link.";
    private String noEmailNotificationHeader_CL = "Wichtig für Dich";
    private String noEmailNotificationDescription_CL = "Gib uns bitte Deine E-Mail-Adresse. Dann mailen wir Dir, wenn eine neue Rechnung da ist.";
    private String noEmailValue_CL = "Du hast keine E-Mail-Adresse angegeben";
    private String changeToOnlineNotificationHeader_CL = "Gut zu wissen";
    private String changeToOnlineNotificationDescription_CL = "Wenn Du wieder Papier-Rechnungen bekommen willst, meld Dich einfach beim Kundenservice.";
    private String confirmationNotificationHeader_CL = "Vielen Dank!";
    private String confirmationNotificationDescription_CL = "Deine Änderungen haben wir gespeichert.";
    private String dispatchErrorNotificationHeader_CL = "Das hat leider nicht geklappt";
    private String dispatcherrorNotificationDescription_CL = "Wir können Deine Einstellungen zu Rechnungsart und Rechnungsversand im Moment nicht anzeigen. Versuch es bitte später nochmal.";
    private String paperAndOnlineNotification_CL = "Du bekommst im Moment Online- und Papier-Rechnungen für Deine Verträge. Wenn Du Online-Rechnung auswählst, bekommst Du für alle Deine Verträge Online-Rechnungen. Wenn Du dann wieder Papier-Rechnungen bekommen möchtest, musst Du Dich beim Kundenservice melden.";
    private String emailAdresseEintragenBtn_CL = "E-Mail-Adresse eintragen";
    private String bearbeitenBtn_CL = "Bearbeiten";
    private String billTypeLabel_CL = "Deine aktuelle Einstellung:";
    private String lowerSection_CL = "Hier kannst Du bearbeiten, welche Art des Einzelverbindungsnachweises Du bekommst.\n" +
            "Wichtig für Dich: Wir arbeiten gerade am Umzug aller Funktionen vom MeinKabel-Portal zu MeinVodafone. Diese Stelle ist leider noch nicht ganz fertig. Im Moment kannst Du diese Einstellungen in MeinKabel anpassen.\n" +
            "\n" +
            "Deine Änderungen werden für alle Rufnummern dieses Kontos übernommen.";
    private String bearbeitenInMeinKabel_CL = "Bearbeiten in MeinKabel";
    private String productAndItemizedErrorNotificationTitle_CL = "Das funktioniert gerade nicht";
    private String productAndItemizedErrorNotificationBody_CL = "Du kannst keinen Einzelverbindungsnachweis erstellen lassen. Für Dein Produkt gibt es keinen. Oder wir können Deine Einstellungen für einen Einzelverbindungsnachweis gerade nicht laden. Entschuldige bitte, unser Fehler. Bitte lad die Seite neu oder versuch es später nochmal.";

    /* *******WFCT-12607***** */
    String invoiceTypeHeaderText = "Du bekommst Deine Rechnung als:";
    String invoiceEmailHeaderText = "Deine Rechnungsbenachrichtigung";
    String invoiceEmailBodyText = "Wenn eine neue Rechnung da ist, schicken wir Dir eine E-Mail.";
    String emailAddresText = "E-Mail-Adresse:";
    String emailAddressColorCode = "66, 125, 0";
    String verifiedEmail = "E-Mail-Adresse verifiziert";
    String invoiceTypeText = "Online-Rechnung";
    String noBillNotificationCL = "Du hast die Rechnungsbenachrichtigung nicht aktiviert";


    //Methods
    public Einstellungen(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    @Step("Click send new confirmation button")
    public void clickSendNewConfirmationBtn() {
        driver.element().click(neueBestatigungsmailBekommenBtn_Locator);
    }

    @Step("Click on bearbeiten button")
    public void clickOnBearbeitenBtn() {
        driver.element().click(bearbeitenBtn_Locator);
    }

    @Step("Click on complete option")
    public void clickOnCompleteOption() {
        driver.element().click(vollstandigOption_Locator);
    }
    @Step("Click on shortened option")
    public void clickOnShortenedOption() {
        driver.element().click(shortenedOption_Locator);
    }
    @Step("Click on no individual option")
    public void clickOnnoIndividualOption() {
        driver.element().click(noIndividualOption_Locator);
    }

    @Step("Click checkbox")
    public void clickCheckbox() {
        driver.getDriver().findElement(checkbox_Locator).click();
    }

    @Step("Click on Confirm Button")
    public void cliclOnAnderungenSpeichernBtn() {
        driver.element().click(anderungenSpeichernBtn_Locator);
    }
    /* *******WFCT-12607***** */
    @Step("Click on Invoice Settings (Rechnungseinstellungen)")
    public void clickOnInvoiceSettings_Rechnungseinstellungen(){
        driver.element().click(invoiceSettings_Rechnungseinstellungen_Locator);
    }

    @Step("Click On Notification Edit CTA")
    public void clickOnNotificationEditCTA(){
        driver.element().click(editCTALocator);
    }

    @Step("Click On Notification Edit CTA")
    public void clickOnNotificationEditCTA_ActivateBtn(){
        driver.element().click(editCTALocator_ActivateBtn);
    }

    @Step("Click Back Button")
    public void clickBackButton(){
        driver.element().click(backBtn);
    }

    @Step("Click on the tool tip")
    public void clickToolTip() {
        driver.element().click(toolTipText_locator);
    }

    @Step("Click on email bearbeiten button")
    public void clickEmailBearbeitenBtn() {
        driver.element().click(emailAddressBearbeitenBtn_Locator);
    }

    @Step("Click on deactivate notification button")
    public void clickDeactivateNotificationBtn() {
        driver.element().click(benachrichtigungDeaktivierenBtn_Locator);
    }

    @Step("Click on activate notification button")
    public void clickActivateNotificationBtn() {
        driver.element().click(benachrichtigungAktivierenBtn_Locator);
    }

    @Step("Click notification link")
    public void clickNotificationLink() {
        driver.element().click(billTypeSectionNotificationLink_Locator);
    }

    @Step("Click on anderungSpeichern button")
    public void clickAnderungSpeichernBtn() {
        driver.element().click(anderungSpeichernBtn_Locator);
    }

    @Step("Click add email button")
    public void clickAddEmailBtn() {
        driver.element().click(emailAdresseEintragenBtn_Locator);
    }

    @Step("Click online radio button")
    public void clickOnlineRadioBtn() {
        driver.element().click(onlineRadioBtn_Locator);
    }

    @Step("Navigate back to einstellungen page")
    public void navigateToEinstellungenPage() {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/ihre-rechnungen/einstellungen");
    }

    @Step("Navigate back to options page")
    public void navigateToOptionsPage() {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/einzelverbindungsnachweise");
    }

    //Validations

    public void assertOnPageHeader() {
        driver.verifyThat().element(pageHeader_Locator).textTrimmed().isEqualTo(pageHeader_CL).withCustomReportMessage("Assert on page header ").perform();
    }

    public void assertOnPageSubTitle() {
        driver.verifyThat().element(subTitle_Locator).textTrimmed().isEqualTo(subTitle_CL).withCustomReportMessage("Assert on subtitle text").perform();
    }

    public void assertOnEditSectionHeader() {
        driver.verifyThat().element(editSectionHeader_Locator).textTrimmed().isEqualTo(editSectionHeader_CL).withCustomReportMessage("Assert on edit section header text").perform();
    }

    public void assertOnEditSectionUpperDescription() {
        driver.verifyThat().element(editSectionUpperDescription_Locator).textTrimmed().isEqualTo(editSectionUpperDescription_CL).withCustomReportMessage("Assert on edit section upper description text").perform();
    }

    public void assertOnEditSectionMiddleDescription() {
        driver.verifyThat().element(editSectionMiddleDescription_Locator).textTrimmed().isEqualTo(editSectionMiddleDescription_CL).withCustomReportMessage("Assert on edit section middle description text").perform();
    }

    public void assertOnCurrentItemizedBillType(String selectedOption) {
        driver.verifyThat().element(editSectionLowerDescription_Locator).textTrimmed().isEqualTo(selectedOption).withCustomReportMessage("Assert on current itemized bill type text").perform();
    }

    public void assertOnEditSectionUpperDescription_mitigation() {
        driver.verifyThat().element(editSectionUpperDescription_Locator).textTrimmed().isEqualTo(editSectionUpperDescription_CL).withCustomReportMessage("Assert on edit section upper description text").perform();
    }

    public void assertOnEditSectionLowerDescription_mitigation() {
        driver.verifyThat().element(editSectionMiddleDescription_Locator).textTrimmed().isEqualTo(lowerSection_CL).withCustomReportMessage("Assert on edit section middle description text").perform();
    }

    public void assertOnCurrentItemizedBillType_mitigation(String selectedOption) {
        driver.verifyThat().element(billTypeLabel_Locator).textTrimmed().isEqualTo(billTypeLabel_CL).withCustomReportMessage("Assert on bill type label").perform();
        driver.verifyThat().element(editSectionLowerDescription_Locator).textTrimmed().isEqualTo(selectedOption).withCustomReportMessage("Assert on current itemized bill type text").perform();
    }

    public void assertOnBearbeitenBtn() {
        driver.verifyThat().element(bearbeitenBtn_Locator).textTrimmed().isEqualTo(bearbeitenBtn_CL).withCustomReportMessage("Assert on bearbeiten button text").perform();
    }

    public void assertOnBearbeitenInMeinKabelBtn() {
        driver.verifyThat().element(bearbeitenInMeinKabel_Locator).textTrimmed().isEqualTo(bearbeitenInMeinKabel_CL).withCustomReportMessage("Assert on bearbeiten button text").perform();
    }

    public void assertOnBearbeitenInMeinKabelBtnNavigation() {
        driver.verifyThat().element(bearbeitenInMeinKabel_Locator).attribute("href").isEqualTo("https://kabel.vodafone.de/meinkabel/rechnungen/evn").withCustomReportMessage("Assert on bearbeiten button Navigation").perform();
    }

    public void assertOnOptionSectionTitle() {
        driver.verifyThat().element(optionSectionTitle_Locator).textTrimmed().isEqualTo(optionSectionTitle_CL).withCustomReportMessage("Assert on options section title").perform();
    }

    public void assertOnBlackMessageText() {
        driver.verifyThat().element(blackMessageText_Locator).textTrimmed().isEqualTo(blackMessage_CL).withCustomReportMessage("Assert on black message text").perform();
    }

    public void assertThat3OptionsDisplayed() {
        SHAFT.Validations.verifyThat().number(driver.element().getElementsCount(optionsCommon_Locator)).isEqualTo(3).withCustomReportMessage("Assert that 3 options are displayed").perform();
    }

    public void assertThatSelectedOptionIsDimmed(String optionOrder) {
        driver.verifyThat().element(By.xpath("(//input[@id='undefined'])[" + optionOrder + "]")).isDisabled().withCustomReportMessage("Assert that selected option is dimmed").perform();
    }

    public void assertThatCheckboxNotExists() {
        driver.verifyThat().element(checkbox_Locator).doesNotExist().withCustomReportMessage("Assert that checkbox does not exist ").perform();
    }

    public void assertOnCheckboxMessageHeader() {
        driver.verifyThat().element(checkboxMessageHeader_Locator).textTrimmed().isEqualTo(checkboxMessageHeader_CL).withCustomReportMessage("Assert on checkbox message header").perform();
    }

    public void assertOnCheckboxMessageBody() {
        driver.verifyThat().element(checkboxMessageBody_Locator).textTrimmed().isEqualTo(checkboxMessageBody_CL).withCustomReportMessage("Assert on checkbox message body").perform();
    }

    public void assertThatanderungenSpeichernBtnDisabled() {
        driver.verifyThat().element(anderungenSpeichernBtn_Locator).isDisabled().withCustomReportMessage("Assert that anderungenSpeichern Button is disabled").perform();
    }

    public void assertOnGeneralErrorNotificationTitle() {
        driver.verifyThat().element(errorNotificationTitle_Locator).textTrimmed().isEqualTo(errorNotificationTitle_CL).withCustomReportMessage("Assert on error notification title").perform();
    }

    public void assertOnGeneralErrorNotificationDescription() {
        driver.verifyThat().element(errorNotificationDescription_Locator).textTrimmed().isEqualTo(errorNotificationDescription_CL).withCustomReportMessage("Assert on error notification description").perform();
    }
    public void assertOnPaperAndOnlineNotification() {
        driver.verifyThat().element(paperAndOnlineNotification_Locator).textTrimmed().isEqualTo(paperAndOnlineNotification_CL).withCustomReportMessage("Assert on paper and online notification").perform();
    }

    public void assertOnDispatchErrorNotificationHeader() {
        driver.verifyThat().element(dispatchErrorNotificationHeader_Locator).textTrimmed().isEqualTo(dispatchErrorNotificationHeader_CL).withCustomReportMessage("Assert on error notification header").perform();
    }

    public void assertOnDispatchErrorNotificationDescription() {
        driver.verifyThat().element(dispatchErrorNotificationDescription_Locator).textTrimmed().isEqualTo(dispatcherrorNotificationDescription_CL).withCustomReportMessage("Assert on error notification description").perform();
    }

    public void assertOnConfirmationNotificationHeader() {
        driver.verifyThat().element(confirmationNotificationHeader_Locator).textTrimmed().isEqualTo(confirmationNotificationHeader_CL).withCustomReportMessage("Assert on confirmation notification header").perform();
    }

    public void assertOnConfirmationNotificationDescription() {
        driver.verifyThat().element(confirmationNotificationDescription_Locator).textTrimmed().isEqualTo(confirmationNotificationDescription_CL).withCustomReportMessage("Assert on confirmation notification header").perform();
    }

    public void assertOnChangeToOnlineNotificationHeader() {
        driver.verifyThat().element(changeToOnlineNotificationHeader_Locator).textTrimmed().isEqualTo(changeToOnlineNotificationHeader_CL).withCustomReportMessage("Assert on change to online notification header").perform();
    }

    public void assertOnChangeToOnlineNotificationDescription() {
        driver.verifyThat().element(changeToOnlineNotificationDescription_Locator).textTrimmed().isEqualTo(changeToOnlineNotificationDescription_CL).withCustomReportMessage("Assert on change to online notification description").perform();
    }

    public void assertOnEmailAdresseEintragenBtnText() {
        driver.verifyThat().element(emailAdresseEintragenBtn_Locator).textTrimmed().isEqualTo(emailAdresseEintragenBtn_CL).withCustomReportMessage("Assert on email Adresse Eintragen Button text").perform();
    }

    public void assertOnNotActivatedNotificationText() {
        driver.verifyThat().element(notActivatedNotificationText_Locator).textTrimmed().isEqualTo(notActivatedNotificationText_CL).withCustomReportMessage("Assert on Not Activated Notification Text").perform();
    }

    public void assertOnNoEmailText() {
        driver.verifyThat().element(noEmailValueText_Locator).textTrimmed().isEqualTo(noEmailValue_CL).withCustomReportMessage("Assert on No email Text").perform();
    }

    public void assertOnNoEmailNotificationHeader() {
        driver.verifyThat().element(noEmailNotificationHeader_Locator).textTrimmed().isEqualTo(noEmailNotificationHeader_CL).withCustomReportMessage("Assert on No email Notification header").perform();
    }

    public void assertOnNoEmailNotificationDescription() {
        driver.verifyThat().element(noEmailNotificationDescription_Locator).textTrimmed().isEqualTo(noEmailNotificationDescription_CL).withCustomReportMessage("Assert on No email Notification description").perform();
    }

    public void assertOnNotVerifiedEmailNotificationHeader() {
        driver.verifyThat().element(notVerifiedEmailNotificationHeader_Locator).textTrimmed().isEqualTo(notVerifiedEmailNotificationHeader_CL).withCustomReportMessage("Assert on Not Verified email Notification header").perform();
    }

    public void assertOnNotVerifiedEmailNotificationDescription() {
        driver.verifyThat().element(notVerifiedEmailNotificationDescription_Locator).textTrimmed().isEqualTo(notVerifiedEmailNotificationDescription_CL).withCustomReportMessage("Assert on Not Verified email Notification description").perform();
    }

    public void assertOnBillTypeSectionNotificationText() {
        driver.verifyThat().element(billTypeSectionNotificationText_Locator).textTrimmed().isEqualTo(billTypeSectionNotificationText_CL).withCustomReportMessage("Assert on bill Type Section Notification Text").perform();
    }

    public void assertOnBillTypeSectionNotificationLink() {
        driver.verifyThat().element(billTypeSectionNotificationLink_Locator).textTrimmed().isEqualTo(billTypeSectionNotificationLink_CL).withCustomReportMessage("Assert on bill Type Section Notification Link").perform();
    }

    public void assertOnBillTypeSectionNotificationLinkNavigation() {
        driver.verifyThat().element(editAddressAccordion_Locator).attribute("class").contains("active").withCustomReportMessage("Assert that user navigated to edit email page").perform();
    }

    public void assertOnBillTypeSectionHeader() {
        driver.verifyThat().element(billTypeSectionHeader_Locator).textTrimmed().isEqualTo(billTypeSectionHeader_CL).withCustomReportMessage("Assert on bill type section header").perform();
    }

    public void assertOnBillTypeSectionDescription() {
        driver.verifyThat().element(billTypeSectionDescription_Locator).textTrimmed().isEqualTo(billTypeSectionDescription_CL).withCustomReportMessage("Assert on bill type section Description").perform();
    }

    public void assertThatAnderungSpeichernBtnDimmed() {
        driver.verifyThat().element(anderungSpeichernBtn_Locator).isDisabled().withCustomReportMessage("Assert that anderung speichern button is dimmed").perform();
    }

    public void assertThatOnlineRadioBtnNotExist() {
        driver.verifyThat().element(onlineRadioBtn_Locator).doesNotExist().withCustomReportMessage("Assert that online radio button doesn't exist").perform();
    }

    public void assertThatPaperRadioBtnChecked() {
        driver.verifyThat().element(paperRadioBtn_Locator).isChecked().withCustomReportMessage("Assert that paper radio button is checked").perform();
    }

    public void assertThatPaperAndOnlineRadioBtnChecked() {
        driver.verifyThat().element(paperAndOnlineRadioBtn_Locator).isChecked().withCustomReportMessage("Assert that paper radio button is checked").perform();
    }

    public void assertThatUserNavigatedToEditNotificationSettingPage() {
        driver.verifyThat().element(editNotificationSettingsPageHeader_Locator).exists().withCustomReportMessage("Assert that user navigated to edit notification setting page").perform();
    }

    public void assertThatUserNavigatedToSendNewConfirmationPage() {
        driver.verifyThat().element(sendNewConfirmationPageHeader_Locator).exists().withCustomReportMessage("Assert that user navigated to send new confirmation page").perform();
    }

    public void assertThatUserNavigatedToEditEmailPage() {
        driver.verifyThat().element(editEmailPageHeader_Locator).exists().withCustomReportMessage("Assert that user navigated to edit email page").perform();
    }

    public void assertThatEmailStatusVerified() {
        driver.verifyThat().element(emailStatus_Locator).textTrimmed().isEqualTo(emailVerified_CL).withCustomReportMessage("Assert That email status is verified").perform();
    }

    public void assertThatEmailStatusNotVerified() {
        driver.verifyThat().element(emailStatus_Locator).textTrimmed().isEqualTo(emailNotVerified_CL).withCustomReportMessage("Assert That email status is not verified").perform();
    }

    public void assertThatEmailAddressValueGreen() {
        driver.verifyThat().element(emailAddressValue_Locator).cssProperty("color").contains("66, 125, 0").withCustomReportMessage("Assert That email address value color is green").perform();
    }

    public void assertThatEmailAddressValueRed() {
        driver.verifyThat().element(emailAddressValue_Locator).cssProperty("color").contains("230, 0, 0").withCustomReportMessage("Assert That email address value color is Red").perform();
    }

    public void assertOnCheckIcon() {
        driver.verifyThat().element(checkIcon_Locator).exists().withCustomReportMessage("Assert on check icon").perform();
    }

    public void assertOnCrossIcon() {
        driver.verifyThat().element(crossIcon_Locator).exists().withCustomReportMessage("Assert on cross icon").perform();
    }

    public void assertOnEmailAddressValueText(String value) {
        driver.verifyThat().element(emailAddressValue_Locator).textTrimmed().contains(value).withCustomReportMessage("Assert on email address value text").perform();
    }

    public void assertOnEmailAddressLabelText() {
        driver.verifyThat().element(emailAddressLabel_Locator).textTrimmed().isEqualTo(emailAddressLabel_CL).withCustomReportMessage("Assert on email address label text").perform();
    }

    public void assertOnToolTipText() {
        driver.verifyThat().element(toolTipText_locator).textTrimmed().isEqualTo(toolTip_CL).withCustomReportMessage("Assert on tool tip text").perform();
    }

    public void assertOnInvoiceTypeSectionHeader() {
        driver.verifyThat().element(invoiceTypeSectionHeader_Locator).textTrimmed().isEqualTo(invoiceTypeSectionHeader_CL).withCustomReportMessage("Assert on invoice type section header").perform();
    }

    public void assertOnOnlineTypeLabel() {
        driver.verifyThat().element(onlineTypeLabel_Locator).exists().withCustomReportMessage("Assert on invoice online type").perform();
    }

    public void assertOnPaperTypeLabel() {
        driver.verifyThat().element(paperTypeLabel_Locator).exists().withCustomReportMessage("Assert on invoice paper type").perform();
    }

    public void assertOnPaperAndOnlineTypeLabel() {
        driver.verifyThat().element(paperAndOnlineTypeLabel_Locator).textTrimmed().isEqualTo(paperAndOnlineType_CL).withCustomReportMessage("Assert on invoice paper and online type").perform();
    }

    public void assertThatPaperLabelNotExist() {
        driver.verifyThat().element(paperTypeLabel_Locator).doesNotExist().withCustomReportMessage("Assert that invoice paper label doesn't exist ").perform();
    }

    public void assertThatPaperAndOnlineLabelNotExist() {
        driver.verifyThat().element(paperAndOnlineTypeLabel_Locator).doesNotExist().withCustomReportMessage("Assert that invoice paper label doesn't exist ").perform();
    }

    public void assertOnEmailSectionHeader() {
        driver.verifyThat().element(emailSectionHeader_Locator).textTrimmed().isEqualTo(emailSectionHeader_CL).withCustomReportMessage("Assert on email section header").perform();
    }

    public void assertOnEmailSectionSubTitle() {
        driver.verifyThat().element(emailSectionSubTitle_Locator).textTrimmed().isEqualTo(emailSectionSubTitle_CL).withCustomReportMessage("Assert on email section sub title").perform();
    }
    /* *******WFCT-12607***** */

    public void assertOnInvoiceTypeHeader(){
        driver.verifyThat().element(invoiceTypeHeaderLocator).textTrimmed()
                .isEqualTo(invoiceTypeHeaderText)
                .withCustomReportMessage("Assert On Invoice Type Header")
                .perform();
    }

    public void assertOnInvoiceType(){
        driver.verifyThat().element(invoiceTypeLocator).textTrimmed()
                .isEqualTo(invoiceTypeText)
                .withCustomReportMessage("Assert On Invoice Type")
                .perform();
    }

    public void assertOnInvoiceEmailSectionHeadline(){
        driver.verifyThat().element(invoiceEmailHeaderLocator).textTrimmed()
                .isEqualTo(invoiceEmailHeaderText)
                .withCustomReportMessage("Assert On Invoice Email Section Headline")
                .perform();
    }

    public void assertOnInvoiceEmailSectionBody(){
        driver.verifyThat().element(invoiceEmailBodyLocator).textTrimmed()
                .isEqualTo(invoiceEmailBodyText)
                .withCustomReportMessage("Assert On Invoice Email Section Body")
                .perform();
    }

    public void assertOnEmailAdressField(){
        driver.verifyThat().element(emailAddressLocator).textTrimmed()
                .isEqualTo(emailAddresText)
                .withCustomReportMessage("Assert On Email Address Field")
                .perform();
    }

    public void assertOnEmailAdressColor(){
        driver.verifyThat().element(emailAddressColorLocator)
                .cssProperty("color").contains(emailAddressColorCode)
                .withCustomReportMessage("Assert On Email Address Color")
                .perform();
    }

    public void assertThatEmailIsVerified(){
        driver.verifyThat().element(emailAddressVerifiedLocator).textTrimmed()
                .isEqualTo(verifiedEmail)
                .withCustomReportMessage("Assert That Email Address Is Verified")
                .perform();
    }

    public void assertOnNotificationEditCTAText(String editBtnText){
        driver.verifyThat().element(editCTALocator).textTrimmed()
                .isEqualTo(editBtnText)
                .withCustomReportMessage("Assert On Notification Edit CTA Text")
                .perform();
    }

    public void assertOnNotificationEditCTAText_ActivationCase(String editBtnText){
        driver.verifyThat().element(editCTALocator_ActivateBtn).textTrimmed()
                .isEqualTo(editBtnText)
                .withCustomReportMessage("Assert On Notification Edit CTA Text")
                .perform();
    }

    public void assertOnSwitchedOffNotificationMessage(){
        driver.verifyThat().element(noBillNotification).textTrimmed()
                .isEqualTo(noBillNotificationCL)
                .withCustomReportMessage("Assert On Notification Edit CTA Text")
                .perform();
    }

    public void assertThatItemizedBillSectionExists(){
        driver.verifyThat().element(itemizedBillSection_Locator).exists().withCustomReportMessage("Assert that itemized bill section exists").perform();
    }

    public void assertThatItemizedBillSectionNotExists(){
        driver.verifyThat().element(itemizedBillSection_Locator).doesNotExist().withCustomReportMessage("Assert that itemized bill section does not exist").perform();
    }

    public void assertThatOptionsAccordionNotExists(){
        driver.verifyThat().element(settingsOptionsAccordion_Locator).doesNotExist().withCustomReportMessage("Assert that options accordion not exists").perform();
    }

    public void assertThatBillTypeSectionExists(){
        driver.verifyThat().element(billTypeSection_Locator).exists().withCustomReportMessage("Assert that bill type section exists").perform();
    }

    public void assertOnProductAndItemizedErrorNotificationTitle() {
        driver.verifyThat().element(productAndItemizedErrorNotificationTitle_Locator).textTrimmed().isEqualTo(productAndItemizedErrorNotificationTitle_CL).withCustomReportMessage("Assert on Product and Itemized error notification title").perform();
    }

    public void assertOnProductAndItemizedErrorNotificationBody() {
        driver.verifyThat().element(productAndItemizedErrorNotificationBody_Locator).textTrimmed().isEqualTo(productAndItemizedErrorNotificationBody_CL).withCustomReportMessage("Assert on Product and Itemized error notification description").perform();
    }

    public void assertThatProductAndItemizedErrorNotificationNotExists(){
        driver.verifyThat().element(productAndItemizedErrorNotification_Locator).doesNotExist().withCustomReportMessage("assert that Product and Itemizederror notification not exists").perform();
    }
}
