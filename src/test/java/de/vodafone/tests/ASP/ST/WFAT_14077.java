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
@Story("WFAT-14077")

public class WFAT_14077 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment ="ST";
    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-14077_CookieSwitcher.json").getTestDataAsMap("$");
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
    @TmsLink("WFAT-14651")
    @Test(description="Deer user navigates to form page step 1")
    private void GC01() {
        new ASPLandingPage(driver)
                .DeerUser()/*.clickSkipLogin()*/
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .validateNavigationToForm()
                .UMHeaderAndSubHeaderValidation();
    }
    @TmsLink("WFAT-14652")
    @Test(description="Camel user navigates to form page step 1")
    private void GC02() {
        new ASPLandingPage(driver).CamelUser().clickoption3().clickCancelButton()
                .validateNavigationToForm()
                .KDHeaderAndSubHeaderValidation();
    }
    @TmsLink("WFAT-14653")
    @Test(description="Camel user navigates from step 1 to step 2")
    private void GC03() {
        new ASPLandingPage(driver).CamelUser().clickoption3().clickCancelButton()
                .fillFormStep1()
                .clickSubmitButton()
                .streetAddressHeaderValidation();
    }
    @TmsLink("WFAT-14654")
    @Test(description="User checks first dropdown menu in step 1")
    private void GC04() {
        new ASPLandingPage(driver).GiraffeUser().clickoption3().clickCancelButton()
                .clickOnSalutationDropBox()
                .salutationDropdownOptionsValidation();
    }
    @TmsLink("WFAT-14655")
    @Test(description="User checks second dropdown menu in step 1")
    private void GC05() {
        new ASPLandingPage(driver).FoxUser()/*.clickSkipLogin()*/.Navigattosalesagnet_tremination()
                .clickCancelButton()
                .clickOnTitleDropBox()
                .titleDropdownOptionsValidation();
    }
    @TmsLink("WFAT-14656")
    @Test(description="User checks form 1 CL, fills form, and navigates to step 2")
    private void GC06() {
        new ASPLandingPage(driver).CamelUser().clickoption3().clickCancelButton()
                .step1Validation()
                .typeFirstName()
                .typeLastName()
                .validateSubmitButtonIsDisabled()
                .clickOnSalutationDropBox()
                .clickOnSalutationOption1()
                .validateSubmitButtonIsEnabled()
                .clickOnTitleDropBox()
                .clickOnTitleOption1()
                .validateSubmitButtonIsEnabled();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

}
