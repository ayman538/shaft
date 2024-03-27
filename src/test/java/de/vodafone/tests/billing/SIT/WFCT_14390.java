package de.vodafone.tests.billing.SIT;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-14390")

public class WFCT_14390 extends SIT_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String totalDueAmount,totalDueAmountFieldCL,firstOrder,latestDetails;


    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        totalDueAmount = testData.getTestData(method.getName()+".totalDueAmount");
        totalDueAmountFieldCL = testData.getTestData(method.getName()+".totalDueAmountFieldCL");
        firstOrder = testData.getTestData(method.getName()+".fieldOrder");
        latestDetails = testData.getTestData(method.getName()+".latestDetails");
    }

    @Test(description = "GC01 - Marie user checks Zu Zahlender Betrag mapping and Kontobezogene Kosten field")
    @TmsLink("WFCT-14470")
    public void GC01_MarieUserChecksZuZahlenderBetragMappingAndKontobezogeneKostenfield() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnLatestDetailsAtBillChartSIT(latestDetails);
        invoiceSummary.assertOnDueAmountAndDisplayedFieldText(totalDueAmountFieldCL,totalDueAmount);
    }

    @Test(description = "GC02 - Kay user checks Zu Zahlender Betrag mapping and Kontobezogene Kosten field")
    @TmsLink("WFCT-14471")
    public void GC02_KayUserChecksZuZahlenderBetragMappingAndKontobezogeneKostenfield() {
        dashboard.expandContracts(firstOrder);
        dashboard.clickMeineRechnungenTile(firstOrder);
        rechnungen.clickOnLatestDetailsAtBillChartSIT(latestDetails);
        invoiceSummary.assertOnDueAmountAndDisplayedFieldText(totalDueAmountFieldCL,totalDueAmount);
    }
}
