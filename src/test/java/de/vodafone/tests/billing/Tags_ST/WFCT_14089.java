package de.vodafone.tests.billing.Tags_ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.Rechnungen;
import de.vodafone.pages.commons.MeineDokumentePage;
import de.vodafone.pages.commons.Tags;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-14089")


public class WFCT_14089 extends ST_TagsSetup {
    Kostenubersicht kostenubersicht;
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    MeineDokumentePage meineDokumentePage;
    Tags tags;
    String firstCustomerBill, clickTagName, clickTagContentForPreviewCustomerBill, downloadTagName,
            downloadTagContentForPreviewCustomerBill,clickTagContentForDownloadCustomerBill,
            downloadTagContentForDownloadCustomerBill
            ,secondItemizedBill,clickTagContentForPreviewItemizedBill,downloadTagContentForPreviewItemizedBill
            ,clickTagContentForDownloadItemizedBill,firstBill,downloadTagContentForDownloadItemizedBill
            ,clickTagContentForPreviewSubscriberBill,downloadTagContentForPreviewSubscriberBill
            ,clickTagContentForDownloadSubscriberBill,downloadTagContentForDownloadSubscriberBill
            ,clickTagContentForPreviewDynamicBill,downloadTagContentForPreviewDynamicBill
            ,downloadTagContentForDownloadBill,clickTagContentForDownloadBill,secondBill,thirdBill;



    @BeforeMethod
    public void beforeMethod(Method method) {
        kostenubersicht = new Kostenubersicht(driver);
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        meineDokumentePage = new MeineDokumentePage(driver);
        tags = new Tags(driver);
        clickTagName =testData.getTestData(method.getName()+".clickTagName");
        clickTagContentForPreviewCustomerBill =testData.getTestData(method.getName()+".clickTagContentForPreviewCustomerBill");
        downloadTagName =testData.getTestData(method.getName()+".downloadTagName");
        downloadTagContentForPreviewCustomerBill =testData.getTestData(method.getName()+".downloadTagContentForPreviewCustomerBill");
        firstCustomerBill =testData.getTestData(method.getName()+".billRowOrder");
        firstBill =testData.getTestData(method.getName()+".billRowOrder");
        clickTagContentForDownloadCustomerBill =testData.getTestData(method.getName()+".clickTagContentForDownloadCustomerBill");
        downloadTagContentForDownloadCustomerBill =testData.getTestData(method.getName()+".downloadTagContentForDownloadCustomerBill");
        secondItemizedBill = testData.getTestData(method.getName()+".secondItemizedBill");
        clickTagContentForPreviewItemizedBill = testData.getTestData(method.getName()+".clickTagContentForPreviewItemizedBill");
        downloadTagContentForPreviewItemizedBill = testData.getTestData(method.getName()+".downloadTagContentForPreviewItemizedBill");
        clickTagContentForDownloadItemizedBill = testData.getTestData(method.getName()+".clickTagContentForDownloadItemizedBill");
        downloadTagContentForDownloadItemizedBill = testData.getTestData(method.getName()+".downloadTagContentForDownloadItemizedBill");
        clickTagContentForPreviewSubscriberBill= testData.getTestData(method.getName()+".clickTagContentForPreviewSubscriberBill");
        downloadTagContentForPreviewSubscriberBill = testData.getTestData(method.getName()+".downloadTagContentForPreviewSubscriberBill");
        clickTagContentForDownloadSubscriberBill = testData.getTestData(method.getName()+".clickTagContentForDownloadSubscriberBill");
        downloadTagContentForDownloadSubscriberBill = testData.getTestData(method.getName()+".downloadTagContentForDownloadSubscriberBill");
        clickTagContentForPreviewDynamicBill = testData.getTestData(method.getName()+".clickTagContentForPreviewDynamicBill");
        downloadTagContentForPreviewDynamicBill = testData.getTestData(method.getName()+".downloadTagContentForPreviewDynamicBill");
        clickTagContentForDownloadBill = testData.getTestData(method.getName()+".clickTagContentForDownloadBill");
        downloadTagContentForDownloadBill = testData.getTestData(method.getName()+".downloadTagContentForDownloadBill");
        secondBill = testData.getTestData(method.getName()+".secondBill");
        thirdBill = testData.getTestData(method.getName()+".thirdBill");

    }


    @Test(description = "GC03 - Ute user downloads/previews bills at rechnung tab then checks tracking",enabled = false )
    @TmsLink("WFCT-13740")
    public void GC03_UteDownloadsAndPreviewsCustomerBillAtRechnungTabChecksTracking() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnPreviewCustomerBillByOrder(firstCustomerBill);
        rechnungen.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewCustomerBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewCustomerBill);
        rechnungen.clickOnExitPreviewingBill();
        rechnungen.clickOnPreviewItemizedBillByOrder(secondItemizedBill);
        rechnungen.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewItemizedBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewItemizedBill);
        rechnungen.clickOnExitPreviewingBill();
        tags.downloadBillWithoutFrames(rechnungen.getDownloadCustomerBillLocator(firstCustomerBill));
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadCustomerBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadCustomerBill);
        tags.downloadBillWithoutFrames(rechnungen.getDownloadItemizedBillLocator(secondBill));
        tags.assertOnCompleteTag(clickTagName,clickTagContentForDownloadItemizedBill );
        tags.assertOnCompleteTag(downloadTagName,downloadTagContentForDownloadItemizedBill );

    }

    @Test(description = "GC04 - Marie user downloads/previews bills at rechnung tab then checks tracking",enabled = false )
    @TmsLink("WFCT-13741")
    public void GC04_MarieDownloadsAndPreviewsBillsAtRechnungTabChecksTracking() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnPreviewCustomerBillByOrder(firstCustomerBill);
        rechnungen.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewCustomerBill);
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewCustomerBill);
        rechnungen.clickOnExitPreviewingBill();
        rechnungen.clickOnPreviewItemizedBillByOrder(secondItemizedBill);
        rechnungen.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewItemizedBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewItemizedBill);
        rechnungen.clickOnExitPreviewingBill();
        tags.downloadBillWithoutFrames(rechnungen.getDownloadCustomerBillLocator(firstCustomerBill));
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadCustomerBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadCustomerBill);
        tags.downloadBillWithoutFrames(rechnungen.getDownloadItemizedBillLocator(secondBill));
        tags.assertOnCompleteTag(clickTagName,clickTagContentForDownloadItemizedBill );
        tags.assertOnCompleteTag(downloadTagName,downloadTagContentForDownloadItemizedBill );

    }

    @Test(description = "GC05 - Martin user downloads/previews bills at rechnung tab then checks tracking",enabled = false )
    @TmsLink("WFCT-13742")
    public void GC05_MatrinDownloadsAndPreviewsBillsAtRechnungTabChecksTracking() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnPreviewCustomerBillByOrder(firstCustomerBill);
        rechnungen.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewCustomerBill);
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewCustomerBill);
        rechnungen.clickOnExitPreviewingBill();
        rechnungen.clickOnPreviewItemizedBillByOrder(secondItemizedBill);
        rechnungen.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewItemizedBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewItemizedBill);
        rechnungen.clickOnExitPreviewingBill();
        tags.downloadBillWithoutFrames(rechnungen.getDownloadCustomerBillLocator(firstCustomerBill));
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadCustomerBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadCustomerBill);
        tags.downloadBillWithoutFrames(rechnungen.getDownloadItemizedBillLocator(secondBill));
        tags.assertOnCompleteTag(clickTagName,clickTagContentForDownloadItemizedBill );
        tags.assertOnCompleteTag(downloadTagName,downloadTagContentForDownloadItemizedBill );

    }

    @Test(description = "GC06 - Kay user downloads/previews bills at cost overview tab then checks tracking" ,enabled = false)
    @TmsLink("WFCT-13744")
    public void GC06_KayDownloadsAndPreviewsBillsAtCostOverViewTabChecksTracking() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnCostOverView();
        kostenubersicht.clickOnPreviewSubscriberBillByOrder(firstCustomerBill);
        kostenubersicht.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewSubscriberBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewSubscriberBill);
        rechnungen.clickOnExitPreviewingBill();
        kostenubersicht.clickOnPreviewItemizedBillByOrder(secondItemizedBill);
        kostenubersicht.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewItemizedBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewItemizedBill);
        rechnungen.clickOnExitPreviewingBill();
        tags.downloadBillWithoutFrames(kostenubersicht.getDownloadBillLocator(firstCustomerBill));
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadSubscriberBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadSubscriberBill);
        tags.downloadBillWithoutFrames(kostenubersicht.getDownloadBillLocator(secondBill));
        tags.assertOnCompleteTag(clickTagName,clickTagContentForDownloadItemizedBill );
        tags.assertOnCompleteTag(downloadTagName,downloadTagContentForDownloadItemizedBill );
    }

    @Test(description = "GC07 - Peter user downloads/previews download bills at cost overview tab then checks tracking" ,enabled = false)
    @TmsLink("WFCT-13745")
    public void GC07_PeterDownloadsAndPreviewsBillsAtCostOverViewTabChecksTracking() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnPreviewSubscriberBillByOrder(firstCustomerBill);
        kostenubersicht.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewSubscriberBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewSubscriberBill);
        rechnungen.clickOnExitPreviewingBill();
        kostenubersicht.clickOnPreviewItemizedBillByOrder(secondItemizedBill);
        kostenubersicht.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewItemizedBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewItemizedBill);
        rechnungen.clickOnExitPreviewingBill();
        tags.downloadBillWithoutFrames(kostenubersicht.getDownloadBillLocator(secondBill));
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadSubscriberBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadSubscriberBill);
        tags.downloadBillWithoutFrames(kostenubersicht.getDownloadBillLocator(thirdBill));
        tags.assertOnCompleteTag(clickTagName,clickTagContentForDownloadItemizedBill );
        tags.assertOnCompleteTag(downloadTagName,downloadTagContentForDownloadItemizedBill );
    }

    @Test(description = "GC08 - Peter user downloads/previews download bills at Invoice Summary Page then checks tracking",enabled = false )
    @TmsLink("WFCT-13746")
    public void GC08_PeterDownloadsAndPreviewsBillsAtInvoiceSummaryChecksTracking() {
        dashboard.clickMeineKostenTile();
        kostenubersicht.clickOnTheFirstUnderlinedAmount();
        invoiceSummary.downloadSubscriberBill();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadSubscriberBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadSubscriberBill);
        invoiceSummary.downloadItemizedBill();
        tags.assertOnCompleteTag(clickTagName,clickTagContentForDownloadItemizedBill );
        tags.assertOnCompleteTag(downloadTagName,downloadTagContentForDownloadItemizedBill );
    }

    @Test(description = "GC09 - Ute user downloads/previews download bills at Invoice Summary Page then checks tracking" ,enabled = false)
    @TmsLink("WFCT-13747")
    public void GC09_UteDownloadsAndPreviewsBillsAtInvoiceSummaryhecksTracking() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnDetailsAtBillChart();
        invoiceSummary.downloadItemizedPDF();
        tags.assertOnCompleteTag(clickTagName,clickTagContentForDownloadItemizedBill );
        tags.assertOnCompleteTag(downloadTagName,downloadTagContentForDownloadItemizedBill );
        invoiceSummary.downloadCustomerBill();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadCustomerBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadCustomerBill);
    }

    @Test(description = "GC11 - Marie user downloads/previews download bills at Meine Dokumente Page then checks tracking" ,enabled = false)
    @TmsLink("WFCT-13747")
    public void GC11_MarieDownloadsAndPreviewsBillsAtMeineDokumentePageChecksTracking() {
        dashboard.clickMeineDokumenteTile();
        meineDokumentePage.clickOnPreviewBillByOrder(firstBill);
        meineDokumentePage.assertThatPreviewingTagsIsReturned();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewDynamicBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewDynamicBill);
        meineDokumentePage.clickOnExitPreviewingBill();
        meineDokumentePage.clickOnDownloadBillByOrder(firstBill);
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadBill);
    }

    @Test(description = "GC12 - Martin user downloads/previews download bills at Meine Dokumente Page then checks tracking" ,enabled = false)
    @TmsLink("WFCT-13750")
    public void GC12_MartinDownloadsAndPreviewsBillsAtMeineDokumentePageChecksTracking() {
        dashboard.clickMeineDokumenteTile();
        meineDokumentePage.clickOnPreviewBillByOrder(firstBill);
        meineDokumentePage.assertThatPreviewingTagsIsReturned();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewDynamicBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewDynamicBill);
        meineDokumentePage.clickOnExitPreviewingBill();
        meineDokumentePage.clickOnDownloadBillByOrder(firstBill);
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadBill);
    }

    @Test(description = "GC13 - Ute user downloads/previews download bills at Meine Dokumente Page then checks tracking" ,enabled = false)
    @TmsLink("WFCT-13751")
    public void GC13_UteDownloadsAndPreviewsBillsAtMeineDokumentePageChecksTracking() {
        dashboard.clickMeineDokumenteTile();
        meineDokumentePage.clickOnPreviewBillByOrder(firstBill);
        meineDokumentePage.assertThatPreviewingTagsIsReturned();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewDynamicBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForPreviewDynamicBill);
        meineDokumentePage.clickOnExitPreviewingBill();
        meineDokumentePage.clickOnDownloadBillByOrder(firstBill);
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadBill);
    }
}
