package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class DSL_CancelingTransaction {
    private SHAFT.GUI.WebDriver driver;

    public DSL_CancelingTransaction(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public static By CancelingConfCTA =By.xpath("//*[@automation-id='cancel-dsl-extra_btn']");
    public static By BookedExtraTitleLocator = By.xpath("//*[@class='tariff-card-header']");
    public static By BookedExtraPriceLocator = By.xpath("//*[@class='tariffPrice']");
    public static By BookedExtraDescriptionLocator = By.xpath("(//*[@class='short-description'])//p");

    public String getTransText(By locator){
        String text = driver.element().getText(locator);
        return text;
    }

    public DSL_ConfirmationPage clickQuitNowCTA() {
        (new ElementActions(driver.getDriver())).click(CancelingConfCTA);
        return new DSL_ConfirmationPage(driver);
    }
}
