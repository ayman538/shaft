package de.vodafone.tests.FirstLogin;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.FirstLogin.LoginPage;
import de.vodafone.pages.FirstLogin.SuccessConfirmationPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("First Login")
public class WFAT_13748 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String Email;
    public String Number;
    public String Password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeClass()
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "FirstLogin/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "FirstLogin/ST/" + className + ".json");
    }

    @BeforeMethod
    public void setup(Method method) {
        Email = testData.getTestData(method.getName() + ".Email");
        Number = testData.getTestData(method.getName() + ".Number");
        Password = testData.getTestData(method.getName() + ".Password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigate()
                .setCookie(cookieMap).navigate()
                .acceptCookies();
    }

    @TmsLink("WFAT-13997")
    @Test(description = "First Login User navigates to Summary Step and checks page content")
    public void GC01(){
        new LoginPage(driver).LoginAction(Number, Email, Password);
        new SuccessConfirmationPage(driver).successNotificationValidations();
        new SuccessConfirmationPage(driver).pageTitleValidation();
        new SuccessConfirmationPage(driver).summaryValidations();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
