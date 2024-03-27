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
public class WFFT_2170 extends CableMigrationSTSetup {
    @Test(description ="GC01 - Verify the KD table while no invoices retrieved in all months" )
    @TmsLink("WFFT-2556")
    private void GC01(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungNoInvoicesReturned(testData.getTestData(method.getName() + ".noInvoicesInfoTitleMsg"),
                testData.getTestData(method.getName() + ".noInvoicesInfoContentMsg"));
    }
    @Test(description = "GC03 - Verify the KD table while the invoice retrieved without product name and PDF")
    @TmsLink("WFFT-2558")
    private void GC03(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungNoProductNameAndPDFReturned(testData.getTestData(method.getName() + ".noProductNameAndPDFInfoContentMsg"),
                testData.getTestData(method.getName() + ".tableProductName"),testData.getTestData(method.getName() + ".tablePDFErrorMsg"));
    }
    @Test(description = "GC05 - Verify the KD table and chart while the amout and the due date are not retrieved for a single invoice during a specific month")
    @TmsLink("WFFT-2561")
    private void GC05(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungNoAmountAndDueDateReturnedSingleInvoice(testData.getTestData(method.getName() + ".tableAmount"),
                testData.getTestData(method.getName() + ".tableDueDate"),testData.getTestData(method.getName() + ".chartAmount"));
    }
    @Test(description = "GC07 - Verify the KD table and chart while the amout and the due date are not retrieved for all invoices during a specific month")
    @TmsLink("WFFT-2563")
    private void GC07(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungNoAmountAndDueDateReturnedALLInvoice(testData.getTestData(method.getName() + ".tableFirstAmount"),
                testData.getTestData(method.getName() + ".tableFirstDueDate"),testData.getTestData(method.getName() + ".tableSecondAmount"),
                testData.getTestData(method.getName() + ".tableSecondDueDate"));
    }
    @Test(description = "GC13 - Verify Meine Rechnungen Tab while the tab is not loaded")
    @TmsLink("WFFT-2569")
    private void GC13(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungTabIsNOTLoaded(testData.getTestData(method.getName() + ".tabNotLoadedErrorTitle"),
                testData.getTestData(method.getName() + ".tabNotLoadedErrorContent"),testData.getTestData(method.getName() + ".tabNotLoaded_NochmalVersuchen"));
    }
}