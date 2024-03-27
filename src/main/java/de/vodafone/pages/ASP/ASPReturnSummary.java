package de.vodafone.pages.ASP;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ASPReturnSummary {
    private SHAFT.GUI.WebDriver driver;

    //Constructor
    public ASPReturnSummary(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //Locators
    private By returnSummaryPageHeader = By.xpath("//div[@automation-id='pageHeader_tv']/h1");
    private By summaryHeader = By.xpath("//li[@automation-id='accordion0_acc']/a/h4");
    private By summaryTitle = By.xpath("//li[@automation-id='accordion0_acc']/div/h4");
    private By summaryText = By.xpath("//li[@automation-id='accordion0_acc']/div/p");
    private By step1Header = By.xpath("//div[@automation-id='step1_containertv']/a/div[2]");
    private By step2Header = By.xpath("//div[@automation-id='step2_containertv']/a/div[2]");
    private By step1QRHeader = By.xpath("//h4[@automation-id='QRcode_Header_tv']");
    private By step1QRSubHeader = By.xpath("//p[@automation-id='QRcode_subHeader_tv']");
    private By step1QRButton = By.xpath("//button[@automation-id='QRcodemoveToNextStep_btn']");
    private By step1LabelHeader = By.xpath("//h4[@automation-id='PrintBillFreightLabelHeader_tv']");
    private By step1LabelSubHeader = By.xpath("//p[@automation-id='PrintBillFreightLabelSubHeader_tv']");
    private By step1LabelButton = By.xpath("//button[@automation-id='PrintBillFreightLabelNextStep_btn']");
    private By step2Title = By.xpath("//div[@class='white-box']/h4[1]");
    private By step2SubTitle = By.xpath("//div[@class='white-box']/p");
    private By step2DownloadButton = By.xpath("//div[@class='white-box']/button[1]");
    private By step2EmailButton = By.xpath("//div[@class='white-box']/button[2]");
    private By step2EmailText = By.xpath("//span[@class='additional-label']");
    private By step2EmailTextBox = By.xpath("(//div[@class='fm-field-container'])[1]");
    private By step2SendEmailButton = By.xpath("//button[@automation-id='SendQRCodeThroughEmail_btn']");
    private By backToStep1Button = By.xpath("//div[@automation-id='step1_editableTexttv']");

    //CL
    private String returnSummaryPageHeaderCL = "Deine Rücksendung";

    //Validations
    @Step("Validate that user is navigated to return for")
    public ASPReturnSummary validateNavigationToReturnSummary(){
        driver.verifyThat().element(returnSummaryPageHeader).isVisible().perform();
        driver.verifyThat().element(returnSummaryPageHeader).text().isEqualTo(returnSummaryPageHeaderCL).perform();
        return this;
    }
    @Step("Click on step 1 QR Button")
    public ASPReturnSummary clickOnStep1QRButton(){
        driver.element().click(step1QRButton);
        return this;
    }
    @Step("Click on step 1 Label Button")
    public ASPReturnSummary clickOnStep1LabelButton(){
        driver.element().click(step1LabelButton);
        return this;
    }
    @Step("verify that back to step 1 button is displayed")
    public ASPReturnSummary verifyThatBackButtonIsDisplayed(){
        driver.verifyThat().element(backToStep1Button).isVisible().perform();
        return this;
    }
}
