package de.vodafone.pages.DSL;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class KontostandPage {

    private SHAFT.GUI.WebDriver driver;

    //Locators
    private By header_Txt = By.xpath("(//*[@automation-id='h3_tv'])[1]");
    private By subHeader_Txt = By.xpath("//p[@class='mb-32 font-16-sm font-18 lh-24-sm lh-27']");
    private By whiteBox_Headline_Txt = By.xpath("(//*[@automation-id='h2_tv'])[1]");
    private By whiteBox_InvoiceTitle_Txt = By.xpath("(//*[@class='cardContainer_column']//*[@automation-id='h5_tv'])[1]");
    private By whiteBox_InvoiceAmount_Txt = By.xpath("(//*[@class='cardContainer_column']//*[@automation-id='h5_tv'])[2]");
    private By paymentOption_Headline_Txt = By.xpath("//*[@class='mb-20 font-16-sm font-18 bold']");
    private By paymentOption_Button = By.xpath("//*[@class='btn btn-em btn-sml m-0']");
    private By firstInfo_SubHeadline_Txt = By.xpath("(//*[@class='font-16-sm font-18 lh-24-sm lh-27'])[1]");
    private By secondInfo_SubHeadline_Txt = By.xpath("(//*[@class='font-16-sm font-18 lh-24-sm lh-27'])[2]");
    private By document_Headline_Txt = By.xpath("(//*[@automation-id='h3_tv'])[2]");
    private By firstDocument_Title_Txt = By.xpath("(//*[@automation-id='undefined_Link']//span)[1]");
    private By secondDocument_Title_Txt = By.xpath("(//*[@automation-id='undefined_Link']//span)[2]");
    private By dunningNotif_Headline_Txt = By.xpath("//div[@class='flex-disply']//h4");
    private By generalErrorNotif_Headline_Txt = By.xpath("//*[@class='flexDiv']");
    private By eligibleErrorNotif_Headline_Txt = By.xpath("//*[@class='flexDiv']");




    public KontostandPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }
    @Step("Deep link to account balance page")
    public KontostandPage deepLinkToAccountBalancePage() {
        String accountBalancePagePath = "meinvodafone/services/ihre-rechnungen/kontouebersicht";
        driver.browser().navigateToURL(System.getProperty("de.vodafone.baseUrl.st") + accountBalancePagePath);
        return this;
    }
    @Step("Validate Dunning Case")
    public KontostandPage validateDunningCase(String Error) {
        driver.verifyThat()
                .element(dunningNotif_Headline_Txt)
                .text()
                .isEqualTo(Error)
                .perform();
        return this;
    }
    @Step("Validate General Error Case")
    public KontostandPage validateGeneralErrorCase(String Error) {
        driver.verifyThat()
                .element(generalErrorNotif_Headline_Txt)
                .text()
                .isEqualTo(Error)
                .perform();
        return this;
    }

    @Step("Validate eligible Error Case")
    public KontostandPage validateEligibleErrorCase(String Error) {
        driver.verifyThat()
                .element(eligibleErrorNotif_Headline_Txt)
                .text()
                .isEqualTo(Error)
                .perform();
        return this;
    }

    @Step("Validate Headline & SubHeadline")
    public KontostandPage validateKontostandPageIsOpened(String Header, String SubHeader) {
        driver.verifyThat()
                .element(header_Txt)
                .text()
                .isEqualTo(Header)
                .perform();
        driver.verifyThat()
                .element(subHeader_Txt)
                .text()
                .contains(SubHeader)
                .perform();
        return this;
    }

    @Step("Validate The invoices White Box")
    public KontostandPage validateInvoicesWhiteBox(String WhiteBox_Headline, String WhiteBox_InvoiceTitle
                                         ,String WhiteBox_InvoiceAmount) {
        driver.verifyThat()
                .element(whiteBox_Headline_Txt)
                .text()
                .isEqualTo(WhiteBox_Headline)
                .perform();
        driver.verifyThat()
                .element(whiteBox_InvoiceTitle_Txt)
                .text()
                .isEqualTo(WhiteBox_InvoiceTitle)
                .perform();
        driver.verifyThat()
                .element(whiteBox_InvoiceAmount_Txt)
                .text()
                .isEqualTo(WhiteBox_InvoiceAmount)
                .perform();
        return this;
    }

    @Step("Validate The Payment Options Box")
    public KontostandPage validatePaymentOptionsWhiteBox(String PaymentOption_Headline,String PaymentOption_Button) {
        driver.verifyThat()
                .element(paymentOption_Headline_Txt)
                .text()
                .isEqualTo(PaymentOption_Headline)
                .perform();
        driver.verifyThat()
                .element(paymentOption_Button)
                .text()
                .isEqualTo(PaymentOption_Button)
                .perform();
        return this;
    }

    @Step("Validate The Page information")
    public KontostandPage validateThePageInfo(String FirstInfo_SubHeadline,String SecondInfo_SubHeadline) {
        driver.verifyThat()
                .element(firstInfo_SubHeadline_Txt)
                .text()
                .contains(FirstInfo_SubHeadline)
                .perform();
        driver.verifyThat()
                .element(secondInfo_SubHeadline_Txt)
                .text()
                .contains(SecondInfo_SubHeadline)
                .perform();
        return this;
    }

    @Step("Validate The Documents information")
    public KontostandPage validateTheDocumentsInfo(String Document_Headline, String FirstDocument_Title
            ,String SecondDocument_Title) {
        driver.verifyThat()
                .element(document_Headline_Txt)
                .text()
                .isEqualTo(Document_Headline)
                .perform();
        driver.verifyThat()
                .element(firstDocument_Title_Txt)
                .text()
                .isEqualTo(FirstDocument_Title)
                .perform();
        driver.verifyThat()
                .element(secondDocument_Title_Txt)
                .text()
                .isEqualTo(SecondDocument_Title)
                .perform();
        return this;
    }
}
