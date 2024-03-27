package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class KD_Dashboard {
    public KD_Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    private SHAFT.GUI.WebDriver driver;

    // Locators
    private By KabelInternetAndPhoneAcc = By.xpath("//*[@class='subscription-heading' and contains(.,'Internet')]");
    private By SOsSlider = By.xpath("//a[@class='bx-next']");
    public static final By MSG_Container = By.xpath("//*[@class=\"notification-message-container\"]");
    public static final By Close_BTN = By.xpath("//*[@class=\"icon-close-i-xxsml i-xxsml\"]");
    private By KabelTvAccordion = By.xpath("//a[@class='subscription-heading' and contains(.,'TV')]");
    private By meinTariff_SO = By.xpath("//*[@automation-id='TVSubscriptionTvMeinTarif__so']");

    private By superWLANSOHeader = By.xpath("//h3[text()='WLAN-Hotspot-Logins']");
    private By superWLANSOFooter = By.xpath("//div[text()='Hotspot-Logins verwalten']");
    private By manageHotspotLogin = By.xpath("//li[contains(@ng-class,'hotspot-logins')]");
    private By internetAndPhone_Acc = By.xpath("(//span[@class='mbo-name break-word'])[1]");
    private By kabelTV_Acc = By.xpath("(//span[@class='mbo-name break-word'])[2]");
    private By meinTariff_Header = By.xpath("//*[@automation-id='KIPSubscriptionIpMeinTarif__so']//h3");
    private By tariffName_Text = By.xpath("//*[@class='circle-text-big tarrifCardName']");
    private By endDate_Footer = By.xpath("(//*[@class=\"sb-block-footer smart-object-footer\"]//div)[2]");
    private By burger_Menu_KIP = By.xpath("(//*[@class=\"expert-mode dots-menu\"])[1]");
    private By tariff_icon = By.xpath("(//*[@class='option-name'])[1]");
    private By meinTariffSOKabelTV_Header = By.xpath("//*[@automation-id='TVSubscriptionTvMeinTarif__so']//h3");
    private By tariffNameSOKabelTV_Text = By.xpath("(//*[@class='circle-text-big tarrifCardName'])[2]");
    private By endDateSOKabelTV_Footer = By.xpath("(//*[@class='sb-block-footer smart-object-footer']//div)[3]");
    private By meinTariffSOKabelTV_Icon = By.xpath("(//*[@class='icon-circle-i-mdm i-grey w-70'])[2]");
    private By meinTariffKabelTV_Staticfooter = By.xpath("(//div[@automation-id='TVSubscriptionTvMeinTarif__so']//div)[6]");
    private By meinTraifTVSO = By.xpath("//div[@automation-id='TVSubscriptionTvMeinTarif__so']");
    private By meinKabelTVSO = By.xpath("//div[@automation-id='TVSubscriptionTvMeinKabel__so']");
    private By burgerMenuKIP = By.xpath("(//div[@class='expert-mode dots-menu'])[1]");
    private By internetAndPhoneSettingsSO = By.xpath("(//*[@automation-id='TV_settings_so'])");
    private By overviewButtonBurgerMenuTV = By.xpath("(//span[@class='option-name' and contains(text(),'Übersicht')])[2]");
    private By overviewButtonBurgerMenuKIP = By.xpath("(//span[@class='option-name' and contains(text(),'Übersicht')])[1]");
    private By meinKabelTVSOHeadline = By.xpath("//div[@automation-id='TVSubscriptionTvMeinKabel__so']//h3");
    private By meinKabelTVSOSubLine = By.xpath("//div[@automation-id='TVSubscriptionTvMeinKabel__so']//div[@class='circle-text-big tarrifCardName']");
    private By meinKabelTVBMOption = By.xpath("(//span[@class='option-name'])[4]");
    private By meinKabelTVSOEndDate = By.xpath("//div[@automation-id='TVSubscriptionTvMeinKabel__so']//div[@class='sb-block-footer smart-object-footer']//div//div");
    private By kabelTVBurgerMenu = By.xpath("(//div[@class='expert-mode dots-menu'])[2]");
    private By kabelTVBurgerMenuList = By.xpath("(//ul[@automation-id='sushi-bar-menu_lv'])[2]");
    private By meinTarifList = By.xpath("(//a[@class='menu-item'])[4]");
    private By myContactDataSmartObjectLocator = By.xpath("//*[@automation-id='Meine Daten_btn']//div[2]");
    private By myBillsSmartObjectLocator = By.xpath("//*[@automation-id='Meine Rechnungen_btn']//div[2]");
    private By firstSmartObjectLocator = By.xpath("//div[@automation-id='invoiceTileHeadline_tv']");
    private By myProductSushiBarLocator = By.xpath("(//*[@class='expert-mode dots-menu'])[1]");
    private By myTariffSushiBarSOLocator = By.xpath("(//ul[@automation-id='sushi-bar-menu_lv']//span)[1]");
    private By TarifHeader = By.xpath("//*[@automation-id='cardHeader_tv']");
    private By TarifUSP = By.xpath("//*[@automation-id='feature_01_lv']");
    private By MeinKabelTV = By.xpath("//div[@automation-id='TVSubscriptionTvMeinKabel__so']");
    private By KTVBurgerMenu = By.xpath("(//div[@class='expert-mode dots-menu'])[2]");
    private By MeinKabelTVInBurgerMenu = By.xpath("(//a[@class='menu-item'])[4]");
    private By MeinKabelTVIcon = By.xpath("(//div[@class='smart-object-icon-container smart-object-svg-container'])[1]");
    private By MeinKabelTVSOSubLineRenter = By.xpath("//div[@automation-id='TVSubscriptionTvMeinKabel__so']//div[@class='sb-block-footer']");
    private By MeinTarifKabelTVBurgerMenu = By.xpath("(//a[@class='menu-item']//span)[5]");
   private By MeinKabelTVBurgerMenu = By.xpath("(//span[@class='option-name'])[4]");
   private By productsTitle = By.xpath("//div[@class='dashInfoText']");
    private By MeinTarifSO_InternetPhone = By.xpath("//div[@automation-id='KIPSubscriptionIpMeinTarif__so']");
    private By meinTarifAcc = By.xpath("//accordion[@automation-id='meinTarifTv_acc']");
    private By MeineTVOptionenSOTV = By.xpath("(//div[@automation-id='_so' and contains(.,'Meine TV Optionen')])");
    private By ExklusiveAngeboteSOTV = By.xpath("(//div[@class='sb-block-head' and contains(.,'Exklusive Angebote')])//h3");
    private By TVSettingSOTV = By.xpath("(//div[@automation-id='_so' and contains(.,'Einstellungen')])");
    private By PhoneSettingSOKIP = By.xpath("(//div[@automation-id='_so' and contains(.,'Geräte & Einstellungen')])[1]");
    private By ExklusiveAngeboteSOKIP = By.xpath("(//div[@automation-id='_so' and contains(.,'Exklusive Angebote')])[1]");
    private By TariffChangeSOKIP = By.xpath("(//div[@automation-id='_so' and contains(.,'Tarif wechseln')])");
    private By MeinKabelContractAccordion = By.xpath("(//a[@class='ac-head skiphash accordion-state'])[3]");
    private By MeinTarifKIPBurgerMenu = By.xpath("(//span[@class='option-name' and contains(.,'Mein Tarif')])[1]");
    private By meinKabelTVBurgerMenu = By.xpath("//span[@class='option-name' and contains(text(),'Mein Kabel TV')]");
    private By accordion_Title = By.xpath("//div[@class='title' and contains (text(),'Produkte')]");
    private By meinTariff_SO_Body = By.xpath("//div[@class='circle-text-big tarrifCardName']");
    private By meinTariff_SO_Footer = By.xpath("//div[@class='sb-block-footer smart-object-footer']//dynamic-footer/div");
    private By meinTariff_SO_Body_KabelTV = By.xpath("//div[@class='circle-text-big tarrifCardName']");
    private By meinTariff_SO_Footer_KabelTV = By.xpath("//div[@class='circle-text-big tarrifCardName']");

    private By ChangeTarifInKIPBurgerMenu = By.xpath("//span[text()='Tarif wechseln']");

    private By gigaTVGerateSO = By.xpath("(//div[@automation-id='_so'])[2]");
    private By gigaTVGerateSOHeader = By.xpath("(//div[@automation-id='_so'])[2]//h3");
    private By gigaTVGerateSOSubLine = By.xpath("(//div[@automation-id='_so'])[2]//div[@class='sb-block-footer']");
    private By deviceAndSettingBurgerMenu = By.xpath("(//a[@class='menu-item'])[3]//span");
    private By kabelTVBurgerMenuDots = By.xpath("(//div[@class='expert-mode dots-menu'])");
    //CLs
    private String SuperWLANSOHeaderCL = "WLAN-Hotspot-Logins";
    private String SuperWLANSOFooterCL = "Hotspot-Logins verwalten";
    private String MeinTarifKabelTVBurgerMenuCL = "Mein Tarif";
    private String meinTariffHeader_CL = "Mein Tarif";
    private String tariffName_CL = "Vodafone CableMax 1000";
    private String endDate_CL = "Laufzeit bis 05.12.2024";
    private String meinTariffSOKabelTV_HeaderCL = "Mein Tarif";
    private String tariffNameSOKabelTV_CL = "Kabel Digital";
    private String endDateSOKabelTVFooter_CL = "Laufzeit bis";
    private String meinTariffKabelTVStaticFooter_CL = "Leistungen, Laufzeit und mehr";
    private String MeinKabelTVSOHeadlineCL = "Mein Kabel TV";
    private String MeinKabelTVSOSubLineCL = "Digitaler Kabelanschluss";
    private String MeinKabelTVSOEndDateCL = "Laufzeit bis 27.11.2022";
    private String MyContactDataSmartObjectCL = "Meine Daten";
    private String firstSmartObjectCL = "Aktuelle Rechnung";
    private String myBillsSOHeaderCL = "Meine Rechnungen";
    private String MeinKabelTVSOSubLineRenterCL = "Leistungen Vertragsdetails";

    // URL
    private String HotspotLoginURL = "https://hotspot.vodafone.de/service/#/login";
    private String KabelTVPageURl = "https://simplicity.wf-de.vodafone.com/meinvodafone/services/meine-produkte/tv/tarife";

    //Methods
    @Step("Click Mein Kabel TV SO")
    public KD_Dashboard clickMeinKabelTVSO() {
        driver.element().click(MeinKabelTV);
        return this;
    }

    @Step("Expand Kabel Internet & phone Accordion")
    public KD_Dashboard expandKabelInternetAndPhoneAcc() {
        driver.element().click(KabelInternetAndPhoneAcc);
        return this;
    }
    @Step("validate mein tarif SO when there are multiple CLSs and one is cancelled")
    public KD_Dashboard valiadteMainTariffCancellationMessage(String MeinTarifSOHeaderCL , String MeinTarifSOSubLineCL){
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(MeinTarifSOHeaderCL);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(MeinTarifSOSubLineCL);
        return this;
    }

    @Step("close pop up notification")
    public KD_Dashboard closeNotification() {
        driver.element().getElementsCount(MSG_Container);
        if (driver.element().getElementsCount(MSG_Container) != 0) {
            driver.element().click(Close_BTN);
        }
        return this;
    }

    @Step("Click On Kabel TV Burger Menu")
    public KD_Dashboard clickOnKabelTVBurgerMenu() {
        driver.element().click(kabelTVBurgerMenu);
        driver.verifyThat().element(kabelTVBurgerMenuList).isVisible().perform();
        return this;
    }

    @Step("Click Mein Tarif List")
    public KD_Dashboard clickOnMeinTarifList() {
        driver.element().click(meinTarifList);
        return this;
    }
    @Step("Click on MeinKabel TV from Kabel TV Burger menu")
    public KD_Dashboard clickOnMeinKabelTVBM()
    {
        driver.element().click(MeinKabelTVBurgerMenu);

        return this;
    }

    @Step("Click Mein Tariff Button from Burger Menu In Kabel Tv Dashboard")
    public KD_Dashboard clickMeinTariffButtonFromBurgerMenuTV() {
        driver.element().click(MeinTarifKabelTVBurgerMenu);
        return this;
    }

    @Step("Slide SO")
    public KD_Dashboard slideSO() {
        driver.element().click(SOsSlider);
        return this;
    }

    @Step("Expand Kabel Tv Accordion")
    public KD_Dashboard expandKabelTvAccordion() {
        driver.element().click(KabelTvAccordion);
        return this;
    }

    @Step("Click on Mein Tariff SO to be redirected to tariff page")
    public KabelTVPage clickOnMeinTariffSO() {
        driver.element().click(meinTariff_SO);
        return new KabelTVPage(driver);
    }

    @Step("Click On Mein Kabel TV Smart Object")
    public KD_Dashboard clickOnMeinKabelTVSO() {
        driver.element().click(meinKabelTVSO);
        return this;
    }

    @Step("Click on Main Tarif TV Smart Object")
    public KD_Dashboard clickOnMainTarifTVSO() {
        driver.element().click(meinTraifTVSO);
        return this;
    }

    @Step("Click on Mein Tariff SO")
    public KD_Dashboard clickMeinTariffSmartObject() {
        driver.verifyThat().element(productsTitle).exists().perform();
        driver.verifyThat().element(MeinTarifSO_InternetPhone).exists().perform();
        driver.element().click(MeinTarifSO_InternetPhone);
        return this;
    }

    @Step("Expand my product's suhsi bar")
    public KD_Dashboard expandProductSushiBar() {
        driver.element().click(myProductSushiBarLocator);
        return this;
    }

    @Step("Select my tariff of my product's sushi bar")
    public KD_Dashboard clickMyTariffFromSushiBar() {
        driver.element().click(myTariffSushiBarSOLocator);
        return this;
    }

    @Step("Click On Mein Tv Optionen Smart Object in kabel tv")
    public KD_Dashboard clickOnMeinTVOptionenSOTV() {
        driver.element().click(MeineTVOptionenSOTV);
        return this;
    }

    @Step("Click On Exclusive Angebote Smart Object in kabel tv")
    public KD_Dashboard clickOnExklusiveAngeboteSOTV() {
        driver.element().click(ExklusiveAngeboteSOTV);
        return this;
    }

    @Step("Click on TV Setting Smart Object in kabel tv")
    public KD_Dashboard clickOnTVSettingSOTV() {
        driver.element().click(TVSettingSOTV);
        return this;
    }

    @Step("Click On Phone Setting Smart Object in KIP accordion")
    public KD_Dashboard clickOnPhoneSettingSOKIP() {
        driver.element().click(PhoneSettingSOKIP);
        return this;
    }

    @Step("Click on Exclusive Angebote Smart Object in kabel KIP")
    public KD_Dashboard clickOnExklusiveAngeboteSOKIP() {
        driver.element().click(ExklusiveAngeboteSOKIP);
        return this;
    }

    @Step("Click On Tariff Change Smart Object in KIP Accordion")
    public KD_Dashboard clickOnTariffChangeSOKIP() {
        driver.element().click(TariffChangeSOKIP);
        return this;
    }

    @Step("Navigate to Kabel TV Page")
    public KD_Dashboard navigateToKabelTVPage() {
        driver.browser().navigateToURL(KabelTVPageURl);
        driver.verifyThat().element(meinTarifAcc).exists().perform();
        return this;
    }

    @Step("Click on Mein Tariff SO")
    public KD_Dashboard clickOnInternetAndPhoneAccordion() {
        driver.element().click(internetAndPhone_Acc);
        return this;
    }
    @Step("Click on Kabel TV accordion")
    public KD_Dashboard clickOnKabelTVAccordion() {
        driver.element().click(kabelTV_Acc);
        return this;
    }

    @Step("Click on Super WLAN SO")
    public KD_Dashboard clickSuperWLANSO() {
        driver.element().click(superWLANSOFooter);
        return this;
    }

    @Step("Click on Burger Menu Linked to Kabel TV Accordion")
    public KD_Dashboard clickOnBurgerMenuKabelTV() {
        driver.element().click(burgerMenuKIP);
        return this;
    }

    @Step("Click on Internet And phone Settings from KabelTVs Burger Menu")
    public KD_Dashboard clickOnInteretAndPhoneSettingsSO(){
        driver.element().click(internetAndPhoneSettingsSO);
     return this;
    }

    public KD_Dashboard openBurgerMenu() {
        driver.element().click(burger_Menu_KIP);
        return this;
    }

    @Step("Navigate to Kabel TV Page from Burger Menu")
    public KD_Dashboard navigateToKabelTVPageFromBurgerMenu() {
        driver.element().click(KTVBurgerMenu);
        driver.element().click(MeinKabelTVInBurgerMenu);
        return this;
    }

    @Step("Click on Mein Kabel Contract Accordion")
    public KD_Dashboard clickMeinKabelContractAccordion() {
        driver.element().click(MeinKabelContractAccordion);
        return this;
    }

    @Step("Click on burger menu from mein kabel contract accordion in kip")
    public KD_Dashboard clickOnBurgerMenuKIPMeinKabelContract() {
        driver.element().click(burgerMenuKIP);
        return this;
    }

    @Step("Click on mein tariff in kip form burger menu")
    public KD_Dashboard clickOnMeinTarifKIPBurgerMenu() {
        driver.element().waitToBeReady(MeinTarifKIPBurgerMenu);
        driver.element().click(MeinTarifKIPBurgerMenu);
        return this;
    }

    @Step("Click On Giga TV Gerate Smart Object")
    public KD_Dashboard clickOnGigaTVGerateSO(){
        driver.element().click(gigaTVGerateSO);
        return this;
    }

    @Step("Click On Device and Setting From Burger menu in Kabel TV")
    public KD_Dashboard clickOnDeviceAndSettingBurgerMenu(){
        driver.element().click(deviceAndSettingBurgerMenu);
        return this;
    }
    @Step("Click On Burger menu from kabel tv accordion")
    public KD_Dashboard clickBurgerMenuKabelTV(){
        driver.element().click(kabelTVBurgerMenuDots);
        return this;
    }

    @Step("Validate Header of Super WLAN SO")
    public KD_Dashboard validateSuperWLANSOHeader() {
        driver.assertThat()
                .element(superWLANSOHeader)
                .text().isEqualTo(SuperWLANSOHeaderCL);
        return this;
    }

    @Step("Validate Header of Super WLAN SO")
    public KD_Dashboard validateSuperWLANSOFooter() {
        driver.assertThat()
                .element(superWLANSOFooter)
                .text().isEqualTo(SuperWLANSOFooterCL);
        return this;
    }

    @Step("Validate Super WLAN SO redirects to vodafone hotspot page")
    public KD_Dashboard validateSuperWLANSORedirectsTOHotspotPage() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());

        Validations.assertThat().element(driver.getDriver(), manageHotspotLogin).exists()
                .perform();
        Validations.assertThat().browser(driver.getDriver()).url().isEqualTo(HotspotLoginURL)
                .perform();
        return this;
    }

    public TariffPageInternetAndPhone goToTariffPage() {
        driver.element().click(tariff_icon);
        return new TariffPageInternetAndPhone(driver);
    }

    @Step("Mein Tariff SO Validation in KIP Accordion")
    public KD_Dashboard assertOnMeinTariffSO() {
        driver.verifyThat().element(meinTariff_Header).isVisible().perform();
        driver.verifyThat().element(meinTariff_Header).text()
                .isEqualTo(meinTariffHeader_CL).perform();
        return this;
    }

    @Step("Tariff Name Assertion in KIP Accordion")
    public KD_Dashboard assertOnDynamicTariffName() {
        driver.assertThat().element(tariffName_Text).textTrimmed()
                .isEqualTo(tariffName_CL).perform();
        return this;
    }

    @Step("End Date Assertion in KIP Accordion")
    public KD_Dashboard assertOnEndDate() {
        driver.element().waitToBeReady(endDate_Footer);
        driver.assertThat().element(endDate_Footer).textTrimmed()
                .isEqualTo(endDate_CL).perform();
        return this;
    }

    @Step("Kabel TV Mein Tariff SO Validation")
    public KD_Dashboard assertOnMeinTariffSOInKabelTVAcc() {
        driver.element().waitToBeReady(meinTariffSOKabelTV_Header);
        driver.assertThat().element(meinTariffSOKabelTV_Header).text()
                .isEqualTo(meinTariffSOKabelTV_HeaderCL).perform();
        return this;
    }

    @Step("Kabel TV Tariff Name Assertion")
    public KD_Dashboard assertOnDynamicTariffNameInSOMeinTarifIKabelTVAcc() {
        driver.element().waitToBeReady(tariffNameSOKabelTV_Text);
        driver.assertThat().element(tariffNameSOKabelTV_Text).text()
                .isEqualTo(tariffNameSOKabelTV_CL).perform();
        return this;
    }

    @Step("Kabel TV Mein Tarif End Date Assertion")
    public KD_Dashboard assertOnEndDateInSOMeinTarifKabelTVAcc() {
        driver.element().waitToBeReady(endDateSOKabelTV_Footer);
        driver.assertThat().element(endDateSOKabelTV_Footer).text()
                .contains(endDateSOKabelTVFooter_CL).perform();
        return this;
    }

    @Step("Assert on SO Icon - Kabel TV Accordion")
    public KD_Dashboard assertOnSOIconInMeinTariffSOInKabelTVAcc() {
        driver.assertThat().element(meinTariffSOKabelTV_Icon).exists().perform();
        return this;
    }

    @Step("Assert on Static Text - Kabel TV Accordion")
    public KD_Dashboard assertOnStaticFooterInMeinTariffSOInKabelTVAcc() {
        driver.verifyThat().element(meinTariffKabelTV_Staticfooter).exists().perform();
        driver.verifyThat().element(meinTariffKabelTV_Staticfooter).text().isEqualTo(meinTariffKabelTVStaticFooter_CL).perform();
        return this;
    }

    @Step("assert that Mein Tariff exists after Mein Kabel TV")
    public KD_Dashboard assertOnMeinTariffExistsAfterKabelTV() {
        driver.assertThat().element(MeinTarifKabelTVBurgerMenu).text().isEqualTo(MeinTarifKabelTVBurgerMenuCL).perform();
        return this;
    }

    @Step("Validate DashBoard Page for KD")
    public KD_Dashboard validateKdDashboard() {
        driver.verifyThat().element(myContactDataSmartObjectLocator)
                .textTrimmed().contains(MyContactDataSmartObjectCL).perform();
        driver.verifyThat().element(myBillsSmartObjectLocator)
                .textTrimmed().contains(myBillsSOHeaderCL).perform();
        driver.verifyThat()
                .element(firstSmartObjectLocator)
                .textTrimmed().isEqualTo(firstSmartObjectCL).perform();
        return this;
    }

    @Step("Validate Existence of Kabel TV Accordion")
    public KD_Dashboard validateExistenceOfKabelTVAccordion() {
        driver.verifyThat().element(KabelTvAccordion).exists().perform();
        return this;
    }

    @Step("Validate Mein Kabel TV Smart Object")
    public KD_Dashboard validateMeinKabelTVSODashBoard() {
        driver.verifyThat().element(meinKabelTVSO).exists().perform();
        driver.verifyThat().element(meinKabelTVSOHeadline).text().isEqualTo(MeinKabelTVSOHeadlineCL).perform();
        driver.verifyThat().element(meinKabelTVSOSubLine).text().isEqualTo(MeinKabelTVSOSubLineCL).perform();
        driver.verifyThat().element(meinKabelTVSOEndDate).text().isEqualTo(MeinKabelTVSOEndDateCL).perform();
        return this;
    }

    @Step("Validate Mein Kabel TV Exist in Burger Menu First Option")
    public KD_Dashboard validateMeinKabelTVFirstOptionInBurgerMenu() {
        driver.verifyThat().element(meinKabelTVBMOption).exists().perform();
        return this;
    }

    @Step("Validate existence of tariff name and USPs")
    public KD_Dashboard checkExistenceOfTarifNameAndUSPs() {
        driver.verifyThat().element(TarifHeader).exists().perform();
        driver.verifyThat().element(TarifUSP).exists().perform();
        return this;
    }

    @Step("Validate not existence of overview button in burger menu In kabel tv ")
    public KD_Dashboard validateNotExistenceOfOverviewButtontv() {
        driver.verifyThat().element(overviewButtonBurgerMenuTV).doesNotExist().perform();
        return this;
    }

    @Step("Validate not existence of overview button in burger menu in KIP")
    public KD_Dashboard validateNotExistenceOfOverviewButtonkip() {
        driver.verifyThat().element(overviewButtonBurgerMenuKIP).doesNotExist().perform();
        return this;
    }

    @Step("Validate Mein Kabel TV SO In Case of No Tariff for Renter User")
    public KD_Dashboard validateMeinKabelTVSONoTariffUserRenter() {
        driver.verifyThat().element(MeinKabelTVIcon).exists().perform();
        driver.verifyThat().element(MeinKabelTVSOSubLineRenter).textTrimmed().isEqualTo(MeinKabelTVSOSubLineRenterCL).perform();
        return this;
    }
    @Step("Click on Mein KabelTV from TV accordion's burger menu")
    public KD_Dashboard clickOnMeinKabelTVBurgerMenu() {
        driver.element().click(meinKabelTVBurgerMenu);
        return this;
    }

    @Step("validate that Mein Tarif Smart Object Display with the CLS Tarif Name")
    public KD_Dashboard validateMeinTarifSOWithCLSTariffOnly(String meinTarifSO_CLSOnly, String meinTarifSO_CLSOnly_LastDate) {
        driver.verifyThat().element(accordion_Title).exists().perform();
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(meinTarifSO_CLSOnly);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(meinTarifSO_CLSOnly_LastDate);
        return this;
    }

    @Step("validate that Mein Tarif Smart Object Display with the CLS Tarif Name in Kabel TV accordion")
    public KD_Dashboard validateMeinTarifSOWithCLSOnlyTV(String meinTarifSO_CLSOnly, String meinTarifSO_CLSOnly_LastDate) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(meinTarifSO_CLSOnly);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(meinTarifSO_CLSOnly_LastDate);
        return this;
    }

    @Step("validate that Mein Tarif Smart Object Display with the Mein Tarif Name in case user has CLS and Mein Tarif")
    public KD_Dashboard validateMeinTarifSOWithMeinTarifandCLS(String meinTarifSO_KipCLS, String meinTarifSO_KipCLS_LastDate) {
        driver.verifyThat().element(accordion_Title).exists().perform();
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(meinTarifSO_KipCLS);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(meinTarifSO_KipCLS_LastDate);
        return this;
    }

    @Step("validate that Mein Tarif Smart Object Display with the Mein Tarif Name in case user has CLS and Mein Tarif")
    public KD_Dashboard validateMeinTarifSOWithMeinTarifandCLSKabelTV(String meinTarifSO_KipCLS, String meinTarifSO_KipCLS_LastDate) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(meinTarifSO_KipCLS);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(meinTarifSO_KipCLS_LastDate);
        return this;
    }

    @Step("validate that Mein Tarif Smart Object Display with the Mein Tarif Name")
    public KD_Dashboard validateMeinTarifSOWithMeinTariffOnly(String meinTarifSO_KipOnly, String meinTarifSO_KipOnly_LastDate) {
        driver.verifyThat().element(accordion_Title).exists().perform();
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(meinTarifSO_KipOnly);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(meinTarifSO_KipOnly_LastDate);
        return this;
    }

    @Step("validate that Mein Tarif Smart Object Display with the Mein Tarif Name in KabelTV Accordion")
    public KD_Dashboard validateMeinTarifSOWithMeinTariffOnlyKabelTV(String meinTarifSO_KipOnly, String meinTarifSO_KipOnly_LastDate) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(meinTarifSO_KipOnly);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(meinTarifSO_KipOnly_LastDate);
        return this;
    }
    @Step("validate the message of the mein tarif Smart Object in case user has only cancelled CLS Tarif")
    public KD_Dashboard validateMeinTarifSOMsgOnlyCLSCancelledT_KIPUser(String meinTarifSO_msgFooter1, String meinTarifSO_msgHeader1) {
    driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(meinTarifSO_msgHeader1);
    driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(meinTarifSO_msgFooter1);
    return this;
    }

    @Step("validate the message of the mein tarif Smart Object in case user has only cancelled Mein Tarif")
    public KD_Dashboard validateMeinTarifSOMsgOnlyMeinTCancelled_KIPUser(String meinTarifSO_msgHeader2, String meinTarifSO_msgFooter2) {
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(meinTarifSO_msgHeader2);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(meinTarifSO_msgFooter2);
        return this;
    }

    @Step("validate the message of the mein tarif Smart Object in case user has  cancelled CLS Tarif and cancelled Mein Tarif")
    public KD_Dashboard validateMeinTarifSOMsgWithCanceledMeinAndcancelledCLST_KIPUser(String kipUserCancelledMainTandCancelledCLST_Title, String kipUserCancelledMainTandCancelledCLST_Body) {
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(kipUserCancelledMainTandCancelledCLST_Title);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(kipUserCancelledMainTandCancelledCLST_Body);
        return this;
    }

    @Step("validate the message of the mein tarif Smart Object in case user has  cancelled Mein Tarif and active CLS Tarif")
    public KD_Dashboard validateMeinTarifSOMsgWithCanceledMeinTandCLSTarif_KIPUser(String kipUserCancelledMainTandActiveCLST_Title, String kipUserCancelledMainTandActiveCLST_Body) {
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(kipUserCancelledMainTandActiveCLST_Title);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(kipUserCancelledMainTandActiveCLST_Body);
        return this;
    }

    @Step("validate the message of the mein tarif Smart Object in case user has  cancelled CLS and active Mein Tarif")
    public KD_Dashboard validateMeinTarifSOMsgWithCanceledCLSTandMeinTarif_KIPUser(String kipUserActiveCLSTandCancelledMeinTarif_Body) {
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(kipUserActiveCLSTandCancelledMeinTarif_Body);
        return this;
    }

    @Step("validate the message of the mein tarif Smart Object in case user has  Multiple CLS Tarifs")
    public KD_Dashboard validateMeinTarifSOMsgWithMultipleCLSTarif_KIPUser (String kipUserMultipleCLSTandOneISCancelled_Title, String kipUserMultipleCLSTandOneISCancelled_Body)
    {
        driver.verifyThat().element(meinTariff_SO_Body).textTrimmed().isEqualTo(kipUserMultipleCLSTandOneISCancelled_Title);
        driver.verifyThat().element(meinTariff_SO_Footer).textTrimmed().isEqualTo(kipUserMultipleCLSTandOneISCancelled_Body);

        return this;
    }

    @Step("assert on Tarif change SO that doesn't exist when there is only CLS tarif")
    public KD_Dashboard assertThatTariffChangeSODoesNotExist(){
        driver.assertThat().element(TariffChangeSOKIP).doesNotExist().perform();
        return this;
    }

    @Step("assert on Tarif change option that doesn't exist in the KIP burger menu")
    public KD_Dashboard assertThatTariffChangeDoesNotExistInKIPBurgerMenu(){
        driver.assertThat().element(ChangeTarifInKIPBurgerMenu).doesNotExist().perform();
        return this;
    }

    @Step("assert on Tarif change SO that exists when Mixed tarifs tarif")
    public KD_Dashboard assertThatTariffChangeSOExists(){
        driver.assertThat().element(TariffChangeSOKIP).exists().perform();
        return this;
    }

    @Step("validate that Mein Tarif SO in case there is only Cancelled CLS")
    public KD_Dashboard validateMeinTarifSOwithCancelledCLSTOnly(String TVUserCancelledCLSTOnly_Title, String TVUserCancelledCLSTOnly_Body) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(TVUserCancelledCLSTOnly_Title);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(TVUserCancelledCLSTOnly_Body);
        return this;
    }

    @Step("validate that Mein Tarif SO in case there is only Cancelled Mein Tarif")
    public KD_Dashboard validateMeinTarifSOwithCancelledMainTOnly(String TVUserCancelledMainTOnly_Title, String TVUserCancelledMainTOnly_Body) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(TVUserCancelledMainTOnly_Title);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(TVUserCancelledMainTOnly_Body);
        return this;
    }

    @Step("validate that Mein Tarif SO in case there are Cancelled Mein Tarif and Cancelled CLS Tarif")
    public KD_Dashboard validateMeinTarifSOMsgWithCanceledMeinAndcancelledCLST(String TVUserAactiveMainTandCancelledCLST_Title, String TVUserAactiveMainTandCancelledCLST_Body) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(TVUserAactiveMainTandCancelledCLST_Title);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(TVUserAactiveMainTandCancelledCLST_Body);
        return this;
    }

    @Step("validate that Mein Tarif SO in case there are Cancelled CLS Tarif and Active Mein Tarif")
    public KD_Dashboard validateMeinTarifSOwithAactiveMainTandCancelledCLST(String TVUserAactiveMainTandCancelledCLST_Body) {
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(TVUserAactiveMainTandCancelledCLST_Body);
        return this;
    }

    @Step("validate that Mein Tarif SO in case there are Cancelled Mein Tarif and Not Cancelled CLS Tarif")
    public KD_Dashboard validateMeinTarifSOMsgWithCanceledMeinTandCLSTarif(String TVUserCancelledMainTandActiveCLST_Title, String TVUserCancelledMainTandActiveCLST_Body) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(TVUserCancelledMainTandActiveCLST_Title);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(TVUserCancelledMainTandActiveCLST_Body);
        return this;
    }

    @Step("validate that Mein Tarif SO in case there are Multiple Mein Tariffs and only one Cancelled")
    public KD_Dashboard validateTVUserWithMultipleMainTandOneMainTCancelled(String TVUserMultipleMainTandOneMainTCancelled_Title, String TVUserMultipleMainTandOneMainTCancelled_Body) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(TVUserMultipleMainTandOneMainTCancelled_Title);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(TVUserMultipleMainTandOneMainTCancelled_Body);
        return this;
    }

    @Step("validate that Mein Tarif SO in case there are Multiple Mein Tariffs and All are Cancelled")
    public KD_Dashboard validateTVUserWithMultipleMainTandAllTCancelled(String TVUserMultipleMainTandTwoMainTCancelled_Title, String TVUserMultipleMainTandTwoMainTCancelled_Body) {
        driver.verifyThat().element(meinTariff_SO_Body_KabelTV).textTrimmed().isEqualTo(TVUserMultipleMainTandTwoMainTCancelled_Title);
        driver.verifyThat().element(meinTariff_SO_Footer_KabelTV).textTrimmed().isEqualTo(TVUserMultipleMainTandTwoMainTCancelled_Body);
        return this;
    }

    @Step("validate Giga TV Gerate Smart Object")
    public KD_Dashboard validateGigaTVGerateSO(String GigaTVGerateSOHeaderCL, String GigaTVGerateSOSubLineCL){
        driver.verifyThat().element(gigaTVGerateSO).exists().perform();
        driver.verifyThat().element(gigaTVGerateSOHeader).text().isEqualTo(GigaTVGerateSOHeaderCL).perform();
        driver.verifyThat().element(gigaTVGerateSOSubLine).text().isEqualTo(GigaTVGerateSOSubLineCL).perform();
        return this;
    }

    @Step("Validate Device and Setting from burger menu")
    public KD_Dashboard validateDeviceAndSettingBurgerMenu(String DeviceAndSettingBurgerMenuCL){
        driver.verifyThat().element(deviceAndSettingBurgerMenu).text().isEqualTo(DeviceAndSettingBurgerMenuCL).perform();
        return this;
    }
}