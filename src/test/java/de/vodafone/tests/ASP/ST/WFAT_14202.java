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
@Story("WFAT_14202")
public class WFAT_14202 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    public String deliveryNumber;
    public String zipCode;
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-14202_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "ASP/ST/WFAT_14202.json");

    }
    @BeforeMethod
    @Description("setting branches and navigating to landing page url")
    public void setup(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        deliveryNumber = testData.getTestData(method.getName()+".DeliveryNumber");
        zipCode = testData.getTestData(method.getName()+".Zipcode");
        new ASPLandingPage(driver).navigate(environment)
                .setCookie(cookieMap)
                .navigate(environment)
                .acceptCookies();
    }
    @TmsLink("WFAT-14293")
    @Test(description="User clicks on Mobile & giga cube CTA")
    private void GC01() {
        new ASPLandingPage(driver).ClickMobileTile().LoginSectionValidations();
        new ASPLandingPage(driver).CLickAccessoriesTile().LoginSectionValidations();
        new ASPLandingPage(driver).ClickMobileTile().LoginSectionValidations();
        new ASPLandingPage(driver).loginAction(deliveryNumber, zipCode);
        new ASPLandingPage(driver).LoginActionVerification();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
