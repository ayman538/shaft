package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class AnonymousCallSettings {
    private SHAFT.GUI.WebDriver driver;
    public AnonymousCallSettings(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }

    //Locators
    private static final By stepperTitle = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private static final By stepperText1 = By.xpath("//p[@automation-id='incoming_anonymous_description1_tv']");
    private static final By stepperText2 = By.xpath("//p[@automation-id='incoming_anonymous_description2_tv']");
    private static final By stepperText1NonHomeBox = By.xpath("//p[@automation-id='incoming_anonymous_description1_tv']");
    private static final By stepperText2NonHomeBox = By.xpath("//p[@automation-id='incoming_anonymous_description2_tv']");
    private static final By secondLineCard = By.xpath("//div[@class=\"white-box w-60 standard-form w-m-80\"][2]");
    private static final By backBtn = By.xpath("//a[@automation-id='back_Link']");
    private static final By firstLineCard_Title  = By.xpath("//div[@class=\"white-box w-60 standard-form w-m-80\"][1]//h3");
    private static final By firstLineCard_Text = By.xpath("(//div[@class=\"clear\"]//phone-numbers)[1]");
    private static final By secondLineCard_Text = By.xpath("(//div[@class=\"clear\"]//phone-numbers)[2]");
    private static final By secondLineCard_Title  = By.xpath("//div[@class=\"white-box w-60 standard-form w-m-80\"][2]//h3");
    private static final By firstLineCard = By.xpath("//div[@class=\"white-box w-60 standard-form w-m-80\"][1]");
    private static final By firstNumberCard = By.xpath("//div[@class='white-box w-60 standard-form w-m-80'][1]");
    private static final By secondNumberCard = By.xpath("//div[@class=\"white-box w-60 standard-form w-m-80\"][2]");
    private static final By firstNumber = By.xpath("//h3[@automation-id=\"incoming_anonymous_phone_tv\" and contains(text(),'11344860')]");
    private static final By secondNumber = By.xpath("//h3[@automation-id=\"incoming_anonymous_phone_tv\" and contains(text(),'11344861')]");
    private static final By firstNumbertoggleOn = By.xpath("(//span[@class=\"on-text\"])[1]");
    private static final By firstNumbertoggleOff = By.xpath("(//span[@class=\"off-text\"])[1]");
    private static final By secondNumbertoggleOn = By.xpath("(//span[@class=\"on-text\"])[2]");
    private static final By secondNumbertoggleOff = By.xpath("(//span[@class=\"off-text\"])[2]");


    private static final By firstLinetoggleOff = By.xpath("(//span[@class='on-text'])[1]");
    private static final By firstLinetoggleOn = By.xpath("(//span[@class='off-text'])[1]");
    private static final By secondLinetoggleOff = By.xpath("(//span[@class='on-text'])[2]");
    private static final By secondLineToggleOn = By.xpath("(//span[@class='off-text'])[2]");
    private static final By ServiceFailureMsgTitle = By.xpath("//h4[@class=\"flexDiv\"]");
    private static final By confirmationMsg_Text = By.xpath("(//p[@class=\"notification-text mb-10 mt-10\"])");
    private static final By confirmationMsg_Title = By.xpath("(//h4[@class=\"flexDiv\"])");
    private static final By ServiceFailureMsgText = By.xpath("//p[@class=\"notification-text mb-10 mt-10\"]");
    private static final By pageTitle = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private static final By pageSubTitle = By.xpath("//div[@automation-id='pageHeader_tv']/h2");
    private static final By confirmationBtn = By.xpath("//button[@automation-id=\"incoming_anonymous_submit_btn\"]");
    //CLs
    private static String stepperTitle_CL = "Anonyme Anrufe blockieren";
    private static String stepperText2_NonHomeBoxCL = "Die Blockierung gilt pro Leitung, d.h. für alle Rufnummern, die dazu gehören.";
    private static String stepperText1_NonHomeBoxCL = "Ist die Blockierung aktiviert, werden anonyme Anrufe automatisch abgewiesen. Anrufer mit unterdrückter Rufnummer erhalten einen entsprechenden Ansagetext und werden nicht durchgestellt.";
    private static String secondLineCard_Title_CL = "Leitung 2";
    private static String  firstLineCard_Title_CL = "Leitung 1";
    private static String firstLineCard_Text_CL = "Die Leitung 1 ist mit den Rufnummern 030 11344960, 030 11344961, 030 11344962 belegt.";
    private static String secondLineCard_Text_CL = "Die Leitung 2 ist mit der Rufnummer 030 11344963 belegt.";

    private static String stepperText1_CL = "Ist die Blockierung aktiviert, werden anonyme Anrufe automatisch abgewiesen. Anrufer mit unterdrückter Rufnummer erhalten einen entsprechenden Ansagetext und werden nicht durchgestellt.";
    private static String stepperText2_CL = "Die Blockierung gilt pro Rufnummer, d.h. Du musst alle Rufnummern einzeln für die Blockierung einschalten.";
    private static String firstNumber_CL = "030 11344860";
    private static String secondNumber_CL = "030 11344861";
    private static String pageTitle_CL = "Anoyme Anrufer blockieren";
    private static String confirmationMsg_Title_CL = "Geschafft";
    private static String confirmationMsg_Text_CL = "Deine Änderung wurde gespeichert.";
    private static String ServiceFailureMsgTitle_CL = "Das hat leider nicht geklappt";
    private static String ServiceFailureMsgText_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    //Methods
    @Step("validate that user has redirected to the anonymous Call settings page")
    public AnonymousCallSettings validateRedirectionToAnonymousCallSettingPage() {
        driver.verifyThat().element(pageTitle).exists().perform();
        return this;
    }

    @Step("turn first toggle Off")
    public AnonymousCallSettings changeFirstNumberToggleToOFF() {
        driver.element().click(firstNumbertoggleOn);
        return this;
    }

    @Step("turn Second toggle On")
    public AnonymousCallSettings changeSecondNumberToggleToOn() {
        driver.element().click(secondNumbertoggleOff);
        return this;
    }

    @Step("turn first toggle Off")
    public AnonymousCallSettings changeFirstLineToggleToOFF(){
        driver.element().click(firstLinetoggleOff);
        return this;
    }

    @Step("turn Second toggle On")
    public AnonymousCallSettings changeSecondLineToggleToOn() {
        driver.element().click(secondLineToggleOn);
        return this;
    }

    @Step("Click on Confirmation button")
    public AnonymousCallSettings clickOnConfirmationBtn() {
        driver.element().click(confirmationBtn);
        return this;
    }

    @Step("validate Success Confirmation Page in case user has a Home")
    public AnonymousCallSettings validateSuccessConfirmationPageHomeBox(){
        driver.verifyThat().element(confirmationMsg_Text)
                .textTrimmed().isEqualTo(confirmationMsg_Text_CL)
                .withCustomReportMessage("Validate confirmation msg text")
                .perform();
        driver.verifyThat().element(confirmationMsg_Title)
                .textTrimmed().isEqualTo(confirmationMsg_Title_CL)
                .withCustomReportMessage("Validate  confirmation msg title")
                .perform();
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitle_CL)
                .withCustomReportMessage("Validate page title")
                .perform();
        driver.verifyThat().element(stepperTitle)
                .textTrimmed().isEqualTo(stepperTitle_CL)
                .withCustomReportMessage("Validate stepper title")
                .perform();
        driver.verifyThat().element(stepperText1)
                .textTrimmed().contains(stepperText1_CL)
                .withCustomReportMessage("Validate stepper Text Description1")
                .perform();
        driver.verifyThat().element(stepperText2)
                .textTrimmed().contains(stepperText2_CL)
                .withCustomReportMessage("Validate stepper Text Description2")
                .perform();
        driver.verifyThat().element(firstNumbertoggleOff).exists().perform();
        driver.verifyThat().element(secondNumbertoggleOn).exists().perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        return this;
    }

    @Step("validate Success Confirmation Page in case user has a non HomeBox")
    public AnonymousCallSettings validateSuccessConfirmationPageNonHomeBox(){
        driver.verifyThat().element(confirmationMsg_Text)
                .textTrimmed().isEqualTo(confirmationMsg_Text_CL)
                .withCustomReportMessage("Validate confirmation msg text")
                .perform();
        driver.verifyThat().element(confirmationMsg_Title)
                .textTrimmed().isEqualTo(confirmationMsg_Title_CL)
                .withCustomReportMessage("Validate confirmation msg title")
                .perform();
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitle_CL)
                .withCustomReportMessage("Validate page Title")
                .perform();
        driver.verifyThat().element(stepperTitle)
                .textTrimmed().isEqualTo(stepperTitle_CL)
                .withCustomReportMessage("Validate stepper Title")
                .perform();
        driver.verifyThat().element(stepperText1NonHomeBox)
                .textTrimmed().contains(stepperText1_NonHomeBoxCL)
                .withCustomReportMessage("Validate stepper Text Description1")
                .perform();
        driver.verifyThat().element(stepperText2NonHomeBox)
                .textTrimmed().contains(stepperText2_NonHomeBoxCL)
                .withCustomReportMessage("Validate stepper Text Description2")
                .perform();
        driver.verifyThat().element(firstLinetoggleOn).exists().perform();
        driver.verifyThat().element(secondLinetoggleOff).exists().perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        return this;
    }

    @Step("validate service Failure at Confirmation Page in case user has a homebox")
    public AnonymousCallSettings validateFailureOfConfirmationPageHomeBox(){
        driver.verifyThat().element(ServiceFailureMsgTitle)
                .textTrimmed().isEqualTo(ServiceFailureMsgTitle_CL)
                .withCustomReportMessage("Validate service failure title msg Text")
                .perform();
        driver.verifyThat().element(ServiceFailureMsgText)
                .textTrimmed().contains(ServiceFailureMsgText_CL)
                .withCustomReportMessage("Validate service failure text msg")
                .perform();
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitle_CL)
                .withCustomReportMessage("Validate page title")
                .perform();
        driver.verifyThat().element(stepperTitle)
                .textTrimmed().isEqualTo(stepperTitle_CL)
                .withCustomReportMessage("Validate stepper title")
                .perform();
        driver.verifyThat().element(stepperText1)
                .textTrimmed().contains(stepperText1_CL)
                .withCustomReportMessage("Validate stepper Text Description1")
                .perform();
        driver.verifyThat().element(stepperText2)
                .textTrimmed().contains(stepperText2_CL)
                .withCustomReportMessage("Validate stepper Text Description2")
                .perform();
        driver.verifyThat().element(firstNumbertoggleOn).isEnabled().perform();
        driver.verifyThat().element(secondNumbertoggleOff).isEnabled().perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        return this;
    }

    @Step("validate service Failure at Confirmation Page in case user has a non homebox")
    public AnonymousCallSettings validateFailureOfConfirmationPageNonHomeBox(){
        driver.verifyThat().element(ServiceFailureMsgTitle)
                .textTrimmed().isEqualTo(ServiceFailureMsgTitle_CL)
                .withCustomReportMessage("Validate service failure title msg Text ")
                .perform();
        driver.verifyThat().element(ServiceFailureMsgText)
                .textTrimmed().contains(ServiceFailureMsgText_CL)
                .withCustomReportMessage("Validate service failure text msg")
                .perform();
        driver.verifyThat().element(firstLinetoggleOff).isEnabled().perform();
        driver.verifyThat().element(secondLineToggleOn).isEnabled().perform();
        return this;
    }

    @Step("Validate Anonymous Call setting Page in case user has a Home box Router")
    public AnonymousCallSettings  validateAnonymousCallSettingsPageHomebox(){
        driver.verifyThat().element(pageSubTitle).exists().perform();
        driver.verifyThat().element(stepperTitle)
                .textTrimmed().isEqualTo(stepperTitle_CL)
                .withCustomReportMessage("Validate stepper Title")
                .perform();
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitle_CL)
                .withCustomReportMessage("Validate page Title")
                .perform();
        driver.verifyThat().element(stepperText1)
                .textTrimmed().contains(stepperText1_CL)
                .withCustomReportMessage("Validate stepper Text Description1")
                .perform();
        driver.verifyThat().element(stepperText2)
                .textTrimmed().contains(stepperText2_CL)
                .withCustomReportMessage("Validate stepper Text Description2")
                .perform();
        driver.verifyThat().element(firstNumberCard).exists().perform();
        driver.verifyThat().element(secondNumberCard).exists().perform();
        driver.verifyThat().element(firstNumber).textTrimmed().isEqualTo(firstNumber_CL)
                .withCustomReportMessage("Validate first number Text")
                .perform();
        driver.verifyThat().element(secondNumber).textTrimmed().isEqualTo(secondNumber_CL)
                .withCustomReportMessage("Validate second number Text")
                .perform();
        driver.verifyThat().element(firstNumbertoggleOn).exists().perform();
        driver.verifyThat().element(secondNumbertoggleOff).exists().perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        driver.verifyThat().element(backBtn).exists().perform();
        return this;
    }

    @Step("Validate Anonymous Call setting Page in case user has a non home box Router")
    public AnonymousCallSettings  validateAnonymousCallSettingsPageNonHomebox(){
        driver.verifyThat().element(pageSubTitle).exists().perform();
        driver.verifyThat().element(stepperTitle).textTrimmed().isEqualTo(stepperTitle_CL)
                .withCustomReportMessage("Validate stepper Title")
                .perform();
        driver.verifyThat().element(pageTitle).textTrimmed().isEqualTo(pageTitle_CL)
                .withCustomReportMessage("Validate page Title ")
                .perform();
        driver.verifyThat().element(stepperText1NonHomeBox).textTrimmed().contains(stepperText1_NonHomeBoxCL)
                .withCustomReportMessage("Validate stepper Text1")
                .perform();
        driver.verifyThat().element(stepperText2NonHomeBox).textTrimmed().contains(stepperText2_NonHomeBoxCL).perform();
        driver.verifyThat().element(firstLineCard).exists().perform();
        driver.verifyThat().element(firstLineCard_Title).textTrimmed().isEqualTo(firstLineCard_Title_CL)
                .withCustomReportMessage("Validate title of first line card")
                .perform();
        driver.verifyThat().element(firstLineCard_Text).textTrimmed().isEqualTo(firstLineCard_Text_CL)
                .withCustomReportMessage("Validate text of first line card")
                .perform();
        driver.verifyThat().element(secondLineCard).exists().perform();
        driver.verifyThat().element(secondLineCard_Title).textTrimmed().isEqualTo(secondLineCard_Title_CL)
                .withCustomReportMessage("Validate title of second line card")
                .perform();
        driver.verifyThat().element(secondLineCard_Text).textTrimmed().isEqualTo(secondLineCard_Text_CL)
                .withCustomReportMessage("Validate text of second line card")
                .perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        driver.verifyThat().element(backBtn).exists().perform();
        return this;
    }

}