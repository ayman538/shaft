package de.vodafone.tests.CableMigration.ST;

import de.vodafone.pages.CableMigration.KontostandPage;
import de.vodafone.pages.CableMigration.MeinRechnungPage;
import de.vodafone.pages.CableMigration.MeinVodafoneDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Migration")
@Feature("ST")
@Story("Billing | Account balance display - Direct Debit")
public class WFFT_2999 extends CableMigrationSTSetup{
    @Test(description = "GC01 - Martin - Verify The Kontostand tab While having outstanding balance")
    @TmsLink("WFFT-3123")
    private void GC01(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KontostandPage(driver).ClickOnKontostandTab()
        .validateOutstandingTexts(testData.getTestData(method.getName() + ".headerTxt"),
                testData.getTestData(method.getName() + ".subHeaderTxt"));
        new KontostandPage(driver).validateCardOutstanding(testData.getTestData(method.getName() + ".cardHeaderTxt"),
                testData.getTestData(method.getName() + ".yellowIconTxt"),testData.getTestData(method.getName() + ".invoiceCLTxt"),
                testData.getTestData(method.getName() + ".amountCLTxt"));
    }

    @Test(description = "GC02 - Martin - Verify The Kontostand tab While having credit balance")
    @TmsLink("WFFT-3124")
    private void GC02(Method method){
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KontostandPage(driver).ClickOnKontostandTab()
                .ClickOnSecondSubAccount()
                .validateCreditTexts(testData.getTestData(method.getName() + ".headerTxt"),
                        testData.getTestData(method.getName() + ".subHeaderTxt"));
        new KontostandPage(driver).validateCardCredit(testData.getTestData(method.getName() + ".cardHeaderTxt"),
                testData.getTestData(method.getName() + ".greenIconTxt"),testData.getTestData(method.getName() + ".invoiceCLTxt"),
                testData.getTestData(method.getName() + ".amountCLTxt"));
    }

    @Test(description = "GC03 - Martin - Verify The Kontostand tab While having NO outstanding balance")
    @TmsLink("WFFT-3125")
    private void GC03(Method method) {
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KontostandPage(driver).ClickOnKontostandTab()
                .validateNoBalanceTexts(testData.getTestData(method.getName() + ".noBalanceMessageTxt"));
    }
}
