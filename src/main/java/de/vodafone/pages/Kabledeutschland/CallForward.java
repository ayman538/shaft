package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class CallForward {
    //variables
    private SHAFT.GUI.WebDriver driver;
    private String validDestinationNumber="01721234567";
    private String nonValidDestinationNumber="xxvc 0231561erw666";

    //CLs
    private static String pageTitleCL   = "Weiterleitung einrichten";
    private static String firstSectionTitleCL   = "Leitung wählen";
    private static String secondSectionTitleCL   = "Weiterleitung einrichten";
    private static String thirdSectionTitleCL   = "Daten überprüfen";
    private static String homeBoxTitleCL   = "Wähl bitte die Rufnummer aus.";
    private static String nonHomeBoxTitleCL   = "Wähl bitte die Leitung aus.";
    private static String forwardStatusTitleCL   = "Weiterleitung";
    private static String chooseButtonHomeBoxCL = "Wählen";
    private static String chooseButtonNonHomeBoxCL = "Auswählen";
    private static String secondStepTitleCL = "Art der Weiterleitung";
    private static String secondStepDescriptionCL = "Hier kannst Du die Art der Weiterleitung bestimmen. “Wenn besetzt” und “Nach 30 Sekunden” kannst Du kombinieren. Wähl ansonsten bitte nur eine Option aus.";
    private static String busyReasonCL = "Wenn besetzt";
    private static String rightAwayReasonCL = "Sofort";
    private static String after30SecondsReasonCL = "Nach 30 Sekunden";
    private static String proceedButtonCL = "Weiter";
    private static String destenationNumberSectionTitleCL = "Gib bitte die Zielrufnummer ein.";
    private static String destinationNumberLabelCL = "Zielrufnummer *";
    private static String destinationNumberInfoIconContentCL = "Du kannst eine Festnetz- oder Mobilfunknummer eingeben. Gib die Rufnummer im Format 021156398 oder 01721234567 ein. Ohne Leer- oder Sonderzeichen.";
    private static String thirdSteptitleCL = "Überprüf bitte nochmal alles.";
    private static String phoneNumberLabelCL = "Rufnummer";
    private static String lineNumberLabelCL = "Leitung";
    private static String destinationNumberLabelThirdStepCL = "Zielrufnummer";
    private static String forwardLabelCL = "Weiterleitung";
    private static String saveButtonCL = "Speichern";
    private static String successMessageTitleCL = "Geschafft";
    private static String successMessageBodyCL = "Deine Weiterleitung wurde gespeichert.";
    private static String overviewTitleCL = "Übersicht";
    private static String callForwardTitleCL = "Deine Weiterleitung:";
    private static String regexMessageCL = "Gib bitte nur Zahlen ein. Keine Buchstaben, Leer- oder Sonderzeichen.";
    private static String errorMsgTitleCL = "Das hat leider nicht geklappt";
    private static String errorMsgBodyCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    //Locators
    private static By pageTitle = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private static By userAccount = By.xpath("//div[@automation-id='pageHeader_tv']/h2");
    private static By firstSectionTitle = By.xpath("//div[@automation-id='step1_containertv']//div[@class='header-title']");
    private static By secondSectionTitle = By.xpath("//div[@automation-id='step2_containertv']//div[@class='header-title disable-header']");
    private static By thirdSectionTitle = By.xpath("//div[@automation-id='step3_containertv']//div[@class='header-title disable-header']");
    private static By homeBoxTitle = By.xpath("//div[@class='stepper-body show']//h3");
    private static By nonHomeBoxTitle = By.xpath("//div[@class='stepper-body show']//h3");
    private static By phoneNumberFirstCard = By.xpath("(//div[@class='white-box'])[1]");
    private static By phoneNumberSecondCard = By.xpath("(//div[@class='white-box'])[2]");
    private static By forwardStatusTitleFirstCard = By.xpath("(//div[@class='white-box']//p[@class='bold mb-0'])[1]");
    private static By forwardStatusFirstCard = By.xpath("(//div[@class='stepper-body show']//p[2])[1]");
    private static By forwardStatusTitleSecondCard = By.xpath("(//div[@class='white-box']//p[@class='bold mb-0'])[2]");
    private static By forwardStatusSecondCard = By.xpath("(//div[@class='stepper-body show']//p[2])[2]");
    private static By chooseButtonFirstCard = By.xpath("(//button[@automation-id='goToSecondStep_btn'])[1]");
    private static By chooseButtonSecondCard = By.xpath("(//button[@automation-id='goToSecondStep_btn'])[2]");
    private static By lineNumberFirstCard = By.xpath("(//div[@class='white-box'])[1]");
    private static By lineNumberSecondCard = By.xpath("(//div[@class='white-box'])[2]");
    private static By infoIconFirstCardNonHomeBoxOpen = By.xpath("(//info-icon[@automation-id='phoneLines-infoIcon_btn']//a)[1]");
    private static By infoIconSecondCardNonHomeBoxOpen = By.xpath("(//info-icon[@automation-id='phoneLines-infoIcon_btn']//a)[3]");
    private static By infoIconFirstCardContentNonHomeBox = By.xpath("(//div[@automation-id='phoneLines-infoIconInfoIcon_tv']//phone-numbers//div)[1]");
    private static By infoIconSecondCardContentNonHomeBox = By.xpath("(//div[@automation-id='phoneLines-infoIconInfoIcon_tv']//phone-numbers//div)[2]");
    private static By infoIconFirstCardNonHomeBoxClose = By.xpath("(//info-icon[@automation-id='phoneLines-infoIcon_btn']//a)[2]");
    private static By infoIconSecondCardNonHomeBoxClose = By.xpath("(//info-icon[@automation-id='phoneLines-infoIcon_btn']//a)[4]");
    private static By secondStepTitle = By.xpath("//div[@class='stepper-body show']//div[@class='cpm-groups']//h3");
    private static By secondStepDescription = By.xpath("//div[@class='stepper-body show']//div[@class='cpm-groups']//p[@class=\"mb-20\"]");
    private static By busyReason = By.xpath("(//div[@class='w-m-80 standard-form mb-20 w-60']//p[@class='displayinlineblock vertical-align-middle w-m-65 mt-9'])[1]");
    private static By busyToggleBtnOff = By.xpath("(//span[@class='off-text'])[1]");
    private static By busyToggleBtnOn = By.xpath("(//span[@class='on-text'])[1]");
    private static By busyToggleBtnOffFlag = By.xpath("//input[@automation-id='whenBusy_0_swt']");
    private static By rightAwayReason = By.xpath("(//div[@class='w-m-80 standard-form mb-20 w-60']//p[@class='displayinlineblock vertical-align-middle w-m-65 mt-9'])[2]");
    private static By rightAwayToggleBtnOff = By.xpath("(//span[@class='off-text'])[2]");
    private static By rightAwayToggleBtnOn = By.xpath("(//span[@class='on-text'])[2]");
    private static By rightAwayToggleBtnOffFlag = By.xpath("//input[@automation-id='immediately_0_swt']");
    private static By after30SecondsReason = By.xpath("(//div[@class='w-m-80 standard-form mb-20 w-60']//p[@class='displayinlineblock vertical-align-middle w-m-65 mt-9'])[3]");
    private static By after30SecondsToggleBtnOff = By.xpath("(//span[@class='off-text'])[3]");
    private static By after30SecondsToggleBtnOn = By.xpath("(//span[@class='on-text'])[3]");
    private static By after30SecondsToggleBtnOffFlag = By.xpath("//input[@automation-id='after30Seconds_0_swt']");
    private static By busyCheckedToggle = By.xpath("(//label[@for='whenBusy'])[@class='checked']");
    private static By rightAwayCheckedToggle = By.xpath("(//label[@for='immediately'])[@class='checked']");
    private static By after30SecondsCheckedToggle = By.xpath("(//label[@for='after30Seconds'])[@class='checked']");
    private static By proceedButton = By.xpath("//button[@automation-id='goThirdStep_btn']");
    private static By destinationNumberSectionTitle = By.xpath("//p[@class='bold font-20 mb-20']");
    private static By destinationNumberLabel = By.xpath("//div//text[@class='ng-untouched ng-pristine ng-invalid']//label");
    private static By destinationNumberTxtBox = By.xpath("//input[@automation-id='callForwardNumberTextBox_et']");
    private static By destinationNumberOpenInfoIcon = By.xpath("(//div[@automation-id='undefinedInfoIcon_tv']//a)[1]");
    private static By destinationNumberCloseInfoIcon = By.xpath("(//div[@automation-id='undefinedInfoIcon_tv']//a)[2]");
    private static By destinationNumberInfoIconContent = By.xpath("//p[@automation-id='undefined_tv']");
    private static By thirdStepTitle = By.xpath("//div[@class='stepper-body show']//h3");
    private static By phoneNumberLabel = By.xpath("(//div[@class='white-box mb-20']//p[@class='bold mb-0'])[1]");
    private static By lineNumberLabel = By.xpath("(//div[@class='white-box mb-20']//p[@class='bold mb-0'])[1]"); //8albn hyb2a zy phone number label
    private static By lineNumber = By.xpath("(//div[@class='white-box mb-20']//p)[2]");
    private static By phoneNumber = By.xpath("//div[@class='white-box mb-20']//span");
    private static By destinationNumberLabelThirdStep = By.xpath("(//div[@class='white-box mb-20']//p[@class='bold mb-0'])[2]");
    private static By destinationNumber = By.xpath("(//div[@class='white-box mb-20']//p)[3]");
    private static By forwardLabel = By.xpath("(//div[@class='white-box mb-20']//p[@class='bold mb-0'])[3]");
    private static By forwardReason = By.xpath("(//div[@class='white-box mb-20']//p)[5]");
    private static By saveButton = By.xpath("//button[@automation-id='navigateToSummary_btn']");
    private static By successMessageTitle = By.xpath("//div[@automation-id='call_forward_settings_success_nt']//h4");
    private static By successMessageBody = By.xpath("//div[@automation-id='call_forward_settings_success_nt']//p");
    private static By overviewTitle = By.xpath("(//li[@automation-id='call_forward_Settings_preview_acc']//span)[1]");
    private static By callForwardTitle = By.xpath("//li[@automation-id='call_forward_Settings_preview_acc']//div//h3");
    private static By regexMessage = By.xpath("//p[@automation-id='callForwardNumberTextBox_patternErrorMessage_et']");
    private static By errorMsgTitleCallForwardAccordion = By.xpath("//div[@id=\"telefoneinstellungenAccordionId\"]//div[@class=\"item-2 w-100\"]");
    private static By errorMsgBodyCallForwardAccordion = By.xpath("//div[@id=\"telefoneinstellungenAccordionId\"]//p[@class=\"notification-text mb-10 mt-10\"]");
    private static By errorMsgTitleAfterChangingForwardReason = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private static By errorMsgBodyAfterChangingForwardReason = By.xpath("//div[@automation-id='undefined_nt']//p");



    //Constructor
    public CallForward(SHAFT.GUI.WebDriver driver) {
        this.driver=driver;
    }

    //Methods
    public CallForward validateCallForwardPage() {
        driver.verifyThat().element(firstSectionTitle).exists();
        driver.verifyThat().element(firstSectionTitle)
                .textTrimmed().isEqualTo(firstSectionTitleCL)
                .withCustomReportMessage("Check first section title")
                .perform();
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitleCL)
                .withCustomReportMessage("Check Call Forward Page Title")
                .perform();
        driver.verifyThat().element(secondSectionTitle)
                .textTrimmed().isEqualTo(secondSectionTitleCL)
                .withCustomReportMessage("Check second section title")
                .perform();
        driver.verifyThat().element(thirdSectionTitle)
                .textTrimmed().isEqualTo(thirdSectionTitleCL)
                .withCustomReportMessage("Check third section title")
                .perform();
        return this;
    }

    public CallForward validateHomeBoxTitle(){
        driver.verifyThat().element(homeBoxTitle)
                .textTrimmed().isEqualTo(homeBoxTitleCL)
                .withCustomReportMessage("Validate Homebox Title CL")
                .perform();
        return this;
    }

    public CallForward validateNonHomeBoxTitle(){
        driver.verifyThat().element(nonHomeBoxTitle)
                .textTrimmed().isEqualTo(nonHomeBoxTitleCL)
                .withCustomReportMessage("Validate Non Homebox Title CL")
                .perform();
        return this;
    }

    public CallForward validateHomeBoxFirstCard(){
        driver.verifyThat().element(phoneNumberFirstCard).exists()
                .withCustomReportMessage("Validate Homebox first card phone number")
                .perform();
        driver.verifyThat().element(forwardStatusTitleFirstCard)
                .textTrimmed().isEqualTo(forwardStatusTitleCL)
                .withCustomReportMessage("Validate Forward Status Title in first Card HomeBox")
                .perform();
        driver.verifyThat().element(forwardStatusFirstCard).exists()
                .withCustomReportMessage("Validate Homebox first card forward status")
                .perform();
        driver.verifyThat().element(chooseButtonFirstCard)
                .textTrimmed().isEqualTo(chooseButtonHomeBoxCL)
                .withCustomReportMessage("Validate button")
                .perform();
        return this;
    }

    public CallForward validateHomeBoxSecondCard(){
        driver.verifyThat().element(phoneNumberSecondCard).exists()
                .withCustomReportMessage("Validate Homebox second card phone number")
                .perform();
        driver.verifyThat().element(forwardStatusTitleSecondCard)
                .textTrimmed().isEqualTo(forwardStatusTitleCL)
                .withCustomReportMessage("Validate Forward Status Title in first Card HomeBox")
                .perform();
        driver.verifyThat().element(forwardStatusSecondCard).exists()
                .withCustomReportMessage("Validate Homebox second card forward status")
                .perform();
        driver.verifyThat().element(chooseButtonSecondCard)
                .textTrimmed().isEqualTo(chooseButtonHomeBoxCL)
                .withCustomReportMessage("Validate button")
                .perform();
        return this;
    }

    public CallForward validateNonHomeBoxFirstCard(){
        driver.verifyThat().element(lineNumberFirstCard).exists()
                .withCustomReportMessage("Validate Non Homebox first card Line number")
                .perform();
        driver.verifyThat().element(forwardStatusTitleFirstCard).textTrimmed().isEqualTo(forwardStatusTitleCL)
                .withCustomReportMessage("Validate Forward Status Title in first Card Non HomeBox")
                .perform();
        driver.verifyThat().element(forwardStatusFirstCard).exists()
                .withCustomReportMessage("Validate Non Homebox first card forward status")
                .perform();
        driver.verifyThat().element(chooseButtonFirstCard)
                .textTrimmed().isEqualTo(chooseButtonNonHomeBoxCL)
                .withCustomReportMessage("Validate button")
                .perform();
        return this;
    }

    public CallForward validateNonHomeBoxSecondCard(){
        driver.verifyThat().element(lineNumberSecondCard).exists()
                .withCustomReportMessage("Validate Homebox second card Line number")
                .perform();
        driver.verifyThat().element(forwardStatusTitleSecondCard)
                .textTrimmed().isEqualTo(forwardStatusTitleCL)
                .withCustomReportMessage("Validate Forward Status Title in first Card HomeBox")
                .perform();
        driver.verifyThat().element(forwardStatusSecondCard).exists()
                .withCustomReportMessage("Validate Non Homebox second card forward status")
                .perform();
        driver.verifyThat().element(chooseButtonSecondCard)
                .textTrimmed().isEqualTo(chooseButtonNonHomeBoxCL)
                .withCustomReportMessage("Validate button")
                .perform();
        return this;
    }

    public CallForward openInfoIconFirstCardNonHomeBox(){
        driver.element().click(infoIconFirstCardNonHomeBoxOpen);
        return this;
    }

    public CallForward openInfoIconSecondCardNonHomeBox(){
        driver.element().click(infoIconSecondCardNonHomeBoxOpen);
        return this;
    }

    public CallForward validateFirstCardInfoIconContent() {
        driver.verifyThat().element(infoIconFirstCardContentNonHomeBox).exists()
                .withCustomReportMessage("Check First Card info icon content")
                .perform();
        return this;
    }

    public CallForward validateSecondCardInfoIconContent() {
        driver.verifyThat().element(infoIconSecondCardContentNonHomeBox).exists()
                .withCustomReportMessage("Check Second Card info icon content")
                .perform();
        return this;
    }

    public CallForward closeInfoIconFirstCardNonHomeBox(){
        driver.element().click(infoIconFirstCardNonHomeBoxClose);
        return this;
    }

    public CallForward closeInfoIconSecondCardNonHomeBox(){
        driver.element().click(infoIconSecondCardNonHomeBoxClose);
        return this;
    }

    public CallForward clickOnChooseForwardSettingsBtn(){
        driver.element().click(chooseButtonFirstCard);
        return this;
    }

    public CallForward validateSecondStep(){
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitleCL)
                .withCustomReportMessage("Check Call Forward Page Title")
                .perform();
        driver.verifyThat().element(userAccount).exists()
                .withCustomReportMessage("Validate that user account exist")
                .perform();
        driver.verifyThat().element(secondStepTitle)
                .textTrimmed().isEqualTo(secondStepTitleCL)
                .withCustomReportMessage("Check second Step Title")
                .perform();
        driver.verifyThat().element(secondStepDescription)
                .textTrimmed().isEqualTo(secondStepDescriptionCL)
                .withCustomReportMessage("Validate second Step description")
                .perform();
        driver.verifyThat().element(busyReason)
                .textTrimmed().isEqualTo(busyReasonCL)
                .withCustomReportMessage("Validate first reason")
                .perform();
        driver.verifyThat().element(busyToggleBtnOff).exists()
                .withCustomReportMessage("Validate toggle button for reason busy")
                .perform();
        driver.verifyThat().element(rightAwayReason).exists()
                .withCustomReportMessage("Validate second reason")
                .perform();
        driver.verifyThat().element(rightAwayToggleBtnOff).exists()
                .withCustomReportMessage("Validate toggle button for reason right away")
                .perform();
        driver.verifyThat().element(after30SecondsReason)
                .textTrimmed().isEqualTo(after30SecondsReasonCL)
                .withCustomReportMessage("Check third reason")
                .perform();
        driver.verifyThat().element(after30SecondsToggleBtnOff)
                .exists()
                .withCustomReportMessage("Validate toggle button for reason after 30 seconds")
                .perform();
        driver.verifyThat().element(proceedButton)
                .textTrimmed().isEqualTo(proceedButtonCL)
                .withCustomReportMessage("Check Proceed button")
                .perform();
        driver.verifyThat().element(proceedButton)
                .isDisabled()
                .withCustomReportMessage("Validate that Proceed button is disabled")
                .perform();
        return this;
    }

    public CallForward switchToggleBtnOnBusyReason(){
        driver.element().click(busyToggleBtnOff);
        return this;
    }

    public CallForward switchToggleBtnOnRightAwayReason(){
        driver.element().click(rightAwayToggleBtnOff);
        return this;
    }

    public CallForward switchToggleBtnOnAfter30SecondsReason(){
        driver.element().click(after30SecondsToggleBtnOff);
        return this;
    }

    public CallForward switchToggleBtnOffBusyReason(){
        driver.element().click(busyToggleBtnOn);
        return this;
    }

    public CallForward switchToggleBtnOffRightAwayReason(){
        driver.element().click(rightAwayToggleBtnOn);
        return this;
    }

    public CallForward switchToggleBtnOffAfter30SecondsReason(){
        driver.element().click(after30SecondsToggleBtnOn);
        return this;
    }

    public CallForward validateToggleBtnForAfter30SecondsReasonSwitchedOff(){
        driver.verifyThat().element(after30SecondsToggleBtnOffFlag)
                .exists()
                .withCustomReportMessage("Validate After 30 seconds toggle off exists")
                .perform();
        return this;
    }

    public CallForward validateToggleBtnForRightAwayReasonSwitchedOff(){
        driver.verifyThat().element(rightAwayToggleBtnOffFlag)
                .exists()
                .withCustomReportMessage("Validate Right Away toggle off exists")
                .perform();
        return this;
    }

    public CallForward validateToggleBtnForBusyReasonSwitchedOff(){
        driver.verifyThat().element(busyToggleBtnOffFlag)
                .exists()
                .withCustomReportMessage("Validate Busy toggle off exists")
                .perform();
        return this;
    }

    public CallForward validateDestinationNumberDetails(){
        driver.verifyThat().element(destinationNumberSectionTitle)
                .textTrimmed().isEqualTo(destenationNumberSectionTitleCL)
                .withCustomReportMessage("Validate Destination number section Title CL")
                .perform();
        driver.verifyThat().element(destinationNumberLabel)
                .textTrimmed().isEqualTo(destinationNumberLabelCL)
                .withCustomReportMessage("Validate Destination number label CL")
                .perform();
        driver.verifyThat().element(destinationNumberTxtBox)
                .exists()
                .withCustomReportMessage("Validate Destination number text box")
                .perform();
        driver.verifyThat().element(destinationNumberOpenInfoIcon)
                .exists()
                .withCustomReportMessage("Validate Destination number info. icon")
                .perform();
        return this;
    }

    public CallForward validateDisappearingDestinationNumberDetails(){
        driver.verifyThat().element(destinationNumberSectionTitle)
                .doesNotExist()
                .withCustomReportMessage("Validate Destination number section Title not exist")
                .perform();
        driver.verifyThat().element(destinationNumberLabel)
                .doesNotExist()
                .withCustomReportMessage("Validate  Destination number label not exist")
                .perform();
        driver.verifyThat().element(destinationNumberTxtBox)
                .doesNotExist()
                .withCustomReportMessage("Validate Destination number text box not exist")
                .perform();
        driver.verifyThat().element(destinationNumberOpenInfoIcon)
                .doesNotExist()
                .withCustomReportMessage("Validate Destination number info. icon not exist")
                .perform();
        return this;
    }

    public CallForward openInfoIconDestinationNumber(){
        driver.element().click(destinationNumberOpenInfoIcon);
        return this;
    }

    public CallForward validateInfoIconForDestinationNumberContent(){
        driver.verifyThat().element(destinationNumberInfoIconContent)
                .textTrimmed().isEqualTo(destinationNumberInfoIconContentCL)
                .withCustomReportMessage("Validate Info Icon For destination number content")
                .perform();
        return this;
    }

    public CallForward closeInfoIconDestinationNumber(){
        driver.element().click(destinationNumberCloseInfoIcon);
        return this;
    }

    public CallForward insertValidDestinationNumber() {
        driver.element().type(destinationNumberTxtBox,validDestinationNumber);
        driver.verifyThat().element(proceedButton)
                .isEnabled()
                .withCustomReportMessage("Validate that proceed button is enabled after inserting phone number in text box")
                .perform();
        return this;
    }

    public CallForward insertNonValidDestinationNumber() {
        driver.element().type(destinationNumberTxtBox, nonValidDestinationNumber);
        driver.element().isElementClickable(proceedButton);
        driver.element().click(proceedButton);
        driver.verifyThat().element(proceedButton)
                .isEnabled()
                .withCustomReportMessage("Validate that proceed button is enabled after inserting phone number in text box")
                .perform();
        return this;
    }

    public CallForward validateRegexMessageForNonValidDestinationNumber(){
        driver.verifyThat().element(regexMessage)
                .textTrimmed().isEqualTo(regexMessageCL)
                .withCustomReportMessage("Validate Regex Message For non valid destination number")
                .perform();
        return this;
    }

    public CallForward clickOnProceedBtn(){
        driver.element().click(proceedButton);
        return this;
    }

    public CallForward validateThirdStepForHomeBox(){
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitleCL)
                .withCustomReportMessage("Check Call Forward Page Title")
                .perform();
        driver.verifyThat().element(userAccount)
                .exists()
                .withCustomReportMessage("Check that user account exist")
                .perform();
        driver.verifyThat().element(thirdStepTitle)
                .textTrimmed().isEqualTo(thirdSteptitleCL)
                .withCustomReportMessage("Validate third step Title CL")
                .perform();
        driver.verifyThat().element(phoneNumberLabel)
                .isVisible()
                .withCustomReportMessage("Validate phone number label CL appears")
                .perform();
        driver.verifyThat().element(phoneNumberLabel)
                .textTrimmed().isEqualTo(phoneNumberLabelCL)
                .withCustomReportMessage("Validate phone number label CL")
                .perform();
        driver.verifyThat().element(lineNumber)
                .exists()
                .withCustomReportMessage("Validate line number exist")
                .perform();
        driver.verifyThat().element(destinationNumberLabelThirdStep)
                .textTrimmed().isEqualTo(destinationNumberLabelThirdStepCL)
                .withCustomReportMessage("Validate destination number label CL")
                .perform();
        driver.verifyThat().element(destinationNumber)
                .exists()
                .withCustomReportMessage("Validate destination number exist")
                .perform();
        driver.verifyThat().element(forwardReason)
                .exists()
                .withCustomReportMessage("Validate Forward Reason exist")
                .perform();
        driver.verifyThat().element(saveButton)
                .textTrimmed().isEqualTo(saveButtonCL)
                .withCustomReportMessage("Validate save button CL")
                .perform();
        driver.verifyThat().element(saveButton)
                .isEnabled()
                .withCustomReportMessage("Validate save button is enabled")
                .perform();
        return this;
    }

    public CallForward validateThirdStepForNonHomeBox(){

        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitleCL)
                .withCustomReportMessage("Check Call Forward Page Title")
                .perform();
        driver.verifyThat().element(userAccount)
                .exists()
                .withCustomReportMessage("Check that user account exist")
                .perform();
        driver.verifyThat().element(thirdStepTitle)
                .textTrimmed().isEqualTo(thirdSteptitleCL)
                .withCustomReportMessage("Validate third step Title CL")
                .perform();
        driver.verifyThat().element(lineNumberLabel)
                .textTrimmed().isEqualTo(lineNumberLabelCL)
                .withCustomReportMessage("Validate line number label CL")
                .perform();
        driver.verifyThat().element(phoneNumber)
                .exists()
                .withCustomReportMessage("Validate phone number exist")
                .perform();
        driver.verifyThat().element(destinationNumberLabelThirdStep)
                .textTrimmed().isEqualTo(destinationNumberLabelThirdStepCL)
                .withCustomReportMessage("Validate destination number label CL")
                .perform();
        driver.verifyThat().element(destinationNumber)
                .exists()
                .withCustomReportMessage("Validate destination number exist")
                .perform();
        driver.verifyThat().element(forwardReason)
                .exists()
                .withCustomReportMessage("Validate Forward Reason exist")
                .perform();
        driver.verifyThat().element(saveButton)
                .textTrimmed().isEqualTo(saveButtonCL)
                .withCustomReportMessage("Validate save button CL")
                .perform();
        driver.verifyThat().element(saveButton)
                .exists()
                .withCustomReportMessage("Validate save button is enabled")
                .perform();
        return this;
    }

    public CallForward clickOnSaveBtn(){
        driver.element().click(saveButton);
        return this;
    }

    public CallForward validateSuccessMessageStep(){

        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitleCL)
                .withCustomReportMessage("Check Call Forward Page Title")
                .perform();
        driver.verifyThat().element(userAccount)
                .exists()
                .withCustomReportMessage("Check that user account exist")
                .perform();
        driver.verifyThat().element(successMessageTitle)
                .textTrimmed().isEqualTo(successMessageTitleCL)
                .withCustomReportMessage("Validate success message Title")
                .perform();
        driver.verifyThat().element(successMessageBody)
                .textTrimmed().isEqualTo(successMessageBodyCL)
                .withCustomReportMessage("Validate success message Body")
                .perform();
        return this;
    }

    public CallForward expandOverViewSectionUnderSuccessMessage(){
        driver.element().click(overviewTitle);
        return this;
    }

    public CallForward validateOverviewSectionForHomeBox(){
        driver.verifyThat().element(overviewTitle)
                .textTrimmed().isEqualTo(overviewTitleCL)
                .withCustomReportMessage("Check overview section Title")
                .perform();
        driver.verifyThat().element(callForwardTitle)
                .textTrimmed().isEqualTo(callForwardTitleCL)
                .withCustomReportMessage("Check call forward title")
                .perform();
        driver.verifyThat().element(phoneNumberLabel)
                .isVisible()
                .withCustomReportMessage("Validate phone number label CL appears")
                .perform();
        driver.verifyThat().element(phoneNumberLabel)
                .textTrimmed().isEqualTo(phoneNumberLabelCL)
                .withCustomReportMessage("Validate phone number label CL")
                .perform();
        driver.verifyThat().element(lineNumber)
                .exists()
                .withCustomReportMessage("Validate phone number exist")
                .perform();
        driver.verifyThat().element(destinationNumberLabelThirdStep)
                .textTrimmed().isEqualTo(destinationNumberLabelThirdStepCL)
                .withCustomReportMessage("Validate destination number label ")
                .perform();
        driver.verifyThat().element(destinationNumber)
                .exists()
                .withCustomReportMessage("Validate destination number exist")
                .perform();
        driver.verifyThat().element(forwardReason)
                .exists()
                .withCustomReportMessage("Validate Forward Reason exist")
                .perform();
        return this;
    }

    public CallForward validateOverviewSectionForNonHomeBox(){
        driver.verifyThat().element(overviewTitle)
                .textTrimmed().isEqualTo(overviewTitleCL)
                .withCustomReportMessage("Validate overview section Title")
                .perform();
        driver.verifyThat().element(callForwardTitle)
                .textTrimmed().isEqualTo(callForwardTitleCL)
                .withCustomReportMessage("Validate  call forward title")
                .perform();
        driver.verifyThat().element(lineNumberLabel)
                .textTrimmed().isEqualTo(lineNumberLabelCL)
                .withCustomReportMessage("Validate  line number label CL")
                .perform();
        driver.verifyThat().element(phoneNumber)
                .exists()
                .withCustomReportMessage("Validate  phone number exist")
                .perform();
        driver.verifyThat().element(destinationNumberLabelThirdStep)
                .textTrimmed().isEqualTo(destinationNumberLabelThirdStepCL)
                .withCustomReportMessage("Validate destination number label CL")
                .perform();
        driver.verifyThat().element(destinationNumber)
                .exists()
                .withCustomReportMessage("Validate  destination number exist")
                .perform();
        driver.verifyThat().element(forwardReason)
                .exists()
                .withCustomReportMessage("Validate Forward Reason exist")
                .perform();
        return this;
    }

    public CallForward deeplinkToCallForwardSettingsPage(){
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st")+"meinvodafone/services/telefoneinstellungen/weiterleitung");
        return this;
    }

    public CallForward validateErrorMessageInCallForwardAccordion(){
        driver.verifyThat().element(errorMsgTitleCallForwardAccordion)
                .textTrimmed().isEqualTo(errorMsgTitleCL)
                .withCustomReportMessage("Validate Error Message Title")
                .perform();
        driver.verifyThat().element(errorMsgBodyCallForwardAccordion)
                .textTrimmed().isEqualTo(errorMsgBodyCL)
                .withCustomReportMessage("Validate Error Message Body")
                .perform();
        return this;
    }

    public CallForward validateErrorMessageChangeForwardReason(){
        driver.verifyThat().element(errorMsgTitleAfterChangingForwardReason)
                .textTrimmed().isEqualTo(errorMsgTitleCL)
                .withCustomReportMessage("Validate Error Message Title")
                .perform();
        driver.verifyThat().element(errorMsgBodyAfterChangingForwardReason)
                .textTrimmed().isEqualTo(errorMsgBodyCL)
                .withCustomReportMessage("Validate Error Message Body")
                .perform();
        return this;
    }
}
