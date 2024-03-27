package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ASPSimOverview {

    private static SHAFT.GUI.WebDriver driver;

    // Constructor
    public ASPSimOverview(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private By revokeButton = By.xpath("(//button[@class='btn btn-em'])[2]");


    //methods
    @Step("click revoke")
    public ASPSimOverview clickrevoke() {
        driver.element().click(revokeButton);

        return this;
    }
}

