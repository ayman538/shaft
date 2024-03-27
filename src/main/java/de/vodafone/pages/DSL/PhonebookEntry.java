package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class PhonebookEntry {
    private static SHAFT.GUI.WebDriver driver;
    public PhonebookEntry(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Step One Locators
    public static By PhonebookEntryPageHeaderLocator = By.xpath("(//*[@automation-id='pageHeader_tv']/h1)");
    public static By PersonalDataSectionHeaderLocator = By.xpath("//*[@id='step0']//div[@class='header-title']");
    public static By PersonalDataSectionTextLocator = By.xpath("(//*[@automation-id='phoneBookInstruction_tv'])");
    public static By TitleLocator = By.xpath("//input[@id='title']");
    public static By TitleValueLocator = By.xpath("(//suggest-field-brix[@datasource='titles']//ul[@class='brix-suggest-field__result']//li)[1]");
    public static By TitleHintLocator = By.xpath("(//*[@automation-id='title_hint_nt'])");
    public static By FirstnamelablelLocator = By.xpath("(//*[@id='personalInformationForm']//div)[17]//label");
    public static By FirstNameLocator = By.xpath("(//*[@automation-id='firstname_et'])");
    public static By LastnamelablelLocator = By.xpath("(//*[@id='personalInformationForm']//div)[21]//label");

    public static By LastNameLocator = By.xpath("(//*[@automation-id='surname_et'])");
    public static By ProfessionLocator = By.xpath("(//*[@id='profession'])");
    public static By ProfessionValueLocator = By.xpath("(//suggest-field-brix[@datasource='professions']//ul[@class='brix-suggest-field__result']//li)[1]");
    public static By ProfessionHintLocator = By.xpath("(//*[@automation-id='profession_hint_nt'])");
    public static By PhoneNumberLabelLocator = By.xpath("(//*[@id='personalInformationForm']//div)[36]//label");
    public static By PhoneNumberLocator = By.xpath("(//*[@automation-id='telephoneNumber_et'])");
    public static By PhoneNumberHintLocator = By.xpath("(//*[@automation-id='telephoneNumber_hint_nt'])");
    public static By StreetNumberLabelLocator = By.xpath("(//*[@id='personalInformationForm']//div)[42]//label");
    public static By StreetNumberLocator = By.xpath("(//*[@automation-id='streetAndHouseNumber_et'])");
    public static By PostalCodeLabelLocator = By.xpath("(//*[@id='personalInformationForm']//div)[45]//label");
    public static By PostalCodeLocator = By.xpath("(//*[@automation-id='postalCodeAndCity_et'])");
    public static By MandatoryAttLabelLocator = By.xpath("(//div[@class='mb20'])");
    public static By ProceedToStep2CTA_Locator = By.xpath("(//*[@automation-id='personal_info_form_submit_btn'])");
    //Step two locators
    public static By PhonebookEntrySectionHeaderLocator = By.xpath("//*[@id='step1']//div[@class='header-title']");
    public static By PhonebookEntrySectionTextLocator = By.xpath("//*[@automation-id='phoneEntriesInstruction_tv']");
    public static By TelephoneNumberLabelLocator = By.xpath("(//phone-entry//h3[@automation-id='phoneEntryHeadLine_tv'])[1]");
    public static By TelephoneNumberLocator = By.xpath("(//phone-entry//p[@class='h2'])[1]");
    public static By TelephoneNumberSectionAttributesContainerLocator = By.xpath("(//*[@class='white-box']//div)[6]");
    public static By CreateChangeDeletePhonebookLabelLocator = By.xpath("(//*[@automation-id='checkboxItemModel.id_container_tv']//label//div)[2]");
    public static By CreateChangeDeletePhonebookCheckboxLocator = By.xpath("//*[@id='phoneEntry0Selector']");

    public static By EnterAsaPhoneLabelLocator = By.xpath("//*[@id='ol-radio_no1_0']//p");
    public static By EnterAsaPhoneRadioButtonLocator = By.xpath("(//*[@id='ol-radio_no1_0']//div)[3]");
    public static By EnterAsaFaxLabelLocator = By.xpath("//*[@id='ol-radio_no2_0']//p");
    public static By EnterAsaFaxRadioButtonLocator = By.xpath("(//*[@id='ol-radio_no2_0']//div)[3]");
    public static By EnterAsaPhoneAndFaxLabelLocator = By.xpath("//*[@id='ol-radio_no3_0']//p");
    public static By EnterAsaPhoneAndFaxRadioButtonLocator = By.xpath("(//*[@id='ol-radio_no3_0']//div)[3]");
    public static By DeletePhonebookEntryLabelLocator = By.xpath("//*[@id='ol-radio_no4_0']//p");
    public static By DeletePhonebookEntryRadioButtonLocator = By.xpath("(//*[@id='ol-radio_no4_0']//div)[3]");
    public static By DeletePhonebookEntryContainerLocator = By.xpath("(//*[@class='white-box']//div)[25]");

    public static By EntryTypeLabelLocator = By.xpath("(//*[@formcontrolname='entryType']//label)[1]");
    public static By EntryTypeLocator = By.xpath("//*[@automation-id='entryTypeDropDown0_btn']");
    public static By EntryTypeFirstOptionLocator = By.xpath("((//div[@class='fm-select multi-tag-select'])[1]//ul//li)[1]");
    public static By EntryTypeSecondOptionLocator = By.xpath("((//div[@class='fm-select multi-tag-select'])[1]//ul//li)[2]");
    public static By EntryTypeThirdOptionLocator = By.xpath("((//div[@class='fm-select multi-tag-select'])[1]//ul//li)[3]");

    public static By EntryTypeFirstHintLocator = By.xpath("//*[@automation-id='dropDown1Opt2_hint_nt']");
    public static By EntryTypeSecondHintLocator = By.xpath("//*[@automation-id='dropDown1Opt3_hint_nt']");
    public static By EntryTypeThirdHintLocator = By.xpath("//*[@automation-id='dropDown1Opt4_hint_nt']");
    public static By TypeOfInfoLabelLocator = By.xpath("(//*[@formcontrolname='typeOfInformation']//label)[1]");
    public static By TypeOfInfoLocator = By.xpath("//*[@automation-id='typeOfInfoDropDown0_btn']");
    public static By TypeOfInfoFirstOptionLocator = By.xpath("(//*[@automation-id='typeOfInfoDropDown0_lv']//li)[1]");
    public static By TypeOfInfoSecondOptionLocator = By.xpath("(//*[@automation-id='typeOfInfoDropDown0_lv']//li)[2]");

    public static By TypeOfInfoFirstHintLocator = By.xpath("//*[@automation-id='dropDown2Opt2_hint_nt']");
    public static By TypeOfInfoSecondHintLocator = By.xpath("//*[@automation-id='dropDown2Opt3_hint_nt']");
    public static By CoUserLabelLocator = By.xpath("(//*[@formcontrolname='coUser']//label)[1]");
    public static By CoUserLocator = By.xpath("//*[@automation-id='coUser0_et']");
    public static By CoUserHintLocator = By.xpath("(//*[@automation-id='coUser_hint_nt'])[1]");
    public static By AllowReverseSearchLabelLocator = By.xpath("(//*[@automation-id='allowReverseSearchCheckBoxHeadLine_tv'])[1]");
    public static By AllowReverseSearchTextLocator = By.xpath("((//*[@formcontrolname='allowReverseSearch'])//div[2])[1]");
    public static By AllowReverseSearchCheckboxLocator = By.xpath("(//*[@id='allowReverseSearchCheckbox0'])");
    public static By AllowInfoLabelLocator = By.xpath("(//*[@automation-id='allowInformationCheckBoxHeadLine_tv'])[1]");
    public static By AllowInfoTextLocator = By.xpath("((//*[@formcontrolname='noInformation'])//div[2])[1]");
    public static By AllowInfoCheckboxLocator = By.xpath("(//*[@id='allowInformationChecbox0'])");
    public static By MandatoryAttLabelIILocator = By.xpath("(//div[@class='mb-15'])");
    public static By ProceedToStep3CTA_Locator = By.xpath("(//*[@automation-id='phone_entries_form_submit_btn'])");
    //Step three locators
    public static By CheckAndSendDataSectionHeaderLocator = By.xpath("//*[@id='step2']//div[@class='header-title']");
    public static By PersonalDataHeaderLabelLocator = By.xpath("(//*[@class='white-box']//h3)[1]");
    public static By FirstNameLabelLocator = By.xpath("//*[text()='Vorname']");
    public static By FirstNameValLocator = By.xpath("//*[text()='Vorname']/following-sibling::p");
    public static By LastNameLabelLocator = By.xpath("//*[text()='Nachname']");
    public static By LastNameValLocator = By.xpath("//*[text()='Nachname']/following-sibling::p");
    public static By PhoneNumberLabLoctor = By.xpath("//*[text()='Telefonnummer für Rückfragen']");
    public static By PhoneNumberValLocator = By.xpath("//*[text()='Telefonnummer für Rückfragen']/following-sibling::p");
    public static By PhonebookEntryHeaderLabelLocator = By.xpath("(//*[@class='white-box']//h3)[2]");
    public static By PhoneNumberLabLocator = By.xpath("//*[text()='1. Rufnummer']");
    public static By PhoneNumberValueLocator = By.xpath("//*[text()='1. Rufnummer']/following-sibling::p");
    public static By EntryTypeLabLocator = By.xpath("//*[text()='Eintragsart']");
    public static By EntryTypeValLocator = By.xpath("//*[text()='Eintragsart']/following-sibling::p");
    public static By TypeOfInfoLabLocator = By.xpath("//*[text()='Auskunftsart']");
    public static By TypeOfInfoValLocator = By.xpath("//*[text()='Auskunftsart']/following-sibling::p");
    public static By HintMsgLocator = By.xpath("//*[text()='Die hier nicht aufgeführten Rufnummern werden nicht eingetragen oder geändert.']");
    public static By InfoBoxLocator = By.xpath("//*[@automation-id='warningNotification_nt']//p");
    public static By ProceedToConfPageCTA_Locator = By.xpath("(//*[@class='btn'])[3]");



    //step One Cls
    public static String PhonebookEntryPageHeaderCL = "Telefonbucheintrag";
    public static String PersonalDataSectionHeaderCL = "Persönliche Daten";
    public static String PersonalDataSectionTextCL = "Als Vodafone-Kund:in kannst Du hier Deinen Telefonbucheintrag anlegen, ändern oder löschen. Für gedruckte Verzeichnisse, die Telefonauskunft und für elektronische Medien.\n" +
            "\n" +
            "Der Eintrag einer Nummer ist kostenlos. Jede weitere Nummer ist kostenpflichtig. Die Preise findest Du in der Preisliste.";
    public static String TitleCL = "Mr.";
    public static String TitleHintCL = "Bitte wähle einen Titel aus der Liste aus. Du kannst die Auswahl einengen, indem Du den/die Anfangsbuchstaben hier eingibst. Wenn Du keinen Titel verwenden möchtest, sorge bitte dafür, dass dieses Feld leer ist. Dies ist kein Pflichtfeld";

    public static String FirstnamelablelCL = "Vorname *";

    public static String FirstNameCL = "DummyFirstName";
    public static String LastnamelablelCL = "Nachname *";
    public static String LastNameCL = "DummyLastName";
    public static String ProfessionCL = "Softwareprogrammierung";
    public static String ProfessionHintCL = "Bitte wähle einen Beruf aus der Liste aus. Du kannst die Auswahl einengen, indem Du den/die Anfangsbuchstaben hier eingibst. Wenn Du keinen Beruf verwenden möchtest, sorge bitte dafür, dass dieses Feld leer ist. Dies ist kein Pflichtfeld.";
    public static String PhonenumberlabelCL = "Rufnummer für Rückfragen *";
    public static String PhoneNumberCL = "01519223655";
    public static String PhoneNumberHintCL = "Gib bitte eine Telefonnummer an,\n" +
            "unter der Du tagsüber erreichbar bist.";
    public static String StreetNumberLabelCL = "Straße und Hausnummer (Postfach)";

    public static String StreetNumberCL = "";
    public static String PostalCodeLabelCL = "PLZ und Ort";

    public static String PostalCodeCL = "";
    public static String MandatoryAttLabelCL = "* Pflichtfeld";

    public static String ProceedToStep2CTA_CL = "Weiter";
    //Step two CLs
    public static String PhonebookEntrySectionHeaderCL = "Telefonbucheinträge";
    public static String PhonebookEntrySectionTextCL = "Wähl bitte die Rufnummern, für die Du einen Eintrag erstellen, ändern oder löschen willst.";
    public static String TelephoneNumberLabCL = "1. Rufnummer";
    public static String CreateChangeDeletePhonebookLabelCL = "Telefonbucheintrag erstellen, ändern oder löschen";
    public static String EnterAsaPhoneLabelCL = "als Telefon eintragen";
    public static String EnterAsaFaxLabelCL = "als Fax eintragen";
    public static String EnterAsaPhoneAndFaxLabelCL = "als Telefon und Fax eintragen";
    public static String DeletePhonebookEntryLabelCL = "Telefonbucheintrag löschen";


    public static String EntryTypeLabelCL = "Eintragsart *";
    public static String EntryTypeFirstOptionCL = "in gedruckte & elekronische Verzeichnisse";
    public static String EntryTypeFirstHintCL = "Deine Rufnummer erscheint in gedruckten und in Online-Telefonbüchern.";
    public static String EntryTypeSecondOptionCL = "in gedruckte Verzeichnisse";
    public static String EntryTypeSecondHintCL = "Deine Rufnummer erscheint nur in gedruckten Telefonbüchern.";
    public static String EntryTypeThirdOptionCL = "in elekronische Verzeichnisse";
    public static String EntryTypeThirdHintCL = "Deine Rufnummer erscheint nur in Online-Telefonbüchern.";

    public static String TypeOfInfoLabelCL = "Auskunftsart *";
    public static String TypeOfInfoFirstOptionCL = "über den kompletten Eintrag";
    public static String TypeOfInfoFirstHintCL = "Im Telefonbuch stehen Deine Rufnummer, Dein Name und Deine Adresse.";
    public static String TypeOfInfoSecondOptionCL = "nur über die Rufnummer";
    public static String TypeOfInfoSecondHintCL = "Im Telefonbuch stehen nur Deine Rufnummer und Dein Name.";

    public static String CoUserLabelCL = "Mitbenutzer:in";
    public static String CoUserCL = "Test CoUser";
    public static String CoUserHintCL = "Du kannst hier eine Person angeben, die auch unter dieser Nummer erreichbar ist, z.B. Dein:e Mitbewohner:in.";

    public static String AllowReverseSearchLabelCL = "Inverssuche zulassen?";
    public static String AllowReverseSearchTextCL = "Möchtest Du, dass man Dich über Deine Nummer im Online-Telefonbuch finden kann?";
    public static String AllowInfoLabelCL = "Auskunft zulassen?";
    public static String AllowInfoTextCL = "Möchtest Du, dass die Telefonauskunft Infos über Dich erteilt?";

    public static String MandatoryAttLabelIICL = "* Pflichtfelder";
    public static String ProceedToStep3CTA_CL = "Weiter";
    //Step three CLs
    public static String CheckAndSendDataSectionHeaderCL = ("Daten überprüfen und senden");
    public static String PersonalDataHeaderLabelCL = ("Persönliche Daten");
    public static String FirstNameLabelCL = ("Vorname");
    public static String LastNameLabelCL = ("Nachname");
    public static String PhoneNumberLabelCL = ("Telefonnummer für Rückfragen");
    public static String PhonebookEntryHeaderLabelCL = ("Telefonbucheinträge");
    public static String PhoneNumberLabCL = ("1. Rufnummer");
    public static String EntryTypeLabCL = ("Eintragsart");
    public static String TypeOfInfoLabCL = ("Auskunftsart");
    public static String HintMsgCL = ("Die hier nicht aufgeführten Rufnummern werden nicht eingetragen oder geändert.");
    public static String InfoBoxCL = ("Wichtig: Du erteilst damit einen Auftrag an Drittanbieter. Es sind keine Einstellungen in MeinVodafone, die Du schnell wieder ändern kannst. Der Telefonbucheintrag einer Rufnummer und die Löschung sind kostenlos. Der Eintrag jeder weiteren Rufnummer ist kostenpflichtig. Die Preise findest Du in der Preisliste.");
    public static String ProceedToConfPageCTA_CL = ("Verbindlich beauftragen");


    //Step one methods
    public Boolean getAttributeValue(By XpathExpression) {
        String AttributeValue = driver.element().getText(XpathExpression);
        {
            if (AttributeValue == null) {
                return false;
            } else {
                return true;
            }
        }
    }

    public PhonebookEntry fillInemptyAttribute(Boolean attributeValueStatus, By XpathExpression, String newValue)
    {
        driver.element().type(XpathExpression,newValue);
        if (attributeValueStatus==false)
        {
            driver.element().type(XpathExpression,newValue);
        }
        return this;
    }
    //Step Two Methods
    public PhonebookEntry scrollAndClick(By Element){
        WebElement element = driver.getDriver().findElement(Element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public DSL_ConfirmationPage click(By Element){
        WebElement element = driver.getDriver().findElement(Element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].click();", element);
        return new DSL_ConfirmationPage(driver);
    }
}


