package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChangePasswordPage {
    private SHAFT.GUI.WebDriver driver;

    public ChangePasswordPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By oldPasswordInput = By.xpath("//input[@id='old_password']");
    private By newPasswordInput = By.xpath("//input[@id='new_password']");

    @Step("Check navigation to merge accounts page")
    public void checkChangePasswordPage(){
        driver.verifyThat().element(oldPasswordInput).exists().perform();
        driver.verifyThat().element(newPasswordInput).exists().perform();
    }
}
