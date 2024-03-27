package de.vodafone.tests.unityMedia.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.MeineRechnungenPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
@Epic("Unity Media")
@Feature("ST")
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
    String notSelectedBarOrder;
    String dateValue;
    String amountValue;
    String firstBarOrder;
    String firstBarHeight;
    String secondBarOrder;
    String secondBarHeight;

    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/ST_WFCT_13471_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/ST/WFCT_13471.json");
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
        notSelectedBarOrder = testData.getTestData(method.getName() + ".notSelectedBarOrder");
        dateValue = testData.getTestData(method.getName() + ".dateValue");
        amountValue = testData.getTestData(method.getName() + ".amountValue");
        firstBarOrder = testData.getTestData(method.getName() + ".firstBarOrder");
        firstBarHeight = testData.getTestData(method.getName() + ".firstBarHeight");
        secondBarOrder = testData.getTestData(method.getName() + ".secondBarOrder");
        secondBarHeight = testData.getTestData(method.getName() + ".secondBarHeight");

        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }


    @Test(description = "GC02- Ute user with no bills retreived in some months checks the bill chart")
    @TmsLink("WFCT-9274")
    public void GC02_UteUserWithNoBillsRetrievedInSomeMonthsChecksTheBillchart() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertOnNotRetrievedBarHeight(selectedBarOrder)
                .assertOnNotClickableMonth(selectedBarOrder);
    }

    //note that this TC will fail on local machines change the date value in the test data file to 21.05.2023 to make it pass on local machines
    @Test(description = "GC01 - Ute User has External and internal Bills for the last 12 months checks meine rechnungen page")
    @TmsLink("WFCT-8576")
    public void GC01_UteUserHasExternalAndInternalBillsForTheLast12MonthsChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertOnSelectedBarColor(selectedBarOrder)
                .assertOnNotSelectedBarColor(notSelectedBarOrder)
                .assertThatChartHas12Months()
                .assertOnDateValue(dateValue)
                .assertOnAmountValue(amountValue);

    }

    @Test(description = "GC03 - Ute User has Bills for the last 13 months checks meine rechnungen page")
    @TmsLink("WFCT-8578")
    public void GC03_UteUserHasBillsForTheLast13MonthsChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertThatChartHas12Months();
    }

    @Test(description = "GC05 - Suspended Ute User has Bills checks meine rechnungen page")
    @TmsLink("WFCT-8646")
    public void GC05_SuspendedUteUserHasBillsChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertThatChartHas12Months()
                .assertOnTheBelowChartText();

    }

    @Test(description = "GC06 - Cancelled Ute User has Bills checks meine rechnungen page")
    @TmsLink("WFCT-8647")
    public void GC06_CancelledUteUserHasBillsChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertThatChartHas12Months()
                .assertOnTheBelowChartText();

    }

    @Test(description = "GC07 - Ute User Checks The Bar Height")
    @TmsLink("WFCT-8745")
    public void GC07_UteUserChecksTheBarHeight() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage
                .assertOnBarHeight(firstBarOrder, firstBarHeight)
                .assertOnBarHeight(secondBarOrder, secondBarHeight);

    }

    @Test(description = "GC08_Ute User Check The Bill Chart In Case No Amount Is Returned In The BE")
    @TmsLink("WFCT-8746")
    public void GC08_UteUserCheckTheBillChartInCaseNoAmountIsReturnedInTheBE() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertOnBarHeight(firstBarOrder, firstBarHeight);

    }

    @Test(description = "GC04 - Ute user with zero amount")
    @TmsLinks({@TmsLink("WFCT-8579"),@TmsLink("WFCT-9273")})
    public void GC04_UteUserWithZeroAmount() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertOnBarHeight(firstBarOrder, firstBarHeight);

    }
    @Test(description = "GC02 - Ute User has One Bill checks meine rechnungen page")
    @TmsLink("WFCT-8579")
    public void GC02_UteUserHasOneBillChecksMeineRechnungenPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungenPage.assertOnBarHeight(firstBarOrder, firstBarHeight);
        for(int i = 1; i < 12 ; i++){
            meineRechnungenPage.assertOnBarHeight(Integer.toString(i), "0px");

        }

    }


}
