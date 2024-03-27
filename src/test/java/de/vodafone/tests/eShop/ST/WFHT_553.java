package de.vodafone.tests.eShop.ST;

import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("eShop")
@Feature("ST")
@Story("WFHT-553")
public class WFHT_553 extends ST_eShop_Setup{

    @TmsLink("WFHT-601")
    @Test(description = "GC01 -  WFHT-601- Young - Verify DOP view of a devices list for Device First Flow")
    public void GC01() {
            new eShop_Dashboard(driver)
                    .deepLinkToDeviceFirstFlow();

            new DeviceListPage(driver)
                    .validateDevicesCounter()
                    .validateProductCardExistence();
    }

    @TmsLink("WFHT-602")
    @Test(description = "GC02 -WFHT-602-  Young - Verify DOP view of a devices list for Tariff First Flow")
    public void GC02() {
            new eShop_Dashboard(driver)
                    .deepLinkToTariffFirstFlowYoung();

            new DeviceListPage(driver)
                    .validateDevicesCounter()
                    .validateProductCardExistence();
    }

    @TmsLink("WFHT-603")
    @Test(description = "GC03 - WFHT-603-  Young - Verify the product card info. Mandatory and not Mandatory details")
    public void GC03() {
            new eShop_Dashboard(driver)
                    .deepLinkToDeviceFirstFlow();

            new DeviceListPage(driver)
                    .validateProductCardMandatoryFieldsYoung();
    }

    @TmsLink("WFHT-604")
    @Test(description = "GC04 -WFHT-604-  Young -Verify that Monthly tariff cost will be shown only in case of tariff first flow.")
    public void GC04() {
        new eShop_Dashboard(driver)
         .deepLinkToTariffFirstFlowYoung();

        new DeviceListPage(driver)
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }

    @TmsLink("WFHT-606")
    @Test(description = "GC06 -WFHT-606-  Young - Verify Load more button Functionality in case user have more than 12 devices")
    public void GC06() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLargerThan12()
                .validateLoadMoreCTAMoreThan12();
    }

    @TmsLink("WFHT-607")
    @Test(description = "GC07 -WFHT-607 - Young - Verify that all product cards are clickable and redirects to product details page.")
    public void GC07() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateProductCardIsClickable();
    }

    @TmsLink("WFHT-608")
    @Test(description = "GC08 - WFHT-608-  Young - Verify that Load more button functionality in case user have 12 devices or less")
    public void GC08() {
            new eShop_Dashboard(driver)
                    .deepLinkToDeviceFirstFlow();

            new DeviceListPage(driver)
                    .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-612")
    @Test(description = "BC01 - WFHT-612- Young - Verify the error message in case displaying available devices failed (page failed to load)")
    public void BC01() {
            new eShop_Dashboard(driver)
                    .deepLinkToTariffFirstFlowYoung();

            new DeviceListPage(driver)
                    .validateErrorMsgIfPageFailed();
    }

    @TmsLink("WFHT-613")
    @Test(description = "BC02 - WFHT-613- Young - Verify the error message in case there are 0 devices to show.")
    public void BC02() {
            new eShop_Dashboard(driver)
                    .deepLinkToTariffFirstFlowYoung();

            new DeviceListPage(driver)
                    .validateErrorMsgIfZeroDevicesDisplayed();
    }
}








