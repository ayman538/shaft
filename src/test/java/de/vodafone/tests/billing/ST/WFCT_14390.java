package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-14390")

public class WFCT_14390 extends ST_BillingSetup {

    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String accountRelatedItemsTitle, accountRelatedItemsValue, notReturnedActivationFeesCL,totalDueAmount,totalDueAmountFieldCL,fieldOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        accountRelatedItemsValue = testData.getTestData(method.getName()+".accountRelatedItemsValue");
        accountRelatedItemsTitle = testData.getTestData(method.getName()+".accountRelatedItemsTitle");
        notReturnedActivationFeesCL = testData.getTestData(method.getName()+".notReturnedCLResponse");
        totalDueAmount = testData.getTestData(method.getName()+".totalDueAmount");
        totalDueAmountFieldCL = testData.getTestData(method.getName()+".totalDueAmountFieldCL");
        fieldOrder = testData.getTestData(method.getName()+".fieldOrder");
    }


    @Test(description = "GC01 - Marie user checks Zu Zahlender Betrag mapping and Kontobezogene Kosten field")
    @TmsLink("WFCT-14470")
    public void GC01_MarieUserChecksZuZahlenderBetragMappingAndKontobezogeneKostenfield() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnAccountRelatedItemsFieldAtTheCard(accountRelatedItemsValue, accountRelatedItemsTitle);
        invoiceSummary.assertOnNotReturnedClFieldOnFirstCardSectionForOneSubscriber(notReturnedActivationFeesCL,fieldOrder);
        invoiceSummary.assertOnDueAmountAndDisplayedFieldText(totalDueAmountFieldCL,totalDueAmount);
    }

    @Test(description = "GC02 - Kay user checks Zu Zahlender Betrag mapping and Kontobezogene Kosten field")
    @TmsLink("WFCT-14471")
    public void GC02_KayUserChecksZuZahlenderBetragMappingAndKontobezogeneKostenfield() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnTheUnderlinedAmount();
        invoiceSummary.clickOnShowMoreButton(fieldOrder);
        invoiceSummary.assertOnAccountRelatedItemsFieldAtTheCard(accountRelatedItemsValue, accountRelatedItemsTitle);
        invoiceSummary.assertOnNotReturnedClFieldOnFirstCardSectionForMoreThanOneSubscriber(notReturnedActivationFeesCL,fieldOrder);
        invoiceSummary.assertOnDueAmountAndDisplayedFieldText(totalDueAmountFieldCL,totalDueAmount);
    }

    @Test(description = "GC03 - Bart user checks Zu Zahlender Betrag mapping and Kontobezogene Kosten field")
    @TmsLink("WFCT-14472")
    public void GC03_BartUserChecksZuZahlenderBetragMappingAndKontobezogeneKostenfield() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.assertOnAccountRelatedItemsFieldAtTheCard(accountRelatedItemsValue, accountRelatedItemsTitle);
        invoiceSummary.assertOnNotReturnedClFieldOnFirstCardSectionForOneSubscriber(notReturnedActivationFeesCL,fieldOrder);
        invoiceSummary.assertOnDueAmountAndDisplayedFieldText(totalDueAmountFieldCL,totalDueAmount);
    }


}
