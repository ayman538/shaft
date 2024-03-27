package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class KundenKontaktdaten {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    public static final String MobileRegex = "^(0049|049|[+]49|0|49)(1)([5-7]{1})([0-9]{8,9})$";
    //Landline Regex in consumer same as Telephone Regex in SOHO
    public static final String LandlineRegex = "^(((0049|049|[+]49|0|49)(1)([5-7]{1})([0-9]{8,9}))|(0([0-9][-\\s/]*){7,14}))$";
    public static final String EmailRegex = "^\\s*\\w+([\\.-]?\\w+)+@\\w+([\\.:-]?\\w+)+(\\.[a-zA-Z0-9]{2,3})+\\s*$";

    //CLs
    public static String InvalidNumberBadCase = "015673946383";
    public static String InvalidPrivateNumberBadCase = "08736432";
    public static String InvalidMailBadCase = "test@vodafone.com";
    public static String ValidMobileNumber = "01512345678";
    public static String ValidEmail = "max@mustermann.de";
    public static String InvalidLandlineNumber = "67209455778";
    public static String ValidLandlineNumber = "004920945577889";
    public static String InvalidMobileNumber = "20945577889";
    public static String PageTitle = "Kunden-Kontaktdaten";
    public static String KontaktdatenAndernSection = "Kontaktdaten ändern";
    public static String InstructionText = "Gib bitte Deine Daten ein.";
    public static String MobileNumberLabel = "Handy-Nummer";
    public static String MobileNumberLabelInEdit = "Telefonnummer *";
    public static String LandlineNumberLabel = "Telefon privat";
    public static String EmailLabel = "Service-E-Mail-Adresse";
    public static String EmailLabelInEdit = "Service-E-Mail-Adresse *";
    public static String MandatoryField = "Pflichtfeld";
    public static String SaveButton = "Weiter";// Speichern
    public static String EmailErrorMessage = "Gib bitte Deine E-Mail-Adresse ein.";//"Die E-Mail-Adresse hat nicht das korrekte Format. Richtig ist z.B.: max.mustermann@provider.de";
    public static String UbersichtSection = "Übersicht";
    public static String ReviewMessage = "Du hast Deine Kontaktdaten geändert. Überprüf bitte Deine Änderungen nochmal. Klick dann auf „Bestätigen“.";
    public static String ConfirmButton = "Bestätigen";
    public static String MobilePhoneErrorMessage = "Die Rufnummer darf nur Zahlen enthalten. Sonderzeichen und Leerzeichen sind nicht erlaubt.";//Die Rufnummer darf nur Zahlen enthalten. Sonderzeichen und Leerzeichen sind nicht erlaubt.
    public static String LandlinePhoneErrorMessage = "Die Rufnummer darf nur Zahlen enthalten. Sonderzeichen und Leerzeichen sind nicht erlaubt.";//Die Rufnummer darf nur Zahlen enthalten. Sonderzeichen und Leerzeichen sind nicht erlaubt.
    public static String ConfirmationMessageTitle = "Vielen Dank. Du hast Deine Daten erfolgreich geändert.";
    public static String ConfirmationMessageDescription = "Bis Deine Änderungen übernommen sind, kann es bis zu einer Stunde dauern. Sobald Du Dich neu anmeldest, werden sie angezeigt. Hast Du eine E-Mail-Adresse bei uns hinterlegt, bekommst Du außerdem noch eine Bestätigung von uns.";
    public static String UbersichtAccordionConfirmationBodyTitle = "Deine neuen Kunden-Kontaktdaten";
    public static String MobileNumberInOverviewSection = "01512 345 67 8";
    //SOHO CLs not develop yet
    public static String TelephoneNumberLabel = "Telefonnummer";
    public static String emptyTelephoneNumberFieldErrorMessage = "Gib bitte Deine Telefonnummer ein.";
    public static String TelephoneNumberErrorMessage = "Die Rufnummer darf nur Zahlen enthalten. Sonderzeichen und Leerzeichen sind nicht erlaubt.";

    // CLs for 8290 Kabel-Migration | Migrate to New Version of Contact Medium
    public static String telephoneNumberErrorMessage_Tittle_CL = "Entschuldigung, da ist was schiefgelaufen.";
    public static String telephoneNumberErrorMessage_Description_CL = "Bitte versufchen Sie es später noch einmal.";
    public static String telephoneNumberPartialSuccessMessage_Tittle_CL = "Deine Änderungen konnten nicht komplett gespeichert werden.";
    public static String telephoneNumberPartialSuccessMessage_Description_CL = "Versuch es bitte nochmal.";
    public static String telephoneNumberSuccessMessage_Tittle_CL = "Vielen Dank. Du hast Deine Daten erfolgreich geändert.";
    public static String telephoneNumberSuccessMessage_Description_CL = "Bis Deine Änderungen übernommen sind, kann es bis zu einer Stunde dauern. Sobald Du Dich neu anmeldest, werden sie angezeigt. Hast Du eine E-Mail-Adresse bei uns hinterlegt, bekommst Du außerdem noch eine Bestätigung von uns.";

    //Locators
    public static final By kundenKontaktdatenPagetitleLocator = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    public static final By changeContactDetailsSectionTitleLocator = By.xpath("//div[@class='header-title' and text()='Kontaktdaten ändern']");
    public static final By instructionLocator = By.xpath("//p[@automation-id='edit_um_contact_data_tv']");
    public static final By mobilePhoneLabelLocator = By.xpath("//label[@for='text' and text()='Telefonnummer ']");
    public static final By mobilePhoneTextBoxLocator = By.xpath("//input[@automation-id='mobile_phone_et']");

    public static final By landlineLabelLocator = By.xpath("//label[@for='text' and text()='Telefon privat ']");
    public static final By landlineTextBoxLocator = By.xpath("//input[@automation-id='house_phone_et']");
    public static final By landlineTextBoxLocatorWFDT_4562 = By.xpath("//input[@automation-id='phone_number_et']");
    public static final By emailLabelLocator = By.xpath("//label[@for='text' and text()='Service-E-Mail-Adresse ']");
    public static final By emailTextBoxLocator = By.xpath("//input[@automation-id='email_et']");
    public static final By mandatoryFieldsLocator = By.xpath("//span[text()='Pflichtfeld']");
    public static final By saveButtonLocator = By.xpath("//button[@automation-id='edit_um_contact_data_btn']");
    public static final By mobileErrorMessageLocator = By.xpath("//p[@automation-id='mobile_phone_patternErrorMessage_et']");
    public static final By landlineErrorMessageLocator = By.xpath("//p[@automation-id='house_phone_patternErrorMessage_et']");
    public static final By emailErrorMessageLocator = By.xpath("//p[@automation-id='emailrequiredErrorMessage_et']");//By.xpath("//p[@automation-id='email_patternErrorMessage_et']");
    public static final By overviewSectionlocator = By.xpath("//div[@class='header-title' and text()='Übersicht']");
    public static final By reviewMessageLocator = By.xpath("//p[@automation-id='um_contactData_headline_tv']");
    public static final By mobilePhoneReviewlabelLocator = By.xpath("//div[@automation-id='um_contactData_MobilePhone_tv']/label");
    public static final By mobilePhoneReviewLocator = By.xpath("//div[@automation-id='um_contactData_MobilePhone_tv']/p");
    public static final By landlineReviewLabelLocator = By.xpath("//div[@automation-id='um_contactData_HousePhone_tv']/label");
    public static final By landlineReviewLocator = By.xpath("//div[@automation-id='um_contactData_HousePhone_tv']/p");
    public static final By emailReviewLabelLocator = By.xpath("//div[@automation-id='um_contactData_Email_tv']/label");
    public static final By emailReviewLocator_Confirmation = By.xpath("//div[@automation-id='um_contactData_Email_tv']//p");
    public static final By emailReviewLocator = By.xpath("//div[@automation-id='um_contactData_Email_tv']/p");
    public static final By confirmButtonlocator = By.xpath("//button[@automation-id='um_contactData_Email_btn']");
    public static final By confirmationMessageTitle = By.xpath("//h4[@class='flexDiv']");
    public static final By confirmationMessageDescription = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    public static final By confirmationOverviewAccordion = By.xpath("//li[@automation-id='accordion0_acc']");
    public static final By confirmationOverviewAccordionText = By.xpath("//li[@automation-id='accordion1_acc']/a/span");
    public static final By confirmationOverviewAccordionBodyTitle = By.xpath("//li[@automation-id='accordion1_acc']/div/h4");
    //SOHO Locators not develop yet
    public static final By telephoneNumberLabelLocator = By.xpath("//label[@for='text' and text()='Telefonnummer']");
    public static final By telephoneNumberTextBoxLocator = By.xpath("//input[@automation-id='phone_number_et']");
    public static final By telephoneNumberReviewlabelLocator = By.xpath("//div[@automation-id='um_contactData_phoneNumber_tv']/label");
    public static final By telephoneNumberReviewLocator = By.xpath("//div[@automation-id='um_contactData_phoneNumber_tv']/p");
    public static final By telephoneNumberReviewLocator_Confirmation = By.xpath("//div[@automation-id='um_contactData_phoneNumber_tv']//p");
    public static final By telephoneNumberErrorMessageLocator = By.xpath("//p[@automation-id='phone_number_patternErrorMessage_et']");
    public static final By emptyTelephoneNumberFieldErrorMessageLocator = By.xpath("//p[@automation-id='phone_numberrequiredErrorMessage_et']");

    // Locators for 8290 Kabel-Migration | Migrate to New Version of Contact Medium
    public static final By telephoneNumberMessage_Tittle = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    public static final By telephoneNumberMessage_Description = By.xpath("//div[@automation-id='successMsg_tv']//p");

    //Constructor
    public KundenKontaktdaten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Keywords
    @Step("Clear Text Box")
    public KundenKontaktdaten deleteTextBox(By elementLocator) {
        driver.getDriver().findElement(elementLocator).clear();
        return this;
    }

    public KundenKontaktdaten afterDeleteTextBoxHandler(By elementLocator) {
        driver.element().type(elementLocator, "a");
        driver.element().keyPress(elementLocator, Keys.BACK_SPACE);
        return this;
    }

    public KundenKontaktdaten clickOnLandlineTextBox() {
        driver.element().click(landlineTextBoxLocator);
        return this;
    }

    public KundenKontaktdaten clickOnMobileTextBox() {
        driver.element().click(mobilePhoneTextBoxLocator);
        return this;
    }

    public KundenKontaktdaten clickOnEmailTextBox() {
        driver.element().click(emailTextBoxLocator);
        return this;
    }


    public KundenKontaktdaten typeMobileNumberOnTextBox(String mobilenumber) {
        (driver.getDriver().findElement(mobilePhoneTextBoxLocator)).sendKeys(mobilenumber);
        return this;
    }

    public KundenKontaktdaten typeTelephoneNumberOnTextBox(String telephoneNumber) {
        (driver.getDriver().findElement(telephoneNumberTextBoxLocator)).sendKeys(telephoneNumber);
        return this;
    }

    public KundenKontaktdaten typeLandlineNumberOnTextBox(String landlinenumber) {
        (driver.getDriver().findElement(landlineTextBoxLocator)).sendKeys(landlinenumber);
        return this;
    }

    @Step("Type Email On TextBox")
    public KundenKontaktdaten typeEmailOnTextBox(String email) {
        (driver.getDriver().findElement(emailTextBoxLocator)).sendKeys(email);
        return this;
    }
    @Step("Click On Save Button")
    public KundenKontaktdaten clickOnSaveButton() {
        driver.element().click(saveButtonLocator);
        return this;
    }

    @Step("Click On Confirm Button")
    public KundenKontaktdaten clickOnConfirmButton() {
        driver.element().isElementClickable(confirmButtonlocator);
        driver.element().click(confirmButtonlocator);
        return this;
    }

    public KundenKontaktdaten clickOnConfirmationOverviewAccordion() {
        driver.element().click(confirmationOverviewAccordion);
        return this;
    }

    public KundenKontaktdaten assertOnTelephoneInOverviewSection() {
        driver.verifyThat().element(telephoneNumberReviewlabelLocator)
                .textTrimmed().isEqualTo(TelephoneNumberLabel)
                .withCustomReportMessage("Check that mobile phone label in confirmation section text exists")
                .perform();
        driver.verifyThat().element(telephoneNumberReviewLocator_Confirmation)
                .exists()
                .withCustomReportMessage("Check that mobile phone in confirmation section number exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnTelephoneNumberErrorMessage() {
        driver.verifyThat().element(telephoneNumberErrorMessageLocator)
                .textTrimmed().isEqualTo(TelephoneNumberErrorMessage)
                .withCustomReportMessage("Check that telephone number error message exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnEmptyTelephoneNumberFieldErrorMessage() {
        driver.verifyThat().element(emptyTelephoneNumberFieldErrorMessageLocator)
                .textTrimmed().isEqualTo(emptyTelephoneNumberFieldErrorMessage)
                .withCustomReportMessage("validate error message in case telephone number is empty")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnKontaktdatenAndernSection() {
        driver.element().isElementDisplayed(changeContactDetailsSectionTitleLocator);
        driver.verifyThat().element(changeContactDetailsSectionTitleLocator)
                .textTrimmed().isEqualTo(KontaktdatenAndernSection)
                .withCustomReportMessage("Check that Kontaktdaten ändern section Text exists")
                .perform();

        driver.verifyThat().element(kundenKontaktdatenPagetitleLocator)
                .textTrimmed().isEqualTo(PageTitle)
                .withCustomReportMessage("Check that page title 'Kunden-Kontaktdaten' exists")
                .perform();

        driver.verifyThat().element(emailLabelLocator)
                .textTrimmed().contains(EmailLabelInEdit)
                .withCustomReportMessage("Check that email label text exists")
                .perform();

        driver.verifyThat().element(mandatoryFieldsLocator)
                .textTrimmed().isEqualTo(MandatoryField)
                .withCustomReportMessage("Check that mandatory fields text exists")
                .perform();

        driver.verifyThat().element(saveButtonLocator)
                .textTrimmed().isEqualTo(SaveButton)
                .withCustomReportMessage("Check that save button 'Weiter' text exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnEmailErrorMessage() {
        driver.verifyThat().element(emailErrorMessageLocator)
                .textTrimmed().isEqualTo(EmailErrorMessage)
                .withCustomReportMessage("Check that email error message exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnUbersichtSectionReviewTitles() {
        driver.verifyThat().element(overviewSectionlocator)
                .textTrimmed().isEqualTo(UbersichtSection)
                .withCustomReportMessage("Check that overview section text 'Übersicht' exists")
                .perform();
        driver.verifyThat().element(reviewMessageLocator)
                .textTrimmed().contains(ReviewMessage)
                .withCustomReportMessage("Check that review message text exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnMobileInOverviewSection() {
        driver.verifyThat().element(mobilePhoneReviewlabelLocator)
                .textTrimmed().isEqualTo(MobileNumberLabel)
                .withCustomReportMessage("Check that mobile phone label in confirmation section text exists")
                .perform();
        driver.verifyThat().element(mobilePhoneReviewLocator)
                .textTrimmed().isEqualTo(MobileNumberInOverviewSection)
                .withCustomReportMessage("Check that mobile phone in confirmation section number exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnLandlineInOverviewSection() {
        driver.verifyThat().element(landlineReviewLabelLocator)
                .textTrimmed().isEqualTo(LandlineNumberLabel)
                .withCustomReportMessage("Check that Landline phone label text in confirmation section exists")
                .perform();
        driver.verifyThat().element(landlineReviewLocator)
                .textTrimmed().isEqualTo(ValidLandlineNumber)
                .withCustomReportMessage("Check that Landline phone number in confirmation section exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnEmailInOverviewSection() {
        driver.verifyThat().element(emailReviewLabelLocator)
                .textTrimmed().isEqualTo(EmailLabel)
                .withCustomReportMessage("Check that email label in confirmation section exists")
                .perform();
        driver.verifyThat().element(emailReviewLocator_Confirmation)
                .textTrimmed().isEqualTo(ValidEmail)
                .withCustomReportMessage("Check that email in confirmation section exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnConfirmButtonText() {
        driver.verifyThat().element(confirmButtonlocator)
                .textTrimmed().isEqualTo(ConfirmButton)
                .withCustomReportMessage("Check that confirm button text in review section exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnMobileErrorMessage() {
        driver.verifyThat().element(mobileErrorMessageLocator)
                .textTrimmed().isEqualTo(MobilePhoneErrorMessage)
                .withCustomReportMessage("Check that mobile phone error message exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnLandlineErrorMessage() {
        driver.verifyThat().element(landlineErrorMessageLocator)
                .textTrimmed().isEqualTo(LandlinePhoneErrorMessage)
                .withCustomReportMessage("Check that mobile phone error message exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnConfirmationMessage() {
        driver.verifyThat().element(confirmationMessageTitle)
                .textTrimmed().isEqualTo(ConfirmationMessageTitle)
                .withCustomReportMessage("Check that confirmation message title exists")
                .perform();
        driver.verifyThat().element(confirmationMessageDescription)
                .textTrimmed().isEqualTo(ConfirmationMessageDescription)
                .withCustomReportMessage("Check that confirmation message description exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnUbersichtAccordionConfirmationTitles() {
        driver.verifyThat().element(confirmationOverviewAccordionText)
                .textTrimmed().isEqualTo(UbersichtSection)
                .withCustomReportMessage("Check that overview Accordion text 'Übersicht' in confirmation exists")
                .perform();
        driver.verifyThat().element(confirmationOverviewAccordionBodyTitle)
                .textTrimmed().isEqualTo(UbersichtAccordionConfirmationBodyTitle)
                .withCustomReportMessage("Check that title in overview accordion confirmation exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnLandlineRegexWFDT_4316() {
        driver.verifyThat().element(landlineTextBoxLocator)
                .textTrimmed().matchesRegex(LandlineRegex)
                .withCustomReportMessage("Check that landline Regex is right")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnLandlineRegexWFDT_4562() {
        driver.verifyThat().element(landlineTextBoxLocatorWFDT_4562)
                .textTrimmed().matchesRegex(LandlineRegex)
                .withCustomReportMessage("Check that landline Regex is right")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnMobileRegex() {
        driver.verifyThat().element(mobilePhoneTextBoxLocator)
                .textTrimmed().matchesRegex(MobileRegex)
                .withCustomReportMessage("Check that mobile phone Regex is right")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnEmailRegex() {
        driver.verifyThat().element(emailTextBoxLocator)
                .textTrimmed().matchesRegex(EmailRegex)
                .withCustomReportMessage("Check that mobile email is right")
                .perform();
        return this;
    }

    @Step("validate Phone Number Error Message")
    public KundenKontaktdaten validatePhoneNumberErrorMessage() {
        driver.element().isElementDisplayed(telephoneNumberMessage_Tittle);
        driver.verifyThat()
                .element(telephoneNumberMessage_Tittle)
                .textTrimmed()
                .contains(telephoneNumberErrorMessage_Tittle_CL)
                .withCustomReportMessage("Validate telephone Number Error Message Title Text")
                .perform();

        driver.verifyThat()
                .element(telephoneNumberMessage_Description)
                .textTrimmed()
                .contains(telephoneNumberErrorMessage_Description_CL)
                .withCustomReportMessage("Validate telephone Number Error Message Description Text")
                .perform();
        return this;
    }
    @Step("validate Phone Number Success Message")
    public KundenKontaktdaten validatePhoneNumberSuccessMessage() {
        driver.element().isElementDisplayed(telephoneNumberMessage_Tittle);
        driver.verifyThat()
                .element(telephoneNumberMessage_Tittle)
                .textTrimmed()
                .contains(telephoneNumberSuccessMessage_Tittle_CL)
                .withCustomReportMessage("Validate telephone Number Success Message Tittle Text")
                .perform();

        driver.verifyThat()
                .element(telephoneNumberMessage_Description)
                .textTrimmed()
                .contains(telephoneNumberSuccessMessage_Description_CL)
                .withCustomReportMessage("Validate telephone Number Success Message description Text")
                .perform();
        return this;
    }
    @Step("validate Phone Number Partial Success Message")
    public KundenKontaktdaten validatePhoneNumberPartialSuccessMessage() {
        driver.element().isElementDisplayed(telephoneNumberMessage_Tittle);
        driver.verifyThat()
                .element(telephoneNumberMessage_Tittle)
                .textTrimmed()
                .contains(telephoneNumberPartialSuccessMessage_Tittle_CL)
                .withCustomReportMessage("Validate telephone Number Partial Success Message Tittle Text")
                .perform();
        driver.verifyThat()
                .element(telephoneNumberMessage_Description)
                .textTrimmed()
                .contains(telephoneNumberPartialSuccessMessage_Description_CL)
                .withCustomReportMessage("Validate telephone Number Partial Success Message description Text")
                .perform();
        return this;
    }

    @Step("Type Mobile Number For SOHO User")
    public KundenKontaktdaten typeMobileNumberSoho(String mobileNumber) {
        driver.verifyThat().element(telephoneNumberTextBoxLocator).exists();
        driver.element().type(telephoneNumberTextBoxLocator, mobileNumber);
        return this;
    }

    @Step("ype Mobile Number For Consumer User")
    public KundenKontaktdaten typeMobileNumberConsumer(String mobileNumber) {
        driver.element().type(mobilePhoneTextBoxLocator, mobileNumber);
        return this;
    }

    public KundenKontaktdaten assertOnEmailBeforeOverviewSection() {
        driver.verifyThat().element(emailReviewLabelLocator)
                .textTrimmed().isEqualTo(EmailLabel)
                .withCustomReportMessage("Check that email label in confirmation section exists")
                .perform();
        driver.verifyThat().element(emailReviewLocator)
                .textTrimmed().isEqualTo(ValidEmail)
                .withCustomReportMessage("Check that email in confirmation section exists")
                .perform();
        return this;
    }

    public KundenKontaktdaten assertOnTelephoneBeforeOverviewSection() {
        driver.verifyThat().element(telephoneNumberReviewlabelLocator)
                .textTrimmed().isEqualTo(TelephoneNumberLabel)
                .withCustomReportMessage("Check that mobile phone label in confirmation section text exists")
                .perform();
        driver.verifyThat().element(telephoneNumberReviewLocator)
                .exists()
                .withCustomReportMessage("Check that mobile phone in confirmation section number exists")
                .perform();
        return this;
    }
}
