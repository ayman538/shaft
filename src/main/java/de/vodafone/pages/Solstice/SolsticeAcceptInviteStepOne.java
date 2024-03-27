package de.vodafone.pages.Solstice;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class SolsticeAcceptInviteStepOne {
    private SHAFT.GUI.WebDriver driver;
    public static By Register_Button = By.xpath("//*[text()='Zur Registrierung']");


    public SolsticeAcceptInviteStepOne(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public SolssticePersonalData clickOnRegisterButton() {
        new ElementActions(driver.getDriver()).click(Register_Button);
        return new SolssticePersonalData(driver);
    }
}
