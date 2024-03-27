package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12347")
public class WFBT_12347 extends ST_KDSetup {

    @TmsLink("WFBT-12983")
    @Test(description = "GC01 || Martin KIP user - Validate handling Tariff's view when customer has a CLS Tariff and Main Tarif")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnBurgerMenuKIPMeinKabelContract()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver)
                .validateThatFirstTariffMeinTariff(testData.getTestData(method.getName() + ".firstTariff_MeinTariff"))
                .validateThatCLSTariffSecondTariff(testData.getTestData(method.getName() + ".secondTariff_CLSTariff"), testData.getTestData(method.getName() + ".clsTariffID"));
    }

    @TmsLink("WFBT-12984")
    @Test(description = "GC02 || Martin KIP user - Validate handling Tariff's view when customer has a CLS Tariff only.")
    private void gc02(Method method) {
        new KD_Dashboard(driver)
                .clickOnBurgerMenuKIPMeinKabelContract()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver)
                .validateThatCLSTariffOnlyExists(testData.getTestData(method.getName() + ".clsTariffOnly_NameCL"));
    }

    @TmsLink("WFBT-12985")
    @Test(description = "GC03 || Martin KIP user - Validate handling Tariff's view when customer has a Main Tariff only.")
    private void gc03(Method method) {
        new KD_Dashboard(driver)
                .clickOnBurgerMenuKIPMeinKabelContract()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver)
                .vaidateThatMeinTariffExists(testData.getTestData(method.getName() + ".meinTariffOnly_NameCL"));
    }

    @TmsLink("WFBT-12986")
    @Test(description = "GC04 || Martin KIP user - Validate handling Tariff's view when user has CLS tariff with no price (price section should not be shown)")
    private void gc04(Method method) {
        new KD_Dashboard(driver)
                .clickOnBurgerMenuKIPMeinKabelContract()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver)
                .vaidateThatNoPriceOnCLSTariff(testData.getTestData(method.getName() + ".startDate"));
    }

}