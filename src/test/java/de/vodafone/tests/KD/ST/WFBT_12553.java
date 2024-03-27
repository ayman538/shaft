package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12553")
public class WFBT_12553 extends ST_KDSetup {

    @TmsLink("WFBT-13003")
    @Test(description = "GC01 | KD TV User | Check When user has Mein tariff only name will be shown dynamic in mein tariff smart object in Dashboard")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOWithMeinTariffOnly(testData.getTestData(method.getName() + ".meinTarifSO_KipOnly"), testData.getTestData(method.getName() + ".meinTarifSO_KipOnly_LastDate"));
    }

    @TmsLink("WFBT-13004")
    @Test(description = "GC02 | KD TV User | Check When user has CLS only name will be shown dynamic in mein tariff smart object in Dashboard")
    private void gc02(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOWithMeinTarifandCLS(testData.getTestData(method.getName() + ".meinTarifSO_CLSOnly"), testData.getTestData(method.getName() + ".meinTarifSO_CLSOnly_LastDate"));
    }

    @TmsLink("WFBT-13005")
    @Test(description = "GC03 | KD TV User | Check When user has both mein tariff and CLS tariff mein tariff name will be shown dynamic in mein tariff smart object in Dashboard")
    private void gc03(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .validateMeinTarifSOWithCLSTariffOnly(testData.getTestData(method.getName() + ".meinTarifSO_KipCLS"), testData.getTestData(method.getName() + ".meinTarifSO_KipCLS_LastDate"));
    }
}