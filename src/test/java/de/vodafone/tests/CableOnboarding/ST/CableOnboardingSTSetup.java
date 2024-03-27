package de.vodafone.tests.CableOnboarding.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.CableOnboarding.TechInstallDashboard;
import io.qameta.allure.Description;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CableOnboardingSTSetup {
    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    //public JSONFileManager cookieSettings;
    public HashMap<String, String> cookieMap;
    public String urn;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");


    @BeforeMethod
    @Description("Setting URN, Navigate To Dashboard")
    public void setup(Method method) {

        urn = testData.getTestData(method.getName()+".urn");

        String url = System.getProperty("de.vodafone.baseUrl.st") + "startportal/?customerURN=" + urn;
        String urlAfterRedirection = url;
        driver= new SHAFT.GUI.WebDriver();
        driver.browser().navigateToURL(url,urlAfterRedirection);
        for (Map.Entry<String, String> entry : cookieMap.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                Cookie cookie = new Cookie(key, value);
                driver.getDriver().manage().addCookie(cookie);
            }
            driver.browser().navigateToURL(url,urlAfterRedirection);
        if (driver.browser().getCurrentWindowTitle().equals("404 Not Found")) {
            try {
                SHAFT.Validations.assertThat().forceFail().withCustomReportMessage("Cookie Switcher Branch is not found, please validate with the dev team").perform();
            } catch (AssertionError e) {
                Assert.fail("Cookie Switcher Branch is not found, please validate with the dev team");
            }
        }
        new TechInstallDashboard(driver).acceptCookies();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "CableOnboarding/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "CableOnboarding/ST/" + className + ".json");
    }

}
