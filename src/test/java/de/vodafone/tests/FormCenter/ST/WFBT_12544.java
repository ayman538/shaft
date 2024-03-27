package de.vodafone.tests.FormCenter.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.FormCenter.FormCenterHubPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Form Center")
@Feature("ST")
@Story("WFBT-12544")
public class WFBT_12544 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @TmsLink("WFBT-12852")
    @Test(description = "GC01 - Check Back button in the last page and check next button will be removed")
    public void GC01_CheckBackAndNextButtonInTheLastPage(){
        new FormCenterHubPage(driver).navigateToFormCenterHubPage()
                .clickNextButton().clickNextButton()
                .validateBackButtonExist().validateNextButtonNotExist();
    }

    @TmsLink("WFBT-12853")
    @Test(description = "GC02 - Check Next button in the First page and back button will be removed")
    public void GC02_CheckNextAndBackButtonInTheFirstPage(){
        new FormCenterHubPage(driver).navigateToFormCenterHubPage()
                .clickBackButton().clickBackButton()
                .validateNextButtonExist().validateBackButtonNotExist();
    }

    @TmsLink("WFBT-12854")
    @Test(description = "GC03 - Check Next and back button in the Middle page")
    public void GC03_CheckNextAndBackButtonInTheMiddlePage(){
        new FormCenterHubPage(driver).navigateToFormCenterHubPage()
                .clickNextButton().validateNextButtonExist().validateBackButtonExist();
    }

    @TmsLink("WFBT-12855")
    @Test(description = "GC04 - Check the UI for pagination component (current number is bold and the cl of the page Seite {#no} von {#no})")
    public void GC04_CheckTheUIForPaginationComponent(Method method){
        new FormCenterHubPage(driver).navigateToFormCenterHubPage()
                .clickNextButton().validatePaginationComponent(testData.getTestData(method.getName() + ".NextButtonCL")
                        , testData.getTestData(method.getName() + ".PageNumberFormCL")
                        , testData.getTestData(method.getName() + ".PageNumberCL")
                        , testData.getTestData(method.getName() + ".BackButtonCL"));
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver= new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "FormCenter/ST_"+className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "FormCenter/ST/" + className + ".json");
    }
}
