package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLogin;
import io.qameta.allure.Description;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.util.HashMap;

public class ASPSTSetup {

    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    //public String guidNum;
    public String deliveryNumber;
    public String zipCode;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");


    @BeforeMethod
    @Description("Setting Credentials, Navigate To ASP")
    public void setup(Method method) {


        deliveryNumber = testData.getTestData(method.getName()+".MSISDN");
        zipCode = testData.getTestData(method.getName()+".zipcode");

        driver = new SHAFT.GUI.WebDriver();

        new ASPLogin(driver).navigateToSTUrl()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginAction(deliveryNumber, zipCode);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "ASP/ST/" + className + ".json");
    }
}


