package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WidgetPage {
    private SHAFT.GUI.WebDriver driver;
    private By widgetHeader_Text = By.xpath("//div[@automation-id='pageHeader_tv']");
   // private By widgetFooter_Text = By.xpath("//div[@class='sc-htfnp1-3 jNYkDd']");
    private By widgetFooter_Text = By.xpath("//div[@class='sc-htfnp1-3 vUmNL']");

    // constructor
    public WidgetPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    // keywords
    @Step("Click on back browser ")
    public WidgetPage clickOnBackBrowser() {
        driver.browser().navigateBack();
        return this;
    }


    @Step("Validate WidgetPage Existance")
    public WidgetPage validateWidgetPageDesignHeaderOnly(String expectedWidgetHeader) {
        driver.verifyThat()
                .element(widgetHeader_Text)
                .text()
                .contains(expectedWidgetHeader)
                .perform();
        return this;
    }
    @Step("Validate WidgetPage opened successfully")
    public WidgetPage validateWidgetPageHeader(String expectedWidgetHeader) {
        driver.verifyThat()
                .element(widgetHeader_Text)
                .text()
                .contains(expectedWidgetHeader)
                .perform();
        return this;
    }

    @Step("Validate WidgetPage footer")
    public WidgetPage validateWidgetPageFooter(String expectedWidgetFooter) {
        driver.verifyThat()
                .element(widgetFooter_Text)
                .text()
                .contains(expectedWidgetFooter)
                .perform();
        return this;
    }
}
