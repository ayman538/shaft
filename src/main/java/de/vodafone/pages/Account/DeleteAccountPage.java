package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeleteAccountPage {
    private SHAFT.GUI.WebDriver driver;

    public DeleteAccountPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By deleteAccountButton = By.xpath("//button[@class='btn btn-sml']");

    @Step("Check Add contract page and tiles")
    public void checkDeleteAccountPage(){
        driver.verifyThat().element(deleteAccountButton).exists().perform();
    }
}
