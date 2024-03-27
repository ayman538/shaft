package de.vodafone.tests.MNP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ST_MNP_Setup {
    protected SHAFT.GUI.WebDriver driver;
    protected JSONFileManager cookieMap;
    protected HashMap<String,String> cookieSwitcherMap;
    protected JSONFileManager testData;
    protected String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod (alwaysRun = true)
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();

        //make new Login to ST environment
        new de.vodafone.pages.commons.LoginPage(driver)
                .navigateST()
                .acceptCookies()
                .setCookieSwitchers(cookieSwitcherMap);
    }

    @AfterMethod (alwaysRun = true)
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass(alwaysRun = true)
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/ST/ST_" + className + "_CookieSwitcher.json");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "MNP/ST/" + className + ".json");
        cookieSwitcherMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "MNP/ST/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
    }

}