package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class SolsticeLogin {
    // Variables
    private SHAFT.GUI.WebDriver driver;


    //Locators
    private static By STloginButtonLocator = By.id("sign-in");
    private static By STloginUserNameLocator = By.xpath("//input[@id='name']");
    private static By STloginPasswordLocator = By.xpath("//input[@id='password']");
    private static By SITloginButtonLocator = By.xpath("(//button[@type='submit'])[2]");
    private static By SITloginUserNameLocator = By.xpath("//input[@id='txtUsername']");
    private static By SITloginPasswordLocator = By.xpath("//input[@id='txtPassword']");
    private static By loginButtonLocator = By.id("sign-in");
    private static By loginUserNameLocator = By.id("name");
    private static By loginPasswordLocator = By.id("password");
    //    private static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");

    //constructor
    public SolsticeLogin(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    //keywords

    public SolsticeLogin setCookie(HashMap<String, String> cookieMap) {
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

    public SolsticeLogin navigateST() {
        String pagePath = "meinvodafone/services/loginStubs";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public SolsticeLogin navigateSIT() {
        String pagePath = "meinvodafone/account/login";
//                meinvodafone/services/
        String url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL(url, urlAfterRedirection);
        return this;
    }

    public SolsticeLogin acceptCookies() {
        driver.element().click(acceptCookies_button);
        return this;
    }

    public SolsticeDashboard loginActionST(String userName, String userPassword) {
        driver.element().type(STloginUserNameLocator, userName)
                .typeSecure(STloginPasswordLocator, userPassword)
                .click(STloginButtonLocator);
        return new SolsticeDashboard(driver);
    }

    public SolsticeDashboard loginActionSIT(String userName, String userPassword) {
        driver.element().type(SITloginUserNameLocator, userName)
                .typeSecure(SITloginPasswordLocator, userPassword)
                .click(SITloginButtonLocator);
        return new SolsticeDashboard(driver);
    }

    public UploadDocument loginToUploadDocument(String userName, String userPassword) {
        driver.element().type(SITloginUserNameLocator, userName)
                .typeSecure(SITloginPasswordLocator, userPassword)
                .click(SITloginButtonLocator);
        return new UploadDocument(driver);
    }

    public ContractChooser loginToContractChooser(String userName, String userPassword) {
        driver.element().type(SITloginUserNameLocator, userName)
                .typeSecure(SITloginPasswordLocator, userPassword)
                .click(SITloginButtonLocator);
        return new ContractChooser(driver);
    }
}
