package de.vodafone.tests.eShop.ST;

import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;

@Epic("eShop")
@Feature("ST")
@Story("WFHT-284")
public class WFHT_262 extends ST_eShop_Setup{
    @TmsLink("WFHT-491")
    @Test(description = "GC01 - WFHT-491 - BNT consumer - Verify DOP view of a devices list for Device First Flow ")
    public void verifyDOPForDeviceFirstFlow() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateProductCardExistence();
    }
    @TmsLink("WFHT-492")
    @Test(description = "GC02 - WFHT-492-  BNT consumer - Verify DOP view of a devices list for Tariff First Flow")
    public void verifyDOPForTariffFirstFlow() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowConsumer();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateProductCardExistence();
    }

    @TmsLink("WFHT-493")
    @Test(description = "GC03 - WFHT-493- BNT consumer - Verify the product card info. Mandatory and not Mandatory details")
    public void verifyMandatoryFields() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateProductCardMandatoryFields();
    }

    @TmsLink("WFHT-495")
    @Test(description = "GC05 -WFHT-495-  BNT consumer - Verify that 'Load more' button functionality in case user have 12 devices or less"
    )
    public void validateLoadMoreFunctionalityLessThan12() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLessThan12()
                .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-496")
    @Test(description = "GC06 - WFHT-496- BNT consumer - Verify 'Load more' button Functionality in case user have more than 12 devices")
    public void validateLoadMoreFunctionalityMoreThan12() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLargerThan12()
                .validateLoadMoreCTAMoreThan12();
    }

    @TmsLink("WFHT-497")
    @Test(description = "GC07 -WFHT-497-  BNT consumer - Verify that all product cards are clickable and redirects to product details page.")
    public void validateProductCardIsClickable() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlow();

        new DeviceListPage(driver)
                .validateProductCardIsClickable();
    }

    @TmsLink("WFHT-498")
    @Test(description = "GC08 -WFHT-498-  BNT consumer - Verify that Monthly tariff cost will be shown only in case of tariff first flow")
    public void validateMonthlyTariffCostOnlyExistsInTariffFirstFlow() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowConsumer();

        new DeviceListPage(driver)
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }
    @TmsLink("WFHT-500")
    @Test(description = "BC01 - WFHT-500- Verify the error message in case displaying available devices failed (page failed to load)")
    public void validateErrorMsgPageFailedToLoad() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowConsumer();

        new DeviceListPage(driver)
                .validateErrorMsgIfPageFailed();
    }
    @TmsLink("WFHT-501")
    @Test(description = "BC02 - WFHT-502 - Verify the error message in case there are 0 devices to show.")
    public void validateErrorMsgZeroDevices() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowConsumer();

        new DeviceListPage(driver)
                .validateErrorMsgIfZeroDevicesDisplayed();
    }
}
