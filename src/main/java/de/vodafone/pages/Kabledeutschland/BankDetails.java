package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;

public class BankDetails {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    public static String IBan = "DE86300700100002508000";
    public static String WrongIBan = "DE86300700100002508002";
    public static String IncompletedIban = "DE863007001000025080";
    public static String TooLongIban = "DE8630070010000250800011";
    public static String WrongFormatIBan = "%86300700100002508000";

    // Locators
    public static final By EditFirstDebitBank_btn = By.xpath("(//*[@automation-id=\"changeBank_btn\"])[1]");
    public static final By EditSecondDebitBank_btn = By.xpath("(//*[@automation-id=\"changeBank_btn\"])[2]");

    public static final By EditOneByOneInvoices_LinkOut1 = By.xpath("(//*[@automation-id=\"changeOneByOne_Link\"])[1]");
    public static final By EditOneByOneInvoices_LinkOut2 = By.xpath("(//*[@automation-id=\"changeOneByOne_Link\"])[2]");
    public static final By EditBankPage_Title = By.xpath("//*[@automation-id=\"pageHeader_tv\"]/h1");
    public static final By EditBankInvoiceChooserAcc_Title = By.xpath("//*[@automation-id=\"oneStepStepperHeader_tv\"]");
    public static final By EditBankInvoiceChooserHeader_Text = By.xpath("//*[@automation-id=\"description_tv\"]");
    public static final By FirstInvoiceOwner_Title = By.xpath("(//*[@automation-id=\"owner_tv\"]/strong)[1]");
    public static final By FirstInvoiceOwner_Content = By.xpath("(//*[@automation-id=\"owner_tv\"]/span)[1]");
    public static final By FirstInvoiceIban_Title = By.xpath("(//*[@automation-id=\"iban_tv\"]/strong)[1]");
    public static final By FirstInvoiceIban_Content = By.xpath("(//*[@automation-id=\"iban_tv\"]/span)[1]");
    public static final By FirstInvoiceBIC_Title = By.xpath("(//*[@automation-id=\"bic_tv\"]/strong)[1]");
    public static final By FirstInvoiceBIC_Content = By.xpath("(//*[@automation-id=\"bic_tv\"]/span)[1]");
    public static final By FirstInvoiceBank_Title = By.xpath("(//*[@automation-id=\"bankName_tv\"]/strong)[1]");
    public static final By FirstInvoiceBank_Content = By.xpath("(//*[@automation-id=\"bankName_tv\"]/span)[1]");
    public static final By FirstInvoiceDirectPayStatus_Title = By.xpath("(//*[@automation-id=\"authority_tv\"]/strong)[1]");
    public static final By FirstInvoiceDirectPayStatus = By.xpath("(//*[@automation-id=\"authority_tv\"]/span)[1]");
    public static final By FirstInvoiceProdSection_Title = By.xpath("(//*[@automation-id=\"referenceKonto-header_tv\"])[1]");
    public static final By FirstInvoice_Number = By.xpath("(//*[@automation-id=\"referenceKonto_tv\"])[1]");
    public static final By FirstInvoiceProduct_Name = By.xpath("(//*[@automation-id=\"service_tv\"]/span)[1]");
    public static final By FirstInvoiceProduct_Icon = By.xpath("(//*[@automation-id=\"service_tv\"]//*[@class=\"i-sml\"])[1]");
    public static final By EditBankFirstInvoice_btn = By.xpath("(//*[@class=\"btn btn-em mt-20\"])[1]");
    public static final By SecondInvoiceOwner_Title = By.xpath("(//*[@automation-id=\"owner_tv\"]/strong)[2]");
    public static final By SecondInvoiceOwner_Content = By.xpath("(//*[@automation-id=\"owner_tv\"]/span)[2]");
    public static final By SecondInvoiceIban_Title = By.xpath("(//*[@automation-id=\"iban_tv\"]/strong)[2]");
    public static final By SecondInvoiceIban_Content = By.xpath("(//*[@automation-id=\"iban_tv\"]/span)[2]");
    public static final By SecondInvoiceBIC_Title = By.xpath("(//*[@automation-id=\"bic_tv\"]/strong)[2]");
    public static final By SecondInvoiceBIC_Content = By.xpath("(//*[@automation-id=\"bic_tv\"]/span)[2]");
    public static final By SecondInvoiceBank_Title = By.xpath("(//*[@automation-id=\"bankName_tv\"]/strong)[2]");
    public static final By SecondInvoiceBank_Content = By.xpath("(//*[@automation-id=\"bankName_tv\"]/span)[2]");
    public static final By SecondInvoiceDirectPayStatus_Title = By.xpath("(//*[@automation-id=\"authority_tv\"]/strong)[2]");
    public static final By SecondInvoiceDirectPayStatus = By.xpath("(//*[@automation-id=\"authority_tv\"]/span)[2]");
    public static final By SecondInvoiceProdSection_Title = By.xpath("(//*[@automation-id=\"referenceKonto-header_tv\"])[2]");
    public static final By SecondInvoice_Number = By.xpath("(//*[@automation-id=\"referenceKonto_tv\"])[2]");
    public static final By SecondInvoiceProduct_Name = By.xpath("(//*[@automation-id=\"service_tv\"]/span)[2]");
    public static final By SecondInvoiceProduct_Icon = By.xpath("(//*[@automation-id=\"service_tv\"]//*[@class=\"i-sml\"])[3]");
    public static final By EditBankSecondInvoice_btn = By.xpath("(//*[@class=\"btn btn-em mt-20\"])[2]");

    public static final By EditBankFirstStep_Title = By.xpath("(//*[@class=\"header-title\"])[1]");
    public static final By EditBankFirstStepHeader_Text = By.xpath("//*[@automation-id=\"description_tv\"]");
    public static final By OwnerField_Title = By.xpath("(//*[@class=\"tg-label\"])[1]");
    public static final By OwnerFieldTitle_Locator = By.xpath("(//label[@for='text'])[1]");
    public static final By OwnerFieldLocator = By.xpath("//input[@automation-id='accountOwnerName_et']");
    public static final By OwnerField = By.xpath("(//*[@class=\"fm-field-container\"])[1]");
    public static final By IbanInputField_Title = By.xpath("(//*[@class=\"tg-label\"])[2]");
    public static final By IbanInputField = By.xpath("(//*[@class=\"fm-field-container\"]/input)[2]");
    public static final By IbanInputFieldBelow_Text = By.xpath("(//*[@automation-id=\"required_tv\"]/span)[2]");
    public static final By FirstStepSubmit_btn = By.xpath("//*[@automation-id=\"validate_Iban_btn\"]");
    public static final By EditFirstStep_btn = By.xpath("//*[@class=\"header-back-link\"]");
    public static final By info_Icon = By.xpath("(//*[@automation-id=\"undefinedInfoIcon_tv\"]/a)[1]");

    public static final By EditBankSecondStep_Title = By.xpath("(//*[@class=\"header-title\"])[2]");
    public static final By EditBankSecondStepHeader_Text = By.xpath("//*[@automation-id=\"description_tv\"]");

    public static final By ReviewCheckBox = By.xpath("//*[@automation-id=\"SEPA_mandate_chk\"]/div");
    public static final By ReviewCheckBox_Text = By.xpath("//*[@class=\"label-content\"]");
    public static final By ReviewCheckBox_InfoIcon = By.xpath("//*[@automation-id=\"undefinedInfoIcon_tv\"]/a[1]//*[@class=\"i-xsml\"]");
    public static final By ReviewCheckBox_Close_InfoIcon = By.xpath("//*[@automation-id=\"undefinedInfoIcon_tv\"]/a[2]//*[@class=\"i-xsml\"]");
    public static final By ReviewCheckBox_InfoIcon_Text = By.xpath("//*[@automation-id=\"undefinedInfoIcon_tv\"]//p");

    public static final By backEndErrorHeadlineLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    public static final By backEndErrorBodyLocator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    public static final By ReviewStepSubmit_btn = By.xpath("//*[@automation-id=\"Update_Bank_btn\"]");
    public static final By anderButtonLocator = By.xpath("//div[@automation-id='cableStep1_editableTexttv']");
    public static final By sepaMandateCheckbox = By.xpath("//input[@automation-id='checkboxItemModel.id_tv']");
    public static final By sepaMandateToolTipClLocator = By.xpath("//p[@automation-id='undefined_tv']");
    public static final By sepaMandateClLocator = By.xpath("//div[@automation-id='checkboxItemModel.id_label_tv']");
    public static final By sepaMandateToolTipSymbolLocator = By.xpath("//div[@automation-id='undefinedInfoIcon_tv']/a[@class='tg-icon']");
    public static final By confirmationPageTitleLocator = By.xpath("//div[@automation-id='pageHeader_tv']/h1");

    public static final By SingleContract_SuccessMsg_Title = By.xpath("//*[@automation-id=\"success_nt\"]//h4");
    public static final By SingleContract_SuccessMsg_Body = By.xpath("//*[@automation-id=\"success_nt\"]//p");
    public static final By SingleContract_SuccessMsg_Icon = By.xpath("//*[@automation-id=\"success_nt\"]//*[@class=\"i-sml i-green\"]");

    public static final By MultiContract_SuccessMsg_Title = By.xpath("//*[@automation-id=\"multi_success_nt\"]//h4");
    public static final By MultiContract_SuccessMsg_Body = By.xpath("//*[@automation-id=\"multi_success_nt\"]//p");
    public static final By MultiContract_SuccessMsg_Icon = By.xpath("//*[@automation-id=\"multi_success_nt\"]//*[@class=\"i-sml i-green\"]");

    public static final By PartFailMsg_Title = By.xpath("//*[@automation-id=\"partail_success_nt\"]//h4");
    public static final By PartFailMsg_Body = By.xpath("//*[@automation-id=\"partail_success_nt\"]//p");
    public static final By PartFailMsg_Icon = By.xpath("//*[@automation-id=\"partail_success_nt\"]//*[@class=\"i-sml i-orange\"]");

    public static final By AllFailMsg_Title = By.xpath("//*[@automation-id=\"failed_nt\"]//h4");
    public static final By AllFailMsg_Body = By.xpath("//*[@automation-id=\"failed_nt\"]//p");
    public static final By AllFailMsg_Icon = By.xpath("//*[@automation-id=\"failed_nt\"]//*[@class=\"i-sml i-red\"]");
    public static final By ConfirmedDetailsAcc_Title = By.xpath("(//*[@automation-id=\"preview_acc\"]//span)[1]");
    public static final By ConfirmedDetailsText_Header = By.xpath("//*[@automation-id=\"preview_acc\"]//h3");
    public static final By refrenzkontoPartLocator = By.xpath("//h5[@automation-id='referenceKonto-header_tv']/..");
    public static final By ConfirmationWarningMsg_Title = By.xpath("//*[@automation-id=\"success_info_nt\"]//h4");
    public static final By ConfirmationWarningMsg_Body = By.xpath("//*[@automation-id=\"success_info_nt\"]//p");
    public static final By ConfirmationWarningMsg_Icon = By.xpath("//*[@automation-id=\"success_info_nt\"]//*[@class=\"i-sml\"]");

    public static final By WrongIbanMSg_Title = By.xpath("//div[@class='item-2 w-100']//h4");
    public static final By WrongIbanMSg_Body = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    public static final By WrongIbanMSg_Icon = By.xpath("//*[@class='i-sml i-orange']");
    public static final By WrongIbanInline_Error = By.xpath("//*[@automation-id='iban_patternErrorMessage_et']");
    public static final By Contract_Accordion = By.xpath("(//*[@class=\"contractName\"])[2]");
    public static final By backButton = By.xpath("//a[@automation-id='back_Link']");
    public static final By secondEditBtnInvoiceChooser = By.xpath("(//button[@class='btn btn-em mt-20'])[2]");





    //CLs
    public static String EditBankPage_Title_CL = "Bankverbindung ändern";
    public static String EditBankInvoiceChooserAcc_Title_CL = "Bankverbindung wählen";
    public static String EditBankInvoiceChooserHeader_Text_CL = "Wähl die Bankverbindung aus, die Du ändern willst.";
    public static String Owner_Title_CL = "Kontoinhaber";
    public static String Iban_Title_CL = "IBAN";
    public static String BIC_Title_CL = "BIC";
    public static String Bank_Title_CL = "Bank";
    public static String DirectPayStatus_Title_CL = "Einzugsermächtigung";
    public static String ProdSection_Title_CL = "Verwendet für:";
    public static String EditBank_Btn_CL = "Bankverbindung ändern";
    public static String EditBankFirstStep_Title_CL = "Kontodaten bearbeiten";
    public static String EditBankFirstStepHeader_Text_CL = "Gib bitte Deine Daten ein.";
    public static String OwnerField_Title_CL = "Kontoinhaber *";
    public static String IbanInputField_Title_CL = "IBAN *";
    public static String IbanInputFieldBelow_Text_CL = "Pflichtfeld";
    public static String FirstStepSubmit_btn_CL = "Weiter";
    public static String EditFirstStep_btn_CL = "ändern";
    public static String EditBankSecondStep_Title_CL = "Daten überprüfen";
    public static String EditBankSecondStepHeader_Text_CL = "Überprüf bitte nochmal alles, bevor Du die neue Bankverbindung speicherst.";
    public static String ReviewCheckBox_Text_CL = "Hiermit erteile ich Vodafone ein SEPA-Lastschriftmandat.";
    public static String ReviewCheckBox_InfoIcon_Text_CL = "Ich ermächtige die Vodafone GmbH, Zahlungen von meinem Konto mittels Lastschrift einzuziehen. Zugleich weise ich mein Kreditinstitut an, diese Lastschriften einzulösen. Gut zu wissen: Ich kann innerhalb von 8 Wochen, beginnend mit dem Belastungsdatum, die Erstattung des belasteten Betrags verlangen. Es gelten dabei die Bedingungen, die ich mit meinem Kreditinstitut vereinbart habe.";
    public static String ReviewStepSubmit_btn_CL = "Speichern";
    public static String SingleContract_SuccessMsg_Title_CL = "Bankverbindung gespeichert";
    public static String confirmationPageHeaderCl = "Bankverbindung ändern";
    public static String SingleContract_SuccessMsg_Body_CL = "Von dieser Bankverbindung buchen wir in Zukunft den Rechnungsbetrag für die ausgewählten Produkte ab.";
    public static String MultiContract_SuccessMsg_Title_CL = "Bankverbindung gespeichert";
    public static String MultiContract_SuccessMsg_Body_CL1 = "Von dieser Bankverbindung buchen wir in Zukunft den Rechnungsbetrag für die ausgewählten Produkte ab.";
    public static String MultiContract_SuccessMsg_Body_CL2 = "Wichtig: Wenn Du auch einen DSL-, Festnetz- oder Mobilfunk-Vertrag bei uns hast, ändere Deine Bankverbindung bitte auch dort. Das geschieht nicht automatisch.";
    public static String PartFailMsg_Title_CL = "Wichtig zu wissen";
    public static String PartFailMsg_Body_CL1 = "Die Bankverbindung wurde nur für das Referenzkonto";
    public static String PartFailMsg_Body_CL2 = "gespeichert.";
    public static String PartFailMsg_Body_CL3 = "Für das Referenzkonto";
    public static String PartFailMsg_Body_CL4 = "kannst Du diese IBAN leider nicht verwenden.";
    public static String PartFailMsg_Body_CL5 = "Hast Du Fragen dazu? Ruf uns einfach kostenlos unter";
    public static String PartFailMsg_Body_CL6 = "0800 172 1212 an.";
    public static String AllFailMsg_Title_CL = "Hier stimmt was nicht";
    public static String AllFailMsg_Body_CL = "Diese IBAN kannst Du leider nicht verwenden. Hast Du Fragen dazu? Ruf uns einfach kostenlos unter 0800 172 1212 an.";
    public static String ConfirmedDetailsAcc_Title_CL = "Übersicht";
    public static String ConfirmedDetailsText_Header_CL = "Deine Bankverbindung:";
    public static String ConfirmationWarningMsg_Title_CL = "Wichtig";
    public static String ConfirmationWarningMsg_Body_CL = "Die Bankverbindung wird erst für Deine nächste Rechnung verwendet.";
    public static String WrongIbanMSg_Title_CL = "Wichtig zu wissen";
    public static String WrongIbanMSg_Body_CL = "Überprüf bitte Deine Eingabe und gib eine gültige IBAN ein.";
    public static String WrongIbanInline_Error_CL = "Bitte gib eine gültige IBAN ein.";

    //constructor
    public BankDetails(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }



    //Methods

    private static String deleteWords(String requiredSentence, String... wordsToDelete) {
        for (String word : wordsToDelete) {
            requiredSentence = requiredSentence.replace(word, "");
        }
        return requiredSentence;
    }

    @Step("Check sepa Mandate Check Box")
    public BankDetails checkSepaMandateCheckBox(){
        driver.element().click(sepaMandateCheckbox);
        return this;
    }

    public BankDetails EditFirstBankDetails(){
        driver.element().isElementClickable(EditFirstDebitBank_btn);
        driver.element().click(EditFirstDebitBank_btn);
        return this;
    }
    public BankDetails EditSecondBankDetails(){
        driver.element().click(EditSecondDebitBank_btn);
        return  this;
    }
    public BankDetails EditFirstInvoiceBankDetails() {
        driver.element().isElementClickable(EditBankFirstInvoice_btn);
        driver.element().click(EditBankFirstInvoice_btn);
        return  this;
    }
    public BankDetails EditSecondInvoiceBankDetails() {
        driver.element().isElementClickable(EditBankSecondInvoice_btn);
        driver.element().click(EditBankSecondInvoice_btn);
        return  this;
    }

    public BankDetails SubmitFirstStepOfEditBank() {
        driver.element().isElementClickable(FirstStepSubmit_btn);
        driver.element().click(FirstStepSubmit_btn);
        return  this;
    }
    @Step("Click On Submit Second Step")
    public BankDetails SubmitSecondStepOfEditBank() {
        driver.element().isElementClickable(ReviewStepSubmit_btn);
        driver.element().click(ReviewStepSubmit_btn);
        return  this;
    }
    @Step("Click On Edit IBAN After Entering It")
    public BankDetails clickOnAndernToBackToIbanFieldAgain() {
        driver.element().click(anderButtonLocator);
        return  this;
    }

    @Step("Type In IBAN Field")
    public BankDetails TypeIbanRegex(String IBAN){
        driver.element().type(IbanInputField,IBAN);
        return this;
    }

    //Methods
    public BankDetails assertOnFirtStepCardNameAndTitle() {
        driver.verifyThat().element(EditBankFirstStep_Title)
                .textTrimmed().isEqualTo(EditBankFirstStep_Title_CL)
                .withCustomReportMessage("Check that Edit Bank First Step Title is correct")
                .perform();
        driver.verifyThat().element(EditBankFirstStepHeader_Text).textTrimmed()
                .contains(EditBankFirstStepHeader_Text_CL)
                .withCustomReportMessage("Check that Edit Bank First Step Header Text is correct")
                .perform();
        return  this;
    }
    public BankDetails assertOnOwnerFieldTitleAndDimmed() {
        driver.verifyThat().element(OwnerField_Title).textTrimmed()
                .contains(OwnerField_Title_CL)
                .withCustomReportMessage("Check that Owner Field Title is correct")
                .perform();
        driver.verifyThat().element(OwnerFieldLocator).isDisabled()
                .withCustomReportMessage("Owner Field Is Disabled").perform();
        return  this;
    }

    public BankDetails assertOnOwnerFieldTitle() {
        driver.verifyThat().element(OwnerFieldTitle_Locator).textTrimmed()
                .isEqualTo(OwnerField_Title_CL)
                .withCustomReportMessage("Check that Owner Field Title is correct")
                .perform();
        driver.verifyThat().element(OwnerFieldLocator).isDisabled()
                .withCustomReportMessage("Owner Field Is Disabled").perform();
        return  this;
    }
    public BankDetails assertOnIbanFieldTitleAndExistance() {
        driver.verifyThat().element(IbanInputField_Title).textTrimmed()
                .isEqualTo(IbanInputField_Title_CL)
                .withCustomReportMessage("Check that IbanInputField Title is correct")
                .perform();
        driver.verifyThat().element(IbanInputField)
                .exists()
                .withCustomReportMessage("Check that Iban Input Field is exist")
                .perform();
        return  this;
    }

    public BankDetails assertOnFirstStepSubmitTitle() {
        driver.verifyThat().element(FirstStepSubmit_btn).textTrimmed()
                .isEqualTo(FirstStepSubmit_btn_CL)
                .withCustomReportMessage("Check that text of First Step Submit btn is correct")
                .perform();
        return  this;
    }
    public BankDetails assertThatFirstStepSubmitIsDimmed() {
        driver.verifyThat().element(FirstStepSubmit_btn)
                .isDisabled()
                .withCustomReportMessage("Check that submit btn still dimmed until enter correct Iban")
                .perform();
        return  this;
    }


    public BankDetails assertThatEditBankDetailsIsDimmed() {
        driver.verifyThat().element(EditSecondDebitBank_btn).isDisabled()
                .withCustomReportMessage("Assert That Edit Bank Details is Dimmed").perform();
        return this;
    }


    public BankDetails assertOnSepaMandateToolTip(String toolTipCL) {
        driver.verifyThat().element(sepaMandateToolTipSymbolLocator).exists()
                .withCustomReportMessage("assert On Presence of Tooltip Image")
                .perform();
        driver.verifyThat().element(sepaMandateToolTipClLocator).textTrimmed()
                .isEqualTo(toolTipCL).withCustomReportMessage("Assert On Tool Tip CL")
                .perform();
        return  this;
    }

    public BankDetails assertOnSepaMandateCheckBoxCL(String SepaMandateCL) {
        driver.verifyThat().element(sepaMandateClLocator).textTrimmed()
                .isEqualTo(SepaMandateCL).withCustomReportMessage("Assert Sepa Mandate CL")
                .perform();
        return  this;
    }

    public BankDetails assertOnPageTitleAndConfirmationMessage() {
        driver.verifyThat().element(confirmationPageTitleLocator).textTrimmed()
                .isEqualTo(confirmationPageHeaderCl)
                .withCustomReportMessage("Assert On Page Title is Correct")
                .perform();
        driver.verifyThat().element(SingleContract_SuccessMsg_Title).textTrimmed()
                .isEqualTo(SingleContract_SuccessMsg_Title_CL)
                .withCustomReportMessage("Check that SingleContract_SuccessMsg_Title is correct")
                .perform();
        driver.verifyThat().element(SingleContract_SuccessMsg_Body).textTrimmed()
                .contains(SingleContract_SuccessMsg_Body_CL)
                .withCustomReportMessage("Check that SingleContract_SuccessMsg_Body is correct")
                .perform();
        return this;
    }



    public BankDetails assertOnBankDetailsAtConfirmationCard() {
        driver.verifyThat().element(ConfirmedDetailsAcc_Title).textTrimmed()
                .isEqualTo(ConfirmedDetailsAcc_Title_CL)
                .withCustomReportMessage("Check that ConfirmedDetailsAcc_Title is correct")
                .perform();
        driver.verifyThat().element(ConfirmedDetailsText_Header).textTrimmed()
                .contains(ConfirmedDetailsText_Header_CL)
                .withCustomReportMessage("Check that ConfirmedDetailsText_Header is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Title).textTrimmed()
                .isEqualTo(Owner_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Title).textTrimmed()
                .isEqualTo(Iban_Title_CL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Title).textTrimmed()
                .isEqualTo(BIC_Title_CL)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Title).textTrimmed()
                .isEqualTo(Bank_Title_CL)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus_Title).textTrimmed()
                .isEqualTo(DirectPayStatus_Title_CL)
                .withCustomReportMessage("Check that DirectPayStatus_Title_CL is correct")
                .perform();

        return this;
    }

    public BankDetails assertOnRefernzKontoPartExistanceAtMiddleOfConfirmationCard(){
        driver.verifyThat().element(refrenzkontoPartLocator).exists()
                .withCustomReportMessage("Assert ON Refernzkonto Existance at Confirmation Card")
                .perform();
        return this;
    }

    public BankDetails assertOnConfirmationWarningMessageAtEndOfTheCard(){
        driver.verifyThat().element(ConfirmationWarningMsg_Title).textTrimmed()
                .isEqualTo(ConfirmationWarningMsg_Title_CL)
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Title is correct")
                .perform();
        driver.verifyThat().element(ConfirmationWarningMsg_Body).textTrimmed()
                .isEqualTo(ConfirmationWarningMsg_Body_CL)
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Body is correct")
                .perform();
        return this;
    }

    public BankDetails assertOnBackEndErrorMessage(String errorHeadline, String errorBody){
        driver.verifyThat().element(backEndErrorHeadlineLocator).textTrimmed()
                .isEqualTo(errorHeadline)
                .withCustomReportMessage("assert On Error Headline")
                .perform();
        driver.verifyThat().element(backEndErrorBodyLocator).textTrimmed()
                .isEqualTo(errorBody)
                .withCustomReportMessage("assert On Error Body")
                .perform();
        return this;
    }

    public BankDetails assertOnServiceFailureMessage(String errorHeadline, String errorBody){
        driver.verifyThat().element(backEndErrorHeadlineLocator).textTrimmed()
                .isEqualTo(errorHeadline)
                .withCustomReportMessage("assert On Error Headline")
                .perform();
        driver.verifyThat().element(backEndErrorBodyLocator).textTrimmed()
                .isEqualTo(errorBody)
                .withCustomReportMessage("assert On Error Body")
                .perform();
        return this;
    }

    public BankDetails assertOnIbanDoesNotMatchContractedIban(String errorHeadline, String errorBody){
        driver.verifyThat().element(backEndErrorHeadlineLocator).textTrimmed()
                .isEqualTo(errorHeadline)
                .withCustomReportMessage("assert On Error Headline")
                .perform();
        String requiedSentence = driver.element().getText(backEndErrorBodyLocator);
        String modifiedString = deleteWords(requiedSentence,"0800 172 1212","an.");
        String latestString = modifiedString.trim();
        SHAFT.Validations.verifyThat().object(latestString).isEqualTo(errorBody)
                .withCustomReportMessage("assert On Error Body").perform();

        return this;
    }

    public BankDetails assertOnPartiallySuccessMessage(String errorHeadline, String errorBody){
        driver.verifyThat().element(backEndErrorHeadlineLocator).textTrimmed()
                .isEqualTo(errorHeadline)
                .withCustomReportMessage("assert On Error Headline")
                .perform();
        driver.verifyThat().element(backEndErrorBodyLocator).textTrimmed()
                .isEqualTo(errorBody)
                .withCustomReportMessage("assert On Error Body")
                .perform();
        return this;
    }

    public BankDetails assertThatSecondChangeBankDetailsButtonIsDimmed(){
        driver.verifyThat().element(EditSecondDebitBank_btn).isDisabled()
                .withCustomReportMessage("Asserting On Change Bank details Button is Dimmed")
                .perform();
        return this;
    }

    public BankDetails assertThatFirstChangeBankDetailsButtonIsDimmed(){
        driver.element().waitToBeReady(EditFirstDebitBank_btn);
        driver.verifyThat().element(EditFirstDebitBank_btn).isDisabled()
                .withCustomReportMessage("Asserting On Change Bank details Button is Dimmed")
                .perform();
        return this;
    }

    public BankDetails assertOnMultipleConfirmationMessage(){
        driver.verifyThat().element(MultiContract_SuccessMsg_Title).textTrimmed()
                .contains(MultiContract_SuccessMsg_Title_CL)
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Title is correct")
                .perform();
        driver.verifyThat().element(MultiContract_SuccessMsg_Body).textTrimmed()
                .contains(MultiContract_SuccessMsg_Body_CL1)
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Body is correct")
                .perform();
        driver.verifyThat().element(MultiContract_SuccessMsg_Body).textTrimmed()
                .contains(MultiContract_SuccessMsg_Body_CL2)
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Body is correct")
                .perform();
        driver.verifyThat().element(MultiContract_SuccessMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Icon is exist")
                .perform();
        return this;
    }

    public BankDetails ValidateFirstStepOfEditBankDetails() {
        driver.verifyThat().element(EditBankFirstStep_Title)
                .textTrimmed().isEqualTo(EditBankFirstStep_Title_CL)
                .withCustomReportMessage("Check that Edit Bank First Step Title is correct")
                .perform();
        driver.verifyThat().element(EditBankFirstStepHeader_Text).textTrimmed()
                .contains(EditBankFirstStepHeader_Text_CL)
                .withCustomReportMessage("Check that Edit Bank First Step Header Text is correct")
                .perform();
        driver.verifyThat().element(EditBankPage_Title).textTrimmed()
                .isEqualTo(EditBankPage_Title_CL)
                .withCustomReportMessage("Check that Edit Bank details Page Title is correct")
                .perform();
        driver.verifyThat().element(OwnerField_Title).textTrimmed()
                .contains(OwnerField_Title_CL)
                .withCustomReportMessage("Check that Owner Field Title is correct")
                .perform();
        driver.verifyThat().element(OwnerField)
                .exists()
                .withCustomReportMessage("Check that Owner field is exist")
                .perform();
        driver.verifyThat().element(IbanInputField_Title).textTrimmed()
                .isEqualTo(IbanInputField_Title_CL)
                .withCustomReportMessage("Check that IbanInputField Title is correct")
                .perform();
        driver.verifyThat().element(IbanInputField)
                .exists()
                .withCustomReportMessage("Check that Iban Input Field is exist")
                .perform();
        driver.verifyThat().element(IbanInputFieldBelow_Text).textTrimmed()
                .isEqualTo(IbanInputFieldBelow_Text_CL)
                .withCustomReportMessage("Check that text below Iban Input Field is correct")
                .perform();
        driver.verifyThat().element(FirstStepSubmit_btn).textTrimmed()
                .isEqualTo(FirstStepSubmit_btn_CL)
                .withCustomReportMessage("Check that text of First Step Submit btn is correct")
                .perform();
        driver.verifyThat().element(FirstStepSubmit_btn)
                .isDisabled()
                .withCustomReportMessage("Check that submit btn still dimmed until enter correct Iban")
                .perform();
        driver.element().type(IbanInputField,IBan);
        driver.verifyThat().element(FirstStepSubmit_btn)
                .isEnabled()
                .withCustomReportMessage("Check that submit btn became clickable")
                .perform();
        return  this;
    }
    public BankDetails ValidateSecondStepOfEditBankDetails() {
        driver.verifyThat().element(EditBankSecondStep_Title).textTrimmed()
                .isEqualTo(EditBankSecondStep_Title_CL)
                .withCustomReportMessage("Check that Edit Bank Second Step Title is correct")
                .perform();
        driver.verifyThat().element(EditBankSecondStepHeader_Text).textTrimmed()
                .contains(EditBankSecondStepHeader_Text_CL)
                .withCustomReportMessage("Check that Edit Bank Second Step Header Text is correct")
                .perform();
        driver.verifyThat().element(EditBankSecondStep_Title).textTrimmed()
                .isEqualTo(EditBankSecondStep_Title_CL)
                .withCustomReportMessage("Check that Edit Bank Second Step Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Title).textTrimmed()
                .isEqualTo(Iban_Title_CL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Title).textTrimmed()
                .isEqualTo(BIC_Title_CL)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Title).textTrimmed()
                .isEqualTo(Bank_Title_CL)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus_Title).textTrimmed()
                .isEqualTo(DirectPayStatus_Title_CL)
                .withCustomReportMessage("Check that DirectPayStatus_Title_CL is correct")
                .perform();
        driver.verifyThat().element(ReviewStepSubmit_btn).textTrimmed()
                .isEqualTo(ReviewStepSubmit_btn_CL)
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is correct")
                .perform();
        driver.verifyThat().element(EditFirstStep_btn).textTrimmed()
                .isEqualTo(EditFirstStep_btn_CL)
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Content).exists()
                .withCustomReportMessage("Check that ReviewStepIban_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Content).exists()
                .withCustomReportMessage("Check that ReviewStepBIC_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Content).exists()
                .withCustomReportMessage("Check that ReviewStepBank_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus).exists()
                .withCustomReportMessage("Check that ReviewStepDirectPayStatus is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Title).textTrimmed()
                .isEqualTo(Owner_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Content).exists()
                .withCustomReportMessage("Check that ReviewStepOwner_Content is exist")
                .perform();
        driver.verifyThat().element(ReviewStepSubmit_btn).textTrimmed()
                .isEqualTo(ReviewStepSubmit_btn_CL)
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is correct")
                .perform();
        driver.verifyThat().element(ReviewStepSubmit_btn)
                .isEnabled()
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is correct")
                .perform();
        return  this;
    }

    public BankDetails ValidateSecondStepOfEditBankDetailsWithSepaMandate() {
        driver.verifyThat().element(EditBankSecondStep_Title).textTrimmed()
                .isEqualTo(EditBankSecondStep_Title_CL)
                .withCustomReportMessage("Check that Edit Bank Second Step Title is correct")
                .perform();
        driver.verifyThat().element(EditBankSecondStepHeader_Text).textTrimmed()
                .contains(EditBankSecondStepHeader_Text_CL)
                .withCustomReportMessage("Check that Edit Bank Second Step Header Text is correct")
                .perform();
        driver.verifyThat().element(EditBankSecondStep_Title).textTrimmed()
                .isEqualTo(EditBankSecondStep_Title_CL)
                .withCustomReportMessage("Check that Edit Bank Second Step Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Title).textTrimmed()
                .isEqualTo(Iban_Title_CL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Title).textTrimmed()
                .isEqualTo(BIC_Title_CL)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Title).textTrimmed()
                .isEqualTo(Bank_Title_CL)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus_Title).textTrimmed()
                .isEqualTo(DirectPayStatus_Title_CL)
                .withCustomReportMessage("Check that DirectPayStatus_Title_CL is correct")
                .perform();
        driver.verifyThat().element(ReviewStepSubmit_btn).textTrimmed()
                .isEqualTo(ReviewStepSubmit_btn_CL)
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is correct")
                .perform();
        driver.verifyThat().element(EditFirstStep_btn).textTrimmed()
                .isEqualTo(EditFirstStep_btn_CL)
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Content).exists()
                .withCustomReportMessage("Check that ReviewStepIban_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Content).exists()
                .withCustomReportMessage("Check that ReviewStepBIC_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Content).exists()
                .withCustomReportMessage("Check that ReviewStepBank_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus).exists()
                .withCustomReportMessage("Check that ReviewStepDirectPayStatus is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Title).textTrimmed()
                .isEqualTo(Owner_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Content).exists()
                .withCustomReportMessage("Check that ReviewStepOwner_Content is exist")
                .perform();
        driver.verifyThat().element(ReviewStepSubmit_btn).textTrimmed()
                .isEqualTo(ReviewStepSubmit_btn_CL)
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is correct")
                .perform();
        driver.verifyThat().element(ReviewStepSubmit_btn)
                .isDisabled()
                .withCustomReportMessage("Check that ReviewStepSubmit_btn_CL is Disabled")
                .perform();
        return  this;
    }

    public BankDetails ValidateInvoiceChooserPage() {
        driver.verifyThat().element(EditBankInvoiceChooserAcc_Title).textTrimmed()
                .isEqualTo(EditBankInvoiceChooserAcc_Title_CL)
                .withCustomReportMessage("Check that EditBankInvoiceChooserAcc Title is correct")
                .perform();
        driver.verifyThat().element(EditBankInvoiceChooserHeader_Text).textTrimmed()
                .isEqualTo(EditBankInvoiceChooserHeader_Text_CL)
                .withCustomReportMessage("Check that EditBankInvoiceChooserHeader Text is correct")
                .perform();
        driver.verifyThat().element(EditBankPage_Title).textTrimmed()
                .isEqualTo(EditBankPage_Title_CL)
                .withCustomReportMessage("Check that EditBankInvoiceChooserPage_Title Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Title).textTrimmed()
                .isEqualTo(Owner_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Title).textTrimmed()
                .isEqualTo(Iban_Title_CL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Title).textTrimmed()
                .isEqualTo(BIC_Title_CL)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Title).textTrimmed()
                .isEqualTo(Bank_Title_CL)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus_Title).textTrimmed()
                .isEqualTo(DirectPayStatus_Title_CL)
                .withCustomReportMessage("Check that DirectPayStatus_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceProdSection_Title).textTrimmed()
                .isEqualTo(ProdSection_Title_CL)
                .withCustomReportMessage("Check that Product Section_Title_CL is correct")
                .perform();
        driver.verifyThat().element(EditBankFirstInvoice_btn).textTrimmed()
                .isEqualTo(EditBank_Btn_CL)
                .withCustomReportMessage("Check that Product EditBank_Btn_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Content)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceOwner_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Content)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceIban_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Content)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceBIC_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Content)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceBank_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceDirectPayStatus is exist")
                .perform();
        driver.verifyThat().element(FirstInvoice_Number)
                .exists()
                .withCustomReportMessage("Check that FirstInvoice_Number is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceProduct_Name)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceProduct_Name is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceProduct_Icon)
                .exists()
                .withCustomReportMessage("Check that FirstInvoiceProduct_Icon is exist")
                .perform();
        driver.verifyThat().element(SecondInvoiceOwner_Title).textTrimmed()
                .isEqualTo(Owner_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
        driver.verifyThat().element(SecondInvoiceIban_Title).textTrimmed()
                .isEqualTo(Iban_Title_CL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
        driver.verifyThat().element(SecondInvoiceBIC_Title).textTrimmed()
                .isEqualTo(BIC_Title_CL)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
        driver.verifyThat().element(SecondInvoiceBank_Title).textTrimmed()
                .isEqualTo(Bank_Title_CL)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
        driver.verifyThat().element(SecondInvoiceDirectPayStatus_Title).textTrimmed()
                .isEqualTo(DirectPayStatus_Title_CL)
                .withCustomReportMessage("Check that DirectPayStatus_Title_CL is correct")
                .perform();
        driver.verifyThat().element(SecondInvoiceProdSection_Title).textTrimmed()
                .isEqualTo(ProdSection_Title_CL)
                .withCustomReportMessage("Check that Product Section_Title_CL is correct")
                .perform();
        driver.verifyThat().element(EditBankSecondInvoice_btn).textTrimmed()
                .isEqualTo(EditBank_Btn_CL)
                .withCustomReportMessage("Check that Product EditBank_Btn_CL is correct")
                .perform();
        driver.verifyThat().element(SecondInvoiceOwner_Content)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceOwner_Content is exist")
                .perform();
        driver.verifyThat().element(SecondInvoiceIban_Content)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceIban_Content is exist")
                .perform();
        driver.verifyThat().element(SecondInvoiceBIC_Content)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceBIC_Content is exist")
                .perform();
        driver.verifyThat().element(SecondInvoiceBank_Content)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceBank_Content is exist")
                .perform();
        driver.verifyThat().element(SecondInvoiceDirectPayStatus)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceDirectPayStatus is exist")
                .perform();
        driver.verifyThat().element(SecondInvoice_Number)
                .exists()
                .withCustomReportMessage("Check that SecondInvoice_Number is exist")
                .perform();
        driver.verifyThat().element(SecondInvoiceProduct_Name)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceProduct_Name is exist")
                .perform();
        driver.verifyThat().element(SecondInvoiceProduct_Icon)
                .exists()
                .withCustomReportMessage("Check that SecondInvoiceProduct_Icon is exist")
                .perform();
        return  this;
    }


    public BankDetails ValidateConfirmationAccordionDetails() {
        driver.verifyThat().element(ConfirmedDetailsAcc_Title).textTrimmed()
                .isEqualTo(ConfirmedDetailsAcc_Title_CL)
                .withCustomReportMessage("Check that ConfirmedDetailsAcc_Title is correct")
                .perform();
        driver.verifyThat().element(ConfirmedDetailsText_Header).textTrimmed()
                .contains(ConfirmedDetailsText_Header_CL)
                .withCustomReportMessage("Check that ConfirmedDetailsText_Header is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Title).textTrimmed()
                .isEqualTo(Iban_Title_CL)
                .withCustomReportMessage("Check that Iban_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Title).textTrimmed()
                .isEqualTo(BIC_Title_CL)
                .withCustomReportMessage("Check that BIC_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Title).textTrimmed()
                .isEqualTo(Bank_Title_CL)
                .withCustomReportMessage("Check that Bank_Title is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus_Title).textTrimmed()
                .isEqualTo(DirectPayStatus_Title_CL)
                .withCustomReportMessage("Check that DirectPayStatus_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Content)
                .exists()
                .withCustomReportMessage("Check that ConfirmedDetailsIban_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBIC_Content)
                .exists()
                .withCustomReportMessage("Check that ConfirmedDetailsBIC_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceBank_Content)
                .exists()
                .withCustomReportMessage("Check that ConfirmedDetailsBank_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceDirectPayStatus)
                .exists()
                .withCustomReportMessage("Check that ConfirmedDetailsDirectPayStatus is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Title).textTrimmed()
                .isEqualTo(Owner_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoiceIban_Content)
                .exists()
                .withCustomReportMessage("Check that ConfirmedDetailsIban_Content is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceOwner_Content)
                .exists()
                .withCustomReportMessage("Check that ConfirmedDetailsOwner_Content is exist")
                .perform();
        return this;
    }


    public BankDetails ValidateConfirmationSuccessForSingleContract() {
        driver.verifyThat().element(SingleContract_SuccessMsg_Title).textTrimmed()
                .isEqualTo(SingleContract_SuccessMsg_Title_CL)
                .withCustomReportMessage("Check that SingleContract_SuccessMsg_Title is correct")
                .perform();
        driver.verifyThat().element(SingleContract_SuccessMsg_Body).textTrimmed()
                .contains(SingleContract_SuccessMsg_Body_CL)
                .withCustomReportMessage("Check that SingleContract_SuccessMsg_Body is correct")
                .perform();
        driver.verifyThat().element(SingleContract_SuccessMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that SingleContract_SuccessMsg_Icon is exist")
                .perform();
        driver.verifyThat().element(ConfirmationWarningMsg_Title).textTrimmed()
                .isEqualTo(ConfirmationWarningMsg_Title_CL)
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Title is correct")
                .perform();
        driver.verifyThat().element(ConfirmationWarningMsg_Body).textTrimmed()
                .isEqualTo(ConfirmationWarningMsg_Body_CL)
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Body is correct")
                .perform();
        driver.verifyThat().element(ConfirmationWarningMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Icon is exist")
                .perform();
        driver.element().click(ConfirmedDetailsAcc_Title);
        return this;
    }
    public BankDetails ValidateConfirmationSuccessForMultiContracts() {
        driver.verifyThat().element(MultiContract_SuccessMsg_Title).textTrimmed()
                .contains(MultiContract_SuccessMsg_Title_CL)
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Title is correct")
                .perform();
        driver.verifyThat().element(MultiContract_SuccessMsg_Body).textTrimmed()
                .contains(MultiContract_SuccessMsg_Body_CL1)
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Body is correct")
                .perform();
        driver.verifyThat().element(MultiContract_SuccessMsg_Body).textTrimmed()
                .contains(MultiContract_SuccessMsg_Body_CL2)
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Body is correct")
                .perform();
        driver.verifyThat().element(MultiContract_SuccessMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that MultiContract_SuccessMsg_Icon is exist")
                .perform();
        driver.verifyThat().element(ConfirmationWarningMsg_Title).textTrimmed()
                .contains(ConfirmationWarningMsg_Title_CL)
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Title is correct")
                .perform();
        driver.verifyThat().element(ConfirmationWarningMsg_Body).textTrimmed()
                .contains(ConfirmationWarningMsg_Body_CL)
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Body is correct")
                .perform();
        driver.verifyThat().element(ConfirmationWarningMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that ConfirmationWarningMsg_Icon is exist")
                .perform();
        return this;
    }
    public BankDetails ValidateConfirmationPartiallyFailMessage() {
        driver.verifyThat().element(PartFailMsg_Title).textTrimmed()
                .isEqualTo(PartFailMsg_Title_CL)
                .withCustomReportMessage("Check that PartFailMsg_Title is correct")
                .perform();
        driver.verifyThat().element(PartFailMsg_Body).textTrimmed()
                .contains(PartFailMsg_Body_CL1)
                .withCustomReportMessage("Check that PartFailMsg_Body is correct")
                .perform();
        driver.verifyThat().element(PartFailMsg_Body).textTrimmed()
                .contains(PartFailMsg_Body_CL2)
                .withCustomReportMessage("Check that PartFailMsg_Body is correct")
                .perform();
        driver.verifyThat().element(PartFailMsg_Body).textTrimmed()
                .contains(PartFailMsg_Body_CL3)
                .withCustomReportMessage("Check that PartFailMsg_Body is correct")
                .perform();
        driver.verifyThat().element(PartFailMsg_Body).textTrimmed()
                .contains(PartFailMsg_Body_CL4)
                .withCustomReportMessage("Check that PartFailMsg_Body is correct")
                .perform();
        driver.verifyThat().element(PartFailMsg_Body).textTrimmed()
                .contains(PartFailMsg_Body_CL5)
                .withCustomReportMessage("Check that PartFailMsg_Body is correct")
                .perform();
        driver.verifyThat().element(PartFailMsg_Body).textTrimmed()
                .contains(PartFailMsg_Body_CL6)
                .withCustomReportMessage("Check that PartFailMsg_Body is correct")
                .perform();
        driver.verifyThat().element(PartFailMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that PartFailMsg_Icon is exist")
                .perform();
        return this;
    }
    public BankDetails ValidateConfirmationAllFailedMessage() {
        driver.verifyThat().element(AllFailMsg_Title).textTrimmed()
                .isEqualTo(AllFailMsg_Title_CL)
                .withCustomReportMessage("Check that AllFailMsg_Title is correct")
                .perform();
        driver.verifyThat().element(AllFailMsg_Body).textTrimmed()
                .isEqualTo(AllFailMsg_Body_CL)
                .withCustomReportMessage("Check that AllFailMsg_Body is correct")
                .perform();
        driver.verifyThat().element(AllFailMsg_Icon)
                .exists()
                .withCustomReportMessage("Check that AllFailMsg_Icon is exist")
                .perform();
        return this;
    }
    public BankDetails ValidateInvoiceProductsDetails() {
        driver.verifyThat().element(FirstInvoiceProdSection_Title).textTrimmed()
                .isEqualTo(ProdSection_Title_CL)
                .withCustomReportMessage("Check that Product Section_Title_CL is correct")
                .perform();
        driver.verifyThat().element(FirstInvoice_Number)
                .exists()
                .withCustomReportMessage("Check that ReviewStepInvoice_Number is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceProduct_Name)
                .exists()
                .withCustomReportMessage("Check that ReviewStepProduct_Name is exist")
                .perform();
        driver.verifyThat().element(FirstInvoiceProduct_Icon)
                .exists()
                .withCustomReportMessage("Check that ReviewStepProduct_Icon is exist")
                .perform();
        return this;
    }
    public BankDetails ValidateIBanRegex (){
        driver.verifyThat().element(FirstStepSubmit_btn)
                .isDisabled()
                .withCustomReportMessage("Check that submit btn still dimmed until enter correct Iban")
                .perform();
        driver.element().type(IbanInputField,IncompletedIban);
        driver.element().doubleClick(info_Icon);
        driver.element().isElementDisplayed(WrongIbanInline_Error);
        driver.verifyThat().element(WrongIbanInline_Error).textTrimmed()
                .isEqualTo(WrongIbanInline_Error_CL)
                .withCustomReportMessage("Check that Text inline error message is correct")
                .perform();
        driver.element().type(IbanInputField,TooLongIban);
        driver.verifyThat().element(WrongIbanInline_Error).textTrimmed()
                .isEqualTo(WrongIbanInline_Error_CL)
                .withCustomReportMessage("Check that Text inline error message is correct")
                .perform();
        driver.element().type(IbanInputField,WrongFormatIBan);
        driver.verifyThat().element(WrongIbanInline_Error).textTrimmed()
                .isEqualTo(WrongIbanInline_Error_CL)
                .withCustomReportMessage("Check that Text inline error message is correct")
                .perform();
        driver.element().type(IbanInputField,IBan);
        driver.verifyThat().element(FirstStepSubmit_btn)
                .isEnabled()
                .withCustomReportMessage("Check that submit btn Became clickable")
                .perform();
        return this;
    }

    public BankDetails ValidateWrongIbanRegex () {
        driver.element().type(IbanInputField,WrongIBan);
        driver.verifyThat().element(FirstStepSubmit_btn)
                .isEnabled()
                .withCustomReportMessage("Check that submit btn Became clickable")
                .perform();
        SubmitFirstStepOfEditBank();
        driver.verifyThat().element(WrongIbanMSg_Title).textTrimmed()
                .isEqualTo(WrongIbanMSg_Title_CL)
                .withCustomReportMessage("Check that title of wrong iban message is correct")
                .perform();
        driver.verifyThat().element(WrongIbanMSg_Body).textTrimmed()
                .isEqualTo(WrongIbanMSg_Body_CL)
                .withCustomReportMessage("Check that Body of wrong iban message is correct")
                .perform();
        driver.verifyThat().element(WrongIbanMSg_Icon)
                .exists()
                .withCustomReportMessage("Check that WrongIbanMSg_Icon is exist")
                .perform();
        driver.verifyThat().element(FirstStepSubmit_btn)
                .isDisabled()
                .withCustomReportMessage("Check that submit btn still dimmed until enter correct Iban")
                .perform();
        return this;
    }
    public BankDetails clickBackButton(){
        driver.element().isElementClickable(backButton);
        driver.element().click(backButton);
        return this;
    }
    public BankDetails selectEditBtnInvoiceChooser(){
        driver.element().isElementClickable(secondEditBtnInvoiceChooser);
        driver.element().click(secondEditBtnInvoiceChooser);
        return this;
    }
    public BankDetails clickEditOneByOneInvoicesBtn1(){
        driver.element().isElementClickable(EditOneByOneInvoices_LinkOut1);
        driver.element().click(EditOneByOneInvoices_LinkOut1);
        return this;
    }
    public BankDetails clickEditOneByOneInvoicesBtn2(){
        driver.element().isElementClickable(EditOneByOneInvoices_LinkOut2);
        driver.element().click(EditOneByOneInvoices_LinkOut2);
        return this;
    }
    @Step("Expand Confirmation Details Section")
    public BankDetails expandConfirmationDetailsSection(){
        driver.element().click(ConfirmedDetailsAcc_Title);
        return this;
    }

    public BankDetails clickOnConfirmedDetailsAcc_Title(){
        driver.element().click(ConfirmedDetailsAcc_Title);
        return this;
    }

    public BankDetails validateSecondStepInCaseOfSOHO(){
        driver.verifyThat()
                .element(FirstInvoiceOwner_Title).textTrimmed()
                .isEqualTo(Owner_Title_CL)
                .withCustomReportMessage("Check that Owner_Title_CL is correct")
                .perform();

        driver.verifyThat().element(FirstInvoiceOwner_Content).exists()
                .withCustomReportMessage("Check that ReviewStepOwner_Content is exist")
                .perform();
        return this;
    }

}
