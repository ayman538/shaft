package de.vodafone.pages.redplus;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class LoginPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Element Locators
    //SIT env
    private By username_Field = By.xpath("//input[@id='txtUsername']");
    private By password_Field = By.xpath("//input[@id='txtPassword']");
    private By login_Button = By.xpath("(//button[@type='submit'])[2]");
    private By acceptCookies_Button = By.xpath("//button//span[contains(text(),'ablehnen')]");

    //Constructors
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Methods
    public LoginPage navigate() {
        String pagePath =  "meinvodafone/account/login";
        String url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public LoginPage setCookie(HashMap<String, String> cookieMap) {

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

    public LoginPage acceptCookies() {
        driver.element().click( acceptCookies_Button);
        return this;
    }

    public Dashboard typeLoginData(String username, String Password) {
        driver.element().type( username_Field, username);
        driver.element().typeSecure(password_Field, Password);
        driver.element().click( login_Button);
        return new Dashboard(driver);
    }
}