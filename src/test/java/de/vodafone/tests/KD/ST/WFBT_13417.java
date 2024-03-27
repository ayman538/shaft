package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13417")
public class WFBT_13417 extends ST_KDSetup {

    @TmsLink("WFBT-13505")
    @Test(description = "GC01 | KD KIP user | WFBT-13417 | Check when a user has only CLS, No Tarif Change SO exists in the tarif page")
    public void GC01(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).assertThatTariffChangeSODoesNotExist();
    }

    @TmsLink("WFBT-13506")
    @Test(description = "GC02 | KD KIP user | WFBT-13417 | Check when a user has only CLS, No Tarif Change SO exists in the dashboard")
    public void GC02(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().assertThatTariffChangeSODoesNotExist();
    }

    @TmsLink("WFBT-13507")
    @Test(description = "GC03 | KD KIP user | WFBT-13417 | Check when a user has only CLS, No Tarif Change exists in the KIP burger menu.")
    public void GC03(){
        new KD_Dashboard(driver).openBurgerMenu().assertThatTariffChangeDoesNotExistInKIPBurgerMenu();
    }

    @TmsLink("WFBT-13508")
    @Test(description = "GC04 | KD KIP user | WFBT-13417 | Check when a user has mixed tariffs, Tarif Change SO exists in the tarif page, dashboard and in the burger menu")
    public void GC04(){
        new KD_Dashboard(driver).openBurgerMenu().assertThatTariffChangeDoesNotExistInKIPBurgerMenu();
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().assertThatTariffChangeSOExists().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).assertThatTariffChangeSOExists();
    }
}