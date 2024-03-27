package de.vodafone.pages.DeviceManagement;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import de.vodafone.pages.eCare.Dashboard;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class Login {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private static By SITloginButtonLocator = By.xpath("(//button[@class='btn login-btn'])[1]");
    private static By SITuserNameLocator = By.xpath("//input[@id='txtUsername']");
    private static By SITpasswordLocator = By.xpath("//input[@id='txtPassword']");
    private static By STloginButtonLocator = By.xpath("//input[@id='sign-in']");
    private static By STuserNameLocator =  By.xpath("//input[@id='name']");;
    private static By STpasswordLocator = By.id("//input[@id='passsword']");
    private static By opweb5NameLocator = By.xpath("//input[@id='txtUsername_et']");
    private static By opweb5PasswordLocator = By.xpath("//input[@id='txtPassword_et']");



    private static By acceptCookiesButtonLocator = By.xpath("//button//span[contains(text(),'ablehnen')]");

    public Login(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public de.vodafone.pages.DeviceManagement.Login setCookie(HashMap<String, String> cookieMap) {
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

    public de.vodafone.pages.DeviceManagement.Login navigateST() {
        String pagePath = "meinvodafone/services/loginStubs";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public de.vodafone.pages.DeviceManagement.Login navigateSIT() {
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

    public Login loginActionST(String userName, String userPassword) {
        driver.element().type(STuserNameLocator, userName)
                .typeSecure(STpasswordLocator, userPassword)
                .click(STloginButtonLocator);
        return this;
    }

    public Login loginActionSIT(String userName, String userPassword) {
        driver.element().type(opweb5NameLocator, userName)
                .typeSecure(opweb5PasswordLocator, userPassword)
                .click(SITloginButtonLocator);
        return this;
    }

}
