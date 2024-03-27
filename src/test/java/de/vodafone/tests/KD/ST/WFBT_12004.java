package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.MeinTarifPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12004")
public class WFBT_12004 extends ST_KDSetup{
    @TmsLink("WFBT-11567")
    @Test(description = "WFBT-11567 || Check that user can show available options (each available tariff should have USP).")
    public void checkPriceAndDetailsLink(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateChangeTariffHeader()
                .validateAvailableTariffs()
                .validateUpgradeTarifCard();
    }
}