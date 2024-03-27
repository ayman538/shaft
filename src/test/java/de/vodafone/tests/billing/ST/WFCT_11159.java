package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Verbindungsubersicht;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
@Story("WFCT-11159")

public class WFCT_11159 extends ST_BillingSetup {
    Verbindungsubersicht verbindungsubersicht;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    String totalAmount;
    String phoneNumber;
    String billPeriod;
    String initValue;

    @BeforeMethod
    public void beforeMethod(Method method) {
        verbindungsubersicht = new Verbindungsubersicht(driver);
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        totalAmount = testData.getTestData(method.getName() + ".totalAmount");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        billPeriod = testData.getTestData(method.getName() + ".billPeriod");
        initValue = testData.getTestData(method.getName() + ".initValue");
    }

    @Test(description = "GC01 - Kay user checks the verbindungubersicht tab")
    @TmsLink("WFCT-14465")
    public void GC01_KayUserChecksTheVerbindungubersichtTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnPageTitle()
                .assertOnPageDescription()
                .assertOnTotalAmountValue(totalAmount)
                .assertOnCardDescription()
                .assertOnNumbersFilterLabel()
                .assertOnBillPeriodFilterLabel()
                .assertOnPdfDownloadBtnText()
                .assertOnPdfDownloadBtnColor()
                .assertOnCsvDownloadBtnText()
                .assertOnCsvDownloadBtnColor()
                .assertOnFaqSectionTitle();
    }

    @Test(description = "GC02 - Bart user checks numbers filter")
    @TmsLink("WFCT-14473")
    public void GC02_BartUserChecksNumbersFilter() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.selectNumberFromFilter(phoneNumber)
                .waitForAmountToBeChanged(initValue)
                .assertOnTotalAmountValue(totalAmount);
    }

    @Test(description = "GC03 - kay user checks bill period filter")
    @TmsLink("WFCT-14474")
    public void GC03_KayUserChecksBillPeriodFilter() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.selectBillPeriodFromFilter(billPeriod)
                .waitForAmountToBeChanged(initValue)
                .assertOnTotalAmountValue(totalAmount);
    }

    @Test(description = "GC04 - bart user checks the PDF download")
    @TmsLink("WFCT-14475")
    public void GC04_BartUserChecksThePdfDownload() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.downloadPDF();
    }

    @Test(description = "GC05 - kay user checks CSV download")
    @TmsLink("WFCT-14481")
    public void GC05_KayUserChecksCsvDownload() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.downloadCSV();
    }

    @Test(description = "GC06 - bart user checks using both filters togther")
    @TmsLink("WFCT-14489")
    public void GC06_BartUserChecksUsingBothFiltersTogther() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.selectNumberFromFilter(phoneNumber)
                .selectBillPeriodFromFilter(billPeriod)
                .waitForAmountToBeChanged(initValue)
                .assertOnTotalAmountValue(totalAmount);

    }

    @Test(description = "GC07 - kay user checks the FAQ section",enabled = false)
    @TmsLink("WFCT-14489")
    public void GC07_KayUserChecksTheFaqSection() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.expandFirstAccordion()
                .assertOnFirstAccordionTitle()
                .assertOnFirstAccordionContent()
                .expandSecondAccordion()
                .assertThatFirstFaqAccordionCollapsed()
                .assertOnSecondAccordionTitle()
                .assertOnSecondAccordionContent()
                .expandFirstAccordion()
                .assertThatSecondFaqAccordionCollapsed();
    }


}
