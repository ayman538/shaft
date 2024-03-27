package de.vodafone.tests.eCareProject;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.eCareProject.Login;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;

public class eCareProjectSetup {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {

        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        driver= new SHAFT.GUI.WebDriver();

        new Login(driver).navigate()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginAction(userName, userPassword);
        Validations
                .assertThat()
                .element(driver.getDriver(), de.vodafone.pages.eCareProject.Dashboard.loginIndicator).exists()
                .perform();

        //new Dashboard(driver).isBEWOverlayfound();
        new Dashboard(driver).ignoreDashboardNotifications();

       /* Validations
                .assertThat()
                .element(driver.getDriver(), Dashboard.bewOverlayAcceptSuccessMessage).exists()
                .perform();
        */

    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "eCareProject/ST_eCareProject_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "eCareProject/ST/" + className + ".json");
    }

}