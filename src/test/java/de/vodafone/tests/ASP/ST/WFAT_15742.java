package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import de.vodafone.pages.ASP.ASPReturnSummary;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WFAT_15742 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    public String emailAddress;
    public String customerNumber;
    public String contractNumber;
    public String areaCode;
    public String phoneNumber;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-15742_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "ASP/ST/" + className + ".json");
    }

    @BeforeMethod
    @Description("setting branches and navigating to landing page url")
    public void setup(Method method) {
        emailAddress = testData.getTestData(method.getName()+".EmailAddress");
        customerNumber = testData.getTestData(method.getName()+".CustomerNumber");
        contractNumber = testData.getTestData(method.getName()+".ContractNumber");
        areaCode = testData.getTestData(method.getName()+".AreaCode");
        phoneNumber = testData.getTestData(method.getName()+".PhoneNumber");
        driver = new SHAFT.GUI.WebDriver();
        new ASPLandingPage(driver).navigate(environment)
                .setCookie(cookieMap)
                .navigate(environment)
                .acceptCookies();
    }

    @TmsLink("WFAT-15806")
    @Test(description="WFAT-15806 | Fox User checks Andern button in in summery of return page step 2")
    private void GC01() {
        new ASPLandingPage(driver)
                .FoxUser()
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2KD()
                .clickSubmitButtonStep2()
                .FoxUserfiledsValidation()
                .FillForm3Fox(emailAddress,customerNumber,contractNumber,areaCode,phoneNumber)
                .clickOnQRButton();
        new ASPReturnSummary(driver).clickOnStep1QRButton().verifyThatBackButtonIsDisplayed();
    }

    @TmsLink("WFAT-15806")
    @Test(description="WFAT-15806 | Giraffe User checks Andern button in in summery of return page step 2")
    private void GC02() {
        new ASPLandingPage(driver)
                .GiraffeUser()
                .clickoption3()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2UM()
                .clickSubmitButtonStep2()
                .FillForm3Giraffe(emailAddress,customerNumber,areaCode,phoneNumber)
                .clickOnQRButton();
        new ASPReturnSummary(driver).clickOnStep1QRButton().verifyThatBackButtonIsDisplayed();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
