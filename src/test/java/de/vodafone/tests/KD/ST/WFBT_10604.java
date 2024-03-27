package de.vodafone.tests.KD.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.Login;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Story("WFBT-10604")
@Epic("KD")
@Feature("ST")
public class WFBT_10604 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    KD_Dashboard kdDashboard;
    TariffPageInternetAndPhone kIPTariffPage;

    @Test(description = "GC01 || validate the dashboard page for KD")
    @TmsLink("WFBT-10938")
    public void validateDashboardPageForKableDeutschland() {
        kdDashboard.validateKdDashboard();
    }

    @Test(description = "GC02 || validate that navigation to my tariff page via my tariff SO from dashboard expand my tariff accordion")
    @TmsLink("WFBT-10939")
    public void validateTariffAccordionCollapsed(Method method) {
        kdDashboard.expandProductSushiBar();
        kdDashboard.clickMyTariffFromSushiBar();
        kIPTariffPage.assertOnPageHeader(testData.getTestData(method.getName() + ".PageHeaderCL"));
        kIPTariffPage.validateMyTariffAccIsCollapsed();
    }

    @Test(description = "GC03 || check the sequence of the SOs in mein tariff page and the sequence of the relevant accordions")
    @TmsLinks({@TmsLink("WFBT-10940"),@TmsLink(("WFBT-10941"))})
    public void checkSmartObjectsSequence(Method method) {
        kdDashboard.expandProductSushiBar();
        kdDashboard.clickMyTariffFromSushiBar();
        kIPTariffPage.assertOnPageHeader(testData.getTestData(method.getName() + ".PageHeaderCL"));
        kIPTariffPage.validateMyTariffAccIsCollapsed();
        kIPTariffPage.clickMyTariffSO();
        kIPTariffPage.validateMyTariffAccIsExpanded();
        kIPTariffPage.validateMyBookedOptionsAccIsCollapsed();
        kIPTariffPage.clickBookedOptionsSO();
        kIPTariffPage.validateMyBookedOptionsAccIsExpanded();
        kIPTariffPage.validateMyBookableInternetOptionsAccIsCollapsed();
        kIPTariffPage.clickBookableInternetOptionsSO();
        kIPTariffPage.validateMyBookableInternetOptionsAccIsExpanded();
        kIPTariffPage.validateMyBookablePhoneOptionsAccIsCollapsed();
        kIPTariffPage.clickBookablePhoneOptionsSO();
        kIPTariffPage.validateMyBookablePhoneOptionsAccIsExpanded();
    }

    @Test(description = "GC04 || check The static content of the booked options accordion")
    @TmsLink("WFBT-11041")
    public void checkStaticBookedOptionMsg() {
        kdDashboard.clickOnBurgerMenuKIPMeinKabelContract();
        kdDashboard.clickMyTariffFromSushiBar();
        kIPTariffPage.clickBookedOptionsSO();
        kIPTariffPage.validateNoBookedOptionMsg();
    }

    @Test(description = "GC05 || check The static content of the bookable internet options accordion")
    @TmsLink("WFBT-11042")
    public void checkStaticBookableInternetOptionMsg() {
        kdDashboard.expandProductSushiBar();
        kdDashboard.clickMyTariffFromSushiBar();
        kIPTariffPage.clickBookableInternetOptionsSO();
        kIPTariffPage.validateNoBookableInternetOptionMsg();
    }

    @Test(description = "GC06 || check The static content of the bookable phone options accordion")
    @TmsLink("WFBT-11043")
    public void checkStaticBookablePhoneOptionMsg() {
        kdDashboard.expandProductSushiBar();
        kdDashboard.clickMyTariffFromSushiBar();
        kIPTariffPage.clickBookablePhoneOptionsSO();
        kIPTariffPage.validateNoBookablePhoneOptionMsg();
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
        new Login(driver).navigateToSTUrl()
                .setCookie(cookieMap)
                .acceptCookies()
                .stLoginAction(userName, userPassword);
        kdDashboard = new KD_Dashboard(driver);
        kIPTariffPage = new TariffPageInternetAndPhone(driver);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
