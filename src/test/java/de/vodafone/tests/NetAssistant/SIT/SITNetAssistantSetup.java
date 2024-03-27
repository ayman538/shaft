package de.vodafone.tests.NetAssistant.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.gui.browser.internal.JavaScriptWaitManager;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import org.openqa.selenium.Cookie;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SITNetAssistantSetup {

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
        cookieMap = new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "NetAssistant/SIT_ECHO_NA_CookieSwitcher.json");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "NetAssistant/SIT/" + className + ".json");
        chatbotDecisionTreeJSONFile = new JSONFileManager(System.getProperty("testDataFolderPath") + "NetAssistant/SIT/" + "ChatbotDecisionTrees.json");

    }
    public SITNetAssistantSetup setCookieECHO() {
        CookieSwitcherMap = cookieMap.getTestDataAsMap(className);
        for (Map.Entry<?, ?> entry : CookieSwitcherMap.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            Cookie cookie = new Cookie(key, value);
            driver.getDriver().manage().addCookie(cookie);
        }
        driver.browser().refreshCurrentPage(); JavaScriptWaitManager.waitForLazyLoading();
        if (driver.browser().getCurrentWindowTitle().equals("404 Not Found")) {
            try {
                    SHAFT.Validations.assertThat().forceFail().withCustomReportMessage("Cookie Switcher Branch is not found, please validate with the dev team").perform();
                } catch (AssertionError e) {
                    Assert.fail("Cookie Switcher Branch is not found, please validate with the dev team");
                }
        }
        return this;
    }

    @Description("Navigate to Login Page , Set Cookie Switcher , accept cookies , Login with Valid Credentials then wait for dashboard to be displayed")
    public void loginAction(HashMap cookieSwitcherMap, String userName , String userPassword)
    {
        new LoginPage(driver)
                .navigateSIT()
                .setCookieSwitchers(cookieSwitcherMap)
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();
    }

}
