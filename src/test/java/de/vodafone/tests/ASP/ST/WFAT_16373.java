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
@Story("WFAT_15516")
public class WFAT_16373 {
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
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-16373_CookieSwitcher.json").getTestDataAsMap("$");
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

    @TmsLink("WFAT-16456")
    @Test(description="WFAT-16456 | GC01-Deer user navigates to summary page and checks URL")
    private void GC01() throws InterruptedException {
        new ASPLandingPage(driver)
                .DeerUser()
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2UM()
                .clickSubmitButtonStep2()
                .DeerUserfieldsValidation()
                .FillForm3Deer(emailAddress,customerNumber,areaCode,phoneNumber)
                .deerURLValidation();
    }
    @TmsLink("WFAT-16457")
    @Test(description="WFAT-16457 | GC02-Girrafe user navigates to summary page and checks URL")
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
                .girrafeURLValidation();

    }
    @TmsLink("WFAT-16458")
    @Test(description="WFAT-16458 | GC03-Fox user navigates to summary page and checks URL")
    private void GC03() throws InterruptedException {
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
                .foxURLValidation();
    }
    @TmsLink("WFAT-16459")
    @Test(description="WFAT-16459 | GC04-Camel user navigates to summary page and checks URL")
    private void GC04() {
        new ASPLandingPage(driver)
                .CamelUser()
                .NavigatetosalesAgent()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2KD()
                .clickSubmitButtonStep2()
                .CamelUserfieldsValidation()
                .FillForm3Camel(emailAddress,customerNumber,contractNumber,areaCode,phoneNumber)
                .camelURLValidation();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
