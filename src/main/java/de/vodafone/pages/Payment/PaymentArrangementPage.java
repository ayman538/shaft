package de.vodafone.pages.Payment;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class PaymentArrangementPage {
    SHAFT.GUI.WebDriver driver;

    public PaymentArrangementPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private static By paymentArrangementBackBtnLocator = By.xpath("//a[@automation-id='back_Link']");
    private static By paymentArrangementPageHeaderLocator = By.xpath("//h1[contains(.,'Stundung')]");
    private static By paymentArrangementTitleLocator = By.xpath("//div[@id='paymentArrangement']/h4");

    private static By paymentArrangementDateLocator = By.xpath("(//td[@data-mat-row][@data-mat-col]/button[not(@aria-disabled='true')])[1]");

    private static By paymentArrangementContinueBtnLocator = By.xpath("//div[@class ='fm-buttons mt-15']/../button");
    private static By paymentArrangementSubmitBtnLocator = By.xpath("//button[@class='btn mt-15 mb-0']");
    private static By paymentArrangementSuccessNotificationTitleLocator = By.xpath("//div[@automation-id='undefined_nt']//h4");
    private static By paymentArrangementSuccessNotificationTextLocator = By.xpath("//div[@automation-id='undefined_nt']//p");
    private static By paymentArrangementInformativeTextLocator = By.xpath("//div[@id='Step0']/..//p");
    private static By paymentArrangementAmountTitleLocator = By.xpath("//div[@class='white-box mb-0']/h4[1]");
    private static By paymentArrangementAmountValueLocator = By.xpath("//div[@class='white-box mb-0']/p[1]");
    private static By paymentArrangementAdditionalAmountTitleLocator = By.xpath("//div[@class='white-box mb-0']/h4[2]");
    private static By paymentArrangementAdditionalAmountValueLocator = By.xpath("//div[@class='white-box mb-0']/p[2]");
    private static By paymentArrangementDateTitleLocator = By.xpath("//div[@class='white-box mb-0']/h4[3]");
    private static By paymentArrangementDateValueLocator = By.xpath("//div[@class='white-box mb-0']/p[3]");
    private static By paymentArrangementConfirmationAccLocator = By.xpath("//li[@automation-id='accordion0_acc']/a");

    private String paymentArrangementPageHeaderCl = "Stundung";
    private String paymentArrangementSuccessNotificationTitleCl = "Vielen Dank für Ihren Auftrag";
    private String paymentArrangementSuccessNotificationTextCl = "Ihre Zahlungsfrist für den Betrag von";
    private String paymentArrangementInformativeTextCl = "2024";
    private String paymentArrangementAmountTitleCl = "Betrag";
    private String paymentArrangementAdditionalAmountTitleCl = "Bearbeitungspauschale";
    private String paymentArrangementDateTitleCl = "Zahlungstermin";
    private String paymentArrangementClosedAccClass = "ac-head";


    @Step("Select payment date")
    public void selectPaymentDate() {
        driver.element().click(paymentArrangementDateLocator);
    }

    @Step("Click on payment arrangement continue button")
    public void clickOnPaymentArrangementContinueButton() {
        driver.element().click(paymentArrangementContinueBtnLocator);
    }

    @Step("Click on payment arrangement submit button")
    public void clickOnPaymentArrangementSubmitButton() {
        driver.element().click(paymentArrangementSubmitBtnLocator);
    }


    @Step("assert that payment arrangement page is loaded")
    public void assertThatPaymentArrangementPageIsLoaded() {
        driver.verifyThat().element(paymentArrangementPageHeaderLocator).text().isEqualTo(paymentArrangementPageHeaderCl).perform();
    }

    public void assertOnPaInformativeText() {
        driver.verifyThat().element(paymentArrangementInformativeTextLocator).text().contains(paymentArrangementInformativeTextCl).withCustomReportMessage("Assert on PA informative text cl").perform();
    }

    public void assertOnPaymentArrangementSuccessNotificationTitle() {
        driver.verifyThat().element(paymentArrangementSuccessNotificationTitleLocator).text().isEqualTo(paymentArrangementSuccessNotificationTitleCl).withCustomReportMessage("Assert On Payment Arrangement Success Notification Title").perform();
    }

    public void assertOnPaymentArrangementSuccessNotificationText() {
        driver.verifyThat().element(paymentArrangementSuccessNotificationTextLocator).text().contains(paymentArrangementSuccessNotificationTextCl).withCustomReportMessage("Assert On Payment Arrangement Success Notification text").perform();
    }

    public void assertOnPAAmountTitle() {
        driver.verifyThat().element(paymentArrangementAmountTitleLocator).text().isEqualTo(paymentArrangementAmountTitleCl).withCustomReportMessage("Assert on PA amount title").perform();
    }

    public void assertOnPAAmountValue(String amount) {
        driver.verifyThat().element(paymentArrangementAmountValueLocator).text().isEqualTo(amount).withCustomReportMessage("Assert that amount is presented correctly in Pa info box").perform();
    }

    public void assertOnPAAdditionalAmountTitle() {
        driver.verifyThat().element(paymentArrangementAdditionalAmountTitleLocator).text().isEqualTo(paymentArrangementAdditionalAmountTitleCl).withCustomReportMessage("Assert on PA additional amount title").perform();
    }

    public void assertOnPAAdditionalAmountValue(String amount) {
        driver.verifyThat().element(paymentArrangementAdditionalAmountValueLocator).text().isEqualTo(amount).withCustomReportMessage("Assert that additional amount is presented correctly in Pa info box").perform();
    }

    public void assertOnPADateTitle() {
        driver.verifyThat().element(paymentArrangementDateTitleLocator).text().isEqualTo(paymentArrangementDateTitleCl).withCustomReportMessage("Assert on PA Date  title").perform();
    }

    public void assertOnPADateValue(String date) {
        driver.verifyThat().element(paymentArrangementDateValueLocator).text().contains(date).withCustomReportMessage("Assert that Date is presented correctly in Pa info box").perform();
    }

    public void assertThatPaConfirmationAccIsClosedByDefault() {
        driver.verifyThat().element(paymentArrangementConfirmationAccLocator).attribute("class").isEqualTo(paymentArrangementClosedAccClass).withCustomReportMessage("Assert that PA Confirmation acc is closed by default").perform();
    }
}
