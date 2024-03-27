package de.vodafone.tests.CheckAndCare.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.CheckAndCare.DashboardPage;
import io.qameta.allure.Description;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class CheckAndCareSTSetup {
    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String urlIdent;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");


    @BeforeMethod
    @Description("Setting urlIdent, Navigate To Dashboard")
    public void setup(Method method) {

        urlIdent = testData.getTestData(method.getName()+".urlIdent");

        String url = System.getProperty("de.vodafone.baseUrl.st") + "anschaltung-dsl/check-and-care/willkommen?urlIdent=" + urlIdent;
        String urlAfterRedirection = url + urlIdent;
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
        new DashboardPage(driver).acceptCookies();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "CheckAndCare/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "CheckAndCare/ST/" + className + ".json");
    }
}
