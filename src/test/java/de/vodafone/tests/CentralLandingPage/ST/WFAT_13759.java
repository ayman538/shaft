package de.vodafone.tests.CentralLandingPage.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.CentralLandingPage.LandingPageRedirection;
import de.vodafone.pages.Solstice.SolsticeDashboard;
import de.vodafone.pages.Solstice.SolsticeLogin;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Central Landing Page")
@Feature("ST")
@Story("WFAT_13759")
public class WFAT_13759 {
    public String userName;
    public String userPassword;
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();

        new SolsticeLogin(driver).navigateST()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionST(userName, userPassword);
        Validations
                .assertThat()
                .element(driver.getDriver(), SolsticeDashboard.loginIndicator).exists()
                .perform();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "CentralLandingPage/ST_WFAT-13759_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "CentralLandingPage/ST/" + className + ".json");
    }

    @Test
    @Description(" Given  I'm user that does not have any eligible subscribers and coming from the add contract and subscriber  ," +
            "When  I complete the \" Add contract and subscribers flow\" and add desired MSISDN " +
            "Then  I want to be redirected to the already existed confirmation page with an additional/new CTA button \"under add missing subscribers button\" " +
            "that redirects me back to the form center flow so I can complete it")
    public void EmmaUserloggedinfromCentrallandingpage_Verifyconfirmationpage(Method method) {
        userName = testData.getTestData(method.getName() + ".username");
        userPassword = testData.getTestData(method.getName() + ".userpassword");
        new LandingPageRedirection(driver).redirectToGeneralErrorST()
                .addContract()
                .addMobileContract()
                .addSubscriberInfo(userName, userPassword);
               /*.pageNewButtonValidation();*/
    }
}
