package de.vodafone.tests.CentralLandingPage.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.CentralLandingPage.MainCentralLandingPage;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;

public class CentralLandingPageSetup {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String urlExtention;
    public String fullURL;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    public final String environment = "SIT";

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        urlExtention = testData.getTestData(method.getName() + ".urlExtention");
        driver = new SHAFT.GUI.WebDriver();
        new MainCentralLandingPage(driver)
//                .setCookie(cookieMap)
                .navigate(urlExtention, environment)
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
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "CentralLandingPage/SIT_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "CentralLandingPage/" + environment + "/" + className + ".json");
    }
}