package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class SecondStepPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    //Locators
    private By headline_Text = By.xpath("//tenant-info//h2");
    private By firstName_Label=By.xpath("//*[@formcontrolname='firstName']//label");
    private By firstName_Input=By.xpath("//*[@automation-id='firstName_et']");
    private By weiter_Button=By.xpath("(//tenant-info//button)[1]");
    //constructor
    public SecondStepPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //keywords
    public SecondStepPage clickOnWeiterButton() {
        (new ElementActions(driver.getDriver())).click(weiter_Button);
        return this;
    }
    public SecondStepPage validateFirstNameDeletedInSecondStepPage(String expectedPageHeadline){
        Validations.assertThat().element(driver.getDriver(), headline_Text)
                .text().contains(expectedPageHeadline)
                .withCustomReportMessage("Check Second Step Page Headline is displayed").perform();
        Validations.assertThat().element(driver.getDriver(),firstName_Label )
                .doesNotExist()
                .withCustomReportMessage("Check That First name label is Deleted").perform();
        Validations.assertThat().element(driver.getDriver(),firstName_Input )
                .doesNotExist()
                .withCustomReportMessage("Check That First name input is Deleted").perform();
        return this;
    }
}