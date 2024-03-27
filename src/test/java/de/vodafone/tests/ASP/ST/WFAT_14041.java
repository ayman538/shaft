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
@Story("WFAT_14041")

public class WFAT_14041 {
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
    @TmsLink("WFAT-14472")
    @Test(description="Verify Revocation page CL")
    private void GC01() {

        new ASPLandingPage(driver)
                .GiraffeUser()
                .RevocatioOptionsValidations();
    }

  /*  @TmsLink("WFAT-14473")
    @Test(description="Verify popup message")
    private void verifypopup() {

        new ASPLandingPage(driver)
                .GiraffeUser()
                .clickoption6()
                .PopupValidation();
    }*/
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}