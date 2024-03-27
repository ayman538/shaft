package de.vodafone.tests.FormCenter.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.FormCenter.FormRendering;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Form Center")
@Feature("ST")
@Story("WFBT-10061")
public class WFBT_10061 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName()+".","");
    FormRendering formPage;

    @TmsLink("WFBT-10547")
    @Test(description = "GC03 - check that submission button is enabled when all inputs is filled correctly")
    public void checkSubmissionButton(){
        formPage = new FormRendering(driver).navigateToFormURL();
        formPage.typeFirstName("test");
        formPage.typeEmail("test@test.com");
        formPage.typeAge("23");
        formPage.checkDownloadButtonIsExisted();
        formPage.chooseRadioOption1();
        formPage.checkOption2();
        formPage.chooseFromDropDownMenu("item2");
        formPage.setDate();
        formPage.setTime();
        formPage.typeRequestInfo("this is stub for testing st");
        formPage.typeCaptcha("wdrf5");
        formPage.checkSubmitButtonIsEnabled();
    }

    @TmsLink("WFBT-10550")
    @Test(description = "GC06 - Check that submit button is dimmed with invalid inputs")
    public void checkSubmissionButtonIsNotEnable(){
        formPage = new FormRendering(driver).navigateToFormURL();
        formPage.typeFirstName("test");
        formPage.typeAge("23");
        formPage.checkDownloadButtonIsExisted();
        formPage.chooseRadioOption1();
        formPage.chooseFromDropDownMenu("item2");
        formPage.setDate();
        formPage.typeRequestInfo("this is stub for testing st");
        formPage.typeCaptcha("wdrf5");
        formPage.checkSubmitButtonIsNotEnabled();
    }

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        username = testData.getTestData(method.getName()+".name");
        password = testData.getTestData(method.getName()+".password");
        driver= new SHAFT.GUI.WebDriver();

        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(username, password);
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

