package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12571")
public class WFBT_12571 extends ST_KDSetup {
    @TmsLink("WFBT-9219")
    @Test(description = "WFBT-9219 | GC01 | KD TV User | Check When user has Mein tariff only name will be shown dynamic in mein tariff smart object in Dashboard")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOWithMeinTariffOnlyKabelTV(testData.getTestData(method.getName() + ".meinTarifSO_KipOnly"), testData.getTestData(method.getName() + ".meinTarifSO_KipOnly_LastDate"));
    }

    @TmsLink("WFBT-9220")
    @Test(description = "WFBT-9220 | GC02 | KD TV User | Check When user has CLS only name will be shown dynamic in mein tariff smart object in Dashboard")
    private void gc02(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOWithCLSOnlyTV(testData.getTestData(method.getName() + ".meinTarifSO_CLSOnly"), testData.getTestData(method.getName() + ".meinTarifSO_CLSOnly_LastDate"));
    }

    @TmsLink("WFBT-9221")
    @Test(description = "WFBT-9221 | GC03 | KD TV User | Validate the view of Mein Tariff SO in Dashboard in case customer has CLS Tariff and Main Tariff")
    private void gc03(Method method) {
        new KD_Dashboard(driver)
                .clickOnKabelTVAccordion()
                .validateMeinTarifSOWithMeinTarifandCLSKabelTV(testData.getTestData(method.getName() + ".meinTarifSO_KipCLS"), testData.getTestData(method.getName() + ".meinTarifSO_KipCLS_LastDate"));
    }
}