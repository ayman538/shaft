package de.vodafone.pages.billing;


import com.shaft.driver.SHAFT;
import com.shaft.validation.Validations;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.io.File;
import java.util.List;


public class InvoiceSummary {
    SHAFT.GUI.WebDriver driver;


    //Labels Locators
    private static By monthSwitcherLocator = By.xpath("//*[@class='month-bill-cont']/month-selector");
    private static By monthLocator = By.xpath("TBD");
    private static By amountLocator = By.xpath("//*[@automation-id='invoiceSummaryAmountValue_tv']/div[1]");
    private static By kundennummerLocator = By.xpath("//*[@automation-id='invoiceSummaryAccountNumber_tv']/div[1]");
    private static By zahlbarZumLocator = By.xpath("//*[@automation-id='invoiceSummaryDueDate_tv']/div[1]");
    private static By rechnungsdatumLocator = By.xpath("//*[@automation-id='invoiceSummaryDate_tv']/div[1]");
    private static By rechnungsNrLocator = By.xpath("//*[@automation-id='invoiceSummaryNumber_tv']/div[1]");

    private static By basispreisLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsSubscriptions_tv']/span[1]");
    private static By verbindungspreisLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsUsage_tv']/span[1]");
    private static By sonstigesLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsOneTime_tv']/span[1]");
    private static By zwischensummeNettoLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsSubTotal_tv']/span[1]");

    private static By umsatzsteuer19Locator = By.xpath("//*[@automation-id='invoiceSummaryDetailsTax_tv']/div[2]/span[1]");
    private static By umsatzsteuer16Locator = By.xpath("//*[@automation-id='invoiceSummaryDetailsTax_tv']/div[1]/span[1]");
    private static By rechnungsbetragLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsInvoiceAmount_tv']/span[1]");
    private static By amountToPayLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span[1]");
    private static By unPaidAmountLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsUnpaidAmount_tv']/span[1]");
    private static By creditAmountLabelLocator = By.xpath("//*[@automation-id='invoiceSummaryAmountValue_tv']/div[2]");
    //values locators
    private static By kundennummer_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryAccountNumber_tv']/div[2]");
    private static By zahlbarZum_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDueDate_tv']/div[2]");
    private static By rechnungsdatum_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDate_tv']/div[2]");
    private static By rechnungsNr_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryNumber_tv']/div[2]");
    private static By basispreis_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsSubscriptions_tv']/span[2]");
    private static By verbindungspreis_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsUsage_tv']/span[2]");
    private static By sonstiges_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsOneTime_tv']/span[2]");
    private static By zwischensummeNetto_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsSubTotal_tv']/span[2]");
    private static By umsatzsteuer19_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsTax_tv']/div[2]/span[2]");
    private static By umsatzsteuer16_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsTax_tv']/div[1]/span[2]");
    private static By rechnungsbetrag_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsInvoiceAmount_tv']/span[2]");
    private static By amountToPay_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span[2]");
    private static By unPaidAmount_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsUnpaidAmount_tv']/span[2]");
    private By errorTitleLocator = By.xpath("//div[@class='table-container__modal-error']/h2");

    private By errorNotificationCloseLocator = By.xpath("//button[@class='nsm-dialog-btn-close']");

    private By errorDescriptionLocator = By.xpath("//div[@class='table-container__modal-error']/p");

    private By invoicePdfDownloadButtonLocator = By.xpath("//span[text()='Rechnung']");
    private By subscriberBillLocator = By.xpath("(//li[@automation-id='undefined_Link'])[1]/a");

    private By itemizedPdfDownloadButtonLocator = By.xpath("//span[text()='Verbindungsübersicht']");

    private By negativeAmountToPayLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsAmountInSum_tv']/span[1]");
    private By negativeAmountToPay_ValueLocator = By.xpath("//*[@automation-id='invoiceSummaryDetailsAmountInSum_tv']/span[2]");

    private By invoiceSummaryPageBackButtonLocator = By.xpath("(//*[@class=\"back-to-prev parentNav\"]//span)[2]");
    private By requiredMonthLocator = By.xpath("//month-selector[@automation-id='monthSelector_tv']//span[2]");
    private By amountToPayAtTopRight = By.xpath("(//span[@automation-id='invoiceSummaryAmountValue_tv']/div)[1]");
    private By meinDatenLink = By.xpath("//strong/span[@class='verticalAlign-super']");
    private By teilenhemrLink = By.xpath("//span[@class='verticalAlign-super'][contains(.,'Teil')]");
    private By accountNumberValueLocator = By.xpath("//span[@automation-id='invoiceSummaryAccountNumber_tv']/div[@class='mobile-body']");
    private By accountNumberTitleLocator = By.xpath("//span[@automation-id='invoiceSummaryAccountNumber_tv']/div[@class='mobile-header']");
    private By dueDateValueLocator = By.xpath("//span[@automation-id='invoiceSummaryDate_tv']/div[@class='mobile-body']");
    private By dueDateTitleLocator = By.xpath("//span[@automation-id='invoiceSummaryDate_tv']/div[@class='mobile-header']");
    private By invoicePeriodValueLocator = By.xpath("//span[@automation-id='invoiceSummaryDueDate_tv']/div[@class='mobile-body']");
    private By invoicePeriodTitleLocator = By.xpath("//span[@automation-id='invoiceSummaryDueDate_tv']/div[@class='mobile-header']");
    private By invoiceNumberValueLocator = By.xpath("//span[@automation-id='invoiceSummaryRN_tv']/div[@class='mobile-body']");
    private By invoiceNumberTitleLocator = By.xpath("//span[@automation-id='invoiceSummaryRN_tv']/div[@class='mobile-header']");
    private By msisdnLocator = By.xpath("//div[@class='active-invoice-detials-card__msisdn']");
    private By cardNameLocator = By.xpath("//div[@class='active-invoice-detials-card__title']");
    private By ConnectionPriceLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPrice_tv']/span[@class='item_amount']");
    private By ConnectionPriceCLLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPrice_tv']/span[@class='item_text']");
    private By packagePriceLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsbasePackagePrice_tv']/span[@class='item_amount']");
    private By packagePriceClLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsbasePackagePrice_tv']/span[@class='item_text']");
    private By ConnectionPricesAndServiceLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPricesServices_tv']/span[@class='item_amount']");
    private By ConnectionPricesAndServiceTitleLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPricesServices_tv']/span[@class='item_text']");
    private By otherLocator = By.xpath("(//div[@automation-id='invoiceSummaryDetailsMobilePayment_tv']/span[@class='item_amount'])");
    private By otherTitleLocator = By.xpath("(//div[@automation-id='invoiceSummaryDetailsMobilePayment_tv']/span[@class='item_text'])");
    private By creditsTitleLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsMiscellaneous_tv']/span[@class='item_text']");
    private By creditsLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsMiscellaneous_tv']/span[@class='item_amount']");
    private By lastMonthReceivablesTextLocator = By.xpath("//div[@automation-id='invoiceSummarypreviousBalance_tv']/span[@class='item_text']");
    private By amountFromLastMonthLocator = By.xpath("//div[@automation-id='invoiceSummarypreviousBalance_tv']/span[@class='item_amount']");
    private By accountRelatedItemsLocator = By.xpath("(//div[@automation-id='invoiceSummaryAccountRelated_tv']/span[@class='item_amount'])");
    private By accountRelatedItemsTitleLocator = By.xpath("(//div[@automation-id='invoiceSummaryAccountRelated_tv']/span[@class='item_text'])");
    private By mobilePaymentLocator = By.xpath("(//div[@automation-id='invoiceSummaryMobilePayments_tv']/span[@class='item_amount'])");
    private By mobilePaymentTitleLocator = By.xpath("(//div[@automation-id='invoiceSummaryMobilePayments_tv']/span[@class='item_text'])");
    private By callNowTransferLocator = By.xpath("(//div[@automation-id='invoiceSummaryBalanceTransfer_tv']/span[@class='item_amount'])");
    private By callNowTransferTitleLocator = By.xpath("(//div[@automation-id='invoiceSummaryBalanceTransfer_tv']/span[@class='item_text'])");
    private By payAmountLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span[1]");
    private By payAmountValueLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span[2]");
    private By payAmountCreditLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span[@class='amount_item_text i-green']");
    private By payAmountCreditValueLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsAmountToPay_tv']/span[@class='amount_item_amount i-green']");
    // i used contains bcause of when 1 of pdfs is not retrieved it appears the problem
    private By itemizedBillLocator = By.xpath("(//li[@automation-id='undefined_Link']/a/span)[2]");
    private By customerBillLocator = By.xpath("(//li[@automation-id='undefined_Link']/a/span)[1]");
    private By creditAmountLocator = By.xpath("//span[@automation-id='invoiceSummaryAmountValue_tv']/div[2]");
    private By errorHeadlineLocator = By.xpath("//div[@class='table-container__modal-error']/h2");
    private By errorBodyLocator = By.xpath("//div[@class='table-container__modal-error']/p");
    private By errorNotificationHeadline = By.xpath("//div[@class='item-2 w-100']/h4");
    private By errorNotificationBody = By.xpath("//div[@automation-id='successMsg_tv']/p");
    private By reloadButton = By.xpath("//button[@automation-id='undefined_btn']");
    private By errorDivLocator = By.xpath("//div[@class='alert noselect error']");
    private By backBtn = By.xpath("//a[@automation-id='back_Link']");
    private By msisdnLocation= By.xpath("(//div[@class='active-invoice-card-mobile'])[1]//div[@class='active-invoice-detials-card__msisdn tal display-flex mr-auto']");
    private By showLessBtn = By.xpath("(//div[@class='active-invoice-card-mobile'])[1]//span[contains(.,'Weniger anzeigen')]");
    private By showLessLocatorBtn = By.xpath("//span[@class='ws10-button-link__text ws10-text ws10-spacing-0'][contains(.,'Weniger anzeigen ')]");
    private By showMoreLocator = By.xpath("//span[@class='ws10-button-link__text ws10-text ws10-spacing-0'][contains(.,' Mehr anzeigen ')]");
    private By dividerLinesOfFirstSectionLocator = By.xpath("//div[@class='active-invoice-detials-card__items']/hr");
    private By dividerLinesOfSecondSectionLocator = By.xpath("//div[@class='active-invoice-detials-card__sum']/hr");
    private By backButtonLink = By.xpath("//a[@automation-id='back_Link']");


    //CLs
    String CreditCL = "Dein Guthaben";
    String meinDatenCL = "Meine Daten";
    String positiveValue = "Offene Forderungen aus dem Vormonat";
    String negativeValue = "Guthaben aus dem Vormonat";
    String customerBill="Rechnung";
    String itemizedBill="Verbindungsübersicht";
    String errorHeadline = "Das hat leider nicht geklappt";
    String errorBody = "Entschuldige bitte, unser Fehler. Versuch es einfach später nochmal.";

    private By nueLadenBtn_Locator = By.xpath("//button[@automation-id = 'undefined_btn']");

    private By subscriberCardLocator = By.xpath("//div[@automation-id='invoiceSummaryDetailsCard_tv']");

    private By filterLocator = By.xpath("//select");


    public static By getSubscriberNameLocator(String subscriberOrder) {
        return By.xpath("(//div[@automation-id='invoiceSummaryDetailsCard_tv'])[" + subscriberOrder + "]/div[1]");
    }

    public static By getRequiredLocator(String requiredLocator) {
        return By.xpath(requiredLocator);
    }

    public static By getDividerLinesLocatorByClassName(String requiredClassName) {
        return By.xpath("//div[@class='"+requiredClassName+"']/hr");
    }

    public static By getTextOfFirstSectionOfTheCard(String fieldOrder) {
        return By.xpath("(//div[@class='active-invoice-detials-card__items']//span[@class='item_text'])["+fieldOrder+"]");
    }

    public static By getTextOfFirstSectionOfTheCardForUserHasMoreThanOneSubscriber(String fieldOrder) {
        return By.xpath("(//div[@class='active-invoice-detials-card__items ml-0']//span[@class='item_text tal'])["+fieldOrder+"]");
    }

    public static By getSubscriberNumberLocator(String subscriberOrder) {
        return By.xpath("(//div[@automation-id='invoiceSummaryDetailsCard_tv'])[" + subscriberOrder + "]/div[2]");
    }

    public static By getSubscriberAmountLocator(String subscriberOrder) {
        return By.xpath("(//div[@automation-id='invoiceSummaryDetailsCard_tv'])[" + subscriberOrder + "]/div[3]");
    }

    public static By getSubscriberShowMoreButtonLocator(String subscriberOrder) {
        return By.xpath("(//span[@class='ws10-button-link__text ws10-text ws10-spacing-0'])[" + subscriberOrder + "]");
    }

    public static By getSubscriberConnectionPriceTextLocator(String subscriberOrder) {

        return By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPrice_tv'])[" + subscriberOrder + "]/span[@class='item_text tal']");
    }
    public static By getSubscriberConnectionPriceAmountLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPrice_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }

    public static By getSubscriberBasicPriceTextLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsbasePackagePrice_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }
    public static By getSubscriberBasicPriceAmountLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsbasePackagePrice_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }

    public static By getSubscriberConnectionPriceServicesTextLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPricesServices_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }
    public static By getSubscriberConnectionPriceServicesAmountLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsConnectionPricesServices_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }

    public static By getSubscriberMiscellaneousTextLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsMobilePayment_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }
    public static By getSubscriberMiscellaneousAmountLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsMobilePayment_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }
    public static By getSubscriberToTheirFavorTextLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsMiscellaneous_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }
    public static By getSubscriberToTheirFavorAmountLocator(String subscriberOrder) {
        return By.xpath("//div[@automation-id='invoiceSummaryDetailsMiscellaneous_tv'])[" + subscriberOrder + "]/span[@class='item_amount']");
    }




    public static By getBasispreisLocator() {
        return basispreisLocator;
    }

    public static By getKundennummer_ValueLocator() {
        return kundennummer_ValueLocator;
    }

    public static By getZahlbarZum_ValueLocator() {
        return zahlbarZum_ValueLocator;
    }

    public static By getVerbindungspreis_ValueLocator() {
        return verbindungspreis_ValueLocator;
    }

    public static By getUmsatzsteuer19_ValueLocator() {
        return umsatzsteuer19_ValueLocator;
    }

    public static By getAmountLocator() {
        return amountLocator;
    }

    public InvoiceSummary(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    public static By getInvoiceDetailsLabelsLocator(int x ) {
        return By.xpath("(//div[contains(@class,'active-invoice-detials-card')]//span[1])["+x+"]");
    }

    public static By getCardTotalAmountLocator (String cardOrder){
        return By.xpath("(//*[@automation-id='invoiceSummaryDetailsCard_tv']//div[@class='active-invoice-detials-card-KB__title tar ml-auto no-wrap'])["+cardOrder+"]");
    }


    //CL

    String connectionPriceTextCl = "anschlusspreis";
    String basicPriceTextCl = "Basispreis / Paketpreis";
    String connectionPricesServicesTextCl = "Verbindungspreise und Services";
    String miscellaneousTextCl = "Sonstiges";
    String toTheirFavorTextCl = "Zu Ihren Gunsten";



    /* **************** WFCT-10008 ******************* */

    private String downloadPath = SHAFT.Properties.paths.downloads();

    public String getDownloadPath() {
        return downloadPath;
    }

    @Step("Download invoice PDF")
    public void downloadInvoicePDF() {
        driver.element().click(invoicePdfDownloadButtonLocator);
    }

    @Step("Download itemized PDF")
    public void downloadItemizedPDF() {
        driver.element().click(itemizedPdfDownloadButtonLocator);
    }

    public boolean isFileDownloaded(String downloadPath, String fileName) {
        int i;
        boolean flag = false;
        File dir = new File(downloadPath);
        File[] dir_contents = dir.listFiles();

        for (i = 0; i < dir_contents.length; i++) {
            if (dir_contents[i].getName().contains(fileName)) {
                dir_contents[i].delete();
                return flag = true;
            }

        }

        return flag;
    }

    @Step("wait for file to be downloaded")
    public void waitForFileToBeDownloaded() {
        if (driver.element().getElementsCount(By.xpath("fakeLocator")) == 1) {
            driver.element().click(By.xpath("fakeLocator"));
        }
    }



    // CL
    String errorNotificationTitle_Cl = "Das hat leider nicht geklappt";
    String getErrorNotificationDescription_Cl = "Entschuldige bitte, unser Fehler. Versuch es einfach später nochmal.";
    String kundennummerLabel_Cl = "Kundennummer";
    String zahlbarZumLabel_Cl = "Zahlbar zum";
    String rechnungsdatumLabel_CL = "Rechnungsdatum";
    String rechnungsNrLabel_Cl = "Rechnungs-Nr.";
    String verbindungspreisLabel_CL = "Verbindungspreis";
    String sonstigesLabel_CL = "Sonstiges";
    String zwischensummeNettoLabel_CL = "Zwischensumme Netto";
    String umsatzsteuer16Label_CL = "Umsatzsteuer 16%";
    String rechnungsbetragLabel_CL = "Rechnungsbetrag";
    String unPaidAmountLabel_CL = "Forderungen aus Vormonaten";
    String amountToPayLabel_CL = "Zu zahlender Betrag";
    String creditLabel_CL = "Dein Guthaben";
    String basisPriceLabel_CL = "Basispreis/Paketpreis";
    String tax19Label_CL = "Umsatzsteuer 19%";
    String oldMonthsDetails_CL = "Siehe PDF-Rechnung";
    String unPaidAmountLabelForOldMonths_CL = "Aus Vormonaten";
    String negativeUnPaidAmountLabel_CL = "Guthaben aus Vormonaten";
    String backButton_CL = "Zurück";

    @Step("click on invoice summary page back button")
    public void clickOnInvoiceSummaryBackPageBackButton()
    {
        driver.element().click(backButtonLink);
    }

    // Validations

    /* ***********************WFCT-10008********************* */

    public void assertThatItemizedPdfBtnNotExist() {
        driver.verifyThat()
                .element(itemizedPdfDownloadButtonLocator)
                .doesNotExist()
                .withCustomReportMessage("Assert that Itemized PDF download button does not exist")
                .perform();

    }

    public void assertThatInvoicePdfBtnNotExist() {
        driver.verifyThat()
                .element(invoicePdfDownloadButtonLocator)
                .doesNotExist()
                .withCustomReportMessage("Assert that Invoice PDF download button does not exist")
                .perform();

    }

    public void assertThatInvoicePdfDownloaded() {
        Validations.verifyThat()
                .object(isFileDownloaded(getDownloadPath(), "Rechnung_Kundennr"))
                .isTrue()
                .withCustomReportMessage("Assert that invoice pdf is downloaded")
                .perform();
    }

    public void assertThatItemizedPdfDownloaded() {
        Validations.verifyThat()
                .object(isFileDownloaded(getDownloadPath(), "Verbindungsuebersicht_Kundennr"))
                .isTrue()
                .withCustomReportMessage("Assert that itemized pdf is downloaded")
                .perform();

    }

    public void assertOnErrorNotificationTitle() {
        driver.verifyThat()
                .element(errorTitleLocator)
                .textTrimmed()
                .contains(errorNotificationTitle_Cl)
                .withCustomReportMessage("Assert in Error message title ")
                .perform();
    }


    public void assertOnErrorNotificationBody() {
        driver.verifyThat()
                .element(errorDescriptionLocator)
                .textTrimmed()
                .isEqualTo(getErrorNotificationDescription_Cl)
                .withCustomReportMessage("Assert in Error message body")
                .perform();
    }

    /* **************************WFCT-14089************************** */

    @Step("Download Subscriber Bill")
    public void downloadSubscriberBill(){
        driver.element().click(subscriberBillLocator);
    }

    /* **************************WFCT-7430************************** */

    public void assertOnTheInvoiceSummaryGeneralComponents() {
        driver.verifyThat().element(monthSwitcherLocator).exists().withCustomReportMessage("Assert that Month Switcher is displayed").perform();

        driver.verifyThat().element(amountLocator).exists().withCustomReportMessage("Assert that Amount is displayed").perform();

        driver.verifyThat().element(kundennummerLocator).textTrimmed().isEqualTo(kundennummerLabel_Cl).withCustomReportMessage("Assert on Kundennummer label").perform();

        driver.verifyThat().element(zahlbarZumLocator).textTrimmed().isEqualTo(zahlbarZumLabel_Cl).withCustomReportMessage("Assert on Zahlbar zum label").perform();

        driver.verifyThat().element(rechnungsdatumLocator).textTrimmed().isEqualTo(rechnungsdatumLabel_CL).withCustomReportMessage("Assert on Rechnungsdatum label").perform();

        driver.verifyThat().element(rechnungsNrLocator).textTrimmed().isEqualTo(rechnungsNrLabel_Cl).withCustomReportMessage("Assert on Rechnungs-Nr label").perform();
    }

    public void assertOnAmountValue(String amount) {
        driver.verifyThat().element(InvoiceSummary.getAmountLocator()).textTrimmed().isEqualTo(amount).withCustomReportMessage("Assert on amount value ").perform();
    }

    public void assertOnAccNumValue(String accNum) {
        driver.verifyThat().element(InvoiceSummary.getKundennummer_ValueLocator()).textTrimmed().isEqualTo(accNum).withCustomReportMessage("Assert on account number").perform();
    }

    public void assertOnDueDateValue(String dueDate) {
        driver.verifyThat().element(InvoiceSummary.getZahlbarZum_ValueLocator()).textTrimmed().isEqualTo(dueDate).withCustomReportMessage("Assert on due date value").perform();
    }

    public void assertOnTheInvDate(String invDate) {
        driver.verifyThat().element(rechnungsdatum_ValueLocator).textTrimmed().isEqualTo(invDate).withCustomReportMessage("Assert on The invoice date").perform();
    }

    public void assertOnTheInvoiceNumber(String invNum) {
        driver.verifyThat().element(rechnungsNr_ValueLocator).textTrimmed().isEqualTo(invNum).withCustomReportMessage("Assert on the invoice number").perform();
    }

    public void assertOnUsageValue(String usageValue) {
        driver.verifyThat().element(InvoiceSummary.getVerbindungspreis_ValueLocator()).textTrimmed().isEqualTo(usageValue).withCustomReportMessage("Assert on Usage value").perform();
    }

    public void assertOnOneTimeValue(String oneTimeValue) {
        driver.verifyThat().element(sonstiges_ValueLocator).textTrimmed().isEqualTo(oneTimeValue).withCustomReportMessage("Assert on one time value ").perform();
    }

    public void assertOnSubTotalValue(String subTotalValue) {
        driver.verifyThat().element(zwischensummeNetto_ValueLocator).textTrimmed().isEqualTo(subTotalValue).withCustomReportMessage("Assert on subtotal").perform();
    }

    public void assertOnTax16Value(String tax16Value) {
        driver.verifyThat().element(umsatzsteuer16_ValueLocator).textTrimmed().isEqualTo(tax16Value).withCustomReportMessage("Assert on Tax 16 ").perform();
    }

    public void assertOnInvoiceAmount(String invAmount) {
        driver.verifyThat().element(rechnungsbetrag_ValueLocator).textTrimmed().isEqualTo(invAmount).withCustomReportMessage("Assert on invoice amount").perform();
    }

    @Step("Assert on unpaid amount")
    public void assertOnTheUnPaidAmount(String unPaidAmount) {
        driver.verifyThat().element(unPaidAmount_ValueLocator).textTrimmed()
                .isEqualTo(unPaidAmount).withCustomReportMessage("Assert on unpaid amount").perform();
    }

    @Step("Assert on amount to pay")
    public void assertOnAmountToPay(String amountToPay) {
        driver.verifyThat().element(amountToPay_ValueLocator).textTrimmed()
                .isEqualTo(amountToPay).withCustomReportMessage("Assert on amount to pay").perform();
    }

    @Step("Assert That basis price does not exist")
    public void assertThatBasisPriceNotExists() {
        driver.verifyThat().element(InvoiceSummary.getBasispreisLocator()).doesNotExist().withCustomReportMessage("Assert That basis price does not exist").perform();
    }

    public void assertOnUsageValueLabel() {
        driver.verifyThat().element(verbindungspreisLocator).textTrimmed().isEqualTo(verbindungspreisLabel_CL).withCustomReportMessage("Assert on Usage value label").perform();
    }

    public void assertOnOneTimeValueLabel() {
        driver.verifyThat().element(sonstigesLocator).textTrimmed().isEqualTo(sonstigesLabel_CL).withCustomReportMessage("Assert on one time value label").perform();
    }

    public void assertOnSubTotalLabel() {
        driver.verifyThat().element(zwischensummeNettoLocator).textTrimmed().isEqualTo(zwischensummeNettoLabel_CL).withCustomReportMessage("Assert on subtotal label").perform();
    }

    public void assertOnTax16Label() {
        driver.verifyThat().element(umsatzsteuer16Locator).textTrimmed().isEqualTo(umsatzsteuer16Label_CL).withCustomReportMessage("Assert on Tax 16 Label").perform();
    }

    public void asserThat19TaxLabelNotExists() {
        driver.verifyThat().element(umsatzsteuer19Locator).doesNotExist().withCustomReportMessage("Assert That 19 tax label does not exist");
    }

    public void assertOnInvoiceAmountLabel() {
        driver.verifyThat().element(rechnungsbetragLocator).textTrimmed().isEqualTo(rechnungsbetragLabel_CL).withCustomReportMessage("Assert on invoice amount Label").perform();
    }

    @Step("Assert on unpaid amount Label for latest Month")
    public void assertOnUnPaidAmountLabel() {
        driver.verifyThat().element(unPaidAmountLocator).textTrimmed().isEqualTo(unPaidAmountLabel_CL)
                .withCustomReportMessage("Assert on unpaid amount Label").perform();
    }

    @Step("Assert on amount to pay Label")
    public void assertOnAmountToPayLabel() {
        driver.verifyThat().element(amountToPayLocator).textTrimmed()
                .isEqualTo(amountToPayLabel_CL)
                .withCustomReportMessage("Assert on amount to pay label ").perform();
    }

    public void assertOnNegativeAmountToPayLabel() {
        driver.verifyThat().element(negativeAmountToPayLocator).textTrimmed()
                .isEqualTo(creditLabel_CL)
                .withCustomReportMessage("Assert on amount to pay label").perform();
    }

    public void assertOnCreditLabel() {
        driver.verifyThat().element(creditAmountLabelLocator).textTrimmed().isEqualTo(creditLabel_CL).withCustomReportMessage("Assert that Credit label is correct").perform();
    }

    public void assertOnBasisPriceValue(String basisPriceValue) {
        driver.verifyThat().element(basispreis_ValueLocator).textTrimmed().isEqualTo(basisPriceValue).withCustomReportMessage("Assert on Basis price value").perform();

    }

    public void assertOnTax19Value(String tax19Value) {
        driver.verifyThat().element(InvoiceSummary.getUmsatzsteuer19_ValueLocator()).textTrimmed().isEqualTo(tax19Value).withCustomReportMessage("Assert on Tax 19 value").perform();
    }

    public void assertOnBasisPriceLabel() {
        driver.verifyThat().element(basispreisLocator).textTrimmed().isEqualTo(basisPriceLabel_CL).withCustomReportMessage("Assert on Basis price label").perform();
    }

    public void assertOnTax19Label() {
        driver.verifyThat().element(umsatzsteuer19Locator).textTrimmed().isEqualTo(tax19Label_CL).withCustomReportMessage("Assert on Tax 19 label").perform();
    }

    @Step("Assert on unpaid amount for old months")
    public void assertOnTheUnPaidAmountForOldMonths() {
        driver.verifyThat().element(unPaidAmount_ValueLocator).textTrimmed()
                .isEqualTo(oldMonthsDetails_CL)
                .withCustomReportMessage("Assert on unpaid amount for old months").perform();
    }

    @Step("Assert on amount to pay for old months")
    public void assertOnAmountToPayForOldMonths() {
        driver.verifyThat().element(amountToPay_ValueLocator).textTrimmed()
                .isEqualTo(oldMonthsDetails_CL)
                .withCustomReportMessage("Assert on amount to pay for old months").perform();
    }

    @Step("Assert on amount to pay for old months")
    public void assertOnNegativeAmountToPayForOldMonths() {
        driver.verifyThat().element(negativeAmountToPay_ValueLocator).textTrimmed()
                .isEqualTo(oldMonthsDetails_CL)
                .withCustomReportMessage("Assert on amount to pay for old months").perform();
    }


    @Step("Assert on unpaid amount Label for old months")
    public void assertOnTheUnPaidAmountLabelForOldMonths() {
        driver.verifyThat().element(unPaidAmountLocator).textTrimmed()
                .isEqualTo(unPaidAmountLabelForOldMonths_CL)
                .withCustomReportMessage("Assert on unpaid amount Label for old months").perform();
    }

    @Step("Click On Back Button")
    public void clickOnBackButton(){
        driver.element().click(backBtn);
    }

    public void assertOnNegativeUnPaidAmountLabel() {
        driver.verifyThat().element(unPaidAmountLocator).textTrimmed()
                .isEqualTo(negativeUnPaidAmountLabel_CL)
                .withCustomReportMessage("Assert on negative unpaid amount Label for latest month").perform();

    }

    public void assertOnNegativeAmountToPay(String amountToPay) {
        driver.verifyThat().element(negativeAmountToPay_ValueLocator).textTrimmed()
                .isEqualTo(amountToPay)
                .withCustomReportMessage("Assert on amount to pay for old months").perform();

    }

    public void assertOnNegativeAmountToPayLabelForOldMonths() {
        driver.verifyThat().element(unPaidAmountLocator).textTrimmed()
                .isEqualTo(unPaidAmountLabelForOldMonths_CL)
                .withCustomReportMessage("Assert on negative unpaid amount Label for latest month").perform();

    }

    public void assertOnBackButtonText(){
        driver.verifyThat().element(invoiceSummaryPageBackButtonLocator).textTrimmed().isEqualTo(backButton_CL).withCustomReportMessage("assert on back button text").perform();
    }


    /*
     *********************************************WFCT-7764*****************************************
     */
    @Step("Download Itemized Bill")
    public void downloadItemizedBill(){
        driver.element().click(itemizedBillLocator);
    }


    @Step("Download Customer Bill")
    public void downloadCustomerBill(){
        driver.element().click(customerBillLocator);
    }


    public void assertOnMonthPresence(String requiredMonth){
        driver.verifyThat().element(requiredMonthLocator).textTrimmed()
                .isEqualTo(requiredMonth)
                .withCustomReportMessage("Assert On Month Presence")
                .perform();
    }


    public void assertOnAmountToBePaid(String amountTOBePaid){
        driver.verifyThat().element(amountToPayAtTopRight).textTrimmed()
                .isEqualTo(amountTOBePaid)
                .withCustomReportMessage("Assert On Amount To Pay")
                .perform();
    }

    public void assertOnCardTotalAmount(String cardOrder,String cardTotalAmount){
        driver.verifyThat().element(getCardTotalAmountLocator(cardOrder)).textTrimmed()
                .isEqualTo(cardTotalAmount)
                .withCustomReportMessage("Assert On card total amount")
                .perform();
    }

    public void assertOnMeinDatenLink(){
        driver.verifyThat().element(meinDatenLink).textTrimmed().isEqualTo(meinDatenCL).withCustomReportMessage("Assert Mein Daten Link")
                .perform();
    }

    public void assertOnAccountNumberField(String accountNumber,String accountNumberTitle) {
        driver.verifyThat().element(accountNumberValueLocator).textTrimmed().isEqualTo(accountNumber).withCustomReportMessage("Assert on account number").perform();
        driver.verifyThat().element(accountNumberTitleLocator).textTrimmed().isEqualTo(accountNumberTitle).withCustomReportMessage("Assert on account number").perform();
    }

    public void assertOnInvoicePeriodField(String invoicePeriodTitle, String invoicePeriodValue) {
        driver.verifyThat().element(invoicePeriodValueLocator).textTrimmed().isEqualTo(invoicePeriodTitle).withCustomReportMessage("Assert on Invoice Period Value").perform();
        driver.verifyThat().element(invoicePeriodTitleLocator).textTrimmed().isEqualTo(invoicePeriodValue).withCustomReportMessage("Assert on Invoice Period Title").perform();
    }


    /*
     *********************************************WFCT-7764*****************************************
     */


    public void assertOnDueDateField(String dueDateTitle, String dueDateValue) {
        driver.verifyThat().element(dueDateValueLocator).textTrimmed().isEqualTo(dueDateValue).withCustomReportMessage("Assert on due date value").perform();
        driver.verifyThat().element(dueDateTitleLocator).textTrimmed().isEqualTo(dueDateTitle).withCustomReportMessage("Assert on due date Title").perform();
    }

    public void assertOnInvoiceNumberField(String invoiceNumber, String invoiceNumberTitle) {
        driver.verifyThat().element(invoiceNumberValueLocator).textTrimmed().isEqualTo(invoiceNumber).withCustomReportMessage("Assert on The invoice Number Value").perform();
        driver.verifyThat().element(invoiceNumberTitleLocator).textTrimmed().isEqualTo(invoiceNumberTitle).withCustomReportMessage("Assert on The invoice Number Title").perform();
    }

    public void assertOnCardHeaderMSISDNCardNAme(String cardName, String msisdn){
        driver.verifyThat().element(cardNameLocator).textTrimmed().isEqualTo(cardName).withCustomReportMessage("Assert On Card Name")
                .perform();
        driver.verifyThat().element(msisdnLocator).textTrimmed().isEqualTo(msisdn).withCustomReportMessage("Assert On MSISDN")
                .perform();
    }
    public void assertOnCardHeaderMSISDNCardNAmeSIT(String cardName,String msisdn){
        driver.verifyThat().element(cardNameLocator).textTrimmed().isEqualTo(cardName).withCustomReportMessage("Assert On Card Name")
                .perform();
        driver.verifyThat().element(msisdnLocator).textTrimmed().isEqualTo(msisdn).withCustomReportMessage("Assert On MSISDN")
                .perform();
    }

    public void assertOnConnectionPriceAtTheCard(String connectionPrice,String connectionPriceCL) {
        driver.verifyThat().element(ConnectionPriceLocator).textTrimmed().isEqualTo(connectionPrice).withCustomReportMessage("Assert On Connection Price Value").perform();
        driver.verifyThat().element(ConnectionPriceCLLocator).textTrimmed().isEqualTo(connectionPriceCL).withCustomReportMessage("Assert On Connection Price Title").perform();
    }

    public void assertOnNotReturnedClFieldOnFirstCardSectionForOneSubscriber(String notReturnedCl, String fieldOrder) {
        driver.verifyThat().element(getTextOfFirstSectionOfTheCard(fieldOrder)).textTrimmed().isEqualTo(notReturnedCl).withCustomReportMessage("Assert On Not Returned CL Of First Section Of Card By Order").perform();
    }

    public void assertOnNotReturnedClFieldOnFirstCardSectionForMoreThanOneSubscriber(String notReturnedCl, String fieldOrder) {
        driver.verifyThat().element(getTextOfFirstSectionOfTheCardForUserHasMoreThanOneSubscriber(fieldOrder)).textTrimmed().isEqualTo(notReturnedCl).withCustomReportMessage("Assert On Not Returned CL Of First Section Of Card By Order").perform();
    }

    public void assertOnAnschlusspreisLableCL(String connectionPriceCL) {
        driver.verifyThat().element(ConnectionPriceCLLocator).textTrimmed().isEqualTo(connectionPriceCL).withCustomReportMessage("Assert On Connection Price Title").perform();
    }

    public void assertOnPackagePriceAtTheCard(String packagePrice,String packagePriceCL) {
        driver.verifyThat().element(packagePriceLocator).textTrimmed().isEqualTo(packagePrice).withCustomReportMessage("Assert On Package Price Value").perform();
        driver.verifyThat().element(packagePriceClLocator).textTrimmed().isEqualTo(packagePriceCL).withCustomReportMessage("Assert On Package Price Title").perform();
    }
    public void assertOnServiceAndConnectionPriceAtTheCard(String ConnectionPricesSndService, String ConnectionPricesSndServiceTitle) {
        driver.verifyThat().element(ConnectionPricesAndServiceLocator).textTrimmed().isEqualTo(ConnectionPricesSndService).withCustomReportMessage("Assert On Connection Prices and Service Value").perform();
        driver.verifyThat().element(ConnectionPricesAndServiceTitleLocator).textTrimmed().isEqualTo(ConnectionPricesSndServiceTitle).withCustomReportMessage("Assert On Connection Prices and Service Title").perform();

    }

    public void assertOnOthersPriceAtTheCard(String othersCost, String othersTitle) {
        driver.verifyThat().element(otherLocator).textTrimmed().isEqualTo(othersCost).withCustomReportMessage("Assert On Other Amount ").perform();
        driver.verifyThat().element(otherTitleLocator).textTrimmed().isEqualTo(othersTitle).withCustomReportMessage("Assert On Other Amount Title").perform();
    }

    public void assertOnCreditFieldAtTheCard(String creditValue, String creditValueTitle) {
        driver.verifyThat().element(creditsLocator).textTrimmed().isEqualTo(creditValue).withCustomReportMessage("Assert On Credits Value").perform();
        driver.verifyThat().element(creditsTitleLocator).textTrimmed().isEqualTo(creditValueTitle).withCustomReportMessage("Assert On Credits description").perform();
    }


    public void assertOnAccountRelatedItemsFieldAtTheCard(String accountRelatedItems, String accountRelatedItemsTitle ) {
        driver.verifyThat().element(accountRelatedItemsLocator).textTrimmed().isEqualTo(accountRelatedItems).withCustomReportMessage("Assert On Account Related Items Value").perform();
        driver.verifyThat().element(accountRelatedItemsTitleLocator).textTrimmed().isEqualTo(accountRelatedItemsTitle).withCustomReportMessage("Assert On Account Related Items Title").perform();
    }

    public void assertOnMobilePaymentFieldAtTheCard(String mobilePayment, String mobilePaymentTitle) {
        driver.verifyThat().element(mobilePaymentLocator).textTrimmed().isEqualTo(mobilePayment).withCustomReportMessage("Assert On Mobile Payment Value").perform();
        driver.verifyThat().element(mobilePaymentTitleLocator).textTrimmed().isEqualTo(mobilePaymentTitle).withCustomReportMessage("Assert On Mobile Payment Title").perform();
    }

    public void assertOnCallNowTransferFieldAtTheCard(String callNowTransfer,String callNowTransferTitle) {
        driver.verifyThat().element(callNowTransferLocator).textTrimmed().isEqualTo(callNowTransfer).withCustomReportMessage("Assert On Call Now Transfer Value").perform();
        driver.verifyThat().element(callNowTransferTitleLocator).textTrimmed().isEqualTo(callNowTransferTitle).withCustomReportMessage("Assert On Mobile Payment Title").perform();
    }

    public void assertOnAmountFromLastMonthAndDisplayedText(String displayedFieldTextAsPerAmount, String amountFromLastMonth){
        driver.verifyThat().element(lastMonthReceivablesTextLocator).textTrimmed().isEqualTo(displayedFieldTextAsPerAmount)
                .withCustomReportMessage("Assert On Field CL Depends on Returning Value").perform();
        driver.verifyThat().element(amountFromLastMonthLocator).textTrimmed().isEqualTo(amountFromLastMonth)
                .withCustomReportMessage("Assert On Value While Negative means a Credit Value").perform();
    }

    public void assertOnDueAmountAndDisplayedFieldText(String displayedFieldTextAsPerAmount, String dueAmount){
        driver.verifyThat().element(payAmountLocator).textTrimmed().isEqualTo(displayedFieldTextAsPerAmount)
                .withCustomReportMessage("Assert On Payable Amount CL ").perform();
        driver.verifyThat().element(payAmountValueLocator).textTrimmed().isEqualTo(dueAmount)
                .withCustomReportMessage("Assert On Payable Amount Value").perform();
    }

    public void assertOnPayableAMountAndCLForCredit(String fieldCL, String positiveOrNegValue){
        driver.verifyThat().element(payAmountCreditLocator).textTrimmed().isEqualTo(fieldCL)
                .withCustomReportMessage("Assert On Payable Amount CL ").perform();
        driver.verifyThat().element(payAmountCreditValueLocator).textTrimmed().isEqualTo(positiveOrNegValue)
                .withCustomReportMessage("Assert On Payable Amount Value").perform();
    }

    public void assertOnItemizedBillExistance() {
        driver.verifyThat().element(itemizedBillLocator).textTrimmed().isEqualTo(itemizedBill)
                .withCustomReportMessage("Assert That Itemized Bill Exist").perform();
    }

    public void assertOnCustomerBillExistance(){
        driver.verifyThat().element(customerBillLocator).textTrimmed().isEqualTo(customerBill)
                .withCustomReportMessage("Assert That Customer Bill Exist").perform();

    }

    public void assertThatItemizedPdfDownloadedSuccessfully(String downloadedFileName) {
        Validations.verifyThat()
                .object(isFileDownloaded(getDownloadPath(), downloadedFileName))
                .isTrue()
                .withCustomReportMessage("Assert that invoice pdf is downloaded")
                .perform();
    }



    public void assertThatCustomerBillDoesNotExist(){
        driver.verifyThat().element(itemizedBillLocator)
                .doesNotExist().withCustomReportMessage("Assert That Customer Bill Does Not Exist").perform();
    }

    public void assertThatItemizedBillDoesNotExists(){
        driver.verifyThat().element(itemizedBillLocator)
                .doesNotExist().withCustomReportMessage("Assert That Itemized Bill Does Not Exist").perform();
    }

    public void assertingOnOpenReceivableCL(){
        String receivablesValue = driver.element().getText(amountFromLastMonthLocator);
        String deletedChar = receivablesValue.substring(0, receivablesValue.length() - 1);
        String modifiedString = deletedChar.replace(",", ".");
        float lastMonthReceivables = Float.parseFloat(modifiedString);
        if (lastMonthReceivables>= 0){
            driver.verifyThat().element(lastMonthReceivablesTextLocator).textTrimmed()
                    .isEqualTo(positiveValue).withCustomReportMessage("Assert On Positive value CL").perform();
        }
        else {
            driver.verifyThat().element(lastMonthReceivablesTextLocator).textTrimmed()
                    .isEqualTo(negativeValue).withCustomReportMessage("Assert On Negative value CL").perform();
        }
    }


    public void assertOnErrorNotificationHeadline() {
        driver.verifyThat()
                .element(errorNotificationHeadline)
                .textTrimmed()
                .contains(errorNotificationTitle_Cl)
                .withCustomReportMessage("Assert in Error message title ")
                .perform();
    }



    public void assertOnErrorBody() {
        driver.verifyThat()
                .element(errorNotificationBody)
                .textTrimmed()
                .isEqualTo(getErrorNotificationDescription_Cl)
                .withCustomReportMessage("Assert in Error message body")
                .perform();
    }

    public void assertThatNeuLadenBtnNotExists(){
        driver.verifyThat().element(nueLadenBtn_Locator).doesNotExist().withCustomReportMessage("assert that Neu Laden button doen not exist");
    }

    public void assertOnCreditAmountCL(){
        driver.verifyThat().element(creditAmountLocator).textTrimmed().isEqualTo(CreditCL)
                .withCustomReportMessage("Assert On Credit Amount CL").perform();
    }

    public void assertThatInvoiceNumberComponentNotReturned(){
        driver.verifyThat().element(invoiceNumberValueLocator).doesNotExist()
                .withCustomReportMessage("Assert On Amount To Pay")
                .perform();
        driver.verifyThat().element(invoiceNumberTitleLocator).doesNotExist()
                .withCustomReportMessage("Assert On Amount To Pay")
                .perform();
    }

    public void assertOnTheErrorMessageColor(String requiredColor){
        driver.verifyThat().element(errorDivLocator).cssProperty("background")
                .contains(requiredColor).withCustomReportMessage("Assert On Error Message Color").perform();
    }

    public void assertThatItemizedBillExist() {
        driver.verifyThat().element(customerBillLocator).textTrimmed().isEqualTo(itemizedBill)
                .withCustomReportMessage("Assert That Itemized Bill Exist").perform();
    }

    //10486

    private static String selectSubscriberNotificationTitleCl = "Gut zu wissen";
    private static String selectSubscriberNotificationDescriptionCl = "Du hast Deine Teilnehmer gefiltert. So wird Dir nur einer Deiner Teilnehmer anzeigt. Willst Du wieder alle Teilnehmer sehen, dann wähl im Filter ";
    private static String showLessButtonCl = "Weniger anzeigen";
    private static String SubscriberItemizedBillCl = "Verbindungsübersicht herunterladen";

    private static final By selectSubscriberNotificationTitleLocator = By.xpath("//div[@automation-id='successMsg_tv']//h4");
    private static final By selectSubscriberNotificationDescriptionLocator = By.xpath("//div[@automation-id='successMsg_tv']//p");
    private static final By leftMonthNavigatorLocator = By.xpath("(//div[@class='month-bill-cont']/month-selector//button)[1]");
    public static By getDownloadItemizedBillLocator(String SubNumber) {
        return By.xpath("(//div[@automation-id='invoiceSummaryDetailsItemizedBill_tv']//*[local-name()='svg' ])["+SubNumber+"]");
    }
    public static By getItemizedBillTextLocator(String SubNumber) {
        return By.xpath("(//div[@automation-id='invoiceSummaryDetailsItemizedBill_tv']//p)["+SubNumber+"]");
    }


    @Step("select previous Month")
    public void selectPreviousMonth()
    {
        driver.element().click(leftMonthNavigatorLocator);
    }
    public void assertOnSelectSubscriberNotificationTitle(){
        driver.verifyThat().element(selectSubscriberNotificationTitleLocator).textTrimmed().isEqualTo(selectSubscriberNotificationTitleCl).withCustomReportMessage("assert on select subscriber notification title ").perform();
    }

    public void assertThatSelectSubscriberNotificationDoesNotExist(){
        driver.verifyThat().element(selectSubscriberNotificationTitleLocator).doesNotExist().withCustomReportMessage("assert on select subscriber notification does not exist ").perform();
    }
    public void assertOnSelectSubscriberNotificationDescription()
    {
        driver.verifyThat().element(selectSubscriberNotificationDescriptionLocator).textTrimmed().contains(selectSubscriberNotificationDescriptionCl).withCustomReportMessage("assert on select subscriber notification title ").perform();
    }

    @Step(" select subscriber from drop down list")
    public void selectSubscriberFromDDL(String subscriberNumber) {
        String subNumber = driver.element().getText(By.xpath("//option[@automation-id='ws10-form-select_option_" + subscriberNumber + "']"));
        driver.element().select(filterLocator, subNumber);

    }
    @Step("Download Itemized Bill")
    public void downloadSubscriberItemizedBill(String subNum) {
        driver.element().click(getDownloadItemizedBillLocator(subNum));
    }

    @Step("click on show more button")
    public void clickOnShowMoreButton(String subscriberOrder)
    {
        driver.element().click(getSubscriberShowMoreButtonLocator(subscriberOrder));
    }

    public void checkSubscriberCount(String NumberOfCards) {

        Validations.verifyThat().object(driver.element().getElementsCount(subscriberCardLocator)).isEqualTo(Integer.parseInt(NumberOfCards)).withCustomReportMessage("assert on cards count").perform();
    }
    public void checkThatSubscriberCountIsLessThan5() {

        Validations.verifyThat().number(driver.element().getElementsCount(subscriberCardLocator)).isLessThan(5).withCustomReportMessage("assert that cards count is less than 5").perform();
    }

    public void checkThatSubscriberCountIsMoreThan5() {

        Validations.verifyThat().number(driver.element().getElementsCount(subscriberCardLocator)).isGreaterThan(5).withCustomReportMessage("assert that cards count is more than").perform();
    }
    public void assertThatSubscriberItemizedBillDoesNotExists(String subNum) {
        driver.verifyThat().element(getItemizedBillTextLocator(subNum))
                .doesNotExist().withCustomReportMessage("Assert That Itemized Bill Does Not Exist").perform();
    }

    public void assertThatFilterDoesNotExist() {
        driver.verifyThat().element(filterLocator).doesNotExist().withCustomReportMessage("assert that filter doesn`t exist").perform();
    }




    public void assertOnCollapsedSubscriberCardDetails(String subscriberName, String subscriberNumber, String subscriberAmount,
                                                       String subscriberOrder) {
        driver.verifyThat().element(getSubscriberNameLocator(subscriberOrder)).textTrimmed().isEqualTo(subscriberName).withCustomReportMessage("assert on subscriber name").perform();
        driver.verifyThat().element(getSubscriberNumberLocator(subscriberOrder)).textTrimmed().isEqualTo(subscriberNumber).withCustomReportMessage("assert on subscriber number").perform();
        driver.verifyThat().element(getSubscriberAmountLocator(subscriberOrder)).textTrimmed().isEqualTo(subscriberAmount).withCustomReportMessage("assert on subscriber Amount").perform();

    }
    public void assertOnSubscriberConnectionPriceSection(String subscriberOrder, String connectionPriceAmount)
    {
        driver.verifyThat().element(getSubscriberConnectionPriceTextLocator(subscriberOrder)).textTrimmed().isEqualTo(connectionPriceAmount).withCustomReportMessage("assert on conection price text").perform();
        driver.verifyThat().element(getSubscriberConnectionPriceAmountLocator(subscriberOrder)).textTrimmed().isEqualTo(connectionPriceAmount).withCustomReportMessage("assert on conection price amount").perform();
    }

    public void assertOnSubscriberBasicPriceSection(String subscriberOrder, String basicPriceAmount)
    {
        driver.verifyThat().element(getSubscriberBasicPriceTextLocator(subscriberOrder)).textTrimmed().isEqualTo(basicPriceTextCl).withCustomReportMessage("assert on basic price text").perform();
        driver.verifyThat().element(getSubscriberBasicPriceAmountLocator(subscriberOrder)).textTrimmed().isEqualTo(basicPriceAmount).withCustomReportMessage("assert on basic price amount").perform();
    }

    public void assertOnSubscriberConnectionPriceServicesSection(String subscriberOrder, String ConnectionPriceServicesAmount)
    {
        driver.verifyThat().element(getSubscriberConnectionPriceServicesTextLocator(subscriberOrder)).textTrimmed().isEqualTo(connectionPricesServicesTextCl).withCustomReportMessage("assert on connection price services text").perform();
        driver.verifyThat().element(getSubscriberConnectionPriceServicesAmountLocator(subscriberOrder)).textTrimmed().isEqualTo(ConnectionPriceServicesAmount).withCustomReportMessage("assert on connection price services amount").perform();
    }

    public void assertOnSubscriberMiscellaneousSection(String subscriberOrder, String miscellaneousAmount)
    {
        driver.verifyThat().element(getSubscriberMiscellaneousTextLocator(subscriberOrder)).textTrimmed().isEqualTo(miscellaneousTextCl).withCustomReportMessage("assert on Miscellaneous text").perform();
        driver.verifyThat().element(getSubscriberMiscellaneousTextLocator(subscriberOrder)).textTrimmed().isEqualTo(miscellaneousAmount).withCustomReportMessage("assert on Miscellaneous amount").perform();
    }
    public void assertOnSubscriberToTheirFavorSection(String subscriberOrder, String toTheirFavorAmount)
    {
        driver.verifyThat().element(getSubscriberToTheirFavorTextLocator(subscriberOrder)).textTrimmed().isEqualTo(miscellaneousTextCl).withCustomReportMessage("assert on ToTheirFavor text").perform();
        driver.verifyThat().element(getSubscriberToTheirFavorAmountLocator(subscriberOrder)).textTrimmed().isEqualTo(toTheirFavorAmount).withCustomReportMessage("assert on ToTheirFavor amount").perform();
    }

    public void assertOnCommonCard(String accountRelatedAmount,String mobilePaymentAmount,
                                   String callNowTransferAmount) {
        driver.verifyThat().element(accountRelatedItemsLocator).textTrimmed().isEqualTo(accountRelatedAmount).withCustomReportMessage("Assert On Account Related Items Value").perform();
        driver.verifyThat().element(mobilePaymentLocator).textTrimmed().isEqualTo(mobilePaymentAmount).withCustomReportMessage("Assert On Mobile Payment Value").perform();
        driver.verifyThat().element(callNowTransferLocator).textTrimmed().isEqualTo(callNowTransferAmount).withCustomReportMessage("Assert On Call Now Transfer Value").perform();
    }

    public void assertThatTwoOrMoreCardsCanExpandAtTheSameTime()
    {
        driver.verifyThat().element(getSubscriberShowMoreButtonLocator("1")).textTrimmed().isEqualTo(showLessButtonCl).perform();
        driver.verifyThat().element(getSubscriberShowMoreButtonLocator("2")).textTrimmed().isEqualTo(showLessButtonCl).perform();

    }

    public void assertOnSubscriberItemizedBill(String subNum) {
        driver.verifyThat().element(getItemizedBillTextLocator(subNum)).textTrimmed().isEqualTo(SubscriberItemizedBillCl)
                .withCustomReportMessage("Assert sub Itemized Bill cl").perform();
    }

    public void assertOnCustomerBill() {
        driver.verifyThat().element(customerBillLocator).textTrimmed().isEqualTo(customerBill)
                .withCustomReportMessage("Assert That Customer Bill Exist").perform();

    }

    public void assertOnDownloadErrorHeadline() {
        driver.verifyThat().element(errorHeadlineLocator).textTrimmed()
                .isEqualTo(errorHeadline).withCustomReportMessage("Assert On Error Headline").perform();
    }

    public void assertOnDownloadErrorBody() {
        driver.verifyThat().element(errorBodyLocator).textTrimmed()
                .isEqualTo(errorBody).withCustomReportMessage("Assert On Error Body").perform();
    }

    /* ***************** WFCT-13965 ******************** */
    private static final By invoiceMonthLocator = By.xpath("//month-selector//span[2]");
    public void assertThatShowMoreButtonDoesNotExist()
    {
        driver.verifyThat().element(getSubscriberShowMoreButtonLocator("1")).doesNotExist().withCustomReportMessage("assert That show more button does not exist").perform();
    }

    public void assertThatDateMappedFromEndDate(String endDate)
    {
        driver.verifyThat().element(invoiceMonthLocator).textTrimmed().isEqualTo(endDate).withCustomReportMessage("assert That Date Mapped From EndDate").perform();
    }



    public void assertThatSameMsisdnAppearsAtFirstCard(String msisdn){
        driver.verifyThat().element(msisdnLocation).textTrimmed().isEqualTo(msisdn)
                .withCustomReportMessage("Assert That Same MSISDN Appears At The First CArd").perform();
    }

    public void assertThatCardExpandedAndOnShowLess(String showLessText){
        driver.verifyThat().element(showLessBtn).textTrimmed().isEqualTo(showLessText)
                .withCustomReportMessage("Assert That Card Carries Same MSISDN is Expanded").perform();
    }

    public void assertOnNumberofExpandedCards(String numberOfCollapsedCards){
        int count = driver.element().getElementsCount(showLessLocatorBtn);
        String countInString = String.valueOf(count);
        Assert.assertEquals(countInString,numberOfCollapsedCards);
    }

    public void assertOnNumberofCollapsedCards(String numberOfCollapsedCards){
        List<WebElement> elements = driver.getDriver().findElements(showMoreLocator);
        int count = elements.size();
        String countInString = String.valueOf(count);
        Assert.assertEquals(countInString,numberOfCollapsedCards);
    }

    public void assertOnSameMSISDNAtFilter(String nameAndMSISDN){
        WebElement webElement = driver.getDriver().findElement(By.xpath("//select[@id='filterProperties']"));
        Select dropdown = new Select(webElement);
        WebElement selectedOption = dropdown.getFirstSelectedOption();
        String selectedText = selectedOption.getText();
        Assert.assertEquals(selectedText,nameAndMSISDN);
        System.out.println(selectedText);


    }

    public void assertOnNumberOfDividerLines(String numberOfDividerLines,String className){
        List<WebElement> dividerLines = driver.getDriver().findElements(getDividerLinesLocatorByClassName(className));
        int dividerLinesNumbers = dividerLines.size();
        String dividerLinesNumnberInString = String.valueOf(dividerLinesNumbers);
        Assert.assertEquals(dividerLinesNumnberInString,numberOfDividerLines);
    }


    public void assertOnConnectionPriceFieldDoesNotExist(){
        driver.verifyThat().element(ConnectionPricesAndServiceTitleLocator).doesNotExist()
                .withCustomReportMessage("Assert On Connection Price Field Does Not Exist")
                .perform();
    }

    public void assertOnAccountRelatedFieldDoesNotExist(){
        driver.verifyThat().element(mobilePaymentTitleLocator).doesNotExist()
                .withCustomReportMessage("Assert On Account Related Field Does Not Exist")
                .perform();
    }

    public void assertOnCallTransferFieldDoesNotExist(){
        driver.verifyThat().element(mobilePaymentTitleLocator).doesNotExist()
                .withCustomReportMessage("Assert On Call Transfer Field Does Not Exist")
                .perform();
    }

    public void assertOnGreenColor(String greenColor,String requiredLocator){
        driver.verifyThat().element(getRequiredLocator(requiredLocator)).cssProperty("color")
                .contains(greenColor).withCustomReportMessage("AssertOnGreenColor")
                .perform();
    }
}




