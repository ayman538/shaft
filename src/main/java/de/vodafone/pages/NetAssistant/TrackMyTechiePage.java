package de.vodafone.pages.NetAssistant;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TrackMyTechiePage {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    //Locators
    private static By acceptCookiesButton=By.xpath("//button//span[contains(text(),' ablehnen')]");
    public static By tobiIcon =By.xpath("//*[name()='svg' and @class='ws10-info-overlay__container--icon']");
    public static By trackTechnicianTitle=By.xpath("//div[@class='ws10-info-overlay__container--title']");
    public static By trackTechnicianSubTitleTicketNumber=By.xpath("//div[@class='ws10-info-overlay__container--subTitle']");
    public static By trackTechnicianTimeAwayText=By.xpath("(//div[@class='ws10-info-overlay__subContainer-text' and contains(.,' entfernt')])[1]");
    public static By trackTechnicianClockArrivalTimeText=By.xpath("//div[@class='ws10-info-overlay__subContainer-text' and contains(.,'Uhr Ankunftszeit')]");
    public static By trackTechnicianDistanceAwayText=By.xpath("(//div[@class='ws10-info-overlay__subContainer-text' and contains(.,' entfernt')])[2]");
    public static By trackTechnicianTechArrivedTextMessage=By.xpath("//div[@class='ws10-info-overlay__container--subTitle ws10-info-overlay__infoText']");
    public static By trackTechnicianTechArrivedRightMarkIcon=By.xpath("//*[name()='svg' and @class='notification-tick']");
    public static By trackTechnicianHiddenChatBotTabHeader=By.xpath("//a[@id='chatbotBtn' and @class='hidden-tab']");
    public static By trackTechnicianHiddenTicketsTabHeader=By.xpath("//a[@id='tickets' and @class='hidden-tab']");

    public static By trackMyTechieHomeIcon = By.xpath("//app-track-techie-map/app-google-map//div[2]/div/div[3]/div[1]");
    public static By trackMyTechieTechnicianIcon = By.xpath("//*[@automation-id='infoOverlay_svg']");
    public static By trackMyTechieOverlay = By.xpath("//app-track-techie-map//ws10-info-overlay");
    public static By trackMyTechieMap = By.xpath("//app-track-techie-map/app-google-map");
    private static By technicianPhoneNumber = By.xpath("//*[@automation-id='infoOverlay_phoneNumber_lrg_tv']");
    private static By technicianPhoneIcon = By.xpath("//*[@automation-id='infoOverlay_phoneText_svg']");
    private static By technicianPhoneDetails = By.xpath("//*[@automation-id='infoOverlay_phoneText_tv']");

    //CLs
    private static String trackMyTechieTitleCL1 ="ist unterwegs zu Dir";
    public static String trackTechnicianSubTitleTicketNumberCL = "Ticket-Nummer:";
    public static String trackTechnicianTimeAwayCL = "entfernt";
    public static String trackTechnicianClockArrivalTimeAwayCL = "Uhr Ankunftszeit";
    private static String trackMyTechieTitleCL2 ="Los geht’s!";
    private static String trackMyTechieTitleCL3 ="ist in wenigen Minuten bei Dir";
    public static String trackTechnicianArrivalTextCL = "Der:die Techniker:in schaut sich jetzt vor Ort Dein Problem an.";
    private static String technicianPhoneDetailsCL = "Du hast noch Fragen? Ruf uns einfach an";


    //Constructor
    public TrackMyTechiePage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }

    //Getters
    public static By getTrackMyTechieHomeIcon() {
        return trackMyTechieHomeIcon;
    }

    public static By getTrackMyTechieTechnicianIcon() {
        return trackMyTechieTechnicianIcon;
    }

    public static By getTobiIcon() {
        return tobiIcon;
    }
    public static By getTrackTechnicianTitle() {
        return trackTechnicianTitle;
    }
    public static By getTrackTechnicianSubTitleTicketNumber() {
        return trackTechnicianSubTitleTicketNumber;
    }
    public static By getTrackTechnicianTimeAwayText() {
        return trackTechnicianTimeAwayText;
    }
    public static By getTrackTechnicianClockArrivalTimeText() {
        return trackTechnicianClockArrivalTimeText;
    }
    public static By getTrackTechnicianDistanceAwayText() {
        return trackTechnicianDistanceAwayText;
    }
    public static By getTrackTechnicianArrivalMessage(){return trackTechnicianTechArrivedTextMessage;}
    public static By getTrackTechnicianArrivedRightMarkIcon(){return trackTechnicianTechArrivedRightMarkIcon;}
    public static By getTrackTechnicianHiddenChatBotTabHeader(){return trackTechnicianHiddenChatBotTabHeader;}
    public static By getTrackTechnicianHiddenTicketTabHeader(){return trackTechnicianHiddenTicketsTabHeader;}

    public static By getTrackMyTechieOverlay() {
        return trackMyTechieOverlay;
    }

    public static By getTrackMyTechieMap() {
        return trackMyTechieMap;
    }

    //Methods
    @Step("Navigate Method with deeplink")
    public TrackMyTechiePage navigate(String deepLink){

        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + deepLink);
        return this;
    }
    @Step("Navigate Method without deeplink")
    public TrackMyTechiePage navigate()
    {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st"));
        return this;
    }
    @Step("Accept Cookies")
    public TrackMyTechiePage acceptCookies(){
        driver.element().waitToBeReady(acceptCookiesButton);
        driver.element().click(acceptCookiesButton);
        return this;
    }
    @Step("Validate Tobi icon is displayed")
    public TrackMyTechiePage validateTobiIconExists()
    {
        driver.assertThat()
                .element(getTobiIcon())
                .exists()
                .withCustomReportMessage("Tobi Icon exists")
                .perform();
        return this;
    }
    @Step("Validate track technician title CL")
    public TrackMyTechiePage validateTrackTechnicianTitleText1()
    {
        driver.assertThat()
                .element(getTrackTechnicianTitle())
                .text()
                .contains(trackMyTechieTitleCL1)
                .withCustomReportMessage("Track my techie Title 'ist unterwegs zu Dir' exists")
                .perform();
        return this;
    }
    @Step("Validate track technician Sub-title CL")
    public TrackMyTechiePage validateTrackTechnicianSubTitleTicketNumberText()
    {
        driver.assertThat()
                .element(getTrackTechnicianSubTitleTicketNumber())
                .text()
                .contains(trackTechnicianSubTitleTicketNumberCL)
                .withCustomReportMessage("Track my techie SubTitle 'Ticket-Nummer:' exists")
                .perform();
        return this;
    }
    @Step("Validate track technician title CL")
    public TrackMyTechiePage validateTrackTechnicianTitleText2()
    {
        driver.assertThat()
                .element(getTrackTechnicianTitle())
                .text()
                .contains(trackMyTechieTitleCL2)
                .withCustomReportMessage("Track my techie Title 'Los geht’s! exists")
                .perform();

        driver.assertThat()
                .element(getTrackTechnicianTitle())
                .text()
                .contains(trackMyTechieTitleCL3)
                .withCustomReportMessage("ist in wenigen Minuten bei Dir' exists")
                .perform();
        return this;
    }
    @Step("Validate Right mark is displayed when techniacian has arrived")
    public TrackMyTechiePage validateTrackTechnicianArrivedRightMarkIconDisplayed()
    {
        driver.assertThat()
                .element(getTrackTechnicianArrivedRightMarkIcon())
                .exists()
                .withCustomReportMessage("Technician arrived Right Mark Icon exists")
                .perform();
        return this;
    }
    @Step("Validate technician arrival CL")
    public TrackMyTechiePage validateTrackTechnicianArrivalText()
    {
        driver.assertThat()
                .element(getTrackTechnicianArrivalMessage())
                .text()
                .contains(trackTechnicianArrivalTextCL )
                .withCustomReportMessage("Technician arrived Text message exists")
                .perform();
        return this;
    }
    @Step("Validate home icon is displayed")
    public TrackMyTechiePage validateTrackMyTechieHomeIconDisplayed()
    {
        driver.assertThat()
                .element(getTrackMyTechieHomeIcon())
                .isVisible()
                .withCustomReportMessage("Track My Techie Home Icon is displayed Succesfully")
                .perform();
        return this;
    }
    @Step("Validate technician icon is displayed")
    public TrackMyTechiePage validateTrackMyTechieTechnicianIconDisplayed()
    {
        driver.assertThat()
                .element(getTrackMyTechieTechnicianIcon())
                .isVisible()
                .withCustomReportMessage("Track My Techie Technician Icon is displayed Succesfully")
                .perform();
        return this;
    }
    @Step("Validate chatbot header is hidden")
    public TrackMyTechiePage validateTrackMyTechieHiddenChatbotTabHeader()
    {
        driver.verifyThat()
                .element(getTrackTechnicianHiddenChatBotTabHeader())
                .doesNotExist()
                .withCustomReportMessage("chatbot tab successfully hidden ")
                .perform();
        return this;
    }
    @Step("Validate tickets header is hidden")
    public TrackMyTechiePage validateTrackMyTechieHiddenTicketsTabHeader()
    {
        driver.verifyThat()
                .element(getTrackTechnicianHiddenTicketTabHeader())
                .doesNotExist()
                .withCustomReportMessage("tickets tab successfully hidden ")
                .perform();
        return this;
    }
    @Step("Validate technician time away CL")
    public TrackMyTechiePage validateTrackTechnicianTimeAwayText()
    {
        driver.assertThat()
                .element(getTrackTechnicianTimeAwayText())
                .text()
                .contains(trackTechnicianTimeAwayCL)
                .withCustomReportMessage("Track my techie Time Away Text 'entfernt' exists")
                .perform();
        return this;
    }
    @Step("Validate technician clock arrival time CL")
    public TrackMyTechiePage validateTrackTechnicianClockArrivalTimeAwayText()
    {
        driver.assertThat()
                .element(getTrackTechnicianClockArrivalTimeText())
                .text()
                .contains(trackTechnicianClockArrivalTimeAwayCL)
                .withCustomReportMessage("Track my techie clock Arrival Time 'Uhr Ankunfts-zeit'  exists")
                .perform();
        return this;
    }
    @Step("Validate technician distance away CL")
    public TrackMyTechiePage validateTrackTechnicianDistanceAwayText()
    {
        driver.assertThat()
                .element(getTrackTechnicianDistanceAwayText())
                .text()
                .contains(TrackMyTechiePage.trackTechnicianTimeAwayCL)
                .withCustomReportMessage("Track my techie distance Away Text 'entfernt' exists")
                .perform();
        return this;
    }
    @Step("Validate track my techie overlay is displayed")
    public TrackMyTechiePage validateTrackMyTechieOverlayDisplayed()
    {
        driver.assertThat()
                .element(getTrackMyTechieOverlay())
                .isVisible()
                .withCustomReportMessage("Track My Techie Overlay is displayed Succesfully")
                .perform();
        return this;
    }
    @Step("Validate track my techie map is displayed")
    public TrackMyTechiePage validateTrackMyTechieMapDisplayed()
    {
        driver.assertThat()
                .element(getTrackMyTechieMap())
                .isVisible()
                .withCustomReportMessage("Track My Techie Map is displayed Succesfully")
                .perform();
        return this;
    }

    @Step("Validate Technician phone details CL is correctly displayed")
    public TrackMyTechiePage validatePhoneDetailsCL()
    {
        driver
                .assertThat()
                .element(technicianPhoneDetails )
                .text()
                .contains(technicianPhoneDetailsCL)
                .perform();
        return this;
    }

    @Step("Validate phone icon is diplayed in technician details")
    public TrackMyTechiePage validatePhoneIconExists()
    {
        driver
                .assertThat()
                .element(technicianPhoneIcon )
                .exists()
                .perform();
        return this;
    }

    @Step("Validate phone number is diplayed in technician details")
    public TrackMyTechiePage validatePhoneNumberExists(String phoneNumber)
    {
        driver
                .assertThat()
                .element(technicianPhoneNumber )
                .exists()
                .perform();

        driver
                .assertThat()
                .element(technicianPhoneNumber)
                .text()
                .contains(phoneNumber)
                .perform();

        return this;
    }
}
