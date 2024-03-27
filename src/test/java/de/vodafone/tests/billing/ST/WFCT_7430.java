package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_7430 extends ST_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String detailsPageOrder;
    String amountValue;
    String accountNum;
    String dueDate;
    String invDate;
    String invNum;
    String usageValue;
    String oneTimeValue;
    String subTotalValue;
    String tax16Value;
    String invoiceAmount;
    String unPaidAmount;
    String amountToPay;
    String basisPriceValue;
    String tax19Value;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        detailsPageOrder = testData.getTestData(method.getName() + ".detailsPageOrder");
        amountValue = testData.getTestData(method.getName() + ".amountValue");
        accountNum = testData.getTestData(method.getName() + ".accountNum");
        dueDate = testData.getTestData(method.getName() + ".dueDate");
        invDate = testData.getTestData(method.getName() + ".invDate");
        invNum = testData.getTestData(method.getName() + ".invNum");
        usageValue = testData.getTestData(method.getName() + ".usageValue");
        oneTimeValue = testData.getTestData(method.getName() + ".oneTimeValue");
        subTotalValue = testData.getTestData(method.getName() + ".subTotalValue");
        tax16Value = testData.getTestData(method.getName() + ".tax16Value");
        invoiceAmount = testData.getTestData(method.getName() + ".invoiceAmount");
        unPaidAmount = testData.getTestData(method.getName() + ".unPaidAmount");
        amountToPay = testData.getTestData(method.getName() + ".amountToPay");
        basisPriceValue = testData.getTestData(method.getName() + ".basisPriceValue");
        tax19Value = testData.getTestData(method.getName() + ".tax19Value");
    }

    @Test(description = "ST | GC01 - Ute user checks his invoice details from the bills chart - Details hyperlink")
    @TmsLink("WFCT-10559")
    public void GC01_UteUserChecksTheInvoiceDetailsPage(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickDetailsPage(detailsPageOrder);
        invoiceSummary.assertOnTheInvoiceSummaryGeneralComponents();
        invoiceSummary.assertOnAmountValue(amountValue);
        invoiceSummary.assertOnAccNumValue(accountNum);
        invoiceSummary.assertOnDueDateValue(dueDate);
        invoiceSummary.assertOnTheInvDate(invDate);
        invoiceSummary.assertOnTheInvoiceNumber(invNum);
        invoiceSummary.assertOnUsageValue(usageValue);
        invoiceSummary.assertOnOneTimeValue(oneTimeValue);
        invoiceSummary.assertOnSubTotalValue(subTotalValue);
        invoiceSummary.assertOnTax16Value(tax16Value);
        invoiceSummary.assertOnInvoiceAmount(invoiceAmount);
//        invoiceSummary.assertOnTheUnPaidAmount(unPaidAmount); todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
        invoiceSummary.assertThatBasisPriceNotExists();
        invoiceSummary.assertOnUsageValueLabel();
        invoiceSummary.assertOnOneTimeValueLabel();
        invoiceSummary.assertOnSubTotalLabel();
        invoiceSummary.assertOnTax16Label();
        invoiceSummary.asserThat19TaxLabelNotExists();
        invoiceSummary.assertOnInvoiceAmountLabel();
        //        invoiceSummary.assertOnUnPaidAmountLabel();  todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
    }

    @Test(description = "ST - GC02- - Ute user with credit amount checks the details summary page from bill table")
    @TmsLink("WFCT-10560")
    public void GC02_UteUserWithCreditChecksTheDetailsSummaryPage(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickDetailsPage(detailsPageOrder);
        invoiceSummary.assertOnTheInvoiceSummaryGeneralComponents();
        invoiceSummary.assertOnAmountValue(amountValue);
        invoiceSummary.assertOnCreditLabel();
        invoiceSummary.assertOnAccNumValue(accountNum);
        invoiceSummary.assertOnDueDateValue(dueDate);
        invoiceSummary.assertOnTheInvDate(invDate);
        invoiceSummary.assertOnTheInvoiceNumber(invNum);
        invoiceSummary.assertOnBasisPriceValue(basisPriceValue);
        invoiceSummary.assertOnUsageValue(usageValue);
        invoiceSummary.assertOnOneTimeValue(oneTimeValue);
        invoiceSummary.assertOnSubTotalValue(subTotalValue);
        invoiceSummary.assertOnTax16Value(tax16Value);
        invoiceSummary.assertOnTax19Value(tax19Value);
        invoiceSummary.assertOnInvoiceAmount(invoiceAmount);
//        invoiceSummary.assertOnTheUnPaidAmount(unPaidAmount); todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
        invoiceSummary.assertOnNegativeAmountToPay(amountToPay);
        invoiceSummary.assertOnBasisPriceLabel();
        invoiceSummary.assertOnUsageValueLabel();
        invoiceSummary.assertOnOneTimeValueLabel();
        invoiceSummary.assertOnSubTotalLabel();
        invoiceSummary.assertOnTax16Label();
        invoiceSummary.assertOnTax19Label();
        invoiceSummary.assertOnInvoiceAmountLabel();
//        invoiceSummary.assertOnNegativeUnPaidAmountLabel();todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
//        invoiceSummary.assertOnNegativeAmountToPayLabel();todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
    }


    @Test(description = "ST | GC03 - Ute user with positive unpaid amount checks the details summary page and the spinner")
    @TmsLink("WFCT-10561")
    public void GC03_UteUserWithPositiveUnPaidAmountChecksDetailsSummaryPage(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickDetailsPage(detailsPageOrder);
        invoiceSummary.assertOnTheInvoiceSummaryGeneralComponents();
        invoiceSummary.assertOnAmountValue(amountValue);
        invoiceSummary.assertOnAccNumValue(accountNum);
        invoiceSummary.assertOnDueDateValue(dueDate);
        invoiceSummary.assertOnTheInvDate(invDate);
        invoiceSummary.assertOnTheInvoiceNumber(invNum);
        invoiceSummary.assertOnBasisPriceValue(basisPriceValue);
        invoiceSummary.assertOnOneTimeValue(oneTimeValue);
        invoiceSummary.assertOnSubTotalValue(subTotalValue);
        invoiceSummary.assertOnTax16Value(tax16Value);
        invoiceSummary.assertOnTax19Value(tax19Value);
        invoiceSummary.assertOnInvoiceAmount(invoiceAmount);
//        invoiceSummary.assertOnTheUnPaidAmount(unPaidAmount); todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
        invoiceSummary.assertOnAmountToPay(amountToPay);
        invoiceSummary.assertOnBasisPriceLabel();
        invoiceSummary.assertOnUsageValueLabel();
        invoiceSummary.assertOnOneTimeValueLabel();
        invoiceSummary.assertOnSubTotalLabel();
        invoiceSummary.assertOnTax16Label();
        invoiceSummary.assertOnTax19Label();
        invoiceSummary.assertOnInvoiceAmountLabel();
//        invoiceSummary.assertOnUnPaidAmountLabel();  todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
        invoiceSummary.assertOnAmountToPayLabel();
    }

}
