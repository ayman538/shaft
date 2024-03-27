package de.vodafone.tests.CableMigration.ST;

import de.vodafone.pages.CableMigration.KontostandPage;
import de.vodafone.pages.CableMigration.MeinVodafoneDashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Cable Migration")
@Feature("ST")
@Story("WFFT-2996 Billing | Enhancement of account balance display")
public class WFFT_2996 extends CableMigrationSTSetup {
    @Test(description = "GC01-Verify the Kontostand page with only one Reference konto for TV product")
    @TmsLink("WFFT-4031")
    public void GC01(Method method) {
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KontostandPage(driver)
                .ClickOnKontostandTab()
                .validateTVTexts(testData.getTestData(method.getName() + ".headerNew"),
                testData.getTestData(method.getName() + ".subHeaderNew"),
                testData.getTestData(method.getName() + ".subHeaderNew2"));
    }
    @Test(description = "GC02-Verify the Kontostand page for multiple products (TV , Hotspot & Other prodcut)")
    @TmsLink("WFFT-4032")
    public void GC02(Method method) {
       new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
       new KontostandPage(driver)
               .ClickOnKontostandTab()
               .clickOnTvTab()
               .validateTVTexts(testData.getTestData(method.getName() + ".headerNew"),
               testData.getTestData(method.getName() + ".subHeaderNew"),
               testData.getTestData(method.getName() + ".subHeaderNew2"))
               .clickOnHotspotTab()
               .validateHotspotTexts(testData.getTestData(method.getName() + ".headerHotspot"),
               testData.getTestData(method.getName() + ".subHeaderNew"),
               testData.getTestData(method.getName() + ".subHeaderNew2"))
               .clickOnProduktab()
               .validateProduktTexts(testData.getTestData(method.getName() + ".headerProdukt"),
               testData.getTestData(method.getName() + ".subHeaderNew"),
               testData.getTestData(method.getName() + ".subHeaderNew2"));
    }
    @Test(description = "GC04-Verify the Kontostand page for martin user with different subaccounts (outstanding , inkaso, credit, zero balance)")
    @TmsLink("WFFT-4034")
    public void GC04(Method method) {
        new MeinVodafoneDashboard(driver).navigateToMeinReshnungPage();
        new KontostandPage(driver)
                .ClickOnKontostandTab()
                .clickOnTvTab()
                .validateTvNoBalanceTexts(testData.getTestData(method.getName() + ".headerNew"))
                .clickOntv2tab()
                .validateTv2Texts(testData.getTestData(method.getName() + ".headerTv"),
                testData.getTestData(method.getName() + ".subHeaderInkaso"));
    }
}
