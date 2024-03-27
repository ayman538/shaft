package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class FirstLogin {

    private SHAFT.GUI.WebDriver driver;

    public static By firstLoginHeader_text = By.xpath("//*[@automation-id='pageHeader_tv']/h1");
    public static By setPassHere_text = By.xpath("//*[@automation-id='firstLoginFormContainer_tv']/p");
    public static By yourPass_inputField = By.xpath("//*[@automation-id='olPasswordInput_et']");
    public static By regexDescription_text = By.xpath("//*[text()='Mindestens 8 Zeichen, ein Buchstabe sowie eine Zahl und ein Sonderzeichen.']");
    public static By repeatPass_iputField = By.xpath("//*[@automation-id='repeatPasswordField_et']");
    public static By confirmaPass_button = By.xpath("//*[@automation-id='solsticeFirstLoginSubmitBtn_btn']");
    public static By errorMessage_text = By.xpath("//*[@automation-id='errorMessageContainer_et']");
    private static By acceptCookies_button = By.xpath("//button//span[contains(text(),'ablehnen')]");

    public static By errorMessage_header = By.xpath("//*[@class='flexDiv']");
    public static By errorMessage_text_password =By.xpath("//div[@class='fm-data']/p");

    public static String firstLoginHeader = "Erster Login";
    public static String setPassHere = "Leg hier Dein Passwort fest.";
    public static String regexDescription = "Mindestens 8 Zeichen, ein Buchstabe sowie eine Zahl und ein Sonderzeichen.";
    public static String confirmaPass = "Passwort bestätigen";
    public static String errorMessage = "Das Internet-Passwort muss mindestens 8 Zeichen lang sein und mindestens einen Buchstaben enthalten. Außerdem muss es mindestens eine Zahl und ein Sonderzeichen enthalten, wie zum Beispiel: +-_&@,§$%. Leerzeichen dürfen nicht vorkommen.";
    public static String errorMesaage_header_samepass="Das geht leider nicht";
    public static String errorMessage_samepassword="Mindestens 8 Zeichen, ein Buchstabe sowie eine Zahl und ein Sonderzeichen.";
    public static String errorMessage_invalidpassword_header="Das ist kein gültiges Passwort";
    public static String errorMessage_invalidpassword_text="Mindestens 8 Zeichen, ein Buchstabe sowie eine Zahl und ein Sonderzeichen.";







    public FirstLogin(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public FirstLogin setCookie(HashMap<String, String> cookieMap) {
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

    public FirstLogin navigate() {
        String pagePath = "meinvodafone/account/willkommen?token=";
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;

        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public FirstLogin acceptCookies() {
        driver.element().click( acceptCookies_button);
        return this;
    }

    public FirstLogin navigate(String url, String urlAfterRedirection) {

        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public FirstLogin addPassword(String password) {
        (new ElementActions(driver.getDriver())).type(yourPass_inputField, password);
        return this;
    }

    public FirstLogin reEnterInValidPassword(String confirmPassword) {
        (new ElementActions(driver.getDriver())).type(repeatPass_iputField, confirmPassword);
        return this;
    }

    public ConfirmationPage reEnterPassword(String confirmPassword) {
        (new ElementActions(driver.getDriver())).type(repeatPass_iputField, confirmPassword)
                .click(confirmaPass_button);
        return new ConfirmationPage(driver);
    }




}

