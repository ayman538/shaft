package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import de.vodafone.pages.commons.ASPLogin;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WFAT_16714 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {

        driver = new SHAFT.GUI.WebDriver();
       new ASPLogin(driver)
               .navigateST()
               .acceptCookies()
               .setCookieSwitchers(cookieMap);
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
       cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-16714_CookieSwitcher.json").getTestDataAsMap("$");

    }
    @TmsLink("WFAT-17446")
    @Test(description = "DSl user verify three options are displayed")
    public void GC01() {
new ASPLandingPage(driver).ClickDSLTile().question1ValidationsDSL();

    }
    @TmsLink("WFAT-17447")
    @Test(description = "DSl user click revoke/terminate verify two options displayed")
    public void GC02() {
        new ASPLandingPage(driver).ClickDSLTile().clickDSLrevoke().question2ValidationsDSL();
        new ASPLandingPage(driver).clickDSLTerminate().question2ValidationsDSL();

    }

    @TmsLink("WFAT-17448")
    @Test(description = "DSl user click revoke and login verify login overlay")
    public void GC03() {
        new ASPLandingPage(driver).ClickDSLTile().clickDSLrevoke()
                .clickDSLlogin().LoginSectionValidations();
    }
    @TmsLink("WFAT-17448")
    @Test(description = "DSl user click terminate and login verify login redirection")
    public void GC04() {
        new ASPLandingPage(driver).ClickDSLTile().clickDSLTerminate().clickDSLlogin().mvValidation();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
