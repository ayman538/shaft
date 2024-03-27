package de.vodafone.pages.CentralLandingPage;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.Solstice.SolsticeLogin;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class MainCentralLandingPage {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public MainCentralLandingPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //    private String url = "https://www.vodafone.de/meinvodafone/account/willkommen?documentUrl=%2F";
//    private final String environment = System.getProperty("de.vodafone.environment");

    //Locators
    private static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
    public static By CLPTeaserHeadline = By.xpath("(//*[@automation-id='landingPage_tv'])[1]");
    public static By CLPTeaserSubHeadline = By.xpath("(//*[@automation-id='landingPage_tv'])[2]");
    public static By CLPMainText1 = By.xpath("//*[@automation-id='uploadDocuments_tv']");
    public static By CLPMainText2 = By.xpath("//*[@automation-id='uploadDocuments_tv']");
    public static By CLPLoginHeader = By.xpath("//*[@automation-id='white-box_tv']/h4");
    public static By CLPLoginText = By.xpath("//*[@automation-id='logininfo_tv']");
    public static By CLPLoginCTA = By.xpath("//*[@automation-id='buttons_Link']");
    public static By CLPRegisterHeader = By.xpath("//*[@automation-id='white-box-registerinfo_tv']/h4");
    public static By CLPRegisterText = By.xpath("//*[@automation-id='registerinfo_tv']");
    public static By CLPRegisterCTA = By.xpath("//*[@automation-id='buttons-registerinfo_Link']");

    //CLs
    public static final String CLPTeaserHeadline1CL = "Altersnachweis hochladen";
    public static final String CLPTeaserHeadline2CL = "Altersnachweis hochladen";
    public static final String CLPTeaserHeadline3CL = "Mitarbeiternachweis hochladen";
    public static final String CLPTeaserHeadline4CL = "Kündigungsbestätigung hochladen";
    public static final String CLPTeaserHeadline5CL = "Gewerbenachweis hochladen";
    public static final String CLPTeaserHeadline6CL = "Nachweis zur Zuhause-Adresse hochladen";
    public static final String CLPTeaserSubHeadline1CL = "Mit Red+ Kids kannst Du unsere Vorteilsangebote für Kinder und Jugendliche nutzen.";
    public static final String CLPTeaserSubHeadline2CL = "Mit Red+ Kids kannst Du unsere Vorteilsangebote für Kinder und Jugendliche nutzen.";
    public static final String CLPTeaserSubHeadline3CL = "Sobald wir den Nachweis haben, profitierst Du von Deinen Mitarbeiter-Rabatten.";
    public static final String CLPTeaserSubHeadline4CL = "Schick uns Deine Kündigungsbestätigung und wir schenken Dir 6 Monate unseren Basispreis.";
    public static final String CLPTeaserSubHeadline5CL = "Damit können wir Dir Deine Vorteile dauerhaft einrichten.";
    public static final String CLPTeaserSubHeadline6CL = "Wir brauchen den Nachweis zur Vorlage bei der Bundesnetzagentur.";
    public static final String CLPMainText1CL = "Du willst Dokumente hochladen? Das geht ganz einfach nach dem Login. Falls Du noch kein Konto in MeinVodafone hast, registrier Dich bitte zuerst.";
    public static final String CLPMainText2CL = "Wichtig: Beachte, dass Du Dokumente nur für die Verträge hochladen kannst, die Du schon in MeinVodafone verwaltest.";
    public static final String CLPLoginHeaderCL = "Du hast bereits ein Konto?";
    public static final String CLPLoginTextCL = "Logg Dich einfach ein und lad Deine Dokumente hoch.";
    public static final String CLPLoginCTACL = "Jetzt einloggen";
    public static final String CLPRegisterHeaderCL = "Du bist noch nicht registriert?";
    public static final String CLPRegisterTextCL = "Registrier Dich bitte zuerst und starte dann den Upload-Prozess nochmal von vorne.";
    public static final String CLPRegisterCTACL = "Jetzt registrieren";

    //Actions
    public MainCentralLandingPage setCookie(HashMap<String, String> cookieMap, String environment) {
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

    public MainCentralLandingPage acceptCookies() {
        driver.element().click( acceptCookies_button);
        return this;
    }

    public MainCentralLandingPage navigate(String urlExtention, String environment) {
        String pagePath = "";
        String url = "";
        switch (environment) {
            case "ST" -> {
                pagePath = "meinvodafone/account/dokument-hochladen?documentUrl=/";
                url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
            }
            case "SIT" -> {
                pagePath = "meinvodafone/account/dokument-hochladen?documentUrl=/";
                url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
            }
            default -> Validations.assertThat().forceFail().withCustomReportMessage("This environment  [" + environment + "] is not supported").perform();
        }
        driver.browser().navigateToURL( url + urlExtention);
        return this;
    }

    public SolsticeLogin chooseLoginOption() {
        driver.element().click(CLPLoginCTA );
        return new SolsticeLogin(driver);
    }
}