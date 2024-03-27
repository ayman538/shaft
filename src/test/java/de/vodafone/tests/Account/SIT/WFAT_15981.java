package de.vodafone.tests.Account.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Account.*;
import de.vodafone.pages.TwoFA.Dashboard;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Regression")
@Feature("SIT")
@Story("WFAT_15981")
public class WFAT_15981{
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateSIT()
//                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName, userPassword);
    }

    @Test(description = "Check all account page Smart objects")
    public void GC01() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).smartObjectsValidation();
    }

    @Test(description = "Check SO redirection to add contract page")
    public void GC02() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickOnAddContractSO();
        new AddContractPage(driver).checkAddContractPage();
    }

    @Test(description = "Check SO redirection to merge accounts page")
    public void GC03() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickOnNextSOButton().clickOnMergeAccountsSO();
        new MergeAccountsPage(driver).checkMergeAccountsPage();
    }

    @Test(description = "Check login data accordion content")
    public void GC04() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).LoginDataAccordionValidations();
    }

    @Test(description = "Check change username button redirection")
    public void GC05() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickOnChangeUsernameButton();
        new ChangeUsernamePage(driver).checkUsernamePage();
    }

    @Test(description = "Check change password button redirection")
    public void GC06() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickOnChangePasswordButton();
        new ChangePasswordPage(driver).checkChangePasswordPage();
    }

    @Test(description = "Check change personal data button redirection")
    public void GC07() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickOnchangePersonalDataButton();
        new ChangePersonalDataPage(driver).checkChangePersonalDataPage();
    }

    @Test(description = "Check delete account button redirection")
    public void GC10() {
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();
        new AccountManagementPage(driver).clickOnDeleteButton();
        new DeleteAccountPage(driver).checkDeleteAccountPage();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
//        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Account/ST_WFAT-15981_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Account/SIT/" + className + ".json");
    }
}
