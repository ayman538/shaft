package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class SolsticePersonalDataReview {
    private SHAFT.GUI.WebDriver driver;

    public static By Weiter_button = By.xpath("//*[text()='Weiter']");

    public SolsticePersonalDataReview(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    public SolsticeDashboard clickWeiterButton() {
        new ElementActions(driver.getDriver()).click(Weiter_button);
        return new SolsticeDashboard(driver);
    }
}
