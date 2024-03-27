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
@Story("WFAT_17676")
public class WFAT_17676 {
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
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
        new Dashboard(driver).chooseLoginDatenFromMeinKonto();

    }
    @TmsLink("WFAT-17986")
    @Test(description = "WFAT-17986 |Deactivated 2FA user verify user has back to account management page CTA")
    public void GC01() {
new AccountManagementPage(driver).clickDeactiavte2FA();
new TwoFADeactivation(driver).clickCheckBox().typePW(userPassword);
new DeactivationConfirmation(driver).deactivationValidation();
new DeactivationConfirmation(driver).clickBackCTA();
new AccountManagementPage(driver).loginDataCLValidation();

    }

    @TmsLink("WFAT-17987")
    @Test(description = "WFAT-17987 | WFAT-16120 |user generate Backup codes verify user has back to account management page CTA")
    public void GC02() {
        new AccountManagementPage(driver).clickBackupCode();
        new GenerateBackupCodes(driver).typePasscode(userPassword);
        new BackupCodeConfirmation(driver).backupValidation();
        new BackupCodeConfirmation(driver).clickBackCTA();
        new AccountManagementPage(driver).loginDataCLValidation();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "TwoFA/ST_WFAT-17676_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "TwoFA/ST/" + className + ".json");
    }
}
