package de.vodafone.tests.unityMedia.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.unityMedia.InternetAndPhone;
import de.vodafone.pages.unityMedia.TV;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Unity Media")
@Feature("ST")
@Story("WFBT-9531")
public class WFBT_9531 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @TmsLink("WFBT-9633")
    @Test(enabled = false, description = "Show Price in UM booked options | UTE user | Validate the price of booked options if price is more than zero | TV")
    public void GC01() {
        new TV(driver).expandTvAccordion();
        new TV(driver).openKableTvTariffPage();
        new TV(driver).expandBookedOptionsAcc();
        new TV(driver).bookedOptionsPriceValidation();
    }

    @TmsLink("WFBT-9632")
    @Test(enabled = false, description = "Show Price in UM booked options | UTE user | Validate the price of booked options if price is zero | TV")
    public void GC02() {
        new TV(driver).expandTvAccordion();
        new TV(driver).openKableTvTariffPage();
        new TV(driver).expandBookedOptionsAcc();
        new TV(driver).bookedOptionsPriceValidation_Free();
    }

    @TmsLink("WFBT-9636")
    @Test(description = "Show Price in UM booked options | UTE user | Validate the price of booked options if price is more than zero | Internet & phone")
    public void GC03() {
        new InternetAndPhone(driver).expandInternetAndPhoneAccordion();
        new InternetAndPhone(driver).openMeinInternetAndPhoneTariffPage();
        new InternetAndPhone(driver).expandBookedOptionsAcc();
        new InternetAndPhone(driver).bookedOptionsPriceValidation();
    }

    @TmsLink("WFBT-9635")
    @Test(description = "Show Price in UM booked options | UTE user | Validate the price of booked options if price is zero | Internet & phone")
    public void GC04() {
        new InternetAndPhone(driver).expandInternetAndPhoneAccordion();
        new InternetAndPhone(driver).openMeinInternetAndPhoneTariffPage();
        new InternetAndPhone(driver).expandBookedOptionsAcc();
        new InternetAndPhone(driver).freeBookedOptionsPriceValidation();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/ST/" + className + ".json");
    }

    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
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
}