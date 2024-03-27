package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class MyDSLProducts {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public MyDSLProducts(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By BookableOptionWithConflictCTA = By.xpath("(//*[text()='Jetzt buchen'])[2]");
    private By DSLBookedExtraCardHeader_Locator = By.xpath("//*[@class='extras-card']//span[@class='h2']");
    private By DSLBookedExtraCardPrice_Locator = By.xpath("//*[@class='extras-card-price']//span[1]");
    private By DSLBookedExtraCardCancellationDate_Locator = By.xpath("//*[@class='extras-card-price']//div");
    private By DSLBookedExtraCardDesc_Locator = By.xpath("//*[@class='short-description']//p");
    private By DSLBookedExtraCardCancellationNt_Locator = By.xpath("//*[@automation-id='undefined_nt']//div//h4");
    private By DSLBookedExtraCardContactUsDeepLink_Locator = By.xpath("//*[@automation-id='undefined_description_tv']");
    private By DSLBookedExtraCardDetailsDeepLink_Locator = By.xpath("//*[@class='extras-card-details']//a");
    //////9911-end//////
    private By vodafoneTVSO = By.xpath("//smart-object[@type='vodafonetv']");
    private By bookedOptionsAccordion = By.xpath("//li[@automation-id='options_acc']/a");
    private By bookedOptionsAccordionBodyTitle = By.xpath("//div[@automation-id='dslBookedAccordionText_tv']//h4");
    private By bookedOptionsAccordionBodySubTitle = By.xpath("//div[@automation-id='dslBookedAccordionText_tv']//p");
    private By bookedOptionsDropDownMenu = By.xpath("//button[@automation-id='categoryDropDown_btn']");
    private By allBookedOptionsListCards = By.xpath("//*[@automation-id='dslBookedExtracard_tile']//span[@class='h2']");
    private By bookedOptionsTVOptionList = By.xpath("(//*[@id='option_child'])[3]");
    private By bookedOptionsVoiceOptionList = By.xpath("(//*[@id='option_child'])[2]");
    //////10137-end//////

    private By bookableOptionsAccordion = By.xpath("(//li[@automation-id='buchbareOptionen_acc']//a)[1]");
    private By euroFLatBook_Button = By.xpath("((//div[@class='tariff-card-wrapper'])[2]//a)[1]");
    //10388-end
    private   By NextSOs_Locator = By.xpath("(//*[@class='bx-next'])");
    public static   By BookedExtrasContainerLocator = By.xpath("//*[@class='extras-card-container booked-extras']");
    private   By MyBookedDSLOptionsSO = By.xpath("//*[@automation-id='options_so']");
    private   By SuperWLANSO = By.xpath("//*[@automation-id='superWLAN_so']");
    public static By BookedOptionsSectionHeader_Locator = By.xpath("//*[@automation-id='dslBookedAccordionText_tv']//h4");
    public static   By BookedOptionsSectionDesc_Locator = By.xpath("//*[@automation-id='dslBookedAccordionText_tv']//p");
    private   By CancelOptionCTA = By.xpath("(//*[contains(text(),'Diese Option kündigen')])[1]");
    //8952
    public static By SuperWLAN_AccHeader_Locator = By.xpath("(//*[@automation-id='superWlan_acc']//h4)[1]");
    public static By SuperWLAN_AccDesc_Locator = By.xpath("//*[@automation-id='superWlan_acc']//h5");
    public static By SuperWLAN_1stTileHeader_Locator = By.xpath("(//*[@id='superWlanAccordionId']//span)[2]");
    public static By SuperWLAN_1stTilePrice_Locator = By.xpath("//*[@class='extras-card-price']");
    public static By SuperWLAN_1stTileDesc_Locator = By.xpath("//*[@class='price-information'and contains (.,'Mit')]");
    public static By SuperWLAN_1stTileCallCenterButton_Locator = By.xpath("//*[@class='extras-card-button']");
    public static By SuperWLAN_2ndTileHeader_Locator = By.xpath("(//*[@class='extras-card']//span)[6]");
    public static By SuperWLAN_2ndTilePrice_Locator = By.xpath("(//*[@class='extras-card']//span)[7]");
    public static By SuperWLAN_2ndTileDesc_Locator = By.xpath("(//*[@class='price-information'])[3]");
    public static By SuperWLAN_2ndTileCancellationNt_Locator = By.xpath("((//*[@automation-id='undefined_nt'])//div)[3]");
    public static By SuperWLAN_2ndTileCallCenterButton_Locator = By.xpath("((((//*[@automation-id='undefined_nt'])//div)//ul)[2]//span)[1]");
    public static By SuperWLAN_3rdTileHeader_Locator = By.xpath("(//*[@class='extras-card']//span)[12]");
    public static By SuperWLAN_3rdTilePrice_Locator = By.xpath("(//*[@class='extras-card']//span)[13]");
    public static By SuperWLAN_3rdTileDesc_Locator = By.xpath("(//*[@class='price-information'])[4]");
    public static By SuperWLAN_3rdTileCancellationNt_Locator = By.xpath("(//*[@automation-id='undefined_nt'])[2]//h4");
    public static By SuperWLAN_3rdTileCallCenterButton_Locator = By.xpath("((((//*[@automation-id='undefined_nt'])//div)//ul)[4]//span)[1]");
    private By BasicSecureMsgBody = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By secureNetAcc = By.xpath("//li[@automation-id='secureNet_acc']//a");
    private By BasicSecureCTA = By.xpath("//*[@automation-id='secureNetBasicInfo_btn']");
    public By SecureNetPlusBodyBook_Locator = By.xpath("//*[@automation-id='book-secure-net-plus_tv' and contains (.,'Mit Secure Net+ hast Du online einen erweiterten Schutz. Es entfernt automatisch Spyware, Malware und Viren und schützt Deine Kinder vor gefährlichen Inhalten.')]");
    public By SecureNetPlusInfoBookCTA_Locator = By.xpath("//*[@automation-id='book-secure-net-plus_Link']");
    public By BookSecureNetPlusCTA_Locator = By.xpath("//*[@automation-id='book-secure-net-plus_btn']");
    public By MoreInformationButtonLocator = By.xpath("//*[@automation-id='not-eligible-to-book-secure-net-plus_btn']");
    public By SecureNetPlusBody_Locator = By.xpath("//*[@automation-id='cancel-secure-net-plus_tv' and contains(.,'Mit Secure Net+ hast Du online einen erweiterten Schutz. Es entfernt automatisch Spyware, Malware und Viren und schützt Deine Kinder vor gefährlichen Inhalten.')]");
    public By SecureNetPlusInfoCTA_Locator = By.xpath("//*[@automation-id='cancel-secure-net-plus_Link']");
    public By CancelCTA_Locator = By.xpath("//*[@automation-id='cancel-secure-net-plus_btn']");
    public By SecureNetConflictMsgHeader_Locator = By.xpath("//*[@class='flexDiv'and contains(.,'Gut zu wissen')]");
    public By SecureNetConflictMsg_Locator = By.xpath("//*[@class='notification-text mb-10 mt-10' and contains (.,'Secure Net Basic hast Du automatisch.')]");
    static By SecureNetSOLocator = By.xpath("//*[@automation-id='secureNet_so']");
    private By SecureNetSectionTextLocator = By.xpath("(//div[@id='secureNetAccordionId']//p)[1]");
    private By SecureNetImageLocator = By.xpath("(//div[@id='secureNetAccordionId']//img)[2]");
    private By SecureNetTitleLocator = By.xpath("//h3[@automation-id='book-secure-net-plus_tv']");
    private By SecureNetDescLocator = By.xpath("//p[@automation-id='book-secure-net-plus_tv']");
    private By SecureNetPlusMoreInfoCTALocator = By.xpath("//a[@automation-id='book-secure-net-plus_Link']");
    private By SecureNetBookNowCTALocator = By.xpath("//a[@automation-id='book-secure-net-plus_btn']//span");
    public static By NewSecureNetBookNowCTALocator = By.xpath("//*[@automation-id='book-secure-net-plus_Link']");
    private By BasicSecureNetHeaderLocator = By.xpath("(//*[@automation-id='secureNetBasicInfo_nt'])//h4");
    private By BasicSecureNetDescLocator = By.xpath("(//*[@automation-id='secureNetBasicInfo_nt'])//p");
    private By BasicSecureNetMoreInfoCTALocator = By.xpath("//button[@automation-id='secureNetBasicInfo_btn']");
    static By ConfigurationsAccordionLocator = By.xpath("//*[@automation-id='settings_acc']");
    static By EditPhonebookEntryCTA_Locator = By.xpath("(//*[@automation-id='settings_acc']//a)[5]");
    //9287
    public static By MyProductsPageHeaderLocator = By.xpath("//*[@automation-id='pageHeader_tv']//h1");
    public static By MyTariffSO_locator = By.xpath("(//*[@type='tariff'])");
    public static By MyTariffSO_Headerlocator = By.xpath("(//*[@type='tariff'])//h3");
    public static By MyTariffAcclocator = By.xpath("(//*[@automation-id='mytarif_acc'])");
    public static By MyTariffAcc_Headerlocator = By.xpath("(//*[@automation-id='mytarif_acc']//h4)[1]");
    public static By MyTariffAcc_Textlocator = By.xpath("(//*[@automation-id='mytarif_acc']//h5)[1]");
    public static By SuperWlanSO_HeaderLocator = By.xpath("//*[@automation-id='superWLAN_so']//h3");
    public static By SuperWlanSO_TextLocator = By.xpath("(//*[@automation-id='superWLAN_so']//div)[5]");
    public static By SuperWlanAcc_HeaderLocator = By.xpath("(//*[@automation-id='superWlan_acc']//h4)[1]");
    public static By SuperWlanAcc_TextLocator = By.xpath("(//*[@automation-id='superWlan_acc']//h5)[1]");
    public static By BookableOptionsSO_Locator = By.xpath("//*[@automation-id='dslBuchbareOptionenSo_so']");
    public static By BookableOptionsSO_HeaderLocator = By.xpath("//*[@automation-id='dslBuchbareOptionenSo_so']//h3");
    public static By BookableOptionsSO_TextLocator = By.xpath("(//*[@automation-id='dslBuchbareOptionenSo_so']//div)[5]");
    public static By BookableOptionsAcc_HeaderLocator = By.xpath("(//*[@automation-id='buchbareOptionen_acc']//h4)[1]");
    public static By BookableOptionsAcc_TextLocator = By.xpath("(//*[@automation-id='buchbareOptionen_acc']//h5)[1]");
    public static By SecurityPackageSO_Locator = By.xpath("//*[@automation-id='security_so']");
    public static By SecurityPackageSO_HeaderLocator = By.xpath("//*[@automation-id='security_so']//h3");
    public static By SecurityPackageSO_TextLocator = By.xpath("(//*[@automation-id='security_so']//div)[5]");
    public static By SecurenetSO_Locator = SecureNetSOLocator;
    public static By SuperWlanSO_Locator = By.xpath("//*[@automation-id='secureNet_so']//h3");
    public static By BookedOptionsSO_Locator = By.xpath("//*[@automation-id='secureNet_so']//h3");

    public static By SecurenetSO_HeaderLocator = By.xpath("//*[@automation-id='secureNet_so']//h3");
    public static By SecurenetSO_TextLocator = By.xpath("(//*[@automation-id='secureNet_so']//div)[5]");
    public static By SecurenetAcc_HeaderLocator = By.xpath("(//*[@automation-id='secureNet_acc']//h4)[1]");
    public static By SecurenetAcc_TextLocator = By.xpath("(//*[@automation-id='secureNet_acc']//h5)[1]");
    public static By BookedOptionsSO_HeaderLocator = By.xpath("//*[@automation-id='options_so']//h3");
    public static By BookedOptionsSO_TextLocator = By.xpath("(//*[@automation-id='options_so']//div)[5]");
    public static By BookedOptionsAcc_HeaderLocator = By.xpath("(//*[@automation-id='options_acc']//h4)[1]");
    public static By BookedOptionsAcc_TextLocator = By.xpath("(//*[@automation-id='options_acc']//h5)[1]");
    public static By ConfigurationsSO_Locator = By.xpath("//*[@automation-id='settings_so']");
    public static By ConfigurationsSO_HeaderLocator = By.xpath("(//*[@automation-id='settings_so']//h3)[1]");
    public static By ConfigurationsSO_TextLocator = By.xpath("(//*[@automation-id='settings_so']//div)[5]");
    public static By ConfigurationsAcc_HeaderLocator = By.xpath("(//*[@automation-id='settings_acc']//h4)[1]");
    public static By ConfigurationsAcc_TextLocator = By.xpath("(//*[@automation-id='settings_acc']//h5)[1]");
    public static By DevicesTabLocator = By.xpath("(//*[@automation-id='undefined_lv'])[3]");
    public static By BookNowFreeCTA_Locator = By.xpath("(//a[@class='btn btn-sml'])[1]");
    private By cancelSecureNetPlusOptionCTA = By.xpath("//*[@automation-id='cancel-secure-net-plus_btn']");
    private By secureNetPlusInfoCTA = By.xpath("//a[@automation-id='cancel-secure-net-plus_Link']");
    public static By BookableOptionsSectionHeader_Locator = By.xpath("//*[@class='ac-head ac-active' ]");
    public static By BookableOptionsSectionDesc_Locator = By.xpath("//*[@automation-id='bookableOptions_header_tv' ]");
    public static By BookNowCTA_Locator = By.xpath("//*[@class='btn btn-sml ']");
    public static By NoBookedMsgHeader_Locator = By.xpath("//*[@class='item-2 w-100' and contains (.,'Gut zu wissen')]");
    public static By NoBookedMsgBody_Locator = By.xpath("//*[@class='notification-text mb-10 mt-10' and contains (.,'Du nutzt schon die besten Optionen für Deinen Tarif. Welche Optionen Du ausgewählt hast, kannst Du im Bereich')]");
    public static By SecurityPackageAcc = By.xpath("//*[@automation-id='security_acc']");
    private By SecureNetAccBody_Header_Locator= By.xpath("//*[@class='btn btn-sml ']");
    private By BookableOptionAccordionLoactor = By.xpath("(//li[@automation-id='buchbareOptionen_acc'])");
    //8010-start
    private By pricedOption = By.xpath("(//div[@class='extras-card-button']//a)[1]");
    private By freeOption =  By.xpath("//div[@class='card-button']//a");
    //8010-end

    //CL
    public static String DSLBookedExtraCard_CancellationNt_CL = "Du kannst diese Option leider nicht online kündigen. Wende Dich bitte an die Kundenbetreuung.";
    public static String DSLBookedExtraCard_ContactUsDeepLink_CL = "Dein Kontakt zu uns";
    /////9911-end/////
    private String bookedOptionsAccordionBodyTitleCL = "Dies sind Deine gebuchten Optionen";
    private String bookedOptionsAccordionBodySubTitleCL = "Diese Optionen ergänzen Deinen Tarif im Moment. Du willst etwas ändern? Wann Du eine Option kündigen kannst, siehst Du hier:";
    /////10137-end/////

    public static String BookedOptionsSectionHeader_CL = "Dies sind Deine gebuchten Optionen";
    public static String BookedOptionsSectionDesc_CL = "Diese Optionen ergänzen Deinen Tarif im Moment. Du willst etwas ändern? Wann Du eine Option kündigen kannst, siehst Du hier:";
    //8952
    public static String SuperWLAN_AccHeader_CL = "SuperWLAN";
    public static String SuperWLAN_AccDesc_CL = "Modernste Router und Verstärker für das beste Internet-Erlebnis";
    public static String SuperWLAN_BookableTileHeader_CL = "SuperWLAN";
    public static String SuperWLAN_BookableTilePrice_CL = "Kostenlos";
    public static String superWLAN_BookableTileDesc_CL = "Mit dem SuperWLAN-Verstärker bekommst Du automatische WLAN-Optimierung dank intelligenter Datenanalyse und eine Erweiterung der WLAN-Reichweite. Insgesamt kannst Du bis zu 2 SuperWLAN-Verstärker buchen. Mindestvertragslaufzeit 6 Monate";

    public static String superWLAN_BookableTileDesc_CL2 =  "Bestell den SuperWLAN-Verstärker bei der Hotline: Mo - Fr. 8 - 20 Uhr , Sa: 9 - 18 Uhr , So: 9 - 17 Uhr";
    public static String SuperWLAN_BookableTileCallCenterButton_CL = "0800 172 1212";
    public static String SuperWLANExtender_BookableTileHeader_CL = "SuperWLAN-Verstärker";
    public static String SuperWLANExtender_BookableTileCallCenterButton_CL = "0800 172 1212";
    public static String SuperWLAN_BookedTileDesc_CL = "Mit SuperWLAN bekommst Du automatische WLAN-Optimierung dank intelligenter Datenanalyse und umfassenden WLAN-Support. Dauerhaft kostenlos – keine Laufzeit.";
    public static String SuperWLAN_2ndTileCancellationNt_CL = "Du willst die SuperWLAN-Option kündigen? Dann ruf uns kostenlos an. Mo - Fr: 8 - 20 Uhr, Sa: 9 - 18 Uhr, So: 9 - 17 Uhr";
    public static String SuperWLANExtender_BookedTileHeader_CL = "SuperWLAN-Verstärker";
    public static String SuperWLANExtender_BookedTileDesc_CL = "Mit dem SuperWLAN-Verstärker bekommst Du automatische WLAN-Optimierung dank intelligenter Datenanalyse und eine Erweiterung der WLAN-Reichweite. Insgesamt kannst Du bis zu 2 SuperWLAN-Verstärker buchen.Mindestvertragslaufzeit 6 Monate";
    public static String SuperWLANExtender_BookedCancellationNt_CL = "Du willst die SuperWLAN-Option kündigen? Dann ruf uns kostenlos an. Mo - Fr: 8 - 20 Uhr, Sa: 9 - 18 Uhr, So: 9 - 17 Uhr";
    public static String SuperWLANExtender_BookedTileCallCenterButton_CL = "0800 172 1212";
    private final Duration PT60S = Duration.ofSeconds(60);
    public static String BasicSecureMsgBody_CL = "Secure Net Basic hast Du automatisch. Mit kostenlosem Virenalarm und Bot-Netz-Schutz bist Du sicher online unterwegs. Auf allen Deinen Geräten im Vodafone-Netz.";
    public static String BasicSecureCTA_CL = "Über Secure Net Basic informieren";
    public static String SecureNetAccBody_Header_CL = "Secure Net Basic hast Du automatisch. Mit kostenlosem Virenalarm und Bot-Netz-Schutz bist Du sicher online unterwegs. Noch sicherer surfst Du mit Secure Net+.";
    private String SecureNetPlusBodyBook_CL = "Mit Secure Net+ hast Du online einen erweiterten Schutz. Es entfernt automatisch Spyware, Malware und Viren und schützt Deine Kinder vor gefährlichen Inhalten.";
    private String SecureNetPlusInfoCTA_CL = "Über Secure Net+ informieren";
    private String BookSecureNetPlusCTA_CL = "Secure Net+ buchen";
    private String SecureNetPlusBody_CL = "Mit Secure Net+ hast Du online einen erweiterten Schutz. Es entfernt automatisch Spyware, Malware und Viren und schützt Deine Kinder vor gefährlichen Inhalten.";
    public static String CancelCTA_CL = "Secure Net+ kündigen";
    public static String SecureNetConflictMsg_CL = "Secure Net Basic hast Du automatisch. Es gilt für alle Deine Geräte im Vodafone-Netz. Mit uneingeschränktem Virenalarm und Bot-Netz-Schutz bist Du sicher online unterwegs. Den noch besseren Schutz von Secure Net+ kannst Du mit Deinem aktuellen DSL-Tarif nicht nutzen.";
    public static String SecureNetConflictMsgHeader_CL = "Gut zu wissen";
    public static String SecureNetConflictCTA_CL = "Mehr Infos";
    private String SecureNetSectionTextCL = "Secure Net Basic hast Du automatisch. Mit kostenlosem Virenalarm und Bot-Netz-Schutz bist Du sicher online unterwegs. Noch sicherer surfst Du mit Secure Net+.";
    private String SecureNetTitleCL = "Secure Net+";
    private String SecureNetDescCL = "Mit Secure Net+ hast Du online einen erweiterten Schutz. Es entfernt automatisch Spyware, Malware und Viren und schützt Deine Kinder vor gefährlichen Inhalten.";
    private String SecureNetPlusMoreInfoCTACL = "Über Secure Net+ informieren";
    private String SecureNetBookNowCTACL = "Secure Net+ buchen";
    private String BasicSecureNetHeaderCL = "Secure Net Basic";
    private String BasicSecureNetDescCL = "Secure Net Basic hast Du automatisch. Mit kostenlosem Virenalarm und Bot-Netz-Schutz bist Du sicher online unterwegs. Auf allen Deinen Geräten im Vodafone-Netz.";
    private String BasicSecureNetMoreInfoCTA_CL = "Über Secure Net Basic informieren";
    //9287
    public static String MyProductsPageHeaderCL = ("Meine Produkte");
    public static String MyTariffSO_HeaderCL = ("Mein Tarif");
    public static String MyTariffAcc_HeaderCL = MyTariffSO_HeaderCL;
    public static String MyTariffAcc_TextCL = "Laufzeit und Vertragsverlängerung";

    public static String SuperWlanSO_HeaderCL = SuperWLAN_AccHeader_CL;
    public static String SuperWlanSO_TextCL = SuperWLAN_AccDesc_CL;
    public static String SuperWlanAcc_HeaderCL = SuperWLAN_AccHeader_CL;
    public static String SuperWlanAcc_TextCL = SuperWLAN_AccDesc_CL;

    public static String BookableOptionsSO_HeaderCL = ("Buchbare Optionen");
    public static String BookableOptionsSO_TextCL = ("Ergänze Deinen Tarif mit weiteren Optionen");
    public static String BookableOptionsAcc_HeaderCL = BookableOptionsSO_HeaderCL;
    public static String BookableOptionsAcc_TextCL = BookableOptionsSO_TextCL;

    public static String SecurityPackageSO_HeaderCL = ("Sicherheitspaket");
    public static String SecurityPackageSO_TextCL = ("Sicher im Netz unterwegs");
    public static String SecurityPackageAcc_HeaderCL = SecurityPackageSO_HeaderCL;
    public static String SecurityPackageAcc_TextCL = SecurityPackageSO_TextCL;

    public static String SecurenetSO_HeaderCL = ("Secure Net");
    public static String SecurenetSO_TextCL = ("Sicher surfen im Vodafone-Netz");
    public static String SecurenetAcc_HeaderCL = SecurenetSO_HeaderCL;
    public static String SecurenetAcc_TextCL = SecurenetSO_TextCL;

    public static String BookedOptionsSO_HeaderCL = ("Buchbare Extras und Optionen");
    public static String BookedOptionsSO_TextCL = ("Die Extras und Optionen für Ihren Tarif");
    public static String BookedOptionsAcc_HeaderCL = "Gebuchte Optionen";
    public static String BookedOptionsAcc_TextCL = "Optionen ansehen und bearbeiten";

    public static String ConfigurationsSO_HeaderCL = ("Konfiguration Sprache");
    public static String ConfigurationsSO_TextCL = ("Rufnummern sperren, Telefonbucheintrag festlegen ...");
    public static String ConfigurationsAcc_HeaderCL = ConfigurationsSO_HeaderCL;
    public static String ConfigurationsAcc_TextCL = "Rufnummern sperren, Telefonbucheintrag festlegen, anonyme Anrufe blockieren und mehr";

    public static String BookableOptionsSectionHeader_CL = "Ergänze Deinen Tarif mit weiteren Optionen";
    public static String BookableOptionsSectionDesc_CL = "Diese Optionen kannst Du zu Deinem Tarif dazubuchen, z. B. zusätzliche Flats fürs Telefonieren.";
    public static String NoBookedMsgHeader_CL = "Gut zu wissen";
    public static String NoBookedMsgBody_CL = "Du nutzt schon die besten Optionen für Deinen Tarif. Welche Optionen Du ausgewählt hast, kannst Du im Bereich ";


    //Methods
    @Step("Expand Bookable Option Accordion")
    public void clickOnBookableOptionAccordion(){
        driver.element().click(BookableOptionAccordionLoactor);
    }
    public MyDSLProducts clickViewMoreSOs() {
        (new ElementActions(driver.getDriver())).click(NextSOs_Locator);
        return this;
    }

    public MyDSLProducts clickBookedOptionsSO_expandBookedOptionsAcc() {
        (new ElementActions(driver.getDriver())).click(MyBookedDSLOptionsSO);
        return this;
    }

    public MyDSLProducts clickSecureNetSO_expandSecureNetAcc() {
        driver.element().click(SecureNetSOLocator);
        return this;
    }

    public MyDSLProducts clickSuperWLANSO_expandSuperWLANAcc() {
        (new ElementActions(driver.getDriver())).click(SuperWLANSO);
        return this;
    }


    public HandleGigaKombi clickCancelOption() {
        (new ElementActions(driver.getDriver())).click(CancelOptionCTA);
        return new HandleGigaKombi(driver);
    }

    public DSL_CancelingTransaction clickCancelOptionII() {
        (new ElementActions(driver.getDriver())).click(CancelOptionCTA);
        return new DSL_CancelingTransaction(driver);
    }

    public MyDSLProducts expandSecureNetAcc() {
        driver.element().click(secureNetAcc);
        return this;
    }

    public MyDSLProducts clickSecurenetPlusBookNowCTA(){
        driver.element().click(SecureNetBookNowCTALocator);
        return this;
    }

    public AddEmailConflictPage clickSecurenetPlusBookNowCTAII()
    {
        driver.element().click(SecureNetBookNowCTALocator);
        return new AddEmailConflictPage(driver);
    }

    public BookingSecureNetPlusLegacyPortal clickSecurenetPlusBookNowCTA_LegacyPortal()
    {
        driver.element().click(NewSecureNetBookNowCTALocator);
        return new BookingSecureNetPlusLegacyPortal(driver);
    }

    public PhonebookEntry expandSettingsAccAndNavToPhonebookEntry() {
        (new ElementActions(driver.getDriver())).click(ConfigurationsAccordionLocator).click(EditPhonebookEntryCTA_Locator);
        return new PhonebookEntry(driver);
    }
    public MyDSLProducts click(By Element){
        WebElement element = driver.getDriver().findElement(Element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].click();", element);
        return this;
    }

    public DevicesPage clickTab(By Element){
        WebElement element = driver.getDriver().findElement(Element);
        ((JavascriptExecutor) driver.getDriver()).executeScript("arguments[0].click();", element);
        return new DevicesPage(driver);
    }

    public DSL_BookingTransaction bookOptionWithConflict(){
        WebDriverWait wait = new WebDriverWait(driver.getDriver(), PT60S);
        wait.until(ExpectedConditions.visibilityOfElementLocated(BookableOptionWithConflictCTA));
        (new ElementActions(driver.getDriver())).click(BookableOptionWithConflictCTA);
        return new DSL_BookingTransaction(driver);
    }

    @Step("Book Options Validations")
    public void validateBookedOptionsBody(){
        Validations.verifyThat()
                .element(driver.getDriver(), BookedOptionsSectionHeader_Locator)
                .text().isEqualTo(BookedOptionsSectionHeader_CL).perform();
        Validations.verifyThat()
                .element(driver.getDriver(), BookedOptionsSectionDesc_Locator)
                .text().isEqualTo(BookedOptionsSectionDesc_CL).perform();
    }

    @Step("Non Cancelable Online Card Validations")
    public void validateNonCancellableOnlineCard(){

        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardHeader_Locator).exists().perform();

        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardPrice_Locator).exists().perform();

        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardCancellationDate_Locator)
                .doesNotExist().perform();

        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardDesc_Locator).exists().perform();

        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardCancellationNt_Locator).exists()
                .perform();
        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardCancellationNt_Locator)
                .text()
                .isEqualTo(DSLBookedExtraCard_CancellationNt_CL).perform();

        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardContactUsDeepLink_Locator).exists()
                .perform();
        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardContactUsDeepLink_Locator).text()
                .isEqualTo(DSLBookedExtraCard_ContactUsDeepLink_CL).perform();

        Validations.verifyThat().element(driver.getDriver(), DSLBookedExtraCardDetailsDeepLink_Locator).exists()
                .perform();
    }

    @Step("Booked secure net plus validations")
    public void bookedSecureNetPlusValidations()
    {
        Validations.assertThat()
                .element(driver.getDriver(),SecureNetAccBody_Header_Locator)
                .text().contains(SecureNetAccBody_Header_CL);

        Validations.assertThat()
                .element(driver.getDriver(),SecureNetPlusBody_Locator)
                .text().equals(SecureNetPlusBody_CL);

        Validations.assertThat()
                .element(driver.getDriver(),SecureNetPlusInfoCTA_Locator)
                .text().equals(SecureNetPlusInfoCTA_CL);

        Validations.assertThat()
                .element(driver.getDriver(), CancelCTA_Locator)
                .text().equals(CancelCTA_CL);

    }
    @Step("Basic secure net plus validations")
    public void basicSecureNetPlusValidations()
    {
        Validations.assertThat()
                .element(driver.getDriver(),BasicSecureMsgBody)
                .text().equals(BasicSecureMsgBody_CL);
        Validations.assertThat()
                .element(driver.getDriver(), BasicSecureCTA)
                .text().equals(BasicSecureCTA_CL);

    }

    @Step("Bookable secure net plus validations")
    public void bookableSecureNetPlusValidations()
    {
        Validations.assertThat()
                .element(driver.getDriver(), SecureNetPlusBodyBook_Locator)
                .text().equals( SecureNetPlusBodyBook_CL);
        Validations.assertThat()
                .element(driver.getDriver(), SecureNetPlusInfoBookCTA_Locator)
                .text().equals(SecureNetPlusInfoCTA_CL);
        Validations.assertThat()
                .element(driver.getDriver(), BookSecureNetPlusCTA_Locator)
                .text().equals(BookSecureNetPlusCTA_CL);
        Validations.assertThat()
              .element(driver.getDriver(), BookSecureNetPlusCTA_Locator)
            .text().equals(BookSecureNetPlusCTA_CL);

    }


    @Step("Booked secure net plus validations")
    public void secureNetConflictMsgValidations()
    {
        Validations.assertThat()
                .element(driver.getDriver(),SecureNetConflictMsgHeader_Locator )
                .text().equals(SecureNetConflictMsgHeader_CL);
        Validations.assertThat()
                .element(driver.getDriver(),SecureNetConflictMsg_Locator )
                .text().equals(SecureNetConflictMsg_CL);
        Validations.assertThat()
                .element(driver.getDriver(),MoreInformationButtonLocator )
                .text().equals(SecureNetConflictCTA_CL);
    }

    @Step("Booked secure net plus validations")
    public void checkExistanceOfSecurityAcc()
    {
        Validations.verifyThat().element(driver.getDriver(), SecurityPackageAcc).exists()
                .perform();
    }

    @Step("Booked secure net plus validations")
    public void checkInexistanceOfSecurityAcc()
    {
        Validations.verifyThat().element(driver.getDriver(), SecurityPackageAcc).doesNotExist()
                .perform();
    }
    //10388-start
    @Step("Expand booklable options accordion")
    public MyDSLProducts clickOnBookableOptionsAcc(){
        driver.element().click(bookableOptionsAccordion);
        return this;
    }

    public MyDSLProducts clickOnBookEuroFlat(){
        driver.element().click(euroFLatBook_Button);
        return this;
    }
    //10388-end

    //8003-start
    @Step("Validate on Secure net accordion body")
    public MyDSLProducts validateOnSecureNetBody() {
        driver.verifyThat().element(SecureNetSectionTextLocator).textTrimmed().isEqualTo(SecureNetSectionTextCL).perform();
        driver.verifyThat().element(SecureNetImageLocator).exists().perform();
        driver.verifyThat().element(SecureNetTitleLocator).textTrimmed().isEqualTo(SecureNetTitleCL).perform();
        driver.verifyThat().element(SecureNetDescLocator).textTrimmed().isEqualTo(SecureNetDescCL).perform();
        driver.verifyThat().element(SecureNetPlusMoreInfoCTALocator).textTrimmed().isEqualTo(SecureNetPlusMoreInfoCTACL).perform();
        driver.verifyThat().element(SecureNetBookNowCTALocator).textTrimmed().isEqualTo(SecureNetBookNowCTACL).perform();
        driver.verifyThat().element(BasicSecureNetHeaderLocator).textTrimmed().isEqualTo(BasicSecureNetHeaderCL).perform();
        driver.verifyThat().element(BasicSecureNetDescLocator).textTrimmed().isEqualTo(BasicSecureNetDescCL).perform();
        driver.verifyThat().element(BasicSecureNetMoreInfoCTALocator).textTrimmed().isEqualTo(BasicSecureNetMoreInfoCTA_CL).perform();
        return this;
    }

    //8010- start
    @Step("Book a priced DSL option to redirect to transaction page")
    public MyDSLProducts bookPricedOption(String buttonText_CL){
        driver.verifyThat().element(pricedOption).textTrimmed().isEqualTo(buttonText_CL).perform();
        driver.element().click(pricedOption);
        return this;
    }

    @Step("Book a free DSL option to redirect to transaction page")
    public MyDSLProducts bookFreeOption(String buttonText_CL){
        driver.verifyThat().element(freeOption).textTrimmed().equals(buttonText_CL);
        driver.element().click(freeOption);
        return this;
    }

    //8104 - start
    @Step("Click on Cancel Secure net")
    public MyDSLProducts clickCancelSecureNetPlus() {
        driver.element().click(cancelSecureNetPlusOptionCTA);
        return this;
    }

    @Step("Validate Secure net accordion when user has cancelled secure net")
    public MyDSLProducts validateOnCancelCTAForSecureNet(){
        driver.verifyThat().element(secureNetPlusInfoCTA).exists().perform();
        driver.verifyThat().element(cancelSecureNetPlusOptionCTA).doesNotExist().perform();
        return this;
    }

    //10137-start
    @Step("Assert that Vodafone TV SO doesn't exist")
    public MyDSLProducts assertOnVodafoneTVSO(){
        driver.assertThat().element(vodafoneTVSO).doesNotExist().perform();
        return this;
    }

    @Step("Expand booked options accordion")
    public MyDSLProducts expandBookedOptionsAccordion(){
        driver.element().click(bookedOptionsAccordion);
        return this;
    }

    @Step("Validate on booked options accordion")
    public MyDSLProducts validateBookedOptionsAccordionBody(){
        driver.verifyThat().element(bookedOptionsAccordionBodyTitle).textTrimmed().equals(bookedOptionsAccordionBodyTitleCL);
        driver.verifyThat().element(bookedOptionsAccordionBodySubTitle).textTrimmed().equals(bookedOptionsAccordionBodySubTitleCL);
        driver.verifyThat().element(bookedOptionsDropDownMenu).exists().perform();
        return this;
    }

    @Step("assert on all booked options in the accordion")
    public MyDSLProducts assertOnAllBookedOptions(){
        int bookedOptionsNumber = driver.element().getElementsCount(allBookedOptionsListCards);
        Assert.assertEquals(bookedOptionsNumber,3);
        return this;
    }

    @Step("Validate TV booked options")
    public MyDSLProducts validateTVBookedOptions(String bookedOptionTV1, String bookedOptionTV2){
        driver.element().click(bookedOptionsDropDownMenu);
        driver.element().isElementClickable(bookedOptionsTVOptionList);
        driver.element().click(bookedOptionsTVOptionList);
        driver.element().waitUntilNumberOfElementsToBe(allBookedOptionsListCards,2);
        List<WebElement> optionNamesTVList = driver.getDriver().findElements(allBookedOptionsListCards);
        Assert.assertEquals(optionNamesTVList.get(0).getText(), bookedOptionTV1);
        Assert.assertEquals(optionNamesTVList.get(1).getText(), bookedOptionTV2);
        return this;
    }

    @Step("Validate Voice booked options")
    public MyDSLProducts validateVoiceBookedOptions(String bookedOptionVoice1){
        driver.element().click(bookedOptionsDropDownMenu);
        driver.element().isElementClickable(bookedOptionsVoiceOptionList);
        driver.element().click(bookedOptionsVoiceOptionList);
        driver.verifyThat().element(allBookedOptionsListCards).textTrimmed().equals(bookedOptionVoice1);
        return this;
    }
    //10137-end
}