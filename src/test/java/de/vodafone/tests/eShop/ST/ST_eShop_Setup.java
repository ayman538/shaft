package de.vodafone.tests.eShop.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ST_eShop_Setup {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager cookieMap;
    private HashMap<String,String> cookieSwitcherMap;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod (alwaysRun = true)
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(method.getName());
        driver= new SHAFT.GUI.WebDriver();
        //make new Login to ST environment
        new LoginPage(driver)
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

        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "eShop/ST/ST_" + className + "_CookieSwitcher.json");
        cookieSwitcherMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "eShop/ST/ST_"+className+"_CookieSwitcher.json").getTestDataAsMap("$");
    }

}