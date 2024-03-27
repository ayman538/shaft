package de.vodafone.pages.CableMigration;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class KostenkontrollePage {

    //Locators
    private SHAFT.GUI.WebDriver driver;
    private By Kostenkontrolle_Tab = By.xpath("//a[@automation-id='Kostenkontrolle_Link']");
    private By telefon_button = By.xpath("//input[@id='KIP']");
    private By Header_Text = By.xpath("//div/h4[@automation-id='unbilledMeineRechnungenBothProductsTitle_tv']");
    private By SubHeader_Text = By.xpath("//div/p[@automation-id='unbilledMeineRechnungenBothProductsDescription_tv']");
    private By BlackText = By.xpath("//div[@automation-id='unbilledMeineRechnungenBothProductsCtaMessage_tv']");
    private By TV_Video_accordion = By.xpath("//fieldset/radio-item[1][@automation-id='unbilledMeineRechnungenBothProductsTV_rb']");
    private By Text = By.xpath("//div/h4[@automation-id='unbilledVideoContentTotalAmountHeader_tv']");
    private By SubText = By.xpath("//div/p[@automation-id='unbilledVideoContentTotalAmounDescription_tv']");
    private By Collapse_Btn = By.xpath("//div//li[1]//div[1][@automation-id='unbilledVideoContentConnectionDetailsIconContainer_tv']");
    private By Date = By.xpath("//div//li[1]//div[1][@automation-id='unbilledVideoContentConnectionDetailsExpandedDateLabel_tv']");
    private By Duration = By.xpath("//div//li[1]//div[1][@automation-id='unbilledVideoContentConnectionDetailsExpandedTimeLabel_tv']");
    private By ZeroBillsMsgHeader_Text = By.xpath("//div[@id='content']//notification//h4");
    private By ZeroBillsMsgSubHeader_Text = By.xpath("//div[@id='content']//notification//p");
    private By NoBookingMsgHeader_Text = By.xpath("//div[@id='content']//notification//h4");
    private By NoBookingMsgSubHeader_Text = By.xpath("//div[@id='content']//notification/div/div/div[2]/p");
    //values locator
    private static By accountNumber_ValueLocator = By.xpath("//div[@automation-id='invoiceSummaryAccountNumber_tv']/div[2]");
    private static By billPeriod_ValueLocator = By.xpath("//div[@automation-id='invoiceSummaryDueDate_tv']/div[2]");
    private static By billDate_ValueLocator = By.xpath("//div[@automation-id='invoiceSummaryDate_tv']/div[2]");
// WFFT-2695
    private By header_Text = By.xpath("//*[@automation-id='unbilledMeineRechnungenBothProductsTitle_tv']");
    private By subHeader_Text = By.xpath("//*[@automation-id='unbilledMeineRechnungenBothProductsDescription_tv']");
    private By telefonTail_Select = By.id("KIP");
    private By telefon_Header_Text = By.xpath("//*[@automation-id='unbilledPhoneContentHeader_tv']");
    private By telefon_SubHeader_Text = By.xpath("//*[@automation-id='unbilledPhoneContentPhoneDescription_tv']");
    private By telefonNumber_Select = By.xpath("//*[@automation-id='undefined_btn']");
    private By secondTelefonNumber_Select = By.xpath("(//*[@automation-id='undefined_lv']//li)[2]");

    private By telefonNumber_Header_Text = By.xpath("//div[@id='unbilledUsageDataAccordion']/h4");
    private By telefonNumber_SubHeader_Text = By.xpath("//*[@automation-id='unbilledPhoneContentTotalAmounDescription_tv']");
    private By firstCategory_Select = By.xpath("(//*[@automation-id='unbilledPhoneContentConnectionDetailsName_tv'])[1]");
    private By secondCategory_Select = By.xpath("(//*[@automation-id='unbilledPhoneContentConnectionDetailsName_tv'])[2]");
    private By thirdCategory_Select = By.xpath("(//*[@automation-id='unbilledPhoneContentConnectionDetailsName_tv'])[3]");
    private By fourthCategory_Select = By.xpath("");
    private By fifthCategory_Select = By.xpath("");
    private By sixthCategory_Select = By.xpath("");
    private By noCalls_NotificationHeader_Text = By.xpath("//*[@class='item-2 w-100']//h4");
    private By noCalls_NotificationSubHeader_Text = By.xpath("(//*[@class='alert noselect info']//p)[1]");
    private By notBooked_NotificationHeader_Text = By.xpath("//*[@class='item-2 w-100']//h4");
    private By notBooked_NotificationSubHeader_Text = By.xpath("//*[@class='alert noselect info']//p");
    private By notActive_NotificationHeader_Text = By.xpath("//*[@class='item-2 w-100']//h4");
    private By notActive_NotificationSubHeader_Text = By.xpath("(//*[@class='alert noselect info']//p)[1]");
    private By notActive_ActivationButton_Text = By.xpath("//*[@automation-id='noItemized_Link']");

    //WFFT_3341
    private By errorMsgHeader_txt = By.xpath("//h4[@class='flexDiv']");
    private By errorMsg1SubHeader_txt = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By errorMsg2SubHeader_txt = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By errorMsg3SubHeader_txt = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By errorMsg4SubHeader_txt = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private By NotificationMsg5SubHeader_txt = By.xpath("//p[@class='notification-text mb-10 mt-10']");

    //CLs
    public static String Header = "Meine Verbrauchskosten";
    public static String SubHeader= "Seit der vorigen Rechnung angefallene Kosten, die noch nicht in Rechnung gestellt wurden.";
    public static String BlackTextt = "Einzelkosten anzeigen für:";
    public static String Textt = "Verbindungskosten";
    public static String SubTextt= "Die Preise für TV & Video sind Brutto-Beträge.";
    public static String Datee= "Datum";
    public static String Durationn= "Uhrzeit";
    public static String MsgText= "Wichtig für Dich";
    public static String MsgSubText= "Du hast im Moment keine Kosten für TV & Video.";
    public static String NoBookingMsgText= "Das funktioniert gerade nicht";
    public static String NoBookingMsgSubText= "Du siehst hier keine Einträge, weil Du für den Bereich TV & Video keinen Einzelverbindungsnachweis gebucht hast.";

    //WFFT-3341
    //private static String errorMsgHeader= "Das funktioniert gerade nicht";
    private static String errorMsgHeader= "Das funktioniert gerade nicht";
    private static String errorMsg1SubHeader= "Die Daten können gerade nicht geladen werden. Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String errorMsg2SubHeader= "Die Daten für den Bereich Telefon können gerade nicht geladen werden. Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String errorMsg3SubHeader= "Leider können wir gerade keine Daten zum Bereich TV & Video anzeigen.";
    private static String errorMsg4SubHeader= "Die Daten können gerade nicht geladen werden. Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String NotificationMsg5SubHeader= "Du hast im Moment keinen Einzelverbindungsnachweis gebucht. Du willst das ändern? Dann klick einfach unten auf den Button und richte alles ein.";
    public KostenkontrollePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Clink on the Kostenkontrolle tab")
    public KostenkontrollePage ClickOnKostenkontrolleTab() {
        driver.element().click(Kostenkontrolle_Tab);
        return this;
    }

    @Step("Clink on the Telefon button")
    public KostenkontrollePage ClickOnTelefonButton() {
        driver.element().click(telefon_button);
        return this;
    }

    @Step("Clink on the Video")
    public KostenkontrollePage ClickOnTVandVideo() {
        driver.element().click(TV_Video_accordion);
        return new KostenkontrollePage(driver);
    }

    @Step("Clink on the collapsable card")
    public KostenkontrollePage ClickOnCollapseBtn() {
        driver.element().click(Collapse_Btn);
        return new KostenkontrollePage(driver);
    }
    @Step("Validate the first group of texts")
    public void validateMeinRechnungTexts(){
        driver.verifyThat()
                .element(Header_Text)
                .textTrimmed()
                .isEqualTo(Header)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .textTrimmed()
                .isEqualTo(SubHeader)
                .perform();
        driver.verifyThat()
                .element(BlackText)
                .textTrimmed()
                .isEqualTo(BlackTextt)
                .perform();
    }

    @Step("Validate the second group of texts")
    public void validateText(String textt, String subTextt){
        driver.verifyThat()
                .element(Text)
                .textTrimmed()
                .isEqualTo(Textt)
                .perform();
        driver.verifyThat()
                .element(SubText)
                .textTrimmed()
                .isEqualTo(SubTextt)
                .perform();
    }
    @Step("Validate the collapse card date and duration")
    public void validateCollapsibleCard(String datee, String durationn){
        driver.verifyThat()
                .element(Date)
                .textTrimmed()
                .isEqualTo(Datee)
                .perform();
        driver.verifyThat()
                .element(Duration)
                .textTrimmed()
                .isEqualTo(Durationn)
                .perform();
    }

    @Step("Validate no bills msg header and body")
    public void validateZeroBillsInfoMsg(String msgText, String msgSubText){
        driver.verifyThat()
                .element(ZeroBillsMsgHeader_Text)
                .textTrimmed()
                .isEqualTo(MsgText)
                .perform();
        driver.verifyThat()
                .element(ZeroBillsMsgSubHeader_Text)
                .textTrimmed()
                .isEqualTo(MsgSubText)
                .perform();
    }
    @Step("Validate no video service msg header and body")
    public void validateNoBookingInfoMsg(String noBookingMsgText, String noBookingMsgSubText){
        driver.verifyThat()
                .element(NoBookingMsgHeader_Text)
                .textTrimmed()
                .isEqualTo(NoBookingMsgText)
                .perform();
        driver.verifyThat()
                .element(NoBookingMsgSubHeader_Text)
                .textTrimmed()
                .isEqualTo(NoBookingMsgSubText)
                .perform();
    }
    //WFFT-2695

    @Step("Click on TelefonTail")
    public void selectTelefonTail(){

        driver.element().click(telefonTail_Select);
    }
    @Step("Click on second NO.")
    public void selectSecondNumber(){
        driver.element().click(telefonNumber_Select);
        driver.element().click(secondTelefonNumber_Select);

    }
    @Step("Select First Category")
    public void selectFirstCategory(){
        driver.element().click(firstCategory_Select);
    }
    @Step("Validate Kostenkontrolle Tab Details")
    public KostenkontrollePage validateKostenkontrolleTabDetails(String expectedTabHeader,String expectedTabSubHeader){
        driver.verifyThat()
                .element(header_Text)
                .text()
                .contains(expectedTabHeader)
                .perform();
        driver.verifyThat()
                .element(subHeader_Text)
                .text()
                .contains(expectedTabSubHeader)
                .perform();
        return this;
    }
    @Step("Validate Telefon Tail Details")
    public KostenkontrollePage validateTelefonTailDetails(String expectedTailHeader,String expectedTailSubHeader){
        driver.verifyThat()
                .element(telefon_Header_Text)
                .text()
                .contains(expectedTailHeader)
                .perform();
        driver.verifyThat()
                .element(telefon_SubHeader_Text)
                .text()
                .contains(expectedTailSubHeader)
                .perform();
        return this;
    }
    @Step("Validate Telefon Number Details")
    public KostenkontrollePage validateTelefonNumberDetails(String expectedHeader,String expectedSubHeader){
        driver.verifyThat()
                .element(telefonNumber_Header_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        driver.verifyThat()
                .element(telefonNumber_SubHeader_Text)
                .text()
                .contains(expectedSubHeader)
                .perform();
        return this;
    }
    @Step("Validate Telefon No Calls Case Details")
    public KostenkontrollePage validateTelefonNoCallsCaseDetails(String expectedHeader,String expectedSubHeader){
        driver.verifyThat()
                .element(noCalls_NotificationHeader_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        driver.verifyThat()
                .element(noCalls_NotificationSubHeader_Text)
                .text()
                .contains(expectedSubHeader)
                .perform();
        return this;
    }
    @Step("Validate Telefon Not Booked Case Details")
    public KostenkontrollePage validateTelefonNotBookedCaseDetails(String expectedHeader,String expectedSubHeader){
        driver.verifyThat()
                .element(notBooked_NotificationHeader_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        driver.verifyThat()
                .element(notBooked_NotificationSubHeader_Text)
                .text().contains(expectedSubHeader)
                .withCustomReportMessage("Check not booked Notification SubHeader is displayed").perform();
        return this;
    }
    @Step("Validate Telefon Not Active Case Details")
    public KostenkontrollePage validateTelefonNotActiveCaseDetails(String expectedHeader,String expectedSubHeader,String activationButtonText){
        driver.verifyThat()
                .element(notActive_NotificationHeader_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        driver.verifyThat()
                .element(notActive_NotificationSubHeader_Text)
                .text()
                .contains(expectedSubHeader)
                .perform();
        driver.verifyThat().element(notActive_ActivationButton_Text)
                .text()
                .contains(activationButtonText)
                .perform();
        return this;
    }

    //WFFT-3341
    @Step("Validate error msg when both Telephone & TV are failed")
    public void ValidateAll_ServiceError() {
        driver.verifyThat()
                .element(errorMsgHeader_txt)
                .text()
                .isEqualTo(errorMsgHeader)
                .perform();
    /*    driver.verifyThat()
                .element(errorMsg1SubHeader_txt)
                .text()
                .isEqualTo(errorMsg1SubHeader)
                .perform();*/
    }
    @Step("Validate error msg when only Telephone is failed")
    public void ValidateTelephone_ServiceError() {
        driver.verifyThat()
                .element(errorMsgHeader_txt)
                .text()
                .isEqualTo(errorMsgHeader)
                .perform();
        /*driver.verifyThat()
                .element(errorMsg2SubHeader_txt)
                .text()
                .isEqualTo(errorMsg2SubHeader)
                .perform();*/
    }
    @Step("Validate error msg when only TV is failed")
    public void ValidateTV_ServiceError() {
        driver.verifyThat()
                .element(errorMsgHeader_txt)
                .text()
                .isEqualTo(errorMsgHeader)
                .perform();
       /* driver.verifyThat()
                .element(errorMsg3SubHeader_txt)
                .text()
                .isEqualTo(errorMsg3SubHeader)
                .perform();*/
    }
    @Step("Validate error msg when one service has failed while the other service is not booked")
    public void ValidateNotBooked_ServiceError() {
        driver.verifyThat()
                .element(errorMsgHeader_txt)
                .text()
                .isEqualTo(errorMsgHeader)
                .perform();
     /*   driver.verifyThat()
                .element(errorMsg4SubHeader_txt)
                .text()
                .isEqualTo(errorMsg4SubHeader)
                .perform();*/
    }
    @Step("Validate error msg when the two services are not booked")
    public void ValidateNotBookedNotification() {
        driver.verifyThat()
                .element(NoBookingMsgHeader_Text)
                .text()
                .isEqualTo(NoBookingMsgText)
                .perform();
       /* driver.verifyThat()
                .element(NotificationMsg5SubHeader_txt)
                .text()
                .isEqualTo(NotificationMsg5SubHeader)
                .perform();*/
    }
    public void validateKostenkontrolleTexts(){
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .isEqualTo(Header)
                .perform();
        driver.verifyThat()
                .element(SubHeader_Text)
                .text()
                .isEqualTo(SubHeader)
                .perform();
    }
}