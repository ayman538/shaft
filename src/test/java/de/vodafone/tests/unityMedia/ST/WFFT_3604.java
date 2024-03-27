package de.vodafone.tests.unityMedia.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.Login;
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
@Story("Billing | Showing the unbilled charges for 3rd party subscription in Unbilled Charges page")
public class WFFT_3604{

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/ST_WFFT_3604_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/ST/WFFT_3604.json");
    }
    @AfterMethod(description = "Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();

        new Login(driver).navigateST()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionST(userName, userPassword);
    }

    @Test(description = "GC01- Verify 3rd party products in \"Kosntenkonrolle Page\" from the first entry point.")
    @TmsLink("WFFT-3680")
    @Issue("WFFT-4521")
    private void GC01(Method method) {
        new Dashboard(driver).clickOnKostenkontrolleFromDashboard();
        new MeineRechnungenPage(driver).clickOnKonstenKontrolleTab().clickOnTvAndVideoTab().verifyThirdPartyUnbilledCharges(
                testData.getTestData(method.getName() + ".headerTxt"),
                testData.getTestData(method.getName() + ".subHeaderTxt"),
                testData.getTestData(method.getName() + ".billName"),
                testData.getTestData(method.getName() + ".billPrice"));
        new MeineRechnungenPage(driver).clickOnTheThirdPartyBillDropDownBtn().verifyThirdPartyBillsDetails(
                testData.getTestData(method.getName() + ".billDate"),
                testData.getTestData(method.getName() + ".billDateNum"),
                testData.getTestData(method.getName() + ".billTime"));

    }

    @Test(description = "GC02- Verify 3rd party products in \"Kosntenkonrolle Page\" from the second entry point.")
    @TmsLink("WFFT-3681")
    @Issue("WFFT-4521")
    private void GC02(Method method){

        MeineRechnungenPage meineRechnungenPage = new MeineRechnungenPage(driver);
        new Dashboard(driver).clickOnKostenkontrolleFromDashboard();
        new MeineRechnungenPage(driver).clickOnTvAndVideoTab().verifyThirdPartyUnbilledCharges(
                testData.getTestData(method.getName() + ".headerTxt"),
                testData.getTestData(method.getName() + ".subHeaderTxt"),
                testData.getTestData(method.getName() + ".billName"),
                testData.getTestData(method.getName() + ".billPrice"));
        new MeineRechnungenPage(driver).clickOnTheThirdPartyBillDropDownBtn().verifyThirdPartyBillsDetails(testData.getTestData(method.getName() + ".billDate"),
                testData.getTestData(method.getName() + ".billDateNum"),
                testData.getTestData(method.getName() + ".billTime"));
    }

}
