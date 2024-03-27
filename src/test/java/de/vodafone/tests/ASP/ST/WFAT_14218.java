package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
@Epic("After Sales Portal")
@Feature("ST")
@Story("WFAT_14218")

public class WFAT_14218 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    private String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    public String environment ="ST";

    @TmsLink("WFAT-14866")
    @Test(description="Cheetah user fills form successfully and press save button")
    private void GC01(Method method) {
        new ASPLandingPage(driver).CheetahUser()
                .validateNavigationToReturnForm()
                .stepValidation()
                .validateSubmitButtonIsDisabled()
                .fillReturnForm(testData.getTestData(method.getName() + ".emailAddress") ,
                        testData.getTestData(method.getName() + ".firstName") ,
                        testData.getTestData(method.getName() + ".lastName") ,
                        testData.getTestData(method.getName() + ".streetName") ,
                        testData.getTestData(method.getName() + ".houseNumber") ,
                        testData.getTestData(method.getName() + ".postalCode") ,
                        testData.getTestData(method.getName() + ".cityName") ,
                        testData.getTestData(method.getName() + ".captcha") )
                .validateSubmitButtonIsEnabled()
                .clickSubmitButtonReturnForm()
                .validateNavigationToReturnSummary();
    }

    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-14218_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "ASP/ST/" + className + ".json");
    }

    @BeforeMethod
    @Description("setting branches and navigating to landing page url")
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        new ASPLandingPage(driver).navigate(environment)
                .setCookie(cookieMap)
                .navigate(environment)
                .acceptCookies();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}