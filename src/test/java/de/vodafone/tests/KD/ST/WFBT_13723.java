package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13723")
public class WFBT_13723 extends ST_KDSetup {
    @TmsLink("WFBT_13807")
    @Test(description = "GC01 | KIP User | Check Mein Tarif SO when User has multiple CLS tariffs and Only one CLS is cancelled")
    public void GC02(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .valiadteMainTariffCancellationMessage(testData.getTestData(method.getName() + ".MeinTarifSOHeaderCL"), testData.getTestData(method.getName() + ".MeinTarifSOSubLineCL"));
    }
}