package de.vodafone.tests.eShop.ST;

import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("eShop")
@Feature("ST")
@Story("WFHT-554")
public class WFHT_554 extends ST_eShop_Setup{

    @TmsLink("WFHT-656")
    @Test(description = "GC01 - BNT Red+ - Verify Device Overview Page for Device/Tariff First Flow")
    public void GC01() {
       new eShop_Dashboard(driver)
               .deepLinkToTariffFirstFlowRedPlus();

       new DeviceListPage(driver)
               .validateDevicesCounter()
               .validateRedPlusProductCardMandatoryFields()
               .verifyMonthlyTariffCostShownInTariffFirstFlow();

    }

    @TmsLink("WFHT-658")
    @Test(description = "GC03 - BNT Red+ - Verify More info link Redirects to product details page")
    public void GC03() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowRedPlus();

        new DeviceListPage(driver)
                .validateProductCardIsLoaded()
                .clickOnZumProductButton()
                .verifyMoreInfoLinkRedirection();
    }

    @TmsLink("WFHT-660")
    @Test(description = "GC05 - BNT Red+ - Verify Load more button will be hidden when there are 12 or less devices to be displayed")
    public void GC05() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowRedPlus();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLessThan12()
                .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-661")
    @Test(description = "GC06 - BNT Red+ - Verify Load more button will be displayed when there is more than 12 devices to be displayed")
    public void GC06() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowRedPlus();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLargerThan12()
                .validateLoadMoreCTAMoreThan12();
    }

    @TmsLink("WFHT-662")
    @Test(description = "GC07 - BNT Red+ - Verify that Monthly tariff cost will be shown only in case of tariff first flow")
    public void GC07() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowRedPlus();

        new DeviceListPage(driver)
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }

    @TmsLink("WFHT-665")
    @Test(description = "BC01 - BNT Red+ - Verify Message shall be displayed when there are zero devices to show")
    public void BC01() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowRedPlus();

        new DeviceListPage(driver)
                .validateErrorMsgIfZeroDevicesDisplayedRedPlus();
    }

    @TmsLink("WFHT-666")
    @Test(description = "BC02 - BNT Red+ - Verify Message shall be displayed when displaying available devices failed")
    public void BC02() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowRedPlus();

        new DeviceListPage(driver)
                .validateErrorMsgIfPageFailed();
    }
}








