package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ConfirmationPage {
    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Element Locators
    private By ConfirmationPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By ConfirmationNotificationCard = By.xpath("//div[@automation-id='confirmation_nt']");
    private By ConfirmationNotificationHeader = By.xpath("(//div[@automation-id='successMsg_tv']//p)[1]");
    private By OrderNotificationCard = By.xpath("(//div[@automation-id='workOrder_nt'])");
    private By OrderNotificationHeader = By.xpath("(//div[@class='item-2 w-100'])[2]");
    private By OrderNotificationCTA = By.xpath("(//button[@automation-id='workOrder_btn'])");
    private By OverviewAccordion = By.xpath("(//li[@automation-id='accordion0_acc'])");
    private By InternetOptionCard = By.xpath("(//div[@class='tariff-card-wrapper'])");
    private By InternetOptionName = By.xpath("(//span[@class='h2'])");
    private By InternetOptionPrice = By.xpath("(//div[@class='tariffPrice'])");
    private By PhoneOptionCard = By.xpath("(//div[@class='tariff-card-wrapper'])[1]");
    private By PhoneOptionName = By.xpath("(//div[@class='tariff-card-header'])//span");
    private By PhoneOptionPrice = By.xpath("(//div[@class='tariffPrice'])");
    private By StartDateCard = By.xpath("(//div[@class='white-box date-card mt-10 mb-10'])");
    private By StartDateHeadline = By.xpath("(//h5[@automation-id='startBookingDate_tv'])");
    private By CloseCTA = By.xpath("(//a[@automation-id='back_Link'])");
    private By ErrorNotificationCard= By.xpath("(//div[@automation-id='undefined_nt'])");
    private By ErrorNotificationHeader = By.xpath("(//div[@automation-id='undefined_nt'])//h4");
    private By ErrorNotificationSubLine = By.xpath("(//div[@automation-id='undefined_nt'])//p");
    private By ReturnCTA = By.xpath("(//a[@automation-id='back_Link'])//span[2]");
    private By FirstTVOptionName = By.xpath("//div[@class='tariff-card-header']//span");
    private By OverviewAccordionFirstOptionTV = By.xpath("((//li[@automation-id='accordion0_acc'])//span)[1]");
    private By OverviewAccordionSecondOptionTV = By.xpath("((//li[@automation-id='accordion1_acc'])//span)[1]");
    private By SecondTVOptionName = By.xpath("//div[@class='tariff-card-header']//span");

    //Constructor
    public ConfirmationPage(SHAFT.GUI.WebDriver driver){
        this.driver =driver;
    }

    //Methods
    @Step("Click Order View Accordion")
    public ConfirmationPage clickOrderViewAccordion(){
        driver.element().click(OverviewAccordion);
        return this;
    }

    @Step("Click On Close CTA")
    public ConfirmationPage clickCloseCTA(){
        driver.element().click(CloseCTA);
        return this;
    }

    @Step("Click Over View Accordion first option tv")
    public ConfirmationPage clickOverviewAccordionFirstOptionTV(){
        driver.element().click(OverviewAccordionFirstOptionTV);
        return this;
    }

    @Step("Click overview accordion for second option tv")
    public ConfirmationPage clickOverviewAccordionSecondOptionTV(){
        driver.element().click(OverviewAccordionSecondOptionTV);
        return this;
    }

    @Step("Validate Booking Transaction Page header CL")
    public ConfirmationPage validateConfirmationPageHeader(String ConfirmationPageHeaderCL){
        driver.assertThat().element(ConfirmationPageHeader).text().isEqualTo(ConfirmationPageHeaderCL).perform();
        return this;
    }

    @Step("Validate Confirmation Notification Card")
    public ConfirmationPage validateConfirmationCard(String ConfirmationNotificationHeaderCL){
        driver.verifyThat().element(ConfirmationNotificationCard).exists().perform();
        driver.assertThat().element(ConfirmationNotificationHeader).text().isEqualTo(ConfirmationNotificationHeaderCL).perform();
        return this;
    }

    @Step("Validate Internet Order Notification Card")
    public ConfirmationPage validateInternetOrderNotificationCard(String OrderNotificationHeaderCL, String OrderNotificationCTACL){
        driver.verifyThat().element(OrderNotificationCard).exists().perform();
        driver.assertThat().element(OrderNotificationHeader).text().isEqualTo(OrderNotificationHeaderCL).perform();
        driver.assertThat().element(OrderNotificationCTA).text().isEqualTo(OrderNotificationCTACL).perform();
        return this;
    }

    @Step("Validate phone Order Notification Card")
    public ConfirmationPage validatePhoneOrderNotificationCard(String OrderNotificationHeaderCL, String OrderNotificationCTACL){
        driver.verifyThat().element(OrderNotificationCard).exists().perform();
        driver.assertThat().element(OrderNotificationHeader).text().isEqualTo(OrderNotificationHeaderCL).perform();
        driver.assertThat().element(OrderNotificationCTA).text().isEqualTo(OrderNotificationCTACL).perform();
        return this;
    }

    @Step("Validate on Internet Option Card")
    public ConfirmationPage validateInternetOptionCard(String InternetOptionNameCL,String InternetOptionPriceCL){
        driver.verifyThat().element(InternetOptionCard).exists().perform();
        driver.assertThat().element(InternetOptionName).text().isEqualTo(InternetOptionNameCL).perform();
        driver.assertThat().element(InternetOptionPrice).text().isEqualTo(InternetOptionPriceCL).perform();
        return this;
    }

    @Step("Validate on Phone Option Card")
    public ConfirmationPage validatePhoneOptionCard(String PhoneOptionNameCL, String PhoneOptionPriceCL){
        driver.verifyThat().element(PhoneOptionCard).exists().perform();
        driver.assertThat().element(PhoneOptionName).text().isEqualTo(PhoneOptionNameCL).perform();
        driver.assertThat().element(PhoneOptionPrice).text().isEqualTo(PhoneOptionPriceCL).perform();
        return this;
    }

    @Step("Validate Start Date Card")
    public ConfirmationPage validateStartDateCard(String StartDateHeadlineCL){
        driver.verifyThat().element(StartDateCard).exists().perform();
        driver.assertThat().element(StartDateHeadline).text().isEqualTo(StartDateHeadlineCL).perform();
        return this;
    }

    @Step("Validate Close CTA CL")
    public ConfirmationPage validateCloseCTACL(String CloseCTACL){
        driver.assertThat().element(CloseCTA).text().isEqualTo(CloseCTACL).perform();
        return this;
    }

    @Step("Validate Error Notification Message")
    public ConfirmationPage validateErrorNotificationMessage(String ErrorNotificationHeaderCL, String ErrorNotificationSubLineCL){
        driver.verifyThat().element(ErrorNotificationCard).exists().perform();
        driver.assertThat().element(ErrorNotificationHeader).textTrimmed().isEqualTo(ErrorNotificationHeaderCL).perform();
        driver.assertThat().element(ErrorNotificationSubLine).textTrimmed().isEqualTo(ErrorNotificationSubLineCL).perform();
        return this;
    }

    @Step("Validate Return CTA CL")
    public ConfirmationPage validateReturnCTACL(String ReturnCTACL){
        driver.assertThat().element(ReturnCTA).textTrimmed().isEqualTo(ReturnCTACL).perform();
        return this;
    }

    @Step("Validate Error Notification Message Try Again")
    public ConfirmationPage validateErrorMessageNotification(String ErrorNotificationHeaderCL, String ErrorNotificationSubLineCL){
        driver.assertThat().element(ErrorNotificationHeader).textTrimmed().isEqualTo(ErrorNotificationHeaderCL).perform();
        driver.assertThat().element(ErrorNotificationSubLine).textTrimmed().isEqualTo(ErrorNotificationSubLineCL).perform();
        return this;
    }

    @Step("Validate confirmation message with no dropped options")
    public ConfirmationPage validateConfirmationMessageWithNoDroppedOptions(String ConfirmationMessageTVOptionCL){
        driver.assertThat().element(ConfirmationNotificationHeader).text().isEqualTo(ConfirmationMessageTVOptionCL).perform();
        return this;
    }

    @Step("Validate open work order for tv option")
    public ConfirmationPage validateOpenWorkOrderForTVOption(String OrderNotificationHeaderCL, String OrderNotificationCTACL){
        driver.assertThat().element(OrderNotificationHeader).text().isEqualTo(OrderNotificationHeaderCL).perform();
        driver.assertThat().element(OrderNotificationCTA).text().isEqualTo(OrderNotificationCTACL).perform();
        return this;
    }

    @Step("Validate First TV option header")
    public ConfirmationPage validateFirstTVOptionHeader(String FirstTVOptionNameCL){
        driver.assertThat().element(FirstTVOptionName).text().isEqualTo(FirstTVOptionNameCL).perform();
        return this;
    }

    @Step("Validate First TV option header")
    public ConfirmationPage validateSecondTVOptionHeader(String SecondTVOptionNameCL){
        driver.assertThat().element(SecondTVOptionName).text().isEqualTo(SecondTVOptionNameCL).perform();
        return this;
    }

    @Step("Validate Error Screen Notification 422 Available Message")
    public ConfirmationPage validateErrorScreenNotificationAvailableMessage(String ErrorNotificationHeaderCL, String ErrorScreenAvailableNotificationSubLineCL){
        driver.verifyThat().element(ErrorNotificationCard).exists().perform();
        driver.assertThat().element(ErrorNotificationHeader).text().isEqualTo(ErrorNotificationHeaderCL).perform();
        driver.assertThat().element(ErrorNotificationSubLine).text().isEqualTo(ErrorScreenAvailableNotificationSubLineCL).perform();
        return this;
    }
}
