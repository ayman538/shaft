package de.vodafone.pages.Account;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChangePersonalDataPage {
    private SHAFT.GUI.WebDriver driver;

    public ChangePersonalDataPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameInput = By.xpath("//input[@id='firstnameField']");
    private By lastNameInput = By.xpath("//input[@id='lastnameField']");

    @Step("Check navigation to change personal data page")
    public void checkChangePersonalDataPage(){
        driver.verifyThat().element(firstNameInput).exists().perform();
        driver.verifyThat().element(firstNameInput).exists().perform();
    }
}
