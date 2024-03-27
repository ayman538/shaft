package de.vodafone.pages.eShop;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class RedPlusEshopDashboardPage {

    private SHAFT.GUI.WebDriver driver;

    private static By redPlusFamilyCardS=By.xpath("//*[@data-automation-id='productListing_lv']");
    private static By redPlusFamilyCardL =By.xpath("//*[@data-automation-id='productListing_lv']");
    private static By redPlusFamilyCardM =By.xpath("//*[@data-automation-id='productListing_lv']");
    private static By mobilFunkMegaDropDownMenu = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By newContractWithSmartphone = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By newContractWithoutSmartphone = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By zuSatzUndPartnerKarten = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By partnerKarteDazuBuchenDeepLinkButton = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");
    private static By smartPhoneDazuButton = By.xpath("(//li[@class='nav-item-main'and contains(.,'Mobilfunk')])[1]");

    private static String zusatzKarteDeepLink = "/privat/smartphones-tarife/alle-smartphones-zusatzkarten.html?tariffId=10044";
    private static String partnerkartedazubuchenDeepLink = "/privat/handys-tablets-tarife/zusatzkarten.html";
    private static String partnerkarteUndWeitereZusatzKartenDeepLink = "/privat/handys-tablets-tarife/zusatzkarten.html?icmp=op-mofu:dialog-mobilfunk:xsell:credit:redplus__ab_mf_0095_web:ab:p001";
    private static String deepLinkTariffFirstFLowURL = "simplicity/apps/bob-device-overview-app/js/index.html";
    private static String deepLinkTariffFirstFLowURLFamilyCardS = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=10044";
    private static String deepLinkTariffFirstFLowURLFamilyCardL = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=10046";
    private static String deepLinkTariffFirstFLowURLFamilyCardM = "simplicity/apps/bob-device-overview-app/js/index.html?tariffId=10045";

    public RedPlusEshopDashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step ("Entry Point in SIT")
    public RedPlusEshopDashboardPage navigateToMobilFunkPage() {
        driver.element().click(mobilFunkMegaDropDownMenu);
        return this;
    }

    @Step ("Entry Point in SIT")
    public RedPlusEshopDashboardPage navigateToDeviceFirstFlowPage() {
        driver.element().hover(mobilFunkMegaDropDownMenu).click(newContractWithSmartphone);
        return this;
    }

    @Step ("Entry Point in SIT")
    public RedPlusEshopDashboardPage navigateToTariffFirstFlowPage() {
        driver.element().hover(mobilFunkMegaDropDownMenu).click(newContractWithoutSmartphone);
        return this;
    }

    @Step ("Entry Point in SIT")
    public RedPlusEshopDashboardPage navigateToTariffFirstFlowPageDeeplink() {
        driver.element().hover(mobilFunkMegaDropDownMenu).hover(newContractWithoutSmartphone).click(zuSatzUndPartnerKarten);
        return this;
    }

    @Step ("Entry Point in SIT")
    public RedPlusEshopDashboardPage clickOnPartnerkartedazubuchenDeepLinkButton() {
        driver.element().click(partnerKarteDazuBuchenDeepLinkButton);

        return this;
    }

    @Step ("Button in SIT")
    public RedPlusEshopDashboardPage clickOnSmartPhoneDazuButton() {
        driver.element().click(smartPhoneDazuButton);

        return this;
    }

    @Step ("Entry Point in SIT")
    public RedPlusEshopDashboardPage deepLinkToSmartphonesWithAdditionalCardsListPage() {
        navigateToURLST(zusatzKarteDeepLink);

        return this;
    }

    @Step ("Entry Point in SIT")
    public RedPlusEshopDashboardPage deepLinkToPartnerCardsAndOtherAdditionalListPage() {
        navigateToURLST(partnerkartedazubuchenDeepLink);

        return this;
    }

    @Step ("Navigate to URL ST Version")
    public RedPlusEshopDashboardPage navigateToURLST(String deepLink) {
        String url = System.getProperty("de.vodafone.baseUrl.st") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    @Step ("Deeplink to Tariff First Flow")
    public RedPlusEshopDashboardPage deepLinkToTariffFirstFlow() {
        navigateToURLST(deepLinkTariffFirstFLowURL);

        return this;

    }

    @Step ("Deeplink to Tariff First Flow")
    public RedPlusEshopDashboardPage deepLinkToTariffFirstFlowFamilyCardS() {
        navigateToURLST(deepLinkTariffFirstFLowURLFamilyCardS);

        return this;

    }

    @Step ("Deeplink to Tariff First Flow")
    public RedPlusEshopDashboardPage deepLinkToTariffFirstFlowFamilyCardL() {
        navigateToURLST(deepLinkTariffFirstFLowURLFamilyCardL);

        return this;

    }

    @Step ("Deeplink to Tariff First Flow")
    public RedPlusEshopDashboardPage deepLinkToTariffFirstFlowFamilyCardM() {
        navigateToURLST(deepLinkTariffFirstFLowURLFamilyCardM);

        return this;

    }

    @Step ("Navigate to URL SIT Version")
    public RedPlusEshopDashboardPage navigateToURLSIT(String deepLink) {
        String url = System.getProperty("de.vodafone.baseUrl.sit") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    @Step ("Deeplink to Tariff First Flow")
    public RedPlusEshopDashboardPage deepLinkToTariffFirstFlowSIT() {
        navigateToURLSIT(deepLinkTariffFirstFLowURL);

        return this;

    }

    @Step ("Button in RedPlus Family")
    public RedPlusEshopDashboardPage clickOnFamilyCardS() {
        driver.element().click(redPlusFamilyCardS);

        return this;
    }

    @Step ("Button in RedPlus Family")
    public RedPlusEshopDashboardPage clickOnFamilyCardL() {
        driver.element().click(redPlusFamilyCardL);

        return this;
    }

    @Step ("Button in RedPlus Family")
    public RedPlusEshopDashboardPage clickOnFamilyCardM() {
        driver.element().click(redPlusFamilyCardM);

        return this;
    }
}
