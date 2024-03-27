package de.vodafone.pages.Kabledeutschland;
import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CallBlockingSettings {
    private SHAFT.GUI.WebDriver driver;

    public CallBlockingSettings(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private static final By PageTitle = By.xpath("//*[@automation-id=\"pageHeader_tv\"]//h1");
    private static final By StepperTitle = By.xpath("//*[@automation-id=\"oneStepStepperHeader_tv\"]");
    private static final By StepperHeader = By.xpath("//*[@automation-id=\"description_tv\"]");
    private static final By OneNumberTile = By.xpath("//*[@automation-id=\"one_number_tv\"]");
    private static final By MultiNumbersDDL = By.xpath("//*[@automation-id=\"PHONE_number-chooser_btn\"]");
    private static final By SecondPhoneNumberInDDL = By.xpath("(//*[@id=\"option_child\"])[2]");
    private static final By InlineMessageForLandLineTile = By.xpath("//*[@id=\"outgoingCallBlocking\"]//phone-numbers/div");
    private static final By FirstSwitcherTitle = By.xpath("(//*[@automation-id=\"switcher_header_tv\"])[1]");
    private static final By FirstSwitcherDesc = By.xpath("(//*[@automation-id=\"switcher_description_tv\"])[1]");
    private static final By FirstSwitcherToggle = By.xpath("(//*[@class=\"switch fm-flip-switch\"]/label)[1]");
    private static final By SecondSwitcherTitle = By.xpath("(//*[@automation-id=\"switcher_header_tv\"])[2]");
    private static final By SecondSwitcherDesc = By.xpath("(//*[@automation-id=\"switcher_description_tv\"])[2]");
    private static final By SecondSwitcherToggle = By.xpath("(//*[@class=\"switch fm-flip-switch\"]/label)[2]");
    private static final By ThirdSwitcherTitle = By.xpath("(//*[@automation-id=\"switcher_header_tv\"])[3]");
    private static final By ThirdSwitcherDesc = By.xpath("(//*[@automation-id=\"switcher_description_tv\"])[3]");
    private static final By ThirdSwitcherToggle = By.xpath("(//*[@class=\"switch fm-flip-switch\"]/label)[3]");
    private static final By ConfirmationBtn = By.xpath("//*[@automation-id=\"confirm_blocking_btn\"]");
    private static final By SuccessMessageTitle = By.xpath("//*[@automation-id=\"call_blocking_success_nt\"]//h4");
    private static final By SuccessMessageBody = By.xpath("//*[@automation-id=\"call_blocking_success_nt\"]//p");
    private static final By SuccessMessageIcon = By.xpath("//*[@class=\"i-sml i-green\"]");
    private static final By FailedMessageTitle = By.xpath("//*[@automation-id=\"undefined_nt\"]//h4");
    private static final By FailedMessageBody = By.xpath("//*[@automation-id=\"undefined_nt\"]//p");
    private static final By FailedMessageIcon = By.xpath("(//*[@class=\"i-sml i-red\"])[1]");
    private static final By HuawiSubHeader = By.xpath("//*[@automation-id=\"description_tv\"]");

    //CLs
    private static String PageTitle_CL = "Anrufsperre einrichten";
    private static String StepperTitle_CL = "Anrufsperre einrichten";
    private static String SingleNum_StepperHeader_CL = "Deine Rufnummer:";
    private static String SingleLand_StepperHeader_CL = "Deine Leitung:";
    private static String MultiNum_StepperHeader_CL = "Wähl bitte die Rufnummer für die Anrufsperre aus:";
    private static String MultiLand_StepperHeader_CL = "Wähl bitte die Leitung für die Anrufsperre aus:";
    private static String FirstSwitcherTitle_CL = "Sperre International";
    private static String FirstSwitcherDesc_CL = "Internationale Telefonvorwahl, z.B. 0049 für Deutschland aus dem Ausland.";
    private static String SecondSwitcherTitle_CL = "Sperre Mobilfunk";
    private static String SecondSwitcherDesc_CL = "Vorwahlen für Mobilfunknetze, die für Alarmierungs- oder Benachrichtigungsdienste genutzt werden können.";
    private static String ThirdSwitcherTitle_CL = "Sperre Premium";
    private static String ThirdSwitcherDesc_CL = "Kostenpflichtige Vorwahl, über die bestimmte Dienste abgerufen werden können, z.B. Service-Hotlines oder Gewinnspiel-Hotlines.";
    private static String ConfirmationBtn_CL = "Bestätigen";
    private static String SuccessMessageTitle_CL = "Geschafft";
    private static String SuccessMessageBody_CL = "Deine Änderung wurde gespeichert.";
    private static String FailedMessageTitle_CL = "Das hat leider nicht geklappt";
    private static String FailedMessageBody_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String HuawiSubHeader_CL = "Die Anrufsperre gilt für alle Deine Rufnummern.";

    //Methods
    @Step(" validate block outgoing Calls Settings page Header ")
    public CallBlockingSettings ValidateBlockOutGoingCallPageHeader ()
    {
        driver.element().isElementDisplayed(StepperTitle);
        driver.verifyThat().element(StepperTitle)
                .textTrimmed().isEqualTo(StepperTitle_CL)
                .withCustomReportMessage("Validate StepperTitle text")
                .perform();
        driver.verifyThat().element(PageTitle)
                .textTrimmed().isEqualTo(PageTitle_CL)
                .withCustomReportMessage("Validate PageTitle")
                .perform();
        driver.verifyThat().element(StepperTitle)
                .textTrimmed().isEqualTo(StepperTitle_CL)
                .withCustomReportMessage("Validate StepperTitle text")
                .perform();
        return this;
    }

    @Step(" validate Single number tile is displayed ")
    public CallBlockingSettings ValidateBlockOutGoingCallForSingleNumTile ()
    {
        driver.verifyThat().element(StepperHeader)
                .textTrimmed().isEqualTo(SingleNum_StepperHeader_CL)
                .withCustomReportMessage("Validate StepperHeader text")
                .perform();

        driver.verifyThat().element(OneNumberTile)
                .exists()
                .withCustomReportMessage("Validate OneNumberTile is exist")
                .perform();
        return this;
    }

    @Step(" validate Single Land Line tile is displayed ")
    public CallBlockingSettings ValidateBlockOutGoingCallForSingleLandLineTile ()
    {
        driver.verifyThat().element(StepperHeader)
                .textTrimmed().isEqualTo(SingleLand_StepperHeader_CL)
                .withCustomReportMessage("Validate StepperHeader text")
                .perform();

        driver.verifyThat().element(OneNumberTile)
                .exists()
                .withCustomReportMessage("Validate OneNumberTile is exist")
                .perform();
        return this;
    }

    @Step(" validate Multi numbers DDL is displayed ")
    public CallBlockingSettings ValidateBlockOutGoingCallForMultiNumbersDDL ()
    {
        driver.verifyThat().element(StepperHeader)
                .textTrimmed().isEqualTo(MultiNum_StepperHeader_CL)
                .withCustomReportMessage("Validate StepperHeader text")
                .perform();

        driver.verifyThat().element(MultiNumbersDDL)
                .exists()
                .withCustomReportMessage("Validate MultiNumbersDDL is exist")
                .perform();
        return this;
    }

    @Step(" validate Multi Land Lines DDL is displayed ")
    public CallBlockingSettings ValidateBlockOutGoingCallForMultiLandLinesDDL ()
    {
        driver.verifyThat().element(StepperHeader)
                .textTrimmed().isEqualTo(MultiLand_StepperHeader_CL)
                .withCustomReportMessage("Validate StepperHeader text")
                .perform();

        driver.verifyThat().element(MultiNumbersDDL)
                .exists()
                .withCustomReportMessage("Validate MultiNumbersDDL is exist")
                .perform();
        return this;
    }

    @Step(" validate Inline message for landline tile ")
    public CallBlockingSettings ValidateInLineMessageForLandLineTile ()
    {
        driver.verifyThat().element(InlineMessageForLandLineTile)
                .exists()
                .withCustomReportMessage("Validate InlineMessageForLandLineTile is exist")
                .perform();
        return this;
    }

    @Step(" validate choosing second number in  Multi numbers DDL is displayed ")
    public CallBlockingSettings ChooseSecondNumberForMultiNumbersDDL ()
    {
        driver.element().click(MultiNumbersDDL);
        driver.element().click(SecondPhoneNumberInDDL);
        return this;
    }

    @Step(" validate first step in block outgoing Calls Settings transaction ")
    public CallBlockingSettings ValidateFirstStepOfBlockOutGoingCall ()
    {
        driver.verifyThat().element(FirstSwitcherTitle)
                .textTrimmed().isEqualTo(FirstSwitcherTitle_CL)
                .withCustomReportMessage("Validate FirstSwitcherTitle CL")
                .perform();
        driver.verifyThat().element(FirstSwitcherDesc)
                .textTrimmed().isEqualTo(FirstSwitcherDesc_CL)
                .withCustomReportMessage("Validate FirstSwitcherDesc text")
                .perform();
        driver.verifyThat().element(FirstSwitcherToggle)
                .exists()
                .withCustomReportMessage("Validate FirstSwitcherToggle is exist")
                .perform();
        driver.verifyThat().element(SecondSwitcherTitle)
                .textTrimmed().isEqualTo(SecondSwitcherTitle_CL)
                .withCustomReportMessage("Validate SecondSwitcherTitle CL")
                .perform();
        driver.verifyThat().element(SecondSwitcherDesc)
                .textTrimmed().isEqualTo(SecondSwitcherDesc_CL)
                .withCustomReportMessage("Validate SecondSwitcherDesc text")
                .perform();
        driver.verifyThat().element(SecondSwitcherToggle)
                .exists()
                .withCustomReportMessage("Validate SecondSwitcherToggle is exist")
                .perform();
        driver.verifyThat().element(ThirdSwitcherTitle)
                .textTrimmed().isEqualTo(ThirdSwitcherTitle_CL)
                .withCustomReportMessage("Validate ThirdSwitcherTitle CL")
                .perform();
        driver.verifyThat().element(ThirdSwitcherDesc)
                .textTrimmed().isEqualTo(ThirdSwitcherDesc_CL)
                .withCustomReportMessage("Validate ThirdSwitcherDesc text")
                .perform();
        driver.verifyThat().element(ThirdSwitcherToggle)
                .exists()
                .withCustomReportMessage("Validate ThirdSwitcherToggle is exist")
                .perform();
        driver.verifyThat().element(ConfirmationBtn)
                .textTrimmed().isEqualTo(ConfirmationBtn_CL)
                .withCustomReportMessage("Validate ConfirmationBtn text")
                .perform();

        driver.verifyThat().element(ConfirmationBtn)
                .isDisabled()
                .withCustomReportMessage("Validate ConfirmationBtn is disabled before change settings")
                .perform();
        return this;
    }

    @Step(" Click on first switcher toggle ")
    public CallBlockingSettings ClickOnFirstSwitcherToggle ()
    {
        driver.element().click(FirstSwitcherToggle);
        return this;
    }

    @Step(" Click on Second switcher toggle ")
    public CallBlockingSettings ClickOnSecondSwitcherToggle ()
    {
        driver.element().click(SecondSwitcherToggle);
        return this;
    }

    @Step("  Click on Third switcher toggle ")
    public CallBlockingSettings ClickOnThirdSwitcherToggle ()
    {
        driver.element().click(ThirdSwitcherToggle);
        return this;
    }

    @Step(" Click on Confirmation Btn ")
    public CallBlockingSettings ClickOnConfirmationButton ()
    {
        driver.verifyThat().element(ConfirmationBtn)
                .isEnabled()
                .withCustomReportMessage("Validate ConfirmationBtn is enabled after change settings")
                .perform();
        driver.element().click(ConfirmationBtn);
        return this;
    }

    @Step(" Validate Success Message ")
    public CallBlockingSettings ValidateSuccessMessage ()
    {
        driver.verifyThat().element(SuccessMessageTitle)
                .textTrimmed().isEqualTo(SuccessMessageTitle_CL)
                .withCustomReportMessage("Validate SuccessMessageTitle text")
                .perform();

        driver.verifyThat().element(SuccessMessageBody)
                .textTrimmed().isEqualTo(SuccessMessageBody_CL)
                .withCustomReportMessage("Validate SuccessMessageBody text")
                .perform();

        driver.verifyThat().element(SuccessMessageIcon)
                .exists()
                .withCustomReportMessage("Validate SuccessMessageIcon is exist")
                .perform();
        return this;
    }

    @Step(" Validate Failure Message ")
    public CallBlockingSettings ValidateFailureMessage ()
    {
        driver.verifyThat().element(FailedMessageTitle)
                .textTrimmed().isEqualTo(FailedMessageTitle_CL)
                .withCustomReportMessage("Validate FailedMessageTitle text")
                .perform();

        driver.verifyThat().element(FailedMessageBody)
                .textTrimmed().isEqualTo(FailedMessageBody_CL)
                .withCustomReportMessage("Validate FailedMessageBody text")
                .perform();

        driver.verifyThat().element(FailedMessageIcon)
                .exists()
                .withCustomReportMessage("Validate FailedMessageIcon is exist")
                .perform();
        return this;
    }

    @Step(" validate Out going sub header for huwai user ")
    public CallBlockingSettings ValidateBlockOutGoingCallSubHeaderForHuwai ()
    {
        driver.verifyThat().element(HuawiSubHeader)
                .textTrimmed().isEqualTo(HuawiSubHeader_CL)
                .withCustomReportMessage("Validate HuawiSubHeader text")
                .perform();
        return this;
    }


}
