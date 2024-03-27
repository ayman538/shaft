package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Dashboard {
    private SHAFT.GUI.WebDriver driver;
    public Dashboard(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private static By MeinKontoIcon = By.xpath("//li[@class='menu-md'][1]");
    private static By LoginDatenButton = By.linkText("Login-Daten");
    private static By UbersichtButton = By.linkText("Übersicht");
    private static By addContractCTA = By.xpath("//a[@class='btn btn-em addBtn']");

    private String dashboardURL = "meinvodafone/services/";


    public AccountManagementPage chooseLoginDatenFromMeinKonto() {
        (new ElementActions(driver.getDriver())).click(MeinKontoIcon).click(LoginDatenButton);
        return new AccountManagementPage(driver);
    }
    public AccountManagementPage chooseUbersichtFromMeinKonto() {
        (new ElementActions(driver.getDriver())).click(MeinKontoIcon).click(UbersichtButton);
        return new AccountManagementPage(driver);
    }

    @Step("Validate Dashboard page URL")
    public Dashboard validateDashboardPageURL() {
        driver.verifyThat().browser().url().contains(dashboardURL);
        return this;
    }
    public Dashboard clickAddContract() {
        driver.element().click(addContractCTA);
        return this;
    }

}
