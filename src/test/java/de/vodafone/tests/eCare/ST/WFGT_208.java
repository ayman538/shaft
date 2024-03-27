package de.vodafone.tests.eCare.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.Login;
import de.vodafone.pages.eCare.MeineRechnungen;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WFGT_208 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod()
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        SHAFT.Properties.flags.set().disableCache(true);
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
        SHAFT.Properties.flags.set().disableCache(false);
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "eCare/ST" + "_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "eCare/ST/" + className + ".json");
    }

    @Test(description = "GC01 | WFGT-246 | Martin user | Validate showing the migration message to the user as a user with one contract")
    @TmsLink("WFGT-246")
    @Issue("OverLay message not appeared due to problem in ST session and cookies")
    private void GC01(Method method) {
        new Dashboard(driver).expandContract("1").validateOverLayMsgExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent")).
                CLosePopUpMessage().expandContract("1").validateNotificationBoxExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent"));
    }

    @Test(description = "GC02 | WFGT-247 | Ute user | Validate showing the migration message to the user as a user with one contract")
    @TmsLink("WFGT-247")
    @Issue("OverLay message not appeared due to problem in ST session and cookies")
    private void GC02(Method method) {
        new Dashboard(driver).expandContract("1").validateOverLayMsgExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent")).
                CLosePopUpMessage().expandContract("1").validateNotificationBoxExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent"));
    }

    @Test(description = "GC03 | WFGT-248 | sanity |multi contract (ute - martin) | two contracts in migration in the same account, overlay should displayed only once")
    @TmsLink("WFGT-248")
    private void GC03(Method method) {
        new Dashboard(driver).expandContract("1").validateOverLayMsgExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent")).
                CLosePopUpMessage().validateNotificationBoxExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent")).
                expandContract("2").validateOverLayMsgNotExist().validateSecondAccordionNotificationBoxExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent"));
    }

    @Test(description = "GC05 | WFGT-250 | Martin user | Validate not showing the migration message in Migrated status")
    @TmsLink("WFGT-250")
    private void GC05(Method method) {
        new Dashboard(driver).validateOverLayMsgNotExist().validateNotificationBoxNotExist();
    }
    @Test(description = "GC04 | WFGT-249 | Ute consumer- Validate showing the migration message to the deep link user")
    @TmsLink("WFGT-249")
    private void GC04(Method method) {
        new Dashboard(driver)
                .expandContract("2")
                .validateOverLayMsgExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent"))
                .CLosePopUpMessage()
                .validateNotificationBoxExist(testData.getTestData(method.getName() + ".overlayHeader"), testData.getTestData(method.getName() + ".overlayContent"))
                .expandContract("2");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver.getDriver();
        jsExecutor.executeScript("window.localStorage.clear();");
        new MeineRechnungen(driver)
                .deepLinkRechnungenST()
                .expandMartinContractChooser()
                .assertPageTitle()
                .validateNoNotificationOrOverlayOnAccordion();
    }
}
