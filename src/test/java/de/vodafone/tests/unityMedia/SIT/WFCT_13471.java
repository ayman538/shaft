package de.vodafone.tests.unityMedia.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.commons.LoginPage;

import de.vodafone.pages.unityMedia.MeineRechnungenPage;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Unity Media")
@Feature("SIT")
@Story("WFCT-13471")
public class WFCT_13471 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineRechnungenPage meineRechnungenPage;
    String selectedBarOrder;
    String firstBarOrder;
    String firstBarHeight;
    String contractOrder;


    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/SIT_WFCT_13471_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/SIT/WFCT_13471.json");
    }

    @AfterMethod(description = "Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineRechnungenPage = new MeineRechnungenPage(driver);
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        selectedBarOrder = testData.getTestData(method.getName() + ".selectedBarOrder");
        firstBarOrder = testData.getTestData(method.getName() + ".firstBarOrder");
        firstBarHeight = testData.getTestData(method.getName() + ".firstBarHeight");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");

        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName, userPassword);
    }

    @Test(description = "GC03 - Ute User has Bills for the last 13 months checks meine rechnungen page")
    @TmsLink("WFCT-8578")
    public void GC03_UteUserHasBillsForTheLast13MonthsChecksMeineRechnungenPage() {
        dashboard.expandContracts(contractOrder)
                .clickMeineRechnungenTile(contractOrder);
        meineRechnungenPage.assertThatChartHas12Months();
    }

    @Test(description = "GC04 - Ute user with zero amount")
    @TmsLink("WFCT-8579")
    public void GC04_UteUserWithZeroAmount() {
        dashboard.expandContracts(contractOrder)
                .clickMeineRechnungenTile(contractOrder);
        meineRechnungenPage.assertOnBarHeight(firstBarOrder, firstBarHeight);

    }


}
