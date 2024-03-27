package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11381")
public class WFBT_11381 extends ST_KDSetup{

    @TmsLink("WFBT_12055")
    @Test(description = "WFBT_12055 || GC01 Check the handling of negative price to be shown in green (without the -) with the word geschenkt in KIP")
    public void GC01_CheckNegativePriceInKIP(){
        new KD_Dashboard(driver)
                .clickOnBurgerMenuKIPMeinKabelContract()
                .clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion()
                .validateBookedOptionNegativePriceKIP();
    }

    @TmsLink("WFBT_12056")
    @Test(description = "WFBT_12056 || GC01 Check the handling of negative price to be shown in green (without the -) with the word geschenkt in TV")
    public void GC02_CheckNegativePriceInTV(){
        new KD_Dashboard(driver).clickOnBurgerMenuKabelTV()
                .clickMeinTariffButtonFromBurgerMenuTV();
        new KabelTVPage(driver).expandBookedOptionAccordion()
                .validateBookedOptionNegativePriceTV();
    }
}