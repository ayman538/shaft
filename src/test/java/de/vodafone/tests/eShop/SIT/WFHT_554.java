package de.vodafone.tests.eShop.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.eShop.DeviceListPage;
import de.vodafone.pages.eShop.RedPlusEshopDashboardPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("eShop")
@Feature("SIT")
@Story("WFHT-554")
public class WFHT_554 extends SIT_eShop_Setup{
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

    @TmsLink("WFHT-656")
    @Test(description = "GC01 - BNT Red+ - Verify Device Overview Page for Device/Tariff First Flow")
    public void GC01() {
       new RedPlusEshopDashboardPage(driver)
               .deepLinkToTariffFirstFlowSIT();

       new DeviceListPage(driver)
               .validateDevicesCounter()
               .validateRedPlusProductCardMandatoryFields()
               .verifyMonthlyTariffCostShownInTariffFirstFlow();

    }

    @TmsLink("WFHT-658")
    @Test(description = "GC03 - BNT Red+ - Verify More info link Redirects to product details page")
    public void GC03() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateProductCardIsLoaded()
                .clickOnZumProductButton()
                .verifyMoreInfoLinkRedirection();
    }

    @TmsLink("WFHT-660")
    @Test(description = "GC05 - BNT Red+ - Verify Load more button will be hidden when there are 12 or less devices to be displayed")
    public void GC05() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLessThan12()
                .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-661")
    @Test(description = "GC06 - BNT Red+ - Verify Load more button will be displayed when there is more than 12 devices to be displayed")
    public void GC06() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateDevicesCounter()
                .validateDevicesNumberLargerThan12()
                .validateLoadMoreCTAMoreThan12();
    }

    @TmsLink("WFHT-662")
    @Test(description = "GC07 - BNT Red+ - Verify that Monthly tariff cost will be shown only in case of tariff first flow")
    public void GC07() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .verifyMonthlyTariffCostShownInTariffFirstFlow();
    }

    @TmsLink("WFHT-665")
    @Test(description = "BC01 - BNT Red+ - Verify Message shall be displayed when there are zero devices to show")
    public void BC01() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateErrorMsgIfZeroDevicesDisplayedRedPlus();
    }

    @TmsLink("WFHT-666")
    @Test(description = "BC02 - BNT Red+ - Verify Message shall be displayed when displaying available devices failed")
    public void BC02() {
        new RedPlusEshopDashboardPage(driver)
                .deepLinkToTariffFirstFlowSIT();

        new DeviceListPage(driver)
                .validateErrorMsgIfPageFailed();
    }
}








