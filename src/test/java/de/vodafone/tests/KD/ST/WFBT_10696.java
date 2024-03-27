package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10696")

public class WFBT_10696 extends ST_KDSetup{

    @TmsLink("WFBT-11153")
    @Test(description = "WFBT-11154 || GC01 - Check that the SO retrieving dynamic data if it's only tariff")
    public void assertOnDynamicMeinTarifSOInKabelTVAccordion() {
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .assertOnMeinTariffSOInKabelTVAcc()
                .assertOnDynamicTariffNameInSOMeinTarifIKabelTVAcc()
                .assertOnEndDateInSOMeinTarifKabelTVAcc();
    }

    @TmsLink("WFBT-11154")
    @Test(description = "WFBT-11154 || GC02 - Check that the SO will be static if there is more than a tariff")
    public void assertOnStaticMeinTarifSOInKabelTVAccordion() {
        new KD_Dashboard(driver).closeNotification()
                .expandKabelTvAccordion()
                .assertOnSOIconInMeinTariffSOInKabelTVAcc()
                .assertOnStaticFooterInMeinTariffSOInKabelTVAcc();
    }

    @TmsLink("WFBT-11166")
    @Test(description = "WFBT-11166 || GC03 - Check availability of Mein Kabel TV option in cable TV accordion burger menu above Mein tariff option")
    public void assertOnMeinTarifInBurgerMenu() {
        new KD_Dashboard(driver).closeNotification()
                .clickOnKabelTVBurgerMenu()
                .assertOnMeinTariffExistsAfterKabelTV();
    }
}