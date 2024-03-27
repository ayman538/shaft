package de.vodafone.tests.eShop.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("eShop")
@Feature("SIT")
@Story("WFHT-284")
public class WFHT_262 extends SIT_eShop_Setup{
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager cookieMap;
    private HashMap<String,String> cookieSwitcherMap;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @TmsLink("WFHT-491")
    @Test(description = "GC01 - WFHT-491 - BNT consumer - Verify DOP view of a devices list for Device First Flow ")
    public void verifyDOPForDeviceFirstFlow() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateProductCardExistence();
    }
    @TmsLink("WFHT-492")
    @Test(description = "GC02 - WFHT-492-  BNT consumer - Verify DOP view of a devices list for Tariff First Flow")
    public void verifyDOPForTariffFirstFlow() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateProductCardExistence();
    }

    @TmsLink("WFHT-493")
    @Test(description = "GC03 - WFHT-493- BNT consumer - Verify the product card info. Mandatory and not Mandatory details")
    public void verifyMandatoryFields() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new DeviceListPage(driver)
                .validateProductCardMandatoryFields();
    }

    @TmsLink("WFHT-495")
    @Test(description = "GC05 -WFHT-495-  BNT consumer - Verify that 'Load more' button functionality in case user have 12 devices or less"
    )
    public void validateLoadMoreFunctionalityLessThan12() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new DeviceListPage(driver)
                .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-496")
    @Test(description = "GC06 - WFHT-496- BNT consumer - Verify 'Load more' button Functionality in case user have more than 12 devices")
    public void validateLoadMoreFunctionalityMoreThan12() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLargerThan12()
                .validateLoadMoreCTAMoreThan12();
    }

    @TmsLink("WFHT-497")
    @Test(description = "GC07 -WFHT-497-  BNT consumer - Verify that all product cards are clickable and redirects to product details page.")
    public void validateProductCardIsClickable() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new DeviceListPage(driver)
                .validateProductCardIsClickable();
    }

    @TmsLink("WFHT-498")
    @Test(description = "GC08 -WFHT-498-  BNT consumer - Verify that Monthly tariff cost will be shown only in case of tariff first flow")
    public void validateMonthlyTariffCostOnlyExistsInTariffFirstFlow() {
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new DeviceListPage(driver)
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }
    @TmsLink("WFHT-500")
    @Test(description = "BC01 - WFHT-500- Verify the error message in case displaying available devices failed (page failed to load)")
    public void validateErrorMsgPageFailedToLoad() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateErrorMsgIfPageFailed();
    }
    @TmsLink("WFHT-501")
    @Test(description = "BC02 - WFHT-502 - Verify the error message in case there are 0 devices to show.")
    public void validateErrorMsgZeroDevices() {
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateErrorMsgIfZeroDevicesDisplayed();
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        super.setup(method);
        new LoginPage(driver).
                navigateSIT().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "eShop/SIT/SIT_" + className + "_CookieSwitcher.json");
        cookieSwitcherMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "eShop/SIT/SIT_"+className+"_CookieSwitcher.json").getTestDataAsMap("$");
    }
}
