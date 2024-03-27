package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import de.vodafone.pages.commons.ASPLogin;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WFAT_17551 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment = "ST";


    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        SHAFT.Properties.flags.set().disableCache(true);
        driver = new SHAFT.GUI.WebDriver();
        new ASPLogin(driver)
                .navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-17551_CookieSwitcher.json").getTestDataAsMap("$");
    }

    @TmsLink("WFAT-17774")
    @Test(description = "Verifying Landing Page for Cable users")
    public void TC01() {
        new ASPLandingPage(driver).ClickKableTile().ClickQuestion1Answer1().LandingpageNewCLValidations();
    }

    @TmsLink("WFAT-17775")
    @Test(description = "Verifying Link for Cable users")
    public void TC02() {
        new ASPLandingPage(driver).ClickKableTile().ClickQuestion1Answer1().ClickOnKabelVideoLink().youtubeValidation();
    }

    @TmsLink("WFAT-17776")
    @Test(description = "Verify landing page link not exist in (Mobile & Accessories) pages")
    public void TC03() {
        new ASPLandingPage(driver).ClickMobileTile().youtubeNotExistValidation();
    }

    @TmsLink("WFAT-17777")
    @Test(description = "Verifing Landing Page for DSL users is still working fine")
    public void TC04() {
        new ASPLandingPage(driver).ClickDSLTile().ClickOnDSLVideoLink().youtubeValidation();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
