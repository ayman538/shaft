package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import com.shaft.gui.element.ElementActions;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

public class DashboardPage {
    // Variables
    private final SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;

    //Locators
    private By acceptCookies_Button=By.xpath("//button//span[contains(text(),'ablehnen')]");
    private By headline_Text = By.xpath("//welcome-pagecomponent//h1");
    private By getStarted_Button=By.xpath("//welcome-pagecomponent//button");
    private By Header_Text = By.xpath("//appointment-order-status//h3");
    private By WidgetButton_btn = By.xpath("(//a[@automation-id='tracking_button_btn'])[1]");
    private By SectionMsg_Text = By.xpath("//span[@automation-id=\"order_without_tracking_message_tv\"]");
    private By widgetButtonBtnSecond = By.xpath("(//a[@automation-id='tracking_button_btn'])[2]");
    private By widgetButtonBtnThird = By.xpath("(//a[@automation-id='tracking_button_btn'])[3]");

    //constructor
    public DashboardPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //keywords
    public DashboardPage setCookie(HashMap<String, String> cookieMap){
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

    public DashboardPage navigateToSITUrl(String urlIdent) {
        String pagePath = "anschaltung-dsl/start?urlIdent="+ urlIdent;
        String url = System.getProperty("de.vodafone.baseUrl.sit") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public DashboardPage navigateToSTUrl(String urlIdent) {
        String pagePath = "anschaltung-dsl/countdown?urlIdent="+ urlIdent;
        String url = System.getProperty("de.vodafone.baseUrl.st") + pagePath;
        String urlAfterRedirection = url;
        driver.browser().navigateToURL( url, urlAfterRedirection);
        return this;
    }

    public DashboardPage acceptCookies() {
        driver.element().click( acceptCookies_Button);
        return this;
    }
    public void clickOnGetStartedButton() {
        (new ElementActions(driver.getDriver())).click(getStarted_Button);
    };
    public void validateDSLOnboardingPage(String expectedPageHeadline,String expectedButtonText){
        Validations.assertThat().element(driver.getDriver(), headline_Text)
                .text().contains(expectedPageHeadline)
                .withCustomReportMessage("Check DSL Onboarding Page Headline is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), getStarted_Button)
                .text().contains(expectedButtonText)
                .withCustomReportMessage("Check Get Started Button CL").perform();
    }

    @Step("Click on the first Widget Button")
    public DashboardPage clickOnWidgetButton() {
        driver.element().click(WidgetButton_btn);
        return this;
    }

    @Step("Click on the second Widget Button")
    public DashboardPage clickOnSecondWidgetButton() {
        driver.element().click(widgetButtonBtnSecond);
        return this;
    }
    @Step("Click on the third Widget Button")
    public DashboardPage clickOnThirdWidgetButton() {
        driver.element().click(widgetButtonBtnThird);
        return this;
    }
    @Step("Click on the Widget Button on failure service")
    public DashboardPage clickOnWidgetButtonOnErrormessageCase() {
        driver.element().click(widgetButtonBtnSecond);
        return this;
    }

    @Step("Validate Section Exist ")
    public DashboardPage validateSectionExist(String expectedHeader, String expectedWidgetButton){
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        driver.verifyThat()
                .element(WidgetButton_btn)
                .text()
                .contains(expectedWidgetButton)
                .perform();
        return this;
    }
    @Step("Validate Section with two parcels exist ")
    public DashboardPage validateSectionTwoParcelsExist(String expectedHeader, String expectedWidgetButton){
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        driver.verifyThat()
                .element(WidgetButton_btn)
                .text()
                .contains(expectedWidgetButton)
                .perform();
        driver.verifyThat()
                .element(widgetButtonBtnSecond)
                .text()
                .contains(expectedWidgetButton)
                .perform();
        driver.verifyThat()
                .element(widgetButtonBtnThird)
                .doesNotExist()
                .perform();
        return this;
    }
    @Step("Validate Section with two parcels exist ")
    public DashboardPage validateSectionThreeParcelsExist(String expectedHeader, String expectedWidgetButton){
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        driver.verifyThat()
                .element(WidgetButton_btn)
                .text()
                .contains(expectedWidgetButton)
                .perform();
        driver.verifyThat()
                .element(widgetButtonBtnSecond)
                .text()
                .contains(expectedWidgetButton)
                .perform();
        driver.verifyThat()
                .element(widgetButtonBtnThird)
                .text()
                .contains(expectedWidgetButton)
                .perform();
        return this;
    }
    @Step("Validate Section does not contain parcels")
    public DashboardPage validateNoHardwareNotExist(){
        driver.verifyThat()
                .element(WidgetButton_btn)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(widgetButtonBtnSecond)
                .doesNotExist()
                .perform();
        driver.verifyThat()
                .element(widgetButtonBtnThird)
                .doesNotExist()
                .perform();
        return this;
    }
    @Step("Validate Headline Exist ")
    public DashboardPage validateHeadlineExist(String expectedHeader) {
        driver.verifyThat()
                .element(Header_Text)
                .text()
                .contains(expectedHeader)
                .perform();
        return this;
    }

    @Step("Validate Section Not Exist ")
    public DashboardPage validateSectionNotExist() {
        driver.verifyThat()
                .element(Header_Text).doesNotExist()
                .perform();
        return this;
    }

    @Step("Validate Section Message in case of missing paramters ")
    public DashboardPage validateSectionMessage(String expectedSectionMessage) {
        driver.verifyThat()
                .element(SectionMsg_Text)
                .text()
                .contains(expectedSectionMessage)
                .perform();
        return this;
    }
}