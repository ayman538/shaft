package de.vodafone.tests.DSL.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.DSL_Login;
import de.vodafone.pages.DSL.MyDSLProducts;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-8952")
public class WFBT_8952{

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    DSL_Dashboard dsl_dashboard;

    @TmsLink("WFBT-9068")
    @Test(description = "Marc user | Validate bookable DSL tariff extras - not super WLAN subscriber")
    public void GC01() {

        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickSuperWLANSO_expandSuperWLANAcc();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_AccHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_AccHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_AccDesc_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_AccDesc_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_1stTileHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookableTileHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_1stTilePrice_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookableTilePrice_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_1stTileDesc_Locator)
                .text().contains(MyDSLProducts.superWLAN_BookableTileDesc_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_1stTileDesc_Locator)
                .text().contains(MyDSLProducts.superWLAN_BookableTileDesc_CL2).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_1stTileCallCenterButton_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookableTileCallCenterButton_CL).perform();
    }
    @TmsLink("WFBT-9069")
    @Test(description = " Marc user | Validate bookable DSL tariff extras - superWLAN subscriber")
    public void GC02() {

        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickSuperWLANSO_expandSuperWLANAcc();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_AccHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_AccHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_AccDesc_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_AccDesc_CL).perform();

        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookableTileHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTilePrice_Locator)
                .textTrimmed().contains(MyDSLProducts.SuperWLAN_BookableTilePrice_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileDesc_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookedTileDesc_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileCancellationNt_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_2ndTileCancellationNt_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileCallCenterButton_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookableTileCallCenterButton_CL).perform();

        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_1stTileHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookableTileHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_1stTileCallCenterButton_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookableTileCallCenterButton_CL).perform();
    }
    @TmsLink("WFBT-9070")
    @Test(description = "Marc user | Validate bookable DSL tariff extras - super WLAN and super WLAN extender subscriber")
    public void GC03() {

        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickSuperWLANSO_expandSuperWLANAcc();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_AccHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_AccHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_AccDesc_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_AccDesc_CL).perform();


        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_3rdTileHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookableTileHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_3rdTilePrice_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookableTilePrice_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_3rdTileDesc_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_BookedTileDesc_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_3rdTileCancellationNt_Locator)
                .text().contains(MyDSLProducts.SuperWLAN_2ndTileCancellationNt_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_3rdTileCallCenterButton_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookableTileCallCenterButton_CL).perform();


        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileHeader_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookedTileHeader_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileDesc_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookedTileDesc_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileCancellationNt_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookedCancellationNt_CL).perform();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.SuperWLAN_2ndTileCallCenterButton_Locator)
                .text().contains(MyDSLProducts.SuperWLANExtender_BookedTileCallCenterButton_CL).perform();

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
        new DSL_Login(driver).navigateST()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionST(username, password);
    }
    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

}
