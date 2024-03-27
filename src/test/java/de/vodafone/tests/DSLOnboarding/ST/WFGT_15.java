package de.vodafone.tests.DSLOnboarding.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DSLOnboarding.DashboardPage;
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
@Story("WFGT-15")
public class WFGT_15{
    public SHAFT.GUI.WebDriver driver ;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String urlIdent;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting urlIdent, Navigate To Dashboard")
    public void setup(Method method){
        driver= new SHAFT.GUI.WebDriver();
        SHAFT.Properties.flags.set().disableCache(true);
        urlIdent = testData.getTestData(method.getName()+".urlIdent");
        new DashboardPage(driver).navigateToSTUrl(urlIdent)
                .setCookie(cookieMap)
                .acceptCookies();
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        SHAFT.Properties.flags.set().disableCache(true);
        driver.browser().closeCurrentWindow();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "DSLOnboarding/ST_" +className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "DSLOnboarding/ST/" + className + ".json");
    }

    @Test(description ="GC02 | WFGT-290 | DSL user | Self Install | verify delivery status information and the parcel tracking ID is generated In case of one parcel with Parcel Tracking ID" )
    @TmsLink("WFGT-290")
    @Issue("Deine Sendungsverfolgung Section not appeared due to caching of wording file")
    private void GC02(Method method){
        new DashboardPage(driver)
                .validateSectionExist(testData.getTestData(method.getName() + ".Header"), testData.getTestData(method.getName() + ".widgetButton"));
        new DashboardPage(driver).clickOnWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"));
    }

    @Test(description ="GC03 | WFGT-291 | DSL user | Self Install | verify delivery status information and the parcel tracking ID is generated In case of one parcel without Parcel Tracking ID" )
    @TmsLink("WFGT-291")
    @Issue("Deine Sendungsverfolgung Section not appeared due to caching of wording file")
    private void GC03(Method method){
        new DashboardPage(driver).validateSectionMessage(testData.getTestData(method.getName() + ".SectionMsg"));
    }
    @Test(description ="GC04 | WFGT-292 | Sanity | DSL USER |Tech Install |verify delivery status information and the parcel tracking ID is generated In case of multiple parcel with Parcel Tracking ID(3 parcels)" )
    @TmsLink("WFGT-292")
    private void GC04(Method method){
        new DashboardPage(driver).validateSectionThreeParcelsExist(testData.getTestData(method.getName() + ".widgetHeader"), testData.getTestData(method.getName() + ".widgetButton"))
                .clickOnWidgetButton();
        new WidgetPage(driver).validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"))
                .clickOnBackBrowser();
        new DashboardPage(driver)
                .clickOnSecondWidgetButton();
        new WidgetPage(driver).validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"))
                .clickOnBackBrowser();
        new DashboardPage(driver)
                .clickOnThirdWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"));
    }
    @Test(description ="GC05 | WFGT-293 | DSL user | Self Install | verify delivery status information In case of no shipping exsit" )
    @TmsLink("WFGT-293")
    @Issue("Deine Sendungsverfolgung Section not appeared due to caching of wording file")
    private void GC05(Method method) {
        new DashboardPage(driver).validateSectionNotExist();
    }

    @Test(description ="GC06 | WFGT-294 | SIT02| DSL USER |Tech Install |verify delivery status information In case of multiple parcel with one without Parcel Tracking ID(2 parcels with tracking Id will displayed and the one without tracking id it's section will not appear )" )
    @TmsLink("WFGT-294")
    private void GC06(Method method){
        new DashboardPage(driver)
                .validateSectionTwoParcelsExist(testData.getTestData(method.getName() + ".widgetHeader"), testData.getTestData(method.getName() + ".widgetButton"))
                .clickOnWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"))
                .clickOnBackBrowser();
        new DashboardPage(driver)
                .clickOnSecondWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"));
    }

    @Test(description ="GC07 | WFGT-295 |  DSL user | verify delivery status information and the parcel tracking ID is generated In case of multiple parcel " )
    @TmsLink("WFGT-295")
    @Issue("Deine Sendungsverfolgung Section not appeared due to caching of wording file")
    private void GC07(Method method){
        new DashboardPage(driver)
                .validateSectionExist(testData.getTestData(method.getName() + ".widgetHeader"), testData.getTestData(method.getName() + ".widgetButton"))
                .clickOnWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"))
                .clickOnBackBrowser();
        new DashboardPage(driver)
                .clickOnSecondWidgetButton();
        new WidgetPage(driver)
                .validateWidgetPageHeader(testData.getTestData(method.getName() + ".widgetHeader"));
    }

    @Test(description ="GC08 | WFGT-296 | DSL user | Verify Shipment Tracking page in case of service failure" )
    @TmsLink("WFGT-296")
    private void GC08(Method method) {
        new DashboardPage(driver).validateSectionNotExist();
    }
    @Test(description ="GC10 | WFGT-357 | DSL USER | Self Install | verify delivery status information and the parcel tracking ID is generated In case of one parcel without tracking name" )
    @TmsLink("WFGT-357")
    private void GC10(Method method){
        new DashboardPage(driver)
                .validateNoHardwareNotExist()
                .validateHeadlineExist(testData.getTestData(method.getName() + ".Header")).validateSectionMessage(testData.getTestData(method.getName() + ".SectionMsg"));
    }
    @Test(description ="GC11 | WFGT-358 | DSL USER | Self Install | verify delivery status information and the parcel tracking ID is generated In case of one parcel without postal code" )
    @TmsLink("WFGT-358")
    private void GC11(Method method){
        new DashboardPage(driver)
                .validateNoHardwareNotExist()
                .validateHeadlineExist(testData.getTestData(method.getName() + ".Header"))
                .validateSectionMessage(testData.getTestData(method.getName() + ".SectionMsg"));
    }
    @Test(description ="GC12 | WFGT-359 | DSL USER | Self Install | verify delivery status information and the parcel tracking ID is generated In case of one parcel without status = versand" )
    @TmsLink("WFGT-359")
    private void GC12(Method method){
        new DashboardPage(driver)
                .validateNoHardwareNotExist()
                .validateHeadlineExist(testData.getTestData(method.getName() + ".Header")).validateSectionMessage(testData.getTestData(method.getName() + ".SectionMsg"));
    }
}
