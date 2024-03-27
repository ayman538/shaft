package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12354")
public class WFBT_12354 extends ST_KDSetup{
    @TmsLink("WFBT-13238")
    @Test(description = "GC01 | WFBT-13238 | KD User | Check default view for booked options accordion with the main tariff and CLS drop menu")
    public void GC01(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion()
                .validateHeaderAndSubtitleBookedOptionsAcc(testData.getTestData(method.getName() + ".BookedOptionsHeaderCL")
                        ,testData.getTestData(method.getName() + ".BookedOptionsSubLineCL"));
    }

    @TmsLink("WFBT-13239")
    @Test(description = "GC02 | WFBT-13239 | KD User | Check when user choose a contract Id or smartcard from the drop down menu, all the booked options related to it are displayed")
    public void GC02(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion()
                .validateHeaderOfFirstBookedOption(testData.getTestData(method.getName() + ".HeaderOfFirstBookedOptionFSCL"))
                .clickOnDropdownMenuBookedOptionsAcc()
                .clickOnSecondSmartCardDropdownMenuBOA()
                .validateHeaderOfFirstBookedOption(testData.getTestData(method.getName() + ".HeaderOfFirstBookedOptionSSCL"))
                .clickOnDropdownMenuBookedOptionsAcc()
                .clickOnFirstContractIdDropdownMenuBOA()
                .validateHeaderOfFirstBookedOption(testData.getTestData(method.getName() + ".HeaderOfFirstBookedOptionFCCL"));
    }

    @TmsLink("WFBT-13240")
    @Test(description = "GC03 | WFBT-13240 | KD User | Check when User having only a CLS tariff we shall list the CLS options booked by the user")
    public void GC03(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion()
                .validateHeaderAndSubLineOneTariffOnly(testData.getTestData(method.getName() + ".CLSBookedOptionsHeaderCL")
                        ,testData.getTestData(method.getName() + ".CLSBookedOptionsSubLineCL"));
    }

    @TmsLink("WFBT-13241")
    @Test(description = "GC04 | WFBT-13241 | KD User | Check in case there is only one tariff (smartcard), we shall not show a dropdown menu")
    public void GC04(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion()
                .validateHeaderAndSubLineOneTariffOnly(testData.getTestData(method.getName() + ".CLSBookedOptionsHeaderCL")
                        ,testData.getTestData(method.getName() + ".CLSBookedOptionsSubLineCL"));
    }
}