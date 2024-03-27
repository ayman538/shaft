package de.vodafone.pages.billing;

import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.lang.reflect.Method;

public class SubscriberSummary {
    SHAFT.GUI.WebDriver driver;

    //Labels Locators
    private static By backButtonLocator = By.xpath("(//*[@class=\"back-to-prev parentNav\"]//span)[2]");
    private static By navLink1Locator = By.xpath("(//*[@class=\"back-to-prev parentNav\"]//span)[3]");

    private static By monthSwitcherLocator = By.xpath("//*[@class='month-bill-cont']/month-selector");
    private static By invoiceMonthLocator = By.xpath("(//*[@class='month-bill-cont']/month-selector/span)[2]");
    private static By amountLocator = By.xpath("//*[@automation-id='invoiceSummaryAmountValue_tv']/div[1]");
    private static By creditAmountLabelLocator = By.xpath("//*[@automation-id='invoiceSummaryAmountValue_tv']/div[2]");
    private static By accountNumberLocator = By.xpath("//*[@automation-id='invoiceSummaryAccountNumber_tv']/div[1]");
    private static By billPeriodLocator = By.xpath("//*[@automation-id='invoiceSummaryDueDate_tv']/div[1]");
    private static By billDateLocator = By.xpath("//*[@automation-id='invoiceSummaryDate_tv']/div[1]");

    private static By summaryCardHeaderLocator = By.xpath("(//*[@automation-id='invoiceSummaryDetailsCard_tv']/div)[1]");

    private static By invoiceDetailsLocator;


    private static By summationLocator = By.xpath("(//*[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span)[1]");
    private static By downloadButtonLocator = By.xpath("(//*[@automation-id='undefined_Link'])");


    private static By downloadButton1Locator = By.xpath("(//*[@automation-id='undefined_Link'])[1]//span");

    //values locator
    private static By accountNumber_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryAccountNumber_tv']/div[2]");
    private static By billPeriod_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDueDate_tv']/div[2]");
    private static By billDate_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDate_tv']/div[2]");

    private static By invoiceDetails_ValueLocator;

    private static By summation_ValueLocator = By.xpath("(//*[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span)[2]");

    //CLs
    public static String thirdNavigationalPageBackButton_CL = "Zurück";
    public static String navLink1_CL= "Meine Daten";
    public static String accountNumber_CL = "Kundennummer";
    public static String billPeriod_CL = "Rechnungszeitraum";
    public static String billDate_CL= "Rechnungsdatum";
    public static String summaryCardHeader_CL= "Deine Kosten für";
    public static String creditAmountLabel_CL= "Dein Guthaben";
    public static String positiveSummation_CL= "Summe";
    public static String negativeSummation_CL= "Dein Guthaben beträgt";
    public static String invoicePDFDownloadBTN_CL= "Kostenübersicht";
    public static String itemizedPDFDownloadBTN_CL= "Verbindungsübersicht";

    public SubscriberSummary(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public static By getInvoiceDetailsLocator(int x) {
        invoiceDetailsLocator= By.xpath("//*[@class='active-invoice-detials-card__items']/div["+x+"]/span[1]");

        return invoiceDetailsLocator;
    }
    public  int getNumberOfDownloadBTNs() {
        int x= driver.element().getElementsCount(downloadButtonLocator);
        return x;
    }

    public static By getInvoiceDetails1_ValueLocator(int x) {
        invoiceDetails_ValueLocator= By.xpath("//*[@class='active-invoice-detials-card__items']/div["+x+"]/span[2]");

        return invoiceDetails_ValueLocator;
    }

    @Step("click on subscriber summary page back button")
    public void clickOnSubscriberSummaryBackPageBackButton()
    {
        driver.element().click(backButtonLocator);
    }

    // Validations

    public void assertOnHeaderComponents(){
            driver.verifyThat().element(backButtonLocator).textTrimmed().isEqualTo(thirdNavigationalPageBackButton_CL).withCustomReportMessage("assert on back button text").perform();
            driver.verifyThat().element(navLink1Locator).textTrimmed().isEqualTo(navLink1_CL).withCustomReportMessage("assert on the first navigation link text").perform();
    }

    public void assertOnTheAboveSummaryCardComponents(Method method , String invoiceMonth , String invoiceAmount , String accountNumber , String billPeriod , String billDate) {
        driver.verifyThat().element(invoiceMonthLocator).textTrimmed().isEqualTo(invoiceMonth).withCustomReportMessage("assert on invoice month text").perform();

        driver.verifyThat().element(amountLocator).textTrimmed().isEqualTo(invoiceAmount).withCustomReportMessage("assert on invoice amount text").perform();

        driver.verifyThat().element(accountNumberLocator).textTrimmed().isEqualTo(SubscriberSummary.accountNumber_CL).withCustomReportMessage("assert on account number label").perform();

        driver.verifyThat().element(accountNumber_ValueLocator).textTrimmed().isEqualTo(accountNumber).withCustomReportMessage("assert on account number value text").perform();

        driver.verifyThat().element(billPeriodLocator).textTrimmed().isEqualTo(billPeriod_CL).withCustomReportMessage("assert on bill period label text").perform();

        driver.verifyThat().element(billPeriod_ValueLocator).textTrimmed().isEqualTo(billPeriod).withCustomReportMessage("assert on bill period value text").perform();

        driver.verifyThat().element(billDateLocator).textTrimmed().isEqualTo(billDate_CL).withCustomReportMessage("assert on bill date label text").perform();

        driver.verifyThat().element(billDate_ValueLocator).textTrimmed().isEqualTo(billDate).withCustomReportMessage("assert on bill date value text").perform();

        driver.verifyThat().element(summaryCardHeaderLocator).textTrimmed().isEqualTo(summaryCardHeader_CL).withCustomReportMessage("assert on summary card header text").perform();
    }

    public void assertOnPositiveSumText(){
        driver.verifyThat()
                .element(summationLocator)
                .textTrimmed()
                .contains(positiveSummation_CL)
                .withCustomReportMessage("assert on positive summation text")
                .perform();
    }

    public void assertOnNegativeSumText(){
        driver.verifyThat()
                .element(summationLocator)
                .textTrimmed()
                .isEqualTo(negativeSummation_CL)
                .withCustomReportMessage("assert on negative summation text")
                .perform();
    }

    public void assertOnCreditAmountLabelText(){
        driver.verifyThat()
                .element(creditAmountLabelLocator)
                .textTrimmed()
                .isEqualTo(SubscriberSummary.creditAmountLabel_CL)
                .withCustomReportMessage("assert on credit amount label text")
                .perform();
    }

    public void assertThatOnlyOneDownloadBtnDisplayed(){
        Validations.verifyThat()
                .number(getNumberOfDownloadBTNs()).isEqualTo(1)
                .withCustomReportMessage("assert that the number of the download buttons = 1")
                .perform();
    }
    public void assertThatNoDownloadBtnDisplayed(){
        Validations.verifyThat()
                .number(getNumberOfDownloadBTNs()).isEqualTo(0)
                .withCustomReportMessage("assert that no download buttons displayed")
                .perform();
    }

    public void assertOnInvoicePdfDownloadBtnText(){
        driver.verifyThat()
                .element(downloadButton1Locator)
                .textTrimmed()
                .isEqualTo(invoicePDFDownloadBTN_CL)
                .withCustomReportMessage("assert on invoice PDF download button text").perform();
    }
    public void assertOnItemizedPdfDownloadBtnText() {

        driver.verifyThat()
                .element(downloadButton1Locator)
                .textTrimmed()
                .isEqualTo(itemizedPDFDownloadBTN_CL)
                .withCustomReportMessage("assert on itemized PDF download button text")
                .perform();
    }
    public void assertOnBackButtonText(){
        driver.verifyThat().element(backButtonLocator).textTrimmed().isEqualTo(thirdNavigationalPageBackButton_CL).withCustomReportMessage("assert on back button text").perform();
    }
}