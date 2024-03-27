package de.vodafone.tests.eShop.ST;

import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;


@Epic("eShop")
@Feature("ST")
@Story("WFHT-552")
public class WFHT_552 extends ST_eShop_Setup{
    @TmsLink("WFHT-627")
    @Test(description = "GC01 - BNT SOHO - Verify Overview Page for Device First Flow")
    public void GC01() {
       new eShop_Dashboard(driver)
               .deepLinkToDeviceFirstFlow();

       new DeviceListPage(driver)
               .validateDevicesCounter()
               .validateSohoProductCardMandatoryFields()
               .verifyMonthlyTariffCostNOTEXISTEDInDeviceFirstFlow();

    }

    @TmsLink("WFHT-628")
    @Test(description = "GC02 - BNT SOHO - Verify Overview Page for Tariff First Flow")
    public void GC02() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSoho();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateSohoProductCardMandatoryFields()
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }

    @TmsLink("WFHT-630")
    @Test(description = "GC04 - BNT SOHO - Verify More info link Redirects to product details page")
    public void GC04() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateProductCardIsLoaded()
                .clickOnZumProductButton()
                .verifyMoreInfoLinkRedirection();
    }

    @TmsLink("WFHT-634")
    @Test(description = "GC06 - BNT SOHO - Verify Load more button will be hidden when there are 12 or less devices to be displayed")
    public void GC06() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSoho();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLessThan12()
                .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-635")
    @Test(description = "GC07 - BNT SOHO - Verify Load more button will be displayed when there is more than 12 devices to be displayed")
    public void GC07() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLargerThan12()
                .validateLoadMoreCTAMoreThan12();
    }

    @TmsLink("WFHT-637")
    @Test(description = "GC08 - BNT SOHO - Verify that Monthly tariff cost will be shown only in case of tariff first flow")
    public void GC08() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSoho();

        new DeviceListPage(driver)
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }

    @TmsLink("WFHT-640")
    @Test(description = "BC01 - BNT SOHO - Verify Message shall be displayed when there are zero devices to show")
    public void BC01() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateErrorMsgIfZeroDevicesDisplayedSoho();
    }

    @TmsLink("WFHT-641")
    @Test(description = "BC02 - BNT SOHO - Verify Message shall be displayed when displaying available devices failed")
    public void BC02() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSoho();

        new DeviceListPage(driver)
                .validateErrorMsgIfPageFailed();
    }
}








