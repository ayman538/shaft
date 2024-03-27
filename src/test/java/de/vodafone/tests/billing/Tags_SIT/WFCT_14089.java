package de.vodafone.tests.billing.Tags_SIT;

import de.vodafone.pages.billing.*;
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

public class WFCT_14089 extends SIT_TagsSetup {
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
            ,downloadTagContentForDownloadBill,clickTagContentForDownloadBill,secondBill,thirdBill,contractNumber;



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
        contractNumber = testData.getTestData(method.getName()+".contractNumber");
    }


    @Test(description = "GC05 - Martin user downloads/previews bills at rechnung tab then checks tracking" )
    @TmsLink("WFCT-13742")
    public void GC05_MatrinDownloadsAndPreviewsBillsAtRechnungTabChecksTracking() {
        dashboard.waitUntilDashboardLoadedCompletely();
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnPreviewCustomerBillByOrder(firstCustomerBill);
        rechnungen.waitTillTagsReturnedSuccessfully();
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewCustomerBill);
        tags.assertOnCompleteTag(clickTagName, clickTagContentForPreviewCustomerBill);
        rechnungen.clickOnExitPreviewingBill();
        tags.downloadBillWithoutFrames(rechnungen.getDownloadCustomerBillLocator(firstCustomerBill));
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadCustomerBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadCustomerBill);
    }

    @Test(description = "GC06 - Kay user downloads/previews bills at cost overview tab then checks tracking" )
    @TmsLink("WFCT-13744")
    public void GC06_KayDownloadsAndPreviewsBillsAtCostOverViewTabChecksTracking() {
        dashboard.waitUntilDashboardLoadedCompletely();
        dashboard.expandContracts(contractNumber);
        dashboard.clickMeineRechnungenTile(contractNumber);
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
        tags.assertOnCompleteTag(clickTagName, clickTagContentForDownloadItemizedBill);
        tags.assertOnCompleteTag(downloadTagName, downloadTagContentForDownloadItemizedBill);
    }

    @Test(description = "GC07 - Peter user downloads/previews download bills at cost overview tab then checks tracking" )
    @TmsLink("WFCT-13745")
    public void GC07_PeterDownloadsAndPreviewsBillsAtCostOverViewTabChecksTracking() {
        dashboard.expandContracts(contractNumber);
        dashboard.clickMeineKostenTile(contractNumber);
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



}



