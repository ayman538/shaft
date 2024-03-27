package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Info_Technik_Service {
    private SHAFT.GUI.WebDriver driver;
    //Locators
    private By headline1_txt = By.xpath("//h2[@automation-id='h2_tv']");
    private By subline1_txt = By.xpath("//div[@automation-id='undefined_tv']");
    private By headline2_txt = By.xpath("//h4[@automation-id='h4_tv']");
    private By subline2_txt = By.xpath("//div[@id='content']//ws10-media-text-item//div[2]");
    private By zum_Btn = By.xpath("//a[@automation-id='undefined_Link']");

    public Info_Technik_Service(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("Clink on the Zum button")
    public TechInstallDashboard clickOnZumButton() {
        driver.element().click(zum_Btn);
        return new TechInstallDashboard(driver);
    }

    @Step("Validate the Info Page")
    public Info_Technik_Service validateInfoPageCase1(String headline1, String subline1, String headline2, String subline2, String button) {
        driver.verifyThat()
                .element(headline1_txt)
                .text()
                .isEqualTo(headline1)
                .perform();
        driver.verifyThat()
                .element(subline1_txt)
                .text()
                .isEqualTo(subline1)
                .perform();
        driver.verifyThat()
                .element(headline2_txt)
                .text()
                .isEqualTo(headline2)
                .perform();
        driver.verifyThat()
                .element(subline2_txt)
                .text()
                .isEqualTo(subline2)
                .perform();
        driver.verifyThat()
                .element(zum_Btn)
                .text()
                .isEqualTo(button)
                .perform();
        return this;
    }
    public Info_Technik_Service validateInfoPageCase2(String headline1, String subline1, String headline2, String subline3, String button) {
        driver.verifyThat()
                .element(headline1_txt)
                .text()
                .isEqualTo(headline1)
                .perform();
        driver.verifyThat()
                .element(subline1_txt)
                .text()
                .isEqualTo(subline1)
                .perform();
        driver.verifyThat()
                .element(headline2_txt)
                .text()
                .isEqualTo(headline2)
                .perform();
        driver.verifyThat()
                .element(subline2_txt)
                .text()
                .isEqualTo(subline3)
                .perform();
        driver.verifyThat()
                .element(zum_Btn)
                .text()
                .isEqualTo(button)
                .perform();
        return this;
    }
}

