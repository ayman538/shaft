package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13530")
public class WFBT_13530  extends  ST_KDSetup {
    @TmsLink("WFBT-14440")
    @Test(description = "WFBT-14440 || GC02 || KD KIP || Check tariff names in recommended tariff is bold.")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateChangeTariffHeader()
                .validateTarifnameFontisBoldinChangeTariff();
               }
}