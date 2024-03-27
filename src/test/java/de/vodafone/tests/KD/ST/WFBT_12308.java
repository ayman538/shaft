package de.vodafone.tests.KD.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12308")
public class WFBT_12308 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    String GigaZuhauseCabelMaxNameCL;
    String GigaZuhause1000MainTariffCL;
    KD_Dashboard kdDashboard;
    TariffPageInternetAndPhone internetAndPhoneTariff;

    @TmsLink("WFBT_12521")
    @Test(description = "GC01 | WFBT_12521 | Check when user has both tariffs available i will show GigaZuhause cable max 1000 in tariff change in main tariff Accordion")
    public void GC01_CheckWhenUserHasBothTariffsAvailableInTraiffChangeAccordion(){
        kdDashboard.expandKabelInternetAndPhoneAcc();
        kdDashboard.clickMeinTariffSmartObject();
        internetAndPhoneTariff.validateGigaZuhauseCabelMaxTariffChangeExist(GigaZuhauseCabelMaxNameCL);
    }

    @TmsLink("WFBT_12766")
    @Test(description = "GC02 | WFBT_12766 | Check when user has GigaZuhause 1000 Kabel booked then GigaZuhause CableMax 1000 shall not be hidden")
    public void GC02_CheckWhenUserHasGigaZuhause1000KabelBooked(){
        kdDashboard.expandKabelInternetAndPhoneAcc();
        kdDashboard.clickMeinTariffSmartObject();
        internetAndPhoneTariff.validateGigaZuhause1000Cabel(GigaZuhause1000MainTariffCL);
        internetAndPhoneTariff.validateGigaZuhauseCabelMaxTariffChangeExist(GigaZuhauseCabelMaxNameCL);
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KD/ST/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KD/ST/" + className + ".json");
    }
    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
        kdDashboard = new KD_Dashboard(driver);
        internetAndPhoneTariff = new TariffPageInternetAndPhone(driver);
        GigaZuhauseCabelMaxNameCL = testData.getTestData(method.getName() + ".GigaZuhauseCabelMaxNameCL");
        GigaZuhause1000MainTariffCL = testData.getTestData(method.getName() + ".GigaZuhause1000MainTariffCL");
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
