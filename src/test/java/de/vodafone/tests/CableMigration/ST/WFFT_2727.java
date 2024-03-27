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
public class WFFT_2727 extends CableMigrationSTSetup {
    @Test(description = "GC01 - Verify the KD table and chart while the amout and the due date are not retrieved for all invoices during a specific month")
    @TmsLink("WFFT-2563")
    private void GC01(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungNoAmountAndDueDateReturnedALLInvoice(testData.getTestData(method.getName() + ".tableFirstAmount"),
                testData.getTestData(method.getName() + ".tableFirstDueDate"),testData.getTestData(method.getName() + ".tableSecondAmount"),
                testData.getTestData(method.getName() + ".tableSecondDueDate"));
    }

    @Test(description = "GC03 - Verify the KD table and chart while multiple months having their data missed")
    @TmsLink("WFFT-2565")
    private void GC03(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new MeinRechnungPage(driver).validateMeinRechnungNoAmountAndDueDateReturnedALLInvoice(testData.getTestData(method.getName() + ".tableFirstAmount"),
                testData.getTestData(method.getName() + ".tableFirstDueDate"),testData.getTestData(method.getName() + ".tableSecondAmount"),
                testData.getTestData(method.getName() + ".tableSecondDueDate"));
    }
}
