package de.vodafone.tests.billing.ST;


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
@Feature("ST")
@Story("WFCT-11488")

public class WFCT_11488 extends ST_BillingSetup {

    Dashboard dashboard;
    InvoiceSummary invoiceSummary;
    Rechnungen rechnungen;
    String firstValueAtTable,amountToBePaid,underlineAndColorCssProperty, firstRow;

    @Test(description = "GC01 - Marie with credit checks entry point to invoice summary page through rechnungen table.")
    @TmsLink("WFCT-14008")
    public void GC01_MarieWithCreditChecksEntryPointToInvoiceSummaryThroughRechnungenTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnThatFirstAmountValue(firstValueAtTable);
        rechnungen.asssertThatAmountAtTheTableIsUnderlined(underlineAndColorCssProperty);
        rechnungen.assertThatTheAmountTextColorIsGreen(firstRow);
        rechnungen.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnAmountToBePaid(amountToBePaid);
        invoiceSummary.clickOnInvoiceSummaryBackPageBackButton();
        rechnungen.assertThatUserNavigatedToRechnungen();
    }

    @Test(description = "GC02 - Bart user with zero amount checks entry point to invoice summary page through rechnungen table.")
    @TmsLink("WFCT-14009")
    public void GC02_BartWithZeroAmountChecksEntryPointToInvoiceSummaryThroughRechnungenTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnThatFirstAmountValue(firstValueAtTable);
        rechnungen.asssertThatAmountAtTheTableIsUnderlined(underlineAndColorCssProperty);
        rechnungen.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnAmountToBePaid(amountToBePaid);
        invoiceSummary.clickOnInvoiceSummaryBackPageBackButton();

    }

    @Test(description = "GC03 - Kay checks entry point to invoice summary page through rechnungen table.")
    @TmsLink("WFCT-14010")
    public void GC03_KayChecksEntryPointToInvoiceSummaryThroughRechnungenTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnThatFirstAmountValue(firstValueAtTable);
        rechnungen.asssertThatAmountAtTheTableIsUnderlined(underlineAndColorCssProperty);
        rechnungen.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnAmountToBePaid(amountToBePaid);
        invoiceSummary.clickOnInvoiceSummaryBackPageBackButton();

    }

    @Test(description = "GC04 - Marie with not retrieved amount at rechnungen table checks entry point to invoice summary page")
    @TmsLink("WFCT-14011")
    public void GC04_MarieWithNotRetrievedAmountChecksEntryPointToInvoiceSummaryThroughRechnungenTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnThatFirstAmountValue(firstValueAtTable);
        rechnungen.clickOnFirstAmountAtTable();

    }

    @Test(description = "GC05 - Kay with no bills checks entry point to invoice summary page.")
    @TmsLink("WFCT-14012")
    public void GC05_KayWithNoBillsChecksEntryPointToInvoiceSummaryThroughRechnungenTable() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnThatFirstAmountValue(firstValueAtTable);
        rechnungen.clickOnFirstAmountAtTable();

    }
    @BeforeMethod
    public void testDataSetup(Method method) {
        dashboard = new Dashboard(driver);
        invoiceSummary = new InvoiceSummary(driver);
        rechnungen = new Rechnungen(driver);
        firstValueAtTable = testData.getTestData(method.getName() + ".firstAmountValue");
        amountToBePaid = testData.getTestData(method.getName() + ".amountToBePaid");
        underlineAndColorCssProperty = testData.getTestData(method.getName() + ".underlineAndColorCssProperty");
        firstRow = testData.getTestData(method.getName() + ".firstRaw");
    }
}