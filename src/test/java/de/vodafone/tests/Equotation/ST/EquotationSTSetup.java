package de.vodafone.tests.Equotation.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Equotation.AuthenticationPage;
import io.qameta.allure.Description;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EquotationSTSetup {
    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String guidNum;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");


    @BeforeMethod
    @Description("Setting guidnum, Navigate To Authentication")
    public void setup(Method method) {

        guidNum = testData.getTestData(method.getName()+".guidNum");

        String url = System.getProperty("de.vodafone.baseUrl.st") + "reparaturkosten/reparatur/postcode?guid=" + guidNum;
        String urlAfterRedirection = url;
        driver= new SHAFT.GUI.WebDriver();
        //wait = new WebDriverWait(driver.getDriver(), timeInSeconds);
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
        new AuthenticationPage(driver).acceptCookies();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Equotation/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Equotation/ST/" + className + ".json");
    }
}
