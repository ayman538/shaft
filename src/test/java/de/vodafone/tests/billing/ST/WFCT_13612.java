package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-13612")
public class WFCT_13612 extends ST_BillingSetup{
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;
    InvoiceSummary invoiceSummary;
    String msisdn,showLessText, underlineCssProperty, blueColor,oneCollapsedCard,notUnderlineAndColorCssProperty
            ,oneExpandedCard,nameAndMSISDN;

    @BeforeMethod
    public void testDataSetup(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        invoiceSummary = new InvoiceSummary(driver);
        msisdn = testData.getTestData(method.getName() + ".msisdn");
        showLessText = testData.getTestData(method.getName() + ".showLessText");
        underlineCssProperty = testData.getTestData(method.getName() + ".underlineAndColorCssProperty");
        blueColor = testData.getTestData(method.getName() + ".blueBoxColor");
        oneCollapsedCard = testData.getTestData(method.getName() + ".oneCollapsedCard");
        notUnderlineAndColorCssProperty = testData.getTestData(method.getName() + ".notUnderlineAndColorCssProperty");
        oneExpandedCard = testData.getTestData(method.getName() + ".oneExpandedCard");
        nameAndMSISDN = testData.getTestData(method.getName() + ".nameAndMSISDN");
    }

    @Test(description = "GC01- Kay user checks entry point for invoice summary page then checks cost overview page.")
    @TmsLink("WFCT-13702")
    public void gC01_KayChecksEntryPointForInvoiceSummaryViaKostenubersicht() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.asssertThatAmountAtTheTableIsUnderlined(underlineCssProperty);
        kostenubersicht.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnNumberofExpandedCards(oneExpandedCard);
        invoiceSummary.assertOnNumberofCollapsedCards(oneCollapsedCard);
        invoiceSummary.assertThatSameMsisdnAppearsAtFirstCard(msisdn);
        invoiceSummary.assertThatCardExpandedAndOnShowLess(showLessText);
        invoiceSummary.clickOnBackButton();
        kostenubersicht.assertThatKostenubersichtPageIsLoaded();
    }

    @Test(description = "GC02 - Bart user with not returned amount at cost overview page")
    @TmsLink("WFCT-13703")
    public void gC02_BartWithNotReturnedAmountAtKostenubersichtTableChecksInvoiceSummaryEntryPoint() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnFirstAmountAtTableColorAndItsNotUnderlined(notUnderlineAndColorCssProperty);
        kostenubersicht.asssertOnAmountNotReturnedText();
        kostenubersicht.clickOnNotReturnedAmountText();
        kostenubersicht.assertThatKostenubersichtPageIsLoaded();
    }

    @Test(description = "GC03 - Kay with not returned bill link checks entry point to invoice summary page")
    @TmsLink("WFCT-14024")
    public void gC03_KayWitNotReturnedBillAtKostenubersichtTableChecksChecksInvoiceSummaryEntryPoint() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnFirstAmountAtTableColorAndItsNotUnderlined(notUnderlineAndColorCssProperty);
        kostenubersicht.clickOnFirstAmountAtTheTable();
        kostenubersicht.assertThatKostenubersichtPageIsLoaded();
    }

    @Test(description = "GC04 - Bart with zero bill amount checks entry point to invoice summary page")
    @TmsLink("WFCT-14025")
    public void gC04_BartWithZeroAmountChecksInvoiceSummaryPageEntryPoint() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.asssertThatAmountAtTheTableIsUnderlined(underlineCssProperty);
        kostenubersicht.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnErrorNotificationHeadline();
        invoiceSummary.clickOnBackButton();
        kostenubersicht.assertThatKostenubersichtPageIsLoaded();
    }

    @Test(description = "GC05 - Kay with credit checks entry point to invoice summary page")
    @TmsLink("WFCT-14026")
    public void gC05_KayWithCreditAmountChecksInvoiceSummaryPageEntryPoint() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.asssertThatAmountAtTheTableIsUnderlinedWithCredit(underlineCssProperty);
        kostenubersicht.assertThatTheAmountTextColorIsGreen();
        kostenubersicht.clickOnFirstAmountAtTable();
        invoiceSummary.assertOnErrorNotificationHeadline();
        invoiceSummary.clickOnBackButton();
        kostenubersicht.assertThatKostenubersichtPageIsLoaded();
    }

    @Test(description = "GC06- Kay with 5 subscribers checks entry point for invoice summary page then checks cost overview page.")
    @TmsLink("WFCT-14077")
    public void gC06_KayWith5SubscribertsChecksInvoiceSummaryPageAndTheirEntryPoint() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.asssertThatAmountAtTheTableIsUnderlined(underlineCssProperty);
        kostenubersicht.clickOnFirstAmountAtTable();
        kostenubersicht.assertOnNotificationColor(blueColor);
        invoiceSummary.assertOnSameMSISDNAtFilter(nameAndMSISDN);
        invoiceSummary.assertThatCardExpandedAndOnShowLess(showLessText);
        invoiceSummary.clickOnBackButton();
    }

}