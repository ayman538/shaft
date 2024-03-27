package de.vodafone.tests.DSL.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.MyDSLProducts;
import de.vodafone.pages.commons.LoginPage;
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

@Epic("DSL")
@Feature("ST")
@Story("WFBT-8911")
public class WFBT_8911 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    DSL_Dashboard dsl_dashboard;
    MyDSLProducts myDSLProduct;

    @Test(groups = {"WFBT-9600", "regression"})
    @Description("Validate view new bookable DSL options accordion with Bookable free and chargeable options")
    private void GC01() {
        dsl_dashboard = new DSL_Dashboard(driver);
        dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProduct.clickOnBookableOptionAccordion();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookableOptionsSectionHeader_Locator)
                .text().contains(MyDSLProducts.BookableOptionsSectionHeader_CL);
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookableOptionsSectionDesc_Locator)
                .text().contains(MyDSLProducts.BookableOptionsSectionDesc_CL);

        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookNowFreeCTA_Locator)
                .doesNotExist();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookNowCTA_Locator)
                .exists();
    }

    @Test(groups = {"WFBT-9601", "regression"})
    @Description("Validate view new bookable DSL options accordion with no Bookable options")
      private void GC02() {
        dsl_dashboard = new DSL_Dashboard(driver);
        dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProduct.clickOnBookableOptionAccordion();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.NoBookedMsgHeader_Locator)
                .text().contains(MyDSLProducts.NoBookedMsgHeader_CL);
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.NoBookedMsgBody_Locator)
                .text().contains(MyDSLProducts.NoBookedMsgBody_CL);
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
        myDSLProduct = new MyDSLProducts(driver);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}