package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13150")
public class WFBT_13150 extends ST_KDSetup{

    @TmsLink("WFBT_13469")
    @Test(description = "GC01 | KD KIP User | check when user has cancelled main tariff should be displayed a message that informs me that I have a cancelled main tariff in bookable internet accordion")
    public void GC01(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().valiadteMainTariffCancellationMessage(testData.getTestData(method.getName() + ".MainTariffCancellationMessageHeaderCL")
                ,testData.getTestData(method.getName() + ".MainTariffCancellationMessageBodyCL"));
    }

    @TmsLink("WFBT_13470")
    @Test(description = "GC02 | KD KIP User | check when user has cancelled contract should be displayed a message that informs me that I have a cancelled main tariff in bookable phone accordion")
    public void GC02(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickDropdownMenuBookableInternet()
                .clickOnContractIDDropdownMenuBookableInternet()
                .valiadteMainTariffCancellationMessage(testData.getTestData(method.getName() + ".MainTariffCancellationMessageHeaderCL")
                ,testData.getTestData(method.getName() + ".MainTariffCancellationMessageBodyCL"));
    }

    @TmsLink("WFBT_13471")
    @Test(description = "GC03 | KD KIP User | check when user has cancelled main tariff and CLS tariff exist should be displayed a message that informs me that I have a cancelled main tariff in bookable internet accordion has dropdown menu")
    public void GC03(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickDropdownMenuBookableInternet()
                .clickOnContractIDDropdownMenuBookableInternet().valiadteMainTariffCancellationMessageDoesnotExist();
    }

    @TmsLink("WFBT_13472")
    @Test(description = "GC04 | KD KIP User | check when user has cancelled CLS tariff and main tariff exist should be displayed a message that informs me that I have a cancelled CLS tariff in bookable phone accordion has dropdown menu")
    public void GC04(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion()
                .valiadteMainTariffCancellationMessageDoesnotExist();
    }
}