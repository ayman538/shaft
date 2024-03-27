package de.vodafone.pages.Kabledeutschland;
import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import io.qameta.allure.Step;


public class Phonebook {
    private SHAFT.GUI.WebDriver driver;
    //CLs
    private static String phonebook_PageTitleCL = "Telefonbuch-Eintrag";
    private static String phonebook_Add_firstStep_TitleCL = "Persönliche Daten";
    private static String phonebook_Add_secondStep_TitleCL = "Telefonbuch-Einträge";
    private static String phonebook_Add_thirdStep_TitleCL = "Daten überprüfen und senden";
    private static String phonebook_ContainerTitleCL = "Persönliche Daten";
    private static String phonebook_Container_FirstTextCL1 = "Du kannst hier Deinen Telefonbuch-Eintrag anlegen, ändern oder löschen.";
    private static String phonebook_Container_FirstTextCL2 = "Für gedruckte Verzeichnisse, die Telefonauskunft und für elektronische Medien.";
    private static String warningMsgTitleCL = "Die hier nicht aufgeführten Rufnummern werden nicht eingetragen oder geändert.";
    private static String phonebook_Add_thirdStep_2ndSubTitleCL = "Telefonbuch-Einträge";
    private static String warningMsgTextCL = "Wichtig: Du erteilst damit einen verbindlichen Auftrag an Drittanbieter. Es sind keine Einstellungen in MeinVodafone, die Du schnell wieder ändern kannst. Der Telefonbuch-Eintrag einer Rufnummer und die Löschung sind kostenlos. Jeder weitere Eintrag oder eine Änderung sind kostenpflichtig. Die Preise findest Du in der Preisliste.";
    private static String phonebook_Container_SecondTextCL1 = "Wichtig:";
    private static String phonebook_Container_SecondTextCL2 = "Der Eintrag einer Nummer ist kostenlos.";
    private static String phonebook_Container_SecondTextCL3 = "Jede weitere Nummer ist kostenpflichtig. Die Preise findest Du in der Preisliste.";
    private static String titleValue_Change = "Title";
    private static String firstNameField_valueChange = "Nahla";
    private static String lastNameField_valueChange = "Mosaad";
    private static String titleField_TitleCL = "Titel";
    private static String firstNameField_TitleCL = "Vorname oder Firma *";
    private static String firstNameField_TitleCLRS = "Vorname oder Firma";
    private static String lastNameField_TitleCLRS = "Nachname oder Ansprechpartner";
    private static String wrongTitle_value= "TitleTitleTitleTitleTitle 4";
    private static String wrongSecond_value= "Company1 Name";
    private static String wrongThird_value= "Contact Perspn@Nahla";
    private static String lastNameField_TitleCL = "Nachname oder Ansprechpartner *";
    private static String companyField_TitleCL = "Vorname oder Firma *";
    private static String contactPersonField_TitleCL = "Nachname oder Ansprechpartner *";
    private static String titleField_RegexCL = "Gib bitte Deinen Titel ein. Erlaubt sind max. 20 Zeichen.";
    private static String firstNameField_RegexCL = "Erlaubt sind max. 30 Zeichen.";
    private static String lastNameField_RegexCL = "Erlaubt sind max. 80 Zeichen.";
    private static String companyField_RegexCL = "Erlaubt sind max. 30 Zeichen.";
    private static String contactPersonField_RegexCL = "Erlaubt sind max. 80 Zeichen.";
    private static String streetandHouseNumberField_TitleCL = "Straße und Hausnummer (Postfach)";
    private static String cityField_TitleCL = "PLZ und Ort";
    private static String cityField_TextCL = "91413 Neustadt";
    private static String error_MSG_TitleCL = "Das hat leider nicht geklappt";
    private static String error_MSG_TextCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String successMsgTextCL1 = "Dein Telefonbuch-Eintrag wurde gespeichert.";
    private static String successMsgTextCL2 = "Es kann noch wenige Minuten dauern,  bis Du den Eintrag siehst.";
    private static String successMsgTitleCL = "Geschafft";
    private static String streetandHouseNumberField_TextCL  = "Zeppelinstr 3";
    private static String title_value_Change="Eng";
    private static String second_value_Change="nahla";
    private static String third_value_Change="mosaad";
    private static String contactPersonInfoIconTextCL1 = "Gib hier Deinen Nachnamen oder den Ansprechpartner Deiner Firma ein.";
    private static String contactPersonInfoIconTextCL2 = "Erlaubt sind max. 80 Zeichen.";
    private static String titleFieldInfoIconCL  = "Gib hier Deinen Titel ein, z.B. \"Dr.\" oder \"M. Eng.“ . Erlaubt sind max. 20 Zeichen.";
    private static String  invalidTitleValue= "NahlaNahlaNahlaNahlaNahla";
    private static String firmaFieldInfoIconTextCL = "Gib hier Deinen Vornamen oder den Namen Deiner Firma ein. Erlaubt sind max. 30 Zeichen.";
    private static String invalidFNameValue ="NahlaNahlaNahla Nahl33333aNahlaaaNahlaNahla";
    private static String invalidLNameValue ="NahlaNahlaNahlaNahlaNahlaNahlaaaNahlaNahlaNahlaNahlaNahlaNahlaNahlaNahlaaaNahlaNahlaNahlaNahlaNahlaNahlaNahlaNahlaaaNahla NahlaN222hlaNahlaNahlaNahlaNahlaaaNahlaNahla";
    private static String invalidCompanyValue ="NahlaNahlaNahla Nahl33333aNahlaaaNahlaNahla";
    private static String invalidCPValue ="NahlaNahlaNahlaNahlaNahlaNahlaaaNahlaNahlaNahlaNahlaNahlaNahlaNahlaNahlaaaNahlaNahlaNahlaNahlaNahlaNahlaNahlaNahlaaaNahla NahlaN222hlaNahlaNahlaNahlaNahlaaaNahlaNahla";
    private static String mandatoryWordCL = "Pflichtfeld";
    private static String stepThree_Add_AccTitleCL = "Daten überprüfen und senden";
    private static String secondStep_FirstQTitleCL = "Wie soll Deine Rufnummer eingetragen werden?";
    private static String telephone_RadioBtn_TextCL = "Als Telefon";
    private static String fax_RadioBtn_TextCL = "Als Fax";
    private static String faxAndTelephone_RadioBtn_TextCL = "Als Telefon und Fax";
    private static String entrTypeFieldCL = "Eintragsart *";
    private static String entrTypeField_TextCL = "Bitte wählen";
    private static String entrTypeField_Op1CL = "in gedruckte & elekronische Verzeichnisse";
    private static String entrTypeField_Op2CL = "in gedruckte Verzeichnisse";
    private static String secondQuestionCL = "Inverssuche zulassen?";
    private static String secondQuestionC_ChechboxCL = "Ich stimme zu, dass man mich über meine Nummer im Online-Telefonbuch finden kann.";
    private static String thirdQuestionCL = "Adresse veröffentlichen?";
    private static String thirdQuestion_CheckboxCL = "Ich stimme zu, dass meine Adresse veröffentlicht wird.";
    private static String title_value="Title";
    private static String title_value_change="Eng";
    private static String  second_value_change  = "nahla";
    private static String  third_value_change = "mosaad";

    private static String second_value="Company FirstName";
    private static String third_value ="ContactPerson LastName";
    private static String salutationValue = "Firma";
    private static String addressValue = "Zeppelinstr 3";
    private static String postalValue = "91413 Neustadt";
    private static String entryTypeValue = "In gedruckte & elektronische Verzeichnisse";
    private static String  secondQuestionReviewCL = "Ja";
    private static String  thirdQuestionReviewCLFirmaCase = "Nein";
    private static String  secondQuestionReviewCLFirmaCase = "Nein";
    private static String thirdQuestionReviewCL = "Ja";

    //Locators
    private static final By phonebook_PageTitle = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private static final By phonebook_Add_firstStep_Title = By.xpath("//div[@automation-id='step1_containertv']//div[2]");
    private static final By phonebook_Add_secondStep_Title = By.xpath("//div[@automation-id='step2_containertv']");
    private static final By secondStep_FirstQTitle = By.xpath("//*[@id='stepper-component-step-1']//activate-phone-book-step-two/div/h4");
    private static final By change_SecondStep_FirstQTitle = By.xpath("//step[@id='stepper-component-step-1']//edit-phone-book-step-two/div/h4");

    private static final By secondStep_FirstQ_Telephone = By.xpath("(//ol-radio[@automation-id='limitedItemizedRadio_rb'])[1]");
    private static final By secondStep_FirstQ_TelephoneAndFax = By.xpath("(//ol-radio[@automation-id='limitedItemizedRadio_rb'])[3]");
    private static final By secondStep_FirstQ_Fax = By.xpath("(//ol-radio[@automation-id='limitedItemizedRadio_rb'])[2]");
    private static final By entryTypeFieldTitle = By.xpath("(//label[@for='entryType'])");
    private static final By warningMsgTitle = By.xpath("//p[@automation-id='info_field_tv']");
    private static final By warningMsgText = By.xpath("//div[@automation-id='activate_phonebook_notification_success_nt']//p");
    private static final By secondQuestion_Title = By.xpath("//h4[@automation-id='reverseSearchText_tv']");
    private static final By change_SecondQuestion_Title = By.xpath("//*[@automation-id='reverseSearchText_tv']");
    private static final By change_ThirdQuestion_Title = By.xpath("//*[@automation-id='publishAddressText_tv']");

    private static final By secondQuestion_Text = By.xpath("(//div[@automation-id='checkboxItemModel.id_label_tv'])[1]");
    private static final By thirdQuestion_Title = By.xpath("//h4[@automation-id='publishAddressText_tv']");
    private static final By thirdQuestion_Text = By.xpath("(//div[@automation-id='checkboxItemModel.id_label_tv'])[2]");
    private static final By thirdQ_Checkbox = By.xpath("(//span[@class='span-box'])[2]");
    private static final By phonebook_Add_thirdStep_1stSubTitle = By.xpath("(//div[@class='mb-20']//h3)[1]");
    private static final By phonebook_Add_thirdStep_2ndSubTitle = By.xpath("(//div[@class='mb-20']//h3)[2]");
    private static final By entryTypeReviewStep = By.xpath("(//*[@automation-id='review_entryType_tv']//p)[2]");
    private static final By secondStep_firstQReview = By.xpath("(//p[@automation-id='review_allowReverseSearch_tv'])");
    private static final By secondQuestionReview = By.xpath("(//div[@automation-id='review_allowReverseSearch_tv'])[1]//p[2]");
    private static final By thirdQuestionReview = By.xpath("(//div[@automation-id='review_allowReverseSearch_tv'])[2]//p[2]");
    private static final By titelValue_ReviewStep = By.xpath("//div[@automation-id='review_title_tv']//p[2]");
    private static final By firstfieldReviewStep = By.xpath("//div[@automation-id='review_firstName_tv']//p[2]");
    private static final By secondfieldReviewStep = By.xpath("//div[@automation-id='review_lastName_tv']//p[2]");
    private static final By address_ReviewStep = By.xpath("//div[@automation-id='review_address_tv']//p[2]");
    private static final By postalCode_ReviewStep = By.xpath("//div[@automation-id='review_postal_tv']//p[2]");

    private static final By phonebook_Add_thirdStep_Title = By.xpath("//div[@automation-id='step3_containertv']//div[2]");
    private static final By notFirmaSalutationOption = By.xpath("(//select[@automation-id='salutation_lv']//option)[3]");
    private static final By firmaSalutationOption = By.xpath("(//select[@automation-id='salutation_lv']//option)[4]");
    private static final By continue_Btn = By.xpath("//button[@automation-id='activae_phoneBook_btn']");
    private static final By mandatoryWord = By.xpath("//span[@automation-id='requiredLabel_tv']");
    private static final By PostalCodeField_Title = By.xpath("//label[@automation-id='postalLable_tv']");
    private static final By postalCodeField_Text = By.xpath("//div[@automation-id='postalValue_tv']");
    private static final By postalCodeField_Box = By.xpath("//div[@automation-id='postalValue_tv']");
    private static final By lastNameField_Title = By.xpath("//label[@for='text' and contains (text(),'Nachname')]");
    private static final By firstNameField_Title = By.xpath("//label[@for='text' and contains (text(),'Vorname')]");
    private static final By streetandHouseNumberField_Box = By.xpath("//div[@automation-id='addressValue_tv']");
    private static final By streetandHouseNumberField_Title = By.xpath("//label[@automation-id='addressLable_tv']");
    private static final By contactPersonField_Regex = By.xpath("//p[@automation-id='lastName_patternErrorMessage_et']");
    private static final By companyField_Regex = By.xpath("//p[@automation-id='firstName_patternErrorMessage_et']");
    private static final By lastNameField_Regex = By.xpath("//p[@automation-id='lastName_patternErrorMessage_et']");
    private static final By firstNameField_Regex = By.xpath("//p[@automation-id='firstName_patternErrorMessage_et']");
    private static final By titleField_Regex = By.xpath("//p[@automation-id=\"title_patternErrorMessage_et\"]");

    private static final By contactPersonField_Title = By.xpath("//label[@for='text' and contains (text(),'Ansprechpartner')]");
    private static final By companyField_Title = By.xpath("//label[@for='text' and contains (text(),'Firma')]");
    private static final By salutationField_Title = By.xpath("(//div[@class='fm-data']//label)[2]");
    private static final By titleField_Title = By.xpath("//label[@for='text' and contains (text(),'Titel')]");
    private static final By titleField_textbox = By.xpath("//input[@automation-id='title_et']");
    private static final By firstNameField_TextBox = By.xpath("//input[@automation-id='firstName_et']");
    private static final By lastNameField_textbox = By.xpath("//input[@automation-id='lastName_et']");
    private static final By titleFieldInfoIcon = By.xpath("(//div[@automation-id='undefinedInfoIcon_tv']//a)[2]");
    private static final By titleFieldInfoIconText = By.xpath("(//p[@automation-id='undefined_tv'])[1]");
    private static final By firmaFieldInfoIconText = By.xpath("(//p[@automation-id='undefined_tv'])[2]");
    private static final By contactPersonInfoIconText = By.xpath("(//p[@automation-id='undefined_tv'])[3]");
    private static final By firmaFieldInfoIcon = By.xpath("(//div[@automation-id='undefinedInfoIcon_tv']//a)[3]");
    private static final By contactPerspnInfoIcon = By.xpath("(//div[@automation-id='undefinedInfoIcon_tv']//a)[5]");
    private static final By companyField_textbox = By.xpath("//input[@automation-id='firstName_et']");
    public static final By error_MSG_Title = By.xpath("//div[@automation-id='undefined_nt']//div[@class=\"item-2 w-100\"]");
    public static final By error_MSG_text = By.xpath("//div[@automation-id='successMsg_tv']//p");
    public static final By error_MSG_Title_ChangePhonebook = By.xpath("//div[@automation-id='undefined_nt']//h4");
    public static final By error_MSG_Text_ChangePhonebook = By.xpath("//div[@automation-id='undefined_nt']//p");
    public static final By successMsgTitle = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    public static final By successMsgText = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private static final By contactPersonField_textbox = By.xpath("//input[@automation-id='lastName_et']");
    private static final By telephone_RadioBtn = By.xpath("(//div[@class='bgdiv'])[1]");
    private static final By fax_RadioBtn = By.xpath("");
    private static final By telephoneaAndFax_RadioBtn = By.xpath("");
    private static final By entryTypeField_DDL = By.xpath("//*[@automation-id='entryType_lv']");
    private static final By phonebook_Container_SecondText = By.xpath("//*[@id=\"stepper-component-step-0\"]//activate-phone-book-step-one/div/p[2]");
    private static final By phonebook_Container_FirstText = By.xpath("//*[@id='stepper-component-step-0']//activate-phone-book-step-one/div/p[1]");
    private static final By changephonebook_Container_FirstText = By.xpath("(//step[@id='stepper-component-step-0']//div)[9]");
    private static final By changephonebook_Container_secondText = By.xpath("(//step[@id='stepper-component-step-0']//div)[10]");

    private static final By entryTypeField_DDL_secondOp = By.xpath("(//*[@automation-id='entryType_lv']//option)[2]");
    private static final By secondStep_ContinueBtn = By.xpath("(//button[@automation-id='change_address_btn'])");
    private static final By thirdstepConfirmbutton = By.xpath("//button[@automation-id='addPhoneBook_btn' and contains(text(),' Verbindlich beauftragen')]");
    private static final By thirdstep_Change_Confirmbutton = By.xpath("//button[@automation-id='editPhoneBook_btn']");
    private static final By firstNameField_TitleReviewStep = By.xpath("//div[@automation-id='review_firstName_tv']/p[1]");
    private static final By lastNameField_TitleReviewStep = By.xpath("//div[@automation-id='review_lastName_tv']/p[1]");

    //Methods
    /*constructor*/
    public Phonebook(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }
    @Step("validate the regex of not firma case fields")
    public Phonebook validateRegexofNOTFirma ()
    {

        driver.element().isElementDisplayed(titleField_Regex);
        driver.verifyThat().element(titleField_Regex)
                .textTrimmed().isEqualTo(titleField_RegexCL)
                .withCustomReportMessage("Validate regex of title field")
                .perform();
        driver.element().isElementDisplayed(firstNameField_Regex);
        driver.verifyThat().element(firstNameField_Regex)
                .textTrimmed().isEqualTo(firstNameField_RegexCL)
                .withCustomReportMessage("Validate regex of firstname field")
                .perform();
        driver.element().isElementDisplayed(lastNameField_Regex);
        driver.verifyThat().element(lastNameField_Regex)
                .textTrimmed().isEqualTo(lastNameField_RegexCL)
                .withCustomReportMessage("Validate regex of lastname field")
                .perform();
        return this;
    }
    @Step("validate the regex of firma case fields")
    public Phonebook validateRegexofFirma () {
        driver.element().type(firstNameField_TextBox,invalidCompanyValue);
        driver.element().type(lastNameField_textbox,invalidCPValue);
        driver.element().isElementDisplayed(contactPersonField_Regex);
        driver.verifyThat().element(contactPersonField_Regex)
                .textTrimmed().isEqualTo(contactPersonField_RegexCL)
                .withCustomReportMessage("Validate regex of contact person field")
                .perform();
        driver.verifyThat().element(companyField_Regex)
                .textTrimmed().isEqualTo(companyField_RegexCL)
                .withCustomReportMessage("Validate regex of company field")
                .perform();
        return this;
    }
    @Step("Validate the view of Firma Case in Adding new Phonebook Settings")
    public Phonebook validatePhoneBookPageFirmaCase()
    {
        driver.verifyThat().element(phonebook_Add_firstStep_Title)
                .textTrimmed().isEqualTo(phonebook_Add_firstStep_TitleCL)
                .withCustomReportMessage("Validate first step title")
                .perform();
        driver.verifyThat().element(phonebook_PageTitle)
            .textTrimmed().isEqualTo(phonebook_PageTitleCL)
            .withCustomReportMessage("Validate page title")
            .perform();

        driver.verifyThat().element(phonebook_Container_FirstText)
                .textTrimmed().contains(phonebook_Container_FirstTextCL1)
                .withCustomReportMessage("Validate first text in first step")
                .perform();
        driver.verifyThat().element(phonebook_Container_FirstText)
                .textTrimmed().contains(phonebook_Container_FirstTextCL2)
                .withCustomReportMessage("Validate first text in first step")
                .perform();

        driver.verifyThat().element(phonebook_Container_SecondText)
                .textTrimmed().contains(phonebook_Container_SecondTextCL1)
                .withCustomReportMessage("Validate second text in first step")
                .perform();

        driver.verifyThat().element(phonebook_Container_SecondText)
                .textTrimmed().contains(phonebook_Container_SecondTextCL2)
                .withCustomReportMessage("Validate second text in first step")
                .perform();

        driver.verifyThat().element(phonebook_Container_SecondText)
                .textTrimmed().contains(phonebook_Container_SecondTextCL3)
                .withCustomReportMessage("Validate second text in first step")
                .perform();

        driver.verifyThat().element(titleField_Title)
                .textTrimmed().isEqualTo(titleField_TitleCL)
                .withCustomReportMessage("Validate first text-box's title")
                .perform();
        driver.verifyThat().element(companyField_Title)
                .textTrimmed().isEqualTo(companyField_TitleCL)
                .withCustomReportMessage("Validate third text-box's title")
                .perform();
        driver.verifyThat().element(contactPersonField_Title)
                .textTrimmed().isEqualTo(contactPersonField_TitleCL)
                .withCustomReportMessage("Validate forth text-box's title")
                .perform();
        driver.verifyThat().element(streetandHouseNumberField_Title)
                .textTrimmed().isEqualTo(streetandHouseNumberField_TitleCL)
                .withCustomReportMessage("Validate fifth field's title")
                .perform();
        driver.verifyThat().element(streetandHouseNumberField_Box).isDisabled();
        driver.verifyThat().element(streetandHouseNumberField_Box)
                .textTrimmed().isEqualTo(streetandHouseNumberField_TextCL)
                .withCustomReportMessage("Validate street and housnumber value")
                .perform();
        driver.verifyThat().element(PostalCodeField_Title)
                .textTrimmed().isEqualTo(cityField_TitleCL)
                .withCustomReportMessage("Validate sixth field's title")
                .perform();
        driver.verifyThat().element(postalCodeField_Box).isDisabled();
        driver.verifyThat().element(postalCodeField_Text)
                .textTrimmed().isEqualTo(cityField_TextCL)
                .withCustomReportMessage("Validate city field's value")
                .perform();
        driver.verifyThat().element(mandatoryWord)
                .textTrimmed().isEqualTo(mandatoryWordCL)
                .withCustomReportMessage("Validate city field")
                .perform();
        return this;
    }
    @Step("validate the firma case in change phonebooksettings")
    public Phonebook validateReviewStep_ChangeFirmaCase() {
        driver.verifyThat().element(phonebook_Add_thirdStep_Title)
                .textTrimmed().isEqualTo(phonebook_Add_thirdStep_TitleCL)
                .withCustomReportMessage("Validate second step of Adding phonebook")
                .perform();
        driver.verifyThat().element(titelValue_ReviewStep)
                .textTrimmed().isEqualTo(title_value_change)
                .perform();
        driver.verifyThat().element(secondfieldReviewStep)
                .textTrimmed().isEqualTo(second_value_change)
                .perform();
        driver.verifyThat().element(firstfieldReviewStep)
                .textTrimmed().isEqualTo(third_value_change)
                .perform();
        driver.verifyThat().element(address_ReviewStep)
                .textTrimmed().isEqualTo(addressValue)
                .perform();
        driver.verifyThat().element(postalCode_ReviewStep)
                .textTrimmed().isEqualTo(postalValue)
                .perform();
        driver.verifyThat().element(phonebook_Add_thirdStep_2ndSubTitle)
                .textTrimmed().contains(phonebook_Add_thirdStep_2ndSubTitleCL)
                .perform();
        driver.verifyThat().element(entryTypeReviewStep)
                .textTrimmed().isEqualTo(entryTypeValue)
                .perform();
        driver.verifyThat().element(secondQuestionReview)
                .textTrimmed().isEqualTo(secondQuestionReviewCL)
                .withCustomReportMessage("Validate second question Review step")
                .perform();
        driver.verifyThat().element(thirdQuestionReview)
                .textTrimmed().isEqualTo(thirdQuestionReviewCLFirmaCase)
                .withCustomReportMessage("Validate first question Review step")
                .perform();
        return this;
    }

    @Step("validate the review step of non firma case in change phonebooksettings")
    public Phonebook validateReviewStep_Change () {
        driver.verifyThat().element(phonebook_Add_thirdStep_Title)
                .textTrimmed().isEqualTo(phonebook_Add_thirdStep_TitleCL)
                .withCustomReportMessage("Validate second step of Adding phonebook")
                .perform();

        driver.verifyThat().element(titelValue_ReviewStep)
                .textTrimmed().isEqualTo(title_value_change)
                .perform();
        driver.verifyThat().element(secondfieldReviewStep)
                .textTrimmed().isEqualTo(second_value_change)
                .perform();
        driver.verifyThat().element(firstfieldReviewStep)
                .textTrimmed().isEqualTo(third_value_change)
                .perform();
        driver.verifyThat().element(address_ReviewStep)
                .textTrimmed().isEqualTo(addressValue)
                .perform();
        driver.verifyThat().element(postalCode_ReviewStep)
                .textTrimmed().isEqualTo(postalValue)
                .perform();
        driver.verifyThat().element(phonebook_Add_thirdStep_2ndSubTitle)
                .textTrimmed().contains(phonebook_Add_thirdStep_2ndSubTitleCL)
                .perform();
        driver.verifyThat().element(entryTypeReviewStep)
                .textTrimmed().isEqualTo(entryTypeValue)
                .perform();
        driver.verifyThat().element(secondQuestionReview)
                .textTrimmed().isEqualTo(secondQuestionReviewCL)
                .withCustomReportMessage("Validate second question Review step")
                .perform();
        driver.verifyThat().element(thirdQuestionReview)
                .textTrimmed().isEqualTo(thirdQuestionReviewCL)
                .withCustomReportMessage("Validate first question Review step")
                .perform();

        driver.verifyThat().element(warningMsgTitle)
                .textTrimmed().isEqualTo(warningMsgTitleCL)
                .withCustomReportMessage("Validate warning msg title")
                .perform();
        return this;
    }
    @Step("click on continue button of first step of adding phonebook")
    public Phonebook clickOnContinueBtn()
    {
        driver.element().isElementClickable(continue_Btn);
        driver.element().click(continue_Btn);
        return this;
    }
    @Step("validate the review step of firma case")
    public Phonebook validateReviewStep () {
        driver.verifyThat().element(phonebook_Add_thirdStep_Title)
                .textTrimmed().isEqualTo(phonebook_Add_thirdStep_TitleCL)
                .withCustomReportMessage("Validate second step of Adding phonebook")
                .perform();

        driver.verifyThat().element(titelValue_ReviewStep)
                .textTrimmed().isEqualTo(title_value)
                .perform();
        driver.verifyThat().element(firstfieldReviewStep)
                .textTrimmed().isEqualTo(third_value)
                .perform();
        driver.verifyThat().element(secondfieldReviewStep)
                .textTrimmed().isEqualTo(second_value)
                .perform();
        driver.verifyThat().element(address_ReviewStep)
                .textTrimmed().isEqualTo(addressValue)
                .perform();
        driver.verifyThat().element(postalCode_ReviewStep)
                .textTrimmed().isEqualTo(postalValue)
                .perform();
        driver.verifyThat().element(phonebook_Add_thirdStep_2ndSubTitle)
                .textTrimmed().contains(phonebook_Add_thirdStep_2ndSubTitleCL)
                .perform();
        driver.verifyThat().element(entryTypeReviewStep)
                .textTrimmed().isEqualTo(entryTypeValue)
                .perform();
       driver.verifyThat().element(secondStep_firstQReview)
                .textTrimmed().isEqualTo(secondQuestionReviewCLFirmaCase)
                .perform();
        driver.verifyThat().element(secondQuestionReview)
                .textTrimmed().isEqualTo(thirdQuestionReviewCLFirmaCase)
                .withCustomReportMessage("Validate second question Review step")
                .perform();
        driver.verifyThat().element(warningMsgTitle)
                .textTrimmed().isEqualTo(warningMsgTitleCL)
                .withCustomReportMessage("Validate warning msg title")
                .perform();
        /*driver.verifyThat().element(warningMsgText)
                .textTrimmed().isEqualTo(warningMsgTextCL)
                .withCustomReportMessage("Validate warning msg text")
                .perform(); */
        return this;
    }
    @Step("validate second step of Adding phonebook")
    public Phonebook validateSecondAccordionAdd() {
        driver.verifyThat().element(phonebook_Add_secondStep_Title)
                .textTrimmed().contains(phonebook_Add_secondStep_TitleCL)
                .withCustomReportMessage("Validate second step of Adding phonebook")
                .perform();
        driver.verifyThat().element(secondStep_FirstQTitle)
                .textTrimmed().isEqualTo(secondStep_FirstQTitleCL)
                .withCustomReportMessage("Validate second step's first question")
                .perform();
        driver.verifyThat().element(secondStep_FirstQ_Telephone)
                .textTrimmed().isEqualTo(telephone_RadioBtn_TextCL)
                .withCustomReportMessage("Validate second step's first question's first option")
                .perform();
        driver.verifyThat().element(secondStep_FirstQ_Fax)
                .textTrimmed().isEqualTo(fax_RadioBtn_TextCL)
                .withCustomReportMessage("Validate second step's first question's 2nd option")
                .perform();
        driver.verifyThat().element(secondStep_FirstQTitle)
                .textTrimmed().isEqualTo(secondStep_FirstQTitleCL)
                .withCustomReportMessage("Validate second step's first question's 3rd option")
                .perform();
        driver.verifyThat().element(entryTypeFieldTitle)
                .textTrimmed().isEqualTo(entrTypeFieldCL)
                .withCustomReportMessage("Validate entry type field title")
                .perform();
        driver.verifyThat().element(secondQuestion_Title)
                .textTrimmed().isEqualTo(secondQuestionCL)
                .withCustomReportMessage("Validate second step of Adding phonebook's second question title")
                .perform();
        driver.verifyThat().element(secondQuestion_Text)
                .textTrimmed().isEqualTo(secondQuestionC_ChechboxCL)
                .withCustomReportMessage("Validate second step of Adding phonebook's second questin's checkbox")
                .perform();
        driver.verifyThat().element(thirdQuestion_Title)
                .textTrimmed().isEqualTo(thirdQuestionCL)
                .withCustomReportMessage("Validate second step of Adding phonebook's third question title")
                .perform();
        driver.verifyThat().element(thirdQuestion_Text)
                .textTrimmed().isEqualTo(thirdQuestion_CheckboxCL)
                .withCustomReportMessage("Validate second step of Adding phonebook's second question's checkbox")
                .perform();
        return this;
    }
    @Step("validate second step of change phonebook")
    public Phonebook validateSecondAccordionChange() {
        driver.verifyThat().element(phonebook_Add_secondStep_Title)
                .textTrimmed().contains(phonebook_Add_secondStep_TitleCL)
                .withCustomReportMessage("Validate second step of Adding phonebook")
                .perform();
        driver.verifyThat().element(change_SecondStep_FirstQTitle)
                .textTrimmed().isEqualTo(secondStep_FirstQTitleCL)
                .withCustomReportMessage("Validate second step's first question")
                .perform();
        driver.verifyThat().element(secondStep_FirstQ_Telephone)
                .textTrimmed().isEqualTo(telephone_RadioBtn_TextCL)
                .withCustomReportMessage("Validate second step's first question's first option")
                .perform();
        driver.verifyThat().element(secondStep_FirstQ_Fax)
                .textTrimmed().isEqualTo(fax_RadioBtn_TextCL)
                .withCustomReportMessage("Validate second step's first question's 2nd option")
                .perform();
        driver.verifyThat().element(entryTypeFieldTitle)
                .textTrimmed().isEqualTo(entrTypeFieldCL)
                .withCustomReportMessage("Validate entry type field title")
                .perform();
        driver.verifyThat().element(change_SecondQuestion_Title)
                .textTrimmed().isEqualTo(secondQuestionCL)
                .withCustomReportMessage("Validate second step of changing phonebook's second question title")
                .perform();
        driver.verifyThat().element(secondQuestion_Text)
                .textTrimmed().isEqualTo(secondQuestionC_ChechboxCL)
                .withCustomReportMessage("Validate second step of changing phonebook's second question's checkbox")
                .perform();
        driver.verifyThat().element(change_ThirdQuestion_Title)
                .textTrimmed().isEqualTo(thirdQuestionCL)
                .withCustomReportMessage("Validate second step of changing phonebook's third question title")
                .perform();
        driver.verifyThat().element(thirdQuestion_Text)
                .textTrimmed().isEqualTo(thirdQuestion_CheckboxCL)
                .withCustomReportMessage("Validate second step of changing phonebook's second question's checkbox")
                .perform();
        return this;
    }
    @Step("Agree to publish address on third question")
    public Phonebook AgreeOnPublishAddress ()
    {
        driver.element().click(thirdQ_Checkbox);
        return this;
    }

    @Step("validate that as telephone option is checked")
    public Phonebook validateThatitsAlsTelefone()
    {
        driver.element().click(telephone_RadioBtn);
        return this;
    }

    @Step("choose Printed Type From DropDownList")
    public Phonebook choosePrintedTypeFromDropDownList ()
    {
        driver.element().click(entryTypeField_DDL);
        driver.element().click(entryTypeField_DDL_secondOp);
        return this;
    }

    @Step("click on continue button of second step")
    public Phonebook clickOnConfirmationButton() {
        driver.element().click(thirdstepConfirmbutton);
        return this;
    }

    @Step("click on continue button of second step")
    public Phonebook clickOnConfirmationButton_ReviewChange()
    {
        driver.element().click( thirdstep_Change_Confirmbutton );
        return this;
    }

    @Step("click on continue button of second step")
    public Phonebook clickOnContinueBtn2ndStep()
    {
        driver.element().click(secondStep_ContinueBtn);
        return this;
    }

    @Step("validate Review Step In Not FirmaCase")
    public Phonebook validateReviewStepInNotFirmaCase ()
    {
        driver.verifyThat().element(firstNameField_TitleReviewStep)
                .textTrimmed().isEqualTo(firstNameField_TitleCLRS)
                .withCustomReportMessage("Validate third text-box's title")
                .perform();
        driver.verifyThat().element(lastNameField_TitleReviewStep)
                .textTrimmed().isEqualTo(lastNameField_TitleCLRS)
                .withCustomReportMessage("Validate third text-box's title")
                .perform();
        return this;
    }

    @Step("click on continue button of first step of adding phonebook")
    public Phonebook fillAllFieldsFirmaCase() {
        driver.element().type(titleField_textbox,wrongTitle_value);
        driver.element().type(contactPersonField_textbox,wrongSecond_value);
        driver.element().type(companyField_textbox,wrongThird_value);
        return this;
    }

    @Step("click on continue button of first step of adding phonebook")
    public Phonebook fillAllFields()
    {
        driver.element().type(titleField_textbox,title_value);
        driver.element().type(contactPersonField_textbox,second_value);
        driver.element().type(companyField_textbox,third_value);
        return this;
    }

    @Step("Validate the view of Not Firma Case in Adding new Phonebook Settings")
    public Phonebook validatePhoneBookPageNOTFirmaCase()
    {
        driver.verifyThat().element(firstNameField_Title)
                .textTrimmed().isEqualTo(firstNameField_TitleCL)
                .withCustomReportMessage("Validate third text-box's title")
                .perform();
        driver.verifyThat().element(lastNameField_Title)
                .textTrimmed().isEqualTo(lastNameField_TitleCL)
                .withCustomReportMessage("Validate forth text-box's title")
                .perform();
        return this;
    }

    @Step("validate Success Step message")
    public Phonebook validateSuccessStep()
    {
        driver.verifyThat().element(successMsgText)
                .textTrimmed().contains(successMsgTextCL1)
                .withCustomReportMessage("Check success Message Description")
                .perform();
        driver.verifyThat().element(successMsgText)
                .textTrimmed().contains(successMsgTextCL2)
                .withCustomReportMessage("Check success Message Description")
                .perform();

        driver.verifyThat().element(successMsgTitle)
                .textTrimmed().contains(successMsgTitleCL)
                .withCustomReportMessage("Check success Message Title")
                .perform();
        return this;
    }

    @Step("validate failure message")
    public Phonebook validateFailureView()
    {
        driver.verifyThat().element(error_MSG_Title)
                    .text().isEqualTo(error_MSG_TitleCL)
                    .withCustomReportMessage("Check Error Message Title")
                    .perform();
        driver.verifyThat().element(error_MSG_text)
                    .text().isEqualTo(error_MSG_TextCL)
                    .withCustomReportMessage("Check Error Message Description")
                    .perform();
        return this;
    }

    @Step("validate failure message")
    public Phonebook validateFailureView_ChangePhonebook()
    {
        driver.verifyThat().element(error_MSG_Title_ChangePhonebook)
                .text().isEqualTo(error_MSG_TitleCL)
                .withCustomReportMessage("Check Error Message Title")
                .perform();
        driver.verifyThat().element(error_MSG_Text_ChangePhonebook)
                .text().isEqualTo(error_MSG_TextCL)
                .withCustomReportMessage("Check Error Message Description")
                .perform();
        return this;
    }

    @Step("enter Invalid Data In NotFirma Case")
    public Phonebook enterInvalidDataInNotFirmaCase()
    {
        driver.element().type(titleField_textbox,invalidTitleValue);
        driver.element().type(firstNameField_TextBox,invalidFNameValue);
        driver.element().type(lastNameField_textbox,invalidLNameValue);

        driver.element().isElementClickable(continue_Btn);
        driver.element().click(continue_Btn);
        return this;
    }

    @Step("validate info icon's messages")
    public Phonebook validateAllInfoIconsMessagesFirmaCase()
    {
        driver.element().click(titleFieldInfoIcon);
        driver.verifyThat().element(titleFieldInfoIconText)
                .textTrimmed().isEqualTo(titleFieldInfoIconCL)
                .withCustomReportMessage("validate title Field Info Icon Text")
                .perform();
        driver.element().click(firmaFieldInfoIcon);
        driver.verifyThat().element(firmaFieldInfoIconText)
                .textTrimmed().isEqualTo(firmaFieldInfoIconTextCL)
                .withCustomReportMessage("validate firma field's Info Icon Text")
                .perform();
        driver.element().click(contactPerspnInfoIcon);

        driver.verifyThat().element(contactPersonInfoIconText)
                .textTrimmed().contains(contactPersonInfoIconTextCL1)
                .withCustomReportMessage("validate contact person field's Info Icon Text")
                .perform();
        driver.verifyThat().element(contactPersonInfoIconText)
                .textTrimmed().contains(contactPersonInfoIconTextCL2)
                .withCustomReportMessage("validate contact person field's Info Icon Text")
                .perform();
        return this;
    }

    @Step("click on continue button of first step of adding phonebook")
    public Phonebook changeALLFields()
    {
        driver.element().type(titleField_textbox,title_value_Change);
        driver.element().type(contactPersonField_textbox,second_value_Change);
        driver.element().type(companyField_textbox,third_value_Change);
        return this;
    }

    @Step("clear all fields of not firma case")
    public Phonebook clearAllFields()
    {
        driver.verifyThat().element(changephonebook_Container_FirstText)
                .textTrimmed().contains(phonebook_Container_FirstTextCL1)
                .withCustomReportMessage("Validate first text in first step")
                .perform();
        driver.verifyThat().element(changephonebook_Container_FirstText)
                .textTrimmed().contains(phonebook_Container_FirstTextCL2)
                .withCustomReportMessage("Validate first text in first step")
                .perform();

        driver.getDriver().findElement(titleField_textbox).clear();
        driver.getDriver().findElement(firstNameField_TextBox).clear();
        driver.getDriver().findElement(lastNameField_textbox).clear();
        return this;
    }

    @Step("clear all firma fields")
    public Phonebook clearNotFirmaFields ()
    {
        driver.verifyThat().element(changephonebook_Container_FirstText)
                .textTrimmed().contains(phonebook_Container_FirstTextCL1)
                .withCustomReportMessage("Validate first text in first step")
                .perform();
        driver.verifyThat().element(changephonebook_Container_FirstText)
                .textTrimmed().contains(phonebook_Container_FirstTextCL2)
                .withCustomReportMessage("Validate first text in first step")
                .perform();

        driver.getDriver().findElement(titleField_textbox).clear();
        driver.getDriver().findElement(contactPersonField_textbox).clear();
        driver.getDriver().findElement(companyField_textbox).clear();
        return this;
    }

    @Step("Validate returned values on Change phonebook Fields")
    public Phonebook validateReturnedValuesOnFields()
    {
        driver.verifyThat().element(changephonebook_Container_FirstText)
            .textTrimmed().contains(phonebook_Container_FirstTextCL1)
            .withCustomReportMessage("Validate first text in first step")
            .perform();
        driver.verifyThat().element(changephonebook_Container_FirstText)
                .textTrimmed().contains(phonebook_Container_FirstTextCL2)
                .withCustomReportMessage("Validate first text in first step")
                .perform();

        driver.verifyThat().element(phonebook_PageTitle)
            .textTrimmed().isEqualTo(phonebook_PageTitleCL)
            .withCustomReportMessage("Validate page title")
            .perform();

        driver.verifyThat().element(changephonebook_Container_secondText)
            .textTrimmed().contains(phonebook_Container_SecondTextCL1)
            .withCustomReportMessage("Validate second text in first step")
            .perform();

        driver.verifyThat().element(changephonebook_Container_secondText)
                .textTrimmed().contains(phonebook_Container_SecondTextCL2)
                .withCustomReportMessage("Validate second text in first step")
                .perform();

        driver.verifyThat().element(changephonebook_Container_secondText)
                .textTrimmed().contains(phonebook_Container_SecondTextCL3)
                .withCustomReportMessage("Validate second text in first step")
                .perform();

        driver.verifyThat().element(titleField_textbox)
            .textTrimmed().isEqualTo(titleValue_Change)
            .withCustomReportMessage("Validate first text-box's value")
            .perform();
        driver.verifyThat().element(firstNameField_TextBox)
            .textTrimmed().isEqualTo(firstNameField_valueChange)
            .withCustomReportMessage("Validate third text-box's value")
            .perform();
        driver.verifyThat().element(lastNameField_textbox)
            .textTrimmed().isEqualTo(lastNameField_valueChange)
            .withCustomReportMessage("Validate forth text-box's value")
            .perform();
        driver.verifyThat().element(streetandHouseNumberField_Box)
            .textTrimmed().isEqualTo(streetandHouseNumberField_TextCL)
            .withCustomReportMessage("Validate street and housnumber value")
            .perform();
        driver.verifyThat().element(streetandHouseNumberField_Box).isDisabled();
        driver.verifyThat().element(postalCodeField_Box).isDisabled();
        driver.verifyThat().element(postalCodeField_Text)
            .textTrimmed().isEqualTo(cityField_TextCL)
            .withCustomReportMessage("Validate city field's value")
            .perform();
        driver.verifyThat().element(mandatoryWord)
            .textTrimmed().isEqualTo(mandatoryWordCL)
            .withCustomReportMessage("Validate city field")
            .perform();

        return this;
    }

}
