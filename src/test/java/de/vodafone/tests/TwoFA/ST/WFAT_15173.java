package de.vodafone.tests.TwoFA.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.TwoFA.*;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import de.vodafone.pages.commons.LoginPage;
import java.lang.reflect.Method;
import java.util.HashMap;
@Epic("2FA")
@Feature("ST")
@Story("WFAT_15173")
public class WFAT_15173 {
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

    @TmsLink("WFAT-15390")
    @Test(description = "Legacy User checks Login Data accordion in Account Management page")
    public void GC01() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).loginDataCLValidation();
        new AccountManagementPage(driver).loginDataSectionsValidations();
    }
    @TmsLink("WFAT-15391")
    @Test(description = "Solstice User checks Login Data accordion in Account Management page")
    public void GC02() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).loginDataCLValidation();
        new AccountManagementPage(driver).loginDataSectionsValidations();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-15173_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }
}
