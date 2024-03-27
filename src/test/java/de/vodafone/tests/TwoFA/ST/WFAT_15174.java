package de.vodafone.tests.TwoFA.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.TwoFA.AccountManagementPage;
import de.vodafone.pages.TwoFA.Dashboard;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
@Epic("2FA")
@Feature("ST")
@Story("WFAT_15174")
public class WFAT_15174 {
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
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @TmsLink("WFAT-16172")
    @Test(description = "Legacy Non-activated User checks 2FA section in login data accordion")
    public void GC01() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).twoFANotActivatedSectionValidation();

    }

    @TmsLink("WFAT-16173")
    @Test(description = "Solstice Activated User checks 2FA section in login data accordion")
    public void GC02() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).twoFAActivatedSectionValidation();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-15174_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }
}
