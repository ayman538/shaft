package de.vodafone.pages.FirstLogin;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import com.shaft.gui.element.ElementActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class LoginPage {
    private SHAFT.GUI.WebDriver driver;
    private By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");
    private By email_textfield = By.xpath("//*[@automation-id='emailField_et']");
    private By number_textfield = By.xpath("//*[@automation-id='phoneField_et']");
    private By password_textfield = By.xpath("(//*[@automation-id='_et'])[2]");
    private By password2_textfield = By.xpath("//*[@automation-id='repeatPasswordField_et']");
    private By step1Submit_button = By.xpath("//*[@class='btn btn-em btn-sml']");
    private By step2Submit_button = By.xpath("//*[@class='btn btn-em btn-sml']");

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }



    public LoginPage navigate() {
        String pagePath = "meinvodafone/account/firstlogin/kontaktdaten";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        driver.browser().navigateToURL( url);
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
        driver.element().click( acceptCookies_button);
        return this;
    }

    public LoginPage typeEmail(String Email) {
        new ElementActions(driver.getDriver()).type(email_textfield, Email);
        return this;
    }

    public LoginPage typeNumber(String Number) {
        new ElementActions(driver.getDriver()).type(number_textfield, Number);
        return this;
    }

    public LoginPage clickStep1Submit() {
        driver.element().click( step1Submit_button);
        return this;
    }

    public LoginPage typePassword(String Password) {
        new ElementActions(driver.getDriver()).type(password_textfield, Password);
        return this;
    }

    public LoginPage typePasswordAgain(String Password) {
        new ElementActions(driver.getDriver()).type(password2_textfield, Password);
        return this;
    }

    public LoginPage clickStep2Submit() {
        driver.element().click( step2Submit_button);
        return this;
    }

    @Step("Login on FirstLogin")
    public LoginPage LoginAction (String Number, String Email, String Password){
        typeEmail(Email);
        typeNumber(Number);
        clickStep1Submit();
        typePassword(Password);
        typePasswordAgain(Password);
        clickStep2Submit();
        return this;
    }
}
