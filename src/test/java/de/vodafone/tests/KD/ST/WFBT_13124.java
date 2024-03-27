package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13124")
public class WFBT_13124 extends  ST_KDSetup {
        @TmsLink("WFBT-13221")
        @Test(description = "WFBT-13221 || GC01 || KD KIP User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user Only has a cancelled CLS Tariff")
        private void gc01(Method method) {
            new KD_Dashboard(driver)
                    .clickOnInternetAndPhoneAccordion()
                    .validateMeinTarifSOMsgOnlyCLSCancelledT_KIPUser(testData.getTestData(method.getName() + ".kipUserCancelledCLSTOnly_Title"), testData.getTestData(method.getName() + ".kipUserCancelledCLSTOnly_Body"));
        }

    @TmsLink("WFBT-13457")
    @Test(description = "WFBT-13457 || GC02 || KD KIP User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has cancelled Mein Tariff")
    private void gc02(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOMsgOnlyMeinTCancelled_KIPUser(testData.getTestData(method.getName() + ".kipUserCancelledMainTOnly_Title"), testData.getTestData(method.getName() + ".kipUserCancelledMainTOnly_Body"));
    }

    @TmsLink("WFBT-13458")
    @Test(description = "WFBT-13459 | GC03 || KD KIP User - Validate the notification message of the pending Cancelled tariff message on Tariff SO in Dashboard when user has Cancelled Main Tariff and Cancelled CLS Tariff")
    private void gc03(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOMsgWithCanceledMeinAndcancelledCLST_KIPUser(testData.getTestData(method.getName() + ".kipUserCancelledMainTandCancelledCLST_Title"), testData.getTestData(method.getName() + ".kipUserCancelledMainTandCancelledCLST_Body"));
        }

    @TmsLink("WFBT-13459")
    @Test(description = "WFBT-13459 | GC04 || KD KIP User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has CLS tariff and cancelled Main Tariff")
    private void gc04(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOMsgWithCanceledMeinTandCLSTarif_KIPUser(testData.getTestData(method.getName() + ".kipUserCancelledMainTandActiveCLST_Title"), testData.getTestData(method.getName() + ".kipUserCancelledMainTandActiveCLST_Body"));
    }

    @TmsLink("WFBT-13460")
    @Test(description = "WFBT-13460 | GC05 || KD KIP User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has Mein Tariff and cancelled CLS Tariff")
    private void gc05(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOMsgWithCanceledCLSTandMeinTarif_KIPUser(testData.getTestData(method.getName() + ".kipUserActiveCLSTandCancelledMeinTarif_Body"));
    }

    @TmsLink("WFBT-13807")
    @Test(description = "WFBT-13807 ||GC01 | KIP User | Check Mein Tarif SO when User has multiple CLS tariffs and Only one CLS is cancelled")
    private void gc06(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOMsgWithMultipleCLSTarif_KIPUser(testData.getTestData(method.getName() + ".kipUserMultipleCLSTandOneISCancelled_Title"), testData.getTestData(method.getName() + ".kipUserMultipleCLSTandOneISCancelled_Body"));
    }
}