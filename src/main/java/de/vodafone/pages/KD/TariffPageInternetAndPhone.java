package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TariffPageInternetAndPhone {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Element Locators
    private By page_Header = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By bookedOptionsAccordion = By.xpath("//li[@automation-id='bookedTarif_acc']");
    private By bookedOptionsHeader = By.xpath("//h3[@automation-id='bookedOptionsHeadline_tv']");
    private By bookedOptionsSubline = By.xpath("//p[@automation-id='bookedOptionsSubHeadline_tv']");
    private By BookedOptionsCard = By.xpath("(//*[@automation-id='bookedOptions_tv']//extra-tiles)[4]");
    private By BookedOptionsCardName = By.xpath("(//*[@automation-id='bookedOption_31_tile']//span)[1]");
    private By BookedOptionsCardPrice = By.xpath("(//*[@class='extras-card-price'])[4]");
    private By BookedOptionsCardDescription = By.xpath("//*[@class='price-information']");
    private By BookedOptionsCardDetailsButton = By.xpath("//*[@class='extras-card-details']//a");
    private By MyTariffSOLocator = By.xpath("//*[@automation-id='cableIpTariffSO_so']");
    private By MyTariffTitleSoLocator = By.xpath("//div[@automation-id='cableIpTariffSO_so']//h3");
    private By MyTariffTextSoLocator = By.xpath("(//*[@automation-id='tarifName_tv'])");
    private By MyTariffDateSO = By.xpath("(//div[@automation-id='cableIpTariffSO_so']//div)[4]");
    private By ExpandedMyTariffAccordionIndicator = By.xpath("(//a[@class='ac-head ac-active']//div//*[name()='svg'])[2]");
    private By MyTariffTitleAccLocator = By.xpath("//*[@automation-id='meinTarif_acc']//h4");
    private By tarifUSPShown = By.xpath("//div[@automation-id='productFeatures_tv']");
    private By MyTarifAccTitle = By.xpath("(//*[@automation-id='meinTarif_acc']//h4)[1]");
    private By MyTariffTextAccLocator = By.xpath("//*[@automation-id='meinTarif_acc']//h5");
    private By TariffPageContainerLocator = By.xpath("//*[@id='content']");
    private By MyBookedOptionsTitleSoLocator = By.xpath("//*[@automation-id='ipBookedTariffSO_so']//h3");
    private By MyBookedOptionsTextSoLocator = By.xpath("(//*[@automation-id='ipBookedTariffSO_so']//div)[5]");
    private By MyBookedOptionsLocator = By.xpath("//div[@automation-id='ipBookedTariffSO_so']");
    private By MyBookedOptionsTitleAccLocator = By.xpath("//*[@automation-id='bookedTarif_acc']//h4");
    private By MyBookedOptionsTextAccLocator = By.xpath("//*[@automation-id='bookedTarif_acc']//h5");
    private By MyInternetBookableOptionsAccordion = By.xpath("//li[@automation-id='internetBookableOptions_acc']");
    private By MyInternetBookableOptionsTitleSoLocator = By.xpath("//*[@automation-id='bookableOptionsInternetSO_so']//h3");
    private By MyInternetBookableOptionsTextSoLocator = By.xpath("(//*[@automation-id='bookableOptionsInternetSO_so']//div)[5]");
    private By MyBookableInternetOptionsSOLocator = By.xpath("//*[@automation-id='bookableOptionsInternetSO_so']");
    private By MyInternetBookableOptionsTitleAccLocator = By.xpath("//*[@automation-id='internetBookableOptions_acc']//h4");
    private By MyInternetBookableOptionsTextAccLocator = By.xpath("//*[@automation-id='internetBookableOptions_acc']//h5");
    private By MyPhoneBookableOptionsAccordion = By.xpath("(//li[@automation-id='phoneBookableOptions_acc'])");
    private By MyPhoneBookableOptionsTitleSoLocator = By.xpath("//*[@automation-id='bookableOptionsPhoneSO_so']//h3");
    private By MyPhoneBookableOptionsTextSoLocator = By.xpath("(//*[@automation-id='bookableOptionsPhoneSO_so']//div)[5]");
    private By MyBookablePhoneOptionsLocator = By.xpath("//div[@automation-id='bookableOptionsPhoneSO_so']");
    private By MyPhoneBookableOptionsTitleAccLocator = By.xpath("(//li[@automation-id='phoneBookableOptions_acc']//h4)[1]");
    private By MyPhoneBookableOptionsTextAccLocator = By.xpath("//*[@automation-id='phoneBookableOptions_acc']//h5");
    private By NoBookedOptionHeadline = By.xpath("//*[@automation-id='noBookedOptions_nt']//h4");
    private By NoBookedOptionSubLine = By.xpath("//*[@automation-id='noBookedOptions_nt']//p");
    private By NoBookableInternetOptionLabelLocator = By.xpath("(//div[@automation-id='successMsg_tv']//h4)[1]");
    private By NoBookableInternetOptionTextLocator = By.xpath("(//div[@automation-id='successMsg_tv']//p)[1]");
    private By NoBookableInternetOptionCTALocator = By.xpath("(//div[@automation-id='successMsg_tv']//span)[1]");
    private By NoBookablePhoneOptionLabelLocator = By.xpath("//*[@automation-id='successMsg_tv']//h4");
    private By NoBookablePhoneOptionTextLocator = By.xpath("(//*[@automation-id='successMsg_tv']//p)[2]");
    private By NoBookablePhoneOptionTextLocator2 = By.xpath("//*[@automation-id='successMsg_tv']//p");
    private By cardExist = By.xpath("(//span[@automation-id='bookedOption_31_tile'])");
    private By CancellationNotificationCardBookedOption = By.xpath("(//div[@automation-id='undefined_nt'])[1]");
    private By CancellationNotificationBody = By.xpath("(//h4[@class='flexDiv'])[1]");
    private By BookNowInternetFirstFreeOptionCTA = By.xpath("//a[@class='btn btn-sml' and contains(.,'Jetzt kostenlos buchen')]");
    private By BookNowInternetFirstOptionCTA = By.xpath("//a[@class='btn btn-sml' and contains (.,'Jetzt buchen')]");
    private By BookNowInternetSecondOptionCTA = By.xpath("(//div[@class='extras-card-button']/a)[2]");
    private By BookNowPhoneFirstOptionCTA = By.xpath("(//div[@class='extras-card-button']/a)[1]");
    private By BookNowPhoneSecondOptionCTA = By.xpath("(//div[@class='extras-card-button']/a)[2]");
    private By BookExternalOptionCTA = By.xpath("(//div[@class='extras-card-button']/a)[1]");
    private By BookNowCTAMissed = By.xpath("(//a[@class='btn btn-sml'])[2]");
    private By MeinTariffAccordion = By.xpath("//li[@automation-id='meinTarif_acc']");
    private By BookableInternetOptionsAccordionHeader = By.xpath("//li[@automation-id='internetBookableOptions_acc']//h4");
    private By OneTimePaymentOptionCard = By.xpath("(//div[@class='tariff-card-wrapper'])[5]");
    private By OneTimePaymentOptionCardName = By.xpath("(//div[@class='tariff-card-header']//span)[5]");
    private By OneTimePaymentOptionCardPrice = By.xpath("(//div[@class='tariffPrice'])[5]");
    private By OneTimePaymentOptionCardStatement = By.xpath("(//div[@class='price-information'])[5]");
    private By OneTimePaymentOptionCardDescription = By.xpath("(//div[@class='short-description']//p)[4]");
    private By OneTimePaymentOptionCardBookCTA = By.xpath("(//a[@class='btn btn-sml'])[5]");
    private By TVPageCrossLink = By.xpath("(//span[@class='verticalAlign-super' and contains(.,'Kabel-TV - Tarif')])");
    private By MeinDatenPageCrossLink = By.xpath("(//span[@class='verticalAlign-super' and contains(.,'Meine Daten')])");
    private By MBOX_ID = By.xpath("(//img[@class=\"only-lrg\"])[3]");
    private By MBOX_button = By.xpath("(//button[@class='btn btn-sml'])[2]");
    private By TariffChangeHeaderInMeinTariffAccordion = By.xpath("//h3[@automation-id='cableMeinTarifText_tv' and contains(.,' Du willst einen neuen Tarif? ')]");
    private By BookedOptionNegativePrice = By.xpath("//div[@class='secodary-green']//span[1]");
    private By BookedOptionCurrency = By.xpath("//div[@class='secodary-green']//span[2]");
    private By BookedOptionNegativePriceText = By.xpath("//div[@class='secodary-green']//span[3]");
    private By kipNextSOButton = By.xpath("(//a[@class='bx-next'])");
    private By WLANHotspotSOLocator = By.xpath("//div[@automation-id='WLANHotspotLoginsSO_so']");
    private By TariffChangeSOTitle = By.xpath("//div[@automation-id='TarifWechselnSO_so']//h3");
    private By TariffChangeSOBody = By.xpath("//div[@automation-id='TarifWechselnSO_so']//div[@class='sb-block-footer']");
    private By WLANHotspotSOTitle = By.xpath("//div[@automation-id='WLANHotspotLoginsSO_so']//h3");
    private By WLANHotspotSOBody = By.xpath("//div[@automation-id='WLANHotspotLoginsSO_so']//div[@class='sb-block-footer']");
    private By tarifChangeHiddenCase = By.xpath("(//div[@class='bx-wrapper']//div)[12]");
    private By TariffChangeSOLocator = By.xpath("//smart-object[@type='tarifwechselnso']");
    private By GigaZuHauseCabelMaxTariffChange = By.xpath("//li[@class='tariff-box active-tariff']");
    private By GigaZuhauseCabelMaxName = By.xpath("//li[@class='tariff-box active-tariff']//span");
    private By GigaZuhause1000MainTariff = By.xpath("//span[@automation-id='cardHeader_tv']");
    private By securityPackageSO = By.xpath("//div[@automation-id='ipSecurityPackageSO_so']");
    private By securityPackageAcc = By.xpath("//accordion[@automation-id='securityPackage_acc']");
    private By securityPackageSOIcon = By.xpath("(//*[@automation-id='ipSecurityPackageSO_so']//div)[4]");
    private By securityPackageSOHeader = By.xpath("//div[@automation-id='ipSecurityPackageSO_so']//h3");
    private By securityPackageSOFooter = By.xpath("//div[@automation-id='ipSecurityPackageSO_so']//div[@class='sb-block-footer']");
    private By securityPackageAccordion = By.xpath("//div[@automation-id='ipSecurityPackageSO_so']");
    private By securityPackageAccordionIcon = By.xpath("//*[@class='ac-icon i-security-pc-sml i-sml']");
    private By securityPackageAccordionHeader = By.xpath("//*[@automation-id='securityPackage_acc']//h4");
    private By securityPackageAccordionSubHeader = By.xpath("//*[@automation-id='securityPackage_acc']//h5");
    private By notBookedSecurityPackageHeadline = By.xpath("//h3[@automation-id='bookableOptionsHeadline_tv']");
    private By notBookedSecurityPackageBodyImage = By.xpath("(//img[@automation-id='undefined_img'])[1]");
    private By notBookedSecurityPackageImageHeader = By.xpath("//h3[@automation-id='undefined_tv']");
    private By notBookedSecurityPackageImageText = By.xpath("//p[@automation-id='undefined_tv']");
    private By notBookedSecurityPackageCTA = By.xpath("//a[@automation-id='undefined_btn']//span");
    private By ineligibleSecurityPackageHeader = By.xpath("//*[@automation-id='successMsg_tv']//h4");
    private By ineligibleSecurityPackageText = By.xpath("//*[@automation-id='successMsg_tv']//p");
    private By ineligibleSecurityPackageCTA = By.xpath("(//*[@automation-id='noBookedOptions_btn'])[1]");
    private By bookedSecurityPackageHeadline = By.xpath("//h3[@automation-id='bookedSecurityPackage_headline_tv']");
    private By bookedSecurityPackageNotificationHeader = By.xpath("//*[@id='securityPackageId']//h4");
    private By bookedSecurityPackageNotificationText = By.xpath("//p[@automation-id='bookedSecurityPackage_downloadSteps_tv']");
    private By bookedSecurityPackageNotificationCTA = By.xpath("//a[@automation-id='downloadButton_btn']");
    private By inventoryBEErrorMessageHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By inventoryBEErrorMessageText = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By availabilityBEErrorMessageHeader = By.xpath("//*[@automation-id='successMsg_tv']//h4");
    private By availabilityBEErrorMessageText = By.xpath("//*[@automation-id='successMsg_tv']//p");
    private By CancellationPendingNotification = By.xpath("(//div[@automation-id='undefined_nt']//h4[@class='flexDiv'])[1]");
    //WFBT_12465
    private By promoBadge = By.xpath("//span[@class='promo-badge']");
    //WFBT_12347's locators
    private By firstTariff_Name = By.xpath("//span[@automation-id='cardHeader_tv']");
    private By secondTariff_Name = By.xpath("//span[@automation-id='cardHeader_tv' and contains (text(),'Basic TV')");
    private By secondTariff_ID = By.xpath("//h3[@automation-id='cableMeinTarifText_tv' and contains(text(),'972510527')]");
    private By meinTariffOnly_DetailsBox = By.xpath("//div[@class='white-box tarrifDetails w-66 col']");
    private By meinTariff_ChangeQuestion = By.xpath("//h3[@automation-id='cableMeinTarifText_tv' and contains (text(),'Du willst')]");
    private By clsTariffOnly_FirstDate = By.xpath(".//span[@automation-id='productPriceLabel_tv']");
    private By makeMore_Question = By.xpath("//h3[@automation-id='cableMeinTarifText_tv' and contains (text(),'Mach')");
    private By cancellationMessageMainTarifSO = By.xpath("//div[@automation-id='cableIpTariffSO_so']//p");
    private By CancellationMSGMainTarifAccordionHeader = By.xpath("(//div[@automation-id='successMsg_tv']//h4)[1]");
    private By CancellationMSGMainTarifAccordionBody = By.xpath("(//div[@automation-id='successMsg_tv']//p)[1]");
    private By CancellationMSGMainTarifAccordionHeaderSec = By.xpath("(//div[@automation-id='successMsg_tv']//h4)[2]");
    private By CancellationMSGMainTarifAccordionBodySec = By.xpath("(//div[@automation-id='successMsg_tv']//p)[2]");
    private By ActiveTariffHeader = By.xpath("(//h3[@automation-id='cableMeinTarifText_tv'])[2]");
    private By MainTariffSOName = By.xpath("//h4[@automation-id='tarifName_tv']");
    private By MainTariffSODate = By.xpath("(//div[@automation-id='cableIpTariffSO_so']//div)[4]");
    private By CancelContractHint = By.xpath("(//span[@automation-id='canceledContractHint_tv'])[1]");
    private By ContractEndDateContractDetails = By.xpath("(//span[@automation-id='contractEndDateLable_tv'])[1]");
    private By CancelContractHintSec = By.xpath("(//span[@automation-id='canceledContractHint_tv'])[2]");
    private By BillSectionCurrentPrice = By.xpath("(//span[@automation-id='canceledContractHint_tv'])[2]//a");
    private By GoToBookedOptionsAccordionCTA = By.xpath("//a[@automation-id='goToBookedOptions_btn']");
    private By BookableDropdownMenuInternet = By.xpath("(//button[@automation-id='smartCardsDropdown_btn'])[1]");
    private By MainTariffCancellationMessageCard = By.xpath("//div[@automation-id='warningNotification_nt']");
    private By contractNum = By.xpath("(//button[@automation-id='smartCardsDropdown_btn']//div)[2]");
    private By MainTariffCancellationMessageHeader = By.xpath("(//div[@automation-id='successMsg_tv']//h4)[2]");
    private By MainTariffCancellationMessageBody = By.xpath("(//div[@automation-id='successMsg_tv']//p)[2]");
    private By ContractIDDropdownMenuBookableInternet = By.xpath("(//ul[@automation-id='smartCardsDropdown_lv'])//li[2]");
    private By bookedOptionsAccordionBodyHeader = By.xpath("//h3[@automation-id='bookedOptionsHeadline_tv']");
    private By bookedOptionsAccordionBodySubHeader = By.xpath("//p[@automation-id='bookedOptionsSubHeadline_tv']");
    private By defaultContractHeader = By.xpath("(//button[@automation-id='bookedOptionsDropdown_btn']//div)[1]");
    private By defaultContractNumber = By.xpath("(//button[@automation-id='bookedOptionsDropdown_btn']//div)[2]");
    private By defaultContractIcon = By.xpath("(//*[@class='i-sml dropdown-icon'])[1]");
    private By bookedOptionsDropDownMenu = By.xpath("//ul[@automation-id='bookedOptionsDropdown_lv']//li");
    private By bookedOptionsDropDownMenuElement = By.xpath("//ul[@automation-id='bookedOptionsDropdown_lv']//button");
    private By contract1Number = By.xpath("//button[text()='972510524']");
    private By contract2Number = By.xpath("//button[text()='972510525']");
    private By contract3Number = By.xpath("//button[text()='972510526']");
    private By contract4Number = By.xpath("//button[text()='972510527']");
    private By contract1CLS = By.xpath("//button[text()='972510530']");
    private By contract2CLS = By.xpath("//button[text()='972510531']");
    private By contract3CLS = By.xpath("//button[text()='972510532']");
    private By contract1KIP = By.xpath("//button[text()='972510540']");
    private By contract2KIP = By.xpath("//button[text()='972510541']");
    private By contract3KIP = By.xpath("//button[text()='972510542']");
    private By dropDownMenuOptionCard = By.xpath("//extra-tiles[@class='extras-card']");
    private By dropDownMenuOptionCardName = By.xpath("//extra-tiles[@class='extras-card']//span[@class='h2']");
    private By KIPOptionCardName = By.xpath("(//extra-tiles[@class='extras-card']//span[@class='h2'])[2]");
    private By CLSOptionCardName = By.xpath("(//extra-tiles[@class='extras-card']//span[@class='h2'])[2]");
    private By onlineCancelableBookedOptionCTA = By.xpath("//a[@class='btn btn-sml btn-alt' and contains (.,' Option kündigen')]");
    private By changeTarifBoxText = By.xpath("//div[@id='availableTariffBlock']//a//span");
    //CLs
    private String pageHeader_CL = "Internet & Festnetz – Tarif";
    private String bookedOptionsHeaderCL = "Deine gebuchten Optionen";
    private String bookedOptionsSublineCL = "Diese Optionen ergänzen Deinen Tarif im Moment. Du willst etwas ändern? Hier siehst Du, wann Du eine Option kündigen kannst:";
    private String MyTariffTitleCL = "Mein Tarif";
    private String MyTariffTextSoCL = "Red Internet & Phone 250 Cable";
    private String MyTariffTextAccCL = "Laufzeit und Vertragsverlängerung";
    private String NoBookedOptionsLabelCL = "Option dazubuchen";
    private String MyBookableInternetOptionsTextCL = "Wende Dich bitte an den Support. Du erreichst uns montags bis freitags von 8 bis 20 Uhr und samstags von 9 bis 18 Uhr, kostenlos aus allen deutschen Netzen.";
    private String MyBookablePhoneOptionsTextCL = "Wende Dich bitte an den Support. Du erreichst uns montags bis freitags von 8 bis 20 Uhr und samstags von 9 bis 18 Uhr, kostenlos aus allen deutschen Netzen.";
    private String MyBookedOptionsTitleCL = "Gebuchte Optionen";
    private String MyBookedOptionsTextSoCL = "Alle gebuchten Tarifoptionen";
    private String MyBookedOptionsTextAccCL = "Ansehen und bearbeiten";
    private String MyInternetBookableOptionsTitleCL = "Buchbare Optionen Internet";
    private String MyInternetBookableOptionsTextCL = "Alle buchbaren Optionen für meinen Internet-Tarif";
    private String MyPhoneBookableOptionsTitleCL = "Buchbare Optionen Telefon";
    private String MyPhoneBookableOptionsTextCL = "Alle buchbaren Optionen für meinen Telefon-Tarif";
    private String NoBookedOptionsTextCL = "Geh bitte zu MeinKabel. Dort kannst Du die Optionen für Deinen Internet-Tarif buchen.";
    private String NoBookableOptionLabelCL = "Du kannst keine Optionen online buchen.";
    private String NoBookableInternetOptionTextCL = "Wende Dich bitte an den Support. Du erreichst uns montags bis freitags von 8 bis 20 Uhr und samstags von 9 bis 18 Uhr, kostenlos aus allen deutschen Netzen.";
    private String NoBookableOptionCTACL = "0800 203 03 44";
    private String NoBookablePhoneOptionTextCL = "Wende Dich bitte an den Support. Du erreichst uns montags bis freitags von 8 bis 20 Uhr und samstags von 9 bis 18 Uhr, kostenlos aus allen deutschen Netzen.";
    private String TVPageCrossLinkCL = "Kabel-TV - Tarif";
    private String MeinDatenPageCrossLinkCL = "Meine Daten";
    private String BookableInternetOptionsAccordionHeaderCL = "Buchbare Optionen Internet";
    private String OneTimePaymentOptionCardStatementCL = "Einmalzahlung";
    private String BookedOptionNegativePriceCL = "9,99";
    private String BookedOptionCurrencyCL = "€";
    private String BookedOptionNegativePriceTextCL = "geschenkt";
    private String securityPackageSOHeaderCL = "Sicherheitspaket";
    private String securityPackageSOFooterCL = "Sicher im Netz unterwegs";
    private String securityPackageAccordionHeaderCL = securityPackageSOHeaderCL;
    private String securityPackageAccordionSubHeaderCL = securityPackageSOFooterCL;
    private String notBookedSecurityPackageHeadlineCL = "Surf mit bestem Schutz";
    private String notBookedSecurityPackageImageHeaderCL = "Hol Dir das Sicherheitspaket";
    private String notBookedSecurityPackageImageTextCL = "Wir schützen Dich und Deine Daten vor Viren, Spam und Malware. So surfst Du sicher im Internet.";
    private String notBookedSecurityPackageCTACL = "Zu den buchbaren Optionen";
    private String ineligibleSecurityPackageHeaderCL = "Leider kannst du das Sicherheitspaket nicht buchen";
    private String ineligibleSecurityPackageTextCL = "Wende Dich bitte an den Support. Du erreichst uns montags bis freitags von 8 bis 20 Uhr und samstags von 9 bis 18 Uhr, kostenlos aus allen deutschen Netzen.";
    private String ineligibleSecurityPackageCTACL = "0800 203 03 44";
    private String bookedSecurityPackageHeadlineCL = "Download Deines Sicherheitspakets";
    private String bookedSecurityPackageNotificationHeaderCL = "Herunterladen und installieren";
    private String bookedSecurityPackageNotificationTextCL = "Einfach draufklicken, runterladen und installieren. Schon hast Du den optimalen Schutz für Deine Daten.";
    private String bookedSecurityPackageNotificationCTACL = "Jetzt runterladen";
    private String inventoryBEErrorMessageHeaderCL = "Das hat leider nicht geklappt";
    private String inventoryBEErrorMessageTextCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    private String availabilityBEErrorMessageHeaderCL = "Das hat leider nicht geklappt";
    private String availabilityBEErrorMessageTextCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";

    //URLS
    private String icmpPhone = "https://zuhauseplus.vodafone.de/optionen/?vfBasket=mobile-euro-flat-plus&shop-product=mobile-euro-flat-plus&icmp=mvw:option:others_kip_vkd_telefonoptionen";

    //Constructor
    public TariffPageInternetAndPhone(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Methods
    @Step("Click my tariff SO")
    public TariffPageInternetAndPhone clickMyTariffSO(){
        driver.element().click(MyTariffSOLocator);
        return this;
    }

    @Step("Click my booked options SO")
    public TariffPageInternetAndPhone clickBookedOptionsSO(){
        driver.element().click(MyBookedOptionsLocator);
        return this;
    }

    @Step("Click bookable internet options options SO")
    public TariffPageInternetAndPhone clickBookableInternetOptionsSO(){
        driver.element().click(MyBookableInternetOptionsSOLocator);
        return this;
    }

    @Step("Click bookable phone options options SO")
    public TariffPageInternetAndPhone clickBookablePhoneOptionsSO(){
        driver.element().click(MyBookablePhoneOptionsLocator);
        return this;
    }

    @Step("Click on My Internet Bookable Options Accordion")
    public TariffPageInternetAndPhone clickInternetBookableOptionsAccordion(){
        driver.element().click(MyInternetBookableOptionsAccordion);
        return this;
    }

    @Step("Click on My Phone Bookable Options Accordion")
    public TariffPageInternetAndPhone clickPhoneBookableOptionsAccordion(){
        driver.element().click(MyPhoneBookableOptionsAccordion);
        return this;
    }

    @Step("Click Book Now Button In internet Bookable options accordion First Free Option")
    public TariffPageInternetAndPhone clickBookNowInternetFirstFreeOptionCTA(){
        driver.element().click(BookNowInternetFirstFreeOptionCTA);
        return this;
    }

    @Step("Click Book Now Button In internet Bookable options accordion First Option")
    public TariffPageInternetAndPhone clickBookNowInternetFirstOptionCTA(){
        driver.element().click(BookNowInternetFirstOptionCTA);
        return this;
    }

    @Step("Click Book Now Button External Option")
    public TariffPageInternetAndPhone clickBookExternalOptionCTA(){
        driver.element().click(BookExternalOptionCTA);
        return this;
    }

    @Step("Click Book Now Button In Internet Bookable Options Accordion Second Option")
    public TariffPageInternetAndPhone clickBookNowInternetSecondOptionCTA(){
        driver.element().click(BookNowInternetSecondOptionCTA);
        return this;
    }

    @Step("Click Book Now Button In Phone Bookable options accordion First Option")
    public TariffPageInternetAndPhone clickBookNowPhoneFirstOptionCTA(){
        driver.element().click(BookNowPhoneFirstOptionCTA);
        return this;
    }

    @Step("Click Book Now Button In Phone Bookable options accordion Second Option")
    public TariffPageInternetAndPhone clickBookNowPhoneSecondOptionCTA(){
        driver.element().click(BookNowPhoneSecondOptionCTA);
        return this;
    }

    @Step("Click on Mein Tariff Accordion")
    public TariffPageInternetAndPhone clickOnMeinTariffAccordion(){
        driver.element().click(MeinTariffAccordion);
        return this;
    }

    @Step("Click on next button in kip page ")
    public TariffPageInternetAndPhone clickNextButtonKipSO(){
        driver.element().click(kipNextSOButton);
        return this;
    }

    @Step("Click On WLAN Hotspot Smart Object")
    public TariffPageInternetAndPhone clickOnWLANHotspotSO(){
        driver.element().click(WLANHotspotSOLocator);
        return this;
    }

    @Step("Click On Change Traiff Change Smart Object")
    public TariffPageInternetAndPhone clickOnTariffChangeSO(){
        driver.element().click(TariffChangeSOLocator);
        return this;
    }
    @Step("Click on Security Package accordion")
    public  TariffPageInternetAndPhone clickOnSecurityPackageAcc(){
        driver.element().doubleClick(securityPackageAcc);
        return this;
    }

    @Step("Click on Security Package Smart Object")
    public  TariffPageInternetAndPhone clickOnSecurityPackageSO(){
        driver.element().click(securityPackageSO);
        return this;
    }
    @Step("Click On Booked Options Accordion")
    public TariffPageInternetAndPhone expandBookedOptionsAccordion(){
        driver.element().click(bookedOptionsAccordion);
        return this;
    }

    @Step("Click On drop down menu in bookable options internet accordion")
    public TariffPageInternetAndPhone clickDropdownMenuBookableInternet(){
        driver.element().click(BookableDropdownMenuInternet);
        return this;
    }

    @Step("Click on another contract id from dropdown menu from bookable options internet")
    public TariffPageInternetAndPhone clickOnContractIDDropdownMenuBookableInternet(){
        driver.element().click(ContractIDDropdownMenuBookableInternet);
        return this;
    }

    @Step("Click on Go to Booked options CTA")
    public TariffPageInternetAndPhone clickOnGoToBookedOptionsCTA(){
        driver.element().click(GoToBookedOptionsAccordionCTA);
        return this;
    }

    @Step("Click on bill section hyperlink")
    public TariffPageInternetAndPhone clickOnBillSectionHyperlink(){
        driver.element().click(BillSectionCurrentPrice);
        return this;
    }
    @Step("Page Assertion")
    public TariffPageInternetAndPhone assertOnPageHeader (String PageHeaderCL){
        driver.verifyThat().element(page_Header).text().isEqualTo(PageHeaderCL).perform();
        return this;
    }

    @Step("Booked Options Accordion Assertion")
    public TariffPageInternetAndPhone assertOnBookedOptionsAccordion(){
        driver.verifyThat().element(bookedOptionsHeader).text().isEqualTo(bookedOptionsHeaderCL).perform();
        driver.verifyThat().element(bookedOptionsSubline).text().isEqualTo(bookedOptionsSublineCL).perform();
        return this;
    }

    @Step("Booked Options Card Validations")
    public TariffPageInternetAndPhone validateBookedOptionsCard(){
        driver.verifyThat().element(BookedOptionsCard).exists().perform();
        driver.verifyThat().element(BookedOptionsCardName).exists().perform();
        driver.verifyThat().element(BookedOptionsCardPrice).exists().perform();
        driver.verifyThat().element(BookedOptionsCardDescription).exists().perform();
        driver.verifyThat().element(BookedOptionsCardDetailsButton).exists().perform();
        return this;
    }

    @Step("Check my tariff accordion is not collapsed")
    public TariffPageInternetAndPhone validateMyTariffAccIsCollapsed(){
        driver.verifyThat().element( MyTariffTitleSoLocator).text().isEqualTo(MyTariffTitleCL).perform();
        driver.verifyThat().element( MyTariffTextSoLocator).text().isEqualTo(MyTariffTextSoCL).perform();
        driver.verifyThat().element( ExpandedMyTariffAccordionIndicator).exists().perform();
        return this;
    }

    @Step("Check my tariff accordion is expanded")
    public TariffPageInternetAndPhone validateMyTariffAccIsExpanded(){
        driver.verifyThat().element( MyTarifAccTitle).text().contains(MyTariffTitleCL).perform();
        driver.verifyThat().element( MyTariffTextAccLocator).text().isEqualTo(MyTariffTextAccCL).perform();
        driver.verifyThat().element( tarifUSPShown ).exists().perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(NoBookedOptionsLabelCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(MyBookableInternetOptionsTextCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(MyBookablePhoneOptionsTextCL).perform();
        return this;
    }

    @Step("Check my booked options accordion is collapsed")
    public TariffPageInternetAndPhone validateMyBookedOptionsAccIsCollapsed(){
        driver.verifyThat().element( MyBookedOptionsTitleSoLocator).text().isEqualTo(MyBookedOptionsTitleCL).perform();
        driver.verifyThat().element( MyBookedOptionsTextSoLocator).text().isEqualTo(MyBookedOptionsTextSoCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotContain(NoBookedOptionsLabelCL).perform();
        return this;
    }

    @Step("Check my booked options accordion is expanded")
    public TariffPageInternetAndPhone validateMyBookedOptionsAccIsExpanded(){
        driver.verifyThat().element( MyBookedOptionsTitleAccLocator).text().isEqualTo(MyBookedOptionsTitleCL).perform();
        driver.verifyThat().element( MyBookedOptionsTextAccLocator).text().isEqualTo(MyBookedOptionsTextAccCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(ExpandedMyTariffAccordionIndicator).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(MyBookableInternetOptionsTextCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(MyBookablePhoneOptionsTextCL).perform();
        return this;
    }

    @Step("Check my bookable internet options accordion is collapsed")
    public TariffPageInternetAndPhone validateMyBookableInternetOptionsAccIsCollapsed(){
        driver.verifyThat().element( MyInternetBookableOptionsTitleSoLocator).text().isEqualTo(MyInternetBookableOptionsTitleCL).perform();
        driver.verifyThat().element( MyInternetBookableOptionsTextSoLocator).text().isEqualTo(MyInternetBookableOptionsTextCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(MyBookableInternetOptionsTextCL).perform();
        return this;
    }

    @Step("Check my bookable internet options accordion is expanded")
    public TariffPageInternetAndPhone validateMyBookableInternetOptionsAccIsExpanded(){
        driver.verifyThat().element( MyInternetBookableOptionsTitleAccLocator).text().isEqualTo(MyInternetBookableOptionsTitleCL).perform();
        driver.verifyThat().element( MyInternetBookableOptionsTextAccLocator).text().isEqualTo(MyInternetBookableOptionsTextCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(ExpandedMyTariffAccordionIndicator).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(NoBookedOptionsLabelCL).perform();
        driver.verifyThat().element( NoBookableInternetOptionTextLocator).text().isEqualTo(MyBookableInternetOptionsTextCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(MyBookablePhoneOptionsTextCL).perform();
        return this;
    }

    @Step("Check my bookable phone options accordion is collapsed")
    public TariffPageInternetAndPhone validateMyBookablePhoneOptionsAccIsCollapsed(){
        driver.verifyThat().element( MyPhoneBookableOptionsTitleSoLocator).text().isEqualTo(MyPhoneBookableOptionsTitleCL).perform();
        driver.verifyThat().element( MyPhoneBookableOptionsTextSoLocator).text().isEqualTo(MyPhoneBookableOptionsTextCL).perform();
        driver.verifyThat().element( TariffPageContainerLocator).text().doesNotEqual(MyBookablePhoneOptionsTextCL).perform();
        return this;
    }

    @Step("Check my bookable phone options accordion is expanded")
    public TariffPageInternetAndPhone validateMyBookablePhoneOptionsAccIsExpanded(){
        driver.verifyThat().element( MyPhoneBookableOptionsTitleAccLocator).text().isEqualTo(MyPhoneBookableOptionsTitleCL).perform();
        driver.verifyThat().element( MyPhoneBookableOptionsTextAccLocator).text().isEqualTo(MyPhoneBookableOptionsTextCL).perform();
        driver.verifyThat().element( NoBookablePhoneOptionTextLocator).text().isEqualTo(MyBookablePhoneOptionsTextCL).perform();
        return this;
    }

    @Step("Validate no booked options message")
    public TariffPageInternetAndPhone validateNoBookedOptionMsg(){
        driver.verifyThat().element(NoBookedOptionHeadline).textTrimmed().isEqualTo(NoBookedOptionsLabelCL).perform();
        driver.verifyThat().element(NoBookedOptionSubLine).textTrimmed().isEqualTo(NoBookedOptionsTextCL).perform();
        return this;
    }

    @Step("Validate no bookable internet options message")
    public TariffPageInternetAndPhone validateNoBookableInternetOptionMsg(){
        driver.verifyThat().element( NoBookableInternetOptionLabelLocator).textTrimmed().isEqualTo(NoBookableOptionLabelCL).perform();
        driver.verifyThat().element( NoBookableInternetOptionTextLocator).textTrimmed().isEqualTo(NoBookableInternetOptionTextCL).perform();
        driver.verifyThat().element( NoBookableInternetOptionCTALocator).textTrimmed().isEqualTo(NoBookableOptionCTACL).perform();
        return this;
    }

    @Step("Validate no bookable phone options message")
    public TariffPageInternetAndPhone validateNoBookablePhoneOptionMsg(){
        driver.verifyThat().element( NoBookablePhoneOptionLabelLocator).text().isEqualTo(NoBookableOptionLabelCL).perform();
        driver.verifyThat().element( NoBookablePhoneOptionTextLocator2).text().isEqualTo(NoBookablePhoneOptionTextCL).perform();
        return this;
    }

    @Step("Validate cross links order")
    public TariffPageInternetAndPhone validateCrossLinksInKIPTariffPage(){
        driver.verifyThat().element(MeinDatenPageCrossLink).text().isEqualTo(MeinDatenPageCrossLinkCL).perform();
        driver.verifyThat().element(TVPageCrossLink).text().isEqualTo(TVPageCrossLinkCL).perform();
        return this;
    }

    @Step("Got to TV product page from Cross link")
    public TariffPageInternetAndPhone navigateToTVProductPageFromCrossLink(){
        driver.element().click(TVPageCrossLink);
        return this;
    }

    @Step("Assert that MBOX_ID doesn't exists")
    public TariffPageInternetAndPhone assertOnTeaserDoesNotExistsInKIPPage(){
        driver.verifyThat().element(MBOX_ID).doesNotExist().perform();
        driver.verifyThat().element(MBOX_button).doesNotExist().perform();
        return this;
    }

    @Step("Validate Cancellation Notification Card")
    public TariffPageInternetAndPhone validateCancellationNotificationCard(String CancellationNotificationBodyCL){
        driver.verifyThat().element(cardExist).exists().perform();
        driver.verifyThat().element(CancellationNotificationCardBookedOption).exists().perform();
        driver.verifyThat().element(CancellationNotificationBody).text().isEqualTo(CancellationNotificationBodyCL).perform();
        return this;
    }

    @Step("Validate that Book Now CTA is Missing")
    public TariffPageInternetAndPhone validateBookNowIsMissing(){
        driver.verifyThat().element(BookNowCTAMissed).isDisabled().perform();
        return this;
    }

    @Step("Validate Bookable Internet Accordion Header CL")
    public TariffPageInternetAndPhone validateBookableInternetAccordionHeaderCL(String BookableInternetOptionsAccordionHeaderCL){
        driver.verifyThat().element(BookableInternetOptionsAccordionHeader).text().isEqualTo(BookableInternetOptionsAccordionHeaderCL).perform();
        return this;
    }

    @Step("One-time payment statement validations")
    public TariffPageInternetAndPhone validateOneTimePaymentStatement(){
        driver.verifyThat().element(OneTimePaymentOptionCard).exists().perform();
        driver.verifyThat().element(OneTimePaymentOptionCardName).exists().perform();
        driver.verifyThat().element(OneTimePaymentOptionCardPrice).exists().perform();
        driver.verifyThat().element(OneTimePaymentOptionCardStatement).text().isEqualTo(OneTimePaymentOptionCardStatementCL).perform();
        driver.verifyThat().element(OneTimePaymentOptionCardDescription).exists().perform();
        driver.verifyThat().element(OneTimePaymentOptionCardBookCTA).exists().perform();
        return this;
    }

    @Step("Validate that when click change tariff from dashboard it will directed to mein tariff accordion in tariff page")
    public TariffPageInternetAndPhone validateChangeTariffHeader(){
        driver.verifyThat().element(TariffChangeHeaderInMeinTariffAccordion).exists().perform();
        return this;
    }

    @Step("Validate Booked Option Negative Price in KIP")
    public TariffPageInternetAndPhone validateBookedOptionNegativePriceKIP(){
        driver.verifyThat().element(BookedOptionNegativePrice).textTrimmed().contains(BookedOptionNegativePriceCL).perform();
        driver.verifyThat().element(BookedOptionCurrency).textTrimmed().contains(BookedOptionCurrencyCL).perform();
        driver.verifyThat().element(BookedOptionNegativePriceText).textTrimmed().contains(BookedOptionNegativePriceTextCL).perform();
        return this;
    }

    @Step("Validate Security Package Smart Object in KIP Tarif Page")
    public TariffPageInternetAndPhone validateSecurityPackageSO(){
        driver.verifyThat().element(securityPackageSO).exists().perform();
        driver.verifyThat().element(securityPackageSOIcon).exists().perform();
        driver.verifyThat().element(securityPackageSOHeader).textTrimmed().equals(securityPackageSOHeaderCL);
        driver.verifyThat().element(securityPackageSOFooter).textTrimmed().equals(securityPackageSOFooterCL);
        return this;
    }

    @Step("Validate Security Package Accordion in KIP Tariff Page")
    public TariffPageInternetAndPhone validateSecurityPackageAccordion(){
        driver.verifyThat().element(securityPackageAccordion).exists().perform();
        driver.verifyThat().element(securityPackageAccordionIcon).exists().perform();
        driver.verifyThat().element(securityPackageAccordionHeader).textTrimmed().equals(securityPackageAccordionHeaderCL);
        driver.verifyThat().element(securityPackageAccordionSubHeader).textTrimmed().equals(securityPackageAccordionSubHeaderCL);
        return this;
    }

    @Step("Validate accordion view when user has no booked security package")
    public TariffPageInternetAndPhone validateNotBookedSecurityPackage(){
        driver.verifyThat().element(notBookedSecurityPackageHeadline).textTrimmed().equals(notBookedSecurityPackageHeadlineCL);
        driver.verifyThat().element(notBookedSecurityPackageBodyImage).exists().perform();
        driver.verifyThat().element(notBookedSecurityPackageImageHeader).textTrimmed().equals(notBookedSecurityPackageImageHeaderCL);
        driver.verifyThat().element(notBookedSecurityPackageImageText).textTrimmed().equals(notBookedSecurityPackageImageTextCL);
        driver.verifyThat().element(notBookedSecurityPackageCTA).textTrimmed().equals(notBookedSecurityPackageCTACL);
        return this;
    }

    @Step("Validate accordion view when user is not eligible to book security package")
    public TariffPageInternetAndPhone validateIneligibleSecurityPackage(){
        driver.verifyThat().element(ineligibleSecurityPackageHeader).textTrimmed().equals(ineligibleSecurityPackageHeaderCL);
        driver.verifyThat().element(ineligibleSecurityPackageText).textTrimmed().equals(ineligibleSecurityPackageTextCL);
        driver.verifyThat().element(ineligibleSecurityPackageCTA).textTrimmed().equals(ineligibleSecurityPackageCTACL);
        driver.verifyThat().element(ineligibleSecurityPackageCTA).isDisabled().perform();
        return this;
    }

    @Step("Validate security package when user has booked security package")
    public TariffPageInternetAndPhone validateBookedSecurityPackage(){
        driver.verifyThat().element(bookedSecurityPackageHeadline).textTrimmed().equals(bookedSecurityPackageHeadlineCL);
        driver.verifyThat().element(bookedSecurityPackageNotificationHeader).textTrimmed().equals(bookedSecurityPackageNotificationHeaderCL);
        driver.verifyThat().element(bookedSecurityPackageNotificationText).textTrimmed().equals(bookedSecurityPackageNotificationTextCL);
        driver.verifyThat().element(bookedSecurityPackageNotificationCTA).textTrimmed().equals(bookedSecurityPackageNotificationCTACL);
        return this;
    }

    @Step("Validate BE notification message when inventory fails")
    public TariffPageInternetAndPhone checkBEInventoryErrorMessage(){
        driver.verifyThat().element(securityPackageAccordion).doesNotExist();
        driver.verifyThat().element(inventoryBEErrorMessageHeader).textTrimmed().equals(inventoryBEErrorMessageHeaderCL);
        driver.verifyThat().element(inventoryBEErrorMessageText).textTrimmed().equals(inventoryBEErrorMessageTextCL);
        return this;
    }

    @Step("Validate BE notification message when availability fails")
    public TariffPageInternetAndPhone checkBEAvailabilityErrorMessage(){
        driver.verifyThat().element(securityPackageAccordion).exists();
        driver.verifyThat().element(availabilityBEErrorMessageHeader).textTrimmed().equals(availabilityBEErrorMessageHeaderCL);
        driver.verifyThat().element(availabilityBEErrorMessageText).textTrimmed().equals(availabilityBEErrorMessageTextCL);
        return this;
    }

    @Step("Validate SOs ordering")
    public TariffPageInternetAndPhone validateSmartObjectOrdering(){
        driver.verifyThat().element(MyTariffSOLocator).exists().perform();
        driver.verifyThat().element(TariffChangeSOLocator).exists().perform();
        driver.verifyThat().element(MyBookedOptionsLocator).exists().perform();
        driver.verifyThat().element(MyBookableInternetOptionsSOLocator).exists().perform();
        driver.verifyThat().element(MyBookablePhoneOptionsLocator).exists().perform();
        driver.verifyThat().element(WLANHotspotSOLocator).exists().perform();
        return this;
    }

    @Step("Validate Tariff Change Smart Object")
    public TariffPageInternetAndPhone validateTariffChangeSO(String TariffChangeSOTitleCL, String TariffChangeSOBodyCL){
        driver.verifyThat().element(TariffChangeSOTitle).text().isEqualTo(TariffChangeSOTitleCL).perform();
        driver.verifyThat().element(TariffChangeSOBody).text().isEqualTo(TariffChangeSOBodyCL).perform();
        return this;
    }

    @Step("Validate WLAN Hotspot Smart Object")
    public TariffPageInternetAndPhone validateWLANHotspotSO(String WLANHotspotSOTitleCL, String WLANHotspotSOBodyCL){
        driver.verifyThat().element(WLANHotspotSOTitle).text().isEqualTo(WLANHotspotSOTitleCL).perform();
        driver.verifyThat().element(WLANHotspotSOBody).text().isEqualTo(WLANHotspotSOBodyCL).perform();
        return this;
    }

    @Step("Validate GigaZuhause cabel max 1000 Tariff Change Exist")
    public TariffPageInternetAndPhone validateGigaZuhauseCabelMaxTariffChangeExist(String GigaZuhauseCabelMaxNameCL){
        driver.verifyThat().element(GigaZuHauseCabelMaxTariffChange).exists().perform();
        driver.verifyThat().element(GigaZuhauseCabelMaxName).textTrimmed().isEqualTo(GigaZuhauseCabelMaxNameCL).perform();
        return this;
    }

    @Step("Validate GigaZuhause 1000 cabel main tariff Exist")
    public TariffPageInternetAndPhone validateGigaZuhause1000Cabel(String GigaZuhause1000MainTariffCL){
        driver.verifyThat().element(GigaZuhause1000MainTariff).text().isEqualTo(GigaZuhause1000MainTariffCL).perform();
        return this;
    }

    @Step("Validate Mein Tariff Smart Object")
    public TariffPageInternetAndPhone validateMeinTariffSO(String MyTariffTitle,String MyTariffText, String MyTariffDate){
        driver.verifyThat().element(MyTariffSOLocator).exists().perform();
        driver.verifyThat().element(MyTariffTitleSoLocator).textTrimmed().isEqualTo(MyTariffTitle).perform();
        driver.verifyThat().element(MyTariffTextSoLocator).textTrimmed().isEqualTo(MyTariffText).perform();
        driver.verifyThat().element(MyTariffDateSO).textTrimmed().isEqualTo(MyTariffDate).perform();
        return this;
    }

    @Step("Validate That Mein Tariff Exists")
    public TariffPageInternetAndPhone vaidateThatMeinTariffExists(String meinTariffOnly_NameCL) {
        driver.verifyThat().element(firstTariff_Name).textTrimmed().isEqualTo(meinTariffOnly_NameCL);
        driver.verifyThat().element(meinTariffOnly_DetailsBox).exists();
        driver.verifyThat().element(meinTariff_ChangeQuestion);
        return this;
    }

    @Step("Validate That no price exists")
    public TariffPageInternetAndPhone vaidateThatNoPriceOnCLSTariff(String startDate_CL) {
        driver.verifyThat().element(clsTariffOnly_FirstDate).textTrimmed().isEqualTo(startDate_CL);
    return this;
    }

    @Step("Validate that only CLS tariff exists on tariff accordion")
    public TariffPageInternetAndPhone validateThatCLSTariffOnlyExists(String clsTariffOnly_NameCL) {
        driver.verifyThat().element(firstTariff_Name).textTrimmed().isEqualTo(clsTariffOnly_NameCL);
        driver.verifyThat().element(makeMore_Question);
        return this;
    }

    public TariffPageInternetAndPhone validateThatFirstTariffMeinTariff(String MeinTariffFirst) {
        driver.verifyThat().element(firstTariff_Name).textTrimmed().isEqualTo(MeinTariffFirst);
        return this;
    }
    public TariffPageInternetAndPhone validateThatCLSTariffSecondTariff(String clsTariffName, String clsTariffID) {
        driver.verifyThat().element(secondTariff_ID).textTrimmed().isEqualTo(clsTariffID);
        driver.verifyThat().element(secondTariff_Name).textTrimmed().isEqualTo(clsTariffName);
        return this;
    }

    @Step("Validate on Cancellation pending notification message")
    public TariffPageInternetAndPhone validateCancellationPending(String CancellationPendingMessage){
        driver.assertThat().element(CancellationPendingNotification).textTrimmed().isEqualTo(CancellationPendingMessage).perform();
        return this;
    }

    @Step("Validate the Promo Badge")
    public TariffPageInternetAndPhone validateThatPromoPageIsDisplayed(String promoBadge_Text) {
        driver.assertThat().element(promoBadge).textTrimmed().isEqualTo(promoBadge_Text).perform();
                return this;
    }

    @Step("validate the cancellation pending message in smart object main tariff")
    public TariffPageInternetAndPhone validateCancellationMessage(String cancellationMessageMainTariffSO){
        driver.verifyThat().element(cancellationMessageMainTarifSO).textTrimmed().isEqualTo(cancellationMessageMainTariffSO).perform();
        return this;
    }

    @Step("Validate main tariff cancellation message details Bookable internet accordion")
    public TariffPageInternetAndPhone valiadteMainTariffCancellationMessage(String MainTariffCancellationMessageHeaderCL, String MainTariffCancellationMessageBodyCL){
          driver.verifyThat().element(contractNum).exists().perform();
        driver.verifyThat().element(MainTariffCancellationMessageCard).exists().perform();
        driver.verifyThat().element(MainTariffCancellationMessageHeader).textTrimmed().isEqualTo(MainTariffCancellationMessageHeaderCL).perform();
        driver.verifyThat().element(MainTariffCancellationMessageBody).textTrimmed().isEqualTo(MainTariffCancellationMessageBodyCL).perform();
        return this;
    }
    @Step("Validate main tariff cancellation message details Bookable internet accordion")
    public TariffPageInternetAndPhone valiadteMainTariffCancellationMessageDoesnotExist(){
        driver.verifyThat().element(MainTariffCancellationMessageCard).doesNotExist().perform();
        return this;
    }

    @Step("assert on Tarif change SO that doesn't exist when there is only CLS tarif")
    public TariffPageInternetAndPhone assertThatTariffChangeSODoesNotExist(){
        driver.assertThat().element(tarifChangeHiddenCase).attribute("aria-hidden").contains("false").perform();
        //driver.assertThat().element(TariffChangeSOLocator).isHidden().perform();
        return this;
    }

    @Step("assert on Tarif change SO that exists when there are mixed tarifs")
    public TariffPageInternetAndPhone assertThatTariffChangeSOExists(){
        driver.assertThat().element(TariffChangeSOLocator).exists().perform();
        return this;
    }

    @Step("Validate main tariff cancellation message details main tariff accordion")
    public TariffPageInternetAndPhone validateMainTariffAccCancellationMessage(String CancellationMSGMainTarifAccordionHeaderCL, String CancellationMSGMainTarifAccordionBodyCL){
        driver.verifyThat().element(CancellationMSGMainTarifAccordionHeader).textTrimmed().isEqualTo(CancellationMSGMainTarifAccordionHeaderCL).perform();
        driver.verifyThat().element(CancellationMSGMainTarifAccordionBody).text().contains(CancellationMSGMainTarifAccordionBodyCL).perform();
        return this;
    }

    @Step("Validate the header of the active tarif")
    public TariffPageInternetAndPhone validateActiveTariffHeader(String ActiveTariffHeaderCL){
        driver.verifyThat().element(ActiveTariffHeader).text().isEqualTo(ActiveTariffHeaderCL).perform();
        return this;
    }

    @Step("Validate the cancel contract hint message")
    public TariffPageInternetAndPhone validateCancelContractHintMSG(String CancelContractHintCL){
        driver.verifyThat().element(CancelContractHint).textTrimmed().isEqualTo(CancelContractHintCL).perform();
        return this;
    }

    @Step("Validate main tariff cancellation message Second details main tariff accordion")
    public TariffPageInternetAndPhone validateMainTariffAccCancellationMessageSec(String CancellationMSGMainTarifAccordionHeaderSecCL, String CancellationMSGMainTarifAccordionBodySecCL){
        driver.verifyThat().element(CancellationMSGMainTarifAccordionHeaderSec).text().isEqualTo(CancellationMSGMainTarifAccordionHeaderSecCL).perform();
        driver.verifyThat().element(CancellationMSGMainTarifAccordionBodySec).text().contains(CancellationMSGMainTarifAccordionBodySecCL).perform();
        return this;
    }

    @Step("Validate main tariff name")
    public TariffPageInternetAndPhone validateMainTariffSODetails(String MainTariffSONameCL, String MainTariffSODateCL){
        driver.verifyThat().element(MainTariffSOName).text().isEqualTo(MainTariffSONameCL).perform();
        driver.verifyThat().element(MainTariffSODate).text().isEqualTo(MainTariffSODateCL).perform();
        return this;
    }

    @Step("Validate Contract Details card when there is cancelled contract")
    public TariffPageInternetAndPhone validateCancelledContractDetailsCard(String ContractEndDateContractDetailsCL, String CancelContractHintCL, String CancelContractHintSecCL, String BillSectionCurrentPriceCL, String GoToBookedOptionsAccordionCTACL){
        driver.verifyThat().element(ContractEndDateContractDetails).textTrimmed().isEqualTo(ContractEndDateContractDetailsCL).perform();
        driver.verifyThat().element(CancelContractHint).text().isEqualTo(CancelContractHintCL).perform();
        driver.verifyThat().element(CancelContractHintSec).text().isEqualTo(CancelContractHintSecCL).perform();
        driver.verifyThat().element(BillSectionCurrentPrice).text().isEqualTo(BillSectionCurrentPriceCL).perform();
        driver.verifyThat().element(GoToBookedOptionsAccordionCTA).text().isEqualTo(GoToBookedOptionsAccordionCTACL).perform();
        return this;
    }

    @Step("Validate Booked options accordion Headline")
    public TariffPageInternetAndPhone validateBookedOptionAccHeadline(String bookedOptionsHeadlineCL){
        driver.verifyThat().element(bookedOptionsHeader).text().isEqualTo(bookedOptionsHeadlineCL).perform();
        return this;
    }

    @Step("Validate booked options accordion body view with CLS menu")
    public TariffPageInternetAndPhone validateBookedOptionsAccordionBodyWithCLSMenu(String bookedOptionsAccordionBodyHeaderCL, String bookedOptionsAccordionBodySubHeaderCL, String defaultContractHeaderCL, String defaultContractNumberCL){
        driver.verifyThat().element(bookedOptionsAccordionBodyHeader).textTrimmed().equals(bookedOptionsAccordionBodyHeaderCL);
        driver.verifyThat().element(bookedOptionsAccordionBodySubHeader).textTrimmed().equals(bookedOptionsAccordionBodySubHeaderCL);
        driver.verifyThat().element(defaultContractHeader).textTrimmed().equals(defaultContractHeaderCL);
        driver.verifyThat().element(defaultContractNumber).textTrimmed().equals(defaultContractNumberCL);
        driver.verifyThat().element(defaultContractIcon).exists().perform();
        return this;
    }

    @Step("validateAllContractNumberExists")
    public TariffPageInternetAndPhone getTheDropDownMenuContractIDs(){
        driver.element().click(defaultContractHeader);
        int contractNumbers = driver.element().getElementsCount(bookedOptionsDropDownMenu);
        Assert.assertEquals(contractNumbers, 4);
        List<WebElement> contractIDs = driver.getDriver().findElements(bookedOptionsDropDownMenuElement);
        for(int i = 0; i <= contractIDs.size(); i++) {
            if(i%2 != 0){
                String contractNumber = contractIDs.get(i).getText();
                System.out.println("contractNumber is: " + contractNumber);
            }
        }
        return this;
    }

    @Step("Validate that each contract its options")
    public TariffPageInternetAndPhone validateEachContractHasEachOptions(){
        int Contract1OptionsNumber = driver.element().click(defaultContractHeader)
                .click(contract1Number).getElementsCount(dropDownMenuOptionCard);
        Assert.assertEquals(Contract1OptionsNumber, 3);

        int Contract2OptionsNumber = driver.element().click(defaultContractHeader)
                .click(contract2Number).getElementsCount(dropDownMenuOptionCard);
        Assert.assertEquals(Contract2OptionsNumber, 3);

        int Contract3OptionsNumber = driver.element().click(defaultContractHeader)
                .click(contract3Number).getElementsCount(dropDownMenuOptionCard);
        Assert.assertEquals(Contract3OptionsNumber, 3);

        int Contract4OptionsNumber = driver.element().click(defaultContractHeader)
                .click(contract4Number).getElementsCount(dropDownMenuOptionCard);
        Assert.assertEquals(Contract4OptionsNumber, 3);

        return this;
    }

    @Step("Validate on CLS options exists only")
    public TariffPageInternetAndPhone validateCLSOptions(String CLSOption1, String CLSOption2, String CLSOption3, String CLSOption4, String CLSOption5) {
        driver.element().click(contract1CLS);
        List<WebElement> OptionNamesList1 = driver.getDriver().findElements(dropDownMenuOptionCardName);
        Assert.assertEquals(OptionNamesList1.get(0).getText(), CLSOption1);
        Assert.assertEquals(OptionNamesList1.get(1).getText(), CLSOption2);

        driver.element().click(defaultContractHeader).click(contract2CLS);
        driver.verifyThat().element(dropDownMenuOptionCardName).text().equals(CLSOption3);

        driver.element().click(defaultContractHeader).click(contract3CLS);
        List<WebElement> OptionNamesList3 = driver.getDriver().findElements(dropDownMenuOptionCardName);
        Assert.assertEquals(OptionNamesList3.get(0).getText(), CLSOption4);
        Assert.assertEquals(OptionNamesList3.get(1).getText(), CLSOption5);

        return this;
    }

    @Step("Validate on KIP options exists only")
    public void validateKIPOptions(String KIPOption1, String KIPOption2, String KIPOption3, String KIPOption4, String KIPOption5, String KIPOption6, String KIPOption7,String KIPOption8) {
        driver.element().click(contract1KIP);
        List<WebElement> optionNamesList1 = driver.getDriver().findElements(dropDownMenuOptionCardName);
        Assert.assertEquals(optionNamesList1.get(0).getText(), KIPOption1);
        Assert.assertEquals(optionNamesList1.get(1).getText(), KIPOption2);
        Assert.assertEquals(optionNamesList1.get(2).getText(), KIPOption3);
        Assert.assertEquals(optionNamesList1.get(3).getText(), KIPOption4);

        driver.element().click(defaultContractHeader).click(contract2KIP);
        List<WebElement> optionNamesList2 = driver.getDriver().findElements(dropDownMenuOptionCardName);
        Assert.assertEquals(optionNamesList2.get(0).getText(), KIPOption5);
        Assert.assertEquals(optionNamesList2.get(1).getText(), KIPOption6);

        driver.element().click(defaultContractHeader).click(contract3KIP);
        List<WebElement> optionNamesList3 = driver.getDriver().findElements(dropDownMenuOptionCardName);
        Assert.assertEquals(optionNamesList3.get(0).getText(), KIPOption7);
        Assert.assertEquals(optionNamesList3.get(1).getText(), KIPOption8);

    }

    @Step("Assert that no drop down menu in the booked options accordion body when there is only one KIP contract")
    public TariffPageInternetAndPhone assertThaNoKIPContractListAppearsInBookedOptionsBody(String KIPOption){
        driver.verifyThat().element(KIPOptionCardName).text().contains(KIPOption).perform();
        driver.assertThat().element(defaultContractHeader).doesNotExist().perform();
        return this;
    }

    @Step("Assert that no drop down menu in the booked options accordion body when there is only one CL contract")
    public TariffPageInternetAndPhone assertThaNoCLSContractListAppearsInBookedOptionsBody(String CLSOption){
        driver.verifyThat().element(CLSOptionCardName).text().contains(CLSOption).perform();
        driver.assertThat().element(defaultContractHeader).doesNotExist().perform();
        return this;
    }

    @Step("Click on  Option kündigen to cancel a booked option online")
    public TariffPageInternetAndPhone clickOnOptionKündigen(){
        driver.element().click(onlineCancelableBookedOptionCTA);
        return this;
    }

    @Step("Validate BE notification during cancellation transaction fails (Inventory BE)")
    public void validateBackEndErrorMessageDuringCancellationTransaction(String generalErrorNotificationMessageHeaderCL, String generalErrorNotificationMessageTextCL){
        driver.verifyThat().element(inventoryBEErrorMessageHeader).text().isEqualTo(generalErrorNotificationMessageHeaderCL).perform();
        driver.verifyThat().element(inventoryBEErrorMessageText).text().isEqualTo(generalErrorNotificationMessageTextCL).perform();
    }

    @Step("validate that the font in ChangeTariffs boxes is bold")
    public void validateTarifnameFontisBoldinChangeTariff ()
    {
        driver.assertThat().element(changeTarifBoxText).exists();
        driver.verifyThat()
                .element( changeTarifBoxText)
                .cssProperty("font-weight")
                .isEqualTo("700")
                .withCustomReportMessage("Assert that font in Change Tariff Box is Bold")
                .perform();
    }
}
