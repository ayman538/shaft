package de.vodafone.tests.KD.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
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
@Story("WFBT-11589")
public class WFBT_11589 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    String TariffChangeSOTitleCL, TariffChangeSOBodyCL;
    String WLANHotspotSOTitleCL, WLANHotspotSOBodyCL;
    KD_Dashboard kdDashboard;
    TariffPageInternetAndPhone internetAndPhoneTariff;

    @TmsLink("WFBT_12081")
    @Test(description = "GC01 | WFBT_11589 | Check Smart object ordering in Tarif Detail page in KIP")
    public void GC01_CheckSOOrderingtariffDetailsPageInKIP(){
        kdDashboard.openBurgerMenu();
        kdDashboard.clickOnMeinTarifKIPBurgerMenu();
        internetAndPhoneTariff.validateSmartObjectOrdering();
    }

    @TmsLink("WFBT_12082")
    @Test(description = "GC02 | WFBT_11589 | Check Tarif wechseln SO came before Gebuchte Optionen SO")
    public void GC02_CheckTarifWechselnSOCameBeforeGebuchteOptionenSO(){
        kdDashboard.openBurgerMenu();
        kdDashboard.clickOnMeinTarifKIPBurgerMenu();
        internetAndPhoneTariff.validateTariffChangeSO(TariffChangeSOTitleCL, TariffChangeSOBodyCL);
    }

    @TmsLink("WFBT_12083")
    @Test(description = "GC03 | WFBT_11589 | Check WLAN-Hotspot-Logins SO came last one")
    public void GC03_CheckWLANHotspotLoginsSOCameLastOne(){
        kdDashboard.openBurgerMenu();
        kdDashboard.clickOnMeinTarifKIPBurgerMenu();
        internetAndPhoneTariff.validateWLANHotspotSO(WLANHotspotSOTitleCL, WLANHotspotSOBodyCL);
    }
    @TmsLink("WFBT_12084")
    @Test(description = "GC04 | WFBT_11589 | Check Tarif wechseln SO when click on it will directed to its part in mein tarif")
    public void GC04_CheckTarifWechselnSOwhenClickOnItWillDirectedToItsPartInMeinTarif(){
        kdDashboard.openBurgerMenu();
        kdDashboard.clickOnMeinTarifKIPBurgerMenu();
        internetAndPhoneTariff.clickOnMeinTariffAccordion();
        internetAndPhoneTariff.clickOnTariffChangeSO();
        internetAndPhoneTariff.validateMyTariffAccIsExpanded();
    }

    @TmsLink("WFBT_12085")
    @Test(description = "GC05 | WFBT_11589 | Check when click on WLAN Hotspot SO will redirects to external link in a new tab")
    public void GC05_CheckWhenClickOnWLANHotspotSOWillRedirectedToExternalLinkInNewTab(){
        kdDashboard.openBurgerMenu();
        kdDashboard.clickOnMeinTarifKIPBurgerMenu();
        internetAndPhoneTariff.clickNextButtonKipSO();
        internetAndPhoneTariff.clickOnWLANHotspotSO();
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
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
        kdDashboard = new KD_Dashboard(driver);
        internetAndPhoneTariff = new TariffPageInternetAndPhone(driver);
        TariffChangeSOTitleCL = testData.getTestData(method.getName() + ".TariffChangeSOTitleCL");
        TariffChangeSOBodyCL = testData.getTestData(method.getName() + ".TariffChangeSOBodyCL");
        WLANHotspotSOTitleCL = testData.getTestData(method.getName() + ".WLANHotspotSOTitleCL");
        WLANHotspotSOBodyCL = testData.getTestData(method.getName() + ".WLANHotspotSOBodyCL");
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
