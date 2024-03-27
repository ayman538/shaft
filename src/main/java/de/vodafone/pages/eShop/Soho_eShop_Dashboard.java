package de.vodafone.pages.eShop;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Soho_eShop_Dashboard {

    private SHAFT.GUI.WebDriver driver;

    private static By mobilFunkMegaDropDown = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By neuerVertragMitSmartphoneButton = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By neuerVertragOhneSmartphoneButton = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By ichBinSelbständigButton = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By newContractWithSmartphone = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By newContractWITHOUTSmartphone = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By smartphonesFürSelbständige = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By smartPhoneDazuButton = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");

    private static String zuSatzKarteDeepLink = "/privat/smartphones-tarife/alle-smartphones-zusatzkarten.html?tariffId=10044";
    private static String smartphonesFürSelbständigeDeepLink = "/privat/smartphones-tarife/smartphones-fuer-selbstaendige.html";
    private static String deepLinkDeviceFirstFLowURL = "simplicity/apps/bob-device-overview-app/js/index.html";
    private static String deepLinkTariffFirstFLowURL = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=2025";

    public Soho_eShop_Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    @Step("Entry Point in SIT")
    public Soho_eShop_Dashboard navigateToDeviceFirstFlowPage() {
        driver.element().hover(mobilFunkMegaDropDown).click(newContractWithSmartphone);
        return this;
    }
    @Step ("Entry Point in SIT")
    public Soho_eShop_Dashboard navigateToDeviceHandyAngeboteFürSelbständige() {
        driver.element().hover(mobilFunkMegaDropDown).hover(newContractWITHOUTSmartphone).click(smartphonesFürSelbständige);
        return this;
    }
    @Step ("Entry Point in SIT")
    public Soho_eShop_Dashboard navigateToTariffHandyAngeboteFürSelbständige() {
        driver.element().hover(mobilFunkMegaDropDown).hover(newContractWITHOUTSmartphone).click(smartphonesFürSelbständige);
        return this;
    }
    @Step ("Entry Point in SIT")
    public Soho_eShop_Dashboard navigateToTariffFirstFlowPage() {
        driver.element().hover(mobilFunkMegaDropDown).click(newContractWITHOUTSmartphone);
        return this;
    }

    @Step ("Button in SIT")
    public Soho_eShop_Dashboard clickOnSmartPhoneDazuButton() {
        driver.element().click(smartPhoneDazuButton);

        return this;
    }

    @Step ("Button in SIT")
    public Soho_eShop_Dashboard clickOnMobileFunk() {
        driver.element().click(mobilFunkMegaDropDown);

        return this;
    }

    @Step ("Button in SIT")
    public Soho_eShop_Dashboard clickOnNeuerVertragMitSmartphone() {
        driver.element().click(neuerVertragMitSmartphoneButton);

        return this;
    }

    @Step ("Button in SIT")
    public Soho_eShop_Dashboard clickOnNeuerVertragOhneSmartphone() {
        driver.element().click(neuerVertragOhneSmartphoneButton);

        return this;
    }

    @Step ("Button in SIT")
    public Soho_eShop_Dashboard clickOnIchBinSelbständig() {
        driver.element().click(ichBinSelbständigButton);

        return this;
    }

    @Step ("Entry Point in SIT")
    public Soho_eShop_Dashboard deepLinkToSmartphonesWithAdditionalCardsListPage() {
        navigateToURLST(zuSatzKarteDeepLink);

        return this;
    }

    @Step ("Entry Point in SIT")
    public Soho_eShop_Dashboard deepLinkToSmartphonesForSelfEmployedPage() {
        navigateToURLST(smartphonesFürSelbständigeDeepLink);

        return this;
    }

    @Step ("Navigate to URL ST Version")
    public Soho_eShop_Dashboard navigateToURLST(String deepLink) {
        String url = System.getProperty("de.vodafone.baseUrl.st") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    @Step("Deeplink to Device First Flow")
    public Soho_eShop_Dashboard deeplinkToDeviceFirstFlowPage() {
        navigateToURLST(deepLinkDeviceFirstFLowURL);
        return this;
    }

    @Step("Deeplink to Tariff First Flow")
    public Soho_eShop_Dashboard deeplinkToTariffFirstFlowPage() {
        navigateToURLST(deepLinkTariffFirstFLowURL);
        return this;
    }

    @Step ("Navigate to URL SIT Version")
    public Soho_eShop_Dashboard navigateToURLSIT(String deepLink) {
        String url = System.getProperty("de.vodafone.baseUrl.sit") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    @Step("Deeplink to Device First Flow")
    public Soho_eShop_Dashboard deeplinkToDeviceFirstFlowPageSIT() {
        navigateToURLSIT(deepLinkDeviceFirstFLowURL);
        return this;
    }

    @Step("Deeplink to Tariff First Flow")
    public Soho_eShop_Dashboard deeplinkToTariffFirstFlowPageSIT() {
        navigateToURLSIT(deepLinkTariffFirstFLowURL);
        return this;
    }
}
