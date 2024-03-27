package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FailurePage {
    private SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;

    private By FailurePageErrorHeader_Text = By.xpath("//div[@class='sc-1n82xk-2 ikDSqW']");

    public FailurePage(SHAFT.GUI.WebDriver driver) {this.driver = driver;}
    @Step("Validate FailurePage Existance")
    public FailurePage validateFailurePage(String FailurePageErrorHeaderExpected) {
        driver.verifyThat()
                .element(FailurePageErrorHeader_Text)
                .text()
                .contains(FailurePageErrorHeaderExpected)
                .perform();
        return this;
    }
}
