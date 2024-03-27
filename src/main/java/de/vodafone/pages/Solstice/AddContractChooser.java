package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class AddContractChooser {
    private SHAFT.GUI.WebDriver driver;

    private static By MobileContract_label = By.xpath("(//*[@class='input-container'])[1]");


    public AddContractChooser(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public AddContractNumber addMobileContract() {
        driver.element().click( MobileContract_label );
        return new AddContractNumber(driver);
    }
}
