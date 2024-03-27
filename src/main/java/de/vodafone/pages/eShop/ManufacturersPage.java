package de.vodafone.pages.eShop;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ManufacturersPage {
    private SHAFT.GUI.WebDriver driver;

    private static By pageHeader = By.xpath("//*[@data-automation-id='mainHeader_tv']");
    private static By pageSubHeader = By.xpath("//*[@data-automation-id='subHeader_tv']");
    private static By filterYourSection = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By numberOfDisplayedDevices = By.xpath("//*[@data-automation-id='productListing_lv']//p/strong");
    private static By moreInfoLink = By.xpath("(//*[@data-automation-id='productListing_lv']//a//a)[1]");
    private static By productCard= By.xpath("(//*[@data-automation-id='productListing_lv'])//div[@name='iPhone 14 Plus' and @class='sc-jnOGJG fxBtWX']");
    private static By appleManfacurerOption = By.xpath("//div//img[@title='Apple-iPhones']");
    private static By samsungManfactureOption = By.xpath("//div//img[@title='Samsung-Smartphones']");
    private static By xiaomiManfactureOption = By.xpath("//div//img[@title='Xiaomi-Smartphones']");
    private static By sonyManfactureOption = By.xpath("//div//img[@title='Sony-Smartphones']");
    private static By googleManfactureOption = By.xpath("//div//img[@title='Google-Smartphones']");
    private static By alleSmartphonesAnzeigenButton = By.id("button-1254285");
    private static By weitereIPhonesButton = By.xpath("//div[@id='hardware-overview__more-items']//button[@type='button']");
    private static By faildToLoadError  = By.xpath("//*[@data-automation-id='error_nt']/p");
    private static By zeroDevicesError = By.xpath("//*[@data-automation-id='zeroDevices_tv']");
    private static By loadMoreCTA = By.xpath("//*[@data-automation-id='showMore_btn']");


    private static String loadMoreCTA_CL = "Mehr Smartphones anzeigen";
    private static String failedLodingErrorMsg_CL = "Bei der Datenübertragung ist uns ein Fehler passiert. Bitte lad die Seite neu.";
    private static String zeroDevicesErrorMsg_CL = "Kein passendes Smartphones gefunden";
    private static String pageHeaderCL =   "Such Dir ein passendes ";
    private static String pageHeaderAppleCL =   "iPhone" +" aus";
    private static String pageHeaderSamsungCL = "Samsung-Smartphone"+" aus";
    private static String pageHeaderXiaomiCL =  "Xiaomi-Handy mit Vertrag"+" aus";
    private static String pageHeaderGoogleCL =  "Google-Smartphone"+" aus";
    private static String subHeaderCL=   "Bei Vodafone findest Du die neusten und beliebtesten Smartphones von ";
    private static String subHeaderAppleCL =   "Apple"+" mit Vertrag.";
    private static String subHeaderSamsungCL = "Samsung"+" mit Vertrag.";
    private static String subHeaderXiaomiCL =  "Xiaomi"+" mit Vertrag.";
    private static String subHeaderGoogleCL =  "Google"+" mit Vertrag.";

    public ManufacturersPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Validations
    @Step("Validate on the page Header matches the Manufacturer option ")
    public ManufacturersPage validateOnPageHeader() {
      driver.assertThat().element(pageHeader).text().isEqualTo(samsungManfactureOption).perform();
        return this;
    }

    @Step("Validate on the page Header matches the Apple Manufacturer option ")
    public ManufacturersPage validateOnPageHeaderInCaseApple() {
        driver.assertThat().element(pageHeader).text().contains(pageHeaderCL).perform();
        driver.assertThat().element(pageHeader).text().contains(pageHeaderAppleCL).perform();
        return this;
    }

    @Step("Validate on the page Header matches Samsung Manufacturer option ")
    public ManufacturersPage validateOnPageHeaderInCaseSamsung() {
        driver.assertThat().element(pageHeader).text().contains(pageHeaderCL).perform();
        driver.assertThat().element(pageHeader).text().contains(pageHeaderSamsungCL).perform();
        return this;
    }

    @Step("Validate on the page Header matches Xiaomi Manufacturer option ")
    public ManufacturersPage validateOnPageHeaderInCaseXiaomi() {
        driver.assertThat().element(pageHeader).text().contains(pageHeaderCL).perform();
        driver.assertThat().element(pageHeader).text().contains(pageHeaderXiaomiCL).perform();
        return this;
    }

    @Step("Validate on the page Header matches Google Manufacturer option ")
    public ManufacturersPage validateOnPageHeaderInCaseGoogle() {
        driver.assertThat().element(pageHeader).text().contains(pageHeaderCL).perform();
        driver.assertThat().element(pageHeader).text().contains(pageHeaderGoogleCL).perform();
        return this;
    }
    @Step("Validate on the sub page Header matches Apple Manufacturer option ")
    public ManufacturersPage validateOnSubPageHeaderInCaseApple() {
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderCL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderAppleCL).perform();
        return this;
    }
    @Step("Validate on the sub page Header matches Samsung Manufacturer option ")
    public ManufacturersPage validateOnSubPageHeaderInCaseSamsung() {
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderCL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderSamsungCL).perform();
        return this;
    }

    @Step("Validate on the sub page Header matches Xiaomi Manufacturer option ")
    public ManufacturersPage validateOnSubPageHeaderInCaseXiaomi() {
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderCL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderXiaomiCL).perform();
        return this;
    }
    @Step("Validate on the sub page Header matches Google Manufacturer option ")
    public ManufacturersPage validateOnSubPageHeaderInCaseGoogle() {
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderCL).perform();
        driver.assertThat().element(pageSubHeader).text().contains(subHeaderGoogleCL).perform();
        return this;
    }

    @Step("Validate that No filters are displayed")
    public ManufacturersPage validateOnNoFilters(){
        driver.verifyThat().element(filterYourSection).doesNotExist().perform();
        return this ;
    }

    @Step("Check on the number of Displayed Devices in case of choosing any Manufacturer")
    public ManufacturersPage checkNumberOfDisplayedDevices(){
        driver.assertThat().element(numberOfDisplayedDevices).isVisible().perform();
        return this;
    }


    @Step("Validate on the Product Card is clickable")
    public ManufacturersPage validateProductCardIsClickable(){
        driver.element().click(productCard);
        return this;
    }

    @Step("Check that the More info link is clickable")
    public ManufacturersPage clickOnMoreInfoLink(){
        driver.element().click(moreInfoLink);
        return this; // Redirects to the product details page
    }

    @Step("Validate on Clicking on the AlleSmartPhonesAnzeigen Button is clickable")
    public ManufacturersPage clickOnAlleSmartPhonesAnzeigen(){
        driver.element().click(alleSmartphonesAnzeigenButton);
        return this; //Redirects back to general Dop page
    }

    @Step("Assert that SmartPhonesAnzeigenButton redirects to DOP")
    public ManufacturersPage assertThatSmartPhonesAnzeigenButtonRedirectsToDop(){
        driver.assertThat().browser().url().contains("privat/handys").perform();
        return this ;
    }

    @Step("Clicking on Apple Manufacturer option in the DOP")
    public ManufacturersPage clickOnAppleManufacturerOption(){
        driver.element().click(appleManfacurerOption);
        return this;
    }

    @Step("Clicking on Samsung Manufacturer option in the DOP")
    public ManufacturersPage clickOnSamsungManufacturerOption(){
        driver.element().click(samsungManfactureOption);
        return this;
    }

    @Step("Clicking on Xiaomi Manufacturer option in the DOP")
    public ManufacturersPage clickOnXiaomiManufacturerOption(){
        driver.element().click(xiaomiManfactureOption);
        return  this;
    }
    
    //In case of Clicking on Apple Manufactutrer option
    @Step("Clicking on WeitereIphones Button in case of choosing Apple Manufacturer option ")
    public ManufacturersPage clickOnWeitereIphonesButton(){
        driver.element().click(weitereIPhonesButton);
        return this;
    }

    @Step("Get number of devices")
    public String get_Devices_Count() {
        String count = driver.element().getText(numberOfDisplayedDevices);
        return count;
    }

    @Step("validate that number Of Devices is more than 12 devices")
    public ManufacturersPage validateDevicesNumberLargerThan12(){
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

    @Step("validate that number Of Devices is less than 12 devices")
    public ManufacturersPage validateDevicesNumberLessThan12(){
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

    @Step("validate that LoadMore CTA shows 12 more devices each click ")
    public ManufacturersPage validateLoadMoreCTAMoreThan12(){
        driver.assertThat().element(loadMoreCTA).text().isEqualTo(loadMoreCTA_CL).perform();
        driver.element().click(loadMoreCTA);
        driver.element().click(loadMoreCTA);
        return this;
    }

    @Step("validate that LoadMore CTA is hidden if less than 12 devices exist ")
    public ManufacturersPage validateLoadMoreCTALessThanOrEqual12(){
        driver.assertThat().element(loadMoreCTA).doesNotExist().perform();
        return this;
    }


    @Step("Assert that WeitereIphones Button loaded more Devices in the same page ")
    public ManufacturersPage assertThatWeitereIphonesButtonloadedMoreDevicesInTheSamePage(){
        driver.assertThat().browser().url().isEqualTo("https://www.vodafone.de/privat/smartphones-tarife/apple-iphones.html").perform();
        return this ;
    }

    @Step("Assert that the Error message Appears in case of Faliure in loading ")
    public ManufacturersPage assertThatErrorMessageAppearsInCaseOfFailureInLoading(){
     driver.assertThat().element(faildToLoadError).text().isEqualTo(failedLodingErrorMsg_CL).perform();
         return this;
    }

    @Step("Assert that Zero Devices are displayed ")
    public ManufacturersPage assertOnZeroDevicesAreDisplayed(){
        driver.assertThat().element(zeroDevicesError).text().isEqualTo(zeroDevicesErrorMsg_CL).perform();
        return this;
    }


}
