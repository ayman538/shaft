package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class BookingTransactionPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public BookingTransactionPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //Element Locators
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By pageSubHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By reviewDetailsHeader = By.xpath("//h3[@automation-id='transactionReviewDetails_headline_tv']");
    private By optionName = By.xpath("//span[@class='h2']");
    private By optionPrice = By.xpath("//div[@class='tariffPrice']");
    private By optionDetailsHyperLink = By.xpath("//div[@class='tariff-card-details']//a");
    private By dateTitle = By.xpath("//div//h5");
    private By currentBookingDate = By.xpath("//span[@automation-id='undefined-date_tv']");
    private By policyTerms = By.xpath("//div[@class='white-box contract-summary-card mt-15']");
    private By confirmBookingCTA = By.xpath("//button[@automation-id='undefined_btn']");

    //CLs
    private String dateTitle_CL = "Deine Option startet am:";
    private String policyTerms_CL2 = "Du hast ein 14-tägiges Widerrufsrecht, die Details findest Du in der Widerrufsbelehrung.";

    //Methods
    @Step("Validate booking transaction page titles")
    public BookingTransactionPage validateTransactionPageTitles(String reviewDetailsHeaderCL){
        driver.verifyThat().element(pageHeader).exists().perform();
        driver.verifyThat().element(pageSubHeader).exists().perform();
        driver.verifyThat().element(reviewDetailsHeader).textTrimmed().isEqualTo(reviewDetailsHeaderCL).perform();
        return this;
    }

    @Step("Verify priced booked option card")
    public BookingTransactionPage validatePricedBookedOptionCard(String optionName_CL, String optionPrice_CL){
        driver.verifyThat().element(optionName).textTrimmed().isEqualTo(optionName_CL).perform();
        driver.verifyThat().element(optionPrice).textTrimmed().contains(optionPrice_CL).perform();
        driver.verifyThat().element(optionDetailsHyperLink).exists().perform();
        return this;
    }
    @Step("Verify free booked option card")
    public BookingTransactionPage validateFreeBookedOptionCard(String optionName_CL, String optionPrice_CL){
        driver.verifyThat().element(optionName).textTrimmed().equals(optionName_CL);
        driver.verifyThat().element(optionPrice).textTrimmed().contains(optionPrice_CL).perform();
        return this;
    }

    @Step("Validate booking date")
    public BookingTransactionPage validateBookingDate(){
        driver.verifyThat().element(dateTitle).textTrimmed().isEqualTo(dateTitle_CL).perform();
        driver.verifyThat().element(currentBookingDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Assert on Policy Terms for booking an option")
    public BookingTransactionPage validatePolicyTerms(){
        driver.verifyThat().element(policyTerms).exists().perform();
        driver.verifyThat().element(policyTerms).text().contains(policyTerms_CL2).perform();
        return this;
    }

    @Step("Assert on Booking CTA CL and click on it to confirm the booking transaction")
    public BookingTransactionPage clickOnConfirmBookingCTA(String confirmBookingCTA_CL){
        driver.verifyThat().element(confirmBookingCTA).textTrimmed().isEqualTo(confirmBookingCTA_CL).perform();
        driver.element().click(confirmBookingCTA);
        return this;
    }
}
