package de.vodafone.tests.KD.ST;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12465")
public class WFBT_12465 extends ST_KDSetup {
    @TmsLink("WFBT-12959")
    @Test(description = "WFBT-12959 || GC01 || Martin KIP User - Check the view of promo badge over the recommended tariff for the user in KIP tariff page.")
    private void gc01(Method method) {
        new KD_Dashboard(driver)
                .clickOnBurgerMenuKIPMeinKabelContract()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver)
                .validateThatPromoPageIsDisplayed(testData.getTestData(method.getName() + ".promoBadge_Text"));
    }
}