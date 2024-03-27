package de.vodafone.pages.commons;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class ASPLogin {
        private SHAFT.GUI.WebDriver driver;

        //Locators
        private By acceptCookiesButtonLocator = By.xpath("//button//span[contains(text(),'ablehnen')]");

        public By loginIndicator = By.xpath("//span[@class='indicator' and @style='display: block;']");
        private By meinVodafoneIcon = By.xpath("//a[@class='open-overlay-my-vf']");
         private By DeliveryNumberTextBox = By.xpath("//*[@automation-id='deliveryNumber_et']");
         private By ZipcodeTitle = By.xpath("(//*[@class='mt-60'])[2]/text/div/div[1]/label");
        private By ZipcodeTextBox = By.xpath("//*[@automation-id='zipCode_et']");
        private By LoginButton = By.xpath("//*[@automation-id='loginBtn_btn']");


        public ASPLogin (SHAFT.GUI.WebDriver driver) {
            this.driver = driver;
        }

        public ASPLogin setCookieSwitchers(HashMap<String, String> cookieMap) {
            HashMap<String, String> branchesNames = new HashMap<>();
            for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                driver.browser().addCookie(key, value);
                branchesNames.put(key, value);
            }
            driver.browser().refreshCurrentPage();
            JavaScriptWaitManager.waitForLazyLoading();
            if (driver.browser().getCurrentWindowTitle().equals("404 Not Found")) {
                try {
                    SHAFT.Validations.assertThat().forceFail().withCustomReportMessage(branchesNames + " Cookie Switcher Branch(es) not found, please validate with the dev team").perform();
                } catch (AssertionError e) {
                    Assert.fail(branchesNames + " Cookie Switcher Branch(es) not found, please validate with the dev team");
                }
            }
            return this;
        }

        public ASPLogin acceptCookies() {
            driver.element().click(acceptCookiesButtonLocator);
            return this;
        }

        public ASPLogin navigateST() {
            String pagePath = "retoure/landing-page";
            String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
            String urlAfterRedirection = url;

            driver.browser().navigateToURL(url, urlAfterRedirection);
            return this;
        }


        public ASPLogin navigateSIT() {
            String pagePath = "retoure/landing-page";
            String url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
            String urlAfterRedirection = url;

            driver.browser().navigateToURL(url, urlAfterRedirection);
            return this;
        }

        public ASPLogin navigateSIT(String deepLink) {

            String url = System.getProperty("de.vodafone.baseUrl.sit") + deepLink;
            String urlAfterRedirection = url;
            driver.browser().navigateToURL(url, urlAfterRedirection);
            return this;
        }
    public ASPLogin loginST(String deliveryNumber, String Zipcode) {

        driver.element().type(DeliveryNumberTextBox, deliveryNumber);
        driver.element().typeSecure(ZipcodeTextBox, Zipcode);
        driver.element().click(LoginButton);
        return this;
    }
    public ASPLogin loginSIT(String deliveryNumber, String Zipcode) {

        driver.element().type(DeliveryNumberTextBox, deliveryNumber);
        driver.element().typeSecure(ZipcodeTextBox, Zipcode);
        driver.element().click(LoginButton);
        return this;
    }


}