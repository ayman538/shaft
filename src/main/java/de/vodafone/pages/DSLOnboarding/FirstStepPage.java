package de.vodafone.pages.DSLOnboarding;

import com.shaft.driver.SHAFT;
import com.shaft.gui.element.ElementActions;
import com.shaft.validation.Validations;
import org.openqa.selenium.By;

public class FirstStepPage {
    // Variables
    private static SHAFT.GUI.WebDriver driver;
    //Locators
    private By headline_Text = By.xpath("//date-selection//h2");
    private By date_Button=By.xpath("//table//tr[5]//td[5]//button");
    private By weiter_Button=By.xpath("//date-selection/button");
    //constructor
    public FirstStepPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    //keywords
    public FirstStepPage selectDate(){
        driver.element().click( date_Button);
        return this;
    }
    public FirstStepPage clickOnWeiterButton() {
        (new ElementActions(driver.getDriver())).click(weiter_Button);
        return this;
    }
    public FirstStepPage validateFirstStepPageHeadline(String expectedPageHeadline){
        Validations.assertThat().element(driver.getDriver(), headline_Text)
                .text().contains(expectedPageHeadline)
                .withCustomReportMessage("Check First Step Page Headline is displayed").perform();
        return this;
    }
}