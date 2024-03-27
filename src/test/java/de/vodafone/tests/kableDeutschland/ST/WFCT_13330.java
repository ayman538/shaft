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
@Story("WFCT-13330")
public class WFCT_13330 {

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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_13330_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_13330.json");
    }

    @Test(description = "WFCT_13330 | GC01 - SOHO user with phone product checks einstellungen tab")
    @TmsLink("WFCT-13386")
    public void GC01_SohoUserWithPhoneProductChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionNotExists();

    }

    @Test(description = "WFCT_13330 | GC02 - SOHO user with No phone product checks einstellungen tab")
    @TmsLink("WFCT-13387")
    public void GC02_SohoUserWithNoPhoneProductChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionNotExists();
    }

    @Test(description = "WFCT_13330 | GC03 - Consumer user with phone product checks einstellungen tab")
    @TmsLink("WFCT-13388")
    public void GC03_ConsumerUserWithPhoneProductChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionExists();

    }

    @Test(description = "WFCT_13330 | GC04 - Consumer user with No phone product checks einstellungen tab")
    @TmsLink("WFCT-13389")
    public void GC04_ConsumerUserWithNoPhoneProductChecksEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionNotExists();
    }

    @Test(description = "WFCT_13330 | GC05 - Consumer user with No phone product deeplink to options page")
    @TmsLink("WFCT-13391")
    public void GC05_ConsumerUserWithNoPhoneProductDeepLinksToOptionsPage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.navigateToOptionsPage();
        einstellungen.assertThatOptionsAccordionNotExists();
        einstellungen.assertThatBillTypeSectionExists();
    }

}
