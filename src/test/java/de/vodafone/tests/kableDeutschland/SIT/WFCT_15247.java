package de.vodafone.tests.kableDeutschland.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.*;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KabelDeutschland")
@Feature("SIT")
@Story("WFCT-15247")

public class WFCT_15247 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Rechnungsarchiv rechnungsarchiv;
    Kontostand kontostand;
    String secondProductOrder , internetAndPhoneNewCl,collectionCl , pillOrder;


    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        rechnungsarchiv = new Rechnungsarchiv(driver);
        kontostand = new Kontostand(driver);
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        secondProductOrder = testData.getTestData(method.getName() + ".secondProductOrder");
        internetAndPhoneNewCl = testData.getTestData(method.getName() + ".internetAndPhoneNewCl");
        collectionCl = testData.getTestData(method.getName() + ".collectionCl");
        pillOrder = testData.getTestData(method.getName() + ".pillOrder");
        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName, userPassword);
    }

    @AfterMethod(alwaysRun = true)
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass(alwaysRun = true)
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/SIT_WFCT_15247_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/SIT/WFCT_15247.json");
    }


    @Test(description = "GC05 - Martin user has internet and phone prodcut checks the 'Produktart' column")
    @TmsLink("WFCT-15538")
    public void GC05_MartinHasInternetAndPhoneChecksProduktartColumn() {
        dashboard.clickMeineRechnungenTile();
        rechnungsarchiv.assertOnProductCl(secondProductOrder,internetAndPhoneNewCl);
    }

    @Test(description = "GC03 - Martin user has more than a product checks the account balance page")
    @TmsLink("WFCT-15472")
    public void GC03_MartinHasMoreThanProductChecksAccountBalancePage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickOnKontostandTab();
        kontostand.assertOnPillCl(pillOrder,collectionCl);
    }

}
