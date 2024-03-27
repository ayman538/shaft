package de.vodafone.tests.Account.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Account.*;
import de.vodafone.pages.TwoFA.Dashboard;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Regression")
@Feature("SIT")
@Story("WFAT_15981")
public class WFAT_16671 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String password;
    public String username;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        password= testData.getTestData(method.getName() + ".password");
        username= testData.getTestData(method.getName() + ".name");
        new LoginPage(driver)
                .navigateST()
                .setCookieSwitchers(cookieMap).acceptCookies();
    }
    @Test(description = "Validate DSl code is added in registration page")
    public void GC01() {
        new  LoginPage(driver).clickRegisterButton();
        new DSLRegisterationPage(driver)
                .clickAddContract()
                .clickDSLContract()
                .DSLcodeValidation();
        new DSLRegisterationPage(driver).clickOnRequestCode();
    }
    @Test(description = "Validate DSl code is added in Add contract page")
    public void GC02() {
        new LoginPage(driver).loginST(username,password);
        new Dashboard(driver).clickAddContract();
        new AddContractPage(driver).clickDSLContract();
        new DSlAddContract(driver).DSLcodeValidation();
        new DSlAddContract(driver).clickOnRequestCode();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
       cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Account/ST_WFAT-16671_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Account/ST/" + className + ".json");
    }
}
