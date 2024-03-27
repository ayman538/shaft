package de.vodafone.pages.NetAssistant;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RateTechnicianPage {
    //Variables


    private SHAFT.GUI.WebDriver driver;
    //Locators
    private static By acceptCookiesButton = By.xpath("//button//span[contains(text(),' ablehnen')]");
    private static By technicianImage = By.xpath("//*[@automation-id='rateTechnicianOverlayInfo_img']");
    private static By technicianName = By.xpath("//*[@automation-id='rateTechnicianOverlayInfoTitle_tv']");
    private static By technicianTicketNo = By.xpath("//*[@automation-id='rateTechnicianOverlayInfoSubTitle_tv']");
    private static By headerQuestion = By.xpath("//*[@automation-id='rateTechnicianHeader_tv']");
    private static By ratePageText = By.xpath("//*[@automation-id='rateTechnicianSubheader_tv']");
    private static By rateBox1 = By.xpath("//*[@id='option-picker 0']");
    private static By rateBox2 = By.xpath("//*[@id='option-picker 1']");
    private static By rateBox3 = By.xpath("//*[@id='option-picker 2']");
    private static By rateBox4 = By.xpath("//*[@id='option-picker 3']");
    private static By rateBox5 = By.xpath("//*[@id='option-picker 4']");
    private static By feedbackBox = By.xpath("//*[@automation-id='commentTextArea_tv_et']");
    private static By submitRateBtn = By.xpath("//*[@automation-id='rateTechnicianBtnSubmit_Link']");
    private static By doneRateHeader = By.xpath("//*[@automation-id='rateTechnicianCreatedAt_tv']");
    private static By ticketDetialsBtn = By.xpath("//*[@automation-id='rateTechnicianBtnTicketDetails_Link']");
    private static By alreadyRatedBeforeHeader = By.xpath("//*[@automation-id='commentTextArea_tv_et']");
    private static By tobiImage = By.xpath("//*[@automation-id='rateTechnicianOverlayInfo_svg']");
    private static By invalidtokenheaderpage = By.xpath("//*[@automation-id='errorHeadline_tv']");
    private static By invalidtokentextpage = By.xpath("//*[@automation-id='errorText_tv']");
    private static By invalidtokenbutton = By.xpath("//*[@automation-id='errorButton_btn']");
    private static By servicedownheaderpage = By.xpath("//*[@automation-id='errorHeadline_tv']");
    private static By servicedowntextpage = By.xpath("//*[@automation-id='errorText_tv']");
    private static By servicedownbutton = By.xpath("//*[@automation-id='errorButton_btn']");
    //CLs
    private static String RateMyTechieHeaderCL = "Hat alles gut geklappt?";
    public static String RateMyTechieTextCL = "Bewerte bitte Deine Erfahrung mit dem Technik-Service. Durch Dein Feedback können wir unseren Service weiter verbessern. Vielen Dank!";
    public static String FeedbackBoxCL = "Du möchtest uns noch etwas sagen? Dann schreib uns das hier.";
    public static String DoneRateHeaderCL = "Vielen Dank für Deine Bewertung!";
    public static String InvalidTokenHeaderCL = "Das geht leider nicht";
    public static String InvalidTokenTextCL = "Der Link ist nicht mehr gültig.";
    public static String ServiceDownHeaderCL = "Das hat leider nicht geklappt";
    public static String ServiceDownTextCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";



    //Constructor
    public RateTechnicianPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }


    //Getters
    public static By getRateBoxThree() {
        return rateBox3;
    }

    public static By getSubmitRateBtn() {
        return submitRateBtn;
    }

    public static By getTicketDetialsBtn() {
        return ticketDetialsBtn;
    }


    //Methods
    @Step("Navigate Method with deeplink")
    public RateTechnicianPage navigate(String deepLink) {
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + deepLink);

        return this;
    }

    @Step("Navigate Method with out deeplink")
    public RateTechnicianPage navigate() {
        driver.browser().navigateToURL( System.getProperty("de.vodafone.baseUrl.st"));
        return this;
    }

    @Step("Accept Cookies")
    public RateTechnicianPage acceptCookies() {
        driver.element().click(acceptCookiesButton);
        return this;
    }

    @Step("click on element")
    public RateTechnicianPage clickOn(By Element) {

        driver.element().click( Element);
        return this;
    }

    @Step("assert that Header Question is Visible")
    public RateTechnicianPage verifyRatePageDisplayed() {
        driver.assertThat().element(headerQuestion).isVisible().perform();
        return this;
    }

    @Step("assert that Technician Image is Visible")
    public RateTechnicianPage verifyImageofRatePage() {
        driver.verifyThat()
                .element(technicianImage)
                .isVisible()
                .perform();
        return this;
    }

    @Step("assert that Technician Name is Visible")
    public RateTechnicianPage verifyNameofTechnician() {
        driver.assertThat().element(technicianName).isVisible().perform();
        return this;
    }

    @Step("assert that Technician Ticket Number is Visible")
    public RateTechnicianPage verifyTicketNoOfTechnician() {
        driver.assertThat().element(technicianTicketNo).isVisible().perform();
        return this;
    }

    @Step("assert that Technician Rate Page Header CL is correct")
    public RateTechnicianPage validateTheHeaderOfRatePage() {
        driver.assertThat().element(headerQuestion).text().isEqualTo(RateMyTechieHeaderCL).perform();
        return this;
    }

    @Step("assert that Technician Rate Page Text CL is correct")
    public RateTechnicianPage validateTheTextOfRatePage() {
        driver.assertThat().element(ratePageText).text().isEqualTo(RateMyTechieTextCL).perform();
        return this;
    }

    @Step("assert that Technician Feedback Box exists")
    public RateTechnicianPage validateTheFeedbackBox() {
        driver.assertThat().element(feedbackBox).exists().perform();
        return this;
    }

    @Step("assert that Five Rate Boxes exists")
    public RateTechnicianPage verifyTheFiveRateBox() {
        driver.assertThat().element(rateBox1).isVisible().perform();
        driver.assertThat().element(rateBox2).isVisible().perform();
        driver.assertThat().element(rateBox3).isVisible().perform();
        driver.assertThat().element(rateBox4).isVisible().perform();
        driver.assertThat().element(rateBox5).isVisible().perform();
        return this;

    }

    @Step("Click on Ratebox")
    public RateTechnicianPage verifyRateBoxOneClickable() {
        driver.element().click(rateBox1);
        return this;
    }

    @Step("Type Text in feedbackbox")
    public RateTechnicianPage EnterDataAtFeedbackBox(String text) {
        driver.element().type(feedbackBox, text);
        return this;
    }

    @Step("assert that Done Rate Header exists")
    public RateTechnicianPage verifyRateIsDonePage() {
        driver.assertThat().element(doneRateHeader).exists().perform();
        return this;
    }

    @Step("assert that Already Rated Before Header exists")
    public RateTechnicianPage verifyAlreadyRatedBeforePage() {
        driver.assertThat().element(alreadyRatedBeforeHeader).exists().perform();
        return this;
    }

    @Step("assert that Ticket Details Button exists")
    public RateTechnicianPage verifyTicketDetailsBtn() {
        driver.assertThat().element(ticketDetialsBtn).exists().perform();
        return this;
    }

    @Step("assert that Tobi Image exists")
    public RateTechnicianPage verifyTobiImageDisplayed() {
        driver.assertThat().element(tobiImage).exists().perform();
        return this;
    }

    @Step("assert that Invalid Token Header Page exists")
    public RateTechnicianPage verifyInvalidTokenErrorPageDisplayed() {
        driver.assertThat().element(invalidtokenheaderpage).exists().perform();
        return this;
    }

    @Step("assert that Invalid Token Header Page text is correct")
    public RateTechnicianPage validateInvalidTokenPageHeader() {
        driver.assertThat().element( invalidtokenheaderpage).text().isEqualTo(InvalidTokenHeaderCL).perform();
        return this;
    }

    @Step("assert that Invalid Token Page text is correct")
    public RateTechnicianPage validateInvalidTokenPageText() {
        driver.assertThat().element( invalidtokentextpage).text().isEqualTo(InvalidTokenTextCL).perform();
        return this;
    }

    @Step("assert that Invalid Token Button exists")
    public RateTechnicianPage verifyErrorButtonDisplayed() {
        driver.assertThat().element(invalidtokenbutton).exists().perform();
        return this;

    }

    @Step("assert that Service down header page exists")
    public RateTechnicianPage verifyServiceDownPageDisplayed() {
        driver.assertThat().element(servicedownheaderpage).exists().perform();
        return this;
    }

    @Step("assert that Service down header page CL is correct")
    public RateTechnicianPage validateServiceDownPageHeader() {
        driver.assertThat().element( servicedownheaderpage).text().isEqualTo(ServiceDownHeaderCL).perform();
        return this;
    }

    @Step("assert that Service down text page CL is correct")
    public RateTechnicianPage validaServiceDownPageText() {
        driver.assertThat().element( servicedowntextpage).text().isEqualTo(ServiceDownTextCL).perform();
        return this;
    }



}



