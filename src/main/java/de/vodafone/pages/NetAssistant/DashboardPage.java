package de.vodafone.pages.NetAssistant;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.util.ArrayList;

import static de.vodafone.pages.utils.ElementActions.clickOnPopupElement;

public class DashboardPage {
    // Variables
    private SHAFT.GUI.WebDriver driver;

    private static int affectedServicesCount;
    //Locators
    private static By chatbotHeader = By.xpath("//*[@id='chatbot']");
    private static By logoutPage = By.xpath("/html/body/div[3]/div/div/div[1]/h1");
    private static By logoutButton = By.xpath("/html/body/div[3]/div/header/nav/div/div/div/div/ul[1]/li[3]/a/span");//a[@class='btn btn-alt']
    private static By ticketsPage = By.xpath("//div[@class='ticket-header']");
    private static By FirstContract = By.xpath("//*[@id='content']/div[2]/div/div/section/div/div/div[2]/div/div/ul/li[1]/a/span");
    public static By closeStickyNotification = By.xpath("//*[@class='icon-close-i-xxsml i-xxsml']");
    public static By cableAccordion = By.xpath("(//*[@id='dashboard:cable'])[2]");
    public static By internetAndPhoneAccordion = By.xpath("(//a[@class='subscription-heading' and contains(.,'Kabel Internet & Festnetz')])[1]");
    public static By infoserviceBeiStörungenSmartObject = By.xpath("//*[@automation-id='_so' and contains(.,'Infoservice')]");
    public static By subscriptionUnsubscribeButton = By.xpath("//*[@automation-id='unsubscribeButton_btn']");
    public static By saveButton = By.xpath("//*[@automation-id='saveButton_btn']");
    public static By subscriptionSuccessMessageHeader = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    public static By backButton = By.xpath("//*[@automation-id='back_Link']");
    public static By emailRadioButton = By.xpath("//*[@automation-id='channelRadio_rb'][1]//*[@class='bgdiv'][1]");
    public static By  AddressingSelectionCheckbox= By.xpath("//*[@automation-id='checkboxItemModel.id_label_tv']");
    public static By smsRadioButton = By.xpath("//*[@automation-id='channelRadio_rb'][2]//*[@class='bgdiv'][1]");
    private static By emailChannelRadioButton = By.xpath("//*[@automation-id='email_channel_rb']//ol-radio[@id='radioLi-1']");
    private static By smsChannelRadioButton = By.xpath("//*[@automation-id='sms_channel_rb']");
    private static By errorIcon = By.xpath("(//*[@class='i-sml i-red'])[1]");
    private static By acceptCookiesbutton = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private static By netAssistantSOLocator = By.xpath("//*[@automation-id='_so' and contains(.,'Netz-Assistent')]");
    private static By netAssistantSOLocatorSIT = By.xpath("(//smart-object/a/div)[3]");
    private static By netAssistantSOHeaderLocator = By.xpath("//*[@automation-id='internetAndPhone_so']//h3[contains(.,'Netz-Assistent')]");//*[@automation-id='_so']//h3[contains(.,'Netz-Assistent')]
    private static By NetAssistantSOFooterLocator = By.xpath("(//*[@automation-id='_so']//div/div[contains(.,'Verbindungsprobleme und Störungen lösen')])[1]");
    private static By dslAccordion = By.xpath("//*[@id='dashboard:fixed']");
    private static By dslAccordionSIT = By.xpath("//*[@id='dashboard:fixed'][3]");
    private static By dslBurgerMenu = By.xpath("//div[@class='expert-mode dots-menu']");//subscriber-bar-list//li[2]/a
    private static By dslStatusBurgerMenuItem = By.xpath("//span[@class='option-name' and contains(.,'Status')]");
    private static By dslProducteAccordionInternet = By.xpath("//*[@class='subscription-heading' and contains(.,'Meine Produkte')]");
    private static By dslProducteAccordionInternetSIT = By.xpath("//*[@class='subscription-heading' and contains(.,'Produkte')]");
    private static By checkBox = By.xpath("//*[@automation-id='checkboxItemModel.id_container_tv']");
    private static By multipleOutageCheckBox = By.xpath("//*[@automation-id='checkboxItemModel.id_labelHTML_tv']");
    private static By multipleOutageEmailRadioBtn = By.xpath("//ol-radio[@id='radioLi-1']//label");
    private static By multipleOutageSMSRadioBtn = By.xpath("//ol-radio[@id='radioLi-2']//label");
    private static By multipleOutageSaveButton = By.xpath("//button[@automation-id='set_channel_btn']");
    private static By multipleOutageEmailInput = By.xpath("//input[@automation-id='email_et']");
    private static By multipleOutageSMSInput = By.xpath("//input[@automation-id='mobile_phone_et']");
    private static By multipleOutageSpeichernBtn = By.xpath("//button[@automation-id='contact_data_btn']");
    private static By infoServiceSuccessMsg = By.xpath("//div[@automation-id='successMsg_tv']");
    private static By zurStartseiteDesNetzAssistentenBtn = By.xpath("//button[@automation-id='confirmation_msg _btn']");
    private static By tvAffectedService = By.xpath("//*[@automation-id='checkboxItemModel.id_labelHTML_tv' and contains(.,'TV')]");
    private static By alleBereicheAffectedService = By.xpath("(//*[@automation-id='checkboxItemModel.id_tv'])[1]");
    private static By infoZumStörungsendeMsg = By.xpath("//div[@automation-id='successMsg_tv']");
    private static By noOutageZurStartseiteDesNetzAssistentenBtn = By.xpath("//button[@automation-id='no_outage_btn']");
    public static By cableAccordionST = By.xpath("(//*[@id='dashboard:cable'])[1]");
    public static By internetAndPhoneAccordionST = By.xpath("(//a[@class='subscription-heading'])[4]");
    public static By infoServiceBeiStörungenSmartObjectST = By.xpath("//div[@automation-id='_so' and contains(.,'Infoservice bei Störungen')]");
    public static By infoServiceSuccessMessageTitle = By.xpath("//h4[@class='flexDiv']");
    public static By infoServiceSuccessMessageBody = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    public static By kontaktdatenLink = By.xpath("//a[@target='_blank']");
    public static By umAccordion = By.xpath("(//a[@automation_id='dashboard:unitymedia_acc'])[1]");
    public static By internetAndPhoneUMAccordion = By.xpath("(//a[@class='subscription-heading'])[1]");
    public static By netAssistantSOST = By.xpath("//*[contains(text(),'Netz-Assistent & Störungstickets')]");
    public static By loginIndicator = By.xpath("//div/div[2]/div/div/ul[2]/li[2]/a/span[2]");
    public static By contractChooseHeader = By.xpath("//div[@class='contracts-chooser']//div[@class='cta-item']");
    private static By netAssistantUMSO=By.xpath("//*[@automation-id='internetAndPhone_so' and contains(.,'Netz-Assistent')]/div[1]");
    private static By errorMessage = By.xpath("//*[@automation-id='undefined_nt']");
    private static By addContractButton = By.xpath("//*[@automation-id='undefined_btn']");
    private static By dslSOLocator= By.xpath("//ul[@class='subscriber-bar' and contains(.,'Produkte')]//div[@automation-id='_so' and contains(.,'Netz-Assistent')]");

    public static By getContractByName(String contractNumber){
        return By.xpath("//*[@automation-id='oneStepStepperHeader_tv' and contains(.,'"+contractNumber+"')]");}
    private static By getCableInternetTileByContract(String contractNumber){
        return By.xpath("//li[@automation-id='cableListContainerlv' and contains(.,'"+contractNumber+"')]//a[@class='subscription-heading' and contains(.,'Kabel Internet & Festnetz')]");}
    private static By getCableInternetTileByContractSIT(String contractNumber){
        return By.xpath("//li[@automation-id='cableListContainerlv' and contains(.,'"+contractNumber+"')]//a[@class='subscription-heading' and contains(.,'Kabel Internet & Festnetz')]");}
    private static By getUMInternetTileByContract(String contractNumber){
        return By.xpath("//li[@automation-id='unitymediaListContainerlv' and contains(.,'"+contractNumber+"')]//span[@class='mbo-name' and contains(.,'Internet & Phone-Produkte')]");}
    private static By getUMInternetTileByContractSIT(String contractNumber){
        return By.xpath("//li[@automation-id='unitymediaListContainerlv' and contains(.,'"+contractNumber+"')]//span[@class='mbo-name' and contains(.,'Internet & Festnetz')]");}
    private static By getContractTileUMSIT(String contractNumber){
        return By.xpath("//a[@id='dashboard:unitymedia' and contains(.,'"+contractNumber+"')]");}

    private static By getContractTileCableSIT(String contractNumber){
        return By.xpath("//a[@id='dashboard:cable' and contains(.,'"+contractNumber+"')]");}
    public static By getMultipleOutageRadioBtn(String index){
        return By.xpath("(//*[@automation-id='checkboxItemModel.id_tv'])["+index+"]");}

    //CLs
    public static String infoServiceSuccessMessageTitleCL = "Infoservice gebucht";
    public static String infoServiceSuccessMessageBodyCL = "Wir informieren Dich, wenn Dein Festnetz-Anschluss von einer Netzstörung betroffen ist";
    public static String subscriptionSuccessMessageHeaderCL = "Infoservice bei Störungen";
    public static String netAssistantSOHeaderLocatorCL = "Netz-Assistent";
    public static String netAssistantSOFooterLocatorCL = "Verbindungsprobleme und Störungen lösen";
    public static String contractChooserHeaderCL = "Bitte Vertrag oder Teilnehmer auswählen";
    private static String NoContractErrorMessageHeaderCL = "Das geht leider nicht";
    private static String NoContractErrorMessageCL = "Füg zuerst Deinen Vertrag oder Teilnehmer in MeinVodafone hinzu. Versuch es danach bitte nochmal.";
    private static String infoSubscriptionSuccessMsgCL = "Geschafft!Wir schicken Dir eine E-Mail, wenn die Störung behoben ist.Zur Startseite des Netz-Assistenten";
    private static String infoSubscriptionFailureMsgCL = "Das funktioniert gerade nichtLeider steht der Service momentan nicht zur Verfügung. Versuch es bitte später nochmal.";
    private static String infoZumStörungsendeMsgHeaderCL = "Im Moment gibt es keine Störung";
    private static String infoZumStörungsendeMsgBodyCL = "Gute Nachrichten: Die Störung wurde schon behoben.";


    //constructor
    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Getters
    public static By getLogoutPage() {
        return logoutPage;
    }

    public static By getFirstContract() {
        return FirstContract;
    }

    public static By getTicketsPage() {
        return ticketsPage;
    }

    public static By getLogoutButton() {
        return logoutButton;
    }

    public static By getNetAssistantSOLocator() {
        return netAssistantSOLocator;
    }

    public static By getNetAssistantSOLocatorSIT() {
        return netAssistantSOLocatorSIT;
    }

    public static By getNetAssistantSOHeaderLocator() {
        return netAssistantSOHeaderLocator;
    }

    public static By getNetAssistantSOFooterLocator() {
        return NetAssistantSOFooterLocator;
    }

    public static By getCableAccordion() {
        return cableAccordion;
    }

    public static By getInternetAndPhoneAccordion() {
        return internetAndPhoneAccordion;
    }

    public static By getDslAccordion() {
        return dslAccordion;
    }

    public static By getDslAccordionSIT() {
        return dslAccordionSIT;
    }

    public static By getDslProducteAccordionInternet() {
        return dslProducteAccordionInternet;
    }

    public static By getDslProducteAccordionInternetSIT() {
        return dslProducteAccordionInternetSIT;
    }

    public static By getBackButton() {
        return backButton;
    }

    public static By getEmailRadioButton() {
        return emailRadioButton;
    }

    public static By getAddressingSelection()
    {
        return AddressingSelectionCheckbox;
    }

    public static By getSmsRadioButton() {
        return smsRadioButton;
    }

    public static By getInfoServiceSmartObject() {
        return infoserviceBeiStörungenSmartObject;
    }

    public static By getSaveButton() {
        return saveButton;
    }

    public static By getCheckBox() {
        return checkBox;
    }

    public static By getCableAccordionST() {
        return cableAccordionST;
    }

    public static By getInternetAndPhoneAccordionST() {
        return internetAndPhoneAccordionST;
    }

    public static By getInfoServiceSmartObjectST() {
        return infoServiceBeiStörungenSmartObjectST;
    }

    public static By getErrorIcon() {
        return errorIcon;
    }

    public static By getKontaktdatenLink() {
        return kontaktdatenLink;
    }

    public static By getUnityMediaAccordion() {
        return umAccordion;
    }

    public static By getInternetAndPhoneUMAccordion() {
        return internetAndPhoneUMAccordion;
    }

    public static By getDslBurgerMenu() {
        return dslBurgerMenu;
    }

    public static By getDslStatusBurgerMenuItem() {
        return dslStatusBurgerMenuItem;
    }

    public static By getNetAssistantSOST() {
        return netAssistantSOST;
    }

    public static By getLoginIndicator() {
        return loginIndicator;
    }

    public static By getSubscriptionSuccessMessageHeader() {
        return subscriptionSuccessMessageHeader;
    }

    public static By getInfoServiceSuccessMessageTitle() {
        return infoServiceSuccessMessageTitle;
    }

    public static By getInfoServiceSuccessMessageBody() {
        return infoServiceSuccessMessageBody;
    }

    public static By getSubscriptionUnsubscribeButton() {
        return subscriptionUnsubscribeButton;
    }

    public static By getAcceptCookiesbutton() {
        return acceptCookiesbutton;
    }

    public static By getCloseStickyNotification() {
        return closeStickyNotification;
    }


    //Methods
    @Step("Navigate Method without deeplink")
    public DashboardPage navigate() {
        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.st"));
        return this;
    }

    @Step("Accept Cookies")
    public DashboardPage acceptCookies() {
        driver.element().click(getAcceptCookiesbutton());
        return this;
    }
    @Step("Click on elements")
    public DashboardPage clickOn(By Element) {
        driver.element().click(Element);
        return this;
    }
    @Step("Validate email subscription confirmation action")
    public DashboardPage subscriptionEmailConfirmationAction() {
        driver.element().click(getAddressingSelection());
        driver.element().click(getEmailRadioButton());
        driver.element().click(getSaveButton());
        return this;
    }
    @Step("Validate un-subscription action")
    public DashboardPage unsubscribeAction() {
        driver.element().click(getSubscriptionUnsubscribeButton());
        driver.element().isElementDisplayed(subscriptionSuccessMessageHeader);
        driver.element().click(getBackButton());
        return this;
    }
    @Step("Close sticky notifications with wait action")
    public DashboardPage closeStickyNotificationsWithWait(By accordion) {
        driver.element().click(getCloseStickyNotification());
        driver.element().click(getCloseStickyNotification());
        driver.element().waitToBeReady(accordion);
        return this;
    }
    @Step("Get mass outage message")
    public DashboardPage readMessageWithWait(String Element)
    {

        driver.element().waitForTextToChange(ChatbotPage.getNewMassoutageMsg(),Element);
        return this;
    }
    @Step("Close sticky notifications")
    public DashboardPage closeStickyNotifications() {
        driver.element().click(getCloseStickyNotification());
        //driver.element().click(getCloseStickyNotification());
        //
        return this;
    }


    @Step("Swtich to another tab")
    public DashboardPage switchToTab() {
        ArrayList<String> tabs = new ArrayList<String>(driver.getDriver().getWindowHandles());
        driver.browser().switchToWindow(tabs.get(tabs.size()-1));
        return this;
    }

    @Step("Navigate Method with deeplink")
    public DashboardPage navigate(String deepLink) {

        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + deepLink);
        return this;
    }
    @Step("Open net assistant smart object")
    public DashboardPage clickOnNetAssSODSL() {
        driver.element().click(getDslAccordion());
        driver.element().click(getDslProducteAccordionInternet());
        driver.element().click(getNetAssistantSOLocator());
        return this;
    }

    @Step("Open net assistant smart object")
    public DashboardPage clickOnNetAssSODSLSIT() {
        driver.element().click(getDslAccordionSIT());
        driver.element().click(getDslProducteAccordionInternetSIT());
        driver.element().click(getNetAssistantSOLocatorSIT());
        return this;
    }

    @Step("Open net assistant smart object burger menu")
    public DashboardPage clickOnNetAssistantSOBurgerMenuDSL() {
      //  driver.element().click(getDslAccordion());
        driver.element().click(getDslBurgerMenu());
        driver.element().click(getDslStatusBurgerMenuItem());
        clickOnPopupElement(driver,getNetAssistantSOST());
        return this;
    }
    @Step("Validate save indicator exists")
    public DashboardPage validateSaveIndicatorExists() {
        driver.assertThat()
                .element(getSaveButton())
                .exists()
                .withCustomReportMessage("Save Button Exists Successfully")
                .perform();
        return this;
    }
    @Step("Validate save button is disbaled")
    public DashboardPage validateSaveButtonDisabled() {
        driver.assertThat()
                .element(getSaveButton())
                .isDisabled()
                .withCustomReportMessage("Save button disabled")
                .perform();
        return this;
    }
    @Step("Validate checkbox exists")
    public DashboardPage validateCheckBoxExists() {
        driver.assertThat()
                .element(getCheckBox())
                .exists()
                .withCustomReportMessage("Checkobox exists")
                .perform();
        return this;
    }
    @Step("Validate email radio button exists")
    public DashboardPage validateEmailRadioButtonExists() {
        driver.assertThat()
                .element(getEmailRadioButton())
                .exists()
                .withCustomReportMessage("email radio button exists")
                .perform();
        return this;
    }
    @Step("Validate SMS radio button exists")
    public DashboardPage validateSmsRadioButtonExists() {
        driver.assertThat()
                .element(getSmsRadioButton())
                .exists()
                .withCustomReportMessage("Sms radio button exists")
                .perform();
        return this;
    }
    @Step("Validate email radio button is disabled")
    public DashboardPage validateEmailRadioButtonDisabled() {
        driver.assertThat()
                .element(getEmailRadioButton())
                .isDisabled()
                .perform();
        return this;
    }
    @Step("Validate SMS radio button is disabled")
    public DashboardPage validateSmsRadioButtonDisabled() {
        driver.assertThat()
                .element(getSmsRadioButton())
                .isDisabled()
                .perform();
        return this;
    }
    @Step("Validate email radio button is visible")
    public DashboardPage validateEmailRadioButtonVisible() {
        driver.assertThat()
                .element(getEmailRadioButton())
                .isVisible()
                .withCustomReportMessage("email radio button Enabled")
                .perform();
        return this;
    }
    @Step("Validate SMS radio button is visible")
    public DashboardPage validateSmsRadioButtonVisible() {
        driver.assertThat()
                .element(getSmsRadioButton())
                .isVisible()
                .withCustomReportMessage("Sms radio button Enabled")
                .perform();
        return this;
    }
    @Step("Validate success subscription message header CL")
    public DashboardPage validateSubscriptionSuccessMessageHeaderText() {
        driver.verifyThat()
                .element(getSubscriptionSuccessMessageHeader())
                .text()
                .isEqualTo(subscriptionSuccessMessageHeaderCL)
                .perform();
        return this;
    }
    @Step("Validate success subscription message title CL")
    public DashboardPage validateSubscriptionSuccessMessageTitleText() {
        driver.assertThat()
                .element(getInfoServiceSuccessMessageTitle())
                .text()
                .contains(infoServiceSuccessMessageTitleCL)
                .withCustomReportMessage("Info service success message title exists successfully")
                .perform();
        return this;
    }
    @Step("Validate success subscription message body CL")
    public DashboardPage validateSubscriptionSuccessMessageBodyText() {
        driver.assertThat()
                .element(getInfoServiceSuccessMessageBody())
                .text()
                .contains(infoServiceSuccessMessageBodyCL)
                .withCustomReportMessage("Info service success message Body exists successfully")
                .perform();
        return this;
    }
    @Step("Validate tickets page is displayed")
    public DashboardPage validateTicketsPageDisplayed() {
        driver.assertThat()
                .element(ticketsPage)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate logout button is displayed")
    public DashboardPage validateLogoutButtonDisplayed() {
        driver.assertThat()
                .element(getLogoutButton())
                .exists()
                .withCustomReportMessage("logout button displayed")
                .perform();
        return this;
    }
    @Step("Validate logout button is displayed")
    public DashboardPage validateLogoutPageDisplayed() {
        driver.assertThat()
                .element(getLogoutPage())
                .exists()
                .withCustomReportMessage("logout page displayed")
                .perform();
        return this;
    }
    @Step("Validate error icon is displayed")
    public DashboardPage validateErrorIconDisplayed() {
        driver.assertThat()
                .element(getErrorIcon())
                .isVisible()
                .withCustomReportMessage("Error Icon exists")
                .perform();
        return this;
    }
    @Step("Validate contracts exist")
    public DashboardPage validateContractsExist() {
        driver.assertThat()
                .element(getFirstContract())
                .exists()
                .withCustomReportMessage("1st contract Exists Successfully")
                .perform();
        return this;
    }
    @Step("Validate net assistant smart object is existing")
    public DashboardPage validateNetAssistantSmartObjectLocatorExist() {
        driver.assertThat()
                .element(getNetAssistantSOLocator())
                .exists()
                .perform();
        return this;
    }
    @Step("Validate net assistant smart object header locator CL")
    public DashboardPage validateNetAssistantSmartObjectHeaderLocatorText() {
        driver.assertThat()
                .element(getNetAssistantSOHeaderLocator())
                .text()
                .isEqualTo(netAssistantSOHeaderLocatorCL)
                .perform();
        return this;
    }
    @Step("Validate net assistant smart object footer locator CL")
    public DashboardPage validateNetAssistantSmartObjectFooterLocatorText() {
        driver.assertThat()
                .element(getNetAssistantSOFooterLocator())
                .text()
                .isEqualTo(netAssistantSOFooterLocatorCL)
                .perform();
        return this;
    }
    @Step("Validate back button exists")
    public DashboardPage validateBackButtonExists() {
        driver.assertThat()
                .element(getBackButton())
                .exists()
                .withCustomReportMessage("Back Button exists")
                .perform();
        return this;
    }
    @Step("Validate login indicator exists")
    public DashboardPage validateLoginIndicatorExists() {
        driver.assertThat()
                .element(getLoginIndicator())
                .exists()
                .withCustomReportMessage("Login Indicator exists Successfully")
                .perform();
        return this;
    }
    @Step("Validate contract chooser appears")
    public DashboardPage validateContractChooserPage()
    {
        driver.assertThat()
                .element(contractChooseHeader)
                .text()
                .contains(contractChooserHeaderCL)
                .perform();
        return this;
    }

    @Step("Validate error that there is no contracts exists")
    public DashboardPage validateNoContractError()
    {
        driver
                .assertThat()
                .element(errorMessage)
                .exists()
                .perform();


        driver.assertThat()
                .element(errorMessage)
                .text()
                .contains(NoContractErrorMessageHeaderCL)
                .perform();

        driver.assertThat()
                .element(errorMessage)
                .text()
                .contains(NoContractErrorMessageCL)
                .perform();


        return this;
    }
    @Step("Validate add contract button exists")
    public DashboardPage validateAddContractBtnExists()
    {
        driver
                .assertThat()
                .element(addContractButton)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate URL redirection for Cable SO")
    public DashboardPage validateSORedirectionCable()
    {
        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("i=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("c=CABLE")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .contains("icmp=mvw_db_netzass_kip")
                .perform();
        return this;
    }
    @Step("Validate URL redirection for UM SO")
    public DashboardPage validateSORedirectionUM()
    {
        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("i=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("c=UM")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("s=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .contains("icmp=mvw_db_netzass_um")
                .perform();
        return this;
    }

    @Step("Validate URL redirection for DSL Helpform")
    public DashboardPage validateSORedirectionDSL()
    {
        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("i=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("c=DSL")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .doesNotContain("a=")
                .perform();

        driver.assertThat()
                .browser()
                .url()
                .contains("icmp=mvw_db_netzass_dsl")
                .perform();
        return this;
    }

    @Step("Click on NetAssistant SO for Cable from accordion")
    public DashboardPage clickOnNetAssSOCable()
    {
     driver.element().click(internetAndPhoneAccordion);
     clickOnPopupElement(driver,netAssistantSOLocator);
     return this;
    }

    @Step("Click on NetAssistant SO for UM from accordion")
    public DashboardPage clickOnNetAssSOUM()
    {
        driver.element().click(internetAndPhoneUMAccordion);
        clickOnPopupElement(driver,netAssistantUMSO);
        return this;
    }
    @Step("Switch to another tab by index")
    public DashboardPage switchToTabByIndex(int index){
        ArrayList<String> tabs = new ArrayList<String> (driver.getDriver().getWindowHandles());
        driver.browser().switchToWindow(tabs.get(index));
        return this;
    }
    @Step("Click on NetAssistant ST SO for Cable from accordion")
    public DashboardPage clickOnNetAssSOCableST()
    {
        driver.element().click(internetAndPhoneAccordionST);
        driver.element().click(netAssistantSOLocator);
        return this;
    }

    @Step("Navigate Method without deeplink SIT")
    public DashboardPage navigateSIT(String deepLink)
    {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit")+ deepLink);
        return this;
    }

    @Step("Select Netassistant SO for cable")
    public DashboardPage getCableSO(String contractNumber)
    {
        clickOn(getCableInternetTileByContract(contractNumber));
        clickOnPopupElement(driver,netAssistantSOLocator);
        return this;
    }

    @Step("Select Netassistant SO for cable SIT environment")
    public DashboardPage getCableSOSIT(String contractNumber)
    {
        clickOn(getCableInternetTileByContractSIT(contractNumber));
        clickOn(netAssistantSOLocator);
        return this;
    }

@Step("Select Netassistant SO for UM")
public DashboardPage getUmSO(String contractNumber)
{
    clickOn(getUMInternetTileByContract(contractNumber));
    clickOnPopupElement(driver,netAssistantUMSO);
    return this;
}
    @Step("Select Netassistant SO for UM SIT environment")
    public DashboardPage getUmSOSIT(String contractNumber)
    {
        clickOn(getUMInternetTileByContractSIT(contractNumber));
        clickOnPopupElement(driver,netAssistantUMSO);
        return this;
    }
    @Step("expandContractTile UM")
    public DashboardPage expandContractTileUM(String contractNumber)
    {
        clickOn(getContractTileUMSIT(contractNumber));
        return this;
    }

    @Step("expandContractTile Cable")
    public DashboardPage expandContractTileCable(String contractNumber)
    {
        clickOn(getContractTileCableSIT(contractNumber));
        return this;
    }

    @Step("Select Netassistant SO for dsl")
    public DashboardPage getDSLSO()
    {
        clickOnPopupElement(driver,dslSOLocator);
        return this;
    }

    @Step("Click on Chatbot tab header")
    public DashboardPage clickChatbotHeader()
    {
        driver.element().click(chatbotHeader);
        return this;
    }

    @Step("Validate email subscription confirmation action")
    public DashboardPage subscriptionSMSConfirmationAction() {
        driver.element().click(AddressingSelectionCheckbox);
        driver.element().click(smsRadioButton);
        driver.element().click(saveButton);
        return this;
    }

    @Step("Validate multiple outage email subscription confirmation action")
    public DashboardPage multipleOutageSubscriptionEmailConfirmationAction(String emailAddress) {
        driver.element().click(multipleOutageCheckBox);
        driver.element().click(multipleOutageEmailRadioBtn);
        driver.element().click(multipleOutageSaveButton);
        driver.element().type(multipleOutageEmailInput,emailAddress);
        driver.element().click(multipleOutageSpeichernBtn);
        return this;
    }

    @Step("Validate resolved multiple outage email subscription confirmation action")
    public DashboardPage resolvedMultipleOutageSubscriptionSMSConfirmationAction(String mobileNumber) {
        driver.element().click(tvAffectedService);
        driver.element().click(multipleOutageSMSRadioBtn);
        driver.element().click(multipleOutageSaveButton);
        driver.element().type(multipleOutageSMSInput,mobileNumber);
        driver.element().click(multipleOutageSpeichernBtn);
        return this;
    }

    @Step("Validate multiple outage info subscription success message")
    public DashboardPage validateMultipleOutageInfoSubscriptionSuccess()
    {
        driver.element().assertThat(infoServiceSuccessMsg).exists().perform();
        driver.element().assertThat(infoServiceSuccessMsg).textTrimmed().isEqualTo(infoSubscriptionSuccessMsgCL).perform();
        return this;
    }

    @Step("Validate multiple outage info subscription error message")
    public DashboardPage validateMultipleOutageInfoSubscriptionError()
    {
        driver.element().assertThat(infoServiceSuccessMsg).exists().perform();
        driver.element().assertThat(infoServiceSuccessMsg).textTrimmed().contains(infoSubscriptionFailureMsgCL).perform();
        driver.element().assertThat(zurStartseiteDesNetzAssistentenBtn).exists().perform();
        return this;
    }

    @Step("click on zurStartseiteDesNetzAssistenten Button")
    public DashboardPage clickOnzurStartseiteDesNetzAssistentenBtn()
    {
        clickOn(zurStartseiteDesNetzAssistentenBtn);
        return this;
    }

    @Step("Validate that speichern button dimmed when no service is choosen")
    public DashboardPage validateSpeichernButtonDimmed()
    {
        driver.element().assertThat(multipleOutageSaveButton).isDisabled().perform();
        return this;
    }

    @Step("Validate that info subscription channels are dimmed")
    public DashboardPage validateInfoSubscriptionChannelsDimmed()
    {
        driver.element().assertThat(emailChannelRadioButton).isDisabled().perform();
        driver.element().assertThat(smsChannelRadioButton).isDisabled().perform();
        return this;
    }

    @Step("click on TV affected service radio button")
    public DashboardPage clickOnTVAffectedServiceRadioBtn()
    {
        clickOn(tvAffectedService);
        return this;
    }

    @Step("Validate that Alle Bereiche checkbox controls all affected services radio buttons")
    public DashboardPage validateAlleBereicheControlsAllAffectedServicesCheckBoxes()
    {
        affectedServicesCount = driver.element().getElementsCount(multipleOutageCheckBox);

        clickOn(alleBereicheAffectedService);
        for(int index= 1 ; index<= affectedServicesCount ;index++)
        {
            driver.element().assertThat(getMultipleOutageRadioBtn(String.valueOf(index))).isChecked().perform();
        }

        clickOn(alleBereicheAffectedService);
        for(int index= 1 ; index<= affectedServicesCount ;index++)
        {
            driver.element().assertThat(getMultipleOutageRadioBtn(String.valueOf(index))).isNotChecked().perform();
        }
        return this;
    }

    @Step("Validate that speichern button will be dimmed when invalid email is entered")
    public DashboardPage validateSpeichernBtnIsDimmedWithInvalidEmail(String emailAddress)
    {
        driver.element().click(alleBereicheAffectedService);
        driver.element().click(multipleOutageEmailRadioBtn);
        driver.element().click(multipleOutageSaveButton);
        driver.element().type(multipleOutageEmailInput,emailAddress);
        driver.element().assertThat(multipleOutageSpeichernBtn).isDisabled().perform();
        return this;
    }

    @Step("Refresh current page")
    public DashboardPage refreshCurrentPage()
    {
        driver.browser().refreshCurrentPage();
        return this;
    }

    @Step("Validate that speichern button will be dimmed when invalid mobile number is entered")
    public DashboardPage validateSpeichernBtnIsDimmedWithInvalidMobileNumber(String mobileNumber)
    {
        driver.element().click(alleBereicheAffectedService);
        driver.element().click(multipleOutageSMSRadioBtn);
        driver.element().click(multipleOutageSaveButton);
        driver.element().type(multipleOutageSMSInput,mobileNumber);
        driver.element().assertThat(multipleOutageSpeichernBtn).isDisabled().perform();
        return this;
    }

    @Step("Click pn Abbrechen button")
    public DashboardPage clickOnAbbrechenBtn()
    {
        driver.element().click(backButton);
        return this;
    }

    @Step("Validate that user choices are saved")
    public DashboardPage validateChoicesAreSaved()
    {
        driver.element().assertThat(alleBereicheAffectedService).isChecked().perform();
        return this;
    }

    @Step("validate that info ZumStörungsende message is appearing when mass outage is resolved")
    public DashboardPage validateinfoZumStörungsendeMsgExists()
    {
        driver.assertThat().element(infoZumStörungsendeMsg).exists().perform();
        return this;
    }

    @Step("validate that zur Startseite Des Netz-Assistenten button exists when mass outage is resolved")
    public DashboardPage validatezurStartseiteDesNetzAssistentenBtnExists()
    {
        driver.assertThat().element(noOutageZurStartseiteDesNetzAssistentenBtn).exists().perform();
        return this;
    }

    @Step("validate that info ZumStörungsende message CL appearing when mass outage is resolved")
    public DashboardPage validateinfoZumStörungsendeMsgCLExists()
    {
        driver.element().assertThat(infoZumStörungsendeMsg).text().contains(infoZumStörungsendeMsgHeaderCL).perform();
        driver.element().assertThat(infoZumStörungsendeMsg).text().contains(infoZumStörungsendeMsgBodyCL).perform();
        return this;
    }

    @Step("Click on cables info subscription SO")
    public DashboardPage clickOnCableInfoSubscriptionSO()
    {
            driver.element().click(cableAccordionST);
            driver.element().click(internetAndPhoneAccordion);
            driver.element().click(infoServiceBeiStörungenSmartObjectST);
            return this;
    }

    @Step("Click on cable checkbox in infosubscription SO screen")
    public DashboardPage clickOnCableCheckBoxInfoSubscriptionSO()
    {
        driver.element().click(checkBox);
        return this;
    }
}


