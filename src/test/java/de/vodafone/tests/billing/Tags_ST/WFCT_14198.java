package de.vodafone.tests.billing.Tags_ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Verbindungsubersicht;
import de.vodafone.pages.commons.Tags;
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
public class WFCT_14198 extends ST_TagsSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Verbindungsubersicht verbindungsubersicht;
    Tags tags;
    String type, action, code, area, message,csvErrorDetails,pdfErrorDetails,typePdf,actionPdf,areaPdf,messagePdf;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        verbindungsubersicht = new Verbindungsubersicht(driver);
        tags = new Tags(driver);
        type = testData.getTestData((method.getName()+".type"));
        action = testData.getTestData((method.getName()+".action"));
        code = testData.getTestData((method.getName()+".code"));
        area = testData.getTestData((method.getName()+".area"));
        message = testData.getTestData((method.getName()+".message"));
        csvErrorDetails = testData.getTestData((method.getName()+".csvErrorDetails"));
        pdfErrorDetails = testData.getTestData((method.getName()+".pdfErrorDetails"));
        typePdf = testData.getTestData((method.getName()+".type1"));
        actionPdf = testData.getTestData((method.getName()+".action1"));
        areaPdf = testData.getTestData((method.getName()+".area1"));
        messagePdf = testData.getTestData((method.getName()+".message1"));
    }

    @Test(description = "Tag01 - Kay checks connection overview failure error tracking" )
    @TmsLink("WFCT-14570")
    public void Tag01_KayChecksConnectionOverviewFailureErrorTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnErrorType(type);
        tags.assertOnErrorAction(action);
        tags.assertOnErrorCode(code);
        tags.assertOnErrorArea(area);
        tags.assertOnErrorMessage(message);
    }

    @Test(description = "Tag02 - Kay checks connection overview PDF and CSV download failure error tracking" )
    @TmsLink("WFCT-14571")
    public void Tag02_KayChecksConnectionOverviewPdfAndCsvDownloadFailureErrorTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        verbindungsubersicht.downloadPDF();
        tags.assertOnErrorType(type);
        tags.assertOnErrorAction(action);
        tags.assertOnErrorCode(code);
        tags.assertOnErrorArea(area);
        tags.assertOnErrorMessage(message);
        tags.assertOnErrorDetails(pdfErrorDetails);
        verbindungsubersicht.downloadCSV();
        tags.assertOnErrorType(type);
        tags.assertOnErrorAction(action);
        tags.assertOnErrorCode(code);
        tags.assertOnErrorArea(area);
        tags.assertOnErrorMessage(message);
        tags.assertOnErrorDetails(csvErrorDetails);
    }

    @Test(description = "Tag03 - Marie with missing PDF checks connection overview notification tracking" )
    @TmsLink("WFCT-14572")
    public void Tag03_MarieWithMissingPdfChecksConnectionOverviewNotificationTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

    @Test(description = "Tag04 - Marie with not able to load CSV checks connection overview notification tracking" )
    @TmsLink("WFCT-14573")
    public void Tag04_MarieWithNotAbleToLoadCsvChecksConnectionOverviewNotificationTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

    @Test(description = "Tag05 - Brand new kay customer checks connection overview notification tracking" )
    @TmsLink("WFCT-14574")
    public void Tag05_BrandNewKayCustomerChecksConnectionOverviewNotificationTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

    @Test(description = "Tag06 - Kay with no usage checks connection overview notification tracking" )
    @TmsLink("WFCT-14575")
    public void Tag06_KayWithNoUsageChecksConnectionOverviewNotificationTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

    @Test(description = "Tag07 - Marie with missing PDF and not able to load CSV checks connection overview notification tracking" )
    @TmsLink("WFCT-14578")
    public void Tag07_MarieWithMissingPdfAndNotAbleToLoadCsvChecksConnectionOverviewNotificationTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
        tags.assertOnNotificationAction(actionPdf);
        tags.assertOnNotificationType(typePdf);
        tags.assertOnNotificationMessage(messagePdf);
        tags.assertOnNotificationArea(areaPdf);
    }

    @Test(description = "Tag08 - Marie with no MSISDN to be displayed checks connection overview tab")
    @TmsLink("WFCT-14775")
    public void Tag08_MarieWithoutNumbersToBeDisplayedChecksConnectionOverviewTabTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

    @Test(description = "Tag09 - Kay without booking itemized bill checks connection overview notification tracking")
    @TmsLink("WFCT-14776")
    public void Tag09_KayWithoutBookingItemizedBillChecksConnectionOverviewTabTracking() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickVerbindungsübersichtTab();
        tags.assertOnNotificationAction(action);
        tags.assertOnNotificationType(type);
        tags.assertOnNotificationMessage(message);
        tags.assertOnNotificationArea(area);
    }

}
