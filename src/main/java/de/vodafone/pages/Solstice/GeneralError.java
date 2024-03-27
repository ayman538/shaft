package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class GeneralError {
    private SHAFT.GUI.WebDriver driver;
    private static By AddContract_button = By.xpath("//*[@automation-id='undefined_btn']");

    public GeneralError (SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public AddContractChooser addContract() {
        driver.element().click(AddContract_button );
        return new AddContractChooser(driver);
    }
}
