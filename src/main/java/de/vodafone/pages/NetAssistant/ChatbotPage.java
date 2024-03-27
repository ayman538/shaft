package de.vodafone.pages.NetAssistant;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static de.vodafone.pages.utils.ElementActions.clickOnPopupElement;

public class ChatbotPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;

    //CLs
    private String memoInputInfoMsgCL = "Die Postnummer ist Deine DHL Kundennummer.Du kannst sie in Deinemr DHL Kundenkunto einsehen";
    private String memoInputInfoMsgSITCL = "Bei DHL Packstation finden kannst du die nächste Packstation finden.";
    private String memoInputInfoHyperlinkCL = "DHL Kundenkunto";
    private String memoInputInfoHyperlinkSITCL = "DHL Packstation finden";
    private String oldMemoInputInfoMsgCL = "Nur deutsche Rufnummern sind möglich.";
    public static String newMassoutageMsgUMCableCL="Es tut uns leid, dass Dein Anschluss gerade nicht funktioniert. Meld uns das bitte hier, dann kümmern wir uns darum. Nutz dafür die Benachrichtigungsfunktion. Oder ruf uns an unter 0800 52 666 25.";
    public static String affectedServicesEmptyArrayCL="Alle Produkte: Internet, Festnetz-Telefonie, TV";
    public static String affectedServicesCL="RADIO, TV";
    public static String newMassoutageMsgDSLCL ="Leider gibt es gerade eine Netz-Störung, entschuldige bitte.\n" +
            "Aber unsere Techniker arbeiten schon dran.\n"+
            "Wir beeilen uns – versprochen!";
    public static String noMassoutageMsgDSLCL ="Eine Netz-Störung ist uns in Deiner Region nicht bekannt. Es muss an etwas anderem liegen.";

    public static String generalMessageCL ="In Deiner Region ist uns keine Störung bekannt.";

    public static String jaMessageCL = "Welches Problem hast Du?";

    public static String questionTwoCL = "Willst Du mit dem Netz-Assistenten auf weitere Fehlersuche gehen?";
    private static String welcomeMessageCL = "Hallo, ich bin Dein Netz-Assistent. Ich helfe Dir, wenn’s irgendwo hakt. Lass uns zusammen loslegen. Logg Dich dafür erst bei MeinVodafone ein. Du hast noch kein Konto? Dann registrier Dich einfach. So kann ich Dir immer schnell helfen.";
    private static String endMessageCL = "Schade. Du kannst den Netz-Assistenten nur nutzen, wenn Du eingeloggt bist.";
    private static String welcomeMsgNewCL = "Hallo, du bist eingeloggt.";
    private static String regexFailureMsgCL = "Vertippt? Überprüf Deine Eingabe bitte nochmal.";
    private static String callBackNoNumberErrorCL = "Das Feld darf nicht leer sein.";
    private static String callBackWrongNumberFormatErrorCL = "Gib Deine Nummer mit Vorwahl ein. Ohne Sonder- oder Leerzeichen. Beispiel: 017212345678.";
    private static String invalidDateErrorCL = "Wähl heute oder ein Datum in der Vergangenheit.";
    private static String invalidTimeErrorCL = "Wähl eine Zeit in der Vergangenheit.";
    private static String DateMandatoryFieldUnfilledErrorCL = "Das Feld darf nicht leer sein.";
    private static String TimeMandatoryFieldUnfilledErrorCL = "Das Feld darf nicht leer sein.";
    //Locators
    private static By newMassoutageMsg = By.xpath("//app-system-info-message/div/div");
    private static By affectedServicesEmptyArray = By.xpath("(//div[@class='extra-text']/span)[2]");
    private static By affectedServices = By.xpath("(//div[@class='extra-text']/span)[2]");
    private static By firstQuestion = By.xpath("//*[@automation-id='undefined_tv']");
    private static By secondQuestion = By.xpath("//*[@automation-id='helpFlowText_tv']");
    private static By systemMessage = By.xpath("//*[@id='content']/div[2]/div/div/section/div/div/div/app-root/div/app-chatbot-window/div/div/app-network-outage/system-info-message");
    private static By noMassOutageSystemMessage = By.xpath("//app-system-info-message/div/div/div[2]/span");
    private static By neinButton = By.xpath("//*[@automation-id='helpFlowNo_btn']");
    private static By jaButton = By.xpath("//*[@automation-id='helpFlowYes_btn']");
    private static By zuMeinenTicketsButton = By.xpath("//*[@automation-id='helpFlowTicket_btn']");

    private static By jaButton2ST = By.xpath("//div/div[3]/app-button/div/div[1]");
    private static By jaButtonWelcomeFlow = By.xpath("//*[@automation-id='welcomePageYes_btn']");
    private static By neinMessage = By.xpath("//*[@automation-id='endhelpFlowMessage_tv']");
    private static final By jaMessage = By.xpath("//*[@automation-id='SL13287254544627181_11070_tv']");
    private static By acceptCookiesButton =By.xpath("//button//span[contains(text(),'ablehnen')]");
    private static By verkabelungWlanCableButton = By.xpath("//*[@id='chatbot-container']/app-user[2]/div/div[3]/app-button/div/div[1]");
    private static By verkabelungWlanDSLButton = By.xpath("//*[@id='chatbot-container']/app-user[1]/div/div[3]/app-button/div/div[1]");
    private static By wlanEmpfangSchlechtButton = By.xpath("//*[@id='chatbot-container']/app-user[3]/div/div[3]/app-button/div/div[4]");
    private static By goonButton =By.xpath("//*[@id='chatbot-container']/app-user/div/div[3]/app-button/div/div");
    private static By wohnungOptionButton =By.xpath("//*[@id='chatbot-container']/app-user[4]/div/div[3]/app-button/div/div[3]");
    private static By imKellerOptionButton = By.xpath("//*[@id='chatbot-container']/app-user[5]/div/div[3]/app-button/div/div[4]");
    private static By inRäumenOptionButton = By.xpath("//*[@id='chatbot-container']/app-user[6]/div/div[3]/app-button/div/div[2]");
    private static By streamingButton = By.xpath("//*[@id='chatbot-container']/app-user[7]/div/div[3]/app-button/div/div[3]");
    private static By rückrufnummerInputField = By.xpath("//*[@automation-id='phoneNumber_et']");
    private static By datePickerInputField = By.xpath("//*[@automation-id='dateInput_et']");
    private static By timePickerInputField = By.xpath("//*[@automation-id='timeInput_et']");
    private static By optionalField =By.xpath("//*[@automation-id='SL13287254544627181_15170_et']");
    private static By MandatoryField =By.xpath("//*[@automation-id='SL13287254544627181_16170_et']");
    private static By MandatoryFieldSIT =By.xpath("//*[@automation-id='SL2413186112800_72733_et']");
    private static By MandatoryFieldRedBorder = By.xpath("//*[@automation-id='SL13287254544627181_16170_et']");
    private static By MandatoryFieldRedBorderSIT = By.xpath("//*[@automation-id='SL2413186112800_72733_et']");
    private static By MandatoryFieldErrorMessage =By.xpath("//*[@automation-id='SL13287254544627181_16170requiredErrorMessage_et']");
    private static By MandatoryFieldErrorMessageSIT =By.xpath("(//div[@class='fm-formerror error-body'])[1]");
    private static By submitButtonField = By.xpath("//*[@automation-id='timeDatePickerSubmit_btn']");
    private static By submitMandatoryFieldButton = By.xpath("//app-formular-answer/div/form/div[2]/div");
    private static By checkBoxCable = By.xpath("//*[@automation-id='checkboxItemModel.id_tv']");
    private static By checkBoxDSL =By.xpath("//*[@automation-id='checkboxItemModel.id_tv']");
    private static By checkBoxDSLST =By.xpath("//*[@automation-id='checkboxItemModel.id_container_tv']");
    private static By rückrufAnfordernCableButton = By.xpath("//button[@type='submit']");
    private static By neuStartenButton = By.xpath("//div[2]/div[2]/div/div");
    private static By keinInternetCableButton = By.xpath("//*[@id='chatbot-container']/app-user/div/div[3]/app-button/div/div[1]");
    private static By keinInternetDSLButton = By.xpath("//*[@id='chatbot-container']/app-user[2]/div/div[3]/app-button/div/div[1]");
    private static By easyBoxRouter = By.xpath("//*[@id='chatbot-container']/app-user[3]/div/div[3]/app-button/div/div[1]");
    private static By lanKabelCableButton = By.xpath("//*[@id='chatbot-container']/app-user[4]/div/div[3]/app-button/div/div[1]");
    private static By ausButton1 = By.xpath("//*[@id='chatbot-container']/app-user[5]/div/div[3]/app-button/div/div[4]");
    private static By ausButton2 = By.xpath("//*[@id='chatbot-container']/app-user[6]/div/div[3]/app-button/div/div[3]");
    private static By funktioniertButton = By.xpath("//*[@id='chatbot-container']/app-user[6]/div/div[3]/app-button/div/div[1]");
    private static By rückrufAnfordernDSLButton1 = By.xpath("//*[@id='chatbot-container']/app-user[7]/div/div[3]/app-button/div/div");
    private static By rückrufAnfordernDSLButton2 = By.xpath("//div/div[3]/app-callback/div/form/div[2]/div");
    private static By rückrufAnfordernDSLButtonST = By.xpath("//div/div[3]/app-callback/div/form/div[2]");
    private static By massOutageMessage = By.xpath("//app-system-info-message/div/div/div[2]");
    private static By question1   = By.xpath("//*[@automation-id='SL12119385304200_83668_tv']");

    private static By question1UM = By.xpath("//*[@automation-id='SL19782529998000_38949_tv']");
    private static By infoIcon = By.xpath("//*[@id='content']/div[2]/div/div/section/div/div/div/app-root/div/app-chatbot-window/div/div/app-network-outage/system-info-message/div/div/div[1]");
    private static  By memoInfoIcon = By.xpath("//a[@class='tg-icon']");
    private static By memoInfoIconLable2 = By.xpath("(//div[@class='tg-label'])[2]//a[@class='tg-icon']");
    private static  By closeMemoInfo = By.cssSelector("a.tg-icon:nth-child(2)");
    private static By tobiIcon = By.xpath("//*[@id='content']/div[2]/div/div/section/div/div/div/app-root/div/app-chatbot-window/div/div/app-system/div/div[1]");
    private static By tobiIconDesktop = By.xpath("(//div[@class='svg-wrapper'])[1]");
    private static By welcomeMessage = By.xpath("//*[@automation-id='welcomeMessageText_tv']");
    private static By neinButtonWelcomeFlow = By.xpath("//button[@automation-id='welcomePageNo_btn']");
    private static By endMessage = By.xpath("//*[@automation-id='endMessageText_tv']");

    //Headers for Net Assistant Tabs
    private static By chatbotTabHeader = By.xpath("//*[@id='chatBot']");
    private static By ticketsTabHeader = By.xpath("//*[@id='tickets']");
    private static By NAImage = By.xpath("//img[@automation-id='undefined_img']");

    //Headers for Net Assistant WelcomePage
    private static By chatbotWelcomeMsg = By.xpath("//*[@automation-id='welcomeMessageText_tv']");
    private static By chatbotThanksMsg = By.xpath("//*[@automation-id='endMessageText_tv']");
    private static By loginButtonWelcomePage = By.xpath("//*[@automation-id='welcomePageYes_btn']");
    private static By neinButtonWelcomePage = By.xpath("//*[@automation-id='welcomePageNo_btn']");
    private static By registerButtonWelcomePage = By.xpath("//*[@automation-id='welcomePageRegister_btn']");
    private static By registerPage = By.xpath("//*[@class='title-ecare overview']");
    private static By refreshButtonWelcomePage = By.xpath("//*[@automation-id='refreshBtn_btn']");
    private static By firstHyperLinkThanksMsg = By.xpath("//*[@automation-id='endMessageText_tv']/a[1]");
    private static By secondHyperLinkThanksMsg = By.xpath("//*[@automation-id='endMessageText_tv']/a[2]");
    private static By chatbotLogoutButton= By.xpath("//*[@id='logout']");
    private static By forgetLoginDataPage= By.xpath("//*[@automation-id='pageHeader_tv']");
    private static By helpToLoginPage= By.xpath("//*[@class='row wm-header']/h1");
    private static By loginPageFromWelcomeFlow= By.xpath("//*[@class='content-wrap']/h1");
    private static By ticketsListTitle = By.xpath("//*[@automation-id='openticketHeader_title']");
    private static By regexFailureMsg = By.xpath("//div[@class='fm-formerror error-body']/div");
    private static By formFormularOneColumnMobileNo = By.xpath("//input[@type='text']");
    private static By dropDownDecisionTree = By.xpath("//select[@automation-id='ws10-form-select_dropdown']");
    private static By dropDownList =  By.xpath("//select[@automation-id='ws10-form-select_dropdown']");
    private static By optionChooserDecisionTreeFetrigBtn = By.xpath("//button[@type='submit']");
    private static By optionPickerDecisionTree = By.xpath("//span[@id='option-picker 0']");
    private static By againQuestionCL = By.xpath("//p[contains(text(),'Again ?')]");
    private static By optionPickerQuestionCL = By.xpath("//p[contains(text(),'Ergänzende Daten')]");
    private static By weiterButtonFormFormularOneColumn = By.xpath("//button[@type='submit']");
    private static By mandatoryFieldLabel = By.xpath("//div[@class='tg-label']");
    private static By formFormularOneColumnMandatoryFieldError = By.xpath("//div[@class='wysiwyg']");
    private static By hotlineMessage = By.xpath("//*[@class='system-message-wrapper'and contains(.,'Ruf uns bitte an.')]");
    private static By callBackNoNumberError = By.xpath("//p[@automation-id='phoneNumberrequiredErrorMessage_et']");
    private static By invalidDateError = By.xpath("//p[@automation-id='dateInputadditionalErrorMessage_et']");
    private static By invalidTimeError = By.xpath("//p[@automation-id='timeInputadditionalErrorMessage_et']");
    private static By DateMandatoryFieldUnfilledError = By.xpath("//p[@automation-id='dateInputrequiredErrorMessage_et']");
    private static By TimeMandatoryFieldUnfilledError = By.xpath("//p[@automation-id='timeInputrequiredErrorMessage_et']");
    private static By callBackWrongNumberFormatError = By.xpath("//p[@automation-id='phoneNumber_patternErrorMessage_et']");
    private static By neuLadenErrorBtn = By.xpath("//div[@automation-id='errorButton_btn']");
    private static By ichMöchteEineInfoBekommenBtn = By.xpath("//div[@class='system-message red-message']//button");
    private static By infoZumStörungsendeMsg = By.xpath("//div[@automation-id='successMsg_tv']");
    private static By zurStartseiteDesNetzAssistentenBtn = By.xpath("//button[@automation-id='no_outage_btn']");
    private static By timerMinutes = By.xpath("//div[@class='timer']//span[@class='minutes']");
    private static By timerSeconds = By.xpath("//div[@class='timer']//span[@class='seconds']");
    private static By timerDots = By.xpath("(//div[@class='timer']//span)[2]");
    private static By micFormFamilyName = By.xpath("//input[@automation-id='familyName_et']");
    private static By micFormPostalCode = By.xpath("//input[@automation-id='postalCode_et']");
    private static By micFormCustomerID = By.xpath("//input[@automation-id='customerId_et']");
    private static By micConfirmationBtn = By.xpath("//div[@class='button-wrapper fm-data w-270']/button");
    private static By memoInputInfo_msg = By.xpath("//div[@class='wysiwyg']/p[@automation-id='undefined_tv']");
    private static By memoInputInfo_hyperlink = By.xpath("//div[@class='wysiwyg']/p[@automation-id='undefined_tv']/a");
    private static By formularOneColumnMultipleRowsTxtField = By.xpath("//text-area[@type='text']//textarea");
    private static By waitTemplate = By.xpath("//div[@class='wait-template']");
    private static By waitTemplateFinishedQuestion = By.xpath("//p[contains(text(),'Finished. Do you want to start again?')]");
    private static By datePickerForm = By.xpath("(//span[@id='option-picker 0'])[1]");
    private static By datePickerFormFirstAppointmentDate = By.xpath("(//span[@id='option-picker 0'])[1]");
    private static By datePickerWeiterBtn = By.xpath("//div[@id='choose-new-appointment2']");
    private static By infoOverlay = By.xpath("//div[@class='infoOverlay infoOverlay__moreInfoContainer']");
    private static By overlayMehrInfoBtn = By.xpath("//strong[@class='moreInfoBtn']");
    private static By overlayCloseBtn = By.xpath("//button[@aria-label='Close']");
    private static By overlay = By.xpath("//div[@id='infoContainer']");
    private static By overlayTitle = By.xpath("//h1[@automation-id='overlayTitle']");
    private static By overlaySubTitle = By.xpath("//h2[@automation-id='overlaySubLine']");
    private static By overlayVideo = By.xpath("//iframe[@id='video']");
    private static By overlayImage = By.xpath("//img[@automation-id='overlayImage']");
    private static By overlayTextBlock1 = By.xpath("(//span[@automation-id='overlayTextBlockOne'])[1]");
    private static By overlayTextBlock2 = By.xpath("//span[@automation-id='overlayTextBlockTwo']");
    private static By overlayTextBlock3 = By.xpath("(//span[@automation-id='overlayTextBlockOne'])[2]");
    private static By overlayImageListIcon1 = By.xpath("(//img[@automation-id='overlayImageListIcon'])[1]");
    private static By overlayImageListText1 = By.xpath("(//span[@automation-id='overlayImageListText'])[1]");
    private static By overlayImageListIcon2 = By.xpath("(//img[@automation-id='overlayImageListIcon'])[2]");
    private static By overlayImageListText2 = By.xpath("(//span[@automation-id='overlayImageListText'])[2]");
    private static By optionalInputField = By.xpath("//*[@automation-id='SL6715831056399258_56123_et']");
    //dynamic locators
    private By getButton(String buttonText){return By.xpath("//app-user//*[text()='"+buttonText+"']");}
    private By getDuplicatedButton(String buttonText){return By.xpath("(//app-user//*[text()='"+buttonText+"'])[2]");}
    private By getNextStep(int index){return By.xpath("(//app-user//div[@class='user-message-wrapper'])["+index+"]");}
    private By chatbotUserMessageContainer(int index){return By.xpath("(//app-user//div[@class='user-message'])["+index+"]");}
    private By optionPicker(String option){ return By.xpath("(//*[@class='brix-option-picker__label js-option-picker-item'])["+option+"]");}
    private By getDropDownList(String option){ return By.xpath("(//select[@automation-id='ws10-form-select_dropdown']/option)["+option+"]");}

    public ChatbotPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;

    }

    //Getters
    public static By getNewMassoutageMsg(){return newMassoutageMsg;}
    public static By getQuestion1(){return question1;}
    public static By getNeinMessage() {
        return neinMessage;
    }
    public static By getSecondQuestion(){
        return secondQuestion;
    }
    public static By getSystemMessage() {
        return systemMessage;
    }
    public static By getNoMassOutageSystemMessage(){ return noMassOutageSystemMessage;}
    public static By getJaMessage(){return jaMessage;}
    public static By getJaButton(){return jaButton;}
    public static By getNeinButton(){return neinButton;}
    public static By getNeuStartenButton(){return neuStartenButton;}
    public static By getMassOutageMessage() {
        return massOutageMessage;
    }

    public static By getQuestion1UM(){ return question1UM; }
    public static By getRückrufAnfordernDSLButton1(){ return rückrufAnfordernDSLButton1; }
    public static By getRückrufAnfordernDSLButton2(){ return rückrufAnfordernDSLButton2; }
    public static By getRückrufAnfordernCableButton(){ return rückrufAnfordernCableButton;}
    public static By getWlanEmpfangSchlechtButton(){ return wlanEmpfangSchlechtButton; }
    public static By getVerkabelungWlanCableButton(){ return verkabelungWlanCableButton; }
    public static By getVerkabelungWlanDslButton(){ return verkabelungWlanDSLButton;}
    public static By getKeinInternetDSLButton(){ return keinInternetDSLButton; }
    public static By getGoonButton(){ return goonButton; }
    public static By getWohnungOptionButton(){ return wohnungOptionButton; }
    public static By getImKellerOptionButton(){ return imKellerOptionButton; }
    public static By getInRäumeOptionButton(){ return inRäumenOptionButton; }
    public static By getStreamingButton(){ return streamingButton; }
    public static By getEasyBoxRouter(){ return easyBoxRouter; }
    public static By getlanKabelCableButton(){ return lanKabelCableButton; }
    public static By getAusButton1(){ return ausButton1; }
    public static By getAusButton2(){ return ausButton2; }
    public static By getFunktioniertButton(){ return funktioniertButton; }
    public static By getRückrufnummerInputField(){ return rückrufnummerInputField; }
    public static By getChatboTabHeader() {
        return chatbotTabHeader;
    }
    public static By getTicketsTabHeader() {
        return ticketsTabHeader;
    }
    public static By getFirstQuestion(){ return firstQuestion; }

    public static By getInfoIcon(){ return infoIcon; }

    public static By getTobiIcon(){ return tobiIcon; }

    public static String getNewMassOutageMsgDSLCL(){ return newMassoutageMsgDSLCL;}


    //Methods
    @Step("Navigate Method with deeplink")
    public ChatbotPage navigate(String deepLink){

        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + deepLink);
        return this;
    }
    @Step("Navigate Method with out deeplink")
    public ChatbotPage navigate()
    {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st"));
        return this;
    }

    @Step("Navigate Method with out deeplink")
    public ChatbotPage navigateSIT()
    {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit"));
        return this;
    }

    @Step("Navigate Method without deeplink SIT")
    public ChatbotPage navigateSIT(String deepLink)
    {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.sit")+ deepLink);
        return this;
    }

    @Step("Accept Cookies")
    public ChatbotPage acceptCookies(){
        driver.element().click(acceptCookiesButton);
        return this;
    }
    @Step("Click on element")
    public ChatbotPage clickOn(By Element){
        driver.element().clickUsingJavascript(Element);
        return this;
    }
    @Step("Text input")
    public ChatbotPage typeToInputField(By Element, String input){
        driver.element().type(Element,input);
        return this;
    }
    @Step("Select cable checkbox")
    public ChatbotPage selectCableCheckbox(){
        driver.element().click(checkBoxCable);
        return this;
    }
    @Step("Clcik on submit button")
    public ChatbotPage submitButton(By Element){
        driver.element().click(Element);
        return this;
    }
    @Step("Select dsl checkbox")
    public ChatbotPage selectDSLCheckbox(){
        driver.element().click(checkBoxDSL);
        return this;
    }
    @Step("Get mass outage message")
    public String getMassOutageMessageDetails(){

        return driver.element().getText( massOutageMessage);
    }

    @Step("Click on submit button")
    public ChatbotPage submitDSLButton(){
        driver.element().click(rückrufAnfordernDSLButtonST);
        return this;
    }
    @Step("Validate that there is no mass outage")
    public ChatbotPage validateNoMassOutageMessage()
    {
        driver.assertThat()
                .element(getNoMassOutageSystemMessage())
                .exists()
                .withCustomReportMessage("There is no Outage")
                .perform();

        return this;
    }
    @Step("Validate mass outage message is not displayed")
    public ChatbotPage validateMassOutageMessage()
    {
        driver.assertThat()
                .element(getMassOutageMessage())
                .text()
                .doesNotEqual(generalMessageCL)
                .withCustomReportMessage("There is Mass Outage and this is the message:  " + getMassOutageMessageDetails())
                .perform();

        return this;
    }
    @Step("Validate mass outage message is displayed")
    public ChatbotPage validateNoMassOutageMessageCL()
    {
        driver.element().waitForTextToChange(  newMassoutageMsg,"Wir prüfen den Netzwerk-Status in Deiner Gegend.");
        driver.assertThat()
                .element(getMassOutageMessage())
                .textTrimmed()
                .isEqualTo(generalMessageCL)
                .perform();

        return this;
    }
    @Step("Validate callBack service sucess")
    public ChatbotPage validateCallBackServiceSucess()
    {
        driver.assertThat()
                .element(getNeuStartenButton())
                .exists()
                .withCustomReportMessage("Callback is done Successfully")
                .perform();

        return this;
    }
    @Step("Validate Question1 exists")
    public ChatbotPage validateQuestion1Exists()
    {
        driver.assertThat()
                .element(getSecondQuestion())
                .exists()
                .withCustomReportMessage("Question1 Exists Successfully")
                .perform();


        return this;
    }
    @Step("Validate Ja button exists")
    public ChatbotPage validateJaButtonExists()
    {
        driver.assertThat()
                .element(getJaButton())
                .exists()
                .withCustomReportMessage("Ja Button Exists Successfully")
                .perform();

        return this;
    }
    @Step("Validate decision tree is displayed")
    public ChatbotPage validateChatbotDecesionTree()
    {
        driver.assertThat()
                .element(getQuestion1UM())
                .exists()
                .withCustomReportMessage("Question 1 Exists")
                .perform();

        driver.assertThat()
                .element(getSystemMessage())
                .doesNotExist()
                .withCustomReportMessage("Mass Outage is not present")
                .perform();

        return this;
    }
    @Step("Validate Nein button exists")
    public ChatbotPage validateNeinButtonExists()
    {
        driver.assertThat()
                .element(getNeinButton())
                .exists()
                .withCustomReportMessage("Flow of Nein work fine")
                .perform();

        return this;
    }
    @Step("Validate Question2 CL")
    public ChatbotPage validateQuestion2Text()
    {
        driver.assertThat()
                .element(getSecondQuestion())
                .text()
                .isEqualTo(questionTwoCL)
                .perform();

        return this;
    }
    @Step("Validate Ja message CL")
    public ChatbotPage validateJaMessage()
    {
        driver.assertThat()
                .element(getJaMessage())
                .text()
                .isEqualTo(jaMessageCL)
                .perform();

        return this;
    }
    @Step("Get mass outage message")
    public ChatbotPage readMessageWithWait(String Element)
    {

        driver.element().waitForTextToChange( massOutageMessage,Element);
        return this;
    }
    @Step("Switch to another tab")
    public ChatbotPage switchToTab(By elementLocator) {
        clickOnPopupElement(driver, elementLocator);
        return this;
    }
    @Step("Validate new massoutage msg CL")
    public ChatbotPage  validateNewMassOutageMsg()
    {
        driver.element().waitForTextToChange(  getNewMassoutageMsg(),"Wir prüfen den Netzwerk-Status in Deiner Gegend.");
        driver.assertThat()
                .element(getNewMassoutageMsg())
                .text()
                .contains(newMassoutageMsgDSLCL)
                .withCustomReportMessage("mass outage message displayed without effected services")
                .perform();

        return this;
    }
    @Step("Validate No mass outage CL")
    public ChatbotPage validateNoMassOutageCLDisplayed()
    {
        driver.element().waitForTextToChange( getNoMassOutageSystemMessage(),"Wir prüfen den Netzwerk-Status in Deiner Gegend.");
        driver.assertThat()
                .element(getNoMassOutageSystemMessage())
                .text().contains(generalMessageCL)
                .withCustomReportMessage("mass outage message displayed without effected services")
                .perform();

        return this;
    }
    @Step("Validate Tobi icon exists")
    public ChatbotPage validateTobiIconExists()
    {
        driver.assertThat()
                .element(getTobiIcon())
                .exists()
                .perform();

        return this;
    }
    @Step("Validate Tobi icon exists")
    public ChatbotPage validateTobiIconExistsWeb()
    {
        driver.assertThat()
                .element(tobiIconDesktop)
                .exists()
                .perform();

        return this;
    }
    @Step("Validate Chatbot header exists")
    public ChatbotPage validateChatbotHeaderExists()
    {
        driver.assertThat()
                .element(getChatboTabHeader())
                .exists()
                .withCustomReportMessage("chatbot tab should be displayed")
                .perform();

        return this;
    }
    @Step("Validate tickets header exists")
    public ChatbotPage validateTicketsHeaderExists()
    {
        driver.assertThat()
                .element(getTicketsTabHeader())
                .exists()
                .withCustomReportMessage("tickets tab should be displayed")
                .perform();

        return this;
    }
    @Step("Validate info icon exists")
    public ChatbotPage validateInfoIconExists()
    {
        driver.assertThat()
                .element(getInfoIcon())
                .exists()
                .perform();

        return this;
    }
    @Step("Validate help header exists")
    public ChatbotPage validateHelpHeaderExists()
    {
        driver.assertThat()
                .element(HelpPage.getHelpPageHeader())
                .exists()
                .withCustomReportMessage("help page displayed")
                .perform();

        return this;
    }

    @Step("Validate logout button displayed in chatbot")
    public ChatbotPage validateLogoutButtonExist() {
        driver
                .assertThat()
                .element(chatbotLogoutButton)
                .exists()
                .perform();

        return this;
    }
    @Step("navigate to tickettab from chatbot page")
    public ChatbotPage clickOnTicketTab() {
        driver.element().click(ticketsTabHeader);

        return this;
    }
    @Step("Switch to another tab by index")
    public ChatbotPage switchToTabByIndex(int index){
        ArrayList<String> tabs = new ArrayList<String> (driver.getDriver().getWindowHandles());
        driver.browser().switchToWindow(tabs.get(index));
        return this;
    }

    public ChatbotPage clickOnYaButtonFlow()
    {
        driver.element().click(jaButtonWelcomeFlow);
        return this;
    }

    public ChatbotPage clickOnJaButton()
    {
        driver.element().click(jaButton);
        return this;
    }

    public ChatbotPage clickOnJaButton2()
    {
        driver.element().click(jaButton2ST);
        return this;
    }

    @Step("Select dsl checkbox")
    public ChatbotPage selectDSLCheckboxST(){
        if (driver.element().isElementDisplayed(checkBoxDSLST)){
            driver.element().click(checkBoxDSLST);
        }
        return this;
    }

    @Step("Validate CallBack Input Field is prefilled")
    public ChatbotPage validateCallbackInputFieldisPrefilled()
    {
        driver.assertThat()
                .element(getRückrufnummerInputField())
                .text()
                .isNotNull()
                .perform();

        return this;
    }

    @Step("Validate CallBack Input Field is not prefilled")
    public ChatbotPage validateCallbackInputFieldisNotPrefilled()
    {
        driver.assertThat()
                .element(getRückrufnummerInputField())
                .text()
                .isEqualTo("")
                .perform();

        return this;
    }

    @Step("Validate welcome message appears")
    public ChatbotPage validateWelcomeMessageAppears()
    {
        driver.assertThat().element(welcomeMessage).exists().perform();
        driver.assertThat().element(welcomeMessage).textTrimmed().isEqualTo(welcomeMessageCL).perform();
        return this;
    }
    @Step("click on nein for welcoming message flow")
    public ChatbotPage clickOnNeinButtonFlow()
    {
        driver.element().click(neinButtonWelcomeFlow);
        return this;
    }

    @Step("Validate End Message Appears with valid CL")
    public ChatbotPage validateEndMessageAppears()
    {
        driver.assertThat().element(endMessage).exists().perform();
        driver.assertThat().element(endMessage).textTrimmed().isEqualTo(endMessageCL).perform();
        return this;
    }

    @Step("Validate redirection to login page")
    public ChatbotPage validateRedirectionToLogin() {

        driver.assertThat().browser().url().contains("account/login").perform();
        return this;
    }

    @Step("Click on Tickets tab header")
    public ChatbotPage clickTicketsHeader()
    {
        driver.element().click(ticketsTabHeader);
        return this;
    }

    @Step("validate that tickets image is not visible")
    public ChatbotPage validateNaImageIsNotVisible()
    {
        driver.assertThat().element(NAImage).doesNotExist().perform();
        return this;
    }

    @Step("Validate welcome message new CL")
    public ChatbotPage validateWelcomeMsgNewCL(){
        driver.assertThat().element(firstQuestion).textTrimmed().isEqualTo(welcomeMsgNewCL).perform();
        return this;
    }

    @Step("Validate welcome message buttons new CLs")
    public ChatbotPage validateMeinTicketsButtonExists(){
        driver.assertThat().element(zuMeinenTicketsButton).exists().perform();
        return this;
    }

    @Step("click on Meine Tickets for welcoming message flow")
    public ChatbotPage clickOnZuMeinenTicketsButtonFlow()
    {
        driver.element().click(zuMeinenTicketsButton);
        return this;
    }

    @Step("Navigate in new tab Method with deeplink SIT environment")
    public ChatbotPage navigateInNewTabSIT(String deeplink) {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.sit") + deeplink);
        return this;
    }

    @Step("Click on Chatbot tab header")
    public ChatbotPage clickChatbotHeaderButton()
    {
        driver.element().click(chatbotTabHeader);
        return this;
    }

    @Step("Click on Tickets tab header")
    public ChatbotPage clickJaWelcomeScreen()
    {
        driver.assertThat().element(welcomeMessage).exists().perform();
        driver.element().click(loginButtonWelcomePage);
        return this;
    }
    @Step("Validate new login button displayed in chatbot new welcome page")
    public ChatbotPage validateLoginButtonExist() {
        driver
                .assertThat()
                .element(loginButtonWelcomePage)
                .exists()
                .perform();

        return this;
    }
    @Step("Validate new register button displayed in chatbot new welcome page")
    public ChatbotPage validateRegisterButtonExist() {
        driver
                .assertThat()
                .element(registerButtonWelcomePage)
                .exists()
                .perform();

        return this;
    }
    @Step("Validate nein button displayed in chatbot new welcome page")
    public ChatbotPage validateNeinButtonExist() {
        driver
                .assertThat()
                .element(neinButtonWelcomePage)
                .exists()
                .perform();

        return this;
    }
    @Step("click on new login button for welcome screen")
    public ChatbotPage clickOnLoginButton()
    {
        driver.element().click(loginButtonWelcomePage);
        return this;
    }
    @Step("click on new register  button for welcome screen")
    public ChatbotPage clickOnRegisterButton()
    {
        clickOnPopupElement(driver,registerButtonWelcomePage);
        return this;
    }
    @Step("Validate regiester page displayed ")
    public ChatbotPage validateRegisterPage() {
        driver
                .assertThat()
                .element(registerPage)
                .exists()
                .perform();

        return this;
    }
    @Step("click on Nein button for welcome screen")
    public ChatbotPage clickOnNeinButton()
    {
        driver.element().click(neinButtonWelcomePage);
        return this;
    }
    @Step("validate thanks msg displayed ")
    public ChatbotPage validateThanksMsgForNeinFlow()
    {
        driver
                .assertThat()
                .element(chatbotThanksMsg)
                .exists()
                .perform();
        return this;
    }
    @Step("validate 1st hyperlink displayed for thanks msg ")
    public ChatbotPage validate1stHyperlinkForThanksMsg()
    {
        driver
                .assertThat()
                .element(firstHyperLinkThanksMsg)
                .exists()
                .perform();
        return this;
    }
    @Step("validate 2nd hyperlink displayed for thanks msg ")
    public ChatbotPage validate2ndHyperlinkForThanksMsg()
    {
        driver
                .assertThat()
                .element(secondHyperLinkThanksMsg)
                .exists()
                .perform();
        return this;
    }
    @Step("validate refresh button displayed after thanks msg ")
    public ChatbotPage validateRefreshButton()
    {
        driver
                .assertThat()
                .element(refreshButtonWelcomePage)
                .exists()
                .perform();
        return this;
    }
    @Step("click on 1st hyperlink displayed at thnks msg")
    public ChatbotPage click1stHyperlink()
    {
        clickOnPopupElement(driver,firstHyperLinkThanksMsg);
        return this;
    }
    @Step("validate forget data page ")
    public ChatbotPage validateForgetLoginDataPage()
    {
        driver
                .assertThat()
                .element(forgetLoginDataPage)
                .exists()
                .perform();
        return this;
    }
    @Step("click on 2nd hyperlink displayed at thnks msg")
    public ChatbotPage click2ndHyperlink()
    {
        clickOnPopupElement(driver,secondHyperLinkThanksMsg);
        return this;
    }
    @Step("validate help login page ")
    public ChatbotPage validateHelpLoginPage()
    {
        driver
                .assertThat()
                .element(helpToLoginPage)
                .exists()
                .perform();
        return this;
    }
    @Step("validate  login page from welcome flow ")
    public ChatbotPage validateNavigateToLoginPage()
    {
        driver
                .assertThat()
                .element(loginPageFromWelcomeFlow)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate chatbot page is appearing")
    public ChatbotPage validateChatbotPage()
    {
        driver.assertThat()
                .element(newMassoutageMsg)
                .exists()
                .perform();

        return this;
    }

    @Step("Validate tickets page is appearing")
    public ChatbotPage validateTicketsPage()
    {
        driver.assertThat()
                .element(ticketsListTitle)
                .exists()
                .perform();

        return this;
    }
    @Step("filling callback form")
    public ChatbotPage fillCallbackForm(String mobileNumber)
    {
        typeToInputField(rückrufnummerInputField,mobileNumber);
        selectCableCheckbox();
        submitButton(rückrufAnfordernCableButton);
        return this;
    }

    @Step("filling Date/Time Picker form")
    public ChatbotPage fillDateTimePickerForm(String Date,String Time)
    {
        driver.element().click(timePickerInputField);
        driver.element().keyPress(datePickerInputField,Keys.ESCAPE);
        typeToInputField(timePickerInputField,Time);
        driver.element().click(datePickerInputField);
        driver.element().keyPress(datePickerInputField,Keys.ESCAPE);
        typeToInputField(datePickerInputField,Date);
        submitButton(submitButtonField);
        return this;
    }
    @Step("Click on Mandatory Field and don't type anything")
    public ChatbotPage clickMandatoryFieldWithoutTyping()
    {
        driver.element().click(MandatoryField);
        deleteTextFromField(MandatoryField);
        driver.element().click(mandatoryFieldLabel);
        return this;
    }
    @Step("Click on Mandatory Field and don't type anything")
    public ChatbotPage clickMandatoryFieldWithoutTypingSIT()
    {
        driver.element().click(MandatoryFieldSIT);
        deleteTextFromField(MandatoryFieldSIT);
        driver.element().click(MandatoryFieldErrorMessageSIT);
        return this;
    }
    @Step("type anything on Mandatory Field")
    public ChatbotPage typeIntoMandatoryFieldSIT(String text)
    {
        driver.element().type(MandatoryFieldSIT,text);
        return this;
    }
    @Step("type anything on Mandatory Field")
    public ChatbotPage typeIntoMandatoryField(String text)
    {
        driver.element().type(MandatoryField,text);
        return this;
    }
    @Step("Click on Submit Button Field")
    public ChatbotPage clickSubmitMandatoryFieldButton()
    {
        driver.element().click(submitMandatoryFieldButton);
        return this;
    }

    @Step("Click on Mandatory Field and type anything")
    public ChatbotPage clickMandatoryFieldThenDelete() {
        String text = driver.element().getText(MandatoryField);
        deleteTextFromField(MandatoryField);
        driver.element().click(mandatoryFieldLabel);
        return this;
    }
    @Step("Delete data from mandatory field")
    public ChatbotPage clickMandatoryFieldThenDeleteSIT() {
        deleteTextFromField(MandatoryFieldSIT);
        driver.element().click(MandatoryFieldErrorMessageSIT);
        return this;
    }
    @Step("Delete data from field")
    public void deleteTextFromField(By element) {
        String text = driver.element().getText(element);
        for (int index = text.length(); index >= 0; index--)
        {
            driver.element().keyPress(element, Keys.BACK_SPACE);
        }
    }
    @Step("filling Date/Time Picker form without inputs")
    public ChatbotPage fillDateTimePickerForm()
    {
        driver.element().click(datePickerInputField);
        driver.element().keyPress(datePickerInputField,Keys.ESCAPE);
        driver.element().click(timePickerInputField);
        driver.element().keyPress(timePickerInputField,Keys.ESCAPE);
        submitButton(submitButtonField);
        return this;
    }

    @Step("Validate Weiter Button enabled")
    public ChatbotPage validateWeiterButtonEnabled()
    {
        driver.element()
                .assertThat(submitButtonField)
                .isEnabled()
                .perform();

        return this;
    }

    @Step("Validate Weiter Button disabled")
    public ChatbotPage validateWeiterButtonDisabled()
    {
        driver.element().assertThat(submitButtonField).isDisabled().perform();

        return this;
    }

    @Step("Validate Green Border is displayed")
    public ChatbotPage validateGreenBorder1Displayed()
    {
        driver.assertThat()
                .element(datePickerInputField)
                .cssProperty("border-top-color")
                .contains("66, 125, 0")
                .perform();
        return this;
    }

    @Step("Validate Green Border is displayed")
    public ChatbotPage validateGreenBorder2Displayed()
    {
        driver.assertThat()
                .element(timePickerInputField)
                .cssProperty("border-top-color")
                .contains("66, 125, 0")
                .perform();
        return this;
    }

    @Step("Validate Red Border is displayed")
    public ChatbotPage validateRedBorder1Displayed()
    {
        driver.assertThat()
                .element(datePickerInputField)
                .cssProperty("border-top-color")
                .contains("230, 0, 0")
                .perform();
        return this;
    }
    @Step("Validate Red Border is displayed")
    public ChatbotPage validateRedBorder2Displayed()
    {
        driver.assertThat()
                .element(timePickerInputField)
                .cssProperty("border-top-color")
                .contains("230, 0, 0")
                .perform();
        return this;
    }

    @Step("Validate Red Border is displayed")
    public ChatbotPage validateRedBorderDisplayed()
    {
            driver.assertThat()
                    .element(MandatoryFieldRedBorder)
                    .cssProperty("border-bottom-color")
                    .contains("230, 0, 0")
                    .perform();
        return this;
    }
    @Step("Validate Red Border is displayed")
    public ChatbotPage validateRedBorderDisplayedSIT()
    {
        driver.assertThat()
                .element(MandatoryFieldRedBorderSIT)
                .cssProperty("border-bottom-color")
                .contains("230, 0, 0")
                .perform();
        return this;
    }
    @Step("validate error displayed in case of Future Invalid Date")
    public ChatbotPage validateErrorCLFutureInvalidDate()
    {
        driver.element().assertThat(invalidDateError).textTrimmed().isEqualTo(invalidDateErrorCL).perform();

        return this;
    }

    @Step("validate error displayed in case of Future Invalid Time")
    public ChatbotPage validateErrorCLFutureInvalidTime()
    {
        driver.element().assertThat(invalidTimeError).textTrimmed().isEqualTo(invalidTimeErrorCL).perform();
        driver.element().click(invalidTimeError);

        return this;
    }

    @Step("validate error displayed in case of Date Mandatory Field Left Unfilled")
    public ChatbotPage validateErrorCLDateMandatoryFieldUnfilled()
    {
        driver.element().assertThat(DateMandatoryFieldUnfilledError).textTrimmed().isEqualTo(DateMandatoryFieldUnfilledErrorCL).perform();

        return this;
    }

    @Step("validate error displayed in case of Time Mandatory Field Left Unfilled")
    public ChatbotPage validateErrorCLTimeMandatoryFieldUnfilled()
    {
        driver.element().assertThat(TimeMandatoryFieldUnfilledError).textTrimmed().isEqualTo(TimeMandatoryFieldUnfilledErrorCL).perform();

        return this;
    }

    /**
     * This method handles Chatbot decision tree using the steps passed from JSON file , The steps from JSON file are used as a list to be a unique identifier to locate the web elements through a dynamic locator , with every step there are some handling conditions checked to break the method if the flow reached an end or another action other than the decision tree should be taken , Also there are children trees for different types of users that are checked respectively with each new step to validate the response of the decision tree is valid as expected , Also there is a special handling for elements that may appear two times through the tree to be checked and handled with another dynamic locator and if the same case happened for the children validation there will be a flag raised that there is a duplicate valye and it will be handled with a specail list for duplicated searching for the children values that appends [duplicate] beside the key value.
     * @param indexSize
     * @param buttonLabel
     * @param childrenNames
     */
    @Step("Handle Decision Tree")
    public ChatbotPage getDecisionButton(int indexSize, List<String> buttonLabel, HashMap<String, ArrayList> childrenNames) {
        List<String> childrenNamesList = null;
        int index = 0;

        try {
            //for loop to loop over the number of steps passed from the JSON file until the flow is completed
            for (index = 0; index < indexSize; index++) {
                if(index>0 && index!= (indexSize-1))
                    childrenNamesList =childrenNames.get(buttonLabel.get(index-1)+"."+buttonLabel.get(index)).stream().toList();
                else if(index==0){childrenNamesList = childrenNames.get(buttonLabel.get(index)).stream().toList();}

                //This condition handles the end of tree and breaks the loop
                if (buttonLabel.get(index).contentEquals("Problem gelöst!")) {
                    clickOn(getButton(buttonLabel.get(index)));
                    driver.assertThat().element(neuStartenButton).exists().perform();
                    break;
                }

                if(index==indexSize-1)
                {
                    clickOn(getButton(buttonLabel.get(index)));
                    break;
                }

                else {
                    new WebDriverWait(driver.getDriver(), Duration.ofSeconds(Long.parseLong(System.getProperty("browserNavigationTimeout"))))
                            .until(ExpectedConditions.visibilityOfElementLocated((getNextStep((index+1)))));
                    driver.assertThat().element(getNextStep((index+1))).exists().perform();

                    if (driver.element().getElementsCount(getButton(buttonLabel.get(index))) > 1) {
                        clickOn(getDuplicatedButton(buttonLabel.get(index)));
                    }
                    else
                    {
                        clickOn(getButton(buttonLabel.get(index))); //if non of the above conditions is true then the next step in tree is clicked
                    }

                    //Children validation for every step is handled her
                    for (int index2 = 0; index2 < childrenNamesList.size(); index2++) //loops over until  all children name provided from the tree are verified
                    {
                        new WebDriverWait(driver.getDriver(), Duration.ofSeconds(Long.parseLong(System.getProperty("browserNavigationTimeout"))))
                                .until(ExpectedConditions.visibilityOfElementLocated((getNextStep((index+1)))));
                        driver.assertThat().element(getNextStep((index+1))).exists().perform();
                        //driver.element().waitToBeReady(getNextStep((index+1)));
                        if (driver.element().getElementsCount(getButton(childrenNamesList.get(index2))) > 1) //Checks that the child name is not a duplicate and it is the first time to appear
                        {
                            driver.verifyThat().
                                    element(getDuplicatedButton(childrenNamesList.get(index2))).exists().perform(); //duplicated child is handled with another locator here and verfied
                        }
                        else
                        {
                            driver.verifyThat().
                                    element(getButton(childrenNamesList.get(index2))).exists().perform(); // first time appearing element is handled and verified normally here
                        }
                    }
                }
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Failed to get children names for element '" + buttonLabel.get(index) + "' , Please check it in the JSON file with this path : '"+(buttonLabel.get(index-1))+"."+(buttonLabel.get(index)) + "'\t" +e.getMessage()); //the method is surrounded by try/catch to catch null exception error related to JSON missing steps and show the absent value for user with clear error message
        }
        return this;
    }
    @Step("Validate new massoutage msg CL")
    public ChatbotPage  validateMassOutageUMCable()
    {
        driver.element().waitForTextToChange(  newMassoutageMsg,"Wir prüfen den Netzwerk-Status in Deiner Gegend.");
        new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        driver.assertThat()
                .element(newMassoutageMsg)
                .textTrimmed()
                .contains(newMassoutageMsgUMCableCL)
                .perform();

        return this;
    }
    @Step("Validate affectedservices empty array empty")
    public ChatbotPage  validateAffectedServicesEmptyArrayMsg()
    {

        driver.assertThat()
                .element(affectedServicesEmptyArray)
                .textTrimmed()
                .contains(affectedServicesEmptyArrayCL)
                .perform();

        return this;
    }
    @Step("Validate affectedservices message ")
    public ChatbotPage  validateAffectedServicesMsg()
    {

        driver.assertThat()
                .element(affectedServices)
                .textTrimmed()
                .contains(affectedServicesCL)
                .perform();

        return this;
    }

    @Step("click on Netz-Assistent Verlassen button")
    public ChatbotPage clickOnNetzAssistentVerlassenBtn()
    {
        driver.element().click(neinButton);

        return this;
    }
    @Step("validate nein message is appearing")
    public ChatbotPage validateNeinMessageAppears()
    {
        driver.element().assertThat(neinMessage).exists();

        return this;
    }

    @Step("Validate Regex Failure Message")
    public ChatbotPage validateRegexFailureMsg()
    {
        driver.element().type(formFormularOneColumnMobileNo,"Testtt");
        driver.element().assertThat(regexFailureMsg).exists();
        driver.element().assertThat(regexFailureMsg).textTrimmed().isEqualTo(regexFailureMsgCL).perform();

        return this;
    }

    @Step("Validate option picker appears")
    public ChatbotPage validateOptionPickerAppears()
    {
        driver.element().assertThat(optionPickerDecisionTree).exists().perform();
        driver.element().click(optionPickerDecisionTree);
        driver.element().type(formFormularOneColumnMobileNo,"TESTT");
        driver.element().click(optionChooserDecisionTreeFetrigBtn);
        driver.assertThat().element(againQuestionCL).exists().perform();

        return this;
    }
    @Step("Validate dropdown appears")
    public ChatbotPage validateDropDownAppears()
    {
        driver.element().assertThat(dropDownDecisionTree).exists().perform();
        driver.element().type(formFormularOneColumnMobileNo,"TESTT");
        driver.element().click(optionChooserDecisionTreeFetrigBtn);
        driver.assertThat().element(againQuestionCL).exists().perform();

        return this;
    }


    @Step("Validate option picker question exists")
    public ChatbotPage validateOptionPickerQuestionExists()
    {
        driver.element().assertThat(optionPickerQuestionCL).exists().perform();

        return this;
    }

    @Step("Validate jumpBack is disabled")
    public ChatbotPage validateJumpBackIsDisabled()
    {
        driver.element().click(getButton("Testbereich"));
        driver.assertThat().element(getButton("mit Emulator")).exists().perform();
        return this;
    }

    @Step("Validate jumpBack is enabled")
    public ChatbotPage validateJumpBackIsEnabledDSL()
    {
        driver.element().click(getButton("Testbereich"));
        driver.assertThat().element(getButton("Kein Internet")).doesNotExist().perform();

        return this;
    }

    @Step("Validate that text is optional")
    public ChatbotPage validateTextIsOptional()
    {
        driver.element().click(weiterButtonFormFormularOneColumn);
        driver.element().click(weiterButtonFormFormularOneColumn);
        driver.assertThat().element(getButton("Ja")).exists().perform();

        return this;
    }

    @Step("Validate that text is mandatory")
    public ChatbotPage validateTextIsMandatory()
    {
        driver.element().click(formFormularOneColumnMobileNo);
        driver.element().click(formFormularOneColumnMobileNo);
        driver.element().click(mandatoryFieldLabel);
        driver.element().assertThat(formFormularOneColumnMandatoryFieldError).exists().perform();

        return this;
    }

    @Step("validate prefill feature")
    public ChatbotPage validatePreFill(String filledData)
    {
        driver.element().assertThat(formFormularOneColumnMobileNo).textTrimmed().isEqualTo(filledData).perform();

        return this;
    }

    @Step("validate prefill green frame")
    public ChatbotPage validatePreFillGreenFrame()
    {
        driver.element().assertThat(formFormularOneColumnMobileNo).cssProperty("border-top-color").contains("66, 125, 0").perform();

        return this;
    }

    @Step("validate form is not prefilled")
    public ChatbotPage validateNotPreFilled()
    {
        driver.element().assertThat(formFormularOneColumnMobileNo).textTrimmed().isEqualTo("").perform();

        return this;
    }


    @Step("Validate that hotline message is no longer shown")
    public ChatbotPage validateHotLineMsgDoesNotExist()
    {
        driver.element().assertThat(hotlineMessage).doesNotExist().perform();

        return this;
    }

    @Step("filling callback form without checking the checkbox")
    public ChatbotPage fillCallbackFormWithoutCheckBox(String mobileNumber)
    {
        typeToInputField(rückrufnummerInputField,mobileNumber);

        return this;
    }

    @Step("validate ruckruf anforden button is disabled when checkbox is not selected")
    public ChatbotPage validateRuckrufBtnIsDisabled()
    {
        driver.element().assertThat(rückrufAnfordernCableButton).isDisabled().perform();

        return this;
    }

    @Step("validate no number entered error CL for callback")
    public ChatbotPage validateErrorCLNoNumberEnteredCallBack()
    {
        driver.element().assertThat(callBackNoNumberError).textTrimmed().isEqualTo(callBackNoNumberErrorCL).perform();

        return this;
    }
    @Step("validate wrong number format entered error CL for callback")
    public ChatbotPage validateErrorCLWrongNumberFormatEnteredCallBack()
    {
        driver.element().assertThat(callBackWrongNumberFormatError).textTrimmed().isEqualTo(callBackWrongNumberFormatErrorCL).perform();

        return this;
    }

    @Step("validate no text entered error CL for mandatory field")
    public ChatbotPage validateErrorCLNoTextEntered()
    {
        driver.element().assertThat(MandatoryFieldErrorMessage).textTrimmed().isEqualTo(callBackNoNumberErrorCL).perform();

        return this;
    }
    @Step("validate no text entered error CL for mandatory field")
    public ChatbotPage validateErrorCLNoTextEnteredSIT()
    {
        driver.element()
                .assertThat(MandatoryFieldErrorMessageSIT)
                .textTrimmed().isEqualTo(callBackNoNumberErrorCL)
                .perform();
        return this;
    }

    @Step("Validate error page appears when error 500 is returned for decision tree")
    public ChatbotPage validateDecisionTreeErrorPage()
    {
        driver.element().assertThat(neuLadenErrorBtn).exists().perform();

        return this;
    }
    @Step("Click on cable submit button in callback form")
    public ChatbotPage submitCableButton(){
        driver.element().click(rückrufAnfordernDSLButtonST);
        return this;
    }
    @Step("Validate that subscriber button displayed for cable user")
    public ChatbotPage validateIchMöchteEineInfoBekommenBtnDisplayed()
    {
        driver.element().assertThat(ichMöchteEineInfoBekommenBtn).exists().perform();

        return this;
    }
    @Step("Validate that subscriber button not displayed for UM user")
    public ChatbotPage validateIchMöchteEineInfoBekommenBtnNotDisplayed()
    {
        driver.element().assertThat(ichMöchteEineInfoBekommenBtn).doesNotExist().perform();

        return this;
    }

    @Step("Click on ichMöchteEineInfoBekommen button")
    public ChatbotPage clickOnichMöchteEineInfoBekommenBtn()
    {
        clickOn(ichMöchteEineInfoBekommenBtn);
        return this;
    }

    @Step("Click on Mandatory Field")
    public ChatbotPage clickOnMandatoryField()
    {
        driver.element().click(rückrufAnfordernDSLButtonST);
        return this;
    }


    @Step("Validate that overlay object is existing")
    public ChatbotPage validateOverlayObjectIsExisting()
    {
        driver.assertThat().element(overlay).exists().perform();
        return this;
    }

    @Step("Validate that overlay object is not existing")
    public ChatbotPage validateOverlayObjectIsNotExisting()
    {
        driver.assertThat().element(overlay).doesNotExist().perform();
        return this;
    }

    @Step("Validate that overyLay is returned with all objects")
    public ChatbotPage validateOveryLayReturnedWithAllObjects()
    {
        driver.assertThat().element(overlayTitle).exists().perform();
        driver.assertThat().element(overlaySubTitle).exists().perform();
        driver.assertThat().element(overlayVideo).exists().perform();
        driver.assertThat().element(overlayImage).exists().perform();
        driver.assertThat().element(overlayTextBlock1).exists().perform();
        driver.assertThat().element(overlayTextBlock2).exists().perform();
        driver.assertThat().element(overlayTextBlock3).exists().perform();
        driver.assertThat().element(overlayImageListIcon1).exists().perform();
        driver.assertThat().element(overlayImageListIcon2).exists().perform();
        driver.assertThat().element(overlayImageListText1).exists().perform();
        driver.assertThat().element(overlayImageListText2).exists().perform();
        return this;
    }

    @Step("Validate that overlay close button exists and closes the overlay without reloading it")
    public ChatbotPage validateOverlayCloseBtnExistsAndClosesOverlayWithoutReload()
    {
        driver.assertThat().element(overlayCloseBtn).exists().perform();
        driver.element().click(overlayCloseBtn);
        driver.assertThat().element(overlayMehrInfoBtn).exists().perform();
        return this;
    }

    @Step("Click on mehr info for overlay")
    public ChatbotPage clickOnOverlayMehrInfoBtn()
    {
        driver.element().click(overlayMehrInfoBtn);
        return this;
    }

    @Step("Validate that image selector component is exisitng")
    public ChatbotPage validateImageSelectorComponent()
    {
        driver.assertThat().element(getButton("Compal CH6640E")).attribute("class").contains("image").perform();
        return this;
    }
    @Step("Validate that timer component is exisitng")
    public ChatbotPage validateTimerComponent()
    {
        driver.assertThat().element(timerMinutes).exists().perform();
        driver.assertThat().element(timerDots).exists().perform();
        driver.assertThat().element(timerSeconds).exists().perform();
        return this;
    }
    @Step("Fill Three parameters MIC form")
    public ChatbotPage fillThreeParametersMicForm(String familyName, String potsalCode , String customerID)
    {
        driver.element().type(micFormFamilyName,familyName);
        driver.element().type(micFormPostalCode,potsalCode);
        driver.element().type(micFormCustomerID,customerID);
        driver.element().click(micConfirmationBtn);
        return this;
    }
    @Step("Fill and submit Formular one column form")
    public ChatbotPage fillFormularOneColumn(String mobileNumber)
    {
        driver.element().type(formFormularOneColumnMobileNo,mobileNumber);
        driver.element().click(optionChooserDecisionTreeFetrigBtn);
        return this;
    }
    @Step("Fill and submit Formular one column form")
    public ChatbotPage fillFormularOneColumnMultipleRows(String mobileNumber)
    {
        driver.element().type(formularOneColumnMultipleRowsTxtField,mobileNumber);
        driver.element().click(optionChooserDecisionTreeFetrigBtn);
        return this;
    }
    @Step("Validate jumpBack is disabled")
    public ChatbotPage validateJumpBackIsNotDimmed(int stepsSize)
    {
        for(int index = 1 ; index  <= stepsSize ; index++) {
            driver.assertThat().element(chatbotUserMessageContainer(index)).cssProperty("pointer-events").isEqualTo("auto").perform();
        }
            return this;
    }

    @Step("Validate jumpBack is enabled")
    public ChatbotPage validateJumpBackIsDimmed(int stepsSize)
    {
        for(int index = 1 ; index  <= stepsSize ; index++) {
            driver.assertThat().element(chatbotUserMessageContainer(index)).cssProperty("pointer-events").isEqualTo("none").perform();
        }
        return this;
    }
    @Step("Validate that wait form is appearing then next question is triggered")
    public ChatbotPage validateWaitFormAppears()
    {
        driver.assertThat().element(waitTemplate).exists().perform();
        driver.assertThat().element(waitTemplateFinishedQuestion).exists().perform();
        return this;
    }
    @Step("Validate Date Picker form appears")
    public ChatbotPage validateDatePickerFormAppears()
    {
        driver.assertThat().element(datePickerForm).exists().perform();
        return this;
    }
    @Step("Validate Date Picker form success when selecting appointment")
    public ChatbotPage validateDatePickerFormSuccess()
    {
        driver.assertThat().element(datePickerFormFirstAppointmentDate).exists().perform();
        driver.element().click(datePickerFormFirstAppointmentDate);
        driver.element().click(datePickerWeiterBtn);
        return this;
    }
    @Step("Fill Two parameters MIC form")
    public ChatbotPage fillTwoParametersMicForm(String familyName, String potsalCode)
    {
        driver.element().type(micFormFamilyName,familyName);
        driver.element().type(micFormPostalCode,potsalCode);
        driver.element().click(micConfirmationBtn);
        return this;
    }

    @Step("Validate memoInfo icon exists")
    public ChatbotPage validateMemoInfoIconExists(){
        driver.assertThat()
                .element(memoInfoIcon)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate close memoInfo icon exists")
    public ChatbotPage validateXIconExists(){
        driver.assertThat()
                .element(closeMemoInfo)
                .exists()
                .perform();
        return this;
    }
    @Step("click on the \"i\" icon ")
    public ChatbotPage openMemoInfoIcon(){
        driver.element().click(memoInfoIcon);
        return this;
    }
    @Step("click on the \"x\" icon ")
    public ChatbotPage closeMemoInfoIcon(){
        driver.element().click(closeMemoInfo);
        return this;
    }
    @Step("validate MemoInputInfo message")
    public ChatbotPage verifyMemoInputInfoMsg() {
        driver.element()
                .assertThat(memoInputInfo_msg)
                .text()
                .isEqualTo(memoInputInfoMsgCL)
                .perform();
        return this;
    }
    @Step("validate MemoInputInfo message")
    public ChatbotPage verifyMemoInputInfoMsgSIT() {
        driver.element()
                .assertThat(memoInputInfo_msg)
                .text()
                .isEqualTo(memoInputInfoMsgSITCL)
                .perform();
        return this;
    }
    @Step("validate MemoInputInfo message is not displayed after clicking on \"x\" icon")
    public ChatbotPage verifyXiconFunctionality(){
        driver.element()
                .assertThat(memoInputInfo_msg)
                .text()
                .isEqualTo(null)
                .perform();
        return this;
    }
    @Step("Verify CL text of memo info hyperLink ")
    public ChatbotPage verifyMemoInputInfoHyperlinkCL(){
        driver.element()
                .assertThat(memoInputInfo_hyperlink)
                .text()
                .isEqualTo(memoInputInfoHyperlinkCL)
                .perform();
        return this;
    }
    @Step("Verify CL text of memo info hyperLink ")
    public ChatbotPage verifyMemoInputInfoHyperlinkCLSIT(){
        driver.element()
                .assertThat(memoInputInfo_hyperlink)
                .text()
                .isEqualTo(memoInputInfoHyperlinkSITCL)
                .perform();
        return this;
    }
    @Step("Click memo info hyperlink")
    public ChatbotPage clickHyperlink(){
        driver.element().click(memoInputInfo_hyperlink);
        if(((System.getProperty("targetBrowserName").equals("chrome"))&&(driver.browser().alert().isAlertPresent()))||((System.getProperty("targetBrowserName").equals("microsoftedge"))&&(driver.browser().alert().isAlertPresent()))) {
            driver.browser().alert().acceptAlert();
        }
        return this;
    }
    @Step("Verify MemoInputInfo Hyperlink Functionality")
    public ChatbotPage verifyUserNavigatedToNewPage(){
        driver.browser()
                .assertThat()
                .url()
                .contains("dhl")
                .perform();
        return this;
    }
    @Step("Verify MemoInputInfo Hyperlink Functionality")
    public ChatbotPage verifyUserNavigatedToNewPageSIT(){
        switchToTabByIndex(2);
        driver.browser()
                .assertThat()
                .url()
                .contains("dhl")
                .perform();
        return this;
    }
    @Step("Verify \"i\" icon is not displayed when \"Memo_InputInfo\" isn't returned as in Lable2")
    public ChatbotPage verifyInfoIconDoesNotExist(){
        driver.assertThat()
                .element(memoInfoIconLable2)
                .doesNotExist()
                .perform();
        return this;
    }

    @Step("Validate Info Overlay enabled")
    public ChatbotPage validateInfoOverlayEnabled(){
        driver.element()
                .assertThat(infoOverlay)
                .isEnabled()
                .perform();
        return this;
    }
    @Step(" Verify Same date and time still displayed ")
    public ChatbotPage  validateSameDateTimeDisplayed(String date,String time){
        driver.verifyThat()
                .element(datePickerInputField)
                .text()
                .contains(date)
                .perform();
        driver.verifyThat()
                .element(timePickerInputField)
                .text()
                .contains(time)
                .perform();
        return this;
    }
    @Step("Validate Weiter Button Is not diplayed")
    public ChatbotPage validateWeiterBtnNotExists(){
        driver.element()
                .assertThat(submitButtonField)
                .doesNotExist()
                .perform();
        return this;
    }
    @Step("Validate info overlay Is not diplayed")
    public ChatbotPage validateInfoOverlayNotExists(){
        driver.element()
                .assertThat(infoOverlay)
                .doesNotExist()
                .perform();
        return this;
    }
    @Step("Switch to tickets page")
    public ChatbotPage switchToTickets(){
        driver.element().click(ticketsTabHeader);
        return this;
    }
    @Step("Validare user in chatbot page")
    public ChatbotPage validateUserInChatbot(){
        driver.browser()
                .verifyThat()
                .url()
                .contains("chatbot")
                .perform();
        return this;
    }
    @Step("Refresh Page")
    public ChatbotPage refreshPage(){
        driver.browser().refreshCurrentPage();
        return this;
    }
    @Step("deeplink to chatbot for the same user in a new tab")
    public ChatbotPage duplicateCurrentTab(){
        String currentUrl =driver.browser().getCurrentURL();
        driver.browser().switchToNewTab(currentUrl);
        return this;
    }
    @Step("Click on logout tab")
    public ChatbotPage logout(){
        driver.browser().waitForLazyLoading();
        driver.element().click(chatbotLogoutButton);
        return this;
    }
    @Step("Validate optionPicker exists")
    public ChatbotPage validateDropDownExists(){
        driver.element()
                .assertThat(dropDownDecisionTree)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate optionPicker exists")
    public ChatbotPage validateOptionPickerExists(){
        driver.element().assertThat(optionPickerDecisionTree).exists().perform();
        return this;
    }
    @Step("select optionPicker")
    public ChatbotPage selectOptionPicker(String option){
        driver.element().click(optionPicker(option));
        return this;
    }
    @Step("select optionPicker")
    public ChatbotPage selectdropDownOption(String option){
        driver.element().select(dropDownList,option);
        return this;
    }
    @Step("Enter text into  FormularOneColumn input field")
    public ChatbotPage typeIntoFormularOneColumnText(String text)
    {
        driver.element().type(formFormularOneColumnMobileNo,text);
        return this;
    }
    @Step("Enter text into  FormularOneColumn input field")
    public ChatbotPage validateFormularOneColumnInputFieldExists()
    {
        driver.element().
                assertThat(formFormularOneColumnMobileNo)
                .exists()
                .perform();
        return this;
    }
    @Step("Click FetrigBtn")
    public ChatbotPage clickFetrigBtn(){
        driver.element().click(optionChooserDecisionTreeFetrigBtn);
        return this;
    }
    @Step("Validate same mobile number displayed after switching between chatbot-tickets tabs")
    public ChatbotPage validateSameMobileNoCallbackDisplayed(String text)
    {
        driver.element()
                .verifyThat(rückrufnummerInputField)
                .text()
                .isEqualTo(text)
                .perform();
        return this;
    }
    @Step("Validate same text displayed after switching between chatbot-tickets tabs")
    public ChatbotPage validateSameTextDisplayed(String text)
    {
        driver.element()
                .verifyThat(formFormularOneColumnMobileNo)
                .text()
                .isEqualTo(text)
                .perform();
        return this;
    }
    @Step("Validate mandatory field still empty switching between chatbot-tickets tabs")
    public ChatbotPage validateFormularFieldEmpty()
    {
        driver.element()
                .verifyThat(formFormularOneColumnMobileNo)
                .text()
                .isEqualTo("")
                .perform();
        return this;
    }
    @Step("Validate drop down option selected")
    public ChatbotPage  validateSamedropDownOptionSelected(String option){
        driver.element().assertThat(getDropDownList(option)).isSelected();
        return this;
    }
    @Step("Validate option selected it's text turned to red")
    public ChatbotPage  validateSameOptionSelected(String option){
        driver.assertThat()
                .element(optionPicker(option))
                .cssProperty("border-bottom-color")
                .contains("230, 0, 0")
                .perform();
        return this;
    }
    @Step("validate Fetrig button is enabled")
    public ChatbotPage  validateFetrigBtnEnabled(){
        driver.element()
                .assertThat(optionChooserDecisionTreeFetrigBtn)
                .isEnabled()
                .perform();
        return this;
    }
    @Step("validate text black color")
    public ChatbotPage  validateDataBlackColor(){
        if(System.getProperty("targetBrowserName").equals("firefox")) {
            driver.element()
                    .assertThat(rückrufnummerInputField)
                    .cssProperty("color")
                    .contains("51, 51, 51")
                    .perform();
        }
        else {
            driver.element()
                    .assertThat(rückrufnummerInputField)
                    .cssProperty("color")
                    .contains("rgba(0, 0, 0, 1)")
                    .perform();
        }
        return this;
    }
    @Step("validate checkbox is selected")
    public ChatbotPage validatecheckBoxIsSelected()
    {
        driver.element()
                .assertThat(checkBoxCable)
                .isSelected()
                .perform();
        return this;
    }
    @Step("Validate optional field still empty switching between chatbot-tickets tabs")
    public ChatbotPage validateOptionalFieldEmptyDSL()
    {
        driver.element()
                .verifyThat(optionalInputField)
                .text()
                .isEqualTo("")
                .perform();
        return this;
    }
    @Step("Validate optional field still empty switching between chatbot-tickets tabs")
    public ChatbotPage validateOptionalFieldEmptyCableUM()
    {
        driver.element()
                .verifyThat(optionalField)
                .text()
                .isEqualTo("")
                .perform();
        return this;
    }
    @Step("Validate customer ID is saved for Mic form after switching between chatbot tickets tabs")
    public ChatbotPage validateCustomerIDSavedMicForm(String customerID)
    {
        driver.element()
                .assertThat(micFormCustomerID)
                .text()
                .isEqualTo(customerID)
                .perform();
        return this;
    }
    @Step("Validate postal code is saved for Mic form after switching between chatbot tickets tabs")
    public ChatbotPage validatePostalCodeSavedMicForm(String postalCode)
    {
        driver.element()
                .assertThat(micFormPostalCode)
                .text()
                .isEqualTo(postalCode)
                .perform();
        return this;
    }
    @Step("Validate family name is saved for Mic form after switching between chatbot tickets tabs")
    public ChatbotPage validateFamilyNameSavedMicForm(String familyName)
    {
        driver.assertThat()
                .element(micFormFamilyName)
                .text()
                .isEqualTo(familyName)
                .perform();
        return this;
    }
    @Step("Validate that wait is finished and wait form is no longer appearing after switching between tickets-chatbot tabs")
    public ChatbotPage validateWaitFormFinished()
    {
        driver.assertThat()
                .element(waitTemplateFinishedQuestion)
                .exists()
                .perform();
        return this;
    }
    @Step("Validate that text is Mandatory")
    public ChatbotPage validateFetrigBtIsDimmed()
    {
        driver.element()
                .assertThat(optionChooserDecisionTreeFetrigBtn)
                .cssProperty("pointer-events")
                .isEqualTo("none")
                .perform();
        return this;
    }

    @Step("click on callback form mobile number field")
    public ChatbotPage clickCallBackMobileField()
    {
        driver.element().click(rückrufnummerInputField);

        return this;
    }

    @Step("Refresh Page with accepting alerts")
    public ChatbotPage refreshPageWithAlert(){
        driver.browser().refreshCurrentPage();
        if(((System.getProperty("targetBrowserName").equals("chrome"))&&(driver.browser().alert().isAlertPresent()))||((System.getProperty("targetBrowserName").equals("microsoftedge"))&&(driver.browser().alert().isAlertPresent()))) {
            driver.browser().alert().acceptAlert();
        }
        return this;
    }

    @Step("Click on logout tab with accepting alerts")
    public ChatbotPage logoutWithAlert(){
        switch (System.getProperty("targetBrowserName")) {
            case "firefox":
                driver.element().click(chatbotLogoutButton);
                break;
            default:
                driver.element().click(chatbotLogoutButton);
                driver.browser().alert().acceptAlert();
        }
        return this;
    }
}



