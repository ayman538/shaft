package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ASPMoblieRevocationPage {

    private static SHAFT.GUI.WebDriver driver;

    // Constructor
    public ASPMoblieRevocationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By winbackButton = By.xpath("//h4[@automation-id='winback-link_title_tv']");
    @Step("click revoke")
    public ASPMoblieRevocationPage clickwinback() {
        driver.element().click(winbackButton);
        return this;
    }
}
