package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class KabelTVPage {
    private SHAFT.GUI.WebDriver driver;
    public KabelTVPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver ;
    }

    //Page General Locator
    private By kipPageCrossLink = By.xpath("(//span[@class='verticalAlign-super' and contains(.,'Internet & Festnetz - Tarif')])");
    private By meinDatenPageCrossLink = By.xpath("(//*[@class='inline-block verticalAlign-super'])[1]");
    private By mbox_ID = By.xpath("(//img[@class='only-lrg'])[2]");
    private By mbox_button = By.xpath("(//button[@class='btn btn-sml'])[2]");

    //Locators Bookable Option
    private By internetAndPhoneButton = By.xpath("(//span[@class='verticalAlign-super'])[2]");
    private By kabelTVTitle = By.xpath("(//div[@automation-id='pageHeader_tv']/h1)");
    private By bookableOptionSO = By.xpath("(//div[@automation-id='buchbareOptionenSo_so'])");
    private By bookableOptionSOTitle = By.xpath("(//div[@automation-id='buchbareOptionenSo_so']//h3)");
    private By bookableOptionSOSubLine = By.xpath("(//div[@automation-id='buchbareOptionenSo_so']//div[@class=\"sb-block-footer\"])");
    private By bookableOptionAccordion = By.xpath("(//li[@automation-id='BuchbareOptionen_acc'])");
    private By bookableOptionCard = By.xpath("(//div[@id='BuchbareOptionenId'])");
    private By bookableOptionCardButton = By.xpath("(//a[@automation-id='customer_has_best_tariff_btn'])[1]");
    private By kudNummerText = By.xpath("//h3[@automation-id='smartCardName_tv']");
    private By kudNummerValue=By.xpath("//h3[@automation-id='smartCardserialNumber_tv']");
    private By firstBookableOp = By.xpath("(//bookable-tariff-card[@automation-id='bookableOption_tcrd'])[1]");
    private By noOptionsMsgBookableOpsAcc = By.xpath("(//div[@automation-id='successMsg_tv'])");
    private By noOptionsMeinTarifMsgBookableOpsAcc = By.xpath("(//div[@automation-id='successMsg_tv']/p)");
    private By noOptionsCLSTarifMsgBookableOpsAcc = By.xpath("(//div[@automation-id='successMsg_tv']//h4)");
    private By secondBookableOp = By.xpath("(//bookable-tariff-card[@automation-id='bookableOption_tcrd'])[2]");
    private By dropDownListInBookableOpsAcc = By.xpath("//button[@automation-id='smartCardsDropdown_btn']");
    private By firstKudnumberinDDL = By.xpath("(//ul[@automation-id='smartCardsDropdown_lv']//li//button[2])[1]");
    private By secondKudnumberinDDL = By.xpath("(//ul[@automation-id='smartCardsDropdown_lv']//li//button[2])[2]");

    //Locators Booked Option
    private By bookedOptionSO = By.xpath("//div[@automation-id='productBookedOptions_so']");
    private By bookedOptionSOTitle = By.xpath("//div[@automation-id='productBookedOptions_so']//h3");
    private By bookedOptionSOSubLine = By.xpath("//div[@automation-id='productBookedOptions_so']//div[@class='sb-block-footer']");
    private By bookedOptionAccordion = By.xpath("//li[@automation-id='productBookedOptions_acc']");
    private By dropDownList = By.xpath("(//button[@automation-id='smartCardsDropdown_btn'])");
    private By secondContactID = By.xpath("(//ul[@automation-id='smartCardsDropdown_lv'])//li[2]");
    private By bookedOptionCard = By.xpath("//div[@id='productBookedOptionsId']");
    private By firstSmartCardHeadline = By.xpath("(//button[@automation-id='smartCardsDropdown_btn']//div)[1]");
    private By firstSmartCardID = By.xpath("(//button[@automation-id='smartCardsDropdown_btn']//div)[2]");
    private By bookedOptionHeadlineF = By.xpath("(//h3[@automation-id='optionsWithSmartCardHeadline_tv'])[1]");
    private By bookedOptionSubLineF = By.xpath("(//p[@automation-id='bookedOptionsSubHeadline_tv'])[1]");
    private By bookedOptionsSectionF = By.xpath("(//div[@automation-id='optionWithoutSmartCard_tv'])[1]");
    private By firstBookedOptionWithSmartCard = By.xpath("(//span[@automation-id='option_0_tile'])[1]");
    private By secondBookedOptionWithSmartCard = By.xpath("(//span[@automation-id='option_1_tile'])[1]");
    private By secondSmartCardHeadline = By.xpath("(//li[@id='option_child']//button)[3]");
    private By secondSmartCardID = By.xpath("(//li[@id='option_child']//button)[4]");
    private By bookedOptionsSectionS = By.xpath("(//div[@automation-id='optionWithoutSmartCard_tv'])");
    private By thirdBookedOptionWithSmartCard = By.xpath("(//span[@automation-id='option_1_tile'])");
    private By firstBookedOptionWithoutSmartCard = By.xpath("//span[@automation-id='option_0_tile']");
    private By secondBookedOptionWithoutSmartCard = By.xpath("(//span[@automation-id='option_1_tile'])");
    private By withoutSmartCardTitle = By.xpath("(//h3[@automation-id='optionsWithoutSmartCardHeadline_tv'])");
    private By noBookedOptionTitle = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By noBookedOptionSubLine = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By errorMessageHeadline = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By errorMessageSubLine = By.xpath("//div[@automation-id='successMsg_tv']//p");

    //Mein Tariff Accordion Locators
    private By meinTarifAccordion = By.xpath("//li[@automation-id='meinTarifTv_acc']");
    private By meinTarifAccordionHeader = By.xpath("(//*[@automation-id='meinTarifTv_acc']//h4)[1]");
    private By meinTariffAccordionSubline = By.xpath("//*[@automation-id='meinTarifTv_acc']//h5");
    private By smartCard1 = By.xpath("(//div[@id='meinTarifTvId']//div)[2]");
    private By smartCard1header = By.xpath("//h3[@automation-id='smartCardName0_tv']");
    private By smartCard1SerialNumber = By.xpath("//h3[@automation-id='smartCardSerialNumber0_tv']");
    private By smartCard2header = By.xpath("//h3[@automation-id='smartCardName1_tv']");
    private By smartCard2 = By.xpath("(//*[@id='meinTarifTvId']//div)[36]");
    private By tariffWithNoSmartCard = By.xpath("(//div[@id='meinTarifTvId']//div)[2]");
    private By mixedTariffHeader = By.xpath("//h3[@automation-id='NoSmartCard1_tv']");
    private By staticBookedOptionCard = By.xpath("//div[@class='front']");
    private By MBOX_ID_Header = By.xpath("//h3[@automation-id='cableMeinTarifText_tv']");
    private By notificationError = By.xpath("//div[@automation-id='successMsg_tv']");
    private By notificationErrorHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By notificationErrorText = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By notificationCard = By.xpath("//div[@automation-id='changeTariffNotification_nt']");
    private By notificationCardHeader = By.xpath("//*[@automation-id='changeTariffNotification_nt']//h4");
    private By notificationCardText = By.xpath("//*[@automation-id='changeTariffNotification_nt']//p");
    private By notificationCardButton = By.xpath("(//*[@automation-id='changeTariffNotification_btn'])[1]");
    private By NoTariffOrBONotificationCard = By.xpath("//div[@automation-id='noTariff_nt']");
    private By NoTariffOrBONotificationCardHeader = By.xpath("//div[@automation-id='noTariff_nt']//div//h4");
    private By NoTariffOrBONotificationCardText = By.xpath("//div[@automation-id='noTariff_nt']//div//p");
    private By NoTariffOrBONotificationCardButton = By.xpath("(//a[@automation-id='noTariff_btn'])[1]");
    private By tarifDetailsCard = By.xpath("(//div[@class='tariff-dates-box'])[1]");
    private By tarifDetailsCard2 = By.xpath("(//div[@class='tariff-dates-box'])[2]");
    private By tarifDetailsCardHeader = By.xpath("(//span[@automation-id='contractDetailsHeader_tv'])[1]");
    private By monthlyBasePrice = By.xpath("(//span[@automation-id='productPriceLabel_tv'])[1]");
    private By contractNummber = By.xpath("(//span[@automation-id='contractNumberLabel_tv'])[1]");
    private By contractStartDate = By.xpath("(//span[@automation-id='contractStartDateLabel_tv'])[1]");
    private By contractEndDate = By.xpath("//span[@automation-id='contractEndDateLable_tv']");
    private By lastTerminationDate = By.xpath("//span[@automation-id='contractLastCancellationDateLable_tv']");
    private By cancellationLink = By.xpath("(//a[@automation-id='cancelConnection_Link'])[1]");
    private By bookedOptionsButton = By.xpath("(//a[@automation-id='goToBookedOptions_btn'])[1]");
    private By uspsCard = By.xpath("(//div[@class='front'])[1]");
    private By uspsCard2 = By.xpath("(//div[@class='front'])[2]");
    private By uspsCard3 = By.xpath("(//div[@class='front'])[3]");
    private By disclaimerMsg1 = By.xpath("(//div[@id='meinTarifTvId']//p)[1]");
    private By disclaimerMsg2 = By.xpath("(//div[@id='meinTarifTvId']//p)[3]");

    //Mein Kabel TV Locators
    private By meinKabelTVSO = By.xpath("//div[@automation-id='meinCableTv_so']");
    private By MeinKabelTVSOHeadline = By.xpath("//div[@automation-id='meinCableTv_so']//h3");
    private By MeinKabelTVSOSubLine = By.xpath("//div[@automation-id='meinCableTv_so']//div[@class='sb-block-footer']");
    private By MeinKabelTVAccordion = By.xpath("//accordion[@automation-id='meinCableTv_acc']");
    private By MeinKabelTVAccordionHeadline = By.xpath("//li[@automation-id='meinCableTv_acc']//h4");
    private By MeinKabelTVAccordionSubLine = By.xpath("//li[@automation-id='meinCableTv_acc']//h5");
    private By MeinKabelTVAccessNameAndUSPsCard = By.xpath("//li[@automation-id='meinCableTv_acc']//div[@class='front']");
    private By AccessNameAndUSPsHeadline = By.xpath("(//span[@automation-id='cardHeader_tv'])[1]");
    private By AccessNameAndUSPsBulletPoint = By.xpath("(//img[@automation-id='feature_01_img'])[1]");
    private By AccessNameAndUSPsFeatureOne = By.xpath("(//div[@automation-id='feature_01_lv'])[1]");
    private By MeinKabelTVContractDetailsCard = By.xpath("//li[@automation-id='meinCableTv_acc']//div[@class='white-box tarrifDetails w-66 col']");
    private By ContractDetailsCard = By.xpath("(//div[@class='white-box tarrifDetails w-66 col mb-15'])[1]");
    private By ContractDetailsHeadline = By.xpath("(//span[@automation-id='contractDetailsHeader_tv'])[1]");
    private By ContractDetailsBasicPrice = By.xpath("(//span[@automation-id='productPriceLabel_tv'])[1]");
    private By ContractDetailsContractNumber = By.xpath("(//span[@automation-id='contractNumberLabel_tv'])[1]");
    private By ContractDetailsStartDate = By.xpath("(//span[@automation-id='contractStartDateLabel_tv'])[1]");
    private By ContarctDetailsStartDateDate = By.xpath("(//div[@automation-id='contractStartDate_tv'])[1]");
    private By ContractDetailsEndDate = By.xpath("(//span[@automation-id='contractEndDateLable_tv'])[1]");
    private By ContractDetailsCancellationDate = By.xpath("(//span[@automation-id='contractLastCancellationDateLable_tv'])[1]");
    private By ContractDetailsCancellationLink = By.xpath("(//a[@automation-id='cancelConnection_Link'])[1]");
    private By MeinKabelTVParagraph = By.xpath("//li[@automation-id='meinCableTv_acc']//p[@class='mt-15']");
    private By MeinKabelTVText = By.xpath("//h3[@automation-id='meinCableTvText_tv']");
    private By MeinKabelTVTessar = By.xpath("(//li[@class='slider-content'])[1]");
    private By TessarToOfferCTA = By.xpath("(//button[@class='btn btn-sml'])[2]");
    private By MeinDatenLink = By.xpath("(//span[@class='verticalAlign-super'])[1]");
    private By KabelInternetFestnetzLink = By.xpath("(//span[@class='verticalAlign-super'])[2]");
    private By NoTariffImg = By.xpath("(//img[@automation-id='undefined_img'])[1]");
    private By NoTariffHeadline = By.xpath("(//h3[@automation-id='undefined_tv'])");
    private By NoTariffSubLine = By.xpath("(//p[@automation-id='undefined_tv'])//p[1]");
    private By NoTariffCTA = By.xpath("//a[@automation-id='undefined_btn']//span");
    private By CancellationNotificationCardBookedOption = By.xpath("(//div[@automation-id='undefined_nt'])[1]");
    private By CancellationNotificationBody = By.xpath("(//div[@automation-id='successMsg_tv'])[2]//h4");
    private By CancellationNotificationHotline = By.xpath("(//span[@automation-id='undefined_description_tv'])[1]");
    private By BookedOptionNegativePrice = By.xpath("(//span[@automation-id='option_4_tile']//span)[2]");
    private By BookedOptionCurrency = By.xpath("(//span[@automation-id='option_4_tile']//span)[3]");
    private By BookedOptionNegativePriceText = By.xpath("//span[@automation-id='option_4_tile']//span[3]");
    //CLs Booked Option Cards WFBT_12384
    private By bookedOptionPrice = By.xpath("//span[contains (text(),' 10,00 ')]");
    private By bookedOptionPriceCurrency = By.xpath("(//span[contains (text(),'€')])[1]");
    private By bookedOptionPricePerMonth = By.xpath("(//div[@class='status-information'])[1]");
    private By bookedOptionDetailsLink = By.xpath("(//div[@class='extras-card-details']//a)");
    private By addEmailAddressBtn = By.xpath("//div[@automation-id='successMsg_tv']//button");
    private By bookedOptionPrice_CancelBtn = By.xpath("(//a[@class='btn btn-sml btn-alt'])");
    private By bookedOptionFree_Name = By.xpath("//span[@class='h2' and contains (text(),'Erotik Option')]");
    private By bookedOptionFree_Text = By.xpath("//span[contains (text(),' Kostenlos ')]");
    private By bookedOptionNegativePriceNotificationTV = By.xpath("//span[@automation-id='option_5_tile']//h4[contains (text(),'nicht online kündigen')]");
    private By bookedOptionNegativePriceTextTV = By.xpath("//span[@automation-id='option_5_tile']//span[3]");
    private By bookedOptionNegative_CurrencyTV = By.xpath("//span[@automation-id='option_5_tile']//span[2]");
    private By bookedOptionNegativePriceTV = By.xpath("//span[@automation-id='option_5_tile']//div[2] //span[contains (text(),'14,99')]");
    private By cancellationBtnDimmed = By.xpath("//a[@class='btn btn-sml btn-alt dimmed-opacity']");
    private By bookedOptionNotCancellablePrice = By.xpath("//span[contains (text(),' 5,00 ')]");
    private By bookedOptionNotCancellable_PermonthTV = By.xpath("//div[@class='status-information']");
    private By bookedOptionNotCancellable_CurrencyTV = By.xpath("//span[contains (text(),'€')]");
    private By bookedOptionNotCancellable_NotificationTV = By.xpath("(//div[@automation-id='undefined_nt'])//h4");
    private By kabelTV_pageSubtitle=By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By kabelTV_FailureMessage_Title=By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By kabelTV_FailureMessage_Body=By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By cancelButtonFirstBookedOption = By.xpath("//a[@class='btn btn-sml btn-alt']");
    private By cancelButtonFirstBookedOptionWithoutSmartcard = By.xpath("//a[@class='btn btn-sml btn-alt']");
    private By cancelButtonThirdBookedOption = By.xpath("//span[@automation-id='option_2_tile']//a");
    private By cancellationOptionWithFirstSmartCardHeadline = By.xpath("(//h2[@automation-id='optionsWithSmartCardHeadline_tv'])[1]");
    private By cancellationBookedOptionHeadline = By.xpath("(//h3[@automation-id='bookedOptionsHeadline_tv'])[1]");
    private By cancellationBookedOptionSubHeadline = By.xpath("(//p[@automation-id='bookedOptionsSubHeadline_tv'])[1]");
    private By BookableCostFirstOptionTV = By.xpath("(//div[@class='extras-card-button']//a)[1]");
    private By OneSmartCardNameTV = By.xpath("//h3[@automation-id='smartCardName_tv']");
    private By OneSmartCardNumberTV = By.xpath("//h3[@automation-id='smartCardserialNumber_tv']");
    private By BookableCostThirdOptionTV = By.xpath("(//div[@class='extras-card-button']//a)[3]");
    private By fourthCardExisted = By.xpath("(//div[@class='tariff-card-wrapper'])[4]");
    private By BookableCostFourthOptionTV = By.xpath("(//div[@class='extras-card-button']//a)[4]");
    private By BookableCostSecondOptionTV = By.xpath("(//div[@class='extras-card-button']//a)[3]");
    private By BookableFreeFirstOptionTV = By.xpath("//div[@class='extras-card-buttonfreeOfCharge']//a");
    private By clsTeaser_Header = By.xpath("//h3[@automation-id='clsTeaserHeadline_tv']");
    private By tariffDetailsBox = By.xpath("//div[@class='tariff-dates-box']");
    private By forMoreQuestion = By.xpath("//h3[@automation-id=\"meinCableTvText_tv\"]");
    private By firstTariffName = By.xpath("//span[@automation-id=\"cardHeader_tv\"]");
    private By clsTeaserTitle = By.xpath("//h3[@automation-id='undefined_tv']");
    private By clsTeaserText = By.xpath("//p[@automation-id='undefined_tv']//p");
    private By clsTeaserBtn = By.xpath("//a[@automation-id='undefined_btn']");
    private By CancellationPendingNotification = By.xpath("(//div[@automation-id='undefined_nt']//h4[@class='flexDiv'])[3]");
    private By DropdownMenuBookedOptions = By.xpath("//button[@automation-id='smartCardsDropdown_btn']");
    private By SecondSmartCardDropdownMenu = By.xpath("(//ul[@automation-id='smartCardsDropdown_lv'])//li[2]");
    private By FirstContractIdDropdownMenu = By.xpath("(//ul[@automation-id='smartCardsDropdown_lv'])//li[3]");
    private By HeaderOfFirstBookedOption = By.xpath("(//span[@automation-id='option_0_tile']//div//span)[1]");
    private By OneTariffBookedOptionsHeader = By.xpath("//h2[@automation-id='optionsWithSmartCardHeadline_tv']");
    private By OneTariffBookedOptionsSubLine = By.xpath("//p[@automation-id='bookedOptionsSubHeadline_tv']");
    private By meinTarifSO = By.xpath("//div[@automation-id='meinTarifCableTv_so']");
    private By CancellationNotificationBodySO = By.xpath("//div[@automation-id='meinTarifCableTv_so']//p");
    private By CancellationNotificationFirstBodyMainTariffAcc = By.xpath("(//div[@automation-id='cancelledTariff_nt']//p)[1]");
    private By ContractEndDateLabel = By.xpath("//span[@automation-id='contractEndDateLable_tv']");
    private By CancelledContractFirstHint = By.xpath("(//span[@automation-id='canceledContractHint_tv'])[1]");
    private By CancelledContractSecondHint = By.xpath("(//span[@automation-id='canceledContractHint_tv'])[2]");
    private By BillSectionHyperLink = By.xpath("//a[@automation-id='billSection_undefined_0_Link']");
    private By GoToBookedOptionsAccCTA = By.xpath("//a[@automation-id='goToBookedOptions_btn']");
    private By MainTariffNameSO = By.xpath("(//h4[@automation-id='tarifName_tv'])[2]");
    private By CancellationNotificationSecondBodyMainTariffAcc = By.xpath("(//div[@automation-id='cancelledTariff_nt']//p)[2]");
    private By meinKabelTVAcc = By.xpath("//li[@automation-id='meinCableTv_acc']");
    private By BookableAccordionTitle = By.xpath("//li[@automation-id='BuchbareOptionen_acc']//h4");
    //CLs
    private String KIPPageCrossLinkCL = "Internet & Festnetz - Tarif";
    private String MeinDatenPageCrossLinkCL = "Meine Daten";
    private String BookableOptionSOTitleCL = "Buchbare Optionen TV";
    private String BookableOptionSOSubLineCL = "Alle buchbaren Optionen für meinen TV-Tarif";
    private String BookableOptionCardButtonCL = "0800 172 12 12";
    private String BookedOptionSOTitleCL = "Gebuchte Optionen";
    private String BookedOptionSOSubLineCL = "Ansehen und bearbeiten";
    private String FirstSmartCardHeadlineCL = "Smart card";
    private String FirstSmartCardHeadLineSecondIDCL = "Smart card";
    private String BookedOptionSubLineCL = "Diese Optionen ergänzen Deinen Tarif im Moment. Du willst etwas ändern? Hier siehst Du, wann Du eine Option kündigen kannst:";
    private String SecondSmartCardHeadlineCL = "Smart card";
    private String SecondSmartCardIDCL = "071177010107";
    private String WithoutSmartCardTitleCL = "Tarife ohne Smartcard";
    private String NoBookedOptionTitleCL = "Du kannst neue Optionen telefonisch dazubuchen";
    private String NoBookedOptionSubLineCL = "Ruf uns einfach an. Du erreichst uns montags bis freitags von 8 bis 20 Uhr und samstags von 9 bis 18 Uhr.";
    private String BookedOptionNegativePriceCL = "8,93";
    private String bookedOptionCurrencyCL = "€";
    private String BookedOptionNegativePriceTextCL = "geschenkt";

    //CLs of BookedOptionCards WFDT_12384
    private String bookedOptionPricePerMonthCL = "pro Monat";
    private String bookedOptionPriceCL = "10,00";
    private String bookedOptionCancelBtnCL = "Option kündigen";
    private String bookedOptionFree_NameCL = "Erotik Option";
    private String bookedOptionFree_TextCL = "Kostenlos";
    private String bookedOptionNotCancellablePriceCL = "5,00";
    private String bookedOptionNotCancellable_NotificationTVCL = "Du kannst diese Option leider nicht online kündigen. Wende Dich bitte an die Kundenbetreuung.";
    private String kabelTV_pageSubtitle_CL = "Automated Martin (Kundennummer: 1111)";
    private String externalDetailsPage= "https://zuhauseplus.vodafone.de/gigatv/";
    private String missingEmailRedirection = "meinvodafone/services/vertragsdaten?accordion=kontaktdaten";

    //CLs Mein Tariff Accordion
    private String meinTariffAccordionHeaderCL = "Mein Tarif";
    private String meinTariffAccSublineCL = "Laufzeit und Vertragsverlängerung";
    private String smartCard1HeaderCL = "Tarife auf Deiner Smartcard";
    private String smartCard2HeaderCL = smartCard1HeaderCL;
    private String NotificationErrorHeaderCL = "Das hat leider nicht geklappt";
    private String NotificationErrorTextCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private String NotificationCardHeaderCL = "Du willst einen anderen TV-Tarif?";
    private String NotificationCardTextCL = "Ruf uns einfach an. Du erreichst uns von Montag bis Freitag von 8 bis 20 Uhr" +
            " und Samstag von 9 bis 18 Uhr. Kostenlos aus allen deutschen Netzen.";
    private String NotificationCardButtonCL = "0800 203 03 44";
    private String NoTariffOrBONotificationCardHeaderCL = "Du hast noch keinen Tarif";
    private String MixedTariffHeaderCL = "Tarife ohne Smartcard";
    private String tarifDetailsCardHeaderCL = "Meine Vertragsdetails";
    private String monthlyBasePriceCL = "Monatlicher Grundpreis *";
    private String contractNumberCL = "Vertragsnummer";
    private String contractStartDateCL = "Vertragsstart";
    private String contractEndDateCL = "Vertrag läuft bis";
    private String lastTerminationDateCL = "Letzter Kündigungstermin";
    private String cancellationLinkCL = "Anschluss kündigen";
    private String bookedOptionButtonCL = "Deine gebuchten Optionen";
    private String DisclaimerMsg1CL = "* Grundpreis ohne gebuchte Optionen und Produkte wie Vodafone TV oder Auslandsoptionen.";
    private String DisclaimerMsg2CL = DisclaimerMsg1CL;
    private String MBOX_ID_Header_CL = "Mach noch mehr draus";
    private String MeinKabelTVSOHeadlineCL = "Mein Kabel TV";
    private String MeinKabelTVAccordionHeadlineCL = "Mein Kabel TV";
    private String MeinKabelTVAccordionSubLineCL = "Leistungsumfang, Vertragsdetails und mehr";
    private String AccessNameAndUSPsHeadlineCL = "HD Receiver";
    private String AccessNameAndUSPsFeatureOneCL = "Empfang von digitalen TV-Sendern";
    private String AccessNameAndUSPsHeaderRenterNoTariffCL = "GigaTV Cable";
    private String AccessNameAndUSPsFeatureOneRenterCL = "Großes Media- und Videotheken Angebot";
    private String ContractDetailsHeadlineCL = "Meine Vertragsdetails";
    private String ContractDetailsBasicPriceCL = "Monatlicher Grundpreis *";
    private String ContractDetailsContractNumberCL = "Vertragsnummer";
    private String ContractDetailsStartDateCL = "Vertragsstart";
    private String ContractDetailsEndDateCL = "Vertrag läuft bis";
    private String ContractDetailsCancellationDateCL = "Letzter Kündigungstermin";
    private String ContractDetailsCancellationLinkCL = "Anschluss kündigen";
    private String MeinKabelTVParagraphCL = "* Grundpreis ohne gebuchte Optionen und Produkte wie Vodafone TV oder Auslandsoptionen.";
    private String MeinKabelTVTextCL = "Mach noch mehr draus";
    private String TessarToOfferCTACL = "Zum Angebot";
    private String ContarctDetailsStartDateDateCL = "in Mietnebenkosten enhalten";
    private String MeinDatenLinkCL = "Mein Daten";
    private String KabelInternetFestnetzLinkCL = "Kabel Internet & Festnetz";
    private String NoTariffHeadlineCL = "Beste TV-Unterhaltung über Deinen Kabelanschluss";
    private String NoTariffSubLineCL = "Mit GigaTV hast Du eine riesige Programmvielfalt.";
    private String NoTariffCTACL = "Jetzt buchen";
    private String CancellationNotificationBodyCL = "Diese Option kannst Du telefonisch kündigen. Du erreichst uns montags bis sonntags von 7:30 bis 22 Uhr.";
    private String CancellationNotificationHotlineCL = "0800 172 12 12";
    private String MeinKabelTVSOSubLineCL = "Leistungen Vertragsdetails";

    //Methods
    @Step("Expand Bookable Option Accordion")
    public KabelTVPage expandBookableOptionAccordion(){
        driver.element().click(bookableOptionAccordion);
        return this;
    }
    @Step("Validate the view of the bookable options acc when user has only Mein Tarif")
    public KabelTVPage validateBookableAccWhenTheresOnlyMeinTarif(){
        driver.verifyThat().element(kudNummerText).isVisible().perform();
        driver.verifyThat().element(kudNummerValue).isVisible().perform();
        driver.verifyThat().element(firstBookableOp).isVisible().perform();
        driver.verifyThat().element(secondBookableOp).isVisible().perform();
        return this;
    }
    @Step("Validate the view of the bookable options acc when user has Mein and CLS Tarifs")
    public KabelTVPage validateBookableAccWhenThereCLSandMainTarif() {
        driver.verifyThat().element(dropDownListInBookableOpsAcc).isVisible().perform();
        return this;
    }
    @Step("Validate the view of the bookable options acc when user has Mein Tarif with No Options")
    public KabelTVPage validateTheresNoOptsForMeinTarif() {
        driver.verifyThat().element(noOptionsMeinTarifMsgBookableOpsAcc).exists().perform();
        return this;
    }
    @Step("Validate the view of the bookable options acc when user has Mein Tarif with No Options")
    public KabelTVPage validateTheresNoOptsForCLSTarif() {
        driver.verifyThat().element(noOptionsCLSTarifMsgBookableOpsAcc).isVisible().perform();
        return this;
    }

    @Step("Validate that the CLS Tarif's number displayed in the Bookable options accordion")
    public KabelTVPage validateCLSTarifsKudnumerIsDisplayed(String clsTarifKudnumber){
        driver.verifyThat().element(firstKudnumberinDDL).textTrimmed().isEqualTo(clsTarifKudnumber);
        return this;
    }
    @Step("Validate Bookable options accordion when theres a CLS tarif without options")
    public KabelTVPage validateBookableoptionAccWithNoOps( ){
        driver.verifyThat().element(noOptionsMsgBookableOpsAcc).isVisible().perform();
        return this;
    }

    @Step("click on the DropDownList of Bookable options accordion")
    public KabelTVPage clickOnDropDwonListOnBookableOpAcc(){
        driver.element().click(dropDownListInBookableOpsAcc);
        return this;
    }
    @Step("Click on 2nd Option of the Dropdownlist on Bookable options accordion")
    public KabelTVPage clickOnSecondOptionInDDL(){
        driver.element().click(secondKudnumberinDDL);
        return this;
    }

    @Step("Validate the are 2 kudnumbers in the DDL")
    public KabelTVPage validateThereTwoKudnumbersInDDL(){
        driver.verifyThat().element(firstKudnumberinDDL).isVisible().perform();
        driver.verifyThat().element(secondKudnumberinDDL).isVisible().perform();
        return this;
    }
    @Step("Validate that first Kudnumber is the Mein tarif's ")
    public KabelTVPage validateFirstKudnumberInDDL (String MeinTarifKudnumber){
        driver.verifyThat().element(firstKudnumberinDDL).textTrimmed().isEqualTo(MeinTarifKudnumber);

        return this;
    }

    @Step("Expand Booked Option Accordion")
    public KabelTVPage expandBookedOptionAccordion() {
        driver.verifyThat().element(bookedOptionAccordion).exists().perform();
        driver.element().click(bookedOptionAccordion);
        return this;
    }

    @Step("Click On Mein Kabel TV Smart Object")
    public KabelTVPage clickOnMeinKabelTVSO(){
        driver.element().click(meinKabelTVSO);
        return this;
    }

    @Step("Click On Mein Kabel TV Accordion")
    public KabelTVPage clickOnMeinKabelTVAccordion(){
        driver.element().click(MeinKabelTVAccordion);
        return this;
    }

    @Step("Click On Cancellation Link In Contract Detail Card")
    public KabelTVPage clickOnCancellationLink(){
        driver.element().click(ContractDetailsCancellationLink);
        return this;
    }

    @Step("Click on Book now CTA")
    public KabelTVPage clickOnBookNowCTA(){
        driver.element().click(NoTariffCTA);
        return this;
    }

    @Step("Click on Cancel button on first booked option")
    public KabelTVPage clickCancelButtonFirstBookedOption(){
        driver.element().click(cancelButtonFirstBookedOption);
        return this;
    }

    @Step("Click on Cancel button on second booked option")
    public KabelTVPage clickCancelButtonSecondBookedOption(){
        driver.element().click(cancelButtonThirdBookedOption);
        return this;
    }

    @Step("Click On Cancel Button Third Booked Option")
    public KabelTVPage clickCancelButtonThirdBookedOption(){
        driver.element().click(cancelButtonThirdBookedOption);
        return this;
    }

    @Step("Click On Cancel Button First Booked Option Without SmartCard")
    public KabelTVPage clickCancelButtonFirstBookedOptionWithoutSmartcard(){
        driver.element().click(cancelButtonFirstBookedOptionWithoutSmartcard);
        return this;
    }

    @Step("Click On Bookable First Option Tv with cost")
    public KabelTVPage clickBookFirstOptionTVWithCost(){
        driver.element().click(BookableCostFirstOptionTV);
        return this;
    }

    @Step("Click On Bookable fourth Option Tv with cost")
    public KabelTVPage clickBookFourthOptionTVWithCost(){
        driver.verifyThat().element(fourthCardExisted).exists().perform();
        driver.element().click(BookableCostFourthOptionTV);
        return this;
    }

    @Step("Click On Bookable Second Option Tv with cost")
    public KabelTVPage clickBookSecondOptionTVWithCost(){
        driver.element().click(BookableCostSecondOptionTV);
        return this;
    }

    @Step("Click On Bookable first option TV")
    public KabelTVPage clickBookFirstOptionTvFree(){
        driver.element().click(BookableFreeFirstOptionTV);
        return this;
    }

    @Step("Click on dropdown menu in booked options accordion")
    public KabelTVPage clickOnDropdownMenuBookedOptionsAcc(){
        driver.element().click(DropdownMenuBookedOptions);
        return this;
    }

    @Step("Click On second smartcard dropdown menu booked option accordion")
    public KabelTVPage clickOnSecondSmartCardDropdownMenuBOA(){
        driver.element().click(SecondSmartCardDropdownMenu);
        return this;
    }

    @Step("Click On first contract id dropdown menu booked option accordion")
    public KabelTVPage clickOnFirstContractIdDropdownMenuBOA(){
        driver.element().click(FirstContractIdDropdownMenu);
        return this;
    }

    @Step("Click On Bookable Third Option Tv with cost")
    public KabelTVPage clickBookThirdOptionTVWithCost(){
        driver.element().click(BookableCostThirdOptionTV);
        return this;
    }

    @Step("Click on Bill section Hyper link")
    public KabelTVPage clickBillHyperLink(){
        driver.element().click(BillSectionHyperLink);
        return this;
    }
    @Step("Click on Go to booked option CTA in main tariff accordion")
    public KabelTVPage clickOnGoToBookedOptionCTA(){
        driver.element().click(GoToBookedOptionsAccCTA);
        return this;
    }

    @Step("Validate When click on Mein Kabel TV SO it will Expand Mein Kabel TV Accordion")
    public KabelTVPage validateWhenClickMKTVSOExpandMKTVAccordion(){
        driver.verifyThat().element(MeinKabelTVAccordionHeadline).textTrimmed().isEqualTo(MeinKabelTVAccordionHeadlineCL).perform();
        driver.verifyThat().element(MeinKabelTVAccordionSubLine).textTrimmed().isEqualTo(MeinKabelTVAccordionSubLineCL).perform();
        driver.verifyThat().element(MeinKabelTVAccessNameAndUSPsCard).exists().perform();
        driver.verifyThat().element(MeinKabelTVContractDetailsCard).exists().perform();
        driver.verifyThat().element(MeinKabelTVText).textTrimmed().isEqualTo(MeinKabelTVTextCL).perform();
        return this;
    }

    @Step("Validate Existence of Internet and phone CTA")
    public KabelTVPage checkInternetAndPhoneButtonExist(){
        driver.verifyThat().element(internetAndPhoneButton).exists().perform();
        return this;
    }

    @Step("Validate Kabel Tv Title")
    public KabelTVPage validateKabelTVTitle(String KabelTVTitleCL){
        driver.assertThat().element(kabelTVTitle).textTrimmed().isEqualTo(KabelTVTitleCL).perform();
        return this;
    }

    @Step("Validate Bookable Option Smart Object")
    public KabelTVPage validateBookableOptionSO(){
        driver.verifyThat().element(bookableOptionSO).exists().perform();
        driver.verifyThat().element(bookableOptionSOTitle).textTrimmed().isEqualTo(BookableOptionSOTitleCL).perform();
        driver.verifyThat().element(bookableOptionSOSubLine).textTrimmed().isEqualTo(BookableOptionSOSubLineCL).perform();
        return this;
    }

    @Step("Validate Bookable Option Accordion Card")
    public KabelTVPage validateBookableOptionAccordionCard(){
        driver.verifyThat().element(bookableOptionCard).exists().perform();
        return this;
    }

    @Step("Validate Booked Option Smart Object")
    public KabelTVPage validateBookedOptionOS(){
        driver.verifyThat().element(bookedOptionSO).exists().perform();
        driver.verifyThat().element(bookedOptionSOTitle).textTrimmed().isEqualTo(BookedOptionSOTitleCL).perform();
        driver.verifyThat().element(bookedOptionSOSubLine).textTrimmed().isEqualTo(BookedOptionSOSubLineCL).perform();
        return this;
    }

    @Step("Validate Existence of Booked Option Accordion Card")
    public KabelTVPage validateExistenceOfBookedOptionAccordionCard(){
        driver.verifyThat().element(bookedOptionCard).exists().perform();
        return this;
    }

    @Step("Validate First SmartCard Details First Serial Number")
    public KabelTVPage validateFirstSmartCardDetails(){
        driver.verifyThat().element(firstSmartCardHeadline).textTrimmed().isEqualTo(FirstSmartCardHeadlineCL).perform();
        return this;
    }

    @Step("Validate Booked Option Accordion in First SmartCard")
    public KabelTVPage validateBookedOptionFAccordionDetails(){
        driver.verifyThat().element(OneTariffBookedOptionsSubLine).textTrimmed().contains(BookedOptionSubLineCL).perform();
        driver.verifyThat().element(bookedOptionsSectionF).exists().perform();
        return this;
    }

    @Step("Validate First Booked Option Card in First SmartCard")
    public KabelTVPage validateFirstBookedOptionWithSmartCard(){
        driver.verifyThat().element(firstBookedOptionWithSmartCard).exists().perform();
        return this;
    }

    @Step("Validate Second Booked Option Card In First SmartCard")
    public KabelTVPage validateSecondBookedOptionWithSmartCard(){
        driver.verifyThat().element(secondBookedOptionWithSmartCard).exists().perform();
        return this;
    }

    @Step("Validate Second SmartCard Details")
    public KabelTVPage validateSecondSmartCardDetails(){
        driver.element().click(dropDownList);
        driver.verifyThat().element(secondSmartCardHeadline).textTrimmed().isEqualTo(SecondSmartCardHeadlineCL).perform();
        driver.verifyThat().element(secondSmartCardID).textTrimmed().isEqualTo(SecondSmartCardIDCL).perform();
        driver.element().click(secondSmartCardHeadline);
        return this;
    }

    @Step("Validate Booked Option Accordion in Second SmartCard")
    public KabelTVPage validateBookedOptionSAccordionDetails(){
        driver.assertThat().element(bookedOptionsSectionS).exists().perform();
        return this;
    }

    @Step("Validate First Booked Option Card in Second SmartCard")
    public KabelTVPage validateThirdBookedOptionWithSmartCard(){
        driver.assertThat().element(thirdBookedOptionWithSmartCard).exists().perform();
        return this;
    }

    @Step("Validate that there is no SmartCard")
    public KabelTVPage validateFirstSmartCardDoesNotExist(){
        driver.verifyThat().element(firstSmartCardHeadline).doesNotExist().perform();
        driver.verifyThat().element(firstSmartCardID).doesNotExist().perform();
        return this;
    }

    @Step("Validate Booked Options Without SmartCard")
    public KabelTVPage validateBookedOptionsWithoutSmartCard(){
        driver.verifyThat().element(firstBookedOptionWithoutSmartCard).exists().perform();
        driver.verifyThat().element(secondBookedOptionWithoutSmartCard).exists().perform();
        return this;
    }

    @Step("Validate that there is no SmartCard")
    public KabelTVPage validateSecondSmartCardDoesNotExist(){
        driver.verifyThat().element(secondSmartCardHeadline).doesNotExist().perform();
        driver.verifyThat().element(secondSmartCardID).doesNotExist().perform();
        return this;
    }

    @Step("Validate Title if there is no SmartCard")
    public KabelTVPage validateWithoutSmartCardTitle(){
        driver.assertThat().element(withoutSmartCardTitle).textTrimmed().isEqualTo(WithoutSmartCardTitleCL).perform();
        return this;
    }

    @Step("Validate When there is no Booked Options")
    public KabelTVPage validateNoBookedOptions(){
        driver.verifyThat().element(noBookedOptionTitle).textTrimmed().isEqualTo(NoBookedOptionTitleCL).perform();
        driver.verifyThat().element(noBookedOptionSubLine).textTrimmed().isEqualTo(NoBookedOptionSubLineCL).perform();
        return this;
    }

    @Step("Validate Error Message Notification")
    public KabelTVPage validateErrorMessageNotification(){
        driver.verifyThat().element(errorMessageHeadline).textTrimmed().isEqualTo(NotificationErrorHeaderCL).perform();
        driver.verifyThat().element(errorMessageSubLine).textTrimmed().isEqualTo(NotificationErrorTextCL).perform();
        return this;
    }

    @Step("Mein Tariff Accordion Validations")
    public KabelTVPage validateMeinTariffAcc(){
        driver.verifyThat().element(meinTarifAccordion).exists().perform();
        driver.verifyThat().element(meinTarifAccordionHeader).textTrimmed().isEqualTo(meinTariffAccordionHeaderCL).perform();
        driver.verifyThat().element(meinTariffAccordionSubline).textTrimmed().isEqualTo(meinTariffAccSublineCL).perform();
        return this;
    }

    @Step("Validate that there is an one smart card in mein tariff accordion Validation")
    public KabelTVPage assertOnSmartCard1(){
        driver.verifyThat().element(smartCard1).exists().perform();
        driver.verifyThat().element(smartCard1header).textTrimmed().isEqualTo(smartCard1HeaderCL).perform();
        driver.verifyThat().element(smartCard1SerialNumber).exists().perform();
        driver.verifyThat().element(tarifDetailsCard).exists().perform();
        driver.verifyThat().element(disclaimerMsg1).textTrimmed().isEqualTo(DisclaimerMsg1CL).perform();
        return this;
    }

    @Step("Validate Tariff Card Details in the Smart Card")
    public KabelTVPage validateSmartCardTarifDetails(){
        driver.verifyThat().element(tarifDetailsCard).exists().perform();
        driver.verifyThat().element(tarifDetailsCardHeader).textTrimmed().isEqualTo(tarifDetailsCardHeaderCL).perform();
        driver.verifyThat().element(monthlyBasePrice).textTrimmed().isEqualTo(monthlyBasePriceCL).perform();
        driver.verifyThat().element(contractNummber).textTrimmed().isEqualTo(contractNumberCL).perform();
        driver.verifyThat().element(contractStartDate).textTrimmed().isEqualTo(contractStartDateCL).perform();
        driver.verifyThat().element(contractEndDate).textTrimmed().isEqualTo(contractEndDateCL).perform();
        driver.verifyThat().element(lastTerminationDate).textTrimmed().isEqualTo(lastTerminationDateCL).perform();
        driver.verifyThat().element(cancellationLink).textTrimmed().isEqualTo(cancellationLinkCL).perform();
        driver.verifyThat().element(bookedOptionsButton).textTrimmed().isEqualTo(bookedOptionButtonCL).perform();
        driver.verifyThat().element(disclaimerMsg1).textTrimmed().isEqualTo(DisclaimerMsg1CL).perform();
        return this;
    }

    @Step("Assert On Unique Selling Points Card")
    public KabelTVPage assertOnUSPsCardExists(){
        driver.assertThat().element(uspsCard).exists().perform();
        return this;
    }

    @Step("Assert On second Selling Points Card")
    public KabelTVPage assertOnSecondUSPsCardExists(){
        driver.assertThat().element(uspsCard2).exists().perform();
        return this;
    }

    @Step("Smart card2 in mein tariff accordion Validation")
    public KabelTVPage validateSmartCard2(){
        driver.verifyThat().element(smartCard2).exists().perform();
        driver.verifyThat().element(smartCard2header).exists().perform();
        driver.verifyThat().element(smartCard2header).textTrimmed().isEqualTo(smartCard2HeaderCL).perform();
        driver.verifyThat().element(tarifDetailsCard2).exists().perform();
        driver.verifyThat().element(disclaimerMsg2).textTrimmed().isEqualTo(DisclaimerMsg2CL).perform();
        return this;
    }

    @Step("Assert that the notification appears once in the whole page")
    public KabelTVPage assertOnChangeTariffNotificationExistsOnce(){
        if(driver.getDriver().findElements(notificationCard).size() == 1){
            driver.verifyThat().element(notificationCard).exists().perform();
            driver.verifyThat().element(notificationCardHeader).textTrimmed().isEqualTo(NotificationCardHeaderCL).perform();
            driver.verifyThat().element(notificationCardText).textTrimmed().isEqualTo(NotificationCardTextCL).perform();
            driver.verifyThat().element(notificationCardButton).textTrimmed().isEqualTo(NotificationCardButtonCL).perform();
        }
        else{
            System.out.println("Notification card exists more than once in the page");
        }
        return this;
    }

    @Step("Assert on Msg error when BE erorr occurs")
    public KabelTVPage assertOnNotificationError(){
        driver.verifyThat().element(notificationError).exists().perform();
        driver.verifyThat().element(notificationErrorHeader).textTrimmed().isEqualTo(NotificationErrorHeaderCL).perform();
        driver.verifyThat().element(notificationErrorText).textTrimmed().isEqualTo(NotificationErrorTextCL).perform();
        return this;
    }

    @Step("Assert on No Tarif/Options booked Notification card")
    public KabelTVPage assertOnNoTariffOrBookedOptionsNotificationCard(){
        driver.verifyThat().element(tarifDetailsCard).doesNotExist().perform();
        driver.verifyThat().element(uspsCard).doesNotExist().perform();
        driver.verifyThat().element(NoTariffOrBONotificationCard).exists().perform();
        driver.verifyThat().element(NoTariffOrBONotificationCardHeader).text().isEqualTo(NoTariffOrBONotificationCardHeaderCL).perform();
        driver.verifyThat().element(NoTariffOrBONotificationCardText).text().isEqualTo(NotificationCardTextCL).perform();
        driver.verifyThat().element(NoTariffOrBONotificationCardButton).text().isEqualTo(NotificationCardButtonCL).perform();
        return this;
    }

    @Step("Assert that no SmartCard Header/Id exists (Mixed Tarif)")
    public KabelTVPage assertOnTariffWithoutSmartCard(){
        driver.verifyThat().element(mixedTariffHeader).textTrimmed().isEqualTo(MixedTariffHeaderCL).perform();
        driver.verifyThat().element(smartCard2).exists().perform();
        driver.verifyThat().element(disclaimerMsg2).textTrimmed().isEqualTo(DisclaimerMsg2CL).perform();
        return this;
    }

    @Step("Assert that there is only tariff exists")
    public KabelTVPage assertOnTariffOnly(){
        driver.verifyThat().element(smartCard1header).doesNotExist().perform();
        driver.verifyThat().element(tariffWithNoSmartCard).exists().perform();
        driver.verifyThat().element(tarifDetailsCard).exists().perform();
        driver.verifyThat().element(disclaimerMsg1).textTrimmed().isEqualTo(DisclaimerMsg1CL).perform();
        return this;
    }

    @Step("Assert on Static Book options Card")
    public KabelTVPage assertOnStaticBookedOptionCard(){
        driver.verifyThat().element(tarifDetailsCard).doesNotExist().perform();
        driver.verifyThat().element(staticBookedOptionCard).exists().perform();
        return this;
    }

    @Step("Assert on Static Book options Card in the edge case")
    public KabelTVPage assertOnStaticBookedOptionCardInEdgeCase(){
        driver.assertThat().element(uspsCard3).exists().perform();
        return this;
    }

    @Step("Assert on teaser campaign")
    public KabelTVPage assertOnMBOXsID(){
        driver.verifyThat().element(MBOX_ID_Header).textTrimmed().isEqualTo(MBOX_ID_Header_CL).perform();
        driver.verifyThat().element(mbox_ID).doesNotExist().perform();
        return this;
    }

    @Step("Validate the Hotline Number Added in the Bookable Option Card")
    public KabelTVPage validateHotlineButton(){
        driver.verifyThat().element(bookableOptionCardButton).textTrimmed().isEqualTo(BookableOptionCardButtonCL).perform();
        driver.assertThat().element(bookableOptionCardButton).attribute("class").contains("disabled").perform();
        return this;
    }

    @Step("Validate First SmartCard Details Second Serial Number")
    public KabelTVPage validateSecondSerialNumberInFirstSmartCard(String SmartCardSerialNO){
        driver.element().waitToBeReady(firstSmartCardHeadline);
        driver.verifyThat().element(firstSmartCardHeadline).textTrimmed().isEqualTo(FirstSmartCardHeadLineSecondIDCL).perform();
        driver.verifyThat().element(firstSmartCardID).textTrimmed().isEqualTo(SmartCardSerialNO).perform();
        return this;
    }

    @Step("Validate Existence of Mein Kabel TV Smart Object and Validate the Content of SO")
    public KabelTVPage validateMeinKabelTVSO(){
        driver.verifyThat().element(meinKabelTVSO).exists().perform();
        driver.verifyThat().element(MeinKabelTVSOHeadline).textTrimmed().isEqualTo(MeinKabelTVSOHeadlineCL).perform();
        driver.verifyThat().element(MeinKabelTVSOSubLine).exists().perform();
        return this;
    }

    @Step("Validate Existence of Mein Kabel TV Smart Object and Validate the Content of SO in case of no tariff renter user")
    public KabelTVPage validateMeinKabelTVSORenterNoTariff(){
        driver.verifyThat().element(meinKabelTVSO).exists().perform();
        driver.verifyThat().element(MeinKabelTVSOHeadline).textTrimmed().isEqualTo(MeinKabelTVSOHeadlineCL).perform();
        driver.verifyThat().element(MeinKabelTVSOSubLine).textTrimmed().isEqualTo(MeinKabelTVSOSubLineCL).perform();
        return this;
    }

    @Step("Validate Mein Kabel TV Accordion")
    public KabelTVPage validateMeinKabelTVAccordion(){
        driver.verifyThat().element(MeinKabelTVAccordionHeadline).textTrimmed().isEqualTo(MeinKabelTVAccordionHeadlineCL).perform();
        driver.verifyThat().element(MeinKabelTVAccordionSubLine).textTrimmed().isEqualTo(MeinKabelTVAccordionSubLineCL).perform();
        driver.verifyThat().element(MeinKabelTVAccessNameAndUSPsCard).exists().perform();
        driver.verifyThat().element(MeinKabelTVContractDetailsCard).exists().perform();
        driver.verifyThat().element(MeinKabelTVParagraph).textTrimmed().isEqualTo(MeinKabelTVParagraphCL).perform();
        return this;
    }

    @Step("Validate Campaign Details")
    public KabelTVPage validateCampaignDetails(){
        driver.verifyThat().element(MeinKabelTVText).textTrimmed().isEqualTo(MeinKabelTVTextCL).perform();
        driver.verifyThat().element(MeinKabelTVTessar).exists().perform();
        driver.verifyThat().element(TessarToOfferCTA).textTrimmed().isEqualTo(TessarToOfferCTACL).perform();
        return this;
    }

    @Step("Validate Access Name and USPs card")
    public KabelTVPage validateAccessNameAndUSPsCard(){
        driver.verifyThat().element(AccessNameAndUSPsHeadline).textTrimmed().isEqualTo(AccessNameAndUSPsHeadlineCL).perform();
        driver.verifyThat().element(AccessNameAndUSPsBulletPoint).exists().perform();
        driver.verifyThat().element(AccessNameAndUSPsFeatureOne).textTrimmed().isEqualTo(AccessNameAndUSPsFeatureOneCL).perform();
        return this;
    }

    @Step("Validate Access Name and USPs card in case of no tariff with renter user")
    public KabelTVPage validateAccessNameAndUSPsCardNoTariffRenter(){
        driver.verifyThat().element(AccessNameAndUSPsHeadline).textTrimmed().isEqualTo(AccessNameAndUSPsHeaderRenterNoTariffCL).perform();
        driver.verifyThat().element(AccessNameAndUSPsBulletPoint).exists().perform();
        driver.verifyThat().element(AccessNameAndUSPsFeatureOne).textTrimmed().isEqualTo(AccessNameAndUSPsFeatureOneRenterCL).perform();
        return this;
    }

    @Step("Validate Contract Details in case of Self-Payer")
    public KabelTVPage validateContractDetailsSelfPayer(){
        driver.verifyThat().element(ContractDetailsHeadline).textTrimmed().isEqualTo(ContractDetailsHeadlineCL).perform();
        driver.verifyThat().element(ContractDetailsBasicPrice).textTrimmed().isEqualTo(ContractDetailsBasicPriceCL).perform();
        driver.verifyThat().element(ContractDetailsContractNumber).textTrimmed().isEqualTo(ContractDetailsContractNumberCL).perform();
        driver.verifyThat().element(ContractDetailsStartDate).textTrimmed().isEqualTo(ContractDetailsStartDateCL).perform();
        driver.verifyThat().element(ContractDetailsEndDate).textTrimmed().isEqualTo(ContractDetailsEndDateCL).perform();
        driver.verifyThat().element(ContractDetailsCancellationDate).textTrimmed().isEqualTo(ContractDetailsCancellationDateCL).perform();
        driver.verifyThat().element(ContractDetailsCancellationLink).textTrimmed().isEqualTo(ContractDetailsCancellationLinkCL).perform();
        return this;
    }

    @Step("Validate Contract Details in case of Renter")
    public KabelTVPage validateContractDetailsRenter(){
        driver.verifyThat().element(ContractDetailsHeadline).textTrimmed().isEqualTo(ContractDetailsHeadlineCL).perform();
        driver.verifyThat().element(ContractDetailsStartDate).textTrimmed().isEqualTo(ContractDetailsStartDateCL).perform();
        driver.verifyThat().element(ContarctDetailsStartDateDate).textTrimmed().isEqualTo(ContarctDetailsStartDateDateCL).perform();
        return this;
    }

    @Step("Validate Mein Daten Link CL")
    public KabelTVPage validateMeinDatenLinkCL(){
        driver.assertThat().element(MeinDatenLink).textTrimmed().isEqualTo(MeinDatenLinkCL).perform();
        return this;
    }

    @Step("Validate Kabel Internet And Phone Link CL")
    public KabelTVPage validateKabelInternetAndPhoneLinkCL(){
        driver.assertThat().element(KabelInternetFestnetzLink).textTrimmed().isEqualTo(KabelInternetFestnetzLinkCL).perform();
        return this;
    }

    @Step("Validate No Tariff Image")
    public KabelTVPage validateNoTariffImg(){
        driver.verifyThat().element(NoTariffImg).exists().perform();
        return this;
    }

    @Step("Validate No Tariff Headline")
    public KabelTVPage validateNoTariffHeadline(){
        driver.assertThat().element(NoTariffHeadline).textTrimmed().isEqualTo(NoTariffHeadlineCL).perform();
        return this;
    }

    @Step("Validate No Tariff Subline")
    public KabelTVPage validateNoTariffSubLine(){
        driver.assertThat().element(NoTariffSubLine).textTrimmed().isEqualTo(NoTariffSubLineCL).perform();
        return this;
    }

    @Step("Validate No Tariff CTA")
    public KabelTVPage validateNoTariffCTA(){
        driver.assertThat().element(NoTariffCTA).textTrimmed().isEqualTo(NoTariffCTACL).perform();
        return this;
    }

    @Step("Validate cross links order")
    public KabelTVPage validateCrossLinksInTVTariffPage(){
        driver.verifyThat().element(meinKabelTVAcc).exists().perform();
        driver.verifyThat().element(meinDatenPageCrossLink).textTrimmed().isEqualTo(MeinDatenPageCrossLinkCL).perform();
        driver.verifyThat().element(kipPageCrossLink).textTrimmed().isEqualTo(KIPPageCrossLinkCL).perform();
        return this;
    }

    @Step("Got to TV product page from Cross link")
    public KabelTVPage navigateToKIPProductPageFromCrossLink(){
        driver.element().click(kipPageCrossLink);
        return this;
    }

    @Step("Assert that MBOX_ID doesn't exists")
    public KabelTVPage assertOnTeaserDoesNotExistsInTVPage(){
        driver.verifyThat().element(mbox_ID).doesNotExist().perform();
        driver.verifyThat().element(mbox_button).doesNotExist().perform();
        return this;
    }

    @Step("Validate Cancellation Notification Card")
    public KabelTVPage validateCancellationNotificationCard(){
        driver.verifyThat().element(CancellationNotificationCardBookedOption).exists().perform();
        driver.verifyThat().element(CancellationNotificationBody).textTrimmed().isEqualTo(CancellationNotificationBodyCL).perform();
        driver.verifyThat().element(CancellationNotificationHotline).textTrimmed().isEqualTo(CancellationNotificationHotlineCL).perform();
        return this;
    }

    @Step("Validate that Mein Tariff accordion is expanded")
    public KabelTVPage validateMeinTariffAccordionExpanded(){
        driver.verifyThat().element(ContractDetailsCard).exists().perform();
        return this;
    }

    @Step("Validate Booked Option Negative Price in Kabel TV")
    public KabelTVPage validateBookedOptionNegativePriceTV(){
        driver.verifyThat().element(BookedOptionNegativePrice).textTrimmed().isEqualTo(BookedOptionNegativePriceCL).perform();
        driver.verifyThat().element(BookedOptionCurrency).textTrimmed().isEqualTo(bookedOptionCurrencyCL).perform();
        driver.verifyThat().element(BookedOptionNegativePriceText).textTrimmed().isEqualTo(BookedOptionNegativePriceTextCL).perform();
        return this;
    }

    @Step("Validate the two smartcards")
    public KabelTVPage validateTheTwoSmartcards(String CancellationOptionWithFirstSmartCardHeadlineCL,String CancellationBookedOptionHeadlineCL,String CancellationBookedOptionSubHeadlineCL,String CancellationOptionWithSecondSmartCardHeadlineCL){
        driver.verifyThat().element(cancellationOptionWithFirstSmartCardHeadline).textTrimmed().contains(CancellationOptionWithFirstSmartCardHeadlineCL).perform();
        driver.verifyThat().element(cancellationBookedOptionHeadline).textTrimmed().isEqualTo(CancellationBookedOptionHeadlineCL).perform();
        driver.verifyThat().element(cancellationBookedOptionSubHeadline).textTrimmed().isEqualTo(CancellationBookedOptionSubHeadlineCL).perform();
        return this;
    }

    @Step("Validate Booked Option Accordion Cancellation")
    public KabelTVPage validateBookedOptionAccordionCancellation(String CancellationBookedOptionHeadlineCL,String CancellationBookedOptionSubHeadlineCL){
        driver.verifyThat().element(cancellationBookedOptionHeadline).textTrimmed().isEqualTo(CancellationBookedOptionHeadlineCL).perform();
        driver.verifyThat().element(cancellationBookedOptionSubHeadline).textTrimmed().isEqualTo(CancellationBookedOptionSubHeadlineCL).perform();
        return this;
    }

    @Step("Expand Booked option Accordion")
    public KabelTVPage expandBookedOptionAcc() {
        driver.element().click(bookedOptionAccordion);
        return this;
    }
    @Step("click on the DropdownList")
    public KabelTVPage clickOnDropDownAndChooseSecondContactID(){
        driver.element().click(dropDownList);
        driver.element().click(secondContactID);
        return this;
    }

    @Step("Validate Booked Option with Price in Kabel-TV")
    public KabelTVPage validateBookedOptionWithPrice() {
        driver.verifyThat().element(bookedOptionPrice).textTrimmed().isEqualTo(bookedOptionPriceCL).perform();
        driver.verifyThat().element(bookedOptionPriceCurrency).textTrimmed().isEqualTo(bookedOptionCurrencyCL).perform();
        driver.verifyThat().element(bookedOptionPricePerMonth).textTrimmed().isEqualTo(bookedOptionPricePerMonthCL).perform();
        driver.verifyThat().element(bookedOptionDetailsLink).isEnabled().perform();
        driver.verifyThat().element(bookedOptionPrice_CancelBtn).isEnabled().perform();
        driver.verifyThat().element(bookedOptionPrice_CancelBtn).textTrimmed().isEqualTo(bookedOptionCancelBtnCL).perform();
        return this;
    }

    @Step("Validate Booked Option Card For Free in Kabel-TV")
    public KabelTVPage validateBookedOptionForFree(){
        driver.verifyThat().element(bookedOptionFree_Name).textTrimmed().isEqualTo(bookedOptionFree_NameCL).perform();
        driver.verifyThat().element(bookedOptionFree_Text).textTrimmed().isEqualTo(bookedOptionFree_TextCL).perform();
        return this;
    }

    @Step("Validate Booked Option Card Not cancellable in Kabel-TV")
    public KabelTVPage validateBookedOptionNotCancellable() {
        driver.verifyThat().element(bookedOptionNotCancellablePrice).textTrimmed().isEqualTo(bookedOptionNotCancellablePriceCL).perform();
        driver.verifyThat().element(bookedOptionNotCancellable_CurrencyTV).textTrimmed().isEqualTo(bookedOptionCurrencyCL).perform();
        driver.verifyThat().element(bookedOptionNotCancellable_PermonthTV).textTrimmed().isEqualTo(bookedOptionPricePerMonthCL).perform();
        driver.verifyThat().element(bookedOptionNotCancellable_NotificationTV).textTrimmed().isEqualTo(bookedOptionNotCancellable_NotificationTVCL).perform();
        return this;
    }

    @Step("Validate Booked Option Card's Negative Price in Kabel TV")
    public KabelTVPage validateBookedOptionNegativePriceKabelTV(String bookedOptionNegativePriceTVCL, String bookedOptionCurrencyCL, String bookedOptionNegativePriceTextTVCL, String bookedOptionNegativePriceNotificationTVCL){
        driver.verifyThat().element(bookedOptionNegativePriceTV).textTrimmed().isEqualTo(bookedOptionNegativePriceTVCL).perform();
        driver.verifyThat().element(bookedOptionNegative_CurrencyTV).textTrimmed().isEqualTo(bookedOptionCurrencyCL).perform();
        driver.verifyThat().element(bookedOptionNegativePriceTextTV).textTrimmed().isEqualTo(bookedOptionNegativePriceTextTVCL).perform();
        driver.verifyThat().element(bookedOptionNegativePriceNotificationTV).textTrimmed().isEqualTo(bookedOptionNegativePriceNotificationTVCL).perform();
        return this;
    }

    @Step("Validate that cancellation button is dimmed in case messing email")
    public KabelTVPage validateCanellationBtnDimmed(){
        driver.verifyThat().element(firstBookedOptionWithSmartCard).isVisible().perform();
        driver.verifyThat().element(cancellationBtnDimmed).attribute("class").contains("dimmed-opacity").perform();
        return this;
    }

    @Step("Validate that Missing Email CTA btn redirects right")
    public KabelTVPage validateMissingEmailBtnRedirection () {
        driver.assertThat().browser().url().matchesRegex(System.getProperty("de.vodafone.baseUrl.st")+ missingEmailRedirection);
        return this;
    }

    @Step("Validate failure view of booked option")
    public KabelTVPage validateThatBookedOptionFailed() {
        driver.verifyThat().element(kabelTV_pageSubtitle).textTrimmed().isEqualTo(kabelTV_pageSubtitle_CL).perform();
        driver.verifyThat().element(kabelTV_FailureMessage_Title).textTrimmed().isEqualTo(NotificationErrorHeaderCL).perform();
        driver.verifyThat().element(kabelTV_FailureMessage_Body).textTrimmed().isEqualTo(NotificationErrorTextCL).perform();
        return this;
    }

    @Step("Validate that details link redirects to the right link")
    public KabelTVPage validateRedirectionofDetailsLink() {
        driver.assertThat().browser().url().matchesRegex(externalDetailsPage);
        return this;
    }

    @Step("click on Details link")
    public KabelTVPage clickOnDetailsLink() {
        driver.element().doubleClick(bookedOptionDetailsLink);
        return this;
    }

    @Step("click on Add Email Address")
    public KabelTVPage clickOnAddEmailAddress() {
        driver.assertThat().element(addEmailAddressBtn).isEnabled().perform();
        driver.element().click(addEmailAddressBtn);
        return this;
    }

    @Step("Validate One SmartCard name and number for kabel tv")
    public KabelTVPage validateOneSmartCardForTV(String OneSmartCardNameTVCL,String OneSmartCardNumberTVCL){
        driver.assertThat().element(OneSmartCardNameTV).textTrimmed().isEqualTo(OneSmartCardNameTVCL).perform();
        driver.assertThat().element(OneSmartCardNumberTV).textTrimmed().isEqualTo(OneSmartCardNumberTVCL).perform();
        return this;
    }

    @Step("validate the teaser of CLS Tariff")
    public KabelTVPage validateCLSTeaser(String clsTeaserHeader_CL , String clsTeaserTitle_CL , String clsTeaserText_CL) {
        driver.verifyThat().element(clsTeaser_Header).textTrimmed().isEqualTo(clsTeaserHeader_CL);
        driver.verifyThat().element(clsTeaserTitle).textTrimmed().isEqualTo(clsTeaserTitle_CL);
        driver.verifyThat().element(clsTeaserText).textTrimmed().isEqualTo(clsTeaserText_CL);
        driver.verifyThat().element(clsTeaserBtn).exists();
        return this;
    }

    @Step("validate the view of Mein Tariff only when user has a CLS and Mein Tariff")
    public KabelTVPage validateViewOfMeinTariffOnly(String firstTariffMeinTariff, String makeMoreQuestion) {
        driver.verifyThat().element(firstTariffName).textTrimmed().isEqualTo(firstTariffMeinTariff);
        driver.verifyThat().element(tariffDetailsBox).exists();
        driver.verifyThat().element(forMoreQuestion).textTrimmed().isEqualTo(makeMoreQuestion);
        return this;
    }

    @Step("Validate on Cancellation pending notification message")
    public KabelTVPage validateCancellationPending(String CancellationPendingMessage){
        driver.assertThat().element(CancellationPendingNotification).textTrimmed().isEqualTo(CancellationPendingMessage).perform();
        return this;
    }

    @Step("Validate header and subtitle in booked option accordion")
    public KabelTVPage validateHeaderAndSubtitleBookedOptionsAcc(String BookedOptionsHeaderCL,String BookedOptionsSubLineCL){
        driver.element().waitToBeReady(bookedOptionHeadlineF);
        driver.verifyThat().element(bookedOptionHeadlineF).textTrimmed().isEqualTo(BookedOptionsHeaderCL).perform();
        driver.verifyThat().element(bookedOptionSubLineF).textTrimmed().isEqualTo(BookedOptionsSubLineCL).perform();
        return this;
    }

    @Step("Validate header of first booked option in booked options accordion")
    public KabelTVPage validateHeaderOfFirstBookedOption(String HeaderOfFirstBookedOptionCL){
        driver.verifyThat().element(HeaderOfFirstBookedOption).textTrimmed().isEqualTo(HeaderOfFirstBookedOptionCL).perform();
        return this;
    }

    @Step("Validate header and subline in case user has only one tariff has booked options")
    public KabelTVPage validateHeaderAndSubLineOneTariffOnly(String OneTariffBookedOptionsHeaderCL, String OneTariffBookedOptionsSubLineCL){
        driver.verifyThat().element(OneTariffBookedOptionsHeader).textTrimmed().contains(OneTariffBookedOptionsHeaderCL).perform();
        driver.verifyThat().element(OneTariffBookedOptionsSubLine).textTrimmed().isEqualTo(OneTariffBookedOptionsSubLineCL).perform();
        return this;
    }

    @Step("Validate cancellation notification msg body in main tariff smart object")
    public KabelTVPage validateCancellationMSGBodyMainTariffSO(String CancellationNotificationBodySOCL){
       driver.verifyThat().element(meinTarifSO).exists().perform();
        driver.verifyThat().element(CancellationNotificationBodySO).textTrimmed().isEqualTo(CancellationNotificationBodySOCL).perform();
        return this;
    }

    @Step("Validate Cancellation notification First msg body in main tariff accordion")
    public KabelTVPage validateCancellationFirstMSGBodyMainTariffAcc(String CancellationNotificationBodyMainTariffAccCL){
        driver.verifyThat().element(CancellationNotificationFirstBodyMainTariffAcc).textTrimmed().contains(CancellationNotificationBodyMainTariffAccCL).perform();
        return this;
    }

    @Step("Validate Contract card details when tariff is cancelled")
    public KabelTVPage validateContractDetailsCardCancelledTariff(String ContractEndDateLabelCL
            , String CancelledContractFirstHintCL, String CancelledContractSecondHintCL
            , String BillSectionHyperLinkCL, String GoToBookedOptionsAccCTACL){
        driver.verifyThat().element(ContractEndDateLabel).textTrimmed().isEqualTo(ContractEndDateLabelCL).perform();
        driver.verifyThat().element(CancelledContractFirstHint).textTrimmed().isEqualTo(CancelledContractFirstHintCL).perform();
        driver.verifyThat().element(CancelledContractSecondHint).textTrimmed().isEqualTo(CancelledContractSecondHintCL).perform();
        driver.verifyThat().element(BillSectionHyperLink).textTrimmed().isEqualTo(BillSectionHyperLinkCL).perform();
        driver.verifyThat().element(GoToBookedOptionsAccCTA).textTrimmed().isEqualTo(GoToBookedOptionsAccCTACL).perform();
        return this;
    }

    @Step("Validate Main tariff name smart object")
    public KabelTVPage validateMainTariffNameSO(String MainTariffNameSOCL){
        driver.verifyThat().element(MainTariffNameSO).text().isEqualTo(MainTariffNameSOCL).perform();
        return this;
    }

    @Step("Validate Cancellation notification Second msg body in main tariff accordion")
    public KabelTVPage validateCancellationSecondMSGBodyMainTariffAcc(String CancellationNotificationBodyMainTariffAccCL){
        driver.verifyThat().element(CancellationNotificationSecondBodyMainTariffAcc).text().contains(CancellationNotificationBodyMainTariffAccCL).perform();
        return this;
    }

    @Step("Validate Bookable Accordion Title")
    public KabelTVPage validateBookableAccordionTitle(String BookableAccordionTitleCL){
        driver.verifyThat().element(BookableAccordionTitle).textTrimmed().isEqualTo(BookableAccordionTitleCL).perform();
        return this;
    }
}