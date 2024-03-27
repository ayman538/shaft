package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MergeAccountsPage {
    private SHAFT.GUI.WebDriver driver;

    public MergeAccountsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By usernameInput = By.xpath("//input[@id='txtUsername']");
    private By passwordInput = By.xpath("//input[@id='txtPassword']");

    @Step("Check navigation to merge accounts page")
    public void checkMergeAccountsPage(){
        driver.verifyThat().element(usernameInput).exists().perform();
        driver.verifyThat().element(passwordInput).exists().perform();
    }
}
