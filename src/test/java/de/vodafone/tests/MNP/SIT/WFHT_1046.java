package de.vodafone.tests.MNP.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("MNP")
@Feature("SIT")
@Story("WFHT-1046")
public class WFHT_1046 extends SIT_MNP_Setup {
    private SHAFT.GUI.WebDriver driver;
    private JSONFileManager cookieMap;
    private JSONFileManager testData;
    private HashMap<String,String> cookieSwitcherMap;
    private String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        new de.vodafone.pages.commons.LoginPage(driver).
                navigateSIT().
                acceptCookies().
                setCookieSwitchers(cookieSwitcherMap);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/SIT/SIT_" + className + "_CookieSwitcher.json");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "MNP/SIT/" + className + ".json");
        cookieSwitcherMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/SIT/SIT_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
    }

}








