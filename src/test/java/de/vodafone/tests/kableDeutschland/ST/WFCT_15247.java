package de.vodafone.tests.kableDeutschland.ST;

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

@Epic("KableDeutschland")
@Feature("ST")
@Story("WFCT_15247")
public class WFCT_15247 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String otherProductCl;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Rechnungsarchiv rechnungsarchiv;
    Kontostand kontostand;
    String firstPill , firstProductOrder,secondProductOrder , internetAndPhoneNewCl , collectionCl , pillOrder;

    @BeforeMethod()
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        rechnungsarchiv = new Rechnungsarchiv(driver);
        kontostand = new Kontostand(driver);
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        otherProductCl = testData.getTestData(method.getName() + ".otherProductCl");
        firstPill = testData.getTestData(method.getName() + ".firstPill");
        firstProductOrder = testData.getTestData(method.getName() + ".firstProductOrder");
        secondProductOrder = testData.getTestData(method.getName() + ".secondProductOrder");
        internetAndPhoneNewCl = testData.getTestData(method.getName() + ".internetAndPhoneNewCl");
        collectionCl = testData.getTestData(method.getName() + ".collectionCl");
        pillOrder = testData.getTestData(method.getName() + ".pillOrder");
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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_15247_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_15247.json");
    }


    @Test(description = "GC01 - Martin user checks the 'Productart' column in case subType='notSpecified' and referenceBillingAccount including the product is provided from the service")
    @TmsLink("WFCT-15469")
    public void GC01_MartinChecksProductartWithReferenceBillingAccount() {
        dashboard.clickMeineRechnungenTile();
        rechnungsarchiv.assertOnProductCl(firstProductOrder,collectionCl);
    }

    @Test(description = "GC02 - Martin user checks the 'Productart' column in case subType='notSpecified' and No referenceBillingAccount including the product is provided from the service")
    @TmsLink("WFCT-15470")
    public void GC02_MartinChecksProuctartWithNoReferenceBillingAccount() {
        dashboard.clickMeineRechnungenTile();
        rechnungsarchiv.assertOnProductCl(firstProductOrder,otherProductCl);
    }

    @Test(description = "GC03 - Martin user has more than a product checks the account balance page")
    @TmsLink("WFCT-15472")
    public void GC03_MartinHasMoreThanProductChecksAccountBalancePage() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickOnKontostandTab();
        kontostand.assertOnPillCl(pillOrder,collectionCl);
    }

    @Test(description = "GC04 - Martin user has internet and phone product checks the 'Produktart' column")
    @TmsLink("WFCT-15538")
    public void GC04_MartinHasInternetAndPhoneChecksProduktartColumn() {
        dashboard.clickMeineRechnungenTile();
        rechnungsarchiv.assertOnProductCl(secondProductOrder,internetAndPhoneNewCl);

    }
}