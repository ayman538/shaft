package de.vodafone.tests.kableDeutschland.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.ConfirmationPage;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.Einstellungen;
import de.vodafone.pages.Kabledeutschland.MeineRechnungen;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KabelDeutschland")
@Feature("SIT")
@Story("WFCT-13054")

public class WFCT_13054 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;
    ConfirmationPage confirmationPage;
    String selectedOption;
    String newOption;
    String optionOrder;
    String contractOrder;
    @BeforeMethod(alwaysRun = true)
    public void setup(Method method) {
        driver= new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        confirmationPage = new ConfirmationPage(driver);
        selectedOption = testData.getTestData(method.getName()+".selectedOption");
        newOption = testData.getTestData(method.getName()+".newOption");
        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        optionOrder = testData.getTestData(method.getName() + ".optionOrder");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");



        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName, userPassword);
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/SIT_WFCT_13054_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/SIT/WFCT_13054.json");
    }


    @Test(description = "WFCT_13054 | GC01 - Martin user checks the itemized bill section in the einstellungen tab")
    @TmsLink("WFCT-13057")
    public void GC01_MartinUserWithCompleteItemizedBillChecksItemizedBillSectionInTheEinstellungenTab() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnPageHeader();
        einstellungen.assertOnPageSubTitle();
        einstellungen.assertOnEditSectionHeader();
        einstellungen.assertOnEditSectionUpperDescription_mitigation();
        einstellungen.assertOnEditSectionLowerDescription_mitigation();
        einstellungen.assertOnCurrentItemizedBillType_mitigation(selectedOption);
        einstellungen.assertOnBearbeitenInMeinKabelBtn();
        einstellungen.assertOnBearbeitenInMeinKabelBtnNavigation();
    }

}
