package de.vodafone.tests.NetAssistant.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.HashMap;

public class STNetAssistantSetup {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public JSONFileManager cookieMap;
    public JSONFileManager chatbotDecisionTreeJSONFile;
    Map<?, ?> CookieSwitcherMap;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        driver= new SHAFT.GUI.WebDriver();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "NetAssistant/ST_ECHO_NA_CookieSwitcher.json");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "NetAssistant/ST/" + className + ".json");
        chatbotDecisionTreeJSONFile = new JSONFileManager(System.getProperty("testDataFolderPath") + "NetAssistant/ST/" + "ChatbotDecisionTrees.json");

    }
    @Description("Navigate to Login Page , Set Cookie Switcher , accept cookies , Login with Valid Credentials then wait for dashboard to be displayed")
    public void loginAction(HashMap cookieSwitcherMap, String userName , String userPassword)
    {
        new LoginPage(driver)
                .navigateST()
                .acceptCookies()
                .loginST(userName,userPassword)
                .waitForPageLoading()
                .setCookieSwitchers(cookieSwitcherMap);
    }

    @Description("Navigate to Login Page , Set Cookie Switcher then accept cookies")
    public void loginAction(HashMap cookieSwitcherMap)
    {
        new LoginPage(driver)
                .navigateST()
                .setCookieSwitchers(cookieSwitcherMap)
                .acceptCookies();
    }


}
