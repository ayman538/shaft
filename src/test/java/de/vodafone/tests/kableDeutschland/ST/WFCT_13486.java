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
@Story("WFCT-13486")
public class WFCT_13486 {

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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_13486_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_13486.json");
    }

    @Test(description = "WFCT_13486 | BC01 - Martin user with error in product inventory service")
    @TmsLink("WFCT-13540")
    public void BC01_MartinUserWithErrorInProductInventoryService() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnProductAndItemizedErrorNotificationTitle();
        einstellungen.assertOnProductAndItemizedErrorNotificationBody();
        einstellungen.assertThatItemizedBillSectionNotExists();
        einstellungen.assertThatBillTypeSectionExists();

    }

    @Test(description = "WFCT_13486 | BC02 - Consumer user with error in itemized bill service")
    @TmsLink("WFCT-13541")
    public void BC02_ConsumerUserWithErrorInItemizedBillService() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnProductAndItemizedErrorNotificationTitle();
        einstellungen.assertOnProductAndItemizedErrorNotificationBody();
        einstellungen.assertThatItemizedBillSectionNotExists();
        einstellungen.assertThatBillTypeSectionExists();
    }

    @Test(description = "WFCT_13486 | BC03 - Martin user with error in both itemized bill and invoice settings services")
    @TmsLink("WFCT-13542")
    public void BC03_MartinUserWithErrorInItemizedBillAndInvoiceSettingsServices() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnGeneralErrorNotificationTitle();
        einstellungen.assertOnGeneralErrorNotificationDescription();
        einstellungen.assertThatProductAndItemizedErrorNotificationNotExists();

    }

    @Test(description = "WFCT_13486 | BC04 - SOHO user with an error in itemized bill service")
    @TmsLink("WFCT-13543")
    public void BC04_SohoUserWithErrorInItemizedBillService() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionNotExists();
        einstellungen.assertThatProductAndItemizedErrorNotificationNotExists();
        einstellungen.assertThatBillTypeSectionExists();
    }

    @Test(description = "WFCT_13486 | BC05 - Consumer user with no phone product has an error in itemized bill service")
    @TmsLink("WFCT-13544")
    public void BC05_ConsumerUserNoPhoneProductHasErrorInItemizedBillService() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertThatItemizedBillSectionNotExists();
        einstellungen.assertThatProductAndItemizedErrorNotificationNotExists();
        einstellungen.assertThatBillTypeSectionExists();
    }

}
