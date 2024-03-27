package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.MeinTarifPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10638")
public class WFBT_10638 extends ST_KDSetup  {

    @Test(description = "GC01 || check the existence of the dynamic my tariff name and under it the USPs with icons")
    @TmsLink("WFBT-10972")
    public void GC01() {
     //   new KD_Dashboard(driver).closeNotification();
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc();
        new KD_Dashboard(driver).clickMeinTariffSmartObject();
        new KD_Dashboard(driver).checkExistenceOfTarifNameAndUSPs();
    }

    @Test(description = "GC02 || check the contract details (Price, Contract#, Start date, The next possible end date, The last possible cancellation date, CTA show more options)")
    @TmsLink("WFBT-10973")
    public void GC02(){
     //   new KD_Dashboard(driver).closeNotification();
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc();
        new KD_Dashboard(driver).clickMeinTariffSmartObject();
        new MeinTarifPage(driver).validateContractDetailsCard();
        new MeinTarifPage(driver).clickContractCancellationHyperlink();
        new MeinTarifPage(driver).validateContractCancellationHyperlink();
    }

    @Test(description = "GC03 || check the redirection to the legacy portal while changing tariff")
    @TmsLink("WFBT-10974")
    public void GC03(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc();
        new KD_Dashboard(driver).clickMeinTariffSmartObject();
        new MeinTarifPage(driver).clickChangeTariffCTA();
        new MeinTarifPage(driver).validateChangeTariffPage();
    }
}