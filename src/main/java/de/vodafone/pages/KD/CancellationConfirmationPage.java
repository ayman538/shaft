package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class CancellationConfirmationPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By BackLink = By.xpath("//a[@automation-id='back_Link']");
    private By CancellationConfirmationPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By confirmationNotificationBody = By.xpath("(//div[@automation-id='successMsg_tv']//p)[1]");
    private By WorkOrderNotificationHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By WorkOrderCTA = By.xpath("//button[@automation-id='workOrder_btn']");
    private By OverviewAccordion = By.xpath("//li[@automation-id='accordion0_acc']");
    private By CancellableOptionTileHeader = By.xpath("//span[@automation-id='cancellable_option_tile']//span[@class='h2']");
    private By StartCancellingDateHeader = By.xpath("//h5[@automation-id='startCancellingDate_tv']");
    private By contractNumberSubHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By orderNotificationCard = By.xpath("(//div[@automation-id='workOrder_nt'])");
    private By overviewDropDownHeader = By.xpath("(//*[@automation-id='accordion0_acc']//span)[1]");
    private By cancelledOptionName = By.xpath("(//*[@automation-id='cancellable_option_tile']//span)[1]");
    private By cancelledOptionsDescription = By.xpath("//div[@class='price-information']");
    private By cancelledOptionPrice = By.xpath("//*[@class='extras-card-price']");
    private By cancellationDateHeader = By.xpath("//h5[@automation-id='startCancellingDate_tv']");
    private By currentDate = By.xpath("//span[@automation-id='currentDate_tv']");
    private By openWorkOrderNotificationHeader = By.xpath("//h4[@class='flexDiv']");
    private By openWorkOrderNotificationText = By.xpath("(//div[@automation-id='successMsg_tv']//p)[2]");
    private By openWorkOrderNotificationCTA = By.xpath("//button[@automation-id='workOrder_btn']");

    //Constructor
    public CancellationConfirmationPage(SHAFT.GUI.WebDriver driver){
        this.driver=driver;
    }

    //Methods
    @Step("Click Back Link")
    public CancellationConfirmationPage clickBackLink(){
        driver.element().click(BackLink);
        return this;
    }

    @Step("Click on Work Order CTA")
    public CancellationConfirmationPage clickOnWorkOrderCTA(){
        driver.element().click(WorkOrderCTA);
        return this;
    }

    @Step("Click On Overview Accordion")
    public CancellationConfirmationPage clickOnOverviewAccordion(){
        driver.element().click(OverviewAccordion);
        return this;
    }

    @Step("Validate Cancellation Confirmation Page Header")
    public CancellationConfirmationPage validateCancellationConfirmationPageHeader(String CancellationConfirmationPageHeaderCL){
        driver.assertThat().element(CancellationConfirmationPageHeader).textTrimmed().isEqualTo(CancellationConfirmationPageHeaderCL).perform();
        return this;
    }

    @Step("Validate Cancellation Confirmation Notification Body")
    public CancellationConfirmationPage validateConfirmationNotificationBody(String ConfirmationNotificationBodyCL){
        driver.assertThat().element(confirmationNotificationBody).textTrimmed().isEqualTo(ConfirmationNotificationBodyCL).perform();
        return this;
    }

    @Step("Validate Work Order Notification Card")
    public CancellationConfirmationPage validateWorkOrderNotificationCard(String WorkOrderNotificationHeaderCL,String WorkOrderCTACL){
        driver.verifyThat().element(WorkOrderNotificationHeader).textTrimmed().isEqualTo(WorkOrderNotificationHeaderCL).perform();
        driver.verifyThat().element(WorkOrderCTA).textTrimmed().isEqualTo(WorkOrderCTACL).perform();
        return this;
    }

    @Step("Validate Cancellable Option Tile Header")
    public CancellationConfirmationPage validateCancellableOptionTileHeader(String CancellableOptionTileHeaderCL){
        driver.assertThat().element(CancellableOptionTileHeader).textTrimmed().isEqualTo(CancellableOptionTileHeaderCL).perform();
        return this;
    }

    @Step("Validate Start Cancelling Date Header")
    public CancellationConfirmationPage validateStartCancellingDateHeader(String StartCancellingDateHeaderCL){
        driver.assertThat().element(StartCancellingDateHeader).textTrimmed().isEqualTo(StartCancellingDateHeaderCL).perform();
        return this;
    }

    @Step("Assert on the confirmation page link")
    public CancellationConfirmationPage assertOnConfirmationPageLink(String confirmationPageURL){
        driver.verifyThat().element(confirmationNotificationBody).exists().perform();
        driver.browser().getCurrentWindowTitle().equals(confirmationPageURL);
        return this;
    }

    @Step("Assert on Contract number in the Confirmation Page")
    public CancellationConfirmationPage assertOnContractNumber(String contractNumberCL){
        driver.assertThat().element(contractNumberSubHeader).text().isEqualTo(contractNumberCL).perform();
        return this;
    }

    @Step("Assert on Open work order notification")
    public CancellationConfirmationPage assertOnOpenworkOrderNotification(){
        driver.assertThat().element(orderNotificationCard).exists().perform();
        return this;
    }

    @Step("Assert on Overview Drop Down for the option")
    public CancellationConfirmationPage assertOnOptionOverviewDropDown(String overviewDropDownCL){
        driver.assertThat().element(overviewDropDownHeader).text().isEqualTo(overviewDropDownCL).perform();
        return this;
    }

    @Step("validate cancelled option card in confirmation page")
    public CancellationConfirmationPage validateCanceledOptionCard(String optionNameCL, String optionsDescriptionCL, String optionPriceCL){
        driver.verifyThat().element(cancelledOptionName).text().isEqualTo(optionNameCL).perform();
        driver.verifyThat().element(cancelledOptionsDescription).text().isEqualTo(optionsDescriptionCL).perform();
        driver.verifyThat().element(cancelledOptionPrice).text().contains(optionPriceCL).perform();
        return this;
    }

    @Step("validate date card for cancelled option in the confirmation page")
    public CancellationConfirmationPage validateCancellationDateCardCard(String cancellationHeaderCL){
        driver.verifyThat().element(cancellationDateHeader).textTrimmed().isEqualTo(cancellationHeaderCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Validate the Open work order notification")
    public CancellationConfirmationPage validateOpenworkOrderNotification(String openWorkNotificationHeaderCL, String openWorkNotificationTextCL1,String openWorkNotificationTextCL2,String openWorkNotificationTextCL3, String openWorkNotificationButtonCL){
        openWorkNotificationTextCL1 = openWorkNotificationTextCL1.replace("dd.mm.yyyy",getCurrentDate("dd.MM.yyyy"));
        driver.verifyThat().element(openWorkOrderNotificationHeader).textTrimmed().isEqualTo(openWorkNotificationHeaderCL).perform();
        driver.verifyThat().element(openWorkOrderNotificationText).textTrimmed().contains(openWorkNotificationTextCL1).perform();
        driver.verifyThat().element(openWorkOrderNotificationText).textTrimmed().contains(openWorkNotificationTextCL2).perform();
        driver.verifyThat().element(openWorkOrderNotificationText).textTrimmed().contains(openWorkNotificationTextCL3).perform();
        driver.verifyThat().element(openWorkOrderNotificationCTA).textTrimmed().isEqualTo(openWorkNotificationButtonCL).perform();
        return this;
    }

    @Step("Assert on Open work order notification CTA link")
    public CancellationConfirmationPage assertOnOpenWorkOrderNotificationRedirection(String openWorkNotificationButtonURL){
        driver.element().click(openWorkOrderNotificationCTA);
        driver.browser().getCurrentWindowTitle().equals(openWorkNotificationButtonURL);
        return this;
    }
}
