package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ContractChooserPage {
    private SHAFT.GUI.WebDriver driver;
    public static By contractFromContarctChooserLocator (String contractIndex)
    {
        return By.xpath("(//div[@class='subscription__info'])["+ contractIndex+"]");
    }
    public ContractChooserPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("choose contract number from contract chooser")
    public ContractChooserPage clickContractFromContractChooser(String contractIndex)
    {
        driver.element().click(contractFromContarctChooserLocator(contractIndex));
        return this;
    }
}
