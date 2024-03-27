package de.vodafone.pages.CableOnboarding;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeineChecklistPage {
    private final SHAFT.GUI.WebDriver driver;

    public DeineChecklistPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By checkListHeadline = By.xpath("//h1[@automation-id='h1_tv']");
    private By checkListSubheader = By.xpath("//div[@automation-id='undefined_tv']");
    private By firstCheck = By.xpath("(//div[@automation-id='undefined_chk']//div)[1]");
    private By secondCheck = By.xpath("(//div[@automation-id='undefined_chk']//div)[2]");
    private By thirdCheck = By.xpath("(//div[@automation-id='undefined_chk']//div)[3]");
    private By confirmationBtn = By.xpath("(//a[@automation-id='undefined_Link']//span)[1]");
    private By backBtn = By.xpath("(//a[@automation-id='undefined_Link']//span)[2]");
    private By notificationText = By.xpath("//div[@class='ws10-notification__text']");
    private By clickableBackBtn = By.xpath("(//a[@automation-id=\"undefined_Link\"]//span)[1]");

    //START WFFT-3806
    @Step("Verify the text of the page")
    public DeineChecklistPage verifyThePageText(String headline, String subHeader, String firstChecker, String secondChecker, String thirdChecker
    , String confirmBtn, String backButton){
        driver.verifyThat().element(checkListHeadline).textTrimmed().contains(headline).perform();
        driver.verifyThat().element(checkListSubheader).textTrimmed().contains(subHeader).perform();
        driver.verifyThat().element(firstCheck).textTrimmed().contains(firstChecker).perform();
        driver.verifyThat().element(secondCheck).textTrimmed().contains(secondChecker).perform();
        driver.verifyThat().element(thirdCheck).textTrimmed().contains(thirdChecker).perform();
        driver.verifyThat().element(confirmationBtn).textTrimmed().contains(confirmBtn).perform();
        driver.verifyThat().element(backBtn).textTrimmed().contains(backButton).perform();
        return this;
    }

    @Step("Check the checklist boxes")
    public DeineChecklistPage checkTheBoxes(String notification){
        driver.element().click(firstCheck);
        driver.element().click(secondCheck);
        driver.element().click(thirdCheck);
        driver.element().click(confirmationBtn);
        driver.verifyThat().element(notificationText).textTrimmed().contains(notification).perform();
        return this;
    }

    @Step("Click the back button")
    public DeineChecklistPage clickTheBackBtn(){
        driver.element().click(clickableBackBtn);
        return this;
    }
}
