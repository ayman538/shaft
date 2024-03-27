package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChangeUsernamePage {
    private SHAFT.GUI.WebDriver driver;

    public ChangeUsernamePage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By usernameInput = By.xpath("//input[@id='usernameField']");

    @Step("Check navigation to change username page")
    public void checkUsernamePage(){
        driver.verifyThat().element(usernameInput).exists().perform();
    }
}
