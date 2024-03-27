package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Test
public class WFBT_11703 extends ST_KDSetup{
    @TmsLink("WFBT_11784")
    @Test(description = "GC01 Check that a notification appears to the user in the Option card, notifies him to cancel through the hotline in KIP Page")
    public void GC01_CheckCancellationNotificationCardHotlineInBookedOptionsKIPPage(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).assertOnPageHeader(testData.getTestData(method.getName() + ".PageHeaderCL"))
                .expandBookedOptionsAccordion()
                .validateCancellationNotificationCard(testData.getTestData(method.getName() + ".CancellationNotificationBodyCL"));
    }

    @TmsLink("WFBT_11785")
    @Test(description = "WFBT_11785 || GC02 Check that a notification appears to the user in the Option card, notifies him to cancel through the hotline in Kabel-TV Page")
    public void GC02_CheckCancellationNotificationCardHotlineInBookedOptionsTVPage(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion()
                .clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAcc()
                .validateBookedOptionNegativePriceKabelTV(testData.getTestData(method.getName() + ".bookedOptionNegativePriceTVCL")
                ,testData.getTestData(method.getName() + ".bookedOptionCurrencyCL")
                        ,testData.getTestData(method.getName() + ".bookedOptionNegativePriceTextTVCL")
                ,testData.getTestData(method.getName() + ".bookedOptionNegativePriceNotificationTVCL"));
    }
}