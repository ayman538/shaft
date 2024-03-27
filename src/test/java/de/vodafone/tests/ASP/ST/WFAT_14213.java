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
@Story("WFAT-14213")
public class WFAT_14213 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-14213_CookieSwitcher.json").getTestDataAsMap("$");
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
    @TmsLink("WFAT-14810")
    @Test(description="Giraffe fills step 2 in form successfully and Weiter button")
    private void GC01() {
        new ASPLandingPage(driver).GiraffeUser().clickoption3().clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .step2UMValidation()
                .fillFormStep2UM()
                .clickSubmitButtonStep2()
                .emailAddressHeaderValidation();
    }
    @TmsLink("WFAT-14811")
    @Test(description="Camel fills step 2 in form successfully and Weiter button")
    private void GC02() {
        new ASPLandingPage(driver).CamelUser().clickoption3().clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .step2KDValidation()
                .fillFormStep2KD()
                .clickSubmitButtonStep2()
                .emailAddressHeaderValidation();
    }
    @TmsLink("WFAT-14812")
    @Test(description="Deer fills step 2 in form successfully and Weiter button")
    private void GC03() {
        new ASPLandingPage(driver).DeerUser()/*.clickSkipLogin().clickoption3()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .step2UMValidation()
                .fillFormStep2UM()
                .clickSubmitButtonStep2()
                .emailAddressHeaderValidation();
    }
    @TmsLink("WFAT-14813")
    @Test(description="Fox fills step 2 in form successfully and Weiter button")
    private void GC04() {
        new ASPLandingPage(driver).FoxUser()/*.clickSkipLogin().clickoption3()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .step2KDValidation()
                .fillFormStep2KD()
                .clickSubmitButtonStep2()
                .emailAddressHeaderValidation();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}