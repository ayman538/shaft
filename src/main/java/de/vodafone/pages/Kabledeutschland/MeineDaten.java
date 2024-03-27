package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.Kabledeutschland.Dashboard.DashboardSmartObject.MEINEKUNDENDATEN;
import static de.vodafone.pages.utils.ElementActions.clickOnPopupElement;

public class MeineDaten {
    //Variables
    private SHAFT.GUI.WebDriver driver;
    private static String EmailRegex = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";

    //CLs
    private static String MeineDatenText = "Meine Daten";
    private static String KontaktdatenText = "Kontaktdaten";
    private static String MeineKundendatenSmartObjectFooterText = "Kontaktdaten anzeigen und ändern";
    private static String MeineKundendatenAccordionFooter = "Kontaktdaten anzeigen und ändern. Bestätige hier Deine E-Mail-Adresse.";
    public static String LoginDataSectionHeader = "Login-Daten";
    public static String LoginDataSectionFooter = "Deine Anmeldedaten und wie wir Dich in MeinVodafone ansprechen dürfen.";
    public static String UserNameLabel = "Benutzername:";
    public static String SalutationLabel = "Anrede:";
    public static String LastNameLabel = "Nachname:";
    public static String FirstNameLabel = "Vorname:";
    public static String EmailLabel = "E-Mail:";
    public static String LoginDataEditButton = "Login-Daten bearbeiten";
    public static String ContactDataSectionHeader = "Kunden-Kontaktdaten";
    public static String ContactDataSectionHeaderSOHO = "Kunden-Kontaktdaten";
    public static String ContactDataSectionFooter = "So bekommst Du immer und überall wichtige Infos zu Deinem Vertrag, Deinen Rechnungen und persönliche Infos von uns.";
    public static String MeinKabelTitle = "MeinKabel";
    public static String KabelDeutschlandTitle = "Kabel Deutschland";
    public static String CustomerNumberLabel = "Kundennummer";
    public static String HomeNumberTitle_Cl = "Handy-Nummer:";
    public static String MobileNumTitle_CL = "Telefon privat:";
    public static String PhoneNumberNotProvidedMessage = "Du hast keine Rufnummer angegeben.";
    public static String ContactDataEmailLabel = "Service-E-Mail-Adresse:";
    public static String ContactDataEmail = "gicksgacks@test.de";
    public static String ContactDataEditButton = "Kontaktdaten bearbeiten";
    public static String LandlineNumberProvided = "1528697";
    public static String EmailNotProvidedMessage = "Du hast keine E-Mail-Adresse angegeben.";
    private static String DownloadCustomerDataBtn = "Kundendaten herunterladen";
    private static String DownloadCustomerDataPageTitle = "Kundendaten herunterladen";
    private static String CustomerDataWindowTitle = "Deine Kundendaten zu diesem Vertrag";
    private static String CustomerDataNotificationTitle = "Kundendaten";
    private static String CustomerDataNotificationBody = "Hier kannst Du alle personenbezogenen Daten herunterladen, die wir zu diesem Vertrag gespeichert haben.";
    private static String CustomerDataNotificationNote = "Wichtig: Jeder Vertrag hat einen eigenen Download.";
    private static String DownloadCustomerDataAsCSV = "Kundendaten als CSV herunterladen";


    public static String TelephoneNumberLabel = "Telefonnummer";
    public static String ContactDataEmailValidated = "Mohamed@vodafone.com";
    public static String ContactDataEmailValidatedSIT = "manar.mohamed-kamal@vodafone.com";
    public static String ContactDataEmailNotValidated = "Mohamed@vodafone.com";

    public static String InformationFromVodafoneSectionCL = "Informationen von Vodafone";
    public static String InformationFromVodafoneDescriptionCL = "Leg hier fest, wie wir Dich über unsere Produkte, Services und persönlich zugeschnittene Angebote informieren dürfen.";
    public static String PersonalDataSectionCL = "Persönliche Daten";
    public static String PersonalDataDescriptionCL = "Leg hier fest, ob und wie wir Deine persönlichen Daten nutzen dürfen, z.B. um Dich über unsere Produkte zu informieren.";
    public static String ConnectionDataSectionCL = "Verbindungsdaten";
    public static String ConnectionDataDescriptionCL = "Wir brauchen Deine Nutzungsdaten, um eine Verbindung herzustellen und aufrecht zu halten. Das sind z.B. Deine Rufnummer und die Nummer Deines Gesprächspartners oder Beginn und Ende der Verbindung.";
    public static String InternetUsageSectionCL = "Internet-Nutzung";
    public static String InternetUsageDescriptionCL = "Wähl aus, ob wir z.B. Dein Surf-Verhalten mitverfolgen dürfen, um Dir passende Produkte vorzuschlagen.";
    public static String PersonalOffersSectionCL = "Persönliche Angebote";
    public static String PersonalOffersDescriptionCL = "Leg hier fest, ob Du von uns persönliche Angebote im Web und in den Apps angezeigt bekommen möchtest.";
    public static String EditBtnCL = "Bearbeiten";

    private static String MeineDokumenteSOHeaderCL = "Dokumente";
    private static String MeineDokumenteSOFooterCL = "Verträge, Rechnungen und Kommunikation";
    private static String DokumenteLinkoutCL = "Dokumente";


    //View bank details CL
    private static String Acc_TitleCL = "Deine Bankverbindung";
    private static String Acc_DescriptionCL = "Hier findest Du Deine Bankverbindungen. Du kannst zu jedem Produkt eine eigene Bankverbindung angeben.";
    private static String Account_Owner_labelCL = "Kontoinhaber";
    private static String IBAN_labelCL = "IBAN";
    private static String BIC_LabelCL = "BIC";
    private static String Bank_LabelCL = "Bank";
    private static String Direct_Debit_Authorization_LabelCL = "Einzugsermächtigung";
    private static String Used_For_LabelCL = "Verwendet für:";
    private static String Reference_account_LableCL = "Referenzkonto";
    private static String KIP_CL = "Internet & Phone Vertrag";
    private static String Kabel_TV_CL = "Kabel TV Vertrag";
    private static String Giga_Cube_CL = "GigaCube Vertrag";
    private static String Change_Bank_Account_Btn_CL = "Bankverbindung ändern";
    private static String Store_Different_Bank_Account_Text_CL = "Du möchtest eine weitere Bankverbindung für Deine Produkte hinterlegen? Dann klick hier.";
    private static String Store_Different_Bank_Account_Link_CL = "hier.";
    private static String Self_Payer_Notification_Title_CL = "Gut zu wissen";
    private static String Self_Payer_Notification_Description_CL = "Du hast uns noch kein SEPA-Lastschriftmandat erteilt. Du möchtest das ändern? Ruf uns einfach kostenlos unter 0800 172 1212 an.";
    private static String Dunning_Notification_Title_CL = "Offener Rechnungsbetrag";
    private static String Dunning_Notification_Description_CL = "Du kannst zurzeit nichts bearbeiten, weil ein Rechnungsbetrag noch offen ist. Überweis bitte den offenen Betrag.";
    //soho CLs for view bank details
    private static String Company_LabelCL = "Firma";
    private static String Contact_Person_LabelCL = "Ansprechpartner";
    private static String CTA_ChangeBankDetailsNotificationTitleCL = "Nur noch eine Bankverbindung nutzen";
    private static String CTA_ChangeBankDetailsNotificationBodyCL = "So buchen wir alle Deine Rechnungsbeträge von einem Bankkonto ab.";
    private static String CTA_ChangeBankDetailsNotificationBtnCL = "Bankverbindung bearbeiten";

    //View Billing Addresses CLs
    private static String Addresses_Acc_TitleCL = "Rechnungsadressen";
    private static String Addresses_Acc_DescriptionCL = "Du möchtest Deinen Namen ändern, weil Du geheiratest hast oder der Vertragsinhaber wechselt? Die passenden Formulare gibt’s hier.";
    private static String Addresses_Used_For_LabelCL = "Verwendet für:";
    private static String Addresses_Reference_accountCL = "Referenzkonto";
    public static String Addresses_KIP_ProductCL = "Internet & Phone Vertrag";
    public static String Addresses_KabelTV_ProductCL = "Kabel TV Vertrag";
    public static String Addresses_CLS_ProductCL = "GigaCube Vertrag";
    private static String Change_Addresses_BtnCL = "Adresse bearbeiten";
    private static String Store_Different_Addresses_TextCL = "Du möchtest verschiedene Rechnungsadressen für Deine Produkte hinterlegen? Dann klick hier.";
    private static String Store_Different_Addresses_LinkCL = "hier.";
    private static String Change_All_Addresses_Notification_TitleCL = "Nur noch eine Adresse nutzen";
    private static String Change_All_Addresses_Notification_DescriptionCL = "So bekommst Du alle Deine Rechnungen an eine Adresse.";
    private static String Service_Addresses_TitleCL = "Anschlussadresse";
    private static String Service_Addresses_DescriptionCL = "Hier kannst Du Deinen Umzug online beauftragen.";
    private static String No_Billing_Addresses_Notification_TitleCL = "Gut zu wissen";
    private static String No_Billing_Addresses_Notification_DescriptionCL = "Wir nutzen für Deine Rechnung Deine Anschlussadresse. Du willst das ändern? Ruf uns einfach an: 0800 172 1212";
    private static String Dunning_Addresses_Notification_TitleCL = "Offener Rechnungsbetrag";
    private static String Dunning_Addresses_Notification_DescriptionCL = "Du kannst zurzeit nichts bearbeiten, weil ein Rechnungsbetrag noch offen ist. Überweis bitte den offenen Betrag.";
    private static String Change_ALL_Addresses_BtnCL = "Adressen bearbeiten";
    private static String badCase_Notification_TitleCL = "Entschuldigung, da ist was schiefgelaufen.";
    private static String badCase_Notification_DescriptionCL = "Bitte versuchen Sie es später nochmal.";

    //Locators
    public static final By DatenschutzSmartObject = By.xpath("//div[@automation-id='datenschutz_so']");
    //public static final By DatenschutzAccordion = By.xpath("//li[@automation-id='datenschutz-einstellungen_acc']");
    public static final By DatenschutzAccordion = By.xpath("//h4[text()='Datenschutz & Werbeeinstellungen']");

    public static final By DatenschutzAccordionHeaderText = By.xpath("(//*[@automation-id=\"datenschutz-einstellungen_acc\"]//h4)[1]");
    public static final By DatenschutzAccordionFooterText = By.xpath("//*[@automation-id=\"datenschutz-einstellungen_acc\"]//h5");
    private static final By MeinekundenDatenPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private static final By MeinekundendatenSmartObjectHeader = By.xpath("//*[@automation-id='contactDetails_so']/smart-object-header/div/h3");
    private static final By MeinekundendatenSmartObjectFooter = By.xpath("//*[@automation-id='contactDetails_so']/smart-object-footer/div");
    private static final By MeinekundendatenAccordionHeader = By.xpath("//li[@automation-id='kontaktdaten_acc']/a/h4");
    private static final By MeinekundendatenAccordionFooter = By.xpath("//li[@automation-id='kontaktdaten_acc']/a/h5");
    public static final By LoginDatenSectionHeaderLocator = By.xpath("//h3[@automation-id='contactDetails_login_headline_tv'] ");
    public static final By LoginDatenSectionFooterLocator = By.xpath("//p[@automation-id='contactDetails_login_description_tv']");
    public static final By UserNameLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_userName_tv']/h5");
    public static final By SalutationLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_title_tv']/h5");
    public static final By LastNameLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_lastName_tv']/h5");
    public static final By FirstNameLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_firstName_tv']/h5");
    public static final By LoginDatenEmailLabelLocator = By.xpath("//div[@automation-id='contactDetails_login_email_tv']/h5");
    public static final By LoginDatenEmailLocator = By.xpath("//div[@automation-id='contactDetails_login_email_tv']/span");
    public static final By LoginDatenEditButtonLocator = By.xpath("//button[@automation-id='email-not-validated_btn']");
    public static final By KundenKontaktdatenSectionHeaderLocator = By.xpath("//*[@automation-id='contactData_headline_tv']");
    public static final By KundenKontaktdatenSectionFooterLocator = By.xpath("//h5[@automation-id='contactData_subheadline_tv']");
    public static final By KabelDeutschlandTitleLocator = By.xpath("//h3[@class='smallMargin']");
    public static final By KundennummerLocator = By.xpath("//h5[@class='mbo-msisdn']");
    public static final By HomeNumberTitle = By.xpath("//div[@automation-id='contactData_MobilePhone_tv']/h5");
    public static final By HomeNumberContent = By.xpath("//div[@automation-id='contactData_MobilePhone_tv']/span");
    public static final By MobileNumTitle = By.xpath("//div[@automation-id='contactData_HousePhone_tv']/h5");
    public static final By MobileNumContent = By.xpath("//div[@automation-id='contactData_HousePhone_tv']/span");
    public static final By ContactDataEmailLabelLocator = By.xpath("//div[@automation-id='contactData_Email_tv']/h5");
    public static final By ContactDataEmailLocator = By.xpath("//div[@automation-id='contactData_Email_tv']/span");
    public static final By ContactdataEditButtonlocator = By.xpath("//button[@automation-id='contactData_btn']");
    private static final By DownloadCustomerDataBtnlocator = By.xpath("(//a[@class='ac-head accordion-state']//span)[2]");
    private static final By DownloadCustomerDataPageTitlelocator = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private static final By CustomerDataWindowTitleLocator = By.xpath("//span[@automation-id='oneStepStepperHeader_tv']");
    private static final By CustomerDataNotificationTitleLocator = By.xpath("//div[@automation-id='gdprDescription_tv']/h3");
    private static final By CustomerDataNotificationBodyLocator = By.xpath("(//div[@automation-id='gdprDescription_tv']/p)[1]");
    private static final By CustomerDataNotificationNoteLocator = By.xpath("(//div[@automation-id='gdprDescription_tv']/p)[2]");
    private static final By DownloadCustomerDataAsCSVLocator = By.xpath("//button[@automation-id='gdprDownloadData_btn']");
    private static final By initialPermissionLinkoutLocator = By.xpath("//a[contains(text(),'Hier kannst Du die ursprüngliche Beratungseinwilligung')]");
    private static final By dataProtectionLinkoutLocator = By.xpath("//a[contains(text(),'Alles zu unserem Datenschutz')]");

    public static final By telephoneNumberLabelLocator = By.xpath("//div[@automation-id='contactData_OfficePhone_tv']/h5");//PhoneNumber
    public static final By telephoneNumberLocator = By.xpath("//div[@automation-id='contactData_OfficePhone_tv']/span");//PhoneNumber

    public static final By InformationFromVodafoneSectionLocator = By.xpath("(//*[@class='serviceName'])[1]");
    public static final By InformationFromVodafoneDescriptionTxtLocator = By.xpath("(//*[@class='white-box'])[1]/p");
    public static final By EditBtn1Locator = By.xpath("(//*[@class='btn btn-sml btn-em'])[1]");
    public static final By PersonalDataSectionLocator = By.xpath("(//*[@class='serviceName'])[2]");
    public static final By PersonalDataDescriptionTxtLocator = By.xpath("(//*[@class='white-box'])[2]/p");
    public static final By EditBtn2Locator = By.xpath("(//*[@class='btn btn-sml btn-em'])[2]");
    public static final By ConnectionDataSectionLocator = By.xpath("(//*[@class='serviceName'])[3]");
    public static final By ConnectionDataDescriptionTxtLocator = By.xpath("(//*[@class='white-box'])[3]/p");
    public static final By EditBtn3Locator = By.xpath("(//*[@class='btn btn-sml btn-em'])[3]");
    public static final By InternetUsageSectionLocator = By.xpath("(//*[@class='serviceName'])[4]");
    public static final By InternetUsageDescriptionTxtLocator = By.xpath("(//*[@class='white-box'])[4]/p");
    public static final By EditBtn4Locator = By.xpath("(//*[@class='btn btn-sml btn-em'])[4]");
    public static final By PersonalOffersSectionLocator = By.xpath("(//*[@class='serviceName'])[5]");
    public static final By PersonalOffersDescriptionTxtLocator = By.xpath("(//*[@class='white-box'])[5]/p");
    public static final By EditBtn5Locator = By.xpath("(//*[@class='btn btn-sml btn-em'])[5]");

    public static By NEXTBTNSUSHI = By.xpath("//a[@class='bx-next']");
    public static final By MeineDokumenteSO = By.xpath("//div[@automation-id='documentsInbox_so']");
    private static final By MeineDokumenteSOHeader = By.xpath("//div[@automation-id='documentsInbox_so']//h3");
    private static final By MeineDokumenteSOFooter = By.xpath("//div[@automation-id='documentsInbox_so']/smart-object-footer/div");
    private static final By DokumenteLinkout = By.xpath("(//a[@class='ac-head accordion-state']/span)[1]");

    public static final By BankDetails_Acc = By.xpath("//li[@automation-id='bankverbindung_acc']");
    public static final By BankDetails_SO = By.xpath("//div[@automation-id='cableBankDetails_so']");

    public static final By Addresses_SO = By.xpath("//div[@automation-id='calbeAddress_so']");


    //View Bank details locators
    private static final By Acc_Title = By.xpath("//div[@automation-id='description_tv']/h3");
    private static final By Acc_Description = By.xpath("//div[@automation-id='description_tv']/p");
    private static final By Account_Owner_Label = By.xpath("(//div[@automation-id='owner_tv']/strong)[1]");
    private static final By Account_Owner = By.xpath("(//div[@automation-id='owner_tv']/span)[1]");
    private static final By IBAN_label = By.xpath("(//div[@automation-id='iban_tv']/strong)[1]");
    private static final By IBAN = By.xpath("(//div[@automation-id='iban_tv']/span)[1]");
    private static final By BIC_Label = By.xpath("(//div[@automation-id='bic_tv']/strong)[1]");
    private static final By BIC = By.xpath("(//div[@automation-id='bic_tv']/span)[1]");
    private static final By Bank_Label = By.xpath("(//div[@automation-id='bankName_tv']/strong)[1]");
    private static final By Bank = By.xpath("(//div[@automation-id='bankName_tv']/span)[1]");
    private static final By Direct_Debit_Authorization_Label = By.xpath("(//div[@automation-id='authority_tv']/strong)[1]");
    private static final By Direct_Debit_Authorization = By.xpath("(//div[@automation-id='authority_tv']/span)[1]");
    private static final By Used_For_Label = By.xpath("(//div//h5[@automation-id='referenceKonto-header_tv'])[1]");
    private static final By Account_Owner_Label_2 = By.xpath("(//div[@automation-id='owner_tv']/strong)[2]");
    private static final By Account_Owner_2 = By.xpath("(//div[@automation-id='owner_tv']/span)[2]");
    private static final By IBAN_label_2 = By.xpath("(//div[@automation-id='iban_tv']/strong)[2]");
    private static final By IBAN_2 = By.xpath("(//div[@automation-id='iban_tv']/span)[2]");
    private static final By BIC_Label_2 = By.xpath("(//div[@automation-id='bic_tv']/strong)[2]");
    private static final By BIC_2 = By.xpath("(//div[@automation-id='bic_tv']/span)[2]");
    private static final By Bank_Label_2 = By.xpath("(//div[@automation-id='bankName_tv']/strong)[2]");
    private static final By Bank_2 = By.xpath("(//div[@automation-id='bankName_tv']/span)[2]");
    private static final By Direct_Debit_Authorization_Label_2 = By.xpath("(//div[@automation-id='authority_tv']/strong)[2]");
    private static final By Direct_Debit_Authorization_2 = By.xpath("(//div[@automation-id='authority_tv']/span)[2]");
    private static final By Used_For_Label_2 = By.xpath("(//div//h5[@automation-id='referenceKonto-header_tv'])[2]");
    private static final By Reference_account1_Lable = By.xpath("(//div[@automation-id='referenceKonto_tv']//strong)[1]");
    private static final By Reference_account2_Lable = By.xpath("(//div[@automation-id='referenceKonto_tv']//strong)[3]");
    private static final By Reference_account3_Lable = By.xpath("(//div[@automation-id='referenceKonto_tv']//strong)[5]");
    private static final By FirstProduct = By.xpath("(//div[@automation-id='service_tv']//span)[1]");
    private static final By info_icon_1 = By.xpath("(//div[@automation-id='referenceKontoInfoIcon_tv']//a)[1]");
    private static final By SecondProduct = By.xpath("(//div[@automation-id='service_tv']//span)[2]");
    private static final By info_icon_2 = By.xpath("(//div[@automation-id='referenceKontoInfoIcon_tv']//a)[3]");
    private static final By ThirdProduct = By.xpath("(//div[@automation-id='service_tv']//span)[3]");
    private static final By info_icon_3 = By.xpath("(//div[@automation-id='referenceKontoInfoIcon_tv']//a)[5]");
    private static final By Change_Bank_Account_Btn = By.xpath("(//div//button[@automation-id='changeBank_btn'])[1]");
    public static final By EditOneByOneInvoices_LinkOut1 = By.xpath("(//*[@automation-id=\"changeOneByOne_Link\"])[1]");
    private static final By Change_Bank_Account_Btn_2 = By.xpath("(//div//button[@automation-id='changeBank_btn'])[2]");
    private static final By Store_Different_Bank_Account_Text = By.xpath("//p[@automation-id='changeOneByOne_tv']");
    private static final By Store_Different_Bank_Account_Link = By.xpath("//a[@automation-id='changeOneByOne_Link']");
    private static final By Self_Payer_Notification_Title = By.xpath("(//div[@automation-id='selfPayer_nt']//div//h4)[1]");
    private static final By Self_Payer_Notification_Description = By.xpath("(//div[@automation-id='selfPayer_nt']//div//p)[1]");
    private static final By Self_Payer_Notification_Title_2 = By.xpath("(//div[@automation-id='selfPayer_nt']//div//h4)[2]");
    private static final By Self_Payer_Notification_Description_2 = By.xpath("(//div[@automation-id='selfPayer_nt']//div//p)[2]");
    private static final By Dunning_Notification_Title = By.xpath("(//div[@automation-id='suspended_nt']//div//h4)[1]");
    private static final By Dunning_Notification_Description = By.xpath("(//div[@automation-id='suspended_nt']//div//p)[1]");
    private static final By Company_Label = By.xpath("(//div[@automation-id='company_tv']/strong)[1]");
    private static final By Company = By.xpath("(//div[@automation-id='company_tv']/span)[1]");
    private static final By Contact_Person_Label = By.xpath("(//div[@automation-id='contactPerson_tv']/strong)[1]");
    private static final By Contact_Person = By.xpath("(//div[@automation-id='contactPerson_tv']/span)[1]");
    private static final By Company_Label_2 = By.xpath("(//div[@automation-id='company_tv']/strong)[2]");
    private static final By Company_2 = By.xpath("(//div[@automation-id='company_tv']/span)[2]");
    private static final By Contact_Person_Label_2 = By.xpath("(//div[@automation-id='contactPerson_tv']/strong)[2]");
    private static final By Contact_Person_2 = By.xpath("(//div[@automation-id='contactPerson_tv']/span)[2]");

    private static final By CTA_ChangeBankDetailsNotificationTitle = By.xpath("//div[@automation-id='changeAllBankDetails_nt']//h4");
    private static final By CTA_ChangeBankDetailsNotificationBody = By.xpath("//div[@automation-id='changeAllBankDetails_nt']//p");
    private static final By CTA_ChangeBankDetailsNotificationBtn = By.xpath("//button[@automation-id='changeAllBanksDetails_btn']");

    //View Billing addresses locators
    private static final By Addresses_Acc_Title = By.xpath("//h3[@automation-id='addressHeadLine_tv']");
    private static final By Addresses_Acc_Description = By.xpath("//p[@automation-id='description_tv']");
    private static final By Addresses_Company_Name_SOHO_1 = By.xpath("(//strong[@automation-id='organizationName_tv'])[1]");
    private static final By Addresses_Company_Name_SOHO_2 = By.xpath("(//strong[@automation-id='organizationName_tv'])[2]");
    private static final By Addresses_Company_Name_SOHO_3 = By.xpath("(//strong[@automation-id='organizationName_tv'])[3]");
    private static final By Addresses_Owner_Salutation_1 = By.xpath("(//strong[@automation-id='salutation_tv'])[1]");
    private static final By Addresses_Owner_Salutation_2 = By.xpath("(//strong[@automation-id='salutation_tv'])[2]");
    private static final By Addresses_Owner_Salutation_3 = By.xpath("(//strong[@automation-id='salutation_tv'])[3]");
    private static final By Addresses_Owner_Name_1 = By.xpath("(//strong[@automation-id='firstname_tv'])[1]");
    private static final By Addresses_Owner_Name_2 = By.xpath("(//strong[@automation-id='firstname_tv'])[2]");
    private static final By Addresses_Owner_Name_3 = By.xpath("(//strong[@automation-id='firstname_tv'])[3]");
    private static final By Addresses_Contact_Person_1 = By.xpath("(//strong[@automation-id='contactPerson_tv'])[1]");
    private static final By Addresses_Contact_Person_2 = By.xpath("(//strong[@automation-id='contactPerson_tv'])[2]");
    private static final By Addresses_Contact_Person_3 = By.xpath("(//strong[@automation-id='contactPerson_tv'])[3]");
    private static final By Addresses_Street_1 = By.xpath("(//span[@automation-id='street_tv'])[1]");
    private static final By Addresses_Street_2 = By.xpath("(//span[@automation-id='street_tv'])[2]");
    private static final By Addresses_Street_3 = By.xpath("(//span[@automation-id='street_tv'])[3]");
    private static final By Addresses_HouseNo_1 = By.xpath("(//span[@automation-id='houseNumber_tv'])[1]");
    private static final By Addresses_HouseNo_2 = By.xpath("(//span[@automation-id='houseNumber_tv'])[2]");
    private static final By Addresses_HouseNo_3 = By.xpath("(//span[@automation-id='houseNumber_tv'])[3]");
    private static final By Addresses_PostalCode_1 = By.xpath("(//span[@automation-id='zipCode_tv'])[1]");
    private static final By Addresses_PostalCode_2 = By.xpath("(//span[@automation-id='zipCode_tv'])[2]");
    private static final By Addresses_PostalCode_3 = By.xpath("(//span[@automation-id='zipCode_tv'])[3]");
    private static final By Addresses_City_1 = By.xpath("(//span[@automation-id='city_tv'])[1]");
    private static final By Addresses_City_2 = By.xpath("(//span[@automation-id='city_tv'])[2]");
    private static final By Addresses_City_3 = By.xpath("(//span[@automation-id='city_tv'])[3]");
    private static final By Addresses_Used_For_Label_1 = By.xpath("(//h5[@automation-id='referenceKonto-header_tv'])[1]");
    private static final By Addresses_Used_For_Label_2 = By.xpath("(//h5[@automation-id='referenceKonto-header_tv'])[2]");
    private static final By Addresses_Used_For_Label_3 = By.xpath("(//h5[@automation-id='referenceKonto-header_tv'])[3]");
    private static final By Addresses_Reference_account1_Lable = By.xpath("(//div[@automation-id='referenceKonto_tv'])[1]");
    private static final By Addresses_Reference_account2_Lable = By.xpath("(//div[@automation-id='referenceKonto_tv'])[2]");
    private static final By Addresses_Reference_account3_Lable = By.xpath("(//div[@automation-id='referenceKonto_tv'])[3]");
    public static final By Addresses_FirstProduct = By.xpath("(//span[@class='pl-10'])[1]");
    private static final By Addresses_info_icon_1 = By.xpath("(//*[@class='i-xsml'])[1]");
    public static final By Addresses_SecondProduct = By.xpath("(//span[@class='pl-10'])[2]");
    private static final By Addresses_info_icon_2 = By.xpath("(//*[@class='i-xsml'])[3]");
    public static final By Addresses_ThirdProduct = By.xpath("(//span[@class='pl-10'])[3]");
    private static final By Addresses_info_icon_3 = By.xpath("(//*[@class='i-xsml'])[5]");
    private static final By Change_Addresses_Btn = By.xpath("(//button[@automation-id='changeAddress_btn'])[1]");
    private static final By Change_Addresses_Btn_2 = By.xpath("(//button[@automation-id='changeAddress_btn'])[2]");
    private static final By Change_Addresses_Btn_3 = By.xpath("(//button[@automation-id='changeAddress_btn'])[3]");
    private static final By Store_Different_Addresses_Text = By.xpath("//p[@automation-id='changeOneByOne_tv']");
    private static final By Store_Different_Addresses_Link = By.xpath("//a[@automation-id='changeOneByOne_Link']");
    private static final By Change_All_Addresses_Notification_Title = By.xpath("//h4[@class='flexDiv']");
    private static final By Change_All_Addresses_Notification_Description = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private static final By Change_All_Addresses_Btn = By.xpath("//button[@automation-id='changeAllAddress_btn']");
    private static final By service_Addresses_Title = By.xpath("//h3[@automation-id='service_address_header_tv']");
    private static final By service_Addresses_Description = By.xpath("//p[@automation-id='service_address_description_tv']");
    private static final By service_Addresses_Company_Name = By.xpath("//strong[@automation-id='service_organizationName_tv']");
    private static final By service_Addresses_Owner_Salutation = By.xpath("//strong[@automation-id='service_salutation_tv']");
    private static final By service_Addresses_Owner_Name = By.xpath("//strong[@automation-id='service_firstname_tv']");
    private static final By service_Addresses_Contact_Person = By.xpath("//strong[@automation-id='service_contactPerson_tv']");
    private static final By service_Addresses_Street = By.xpath("//span[@automation-id='service_street_tv']");
    private static final By service_Addresses_HouseNo = By.xpath("//span[@automation-id='service_houseNumber_tv']");
    private static final By service_Addresses_PostalCode = By.xpath("//span[@automation-id='service_zipCode_tv']");
    private static final By service_Addresses_City = By.xpath("//span[@automation-id='service_city_tv']");
    private static final By serviceAddressEdit_Btn = By.xpath("//button[@automation-id='changeAddress_btn' and contains(.,'Umzug ')]");
    private static final By No_Billing_Addresses_Notification_Title = By.xpath("//h4[@class='flexDiv']");
    private static final By No_Billing_Addresses_Notification_Description = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private static final By dunning_Addresses_Notification_Title = By.xpath("//h4[@class='flexDiv']");
    private static final By dunning_Addresses_Notification_Description = By.xpath("//p[@class='notification-text mb-10 mt-10']");
    private static final By badCase_Notification_Title = By.xpath("//div[@automation-id='successMsg_tv']//*//h4[@class='flexDiv']");
    private static final By badCase_Notification_Description = By.xpath("//p[@class='notification-text mb-10 mt-10']");

    // Locators for 8290 Kabel-Migration | Migrate to New Version of Contact Medium
    private static final By kontaktdaten_Acc = By.xpath("//li[@automation-id='kontaktdaten_acc']");

    //constructor
    public MeineDaten(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public MeineDaten clickOnSmartObject(MeineDatenSmartObjects smartObject) {
        switch (smartObject) {
            case DATENSCHUTZWERBEEINSTELLUNGEN -> {
                driver.element().click(DatenschutzSmartObject);
            }
            case KONTAKTDATEN -> {
                driver.verifyThat().element(MeinekundendatenSmartObjectHeader).exists();
                driver.element().click(MeinekundendatenSmartObjectHeader);
            }
            case DOKUMENTE -> {
                driver.element().click(MeineDokumenteSO);
            }
        }
        return this;
    }

    public MeineDaten pressOnSmartObject(MeineDatenSmartObjects smartObject) {
        switch (smartObject) {
            case DATENSCHUTZWERBEEINSTELLUNGEN -> {
                driver.element().click(DatenschutzSmartObject);
            }
        }
        return this;

    }

    @Step("Click On Contact Data Edit Button")
    public MeineDaten clickOnEditContactDataButton() {
        driver.element().isElementClickable(ContactdataEditButtonlocator);
        driver.element().click(ContactdataEditButtonlocator);
        return this;
    }

    //Enums
    public enum MeineDatenSmartObjects {
        DATENSCHUTZWERBEEINSTELLUNGEN,
        KONTAKTDATEN,
        DOKUMENTE

    }

    public MeineDaten clickOnDownloadCustomerDataButton() {
        driver.element().click(DownloadCustomerDataBtnlocator);
        return this;
    }

    public MeineDaten clickOnDownloadCustomerDataAsCSVButton() {
        driver.element().click(DownloadCustomerDataAsCSVLocator);
        return this;
    }

    public MeineDaten clickOnInitialPermissionLinkout() {
        driver.element().click(initialPermissionLinkoutLocator);
        return this;
    }

    public MeineDaten clickOnDataProtectionLinkout() {
        driver.element().isElementClickable(dataProtectionLinkoutLocator);
        clickOnPopupElement(driver,dataProtectionLinkoutLocator);
        return this;
    }


    public MeineDaten clickOnDatenschutzAccordion() {
        driver.element().click(DatenschutzAccordion);
        return this;
    }

    public MeineDaten clickOnInformationFromVodafoneEditBtn() {
        driver.element().click(EditBtn1Locator);
        return this;
    }

    public MeineDaten clickOnPersonalDataEditBtn() {
        driver.element().click(EditBtn2Locator);
        return this;
    }

    public MeineDaten clickOnConnectionDataEditBtn() {
        driver.element().click(EditBtn3Locator);
        return this;
    }

    public MeineDaten clickOnInternetUsageEditBtn() {
        driver.element().click(EditBtn4Locator);
        return this;
    }

    public MeineDaten clickOnMeineDokumenteSO() {
        driver.element().click(MeineDokumenteSO);
        return this;
    }

    public MeineDaten clickOnNEXTBTNSUSHI() {
        driver.element().click(NEXTBTNSUSHI);
        return this;
    }

    public MeineDaten clickOnDokumenteLinkout() {
        driver.element().click(DokumenteLinkout);
        return this;
    }
    @Step("Expand Bank Details Accordion")
    public MeineDaten ExpandBankDetailsAccordion() {
        driver.element().isElementClickable(BankDetails_SO);
        driver.element().click(BankDetails_SO);
        //driver.element().click(BankDetails.EditOneByOneInvoices_LinkOut1);
        return this;
    }

    public MeineDaten expandAddressesAccordion() {
        driver.element().click(Addresses_SO);
        return this;
    }

    public MeineDaten validateServiceAddressesSectionContent() {
        driver.verifyThat().element(service_Addresses_Title)
                .textTrimmed().isEqualTo(Service_Addresses_TitleCL)
                .withCustomReportMessage("Check that title of Service Addresses secion is correct")
                .perform();
        driver.verifyThat().element(service_Addresses_Description)
                .exists().perform();
        driver.verifyThat().element(service_Addresses_Owner_Salutation)
                .exists()
                .withCustomReportMessage("Check that Owner Salutation is exist")
                .perform();
        driver.verifyThat().element(service_Addresses_Owner_Name)
                .exists()
                .withCustomReportMessage("Check that OwnerName is exist")
                .perform();
        driver.verifyThat().element(service_Addresses_HouseNo)
                .exists()
                .withCustomReportMessage("Check that House number is exist")
                .perform();
        driver.verifyThat().element(service_Addresses_PostalCode)
                .exists()
                .withCustomReportMessage("Check that Postal code is exist")
                .perform();
        driver.verifyThat().element(service_Addresses_City)
                .exists()
                .withCustomReportMessage("Check that City is exist")
                .perform();
        return this;
    }

    @Step("Click on Edit service address(Umzug beauftragen)CTA Button")
    public MeineDaten clickOnEditServiceAddressButton() {
        driver.element().click(serviceAddressEdit_Btn);
        return this;
    }

    @Step("Validate dunning notification message's content")
    public MeineDaten validateDunningNotification() {
        driver.verifyThat().element(dunning_Addresses_Notification_Title)
                .textTrimmed().isEqualTo(Dunning_Addresses_Notification_TitleCL)
                .withCustomReportMessage("Validate Dunning notification title")
                .perform();
        driver.verifyThat().element(dunning_Addresses_Notification_Description)
                .textTrimmed().isEqualTo(Dunning_Addresses_Notification_DescriptionCL)
                .withCustomReportMessage("Validate Dunning notification description")
                .perform();
        return this;
    }

    public MeineDaten validateEditServiceButtonDimmed() {
        driver.verifyThat().element(serviceAddressEdit_Btn)
                .isDisabled().perform();
        return this;
    }

    //View bank details
    public MeineDaten navigateToBankDetailsAccordion() {
        new Dashboard(driver).openMeineKundenDatenTile(MEINEKUNDENDATEN);
        new MeineDaten(driver).ExpandBankDetailsAccordion();
        return this;
    }

    public MeineDaten validateBankAccordionTitleAndDescription() {
        driver.element().isElementDisplayed(Acc_Title);
        driver.verifyThat().element(Acc_Title)
                .textTrimmed().isEqualTo(Acc_TitleCL)
                .withCustomReportMessage("Validate accordion title")
                .perform();
        driver.verifyThat().element(Acc_Description)
                .textTrimmed().isEqualTo(Acc_DescriptionCL)
                .withCustomReportMessage("Validate accordion description")
                .perform();
        return this;
    }

    public MeineDaten validateAccountOwnerForCustomer() {
        driver.verifyThat().element(Account_Owner_Label)
                .textTrimmed().isEqualTo(Account_Owner_labelCL)
                .withCustomReportMessage("Validate account owner label")
                .perform();
        driver.verifyThat().element(Account_Owner).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerForCustomer2() {
        driver.verifyThat().element(Account_Owner_Label_2)
                .textTrimmed().isEqualTo(Account_Owner_labelCL)
                .withCustomReportMessage("Validate account owner label")
                .perform();
        driver.verifyThat().element(Account_Owner_2).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerForSOHO() {
        driver.verifyThat().element(Company_Label)
                .textTrimmed().isEqualTo(Company_LabelCL)
                .withCustomReportMessage("Validate company label")
                .perform();
        driver.verifyThat().element(Company).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerForSOHO2() {
        driver.verifyThat().element(Company_Label_2)
                .textTrimmed().isEqualTo(Company_LabelCL)
                .withCustomReportMessage("Validate company label")
                .perform();
        driver.verifyThat().element(Company_2).exists().perform();
        driver.verifyThat().element(Contact_Person_Label_2)
                .textTrimmed().isEqualTo(Contact_Person_LabelCL)
                .withCustomReportMessage("Validate Contact person label")
                .perform();
        driver.verifyThat().element(Contact_Person_2).exists().perform();
        return this;
    }

    public MeineDaten validateIBAN() {
        driver.verifyThat().element(IBAN_label)
                .textTrimmed().isEqualTo(IBAN_labelCL)
                .withCustomReportMessage("Validate IBAN label")
                .perform();
        driver.verifyThat().element(IBAN).exists().perform();
        return this;

    }

    public MeineDaten validateIBAN2() {
        driver.verifyThat().element(IBAN_label_2)
                .textTrimmed().isEqualTo(IBAN_labelCL)
                .withCustomReportMessage("Validate IBAN label")
                .perform();
        driver.verifyThat().element(IBAN_2).exists().perform();
        return this;
    }

    public MeineDaten validateBIC() {
        driver.verifyThat().element(BIC_Label)
                .textTrimmed().isEqualTo(BIC_LabelCL)
                .withCustomReportMessage("Validate BIC label")
                .perform();
        driver.verifyThat().element(BIC).exists().perform();
        return this;
    }

    public MeineDaten validateBIC2() {
        driver.verifyThat().element(BIC_Label_2)
                .textTrimmed().isEqualTo(BIC_LabelCL)
                .withCustomReportMessage("Validate BIC label")
                .perform();
        driver.verifyThat().element(BIC_2).exists().perform();
        return this;
    }

    public MeineDaten validateBankName() {
        driver.verifyThat().element(Bank_Label)
                .textTrimmed().isEqualTo(Bank_LabelCL)
                .withCustomReportMessage("Validate Bank label")
                .perform();
        driver.verifyThat().element(Bank).exists().perform();
        return this;
    }

    public MeineDaten validateBankName2() {
        driver.verifyThat().element(Bank_Label_2)
                .textTrimmed().isEqualTo(Bank_LabelCL)
                .withCustomReportMessage("Validate Bank label")
                .perform();
        driver.verifyThat().element(Bank_2).exists().perform();
        return this;
    }

    public MeineDaten validateDirectDebitAuthorization() {
        driver.verifyThat().element(Direct_Debit_Authorization_Label)
                .textTrimmed().isEqualTo(Direct_Debit_Authorization_LabelCL)
                .withCustomReportMessage("Validate Direct Debit Authorization label")
                .perform();
        driver.verifyThat().element(Direct_Debit_Authorization).exists().perform();
        return this;
    }

    public MeineDaten validateDirectDebitAuthorization2() {
        driver.verifyThat().element(Direct_Debit_Authorization_Label_2)
                .textTrimmed().isEqualTo(Direct_Debit_Authorization_LabelCL)
                .withCustomReportMessage("Validate Direct Debit Authorization label")
                .perform();
        driver.verifyThat().element(Direct_Debit_Authorization_2).exists().perform();
        return this;
    }

    public MeineDaten validateBankUsedForLabel() {
        driver.verifyThat().element(Used_For_Label)
                .textTrimmed().isEqualTo(Used_For_LabelCL)
                .withCustomReportMessage("Validate Used For label")
                .perform();
        return this;
    }

    public MeineDaten validateBankUsedForLabel2() {
        driver.verifyThat().element(Used_For_Label_2)
                .textTrimmed().isEqualTo(Used_For_LabelCL)
                .withCustomReportMessage("Validate Used For label")
                .perform();
        return this;
    }

    public MeineDaten validateBankReferenceAccount0001() {
        driver.verifyThat().element(Reference_account1_Lable)
                .textTrimmed().contains(Reference_account_LableCL)
                .withCustomReportMessage("Validate Reference account 1 label")
                .perform();
        return this;
    }

    public MeineDaten validateBankReferenceAccount0002() {
        driver.verifyThat().element(Reference_account2_Lable)
                .textTrimmed().isEqualTo(Reference_account_LableCL)
                .withCustomReportMessage("Validate Reference account 2 label")
                .perform();
        return this;
    }

    public MeineDaten validateBankReferenceAccount0003() {
        driver.verifyThat().element(Reference_account3_Lable)
                .textTrimmed().isEqualTo(Reference_account_LableCL)
                .withCustomReportMessage("Validate Reference account 3 label")
                .perform();
        return this;
    }

    public MeineDaten checkBankInfoIconForProduct1() {
        driver.verifyThat().element(info_icon_1).exists().perform();
        return this;
    }

    public MeineDaten checkBankInfoIconForProduct2() {
        driver.verifyThat().element(info_icon_2).exists().perform();
        return this;
    }

    public MeineDaten checkBankInfoIconForProduct3() {
        driver.verifyThat().element(info_icon_3).exists().perform();
        return this;
    }

    public MeineDaten validateChangeBankAccountButton() {
        driver.verifyThat().element(Change_Bank_Account_Btn)
                .textTrimmed().isEqualTo(Change_Bank_Account_Btn_CL)
                .withCustomReportMessage("Validate Change Bank Account button")
                .perform();
        return this;
    }

    public MeineDaten validateChangeBankAccountButton2() {
        driver.verifyThat().element(Change_Bank_Account_Btn_2)
                .textTrimmed().isEqualTo(Change_Bank_Account_Btn_CL)
                .withCustomReportMessage("Validate Change Bank Account button")
                .perform();
        return this;
    }

    public MeineDaten validateDimmedChangeBankAccountButton() {
        driver.verifyThat().element(Change_Bank_Account_Btn).isDisabled().perform();
        return this;
    }

    @Step("Click On Change Bank Details")
    public MeineDaten clickOnChangeBankDetailsButton() {
        driver.element().click(Change_Bank_Account_Btn);
        return this;
    }

    public MeineDaten assertThatHyperlinkDoesNotExist() {
        driver.verifyThat().element(EditOneByOneInvoices_LinkOut1).doesNotExist()
                .withCustomReportMessage("Assert That Hyper Link Does Not Exist")
                .perform();
        return  this;
    }

    public MeineDaten validateDimmedChangeBankAccountButton2() {
        driver.verifyThat().element(Change_Bank_Account_Btn_2).isDisabled().perform();
        return this;
    }

    public MeineDaten validateStoreDifferentBankAccountsLink() {
        driver.verifyThat().element(Store_Different_Bank_Account_Text)
                .textTrimmed().isEqualTo(Store_Different_Bank_Account_Text_CL)
                .withCustomReportMessage("Validate Store different accounts text")
                .perform();
        driver.verifyThat().element(Store_Different_Bank_Account_Link)
                .textTrimmed().isEqualTo(Store_Different_Bank_Account_Link_CL)
                .withCustomReportMessage("Validate Store different accounts link")
                .perform();
        return this;
    }

    public MeineDaten validateSelfPayerNotification() {
        driver.verifyThat().element(Self_Payer_Notification_Title)
                .textTrimmed().isEqualTo(Self_Payer_Notification_Title_CL)
                .withCustomReportMessage("Validate self payer notification title")
                .perform();
        driver.verifyThat().element(Self_Payer_Notification_Description)
                .textTrimmed().isEqualTo(Self_Payer_Notification_Description_CL)
                .withCustomReportMessage("Validate self payer notification description")
                .perform();
        return this;
    }

    public MeineDaten validateSelfPayerNotification2() {
        driver.verifyThat().element(Self_Payer_Notification_Title_2)
                .textTrimmed().isEqualTo(Self_Payer_Notification_Title_CL)
                .withCustomReportMessage("Validate self payer notification title")
                .perform();
        driver.verifyThat().element(Self_Payer_Notification_Description_2)
                .textTrimmed().isEqualTo(Self_Payer_Notification_Description_CL)
                .withCustomReportMessage("Validate self payer notification description")
                .perform();
        return this;
    }

    public MeineDaten validateBankDunningNotification() {
        driver.verifyThat().element(Dunning_Notification_Title)
                .textTrimmed().isEqualTo(Dunning_Notification_Title_CL)
                .withCustomReportMessage("Validate Dunning debit notification title")
                .perform();
        driver.verifyThat().element(Dunning_Notification_Description)
                .textTrimmed().isEqualTo(Dunning_Notification_Description_CL)
                .withCustomReportMessage("Validate Dunning debit notification description")
                .perform();
        return this;
    }

    public MeineDaten validateBankFirstProduct() {

        driver.verifyThat().element(FirstProduct).exists().perform();
        return this;
    }

    public MeineDaten validateBankSecondProduct() {
        driver.verifyThat().element(SecondProduct).exists().perform();
        return this;
    }

    public MeineDaten validateBankThirdProduct() {
        driver.verifyThat().element(ThirdProduct).exists().perform();
        return this;
    }

    public MeineDaten validateCTAForChangeBankDetailsForAllRefKontosAtOnce() {
        driver.verifyThat().element(CTA_ChangeBankDetailsNotificationTitle)
                .textTrimmed().isEqualTo(CTA_ChangeBankDetailsNotificationTitleCL)
                .withCustomReportMessage("Validate CTA Change Bank Details Notification Title")
                .perform();
        driver.verifyThat().element(CTA_ChangeBankDetailsNotificationBody)
                .textTrimmed().isEqualTo(CTA_ChangeBankDetailsNotificationBodyCL)
                .withCustomReportMessage("Validate CTA Change Bank Details Notification Body")
                .perform();
        driver.verifyThat().element(CTA_ChangeBankDetailsNotificationBtn)
                .textTrimmed().isEqualTo(CTA_ChangeBankDetailsNotificationBtnCL)
                .withCustomReportMessage("Validate CTA Change Bank Details Notification Button")
                .perform();
        return this;
    }


    //View addresses
    public MeineDaten navigateToAddressesAccordion() {
        new Dashboard(driver).openMeineKundenDatenTile(MEINEKUNDENDATEN);
        new MeineDaten(driver).expandAddressesAccordion();
        return this;
    }

    public MeineDaten validateAddressesAccordionTitleAndDescription() {
        driver.verifyThat().element(Addresses_Acc_Title)
                .textTrimmed().isEqualTo(Addresses_Acc_TitleCL)
                .withCustomReportMessage("Validate accordion title")
                .perform();
        driver.verifyThat().element(Addresses_Acc_Description)
                .textTrimmed().isEqualTo(Addresses_Acc_DescriptionCL)
                .withCustomReportMessage("Validate accordion description")
                .perform();
        return this;
    }

    public MeineDaten validateAccountOwnerInfoForCustomer() {
        driver.verifyThat().element(Addresses_Owner_Salutation_1).exists().perform();
        driver.verifyThat().element(Addresses_Owner_Name_1).exists().perform();
        driver.verifyThat().element(Addresses_Street_1).exists().perform();
        driver.verifyThat().element(Addresses_HouseNo_1).exists().perform();
        driver.verifyThat().element(Addresses_PostalCode_1).exists().perform();
        driver.verifyThat().element(Addresses_City_1).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerInfoForCustomer2() {
        driver.verifyThat().element(Addresses_Owner_Salutation_2).exists().perform();
        driver.verifyThat().element(Addresses_Owner_Name_2).exists().perform();
        driver.verifyThat().element(Addresses_Street_2).exists().perform();
        driver.verifyThat().element(Addresses_HouseNo_2).exists().perform();
        driver.verifyThat().element(Addresses_PostalCode_2).exists().perform();
        driver.verifyThat().element(Addresses_City_2).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerInfoForCustomer3() {
        driver.verifyThat().element(Addresses_Owner_Salutation_3).exists().perform();
        driver.verifyThat().element(Addresses_Owner_Name_3).exists().perform();
        driver.verifyThat().element(Addresses_Street_3).exists().perform();
        driver.verifyThat().element(Addresses_HouseNo_3).exists().perform();
        driver.verifyThat().element(Addresses_PostalCode_3).exists().perform();
        driver.verifyThat().element(Addresses_City_3).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerInfoForSOHO() {
        driver.verifyThat().element(Addresses_Company_Name_SOHO_1).exists().perform();
        driver.verifyThat().element(Addresses_Contact_Person_1).exists().perform();
        driver.verifyThat().element(Addresses_Street_1).exists().perform();
        driver.verifyThat().element(Addresses_HouseNo_1).exists().perform();
        driver.verifyThat().element(Addresses_PostalCode_1).exists().perform();
        driver.verifyThat().element(Addresses_City_1).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerInfoForSOHO2() {
        driver.verifyThat().element(Addresses_Company_Name_SOHO_2).exists().perform();
        driver.verifyThat().element(Addresses_Contact_Person_2).exists().perform();
        driver.verifyThat().element(Addresses_Street_2).exists().perform();
        driver.verifyThat().element(Addresses_HouseNo_2).exists().perform();
        driver.verifyThat().element(Addresses_PostalCode_2).exists().perform();
        driver.verifyThat().element(Addresses_City_2).exists().perform();
        return this;
    }

    public MeineDaten validateAccountOwnerInfoForSOHO3() {
        driver.verifyThat().element(Addresses_Company_Name_SOHO_3).exists().perform();
        driver.verifyThat().element(Addresses_Contact_Person_3).exists().perform();
        driver.verifyThat().element(Addresses_Street_3).exists().perform();
        driver.verifyThat().element(Addresses_HouseNo_3).exists().perform();
        driver.verifyThat().element(Addresses_PostalCode_3).exists().perform();
        driver.verifyThat().element(Addresses_City_3).exists().perform();
        return this;
    }

    public MeineDaten validateUsedForLabel() {
        driver.verifyThat().element(Addresses_Used_For_Label_1)
                .textTrimmed().isEqualTo(Addresses_Used_For_LabelCL)
                .withCustomReportMessage("Validate Used For label")
                .perform();
        return this;
    }

    public MeineDaten validateUsedForLabel2() {
        driver.verifyThat().element(Addresses_Used_For_Label_2)
                .textTrimmed().isEqualTo(Addresses_Used_For_LabelCL)
                .withCustomReportMessage("Validate Used For label")
                .perform();
        return this;
    }

    public MeineDaten validateUsedForLabel3() {
        driver.verifyThat().element(Addresses_Used_For_Label_3)
                .textTrimmed().isEqualTo(Addresses_Used_For_LabelCL)
                .withCustomReportMessage("Validate Used For label")
                .perform();
        return this;
    }

    public MeineDaten validateReferenceAccount0001() {
        driver.verifyThat().element(Addresses_Reference_account1_Lable)
                .textTrimmed().contains(Addresses_Reference_accountCL)
                .withCustomReportMessage("Validate Reference account 1 label")
                .perform();
        return this;
    }

    public MeineDaten validateReferenceAccount0002() {
        driver.verifyThat().element(Addresses_Reference_account2_Lable)
                .textTrimmed().contains(Addresses_Reference_accountCL)
                .withCustomReportMessage("Validate Reference account 2 label")
                .perform();
        return this;
    }

    public MeineDaten validateReferenceAccount0003() {
        driver.verifyThat().element(Addresses_Reference_account3_Lable)
                .textTrimmed().contains(Addresses_Reference_accountCL)
                .withCustomReportMessage("Validate Reference account 3 label")
                .perform();
        return this;
    }

    public MeineDaten CheckInfoIconForProduct1() {
        driver.verifyThat().element(Addresses_info_icon_1).exists().perform();
        return this;
    }

    public MeineDaten CheckInfoIconForProduct2() {
        driver.verifyThat().element(Addresses_info_icon_2).exists().perform();
        return this;
    }

    public MeineDaten CheckInfoIconForProduct3() {
        driver.verifyThat().element(Addresses_info_icon_3).exists().perform();
        return this;
    }

    public MeineDaten validateChangeBillingAddressButton() {
        driver.verifyThat().element(Change_Addresses_Btn)
                .textTrimmed().isEqualTo(Change_Addresses_BtnCL)
                .withCustomReportMessage("Validate Change Billing Address button")
                .perform();
        return this;
    }

    public MeineDaten validateChangeBillingAddressButton2() {
        driver.verifyThat().element(Change_Addresses_Btn_2)
                .textTrimmed().isEqualTo(Change_Addresses_BtnCL)
                .withCustomReportMessage("Validate Change Billing Address button")
                .perform();
        return this;
    }

    public MeineDaten validateChangeBillingAddressButton3() {
        driver.verifyThat().element(Change_Addresses_Btn_3)
                .textTrimmed().isEqualTo(Change_Addresses_BtnCL)
                .withCustomReportMessage("Validate Change Billing Address button")
                .perform();
        return this;
    }

    public MeineDaten validateDimmedChangeBillingAddressButton() {
        driver.verifyThat().element(Change_Addresses_Btn).isDisabled().perform();
        return this;
    }

    public MeineDaten validateDimmedChangeBillingAddressButton2() {
        driver.verifyThat().element(Change_Addresses_Btn_2).isDisabled().perform();
        return this;
    }

    public MeineDaten validateStoreDifferentBillingAddressesLink() {
        driver.verifyThat().element(Store_Different_Addresses_Text)
                .textTrimmed().isEqualTo(Store_Different_Addresses_TextCL)
                .withCustomReportMessage("Validate Store different accounts text")
                .perform();
        driver.verifyThat().element(Store_Different_Addresses_Link)
                .textTrimmed().isEqualTo(Store_Different_Addresses_LinkCL)
                .withCustomReportMessage("Validate Store different accounts link")
                .perform();
        return this;
    }

    public MeineDaten validateChangeAllAddressesNotification() {
        driver.verifyThat().element(Change_All_Addresses_Notification_Title)
                .textTrimmed().isEqualTo(Change_All_Addresses_Notification_TitleCL)
                .withCustomReportMessage("Validate Change All Addresses notification title")
                .perform();
        driver.verifyThat().element(Change_All_Addresses_Notification_Description)
                .textTrimmed().isEqualTo(Change_All_Addresses_Notification_DescriptionCL)
                .withCustomReportMessage("Validate Change All Addresses notification description")
                .perform();
        driver.verifyThat().element(Change_All_Addresses_Btn)
                .textTrimmed().isEqualTo(Change_ALL_Addresses_BtnCL)
                .withCustomReportMessage("Validate Change All Addresses Button")
                .perform();
        return this;
    }

    public MeineDaten validateServiceAddressesTitleAndDescription() {
        driver.verifyThat().element(service_Addresses_Title)
                .textTrimmed().isEqualTo(Service_Addresses_TitleCL)
                .withCustomReportMessage("Validate Service Addresses title")
                .perform();
        driver.verifyThat().element(service_Addresses_Description)
                .textTrimmed().isEqualTo(Service_Addresses_DescriptionCL)
                .withCustomReportMessage("Validate Service Addresses description")
                .perform();
        return this;
    }

    public MeineDaten validateAccountInfoForServiceAddressesForConsumer() {
        driver.verifyThat().element(service_Addresses_Owner_Salutation).exists().perform();
        driver.verifyThat().element(service_Addresses_Owner_Name).exists().perform();
        driver.verifyThat().element(service_Addresses_Street).exists().perform();
        driver.verifyThat().element(service_Addresses_HouseNo).exists().perform();
        driver.verifyThat().element(service_Addresses_PostalCode).exists().perform();
        driver.verifyThat().element(service_Addresses_City).exists().perform();
        return this;
    }

    public MeineDaten validateAccountInfoForServiceAddressesForSOHO() {
        driver.verifyThat().element(service_Addresses_Company_Name).exists().perform();
        driver.verifyThat().element(service_Addresses_Contact_Person).exists().perform();
        driver.verifyThat().element(service_Addresses_Street).exists().perform();
        driver.verifyThat().element(service_Addresses_HouseNo).exists().perform();
        driver.verifyThat().element(service_Addresses_PostalCode).exists().perform();
        driver.verifyThat().element(service_Addresses_City).exists().perform();
        return this;
    }

    public MeineDaten validateNoBillingAddressNotification() {
        driver.verifyThat().element(No_Billing_Addresses_Notification_Title)
                .textTrimmed().isEqualTo(No_Billing_Addresses_Notification_TitleCL)
                .withCustomReportMessage("Validate No Billing Address notification title")
                .perform();
        driver.verifyThat().element(No_Billing_Addresses_Notification_Description)
                .textTrimmed().isEqualTo(No_Billing_Addresses_Notification_DescriptionCL)
                .withCustomReportMessage("Validate Dunning notification description")
                .perform();
        return this;
    }

    public MeineDaten validateBillingDunningNotification() {
        driver.verifyThat().element(dunning_Addresses_Notification_Title)
                .textTrimmed().isEqualTo(Dunning_Addresses_Notification_TitleCL)
                .withCustomReportMessage("Validate Dunning notification title")
                .perform();
        driver.verifyThat().element(dunning_Addresses_Notification_Description)
                .textTrimmed().isEqualTo(Dunning_Addresses_Notification_DescriptionCL)
                .withCustomReportMessage("Validate Dunning notification description")
                .perform();
        return this;
    }

    public MeineDaten validateKIP_Product() {
        driver.verifyThat().element(Addresses_FirstProduct)
                .textTrimmed().isEqualTo(Addresses_KIP_ProductCL)
                .withCustomReportMessage("Validate KIP product")
                .perform();
        return this;
    }

    public MeineDaten validateTV_Product() {
        driver.verifyThat().element(Addresses_SecondProduct)
                .textTrimmed().isEqualTo(Addresses_KabelTV_ProductCL)
                .withCustomReportMessage("Validate Kabel TV product")
                .perform();
        return this;
    }

    public MeineDaten validateCLS_Product() {
        driver.verifyThat().element(Addresses_ThirdProduct)
                .textTrimmed().isEqualTo(Addresses_CLS_ProductCL)
                .withCustomReportMessage("Validate Digital product")
                .perform();
        return this;
    }

    public MeineDaten validateBadCaseNotification() {
        driver.verifyThat().element(badCase_Notification_Title)
                .textTrimmed().isEqualTo(badCase_Notification_TitleCL)
                .withCustomReportMessage("Validate Bad case notification title")
                .perform();
        driver.verifyThat().element(badCase_Notification_Description)
                .textTrimmed().isEqualTo(badCase_Notification_DescriptionCL)
                .withCustomReportMessage("Validate Bad case notification description")
                .perform();
        return this;
    }

    public MeineDaten validateMeineDokumenteSOandLinkout() {
        driver.verifyThat().element(MeineDokumenteSOHeader)
                .textTrimmed().isEqualTo(MeineDokumenteSOHeaderCL)
                .withCustomReportMessage("Validate Dokumente SO Header text")
                .perform();
        driver.verifyThat().element(MeineDokumenteSOFooter)
                .textTrimmed().isEqualTo(MeineDokumenteSOFooterCL)
                .withCustomReportMessage("Validate Dokumente SO Footer text")
                .perform();
        driver.verifyThat().element(DokumenteLinkout)
                .textTrimmed().isEqualTo(DokumenteLinkoutCL)
                .withCustomReportMessage("Validate Dokumente SO Footer text")
                .perform();
        return this;
    }

    public MeineDaten validateMeinDokumenteSOheader() {
        driver.verifyThat().element(MeineDokumenteSOHeader)
                .textTrimmed().isEqualTo(MeineDokumenteSOHeaderCL)
                .withCustomReportMessage("Validate Meine Dokumente SO Header")
                .perform();
        return this;
    }

    public MeineDaten validateDownloadCustomerDataBtnText() {
        driver.verifyThat().element(DownloadCustomerDataBtnlocator)
                .textTrimmed().isEqualTo(DownloadCustomerDataBtn)
                .withCustomReportMessage("Validate Download customer data button text")
                .perform();
        return this;
    }

    public MeineDaten validateDownloadCustomerDataPage() {
        driver.verifyThat().element(CustomerDataWindowTitleLocator)
                .textTrimmed().isEqualTo(CustomerDataWindowTitle)
                .withCustomReportMessage("Validate Download customer data window title")
                .perform();
        driver.verifyThat().element(DownloadCustomerDataPageTitlelocator)
                .textTrimmed().isEqualTo(DownloadCustomerDataPageTitle)
                .withCustomReportMessage("Validate Download customer data page title")
                .perform();
        driver.verifyThat().element(CustomerDataNotificationTitleLocator)
                .textTrimmed().isEqualTo(CustomerDataNotificationTitle)
                .withCustomReportMessage("Validate customer data notification title")
                .perform();
        driver.verifyThat().element(CustomerDataNotificationBodyLocator)
                .textTrimmed().isEqualTo(CustomerDataNotificationBody)
                .withCustomReportMessage("Validate customer data notification body")
                .perform();
        driver.verifyThat().element(CustomerDataNotificationNoteLocator)
                .textTrimmed().isEqualTo(CustomerDataNotificationNote)
                .withCustomReportMessage("Validate customer data notification note")
                .perform();
        driver.verifyThat().element(DownloadCustomerDataAsCSVLocator)
                .textTrimmed().isEqualTo(DownloadCustomerDataPageTitle)
                .withCustomReportMessage("Validate Download Customer Data as CSV button text")
                .perform();
        return this;
    }

    public MeineDaten validateContactDataSection() {
        driver.verifyThat().element(KundenKontaktdatenSectionHeaderLocator)
                .textTrimmed().contains(ContactDataSectionHeader)
                .withCustomReportMessage("Check that contact data section header exists")
                .perform();
        driver.verifyThat().element(KundenKontaktdatenSectionFooterLocator)
                .textTrimmed().isEqualTo(ContactDataSectionFooter)
                .withCustomReportMessage("Check that contact data section footer exists")
                .perform();
        driver.verifyThat().element(KabelDeutschlandTitleLocator)
                .textTrimmed().isEqualTo(MeinKabelTitle)
                .withCustomReportMessage("Check that Kable Deutschland Title exists")
                .perform();
        return this;

    }

    public MeineDaten validateContactDataTelephoneNumber() {
        driver.verifyThat().element(KundennummerLocator)
                .textTrimmed().contains(CustomerNumberLabel)
                .withCustomReportMessage("Check that customer number label exists")
                .perform();
        driver.verifyThat().element(telephoneNumberLabelLocator)
                .textTrimmed().isEqualTo(TelephoneNumberLabel)
                .withCustomReportMessage("Check that Telephone number label exists")
                .perform();
        return this;
    }

    public MeineDaten validateContactDataTelephoneNumberNotProvided() {
        driver.verifyThat().element(telephoneNumberLocator)
                .textTrimmed().isEqualTo(PhoneNumberNotProvidedMessage)
                .withCustomReportMessage("Check that telephone number not provided message exists")
                .perform();
        return this;
    }

    public MeineDaten validateContactDataEmailLabel() {
        driver.verifyThat().element(ContactDataEmailLabelLocator)
                .textTrimmed().isEqualTo(ContactDataEmailLabel)
                .withCustomReportMessage("Check that contact data Email label exists")
                .perform();
        return this;
    }

    public MeineDaten validateContactDateEmailNotValidated() {
        driver.verifyThat().element(ContactDataEmailLocator)
                .textTrimmed().isEqualTo(ContactDataEmailNotValidated)
                .withCustomReportMessage("Check that contact data Email exists")
                .perform();
        return this;
    }

    public MeineDaten validateContactDateEmailNotProvided() {
        driver.verifyThat().element(ContactDataEmailLocator)
                .textTrimmed().isEqualTo(EmailNotProvidedMessage)
                .withCustomReportMessage("Check that contact data Email exists")
                .perform();
        return this;
    }

    public MeineDaten validateContactDataEmailIsProvided() {
        driver.verifyThat().element(ContactDataEmailLocator).exists()
                .withCustomReportMessage("Check that contact data Email validated exists")
                .perform();
        return this;
    }

    public MeineDaten validateContactDataEditButton() {
        driver.verifyThat().element(ContactdataEditButtonlocator)
                .textTrimmed().isEqualTo(ContactDataEditButton)
                .withCustomReportMessage("Check that contact data edit button exists")
                .perform();
        return this;
    }

    public MeineDaten validateLoginDataSection() {
        driver.verifyThat().element(LoginDatenSectionHeaderLocator)
                .textTrimmed().isEqualTo(LoginDataSectionHeader)
                .withCustomReportMessage("Check that  Login data section header exists")
                .perform();
        driver.verifyThat().element(LoginDatenSectionFooterLocator)
                .textTrimmed().isEqualTo(LoginDataSectionFooter)
                .withCustomReportMessage("Check that Login data Section footer exists")
                .perform();
        driver.verifyThat().element(UserNameLabelLocator)
                .textTrimmed().isEqualTo(UserNameLabel)
                .withCustomReportMessage("Check that user name label exists")
                .perform();
        driver.verifyThat().element(SalutationLabelLocator)
                .textTrimmed().isEqualTo(SalutationLabel)
                .withCustomReportMessage("Check that salutation label exists")
                .perform();
        driver.verifyThat().element(LastNameLabelLocator)
                .textTrimmed().contains(LastNameLabel)
                .withCustomReportMessage("Check that last name label exists")
                .perform();
        driver.verifyThat().element(FirstNameLabelLocator)
                .textTrimmed().isEqualTo(FirstNameLabel)
                .withCustomReportMessage("Check that first name label exists")
                .perform();
        driver.verifyThat().element(LoginDatenEmailLabelLocator)
                .textTrimmed().isEqualTo(EmailLabel)
                .withCustomReportMessage("Check that Email label exists")
                .perform();
        driver.verifyThat().element(LoginDatenEmailLocator)
                .textTrimmed().matchesRegex(EmailRegex)
                .withCustomReportMessage("Check that Valid Email exists").perform();
        driver.verifyThat().element(LoginDatenEditButtonLocator)
                .textTrimmed().contains(LoginDataEditButton)
                .withCustomReportMessage("Check that Login data edit button exists").perform();
        return this;
    }

    public MeineDaten validateMeinDatenPageTitle() {
        driver.element().isElementDisplayed(MeinekundenDatenPageHeader);
        driver.verifyThat().element(MeinekundenDatenPageHeader)
                .textTrimmed().contains(MeineDatenText)
                .withCustomReportMessage("Check that page title exists").perform();
        return this;
    }

    public MeineDaten validateKontaktDatennSOandAccordion() {
        driver.verifyThat().element(MeinekundenDatenPageHeader)
                .textTrimmed().isEqualTo(MeineDatenText)
                .withCustomReportMessage("Check that page title exists").perform();
        driver.verifyThat().element(MeinekundendatenSmartObjectHeader)
                .textTrimmed().isEqualTo(KontaktdatenText)
                .withCustomReportMessage("Check that meine Kundendaten smart object title exists").perform();
        driver.verifyThat().element(MeinekundendatenSmartObjectFooter)
                .textTrimmed().isEqualTo(MeineKundendatenSmartObjectFooterText)
                .withCustomReportMessage("Check that meine Kundendaten smart object footer exists").perform();
        driver.verifyThat().element(MeinekundendatenAccordionHeader)
                .textTrimmed().isEqualTo(KontaktdatenText)
                .withCustomReportMessage("Check that meine Kundendaten accordion header exists").perform();
        driver.verifyThat().element(MeinekundendatenAccordionFooter)
                .textTrimmed().isEqualTo(MeineKundendatenAccordionFooter)
                .withCustomReportMessage("Check that meine Kundendaten accordion footer exists").perform();
        return this;
    }

    public MeineDaten VerifyPrivacyManagmentAccordionContent() {
        //Verify Information From Vodafone section
        driver.verifyThat().element(InformationFromVodafoneSectionLocator)
                .textTrimmed().isEqualTo(InformationFromVodafoneSectionCL)
                .withCustomReportMessage("Validate Information From Vodafone Section CL")
                .perform();
        driver.verifyThat().element(InformationFromVodafoneDescriptionTxtLocator)
                .textTrimmed().isEqualTo(InformationFromVodafoneDescriptionCL)
                .withCustomReportMessage("Validate Information From Vodafone Description CL")
                .perform();
        driver.verifyThat().element(EditBtn1Locator)
                .textTrimmed().isEqualTo(EditBtnCL)
                .withCustomReportMessage("Validate Edit Button CL")
                .perform();
        //Verify Personal Data section
        driver.verifyThat().element(PersonalDataSectionLocator)
                .textTrimmed().isEqualTo(PersonalDataSectionCL)
                .withCustomReportMessage("Validate Personal Data Section CL")
                .perform();
        driver.verifyThat().element(PersonalDataDescriptionTxtLocator)
                .textTrimmed().isEqualTo(PersonalDataDescriptionCL)
                .withCustomReportMessage("Validate Personal Data Description CL")
                .perform();
        driver.verifyThat().element(EditBtn2Locator)
                .textTrimmed().isEqualTo(EditBtnCL)
                .withCustomReportMessage("Validate Edit Button CL")
                .perform();

        //Verify Connection Data section
        driver.verifyThat().element(ConnectionDataSectionLocator)
                .textTrimmed().isEqualTo(ConnectionDataSectionCL)
                .withCustomReportMessage("Validate Connection Data Section CL")
                .perform();
        driver.verifyThat().element(ConnectionDataDescriptionTxtLocator)
                .textTrimmed().isEqualTo(ConnectionDataDescriptionCL)
                .withCustomReportMessage("Validate Connection Data Description CL")
                .perform();
        driver.verifyThat().element(EditBtn3Locator)
                .textTrimmed().isEqualTo(EditBtnCL)
                .withCustomReportMessage("Validate Edit Button CL")
                .perform();

        //Verify Internet Usage section
        driver.verifyThat().element(InternetUsageSectionLocator)
                .textTrimmed().isEqualTo(InternetUsageSectionCL)
                .withCustomReportMessage("Validate Internet Usage Section CL")
                .perform();
        driver.verifyThat().element(InternetUsageDescriptionTxtLocator)
                .textTrimmed().isEqualTo(InternetUsageDescriptionCL)
                .withCustomReportMessage("Validate Internet Usage Description CL")
                .perform();
        driver.verifyThat().element(EditBtn4Locator)
                .textTrimmed().isEqualTo(EditBtnCL)
                .withCustomReportMessage("Validate Edit Button CL")
                .perform();

        //Verify Personal Offers section
        driver.verifyThat().element(PersonalOffersSectionLocator)
                .textTrimmed().isEqualTo(PersonalOffersSectionCL)
                .withCustomReportMessage("Validate Personal Offers Section CL")
                .perform();
        driver.verifyThat().element(PersonalOffersDescriptionTxtLocator)
                .textTrimmed().isEqualTo(PersonalOffersDescriptionCL)
                .withCustomReportMessage("Validate Personal Offers Description CL")
                .perform();
        driver.verifyThat().element(EditBtn5Locator)
                .textTrimmed().isEqualTo(EditBtnCL)
                .withCustomReportMessage("Validate Edit Button CL")
                .perform();
        return this;

    }

    public MeineDaten validatePersonalDataPermissions() {
        driver.verifyThat().element(PersonalDataSection.sectionTitle)
                .textTrimmed().isEqualTo(PersonalDataSection.sectionTitleCL)
                .withCustomReportMessage("Verify section title")
                .perform();

        //Verify Austausch Bestands-/Vertragsdaten zu Werbezwecken section
        driver.verifyThat().element(PersonalDataSection.Permission)
                .textTrimmed().isEqualTo(PersonalDataSection.PermissionCL)
                .withCustomReportMessage("Verify permission CL")
                .perform();
        driver.verifyThat().element(PersonalDataSection.lastChangeLabel)
                .textTrimmed().isEqualTo(PersonalDataSection.lastChangeLabelCL)
                .withCustomReportMessage("Verify last change label")
                .perform();
        driver.verifyThat().element(PersonalDataSection.lastChangeDate1).exists().perform();
        driver.verifyThat().element(PersonalDataSection.persmissionDescription)
                .textTrimmed().isEqualTo(PersonalDataSection.persmissionDescriptionCL)
                .withCustomReportMessage("Verify permission description")
                .perform();
        return this;
    }

    public MeineDaten changePersonalDataPermissions() {
        new PersonalDataSection(driver).changeToggleBtn();
        if (driver.element().isElementDisplayed(PersonalDataSection.toggleBtnOff)) {
            new ConnectionDataSection(driver).validateWarningMsgAfterChangingToggle();
            new PersonalDataSection(driver).clickContinueBtn();
        }
        //click on confirm button to save all changes
        new PersonalDataSection(driver).clickConfrimBtn();
        new ConnectionDataSection(driver).validateSaveChangesMSG();
        new PersonalDataSection(driver).clickSaveChangesBtn();
        return this;
    }

    // WFDT-4298 Contact data
    public MeineDaten AssertLoginDataInCaseValidatedEmail() {
        driver.verifyThat().element(LoginDatenSectionHeaderLocator)
                .textTrimmed().isEqualTo(LoginDataSectionHeader)
                .withCustomReportMessage("Check that  Login data section header exists")
                .perform();
        driver.verifyThat().element(LoginDatenSectionFooterLocator)
                .textTrimmed().isEqualTo(LoginDataSectionFooter)
                .withCustomReportMessage("Check that Login data Section footer exists")
                .perform();
        driver.verifyThat().element(UserNameLabelLocator)
                .textTrimmed().isEqualTo(UserNameLabel)
                .withCustomReportMessage("Check that salutation label exists")
                .perform();
        driver.verifyThat().element(SalutationLabelLocator)
                .textTrimmed().isEqualTo(SalutationLabel)
                .withCustomReportMessage("Check that first name label exists")
                .perform();
        driver.verifyThat().element(LastNameLabelLocator)
                .textTrimmed().contains(LastNameLabel)
                .withCustomReportMessage("Check that last name label exists")
                .perform();
        driver.verifyThat().element(FirstNameLabelLocator)
                .textTrimmed().isEqualTo(FirstNameLabel)
                .withCustomReportMessage("Check that first name label exists")
                .perform();
        driver.verifyThat().element(LoginDatenEmailLabelLocator)
                .textTrimmed().isEqualTo(EmailLabel)
                .withCustomReportMessage("Check that Email label exists")
                .perform();
        driver.verifyThat().element(LoginDatenEmailLocator)
                .textTrimmed().matchesRegex(EmailRegex)
                .withCustomReportMessage("Check that Valid Email exists")
                .perform();
        driver.verifyThat().element(LoginDatenEditButtonLocator)
                .textTrimmed().isEqualTo(LoginDataEditButton)
                .withCustomReportMessage("Check that Login data edit button exists")
                .perform();
        return this;
    }

    public MeineDaten AssertLoginDataInCaseNotValidatedEmailAndNPhone() {
        driver.verifyThat().element(KundenKontaktdatenSectionHeaderLocator)
                .textTrimmed().contains(ContactDataSectionHeader)
                .withCustomReportMessage("Check that contact data section header exists")
                .perform();
        driver.verifyThat().element(KundenKontaktdatenSectionFooterLocator)
                .textTrimmed().isEqualTo(ContactDataSectionFooter)
                .withCustomReportMessage("Check that contact data section footer exists")
                .perform();
        driver.verifyThat().element(KabelDeutschlandTitleLocator)
                .exists()
                .withCustomReportMessage("Check that Kable Deutschland Title exists")
                .perform();
        driver.verifyThat().element(KundennummerLocator)
                .exists()
                .withCustomReportMessage("Check that customer number label  exists")
                .perform();
        driver.verifyThat().element(HomeNumberTitle)
                .textTrimmed().isEqualTo(HomeNumberTitle_Cl)
                .withCustomReportMessage("Check that mobile number not provided error message exists")
                .perform();
        driver.verifyThat().element(HomeNumberContent)
                .textTrimmed().isEqualTo(PhoneNumberNotProvidedMessage)
                .withCustomReportMessage("Check that mobile number not provided error message exists")
                .perform();
        driver.verifyThat().element(MobileNumTitle)
                .textTrimmed().isEqualTo(MobileNumTitle_CL)
                .withCustomReportMessage("Check that Landline number label exists")
                .perform();
        driver.verifyThat().element(MobileNumContent)
                .exists()
                .withCustomReportMessage("Check that Landline number provided exists")
                .perform();
        driver.verifyThat().element(ContactDataEmailLabelLocator)
                .textTrimmed().isEqualTo(ContactDataEmailLabel)
                .withCustomReportMessage("Check that contact data Email label exists")
                .perform();
        driver.verifyThat().element(ContactDataEmailLocator)
                .exists()
                .withCustomReportMessage("Check that contact data Email exists")
                .perform();
        driver.verifyThat().element(ContactdataEditButtonlocator)
                .textTrimmed().isEqualTo(ContactDataEditButton)
                .withCustomReportMessage("Check that contact data edit button exists")
                .perform();
        return this;
    }

    public MeineDaten AssertLoginDataInCaseNoEmailNoMobile() {
        driver.verifyThat().element(KundenKontaktdatenSectionHeaderLocator)
                .textTrimmed().contains(ContactDataSectionHeader)
                .withCustomReportMessage("Check that contact data section header exists")
                .perform();
        driver.verifyThat().element(KundenKontaktdatenSectionFooterLocator)
                .textTrimmed().isEqualTo(ContactDataSectionFooter)
                .withCustomReportMessage("Check that contact data section footer exists")
                .perform();
        driver.verifyThat().element(KabelDeutschlandTitleLocator)
                .exists()
                .withCustomReportMessage("Check that Kable Deutschland Title exists")
                .perform();
        driver.verifyThat().element(KundennummerLocator)
                .exists()
                .withCustomReportMessage("Check that customer number label  exists")
                .perform();
        driver.verifyThat().element(HomeNumberTitle)
                .textTrimmed().isEqualTo(HomeNumberTitle_Cl)
                .withCustomReportMessage("Check that mobile number not provided error message exists")
                .perform();
        driver.verifyThat().element(HomeNumberContent)
                .textTrimmed().isEqualTo(PhoneNumberNotProvidedMessage)
                .withCustomReportMessage("Check that mobile number not provided error message exists")
                .perform();
        driver.verifyThat().element(MobileNumTitle)
                .textTrimmed().isEqualTo(MobileNumTitle_CL)
                .withCustomReportMessage("Check that Landline number label exists")
                .perform();
        driver.verifyThat().element(MobileNumContent)
                .exists()
                .withCustomReportMessage("Check that Landline number provided exists")
                .perform();
        driver.verifyThat().element(ContactDataEmailLabelLocator)
                .textTrimmed().isEqualTo(ContactDataEmailLabel)
                .withCustomReportMessage("Check that contact data Email label exists")
                .perform();
        driver.verifyThat().element(ContactDataEmailLocator)
                .exists()
                .withCustomReportMessage("Check that contact data Email not provided error message exists")
                .perform();
        driver.verifyThat().element(ContactdataEditButtonlocator)
                .textTrimmed().isEqualTo(ContactDataEditButton)
                .withCustomReportMessage("Check that contact data edit button exists")
                .perform();
        return this;
    }

    public MeineDaten validateDatenSchutzAccordion() {
        driver.verifyThat().element(DatenschutzAccordionHeaderText)
                .textTrimmed().isEqualTo(Dashboard.Datenschutz_Accordion_HeaderText)
                .withCustomReportMessage("Validate Datenschutz accordion header text")
                .perform();
        driver.verifyThat().element(DatenschutzAccordionFooterText)
                .textTrimmed().isEqualTo(Dashboard.Datenschutz_Accordion_FooterText)
                .withCustomReportMessage("Validate Datenschutz accordion footer text")
                .perform();
        return this;
    }

    public MeineDaten clickOnKontaktdatenAcc() {
        driver.element().click(kontaktdaten_Acc);
        return this;
    }


}
