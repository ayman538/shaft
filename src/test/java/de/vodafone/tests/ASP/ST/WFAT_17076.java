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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@Epic("After Sales Portal")
@Feature("ST")
@Story("WFAT-17076")

public class WFAT_17076 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String environment = "ST";
    public String emailAddress = "Mostafa@gmail.com";
    public String customerNumber = "1231231231";
    public String contractNumber = "123123123";
    public String areaCode = "002";
    public String phoneNumber = "123123123";
    //public String terminationDate = new SimpleDateFormat("dd+1.MM.yyyy").format(new Date());
    public String terminationDate = "12.12.2024";
    public String terminationPassedDate = "02.01.2024";
    public String terminationHolidayDate = "01.01.2024";

    @BeforeClass()
    @Description("Setting cookie map file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-17076_CookieSwitcher.json").getTestDataAsMap("$");
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

    @TmsLink("WFAT-17881")
    @Test(description = "WFAT-17881 Check that I can choose a specific termination date as a deer user")
    private void TC01() throws InterruptedException {
        new ASPLandingPage(driver)
                .DeerUser()
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2()
                .FillForm3DeerSpecificTerminationDate(emailAddress,customerNumber,areaCode,phoneNumber,terminationDate).deerURLValidation();
    }

    @TmsLink("WFAT-17882")
    @Test(description = "WFAT-17882 Check that I can choose a specific termination date as a fox user")
    private void TC02() throws InterruptedException {
        new ASPLandingPage(driver)
                .FoxUser().Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2KD().clickSubmitButtonStep2()
                .FillForm3FoxSpecificTerminationDate(emailAddress,customerNumber,contractNumber,areaCode,phoneNumber,terminationDate).foxURLValidation();
    }

    @TmsLink("WFAT-17881")
    @Test(description = "Check Terminate at a desired date CLs and Calendar")
    private void TC03() {
        new ASPLandingPage(driver)
                .DeerUser()
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2()
                .desiredTerminationDateValidation().calendarOverlayValidation();
    }

    @TmsLink("WFAT-17884")
    @Test(description = "WFAT-17884 Check that I can't leave the date field empty when choosing specific termination date")
    private void TC04() {
        new ASPLandingPage(driver)
                .DeerUser()
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2()
                .dateFieldErrorValidation();
    }

    @TmsLink("WFAT-17885")
    @Test(description = "WFAT-17885 Check that I can't choose a date that passed")
    private void TC05() {
        new ASPLandingPage(driver)
                .DeerUser()
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2()
                .dateFieldInputErrorValidation(terminationPassedDate);
    }

    @TmsLink("WFAT-17886")
    @Test(description = "WFAT-17886 Check that I can't choose a date that is a weekend or national holiday")
    private void TC06() {
        new ASPLandingPage(driver)
                .DeerUser()
                .Navigattosalesagnet_tremination()
                .clickCancelButton()
                .fillFormStep1().clickSubmitButton().fillFormStep2UM().clickSubmitButtonStep2()
                .dateFieldInputErrorValidation(terminationHolidayDate);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
