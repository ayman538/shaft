package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ASPLogin {
    // Variables
    protected SHAFT.GUI.WebDriver driver;

    protected String pagePath = "retoure/login";

    //Locators
    public static By loginButtonLocator = By.xpath("//div[@class='btn-login']/button");
    public static By loginDeliveryNumberLocator = By.xpath("//input[@id='deliveryNumber']");
    public static By loginZipCodeLocator = By.xpath("//input[@id='zipCode']");
    public static By acceptCookies_button=By.xpath("//button//span[contains(text(),'ablehnen')]");
    private By mobileTail_button=By.xpath("(//div[@class='brix-option-picker__item']//label)[1]");


    //constructor
    public ASPLogin(SHAFT.GUI.WebDriver driver)
    {
        this.driver = driver;
    }


    //keywords

    public ASPLogin setCookie(HashMap<String, String> cookieMap)
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

    public ASPLogin navigateToSTUrl(){
        String  url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public ASPLogin acceptCookies(){
        driver.element().click( acceptCookies_button);
        return this;
    }

    public ASPDashboard loginAction(String deliveryNumber, String zipCode)
    {
        driver.element().click(mobileTail_button);
        driver.element().type(loginDeliveryNumberLocator,deliveryNumber);
        driver.element().typeSecure(loginZipCodeLocator,zipCode);
        driver.element().click(loginButtonLocator);
        return new ASPDashboard(driver);
    }
}