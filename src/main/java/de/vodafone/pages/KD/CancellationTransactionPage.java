package de.vodafone.pages.KD;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;

public class CancellationTransactionPage {

    //Variables
    private SHAFT.GUI.WebDriver driver;

    //Element Locators
    private By BackLink = By.xpath("//a[@automation-id='back_Link']");
    private By CancellationTransactionPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h1");
    private By CancellationDetailsAccordionHeader = By.xpath("//h3[@automation-id='transactionTileTitle_tv']");
    private By CancellationOptionTile = By.xpath("//span[@automation-id='cancellable_option_tile']");
    private By StartCancellingDateTitle = By.xpath("//h5[@automation-id='startCancellingDate_tv']");
    private By ContractSummaryPreText = By.xpath("//span[@automation-id='contractSummaryPreWording_tv']");
    private By ContractSummaryPDFDownloadHyperLink = By.xpath("//a[@automation-id='contractSummaryDoc_Link']");
    private By ContractSummaryPostText = By.xpath("//span[@automation-id='contractSummaryPostWording_tv']");
    private By cancelOptionCTA = By.xpath("//button[@automation-id='productOrder_btn' and contains (.,'Diese Option')]");
    private By cancelTransTitle = By.xpath("//h3[@automation-id='transactionTileTitle_tv']");
    private By startCancelDate = By.xpath("//h5[@automation-id='startCancellingDate_tv']");
    private By pageSubTitle = By.xpath("//div[@automation-id='pageHeader_tv']");
    private By ErrorScreenNotificationHeader = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private By ErrorScreenNotificationBody = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private By TryAgainNotificationHeader = By.xpath("//div[@automation-id='tryAgain_nt']//h4");
    private By TryAgainNotificationBody = By.xpath("//div[@automation-id='tryAgain_nt']//p");
    private By TryAgainNotificationCTA = By.xpath("//button[@automation-id='tryAgain_btn']");
    private By contractNumberSubHeader = By.xpath("//div[@automation-id='pageHeader_tv']//h2");
    private By textHeader = By.xpath("//h3[@automation-id='transactionTileTitle_tv']");
    private By cancelledOptionName = By.xpath("(//*[@automation-id='cancellable_option_tile']//span)[1]");
    private By cancelledOptionsDescription = By.xpath("//div[@class='price-information']");
    private By cancelledOptionPrice = By.xpath("//*[@class='extras-card-price']");
    private By cancellationDateHeader = By.xpath("//h5[@automation-id='startCancellingDate_tv']");
    private By currentDate = By.xpath("//span[@automation-id='currentDate_tv']");

    //Constructor
    public CancellationTransactionPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }

    //URL
    private String ContractSummeryPDFURL = "blob:https://simplicity.wf-de.vodafone.com/1502ecfe-3937-4ba9-9f9f-1612565eaefb";

    //Methods
    @Step("Click On Contract Summery PDF to Download")
    public CancellationTransactionPage clickOnContractSummeryToDownload(){
        driver.verifyThat().element(ContractSummaryPreText).exists().perform();
        driver.element().click(ContractSummaryPDFDownloadHyperLink);
        return this;
    }

    @Step("Click On Cancel Option CTA")
    public CancellationTransactionPage clickOnCancelOptionCTA(){
        driver.verifyThat().element(cancelTransTitle).exists().perform();
        driver.verifyThat().element(startCancelDate).exists().perform();
        driver.element().click(cancelOptionCTA);
        return this;
    }

    @Step("Validate cancellation transaction page header")
    public CancellationTransactionPage validateCancellationPageHeader(String CancellationTransactionPageHeaderCL){
        driver.assertThat().element(CancellationTransactionPageHeader).textTrimmed().isEqualTo(CancellationTransactionPageHeaderCL).perform();
        return this;
    }

    @Step("Validate Cancellation Details Accordion Header Kabel TV")
    public CancellationTransactionPage validateCancellationDetailsAccordionHeader(String CancellationDetailsAccordionHeaderCL){
        driver.assertThat().element(CancellationDetailsAccordionHeader).textTrimmed().isEqualTo(CancellationDetailsAccordionHeaderCL).perform();
        return this;
    }

    @Step("Validate Existance of Cancellation Option Tile")
    public CancellationTransactionPage validateCancellationOptionTileExist(){
        driver.verifyThat().element(CancellationOptionTile).exists().perform();
        return this;
    }

    @Step("Validate Start Cancelling Option Date Title")
    public CancellationTransactionPage validateStartCancellingDateTitle(String StartCancellingDateTitleCL){
        driver.assertThat().element(StartCancellingDateTitle).textTrimmed().isEqualTo(StartCancellingDateTitleCL).perform();
        return this;
    }

    @Step("Validate Cancellation Legal Text Card")
    public CancellationTransactionPage validateCancellationLegalTextCard(String ContractSummaryPreTextCL,String ContractSummaryTextCL,String ContractSummaryPostTextCL){
        driver.verifyThat().element(ContractSummaryPreText).textTrimmed().isEqualTo(ContractSummaryPreTextCL).perform();
        driver.verifyThat().element(ContractSummaryPDFDownloadHyperLink).textTrimmed().isEqualTo(ContractSummaryTextCL).perform();
        driver.verifyThat().element(ContractSummaryPostText).textTrimmed().isEqualTo(ContractSummaryPostTextCL).perform();
        return this;
    }

    @Step("Validate Cancel Option CTA CL")
    public CancellationTransactionPage validateCancelOptionCTACL(String CancelOptionCTACL){
        driver.assertThat().element(cancelOptionCTA).textTrimmed().isEqualTo(CancelOptionCTACL).perform();
        return this;
    }

    @Step("Validate Error Screen Notification")
    public CancellationTransactionPage validateErrorScreenNotification(String ErrorScreenNotificationHeaderCL, String ErrorScreenNotificationBodyCL){
        driver.verifyThat().element(pageSubTitle).isVisible().perform();
        driver.verifyThat().element(ErrorScreenNotificationHeader).textTrimmed().isEqualTo(ErrorScreenNotificationHeaderCL).perform();
        driver.verifyThat().element(ErrorScreenNotificationBody).textTrimmed().isEqualTo(ErrorScreenNotificationBodyCL).perform();
        return this;
    }

    @Step("Validate Try Again Notification")
    public CancellationTransactionPage validateTryAgainNotification(String TryAgainNotificationHeaderCL,String TryAgainNotificationBodyCL,String TryAgainNotificationCTACL){
        driver.verifyThat().element(TryAgainNotificationHeader).textTrimmed().isEqualTo(TryAgainNotificationHeaderCL).perform();
        driver.verifyThat().element(TryAgainNotificationBody).textTrimmed().isEqualTo(TryAgainNotificationBodyCL).perform();
        driver.verifyThat().element(TryAgainNotificationCTA).textTrimmed().isEqualTo(TryAgainNotificationCTACL).perform();
        return this;
    }

    @Step("Validate that Contract summery PDF open successfully in new tab")
    public CancellationTransactionPage validateContractSummeryPDFOpenSuccessfully(){
        Object[] handles = driver.getDriver().getWindowHandles().toArray();
        driver.browser().switchToWindow(handles[1].toString());
        Validations.assertThat().browser(driver.getDriver()).url().isEqualTo(ContractSummeryPDFURL)
                .perform();
        return this;
    }

    @Step("Assert on the cancellation transaction page link")
    public CancellationTransactionPage assertOnTransactionPageLink(String transactionPageURL){
        driver.verifyThat().element(cancelOptionCTA).exists().perform();
        driver.browser().getCurrentWindowTitle().equals(transactionPageURL);
        return this;
    }

    @Step("Assert on Contract number in the Transaction Page")
    public CancellationTransactionPage assertOnContractNumber(String contractNumberCL){
        driver.assertThat().element(contractNumberSubHeader).textTrimmed().isEqualTo(contractNumberCL).perform();
        return this;
    }

    @Step("Assert on Text Header for the option")
    public CancellationTransactionPage assertOnTextHeader(String textHeaderCL, String optionNameCL){
        textHeaderCL = textHeaderCL.replace("[option name]", optionNameCL);
        driver.assertThat().element(textHeader).textTrimmed().contains(textHeaderCL).perform();
        return this;
    }

    @Step("validate cancelled option card in transaction page")
    public CancellationTransactionPage validateCanceledOptionCard(String optionNameCL, String optionsDescriptionCL, String optionPriceCL){
        driver.verifyThat().element(cancelledOptionName).textTrimmed().isEqualTo(optionNameCL).perform();
        driver.verifyThat().element(cancelledOptionsDescription).textTrimmed().isEqualTo(optionsDescriptionCL).perform();
        driver.verifyThat().element(cancelledOptionPrice).textTrimmed().contains(optionPriceCL).perform();
        return this;
    }

    @Step("validate date card for cancelled option in the transaction page")
    public CancellationTransactionPage validateCancellationDateCardCard(String cancellationHeaderCL){
        driver.verifyThat().element(cancellationDateHeader).textTrimmed().isEqualTo(cancellationHeaderCL).perform();
        driver.verifyThat().element(currentDate).textTrimmed().isEqualTo(getCurrentDate("dd.MM.yyyy")).perform();
        return this;
    }

    @Step("Assert on the contract summary pdf")
    public CancellationTransactionPage assertOnContractSummaryPDF(){
        driver.getDriver().getWindowHandle().contains("blob:https:");
        return this;
    }
}