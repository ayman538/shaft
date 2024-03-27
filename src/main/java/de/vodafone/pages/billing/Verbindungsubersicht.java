package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Verbindungsubersicht {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By errorMessageTitleLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By errorMessageBodyLocator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By errorMessageBodyPdfMultipleLocator = By.xpath("(//div[@automation-id='successMsg_tv']//p)[1]");
    private By errorMessageBodyCsvMultipleLocator = By.xpath("(//div[@automation-id='successMsg_tv']//p)[2]");
    private By newCustomerNotificationTitleLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By newCustomerNotificationBodyLocator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By newCustomerNotificationMessageLocator = By.xpath("//div[@class='alert noselect inProgress mt-sml-32']");
    private By noUsageNotificationTitleLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By noUsageNotificationBodyLocator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By noUsageNotificationMessageLocator = By.xpath("//div[@class='alert noselect inProgress mt-sml-32']");
    private By notBookedNotificationTitleLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By notBookedNotificationBodyLocator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By notBookedNotificationMessageLocator = By.xpath("//div[@class='alert noselect inProgress mt-sml-32']");
    private By downloadErrorMessageTitleLocator = By.xpath("//div[@class='table-container__modal-error']//h2");
    private By downloadErrorMessageBodyLocator = By.xpath("//div[@class='table-container__modal-error']//p");
    private By billCycleDropdown = By.xpath("(//select[@automation-id='ws10-form-select_dropdown'])[2]");
    private By errorMessageButtonLocator = By.xpath("//button[@automation-id='undefined_btn']");
    private By errorMessageLocator = By.xpath("//div[@automation-id='undefined_nt']/div");
    private By exitDownloadFailureMessage = By.xpath("//button[@class='nsm-dialog-btn-close']");
    private By dimmedPdfDownloadBtnLocator = By.xpath("//a[@class='ws10-button ws10-button--icon ws10-button--primary btn-red ws10-button--hybrid ws10-button--rectangle ws10-button--standard ws10-button--disabled ws10-button--icon-position-left']");
    private By dimmedCsvDownloadBtnLocator = By.xpath("//a[@class='ws10-button ws10-button--icon ws10-button--secondary ws10-button--hybrid ws10-button--rectangle ws10-button--standard ws10-button--disabled ws10-button--icon-position-left']");
    private By dimmedBillCycleFilterLocator = By.xpath("//select[@class='ws10-form-select__select ng-untouched ng-pristine']");
    private By detailedItemizedBillBookingMessageLocator = By.xpath("//span[contains(.,'Verbindungsübersicht in der Detail-Variante beauftragen')][@automation-id='undefined_description_tv']");
    private By miniItemizedBillBookingMessageLocator = By.xpath("//span[contains(.,'Verbindungsübersicht in der Mini-Variante beauftragen')][@automation-id='undefined_description_tv']");
    private By noNumbersNotificationHeadline_Locator = By.xpath("");
    private By noNumbersNotificationBody_Locator = By.xpath("");
    private By  noNumbersNotification_Locator = By.xpath("");
    private By pageHeadline_Locator = By.xpath("//div[@class='table-container']/div/h3");
    private By pageDescription_Locator = By.xpath("(//p[@class='table-container__subheadline']/span)[1]");
    private By totalAmount_Locator = By.xpath("//span[@automation-id='table_header_']");
    private By cardDescription_Locator = By.xpath("//div[@class='active-invoice-detials-card mb-64']//p/span");
    private By numbersFilterLabel_Locator = By.xpath("(//*[@automation-id='filter_label_tv'])[1]");
    private By billPeriodFilterLabel_Locator = By.xpath("(//*[@automation-id='filter_label_tv'])[2]");
    private By numbersFilter_Locator = By.xpath("(//*[@automation-id='ws10-form-select_dropdown'])[1]");
    private By billPeriodFilter_Locator = By.xpath("(//*[@automation-id='ws10-form-select_dropdown'])[2]");
    private By pdfDownloadBtn_Locator = By.xpath("(//*[@type='button'])[1]");
    private By csvDownloadBtn_Locator = By.xpath("(//*[@type='button'])[2]");
    private By faqSectionTitle_Locator = By.xpath("(//*[@automation-id='table_header_'])[3]");
    private By firstFaqAccordion_Locator = By.xpath("(//label[@class='ws10-accordion-item__label'])[1]");
    private By secondFaqAccordion_Locator = By.xpath("//label[@for='ws10-accordion-input-content2']");
    private By firstAccordionTitle_Locator = By.xpath("(//div[@automation-id='accordionModel_acc']//span)[1]");
    private By secondAccordionTitle_Locator = By.xpath("(//div[@automation-id='accordionModel_acc']//span)[2]");
    private By firstAccFirstAnswer_Locator = By.xpath("(//div[@id='ws10-accordion-item__content-content1']/div/div/p)[1]");
    private By firstAccSecondQuestion_Locator = By.xpath("(//div[@id='ws10-accordion-item__content-content1']/div/div/p)[2]");
    private By firstAccSecondAnswer_Locator = By.xpath("(//div[@id='ws10-accordion-item__content-content1']/div/div/p)[3]");
    private By secondAccFirstAnswer1_Locator = By.xpath("(//div[@id='ws10-accordion-item__content-content2']/div/div/p)[1]");
    private By secondAccFirstAnswer2_Locator = By.xpath("(//div[@id='ws10-accordion-item__content-content2']/div/div/p)[2]");
    private By secondAccSecondQuestion_Locator = By.xpath("(//div[@id='ws10-accordion-item__content-content2']/div/div/p)[3]");
    private By secondAccSecondAnswer_Locator = By.xpath("(//div[@id='ws10-accordion-item__content-content2']/div/div/p)[4]");


    //CLs

    private String pageHeadline_CL = "Deine Verbindungsübersicht";
    private String pageDescription_CL = "Schau Dir hier Deine Verbindungen im Detail an. Lad Dir dazu die gesamte Übersicht als PDF runter. Wähl den Teilnehmer:in und Zeitraum, den Du Dir anschauen möchtest.";
    private String cardDescription_CL = "Summe aller Verbindungen der Rufnummer";
    private String numbersFilterLabel_CL = "Teilnehmer:in";
    private String billPeriodFilterLabel_CL = "Zeitraum";
    private String pdfDownloadBtn_CL = "PDF herunterladen";
    private String csvDownloadBtn_CL = "CSV herunterladen";
    private String faqSectionTitle_CL = "Hilfe zu dieser Seite";
    private String errorMessageTitle = "Das hat leider nicht geklappt";
    private String errorMessageBody = "Entschuldige bitte, unser Fehler. Versuch es einfach später nochmal.";
    private String notReturnedCsvOrPdfHeader = "Das hat nicht geklappt";
    private String pdfErrorMessageBody = "PDF konnte nicht geladen werden. Versuch es bitte später nochmal.";
    private String csvErrorMessageBody = "CSV konnte nicht geladen werden. Versuch es bitte später nochmal.";
    private String greyBackGround = "190, 190, 190";
    private String darkGreyText = "126, 126, 126";
    private String firstAccordionTitle_CL = "Was ist eine CVS-Datei und was mache ich mit ihr?";
    private String secondAccordionTitle_CL = "Wie bearbeitest Du eine CSV-Datei in Excel?";
    private String firstAccFirstAnswer_CL = "CVS steht für \"Comma-Separated Values\".Eine CSV-Datei ist ein Textformat zur Speicherung von Daten in Tabellenform. Die Daten sind in Zeilen und Spalten angeordnet und durch Trennzeichen getrennt.Wie der Name schon sagt,sind meist Kommas die genutzen Trennzeichen.";
    private String firstAccSecondQuestion_CL = "Wie importierst Du eine CSV-Datei in Excel?";
    private String firstAccSecondAnswer_CL = "1.      Mach Excel auf.   2.     Klick auf \"Datei\" und wähl \"Öffnen\".   3.     Such die  CSV-Datei  auf deinem Computer und klick darauf.   4.     Im  \"Textimport-Assistenten\"  wähl  \"Getrennt\"  und klick dann auf \"Weiter\".   5.     Markier das  Trennzeichen, damit weiß Excel wie die Daten aufgeteilt sind.  6.     Klick auf \"Weiter\" und wähl das Format für jede Spalte aus.  7.     Du kannst auch Spalten auswählen und die Formate ändern. 8.     Klick auf \"Fertigstellen\" und Deine Datei ist importiert.";
    private String secondAccFirstAnswer1_CL = "Du kannst sie wie gewohnt bearbeiten. Füg Formeln hinzu, änder das Format der Daten oder erstell Diagramme. Enthaltene Daten in der CSV-Verbindungsübersicht für Mobilfunk:";
    private String secondAccFirstAnswer2_CL = "•  Datum\n" +
            "\n" +
            "•  Beginn der Verbindung\n" +
            "\n" +
            "•  Angerufene Nummer Mehr anzeigen\n" +
            "\n" +
            "•  Verbindungstyp\n" +
            "\n" +
            "•  Verbindungsart\n" +
            "\n" +
            "•  Ziel (Netz)\n" +
            "\n" +
            "•  Dauer (hh:mm:ss)\n" +
            "\n" +
            "•  Verbrauchtes Datenvolumen in MB\n" +
            "\n" +
            "•  Betrag (netto)\n" +
            "\n" +
            "•  Vodafone Mobiles Bezahlen";
    private String secondAccSecondQuestion_CL = "Wie sortierst Du den Einzelverbindungsnachweis (EVN) in Excel?";
    private String secondAccSecondAnswer_CL = "Sortieren: Klick über der Spalte, nach der Du sortieren willst. Wähl \"Aufsteigend\" oder \"Absteigend\". So kannst Du die EVN-Einträge nach Datum, Anrufdauer und mehr sortieren.\n" +
            "Filtern: Klick auf \"Filter\", so suchst Du gezielt nach bestimmten Infos. Wähl die Info, die Dir wichtig ist.";


    //Methods
    public Verbindungsubersicht(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By getAnyOptionLocatorFromDropdown(String displayedOptionNumberOrDate){
        return By.xpath("//select/option[contains(.,'"+displayedOptionNumberOrDate+"')]");
    }

    @Step("Get Notification Header")
    private By  getHeaderLocator(int i){
        return By.xpath("(//div[@automation-id='successMsg_tv']//h4)["+i+"]");
    }
    @Step("Download PDF")
    public Verbindungsubersicht downloadPDF() {
        driver.element().click(pdfDownloadBtn_Locator);
        return this;
    }

    @Step("Download CSV")
    public Verbindungsubersicht downloadCSV() {
        driver.element().click(csvDownloadBtn_Locator);
        return this;
    }

    @Step("Click On Connection Overview Tab Failure Error Message Reload Button")
    public Verbindungsubersicht clickOnErrorMessageReloadButton(){
        driver.element().click(errorMessageButtonLocator);
        return this;
    }

    @Step("Select number from the filter")
    public Verbindungsubersicht selectNumberFromFilter(String number) {
        driver.element().select(numbersFilter_Locator, number);
        return this;
    }

    @Step("Select Bill period from the filter")
    public Verbindungsubersicht selectBillPeriodFromFilter(String billPeriod) {
        driver.element().select(billPeriodFilter_Locator, billPeriod);
        return this;
    }

    @Step("expand first Accordion")
    public Verbindungsubersicht expandFirstAccordion() {
        driver.element().click(firstFaqAccordion_Locator);
        return this;
    }

    @Step("expand second Accordion")
    public Verbindungsubersicht expandSecondAccordion() {
        driver.element().click(secondFaqAccordion_Locator);
        return this;
    }

    @Step("Exit Download Failure Message")
    public Verbindungsubersicht exitDownloadFailureMessage(){
        driver.element().click(exitDownloadFailureMessage);
        return this;
    }


    //Validations
    public Verbindungsubersicht assertOnPageTitle() {
        driver.verifyThat().element(pageHeadline_Locator).textTrimmed().isEqualTo(pageHeadline_CL).withCustomReportMessage("Assert on page headline text").perform();
        return this;
    }

    public Verbindungsubersicht assertOnPageDescription() {
        driver.verifyThat().element(pageDescription_Locator).textTrimmed().isEqualTo(pageDescription_CL).withCustomReportMessage("Assert on page description text").perform();
        return this;
    }

    public Verbindungsubersicht assertOnTotalAmountValue(String totalAmount) {
        driver.verifyThat().element(totalAmount_Locator).textTrimmed().isEqualTo(totalAmount).withCustomReportMessage("Assert on Total Amount value").perform();
        return this;
    }

    public Verbindungsubersicht waitForAmountToBeChanged(String initValue){
        driver.element().waitForTextToChange(totalAmount_Locator,initValue);
        return this;
    }

    public Verbindungsubersicht assertOnCardDescription() {
        driver.verifyThat().element(cardDescription_Locator).textTrimmed().contains(cardDescription_CL).withCustomReportMessage("Assert on card description").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNumbersFilterLabel() {
        driver.verifyThat().element(numbersFilterLabel_Locator).textTrimmed().isEqualTo(numbersFilterLabel_CL).withCustomReportMessage("Assert on numbers filter label").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBillPeriodFilterLabel() {
        driver.verifyThat().element(billPeriodFilterLabel_Locator).textTrimmed().isEqualTo(billPeriodFilterLabel_CL).withCustomReportMessage("Assert on bill period filter label").perform();
        return this;
    }

    public Verbindungsubersicht assertOnPdfDownloadBtnText() {
        driver.verifyThat().element(pdfDownloadBtn_Locator).textTrimmed().isEqualTo(pdfDownloadBtn_CL).withCustomReportMessage("Assert on PDF download button text").perform();
        return this;
    }

    public Verbindungsubersicht assertOnPdfDownloadBtnColor() {
        driver.verifyThat().element(pdfDownloadBtn_Locator).cssProperty("background-color").contains("230, 0, 0").withCustomReportMessage("Assert on PDF download button color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnCsvDownloadBtnText() {
        driver.verifyThat().element(csvDownloadBtn_Locator).textTrimmed().isEqualTo(csvDownloadBtn_CL).withCustomReportMessage("Assert on CSV download button text").perform();
        return this;
    }

    public Verbindungsubersicht assertOnCsvDownloadBtnColor() {
        driver.verifyThat().element(csvDownloadBtn_Locator).cssProperty("background-color").contains("13, 13, 13").withCustomReportMessage("Assert on CSV download button color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnFaqSectionTitle() {
        driver.verifyThat().element(faqSectionTitle_Locator).textTrimmed().isEqualTo(faqSectionTitle_CL).withCustomReportMessage("Assert on FAQ section title text").perform();
        return this;
    }

    public Verbindungsubersicht assertThatFirstFaqAccordionCollapsed() {
        driver.verifyThat().element(firstFaqAccordion_Locator).attribute("class").doesNotContain("opened").withCustomReportMessage("assert that accordion collapsed").perform();
        return this;
    }

    public Verbindungsubersicht assertThatSecondFaqAccordionCollapsed() {
        driver.verifyThat().element(secondFaqAccordion_Locator).attribute("class").doesNotContain("opened").withCustomReportMessage("assert that accordion collapsed").perform();
        return this;
    }

    public Verbindungsubersicht assertOnFirstAccordionTitle() {
        driver.verifyThat().element(firstAccordionTitle_Locator).textTrimmed().isEqualTo(firstAccordionTitle_CL).withCustomReportMessage("assert on first accordion title").perform();
        return this;
    }

    public Verbindungsubersicht assertOnSecondAccordionTitle() {
        driver.verifyThat().element(secondAccordionTitle_Locator).textTrimmed().isEqualTo(secondAccordionTitle_CL).withCustomReportMessage("assert on second accordion title").perform();
        return this;
    }


    public Verbindungsubersicht assertOnFirstAccordionContent() {
        driver.verifyThat().element(firstAccFirstAnswer_Locator).textTrimmed().isEqualTo(firstAccFirstAnswer_CL).perform();
        driver.verifyThat().element(firstAccSecondQuestion_Locator).textTrimmed().isEqualTo(firstAccSecondQuestion_CL).perform();
        driver.verifyThat().element(firstAccSecondAnswer_Locator).textTrimmed().isEqualTo(firstAccSecondAnswer_CL).perform();
        return this;
        //todo add custom message
    }


    public Verbindungsubersicht assertOnSecondAccordionContent() {
        driver.verifyThat().element(secondAccFirstAnswer1_Locator).textTrimmed().isEqualTo(secondAccFirstAnswer1_CL).perform();
        driver.verifyThat().element(secondAccFirstAnswer2_Locator).textTrimmed().isEqualTo(secondAccFirstAnswer2_CL).perform();
        driver.verifyThat().element(secondAccSecondQuestion_Locator).textTrimmed().isEqualTo(secondAccSecondQuestion_CL).perform();
        driver.verifyThat().element(secondAccSecondAnswer_Locator).textTrimmed().isEqualTo(secondAccSecondAnswer_CL).perform();
        return this;
    }

    public Verbindungsubersicht assertOnConnectionOverViewFailureErrorMessageTitle(){
        driver.verifyThat().element(errorMessageTitleLocator).textTrimmed().isEqualTo(errorMessageTitle)
                .withCustomReportMessage("Assert On Connection OverView Error Message Title").perform();
        return this;
    }

    public Verbindungsubersicht assertOnConnectionOverViewFailureErrorMessageBody(){
        driver.verifyThat().element(errorMessageBodyLocator).textTrimmed().isEqualTo(errorMessageBody)
                .withCustomReportMessage("Assert On Connection OverView Error Message Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotificationMessageTitleOfPdfNotReturned(){
        driver.verifyThat().element(errorMessageTitleLocator).textTrimmed().isEqualTo(notReturnedCsvOrPdfHeader)
                .withCustomReportMessage("Assert On PDF Not Returned Notification Header").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotificationMessageTitleOfCsvNotReturnedForMultipleNotifications(){
        for (int i=1 ; i<3 ; i++) {
            driver.verifyThat().element(getHeaderLocator(i)).textTrimmed().isEqualTo(notReturnedCsvOrPdfHeader)
                    .withCustomReportMessage("Assert On PDF Not Returned Notification Header").perform();
        }
        return this;
    }

    public Verbindungsubersicht assertOnNotificationMessageBodyOfPdfNotReturned(){
        driver.verifyThat().element(errorMessageBodyLocator).textTrimmed().isEqualTo(pdfErrorMessageBody)
                .withCustomReportMessage("Assert On PDF Not Returned Notification Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotificationMessageBodyOfPdfNotReturnedAtMultipleNotifications(){
        driver.verifyThat().element(errorMessageBodyPdfMultipleLocator).textTrimmed().isEqualTo(pdfErrorMessageBody)
                .withCustomReportMessage("Assert On PDF Not Returned Notification Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotificationMessageBodyOfCsvNotReturnedAtMultipleNotifications(){
        driver.verifyThat().element(errorMessageBodyCsvMultipleLocator).textTrimmed().isEqualTo(csvErrorMessageBody)
                .withCustomReportMessage("Assert On CSV Not Returned Notification Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotificationMessageTitleOfCsvNotReturned(){
        driver.verifyThat().element(errorMessageTitleLocator).textTrimmed().isEqualTo(notReturnedCsvOrPdfHeader)
                .withCustomReportMessage("Assert On CSV Not Returned Notification Header").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotificationMessageBodyOfCsvNotReturned(){
        driver.verifyThat().element(errorMessageBodyLocator).textTrimmed().isEqualTo(csvErrorMessageBody)
                .withCustomReportMessage("Assert On CSV Not Returned Notification Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnConnectionOverViewFailureErrorMessageColor(String errorMessageColor){
        driver.verifyThat().element(errorMessageLocator).cssProperty("background-color").contains(errorMessageColor)
                .withCustomReportMessage("Assert On Connection OverView Failure Error Message Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBrandNewCustomerNotificationMessageTitle(String newCustomerNotificationTitle){
        driver.verifyThat().element(newCustomerNotificationTitleLocator).textTrimmed().isEqualTo(newCustomerNotificationTitle)
                .withCustomReportMessage("Assert On Brand New Customer Notification Title").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBrandNewCustomerNotificationMessageBody(String newCustomerNotificationBody){
        driver.verifyThat().element(newCustomerNotificationBodyLocator).textTrimmed().isEqualTo(newCustomerNotificationBody)
                .withCustomReportMessage("Assert On Brand New Customer Notification Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBrandNewCustomerNotificationMessageColor(String errorMessageColor){
        driver.verifyThat().element(newCustomerNotificationMessageLocator).cssProperty("background-color")
                .contains(errorMessageColor)
                .withCustomReportMessage("Assert On Brand New Customer Notification Message Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNoUsageNotificationMessageTitle(String newCustomerNotificationTitle){
        driver.verifyThat().element(noUsageNotificationTitleLocator).textTrimmed().isEqualTo(newCustomerNotificationTitle)
                .withCustomReportMessage("Assert On New Customer Notification Title").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNoUsageNotificationMessageBody(String newCustomerNotificationBody){
        driver.verifyThat().element(noUsageNotificationBodyLocator).textTrimmed().isEqualTo(newCustomerNotificationBody)
                .withCustomReportMessage("Assert On No Usage Notification Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNoUsageNotificationMessageColor(String errorMessageColor){
        driver.verifyThat().element(noUsageNotificationMessageLocator).cssProperty("background-color")
                .contains(errorMessageColor)
                .withCustomReportMessage("Assert On No Usage Notification Message Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotBookedNotificationMessageTitle(String newCustomerNotificationTitle){
        driver.verifyThat().element(notBookedNotificationTitleLocator).textTrimmed().isEqualTo(newCustomerNotificationTitle)
                .withCustomReportMessage("Assert On Not Booked Notification Title").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotBookedNotificationMessageBody(String newCustomerNotificationBody){
        driver.verifyThat().element(notBookedNotificationBodyLocator).textTrimmed().isEqualTo(newCustomerNotificationBody)
                .withCustomReportMessage("Assert On Not Booked Notification Body").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNotBookedNotificationMessageColor(String errorMessageColor){
        driver.verifyThat().element(notBookedNotificationMessageLocator).cssProperty("background-color")
                .contains(errorMessageColor)
                .withCustomReportMessage("Assert On Not Booked Notification Message Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnErrorMessageReloadButtonColorAndText(String buttonText, String ButtonColor){
        driver.verifyThat().element(errorMessageButtonLocator).textTrimmed().isEqualTo(buttonText)
                .withCustomReportMessage("Assert On Error Message Button Color And Text").perform();
        driver.verifyThat().element(errorMessageButtonLocator).cssProperty("background-color").contains(ButtonColor)
                .withCustomReportMessage("Assert On Error Message Button Color And Text").perform();
        return this;
    }

    public Verbindungsubersicht assertOnDownloadFailureMessageTitle(){
        driver.verifyThat().element(downloadErrorMessageTitleLocator).textTrimmed().isEqualTo(errorMessageTitle)
                .withCustomReportMessage("Assert On Connection OverView Error Message Title").perform();
        return this;
    }

    public Verbindungsubersicht assertOnDownloadFailureMessageBody(){
        driver.verifyThat().element(downloadErrorMessageBodyLocator).textTrimmed().isEqualTo(errorMessageBody)
                .withCustomReportMessage("Assert On Connection OverView Error Message Title").perform();
        return this;
    }

    public Verbindungsubersicht assertOnPdfDownloadButtonIsDimmed(){
        driver.verifyThat().element(dimmedPdfDownloadBtnLocator).attribute("class").contains("-disabled").withCustomReportMessage("Assert On PDF Download Button Is Dimmed").perform();

        return this;
    }

    public Verbindungsubersicht assertOnPdfDownloadButtonColor(){
        driver.verifyThat().element(dimmedPdfDownloadBtnLocator).cssProperty("background-color")
                .contains(greyBackGround).withCustomReportMessage("Assert On PDF Download Button Is Dimmed").perform();
        return this;
    }

    public Verbindungsubersicht assertOnPdfDownloadButtonTextColor(){
        driver.verifyThat().element(dimmedPdfDownloadBtnLocator).cssProperty("color")
                .contains(darkGreyText).withCustomReportMessage("Assert On PDF Download Button Is Dimmed").perform();
        return this;
    }

    public Verbindungsubersicht assertOnCsvDownloadButtonIsDimmed(){
        driver.verifyThat().element(dimmedCsvDownloadBtnLocator).attribute("class").contains("-disabled").withCustomReportMessage("Assert On PDF Download Button Is Dimmed").perform();

        return this;
    }

    public Verbindungsubersicht assertOnCsvDownloadButtonColor(){
        driver.verifyThat().element(dimmedCsvDownloadBtnLocator).cssProperty("background-color")
                .contains(greyBackGround).withCustomReportMessage("Assert On CSV Download Button Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnCsvDownloadButtonTextColor(){
        driver.verifyThat().element(dimmedCsvDownloadBtnLocator).cssProperty("color")
                .contains(darkGreyText).withCustomReportMessage("Assert On CSV Download Button Text Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNumbersDropDownIsDimmed(){
        driver.verifyThat().element(numbersFilter_Locator).isDisabled()
                .withCustomReportMessage("Assert On Numbers Dropdown Is Dimmed").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNumbersDropDownColor(){
        driver.verifyThat().element(numbersFilter_Locator).cssProperty("background-color")
                .contains("242, 242, 242").withCustomReportMessage("Assert On Numbers Dropdown Filter Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnNumbersDropDownTextColor(){
        driver.verifyThat().element(numbersFilter_Locator).cssProperty("color")
                .contains(greyBackGround).withCustomReportMessage("Assert On Numbers Dropdown Text Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBillCycleDropDownIsDimmed(){
        driver.verifyThat().element(dimmedBillCycleFilterLocator).isDisabled()
                .withCustomReportMessage("Assert On Bill Cycle Dropdown Is Dimmed").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBillCycleDropDownColor(){
        driver.verifyThat().element(dimmedBillCycleFilterLocator).cssProperty("background-color")
                .contains("242, 242, 242").withCustomReportMessage("Assert On Bill Cycle Dropdown Filter Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnDimmedBillCycleDropDownTextColor(){
        driver.verifyThat().element(billPeriodFilter_Locator).cssProperty("color")
                .contains(greyBackGround).withCustomReportMessage("Assert On Bill Cycle Dropdown Text Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBillCycleDropDownDimmed(){
        driver.verifyThat().element(billPeriodFilter_Locator).isDisabled()
                .withCustomReportMessage("Assert On Bill Cycle Dropdown Is Dimmed").perform();
        return this;
    }

    public Verbindungsubersicht assertOnDimmedBillCycleDropDownColor(){
        driver.verifyThat().element(billPeriodFilter_Locator).cssProperty("background-color")
                .contains("242, 242, 242").withCustomReportMessage("Assert On Bill Cycle Dropdown Filter Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBillCycleDropDownTextColor(){
        driver.verifyThat().element(dimmedBillCycleFilterLocator).cssProperty("color")
                .contains(greyBackGround).withCustomReportMessage("Assert On Bill Cycle Dropdown Text Color").perform();
        return this;
    }

    public Verbindungsubersicht assertOnBookingDetailedItemizedLinkTextAndColor(String text){
        driver.verifyThat().element(detailedItemizedBillBookingMessageLocator).textTrimmed().isEqualTo(text)
                .withCustomReportMessage("Assert On Detailed Variante Text ").perform();
        return this;
    }
    public Verbindungsubersicht assertOnBookingMiniItemizedLinkTextAndColor(String text){
        driver.verifyThat().element(miniItemizedBillBookingMessageLocator).textTrimmed().isEqualTo(text)
                .withCustomReportMessage("Assert On Detailed Variante Text ").perform();
        return this;
    }

    public Verbindungsubersicht assertThatUserNavigatedToBookingDetailedItemizedPage(String url){
        driver.element().click(detailedItemizedBillBookingMessageLocator);
        Object[] tabHandling = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(tabHandling[1].toString());
        driver.verifyThat().browser().url().isEqualTo(url)
                .withCustomReportMessage("Assert That User Navigated To Booking Detailed Itemized Page").perform();
        Object[] tabHandles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(tabHandles[0].toString());
        return this;
    }

    public Verbindungsubersicht assertThatUserNavigatedToBookingMiniItemizedPage(String url){
        driver.element().click(miniItemizedBillBookingMessageLocator);
        Object[] tabHandling = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(tabHandling[2].toString());
        driver.verifyThat().browser().url().isEqualTo(url)
                .withCustomReportMessage("Assert That User Navigated To Booking Mini Itemized Page").perform();
        Object[] tabHandles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(tabHandles[0].toString());
        return this;

    }

    public Verbindungsubersicht assertOnNoNumbersToBeDisplayedNotificationHeadline(String notificationTitle){
        driver.verifyThat().element(noNumbersNotificationHeadline_Locator).textTrimmed()
                .isEqualTo(notificationTitle).withCustomReportMessage("Assert On No Number Displayed Notification HL")
                .perform();

        return this;
    }

    public Verbindungsubersicht assertOnNoNumbersToBeDisplayedNotificationBody(String notificationBody){
        driver.verifyThat().element(noNumbersNotificationBody_Locator).textTrimmed()
                .isEqualTo(notificationBody).withCustomReportMessage("Assert On No Number Displayed Notification HL")
                .perform();

        return this;
    }

    public Verbindungsubersicht assertOnNoNumbersToBeDisplayedNotificationColor(String notificationColor){
        driver.verifyThat().element(noNumbersNotification_Locator).cssProperty("color").contains(notificationColor)
                .withCustomReportMessage("Assert on PDF download button color").perform();
        return this;
    }



    public Verbindungsubersicht assertThatItemizedBillDownloaded() {
        Validations.verifyThat()
                .object(isFileDownloaded(getDownloadPath(), "Verbindungsuebersicht"))
                .isTrue()
                .withCustomReportMessage("Assert that Itemized bill is downloaded")
                .perform();
        return this;
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        int i;
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName)) {
                dir_contents[i].delete();
                return flag = true;
            }

        }

        return flag;
    }

    private String downloadPath = SHAFT.Properties.paths.downloads();

    public String getDownloadPath() {
        return downloadPath;
    }
    @Step("wait for file to be downloaded")
    public void waitForFileToBeDownloaded() {
        if (driver.element().getElementsCount(By.xpath("fakeLocator")) == 1) {
            driver.element().click(By.xpath("fakeLocator"));
        }
    }

    public Verbindungsubersicht assertOnSelectedBillCycle(String billCycle){
        Select selection = new Select(driver.getDriver().findElement(billCycleDropdown));
        String selectedOption = selection.getFirstSelectedOption().getText();
        Validations.verifyThat().object(selectedOption).isEqualTo(billCycle)
                .withCustomReportMessage("Assert On Selected bill Cycle").perform();
        return this;
    }

}
