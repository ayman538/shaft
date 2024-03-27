package de.vodafone.pages.unityMedia;

import com.shaft.driver.SHAFT;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class ConfirmationPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ConfirmationPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Element Locators
    private By overviewAccordionLocator = By.xpath("(//*[@automation-id='accordion0_acc'])");
    private By confirmationMessageLocator = By.xpath("//div[@automation-id='confirmation_nt']");
    private By workOrderNotificationLocator = By.xpath("//div[@automation-id='workOrder_nt']");
    private By bookedPhoneOptionTitleLocator = By.xpath("//div[@class='tariff-card-header']//span");
    private By bookedPhoneOptionPriceLocator = By.xpath("//div[@class='tariff-card-price']");
    private By bookedPhoneOptionDescLocator = By.xpath("//div[@class='short-description']");
    private By dateTitle = By.xpath("//h5[@automation-id='startBookingDate_tv']");
    private By currentDate = By.xpath("//span[@automation-id='currentDate_tv']");
    private By cancelingDateTitle = By.xpath("//h5[@automation-id='startCancellingDate_tv']");
    private By tvOptionName = By.xpath("//div[@class='extras-card-header']/span");
    private By tvOptionPrice = By.xpath("//div[@class='extras-card-price']");
    private By tvOptionDescription = By.xpath("//div[@class='price-information']");
    /* **************WFCT-12634*********** */
    private By itemizedBillChangedMessage = By.xpath("//*[@class='item-2 w-100']/h4");
    private By ubersichtAccordion = By.xpath("//a[@class='ac-head ac-active']");
    private By accordionLocator = By.xpath("//li[@automation-id='accordion0_acc']/a");
    private By confirmationTelephoneNumberLocator = By.xpath("//p[@automation-id='confirmationTelephoneNumber_tv']/strong");
    private By confirmationBillingTypeLocator = By.xpath("//p[@automation-id='confirmationBillingType_tv']/strong");
    private By legalConfirmationLocator = By.xpath("//p[@automation-id='confirmationLegal_tv']/strong");
    private By locator = By.xpath("//span[@span='']");

    //CLs
    /* *****************WFCT-12634 ************** */
    private String itemizedBillChangedSuccesssfullyMessage = "Deine Änderung haben wir gespeichert";
    private String itemizedBillChangedSuccesssfullyMessage_MultipleCase = "Deine Änderungen haben wir gespeichert";
    private String legalConfirmationText = "Mitbenutzer-Erklärung:";
    private String rufnummer = "Rufnummer:";
    private String confirmationBillingTypeText = "EVN:";

    //Methods
    @Step("Validate Phone Booking Confirmation Page")
    public ConfirmationPage validateConfirmationPageElements(String confirmationMessageCL) {
        driver.element().waitToBeReady(workOrderNotificationLocator);
        driver.verifyThat().element(confirmationMessageLocator).textTrimmed().isEqualTo(confirmationMessageCL).perform();
        driver.verifyThat().element(workOrderNotificationLocator).exists().perform();
        return this;
    }

    @Step("Expand Overview Accordion")
    public ConfirmationPage expandOverviewAccordion() {
        driver.element().click(overviewAccordionLocator);
        return this;
    }

    @Step("Validate canceling date")
    public ConfirmationPage validateCancelingDate(String cancelingDateTitleCL){
        driver.verifyThat().element(cancelingDateTitle).textTrimmed().isEqualTo(cancelingDateTitleCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Validate phone booked Option at Overview Accordion")
    public ConfirmationPage validateBookedPhoneOption(String optionNameCL, String optionPriceCL){
        driver.verifyThat().element(bookedPhoneOptionTitleLocator).textTrimmed().isEqualTo(optionNameCL).perform();
        driver.verifyThat().element(bookedPhoneOptionPriceLocator).text().contains(optionPriceCL).perform();
        driver.verifyThat().element(bookedPhoneOptionDescLocator).text().isNotNull().perform();
        return this;
    }

    @Step("Validate TV cancelled Option at Overview Accordion")
    public ConfirmationPage validateCancelledTVOption(String optionNameCL, String optionPriceCL){
        driver.verifyThat().element(tvOptionName).textTrimmed().isEqualTo(optionNameCL).perform();
        driver.verifyThat().element(tvOptionPrice).text().contains(optionPriceCL).perform();
        driver.verifyThat().element(tvOptionDescription).text().isNotNull().perform();
        return this;
    }

    @Step("Validate booking date")
    public ConfirmationPage validateBookingDate(String dateTitleCL){
        driver.verifyThat().element(dateTitle).textTrimmed().isEqualTo(dateTitleCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Expand The Confirmation Accordion")
    public void expandConfirmationAccordion(){
        driver.element().click(accordionLocator);
    }

    public void assertThatPageRedirectedSuccessfully(){
        driver.verifyThat().element(locator)
                .doesNotExist()
                .withCustomReportMessage("Make Sure That Page Navigated and Loaded Successfully ")
                .perform();
    }

    public void assertOnItemizedBillChangedSuccesfullyMessage(){
        driver.verifyThat().element(itemizedBillChangedMessage)
                .text().isEqualTo(itemizedBillChangedSuccesssfullyMessage)
                .withCustomReportMessage("Assert On Itemized Bill Changed Succesfully Message ")
                .perform();
    }

    public void assertOnItemizedBillChangedSuccesfullyMessage_MultipleCase(){
        driver.verifyThat().element(itemizedBillChangedMessage)
                .text().isEqualTo(itemizedBillChangedSuccesssfullyMessage_MultipleCase)
                .withCustomReportMessage("Assert On Itemized Bill Changed Succesfully Message ")
                .perform();
    }

    public void assertOnAccordionIsCollapsed(){
        driver.verifyThat().element(ubersichtAccordion)
                .doesNotExist().withCustomReportMessage("Assert That Accordion is Collapsed")
                .perform();
    }

    public void assertOnRufnummer(){
        driver.verifyThat().element(confirmationTelephoneNumberLocator).text()
                .isEqualTo(rufnummer)
                .withCustomReportMessage("Assert On Rufnummer Field").perform();
    }

    public void assertOnconfirmationBillingType(){
        driver.verifyThat().element(confirmationBillingTypeLocator).text()
                .isEqualTo(confirmationBillingTypeText)
                .withCustomReportMessage("Assert On Confirmation Billing Type Locator").perform();
    }

    public void assertOnLegalConfirmation(){
        driver.verifyThat().element(legalConfirmationLocator).text()
                .isEqualTo(legalConfirmationText)
                .withCustomReportMessage("Assert On legal Confirmation Locator").perform();
    }

}
