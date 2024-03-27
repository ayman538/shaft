package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-11488")

public class WFCT_11488 extends SIT_BillingSetup {
    Dashboard dashboard;
    InvoiceSummary invoiceSummary;
    Rechnungen rechnungen;
    String firstValueAtTable,amountToBePaid,underlineAndColorCssProperty, fifthRow,contractNumber;


    @Test(description = "GC03 - Kay checks entry point to invoice summary page through rechnungen table.")
    @TmsLink("WFCT-14010")
    public void GC03_KayChecksEntryPointToInvoiceSummaryThroughRechnungenTable() {
        dashboard.expandContracts(contractNumber);
        dashboard.clickMeineRechnungenTile(contractNumber);
        rechnungen.asssertThatAmountAtTheTableIsUnderlined(underlineAndColorCssProperty);
        rechnungen.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnAmountToBePaid(amountToBePaid);
        invoiceSummary.clickOnInvoiceSummaryBackPageBackButton();
        rechnungen.assertThatRechnungenPageIsLoaded();
    }


    @BeforeMethod
    public void testDataSetup(Method method) {
        dashboard = new Dashboard(driver);
        invoiceSummary = new InvoiceSummary(driver);
        rechnungen = new Rechnungen(driver);
        firstValueAtTable = testData.getTestData(method.getName() + ".firstAmountValue");
        amountToBePaid = testData.getTestData(method.getName() + ".amountToBePaid");
        contractNumber = testData.getTestData(method.getName() + ".contractNumber");
        underlineAndColorCssProperty = testData.getTestData(method.getName() + ".underlineAndColorCssProperty");
        fifthRow = testData.getTestData(method.getName() + ".fifthRow");
        amountToBePaid = testData.getTestData(method.getName() + ".amountToBePaid");
    }
}