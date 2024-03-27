package de.vodafone.pages.PYP;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class EnterpriseOverview {
    private SHAFT.GUI.WebDriver driver;
    public EnterpriseOverview(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //overview page locators
    public static By unpairEnterprise_button = By.xpath("//*[@automation-id='simDetailsSubmitBtn_btn']");
    public static By pairEnterprise_button = By.xpath("(//*[@automation-id='simDetailsSubmitBtn_btn'])[1]");

    public EnterpriseOverview clickUnpairEnterpriseButton()
    {
        new ElementActions(driver.getDriver()).click(unpairEnterprise_button);
        return this;
    }

    public EnterpriseOverview clickPairEnterpriseButton()
    {
        new ElementActions(driver.getDriver()).click(pairEnterprise_button);
        return this;
    }
}
