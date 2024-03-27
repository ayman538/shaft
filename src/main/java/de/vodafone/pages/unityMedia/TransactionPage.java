package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class TransactionPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public TransactionPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Bookable Options Locators
    private By pageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By pageContractNumber = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By viewOptionHeader = By.xpath("//h3[@automation-id='transactionTileTitle_tv']");
    private By phoneOptionName = By.xpath("//div[@class='tariff-card-header']//span");
    private By phoneOptionPrice = By.xpath("//div[@class='tariffPrice']");
    private By phoneOptionDescription = By.xpath("//div[@class='short-description']");
    private By contractSummaryText = By.xpath("//product-contract-summary");
    private By bookNowCTA = By.xpath("//button[@automation-id='productOrder_btn']");
    private By bookingDateTitle = By.xpath("//h5[@automation-id='startBookingDate_tv']");
    private By currentDate = By.xpath("//span[@automation-id='currentDate_tv']");

    //Canceling Option Locators
    private By cancelingDateTitle = By.xpath("//h5[@automation-id='startCancellingDate_tv']");
    private By tvOptionName = By.xpath("//div[@class='extras-card-header']/span");
    private By tvOptionPrice = By.xpath("//div[@class='extras-card-price']");
    private By tvOptionDescription = By.xpath("//div[@class='price-information']");
    private By cancelNowCTA = By.xpath("//button[@automation-id='productOrder_btn']");

    //Bookable Options Transaction CLs
    private String bookingTransactionPageContractNumberCL = "UM Vertrag (Kundennummer: ";
    private String contractSummaryTextCL = "Hier findest Du Deine Vertragszusammenfassung. So kannst Du nochmal alles in Ruhe prüfen, bevor Du Deine Buchung abschickst.";

    //Methods
    @Step("Validate Phone Booked Option card in Transaction Page")
    public TransactionPage validateBookedOptionCard(String optionNameCL, String optionPriceCL) {
        driver.verifyThat().element(phoneOptionName).textTrimmed().isEqualTo(optionNameCL).perform();
        driver.verifyThat().element(phoneOptionPrice).text().contains(optionPriceCL).perform();
        driver.verifyThat().element(phoneOptionDescription).text().isNotNull().perform();
        return this;
    }

    @Step("Validate Phone Booking Transaction Page")
    public TransactionPage validateTransactionPageElements(String optionHeaderCL, String pageURL){
        driver.verifyThat().element(pageHeader).exists().perform();
        driver.browser().getCurrentURL().equals(pageURL);
        driver.verifyThat().element(pageContractNumber).text().contains(bookingTransactionPageContractNumberCL).perform();
        driver.verifyThat().element(viewOptionHeader).textTrimmed().isEqualTo(optionHeaderCL).perform();
        driver.verifyThat().element(contractSummaryText).text().contains(contractSummaryTextCL).perform();
        return this;
    }

    @Step("Click Book Now CTA To Confirm Booking")
    public TransactionPage clickBookNowCTA(){
        driver.element().click(bookNowCTA);
        return this;
    }

    @Step("Validate booking date")
    public TransactionPage validateBookingDate(String bookingDateTitleCL){
        driver.verifyThat().element(bookingDateTitle).textTrimmed().isEqualTo(bookingDateTitleCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Validate TV cancelable Option card in Transaction Page")
    public TransactionPage validateTVCancellableOption(String optionNameCL, String optionPriceCL) {
        driver.verifyThat().element(tvOptionName).textTrimmed().isEqualTo(optionNameCL).perform();
        driver.verifyThat().element(tvOptionPrice).text().contains(optionPriceCL).perform();
        driver.verifyThat().element(tvOptionDescription).text().isNotNull().perform();
        return this;
    }

    @Step("Validate canceling date")
    public TransactionPage validateCancelingDate(String cancelingDateTitleCL){
        driver.verifyThat().element(cancelingDateTitle).textTrimmed().isEqualTo(cancelingDateTitleCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Confirm canceling the TV booked option")
    public TransactionPage clickCancelNowCTA(){
        driver.element().click(cancelNowCTA);
        return this;
    }
}
