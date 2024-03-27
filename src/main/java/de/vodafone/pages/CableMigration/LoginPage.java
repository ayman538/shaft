package de.vodafone.pages.CableMigration;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class LoginPage {
    // Variables
    protected SHAFT.GUI.WebDriver driver;

    //Locators
    public static By loginButtonLocator = By.xpath("//input[@id='sign-in']");
    public static By loginUserNameLocator = By.xpath("//input[@id='name']");
    public static By loginPasswordLocator = By.xpath("//input[@id='password']");
    public static By acceptCookies_button=By.xpath("//button//span[contains(text(),'ablehnen')]");

    //constructor
    public LoginPage(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }


    //keywords

    public LoginPage setCookie(HashMap<String, String> cookieMap)
    {
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

    public LoginPage navigateToSTUrl(){
        String pagePath = "meinvodafone/services/loginStubs";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public LoginPage acceptCookies(){
        driver.element().click( acceptCookies_button);
        return this;
    }

    public MeinVodafoneDashboard loginAction(String userName,String userPassword)
    {
        driver.element().type(loginUserNameLocator,userName);
        driver.element().typeSecure(loginPasswordLocator,userPassword);
        driver.element().click(loginButtonLocator);
        return new MeinVodafoneDashboard(driver);
    }
}

