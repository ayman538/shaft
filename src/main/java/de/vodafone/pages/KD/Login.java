package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Login {
    // Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private static By STloginButtonLocator = By.xpath("//input[@id='sign-in']");
    private static By STloginUserNameLocator = By.xpath("//input[@id='name']");
    private static By STloginPasswordLocator = By.xpath("//input[@id='password']");
    private static By SITloginButtonLocator = By.xpath("(//button[@type='submit'])[2]");
    private static By SITloginUserNameLocator = By.xpath("//input[@id='txtUsername']");
    private static By SITloginPasswordLocator = By.xpath("//input[@id='txtPassword']");
    private static By acceptCookies_button=By.xpath("//button//span[contains(text(),'ablehnen')]");
    //constructor
    public Login(SHAFT.GUI.WebDriver driver)
    {
        this.driver=driver;
    }

    //keywords
    public Login setCookie(HashMap<String, String> cookieMap)
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

    public Login navigateToSTUrl(){
        String pagePath = "meinvodafone/services/loginStubs";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url,urlAfterRedirection);
        return this;
    }

    public Login navigateToSITUrl(){
        String pagePath = "meinvodafone/account/login";
        String url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url,urlAfterRedirection);
        return this;
    }

    public Login acceptCookies(){
        driver.element().click(acceptCookies_button);
        return this;
    }

    public KD_Dashboard stLoginAction(String userName, String userPassword)
    {
        driver.element().type(STloginUserNameLocator,userName);
        driver.element().typeSecure(STloginPasswordLocator,userPassword);
        driver.element().click(STloginButtonLocator);
        return new KD_Dashboard(driver);
    }

    public KD_Dashboard sitLoginAction(String userName, String userPassword)
    {
        driver.element().type(SITloginUserNameLocator,userName);
        driver.element().typeSecure(SITloginPasswordLocator,userPassword);
        driver.element().click(SITloginButtonLocator);
        return new KD_Dashboard(driver);
    }
}
