package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MeineDaten {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //CLs

    public static String meineDatenText = "Meine Daten";
    public static String kontaktdatenText = "Kontaktdaten";
    public static String meineKundendatenSmartObjectFooterText = "Kontaktdaten anzeigen und ändern";
    public static String meineKundendatenAccordionFooter = "Kontaktdaten anzeigen und ändern. Bestätige hier Deine E-Mail-Adresse.";
    public static String loginDataSectionHeader = "Login-Daten";
    public static String loginDataSectionFooter = "Deine Anmeldedaten und wie wir Dicdeh in MeinVodafone ansprechen dürfen.";
    public static String userNameLabel = "Benutzername:";
    public static String salutationLabel = "Anrede:";
    public static String lastNameLabel = "Nachname:";
    public static String firstNameLabel = "Vorname:";
    public static String editvorName = "Egemenn";
    public static String emailLabel = "E-Mail:";
    public static String loginDataEditButton = "Login-Daten bearbeiten";
    public static String contactDataSectionHeader = "Kunden-Kontaktdaten";
    public static String contactDataSectionHeaderSOHO = " Kunden-Kontaktdaten ";
    public static String contactDataSectionFooter = "So bekommst Du immer und überall wichtige Infos zu Deinem Vertrag, Deinen Rechnungen und persönliche Infos von uns.";
    public static String meinKabelTitle = "MeinKabel";
    public static String kabelDeutschlandTitle = "Kabel Deutschland";
    public static String customerNumberLabel432051461 = "Kundennummer 432051461";
    public static String mobileNumberLabel = "Handy-Nummer:";
    public static String landlineNumberLabel = "Telefon privat:";
    public static String phoneNumberNotProvidedMessage = "Du hast keine Rufnummer angegeben.";
    public static String contactDataEmailLabel = "Service-E-Mail-Adresse:";
    public static String contactDataEmail = "gicksgacks@test.de";
    public static String contactDataEditButton = "Kontaktdaten bearbeiten";
    public static String customerNumberLabel934034564 = "Kundennummer 934034564";
    public static String landlineNumberProvided = "1528697";
    public static String emailNotProvidedMessage = "Du hast keine E-Mail-Adresse angegeben.";
    public static String downloadCustomerDataBtn = "Kundendaten herunterladen";
    public static String downloadCustomerDataPageTitle = "Kundendaten herunterladen";
    public static String customerDataWindowTitle = "Deine Kundendaten zu diesem Vertrag";
    public static String customerDataNotificationTitle = "Kundendaten";
    public static String customerDataNotificationBody = "Hier kannst Du alle personenbezogenen Daten herunterladen, die wir zu diesem Vertrag gespeichert haben.";
    public static String customerDataNotificationNote = "Wichtig: Jeder Vertrag hat einen eigenen Download.";
    public static String downloadCustomerDataAsCSV = "Kundendaten herunterladen";
    public static String adressenSOHeaderCL = "Addressen";
    public static String adressenSOFooterCL = "Adressen verwalten und Umzug beauftragen";
    public static String confirmEditButtonCL = "Übersicht";
    public static String informative_MessageCL = "Gut zu wissen:";
    public static String success_MessageCL = "Deine Adresse haben wir geändert.";

    public static String meineDokumenteSOHeaderCL = "Dokumente";
    public static String meineDokumenteSOFooterCL = "Verträge, Rechnungen und Kommunikation";
    public static String dokumenteLinkoutCL = "Dokumente";

    //TopNavigations
    public static String topNav1CL = "Meine Rechnungen";
    public static String topNav2CL = "Kabel-TV - Tarif";
    public static String topNav3CL = "Internet & Phone - Tarif";
    public static String topNav4CL = "Meine Daten";
    public static String internetAndPhoneTariftitleCL = "Internet & Phone – Tarif";
    public static String kabelTVTraifTitleCL = "Kabel-TV – Tarif";
    public static String subTitleCL =
            "Unity Media Horizon Go Test (Kundennummer: 341449201)";
    public static String headerCL =
            "Hier findest Du alles zu Deinen Rechnungen";

    public static String adressenAccTitleCL = "Adressen";
    public static String adressenAccTextCL = "Adressen verwalten und Umzug beauftragen";
    public static String suspendedMsg_Billing_Address_TitleCL = "Wichtig für Dich";
    public static String suspendedMsg_Billing_Address_TextCL = "Du kannst die Adresse nicht ändern, weil noch Rechnungen zu diesem Vertrag offen sind.";
    public static String suspendedMsg_Service_Address_TitleCL = "Wichtig für Dich";
    public static String suspendedMsg_Service_Address_TextCL = "Du kannst keinen Umzug beauftragen, weil noch Rechnungen zu diesem Vertrag offen sind.";


    //Cls not develop yet
    public static String customerNumberLabel390171300 = "Kundennummer 390171300";
    public static String customerNumberLabel390271301 = "Kundennummer 390271301";
    public static String customerNumberLabel390371302 = "Kundennummer 390371302";
    public static String customerNumberLabel390471303 = "Kundennummer 390471303";
    public static String customerNumberLabel332881148 = "Kundennummer 332881148";
    public static String customerNumberLabel934301035 = "Kundennummer 934301035";
    public static String telephoneNumberLabel = "Telefonnummer";
    public static String contactDataEmailValidated = "Mohamed@vodafone.com";
    public static String contactDataEmailValidatedSIT = "manar.mohamed-kamal@vodafone.com";
    public static String contactDataEmailNotValidated = "Mohamed@vodafone.com";
    public static String bank_DetailsSO_HeaderCL = "Bankverbindung";
    public static String bankDetailsSOAccDescriptionCL = "Bankverbindung anzeigen und ändern";
    public static String bankDetailsHeader_Cl = "Deine Bankverbindung:";
    public static String editBankDetailsBtn_Cl ="Bankverbindung bearbeiten";
    public static String changeBankDetailsNotificationHeader_Cl="Bankverbindung wurde geändert";
    public static String changeBankDetailsNotificationBody_Cl="Du hast Deine Bankverbindung schon geändert. Es kann 1 bis 2 Tage dauern, bis wir die Änderung umgesetzt haben.";

    //Locators
    public static By pageTitle = By.xpath("//*[@automation-id='pageHeader_tv']/h1");

    public static By nextBTNSUSHI = By.xpath("//a[@class='bx-next']");
    public static final By meineDokumenteSO = By.xpath("//div[@automation-id='documentsInbox_so']");
    public static final By meineDokumenteSOHeader = By.xpath("//div[@automation-id='documentsInbox_so']/smart-object-header/div/h3");
    public static final By meineDokumenteSOFooter = By.xpath("//div[@automation-id='documentsInbox_so']/smart-object-footer/div");
    public static final By dokumenteLinkout = By.xpath("(//a[@class='ac-head accordion-state']/span)[1]");

    public static final By datenschutzSmartObject = By.xpath("//div[@automation-id='datenschutz_so']");
    public static final By datenschutzAccordion = By.xpath("//h4[text()='Datenschutz & Werbeeinstellungen']");
    public static final By datenschutzSmartObjectHeaderText = By.xpath("//h3[text()='Datenschutz- & Werbe-Einstellungen']");
    public static final By datenschutzSmartObjectFooterText = By.xpath("//div[text()='Hier schützt Du Deine Privatsphäre']");
    public static final By datenschutzAccordionHeaderText = By.xpath("//h4[text()='Datenschutz & Werbeeinstellungen']");
    public static final By datenschutzAccordionFooterText = By.xpath("//h5[contains(text(),'Hier schützt Du Deine Privatsphäre')]");
    public static final By meinekundenDatenPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    public static final By meinekundendatenSmartObjectHeader = By.xpath("//*[@automation-id='contactDetails_so']/smart-object-header/div/h3");
    public static final By meinekundendatenSmartObjectFooter = By.xpath("//*[@automation-id='contactDetails_so']/smart-object-footer/div");
    public static final By meinekundendatenAccordionHeader = By.xpath("//li[@automation-id='kontaktdaten_acc']/a/h4");
    public static final By meinekundendatenAccordionFooter = By.xpath("//li[@automation-id='kontaktdaten_acc']/a/h5");
    public static final By loginDatenSectionHeaderLocator = By.xpath("//h3[@automation-id='contactDetails_login_headline_tv'] ");
    public static final By loginDatenSectionFooterLocator = By.xpath("//p[@automation-id='contactDetails_login_description_tv']");
    public static final By userNameLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_userName_tv']/h5");
    public static final By slutationLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_title_tv']/h5");
    public static final By lastNameLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_lastName_tv']/h5");
    public static final By firstNameLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_firstName_tv']/h5");
    public static final By loginDatenEmailLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_email_tv']/h5");
    public static final By loginDatenEmailLocator = By.xpath("//div[@automation-id='contactDetails_login_email_tv']/span");
    public static final By loginDatenEditButtonLocator = By.xpath("//a[@automation-id='contactDetails_emailValidated_Link']");
    public static final By kundenKontaktdatenSectionHeaderLocator = By.xpath("//h3[@automation-id='contactData_headline_tv' and normalize-space(text())='Kunden-Kontaktdaten']");
    public static final By kundenKontaktdatenSectionFooterLocator = By.xpath("//h5[@automation-id='contactData_subheadline_tv']");
    public static final By kabelDeutschlandTitleLocator = By.xpath("//h3[@class='smallMargin']");
    public static final By KundennummerLocator = By.xpath("//h5[@class='mbo-msisdn']");
    public static final By mobilePhoneLabelLocator = By.xpath("//div[@automation-id='contactData_MobilePhone_tv']/h5");
    public static final By mobilePhoneLocator = By.xpath("//div[@automation-id='contactData_MobilePhone_tv']/span");
    public static final By landlineLabelLocator = By.xpath("//div[@automation-id='contactData_HousePhone_tv']/h5");
    public static final By landlineLocator = By.xpath("//div[@automation-id='contactData_HousePhone_tv']/span");
    public static final By contactDataEmailLabelLocator = By.xpath("//div[@automation-id='contactData_Email_tv']/h5");
    public static final By contactDataEmailLocator = By.xpath("//div[@automation-id='contactData_Email_tv']/span");
    public static final By contactdataEditButtonlocator = By.xpath("//button[@automation-id='contactData_submit_btn']");
    public static final By downloadCustomerDataBtnlocator = By.xpath("(//a[@class='ac-head accordion-state'])[4]");

    public static final By downloadCustomerDataPageTitlelocator = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    public static final By customerDataWindowTitleLocator = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    public static final By customerDataNotificationTitleLocator = By.xpath("//div[@automation-id='gdprDescription_tv']/h3");
    public static final By customerDataNotificationBodyLocator = By.xpath("(//div[@automation-id='gdprDescription_tv']/p)[1]");
    public static final By customerDataNotificationNoteLocator = By.xpath("(//div[@automation-id='gdprDescription_tv']/p)[2]");
    public static final By downloadCustomerDataAsCSVLocator = By.xpath("//button[@automation-id='gdprDownloadData_btn']");
    public static final By adressenAcc = By.xpath("//*[@id='adressen']");
    public static final By addressenSO = By.xpath("//*[@automation-id='adresses_so']");
    public static final By homezoneAddressSectionTitle = By.xpath("(//*[@automation-id='adressen_acc']//h4)[5]");
    public static final By homezoneAddressSectionHeader = By.xpath("(//*[@class='white-box']//address-selection-header)[3]");
    public static final By homezoneAddress_Telfon = By.xpath("(//*[@class='display-flex']/div)[3]");
    public static final By homezoneAddressText = By.xpath("(//*[@class='checklist-content-multiline'])[4]");
    public static final By homezoneAddressSection_EditButton = By.xpath("(//*[@class='btn btn-em mb-0'])[2]");
    public static final By bank_DetailsSO = By.xpath("//*[@automation-id='bankverbindung_acc']");
    public static final By bank_DetailsSO_Header = By.xpath("//*[@automation-id='bankDetails_so']//h3");
    public static final By bank_DetailsSO_Footer = By.xpath("(//*[@class='sb-block-footer'])[3]");
    public static final By ownerName_field = By.xpath("//*[@automation-id='accountOwnerName_tv']");
    public static final By iban_field = By.xpath("//*[@automation-id='iban_tv']");
    public static final By btc_Field = By.xpath("//*[@automation-id='bic_tv']");
    public static final By bankName_field = By.xpath("//*[@automation-id='bankName_tv']");
    public static final By editBankDetails_Btn = By.xpath("//*[@automation-id='changeBank_btn']");

    public static final By editAddressButtonlocator = By.xpath("(//*[@automation-id='edit_address_btn'])");

    /*Edit Address Page's Locators*/
    public static final By changeAddressButton = By.xpath("//*[@automation-id='change_address_rb']");
    public static final By rechnungsanschrift_AddressenCheckBox = By.xpath("//*[@automation-id='check_box_chk'])[2]");
    public static final By secondEditButton = By.xpath("(//*[@automation-id='edit_address_btn'])[2]");
    public static final By teilnehmer_Adresse_vorname = By.xpath("//*[@automation-id='input2_et']");
    public static final By submitButton = By.xpath("//*[@automation-id='submit_form_btn']");
    public static final By confirmationStepTwo = By.xpath("//*[@id='stepper-component-step-2']//div[2]//h3");
    public static final By confirmationButton = By.xpath("//*[@automation-id='confirm_btn']");
    /*third step of edit address locators*/
    public static final By success_Message = By.xpath("//*[@class='alert noselect success no-text']//h4");
    public static final By informative_Message = By.xpath("//*[@class='flexDiv']");
    public static final By confirmEditButton = By.xpath("//*[@id='confirmEdit']//a/span");


    public static final By addAddressButton = By.xpath("//*[@automation-id='add_address_rb']/input");
    public static final By deleteAddressButton = By.xpath("//*[@automation-id='delate_address_rb']/input");
    public static final By adressenAcc_Title = By.xpath("//li[@automation-id='adressen_acc']//a/h4");
    public static final By adressenAcc_Text = By.xpath("//li[@automation-id='adressen_acc']//a/h5");

    /*AddressenAccordion_SuspendedUser*/
    public static final By suspendedMsg_Billing_Address_Title = By.xpath("//*[@automation-id='addressesSuspended_nt']//h4");
    public static final By suspendedMsg_Billing_Address_Text = By.xpath("//*[@automation-id='addressesSuspended_nt']//p");
    public static final By suspendedMsg_Service_Address_Title = By.xpath("//*[@id='order']//div[2]/h4");
    public static final By suspendedMsg_Service_Address_Text = By.xpath("//*[@id='order']//div[2]/p");
    public static final By rechnungLinkout = By.xpath("//*[@automation-id='addressesSuspended_nt']//span/span");
    /*TopNavigation*/
    public static final By topNav1Locator = By.xpath("(//*[@class='inline-block']/strong/span)[1]");
    public static final By topNav2Locator = By.xpath("(//*[@class='inline-block']/strong/span)[2]");
    public static final By topNav3Locator = By.xpath("(//*[@class='inline-block']/strong/span)[3]");
    public static final By pageSubTitle = By.xpath("//*[@automation-id='pageHeader_tv']/h2");
    public static final By headerRechnungen = By.xpath("//*[@id='content']/div[2]//cable-bills-list/p");
    public static final By kabelTVTarif = By.xpath("/    //*[@id='content']/div[2]//ul/li[1]/a");
    //locators not develop yet
    public static final By telephoneNumberLabelLocator = By.xpath("//div[@automation-id='contactData_OfficePhone_tv']/h5");//PhoneNumber
    public static final By telephoneNumberLocator = By.xpath("//div[@automation-id='contactData_OfficePhone_tv']/span");//PhoneNumber
    public static By bankDetailsHeader_Locator = By.xpath("//bank-details-view[@type='cable']//h4");
    private static By bankverbindungAccordionExpandLink = By.xpath("//li[@automation-id='bankverbindung_acc']/a");
    private static By changedBankDetailsNotificationHeader_Locator = By.xpath("//notification[@automation-id='changeBankPending_nt']//h4");
    private static By changedBankDetailsNotificationBody_Locator = By.xpath("//notification[@automation-id='changeBankPending_nt']//p");
    private static By changedBankDetailsNotification = By.xpath("//div[@class='alert noselect inProgress']");



    //constructor
    public MeineDaten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public void clickOnSmartObject(MeineDatenSmartObjects smartObject) {
        switch (smartObject) {
            case DATENSCHUTZWERBEEINSTELLUNGEN -> {
                driver.element().click(datenschutzSmartObject);
            }
            case KONTAKTDATEN -> {
                driver.element().click(meinekundendatenSmartObjectHeader);
            }
            case DOKUMENTE -> {
                driver.element().click(meineDokumenteSO);
            }
        }
    }

    public void pressOnSmartObject(MeineDatenSmartObjects smartObject) {
        switch (smartObject) {
            case DATENSCHUTZWERBEEINSTELLUNGEN -> {
                driver.element().click(datenschutzSmartObject);
            }
        }

    }


    public void clickOnEditContactDataButton() {
        driver.element().click(contactdataEditButtonlocator);
    }

    public void clickOnSubmitButton() {
        driver.element().click(submitButton);
    }

    public void clickOnConfirmationButton() {
        driver.element().click(confirmationButton);
    }


    //Enums
    public enum MeineDatenSmartObjects {
        DATENSCHUTZWERBEEINSTELLUNGEN,
        KONTAKTDATEN,
        DOKUMENTE
    }

    public void clickOnDownloadCustomerDataButton() {
        driver.element().click(downloadCustomerDataBtnlocator);
    }

    public void clickOnDownloadCustomerDataAsCSVButton() {
        driver.element().click(downloadCustomerDataAsCSVLocator);
    }


    public void clickOnMeineDokumenteSO() {
        driver.element().click(meineDokumenteSO);
    }

    public void clickOnAddressenSO() {
        driver.element().click(addressenSO);
    }

    public void clickOnNEXTBTNSUSHI() {
        driver.element().click(nextBTNSUSHI);
    }


    public void clickOnDokumenteLinkout() {
        driver.element().click(dokumenteLinkout);
    }

    public void clickOnAdressenAcc() {
        driver.element().click(adressenAcc_Title);
    }

    public void clickOnEditAdressenButton() {
        driver.element().click(editAddressButtonlocator);
    }

    public void clickOnChangeAdressButton() {
        driver.element().click(changeAddressButton);
    }

    public void clickOnRechnungsanschriftAddress_Checkbox() {
        driver.element().click(rechnungsanschrift_AddressenCheckBox);
    }

    public void clickOnSecondEditButton() {
        driver.element().click(secondEditButton);
    }

    public void deletevornametextbox(By Teilnehmer_Adresse_vorname) {
        driver.getDriver().findElement(Teilnehmer_Adresse_vorname).clear();
    }

    public void ExpandBankDetailsAccordion() {
        driver.element().click(BankDetailsSOLocator);
    }
    /*public void afterDeleteTextBoxHandler(WebDriver driver.getDriver(), By elementLocator){
        driver.element().type(elementLocator,"a");
        driver.findElement(elementLocator).sendKeys(Keys.BACK_SPACE);
    }*/

    public void Editvorname(String vorname) {
        (driver.getDriver().findElement(teilnehmer_Adresse_vorname)).sendKeys(vorname);
    }

    public void clickOnRechnungLinkout() {
        driver.element().click(rechnungLinkout);
    }

    public void clickOnTopNav1() {
        driver.element().click(topNav1Locator);
    }

    public void clickOnTopNav2() {
        driver.element().click(topNav2Locator);
    }

    public void clickOnTopNav3() {
        driver.element().click(topNav3Locator);
    }

    public void clickOnHomezoneAddress_EditButton() {
        driver.element().click(homezoneAddressSection_EditButton);
    }

    public void clickOnBankDetailsSO() {
        driver.element().click(bank_DetailsSO);
    }
    @Step("Click on edit bank details button")
    public void clickOnEditBankDetails_Btn() {
        driver.element().click(editBankDetails_Btn);
    }

    /* **************** WFCT-13466 ********* */

    //CL
    private static String bankDetailsAccHeaderCL = "Hier findest Du Deine Bankverbindungen.";
    private static String noBackDetailsRedNotificationHeaderCL = "Keine Bankverbindung vorhanden";
    private static String noBackDetailsRedNotificationDescriptionCL = "Kostenlos, sicher und bequem: Entscheide Dich für das Lastschriftverfahren – erteil uns eine Einzugsermächtigung.";
    private static String addBankDetailsButtonCl = "Bankverbindung angeben";
    private static String bankDetailsDunningUserNotificationHeaderCl = "Sperrung wegen Zahlungsrückstand";
    private static String bankDetailsDunningUserNotificationBodyCl = "Dein Kundenkonto ist gesperrt. Zurzeit kannst Du es nur eingeschränkt nutzen und keine Änderungen vornehmen.";

    //Locators
    private static final By bankDetailsAccTextLocator = By.xpath("(//div[@id='bankDetailsAccordionId']//h4)[1]");
    private static final By BankDetailsNotificationHeaderLocator = By.xpath("(//div[@automation-id='successMsg_tv']//h4)[1]");
    private static final By BankDetailsNotificationDescriptionLocator = By.xpath("(//div[@automation-id='successMsg_tv']//p)[1]");
    private static final By addBankDetailsButtonLocator = By.xpath("//button[@automation-id='undefined_btn']");
    private static final By BankDetailsSOLocator = By.xpath("//div[@automation-id='bankDetails_so']");
    private static final By bankDetailsAccHeaderTextLocator = By.xpath("(//li[@automation-id='bankverbindung_acc']//h4)[1]");
    private static final By bankDetailsAccTextBelowHeaderLocator = By.xpath("//li[@automation-id='bankverbindung_acc']//h5");



    //methods
    @Step("Click on bank details SO")
    public void clickOnBankAccountSO() {
        driver.element().click(BankDetailsSOLocator);

    }

    @Step("click on add bank details button")
    public void clickAddBankDetailsButton() {
        driver.element().click(addBankDetailsButtonLocator);
    }
    @Step("wait till the dunning notification appears")
    public void waitTillTheDunningNotificationAppears(){
        driver.element().waitToBeReady(BankDetailsNotificationHeaderLocator);
    }
    @Step("wait till the changed bank details notification appears")
    public void waitTillTheChangedBankDetailsNotificationAppears(){
        driver.element().waitToBeReady(BankDetailsNotificationHeaderLocator);
    }

    //verification
    public void assertOnBankDetailsAccHeader() {
        driver.verifyThat().element(bankDetailsAccHeaderTextLocator).text().isEqualTo(bank_DetailsSO_HeaderCL)
                .withCustomReportMessage("Assert On BankVerbindun Acc header text")
                .perform();
    }

    public void assertOnBankDetailsAccTextBelowHeader() {
        driver.verifyThat().element(bankDetailsAccTextBelowHeaderLocator).text().isEqualTo(bankDetailsSOAccDescriptionCL)
                .withCustomReportMessage("Assert On BankVerbindun Acc header text")
                .perform();
    }

    public void assertOnBankDetailsAccText() {
        driver.verifyThat().element(bankDetailsAccTextLocator).text().isEqualTo(bankDetailsAccHeaderCL)
                .withCustomReportMessage("Assert On BankVerbindun Acc text")
                .perform();
    }

    public void assertOnNoBankDetailsNotificationTitle() {
        driver.verifyThat().element(BankDetailsNotificationHeaderLocator).text().isEqualTo(noBackDetailsRedNotificationHeaderCL)
                .withCustomReportMessage("Assert On no bank details notification header")
                .perform();
    }


    public void assertOnNoBankDetailsNotificationDescription() {
        driver.verifyThat().element(BankDetailsNotificationDescriptionLocator).text().isEqualTo(noBackDetailsRedNotificationDescriptionCL)
                .withCustomReportMessage("Assert On no bank details notification description")
                .perform();
    }

    public void assertOnAddBankDetailsButtonCl() {
        driver.verifyThat().element(addBankDetailsButtonLocator).text().isEqualTo(addBankDetailsButtonCl)
                .withCustomReportMessage("Assert On add bank details button cl")
                .perform();
    }

    public void assertOnDunningUserNotification() {
        driver.verifyThat().element(BankDetailsNotificationHeaderLocator).textTrimmed().isEqualTo(bankDetailsDunningUserNotificationHeaderCl).withCustomReportMessage("assert on bank details for dunning user header").perform();
        driver.verifyThat().element(BankDetailsNotificationDescriptionLocator).textTrimmed().isEqualTo(bankDetailsDunningUserNotificationBodyCl).withCustomReportMessage("assert on bank details for dunning user description").perform();
    }

    public void assertThatAddBankDetailsButtonDoesNotExist() {
        driver.verifyThat().element(addBankDetailsButtonLocator).doesNotExist().withCustomReportMessage("assert that add bank details button doesnot exist").perform();
    }

    public void assertOnEditBankDetailsCl(){
        driver.assertThat().element(editBankDetails_Btn).textTrimmed().isEqualTo(editBankDetailsBtn_Cl).withCustomReportMessage("assert on edit bank details button cl").perform();
    }
    public void assertOnChangedBankDetailsNotification() {
        driver.verifyThat().element(changedBankDetailsNotificationHeader_Locator).text().isEqualTo(changeBankDetailsNotificationHeader_Cl).withCustomReportMessage("assert on changed bank details header").perform();
        driver.verifyThat().element(changedBankDetailsNotificationBody_Locator).text().isEqualTo(changeBankDetailsNotificationBody_Cl).withCustomReportMessage("assert on changed bank details description").perform();
        driver.verifyThat().element(changedBankDetailsNotification).cssProperty("background")
                .contains("240, 247, 249")
                .withCustomReportMessage("Assert on changed bank details notification color")
                .perform();
    }

    public void assertThatEditBankDetailsButtonIsDisabled(){
        driver.assertThat().element(editBankDetails_Btn).isDisabled().withCustomReportMessage("assert that edit bank details button is disabled").perform();
    }
    public void assertThatEditBankDetailsButtonDoesntExist(){
        driver.assertThat().element(editBankDetails_Btn).doesNotExist().withCustomReportMessage("assert that edit bank details button doesn't exist").perform();
    }
}
