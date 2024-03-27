package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InvoicePage {
    private SHAFT.GUI.WebDriver driver;

    //Element Locators

    private By InvoiceArchiveLocator = By.xpath("//a[@automation-id='Rechnungsarchiv_Link']");

    //Constructor
    public InvoicePage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Methods
    @Step("Validate that the invoice page open successfully")
    public InvoicePage validateInvoicePageOpenSuccessfully(){
        driver.verifyThat().element(InvoiceArchiveLocator).exists().perform();
        return this;
    }
}
