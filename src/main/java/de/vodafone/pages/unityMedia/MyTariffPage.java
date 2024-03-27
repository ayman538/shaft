package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
public class MyTariffPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public MyTariffPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By phoneBookableOptionsAccordion = By.xpath("//li[@automation-id='phoneBookableOptions_acc']");
    private By phoneOptionBookCTA = By.xpath("(//a[text()='Jetzt buchen'])[1]");
    private By tvBookedOptions = By.xpath("//li[@automation-id='productBookedOptions_acc']");
    private By cancelTVOptionCTA = By.xpath("//div[@class='extras-card-button']//a");
    private By Contract_Termination_CTA = By.xpath("//*[@automation-id='option_2_rb']");

    //Methods
    @Step("Expand Phone Bookable Options Accordion")
    public MyTariffPage expandPhoneBookableOptionsAccordion(){
        driver.element().click(phoneBookableOptionsAccordion);
        return this;
    }

    @Step("Click Book Now CTA that navigates to transaction page")
    public MyTariffPage clickOnBookNowCTAToBookPhoneOption(){
        driver.element().click(phoneOptionBookCTA);
        return this;
    }

    @Step("Expand TV Booked options at TV Tariff page")
    public MyTariffPage expandTVBookedOptionsAccordion(){
        driver.element().click(tvBookedOptions);
        return this;
    }

    @Step("click on cancel CTA for TV booked option")
    public MyTariffPage clickOnCancelTVBookedOption(){
        driver.element().click(cancelTVOptionCTA);
        return this;
    }

    @Step("click on contract termination CTA on tariff page")
    public void clickContractTermination(){
        driver.element().click(Contract_Termination_CTA);
    }
}
