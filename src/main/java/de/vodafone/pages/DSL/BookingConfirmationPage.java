package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class BookingConfirmationPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public BookingConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By pageSubHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By confirmationMessageHeader = By.xpath("//h4[@class='flexDiv']");
    private By confirmationMessageBody = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By overviewHeader = By.xpath("(//li[@automation-id='accordion0_acc']//span)[1]");
    private By optionName = By.xpath("//div[@class='tariff-card-header']//span");
    private By optionPrice = By.xpath("//div[@class='tariffPrice']");
    private By optionDetailsHyperLink = By.xpath("//div[@class='tariff-card-details']//a");
    private By dateTitle = By.xpath("//div[@class='white-box date-card mt-5']//h5");
    private By currentBookingDate = By.xpath("//span[@automation-id='undefined-date_tv']");

    //CLs
    private String overviewHeaderCL = "Übersicht";
    private String dateTitleCL = "Deine Option startet am:";
    private String confirmationMessageHeaderCL = "Fast geschafft!";

    //Methods
    @Step("Expand overview accordion")
    public BookingConfirmationPage expandOverviewAccordion(){
        driver.element().click(overviewHeader);
        return this;
    }

    @Step("Validate booking confirmation page titles")
    public BookingConfirmationPage validateConfirmationPageTitles(){
        driver.verifyThat().element(pageHeader).exists().perform();
        driver.verifyThat().element(pageSubHeader).exists().perform();
        driver.verifyThat().element(overviewHeader).textTrimmed().isEqualTo(overviewHeaderCL).perform();
        return this;
    }

    @Step("Validate confirmation message")
    public BookingConfirmationPage validateConfirmationMessage(){
        driver.verifyThat().element(confirmationMessageHeader).textTrimmed().isEqualTo(confirmationMessageHeaderCL).perform();
        driver.verifyThat().element(confirmationMessageBody).exists().perform();
        return this;
    }

    @Step("Validate booking date")
    public BookingConfirmationPage validateActualBookingDate(){
        driver.verifyThat().element(dateTitle).textTrimmed().isEqualTo(dateTitleCL).perform();
        driver.verifyThat().element(currentBookingDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Verify priced booked option card")
    public BookingConfirmationPage validatePricedBookedOptionCard(String optionName_CL, String optionPrice_CL){
        driver.verifyThat().element(optionName).textTrimmed().isEqualTo(optionName_CL).perform();
        driver.verifyThat().element(optionPrice).textTrimmed().contains(optionPrice_CL).perform();
        driver.verifyThat().element(optionDetailsHyperLink).exists().perform();
        return this;
    }

    @Step("Verify free Option Card")
    public BookingConfirmationPage validateFreeBookedOptionCard(String optionName_CL, String optionPrice_CL){
        driver.verifyThat().element(optionName).textTrimmed().isEqualTo(optionName_CL).perform();
        driver.verifyThat().element(optionPrice).textTrimmed().contains(optionPrice_CL).perform();
        return this;
    }
}
