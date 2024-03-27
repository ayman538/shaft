package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

public class Dashboard {
    // Variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String Datenschutz_SO_HeaderText = "Datenschutz- & Werbe-Einstellungen";
    private static String Datenschutz_SO_FooterText = "Hier schützt Du Deine Privatsphäre.";
    public static String Datenschutz_Accordion_HeaderText = "Datenschutz & Werbeeinstellungen";
    public static String Datenschutz_Accordion_FooterText = "Hier schützt Du Deine Privatsphäre";



    //5209 - Terminated KD user CLs
    private static String terminatedWarningMessageTitleCL = "Dein Vertrag ist beendet";
    private static String terminatedWarningMessageDescriptionCL = "Dein Kundenkonto wird bald gelöscht. Schick bitte geliehene Geräte an uns zurück.";
    private static String ctaButtonCL = "Vertrag oder Rufnummer entfernen";
    private static String myBillsSOHeaderCL = "Meine Rechnungen";
    private static String myBillsSOSubHeaderCL = "Vergleichen und herunterladen";
    private static String removeContractTitleCL = "Vertrag oder Teilnehmer aus dem MeinVodafone-Konto entfernen";
    private static String myBillsPageTitleCL = "Meine Rechnungen";

    private static String suspendedMsgTitleCL = "Dein Konto weist aktuell einen offenen Saldo aus";
    private static String suspendedMsgBodyCL = "Wie sich der Betrag zusammensetzt, kannst Du hier einsehen.";

    //Kabel TV CLs
    private static String gigaTVSO_Header_CL = "GigaTV-Geräte";
    private static String gigaTVSO_Footer_CL = "Deine GigaTV-Geräte verwalten";


    //Locators
    public static By loginIndicator = By.xpath("//span[@class='indicator' and @style='display: block;']");
    public static By accordionMSISDN934034564Locator =By.xpath("//a[@id='dashboard:cable']");
    public static By bewOverlayAcceptDashboard =By.xpath("//div[@class='overlay-content']//a[@class='btn' and contains(text(),'Ja')]");
    public static By meineDaten_Tile =By.xpath("//a[@automation-id='Meine Daten_btn']");
    public static By meineDaten_Tile_1ndAcc =By.xpath("(//a[@automation-id='Meine Daten_btn'])[1]");
    public static By meineDaten_Tile_2ndAcc =By.xpath("(//a[@automation-id='Meine Daten_btn'])[2]");

    public static By KABEL_TV_BURGER_MENU =By.xpath("(//*[@class='expert-mode dots-menu'])[2]");
    public static By DATENSCHUTZ_MENU_ITEM_LINK =By.xpath("(//span[@class='option-name'])[7]");
    private static final By DatenschutzSmartObjectHeaderText = By.xpath("//*[@automation-id=\"datenschutz_so\"]//h3");
    private static final By DatenschutzSmartObjectFooterText = By.xpath("//*[@automation-id=\"datenschutz_so\"]//*[@class=\"sb-block-footer\"]");
    public static By contactEmailNotificatnCloseButton1 =By.xpath("(//*[local-name()='svg' and @class='icon-close-i-xxsml i-xxsml'])[1]");


    //KIP_Locators
    public static By KABEL_INTERNET_ACCORDION =By.xpath("//span[@class='mbo-name break-word' and contains(text(),'Internet')]");
    public static By KABEL_DEVICE_SETTING_SO_IN_DASHBOARD =By.xpath("(//div[@class='sb-block-inner'])[4]");
    public static By KABEL_INTERNET_BURGERMENU =By.xpath("(//div[@class='expert-mode dots-menu'])[1]");
    public static By KABEL_INTERNET_SETTINGS_MENUELEMENT =By.xpath("(//span[contains(text(),'Geräte & Einstellungen')])[1]");


    //WFDT-5209 Terminated KD user locators
    private static By terminatedWarningMessageTitle =By.xpath("//*[@class='alert warning ']/div/h4");
    private static By terminatedWarningMessageDescription =By.xpath("//*[@class='alert warning ']/div/p");
    private static By ctaButton =By.xpath("//*[@class='btn mt-10']");
    private static By myBillsSOHeader =By.xpath("(//*[@automation-id='Meine Rechnungen_btn']/div[2])[1]");
    private static By myBillsSOSubHeader =By.xpath("(//*[@automation-id='Meine Rechnungen_btn']/div[3])[1]");
    private static By removeContractTitle =By.xpath("//*[@class='title-ecare overview']");
    private static By myBillsPageTitle =By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private static By warningMessageForDeeplinkTerminatedUserTitle =By.xpath("//*[@class='flexDiv']");
    private static By warningMessageForDeeplinkTerminatedUserDescription =By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private static By warningMessageForTerminatedUserTitle =By.xpath("//div[@class='align-super']/h4");
    private static By warningMessageForTerminatedUserDescription =By.xpath("//div[@class='align-super']/p");
    private static By terminatedSubscriberAccordion =By.xpath("(//*[@class='icon-arrow-down-i-xsml i-xsml ac-arrow'])[1]");
    public static By backButton =By.xpath("//a[@automation-id='back_Link']");

    //WFDT-5211 locators
    public static By documentsAndOrdersNotificationIcon =By.xpath("//span[@class='menu-item-text only-lrg' and contains(text(),'Dokumente und Aufträge')]");
    public static By myDocumentsInbox  =By.xpath("//a[@href='/meinvodafone/services/notifizierung/dokumente']");
    public static By automatedMartinAccordion =By.xpath("//li[@dashboard-click-event='3'][3]");//a[@id='dashboard:cable']
    public static By secondSubscriber =By.xpath("(//a[@class='ac-head skiphash accordion-state'])[2]");

    // KD TV locators

    public static final By TV_ThreeDots = By.xpath("(//div[@class='expert-mode dots-menu'])[2]");
    public static final By TV_SettingsOption = By.xpath("(//*[@class='option-name'])[6]");
    private static final By suspendedMsgTitle = By.xpath("//div[@automation-id='suspended_nt']//h4");
    private static final By suspendedMsgBody = By.xpath("//div[@automation-id='suspended_nt']//p");

    //Dashboard email or red plus notification message ignoring
    public static final By MSG_Container = By.xpath("//*[@class=\"notification-message-container\"]");
    public static final By Close_BTN = By.xpath("//*[@class=\"icon-close-i-xxsml i-xxsml\"]");

    public static final By Second_Miene_Daten_Tile_Multi = By.xpath("(//a[@automation-id='Meine Kundendaten_btn'])[2]");

    public static final By FirstAcc_in_multiMartin_Contract = By.xpath("(//*[@class='icon-arrow-down-i-xsml i-xsml ac-arrow'])[1]");
    private static final By notf_MSG_Container = By.xpath("(//div[@class='notification-message-container'])");
    private static final By notf_Msg_Close_BTN = By.xpath("(//*[@class='icon-close-i-xxsml i-xxsml'])");

    /* *********WFCT-12607***** */
    private static final By torstenAccordion = By.xpath("//li[@automation-id='cableListContainerlv']");
    private static final By getMeineRehnungen = By.xpath("//a[@automation-id='Meine Rechnungen_btn']");
    private static final By contractLocator = By.xpath("(//a[@track-type='accordion-track'])[4]");

    //Kabel TV Locators for WFDT-8291
    private static final By kabelTV_ACC = By.xpath("(//a[@class='subscription-heading'])[2]");
    private static final By gigaTV_SO = By.xpath("//smart-object[@automation-id='gigaTv_so']");
    private static final By gigaTV_SO_Header = By.xpath("//smart-object[@automation-id='gigaTv_so']//div//h3");
    private static final By gigaTV_SO_Footer = By.xpath("//smart-object[@automation-id='gigaTv_so']//div[@class='sb-block-footer']");
    private static final By gigaTV_Setting_MenuElement = By.xpath("(//span[contains(text(),'Geräte & Einstellungen')])[2]");
    private static final By gigaTV_BurgerMenu = By.xpath("(//*[@class='expert-mode dots-menu'])[2]");
    private static By meineRechnungTileLocator = By.xpath("//div[@class=\"subTitle\"][contains(.,\"Vergleichen und herunterladen\")]");
    private static By meineKundenDatenButtonLocator = By.xpath("//a[@automation-id='Meine Kundendaten_btn']");

    // WFDT-8290 | Migrate to New Version of Contact Medium
    private static final By meineDatenButton = By.xpath("//a[@automation-id='Meine Daten_btn']");

    //constructor
    public Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public Dashboard openMeineKundenDatenTile(DashboardSmartObject card) {
        switch (card) {
            case MEINEKUNDENDATEN -> {
                driver.element().isElementClickable(meineDaten_Tile);
                driver.element().click(meineDaten_Tile);
            }
            case MULTIMEINEKUNDENDATEN -> {
                driver.element().isElementClickable(Second_Miene_Daten_Tile_Multi);
                driver.element().click( Second_Miene_Daten_Tile_Multi);
            }
        }
        return this;
    }


    public MeineDaten openTile(DashboardSmartObject card) {
        switch (card) {
            case MEINEKUNDENDATEN -> {
                driver.element().click(meineDaten_Tile);
            }
        }
        return new MeineDaten(driver);
    }

    public Dashboard clickKabelTVBurgerMenu (){
        driver.element().isElementClickable(KABEL_TV_BURGER_MENU);
        driver.element().click(KABEL_TV_BURGER_MENU);
        return this;
    }

    public Dashboard clickDatenSchutzMenuItem (){
        driver.element().click(DATENSCHUTZ_MENU_ITEM_LINK);
        return this;
    }

    public Dashboard isBEWOverlayfound() {
        driver.element().getElementsCount(bewOverlayAcceptDashboard);
        if (driver.element().getElementsCount(bewOverlayAcceptDashboard)!=0)
        {
            driver.element().click(bewOverlayAcceptDashboard);
        }
        return this;
    }

    public Dashboard IsEmailMsgFound()
    {
        driver.element().getElementsCount(MSG_Container);
        if (driver.element().getElementsCount( MSG_Container)!=0)
        {
            driver.element().click( Close_BTN);
        }
        return this;
    }

    public Dashboard ignoreDashboardNotifications() {
        IsEmailMsgFound();
        return this;
    }

    public Dashboard openKIPSettingsPageUsingSmartObject()
    {
        driver.element().click(KABEL_INTERNET_ACCORDION);
        driver.element().click(KABEL_DEVICE_SETTING_SO_IN_DASHBOARD);
        return this;
    }

    @Step("Open KIP Settings")
    public Dashboard openKIPSettingsPageUsingBurgerMenuLinkout()
    {
        driver.element().isElementClickable(KABEL_INTERNET_BURGERMENU);
        driver.element().click(KABEL_INTERNET_BURGERMENU);
        driver.element().isElementClickable(KABEL_INTERNET_SETTINGS_MENUELEMENT);
        driver.element().click(KABEL_INTERNET_SETTINGS_MENUELEMENT);
        return this;
    }

    public Dashboard expandSecondContractInMultiMartin() {
        driver.element().click(BankDetails.Contract_Accordion);
        return this;
    }

    public Dashboard clickOnMeineDatenSecondContract(){
        driver.element().click(meineDaten_Tile_2ndAcc);
        return this;
    }

    public enum DashboardSmartObject {
        MEINEKUNDENDATEN,
        MULTIMEINEKUNDENDATEN
    }

    public enum DashboardAccordion {
        KABELVERTRAG
    }

    public Dashboard expandTerminatedSubscriberAccordion () {
        driver.element().click(terminatedSubscriberAccordion);
        return this;
    }

    public Dashboard clickCTAbutton () {
        driver.element().click(ctaButton);
        return this;
    }

    public Dashboard deeplinkToMeineKundendaten (){
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/vertragsdaten");
        return this;
    }

    public Dashboard deeplinkToInternet_PhoneProdukte (){
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/meine-produkte/internet-phone/geraete-einstellungen");
        return this;
    }

    public Dashboard deeplinkToTVProdukte (){
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/meine-produkte/tv/geraete-einstellungen?accordion=tvDevices");
        return this;
    }

    public Dashboard deeplinkToAddressTransaction (){
          driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/vertragsdaten?accordion=adressen");
        return this;
    }

    public Dashboard deeplinkToContactDataTransaction (){
          driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/vertragsdaten?accordion=kontaktdaten");
        return this;
    }

    public Dashboard deeplinkToBankDetailsTransaction () {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/vertragsdaten?accordion=bankverbindung");
        return this;
    }

    public Dashboard openMeineRechnungenSO (){
        //get all browser tabs in a list
        ArrayList<String> tabs = new ArrayList<String> (driver.getDriver().getWindowHandles());
        //switch back to previous tab
        driver.browser().switchToWindow(tabs.get(0));
        driver.browser().navigateBack();
        //driver.browser().navigateBack();
        driver.element().click(myBillsSOHeader);
        return this;
    }

    public Dashboard clickDocumentsAndOrdersNotification(){
        driver.element().isElementClickable(documentsAndOrdersNotificationIcon);
        driver.element().click(documentsAndOrdersNotificationIcon);
        return this;
    }

    public Dashboard clickMyDocumentsInbox(){
        driver.element().click(myDocumentsInbox);
        return this;
    }

    public Dashboard selectSecondSubscriber() {
        driver.element().isElementClickable(secondSubscriber);
        driver.element().click(secondSubscriber);
        return this;
    }

    public Dashboard deeplinkToMyDocumentsInbox (){
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/notifizierung/dokumente");
        return this;
    }

    public Dashboard returnBackToDashboard (){
        driver.element().isElementClickable(backButton);
        driver.element().click(backButton);
        return this;
    }

    // KD TV Keywords
    public Dashboard NavigateToTVSettingsPage(){
        driver.element().click(TV_ThreeDots);
        driver.element().click(TV_SettingsOption);
        return this;
    }

    //Tab page actions
    public Dashboard GoToPreviousPage(){
        driver.browser().navigateBack();
        return this;
    }

    public Dashboard GoToForwardPage(){
        driver.browser().navigateForward();
        return this;
    }

    public Dashboard ReloadCurrentPage(){
        driver.browser().refreshCurrentPage(); JavaScriptWaitManager.waitForLazyLoading();
        return this;
    }

    public Dashboard expandFirstContractInMultiMartin(){
        driver.element().click( FirstAcc_in_multiMartin_Contract);
        return this;
    }

    public Dashboard clickOnMeineDatenFirstContract() {
        driver.element().click(meineDaten_Tile_1ndAcc);
        return this;
    }

    public Dashboard validateSuspendedMsg(){
        driver.verifyThat().element(suspendedMsgTitle)
                .textTrimmed().isEqualTo(suspendedMsgTitleCL)
                .withCustomReportMessage("Validate that suspended Message title correct")
                .perform();
        driver.verifyThat().element(suspendedMsgBody)
                .textTrimmed().isEqualTo(suspendedMsgBodyCL)
                .withCustomReportMessage("Validate that suspended Message Body correct")
                .perform();
        return this;
    }

    public Dashboard validateWarningMessageForTerminatedKDUser(){
        driver.verifyThat().element(terminatedWarningMessageTitle)
                .textTrimmed().isEqualTo(terminatedWarningMessageTitleCL)
                .withCustomReportMessage("Validate warning message title for terminated KD user")
                .perform();
        driver.verifyThat().element(terminatedWarningMessageDescription)
                .textTrimmed().isEqualTo(terminatedWarningMessageDescriptionCL)
                .withCustomReportMessage("Validate warning message description for terminated KD user")
                .perform();
        driver.verifyThat().element(ctaButton)
                .textTrimmed().isEqualTo(ctaButtonCL)
                .withCustomReportMessage("Validate CTA button in warning message for terminated KD user")
                .perform();
        return this;
    }

    public Dashboard validateMeineRechnungenSO(){
        driver.verifyThat().element(myBillsSOHeader).textTrimmed()
                .isEqualTo(myBillsSOHeaderCL)
                .withCustomReportMessage("Validate Meine Rechnungen SO header ")
                .perform();
        driver.verifyThat().element(myBillsSOSubHeader).textTrimmed()
                .isEqualTo(myBillsSOSubHeaderCL)
                .withCustomReportMessage("Validate Meine Rechnungen SO subheader ")
                .perform();
        return this;
    }

    public Dashboard validateRemoveContractPageTitle(){
        driver.verifyThat().element(removeContractTitle).textTrimmed()
                .contains(removeContractTitleCL)
                .withCustomReportMessage("Validate Remove Contract page title ")
                .perform();
        return this;
    }

    public Dashboard validateWarningMessageForDeeplinkTerminatedUser(){
        driver.verifyThat().element(warningMessageForDeeplinkTerminatedUserTitle)
                .textTrimmed().isEqualTo(terminatedWarningMessageTitleCL)
                .withCustomReportMessage("Validate Warning message title")
                .perform();
        driver.verifyThat().element(warningMessageForDeeplinkTerminatedUserDescription)
                .textTrimmed().isEqualTo(terminatedWarningMessageDescriptionCL)
                .withCustomReportMessage("Validate Warning message description")
                .perform();
        return this;
    }

    public Dashboard validateCTAButtonInWarningMessageForTerminatedKDUser(){
        driver.verifyThat().element(ctaButton)
                .textTrimmed().isEqualTo(ctaButtonCL)
                .withCustomReportMessage("Validate CTA button in warning message for terminated KD user")
                .perform();
        return this;
    }

    public Dashboard validateWarningMsgForKIPAndTVTerminatedUser(){
        driver.verifyThat().element( warningMessageForDeeplinkTerminatedUserTitle)
                .textTrimmed().isEqualTo(terminatedWarningMessageTitleCL)
                .withCustomReportMessage("Validate Warning message title")
                .perform();
        driver.verifyThat().element(warningMessageForDeeplinkTerminatedUserDescription)
                .textTrimmed().isEqualTo(terminatedWarningMessageDescriptionCL)
                .withCustomReportMessage("Validate Warning message description")
                .perform();
        return this;
    }

    public Dashboard validateMeineRechnungenPageTitle(){
        driver.verifyThat().element(myBillsPageTitle)
                .textTrimmed().isEqualTo(myBillsPageTitleCL)
                .withCustomReportMessage("Validate Meine Rechnungen page title")
                .perform();
        return this;
    }

    public Dashboard validateWarningMsgForTerminatedUserInMultiContracts(){
        driver.verifyThat().element(warningMessageForTerminatedUserTitle).textTrimmed()
                .isEqualTo(terminatedWarningMessageTitleCL)
                .withCustomReportMessage("Validate Warning message title")
                .perform();
        driver.verifyThat().element(warningMessageForTerminatedUserDescription).textTrimmed()
                .isEqualTo(terminatedWarningMessageDescriptionCL)
                .withCustomReportMessage("Validate Warning message description")
                .perform();
        return this;
    }

    public Dashboard validateDatenschutzAndWerbeeinstellungenSO(){
        driver.verifyThat().element(DatenschutzSmartObjectHeaderText)
                .textTrimmed().isEqualTo(Datenschutz_SO_HeaderText)
                .withCustomReportMessage("Check that Header exists for Datenschutz&Werbeeinstellungen SmartObject ")
                .perform();
        driver.verifyThat().element(DatenschutzSmartObjectFooterText)
                .textTrimmed().isEqualTo(Datenschutz_SO_FooterText)
                .withCustomReportMessage("Check that Footer exists for Datenschutz&Werbeeinstellungen SmartObject ")
                .perform();
        return this;
    }

    //wfbt-10604
    public Dashboard validateDatenSchutzLinkout(){
        driver.verifyThat().element(DATENSCHUTZ_MENU_ITEM_LINK).exists()
                .withCustomReportMessage("Check that DATENSCHUTZ linkout is exist")
                .perform();
        return this;
    }

    /* ***********WFCT-12607************ */

    @Step("Expand Contract Accordion With Order")
    public Dashboard expandContractAccordion(){
        driver.element().click(contractLocator);
        return this;
    }

    @Step("Click On Meine Rechnungen SO")
    public Dashboard clickOnMeineRehnungenSO(){
        driver.element().click(getMeineRehnungen);
        return this;
    }

    /* ********************** WFCT_8950 ***************************** */
    public By getMeineRechnungOrderedTileLocator(String contractOrder) {
        return By.xpath("(//div[@class='subTitle'][contains(.,'Vergleichen und herunterladen')])[" + contractOrder + "]");
    }

    public By getContractLocator(String contractsOrder) {
        return By.xpath("(//h2[@class='contractName'])[" + contractsOrder + "]");
    }

    @Step("Click on meine Rechnungen tile")
    public Dashboard clickMeineRechnungenTile() {
        driver.element().click(meineRechnungTileLocator);
        return this;
    }

    @Step("Click on Meine Rechnungen Tile")
    public Dashboard clickMeineRechnungenTile(String contractOrder) {
        driver.element().click(getMeineRechnungOrderedTileLocator(contractOrder));
        return this;
    }

    @Step("Expand contract")
    public Dashboard expandContracts(String contractsOrder) {
        driver.element().click(getContractLocator(contractsOrder));
        return this;
    }

    public Dashboard expandTorstenAccordionForSITCases(){
        driver.element().click(torstenAccordion);
        return this;
    }

    // Giga Tv
    @Step ("Click on Geräte & Einstellungen from the Kabel TV accordion's burger menu.")
    public Dashboard openGigaTVSettingsPageUsingBurgerMenuLinkout() {
        driver.element().isElementClickable(gigaTV_BurgerMenu);
        driver.element().click(gigaTV_BurgerMenu);
        driver.element().click(gigaTV_Setting_MenuElement);
        return this;
    }

    @Step("Expand Kabel TV accordion from the products section")
    public Dashboard expandKabelTVAccordion() {
        driver.element().click(kabelTV_ACC);
        return this;
    }

    @Step("Validate Giga TV Smart Object")
    public Dashboard validateGigaTvSO() {
        driver.verifyThat()
                .element(gigaTV_SO_Header)
                .textTrimmed()
                .contains(gigaTVSO_Header_CL)
                .withCustomReportMessage("Validate Giga TV Smart Object Header Text")
                .perform();
        driver.verifyThat()
                .element(gigaTV_SO_Footer)
                .textTrimmed()
                .contains(gigaTVSO_Footer_CL)
                .withCustomReportMessage("Validate Giga TV Smart Object Footer Text")
                .perform();
        return this;
    }

    // WFDT-8290 | Migrate to New Version of Contact Medium
    public Dashboard clickOnMeineDatenButton () {
        driver.element().click(meineDatenButton);
        return this;
    }

    /* ********************** WFCT_13466 ***************************** */
    public  static By getMeineDatenLocator(String contractOrder) {
        return By.xpath("(//a[@automation-id='Meine Daten_btn'])[" + contractOrder + "]");
    }

    @Step("click on meine kunden Daten button")
    public Dashboard clickOnMeineKundenDatenButton () {
        driver.element().click(meineKundenDatenButtonLocator);
        return this;
    }

    @Step("Click On Meine Daten Tile")
    public Dashboard clickOnMeineDatenTile(String contractOrder){
        driver.element().click(getMeineDatenLocator(contractOrder));
        return this;
    }

}
