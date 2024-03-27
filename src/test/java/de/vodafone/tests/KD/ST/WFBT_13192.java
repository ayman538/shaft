package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13192")
public class WFBT_13192 extends ST_KDSetup{

    @TmsLink("WFBT_13257")
    @Test(description = "GC01-TV | WFBT_13192 | Check Notification message in cancelled option card and the date when cancellation will be effective")
    public void GC01(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().validateCancellationPending(testData.getTestData(method.getName() + ".CancellationPendingMessage"));
    }

    @TmsLink("WFBT_13258")
    @Test(description = "GC02-KIP | WFBT_13192 | Check Notification message in cancelled option card and the date when cancellation will be effective")
    public void GC02(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickOnMeinTarifKIPBurgerMenu();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().validateCancellationPending(testData.getTestData(method.getName() + ".CancellationPendingMessage"));
    }
}