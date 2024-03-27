package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


public class MeinTarifPage {
    private SHAFT.GUI.WebDriver driver;

    public MeinTarifPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    // Locators
    private By eazyProductHeader = By.xpath("//*[@class='flexDiv' and contains (.,'Du kannst den Tarif leider nicht online wechseln.')]");
    private By eazyProductNotificationBody = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By digitalTVProductHeader = By.xpath("//*[@class='flexDiv' and contains (.,'Du kannst den Tarif leider nicht online wechseln.')]");
    private By digitalTVProductNotificationBody = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By dunningProcessHeader = By.xpath("//*[@class='flexDiv' and contains (.,'Du hast noch unbezahlte Rechnungen.')]");
    private By dunningProcessNotificationBody = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By userHasOpenWorkOrderNotificationHeader = By.xpath("//*[@class='flexDiv' and contains (.,'Etwas Geduld noch, bitte...')]");
    private By userHasOpenWorkOrderNotificationBody = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By userHasOpenWorkOrderNotificationCTA = By.xpath("//button[@automation-id='customer_has_open_orders_btn']");

    private By contractDetailsHeader = By.xpath("//span[@automation-id='contractDetailsHeader_tv']");
    private By productPriceLabel_tv = By.xpath("//span[@automation-id='productPriceLabel_tv']");
    private By contractNumberLabel_tv = By.xpath("//span[@automation-id='contractNumberLabel_tv']");
    private By contractStartDateLabel_tv = By.xpath("//span[@automation-id='contractStartDateLabel_tv']");
    private By contractEndDateLable_tv = By.xpath("//span[@automation-id='contractEndDateLable_tv']");
    private By contractLastCancellationDateLable_tv = By.xpath("//span[@automation-id='contractLastCancellationDateLable_tv']");
    private By cancelConnection_Link = By.xpath("//a[@automation-id='cancelConnection_Link']");
    private By tariffChange_btn = By.xpath("//a[@automation-id='shopExternalLink_btn']");
    private By cableMeinTarifText_tv = By.xpath("//h3[@automation-id='cableMeinTarifText_tv']");
    private By hyperlinkPageAssertion = By.xpath("//div[@automation-id='landingPageTeaser_teaser']");
    private By changeTariffPage = By.xpath("//h1[@class='h1 hl-giga']");
    private By openWorkOrderLegacyPortal = By.xpath("//h1[text()='Willkommen bei MeinVodafone']");

    private By Campaign = By.xpath("(//*[@class='h2 red-text -txt'])[1]");
    private By eazyProductPage = By.xpath("//*[@class='heading-primary']");

    private By goOfferCTA = By.xpath("(//*[@class='btn btn-sml'])[2]");
    private By goOfferPage = By.xpath("//h1[text()='Weil Du schon Kund:in bist']");
    private By changeTariffHeader = By.xpath("//*[@automation-id='cableMeinTarifText_tv' and contains(.,'Du')]");
    private By availableTariffsChooser= By.xpath("//*[@class='tariff-block']");
    private By changeTariffCTA= By.xpath("//*[@automation-id='shopExternalLink_btn']");
    private By changeTariffExternalPage= By.xpath("//*[@data-qa-locator='brand-headline']");
    private By bestTariffNotificationHeader= By.xpath("//*[@class='flexDiv'and contains(.,'Du hast schon den besten Tarif')]");
    private By beErrorNotificationHeader = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private By apiDoesNotLoadErrorHeader = By.xpath("//*[@class='flexDiv'and contains(.,' nicht geklappt')]");
    private By beErrorNotificationBody = By.xpath("//div [@automation-id='successMsg_tv']//p");
    private By apiDoesNotLoadErrorNotificationBody = By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By bestTariffNotificationBody= By.xpath("//*[@class='notification-text mb-10 mt-10']");
    private By hotLineCTA = By.xpath("//*[@class='btn btn-em btn-sml only-sml']");
    private By eazyProductCTA= By.xpath("//*[@automation-id='customer_has_a_non_supported_product_btn']");
    private By upgradeTarifCard = By.xpath("//div[@class='front pb-15']");
    private By upgradeTarifCardPrice = By.xpath("//span[@automation-id='cableMeinTarif_bullet-card_price_tv']");
    private By upgradeTarifCardDetails = By.xpath("//a[@automation-id='cableMeinTarif_bullet-card_tariffDetailsLink_Link']");

    //CLs
    private String upgradeTarifCardDetailsCL = "Tarifdetails";
    private String apiDoesNotLoadErrorNotificationBodyCL = "Entschuldige bitte, unser Fehler. Versuch es bitte später nochmal.";
    private String eazyProductCTACL= "Kontakt um Eazy-Support aufnehmen";
    private String eazyProductNotificationBodyCL= "Wende Dich bitte an den Eazy-Support. Du erreichst uns Montag bis Freitag von 9 bis 22 Uhr zum Ortstarif oder einfach per Email.";
    private String dunningProcessNotificationBodyCL= "Bitte bezahle die noch offenen Beträge. Wenn die Zahlung bei uns eingegangen ist, kannst Du weitere Optionen buchen.";
    private String dunningProcessNotificationBodyCL1= "Tipp: Die Rechnugsbeträge findest Du unter \"Meine Rechnungen\". Bei Fragen wende Dich bitte an den Support.";
    private String digitalTVProductNotificationBodyCL= "Wende Dich bitte an den Support. Du erreichst uns von Montag bis Freitag von 8 bis 20 Uhr und Samstag von 9 bis 18 Uhr. Kostenlos aus allen deutschen Netzen.";
    private String userHasOpenWorkOrderNotificationCTACL= "Meine Aufträge anzeigen";
    private String userHasOpenWorkOrderNotificationBodyCL= "Wir bearbeiten noch Deinen letzten Auftrag. Wenn wir damit fertig sind, kannst Du weitere Optionen buchen.";
    private String userHasOpenWorkOrderNotificationBodyCL1=  "Tipp: Die Übersicht Deiner Aufträge findest Du in den Mitteilungen.";
    private String changeTariffCTACL = "Zum Tarifwechsel";
    private String bestTariffNotificationBodyCL = "Wir haben immer wieder neue Angebote. Und informieren Dich hier. Im Moment hast Du schon den besten Tarif. Wirf solange einen Blick auf unsere Angebote zum Kombinieren. Es lohnt sich!";
    private String changeTariffHeaderCL = "Du willst einen neuen Tarif?";
    private String contractDetailsHeaderCL = "Meine Vertragsdetails";
    private String productPriceLabel_tvCL = "Monatlicher Grundpreis *";
    private String contractNumberLabel_tvCL = "Vertragsnummer";
    private String contractStartDateLabel_tvCL = "Vertragsstart";
    private String contractEndDateLable_tvCL = "Vertrag läuft bis";
    private String contractLastCancellationDateLable_tvCL = "Letzter Kündigungstermin";
    private String cancelConnection_LinkCL = "Anschluss kündigen";
    private String tariffChange_btnCL = "Zum Tarifwechsel";
    private String cableMeinTarifText_tvCL = "Mach noch mehr draus";
    private String goOfferCTACL = "Zum Angebot";

    //URLs
    private String UpgradeTarifURL = "https://zuhauseplus.vodafone.de/internet-telefon/kabel/?product=kip-1000-um";
    //Methods
    @Step("Validate contract details card components")
    public void validateContractDetailsCard() {
        driver.assertThat().element(contractDetailsHeader).textTrimmed()
                .isEqualTo(contractDetailsHeaderCL).perform();

        driver.assertThat().element(productPriceLabel_tv).textTrimmed()
                .isEqualTo(productPriceLabel_tvCL).perform();

        driver.assertThat().element(contractNumberLabel_tv).textTrimmed()
                .isEqualTo(contractNumberLabel_tvCL).perform();

        driver.assertThat().element(contractStartDateLabel_tv).textTrimmed()
                .isEqualTo(contractStartDateLabel_tvCL).perform();

        driver.assertThat().element(contractEndDateLable_tv).textTrimmed()
                .isEqualTo(contractEndDateLable_tvCL).perform();

        driver.assertThat().element(contractLastCancellationDateLable_tv).textTrimmed()
                .isEqualTo(contractLastCancellationDateLable_tvCL).perform();

        driver.assertThat().element(cancelConnection_Link).textTrimmed()
                .isEqualTo(cancelConnection_LinkCL).perform();

        driver.assertThat().element(tariffChange_btn).textTrimmed()
                .isEqualTo(tariffChange_btnCL).perform();
    }

    @Step("Click Mein Tarif SO")
    public void clickContractCancellationHyperlink() {
        driver.element().click(cancelConnection_Link);
    }

    @Step("Validate contract cancellation hyperlink directs to cancellation page")
    public void validateContractCancellationHyperlink() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        driver.assertThat().element(hyperlinkPageAssertion).exists().perform();
    }

    @Step("Click change tariff CTA")
    public void clickChangeTariffCTA() {
        driver.assertThat().element(tariffChange_btn).textTrimmed()
                .isEqualTo(tariffChange_btnCL).perform();
        driver.element().click(tariffChange_btn);
    }

    @Step("Validate change tariff page")
    public void validateChangeTariffPage() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        driver.assertThat().element(changeTariffPage).exists().perform();

    }

    @Step("Validate campaign")
    public void validateCampaign() {
        driver.assertThat().element(cableMeinTarifText_tv).textTrimmed()
                .isEqualTo(cableMeinTarifText_tvCL).perform();
        driver.assertThat().element(Campaign).exists().perform();

    }
    @Step("Click change tariff CTA")
    public void clickGoOfferCTA() {
        driver.assertThat().element(goOfferCTA).textTrimmed()
                .isEqualTo(goOfferCTACL).perform();
        driver.element().click(goOfferCTA);
    }

    @Step("Validate go offer page")
    public void validateGoOfferPage() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        driver.assertThat().element(goOfferPage).exists().perform();
    }

    @Step("Assert on change tariff header")
    public MeinTarifPage validateChangeTariffHeader() {

        driver.assertThat().element(changeTariffHeader).textTrimmed().isEqualTo(changeTariffHeaderCL).perform();
    return this;
    }

    @Step("Assert on change tariff header")
    public MeinTarifPage validateAvailableTariffs() {
        driver.assertThat().element(availableTariffsChooser).exists().perform();
    return this;
    }
    @Step("Validate that change tariff CTA redirects to the right link")
    public void validateChangeTariffCTA() {
        driver.assertThat().element(changeTariffCTA).textTrimmed()
                .isEqualTo(changeTariffCTACL).perform();
        driver.element().click(changeTariffCTA);
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        driver.assertThat().element(changeTariffExternalPage).exists().perform();
    }
    @Step("Assert on change tariff header")
    public MeinTarifPage validateUserOnBestTariff() {
        driver.assertThat().element(bestTariffNotificationHeader).exists().perform();
        driver.assertThat().element(bestTariffNotificationBody).textTrimmed().isEqualTo(bestTariffNotificationBodyCL).perform();
        driver.assertThat().element(hotLineCTA).exists().perform();
    return this;
    }
    @Step("Assert on user has open work order notification")
    public MeinTarifPage validateUserHasOpenWorkOrder() {
        driver.assertThat().element(userHasOpenWorkOrderNotificationHeader).exists().perform();
        driver.assertThat().element(userHasOpenWorkOrderNotificationBody).textTrimmed().contains(userHasOpenWorkOrderNotificationBodyCL).perform();
        driver.assertThat().element(userHasOpenWorkOrderNotificationBody).textTrimmed().contains(userHasOpenWorkOrderNotificationBodyCL1).perform();
        driver.assertThat().element(userHasOpenWorkOrderNotificationCTA).textTrimmed().contains(userHasOpenWorkOrderNotificationCTACL).perform();
    return this;
    }

    @Step("Validate that user has open work order CTA redirects to the right link (Legacy portal)")
    public void validateOpenWorkOrderCTA() {
        driver.element().click(userHasOpenWorkOrderNotificationCTA);
        driver.assertThat().element(openWorkOrderLegacyPortal).exists().perform();
    }

    @Step("Assert on user has digital TV product notification")
    public void validateUserHasDigitalTVProduct() {
        driver.assertThat().element(digitalTVProductHeader).exists().perform();
        driver.assertThat().element(digitalTVProductNotificationBody).textTrimmed().isEqualTo(digitalTVProductNotificationBodyCL).perform();
        driver.assertThat().element(hotLineCTA).exists().perform();    }


    @Step("Assert on user is SOHO customer")
    public void validateUserSOHOCustomer() {
        driver.assertThat().element(digitalTVProductHeader).exists().perform();
        driver.assertThat().element(digitalTVProductNotificationBody).text().isEqualTo(digitalTVProductNotificationBodyCL).perform();
        driver.assertThat().element(hotLineCTA).exists().perform();    }
    @Step("Assert on user has phone only product")
    public MeinTarifPage validateUserHasPhoneOnlyProduct() {
        driver.assertThat().element(digitalTVProductHeader).exists().perform();
        driver.assertThat().element(digitalTVProductNotificationBody).textTrimmed().isEqualTo(digitalTVProductNotificationBodyCL).perform();
        driver.assertThat().element(hotLineCTA).exists().perform();
    return this;
    }

    @Step("Assert on user is in dunning process")
    public MeinTarifPage validateUserIsInDunningProcess() {
        driver.assertThat().element(dunningProcessHeader).exists().perform();
        driver.assertThat().element(dunningProcessNotificationBody).textTrimmed().contains(dunningProcessNotificationBodyCL).perform();
        driver.assertThat().element(dunningProcessNotificationBody).textTrimmed().contains(dunningProcessNotificationBodyCL1).perform();
        driver.assertThat().element(hotLineCTA).exists().perform();
        return this;
    }

    @Step("Assert on user has VVO address")
    public MeinTarifPage validateUserHasVVOAddress() {
        driver.assertThat().element(digitalTVProductHeader).exists().perform();
        driver.assertThat().element(digitalTVProductNotificationBody).textTrimmed().isEqualTo(digitalTVProductNotificationBodyCL).perform();
        driver.assertThat().element(hotLineCTA).exists().perform();
    return this;
    }

    @Step("Assert on eazy product CTA CL")
    public MeinTarifPage validateUserHasEazyProduct() {
        driver.assertThat().element(eazyProductHeader).exists().perform();
        driver.assertThat().element(eazyProductNotificationBody).textTrimmed().isEqualTo(eazyProductNotificationBodyCL).perform();
        return this;
    }

    @Step("validate eazy product CTA redirects to the right page ")
    public MeinTarifPage clickEazyProductCTA() {
        driver.assertThat().element(eazyProductCTA).textTrimmed()
                .isEqualTo(eazyProductCTACL).perform();
        driver.element().click(eazyProductCTA);
        return this;
    }

    @Step("Validate change tariff page")
    public MeinTarifPage validateEazyProductPage() {
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        driver.assertThat().element(eazyProductPage).exists().perform();
    return this;
    }

    @Step("Assert on user has 3 Play product")
    public MeinTarifPage validateUserHas3PProduct() {
        driver.assertThat().element(digitalTVProductHeader).exists().perform();
        driver.assertThat().element(digitalTVProductNotificationBody).textTrimmed().isEqualTo(digitalTVProductNotificationBodyCL).perform();
        driver.assertThat().element(hotLineCTA).exists().perform();
    return this;
    }

    @Step("Assert on change tariff header")
    public MeinTarifPage validateBEErrorMsg() {
        driver.assertThat().element(beErrorNotificationHeader).exists().perform();
        driver.assertThat().element(beErrorNotificationBody).textTrimmed().isEqualTo(apiDoesNotLoadErrorNotificationBodyCL).perform();
   return this;
    }

    @Step("Assert on change tariff header")
    public MeinTarifPage validateAPIDoesNotLoadErrorMsg() {
        driver.assertThat().element(apiDoesNotLoadErrorHeader).exists().perform();
        driver.assertThat().element(apiDoesNotLoadErrorNotificationBody).textTrimmed().isEqualTo(apiDoesNotLoadErrorNotificationBodyCL).perform();
        return this;
    }

    @Step("Validate the upgrade tarif price and details link")
    public MeinTarifPage validateUpgradeTarifCard(){
        driver.verifyThat().element(upgradeTarifCard).exists().perform();
        driver.verifyThat().element(upgradeTarifCardPrice).exists().perform();
        driver.verifyThat().element(upgradeTarifCardDetails).textTrimmed().isEqualTo(upgradeTarifCardDetailsCL).perform();
        driver.element().click(upgradeTarifCardDetails);
        driver.browser().getCurrentURL().equals(UpgradeTarifURL);
    return this;
    }
}