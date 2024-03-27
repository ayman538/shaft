package de.vodafone.pages.eShop;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DeviceListPage {

    private SHAFT.GUI.WebDriver driver;

    private static By pageHeader = By.xpath("//*[@data-automation-id='mainHeader_tv']");
    private static By pageSubHeader = By.xpath("//*[@data-automation-id='subHeader_tv']");
    private static By devicesCounter = By.xpath("//*[@data-automation-id='productListing_lv']/p/span");
    private static By devicesCount = By.xpath("//*[@data-automation-id='productListing_lv']/p/strong");
    private static By filterYourSelection = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By productCard = By.xpath("(//*[@data-automation-id='productListing_lv']//a[1])[1]");
    private static By moreInfoLink = By.xpath("(//*[@target='_self'][1])[4]");
    private static By otherManufacturer = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By fAQSection = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By moreOffersSection = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By deviceImage = By.xpath("(//*[@data-automation-id='productListing_lv']//picture)[1]");
    private static By deviceName = By.xpath("(//*[@data-automation-id='productListing_lv']//h3)[1]");
    private static By manufacturerLogo = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By fAQAndAnswers = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By otherOffers  = By.xpath("(//*[@data-automation-id='productListing_lv' and contains(.,'Tauschbonussichern')])[1]");
    private static By otherOffersLinks = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By loadMoreCTA = By.xpath("//*[@data-automation-id='showMore_btn']");
    private static By monthlyTariffCost = By.xpath("(//*[@data-automation-id='productListing_lv']//p)[2]");
    private static By zeroDevicesErrorMsg = By.xpath("//*[@data-automation-id='zeroDevices_tv']");
    private static By pageFailedErrorMsgHeader = By.xpath("//*[@data-automation-id='error_nt']/h5");
    private static By pageFailedErrorMsgBody = By.xpath("//*[@data-automation-id='error_nt']/p");
    private static By productDetailsPageHeader = By.xpath("//*[@id='hardware-overview__headline']//h1");
    private static By oneTimeContributionCost = By.xpath("(//*[@data-automation-id='productListing_lv']//div[2])[3]");

    // CL
    private String expectedTitleProductDetailsPage = "Handy mit Vertrag bestellen | Vodafone";
    private String expectedTitleDevicesListPage = "Bob App";
    private static String pageHeader_CL = "Handy mit Vertrag";
    private static String pageHeaderYoung_CL = "Smartphones für junge Leute";
    private static String pageSubHeader_CL = "Such Dir Dein neues Smartphone mit Tarif aus – z.B. von Apple oder Samsung.";
    private static String filterYourSelection_CL = "Filter Deine Auswahl:";
    private static String devicesCounter_CL = "Smartphones sortiert nach Beliebtheit";
    private static String moreInfoLink_CL = "Mehr Infos";
    private static String otherManufacturer_CL = "Unsere Hersteller";
    private static String moreOffersSection_CL = "Mehr Handy-Angebote für Dich";
    private static String fAQSection_CL = "Häufige Fragen zu unseren Smartphones und Tarifen";
    private static String otherOffers_CL  = "Mehr Handy-Angebote für Dich";
    private static String loadMoreCTA_CL  = "Mehr Smartphones anzeigen";
    private static String monthlyTariffCost_CL  = "Zuzahlung pro Monat zum Tarif";
    private static String zeroDevicesErrorMsg_CL  = "Kein passendes Smartphones gefunden";
    private static String redPlusZeroDevicesErrorMsg_CL  = "Kein passendes Smartphones gefunden";
    private static String sohoZeroDevicesErrorMsg_CL  = "Kein passendes Smartphones gefunden";
    private static String  PageFailedErrorMsgHeader_CL  = "Tut uns leid!";
    private static String  PageFailedErrorMsgBody_CL  = "Bei der Datenübertragung ist uns ein Fehler passiert. Bitte lad die Seite neu.";
    private static String redPlus_PageHeader_CL = "Smartphones mit Zusatzkarte";
    private static String redPlus_PageSubHeader_CL = "Such Dir ein passendes Smartphone zu Deiner ";
    private static String redPlus_Tariff_CL1 ="FamilyCard S"+" aus.";
    private static String redPlus_Tariff_CL2 ="FamilyCard M"+" aus.";
    private static String redPlus_Tariff_CL3 ="FamilyCard L"+" aus.";
    private static String soho_PageHeader_CL = "Smartphones für Selbständige";
    private static String soho_PageSubHeader_CL = "Bei Vodafone findest Du die neusten und beliebtesten Smartphones mit Vertrag.";


    public DeviceListPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    // Header and SubHeader not exist in ST
    @Step("Validate Device list page Header and sub header CL")
    public DeviceListPage validateHeaderAndSubHeaderCL(){
        driver.assertThat().element(pageHeader).text().isEqualTo(pageHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().isEqualTo(pageSubHeader_CL).perform();
        return this;
    }

    @Step("Validate Young Device list page Header CL")
    public DeviceListPage validateYoungHeaderCL(){
        driver.assertThat().element(pageHeader).text().isEqualTo(pageHeaderYoung_CL).perform();
        return this;
    }

    // Filters section will appear in filtration story WFHT_284
    @Step("validateFilterYourDevicesSection")
    public DeviceListPage validateFilterYourDevicesSection(){
        driver.assertThat().element(filterYourSelection).text().isEqualTo(filterYourSelection_CL).perform();
        return this;
    }

    @Step("validateDevicesCounter")
    public DeviceListPage validateDevicesCounter(){
        waitForDevicesListPageLoading();
        driver.assertThat().element(devicesCounter).text().contains(devicesCounter_CL).perform();
        return this;
    }

    @Step("validateProductCard")
    public DeviceListPage verifyMonthlyTariffCostShownInTariffFirstFlow(){
        driver.assertThat().element(monthlyTariffCost).text().contains(monthlyTariffCost_CL).perform();
        return this;
    }

    //Will not appear in ST
    @Step("validateOtherManufacturerSection")
    public DeviceListPage validateOtherManufacturerSection(){
        driver.assertThat().element(otherManufacturer).text().isEqualTo(otherManufacturer_CL).perform();
        driver.assertThat().element(manufacturerLogo).exists().perform();

        return this;
    }
    @Step("validateFAQSection")
    public DeviceListPage validateFAQSection(){
        driver.assertThat().element(fAQSection).text().isEqualTo(fAQSection_CL).perform();
        driver.assertThat().element(fAQAndAnswers).exists().perform();
        return this;
    }

    @Step("validateMoreOffersSection")
    public DeviceListPage validateMoreOffersSection(){
        //  driver.assertThat().element(ProductCard).exists().perform();
        driver.assertThat().element(moreOffersSection).text().isEqualTo(moreOffersSection_CL).perform();
        return this;
    }

    @Step("validateProductCardMandatoryFields")
    public DeviceListPage validateProductCardMandatoryFields(){
        driver.assertThat().element(deviceImage).exists().perform();
        driver.assertThat().element(deviceName).exists().perform();
        driver.assertThat().element(moreInfoLink).exists().perform();
        return this;
    }

    @Step("validateProductCardMandatoryFields - Young")
    public DeviceListPage validateProductCardMandatoryFieldsYoung(){
        driver.assertThat().element(deviceImage).exists().perform();
        driver.assertThat().element(deviceName).exists().perform();
        driver.assertThat().element(moreInfoLink).exists().perform();
        driver.assertThat().element(oneTimeContributionCost).exists().perform();
        return this;
    }

    @Step("validate that LoadMore CTA shows 12 more devices each click ")
    public DeviceListPage validateLoadMoreCTAMoreThan12(){
        driver.assertThat().element(loadMoreCTA).text().isEqualTo(loadMoreCTA_CL).perform();
        driver.element().click(loadMoreCTA);
        driver.element().click(loadMoreCTA);
        return this;
    }

    @Step("validate that LoadMore CTA is hidden if less than 12 devices exist ")
    public DeviceListPage validateLoadMoreCTALessThanOrEqual12(){
        driver.assertThat().element(loadMoreCTA).doesNotExist().perform();
        return this;
    }

    @Step("validateProductCardIsClickable")
    public DeviceListPage validateProductCardIsClickable(){
        driver.element().click(productCard);
        driver.assertThat().element(productDetailsPageHeader).exists().perform();
        return this;
    }

    @Step("validateProductCardIsLoaded")
    public DeviceListPage validateProductCardIsLoaded(){
        waitForDevicesListPageLoading();
        driver.assertThat().element(productCard).exists().perform();
        return this;
    }
    @Step("validateErrorMsgIfPageFailed ")
    public DeviceListPage validateErrorMsgIfPageFailed(){
        driver.assertThat().element(pageFailedErrorMsgHeader).text().isEqualTo(PageFailedErrorMsgHeader_CL).perform();
        driver.assertThat().element(pageFailedErrorMsgBody).text().isEqualTo(PageFailedErrorMsgBody_CL).perform();

        return this;
    }
    @Step("validateErrorMsgIfZeroDevicesDisplayed ")
    public DeviceListPage validateErrorMsgIfZeroDevicesDisplayed(){
        driver.assertThat().element(zeroDevicesErrorMsg).text().isEqualTo(zeroDevicesErrorMsg_CL).perform();
        return this;
    }

    @Step("validateErrorMsgIfZeroDevicesDisplayed - RedPlus")
    public DeviceListPage validateErrorMsgIfZeroDevicesDisplayedRedPlus(){
        driver.assertThat().element(zeroDevicesErrorMsg).text().isEqualTo(redPlusZeroDevicesErrorMsg_CL).perform();
        return this;
    }

    @Step("validateErrorMsgIfZeroDevicesDisplayed - Soho")
    public DeviceListPage validateErrorMsgIfZeroDevicesDisplayedSoho(){
        driver.assertThat().element(zeroDevicesErrorMsg).text().isEqualTo(sohoZeroDevicesErrorMsg_CL).perform();
        return this;
    }

    @Step("validate existence of ProductCard")
    public void validateProductCardExistence(){
        driver.assertThat().element(productCard).exists().perform();
    }

    @Step("validateProductCard")
    public DeviceListPage verifyMonthlyTariffCostNOTEXISTEDInDeviceFirstFlow(){
        driver.assertThat().element(monthlyTariffCost).doesNotExist().perform();
        return this;
    }

    @Step("validateOtherOffersSection")
    public DeviceListPage validateOtherOffersSection(){
        driver.assertThat().element(otherOffers).text().isEqualTo(otherOffers_CL).perform();
        driver.assertThat().element(otherOffersLinks).exists().perform();
        return this;
    }

    @Step("validateMoreInfoLinkRedirection")
    public DeviceListPage verifyMoreInfoLinkRedirection(){
        waitForProductDetailsPageLoading();
        driver.assertThat().browser().url().contains("privat/handys").perform();

        return this;
    }

    @Step("Click on More Info Button")
    public DeviceListPage clickOnZumProductButton() {
        driver.assertThat().element(moreInfoLink).exists().perform();
        driver.element().click(moreInfoLink);

        return this;
    }

    @Step("validateProductCardMandatoryFields - Red Plus")
    public DeviceListPage validateRedPlusProductCardMandatoryFields(){
        driver.assertThat().element(deviceImage).exists().perform();
        driver.assertThat().element(deviceName).exists().perform();
        driver.assertThat().element(moreInfoLink).exists().perform();
        driver.assertThat().element(otherOffers).exists().perform();
        return this;
    }

    @Step("Get number of devices")
    public String get_Devices_Count() {
        String count = driver.element().getText(devicesCount);
        return count;
    }

    @Step("validateDevicesNumber")
    public DeviceListPage validateDevicesNumberLargerThan12(){
        String Devices_count = get_Devices_Count();
        int Devices = Integer.parseInt(Devices_count);
        System.out.println("Devices count "+ get_Devices_Count());

        SHAFT.Validations
                .verifyThat()
                .number(Devices)
                .isGreaterThan(12)
                .perform();

        return this;
    }
    @Step("validateDevicesNumber")
    public DeviceListPage validateDevicesNumberLessThan12(){
        String Devices_count = get_Devices_Count();
        int Devices = Integer.parseInt(Devices_count);
        System.out.println("Devices count "+ get_Devices_Count());

        SHAFT.Validations
                .verifyThat()
                .number(Devices)
                .isLessThan(12)
                .perform();

        return this;
    }

    @Step("validateProductCard")
    public DeviceListPage validateProductCard(){
        driver.assertThat().element(productCard).exists().perform();
        driver.assertThat().element(moreInfoLink).text().isEqualTo(moreInfoLink_CL).perform();
        return this;
    }

    @Step("Validate Device list page Header and sub header CL - FamilyCard S")
    public DeviceListPage validateRedPlusHeaderAndSubHeaderCLFamilyCardS(){
        driver.assertThat().element(pageHeader).text().isEqualTo(redPlus_PageHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(redPlus_PageSubHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(redPlus_Tariff_CL1).perform();
        return this;
    }

    @Step("Validate Device list page Header and sub header CL - FamilyCard M")
    public DeviceListPage validateRedPlusHeaderAndSubHeaderCLFamilyCardM(){
        driver.assertThat().element(pageHeader).text().isEqualTo(redPlus_PageHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(redPlus_PageSubHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(redPlus_Tariff_CL2).perform();
        return this;
    }

    @Step("Validate Device list page Header and sub header CL - FamilyCard L")
    public DeviceListPage validateRedPlusHeaderAndSubHeaderCLFamilyCardL(){
        driver.assertThat().element(pageHeader).text().isEqualTo(redPlus_PageHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(redPlus_PageSubHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(redPlus_Tariff_CL3).perform();
        return this;
    }

    @Step("validateProductCardMandatoryFields - Soho")
    public DeviceListPage validateSohoProductCardMandatoryFields(){
        driver.assertThat().element(deviceImage).exists().perform();
        driver.assertThat().element(deviceName).exists().perform();
        driver.assertThat().element(moreInfoLink).exists().perform();
        driver.assertThat().element(otherOffers).exists().perform();
        return this;
    }

    @Step("Validate Device list page Header and sub header CL")
    public DeviceListPage validateSohoHeaderAndSubHeaderCL(){
        driver.assertThat().element(pageHeader).text().isEqualTo(soho_PageHeader_CL).perform();
        driver.assertThat().element(pageSubHeader).text().isEqualTo(soho_PageSubHeader_CL).perform();
        return this;
    }

    @Step("wait for Product Details Page to be Loaded Fully")
    public DeviceListPage waitForProductDetailsPageLoading(){
        new WebDriverWait(driver.getDriver(), Duration.ofSeconds(Long.parseLong(System.getProperty("browserNavigationTimeout"))))
                .until(ExpectedConditions.titleIs(expectedTitleProductDetailsPage));
        return this;
    }

    @Step("wait for Devices List Page to be Loaded Fully")
    public DeviceListPage waitForDevicesListPageLoading(){
        new WebDriverWait(driver.getDriver(), Duration.ofSeconds(Long.parseLong(System.getProperty("browserNavigationTimeout"))))
                .until(ExpectedConditions.titleIs(expectedTitleDevicesListPage));
        return this;
    }
}