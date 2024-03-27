package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import de.vodafone.pages.ASP.ASPSummaryofReturnPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("After Sales Portal")
@Feature("ST")
@Story("WFAT_14215.json")
public class WFAT_14215 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    private String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    public String environment = "ST";

    @TmsLink("WFAT-14925")
    @Test(description = "WFAT-14926-Giraffe user validate summary of return page")
    private void GC01(Method method) {
        new ASPLandingPage(driver).GiraffeUser()
                .NavigatetosalesAgent()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2UM().clickSubmitButtonStep2()
                .FillForm3Giraffe(testData.getTestData(method.getName() + ".emailAddress"),
                        testData.getTestData(method.getName() + ".CustomerNumber"),
                        testData.getTestData(method.getName() + ".AreaCode"),
                        testData.getTestData(method.getName() + ".PhoneNumber"));
        new ASPSummaryofReturnPage(driver).validateReturnSummary_revocation();
    }

    @TmsLink("WFAT-14926")
    @Test(description = "WFAT-14926-Camel user validate summary of return page")
    private void GC02(Method method) {
        new ASPLandingPage(driver).CamelUser()
                .NavigatetosalesAgent()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .fillFormStep2KD().clickSubmitButtonStep2()
                .FillForm3Camel(testData.getTestData(method.getName() + ".emailAddress"),
                        testData.getTestData(method.getName() + ".CustomerNumber"),
                        testData.getTestData(method.getName() + ".ContractNumber"),
                        testData.getTestData(method.getName() + ".AreaCode"),
                        testData.getTestData(method.getName() + ".PhoneNumber"));
        new ASPSummaryofReturnPage(driver).validateReturnSummary_revocation();
    }

    @TmsLink("WFAT-14927")
    @Test(description = "WFAT-14927-Deer user validate summary of return page ")
    private void GC03(Method method) {
        new ASPLandingPage(driver)
                .DeerUser()/*.clickSkipLogin()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2()
                .FillForm3Deer(testData.getTestData(method.getName() + ".emailAddress"),
                        testData.getTestData(method.getName() + ".CustomerNumber"),
                        testData.getTestData(method.getName() + ".AreaCode"),
                        testData.getTestData(method.getName() + ".PhoneNumber"));
        new ASPSummaryofReturnPage(driver).validateReturnSummary_termination();
    }

    @TmsLink("WFAT-14928")
    @Test(description = "WFAT-14928-Fox user validate summary of return page ")
    private void GC04(Method method) {
        new ASPLandingPage(driver)
                .FoxUser().Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2KD().clickSubmitButtonStep2()
                .FillForm3Fox(testData.getTestData(method.getName() + ".emailAddress"),
                        testData.getTestData(method.getName() + ".CustomerNumber"),
                        testData.getTestData(method.getName() + ".ContractNumber"),
                        testData.getTestData(method.getName() + ".AreaCode"),
                        testData.getTestData(method.getName() + ".PhoneNumber"));
        new ASPSummaryofReturnPage(driver).validateReturnSummary_termination();
    }

    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-14077_CookieSwitcher.json").getTestDataAsMap("$");
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


