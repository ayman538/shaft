package de.vodafone.tests.kableDeutschland.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.Kontostand;
import de.vodafone.pages.Kabledeutschland.MeineRechnungen;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFCT_15248")
public class WFCT_15248 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kontostand kontostand;
    String firstPill , secondPill , thirdPill;
    @BeforeMethod()
    public void setup(Method method) {
        driver= new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kontostand = new Kontostand(driver);
        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        firstPill = testData.getTestData(method.getName()+".firstPill");
        secondPill = testData.getTestData(method.getName()+".secondPill");
        thirdPill = testData.getTestData(method.getName()+".thirdPill");


        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_15248_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_15248.json");
    }

    @Test(description = "GC01 - Martin user with no paymentType checks the filter pill")
    @TmsLink("WFCT-15534")
    public void GC01_MartinWithOneProductNoPaymentTypeChecksKontostandPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickOnKontostandTab();
        kontostand.assertThatFilterPillDoesNotExist(firstPill);
        kontostand.assertOnNoPaymentTypeNotification();
        kontostand.assertOnNoPaymentTypeNotificationColor();
    }
    @Test(description = "GC02 - Martin user with many products no payment type checks Kontostand page")
    @TmsLink("WFCT-15594")
    public void GC02_MartinWithManyProductsNoPaymentTypeChecksKontostandPage(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickOnKontostandTab();
        kontostand.assertThatFilterPillDoesNotExist(thirdPill);
        kontostand.assertThatFilterPillExists(firstPill);
        kontostand.assertThatFilterPillExists(secondPill);
    }

}