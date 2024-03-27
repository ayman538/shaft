package de.vodafone.tests.CableMigration.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;

public class CableMigrationSTSetup {
    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    //public String guidNum;
    public String userName;
    public String userPassword;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");


    @BeforeMethod
    @Description("Setting guidnum, Navigate To Authentication")
    public void setup(Method method) {


        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");

        driver = new SHAFT.GUI.WebDriver();

      /*  new LoginPage(driver).navigateST()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginAction(userName, userPassword);
        }*/
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "CableMigration/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "CableMigration/ST/" + className + ".json");
    }
}
