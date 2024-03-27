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
@Story("WFAT_15276")
public class WFAT_15276 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String userName2;
    public String userPassword2;
    public String code;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        userName2 = testData.getTestData(method.getName() + ".username2");
        userPassword2 = testData.getTestData(method.getName() + ".password2");
        code = testData.getTestData(method.getName() + ".code");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @TmsLink("WFAT-16584")
    @Test(description = "WFAT-16584 | GC01-User with activated 2fa and deactivated backup codes completes merge user transaction successfully")
    public void GC01() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox()
                .clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FAStep(driver).verifyPageCL();
        new MergeAccounts2FAStep(driver).typeCode(code).clickWeiterButton();
        new MergeAccountsSelectUsernameStep(driver).selectFirstUsername();
        new MergeAccountsSetNewPasswordStep(driver).typePassword1(userPassword2).typePassword2(userPassword2).clickWeiterButton();
        new MergeAccountsConfirmationPage(driver).successNot();

    }

    @TmsLink("WFAT-16585")
    @Test(description = "WFAT-16585 | GC02-User with activated 2fa and activated backup codes completes merge user transaction successfully")
    public void GC02() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox()
                .clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FABUC(driver).verifyPageCL();
        new MergeAccounts2FABUC(driver).selectBuc();
        new MergeAccountsBUCStep(driver).verifyPageCL();
        new MergeAccountsBUCStep(driver).typeCode(code).clickWeiterButton();
        new MergeAccountsSelectUsernameStep(driver).selectFirstUsername();
        new MergeAccountsSetNewPasswordStep(driver).typePassword1(userPassword2).typePassword2(userPassword2).clickWeiterButton();
        new MergeAccountsConfirmationPage(driver).successNot();
    }

    @TmsLink("WFAT-16587")
    @Test(description = "WFAT-16587 | GC03-User with deactivated 2fa completes merge user transaction successfully")
    public void GC03() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccountsSelectUsernameStep(driver).selectFirstUsername();
        new MergeAccountsSetNewPasswordStep(driver).typePassword1(userPassword2).typePassword2(userPassword2).clickWeiterButton();
        new MergeAccountsConfirmationPage(driver).successNot();


    }

    @TmsLink("WFAT-16589")
    @Test(description = "WFAT-16589 | BC05-User empties 2fa code field and checks error msg")
    public void BC05() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FAStep(driver).checkEmptyFieldErrorMsg();
    }

    @TmsLink("WFAT-16590")
    @Test(description = "WFAT-16590 | BC06-User enters wrong regex in 2fa code field and checks error msg")
    public void BC06() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FAStep(driver).checkWrongRegexErrorMsg();
    }

    @TmsLink("WFAT-16591")
    @Test(description = "WFAT-16591 | BC07-User enters invalid code in 2fa code field and checks error msg")
    public void BC07() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FABUC(driver).select2fa();
        new MergeAccounts2FAStep(driver).typeCode(code).clickWeiterButton().verifyInvalidError();
    }

    @TmsLink("WFAT-16592")
    @Test(description = "WFAT-16592 | BC08-User enters too many invalid codes in 2fa code field and checks error msg")
    public void BC08() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FABUC(driver).select2fa();
        new MergeAccounts2FAStep(driver).typeCode(code).clickWeiterButton();
        new MergeAccountsBlockedErrorPage(driver).verify2faBlockedError();
    }

    @TmsLink("WFAT-16593")
    @Test(description = "WFAT-16593 | BC09-User empties backup code field and checks error msg")
    public void BC09() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FABUC(driver).selectBuc();
        new MergeAccountsBUCStep(driver).checkEmptyFieldErrorMsg();
    }

    @TmsLink("WFAT-16594")
    @Test(description = "WFAT-16594 | BC10-User enters wrong regex in backup code field and checks error msg")
    public void BC10() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FABUC(driver).selectBuc();
        new MergeAccountsBUCStep(driver).checkWrongRegexErrorMsg();
    }

    @TmsLink("WFAT-16595")
    @Test(description = "WFAT-16595 | BC11-User enters invalid code in backup code field and checks error msg")
    public void BC11() {
        new Dashboard(driver).chooseUbersichtFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FABUC(driver).selectBuc();
        new MergeAccountsBUCStep(driver).typeCode(code).clickWeiterButton().verifyInvalidError();
    }

    @TmsLink("WFAT-16596")
    @Test(description = "WFAT-16596 | BC12-User enters too many invalid codes in backup code field and checks error msg")
    public void BC12() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto().clickMergeAccountsSO();
        new MergeAccountsAcceptStep(driver).clickCheckbox().clickButton().clickWeiterButton();
        new MergeAccountsCredentialsStep(driver).typeUsername(userName2).typePassword(userPassword2).clickWeiterButton();
        new MergeAccounts2FABUC(driver).selectBuc();
        new MergeAccountsBUCStep(driver).typeCode(code).clickWeiterButton();
        new MergeAccountsBlockedErrorPage(driver).verifyBucBlockedError();

    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-15276_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }
}
