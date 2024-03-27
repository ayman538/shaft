package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-8949")

public class WFCT_8949 extends SIT_BillingSetup{
    Dashboard dashboard;
    Rechnungen rechnungen;
    int firstMonthOrder;
    int secondMonthOrder;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        firstMonthOrder =Integer.parseInt(testData.getTestData(method.getName()+".firstMonthOrder")) ;
        secondMonthOrder =Integer.parseInt(testData.getTestData(method.getName()+".secondMonthOrder"));
        contractOrder =testData.getTestData(method.getName()+".contractOrder");

    }

    @Test(description = "mobile user checks collective download ")
    @TmsLink("WFCT-11425")
    public void GC01_MarieUserWithLessThan12InvoicesChecksCollectiveDownload() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.assertOnSelectAllCheckBox();
        rechnungen.clickInvoiceCheckbox(firstMonthOrder);
        rechnungen.clickInvoiceCheckbox(secondMonthOrder);
        rechnungen.clickDownloadAllBtn();
        rechnungen.waitForFileToBeDownloaded();
        rechnungen.assertOnCollectiveDownloadAllBtn();
        rechnungen.assertThatFileIsDownloaded();
    }



    @Test(description = "Mobile user checks collective download Using select all checkbox ")
    @TmsLink("WFCT-11426")
    public void GC02_KayUserWithMoreThan12InvoicesChecksCollectiveDownloadUsingSelectAll() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.assertOnSelectAllCheckBox();
        rechnungen.clickSelectAllCheckbox();
        rechnungen.clickDownloadAllBtn();
        rechnungen.waitForFileToBeDownloaded();
        rechnungen.assertOnCollectiveDownloadAllBtn();
        rechnungen.assertThatFileIsDownloaded();
    }
}
