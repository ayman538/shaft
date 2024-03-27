package de.vodafone.pages.TwoFA;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AddContractPage {
    private SHAFT.GUI.WebDriver driver;

    public AddContractPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By requestActivationCodeCTA = By.xpath("//a[@class=\"ac-head background-white\"]");
    private By unityMediaCTA = By.xpath("//input[@value=\"unitymedia\"]");


    public AddContractPage chooseUnityMedia() {
        driver.element().click(unityMediaCTA);
        return this;
    }

    public AddContractPage clickRequestActivationCode() {
        driver.element().click(requestActivationCodeCTA);
        return this;
    }
}
