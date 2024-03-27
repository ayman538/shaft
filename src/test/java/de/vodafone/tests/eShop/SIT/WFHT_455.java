package de.vodafone.tests.eShop.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.eShop.ManufacturersPage;
import de.vodafone.pages.eShop.eShop_Dashboard;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("eShop")
@Feature("SIT")
@Story("WFHT-455")
public class WFHT_455 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager cookieMap;
    private HashMap<String,String> cookieSwitcherMap;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @TmsLink("WFHT-626")
    @Test(description = "GC01-BNT-Verify the view of all the available devices")
    public void validateOnViewOfAvailableDevices(){
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();
        new ManufacturersPage(driver)
                .checkNumberOfDisplayedDevices()
                 .validateProductCardIsClickable();
    }

    @TmsLink("WFHT-644")
    @Test(description = "GC03-BNT-Verify that the whole product card is clickable and the more info link is clickable and redirection")
    public void validateOnWholeProductCard(){
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new ManufacturersPage(driver)
                .clickOnMoreInfoLink();

    }

    @TmsLink("WFHT-650")
    @Test(description = "GC09-BNT-Verify that load more button is hidden when 12 devices or less is displayed.")
    public void verifyThatLoadMoreButtonIsHidden(){
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSIT();

        new ManufacturersPage(driver)
                .validateDevicesNumberLessThan12()
                .validateLoadMoreCTALessThanOrEqual12();
    }

    @TmsLink("WFHT-651")
    @Test(description = "GC10-BNT-Verify that the number of displayed devices (counter) is changed when choosing any manufacturer.")
    public void validateOnNumberOfDisplayedDevices(){
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new ManufacturersPage(driver)
                .checkNumberOfDisplayedDevices();

    }

    @TmsLink("WFHT-653")
    @Test(description = "GC12-BNT -Verify the view of all the available devices in case of Tariff first flow.")
    public void validateOnViewOfAvailableDevicesInCaseOfTariffFirstFlow(){
        new eShop_Dashboard(driver)
                .deepLinkToTariffFirstFlowSIT();

        new ManufacturersPage(driver)
                .checkNumberOfDisplayedDevices()
                .validateProductCardIsClickable();

    }

    @TmsLink("WFHT-654")
    @Test(description = "BC01-BNT- Verify that an error message will be shown in case of available devices failed to load.")
    public void validateOnErrorMessageInCaseOfAvailableDevicesFailedToload(){
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new ManufacturersPage(driver)
                .assertThatErrorMessageAppearsInCaseOfFailureInLoading();
    }

    @TmsLink("WFHT-655")
    @Test(description = "BC02-BNT-Verify that an error message will be shown in case of zero devices are displayed.")
    public void validateOnErrorMessageInCaseOfZeroDevices(){
        new eShop_Dashboard(driver)
                .deepLinkToDeviceFirstFlowSIT();

        new ManufacturersPage(driver)
                .assertOnZeroDevicesAreDisplayed();
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new LoginPage(driver).
                navigateST().
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








