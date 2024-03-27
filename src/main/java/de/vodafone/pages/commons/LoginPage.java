package de.vodafone.pages.commons;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By SITloginButtonLocator = By.xpath("(//button[@class='btn login-btn'])[1]");
    private By SITuserNameLocator = By.xpath("//input[@id='txtUsername']");
    private By SITpasswordLocator = By.xpath("//input[@id='txtPassword']");
    private By STloginButtonLocator = By.xpath("(//button[@class='btn login-btn' and contains(.,'Login')])[1]");
    private By STuserNameLocator = By.xpath("//input[@id='txtUsername']");
    private By STpasswordLocator = By.xpath("//input[@id='txtPassword']");
    private By acceptCookiesButtonLocator = By.xpath("//button//span[contains(text(),'ablehnen')]");

    public By loginIndicator = By.xpath("//span[@class='indicator' and @style='display: block;']");
    private By meinVodafoneIcon = By.xpath("//a[@class='open-overlay-my-vf']");
    private By logoutButtonIcon = By.xpath("//a[@class='btn btn-alt']");
    private By loginAgainButton  = By.xpath("//a[@class='btn btn-em btn-sml']");
    private By registerButton  = By.xpath("//a[@class='textlink not-open-overlay'][2]");

    private String expectedTitle = "MeinVodafone";

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage setCookieSwitchers(HashMap<String, String> cookieMap) {
        HashMap<String, String> branchesNames = new HashMap<>();
        for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            driver.browser().addCookie(key, value);
            branchesNames.put(key, value);
        }
        driver.browser().refreshCurrentPage(); JavaScriptWaitManager.waitForLazyLoading();
        if (driver.browser().getCurrentWindowTitle().equals("404 Not Found")) {
            try {
                SHAFT.Validations.assertThat().forceFail().withCustomReportMessage(branchesNames + " Cookie Switcher Branch(es) not found, please validate with the dev team").perform();
            } catch (AssertionError e) {
                Assert.fail(branchesNames + " Cookie Switcher Branch(es) not found, please validate with the dev team");
            }
        }
        return this;
    }

    public LoginPage acceptCookies() {
        driver.element().click(acceptCookiesButtonLocator);
        return this;
    }

    public LoginPage navigateST() {
        String pagePath = "meinvodafone/account/login";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;

        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public LoginPage navigateST(String deepLink) {

        String url = System.getProperty("de.vodafone.baseUrl.st") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public LoginPage navigateSIT() {
        String pagePath = "meinvodafone/account/login";
        String url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
        String urlAfterRedirection = url;

        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public LoginPage navigateSIT(String deepLink) {

        String url = System.getProperty("de.vodafone.baseUrl.sit") + deepLink;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public LoginPage navigateOpweb5() {
        String pagePath = "meinvodafone/account/login";
        String url = System.getProperty("de.vodafone.baseUrl.opweb5") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public LoginPage loginST(String userName, String userPassword) {
        driver.element()
                .type(STuserNameLocator, userName)
                .typeSecure(STpasswordLocator, userPassword)
                .click(STloginButtonLocator);
        return this;
    }

    public LoginPage loginSIT(String userName, String userPassword) {
        driver.element()
                .type(SITuserNameLocator, userName)
                .typeSecure(SITpasswordLocator, userPassword)
                .click(SITloginButtonLocator);
        return this;
    }

    public LoginPage loginActionopweb5(String userName, String userPassword) {
        driver.element().type(SITuserNameLocator, userName)
                .typeSecure(SITpasswordLocator, userPassword)
                .click(SITloginButtonLocator);
        return this;
    }
    public LoginPage validateLoginIndicatorExists()
    {
        driver.assertThat()
                .element(loginIndicator).exists()
                .withCustomReportMessage("Login Indicator Exists Successfully")
                .perform();
        return this;
    }

    @Step("Click on Mein Vodafone Icon")
    public LoginPage clickMeinVodafoneIcon(){
        driver.element().click(meinVodafoneIcon);
        return this;
    }

    @Step("Click on Logout Button Icon")
    public LoginPage clickLogoutButtonIcon(){
        driver.element().click(logoutButtonIcon);
        return this;
    }

    @Step("Click on Login Again Button")
    public LoginPage clickLoginAgainButton(){
        driver.element().click(loginAgainButton);
        return this;
    }
    @Step("Click on Register Button")
    public LoginPage clickRegisterButton(){
        driver.element().click(registerButton);
        return this;
    }

    @Step("wait for Login Page to be Loaded Fully")
    public LoginPage waitForPageLoading(){
        new WebDriverWait(driver.getDriver(),Duration.ofSeconds(Long.parseLong(System.getProperty("browserNavigationTimeout"))))
                .until(ExpectedConditions.titleIs(expectedTitle));
        return this;
    }


}
