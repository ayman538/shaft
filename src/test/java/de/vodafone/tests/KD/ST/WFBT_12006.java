package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12006")
public class WFBT_12006 extends ST_KDSetup{

    @TmsLink("WFBT_12008")
    @Test(description = "WFBT_12008 || GC01 Check that Kabel-TV Renter user will see the static tariff name and USPs in case no tariff name and no USPs are retrieved")
    public void GC01_CheckMeinKabelTVAccordionInCaseNoTariffAndUSPsRenter(){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .validateMeinKabelTVSONoTariffUserRenter()
                .clickMeinKabelTVSO();
        new KabelTVPage(driver).validateMeinKabelTVSORenterNoTariff()
                .validateAccessNameAndUSPsCardNoTariffRenter()
                .validateContractDetailsRenter();
    }
}