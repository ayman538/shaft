package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import org.openqa.selenium.By;

public class MergeAccountsAcceptStep {
    private static SHAFT.GUI.WebDriver driver;
    public MergeAccountsAcceptStep(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By checkbox = By.xpath("//label[@for='checkbox']");
    private By button = By.xpath("//button[@class='btn btn-sml']");
    private By weiterButton = By.xpath("//button[@class='btn btn-em btn-sml']");


    public MergeAccountsAcceptStep clickCheckbox() {
        driver.element().click(checkbox);
        return this;
    }
    public MergeAccountsAcceptStep clickButton() {
        driver.element().click(button);
        return this;
    }
    public MergeAccountsAcceptStep clickWeiterButton() {
        driver.element().click(weiterButton);
        return this;
    }

}
