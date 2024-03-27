package de.vodafone.tests.Solstice.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Solstice.AdditionalPhoneNumbers;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeLogin;
import de.vodafone.pages.Solstice.SolsticeMyAccount;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12205")
public class WFAT_12205 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");


    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new SolsticeLogin(driver).navigateST()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionST(userName, userPassword);
    }

    @TmsLink("WFAT-15347")
    @Test(description = "WFAT-15347-Check Listed Phone Numbers When I have 3 Additional Phone Numbers")
    public void GC01() {
        new SolsticeDashboard(driver).chooseLoginDatenFromMeinKonto().validateAdditionalPhoneNumberCTACL();
        new SolsticeMyAccount(driver).clickAdditionalPhoneNumbersCTA().ValidateCLForAdditionalNumbersPage();
        new AdditionalPhoneNumbers(driver).clickBackButton();
    }
    @TmsLink("WFAT-15348")
    @Test(description = "WFAT-15348-Check Listed Phone Numbers When I have less than 3 Additional Phone Numbers")
    public void GC02() {
        new SolsticeDashboard(driver).chooseLoginDatenFromMeinKonto().validateAdditionalPhoneNumberCTACL();
        new SolsticeMyAccount(driver).clickAdditionalPhoneNumbersCTA().Validate2AdditionalNumbers();
    }
    @TmsLink("WFAT-15349")
    @Test(description = "WFAT-15349-Check Listed Phone Numbers When I have no Additional Phone Numbers")
    public void GC03() {
        new SolsticeDashboard(driver).chooseLoginDatenFromMeinKonto().validateAdditionalPhoneNumberCTACL();
        new SolsticeMyAccount(driver).clickAdditionalPhoneNumbersCTA().ValidateNoAdditionalNumbersNotification();
        new AdditionalPhoneNumbers(driver).clickBackButton();
    }


    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Solstice/ST_WFAT-12205_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Solstice/ST/" + className + ".json");
    }
}
