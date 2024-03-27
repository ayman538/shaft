package de.vodafone.tests.DSL.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.MyDSLProducts;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-9911")
public class WFBT_9911{
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    DSL_Dashboard dashboard;
    MyDSLProducts myDSLProducts;

    @TmsLink("WFBT-10262")
    @Test(description = "GC01 || Remove status for cards of products that cannot be cancelled online \"Cancellation date not exist\"")
    public void validateOnStatusRemoval() {
        dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickBookedOptionsSO_expandBookedOptionsAcc();
        myDSLProducts.validateBookedOptionsBody();
        myDSLProducts.validateNonCancellableOnlineCard();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "DSL/ST" + "_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "DSL/ST/" + className + ".json");
    }
    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
        myDSLProducts = new MyDSLProducts(driver);
        dashboard = new DSL_Dashboard(driver);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}