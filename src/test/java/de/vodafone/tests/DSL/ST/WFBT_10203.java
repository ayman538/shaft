package de.vodafone.tests.DSL.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.DSL.BookingSecureNetPlusLegacyPortal;
import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.MyDSLProducts;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-10203")
public class WFBT_10203{
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    DSL_Dashboard dsl_dashboard;
    @TmsLink("WFBT-10292")
    @Test(enabled = false , description="Descoped")
    private void GC02() {
        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickSecureNetSO_expandSecureNetAcc();

        /*Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SecureNetSectionTextLocator)
                .text().equals(MyDSLProducts.SecureNetSectionTextCL);
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SecureNetImageLocator).exists();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SecureNetTitleLocator)
                .text().equals(MyDSLProducts.SecureNetTitleCL);
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SecureNetDescLocator)
                .text().equals( MyDSLProducts.NewSecureNetDescCL);
        Validations.assertThat()
                .element(driver.getDriver(),  MyDSLProducts.SecureNetPlusMoreInfoCTALocator)
                .doesNotExist();
        Validations.assertThat()
                .element(driver.getDriver(), myDSLProducts.NewSecureNetBookNowCTALocator)
                .text().equals(myDSLProducts.SecureNetBookNowCTACL);*/

        BookingSecureNetPlusLegacyPortal bookingSecureNetPlusLegacyPortal = myDSLProducts.clickSecurenetPlusBookNowCTA_LegacyPortal();
        Assert.assertEquals(bookingSecureNetPlusLegacyPortal.getLegacyURL(),bookingSecureNetPlusLegacyPortal.LegacyURL);
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "DSL/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "DSL/ST/" + className + ".json");
    }

    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        username = testData.getTestData(method.getName() + ".name");
        password = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
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
}