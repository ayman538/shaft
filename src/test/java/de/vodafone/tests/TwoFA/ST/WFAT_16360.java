package de.vodafone.tests.TwoFA.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.TwoFA.AccountManagementPage;
import de.vodafone.pages.TwoFA.TwoFAloginPage;
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
@Story("WFAT_16360")
public class WFAT_16360 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String code;
    public String deeplink;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        code = testData.getTestData(method.getName() + ".code");
        deeplink = testData.getTestData(method.getName() + ".url");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver)
                .navigateST()
                .setCookieSwitchers(cookieMap).acceptCookies();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-16360_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }

    @TmsLink("WFAT-16488")
    @Test(description = "WFAT-16488 | GC01-Activated 2FA user-click login with backup-verify backup login page")
    public void GC01() {
        new LoginPage(driver).loginST(userName,userPassword);
        new  TwoFAloginPage(driver)
                .loginwithbuc()
                .loginWithBucPageValidation();
        new  TwoFAloginPage(driver)
                .typeBUC(code)
                .clicklogin();
    }

    @TmsLink("WFAT-16489")
    @Test(description = "WFAT-16489 | GC02-Activated 2FA user-deeplink to login daten-user redirect to login daten")
    public void GC02(Method method) {
       new LoginPage(driver).navigateST(deeplink).loginST(userName,userPassword);
        new  TwoFAloginPage(driver)
                .loginwithbuc()
                .typeBUC(code)
                .clicklogin();
        new AccountManagementPage(driver).validateURL();
    }
    @TmsLink("WFAT-16490")
    @Test(description = "WFAT-16490 | GC03-Activated 2FA user-click login with authentication-user redirect to login with totpWFAT-16490")
    public void GC03() {
        new LoginPage(driver).loginST(userName,userPassword);
        new  TwoFAloginPage(driver)
                .loginwithbuc()
                .loginwith2fa()
                .twoFAlabelValidation();
    }
    @TmsLink("WFAT-16491")
    @Test(description = "WFAT-16491 | BC04-Activated 2FA user-leave the BUC field empty -Verify Error message")
    public void BC04() {
        new LoginPage(driver).loginST(userName,userPassword);
        new  TwoFAloginPage(driver)
                .loginwithbuc()
                .emptyBucField()
                .validateEmptyBucFieldError();
    }
    @TmsLink("WFAT-16492")
    @Test(description = "WFAT-16492 | BC05-Activated 2FA user-Insert wrong REGEX -Verify Error message")
    public void BC05() {
        new LoginPage(driver).loginST(userName,userPassword);
        new  TwoFAloginPage(driver)
                .loginwithbuc()
                .typeBUC(code).emptyBucField()
                .validateWrongRegexBucFieldError();
    }

    @TmsLink("WFAT-16493")
    @Test(description = "WFAT-16493 | BC06-Activated 2FA user- Insert BUC incorrectly (up to 5 times) -Verify Error message")
    public void BC06() {
        new LoginPage(driver).loginST(userName,userPassword);
        new  TwoFAloginPage(driver)
                .loginwithbuc()
                .typeBUC(code)
                .clicklogin()
                .validateInvalidBucErrorMsg();
    }

    @TmsLink("WFAT-16494")
    @Test(description = "WFAT-16494 | BC07-Activated 2FA user- Insert BUC incorrectly for the 6th time -Verify Error message")
    public void BC07() {
        new LoginPage(driver).loginST(userName,userPassword);
        new  TwoFAloginPage(driver)
                .loginwithbuc()
                .typeBUC(code)
                .clicklogin()
                .validateBlockedBucErrorMsg();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

}