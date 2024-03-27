package de.vodafone.pages.MNP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LandingPage {

    private SHAFT.GUI.WebDriver driver;

    // Locators
    private static By pageHeader = By.xpath("//*[@data-automation-id='mainHeader_tv']");
    private static By allesZurRufNummernMitNahmeButton = By.xpath("(//span//li[1]/a)[1]");
    private static By dannprüfHierDenAktuellenStatusHyperLink = By.xpath("//div[2]//section/p/a");
    private static By mitHandyNummerEinLoggenButton = By.xpath("//*[@id='button-771208']");
    private static By acceptCookiesButtonLocator = By.xpath("//button//span[contains(text(),'ablehnen')]");

    // CLs
    private static String pageHeader_CL = "Handy mit Vertrag";
    private static String allesZurRufNummernMitNahmeButtonCL = "";
    private static String dannprüfHierDenAktuellenStatusHyperLinkCL = "Dann prüf hier den aktuellen Status.";

    // DeepLinks
    private static String rufNummernMitnahmeOnlineBeauftragenButtonURL ="hilfe/rufnummernmitnahme/portierungsdatendokument.html";
    private static String jetztRufNummernMitnahmeStartenButtonURL = "hilfe/rufnummernmitnahme/portierungsdatendokument.html";
    private static String mitHandyNummerEinLoggenButtonURL = "shop/authentifizierung.html";

    public LandingPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    @Step("Validate Device list page Header and sub header CL")
    public LandingPage validateHeaderCL(){
        driver.assertThat().element(pageHeader).text().isEqualTo(pageHeader_CL).perform();
        return this;
    }

    @Step("Navigate to Deeplink - ST")
    public LandingPage navigateDeeplinkST(String deepLink) {

        String url = System.getProperty("de.vodafone.baseUrl.st") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    @Step("Click Abbrechen Button and Verify Redirection")
    public LandingPage clickMitHandyNummerEinLoggenButton(){
        driver.element().click(mitHandyNummerEinLoggenButton);
        driver.verifyThat().browser().url().contains(mitHandyNummerEinLoggenButtonURL).perform();
        return this;
    }

    @Step("Accept Cookies Button Click")
    public LandingPage acceptCookies() {
        driver.element().click(acceptCookiesButtonLocator);
        return this;
    }
}