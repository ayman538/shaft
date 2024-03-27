package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Login {
    // Variables
    protected SHAFT.GUI.WebDriver driver;


    //Locators
    private static By SITloginButtonLocator = By.xpath("(//button[@class='btn login-btn'])[1]");
    private static By SITuserNameLocator = By.xpath("//input[@id='txtUsername']");
    private static By SITpasswordLocator = By.xpath("//input[@id='txtPassword']");
    private static By STloginButtonLocator = By.id("sign-in");
    private static By STuserNameLocator = By.id("name");
    private static By STpasswordLocator = By.id("password");
    private static By acceptCookiesButtonLocator = By.xpath("//button//span[contains(text(),'ablehnen')]");

    //constructor
    public Login(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //keywords

    public Login setCookie(HashMap<String, String> cookieMap) {
        for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            Cookie cookie = new Cookie(key, value);
            driver.getDriver().manage().addCookie(cookie);
        }
        driver.browser().refreshCurrentPage();
        JavaScriptWaitManager.waitForLazyLoading();
        if (driver.browser().getCurrentWindowTitle().equals("404 Not Found")) {
            try {
                SHAFT.Validations.assertThat().forceFail().withCustomReportMessage("Cookie Switcher Branch is not found, please validate with the dev team").perform();
            } catch (AssertionError e) {
                Assert.fail("Cookie Switcher Branch is not found, please validate with the dev team");
            }
        }
        return this;
    }

    public Login navigateST() {
        String pagePath = "meinvodafone/services/loginStubs";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public Login navigateSIT() {
        String pagePath = "meinvodafone/account/login";
        String url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public Login acceptCookies() {
        driver.element().click(acceptCookiesButtonLocator);
        return this;
    }

    public Dashboard loginActionST(String userName, String userPassword) {
        driver.element().type(STuserNameLocator, userName)
                .typeSecure(STpasswordLocator, userPassword)
                .click(STloginButtonLocator);


        return new Dashboard(driver);
    }

    public Dashboard loginActionSIT(String userName, String userPassword) {
        driver.element().type(SITuserNameLocator, userName)
                .typeSecure(SITpasswordLocator, userPassword)
                .click(SITloginButtonLocator);

        return new Dashboard(driver);
    }

}
