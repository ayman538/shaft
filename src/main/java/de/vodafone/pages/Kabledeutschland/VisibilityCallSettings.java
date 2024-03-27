package de.vodafone.pages.Kabledeutschland;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class VisibilityCallSettings {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private static final By stepperTitle = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']/strong");
    private static final By stepperText = By.xpath("//div[@id='outgoingCallsSettings']/p");
    private static final By secondLineCard = By.xpath("(//div[@automation-id='outgoing_calls_settings_lv'])[2]");
    private static final By firstLineCard_Title  = By.xpath("(//h3[@automation-id='line_number_lv'])[1]");
    private static final By firstLineCard_Numbers  = By.xpath("(//div[@class='mt-20'])[1]");
    private static final By secondLineCard_Numbers  = By.xpath("(//div[@class='mt-20'])[2]");
    private static final By secondLineCard_Title  = By.xpath("(//h3[@automation-id='line_number_lv'])[2]");

    private static final By firstLineCard = By.xpath("(//div[@automation-id='outgoing_calls_settings_lv'])[1]");
    private static final By firstNumberCard = By.xpath("(//div[@automation-id='outgoing_calls_settings_lv'])[1]");
    private static final By secondNumberCard = By.xpath("(//div[@automation-id='outgoing_calls_settings_lv'])[2]");
    private static final By firstNumber = By.xpath("(//h3[@automation-id='phone_number_lv'])[1]");
    private static final By secondNumber = By.xpath("(//h3[@automation-id='phone_number_lv'])[2]");
    private static final By secondNumbertoggleOn = By.xpath("(//span[@class='off-text'])[2]");
    private static final By firstNumbertoggleOff = By.xpath("(//span[@class='on-text'])[1]");
    private static final By firstNumbertoggleOn = By.xpath("(//span[@class='off-text'])[1]");
    private static final By secondNumbertoggleOff = By.xpath("(//span[@class='on-text'])[2]");
    private static final By firstLinetoggleOff = By.xpath("(//span[@class='on-text'])[1]");
    private static final By firstLinetoggleOn = By.xpath("(//span[@class='on-text'])[1]");
    private static final By secondLinetoggleOff = By.xpath("(//span[@class='on-text'])[2]");
    private static final By secondLineToggleOn = By.xpath("(//span[@class='off-text'])[2]");
    private static final By confirmationBtn = By.xpath("//button[@automation-id='submit_btn']");
    private static final By backBtn = By.xpath("//a[@automation-id='back_Link']");
    private static final By ServiceFailureMsgTitle = By.xpath("//div[@id='outgoingCallsSettings']//h4");
    private static final By ServiceFailureMsgText = By.xpath("(//div[@id='outgoingCallsSettings']//p)[1]");
    private static final By confirmationMsg_Text = By.xpath("//div[@automation-id='success_nt']//p");
    private static final By confirmationMsg_Title = By.xpath("//div[@automation-id='success_nt']//h4");
    private static final By pageTitle = By.xpath("(//div[@automation-id='pageHeader_tv'])/h1");
    private static final By pageSubTitle = By.xpath("//h2[@class='sub-title']");
  //Cls
    private static String stepperTitle_CL = "Rufnummerunterdrückung";
    private static String stepperText_CL = "Du kannst festlegen, ob Deine Rufnummer bei einem Anruf unterdrückt oder übermittelt wird. Schalte dazu die Rufnummerunterdrückung ein oder aus.";
    private static String pageTitle_CL = "Rufnummerunterdrückung einrichten";
    private static String secondNumber_CL="030 11344861";
    private static String firstNumber_CL="030 11344860";
    private static String pageSubTitle_CL = "KD (Kundennummer: 219188999)";
    private static String secondLineCard_Title_CL = "Leitung 2";
    private static String  firstLineCard_Title_CL = "Leitung 1";
    private static String generalErrorMsg_Title_CL = "Das geht leider nicht";
    private static String confirmationMsg_Title_CL = "Geschafft";
    private static String confirmationMsg_Text_CL = "Deine Änderung wurde gespeichert.";
    private static String ServiceFailureMsgTitle_CL = "Das hat leider nicht geklappt";
    private static String ServiceFailureMsgText_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    // constructor
    public VisibilityCallSettings(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    @Step("turn first number's toggle On")
    public VisibilityCallSettings changeFirstNumberToggleToOn() {
        driver.element().click(firstNumbertoggleOn);
        return this;
    }

    @Step("turn Second number's toggle On")
    public VisibilityCallSettings changeSecondNumberToggleToOn(){
        driver.element().click(secondNumbertoggleOn);
        return this;
    }

    @Step("turn first Line's toggle Off")
    public VisibilityCallSettings changeFirstLineToggleToOFF(){
        driver.element().click(firstLinetoggleOff);
        return this;
    }

    @Step("turn Second Line's toggle On")
    public VisibilityCallSettings changeSecondLineToggleToOn(){
        driver.element().click(secondLineToggleOn);
        return this;
    }

    @Step("Click on Confirmation button")
    public VisibilityCallSettings clickOnConfirmationBtn() {
        driver.element().click(confirmationBtn);
        return this;
    }

    @Step("validate Success Confirmation Page in case user has a Home")
    public VisibilityCallSettings validateSuccessOfConfirmationPageHomeBox(){
        driver.verifyThat().element(confirmationMsg_Title)
                .textTrimmed().isEqualTo(confirmationMsg_Title_CL)
                .withCustomReportMessage("Validate confirmation msg's title")
                .perform();
        driver.verifyThat().element(confirmationMsg_Text)
                .textTrimmed().isEqualTo(confirmationMsg_Text_CL)
                .withCustomReportMessage("Validate  confirmation msg's text")
                .perform();
        driver.verifyThat().element(firstNumbertoggleOff).isEnabled().perform();
        driver.verifyThat().element(secondNumbertoggleOff).isEnabled().perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        return this;
    }

    @Step("validate that user redirected to visibility call settings page")
    public VisibilityCallSettings validateRedirectionToVisibilityCallSettingPage()
    {
          driver.verifyThat().element(stepperTitle).textTrimmed().isEqualTo(stepperTitle_CL).perform();
        return this;
    }

    @Step("validate service Failure at Confirmation Page in case user has a homebox")
    public VisibilityCallSettings validateFailureOfConfirmationPageHomeBox(){
        driver.verifyThat().element(ServiceFailureMsgTitle)
                .textTrimmed().isEqualTo(ServiceFailureMsgTitle_CL)
                .withCustomReportMessage("Validate service failure title msg's title")
                .perform();
        driver.verifyThat().element(ServiceFailureMsgText)
                .textTrimmed().isEqualTo(ServiceFailureMsgText_CL)
                .withCustomReportMessage("Validate the service failure msg's text")
                .perform();
        driver.verifyThat().element(firstNumbertoggleOn).exists().perform();
        driver.verifyThat().element(secondNumbertoggleOn).exists().perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        return this;
    }

    @Step("validate service Failure at Confirmation Page in case user has a non homebox")
    public VisibilityCallSettings validateFailureOfConfirmationPageNonHomeBox(){
        driver.verifyThat().element(ServiceFailureMsgTitle)
                .textTrimmed().isEqualTo(ServiceFailureMsgTitle_CL)
                .withCustomReportMessage("Validate service failure title msg")
                .perform();
        driver.verifyThat().element(ServiceFailureMsgText)
                .textTrimmed().isEqualTo(ServiceFailureMsgText_CL)
                .withCustomReportMessage("Validate service failure text msg")
                .perform();
        driver.verifyThat().element(firstLinetoggleOn).isEnabled().perform();
        driver.verifyThat().element(secondLinetoggleOff).isEnabled().perform();
        return this;
    }

    @Step("validate Success Confirmation Page in case user has a non HomeBox")
    public VisibilityCallSettings validateSuccessConfirmationPageNonHomeBox(){
        driver.verifyThat().element(confirmationMsg_Title)
                .textTrimmed().isEqualTo(confirmationMsg_Title_CL)
                .withCustomReportMessage("Validate confirmation msg title")
                .perform();
        driver.verifyThat().element(confirmationMsg_Text)
                .textTrimmed().isEqualTo(confirmationMsg_Text_CL)
                .withCustomReportMessage("Validate confirmation msg text")
                .perform();
        driver.verifyThat().element(firstLinetoggleOff).isEnabled().perform();
        driver.verifyThat().element(secondLineToggleOn).isEnabled().perform();
        return this;
    }

    @Step("Validate visibility Call setting Page in case user has a non home box Router")
    public VisibilityCallSettings  validateVisibilityCallSettingsPageNonHomebox(){
        driver.verifyThat().element(pageSubTitle).exists().perform();
        driver.verifyThat().element(stepperTitle)
                .textTrimmed().isEqualTo(stepperTitle_CL)
                .withCustomReportMessage("Validate stepper Title")
                .perform();
        driver.verifyThat().element(pageTitle)
                .textTrimmed().isEqualTo(pageTitle_CL)
                .withCustomReportMessage("Validate page Title")
                .perform();
        driver.verifyThat().element(stepperText)
                .textTrimmed().isEqualTo(stepperText_CL)
                .withCustomReportMessage("Validate stepper Text")
                .perform();
        driver.verifyThat().element(firstLineCard).exists().perform();
        driver.verifyThat().element(firstLineCard_Title)
                .textTrimmed().isEqualTo(firstLineCard_Title_CL)
                .withCustomReportMessage("Validate title of first line card")
                .perform();
        driver.verifyThat().element(secondLineCard).exists().perform();
        driver.verifyThat().element(secondLineCard_Title)
                .textTrimmed().isEqualTo(secondLineCard_Title_CL)
                .withCustomReportMessage("Validate title of second line card")
                .perform();
        driver.verifyThat().element(secondLineCard_Numbers).doesNotExist();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        driver.verifyThat().element(backBtn).exists().perform();
        return this;
    }

    @Step("Validate Visibility Call setting Page in case user has a Home box Router")
    public VisibilityCallSettings validateVisibilityCallSettingsPageHomebox() {
        driver.verifyThat().element(pageSubTitle).exists().perform();
        driver.verifyThat().element(stepperTitle).textTrimmed().isEqualTo(stepperTitle_CL)
                .withCustomReportMessage("Validate stepper Title")
                .perform();
        driver.verifyThat().element(pageTitle).textTrimmed().isEqualTo(pageTitle_CL)
                .withCustomReportMessage("Validate page Title")
                .perform();
        driver.verifyThat().element(stepperText).textTrimmed().isEqualTo(stepperText_CL)
                .withCustomReportMessage("Validate stepper Text")
                .perform();
        driver.verifyThat().element(firstNumberCard).exists().perform();
        driver.verifyThat().element(secondNumberCard).exists().perform();
        driver.verifyThat().element(pageSubTitle).exists().perform();
        driver.verifyThat().element(firstNumber).textTrimmed().isEqualTo(firstNumber_CL)
                .withCustomReportMessage("Validate first number Text")
                .perform();
        driver.verifyThat().element(secondNumber).textTrimmed().isEqualTo(secondNumber_CL)
                .withCustomReportMessage("Validate second number Text")
                .perform();
        driver.verifyThat().element(firstNumbertoggleOn).exists().perform();
        driver.verifyThat().element(secondNumbertoggleOn).exists().perform();
        driver.verifyThat().element(confirmationBtn).isDisabled().perform();
        driver.verifyThat().element(backBtn).exists().perform();
        return this;
    }

}