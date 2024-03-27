package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class InvoiceHelpPage {
    private SHAFT.GUI.WebDriver driver;

    public InvoiceHelpPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //locators
    private static By invoiceHelpPageHeader = By.xpath("//h1[contains(.,\"Alles zur Rechnung\")]");


    @Step("assert that invoice help page loaded")
    public void assertThatInvoiceHelpPageLoaded() {
        Validations.verifyThat().element(driver.getDriver(), invoiceHelpPageHeader).exists()
                .withCustomReportMessage("assert that invoice help page loaded").perform();
    }

}
