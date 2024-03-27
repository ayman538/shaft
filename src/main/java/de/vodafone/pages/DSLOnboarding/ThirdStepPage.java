package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class ThirdStepPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    //Locators
    private By headline_Text = By.xpath("//customer-data-form//h2");
    private By firstName_Label=By.xpath("//h4[contains(text(),'Vorname Vormieter')]");
    //constructor
    public ThirdStepPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //keywords
    public ThirdStepPage validateFirstNameDeletedInThirdStepPage(String expectedPageHeadline){
        Validations.assertThat().element(driver.getDriver(), headline_Text)
                .text().contains(expectedPageHeadline)
                .withCustomReportMessage("Check Third Step Page Headline is displayed").perform();
        Validations.assertThat().element(driver.getDriver(),firstName_Label )
                .doesNotExist()
                .withCustomReportMessage("Check That First name label is Deleted").perform();
        return this;
    }
}
