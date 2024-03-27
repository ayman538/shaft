package de.vodafone.tests.unityMedia.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.unityMedia.ConfirmationPage;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.MyTariffPage;
import de.vodafone.pages.unityMedia.TransactionPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Unity Media")
@Feature("ST")
@Story("WFBT-9288")
public class WFBT_9288 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");

    @TmsLink("WFBT-8273")
    @Test(description = "WFBT-8273 || GC01 || Ute user booking a bookable phone option")
    public void bookingPhoneBookableOption(Method method) {
        new Dashboard(driver).openKIPAcc().clickMienTariffSO();
        new MyTariffPage(driver)
                .expandPhoneBookableOptionsAccordion()
                .clickOnBookNowCTAToBookPhoneOption();
        new TransactionPage(driver)
                .validateTransactionPageElements(
                        testData.getTestData(method.getName() + ".optionHeaderCL"),
                        testData.getTestData(method.getName() + ".bookingPageURL"))
                .validateBookedOptionCard(
                        testData.getTestData(method.getName() + ".optionNameCL"),
                        testData.getTestData(method.getName() + ".optionPriceCL"))
                .validateBookingDate(testData.getTestData(method.getName() + ".bookingDateTitleCL"))
                .clickBookNowCTA();
        new ConfirmationPage(driver)
                .validateConfirmationPageElements(testData.getTestData(method.getName() + ".confirmationMessageCL"))
                .expandOverviewAccordion()
                .validateBookingDate(testData.getTestData(method.getName() + ".bookingDateTitleCL"))
                .validateBookedPhoneOption(
                        testData.getTestData(method.getName() + ".optionNameCL"),
                        testData.getTestData(method.getName() + ".optionPriceCL"));
    }

    @TmsLink("WFBT-8277")
    @Test(description = "WFBT-8277 || GC03 || Ute user canceling a TV booked option")
    private void cancelTVOption(Method method) {
        new Dashboard(driver).openTVAcc().clickMienTariffSO();
        new MyTariffPage(driver)
                .expandTVBookedOptionsAccordion()
                .clickOnCancelTVBookedOption();
        new TransactionPage(driver)
                .validateTransactionPageElements(
                        testData.getTestData(method.getName() + ".optionHeaderCL"),
                        testData.getTestData(method.getName() + ".cancellationPageURL"))
                .validateTVCancellableOption(
                        testData.getTestData(method.getName() + ".optionNameCL"),
                        testData.getTestData(method.getName() + ".optionPriceCL"))
                .validateCancelingDate(
                        testData.getTestData(method.getName() + ".cancelingDateTitleCL"))
                .clickCancelNowCTA();
        new ConfirmationPage(driver)
                .validateConfirmationPageElements(testData.getTestData(method.getName() + ".confirmationMessageCL"))
                .expandOverviewAccordion()
                .validateCancelingDate(
                        testData.getTestData(method.getName() + ".cancelingDateTitleCL"))
                .validateCancelledTVOption(
                        testData.getTestData(method.getName() + ".optionNameCL"),
                        testData.getTestData(method.getName() + ".optionPriceCL"));
    }

    @BeforeMethod(alwaysRun = true)
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method){
        username = testData.getTestData(method.getName()+".name");
        password = testData.getTestData(method.getName()+".password");
        driver= new SHAFT.GUI.WebDriver();

        //make new Login to ST environment
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(username, password);
    }

    @AfterMethod(alwaysRun = true)
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass(alwaysRun = true)
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/ST/" + className + ".json");
    }
}