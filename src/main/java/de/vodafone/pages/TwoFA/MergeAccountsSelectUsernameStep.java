package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MergeAccountsSelectUsernameStep {
    private static SHAFT.GUI.WebDriver driver;
    public MergeAccountsSelectUsernameStep(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By firstUsername = By.xpath("(//ol-radio-item[@class='input-container'])[1]");


    public MergeAccountsSelectUsernameStep selectFirstUsername() {
        driver.element().click(firstUsername);
        return this;
    }


}
