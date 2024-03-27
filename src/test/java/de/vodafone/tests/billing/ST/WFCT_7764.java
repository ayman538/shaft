package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


@Epic("Billing")
@Feature("ST")
@Story("WFCT-7764")
public class WFCT_7764 extends ST_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String contractOrder,positiveValueCL;
    String negativeValueCL,negativeValue,payableAmountCL,PayableAmountValue, positiveValue,hasCreditCL;
    String creditValue,zeroValue,accountNumber,invoiceNumber, amountToPay,creditValueFirstSection,selectedMonth;
    String invoicePeriodValue,invoicePeriodTitle,dueDateTitle,dueDateValue,accountNumberTitle,invoiceNumberTitle;
    String cardName, msisdn,connectionPrice,connectionPriceCL,packagePrice,packagePriceCL;
    String connectionPricesSndService,connectionPricesSndServiceTitle,othersCost,othersTitle,creditAmountTitle,creditAmount;
    String accountRelatedItems,accountRelatedItemsTitle,mobilePayment,mobilePaymentTitle,callNowTransferTitle,callNowTransfer;
    String customerBillName,requiredColor,itemizedBillName,numberOfDividerLinesAtSecondSection,numberOfDividerLinesAtFirstSection;
    String creditColorAtTopRight,creditLocator,hasCreditClLocator,hasCreditClColor, firstSectionClassNameLocator, secondSectionClassNameLocator;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        negativeValueCL = testData.getTestData(method.getName() + ".negativeValueCL");
        positiveValueCL = testData.getTestData(method.getName() + ".positiveValueCL");
        zeroValue = testData.getTestData(method.getName() + ".zeroValue");
        negativeValue = testData.getTestData(method.getName() + ".negativeValue");
        payableAmountCL = testData.getTestData(method.getName() + ".payableAmountCL");
        PayableAmountValue = testData.getTestData(method.getName() + ".PayableAmountValue");
        positiveValue = testData.getTestData(method.getName() + ".positiveValue");
        hasCreditCL = testData.getTestData(method.getName() + ".hasCreditCL");
        creditValue = testData.getTestData(method.getName() + ".creditValue");
        accountNumber = testData.getTestData(method.getName() + ".accountNumber");
        invoiceNumber = testData.getTestData(method.getName() + ".invoiceNumber");
        amountToPay = testData.getTestData(method.getName() + ".amountToPay");
        creditValueFirstSection = testData.getTestData(method.getName() + ".credits");
        selectedMonth = testData.getTestData(method.getName() + ".selectedMonth");
        invoicePeriodValue = testData.getTestData(method.getName() + ".invoicePeriodValue");
        invoicePeriodTitle = testData.getTestData(method.getName() + ".invoicePeriodTitle");
        dueDateTitle = testData.getTestData(method.getName() + ".dueDateTitle");
        dueDateValue = testData.getTestData(method.getName() + ".dueDateValue");
        accountNumberTitle = testData.getTestData(method.getName() + ".accountNumberTitle");
        invoiceNumberTitle = testData.getTestData(method.getName() + ".invoiceNumberTitle");
        cardName = testData.getTestData(method.getName() + ".cardName");
        msisdn = testData.getTestData(method.getName() + ".msisdn");
        connectionPrice = testData.getTestData(method.getName() + ".connectionPrice");
        connectionPriceCL = testData.getTestData(method.getName() + ".connectionPriceCL");
        packagePrice = testData.getTestData(method.getName() + ".packagePrice");
        packagePriceCL = testData.getTestData(method.getName() + ".packagePriceCL");
        connectionPricesSndService = testData.getTestData(method.getName() + ".connectionPricesSndService");
        connectionPricesSndServiceTitle = testData.getTestData(method.getName() + ".connectionPricesSndServiceTitle");
        othersCost = testData.getTestData(method.getName() + ".othersCost");
        othersTitle = testData.getTestData(method.getName() + ".othersTitle");
        creditAmount = testData.getTestData(method.getName() + ".creditAmount");
        creditAmountTitle = testData.getTestData(method.getName() + ".creditAmountTitle");
        accountRelatedItems = testData.getTestData(method.getName() + ".accountRelatedItems");
        accountRelatedItemsTitle = testData.getTestData(method.getName() + ".accountRelatedItemsTitle");
        mobilePayment = testData.getTestData(method.getName() + ".mobilePayment");
        mobilePaymentTitle = testData.getTestData(method.getName() + ".mobilePaymentTitle");
        callNowTransfer = testData.getTestData(method.getName() + ".callNowTransfer");
        callNowTransferTitle = testData.getTestData(method.getName() + ".callNowTransferTitle");
        customerBillName = testData.getTestData(method.getName() + ".customerBillName");
        itemizedBillName = testData.getTestData(method.getName() + ".itemizedBillName");
        requiredColor = testData.getTestData(method.getName() + ".requiredColor");
        numberOfDividerLinesAtFirstSection = testData.getTestData(method.getName() + ".numberOfDividerLinesAtFirstSection");
        numberOfDividerLinesAtSecondSection = testData.getTestData(method.getName() + ".numberOfDividerLinesAtSecondSection");
        creditColorAtTopRight = testData.getTestData(method.getName() + ".creditColorAtTopRight");
        creditLocator = testData.getTestData(method.getName() + ".creditLocator");
        hasCreditClLocator = testData.getTestData(method.getName() + ".hasCreditClLocator");
        hasCreditClColor = testData.getTestData(method.getName() + ".creditColorAtTopRight");
        firstSectionClassNameLocator = testData.getTestData(method.getName() + ".firstSectionClassNameLocator");
        secondSectionClassNameLocator = testData.getTestData(method.getName() + ".secondSectionClassNameLocator");
    }

    @Test(description = "GC01 - Marie user checks invoice detailed view page then downloads itemized bill.")
    @TmsLink("WFCT-13565")
    public void gC01_MarieUserChecksInvoiceSummaryPageThenDownload() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnMonthPresence(selectedMonth);
        invoiceSummary.assertOnAmountToBePaid(amountToPay);
        invoiceSummary.assertOnMeinDatenLink();
        invoiceSummary.assertOnAccountNumberField(accountNumber,accountNumberTitle);
        invoiceSummary.assertOnDueDateField(dueDateTitle,dueDateValue);
        invoiceSummary.assertOnInvoicePeriodField(invoicePeriodValue,invoicePeriodTitle);
        invoiceSummary.assertOnInvoiceNumberField(invoiceNumber,invoiceNumberTitle);
        invoiceSummary.assertOnCardHeaderMSISDNCardNAme(cardName,msisdn);
        invoiceSummary.assertOnConnectionPriceAtTheCard(connectionPrice, connectionPriceCL);
        invoiceSummary.assertOnPackagePriceAtTheCard(packagePrice,packagePriceCL);
        invoiceSummary.assertOnServiceAndConnectionPriceAtTheCard(connectionPricesSndService, connectionPricesSndServiceTitle);
        invoiceSummary.assertOnOthersPriceAtTheCard(othersCost,othersTitle);
        invoiceSummary.assertOnCreditFieldAtTheCard(creditAmount,creditAmountTitle);
        invoiceSummary.assertOnAccountRelatedItemsFieldAtTheCard(accountRelatedItems, accountRelatedItemsTitle);
        invoiceSummary.assertOnMobilePaymentFieldAtTheCard(mobilePayment,mobilePaymentTitle);
        invoiceSummary.assertOnCallNowTransferFieldAtTheCard(callNowTransfer,callNowTransferTitle);
        invoiceSummary.assertOnAmountFromLastMonthAndDisplayedText(positiveValueCL, positiveValue);
        invoiceSummary.assertOnDueAmountAndDisplayedFieldText(payableAmountCL,PayableAmountValue);
        invoiceSummary.assertOnCustomerBillExistance();
        invoiceSummary.assertOnItemizedBillExistance();
    }

    @Test(description = "GC02 - Marie user with credit amount and +ve unpaid amount checks invoice summary page.")
    @TmsLink("WFCT-13566")
    public void gC02_marieUserWithCreditAmountAndPositiveUnnpaidAmountChecksInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnCreditAmountCL();
        invoiceSummary.assertOnGreenColor(creditColorAtTopRight,creditLocator);
        invoiceSummary.assertOnMonthPresence(selectedMonth);
        invoiceSummary.assertOnAmountToBePaid(amountToPay);
        invoiceSummary.assertOnMeinDatenLink();
        invoiceSummary.assertOnAccountNumberField(accountNumber,accountNumberTitle);
        invoiceSummary.assertOnDueDateField(dueDateTitle,dueDateValue);
        invoiceSummary.assertOnInvoicePeriodField(invoicePeriodValue,invoicePeriodTitle);
        invoiceSummary.assertOnInvoiceNumberField(invoiceNumber,invoiceNumberTitle);
        invoiceSummary.assertOnCardHeaderMSISDNCardNAme(cardName,msisdn);
        invoiceSummary.assertOnConnectionPriceAtTheCard(connectionPrice,connectionPriceCL);
        invoiceSummary.assertOnPackagePriceAtTheCard(packagePrice,packagePriceCL);
        invoiceSummary.assertOnServiceAndConnectionPriceAtTheCard(connectionPricesSndService, connectionPricesSndServiceTitle);
        invoiceSummary.assertOnOthersPriceAtTheCard(othersCost,othersTitle);
        invoiceSummary.assertOnCreditFieldAtTheCard(creditAmount,creditAmountTitle);
        invoiceSummary.assertOnAccountRelatedItemsFieldAtTheCard(accountRelatedItems, accountRelatedItemsTitle);
        invoiceSummary.assertOnMobilePaymentFieldAtTheCard(mobilePayment,mobilePaymentTitle);
        invoiceSummary.assertOnCallNowTransferFieldAtTheCard(callNowTransfer,callNowTransferTitle);
        invoiceSummary.assertOnAmountFromLastMonthAndDisplayedText(positiveValueCL, positiveValue);
        invoiceSummary.assertOnPayableAMountAndCLForCredit(hasCreditCL, creditValue);
        invoiceSummary.assertOnGreenColor(hasCreditClColor,hasCreditClLocator);
        invoiceSummary.assertOnItemizedBillExistance();
        invoiceSummary.assertOnCustomerBillExistance();
    }

    @Test(description = "GC03 - Marie user with not retrieved customer bill PDF checks invoice summary page.")
    @TmsLink("WFCT-13575")
    public void gC03_marieUserWithNotRetrievedCustomerBillPDFChecksInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnMonthPresence(selectedMonth);
        invoiceSummary.assertOnAmountToBePaid(amountToPay);
        invoiceSummary.assertOnMeinDatenLink();
        invoiceSummary.assertOnCardHeaderMSISDNCardNAme(cardName,msisdn);
        invoiceSummary.assertOnConnectionPriceAtTheCard(connectionPrice,connectionPriceCL);
        invoiceSummary.assertOnPackagePriceAtTheCard(packagePrice,packagePriceCL);
        invoiceSummary.assertOnServiceAndConnectionPriceAtTheCard(connectionPricesSndService, connectionPricesSndServiceTitle);
        invoiceSummary.assertOnOthersPriceAtTheCard(othersCost,othersTitle);
        invoiceSummary.assertOnCreditFieldAtTheCard(creditAmount,creditAmountTitle);
        invoiceSummary.assertOnAccountRelatedItemsFieldAtTheCard(accountRelatedItems, accountRelatedItemsTitle);
        invoiceSummary.assertOnMobilePaymentFieldAtTheCard(mobilePayment,mobilePaymentTitle);
        invoiceSummary.assertOnCallNowTransferFieldAtTheCard(callNowTransfer,callNowTransferTitle);
        invoiceSummary.assertOnAmountFromLastMonthAndDisplayedText(negativeValueCL,negativeValue);
        invoiceSummary.assertThatItemizedBillExist();
        invoiceSummary.assertThatCustomerBillDoesNotExist();
    }

    @Test(description = "GC04 - Marie user with not retrieved itemized bill& customer bill PDFs checks invoice summary page.")
    @TmsLink("WFCT-13576")
    public void gC04_MarieUserWithNotRetrievedItemizedBillAndCustomerBillPDFsChecksInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnMonthPresence(selectedMonth);
        invoiceSummary.assertOnAmountToBePaid(amountToPay);
        invoiceSummary.assertOnMeinDatenLink();
        invoiceSummary.assertOnCardHeaderMSISDNCardNAme(cardName,msisdn);
        invoiceSummary.assertOnAccountRelatedFieldDoesNotExist();
        invoiceSummary.assertOnCallTransferFieldDoesNotExist();
        invoiceSummary.assertOnAmountFromLastMonthAndDisplayedText(positiveValueCL,positiveValue);
        invoiceSummary.assertOnNumberOfDividerLines(numberOfDividerLinesAtFirstSection, firstSectionClassNameLocator);
        invoiceSummary.assertOnNumberOfDividerLines(numberOfDividerLinesAtSecondSection, secondSectionClassNameLocator);
        invoiceSummary.assertOnCustomerBillExistance();
        invoiceSummary.assertThatItemizedBillDoesNotExists();
    }

    @Test(description = "GC05 - Marie user checks invoice summary page then fails to download itemized bill& customer bill PDFs.")
    @TmsLink("WFCT-13577")
    @Issue("WFCT-14719")
    public void gC05_MarieUserChecksInvoiceSummaryPageThenFailsToDownloadItemizedBillAndCustomerBillPDFs() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnCardHeaderMSISDNCardNAme(cardName,msisdn);
        invoiceSummary.assertOnConnectionPriceFieldDoesNotExist();
        invoiceSummary.assertOnAccountRelatedFieldDoesNotExist();
        invoiceSummary.assertOnNumberOfDividerLines(numberOfDividerLinesAtFirstSection, firstSectionClassNameLocator);
        invoiceSummary.assertOnNumberOfDividerLines(numberOfDividerLinesAtSecondSection, secondSectionClassNameLocator);
        invoiceSummary.downloadItemizedBill();
        invoiceSummary.assertOnErrorNotificationTitle();
        invoiceSummary.assertOnErrorNotificationBody();
    }

    @Test(description = "GC06 - Marie user fails to view invoice summary page (service failure).")
    @TmsLink("WFCT-13578")
    public void gC06_MarieUserFailsToViewInvoiceSummaryPage_ServiceFailure() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnErrorNotificationHeadline();
        invoiceSummary.assertOnErrorBody();
        invoiceSummary.assertOnTheErrorMessageColor(requiredColor);
    }

    @Test(description = "GC07 - Marie user with not returned Invoice number checks invoice summary page.")
    @TmsLink("WFCT-13579")
    public void gC07_marieUserWithNotReturnedInoviceNumberChecksInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertThatInvoiceNumberComponentNotReturned();
        invoiceSummary.assertOnCardHeaderMSISDNCardNAme(cardName,msisdn);
    }




    @Test(description = "GC13 - Marie user with not returned bill details link checks entry points to invoice summary page")
    @TmsLink("WFCT-13628")
    public void gC13_MarieUserWithNotReturnedBillDetailsLinkChecksEntryPointToInvoiceSummaryPage() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertThatDetailsBtnDoesNotExist();
    }

}
