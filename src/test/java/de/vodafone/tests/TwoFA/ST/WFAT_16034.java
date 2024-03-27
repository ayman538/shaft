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
@Story("WFAT_16034")
public class WFAT_16034 {
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

    @TmsLink("WFAT-16120")
    @Test(description = "WFAT-16120 | Legacy Non-activated user checks that Backup Codes section is not displayed in login data accordion")
    public void GC01() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).backupCodesSectionNotDisplayedValidation();
    }

    @TmsLink("WFAT-16121")
    @Test(description = "WFAT-16121 | Legacy activated user checks backup codes section in login data accordion before requesting backup codes")
    public void GC02() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).backupCodesSectionNotRequestedValidation();
    }

    @TmsLink("WFAT-16122")
    @Test(description = "WFAT-16122 | Solstice activated user checks backup codes section in login data accordion when 10 codes are remaining")
    public void GC03() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).backupCodesSection10CodesValidation();
    }

    @TmsLink("WFAT-16123")
    @Test(description = "WFAT-16123 | Solstice activated user checks backup codes section in login data accordion when 2 codes are remaining")
    public void GC04() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).backupCodesSection2CodesValidation();
    }

    @TmsLink("WFAT-16124")
    @Test(description = "WFAT-16124 | Solstice activated user checks backup codes section in login data accordion when 0 codes are remaining")
    public void GC05() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).backupCodesSection0CodesValidation();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-16034_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }
}
