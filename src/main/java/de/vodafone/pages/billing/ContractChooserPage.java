package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContractChooserPage {
    private SHAFT.GUI.WebDriver driver;

    private static By contractChooserPageLocator = By.xpath("//div[@class='contracts-chooser']");

    public ContractChooserPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private static By contractFromContractChooserLocator(String contractIndex) {
        return By.xpath("(//div[@class='subscription__info'])[" + contractIndex + "]");
    }

    @Step("choose contract number from contract chooser")
    public ContractChooserPage clickContractFromContractChooser(String contractIndex) {
        if (driver.element().getElementsCount(contractChooserPageLocator) == 1) {
            driver.element().click( contractFromContractChooserLocator(contractIndex));
        }
        return this;
    }

}

