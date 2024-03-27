package de.vodafone.tests.DSL.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.DSL.DSL_Login;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;

public class SIT_DSLSetup {
    private static By LoginIndicator = By.xpath("//div[@class='dashHeader']");
    public static SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new DSL_Login(driver).navigateSIT()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionSIT(userName, userPassword);
        Validations
                .assertThat()
                .element(driver.getDriver(), SIT_DSLSetup.LoginIndicator).text().contains("Hallo")
                .perform();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "DSL/ST" + "_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "DSL/SIT/" + className + ".json");
    }
}