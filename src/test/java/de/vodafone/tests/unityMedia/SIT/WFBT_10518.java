package de.vodafone.tests.unityMedia.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DSL.DSL_Login;
import de.vodafone.pages.unityMedia.ContractTermination;
import de.vodafone.pages.unityMedia.Dashboard;
import de.vodafone.pages.unityMedia.MyTariffPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Unity Media")
@Feature("SIT")
public class WFBT_10518 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");


    @Test(description = "Sanity check for Ecare WFDT-4185| Contract cancelation | Kay user - check cancelling contract")
    @TmsLink("WFBT-10796")
    public void GC01() {
        new Dashboard(driver).clickCertainKaySubscription();
        new Dashboard(driver).clickMeinTariffSO();
        new MyTariffPage(driver).clickContractTermination();
        new ContractTermination(driver).clickNoTerminationReason();
        new ContractTermination(driver).clickContinueTermination();
        new ContractTermination(driver).contractCancellationValidation();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/SIT_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/SIT/" + className + ".json");
    }

    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new DSL_Login(driver).navigateSIT()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionSIT(userName, userPassword);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

}
