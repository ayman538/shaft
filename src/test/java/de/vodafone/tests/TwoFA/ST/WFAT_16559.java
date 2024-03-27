package de.vodafone.tests.TwoFA.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.TwoFA.*;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("2FA")
@Feature("ST")
@Story("WFAT_16559")
public class WFAT_16559 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String federalState;
    public String customerNumber;
    public String postalCode;
    public String captcha;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    public String registrationPageDeepLink = "meinvodafone/account/registrierung/kabelvertrag";


    @TmsLink("WFAT-17028")
    @Test(description = "WFAT-17028 || UM user - Verify Request Activation Code page CLs")
    public void TC01() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver)
                .verifyInfoIconCLs()
                .verifyLoggedUMUserRequestActivationCodeCLs();
    }

    @TmsLink("WFAT-17029")
    @Test(description = "WFAT-17029 || Unauthorized UM user - Verify Request Activation Code page CLs")
    public void TC02() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .verifyInfoIconCLs()
                .verifyUnauthorizedActivationPageCLs();
    }

    @TmsLink("WFAT-17030")
    @Test(description = "WFAT-17030 || UM user - Submit Request Activation Code")
    public void TC03() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver).fillRequiredFieldsAsLoggedUMUser(federalState, customerNumber, postalCode)
                .clickOnContinueCTA();
        new RequestActivationCodePageSuccessPage(driver).validateGreenBorderIsDisplayed()
                .verifySuccessPageCLs();
    }

    @TmsLink("WFAT-17031")
    @Test(description = "WFAT-17031 || Unauthorized UM user - Submit Request Activation Code")
    public void TC04() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .fillRequiredFieldsAsUnauthorizedUser(federalState, customerNumber, postalCode, captcha)
                .clickOnContinueCTA();
        new RequestActivationCodePageSuccessPage(driver).validateGreenBorderIsDisplayed()
                .verifySuccessPageCLs();
    }

    @TmsLink("WFAT-17032")
    @Test(description = "WFAT-17032 || UM user - Press Cancel button on Request Activation Code")
    public void TC05() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver).fillRequiredFieldsAsLoggedUMUser(federalState, customerNumber, postalCode)
                .clickOnCancelCTA();
        new AccountManagementPage(driver).validateURL();
    }

    @TmsLink("WFAT-17033")
    @Test(description = "WFAT-17033 || Unauthorized UM user - Press Cancel button on Request Activation Code page")
    public void TC06() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .fillRequiredFieldsAsUnauthorizedUser(federalState, customerNumber, postalCode, captcha)
                .clickOnCancelCTA();
        new Dashboard(driver).validateDashboardPageURL();
    }

    @TmsLink("WFAT-17156")
    @Test(description = "WFAT-17156 || UM user - leave the Bundesland field empty - Verify continue CTA")
    public void TC09() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver).leaveBundeslandFieldEmpty()
                .validateEmptyFederalState();
    }

    @TmsLink("WFAT-17157")
    @Test(description = "WFAT-17157 || Unregistered user - leave the Bundesland field empty - Verify continue CTA")
    public void TC10() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver).leaveBundeslandFieldEmpty()
                .validateEmptyFederalState();
    }

    @TmsLink("WFAT-17039")
    @Test(description = "WFAT-17039 || UM user - leave Kundennummer field empty - Verify Error Msg")
    public void TC11() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver).fillRequiredFieldsAsLoggedUMUser(federalState, customerNumber, postalCode)
                .clickOnContinueCTA()
                .validateEmptyCustomerNumberErrorMsg();
    }

    @TmsLink("WFAT-17082")
    @Test(description = "WFAT-17082 || Unregistered user - leave Kundennummer field empty - Verify Error Msg")
    public void TC12() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .fillRequiredFieldsAsUnauthorizedUser(federalState, customerNumber, postalCode, captcha)
                .clickOnContinueCTA()
                .validateEmptyCustomerNumberErrorMsg();
    }

    @TmsLink("WFAT-17040")
    @Test(description = "WFAT-17040 || UM user - leave the Postleitzahl field empty - Verify Error Msg")
    public void TC13() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver).fillRequiredFieldsAsLoggedUMUser(federalState, customerNumber, postalCode)
                .clickOnContinueCTA()
                .validateEmptyPostalCodeErrorMsg();
    }

    @TmsLink("WFAT-17083")
    @Test(description = "WFAT-17083 || Unregistered user - leave the Postleitzahl field empty - Verify Error Msg")
    public void TC14() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .fillRequiredFieldsAsUnauthorizedUser(federalState, customerNumber, postalCode, captcha)
                .clickOnContinueCTA()
                .validateEmptyPostalCodeErrorMsg();
    }

    @TmsLink("WFAT-17041")
    @Test(description = "WFAT-17041 || Unauthorized UM user- leave the Captcha field empty - Verify error Msg")
    public void TC15() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .fillRequiredFieldsAsUnauthorizedUser(federalState, customerNumber, postalCode, captcha)
                .clickOnContinueCTA()
                .validateEmptyCaptchaErrorMsg();
    }

    @TmsLink("WFAT-17042")
    @Test(description = "WFAT-17042 || UM user - Insert wrong Kundennummer regex - Verify error Msg")
    public void TC16() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver).fillRequiredFieldsAsLoggedUMUser(federalState, customerNumber, postalCode)
                .clickOnContinueCTA()
                .validateWrongCustomerNumberErrorMsg();
    }

    @TmsLink("WFAT-17084")
    @Test(description = "WFAT-17084 || Unregistered user - Insert wrong Kundennummer regex - Verify error Msg")
    public void TC17() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .fillRequiredFieldsAsUnauthorizedUser(federalState, customerNumber, postalCode, captcha)
                .clickOnContinueCTA()
                .validateWrongCustomerNumberErrorMsg();
    }

    @TmsLink("WFAT-17043")
    @Test(description = "WFAT-17043 || UM user - insert wrong Postleitzahl regex - Verify error Msg")
    public void TC18() {
        new LoginPage(driver).navigateST().loginST(userName, userPassword).setCookieSwitchers(cookieMap).acceptCookies();
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickAddContract();
        new AddContractPage(driver).chooseUnityMedia().clickRequestActivationCode();
        new RequestActivationCodePage(driver).fillRequiredFieldsAsLoggedUMUser(federalState, customerNumber, postalCode)
                .clickOnContinueCTA()
                .validateWrongPostalcodeErrorMsg();
    }

    @TmsLink("WFAT-17085")
    @Test(description = "WFAT-17085 || Unregistered user - Insert wrong Postleitzahl regex - Verify error Msg")
    public void TC19() {
        new LoginPage(driver).navigateST(registrationPageDeepLink).setCookieSwitchers(cookieMap).acceptCookies();
        new RegistrationPage(driver).clickOnRequestActivationCode();
        new RequestActivationCodePage(driver)
                .fillRequiredFieldsAsUnauthorizedUser(federalState, customerNumber, postalCode, captcha)
                .clickOnContinueCTA()
                .validateWrongPostalcodeErrorMsg();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-16559_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        federalState = testData.getTestData(method.getName() + ".federalState");
        customerNumber = testData.getTestData(method.getName() + ".customerNumber");
        postalCode = testData.getTestData(method.getName() + ".postalCode");
        captcha = testData.getTestData(method.getName() + ".captcha");
        driver = new SHAFT.GUI.WebDriver();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
