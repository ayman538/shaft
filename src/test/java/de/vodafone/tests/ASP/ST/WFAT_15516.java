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
public class WFAT_15516 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-15516_CookieSwitcher.json").getTestDataAsMap("$");
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
    @TmsLink("WFAT-15573")
    @Test(description="Verify redirection for UM user")
    private void GC01(){
        driver.browser().navigateToURL("https://simplicity.wf-de.vodafone.com/retoure/landing-page?type=um");
        new ASPLandingPage(driver).UMDeeplinkValidation();
    }

    @TmsLink("WFAT-15575")
    @Test(description="Verify redirection for KD user")
    private void GC02() {
        driver.browser().navigateToURL("https://simplicity.wf-de.vodafone.com/retoure/landing-page?type=vkd");
        new ASPLandingPage(driver).KDDeeplinkValidation();
    }
    @TmsLink("WFAT-15576")
    @Test(description="Check url for UM revocation page")
    private void GC03() {
        new ASPLandingPage(driver).GiraffeUser().UMURLValidation();
    }
    @TmsLink("WFAT-15577")
    @Test(description="Check url for UM termination page")
    private void GC04() {
        new ASPLandingPage(driver).DeerUser().UMURLValidation();
    }
    @TmsLink("WFAT-15578")
    @Test(description="Check url for KD revocation page")
    private void GC05() {
       new ASPLandingPage(driver).CamelUser().KDURLValidation();
    }
    @TmsLink("WFAT-15579")
    @Test(description="Check url for KD termination page")
    private void GC06() {
        new ASPLandingPage(driver).FoxUser().KDURLValidation();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
