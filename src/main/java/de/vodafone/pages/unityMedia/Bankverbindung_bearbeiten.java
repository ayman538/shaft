package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Bankverbindung_bearbeiten {
    public static By PageTitle;
    private SHAFT.GUI.WebDriver driver;

    //Constractor
    public Bankverbindung_bearbeiten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    /*CLs*/
    public static String pageTitleCL = "Bankverbindung ändern";
    public static String pageSubTitleCL = "NRW341449201 (Kundennummer: 341449201)";
    public static String stepOneAccCL = "Kontodaten bearbeiten";
    public static String new_IBAN = "DE12500105170648489890";
    public static String successMsg_textCL = "Von dieser Bankverbindung buchen wir in Zukunft den Rechnungsbetrag für die ausgewählten Produkte ab.";
    public static String successMsg_TitleCL = "Bankverbindung gespeichert";
    public static String notificationMsg_textCL = "Wichtig: Wenn Du außerdem einen Vertrag für DSL & Festnetz oder Kabel bei uns hast, bitte ändere Deine Bankverbindung separat auch dort. Das geschieht nicht automatisch.";
    public static String notificationMsg_TitleCL = "Deine Bankverbindung wird geändert";

    /*Locators*/
    public static final By pageTitle = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    public static final By ibanField = By.xpath("//*[@automation-id='iban_et']");
    public static final By successMsg_text = By.xpath("(//*[@automation-id='undefined_nt']//h4)[1]");
    public static final By successMsg_Title = By.xpath("(//*[@automation-id='undefined_nt']//p)[1]");
    public static final By notificationMsg_Text = By.xpath("//*[@automation-id='changeSeparatelyNotification_nt']//p");
    public static final By notificationMsg_Title = By.xpath("//*[@automation-id='changeSeparatelyNotification_nt']//h4");

    public static final By pageSubTitle = By.xpath("//*[@automation-id='pageHeader_tv']//h2");
    public static final By stepOne_Acc = By.xpath("//*[@id='step2']");
    public static final By stepTwo_Acc = By.xpath("//*[@id='step2']");
    public static final By saveBtn = By.xpath("//button[@class='btn btn-sml']");
    public static final By sepaCheckBox = By.xpath("(//*[@automation-id=\"undefined_chk\"])");
    public static final By continue_Btn = By.xpath("//*[@class='btn btn-sml btn-em']");
    public static final By ownerName_field = By.xpath("//*[@automation-id='accountOwnerName_et']");
    @Step("enter iban")
    public void editIBAN(String IBAN) {
        (driver.getDriver().findElement(ibanField)).sendKeys(new_IBAN);
    }

    @Step("Click on continue button")
    public void clickOnContinueBtn() {
        driver.element().click(continue_Btn);
    }
    @Step("Click on save button")
    public void clickOnSaveBtn() {
        driver.element().click(saveBtn);
    }

    public void clickOnCheckBox() {
        driver.element().click(sepaCheckBox);
    }

    /* **************** WFCT-13466 **************** */

    private String foreignIban = "GB29NWBK60161331926819";
    private String backDetailsInfoIconCL = "Ich ermächtige die Vodafone GmbH, Zahlungen von meinem Konto mittels Lastschrift einzuziehen. Zugleich weise ich mein Kreditinstitut an, diese Lastschriften einzulösen. Gut zu wissen: Ich kann innerhalb von 8 Wochen, beginnend mit dem Belastungsdatum, die Erstattung des belasteten Betrags verlangen. Es gelten dabei die Bedingungen, die ich mit meinem Kreditinstitut vereinbart habe.";

    private String BankDetailsSuccessConfirmationHeaderMsgCl = "Bankverbindung gespeichert";
    private String BankDetailsSuccessConfirmationDescriptionMsgCl = "Von dieser Bankverbindung buchen wir in Zukunft den Rechnungsbetrag für die ausgewählten Produkte ab.";

    private String BankDetailsFailureMsgTitleCL = "Das hat leider nicht geklappt";
    private String BankDetailsFailureMsgDescriptionCL = "Deine Bankverbindung konnte nicht gespeichert werden. Entschuldige bitte, das war unser Fehler. Versuch es bitte nochmal.";

    private String bankDetailsFirstStepFailureNotificationCL = "Hier stimmt was nicht.";
    private String bankDetailsForeignIbanInlineErrorMsgCL = "Du kannst online nur ein deutsches Konto hinzufügen. Falls Du ein nicht-deutsches SEPA-Konto verwenden möchtest, sprich uns bitte an: www.vodafone.de/kontakt";
    private String bankDetailsWrongIbanInlineErrorMsgCL = "Prüf bitte das IBAN-Format.";
    private String ownerFieldTitleCL = "Kontoinhaber *";
    private String ibanInputFieldTitle_CL = "IBAN *";
    private String firstStepSubmitBtnBL = "Weiter";
    private String editBankDetailsSecondStepTitleCL = "Daten überprüfen";
    private String editBankDetailsSecondStepHeaderTextCL = "Überprüf Deine Daten bitte nochmal, bevor Du die Bankverbindung speicherst:";
    private String ibanTitleCL = "IBAN";
    private String bankDetailsBicTitleCl = "BIC";
    private String bankDetailsBankTitleCl = "BANK";
    private String bankDetailsOwnerTitleCl = "Kontoinhaber";
    private String bankDetailsSecondStepButtonCl = "Bankverbindung speichern";
    private String bankDetailsSuccessConfirmationCollapsedCardClass = "ac-head";
    private String bankDetailsSuccessConfirmationCardDescriptionCl = "Vielen Dank für Deinen Auftrag zur Änderung der Bankverbindung";
    private String checkBoxCl = "Hiermit erteile ich Vodafone ein SEPA-Lastschriftmandat.";


    private final By bankDetailsSuccessConfirmationCardDescriptionLocator = By.xpath("//li[@automation-id='accordion0_acc']//h3");
    private final By editBankDetailsFirstSubmitButtonLocator = By.xpath("//div[@id='Step0']/..//button");
    private final By bankDetailsInfoIconLocator = By.xpath("//div[@automation-id='undefinedInfoIcon_tv']/a[1]");
    private final By bankDetailsInfoIconTextLocator = By.xpath("//p[@automation-id='undefined_tv']");
    private final By bankDetailsCheckBoxLocator = By.xpath("//input[@id='id1']");
    private final By editBankDetailsSecondSubmitButtonLocator = By.xpath("//button[@class='btn btn-sml']");
    private final By bankDetailsSuccessConfirmationMsgHeaderLocator = By.xpath("(//div[@automation-id='successMsg_tv'])[1]//h4");
    private final By bankDetailsSuccessConfirmationMsgDescriptionLocator = By.xpath("(//div[@automation-id='successMsg_tv'])[1]//p");
    private final By bankDetailsSuccessConfirmationCardLocator = By.xpath("//li[@automation-id='accordion0_acc']/a");
    private final By BankDetailsFailureMsgTitleLocator = By.xpath("(//div[@automation-id='successMsg_tv'])[1]//h4");
    private final By BankDetailsFailureMsgDescriptionLocator = By.xpath("(//div[@automation-id='successMsg_tv'])[1]//p");
    private final By bankDetailsFirstStepNotificationBodyLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private final By bankDetailsInlineErrorMsgLocator = By.xpath("//p[@automation-id='ibanadditionalErrorMessage_et']/p");
    private final By bankDetailsStepOneCardHeaderLocator = By.xpath("//*[@automation-id='step1_containertv']//div[@class='header-title']");
    private final By ownerFieldTitleLocator = By.xpath("(//div[@class=\"tg-label\"])[1]/label");
    private final By ibanInputFieldTitleLocator = By.xpath("(//div[@class=\"tg-label\"])[2]/label");
    private final By editBankDetailsSecondStepTitleLocator = By.xpath("(//div[@class='header-title'])[2]");
    private final By editBankDetailsSecondStepHeaderTextLocator = By.xpath("//div[@id='Step1']/..//h3");
    private final By ibanTitleLocator = By.xpath("(//div[@id='Step1']/..//strong)[2]");
    private final By bankDetailsBicTitleLocator = By.xpath("(//div[@id='Step1']/..//strong)[3]");
    private final By bankDetailsBankTitleLocator = By.xpath("(//div[@id='Step1']/..//strong)[4]");
    private final By bankDetailsOwnerTitleLocator = By.xpath("(//div[@id='Step1']/..//strong)[1]");
    private final By confirmationCardIbanTitleLocator = By.xpath("//div[@class='white-box mb-20']/p[2]/strong");
    private final By confirmationCardBankDetailsBicTitleLocator = By.xpath("//div[@class='white-box mb-20']/p[3]/strong");
    private final By confirmationCardBankDetailsBankTitleLocator = By.xpath("//div[@class='white-box mb-20']/p[4]/strong");
    private final By confirmationCardBankDetailsOwnerTitleLocator = By.xpath("//div[@class='white-box mb-20']/p[1]/strong");
    private By checkBoxCl_Locator = By.xpath("//div[@automation-id='checkboxItemModel.id_label_tv']");
    private static By backLink = By.xpath("//a[@automation-id='back_Link']");



    @Step("click On Edit Bank Details Second Submit Button")
    public void clickOnEditBankDetailsSecondSubmitButton() {
        driver.element().click(editBankDetailsSecondSubmitButtonLocator);

    }

    @Step("click on bank details checkbox")
    public void clickOnBankDetailsCheckBox() {
        driver.element().click(bankDetailsCheckBoxLocator);
    }

    @Step("click on edit bank details first submit button")
    public void clickOnEditBankDetailsFirstSubmitButton() {
        driver.element().click(editBankDetailsFirstSubmitButtonLocator);
    }

    @Step("expand success confirmation card")
    public void expandSuccessConfirmationCard() {
        driver.element().click(bankDetailsSuccessConfirmationCardLocator);
    }

    @Step("click on info icon")
    public void clickOnBankDetailsInfoIcon() {
        driver.element().click(bankDetailsInfoIconLocator);
    }

    @Step("enter iban")
    public void enterIBAN(String IBAN) {
        driver.element().type(ibanField, IBAN);
    }
    @Step("Click on back button")
    public void clickOnBackButton(){
        driver.element().click(backLink);
    }

    public void assertThatAddBankDetailsPageTitleIsCorrect() {

        driver.verifyThat().element(pageTitle).text()
                .isEqualTo(pageTitleCL)
                .withCustomReportMessage("Check that Edit Bank details Page Title is correct").perform();

    }

    public void assertOnBankDetailsFirstStepTitle() {
        driver.verifyThat().element(bankDetailsStepOneCardHeaderLocator)
                .text().isEqualTo(stepOneAccCL)
                .withCustomReportMessage("Check that Edit Bank First Step Title is correct")
                .perform();
    }

    public void assertOnOwnerFieldTitle() {
        driver.verifyThat().element(ownerFieldTitleLocator).text()
                .contains(ownerFieldTitleCL)
                .withCustomReportMessage("Check that Owner Field Title is correct")
                .perform();
    }

    public void assertOnIbanInputFieldTitle() {
        driver.verifyThat().element(ibanInputFieldTitleLocator).text()
                .contains(ibanInputFieldTitle_CL)
                .withCustomReportMessage("Check that IbanInputField Title is correct")
                .perform();
    }

    public void assertOnBankDetailsFirstStepSubmitButtonText() {
        driver.verifyThat().element(editBankDetailsFirstSubmitButtonLocator).text()
                .isEqualTo(firstStepSubmitBtnBL)
                .withCustomReportMessage("Check that text of First Step Submit btn is correct")
                .perform();
    }

    public void assertThatBankDetailsFirstStepSubmitButtonIsDimmed() {
        driver.verifyThat().element(editBankDetailsFirstSubmitButtonLocator)
                .isDisabled()
                .withCustomReportMessage("Check that submit btn still dimmed until enter correct Iban")
                .perform();
    }

    public void assertThatBankDetailsFirstStepSubmitButtonIsClickable() {
        driver.verifyThat().element(editBankDetailsFirstSubmitButtonLocator)
                .isEnabled()
                .withCustomReportMessage("Check that submit btn become clickable")
                .perform();
    }


    public void assertOnInfoIconCL() {
        driver.verifyThat().element(bankDetailsInfoIconTextLocator).text().isEqualTo(backDetailsInfoIconCL).withCustomReportMessage("assert on info icon cl").perform();
    }

    public void assertOnBankDetailsSuccessConfirmationMsg() {
        driver.verifyThat().element(bankDetailsSuccessConfirmationMsgHeaderLocator).text().isEqualTo(BankDetailsSuccessConfirmationHeaderMsgCl).withCustomReportMessage("assert on bank details success confirmation msg header").perform();

        driver.verifyThat().element(bankDetailsSuccessConfirmationMsgDescriptionLocator).text().isEqualTo(BankDetailsSuccessConfirmationDescriptionMsgCl).withCustomReportMessage("assert on bank details success confirmation msg Description").perform();
    }

    public void assertOnBankDetailsFailureMsg() {
        driver.verifyThat().element(BankDetailsFailureMsgTitleLocator).text().isEqualTo(BankDetailsFailureMsgTitleCL).withCustomReportMessage("assert on bank details failure  msg title").perform();
        driver.verifyThat().element(BankDetailsFailureMsgDescriptionLocator).text().isEqualTo(BankDetailsFailureMsgDescriptionCL).withCustomReportMessage("assert on bank details failure msg description").perform();

    }


    public void assertOnIbanFailureNotificationCl() {

        driver.verifyThat().element(bankDetailsFirstStepNotificationBodyLocator).text().contains(bankDetailsFirstStepFailureNotificationCL).withCustomReportMessage("assert on foreign iban failure inline error Cl").perform();

    }

    public void assertOnForeignIbanInlineErrorCl() {
        driver.verifyThat().element(bankDetailsInlineErrorMsgLocator).text().isEqualTo(bankDetailsForeignIbanInlineErrorMsgCL).withCustomReportMessage("assert on foreign iban failure notification CL").perform();
    }


    public void assertOnWrongIbanInlineErrorCl() {
        driver.verifyThat().element(bankDetailsInlineErrorMsgLocator).text().contains(bankDetailsWrongIbanInlineErrorMsgCL).withCustomReportMessage("assert on Wrong iban failure inline error Cl");
    }

    public void waits() {
        driver.verifyThat().element(By.xpath("sdfddf")).doesNotExist().withCustomReportMessage("wait").perform();
    }

    public void assertThatBankDetailsSecondStepTitleIsCorrect() {
        driver.verifyThat().element(editBankDetailsSecondStepTitleLocator).text()
                .isEqualTo(editBankDetailsSecondStepTitleCL)
                .withCustomReportMessage("Check that Edit Bank Second Step Title is correct")
                .perform();
    }

    public void assertThatBankDetailsSecondStepHeaderIsCorrect() {
        driver.verifyThat().element(editBankDetailsSecondStepHeaderTextLocator).text()
                .isEqualTo(editBankDetailsSecondStepHeaderTextCL)
                .withCustomReportMessage("Check that Edit Bank Second Step Header Text is correct")
                .perform();
    }

    public void assertThatBankDetailsIbanTitleIsCorrect() {
        driver.verifyThat().element(ibanTitleLocator).text()
                .isEqualTo(ibanTitleCL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
    }

    public void assertThatBankDetailsBicTitleIsCorrect() {
        driver.verifyThat().element(bankDetailsBicTitleLocator).text()
                .isEqualTo(bankDetailsBicTitleCl)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
    }

    public void assertThatBankDetailsBankTitleIsCorrect() {
        driver.verifyThat().element(bankDetailsBankTitleLocator).text()
                .isEqualTo(bankDetailsBankTitleCl)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
    }

    public void assertThatBankDetailsOwnerTitleIsCorrect() {
        driver.verifyThat().element(bankDetailsOwnerTitleLocator).text()
                .isEqualTo(bankDetailsOwnerTitleCl)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
    }

    public void assertThatBankDetailsConfirmationCardOIbanTitleIsCorrect() {
        driver.verifyThat().element(confirmationCardIbanTitleLocator).text()
                .isEqualTo(ibanTitleCL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
    }

    public void assertThatBankDetailsConfirmationCardOBicTitleIsCorrect() {
        driver.verifyThat().element(confirmationCardBankDetailsBicTitleLocator).text()
                .isEqualTo(bankDetailsBicTitleCl)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
    }

    public void assertThatBankDetailsConfirmationCardOBankTitleIsCorrect() {
        driver.verifyThat().element(confirmationCardBankDetailsBankTitleLocator).text()
                .isEqualTo(bankDetailsBankTitleCl)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
    }

    public void assertThatBankDetailsConfirmationCardOwnerTitleIsCorrect() {
        driver.verifyThat().element(confirmationCardBankDetailsOwnerTitleLocator).text()
                .isEqualTo(bankDetailsOwnerTitleCl)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
    }


    public void assertThatBankDetailsSecondStepSubmitButtonClIsCorrect() {
        driver.verifyThat().element(editBankDetailsSecondSubmitButtonLocator).text()
                .isEqualTo(bankDetailsSecondStepButtonCl)
                .withCustomReportMessage("Check that second step submit button Cl is correct")
                .perform();
    }

    public void assertThatBankDetailsSecondStepSubmitButtonIsDisabled() {
        driver.verifyThat().element(editBankDetailsSecondSubmitButtonLocator)
                .isDisabled()
                .withCustomReportMessage("Check that second step submit button is disabled")
                .perform();
    }

    public void assertThatBankDetailsSecondStepSubmitButtonIsEnabled() {
        driver.verifyThat().element(editBankDetailsSecondSubmitButtonLocator)
                .isEnabled()
                .withCustomReportMessage("Check that second step submit button is enabled")
                .perform();
    }

    public void assertThatBankDetailsSuccessConfirmationCardIsNotExpanded() {
        driver.verifyThat().element(bankDetailsSuccessConfirmationCardLocator).attribute("class").isEqualTo(bankDetailsSuccessConfirmationCollapsedCardClass).withCustomReportMessage("assert that card is not expanded").perform();

    }

    public void assertOntBankDetailsSuccessConfirmationCardDescription() {
        driver.verifyThat().element(bankDetailsSuccessConfirmationCardDescriptionLocator).text().isEqualTo(bankDetailsSuccessConfirmationCardDescriptionCl).withCustomReportMessage("assert on Confirmation Card Description").perform();
    }
    public void assertThatContinueBtnIsDimmed(){
        driver.assertThat().element(continue_Btn).isDisabled().withCustomReportMessage("assert that continue button is disabled").perform();
    }
    public void assertOnCheckBoxCl(){
        driver.assertThat().element(checkBoxCl_Locator).textTrimmed().isEqualTo(checkBoxCl).withCustomReportMessage("Assert on checkbox Cl").perform();
    }
    public void assertThatSaveBtnIsDimmed(){
        driver.assertThat().element(saveBtn).isDisabled().withCustomReportMessage("assert that save button is disabled").perform();
    }



}
