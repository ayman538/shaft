package de.vodafone.tests.DSLOnboarding.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DSLOnboarding.DashboardPage;
import de.vodafone.pages.DSLOnboarding.FailurePage;
import de.vodafone.pages.DSLOnboarding.WidgetPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("DSL Onboarding")
@Feature("ST")
@Story("WFGT-16")

public class WFGT_16 {
    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String urlIdent;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting urlIdent, Navigate To Dashboard")
    public void setup(Method method){
        SHAFT.Properties.flags.set().disableCache(true);
        driver= new SHAFT.GUI.WebDriver();

        urlIdent = testData.getTestData(method.getName()+".urlIdent");
        new DashboardPage(driver).navigateToSTUrl(urlIdent)
                .setCookie(cookieMap)
                .acceptCookies();
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

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "DSLOnboarding/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "DSLOnboarding/ST/" + className + ".json");
    }

    @Test(description = "GC05 |WFGT-276|DSL USER | Self Install | verify service failure for DSL Shipment Tracking Page" )
    @TmsLink("WFGT-276")
    @Issue("WFGT-693")
    private void GC05 (Method method){
        new DashboardPage(driver).clickOnWidgetButtonOnErrormessageCase();
        new FailurePage(driver).validateFailurePage(testData.getTestData(method.getName() + ".FailurePageErrorHeaderExpected"));
    }

    @Test(description ="GC07 | WFGT-278 | sanity | DSL USER | tech Install | verify DSL Shipment Tracking Page in case of shipping details is returned in service(self/tech)" )
    @TmsLink("WFGT-278")
    @Issue("WFGT-693")
    private void GC07 (Method method){
        new DashboardPage(driver).clickOnWidgetButton();
        new WidgetPage(driver).validateWidgetPageDesignHeaderOnly(testData.getTestData(method.getName() + ".widgetHeader"));
    }
}