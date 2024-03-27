package de.vodafone.tests.kableDeutschland.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.Einstellungen;
import de.vodafone.pages.Kabledeutschland.MeineRechnungen;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KabelDeutschland")
@Feature("ST")
@Story("WFCT-13485")
public class WFCT_13485 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;


    @BeforeMethod()
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");

        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);


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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_13485_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_13485.json");
    }

    @Test(description = "WFCT_13485 | GC01 - SOHO user checks einstellungen tab")
    @TmsLink("WFCT-13528")
    public void GC01_SohoUserChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionNotExists();

    }

    @Test(description = "WFCT_13485 | GC02 - Consumer user checks einstellungen tab")
    @TmsLink("WFCT-13529")
    public void GC02_ConsumerUserChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionExists();
    }


}
