package de.vodafone.tests.RedPlus.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.redplus.ChangeDataLimit;
import de.vodafone.pages.redplus.Dashboard;
import de.vodafone.pages.redplus.LoginPage;
import de.vodafone.pages.redplus.QuickCheckPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Red Plus")
@Feature("SIT")
@Story("WFBT-10423")
public class WFBT_10423 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    QuickCheckPage quickCheckPage;
    Dashboard dashboard;
    ChangeDataLimit changeDataLimit;

    @TmsLink("WFBT-10424")
    @Test(description = "Validate Owner Red Plus")
    public void validateRedPlusOwner() {
        dashboard = new Dashboard(driver).closeNotificationMessage();
        quickCheckPage = new Dashboard(driver).openLimitedContract().clickOnLimitedSubscriber1Acc()
                .clickOnLimitedRedPlusOwnerSO();
        quickCheckPage.clickOnRedPlusAcc().validateRedPluOwnerCard();
    }

    @TmsLink("WFBT-10425")
    @Test(description = "Assert on change limit page")
    public void assertMaxLimitData() {
        dashboard = new Dashboard(driver).closeNotificationMessage();
        quickCheckPage = new Dashboard(driver).openFlatContract().clickOnFlatRedPlusOwnerSO();
        changeDataLimit = new QuickCheckPage(driver).clickOnRedPlusAcc().clickOnChangeLimitButtonForFlatData();
        changeDataLimit.validateChangeLimitPage();
    }

    @TmsLink("WFBT-10427")
    @Test(description = "Check on QuickCheck Accordion for a member")
    public void validateQuickCheckAccordion() {
        dashboard = new Dashboard(driver).closeNotificationMessage();
        quickCheckPage = new Dashboard(driver).openLimitedContract().clickOnLimitedSubscriber2Acc().clickOnLimitedRedPlusMemberSO();
        quickCheckPage.clickOnQuickCheckAcc().validateRedPlusMemberCard();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "RedPlus/SIT_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "RedPlus/SIT/" + className + ".json");
    }
    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        username = testData.getTestData(method.getName() + ".name");
        password = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigate()
                .setCookie(cookieMap)
                .acceptCookies()
                .typeLoginData(username, password);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}