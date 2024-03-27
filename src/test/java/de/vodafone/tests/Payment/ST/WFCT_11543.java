package de.vodafone.tests.Payment.ST;


import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.TopUp;
import de.vodafone.pages.Payment.TopupGPP;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
public class WFCT_11543 extends ST_PaymentSetup {
    String contract_number;
    String autoTopupAmount;
    String autoTopupDate;

    @Test
    @Description("GC01 - Paul user with 28 days autotopup checks GPP")
    @TmsLink("WFCT-11717")
    public void GC01_PaulUserWith28DaysAutoTopupChecksGPP(Method method) {
        new Dashboard(driver).clickTopUpTile(contract_number);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).checkAutoTopupSavedPaymentMethod28DaysCL(autoTopupAmount, autoTopupDate);
    }
    @Test
    @Description("GC01 - Paul user with <5 Euros autotopup checks GPP")
    @TmsLink("WFCT-11718")
    public void GC02_PaulUserWithLessThan5EurosAutoTopupChecksGPP() {
        new Dashboard(driver).clickTopUpTile(contract_number);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).assertThatAutoTopupSavedPaymentMethodlessthan5EurosCL(autoTopupAmount);
    }
    @BeforeMethod()
    @Description("Setting contract number, topup amount and topup date")
    public void beforeMethod(Method method) {
        contract_number = testData.getTestData(method.getName() + ".contract_number");
        autoTopupAmount = testData.getTestData(method.getName() + ".autotopupAmount");
        autoTopupDate = testData.getTestData(method.getName() + ".autotopupDate");
    }

}
