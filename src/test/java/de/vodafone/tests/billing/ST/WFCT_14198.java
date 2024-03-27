package de.vodafone.tests.billing.ST;


import com.shaft.driver.SHAFT;
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
@Story("WFCT-14198")

public class WFCT_14198 extends ST_BillingSetup {

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Verbindungsubersicht verbindungsubersicht;
    String totalAmount,errorMessageColor,reloadButtonText,reloadButtonColor,notificationBody,notificationTitle
            ,notificationColor, detailedText, miniText,miniUrl,detailedUrl,number;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        verbindungsubersicht = new Verbindungsubersicht(driver);
        totalAmount = testData.getTestData(method.getName()+".totalAmount");
        reloadButtonText = testData.getTestData(method.getName()+".reloadButtonText");
        reloadButtonColor = testData.getTestData(method.getName()+".reloadButtonColor");
        errorMessageColor = testData.getTestData((method.getName()+".errorMessageColor"));
        notificationTitle = testData.getTestData((method.getName()+".notificationTitle"));
        notificationBody = testData.getTestData((method.getName()+".notificationBody"));
        notificationColor = testData.getTestData((method.getName()+".notificationColor"));
        detailedText = testData.getTestData((method.getName()+".detailedText"));
        miniText = testData.getTestData((method.getName()+".miniText"));
        detailedUrl = testData.getTestData((method.getName()+".detailedUrl"));
        miniUrl = testData.getTestData((method.getName()+".miniUrl"));
        number = testData.getTestData((method.getName()+".number"));
        SHAFT.Properties.flags.set().disableCache(true);
    }


    @Test(description = "GC01 - Marie checks connection overview tab and FAQs at the same tab.")
    @TmsLink("WFCT-14546")
    public void GC01_MarieChecksConnectionOverviewTabAndFAQsAtTheSameTab() {
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

    @Test(description = "GC02 - Kay checks connection overview tab and FAQs at the same tab.")
    @TmsLink("WFCT-14556")
    public void GC02_KayChecksConnectionOverviewTabAndFAQsAtTheSameTab() {
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

    @Test(description = "GC03 - Marie checks connection overview tab with not retrieved total amount")
    @TmsLink("WFCT-14557")
    public void GC03_MarieChecksConnectionOverviewTabWithNotRetrievedTotalAmount() {
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

    @Test(description = "GC04 - Kay checks connection overview tab failure")
    @TmsLink("WFCT-14558")
    public void GC04_KayChecksConnectionOverviewTabFailure() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnConnectionOverViewFailureErrorMessageTitle()
                .assertOnConnectionOverViewFailureErrorMessageBody()
                .assertOnErrorMessageReloadButtonColorAndText(reloadButtonText,reloadButtonColor)
                .assertOnConnectionOverViewFailureErrorMessageColor(errorMessageColor)
                .clickOnErrorMessageReloadButton()
                .assertOnConnectionOverViewFailureErrorMessageTitle();
    }

    @Test(description = "GC05 - Kay checks download failure at connection overview tab")
    @TmsLink("WFCT-14559")
    public void GC05_KayChecksDownloadFailureAtConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.downloadPDF()
                .assertOnDownloadFailureMessageTitle()
                .assertOnDownloadFailureMessageBody()
                .exitDownloadFailureMessage()
                .downloadCSV()
                .assertOnDownloadFailureMessageTitle()
                .assertOnDownloadFailureMessageBody();
    }

    @Test(description = "GC06 - Marie with missing PDF checks connection overview tab")
    @TmsLink("WFCT-14560")
    public void GC06_MarieWithMissingPDFChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnNotificationMessageTitleOfPdfNotReturned()
                .assertOnNotificationMessageBodyOfPdfNotReturned()
                .assertOnConnectionOverViewFailureErrorMessageColor(errorMessageColor)
                .assertOnPdfDownloadButtonIsDimmed()
                .assertOnPdfDownloadButtonColor()
                .assertOnPdfDownloadButtonTextColor();
    }

    @Test(description = "GC07 - Marie with CSV not able to be loaded checks connection overview tab")
    @TmsLink("WFCT-14561")
    public void GC07_MarieWithCsvNotAbleToBeLoadedChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnNotificationMessageTitleOfCsvNotReturned()
                .assertOnNotificationMessageBodyOfCsvNotReturned()
                .assertOnConnectionOverViewFailureErrorMessageColor(errorMessageColor)
                .assertOnCsvDownloadButtonIsDimmed()
                .assertOnCsvDownloadButtonColor()
                .assertOnCsvDownloadButtonTextColor();
    }

    @Test(description = "GC08 - Brand new Kay user checks connection overview tab")
    @TmsLink("WFCT-14562")
    public void GC08_BrandnewKayUserChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnBrandNewCustomerNotificationMessageTitle(notificationTitle)
                .assertOnBrandNewCustomerNotificationMessageBody(notificationBody)
                .assertOnBrandNewCustomerNotificationMessageColor(notificationColor);
    }

    @Test(description = "GC09 - Kay with no usage at certain bill cycle checks connection overview tab")
    @TmsLink("WFCT-14563")
    public void GC09_KayWithNoUsageAtCertainBillCycleChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnNoUsageNotificationMessageTitle(notificationTitle)
                .assertOnNoUsageNotificationMessageBody(notificationBody)
                .assertOnNoUsageNotificationMessageColor(notificationColor)
                .assertOnTotalAmountValue(totalAmount)
                .assertOnCsvDownloadButtonIsDimmed()
                .assertOnCsvDownloadButtonColor()
                .assertOnCsvDownloadButtonTextColor()
                .assertOnPdfDownloadButtonIsDimmed()
                .assertOnPdfDownloadButtonColor()
                .assertOnPdfDownloadButtonTextColor();
        verbindungsubersicht.selectNumberFromFilter(number);
        verbindungsubersicht.assertOnCsvDownloadButtonIsDimmed()
                .assertOnPdfDownloadButtonIsDimmed()
                .assertOnBillCycleDropDownIsDimmed();

    }

    @Test(description = "GC10 - Kay without booking itemized bill checks connection overview tab")
    @TmsLink("WFCT-14564")
    public void GC10_KayWithoutBookingItemizedBillChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnTotalAmountValue(totalAmount)
                .assertOnCsvDownloadButtonIsDimmed()
                .assertOnCsvDownloadButtonColor()
                .assertOnCsvDownloadButtonTextColor()
                .assertOnPdfDownloadButtonIsDimmed()
                .assertOnPdfDownloadButtonColor()
                .assertOnPdfDownloadButtonTextColor()
                .assertOnBillCycleDropDownIsDimmed()
                .assertOnBillCycleDropDownColor()
                .assertOnBillCycleDropDownTextColor();
        verbindungsubersicht.assertOnNotBookedNotificationMessageTitle(notificationTitle)
                .assertOnNotBookedNotificationMessageBody(notificationBody)
                .assertOnNotBookedNotificationMessageColor(notificationColor);
        verbindungsubersicht.assertOnBookingDetailedItemizedLinkTextAndColor(detailedText)
                .assertThatUserNavigatedToBookingDetailedItemizedPage(detailedUrl);
        verbindungsubersicht.assertOnBookingMiniItemizedLinkTextAndColor(miniText)
                .assertThatUserNavigatedToBookingMiniItemizedPage(miniUrl);
    }

    @Test(description = "GC11 - Peter user booked itemized bill checks connection overview tab")
    @TmsLink("WFCT-14565")
    public void GC11_PeterUserBookedItemizedBillChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnNumbersDropDownIsDimmed()
                .assertOnNumbersDropDownColor()
                .assertOnNumbersDropDownTextColor();
    }

    @Test(description = "GC12 - Bart with itemized bill and one bill cycle checks connection overview tab")
    @TmsLink("WFCT-14566")
    public void GC12_BartWithItemizedBillAndOneBillCycleChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnNumbersDropDownIsDimmed()
                .assertOnNumbersDropDownColor()
                .assertOnNumbersDropDownTextColor()
                .assertOnBillCycleDropDownDimmed()
                .assertOnDimmedBillCycleDropDownColor()
                .assertOnDimmedBillCycleDropDownTextColor();

    }

    @Test(description = "GC13 - Maire with one number booked itemized bill,one bill cycle and no usage checks connection overview tab")
    @TmsLink("WFCT-14567")
    public void GC13_MaireWithOneNumberBookedItemizedBillAndOneBillCycleAndNoUsageChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnNoUsageNotificationMessageTitle(notificationTitle)
                .assertOnNoUsageNotificationMessageBody(notificationBody)
                .assertOnNoUsageNotificationMessageColor(notificationColor);
        verbindungsubersicht.assertOnTotalAmountValue(totalAmount);
        verbindungsubersicht.assertOnNumbersDropDownIsDimmed()
                .assertOnNumbersDropDownColor()
                .assertOnNumbersDropDownTextColor();
        verbindungsubersicht.assertOnBillCycleDropDownDimmed()
                .assertOnDimmedBillCycleDropDownColor()
                .assertOnDimmedBillCycleDropDownTextColor();
        verbindungsubersicht.assertOnCsvDownloadButtonIsDimmed()
                .assertOnCsvDownloadButtonColor()
                .assertOnCsvDownloadButtonTextColor();
        verbindungsubersicht.assertOnPdfDownloadButtonIsDimmed()
                .assertOnPdfDownloadButtonColor()
                .assertOnPdfDownloadButtonTextColor();
    }

    @Test(description = "GC14 - Marie with missing PDF and no able to load CSV checks connection overview tab")
    @TmsLink("WFCT-14569")
    public void GC14_MarieWithMissingPDFAndNoAbleToLoadCSVChecksConnectionOverviewTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnNotificationMessageTitleOfCsvNotReturnedForMultipleNotifications()
                .assertOnNotificationMessageBodyOfPdfNotReturnedAtMultipleNotifications()
                .assertOnNotificationMessageBodyOfCsvNotReturnedAtMultipleNotifications();
        verbindungsubersicht.assertOnPdfDownloadButtonIsDimmed()
                .assertOnPdfDownloadButtonColor()
                .assertOnPdfDownloadButtonTextColor();
        verbindungsubersicht.assertOnCsvDownloadButtonIsDimmed()
                .assertOnCsvDownloadButtonColor()
                .assertOnCsvDownloadButtonTextColor();
    }

    @Test(description = "GC15 - Marie with no MSISDN to be displayed checks connection overview tab")
    @TmsLink("WFCT-14775")
    public void GC15_MarieWithoutNumbersToBeDisplayedChecksConnectionOverviewTabFailure() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.assertOnConnectionOverViewFailureErrorMessageTitle()
                .assertOnConnectionOverViewFailureErrorMessageBody();
    }

}
