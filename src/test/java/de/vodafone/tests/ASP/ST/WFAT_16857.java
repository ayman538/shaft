package de.vodafone.tests.ASP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.ASP.ASPLandingPage;
import de.vodafone.pages.ASP.DSLResonsofterminationPage;
import de.vodafone.pages.ASP.DslReseonsofRevocationpage;
import de.vodafone.pages.commons.ASPLogin;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

public class WFAT_16857 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {

        driver = new SHAFT.GUI.WebDriver();
       new ASPLogin(driver)
               .navigateST()
               .setCookieSwitchers(cookieMap)
               .acceptCookies();
    }
    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
       cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "ASP/ST_WFAT-16714_CookieSwitcher.json").getTestDataAsMap("$");

    }
    @TmsLink("WFAT-17446")
    @Test(description = "DSl user verify reasons of revocation page")
    public void GC01() {
new ASPLandingPage(driver).buffaloUser();
new DslReseonsofRevocationpage(driver).revocatioOptionsValidations().revocationURLValidation();
    }
    @TmsLink("WFAT-17447")
    @Test(description = "DSl user verify marketing popup")
    public void GC02() {
        new ASPLandingPage(driver).buffaloUser();
        new DslReseonsofRevocationpage(driver)
                .clickoption6()
                .popupValidation();
    }

    @TmsLink("WFAT-17448")
    @Test(description = "DSl user verify reasons of termination page")
    public void GC03() {
        new ASPLandingPage(driver).mooseUser();
        new DSLResonsofterminationPage(driver).terminationOptionsValidations().terminationURLValidation();
    }
    @TmsLink("WFAT-17448")
    @Test(description = "DSl user verify marketing popup for termination")
    public void GC04() {
        new ASPLandingPage(driver).mooseUser();
        new DSLResonsofterminationPage(driver).clickoption6().popupValidation();

    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}
