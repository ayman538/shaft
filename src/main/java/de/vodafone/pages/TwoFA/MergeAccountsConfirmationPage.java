package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MergeAccountsConfirmationPage {
    private static SHAFT.GUI.WebDriver driver;
    public MergeAccountsConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By checkbox = By.xpath("//div[@automation-id='undefined_nt']");



    public MergeAccountsConfirmationPage successNot() {
        driver.element().click(checkbox);
        return this;
    }

}
