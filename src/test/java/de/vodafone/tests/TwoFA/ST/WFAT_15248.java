package de.vodafone.tests.TwoFA.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.TwoFA.AccountManagementPage;
import de.vodafone.pages.TwoFA.Dashboard;
import de.vodafone.pages.TwoFA.TwoFAStep1;
import de.vodafone.pages.TwoFA.TwoFAloginPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
    @Epic("2FA")
    @Feature("ST")
    @Story("WFAT_15248")
    public class  WFAT_15248 {
        public SHAFT.GUI.WebDriver driver;
        public JSONFileManager testData;
        public HashMap<String, String> cookieMap;
        public String userName;
        public String userPassword;
        public String code;
        public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

        @BeforeMethod
        @Description("Setting User Name, Login, click accept cookies and validate login")
        public void setup(Method method) {
            userName = testData.getTestData(method.getName() + ".name");
            userPassword = testData.getTestData(method.getName() + ".password");
            code = testData.getTestData(method.getName() + ".code");
            driver = new SHAFT.GUI.WebDriver();

            new LoginPage(driver).navigateST()
                    .setCookieSwitchers(cookieMap)
                    .acceptCookies().loginST(userName,userPassword);
        }

        @BeforeClass()
        @Description("Setting cookie map file and test data file")
        public void beforeClass() {
            cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-15248_CookieSwitcher.json").getTestDataAsMap("$");
            testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
        }

        @TmsLink("WFAT-16425")
        @Test(description = "Legacy User Verify 2FA login page and  click login button ")
        public void GC01(Method method) {
            new  TwoFAloginPage(driver)
                    .insertcode(code)
                    .loginPageValidation();
            new  TwoFAloginPage(driver).clicklogin();
        }

        @TmsLink("WFAT-16426")
        @Test(description = "Legacy verify backup label when click login with buc ")
        public void GC02(Method method) {
            new  TwoFAloginPage(driver)
                    .loginwithbuc().backuplabelValidation();

        }
        @TmsLink("WFAT-16427")
        @Test(description = "Legacy User Verify 2FA login page and empty filed message")
        public void GC03(Method method) {
            new  TwoFAloginPage(driver)
                    .clickemptycodeField().emptycodeValidation();

        }
        @TmsLink("WFAT-16428")
        @Test(description = "Legacy User Verify error message for wrong regex")
        public void GC04(Method method) {
            new  TwoFAloginPage(driver)
                    .insertcode(code).clickemptycodeField()
                    .codeRegexValidation();
        }

        @TmsLink("WFAT-16429")
        @Test(description = "Legacy User Verify error message for invalid code")
        public void GC05(Method method) {
            new  TwoFAloginPage(driver)
                    .insertcode(code)
                    .clicklogin().wrongcodeValidation();
        }

        @TmsLink("WFAT-16430")
        @Test(description = "Legacy User Verify error message for invalid code up to 6 times")
        public void GC06(Method method) {
            new  TwoFAloginPage(driver)
                    .insertcode(code)
                    .clicklogin().terminatedValidation();
        }

    }
