package de.vodafone.tests.FormCenter.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.FormCenter.FormCenterHubPage;
import de.vodafone.pages.FormCenter.Login;
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
@Story("WFBT-10060")
public class WFBT_10060 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @TmsLinks({
            @TmsLink("WFBT-10526"),
            @TmsLink("WFBT-10527"),
            @TmsLink("WFBT-10528"),
            @TmsLink("WFBT-10530"),
            @TmsLink("WFBT-10531"),
            @TmsLink("WFBT-10532"),
            @TmsLink("WFBT-10534")
    })
    @Test(description = "GC01 || Check Form Center Hub Page Main Characteristics")
    public void check_header_footer_searching_sorting() {
        new FormCenterHubPage(driver)
                .navigateToFormCenterHubPage();
        new FormCenterHubPage(driver)
                .validateFormCenterHeaderSubHeaderFinderHeadline()
                .validateFormCenterFooter()
                .validateFormCenterSorting()
                .fillInAnExistingFormName()
                .lookupForForm()
                .validateFormCenterSortingII()
                .clearAndSearch()
                .fillInLongString()
                .lookupForForm()
                .validateSearchingTextLimitedTo50Chars()
                .clearAndSearch()
                .fillInNonExistingFormName()
                .lookupForForm()
                .validateFormNotFound();
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
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








