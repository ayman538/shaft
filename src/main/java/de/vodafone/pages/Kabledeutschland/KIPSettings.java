package de.vodafone.pages.Kabledeutschland;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.utils.ElementActions.clickOnPopupElement;

public class KIPSettings {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //CLs
    private static String Internet_Devices_SO_Header = "Geräte & Einstellungen";
    private static String Internet_Devices_SO_Description = "Meine Geräte für Internet und Telefon";
    private static String Internet_Devices_Accordion_Title = "Geräte";
    private static String Internet_Devices_Accordion_Description = "Alle Infos zu Deinen Geräten und zur Störungsbehebung";
    private static String Gerate_Name_Label = "Gerätename:";
    private static String MAC_Adresse_Label = "MAC-Adresse:";
    private static String Ownership_Label = "Besitzart:";
    private static String Not_Returned_Info = "nicht verfügbar";
    private static String error_Message_Title = "Das hat leider nicht geklappt";
    private static String error_Message_Description = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String redirectedPageTitleCL = "Geräte-Anleitungen";
    private static String TelefoneinstellungenSO_Title_CL = "Telefoneinstellungen";
    private static String TelefoneinstellungenSO_Text_CL = "Rufnummern-Sperren ändern";
    private static String anonymousCallsSettingsCard_Btn_CL = "Ansehen und ändern";
    private static String anonymousCallsSettingsCard_Text_CL = "Ruft Dich jemand mit unterdrückter Rufnummer an, wird er automatisch blockiert.";
    private static String anonymousCallsSettingsCard_Title_CL = "Anonyme Anrufe blockieren";
    private static String callForwardCard_Title_CL = "Weiterleitung einrichten";
    private static String callForwardCard_Body_CL = "Du kannst Anrufe von Deinem Telefonanschluss auf eine andere Rufnummer, z. B. zu Deinem Mobiltelefon weiterleiten.";
    private static String callForwardCard_Btn_CL = "Ansehen und ändern";

    private static String telefoneinstellungenSO_Title_CL = "Telefoneinstellungen";
    private static String telefoneinstellungenSO_Text_CL = "Alle Einstellungen zu Deinen Rufnummern";
    private static String telefoneinstellungenAccordion_Text_CL = "Alle Einstellungen zu Deinen Rufnummern anzeigen und ändern";
    private static String visibiltyCallsSettingsCard_Btn_CL = "Ansehen und ändern";
    private static String visibiltyCallsSettingsCard_Text_CL = "Du kannst Deine eigene Rufnummer unterdrücken, damit sie nicht auf dem Display Deines Gesprächpartners angezeigt wird.";

    private static String visibiltyCallsSettingsCard_Title_CL = "Rufnummerunterdrückung einrichten";

    private static String homespotSO_Title_CL = "Homespot";
    private static String homespotSO_Text_CL = "Surf auch unterwegs im WLAN";
    private static String homespotAccordion_Title_CL = "Homespot";
    private static String homespotAccordion_Text_CL = "Surf auch unterwegs im WLAN";

    private static String homespotNotification_Title_CL = "So geht’s weiter";
    private static String homespotNotification_Text_CL = "Deaktivier zuerst den Bridge-Mode und aktivier dann den Homespot.";
    private static String homespotGeneralError_Title_CL = "Das hat leider nicht geklappt";
    private static String homespotGeneralError_Text_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal";

    private static String SIPSO_Title_CL = "SIP-Zugangsdaten";
    private static String SIPSO_Text_CL = "Zugangsdaten für Deinen eigenen Router";
    private static String SIPAccordion_Title_CL = "SIP-Zugangsdaten";
    private static String SIPAccordion_Text_CL = "Zugangsdaten für Deinen eigenen Router";
    private static String SIPNotification_Title_CL = "Gut zu wissen";
    private static String SIPNotification_Text_CL = "Wenn Du einen eigenen Router benutzt, kannst Du Deine SIP-Zugangsdaten hier ansehen.";
    private static String generalError_Title_CL = "Das hat leider nicht geklappt";
    private static String SIPgeneralError_Title_CL = "Ups, da ist was schiefgelaufen.";
    private static String generalError_Text_CL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private static String SIPgeneralError_Text_CL = "Deine SIP-Zugangsdaten können gerade nicht angezeigt werden. Versuch es bitte später nochmal.";
    private static String OutgoingCallBlocking_Btn_CL = "Ansehen und ändern";
    private static String OutgoingCallBlocking_Title_CL = "Anrufsperre einrichten";
    private static String OutgoingCallBlocking_Body_CL = "Du kannst bestimmte Anrufe, z.b. kostenpflichtige ins Ausland einfach sperren.";
    //Bridge-Mode SO & Accordion Cls
    private static String bridgeMode_SO_Header_CL = "Bridge-Mode";
    private static String pageTitleCL = "Internet & Phone – Geräte & Einstellungen";
    private static String bridgeMode_SO_Footer_CL = "Wenn Du einen zweiten Router nutzen möchtest";
    private static String bridgeMode_Acc_Header_CL = "Bridge-Mode";
    private static String bridgeMode_Acc_Footer_CL = "Wenn Du einen zweiten Router nutzen möchtest";
    private static String bridgeMode_Acc_Deactivation_Text_CL = "Du möchtest nur noch den von uns mitgelieferten Router nutzen? Deaktivier den Bridge-Mode wieder.";
    private static String bridgeMode_Acc_Deactivation_Btn_CL = "Bridge-Mode deaktivieren";
    private static String bridgeMode_Acc_Activation_Text1_CL1 = "Du hast einen Anschluss bei uns und möchtest zusätzlich Deinen eigenen Router nutzen? Aktivier dazu den Bridge-Mode.";
    private static String bridgeMode_Acc_Activation_Text1_CL2 = "Wichtig: Wir empfehlen Dir, nur unseren mitgelieferten Router zu nutzen.";

    private static String bridgeMode_Acc_Activation_Btn_CL = "Bridge-Mode aktivieren";
    private static String bridgeMode_Acc_HomeboxCase_notf_Title_CL = "Bridge-Mode nicht möglich";
    private static String bridgeMode_Acc_HomeboxCase_notf_Text_CL = "Für Deinen Router brauchst Du den Bridge-Mode nicht.";
    private static String bridgeMode_Acc_Homespot_notf_Text_CL = "Deaktivier zuerst den Homespot und aktivier dann den Bridge-Mode.";
    private static String bridgeMode_Acc_Homespot_notf_Title_CL = "Wichtig für Dich";
    private static String bridgeMode_Acc_Homespot_Activate_Title_CL = "Wichtig für Dich";
    private static String bridgeMode_Acc_NotReturned_notf_Title_CL = "Bridge-Mode nicht möglich";
    private static String bridgeMode_Acc_NotReturned_notf_Text_CL = "Für Deinen Router brauchst Du den Bridge-Mode nicht.";

    //phoneline notification CL
    private static String phoneline_Section_Header_CL = "Rufnummern und Hauptnummer zuweisen";
    private static String phoneline_Notification_CL = "Du hast an Deinem Router zwei Leitungen. Die kannst Du parallel nutzen. Jeder Leitung kannst Du bis zu 3 Rufnummern und eine Hauptnummer zuweisen.";
    private static String phoneline_Notification_text_CL = "Bald kannst Du hier Deinen Leitungen bis zu 3 Rufnummern und eine Hauptnummer zuweisen.";

    //phone book settings CL
    private static String phoneSetting_Header_CL = "Telefonbuch-Eintrag";
    private static String phoneSetting_Footer_CL = "So stehst Du im Telefonbuch";
    private static String phoneSettingNotificationTitle_CL = "Gut zu wissen";
    private static String phoneSettingNotificationDescription_CL = "Bald kannst Du hier Deinen Telefonbuch-Eintrag sehen und ändern.";
    //SIP credentials CLs
    private static String SIPNotificationTitle_CL = "Wenn Du Deinen eigenen Router nutzen möchtest, brauchst Du SIP-Zugangsdaten. Pro Rufnummer gibt es einen eigenen SIP-Benutzernamen.";
    private static String SIPPhoneNumbers_CL = "Rufnummer";
    private static String SIPUsernames_CL = "SIP-Benutzername";
    private static String SIPRegistrar_CL = "SIP-Registrar";
    private static String SIPProxy_CL = "SIP-Proxy";
    private static String SIPCredentialsErrorTitle_CL = "Ups, da ist was schiefgelaufen";
    private static String SIPCredentialsErrorDescription_CL = "Deine SIP-Zugangsdaten können gerade nicht angezeigt werden. Versuch es bitte später nochmal.";
    //phoneLine Setting CLs
    private static String mainNumberSectionHeader_CL = "Rufnummern und Hauptnummer zuweisen";
    private static String mainNumberSectionFooter_CL = "Du hast an Deinem Router zwei Leitungen. Die kannst Du parallel nutzen. Jeder Leitung kannst Du bis zu 3 Rufnummern und eine Hauptnummer zuweisen.";

    // CLs For WFDT-7619 | View phone book settings for KD users
    private static String registeredStatusPhoneNumber_Cl = "Eingetragen";
    private static String phoneNumberEditButton_Cl = "Bearbeiten";
    private static String phoneNumberDeleteButton_Cl = "Löschen";
    private static String notRegisteredStatusPhoneNumber_Cl = "Nicht eingetragen";
    private static String phoneNumberAddButton_CL = "Rufnummer eintragen";
    private static String lockedStatusPhoneNumber_Cl = "In Bearbeitung";
    private static String showMoreButton_Cl = "Mehr anzeigen";
    private static String showLessButton_Cl = "Weniger anzeigen";

    // CLs For WFDT-8249
    private static String homespotActiveButton_CL = "Homespot aktivieren";
    private static String activeHomespotMessageInformation_CL1 = "Aktivier Deinen Homespot und nutz auch unterwegs das WLAN von bis zu 4 Millionen WLAN-Hotspots von Vodafone.";
    private static String activeHomespotMessageInformation_CL2 = "Wichtig: Dein privates WLAN-Netz bleibt sicher und schnell. Du bist rechtlich nicht verantwortlich für das, was andere über Deinen Homespot machen.";
    private static String homespotDeActiveButton_CL = "Homespot deaktivieren";
    private static String deAtiveHomespotMessageInformation_CL1 = "Wenn Du Deinen Homespot deaktivierst, kannst Du die WLAN-Hotspots unterwegs nicht mehr nutzen.";
    private static String deAtiveHomespotMessageInformation_CL2 = "Wichtig: Dein privates WLAN-Netz bleibt sicher und schnell. Du bist rechtlich nicht verantwortlich für das, was andere über Deinen Homespot machen.";
    private static String homespotActivationMessageTitle_CL = "Wichtig für Dich";
    private static String homespotActivationMessageDescription_CL1 = "Der Statuswechsel Deines Homespots";
    private static String homespotActivationMessageDescription_CL11 = "läuft gerade. Das dauert normalerweise nur wenige Minuten. In Einzelfällen kann es bis zu 24 Stunden dauern.";
    private static String homespotActivationMessageDescription_CL2 = "Dein Router startet danach automatisch neu. Falls nicht, schalte ihn bitte einmal aus und wieder ein.";
    private static String homespotDeActivationMessageTitle_CL = "Wichtig für Dich";
    private static String homespotDeActivationMessageDescription_CL1 = "Der Statuswechsel Deines Homespots";
    private static String homespotDeActivationMessageDescription_CL11 = "läuft gerade. Das dauert normalerweise nur wenige Minuten. In Einzelfällen kann es bis zu 7 Tage dauern.";
    private static String homespotDeActivationMessageDescription_CL2 = "Dein Router startet danach automatisch neu. Falls nicht, schalte ihn bitte einmal aus und wieder ein.";
    private static String homespotNonEligibleMessageTitle_CL = "So geht's weiter";
    private static String homespotNonEligibleMessageDescription_CL1 = "Im Moment kannst Du den Homespot noch nicht nutzen. Es kann sein, dass Du noch eine WLAN-Option buchen musst. Oder ist Dein Router vielleicht schon etwas älter? Ruf uns einfach an. Dann helfen wir Dir weiter. Du erreichst uns unter";
    private static String homespotNonEligibleMessageDescription_CL2 = "0800 172 12 12.";
    private static String homespotBridgeModeMessageTitle_CL = "So geht’s weiter";
    private static String homespotBrigeModeMessageDescription_CL = "Deaktivier zuerst den Bridge-Mode und aktivier dann den Homespot.";
    private static String homespotErrorMessageTitle_CL = "Ups, da ist was schiefgelaufen";
    private static String homespotErrorMessageDescription_CL1 = "Wir konnten Deine Homespot-Einstellung leider nicht bearbeiten. Ruf uns bitte an. Dann helfen wir Dir weiter. Du erreichst uns unter";
    private static String homespotErrorMessageDescription_CL2 = "0800 172 12 12.";

    //Locators
    private By internetAndDevices_SO = By.xpath("//div[@automation-id='inernetPhoneDevices_so']");
    private static final By INTERNET_DEVICES_SO_HEADER = By.xpath("//div[@automation-id='inernetPhoneDevices_so']//h3");
    private static final By INTERNET_DEVICES_SO_DESCRIPTION = By.xpath("(//*[@class='sb-block-footer'])[1]");
    private static final By INTERNET_DEVICE_NAME_SO_DYNAMIC_ICON = By.xpath("(//*[@class='display-block'])[1]");
    private static final By INTERNET_DEVICE_TYPE_SO_DYNAMIC_ICON = By.xpath("(//*[@class='display-block'])[2]");
    private static final By INTERNET_DEVICE_SO_STATIC_ICON = By.xpath("(//div[@class='sb-block-content'])[1]");
    private static final By INTERNET_DEVICES_ACCORDION = By.xpath("//li[@automation-id='inernetPhoneDevices_acc']");
    private static final By INTERNET_DEVICES_ACC_TITLE = By.xpath("//li[@automation-id='inernetPhoneDevices_acc']//h4");
    private static final By INTERNET_DEVICES_ACC_DESCRIPTION = By.xpath("//li[@automation-id='inernetPhoneDevices_acc']//h5");
    //First device Locators
    private static final By GERATE_NAME_LABEL_1 = By.xpath("//div[@automation-id='internetPhoneDevices_lv']//h4[contains(text(),'Gerätename')]");
    private static final By GERATE_NAME_TEXT_1 = By.xpath("(//*[@class='font-14'])[1]");
    private static final By MAC_ADRESSE_LABEL_1 = By.xpath("(//*[@class='mb-0 font-14'])[2]");
    private static final By MAC_ADRESSE_TEXT_1 = By.xpath("(//*[@class='font-14'])[2]");
    private static final By OWNERSHIP_LABEL_1 = By.xpath("(//*[@class='mb-0 font-14'])[3]");
    private static final By OWNERSHIP_TEXT_1 = By.xpath("(//*[@class='font-14'])[3]");

    //User Guide buttons Locators
    private static final By UserGuideBtnProduct1 = By.xpath("(//div[@class='fm-buttons'])[1]/a");
    private static final By UserGuideBtnProduct2 = By.xpath("(//div[@class='fm-buttons'])[2]/a");
    //Error Message Locators
    public static final By error_MSG_TITLE = By.xpath("//div[@automation-id='undefined_nt']//h4");
    public static final By error_MSG_DESC = By.xpath("//div[@automation-id='undefined_nt']//p");
    private static final By telefoneinstellungen_SO = By.xpath("//div[@automation-id='telefoneinstellungen_so']//div//h3");
    private static final By titleField_textbox = By.xpath("//input[@automation-id='title_et']");
    private static final By companyField_textbox = By.xpath("//input[@automation-id='firstName_et']");
    private static final By contactPersonField_textbox = By.xpath("//input[@automation-id='lastName_et']");
    private static final By firstCardPhoneBook_ChangeBtn = By.xpath("//button[@automation-id='edit_btn']");
    private static final By telefoneinstellungen_SO_Hidden = By.xpath("//div[@automation-id='telefoneinstellungen_so']//ancestor::smart-object-wrapper");
    private static final By pageTitle = By.xpath("//div[@automation-id=\"pageHeader_tv\"]//h1");
    private static final By telefoneinstellungenSO_Title = By.xpath("//div[@automation-id='telefoneinstellungen_so']//div//h3");
    private static final By telefoneinstellungenSO_Text = By.xpath("//div[@class='sb-block-footer' and contains (text(),'Rufnummern')]");
    private static final By telefoneinstellungenAcc_Title = By.xpath("(//li[@automation-id='telefoneinstellungen_acc']//h4)[1]");
    private static final By telefoneinstellungenAcc_Text = By.xpath("//li[@automation-id='telefoneinstellungen_acc']//h5");
    private static final By anonymousCallsSettings_Card = By.xpath("//div[@automation-id='Anrufsperre einrichten_tv']");
    private static final By forwardCallsSettings_Card = By.xpath("//div[@automation-id='Anonyme Anrufe blockieren_tv']");
    private static final By blockCallsSettings_Card = By.xpath("//div[@automation-id='Weiterleitung einrichten_tv']");
    private static final By visibilityCallsSettings_Card = By.xpath("//div[@automation-id='Rufnummerunterdrückung einrichten_tv']");
    private static final By anonymousCallsSettingsCard_Title = By.xpath("//div[@automation-id='Anonyme Anrufe blockieren_tv']//h4");
    private static final By anonymousCallsSettingsCard_Text = By.xpath("//div[@automation-id='Anonyme Anrufe blockieren_tv']//p");
    private static final By anonymousCallsSettingsCard_Btn = By.xpath("//div[@automation-id='Anonyme Anrufe blockieren_tv']//button");
    private static final By visibilityCallsSettingsAcc_Title = By.xpath("//div[@automation-id='Rufnummerunterdrückung einrichten_tv']//h4");
    private static final By visibilityCallsSettingsAcc_Text = By.xpath("//div[@automation-id='Rufnummerunterdrückung einrichten_tv']//p");
    private static final By visibilityCallsSettingsAcc_Btn = By.xpath("//div[@automation-id='Rufnummerunterdrückung einrichten_tv']//button");

    private static final By redirectedPageTitle = By.xpath("//div[@class='title row']");
    private static final By callForwardCard_Title = By.xpath("//div[@automation-id='Weiterleitung einrichten_tv']//h4");
    private static final By callForwardCard_Body = By.xpath("//div[@automation-id='Weiterleitung einrichten_tv']//p");
    private static final By callForwardCard_Btn = By.xpath("//div[@automation-id='Weiterleitung einrichten_tv']//button");
    private static final By OutgoingCallBlocking_Title = By.xpath("//div[@automation-id='Anrufsperre einrichten_tv']//h4");
    private static final By OutgoingCallBlocking_Body = By.xpath("//div[@automation-id='Anrufsperre einrichten_tv']//p");
    private static final By OutgoingCallBlocking_Btn = By.xpath("//div[@automation-id='Anrufsperre einrichten_tv']//button");

    //Homespot SO & Accordion Locators
    private static final By homespotSO_Title = By.xpath("//div[@automation-id=\"cableHomeSpot_so\"]//div//h3");
    private static final By homespotSO_Text = By.xpath("//div[@automation-id=\"cableHomeSpot_so\"]//div[@class='sb-block-footer']");
    private static final By homespotAccordion_Title = By.xpath("//li[@automation-id='homespot-service_acc']//a//h4");
    private static final By homespotAccordion_Text = By.xpath("//li[@automation-id='homespot-service_acc']/a/h5");
    private static final By homespotNotification_Title = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static final By homespotNotification_Text = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static final By homespotErrorMsgTitle = By.xpath("//div[@id='cableHomeSpotId']//h4");
    private static final By homespotErrorMsgDesc = By.xpath("//div[@id='cableHomeSpotId']//p");
    private static final By homespot_SO_Hidden = By.xpath("//div[@automation-id='cableHomeSpot_so']//ancestor::smart-object-wrapper");

    // SIP SO & Accordion Locators

    private static final By SIPSO_Title = By.xpath("//div[@automation-id='cableSipCredentials_so']//h3");
    private static final By SIPSO_Text = By.xpath("(//div[@automation-id='cableSipCredentials_so']//div)[5]");
    private static final By SIPAccordion_Title = By.xpath("(//li[@automation-id='sip-daten_acc']//h4)[1]");
    private static final By SIPAccordion_Text = By.xpath("(//li[@automation-id='sip-daten_acc']//h5)[1]");
    private static final By SIPNotification_Title = By.xpath("//div[@id=\"sipCredentialsId\"]//h4");
    private static final By SIPNotification_Text = By.xpath("//div[@id=\"sipCredentialsId\"]//p");
    private static final By SIPGeneralError_Title = By.xpath("//div[@id=\"sipCredentialsId\"]//h4");
    private static final By SIPGeneralError_Text = By.xpath("//div[@id=\"sipCredentialsId\"]//p");

    private static final By SIP_SO_Hidden = By.xpath("//div[@automation-id='cableSipCredentials_so']//ancestor::smart-object-wrapper");


    //Bridge-Mode SO & Accordion locators
    private static final By bridgeMode_SO = By.xpath("//div[@automation-id='bridgeMode_so']");
    private static final By bridgeMode_SO_Wrapper = By.xpath("//div[@automation-id='bridgeMode_so']//ancestor::smart-object-wrapper");
    private static final By bridgeMode_Acc = By.xpath("//accordion[@automation-id='bridgeMode_acc']");
    private static final By bridgeMode_SO_Header = By.xpath("//div[@automation-id='bridgeMode_so']//h3");
    private static final By bridgeMode_SO_Footer = By.xpath("//div[@class='sb-block-footer' and contains (text(),'Router nutzen möchtest')]");
    private static final By bridgeMode_Acc_Header = By.xpath("(//li[@automation-id='bridgeMode_acc']//h4)[1]");
    private static final By bridgeMode_Acc_Footer = By.xpath("(//li[@automation-id='bridgeMode_acc']//h5)[1]");
    private static final By bridgeMode_Acc_Deactivation_Text = By.xpath("//accordion[@automation-id='bridgeMode_acc']//p");
    private static final By bridgeMode_Acc_Deactivation_Btn = By.xpath("//button[@automation-id='deActivate_btn']");
    private static final By bridgeMode_Acc_Activation_Text = By.xpath("//p[@automation-id='activet_description_tv']");
    private static final By bridgeMode_Acc_Activation_Btn = By.xpath("//button[@automation-id='activate_btn']");
    private static final By bridgeMode_Acc_HomeboxCase_notf_Title = By.xpath("//div[@automation-id='homeBoxNotification_nt']//h4");
    private static final By bridgeMode_Acc_HomeboxCase_notf_Text = By.xpath("//div[@automation-id='homeBoxNotification_nt']//p");
    private static final By bridgeMode_Acc_Homespot_notf_Text = By.xpath("//div[@automation-id='activeHomeSpotNotification_nt']//p");
    private static final By bridgeMode_Acc_Homespot_Activate_Text = By.xpath("//div[@automation-id='activeHomeSpotNotification_nt']//p");
    private static final By bridgeMode_Acc_Homespot_notf_Title = By.xpath("//div[@automation-id='activeHomeSpotNotification_nt']//h4");
    private static final By bridgeMode_Acc_Homespot_Activate_Title = By.xpath("//div[@automation-id='activeHomeSpotNotification_nt']//h4");
    private static final By bridgeMode_Acc_NotReturned_notf_Title = By.xpath("//div[@automation-id='noBridgeNotification_nt']//h4");
    private static final By bridgeMode_Acc_NotReturned_notf_Text = By.xpath("//div[@automation-id='noBridgeNotification_nt']//p");
    private static final By bridgeMode_Acc_Expanded = By.xpath("//div[@class='ac-body']//bridge-mode-accordion");

    //phoneline notification locator
    private static final By phoneline_Section_Header = By.xpath("//div[@automation-id='undefined_tv']//h4");
    private static final By phoneline_Notification_Title = By.xpath("//div[@automation-id='undefined_tv']//p");

    // phone book settings SO & Accordion Locators
    private static final By phoneSetting_SO = By.xpath("//div[@automation-id='phoneBookSettings_so']");
    private static final By phoneSetting_SO_Footer = By.xpath("//div[@automation-id='phoneBookSettings_so']//div[@class='sb-block-footer']");
    private static final By phoneSetting_SO_Header = By.xpath("//div[@automation-id='phoneBookSettings_so']//div//h3");
    private static final By phoneSettingNotificationTitle = By.xpath("//div[@automation-id='phone_book_nt']//h4");
    private static final By phoneSettingNotificationDescription = By.xpath("//div[@automation-id='phone_book_nt']//p");
    private static final By phoneSettingACC_notDisplayed = By.xpath("//li[@automation-id='phoneBook_acc']");
    private static final By phoneSettingSO_notDisplayed = By.xpath("//div[@automation-id='phoneBookSettings_so']//ancestor::smart-object-wrapper");
    private static final By phoneSetting_accFooter = By.xpath("//li[@automation-id='phoneBook_acc']//a//h5");
    private static final By phoneSetting_accHeader = By.xpath("//li[@automation-id='phoneBook_acc']//a//h4");
    private static final By phoneSettingGeneralErrorTitle = By.xpath("(//h4[@class='flexDiv'])[3]");
    private static final By phoneSettingGeneralErrorDescription = By.xpath("(//p[@class='notification-text mb-10 mt-10'])[3]");

    // SIP credentials Locators
    private static final By SIPSo_notDisplayed = By.xpath("//div[@automation-id='cableSipCredentials_so']//ancestor::smart-object-wrapper");
    private static final By SIPAcc_notDisplayed = By.xpath("//li[@automation-id='sip-daten_acc']");
    private static final By SIPPhoneNumbers = By.xpath("(//div[@automation-id='phoneDetails_lv']//h5)[1]");
    private static final By SIPUsernames = By.xpath("(//div[@automation-id='phoneDetails_lv']//h5)[2]");
    private static final By SIPRegistrar = By.xpath("//div[@automation-id='sipRegistrar_tv']//h5");
    private static final By SIPProxy = By.xpath("//div[@automation-id='sipProxy_tv']//h5");
    private static final By SIPCredentialsErrorTitle = By.xpath("(//div[@automation-id='successMsg_tv']//h4)[1]");
    private static final By SIPCredentialsErrorDescription = By.xpath("(//div[@automation-id='successMsg_tv']//p)[1]");

    //Locators for WFDT-7610 || View & change phone line configuration for KD users
    private static final By phoneLineSetting_ACC = By.xpath("//li[@automation-id='telefoneinstellungen_acc']");
    private static final By phoneLineEditButton = By.xpath("//div[@automation-id='undefined_tv']//button");
    private static final By mainNumberSectionHeader = By.xpath("//div[@automation-id='undefined_tv']//h4");
    private static final By mainNumberSectionFooter = By.xpath("//div[@automation-id='undefined_tv']//p");
    private static final By mainNumberSection = By.xpath("//div[@automation-id='undefined_tv']");


    // Locators For WFDT-7619 | View phone book settings for KD users
    private static final By registeredStatusPhoneNumber = By.xpath("(//dd[@automation-id='status_tv'])[1]");
    private static final By phoneNumberEditButton = By.xpath("(//button[@automation-id='edit_btn'])[1]");
    private static final By phoneNumberDeleteButton = By.xpath("(//button[@automation-id='delete_btn'])[1]");
    private static final By notRegisteredStatusPhoneNumber = By.xpath("(//dd[@automation-id='status_tv'])[1]");
    private static final By phoneNumberAddButton = By.xpath("(//button[@automation-id='add_btn'])[1]");
    private static final By lockedStatusPhoneNumber = By.xpath("(//dd[@automation-id='status_tv'])[2]");
    private static final By expandableButton = By.xpath("//div[@automation-id='phoneBookControlsContainer_tv']");
    private static final By viewPhoneBookErrorTittle = By.xpath("//div[@automation-id='phoneBook_error_nt']//h4");
    private static final By viewPhoneBookErrorDescription = By.xpath("//div[@automation-id='phoneBook_error_nt']//p");
    private static final By thirdCardPhonebook_AddBtn = By.xpath("//button[@automation-id='add_btn']");

    // Locators For WFDT-8546 | Delete phone book entry for KD users
    private static final By deletePhoneBook_button = By.xpath("//button[@automation-id='delete_btn']");

    // Locators For WFDT-8249 | View WIFI (homespot) settings for KD users
    private By homespotAccordion = By.xpath("//li[@automation-id='homespot-service_acc']");
    private By homespotActive_button = By.xpath("//button[@automation-id='activate_homespot_submit_btn']");
    private By homespotDeActive_button = By.xpath("//button[@automation-id='deActivate_homespot_submit_btn']");
    private By activeHomespotMessageInformation_label = By.xpath("//p[@automation-id='activate_homespot_tv']");
    private By deAtiveHomespotMessageInformation_label = By.xpath("//p[@automation-id='deActivate_homespot_tv']");
    private By homespotMessageTitle_label = By.xpath("//div[@automation-id='cable_homespot_info_nt']//h4");
    private By homespotMessageDescription_label = By.xpath("//div[@automation-id='cable_homespot_info_nt']//p");
    private By homespotErrorMessageTitle_label = By.xpath("//div[@automation-id='cable_homespot_order_error_nt']//h4");
    private By homespotErrorMessageDescription_label = By.xpath("//div[@automation-id='cable_homespot_order_error_nt']//p");


    //constructor
    public KIPSettings(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate that Telefoneinstellungen_SO is existed")
    public KIPSettings validatePhoneSettinsSOExisted() {
        driver.verifyThat().element(telefoneinstellungen_SO).exists().perform();
        return this;
    }

    @Step("Deeplink to the Anonymous call settings page")
    public KIPSettings deeplinkToAnonymousCallSettingsPage() {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/telefoneinstellungen/anonyme-anrufer-blockieren");
        driver.verifyThat().element(telefoneinstellungen_SO).exists().perform();
        return this;
    }

    @Step("Deeplink to the Visibility call settings page")
    public KIPSettings deeplinkToVisibilityCallSettingsPage() {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/telefoneinstellungen/rufnummerunterdruckung");
        driver.verifyThat().element(telefoneinstellungen_SO).exists().perform();
        return this;
    }

    @Step("validate that deeplinking is disabled and user has been redirected to KIP settings page")
    public KIPSettings validateDeeplinikingIsDisabled() {
        driver.verifyThat().element(telefoneinstellungen_SO).exists().perform();
        driver.verifyThat().element(telefoneinstellungenSO_Title).exists().perform();
        driver.verifyThat().element(telefoneinstellungenAcc_Title).exists().perform();
        driver.verifyThat().element(pageTitle).exists().perform();
        return this;
    }

    @Step("Validate that Telefoneinstellungen smart object's content ")
    public KIPSettings validateTelephoneSettingsSO() {
        driver.verifyThat().element(telefoneinstellungenSO_Title)
                .textTrimmed().isEqualTo(telefoneinstellungenSO_Title_CL)
                .withCustomReportMessage("Validate SmartObject's Title")
                .perform();
        driver.verifyThat().element(telefoneinstellungenSO_Text)
                .textTrimmed().isEqualTo(telefoneinstellungenSO_Text_CL)
                .withCustomReportMessage("Validate SmartObject's text")
                .perform();
        return this;
    }

    @Step("Validate that Telefoneinstellungen accordion's content ")
    public KIPSettings validateTelephoneSettingsAcc() {
        driver.verifyThat().element(telefoneinstellungenAcc_Title)
                .textTrimmed().isEqualTo(telefoneinstellungenSO_Title_CL)
                .withCustomReportMessage("Validate acc's title")
                .perform();
        driver.verifyThat().element(telefoneinstellungenAcc_Text)
                .textTrimmed().isEqualTo(telefoneinstellungenAccordion_Text_CL)
                .withCustomReportMessage("Validate acc's text ")
                .perform();
        driver.verifyThat().element(anonymousCallsSettings_Card).exists().perform();
        driver.verifyThat().element(forwardCallsSettings_Card).exists().perform();
        driver.verifyThat().element(blockCallsSettings_Card).exists().perform();
        driver.verifyThat().element(visibilityCallsSettings_Card).exists().perform();
        return this;
    }

    @Step("Click on Change Button of Anonymous Call settings Card")
    public KIPSettings clickOnAnonymousCardChangeBtn() {
        driver.element().click(anonymousCallsSettingsCard_Btn);
        return this;
    }

    @Step("Click on Change Button of visibility Call settings Card")
    public KIPSettings clickOnVisibilityCardChangeBtn() {
        driver.element().click(visibilityCallsSettingsAcc_Btn);
        return this;
    }

    @Step("Expand Telefoneinstellungen Accordion")
    public KIPSettings clickOnTelephoneSettingsAcc() {
        driver.element().click(telefoneinstellungenAcc_Title);
        return this;
    }

    @Step(" validate Anonymous Calls Settings Card ")
    public KIPSettings validateAnonymousCallsSettingsCard() {
        driver.verifyThat().element(anonymousCallsSettingsCard_Title)
                .textTrimmed().isEqualTo(anonymousCallsSettingsCard_Title_CL)
                .withCustomReportMessage("Validate SmartObject's title")
                .perform();
        driver.verifyThat().element(anonymousCallsSettingsCard_Text)
                .textTrimmed().isEqualTo(anonymousCallsSettingsCard_Text_CL)
                .withCustomReportMessage("Validate SmartObject's text")
                .perform();
        driver.verifyThat().element(anonymousCallsSettingsCard_Btn)
                .textTrimmed().isEqualTo(anonymousCallsSettingsCard_Btn_CL)
                .withCustomReportMessage("Validate SmartObject button's text")
                .perform();
        driver.verifyThat().element(anonymousCallsSettingsCard_Btn).isEnabled().perform();
        return this;
    }

    public KIPSettings openInternetDevicesAccordion() {
        driver.element().click(INTERNET_DEVICES_ACCORDION);
        return this;
    }
    public KIPSettings clickOnInternetDevicesSmartObject() {
        driver.element().click(internetAndDevices_SO);
        return this;
    }

    public KIPSettings clickOnUserGuideBtnProduct1() {
        driver.element().isElementClickable(UserGuideBtnProduct1);
        clickOnPopupElement(driver,UserGuideBtnProduct1);
        return this;
    }

    public KIPSettings clickOnUserGuideBtnProduct2() {
        driver.element().click(UserGuideBtnProduct2);
        return this;
    }

    public KIPSettings validateDynamicDeviceNameSO() {
        //Verify Dynamic SO Device Name
        driver.verifyThat().element(INTERNET_DEVICE_NAME_SO_DYNAMIC_ICON)
                .exists().withCustomReportMessage("Validate Accordion button's text")
                .perform();
        return this;
    }

    public KIPSettings validateStaticDeviceNameSO() {
        //Verify Static SO icon
        driver.verifyThat().element(INTERNET_DEVICE_SO_STATIC_ICON)
                .exists().perform();
        return this;
    }

    public KIPSettings validateKIPSOandAccordion() {
        //Verify SO header
        driver.verifyThat().element(INTERNET_DEVICES_SO_HEADER)
                .textTrimmed().isEqualTo(Internet_Devices_SO_Header)
                .withCustomReportMessage("Check that Header exists for Geräte & Einstellungen SmartObject")
                .perform();

        //Verify SO description
        driver.verifyThat().element(INTERNET_DEVICES_SO_DESCRIPTION)
                .textTrimmed().isEqualTo(Internet_Devices_SO_Description)
                .withCustomReportMessage("Check that Footer exists for Geräte & Einstellungen SmartObject ")
                .perform();
        driver.verifyThat().element(INTERNET_DEVICE_SO_STATIC_ICON)
                .exists().withCustomReportMessage("Validate Accordion button's text")
                .perform();
        //Verify Accordion header
        driver.verifyThat().element(INTERNET_DEVICES_ACC_TITLE)
                .textTrimmed().isEqualTo(KIPSettings.Internet_Devices_Accordion_Title)
                .withCustomReportMessage("Check that Header exists for Geräte Accordion")
                .perform();
        //Verify Accordion footer
        driver.verifyThat().element(INTERNET_DEVICES_ACC_DESCRIPTION)
                .textTrimmed().isEqualTo(KIPSettings.Internet_Devices_Accordion_Description)
                .withCustomReportMessage("Check that Footer exists for Geräte Accordion")
                .perform();
        return this;
    }

    public KIPSettings ValidateKIPDetailsInCaseAllDetailsAvailable() {
        //Verify Gerate accordion details
        //Verify Gerate name label
        driver.verifyThat().element(GERATE_NAME_LABEL_1)
                .textTrimmed().contains(Gerate_Name_Label)
                .withCustomReportMessage("Check Gerate name label")
                .perform();
        //Verify Gerate name text
        driver.verifyThat().element(GERATE_NAME_TEXT_1)
                .exists()
                .withCustomReportMessage("Check Gerate name text")
                .perform();
        //Verify MAC-Adresse label
        driver.verifyThat().element(MAC_ADRESSE_LABEL_1)
                .textTrimmed().isEqualTo(MAC_Adresse_Label)
                .withCustomReportMessage("Check MAC-Adresse label")
                .perform();
        //Verify MAC-Adresse text
        driver.verifyThat().element(MAC_ADRESSE_TEXT_1)
                .exists()
                .withCustomReportMessage("Check MAC-Adresse text")
                .perform();
        //Verify Ownership label
        driver.verifyThat().element(OWNERSHIP_LABEL_1)
                .textTrimmed().isEqualTo(Ownership_Label)
                .withCustomReportMessage("Check Ownership label")
                .perform();
        //Verify Ownership text
        driver.verifyThat().element(OWNERSHIP_TEXT_1)
                .exists()
                .withCustomReportMessage("Check Ownership text")
                .perform();
        return this;
    }

    public KIPSettings ValidateKIPDetailsInCaseSomeDetailsNotAvailable() {
        //Verify Gerate accordion details
        //Verify first device
        //Verify Gerate name label
        driver.verifyThat().element(GERATE_NAME_LABEL_1)
                .textTrimmed().isEqualTo(Gerate_Name_Label)
                .withCustomReportMessage("Check Gerate name label")
                .perform();
        //Verify Gerate name text
        driver.verifyThat().element(GERATE_NAME_TEXT_1)
                .exists()
                .withCustomReportMessage("Check Gerate name text")
                .perform();
        //Verify MAC-Adresse label
        driver.verifyThat().element(MAC_ADRESSE_LABEL_1)
                .textTrimmed().isEqualTo(MAC_Adresse_Label)
                .withCustomReportMessage("Check MAC-Adresse label")
                .perform();
        //Verify MAC-Adresse text
        driver.verifyThat().element(MAC_ADRESSE_TEXT_1)
                .textTrimmed().isEqualTo(Not_Returned_Info)
                .withCustomReportMessage("Check MAC-Adresse text")
                .perform();
        //Verify Ownership label
        driver.verifyThat().element(OWNERSHIP_LABEL_1)
                .textTrimmed().isEqualTo(Ownership_Label)
                .withCustomReportMessage("Check Ownership label")
                .perform();
        //Verify Ownership text
        driver.verifyThat().element(OWNERSHIP_TEXT_1)
                .exists()
                .withCustomReportMessage("Check Ownership text")
                .perform();
        return this;
    }

    public KIPSettings ValidateKIPDetailsInCaseAllDetailsNotAvailable() {
        //Verify Gerate accordion details
        //Verify first device
        //Verify Gerate name label
        driver.verifyThat().element(GERATE_NAME_LABEL_1)
                .textTrimmed().isEqualTo(Gerate_Name_Label)
                .withCustomReportMessage("Check  Gerate name label")
                .perform();
        //Verify Gerate name text
        driver.verifyThat().element(GERATE_NAME_TEXT_1)
                .textTrimmed().isEqualTo(Not_Returned_Info)
                .withCustomReportMessage("Check  Gerate name text")
                .perform();
        //Verify MAC-Adresse label
        driver.verifyThat().element(MAC_ADRESSE_LABEL_1)
                .textTrimmed().isEqualTo(MAC_Adresse_Label)
                .withCustomReportMessage("Check  MAC-Adresse label")
                .perform();
        //Verify MAC-Adresse text
        driver.verifyThat().element(MAC_ADRESSE_TEXT_1)
                .textTrimmed().isEqualTo(Not_Returned_Info)
                .withCustomReportMessage("Check  MAC-Adresse text")
                .perform();
        //Verify Ownership label
        driver.verifyThat().element(OWNERSHIP_LABEL_1)
                .textTrimmed().isEqualTo(Ownership_Label)
                .withCustomReportMessage("Check  Ownership label")
                .perform();
        //Verify Ownership text
        driver.verifyThat().element(OWNERSHIP_TEXT_1)
                .textTrimmed().isEqualTo(Not_Returned_Info)
                .withCustomReportMessage("Check Ownership text")
                .perform();
        return this;
    }

    public KIPSettings ValidateKIPDetailsInCaseServiceFailure() {
        //Verify Gerate accordion details
        //Verify General Error Message
        driver.verifyThat().element(error_MSG_TITLE)
                .textTrimmed().isEqualTo(error_Message_Title)
                .withCustomReportMessage("Check Error Message Title")
                .perform();
        driver.verifyThat().element(error_MSG_DESC)
                .textTrimmed().isEqualTo(error_Message_Description)
                .withCustomReportMessage("Check Error Message Description")
                .perform();
        return this;
    }

    public KIPSettings verifyRedirectionPage() {
//        ArrayList<String> tabs = new ArrayList<String>(driver.getDriver().getWindowHandles());
//        driver.browser().switchToWindow(tabs.get(1));
        driver.element().isElementDisplayed(redirectedPageTitle);
        driver.verifyThat().element(redirectedPageTitle)
                .textTrimmed().isEqualTo(redirectedPageTitleCL)
                .withCustomReportMessage("Validate the redirected page")
                .perform();
        return this;
    }

    public KIPSettings validateVisibilityCallsSettingsAcc() {
        driver.verifyThat().element(visibilityCallsSettingsAcc_Title)
                .textTrimmed().isEqualTo(visibiltyCallsSettingsCard_Title_CL)
                .withCustomReportMessage("Validate Accordion's Title")
                .perform();
        driver.verifyThat().element(visibilityCallsSettingsAcc_Text)
                .textTrimmed().isEqualTo(visibiltyCallsSettingsCard_Text_CL)
                .withCustomReportMessage("Validate Accordion's text")
                .perform();
        driver.verifyThat().element(visibilityCallsSettingsAcc_Btn)
                .textTrimmed().isEqualTo(visibiltyCallsSettingsCard_Btn_CL)
                .withCustomReportMessage("Validate Accordion button's text")
                .perform();
        driver.verifyThat().element(visibilityCallsSettingsAcc_Btn).isEnabled().perform();
        return this;
    }

    public KIPSettings validateCallForwardCard() {
        driver.verifyThat().element(callForwardCard_Title)
                .textTrimmed().isEqualTo(callForwardCard_Title_CL)
                .withCustomReportMessage("Validate call Forward Title")
                .perform();
        driver.verifyThat().element(callForwardCard_Body)
                .textTrimmed().isEqualTo(callForwardCard_Body_CL)
                .withCustomReportMessage("Validate call Forward Body ")
                .perform();
        driver.verifyThat().element(callForwardCard_Btn)
                .textTrimmed().isEqualTo(callForwardCard_Btn_CL)
                .withCustomReportMessage("Validate call Forward button")
                .perform();
        driver.verifyThat().element(callForwardCard_Body)
                .textTrimmed().isEqualTo(callForwardCard_Body_CL)
                .withCustomReportMessage("Validate call Forward Body ")
                .perform();
        driver.verifyThat().element(callForwardCard_Btn).isEnabled();
        return this;
    }

    public KIPSettings clickOnViewAndChangeCallForwardCard() {
        driver.element().click(callForwardCard_Btn);
        return this;
    }

    public KIPSettings validateCallForwardSODoesNotExist() {
        driver.verifyThat().element(telefoneinstellungen_SO_Hidden).isHidden().perform();
        return this;
    }

    public KIPSettings validateCallForwardAccordionDoesNotExist() {
        driver.verifyThat().element(telefoneinstellungenAcc_Title)
                .doesNotExist().withCustomReportMessage("Validate the service failure msg's text")
                .perform();
        driver.verifyThat().element(telefoneinstellungenAcc_Text)
                .doesNotExist().withCustomReportMessage("Validate the service failure msg's text")
                .perform();
        return this;
    }

    public KIPSettings validateDeeplinkIsDisabled() {
        // driver.verifyThat().browser().url().isEqualTo(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/meine-produkte/internet-phone/geraete-einstellungen?accordion=telefoneinstellungen/weiterleitung").perform();
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/telefoneinstellungen/weiterleitung");
        driver.verifyThat().element(telefoneinstellungen_SO).exists().perform();
        return this;
    }

    @Step("Validate deeplinking to Adding PhoneBook Settings")
    public KIPSettings validateDeeplinkTOAddPhoneBookIsDisabled() {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/telefonbuchEintrag/telefonbuch-eintrag-aktivieren");
        driver.verifyThat().element(telefoneinstellungen_SO).exists().perform();
        return this;
    }

    public KIPSettings validateHomespotSO() {
        driver.verifyThat().element(homespotSO_Title)
                .textTrimmed().isEqualTo(homespotSO_Title_CL)
                .withCustomReportMessage("Validate SmartObject Title ")
                .perform();
        driver.verifyThat().element(homespotSO_Text)
                .textTrimmed().isEqualTo(homespotSO_Text_CL)
                .withCustomReportMessage("Validate SmartObject Text")
                .perform();
        return this;
    }

    public KIPSettings validateHomespotAccordion() {
        driver.verifyThat().element(homespotAccordion_Title)
                .textTrimmed().isEqualTo(homespotAccordion_Title_CL)
                .withCustomReportMessage("Validate Accordion Title")
                .perform();
        driver.verifyThat().element(homespotAccordion_Text)
                .textTrimmed().isEqualTo(homespotAccordion_Text_CL)
                .withCustomReportMessage("Validate Accordion Text")
                .perform();
        return this;
    }

    public KIPSettings ExpandHomespotAccordion() {
        driver.element().click(homespotAccordion_Title);
        return this;
    }

    public KIPSettings validateHomespotNotification() {
        driver.verifyThat().element(homespotNotification_Title)
                .textTrimmed().isEqualTo(homespotNotification_Title_CL)
                .withCustomReportMessage("Validate Notification Title")
                .perform();
        driver.verifyThat().element(homespotNotification_Text)
                .textTrimmed().isEqualTo(homespotNotification_Text_CL)
                .withCustomReportMessage("Validate Notification Text")
                .perform();
        return this;
    }

    public KIPSettings validateHomespotSODoesNotExist() {
        driver.verifyThat().element(homespot_SO_Hidden).isHidden().perform();
        return this;
    }

    public KIPSettings validateHomespotAccordionDoesNotExist() {
        driver.verifyThat().element(homespotAccordion_Title).doesNotExist().perform();
        driver.verifyThat().element(homespotAccordion_Text).doesNotExist().perform();
        return this;
    }

    public KIPSettings validateHomespotServiceFailure() {
        driver.verifyThat().element(homespotErrorMsgTitle)
                .textTrimmed().isEqualTo(generalError_Title_CL)
                .withCustomReportMessage("Validate on service failure general error title ")
                .perform();
        driver.verifyThat().element(homespotErrorMsgDesc)
                .textTrimmed().isEqualTo(generalError_Text_CL)
                .withCustomReportMessage("Validate on service failure general error description")
                .perform();
        return this;
    }


    public KIPSettings validateSIPSO() {
        driver.verifyThat().element(SIPSO_Title)
                .textTrimmed().isEqualTo(SIPSO_Title_CL)
                .withCustomReportMessage("Validate SmartObject Title ")
                .perform();
        driver.verifyThat().element(SIPSO_Text)
                .textTrimmed().isEqualTo(SIPSO_Text_CL)
                .withCustomReportMessage("Validate SmartObject Text")
                .perform();
        return this;
    }

    public KIPSettings validateSIPAccordion() {
        driver.verifyThat().element(SIPAccordion_Title)
                .textTrimmed().isEqualTo(SIPAccordion_Title_CL)
                .withCustomReportMessage("Validate Accordion Title")
                .perform();
        driver.verifyThat().element(SIPAccordion_Text)
                .textTrimmed().contains(SIPAccordion_Text_CL)
                .withCustomReportMessage("Validate Accordion Text")
                .perform();
        return this;
    }

    @Step("Expand SIP Accordion")
    public KIPSettings ExpandSIPAccordion() {
        driver.element().click(SIPAccordion_Title);
        return this;
    }

    public KIPSettings validateSIPNotification() {
        driver.verifyThat().element(SIPNotification_Title)
                .textTrimmed().isEqualTo(SIPNotification_Title_CL)
                .withCustomReportMessage("Validate SIP Notification Title")
                .perform();
        driver.verifyThat().element(SIPNotification_Text)
                .textTrimmed().isEqualTo(SIPNotification_Text_CL)
                .withCustomReportMessage("Validate Notification Text")
                .perform();
        return this;
    }

    public KIPSettings validateSIPSODoesNotExist() {
        driver.verifyThat().element(SIP_SO_Hidden).isHidden().perform();
        return this;
    }

    public KIPSettings validateSIPAccordionDoesNotExist() {
        driver.verifyThat().element(SIPAccordion_Title).doesNotExist().perform();
        driver.verifyThat().element(SIPAccordion_Text).doesNotExist().perform();
        return this;
    }

    public KIPSettings validateSIPServiceFailure() {
        driver.verifyThat().element(SIPGeneralError_Title)
                .textTrimmed().isEqualTo(SIPgeneralError_Title_CL)
                .withCustomReportMessage("Validate on service failure general error title ")
                .perform();
        driver.verifyThat().element(SIPGeneralError_Text)
                .textTrimmed().isEqualTo(SIPgeneralError_Text_CL)
                .withCustomReportMessage("Validate on service failure general error description")
                .perform();
        return this;
    }

    public KIPSettings ValidateBlockOutGoingCallSection() {
        driver.verifyThat().element(OutgoingCallBlocking_Title)
                .textTrimmed().isEqualTo(OutgoingCallBlocking_Title_CL)
                .withCustomReportMessage("Validate on OutgoingCallBlocking_Title CL ")
                .perform();
        driver.verifyThat().element(OutgoingCallBlocking_Body)
                .textTrimmed().isEqualTo(OutgoingCallBlocking_Body_CL)
                .withCustomReportMessage("Validate on OutgoingCallBlocking_Body CL ")
                .perform();
        driver.verifyThat().element(OutgoingCallBlocking_Btn)
                .textTrimmed().isEqualTo(OutgoingCallBlocking_Btn_CL)
                .withCustomReportMessage("Validate on OutgoingCallBlocking_Btn_CL ")
                .perform();
        return this;
    }

    public KIPSettings clickOnOutGoingCallBlockBtn() {
        driver.element().click(OutgoingCallBlocking_Btn);
        return this;
    }

    //BridgeModeSettings
    @Step("validate Bridge-Mode Smart Object's content ")
    public KIPSettings validateBridgeModeSO() {
        driver.verifyThat().element(bridgeMode_SO).exists().perform();
        driver.verifyThat().element(bridgeMode_SO_Header).textTrimmed().contains(bridgeMode_SO_Header_CL)
                .withCustomReportMessage("Validate SO's Header text ")
                .perform();
        driver.verifyThat().element(bridgeMode_SO_Footer).textTrimmed().contains(bridgeMode_SO_Footer_CL)
                .withCustomReportMessage("Validate SO's Footer text ")
                .perform();
        return this;
    }

    @Step("click On Bridge-Mode Smart Object")
    public KIPSettings clickOnBridgeModeSO() {
        driver.element().click(bridgeMode_SO);
        return this;
    }

    @Step("validate that the accordion has been expanded after clicking on the Smart Object")
    public KIPSettings validateBridgemodeAccHasExpanded() {
        driver.verifyThat().element(bridgeMode_Acc_Expanded).exists()
                .withCustomReportMessage("Accordion Has been Expanded Successfully")
                .perform();
        return this;
    }

    @Step("validate Bridge-Mode Acc In Deactivation Case")
    public KIPSettings validateBridgeModeAccInDeactivationCase() {
        driver.verifyThat().element(bridgeMode_Acc_Header).textTrimmed().contains(bridgeMode_Acc_Header_CL)
                .withCustomReportMessage("Validate acc's Header text ")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Footer).textTrimmed().contains(bridgeMode_Acc_Footer_CL)
                .withCustomReportMessage("Validate acc's Footer text ")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Deactivation_Text).textTrimmed().contains(bridgeMode_Acc_Deactivation_Text_CL)
                .withCustomReportMessage("Validate acc's text in Deactivation bridge mode case")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Deactivation_Btn).textTrimmed().contains(bridgeMode_Acc_Deactivation_Btn_CL)
                .withCustomReportMessage("Validate acc's button text ")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Deactivation_Btn).isEnabled().perform();
        return this;
    }

    @Step("validate Bridge-Mode Acc In activation Case")
    public KIPSettings validateBridgeModeAccInActivationCase() {
        driver.verifyThat().element(bridgeMode_Acc_Activation_Text).textTrimmed().contains(bridgeMode_Acc_Activation_Text1_CL1)
                .withCustomReportMessage("Validate acc's text1 in Deactivation bridge mode case")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Activation_Text).textTrimmed().contains(bridgeMode_Acc_Activation_Text1_CL2)
                .withCustomReportMessage("Validate acc's text2 in Deactivation bridge mode case")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Activation_Btn).textTrimmed().contains(bridgeMode_Acc_Activation_Btn_CL)
                .withCustomReportMessage("Validate acc's button text ")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Activation_Btn).isEnabled().perform();
        return this;
    }

    @Step("validate Bridge-Mode Acc's content in case the user has a Homebox router")
    public KIPSettings validateBridgeModeAccIncaseUserHasAHomebox() {
        driver.verifyThat().element(bridgeMode_Acc_Header)
                .textTrimmed().contains(bridgeMode_Acc_Header_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's header")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Footer)
                .textTrimmed().contains(bridgeMode_Acc_Footer_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's Footer")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_HomeboxCase_notf_Title)
                .textTrimmed().contains(bridgeMode_Acc_HomeboxCase_notf_Title_CL)
                .withCustomReportMessage("Validate notification msg's title incase the user has a homebox router")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_HomeboxCase_notf_Text)
                .textTrimmed().contains(bridgeMode_Acc_HomeboxCase_notf_Text_CL)
                .withCustomReportMessage("Validate notification msg's text incase the user has a homebox router")
                .perform();
        return this;
    }

    @Step("validate Bridge-Mode Acc's content incase Home Spot is Enabled")
    public KIPSettings validateBridgeModeAccInHomeSpotEnabledCase() {
        driver.verifyThat().element(bridgeMode_Acc_Header)
                .textTrimmed().isEqualTo(bridgeMode_Acc_Header_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's header")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Footer)
                .textTrimmed().isEqualTo(bridgeMode_Acc_Footer_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's Footer")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Homespot_notf_Title).textTrimmed()
                .isEqualTo(bridgeMode_Acc_Homespot_notf_Title_CL)
                .withCustomReportMessage("Validate notification msg's title in case the user's homespot is enabled")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Homespot_notf_Text).textTrimmed()
                .isEqualTo(bridgeMode_Acc_Homespot_notf_Text_CL)
                .withCustomReportMessage("Validate notification msg's text in case the user's homespot is enabled")
                .perform();
        return this;
    }

    @Step("validate Bridge-Mode Acc's content incase Home Spot is Enabled")
    public KIPSettings validateBridgeModeAccIfHomeSpotIsEnabled() {
        driver.verifyThat().element(bridgeMode_Acc_Header)
                .textTrimmed().isEqualTo(bridgeMode_Acc_Header_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's header")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Footer)
                .textTrimmed().isEqualTo(bridgeMode_Acc_Footer_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's Footer")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Homespot_Activate_Title).textTrimmed().isEqualTo(bridgeMode_Acc_Homespot_Activate_Title_CL)
                .withCustomReportMessage("Validate notification msg's title in case the user's homespot is enabled")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Homespot_Activate_Text).textTrimmed().isEqualTo(bridgeMode_Acc_Homespot_notf_Text_CL)
                .withCustomReportMessage("Validate notification msg's text in case the user's homespot is enabled")
                .perform();
        return this;
    }
    @Step("validate Bridge-Mode Acc's content incase the bridge mode service is not returned")
    public KIPSettings validateBridgeModeAccInNotReturnedCase() {
        driver.verifyThat().element(bridgeMode_Acc_Header)
                .textTrimmed().isEqualTo(bridgeMode_Acc_Header_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's header")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_Footer)
                .textTrimmed().isEqualTo(bridgeMode_Acc_Footer_CL)
                .withCustomReportMessage("Validate Bridge mode accordion's Footer")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_NotReturned_notf_Title)
                .textTrimmed().isEqualTo(bridgeMode_Acc_NotReturned_notf_Title_CL)
                .withCustomReportMessage("Validate notification msg's title incase the bridge mode service is not returned")
                .perform();
        driver.verifyThat().element(bridgeMode_Acc_NotReturned_notf_Text)
                .textTrimmed().isEqualTo(bridgeMode_Acc_NotReturned_notf_Text_CL)
                .withCustomReportMessage("Validate notification msg's text incase the bridge mode service is not returned")
                .perform();
        return this;
    }

    @Step("validate Bridge-Mode acc  in case the user has no KIP Device")
    public KIPSettings validateBridgeModeAccInNoKIPCase() {
        driver.verifyThat().element(bridgeMode_SO_Wrapper).isHidden().perform();
        driver.verifyThat().element(bridgeMode_Acc).doesNotExist()
                .withCustomReportMessage("Accordion doesn't exist").perform();
        return this;
    }

    @Step("click On Activation Bridge-Mode Btn")
    public KIPSettings clickOnActivationBridgeModeBtn() {
        driver.element().isElementClickable(bridgeMode_Acc_Activation_Btn);
        driver.element().click(bridgeMode_Acc_Activation_Btn);
        return this;
    }

    @Step("click On Deactivation Bridge-Mode Btn")
    public KIPSettings clickOnDeactivationBridgeModeBtn() {
        driver.element().isElementClickable(bridgeMode_Acc_Deactivation_Btn);
        driver.element().click(bridgeMode_Acc_Deactivation_Btn);
        return this;
    }

    @Step("Deeplink to the bridge mode deactivation page")
    public KIPSettings deeplinkToBridgeModeDeactivationPage() {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/bridgeMode/bridge-mode-deaktivieren");
        return this;
    }

    @Step("validate that deeplinking to bridge mode deactivation page is disabled ")
    public KIPSettings validateDeeplinkingIsdisDiabled() {
        driver.verifyThat().element(bridgeMode_SO).exists().perform();
        driver.verifyThat().element(pageTitle).textTrimmed().isEqualTo(pageTitleCL)
                .withCustomReportMessage("Validate Page Title's  text ")
                .perform();
        return this;
    }

    @Step("validate that phoneline notification is appeared")
    public KIPSettings validatePhonelineNotification() {
        driver.verifyThat().element(phoneline_Section_Header).textTrimmed().isEqualTo(phoneline_Section_Header_CL)
                .withCustomReportMessage("Validate phoneline notification section header ")
                .perform();
        driver.verifyThat().element(phoneline_Notification_Title).textTrimmed().isEqualTo(phoneline_Notification_CL)
                .withCustomReportMessage("Validate phoneline notification section Notification")
                .perform();
        return this;
    }

    // phone Book Setting SO & ACC
    @Step("Verify Telefonbuch-Eintrag Smart Object is displayed.")
    public KIPSettings validatePhoneSettingSoAppears() {
        driver.verifyThat()
                .element(phoneSetting_SO)
                .exists()
                .withCustomReportMessage("Validate Phone Book Settings Smart Object Appears")
                .perform();

        driver.verifyThat()
                .element(phoneSetting_SO_Header)
                .textTrimmed()
                .contains(phoneSetting_Header_CL)
                .withCustomReportMessage("Validate Phone Book Settings Smart Object Header Text")
                .perform();

        driver.verifyThat()
                .element(phoneSetting_SO_Footer)
                .textTrimmed()
                .contains(phoneSetting_Footer_CL)
                .withCustomReportMessage("Validate Phone Book Settings Smart Object Footer Text")
                .perform();
        return this;
    }

    @Step("Verify Telefonbuch-Eintrag Smart Object and Accordion are not displayed.")
    public KIPSettings validatePhoneSettingSoAndAccNotDisplayed() {
        driver.verifyThat()
                .element(phoneSettingSO_notDisplayed)
                .isHidden()
                .withCustomReportMessage("Validate Phone Book Settings Smart Object not displayed")
                .perform();

        driver.verifyThat()
                .element(phoneSettingACC_notDisplayed)
                .doesNotExist()
                .withCustomReportMessage(" Validate Phone Book Settings Accordion not displayed")
                .perform();
        return this;
    }

    @Step("Click on Telefonbuch-Eintrag Smart Object.")
    public KIPSettings clickOnPhoneSettingSO() {
        driver.element().click(phoneSetting_SO);
        return this;
    }

    @Step("Verify Telefonbuch-Eintrag Accordion is displayed.")
    public KIPSettings validatePhoneSettingAccAppears() {
        driver.verifyThat()
                .element(phoneSetting_accHeader)
                .textTrimmed()
                .contains(phoneSetting_Header_CL)
                .withCustomReportMessage("Validate Phone Book Settings Accordion Header Text")
                .perform();

        driver.verifyThat()
                .element(phoneSetting_accFooter)
                .textTrimmed()
                .contains(phoneSetting_Footer_CL)
                .withCustomReportMessage("Validate Phone Book Settings Accordion Footer Text")
                .perform();
        return this;
    }

    @Step("Validate on the Telefonbuch-Eintrag notification.")
    public KIPSettings validatePhoneSettingNotification() {
        driver.verifyThat()
                .element(phoneSettingNotificationTitle)
                .textTrimmed()
                .contains(phoneSettingNotificationTitle_CL)
                .withCustomReportMessage("Validate Phone Book Settings notification Title Text")
                .perform();

        driver.verifyThat()
                .element(phoneSettingNotificationDescription)
                .textTrimmed()
                .contains(phoneSettingNotificationDescription_CL)
                .withCustomReportMessage("Validate Phone Book Settings notification description Text")
                .perform();
        return this;
    }

    @Step("Verify Telefonbuch-Eintrag Smart Object Failure.")
    public KIPSettings validatePhoneSettingSoFailure() {
        driver.verifyThat()
                .element(phoneSettingGeneralErrorTitle)
                .textTrimmed()
                .contains(generalError_Title_CL)
                .withCustomReportMessage("Validate general error title when service failure")
                .perform();

        driver.verifyThat()
                .element(phoneSettingGeneralErrorDescription)
                .textTrimmed()
                .contains(generalError_Text_CL)
                .withCustomReportMessage("Validate general error description when service failure")
                .perform();
        return this;
    }

    //Call settings | View SIP credentials for KD users
    @Step("Validate SIP Credentials")
    public KIPSettings validateSIPCredentials() {
        driver.verifyThat()
                .element(SIPPhoneNumbers)
                .textTrimmed()
                .contains(SIPPhoneNumbers_CL)
                .withCustomReportMessage("Validate SIP Numbers Text")
                .perform();

        driver.verifyThat()
                .element(SIPUsernames)
                .textTrimmed()
                .contains(SIPUsernames_CL)
                .withCustomReportMessage("Validate SIP UserName Text")
                .perform();

        driver.verifyThat()
                .element(SIPRegistrar)
                .textTrimmed()
                .contains(SIPRegistrar_CL)
                .withCustomReportMessage("Validate SIP Register Text")
                .perform();

        driver.verifyThat()
                .element(SIPProxy)
                .textTrimmed()
                .contains(SIPProxy_CL)
                .withCustomReportMessage("Validate SIP Proxy Text")
                .perform();
        return this;
    }

    @Step("Verify SIP Accordion Failure")
    public KIPSettings validateSIPCredentialsServiceFailure() {
        driver.verifyThat()
                .element(SIPCredentialsErrorTitle)
                .textTrimmed()
                .contains(SIPCredentialsErrorTitle_CL)
                .withCustomReportMessage("Validate SIP Credentials error title when service failure")
                .perform();

        driver.verifyThat()
                .element(SIPCredentialsErrorDescription)
                .textTrimmed()
                .contains(SIPCredentialsErrorDescription_CL)
                .withCustomReportMessage("Validate  SIP Credentials error description when service failure")
                .perform();
        return this;
    }

    @Step("Verify SIP Credentials Smart Object and Accordion are not displayed.")
    public KIPSettings validateSIPSoAndAccNotDisplayed() {
        driver.verifyThat()
                .element(SIPSo_notDisplayed)
                .isHidden()
                .withCustomReportMessage("Validate SIP Credentials Smart Object not displayed")
                .perform();

        driver.verifyThat()
                .element(SIPAcc_notDisplayed)
                .doesNotExist()
                .withCustomReportMessage("Validate SIP Credentials Accordion not displayed")
                .perform();
        return this;
    }

    @Step("Click on Telefonbuch-Eintrag Smart Object.")
    public KIPSettings clickOnPhoneBookSettingSO() {
        driver.element().isElementClickable(phoneSetting_SO);
        driver.element().click(phoneSetting_SO);
        return this;
    }

    // WFDT-7619 | View phone book settings for KD users
    @Step("Validate phone book settings in case Phonebook entry is Active.")
    public KIPSettings validateActivePhoneBookEntry() {

        driver.verifyThat()
                .element(registeredStatusPhoneNumber)
                .textTrimmed()
                .contains(registeredStatusPhoneNumber_Cl)
                .withCustomReportMessage("Validate Registered Phone Number")
                .perform();

        driver.verifyThat()
                .element(phoneNumberEditButton)
                .textTrimmed()
                .contains(phoneNumberEditButton_Cl)
                .withCustomReportMessage("Validate phone Number Edit Button")
                .perform();

        driver.verifyThat()
                .element(phoneNumberDeleteButton)
                .textTrimmed()
                .contains(phoneNumberDeleteButton_Cl)
                .withCustomReportMessage("Validate Phone Number Delete Button")
                .perform();
        return this;
    }

    @Step("Validate phone book settings in case there is no Phonebook entry.")
    public KIPSettings validateNoPhoneBookEntry() {

        driver.verifyThat()
                .element(notRegisteredStatusPhoneNumber)
                .textTrimmed()
                .contains(notRegisteredStatusPhoneNumber_Cl)
                .withCustomReportMessage("Validate Phone Number not Registered")
                .perform();

        driver.verifyThat()
                .element(phoneNumberAddButton)
                .textTrimmed()
                .contains(phoneNumberAddButton_CL)
                .withCustomReportMessage("Validate Phone Number Add Button")
                .perform();
        return this;
    }

    @Step("Validate phone book settings in case Phonebook entry is Locked")
    public KIPSettings validateLockedPhoneBookEntry() {
        driver.verifyThat()
                .element(lockedStatusPhoneNumber)
                .textTrimmed()
                .contains(lockedStatusPhoneNumber_Cl)
                .withCustomReportMessage("Validate Locked Phone Number")
                .perform();

        return this;
    }

    @Step("Validate Show more button is displayed")
    public KIPSettings validateShowMoreButtonDisplayed() {
        driver.verifyThat()
                .element(expandableButton)
                .textTrimmed()
                .contains(showMoreButton_Cl)
                .withCustomReportMessage("Validate expandable button")
                .perform();
        return this;
    }

    @Step("Click on expandable button")
    public KIPSettings clickOnShowMoreButton() {
        driver.element().click(expandableButton);
        return this;
    }

    @Step("Validate Show less button is displayed")
    public KIPSettings validateShowLessButtonDisplayed() {
        driver.verifyThat()
                .element(expandableButton)
                .textTrimmed()
                .contains(showLessButton_Cl)
                .withCustomReportMessage("Validate Show less button")
                .perform();
        return this;
    }

    @Step("Validate Expandable button Not displayed")
    public KIPSettings validateExpandableButtonNotDisplayed() {
        driver.verifyThat()
                .element(expandableButton)
                .doesNotExist()
                .withCustomReportMessage("Validate expandable button not displayed")
                .perform();
        return this;
    }

    // phone Line main number section
    @Step("Expand phone Line Accordion")
    public KIPSettings expandPhoneLineAcc() {
        driver.element().click(phoneLineSetting_ACC);
        return this;
    }

    @Step("Validate Main Number Section is displayed")
    public KIPSettings validateMainNumberSectionDisplayed() {
        driver.verifyThat()
                .element(mainNumberSectionHeader)
                .textTrimmed()
                .contains(mainNumberSectionHeader_CL)
                .withCustomReportMessage("Validate main number section header text")
                .perform();

        driver.verifyThat()
                .element(mainNumberSectionFooter)
                .textTrimmed()
                .contains(mainNumberSectionFooter_CL)
                .withCustomReportMessage("Validate main number section footer text")
                .perform();
        return this;
    }

    @Step("Click On phone line edit button")
    public KIPSettings clickOnPhoneLineEditButton() {
        driver.element().click(phoneLineEditButton);
        return this;
    }

    @Step("Validate main number section is not displayed")
    public KIPSettings validateMainNumberSectionNotDisplayed() {
        driver.verifyThat()
                .element(mainNumberSection)
                .doesNotExist()
                .withCustomReportMessage("Validate main number section is not displayed")
                .perform();
        return this;
    }

    @Step("Validate phone line deep linking is disabled")
    public KIPSettings validateDeepLinkingIsDisabledPhoneLine() {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/telefoneinstellungen/hauptnummerzuweisen");
        driver.verifyThat()
                .element(phoneLineSetting_ACC)
                .exists()
                .withCustomReportMessage("Validate phone line accordion is exists ")
                .perform();
        return this;
    }

    // Validation for WFDT-7619 ||View phone book settings for KD users || BC01
    @Step("Verify Telefonbuch-Eintrag Accordion Failure.")
    public KIPSettings validatePhoneSettingAccFailure() {
        driver.verifyThat()
                .element(viewPhoneBookErrorTittle)
                .textTrimmed()
                .contains(generalError_Title_CL)
                .withCustomReportMessage("Validate general error title when service failure")
                .perform();

        driver.verifyThat()
                .element(viewPhoneBookErrorDescription)
                .textTrimmed()
                .contains(generalError_Text_CL)
                .withCustomReportMessage("Validate general error description when service failure")
                .perform();
        return this;
    }

    @Step("Click on the Third Card or Phonebook Settings Acc")
    public KIPSettings clickOnAddBtnOfThirdCard() {
        driver.element().click(thirdCardPhonebook_AddBtn);
        return this;
    }

    // WFDT-8546 | Delete phone book entry for KD users
    public KIPSettings clickOnDeletePhoneBookButton() {
        driver.element().click(deletePhoneBook_button);
        return this;
    }

    @Step("validate that Delete phone book entry Deep linking is disabled.")
    public KIPSettings validateDeletePhoneBookDeepLinkingIsDisabled() {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/telefonbuchEintrag/telefonbuch-eintrag-loschen");
        driver.verifyThat()
                .element(phoneSetting_SO)
                .exists()
                .withCustomReportMessage("Validate phone book entry Deep linking")
                .perform();
        return this;
    }

    // Actions & Validation For WFDT-8249 | View WIFI (homespot) settings for KD users
    public KIPSettings clickOnHomeSpotAccordion() {
        driver.element().click(homespotAccordion);
        return this;
    }

    public KIPSettings clickOnHomespotActiveButton() {
        driver.element().click(homespotActive_button);
        return this;
    }

    public KIPSettings clickOnHomespotDeActiveButton() {
        driver.element().click(homespotDeActive_button);
        return this;
    }

    @Step("Validate Homespot Accordion in Activation Case")
    public KIPSettings validateHomespotActiveButton() {
        driver.verifyThat()
                .element(homespotActive_button)
                .textTrimmed()
                .contains(homespotActiveButton_CL)
                .withCustomReportMessage("Validate Homespot Accordion in Activation Case")
                .perform();

        driver.verifyThat()
                .element(activeHomespotMessageInformation_label)
                .textTrimmed()
                .contains(activeHomespotMessageInformation_CL1)
                .withCustomReportMessage("Validate Homespot Message Information in Active Case")
                .perform();

        driver.verifyThat()
                .element(activeHomespotMessageInformation_label)
                .textTrimmed()
                .contains(activeHomespotMessageInformation_CL2)
                .withCustomReportMessage("Validate Homespot Message Information in Active Case")
                .perform();
        return this;
    }

    @Step("Validate Homespot Accordion in DeActivation Case")
    public KIPSettings validateHomespotDeActiveButton() {
        driver.verifyThat()
                .element(homespotDeActive_button)
                .textTrimmed()
                .contains(homespotDeActiveButton_CL)
                .withCustomReportMessage("Validate Homespot Accordion in DeActivation Case")
                .perform();

        driver.verifyThat()
                .element(deAtiveHomespotMessageInformation_label)
                .textTrimmed()
                .contains(deAtiveHomespotMessageInformation_CL1)
                .withCustomReportMessage("Validate Homespot Message Information in deActive Case")
                .perform();

        driver.verifyThat()
                .element(deAtiveHomespotMessageInformation_label)
                .textTrimmed()
                .contains(deAtiveHomespotMessageInformation_CL2)
                .withCustomReportMessage("Validate Homespot Message Information in deActive Case")
                .perform();
        return this;
    }

    @Step("Validate Homespot Message in Activation Case Within Day")
    public KIPSettings validateHomespotActivationWithinDay() {
        driver.verifyThat()
                .element(homespotMessageTitle_label)
                .textTrimmed()
                .contains(homespotActivationMessageTitle_CL)
                .withCustomReportMessage("Validate Homespot Message Title in Activation Case Within Day")
                .perform();

        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotActivationMessageDescription_CL1)
                .withCustomReportMessage("Validate Homespot Message Description in Activation Case Within Day")
                .perform();
        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotActivationMessageDescription_CL11)
                .withCustomReportMessage("Validate Homespot Message Description in Activation Case Within Day")
                .perform();

        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotActivationMessageDescription_CL2)
                .withCustomReportMessage("Validate Homespot Message Description in Activation Case Within Day")
                .perform();
        return this;
    }

    @Step("Validate Homespot Message in Activation Case  Within 7 days")
    public KIPSettings validateHomespotDeActivationWithinSevenDays() {
        driver.verifyThat()
                .element(homespotMessageTitle_label)
                .textTrimmed()
                .contains(homespotDeActivationMessageTitle_CL)
                .withCustomReportMessage("Validate Homespot Message Title in DeActivation Case Within 7 days")
                .perform();

        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotDeActivationMessageDescription_CL1)
                .withCustomReportMessage("Validate Homespot Message Description in DeActivation Case Within 7 Days")
                .perform();
        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotDeActivationMessageDescription_CL11)
                .withCustomReportMessage("Validate Homespot Message Description in DeActivation Case Within 7 Days")
                .perform();

        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotDeActivationMessageDescription_CL2)
                .withCustomReportMessage("Validate Homespot Message Description in DeActivation Case Within 7 Days")
                .perform();
        return this;
    }

    @Step("Validate Homespot Message in Non-eligible Case ")
    public KIPSettings validateHomespotNonEligibleCase() {
        driver.element().isElementDisplayed(homespotMessageTitle_label);
        driver.verifyThat()
                .element(homespotMessageTitle_label)
                .textTrimmed()
                .contains(homespotNonEligibleMessageTitle_CL)
                .withCustomReportMessage("Validate Homespot Message Title in Non-eligible Case")
                .perform();

        driver.element().isElementDisplayed(homespotMessageDescription_label);
        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotNonEligibleMessageDescription_CL1)
                .withCustomReportMessage("Validate Homespot Message Description in Non-eligible Case")
                .perform();
        return this;
    }

    @Step("Validate Homespot Message in Bridge Mode activated Case")
    public KIPSettings validateHomespotBridgeModeCase() {
        driver.verifyThat()
                .element(homespotMessageTitle_label)
                .textTrimmed()
                .contains(homespotBridgeModeMessageTitle_CL)
                .withCustomReportMessage("Validate Homespot Message Title in Bridge Mode Case")
                .perform();

        driver.verifyThat()
                .element(homespotMessageDescription_label)
                .textTrimmed()
                .contains(homespotBrigeModeMessageDescription_CL)
                .withCustomReportMessage("Validate Homespot Message Description in Bridge Mode Case")
                .perform();
        return this;
    }

    @Step("Validate Homespot Message in Active and Activation Failed")
    public KIPSettings validateHomespotActiveDeActiveFailed() {
        driver.verifyThat()
                .element(homespotErrorMessageTitle_label)
                .textTrimmed()
                .contains(homespotErrorMessageTitle_CL)
                .withCustomReportMessage("Validate Homespot Error Message Title")
                .perform();

        driver.verifyThat()
                .element(homespotErrorMessageDescription_label)
                .textTrimmed()
                .contains(homespotErrorMessageDescription_CL1)
                .withCustomReportMessage("Validate Homespot Error Message Description")
                .perform();
        driver.verifyThat()
                .element(homespotErrorMessageDescription_label)
                .textTrimmed()
                .contains(homespotErrorMessageDescription_CL2)
                .withCustomReportMessage("Validate Homespot Error Message Description")
                .perform();
        return this;
    }

    @Step("Validate Homespot Accordion Not Displayed ")
    public KIPSettings validateHomespotAccNotDisplayed() {
        driver.verifyThat()
                .element(homespotAccordion)
                .doesNotExist()
                .withCustomReportMessage("Validate Homspot Accordion Not Displayed")
                .perform();
        return this;
    }


    @Step("Deeplink to the change phonebook settings page is disabled")
    public KIPSettings validateDeeplinkTOChangePhoneBookIsDisabled()
    {
        driver.browser().switchToNewTab(System.getProperty("de.vodafone.baseUrl.st") + "meinvodafone/services/telefonbuchEintrag/telefonbuch-eintrag-bearbeiten");
        driver.verifyThat().element(telefoneinstellungen_SO)
                .exists().withCustomReportMessage("Validate that deeplinking is disabled for changing phonebook settings")
                .perform();
        return this;
    }

    @Step("Click on the first Card's change button of Phonebook Settings Acc")
    public KIPSettings clickOnChangeBtnOfFirstCard ()
    {
        driver.element().click(firstCardPhoneBook_ChangeBtn);
        return this;
    }

}