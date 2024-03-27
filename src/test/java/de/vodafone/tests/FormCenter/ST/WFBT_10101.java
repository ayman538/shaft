package de.vodafone.tests.FormCenter.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.FormCenter.FormConfirmationPage;
import de.vodafone.pages.FormCenter.FormRendering;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Form Center")
@Feature("ST")
@Story("WFBT-10101")
public class WFBT_10101 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName()+".","");
    FormRendering formPage;

    @TmsLink("WFBT-10724")
    @Test(description = "check that submission button is enabled when all inputs is filled correctly and user redirected to confirmation page")
    public void checkSubmissionConfirmation(){
        formPage = new FormRendering(driver).navigateToFormURL();
        formPage.typeFirstName("test");
        formPage.typeEmail("test@test.com");
        formPage.typeAge("23");
        formPage.checkDownloadButtonIsExisted();
        formPage.chooseRadioOption1();
        //formPage.checkOption2();
        formPage.chooseFromDropDownMenu("item2");
        formPage.setDate();
        formPage.setTime();
        formPage.typeRequestInfo("this is stub for testing st");
        formPage.typeCaptcha("wdrf55");
        formPage.checkSubmitButtonIsEnabled();
        formPage.clickOnSubmit();
       new FormConfirmationPage(driver).validateFormConfirmationMsg();
    }

    @TmsLink("WFBT-10723")
    @Test(description = "check that submission button is enabled when all inputs is filled correctly and user redirected to general error page")
    public void checkSubmissionGeneralError(){
        formPage = new FormRendering(driver).navigateToFailedFormURL();
        formPage.typeFirstNameForm5("test");
        formPage.typeAge5("23");
        formPage.typeCaptcha("wdrf55");
        formPage.checkSubmitButtonIsEnabled();
        formPage.clickOnSubmit();
        new FormConfirmationPage(driver).validateFormGeneralErrorMsg();
    }

    @TmsLink("WFBT-11375")
    @Test(description = "check that error accorded when user entered invalid captcha")
    public void checkInvalidCaptcha(){
        formPage = new FormRendering(driver).navigateToInvalidCaptchaFormURL();
        formPage.typeCaptcha("wdrf55");
        formPage.checkSubmitButtonIsEnabled();
        formPage.clickOnSubmit();
        formPage.validateInvalidCaptchaError();
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        username = testData.getTestData(method.getName()+".name");
        password = testData.getTestData(method.getName()+".password");
        driver= new SHAFT.GUI.WebDriver();

        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies();
             //   .loginAction(username, password);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "FormCenter/ST_"+className+"_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "FormCenter/ST/" + className + ".json");
    }
}

