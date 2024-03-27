package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12562")
public class WFBT_12562 extends ST_KDSetup {

    @TmsLink("WFBT_12849")
    @Test(description = "GC01 | WFBT-12562| Check When User Has Mein Tariff Only")
    public void GC01_CheckWhenUserHasMeinTariffOnly(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateMeinTariffSO(testData.getTestData(method.getName() + ".MyTariffTitle"),
                testData.getTestData(method.getName() + ".MyTariffText"),
                testData.getTestData(method.getName() + ".MyTariffDate"));
    }

    @TmsLink("WFBT_12850")
    @Test(description = "GC02 | WFBT-12562| Check When User Has CLS Only")
    public void GC02_CheckWhenUserHasCLSOnly(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateMeinTariffSO(testData.getTestData(method.getName() + ".MyTariffTitle"),
                testData.getTestData(method.getName() + ".MyTariffText"),
                testData.getTestData(method.getName() + ".MyTariffDate"));
    }

    @TmsLink("WFBT_12851")
    @Test(description = "GC03 | WFBT-12562| CheckWhenUserHasBothMeinTariffAndCLSTariffMeinTariff")
    public void GC03_CheckWhenUserHasBothMeinTariffAndCLSTariffMeinTariff(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateMeinTariffSO(testData.getTestData(method.getName() + ".MyTariffTitle"),
                testData.getTestData(method.getName() + ".MyTariffText"),
                testData.getTestData(method.getName() + ".MyTariffDate"));
    }
}