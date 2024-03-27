package de.vodafone.tests.PYP.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.PYP.PYPLandingPage;
import de.vodafone.pages.PYP.PYPMissingQueryParam;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

/*@Epic("PYP")
@Feature("ST")
@Story("WFAT-12781")
public class WFAT_12781 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String MSISDN;
    public String TAN;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @BeforeMethod
    @Description("Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {
        MSISDN = testData.getTestData(method.getName() + ".MSISDN");
        TAN = testData.getTestData(method.getName() + ".TAN");
        driver = new SHAFT.GUI.WebDriver();
        new PYPLandingPage(driver).missingQueryNavigate()
                .setCookie(cookieMap)
                .acceptCookies();
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "PYP/ST_PYP_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "PYP/ST/" + className + ".json");
    }

    @TmsLink("WFAT-13241")
    @Test(description=" Given that I'm user ,When I have missing app query param " +
            "Then I should be redirected to a general error page without any buttons")
    private void GC01() {
        new PYPMissingQueryParam(driver);
        Validations.assertThat()
                .element(driver.getDriver(), PYPMissingQueryParam.pypPageHeader)
                .text()
                .contains(PYPMissingQueryParam.pypPageHeader_text)
                .withCustomReportMessage("Check that page header is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), PYPMissingQueryParam.pypErrorHeader)
                .text()
                .contains(PYPMissingQueryParam.errorHeader_text)
                .withCustomReportMessage("Check that error header is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), PYPMissingQueryParam.pypErrorBody)
                .text()
                .contains(PYPMissingQueryParam.pypErrorBody_text)
                .withCustomReportMessage("Check that error body is exist")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), PYPMissingQueryParam.pypButton)
                .doesNotExist()
                .withCustomReportMessage("Check that button doesn't exist")
                .perform();
    }

}*/

