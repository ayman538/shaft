package de.vodafone.pages.eShop;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class eShop_Dashboard {

    private SHAFT.GUI.WebDriver driver;

    public static By mobileButton = By.xpath("//li[@id='nav-beea8835-1f3e-4f8e-a6b9-424e327d3fbd' and contains(.,'Mobilfunk')]");
    private static By mobilfunkMegaDropDown = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By newContractWithSmartphone = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By ageCheck = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By newContractWITHOUTSmartphone = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");

    public static String deepLinkDeviceFirstFLowURL = "simplicity/apps/bob-device-overview-app/js/index.html";
    public static String deepLinkTariffFirstFLowURLConsumer = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=2505";
    public static String deepLinkTariffFirstFLowURLSoho = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=2505";
    public static String deepLinkTariffFirstFLowURLRedPlus = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=10044";
    public static String deepLinkTariffFirstFLowURLYoung = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=2540";

    public eShop_Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    @Step("Clicking on the Mobile Button ")
    public eShop_Dashboard clickOnMobileButton(){
        driver.element().click(mobileButton);
        return this;
    }

    // Will be used only in case of SIT
    public eShop_Dashboard navigateToDeviceFirstFlowPage() {
        driver.element().hover(mobilfunkMegaDropDown).click(newContractWithSmartphone);
        return this;
    }

    public eShop_Dashboard navigateToTariffFirstFlowPage() {
        driver.element().hover(mobilfunkMegaDropDown).click(newContractWITHOUTSmartphone);
        return this;
    }

    public eShop_Dashboard clickONAgeCheck() {
        driver.element().click(ageCheck);
        return this;
    }

    @Step("Deeplink to device first flow page.")
    public eShop_Dashboard deepLinkToDeviceFirstFlow () {
        navigateToURLST(deepLinkDeviceFirstFLowURL);
        return this;
    }

    @Step("Deeplink to Tariff first flow page - Consumer")
    public eShop_Dashboard deepLinkToTariffFirstFlowConsumer() {
        navigateToURLST(deepLinkTariffFirstFLowURLConsumer);
        return this;
    }

    @Step("Deeplink to Tariff first flow page - Soho")
    public eShop_Dashboard deepLinkToTariffFirstFlowSoho() {
        navigateToURLST(deepLinkTariffFirstFLowURLSoho);
        return this;
    }

    @Step("Deeplink to Tariff first flow page - Young")
    public eShop_Dashboard deepLinkToTariffFirstFlowYoung () {
        navigateToURLST(deepLinkTariffFirstFLowURLYoung);
        return this;
    }

    @Step("Deeplink to Tariff first flow page - RedPlus")
    public eShop_Dashboard deepLinkToTariffFirstFlowRedPlus () {
        navigateToURLST(deepLinkTariffFirstFLowURLRedPlus);
        return this;
    }


    @Step ("Navigate to URL ST Version")
    public eShop_Dashboard navigateToURLST(String deepLink) {
        String url = System.getProperty("de.vodafone.baseUrl.st") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    @Step("Deeplink to device first flow page.")
    public eShop_Dashboard deepLinkToDeviceFirstFlowSIT () {
        navigateToURLSIT(deepLinkDeviceFirstFLowURL);
        return this;
    }
    @Step("Deeplink to Tariff first flow page.")
    public eShop_Dashboard deepLinkToTariffFirstFlowSIT () {
        navigateToURLST(deepLinkTariffFirstFLowURLConsumer);
        return this;
    }

    @Step ("Navigate to URL SIT Version")
    public eShop_Dashboard navigateToURLSIT(String deepLink) {
        String url = System.getProperty("de.vodafone.baseUrl.sit") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }
}
