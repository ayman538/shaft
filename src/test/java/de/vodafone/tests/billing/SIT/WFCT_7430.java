package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-7430")

public class WFCT_7430 extends SIT_BillingSetup {
    String contract_number;
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
    String tax19Value;
    String invoiceAmount;
    String unPaidAmount;



    @BeforeMethod
    public void testDataSetup(Method method) {
        detailsPageOrder = testData.getTestData(method.getName() + ".detailsPageOrder");
        amountValue = testData.getTestData(method.getName() + ".amountValue");
        accountNum = testData.getTestData(method.getName() + ".accountNum");
        dueDate = testData.getTestData(method.getName() + ".dueDate");
        invDate = testData.getTestData(method.getName() + ".invDate");
        invNum = testData.getTestData(method.getName() + ".invNum");
        usageValue = testData.getTestData(method.getName() + ".usageValue");
        oneTimeValue = testData.getTestData(method.getName() + ".oneTimeValue");
        subTotalValue = testData.getTestData(method.getName() + ".subTotalValue");
        invoiceAmount = testData.getTestData(method.getName() + ".invoiceAmount");
        unPaidAmount = testData.getTestData(method.getName() + ".unPaidAmount");
        tax19Value = testData.getTestData(method.getName() + ".tax19Value");
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);

    }

    @Test(description = "WFCT-7430 | SIT | GC01 - Ute user checks his invoice details from the bills chart - 'Details' hyperlink")
    @TmsLink("WFCT-10562")
    public void GC01_UteChecksHisInvoiceDetailsFromTheBillsChart(){
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickDetailsPage(detailsPageOrder);
        invoiceSummary.assertOnTheInvoiceSummaryGeneralComponents();
        invoiceSummary.assertOnAmountValue(amountValue);
        invoiceSummary.assertOnUsageValue(usageValue);
        invoiceSummary.assertOnOneTimeValue(oneTimeValue);
        invoiceSummary.assertOnSubTotalValue(subTotalValue);
        invoiceSummary.assertOnInvoiceAmount(invoiceAmount);
        //        invoiceSummary.assertOnTheUnPaidAmount(unPaidAmount); todo (this method is commented because there is fast track US will override it till this API is fixed then will be enabled again)
    }
}
