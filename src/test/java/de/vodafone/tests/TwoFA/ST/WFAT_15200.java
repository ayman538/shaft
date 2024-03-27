package de.vodafone.tests.TwoFA.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.TwoFA.*;
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
@Story("WFAT_15200")
public class WFAT_15200 {
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

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-15200_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }

    @TmsLink("WFAT-16129")
    @Test(description = "Legacy User Verify 2FA step 1 page and  click confirm button ")
    public void GC01(Method method) {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickActivate2FA();
        new TwoFAStep1(driver).insertPassword(testData.getTestData(method.getName() + ".password2FA"))
                .twoFAActivationS1Validation();
        new TwoFAStep1(driver).clickConfirm();
    }
    @TmsLink("WFAT-16130")
    @Test(description = "Solstice User Verify 2FA step 1 page and  click confirm button")
    public void GC02(Method method) {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickActivate2FA();
        new TwoFAStep1(driver).insertPassword(testData.getTestData(method.getName() + ".password2FA"))
                .twoFAActivationS1Validation();
        new TwoFAStep1(driver).clickConfirm();
    }

    @TmsLink("WFAT-16131")
    @Test(description = "Legacy User verify error message for empty password")
    public void GC03(Method method) {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickActivate2FA();
        new TwoFAStep1(driver).insertPassword(testData.getTestData(method.getName() + ".password2FA")).emptypasswordValidation();
    }

    @TmsLink("WFAT-16132")
    @Test(description = "Legacy User verify error msg for wrong REGEX")
    public void GC04(Method method) {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickActivate2FA();
        new TwoFAStep1(driver)
                .insertPassword(testData.getTestData(method.getName() + ".password2FA"))
                .clickConfirm()
                .regexValidation();

    }
    @TmsLink("WFAT-16133")
    @Test(description = "Legacy user verify error message when password is invalid many times")
    public void GC05(Method method) {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickActivate2FA();
        new TwoFAStep1(driver).insertPassword(testData.getTestData(method.getName() + ".password2FA")).clickConfirm();
        new GenralErrorPage(driver).generalErrorValidation();
    }

    @TmsLink("WFAT-16133")
    @Test(description = "Legacy user deeplink verify error message when user already activated")
    public void GC07(Method method) {
        driver.browser().navigateToURL("https://simplicity.wf-de.vodafone.com/meinvodafone/account/verwaltung/2fa_totp_aktivieren");
        new DeepLinkErrorPage(driver).deeplinkValidation();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}