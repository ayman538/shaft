package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class SolsticeEmailChangeVerification {
    private SHAFT.GUI.WebDriver driver;

    private static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");

    public static By ECVPageHeadline = By.xpath("//*[@class='title-ecare overview']/div/h1");
    public static final String ECVPageHeadlineCL = "E-Mail-Adresse bestätigen";

    public static By ECVConfNotHeadline = By.xpath("(//*[@class='alert-content'])[1]/div/div[2]/h4");
    public static final String ECVConfNotHeadlineCL = "Vielen Dank!";

    public static By ECVConfNotText = By.xpath("(//*[@class='alert-content'])[1]/p");
    public static final String ECVConfNotTextCL = "Deine E-Mail-Adresse wurde bestätigt";//. Du kannst sie ab sofort für den Login nutzen.";

    public static By ECVConfSummaryHeader = By.xpath("//*[@class='ac-head ac-active']/span");
    public static final String ECVConfSummaryHeaderCL = "Übersicht";

    public static By ECVConfSummaryText = By.xpath("//*[@class='ac-body']/p");
    public static final String ECVConfSummaryTextCL = "Logg Dich jetzt ein und verwalte in MeinVodafone alle Deine Verträge und Services.";

    public static By ECVConfSummaryCTA = By.xpath("//*[@class='ac-body']/div/a");
    public static final String ECVConfSummaryCTACL = "Weiter zu MeinVodafone";

    public SolsticeEmailChangeVerification(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SolsticeEmailChangeVerification setCookie(HashMap<String, String> cookieMap) {
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

    public SolsticeEmailChangeVerification navigate(String FinalUrl) {

        driver.browser().navigateToURL( FinalUrl);
        return this;
    }

    public SolsticeEmailChangeVerification acceptCookies() {
        driver.element().click( acceptCookies_button);
        return this;
    }
}
