package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10400")
public class WFBT_10400 extends ST_KDSetup{

    @TmsLink("WFBT-10949")
    @Test(description = "GC01 | WFBT-10400 | assert on dynamic data retrieving in Mein Tariff SO")
    public void assertOnDynamicDateInMeinTariffSO(){
        new KD_Dashboard(driver).closeNotification().clickOnInternetAndPhoneAccordion().assertOnMeinTariffSO()
            .assertOnDynamicTariffName().assertOnEndDate();
    }

    @TmsLink("WFBT-10951")
    @Test(description = "GC02 | WFBT-10400 | check that the user is redirected to internet and phone tariff page after clicking on tarif icon from the burger menu")
    public void goToInternetAndPhoneTariffPageFromTheBurgerMenu(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).assertOnPageHeader(testData.getTestData(method.getName() + ".PageHeaderCL"));
    }
}