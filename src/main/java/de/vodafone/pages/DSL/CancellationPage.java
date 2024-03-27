package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CancellationPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public CancellationPage (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By cancelingConfCTA =By.xpath("//*[@automation-id='cancel-dsl-extra_btn']");
    private By bookedExtraTitleLocator = By.xpath("//*[@class='tariff-card-header']");
    private By bookedExtraPriceLocator = By.xpath("//*[@class='tariffPrice']");
    private By bookedExtraDescriptionLocator = By.xpath("(//*[@class='short-description'])//p");

    //Methods
    @Step("Confirm option cancellation")
    public CancellationPage clickQuitNowCTA() {
        driver.element().click(cancelingConfCTA);
        return this;
    }
}
