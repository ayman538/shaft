package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;

@Epic("KD")
@Feature("ST")
@Story("WFBT_13134")
public class WFBT_13134 extends  ST_KDSetup {
    @TmsLink("WFBT-13581")
    @Test(description = "WFBT-13581 || GC01 || KD TV User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has only cancelled CLS Tariff")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOwithCancelledCLSTOnly(testData.getTestData(method.getName() + ".TVUserCancelledCLSTOnly_Title"), testData.getTestData(method.getName() + ".TVUserCancelledCLSTOnly_Body"));
    }

    @TmsLink("WFBT-13582")
    @Test(description = "WFBT-13582 || GC02 || KD TV User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has only one cancelled Mein Tariff")
    private void gc02(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOwithCancelledMainTOnly(testData.getTestData(method.getName() + ".TVUserCancelledMainTOnly_Title"), testData.getTestData(method.getName() + ".TVUserCancelledMainTOnly_Body"));
    }

    @TmsLink("WFBT-13583")
    @Test(description = "WFBT-13583 || GC03 || KD TV User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has Cancelled CLS Tariff and Cancelled mein tariff")
    private void gc03(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOMsgWithCanceledMeinAndcancelledCLST(testData.getTestData(method.getName() + ".TVUserAactiveMainTandCancelledCLST_Title"), testData.getTestData(method.getName() + ".TVUserAactiveMainTandCancelledCLST_Body"));
    }

    @TmsLink("WFBT-13584")
    @Test(description = "WFBT-13584 || GC04 || KD TV User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has Cancelled CLS Tariff and not cancelled mein tariff")
    private void gc04(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOwithAactiveMainTandCancelledCLST(testData.getTestData(method.getName() + ".TVUserAactiveMainTandCancelledCLST_Body"));
    }

    @TmsLink("WFBT-13585")
    @Test(description = "WFBT-13585 || GC05 ||  KD TV User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has Cancelled Mein tariff and not Cancelled CLS Tariff.")
    private void gc05(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOMsgWithCanceledMeinTandCLSTarif(testData.getTestData(method.getName() + ".TVUserCancelledMainTandActiveCLST_Title"), testData.getTestData(method.getName() + ".TVUserCancelledMainTandActiveCLST_Body"));
    }

    @TmsLink("WFBT-13586")
    @Test(description = "WFBT-13586 || GC06 ||  KD TV User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has Multiple TV tariffs and only one cancelled")
    private void gc06(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateTVUserWithMultipleMainTandOneMainTCancelled(testData.getTestData(method.getName() + ".TVUserMultipleMainTandOneMainTCancelled_Title"), testData.getTestData(method.getName() + ".TVUserMultipleMainTandOneMainTCancelled_Body"));
    }

    @TmsLink("WFBT-13919")
    @Test(description = "WFBT-13919 || GC07 || KD TV User - Validate the notification message of the pending cancelled tariff message on Tariff SO in Dashboard when user has Multiple TV tariffs and all are cancelled")
    private void gc07(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateTVUserWithMultipleMainTandAllTCancelled(testData.getTestData(method.getName() + ".TVUserMultipleMainTandOneMainTCancelled_Title"), testData.getTestData(method.getName() + ".TVUserMultipleMainTandTwoMainTCancelled_Body"));
    }
}