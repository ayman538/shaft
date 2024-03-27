package de.vodafone.tests.DSLOnboarding.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DSLOnboarding.DashboardPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;

public class DSLOnboardingSTSetup {
    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String urlIdent;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting urlIdent, Navigate To Dashboard")
    public void setup(Method method){
        driver= new SHAFT.GUI.WebDriver();

        urlIdent = testData.getTestData(method.getName()+".urlIdent");
        new DashboardPage(driver).navigateToSTUrl(urlIdent)
                .setCookie(cookieMap)
                .acceptCookies();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "DSLOnboarding/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "DSLOnboarding/ST/" + className + ".json");
    }
}
