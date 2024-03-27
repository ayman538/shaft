package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;

public class HandleGigaKombi {
    private SHAFT.GUI.WebDriver driver;
    public HandleGigaKombi(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public static By GigaKombiNotification = By.xpath("//*[@automation-id='giga-kombi_nt']");
    private static By GigaKombiQuitAnywayCTA =By.xpath("//*[@automation-id='giga-kombi_btn']");

    public DSL_CancelingTransaction clickQuitNowCTA() {
        (new ElementActions(driver.getDriver())).click(GigaKombiQuitAnywayCTA);
        return new DSL_CancelingTransaction(driver);
    }

}
