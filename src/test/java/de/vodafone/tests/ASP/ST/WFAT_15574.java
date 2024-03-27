package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WFAT_15574 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    public String deliveryNumber;
    public String zipCode;
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-15574_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "ASP/ST/WFAT_15574.json");

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
    @Test(description="WFAT-14293-mobile user Navigate to Winback page and verify redirection to WhatsApp page")
    private void GC01() {
        new ASPLandingPage(driver).ClickMobileTile();
        new ASPLandingPage(driver).loginAction(deliveryNumber, zipCode);
        new ASPMobileOverview(driver).clickrevoke();
        new ASPMoblieRevocationPage(driver).clickwinback();

        new WinbackPage(driver).clickOn_WhatsAppbutton();

    }
    @TmsLink("WFAT-14294")
    @Test(description="WFAT-14294-physical sim user Navigate to Winback page and verify redirection to WhatsApp page")
    private void GC02() {
        new ASPLandingPage(driver).ClickMobileTile();
        new ASPLandingPage(driver).loginAction(deliveryNumber, zipCode);
        new ASPSimOverview(driver).clickrevoke();
        new ASPMoblieRevocationPage(driver).clickwinback();
        new WinbackPage(driver).clickOn_WhatsAppbutton();
    }
    @TmsLink("WFAT-14295")
    @Test(description="WFAT-14295- e-sim user Navigate to Winback page and verify redirection to WhatsApp page")
    private void GC03() {
        new ASPLandingPage(driver).ClickMobileTile();
        new ASPLandingPage(driver).loginAction(deliveryNumber, zipCode);
        new ASPSimOverview(driver).clickrevoke();
        new ASPMoblieRevocationPage(driver).clickwinback();
        new WinbackPage(driver).clickOn_WhatsAppbutton();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
