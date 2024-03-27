package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TVProductDetails {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    public static final By TV_Accordion = By.xpath("(//a//span[@class='mbo-name break-word'])[2]");
    public static final By TV_Settings_SO = By.xpath("//smart-object[@automation-id='TV_settings_so']");
    public static final By TV_Settings_SOHeader = By.xpath("//h3[contains(text(),'Geräte & Einstellungen')]");
    public static final By TV_Settings_PgHeader = By.xpath("//*[@automation-id=\"pageHeader_tv\"]");
    public static final By TV_Settings_SO_InPAge = By.xpath("//*[@automation-id='tvDevices_so']");
    public static final By TV_Settings_SO_InPAge_Title = By.xpath("(//div[@class='sb-block-head']//h3)[1]");
    public static final By TV_Settings_SO_InPAge_Desc = By.xpath("(//div[@class='sb-block-footer'])[1]");
    public static final By TV_Device_Acc = By.xpath("//li[@automation-id='tvDevices_acc']");
    public static final By TV_Device_Acc_Title = By.xpath("(//li[@automation-id=\"tvDevices_acc\"]//h4)[1]");
    public static final By TV_Device_Acc_Desc = By.xpath("(//li[@automation-id=\"tvDevices_acc\"]//h5)[1]");
    public static final By TV_Device_Section = By.xpath("(//div[@automation-id=\"tvDevices_lv\"])[1]");

    public static final By First_TV_Device_Name_Title = By.xpath("(//*[@class=\"product-details-card-details\"]/div/h4)[1]");
    public static final By First_TV_Device_Name_Content = By.xpath("(//*[@class=\"product-details-card-details\"]/div/span)[1]");
    public static final By First_TV_Serial_Num_Title = By.xpath("(//*[@class=\"product-details-card-details\"]/div/h4)[2]");
    public static final By First_TV_Serial_Num_Content = By.xpath("(//*[@class=\"product-details-card-details\"]/div/span)[2]");
    public static final By First_TV_Ownership_Title = By.xpath("(//*[@class=\"product-details-card-details\"]/div/h4)[3]");
    public static final By First_TV_Ownership_Content = By.xpath("(//*[@class=\"product-details-card-details\"]/div/span)[3]");
    public static final By First_TV_Download_Multi_Catalog_Linkout = By.xpath("(//*[@class=\"fm-buttons\"]/a[text()='Kurzanleitung und Benutzerhandbuch'])[1]");

    public static final By Second_TV_Device_Name_Title = By.xpath("(//*[@class=\"product-details-card-details\"]/div/h4)[4]");
    public static final By Second_TV_Device_Name_Content = By.xpath("(//*[@class=\"product-details-card-details\"]/div/span)[4]");
    public static final By Second_TV_Serial_Num_Title = By.xpath("(//*[@class=\"product-details-card-details\"]/div/h4)[5]");
    public static final By Second_TV_Serial_Num_Content = By.xpath("(//*[@class=\"product-details-card-details\"]/div/span)[5]");
    public static final By Second_TV_Ownership_Title = By.xpath("(//*[@class=\"product-details-card-details\"]/div/h4)[6]");
    public static final By Second_TV_Ownership_Content = By.xpath("(//*[@class=\"product-details-card-details\"]/div/span)[6]");
    public static final By Second_TV_Download_Single_Catalog_Btn = By.xpath("(//div[@class='fm-buttons'])[1]");

    public static final By Analog_TV_MSG_Title = By.xpath("//*[@automation-id=\"noDevices_nt\"]/div/div//div/h4");
    public static final By Analog_TV_MSG_Body = By.xpath("//*[@automation-id=\"noDevices_nt\"]/div/div/p");

    //Locators for WFDT-9056 | View GigaTV devices
    public static final By gigaTV_ACC_Tittle = By.xpath("(//li[@automation-id='gigatv_acc']//h4)[1]");
    public static final By gigaTV_ACC_Desc = By.xpath("//li[@automation-id='gigatv_acc']//h5");
    public static final By registered_Devices = By.xpath("(//div[@id='gigTvId']//span)[1]");
    public static final By registered_Devices_Number = By.xpath("(//div[@id='gigTvId']//span)[2]");
    public static final By devices_Can_Registered = By.xpath("(//div[@id='gigTvId']//span)[3]");
    public static final By devices_Can_Registered_Number = By.xpath("(//div[@id='gigTvId']//span)[4]");
    public static final By first_Device_Name = By.xpath("(//div[@automation-id='undefined_tv']//div//h4)[1]");
    public static final By first_Device_Registered_Date = By.xpath("(//div[@automation-id='undefined_tv']//div//span)[2]");
    public static final By second_Device_Name = By.xpath("(//div[@automation-id='undefined_tv']//div//h4)[2]");
    public static final By second_Device_Registered_Date = By.xpath("(//div[@automation-id='undefined_tv']//div//span)[2]");
    public static final By third_Device_Name = By.xpath("(//div[@automation-id='undefined_tv']//div//h4)[3]");
    public static final By msgHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    public static final By msgTittle = By.xpath("//div[@automation-id='successMsg_tv']//p");
    public static final By not_Registered_MSGHeader1 = By.xpath("//div[@class='white-box']//h4");
    public static final By not_Registered_MSGTittle1 = By.xpath("(//div[@class='white-box']//p)[1]");
    public static final By not_Registered_MSGHeader2 = By.xpath("(//div[@class='white-box']//p)[2]");
    public static final By not_Registered_MSG = By.xpath("(//div[@class='white-box']//p)[3]");
    public static final By not_Registered_MSGSubTittle1 = By.xpath("(//ul[@class='bullet-list']//li)[1]");
    public static final By not_Registered_MSGSubTittle2 = By.xpath("(//ul[@class='bullet-list']//li)[2]");
    public static final By not_Registered_MSGSubTittle3 = By.xpath("(//ul[@class='bullet-list']//li)[3]");

    //Locators for WFDT-9067 | Manage and delete GigaTV devices
    private static final By gigaTV_ACC = By.xpath("//li[@automation-id='gigatv_acc']//a");
    private static final By deleteFirstDevice_button = By.xpath("(//div[@automation-id='undefined_tv']//button)[1]");
    private By deleteSecondDevice_button = By.xpath("(//div[@automation-id='undefined_tv']//button)[2]");
    private By gigaTVSmartObject_label = By.xpath("//div[@automation-id='cableGigatv_so']");

    //CLs
    public static String TV_Device_Name_Title_CL = "Gerätename:";
    public static String TV_Serial_Num_Title_CL = "Seriennummer:";
    public static String TV_Ownership_Title_CL = "Besitzart:";
    public static String TV_Download_Single_Catalog_Btn_CL = "Kurzanleitung und Benutzerhandbuch";
    public static String TV_Download_Multi_Catalog_Linkout_CL = "Kurzanleitung und Benutzerhandbuch";
    public static String TV_Settings_SO_InPAge_Title_CL = "Geräte & Einstellungen";
    public static String TV_Settings_SO_InPAge_Desc_CL = "Meine Geräte für TV und Radio";
    public static String TV_Device_Acc_Title_CL = "Geräte";
    public static String TV_Device_Acc_Desc_CL = "Alle Infos zu Deinen Geräten und zur Störungsbehebung";
    public static String Not_Retrieved_Details_CL = "nicht verfügbar";
    public static String Analog_TV_MSG_Title_CL = "Keine Daten gefunden";
    public static String Analog_TV_MSG_Body_CL = "Aktuell haben wir leider keine Infos zu Deinen Geräten.";

    public static String gigaTV_ACC_Tittle_CL = "GigaTV-Geräte";
    public static String gigaTV_ACC_Desc_CL = "Leg fest, welche Geräte Zugriff auf die GigaTV-App haben";
    public static String registered_Devices_CL = "Registrierte Geräte:";
    public static String devices_Can_Registered_CL = "Geräte, die Du noch registrieren kannst:";
    public static String first_Device_Name_CL = "Nina's Phone";
    public static String device_Registered_Date_Cl = "Registriert am:";
    public static String second_Device_Name_CL = "Carl's tablet";
    public static String third_Device_Name_CL = "Nour's Router";
    public static String deleteDevice_Button_CL = "Entfernen";
    public static String pending_MSGHeader_CL = "Gut zu wissen";
    public static String pending_MSGTittle_CL = "Ab dem 08.10.2023 kannst Du wieder ein Gerät aus Deiner Liste entfernen.";
    public static String not_Registered_MSGHeader1_CL = "Noch kein Gerät registriert?";
    public static String not_Registered_MSGTittle1_CL = "Du kannst GigaTV ganz einfach nutzen.";
    public static String not_Registered_MSGHeader2_CL = "Du brauchst:";
    public static String not_Registered_MSGSubTittle1_CL= "Eine Datenverbindung zum Mobilfunkoder WLAN-Netz";
    public static String not_Registered_MSGSubTittle2_CL= "Ein Smartphone oder Tablet mit Android oder iOS";
    public static String not_Registered_MSGSubTittle3_CL= "Die Vodafone GigaTV-App";

    public static String not_Registered_MSG_CL1 = "Registrier bis zu 3 mobile Geräte. Du kannst die App aber immer nur auf 2 Geräten gleichzeitig zum Fernsehen nutzen.";
    public static String not_Registered_MSG_CL2 = "Wichtig: Die GigaTV-App funktioniert nur in Deutschland.";
    public static String not_Subscribed_MSGHeader_CL = "GigaTV-Angebot für Dich";
    public static String not_Subscribed_MSGTittle_CL = "Buch die Option einfach dazu und profitiere von der Programmvielfalt von GigaTV.";

    public static String service_Fail_MSGHeader_CL ="Das hat leider nicht geklappt";
    public static String service_Fail_MSGTittle_CL ="Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    // Cls for new workaround for giga TV View User Story (WFDT-9067)
    public static String errorMessageTitle_CL ="Das hat nicht geklappt";
    private String errorMessageDescription_CL1 = "Entschuldige bitte, unser Fehler. Wir arbeiten schon daran, dass Du Deine GigaTV-Geräte bald wieder verwalten kannst.";
    private String errorMessageDescription_CL2 = "Du willst GigaTV auf einem neuen Gerät nutzen und ein altes entfernen? Dann meld Dich bei unsern Expert:innen.";
    private String errorMessageDescription_CL3 = "Whats App - 0172 121 72 12";
    private String errorMessageDescription_CL4 = "X (Twitter)";
    private String errorMessageDescription_CL5 = "Facebook";
    public TVProductDetails(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    public TVProductDetails NavigateToSettingsPage() {
        driver.element().click( TV_Accordion);
        driver.element().click( TV_Settings_SOHeader);
        return this;
    }

    public TVProductDetails ValidateTVSettingSO()
    {
        driver.verifyThat().element(TV_Settings_SO_InPAge).exists().perform();
        driver.verifyThat().element(TV_Settings_SO_InPAge).isEnabled().perform();
        driver.verifyThat().element( TV_Settings_SO_InPAge_Title)
                .textTrimmed().isEqualTo(TV_Settings_SO_InPAge_Title_CL)
                .perform();
        driver.verifyThat().element(TV_Settings_SO_InPAge_Desc)
                .textTrimmed().isEqualTo(TV_Settings_SO_InPAge_Desc_CL)
                .perform();
        driver.element().click(TV_Settings_SO_InPAge);
        driver.verifyThat().element(TV_Device_Section).exists().perform();
        return this;
    }

    public TVProductDetails ValidateTVSettingAccordion()
    {        driver.verifyThat().element(TV_Device_Acc).exists().perform();
        driver.verifyThat().element(TV_Device_Acc).isEnabled().perform();
        driver.verifyThat().element(TV_Device_Acc_Title)
                .textTrimmed().isEqualTo(TV_Device_Acc_Title_CL)
                .perform();
        driver.verifyThat().element(TV_Device_Acc_Desc)
                .textTrimmed().isEqualTo(TV_Device_Acc_Desc_CL)
                .perform();
        return this;
    }

    public TVProductDetails ValidateFirstTVDetails() {
        driver.verifyThat().element(First_TV_Device_Name_Title)
                .textTrimmed().isEqualTo(TV_Device_Name_Title_CL)
                .perform();
        driver.verifyThat().element(First_TV_Serial_Num_Title)
                .textTrimmed().isEqualTo(TV_Serial_Num_Title_CL)
                .perform();
        driver.verifyThat().element(First_TV_Ownership_Title)
                .textTrimmed().isEqualTo(TV_Ownership_Title_CL)
                .perform();

        driver.verifyThat().element(First_TV_Device_Name_Content).exists().perform();
        driver.verifyThat().element(First_TV_Serial_Num_Content).exists().perform();
        driver.verifyThat().element(First_TV_Ownership_Content).exists().perform();
        return this;
    }

    public TVProductDetails ValidateSecondTVDetails()
    {
        driver.verifyThat().element(Second_TV_Device_Name_Title)
                .textTrimmed().isEqualTo(TV_Device_Name_Title_CL)
                .perform();
        driver.verifyThat().element(Second_TV_Serial_Num_Title)
                .textTrimmed().isEqualTo(TV_Serial_Num_Title_CL)
                .perform();
        driver.verifyThat().element(Second_TV_Ownership_Title)
                .textTrimmed().isEqualTo(TV_Ownership_Title_CL)
                .perform();
        driver.verifyThat().element(Second_TV_Device_Name_Content)
                .exists().perform();
        driver.verifyThat().element(Second_TV_Serial_Num_Content)
                .exists().perform();
        driver.verifyThat().element(Second_TV_Ownership_Content)
                .exists().perform();
        return this;
    }

    public TVProductDetails ValidateDownloadMultiCatalogBTN()
    {driver.verifyThat().element(First_TV_Download_Multi_Catalog_Linkout)
            .textTrimmed().isEqualTo(TV_Download_Multi_Catalog_Linkout_CL)
            .perform();
        driver.verifyThat().element(First_TV_Download_Multi_Catalog_Linkout)
                .exists().perform();
        driver.verifyThat().element(First_TV_Download_Multi_Catalog_Linkout)
                .isEnabled().perform();
    return this;
    }

    public TVProductDetails ValidateDownloadSingleCatalogBTN()
    {
        driver.verifyThat().element(Second_TV_Download_Single_Catalog_Btn)
                .isEnabled().perform();
        driver.verifyThat().element(Second_TV_Download_Single_Catalog_Btn)
                .textTrimmed().isEqualTo(TV_Download_Single_Catalog_Btn_CL)
                .perform();
    return this;
    }

    public TVProductDetails ValidateDetailsInCaseOwnershipNotRetrieved()
    {
        driver.verifyThat().element(First_TV_Serial_Num_Title)
                .textTrimmed().isEqualTo(TV_Serial_Num_Title_CL)
                .perform();
        driver.verifyThat().element(First_TV_Ownership_Title)
                .textTrimmed().isEqualTo(TV_Ownership_Title_CL)
                .perform();
        driver.verifyThat().element(First_TV_Ownership_Content)
                .textTrimmed().isEqualTo(Not_Retrieved_Details_CL)
                .perform();
        driver.verifyThat().element(First_TV_Device_Name_Content)
                .exists().perform();
        driver.verifyThat().element(First_TV_Serial_Num_Content)
                .exists().perform();
        driver.verifyThat().element(First_TV_Ownership_Content)
                .exists().perform();
        return this;
    }

    public TVProductDetails ValidateDetailsInCaseAllNotRetrieved()
    {
        driver.verifyThat().element(First_TV_Device_Name_Title)
                .textTrimmed().isEqualTo(TV_Device_Name_Title_CL)
                .perform();
        driver.verifyThat().element(First_TV_Serial_Num_Title)
                .textTrimmed().isEqualTo(TV_Serial_Num_Title_CL)
                .perform();
        driver.verifyThat().element(First_TV_Ownership_Title)
                .textTrimmed().isEqualTo(TV_Ownership_Title_CL)
                .perform();
        driver.verifyThat().element(First_TV_Device_Name_Content)
                .textTrimmed().isEqualTo(Not_Retrieved_Details_CL)
                .perform();
        driver.verifyThat().element(First_TV_Ownership_Content)
                .textTrimmed().isEqualTo(Not_Retrieved_Details_CL)
                .perform();

        driver.verifyThat().element(First_TV_Device_Name_Content)
                .exists().perform();
        driver.verifyThat().element(First_TV_Serial_Num_Content)
                .exists().perform();
        driver.verifyThat().element(First_TV_Ownership_Content)
                .exists().perform();
        return this;
    }

    public TVProductDetails ValidateDetailsInCaseAnalogTV()
    {
        driver.verifyThat().element(TV_Settings_SO_InPAge)
                .exists().perform();
        driver.verifyThat().element(TV_Settings_SO_InPAge)
                .exists().perform();
        driver.verifyThat().element(TV_Device_Acc)
                .exists().perform();
        driver.verifyThat().element(TV_Device_Acc)
                .isEnabled().perform();
        driver.verifyThat().element(TV_Settings_SO_InPAge_Title)
                .textTrimmed().isEqualTo(TV_Settings_SO_InPAge_Title_CL)
                .perform();
        driver.verifyThat().element(TV_Settings_SO_InPAge_Desc)
            .textTrimmed().isEqualTo(TV_Settings_SO_InPAge_Desc_CL)
            .perform();
        driver.verifyThat().element(TV_Device_Acc_Title)
                .textTrimmed().isEqualTo(TV_Device_Acc_Title_CL)
                .perform();
        driver.verifyThat().element(TV_Device_Acc_Desc)
                .textTrimmed().isEqualTo(TV_Device_Acc_Desc_CL)
                .perform();
        driver.element().click(TV_Settings_SO_InPAge);
        driver.verifyThat().element(Analog_TV_MSG_Title)
                .exists().perform();
        driver.verifyThat().element(Analog_TV_MSG_Body)
                .exists().perform();
        driver.verifyThat().element(Analog_TV_MSG_Title)
                .textTrimmed().isEqualTo(Analog_TV_MSG_Title_CL)
                .perform();
        driver.verifyThat().element(Analog_TV_MSG_Body)
                .textTrimmed().isEqualTo(Analog_TV_MSG_Body_CL)
                .perform();
        return this;
    }

    //TV smart card
    public TVProductDetails ValidateTVSmartCardDetails() {
        driver.verifyThat().element(TV_Settings_SO_InPAge)
                .exists().perform();
        driver.verifyThat().element(TV_Settings_SO_InPAge)
                .exists().perform();
        driver.verifyThat().element(TV_Device_Acc)
                .exists().perform();
        driver.verifyThat().element(TV_Device_Acc)
                .isEnabled().perform();
        driver.element().click(TV_Settings_SO_InPAge);

        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCard_Container)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCard_IMG)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardID_Title)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardID_Content)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardName_Title)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardName_Content)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardID_Title)
                .textTrimmed().isEqualTo(TVSmartCardDetails.TV_SmartCardID_Title_CL)
                .perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardName_Title)
                .textTrimmed().isEqualTo(TVSmartCardDetails.TV_SmartCardName_Title_CL)
                .perform();
        return this;
    }

    public TVProductDetails ValidateTVSmartCardInCaseNoDetails() {
        driver.verifyThat().element(TV_Settings_SO_InPAge)
                .exists().perform();
        driver.verifyThat().element(TV_Device_Acc)
                .exists().perform();
        driver.element().click(TV_Settings_SO_InPAge);
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCard_Container)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCard_IMG)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardID_Title)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardID_Content)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardName_Title)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardName_Content)
                .exists().perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardID_Title)
                .textTrimmed().isEqualTo(TVSmartCardDetails.TV_SmartCardID_Title_CL)
                .perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardName_Title)
                .textTrimmed().isEqualTo(TVSmartCardDetails.TV_SmartCardName_Title_CL)
                .perform();
        driver.verifyThat().element(TVSmartCardDetails.TV_SmartCardName_Content)
                .textTrimmed().isEqualTo(TVSmartCardDetails.SmartCardNoDetails_CL)
                .perform();
        return this;
    }

    //Action and validation for WFDT-9056 | View GigaTV devices
    public TVProductDetails validateGigaTVDevicesInCaseLastEditDateWithin30Days() {
        driver.verifyThat().element(gigaTV_ACC_Tittle)
                .textTrimmed().isEqualTo(gigaTV_ACC_Tittle_CL)
                .perform();
        driver.verifyThat().element(gigaTV_ACC_Desc)
                .textTrimmed().isEqualTo(gigaTV_ACC_Desc_CL)
                .perform();
        driver.verifyThat().element(registered_Devices)
                .textTrimmed().isEqualTo(registered_Devices_CL)
                .perform();
        driver.verifyThat().element(registered_Devices_Number)
                .textTrimmed().isEqualTo("2")
                .perform();
        driver.verifyThat().element(devices_Can_Registered)
                .textTrimmed().isEqualTo(devices_Can_Registered_CL)
                .perform();
        driver.verifyThat().element(devices_Can_Registered_Number)
                .textTrimmed().isEqualTo("1")
                .perform();
        driver.verifyThat().element(first_Device_Name)
                .textTrimmed().isEqualTo(second_Device_Name_CL)
                .perform();
        driver.verifyThat().element(second_Device_Registered_Date)
                .textTrimmed().isEqualTo(device_Registered_Date_Cl)
                .perform();
        driver.verifyThat().element(deleteSecondDevice_button)
                .textTrimmed().isEqualTo(deleteDevice_Button_CL)
                .perform();
        driver.verifyThat().element(deleteSecondDevice_button)
                .isDisabled().perform();
        driver.verifyThat().element(second_Device_Name)
                .textTrimmed().isEqualTo(third_Device_Name_CL)
                .perform();
        driver.verifyThat().element(msgHeader)
                .textTrimmed().isEqualTo(pending_MSGHeader_CL)
                .perform();
        driver.verifyThat().element(msgTittle)
                .textTrimmed().isEqualTo(pending_MSGTittle_CL)
                .perform();

        return this;
    }

    public TVProductDetails validateGigaTVDevicesInCaseLastEditDateAfter30Days() {
        driver.verifyThat().element(gigaTV_ACC_Tittle)
                .textTrimmed().isEqualTo(gigaTV_ACC_Tittle_CL)
                .perform();
        driver.verifyThat().element(gigaTV_ACC_Desc)
                .textTrimmed().isEqualTo(gigaTV_ACC_Desc_CL)
                .perform();
        driver.verifyThat().element(registered_Devices)
                .textTrimmed().isEqualTo(registered_Devices_CL)
                .perform();
        driver.verifyThat().element(registered_Devices_Number)
                .textTrimmed().isEqualTo("3")
                .perform();
        driver.verifyThat().element(devices_Can_Registered)
                .textTrimmed().isEqualTo(devices_Can_Registered_CL)
                .perform();
        driver.verifyThat().element(devices_Can_Registered_Number)
                .textTrimmed().isEqualTo("0")
                .perform();
        driver.verifyThat().element(first_Device_Name)
                .textTrimmed().isEqualTo(first_Device_Name_CL)
                .perform();
        driver.verifyThat().element(first_Device_Registered_Date)
                .textTrimmed().isEqualTo(device_Registered_Date_Cl)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .textTrimmed().isEqualTo(deleteDevice_Button_CL)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .isEnabled().perform();
        driver.verifyThat().element(second_Device_Name)
                .textTrimmed().isEqualTo(second_Device_Name_CL)
                .perform();
        driver.verifyThat().element(third_Device_Name)
                .textTrimmed().isEqualTo(third_Device_Name_CL)
                .perform();

        return this;
    }

    public TVProductDetails validateGigaTVDevicesInCaseNoRegisteredDevices() {
        driver.verifyThat().element(not_Registered_MSGHeader1)
                .textTrimmed().isEqualTo(not_Registered_MSGHeader1_CL)
                .perform();
        driver.verifyThat().element(not_Registered_MSGTittle1)
                .textTrimmed().isEqualTo(not_Registered_MSGTittle1_CL)
                .perform();
        driver.verifyThat().element(not_Registered_MSGHeader2)
                .textTrimmed().isEqualTo(not_Registered_MSGHeader2_CL)
                .perform();
        driver.verifyThat().element(not_Registered_MSGSubTittle1)
                .textTrimmed().isEqualTo(not_Registered_MSGSubTittle1_CL)
                .perform();
        driver.verifyThat().element(not_Registered_MSGSubTittle2)
                .textTrimmed().isEqualTo(not_Registered_MSGSubTittle2_CL)
                .perform();
        driver.verifyThat().element(not_Registered_MSGSubTittle3)
                .textTrimmed().isEqualTo(not_Registered_MSGSubTittle3_CL)
                .perform();
        driver.verifyThat().element(not_Registered_MSG)
                .textTrimmed().contains(not_Registered_MSG_CL1)
                .perform();
        driver.verifyThat().element(not_Registered_MSG)
                .textTrimmed().contains(not_Registered_MSG_CL2)
                .perform();

        return this;
    }

    public TVProductDetails validateGigaTVDevicesInCaseNoGigaTVSubscription() {
        driver.verifyThat().element(msgHeader)
                .textTrimmed().isEqualTo(not_Subscribed_MSGHeader_CL)
                .perform();
        driver.verifyThat().element(msgTittle)
                .textTrimmed().isEqualTo(not_Subscribed_MSGTittle_CL)
                .perform();
        return this;
    }

    public TVProductDetails validateGigaTVDevicesInCaseUserHas1RegisteredDevice() {
        driver.verifyThat().element(gigaTV_ACC_Tittle)
                .textTrimmed().isEqualTo(gigaTV_ACC_Tittle_CL)
                .perform();
        driver.verifyThat().element(gigaTV_ACC_Desc)
                .textTrimmed().isEqualTo(gigaTV_ACC_Desc_CL)
                .perform();
        driver.verifyThat().element(registered_Devices)
                .textTrimmed().isEqualTo(registered_Devices_CL)
                .perform();
        driver.verifyThat().element(registered_Devices_Number)
                .textTrimmed().isEqualTo("1")
                .perform();
        driver.verifyThat().element(devices_Can_Registered)
                .textTrimmed().isEqualTo(devices_Can_Registered_CL)
                .perform();
        driver.verifyThat().element(devices_Can_Registered_Number)
                .textTrimmed().isEqualTo("2")
                .perform();
        driver.verifyThat().element(first_Device_Name)
                .textTrimmed().isEqualTo(first_Device_Name_CL)
                .perform();
        driver.verifyThat().element(first_Device_Registered_Date)
                .textTrimmed().isEqualTo(device_Registered_Date_Cl)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .textTrimmed().isEqualTo(deleteDevice_Button_CL)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .isEnabled().perform();
        driver.verifyThat().element(second_Device_Name)
                .doesNotExist()
                .perform();
        driver.verifyThat().element(third_Device_Name)
                .doesNotExist()
                .perform();

        return this;
    }

    public TVProductDetails validateGigaTVDevicesInCaseUserHas2RegisteredDevice() {
        driver.verifyThat().element(gigaTV_ACC_Tittle)
                .textTrimmed().isEqualTo(gigaTV_ACC_Tittle_CL)
                .perform();
        driver.verifyThat().element(gigaTV_ACC_Desc)
                .textTrimmed().isEqualTo(gigaTV_ACC_Desc_CL)
                .perform();
        driver.verifyThat().element(registered_Devices)
                .textTrimmed().isEqualTo(registered_Devices_CL)
                .perform();
        driver.verifyThat().element(registered_Devices_Number)
                .textTrimmed().isEqualTo("2")
                .perform();
        driver.verifyThat().element(devices_Can_Registered)
                .textTrimmed().isEqualTo(devices_Can_Registered_CL)
                .perform();
        driver.verifyThat().element(devices_Can_Registered_Number)
                .textTrimmed().isEqualTo("1")
                .perform();
        driver.verifyThat().element(first_Device_Name)
                .textTrimmed().isEqualTo(first_Device_Name_CL)
                .perform();
        driver.verifyThat().element(first_Device_Registered_Date)
                .textTrimmed().isEqualTo(device_Registered_Date_Cl)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .textTrimmed().isEqualTo(deleteDevice_Button_CL)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .isEnabled().perform();
        driver.verifyThat().element(second_Device_Name)
                .textTrimmed().isEqualTo(second_Device_Name_CL)
                .perform();
        driver.verifyThat().element(third_Device_Name)
                .doesNotExist()
                .perform();

        return this;
    }

    public TVProductDetails validateGigaTVDevicesInCaseUserHas3RegisteredDevice() {
        driver.verifyThat().element(gigaTV_ACC_Tittle)
                .textTrimmed().isEqualTo(gigaTV_ACC_Tittle_CL)
                .perform();
        driver.verifyThat().element(gigaTV_ACC_Desc)
                .textTrimmed().isEqualTo(gigaTV_ACC_Desc_CL)
                .perform();
        driver.verifyThat().element(registered_Devices)
                .textTrimmed().isEqualTo(registered_Devices_CL)
                .perform();
        driver.verifyThat().element(registered_Devices_Number)
                .textTrimmed().isEqualTo("3")
                .perform();
        driver.verifyThat().element(devices_Can_Registered)
                .textTrimmed().isEqualTo(devices_Can_Registered_CL)
                .perform();
        driver.verifyThat().element(devices_Can_Registered_Number)
                .textTrimmed().isEqualTo("0")
                .perform();
        driver.verifyThat().element(first_Device_Name)
                .textTrimmed().isEqualTo(first_Device_Name_CL)
                .perform();
        driver.verifyThat().element(first_Device_Registered_Date)
                .textTrimmed().isEqualTo(device_Registered_Date_Cl)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .textTrimmed().isEqualTo(deleteDevice_Button_CL)
                .perform();
        driver.verifyThat().element(deleteFirstDevice_button)
                .isEnabled().perform();
        driver.verifyThat().element(second_Device_Name)
                .textTrimmed().isEqualTo(second_Device_Name_CL)
                .perform();
        driver.verifyThat().element(third_Device_Name)
                .textTrimmed().isEqualTo(third_Device_Name_CL)
                .perform();

        return this;
    }

    public TVProductDetails validateGigaTVDevicesInCaseServiceFail() {
        driver.verifyThat().element(msgHeader)
                .textTrimmed().isEqualTo(errorMessageTitle_CL)
                .withCustomReportMessage("validate service fail message header")
                .perform();

        driver.verifyThat().element(msgTittle)
                .textTrimmed().contains(errorMessageDescription_CL1)
                .withCustomReportMessage("validate service fail message description")
                .perform();
        driver.verifyThat().element(msgTittle)
                .textTrimmed().contains(errorMessageDescription_CL2)
                .withCustomReportMessage("validate service fail message description")
                .perform();
        driver.verifyThat().element(msgTittle)
                .textTrimmed().contains(errorMessageDescription_CL3)
                .withCustomReportMessage("validate service fail message description")
                .perform();
        driver.verifyThat().element(msgTittle)
                .textTrimmed().contains(errorMessageDescription_CL4)
                .withCustomReportMessage("validate service fail message description")
                .perform();
        driver.verifyThat().element(msgTittle)
                .textTrimmed().contains(errorMessageDescription_CL5)
                .withCustomReportMessage("validate service fail message description")
                .perform();
        return this;

    }


    //Action and validation for WFDT-9067 | Manage and delete GigaTV devices
    public TVProductDetails expandGigaTVAccordion() {
        driver.element().click(gigaTV_ACC);
        return this;
    }

    public TVProductDetails clickOnDeleteButtonForFirstDevice()
    {
        driver.element().click(deleteFirstDevice_button);
        return this;
    }

    public TVProductDetails clickOnDeleteButtonForSecondDevice() {
        driver.element().click(deleteSecondDevice_button);
        return this;
    }

    @Step("validate that Delete Giga TV Deep linking is disabled.")
    public TVProductDetails validateDeleteGigaTVDeepLinkingIsDisabled() {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/giga-tv/remove-gigatv-confirmation?accordion=productData");
        driver.verifyThat()
                .element(gigaTVSmartObject_label)
                .exists()
                .withCustomReportMessage("Validate Delete Giga TV Deep linking")
                .perform();
        return this;
    }
}
