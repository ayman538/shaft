package de.vodafone.tests.eShop.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.Soho_eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("eShop")
@Feature("SIT")
@Story("WFHT-552")
public class WFHT_552 extends SIT_eShop_Setup {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager cookieMap;
    private HashMap<String,String> cookieSwitcherMap;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

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

    @TmsLink("WFHT-627")
    @Test(description = "GC01 - BNT SOHO - Verify Overview Page for Device First Flow")
    public void GC01() {
       new Soho_eShop_Dashboard(driver)
               .deeplinkToDeviceFirstFlowPageSIT();

       new DeviceListPage(driver)
               .validateDevicesCounter()
               .validateSohoProductCardMandatoryFields()
               .verifyMonthlyTariffCostNOTEXISTEDInDeviceFirstFlow();

    }

    @TmsLink("WFHT-628")
    @Test(description = "GC02 - BNT SOHO - Verify Overview Page for Tariff First Flow")
    public void GC02() {
        new Soho_eShop_Dashboard(driver)
                .deeplinkToTariffFirstFlowPageSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateSohoProductCardMandatoryFields()
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }

    @TmsLink("WFHT-630")
    @Test(description = "GC04 - BNT SOHO - Verify More info link Redirects to product details page")
    public void GC04() {
        new Soho_eShop_Dashboard(driver)
                .deeplinkToDeviceFirstFlowPageSIT();

        new DeviceListPage(driver)
                .validateProductCardIsLoaded()
                .clickOnZumProductButton()
                .verifyMoreInfoLinkRedirection();
    }

    @TmsLink("WFHT-634")
    @Test(description = "GC06 - BNT SOHO - Verify Load more button will be hidden when there are 12 or less devices to be displayed")
    public void GC06() {
        new Soho_eShop_Dashboard(driver)
                .deeplinkToTariffFirstFlowPageSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLessThan12()
                .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-635")
    @Test(description = "GC07 - BNT SOHO - Verify Load more button will be displayed when there is more than 12 devices to be displayed")
    public void GC07() {
        new Soho_eShop_Dashboard(driver)
                .deeplinkToDeviceFirstFlowPageSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLargerThan12()
                .validateLoadMoreCTAMoreThan12();
    }

    @TmsLink("WFHT-637")
    @Test(description = "GC08 - BNT SOHO - Verify that Monthly tariff cost will be shown only in case of tariff first flow")
    public void GC08() {
        new Soho_eShop_Dashboard(driver)
                .deeplinkToTariffFirstFlowPageSIT();

        new DeviceListPage(driver)
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }

    @TmsLink("WFHT-640")
    @Test(description = "BC01 - BNT SOHO - Verify Message shall be displayed when there are zero devices to show")
    public void BC01() {
        new Soho_eShop_Dashboard(driver)
                .deeplinkToDeviceFirstFlowPageSIT();

        new DeviceListPage(driver)
                .validateErrorMsgIfZeroDevicesDisplayedSoho();
    }

    @TmsLink("WFHT-641")
    @Test(description = "BC02 - BNT SOHO - Verify Message shall be displayed when displaying available devices failed")
    public void BC02() {
        new Soho_eShop_Dashboard(driver)
                .deeplinkToTariffFirstFlowPageSIT();

        new DeviceListPage(driver)
                .validateErrorMsgIfPageFailed();
    }
}








