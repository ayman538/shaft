package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class PYPLandingPage {
    // Variables
    private SHAFT.GUI.WebDriver driver;


    //landing page locators
    //    private static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
    public static By landingPageHeader = By.xpath("//*[@automation-id='pageHeader_tv']");
    public static By landingPageTeaserHeader = By.xpath("(//*[@automation-id='pypLandingPage_tv'])[1]");
    public static By landingPageTeaserText = By.xpath("(//*[@automation-id='pypLandingPage_tv'])[2]");
    //landing page CL
    public static String landingPageHeaderCL = "Vodafone OneNumber Car";
    public static String landingPageTeaserHeaderCL = "Hotspot für Vodafone-Kunden";
    public static String landingPageTeaserTextCL = "Vodafone-Kunden mit Black-, Red- und Red+-Tarif können ihr Datenvolumen bequem über das Auto-WLAN nutzen. Optimal für stabilen LTE-Empfang über die Auto-Antenne. Hotspot für bis zu 8 Geräte, ohne zusätzlichen Tarif und alles auf einer Rechnung.";
    private static By hereWeGo_button = By.xpath("//*[@automation-id='pypLandingPage_btn']");
    private static By newstart_button = By.xpath("//button[@automation-id='304414_btn']");




    //constructor
    public PYPLandingPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //keywords
    public PYPLandingPage setCookie(HashMap<String, String> cookieMap) {
        for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Cookie cookie = new Cookie(key, value);
            driver.getDriver().manage().addCookie(cookie);
        }
        driver.browser().refreshCurrentPage(); JavaScriptWaitManager.waitForLazyLoading();
        if (driver.browser().getCurrentWindowTitle().equals("404 Not Found")) {
            try {
                SHAFT.Validations.assertThat().forceFail().withCustomReportMessage("Cookie Switcher Branch is not found, please validate with the dev team").perform();
            } catch (AssertionError e) {
                Assert.fail("Cookie Switcher Branch is not found, please validate with the dev team");
            }
        }
        return this;
    }

    public PYPLandingPage navigate() {
        String pagePath ="/pyp/mvp/login?app=aud&imsi=987451231";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public PYPLandingPage missingQueryNavigate() {
        String pagePath = "pyp/one-number?redirect=12345";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public PYPLandingPage acceptCookies() {
        driver.element().click( acceptCookies_button);
        return this;
    }
    public PYPLogin GoToBTN() {
        driver.element().click( hereWeGo_button);
        return new PYPLogin(driver);
    }
    public PYPLandingPage GoTologin() {
        driver.element().click(newstart_button);
        return this;
    }
    public PYPLandingPage goToDeeplinkURL12206() {
        String pagePath = "pyp/mvp/login?app=aud&imsi=987451231";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    //login page keywords


}
