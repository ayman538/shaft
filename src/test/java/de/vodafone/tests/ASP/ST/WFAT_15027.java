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
@Story("WFAT_15027 ")
public class WFAT_15027 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-13953_CookieSwitcher.json").getTestDataAsMap("$");
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
    @TmsLink("WFAT-15423")
    @Test(description="cable user verify what's app page is hided from sales agent page")
    private void GC01() {
        new ASPLandingPage(driver)
                .GiraffeUser()
                .NavigatetosalesAgent()
                .salesAgentValidation();

    }
    @TmsLink("WFAT-15426")
    @Test(description="Giraffe/Camel user verify some revocation options hided")
    private void GC04() {
        new ASPLandingPage(driver)
                .CamelUser()
                .RevocatioOptionsValidations();
    }
    @TmsLink("WFAT-15427")
    @Test(description="Deer/Fox user verify Termination options6 hided")
    private void GC05() {
        new ASPLandingPage(driver)
                .DeerUser().TerminationOptionsValidations();
    }
    @TmsLink("WFAT-15428")
    @Test(description="Camel user verify Call back button hided")
    private void GC06() {
        new ASPLandingPage(driver)
                .CamelUser().NavigatetosalesAgent().CamelsalesAgnetValidation();
    }
    @TmsLink("WFAT-15428")
    @Test(description="Fox user verify Call back button hided")
    private void GC07() {
        new ASPLandingPage(driver)
                .FoxUser().Navigattosalesagnet_tremination().FoxsalesAgnetValidation();
    }


    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

}


