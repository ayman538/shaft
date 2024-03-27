package de.vodafone.tests.eCare.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DeviceManagement.Login;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.eCare.*;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WFGT_966 {


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
        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName,userPassword);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "eCare/SIT" + "_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "eCare/SIT/" + className + ".json");
    }

    @Test(description = "GC01 | Device Management | PIN-Engine - Resetting the PIN for care | Unity Media user | verify Confirming PIN Reset page after clicking on Neue PIN anfordern button")
    @TmsLink("WFGT-1145")
    private void GC01(Method method) {
        new Dashboard(driver).expandContract("2").clickMeineDatenSIT();
        new MeinDaten(driver).validateBanNumberExist().clickKennwörterPINsSmartObject().clickPINansehen();
        new ServicePIN(driver).validateBanNumberExist().clickNeuePINanfordernButton();
        new NeueServicePIN(driver).validateBanNumberExist().validateNeueServicePinPageMainHeader(testData.getTestData(method.getName() + ".NeueServicePinPageHeader"))
                .validateDeineServicePINSection(testData.getTestData(method.getName() + ".NeueServicePinHeader"), testData.getTestData(method.getName() + ".NeueServiceDetailsHeader"), testData.getTestData(method.getName() + ".NeueServiceDetailsContent"), testData.getTestData(method.getName() + ".JetztBestätigenButton"));
    }
    @Test(description = "GC02| Sanity | Device Management | PIN-Engine - Resetting the PIN for care | Unity Media user | verify Success confirmation page after clicking on Jetzt bestätigen button")
    @TmsLink("WFGT-1146")
    private void GC02(Method method) {
        new Dashboard(driver).expandContract("2").clickMeineDatenSIT();
        new MeinDaten(driver).validateBanNumberExist().clickKennwörterPINsSmartObject().clickPINansehen();
        new ServicePIN(driver).validateBanNumberExist().clickNeuePINanfordernButton();
        new NeueServicePIN(driver).validateBanNumberExist().clickOnJetztBestätigenButton();
        new NeueServicePINConfirmation(driver).validateBanNumberExist()
                .validateBackLink(testData.getTestData(method.getName() + ".backLink"))
                .validateConfirmationPageMainHeader(testData.getTestData(method.getName() + ".ConfirmationPageHeader"))
                .validateSuccessNotificationBox(testData.getTestData(method.getName() + ".ConfirmationNotificationHeader"), testData.getTestData(method.getName() + ".ConfirmationNotificationContent"))
                .validateÜbersichtAccordion(testData.getTestData(method.getName() + ".ÜbersichtHeader"), testData.getTestData(method.getName() + ".ÜbersichtHeadline"), testData.getTestData(method.getName() + ".ÜbersichtSubHeadline"));
    }

}
