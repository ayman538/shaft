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
@Story("WFCT-13612")
public class WFCT_13612 extends SIT_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;
    InvoiceSummary invoiceSummary;
    String msisdn,showLessText, underlineCssProperty, blueColor,oneCollapsedCard,contractOrder;


    @BeforeMethod
    public void testDataSetup(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        invoiceSummary = new InvoiceSummary(driver);
        msisdn = testData.getTestData(method.getName() + ".msisdn");
        showLessText = testData.getTestData(method.getName() + ".showLessText");
        underlineCssProperty = testData.getTestData(method.getName() + ".underlineAndColorCssProperty");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        blueColor = testData.getTestData(method.getName() + ".blueBoxColor");
        oneCollapsedCard = testData.getTestData(method.getName() + ".oneCollapsedCard");

    }

    @Test(description = "GC01- Kay user checks entry point for invoice summary page then checks cost overview page.")
    @TmsLink("WFCT-13702")
    public void gC01_KayChecksEntryPointForInvoiceSummaryViaKostenubersicht() {
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.asssertThatAmountAtTheTableIsUnderlined(underlineCssProperty);
        kostenubersicht.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnNumberofCollapsedCards(oneCollapsedCard);
        invoiceSummary.assertThatSameMsisdnAppearsAtFirstCard(msisdn);
        invoiceSummary.assertThatCardExpandedAndOnShowLess(showLessText);
        invoiceSummary.clickOnBackButton();
        kostenubersicht.assertThatUserNavigatedBackToCostOverviewPageWithWait();
    }


    @Test(description = "GC06- Kay with 5 subscribers checks entry point for invoice summary page then checks cost overview page.")
    @TmsLink("WFCT-14077")
    public void gC06_KayWith5SubscribertsChecksInvoiceSummaryPageAndTheirEntryPoint() {
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.asssertThatAmountAtTheTableIsUnderlined(underlineCssProperty);
        kostenubersicht.clickOnFirstAmountAtTable();
        kostenubersicht.assertOnNotificationColor(blueColor);
        invoiceSummary.assertThatCardExpandedAndOnShowLess(showLessText);
        invoiceSummary.clickOnBackButton();
        kostenubersicht.assertThatUserNavigatedBackToCostOverviewPageWithWait();
    }

}