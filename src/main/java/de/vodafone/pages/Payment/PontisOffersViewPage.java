package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PontisOffersViewPage {

    private SHAFT.GUI.WebDriver driver;

    private By pageTitle_Locator = By.xpath("//div[@automation-id='pageHeader_tv']");
    private By accordionHeadLine_Locator = By.xpath("//div[@class='tg-head tg-active one-step']/p[@class='mb-0']");
    private By accordionTitle_Locator = By.xpath("//div[@id='review']/h3");
    private By accordionDescription_Locator = By.xpath("//div[@id='review']//p");
    private By confirmOfferBtn_Locator = By.xpath("//div[@class='fm-buttons']/button");
    private By cancelOfferBtn_Locator = By.xpath("//span[@class='btn btn-sml btn-alt']");


    //CLs
    private String accordionHeadLine_CL = "Du buchst";
    private String confirmOfferBtn_CL = "Jetzt kostenpflichtig bestellen";
    private String cancelOfferBtn_CL = "Abbrechen";

    //Methods
    public PontisOffersViewPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("Click confirm button")
    public PontisOffersViewPage clickConfirmBtn(){
        driver.element().click(confirmOfferBtn_Locator);
        return this;
    }

    @Step("Click cancel button")
    public PontisOffersViewPage clickCancelBtn(){
        driver.element().click(cancelOfferBtn_Locator);
        return this;
    }

    //Assertions
    public PontisOffersViewPage assertOnPageTitle(){
        driver.verifyThat().element(pageTitle_Locator).exists().withCustomReportMessage("Assert on page title").perform();
        return this;
    }
    public PontisOffersViewPage assertOnAccordionHeadline(){
        driver.verifyThat().element(accordionHeadLine_Locator).textTrimmed().isEqualTo(accordionHeadLine_CL).withCustomReportMessage("Assert on accordion headline").perform();
        return this;
    }
    public PontisOffersViewPage assertOnOfferTitle(String title){
        driver.verifyThat().element(accordionTitle_Locator).textTrimmed().isEqualTo(title).withCustomReportMessage("Assert on accordion title").perform();
        return this;
    }
    public PontisOffersViewPage assertOnOfferDescription(String description){
        driver.verifyThat().element(accordionDescription_Locator).textTrimmed().isEqualTo(description).withCustomReportMessage("Assert on accordion description").perform();
        return this;
    }
}
