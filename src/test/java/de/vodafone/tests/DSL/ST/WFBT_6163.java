package de.vodafone.tests.DSL.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Validations;
import de.vodafone.pages.DSL.*;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-6163")
public class WFBT_6163 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String username;
    public String password;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");
    DSL_Dashboard dsl_dashboard;
    DSL_ConfirmationPage confirmatinPage;

    @Test(groups = {"WFBT-9390", "regression"})
    @Description("Check the unavailability of deeplinking to the Cancel DSL Extras Confirmation Page")
    private void GC01() {

        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickViewMoreSOs().clickBookedOptionsSO_expandBookedOptionsAcc();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookedOptionsSectionHeader_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionHeader_CL);
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookedOptionsSectionDesc_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionDesc_CL);

        DSL_CancelingTransaction dsl_cancelingTransaction = myDSLProducts.clickCancelOptionII();
        confirmatinPage = dsl_cancelingTransaction.clickQuitNowCTA();

        String URL = driver.browser().getCurrentURL();
        driver.browser().navigateToURL(URL);
        Validations.assertThat().element(driver.getDriver(),myDSLProducts.BookedExtrasContainerLocator).exists();

    }

    @Test(groups = {"WFBT-9397", "regression"})
    @Description("Cancelling a booked DSL extra")
    private void GC02() {

        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickViewMoreSOs().clickBookedOptionsSO_expandBookedOptionsAcc();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookedOptionsSectionHeader_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionHeader_CL);
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookedOptionsSectionDesc_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionDesc_CL);


        DSL_CancelingTransaction dsl_cancelingTransaction = myDSLProducts.clickCancelOptionII();

        String BookedExtraTitle1 = dsl_cancelingTransaction.getTransText(dsl_cancelingTransaction.BookedExtraTitleLocator);
        String BookedExtraPrice1 = dsl_cancelingTransaction.getTransText(dsl_cancelingTransaction.BookedExtraPriceLocator);
        String BookedExtraDesc1 = dsl_cancelingTransaction.getTransText(dsl_cancelingTransaction.BookedExtraDescriptionLocator);


        confirmatinPage = dsl_cancelingTransaction.clickQuitNowCTA();
        Validations.assertThat()
                .element(driver.getDriver(), DSL_ConfirmationPage.CancelationNotification)
                .textTrimmed().contains(DSL_ConfirmationPage.confMsg);

        confirmatinPage.expandOverviewAccordion(confirmatinPage.OverviewAccordionLocator);

        String BookedExtraTitle2 = confirmatinPage.getConfText(confirmatinPage.BookedExtraTitleLocator);
        String BookedExtraPrice2 = confirmatinPage.getConfText(confirmatinPage.BookedExtraPriceLocator);
        String BookedExtraDesc2 = confirmatinPage.getConfText(confirmatinPage.BookedExtraDescriptionLocator);

        Assert.assertEquals(BookedExtraTitle1,BookedExtraTitle2);
        Validations.verifyThat().object(BookedExtraPrice1).contains(BookedExtraPrice2).perform();
        Assert.assertEquals(BookedExtraDesc1,BookedExtraDesc2);


    }

    @Test(groups = {"WFBT-9398", "regression"})
    @Description("Check loosing the Gigakombi discount")
    private void GC03() {

        dsl_dashboard = new DSL_Dashboard(driver);
        MyDSLProducts myDSLProducts = dsl_dashboard.chooseMyProductsFromMyProductsAcc();
        myDSLProducts.clickViewMoreSOs().clickBookedOptionsSO_expandBookedOptionsAcc();
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookedOptionsSectionHeader_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionHeader_CL);
        Validations.assertThat()
                .element(driver.getDriver(), MyDSLProducts.BookedOptionsSectionDesc_Locator)
                .textTrimmed().equals(MyDSLProducts.BookedOptionsSectionDesc_CL);

        HandleGigaKombi handleGigaKombi = myDSLProducts.clickCancelOption();
        Validations.assertThat().element(driver.getDriver(),handleGigaKombi.GigaKombiNotification).exists();


        DSL_CancelingTransaction dsl_cancelingTransaction = handleGigaKombi.clickQuitNowCTA();
        confirmatinPage = dsl_cancelingTransaction.clickQuitNowCTA();

        Validations.assertThat()
                .element(driver.getDriver(), DSL_ConfirmationPage.CancelationNotification)
                .text().contains(DSL_ConfirmationPage.confMsg);

    }
    @BeforeClass
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
