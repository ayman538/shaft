package de.vodafone.tests.KD.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KD")
@Feature("ST")
@Story("WFBT-10695")
public class WFBT_10695 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    KD_Dashboard kdDashboard;
    KabelTVPage kabelTV;

    @TmsLink("WFBT_11064")
    @Test(description = "GC01 Check Existence of Kabel-TV accordion in Dashboard")
    public void GC01_CheckExistenceOfKabelTVAccordionInDashboard(){
        kdDashboard.validateExistenceOfKabelTVAccordion();
    }

    @TmsLink("WFBT_11065")
    @Test(description = "GC02 Check Existence of Mein Kabel-TV smart object with a static text Mein Kabel-TV, an icon and a subline/the next possible end date of the contract")
    public void GC02_CheckExistenceOfMeinKabelTVSODetails(){
        kdDashboard.expandKabelTvAccordion();
        kdDashboard.validateMeinKabelTVSODashBoard();
    }

    @TmsLink("WFBT_11066")
    @Test(description = "GC03 Check when click on Mein Kabel-TV smart object , Mein Kabel-TV accordion will expand showing content")
    public void GC03_CheckWhenClickOnMeinKabelTVSOMeinKabelTVAccordionWillExpand(){
        kdDashboard.expandKabelTvAccordion();
        kdDashboard.clickOnMeinKabelTVSO();
        kabelTV.validateMeinKabelTVSO();
        kabelTV.clickOnMeinKabelTVAccordion();
        kabelTV.clickOnMeinKabelTVSO();
        kabelTV.validateWhenClickMKTVSOExpandMKTVAccordion();
    }

    @TmsLink("WFBT_11067")
    @Test(description = "GC04 Check Mein Kabel-TV added to Burger menu first option")
    public void GC04_CheckMeinKabelTVAddedToBurgerMenuFirstOption(){
        kdDashboard.clickOnBurgerMenuKabelTV();
        kdDashboard.validateMeinKabelTVFirstOptionInBurgerMenu();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KD/ST/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KD/ST/" + className + ".json");
    }

    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateST().setCookieSwitchers(cookieMap).acceptCookies().loginST(userName, userPassword);
        /*new Login(driver).navigateToSTUrl()
                .setCookie(cookieMap)
                .acceptCookies()
                .stLoginAction(userName, userPassword);*/
        kdDashboard = new KD_Dashboard(driver);
        kabelTV = new KabelTVPage(driver);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
