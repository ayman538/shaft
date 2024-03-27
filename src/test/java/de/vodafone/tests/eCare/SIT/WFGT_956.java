package de.vodafone.tests.eCare.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DeviceManagement.Login;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.eCare.Dashboard;
import de.vodafone.pages.eCare.MeinDaten;
import de.vodafone.pages.eCare.ServicePIN;
import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.lang.reflect.Method;
import java.util.HashMap;

public class WFGT_956 {

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
                .loginSIT(userName, userPassword);

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

    @Test(description = "GC02 | WFGT-1133 | Sanity | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user | verify Service PIN page")
    @TmsLink("WFGT-1133")
    @Issue("WFGT-956")
    private void GC02(Method method){
        new Dashboard(driver).expandContract("2").clickMeineDatenSIT();
        new MeinDaten(driver).clickKennwörterPINsSmartObject()
                             .clickPINansehen();
        new ServicePIN(driver)
                .validateServicePinPageMainHeader((testData.getTestData(method.getName() + ".ServicePinPageHeader")))
                .validateServicePINAnsehenAccordion(testData.getTestData(method.getName() + ".PINAnsehenAccordionTitle"),testData.getTestData(method.getName() + ".PINAnsehenAccordionDetailsFirstPart"),testData.getTestData(method.getName() + ".PINAnsehenAccordionDetailsSecondPart"))
                .validateServicePinHeader((testData.getTestData(method.getName() + ".ServicePinHeader")))
                .validateServiceDetails(testData.getTestData(method.getName() + ".ServiceDetailsFirstPart"),testData.getTestData(method.getName() + ".ServiceDetailsSecondPart"))
                .validateansehenServicePinMessage((testData.getTestData(method.getName() + ".ansehenServicePinMessage")))
                .validateNeuePINanfordernButton((testData.getTestData(method.getName() + ".NeuePINanfordernButton")));
    }
    @Test(description = "GC04 | WFGT-1135 | Device Management | PIN-Engine - Viewing the PIN for care | Unity Media user with no Pin | verify the (Kennworter & pins) accordion")
    @TmsLink("WFGT-1135")
    private void GC04(Method method){
        new Dashboard(driver).clickMeineDaten();
        new MeinDaten(driver)
                .clickKennwörterPINsSmartObject()
                .validateErrorNopin(testData.getTestData(method.getName() + ".ErrorTitleNopin"),testData.getTestData(method.getName() + ".ErrorDetailsNopin"));
    }
}
