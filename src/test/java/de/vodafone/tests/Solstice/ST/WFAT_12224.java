package de.vodafone.tests.Solstice.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.eCare.Login;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Solstice")
@Feature("ST")
@Story("WFAT_12224")
public class WFAT_12224 {
    private SHAFT.GUI.WebDriver driver;
    private JSONFileManager testData;
    private HashMap<String, String> cookieMap;
    private String userName;
    private String userPassword;
    private String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    private String environment ="ST";
    @TmsLink("WFAT-15372")
    @Test(description="WFAT-15372-Check Notification when logging in with a Username that is not E-mail")
    private void GC01() {
        new SolsticeDashboard(driver).chooseLoginDatenFromMeinKonto()
                .validateUsernameNotEmailError();
    }
    @TmsLink("WFAT-15373")
    @Test(description="WFAT-15373-Check Notification when logging in with a Username that is E-mail")
    private void GC02() {
        new SolsticeDashboard(driver).chooseLoginDatenFromMeinKonto()
                .validateUsernameNotEmailErrorNotVisible();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Solstice/ST_WFAT-12224_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Solstice/ST/" + className + ".json");
    }
    @BeforeMethod
    @Description("setting branches and navigating to login page and login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new Login(driver).navigateST()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionST(userName, userPassword);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}