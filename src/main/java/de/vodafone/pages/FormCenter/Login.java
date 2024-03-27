package de.vodafone.pages.FormCenter;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import de.vodafone.pages.unityMedia.Dashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
public class Login {
    // Variables
    private SHAFT.GUI.WebDriver driver;
    //Locators
    private By STloginButtonLocator = By.xpath("//input[@id='sign-in']");
    private By STloginUserNameLocator = By.xpath("//input[@id='name']");
    private By STloginPasswordLocator = By.xpath("//input[@id='password']");
    private By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
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
    public Login navigate() {
        String pagePath = "";
        String url = "";
        String urlAfterRedirection = "";
                pagePath = "meinvodafone/services/loginStubs";
                url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }
    public Login acceptCookies() {
        driver.element().click( acceptCookies_button);
        return this;
    }

    public Dashboard loginAction(String userName, String userPassword) {
        driver.element().type(STloginUserNameLocator, userName)
                .typeSecure(STloginPasswordLocator, userPassword).click(STloginButtonLocator);
        return new Dashboard(driver);
    }
}