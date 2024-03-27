package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class ASPMobileOverview {
    private static SHAFT.GUI.WebDriver driver;

    // Constructor
    public ASPMobileOverview(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By revokeButton = By.xpath("//a[@class='btn btn-em'][1]");


    //methods
    @Step("click revoke")
    public ASPMobileOverview clickrevoke() {
        driver.element().click(revokeButton);

        return this;
    }
}
