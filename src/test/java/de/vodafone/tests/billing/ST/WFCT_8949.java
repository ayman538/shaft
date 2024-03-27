package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")
public class WFCT_8949 extends ST_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    int firstMonthOrder;
    int secondMonthOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        firstMonthOrder =Integer.parseInt(testData.getTestData(method.getName()+".firstMonthOrder")) ;
        secondMonthOrder =Integer.parseInt(testData.getTestData(method.getName()+".secondMonthOrder"));
    }

    @Test(description = "GC01 Marie user checks collective download ")
    @TmsLink("WFCT-11420")
    public void GC01_MarieUserWithLessThan12InvoicesChecksCollectiveDownload() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnSelectAllCheckBox();
        rechnungen.clickInvoiceCheckbox(firstMonthOrder);
        rechnungen.clickInvoiceCheckbox(secondMonthOrder);
        rechnungen.clickDownloadAllBtn();
        rechnungen.waitForFileToBeDownloaded();
        rechnungen.assertOnCollectiveDownloadAllBtn();
//        rechnungen.assertThatFileIsDownloaded();
    }

    @Test(description = "GC02 Kay user checks collective download Using select all checkbox ")
    @TmsLink("WFCT-11421")
    public void GC02_KayUserWithMoreThan12InvoicesChecksCollectiveDownloadUsingSelectAll() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnSelectAllCheckBox();
        rechnungen.clickSelectAllCheckbox();
        rechnungen.clickDownloadAllBtn();
        rechnungen.waitForFileToBeDownloaded();
        rechnungen.assertOnCollectiveDownloadAllBtn();
//        rechnungen.assertThatFileIsDownloaded();
    }

    @Test(description = "BC01 Bart user with back end error checks collective download")
    @TmsLink("WFCT-11422")
    public void BC01_BartUserWithBEErrorChecksCollectiveDownload() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnSelectAllCheckBox();
        rechnungen.clickInvoiceCheckbox(firstMonthOrder);
        rechnungen.clickInvoiceCheckbox(secondMonthOrder);
        rechnungen.clickDownloadAllBtn();
        rechnungen.assertOnCollectiveDownloadErrorNotificationHeader();
        rechnungen.assertOnCollectiveDownloadErrorNotificationBody();
        rechnungen.assertOnRedMonthColor(firstMonthOrder);
        rechnungen.assertOnRedMonthColor(secondMonthOrder);

    }

}

