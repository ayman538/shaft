package de.vodafone.tests.CableMigration.ST;
import de.vodafone.pages.CableMigration.MeinRechnungPage;
import de.vodafone.pages.CableMigration.MeinVodafoneDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Migration")
@Feature("ST")
public class WFFT_2608 extends CableMigrationSTSetup {
    @Test(description ="GC01 - Verify The Meine Rechnungen Chart & Table while the invoice with credit amount for Multi invoice/Month")
    @TmsLink("WFFT-2619")
    private void GC01(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungCreditAmount(testData.getTestData(method.getName() + ".creditAmountInfoTitleMsg"),
                testData.getTestData(method.getName() + ".creditAmountInfoContentMsg"));
    }

    @Test(description ="GC03 - Verify The Meine Rechnungen Chart & Table In case first invoice for Multi invoice/Month")
    @TmsLink("WFFT-2621")
    private void GC03(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungFirstInvoice(testData.getTestData(method.getName() + ".firstInvoiceInfoTitleMsg"),
                testData.getTestData(method.getName() + ".firstInvoiceInfoContentMsg"));
    }

    @Test(description ="GC05 - Verify The Meine Rechnungen Table In case download service failed")
    @TmsLink("WFFT-2623")
    private void GC05(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage().downloadRechnungFile();
        new MeinRechnungPage(driver).validateMeinRechnungDownloadFailed(testData.getTestData(method.getName() + ".downloadFailedInfoTitleMsg"),
                testData.getTestData(method.getName() + ".downloadFailedInfoContentMsg"));
    }
}