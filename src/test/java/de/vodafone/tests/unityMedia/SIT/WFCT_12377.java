package de.vodafone.tests.unityMedia.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Payment.Login;
import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("UnityMedia")
@Feature("SIT")
@Story("WFCT-12377")

public class WFCT_12377 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    Rechnungen rechnungen;
    InvoiceSummary invoiceSummary;
    String detailsPageOrder;
    String unPaidAmount;
    String amountToPay;
    String chartBarOrder;

    @BeforeMethod


    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/SIT_WFCT_12377_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/SIT/WFCT_12377.json");
    }

    @AfterMethod(description = "Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        driver = new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        invoiceSummary = new InvoiceSummary(driver);
        unPaidAmount = testData.getTestData(method.getName() + ".unPaidAmount");
        amountToPay = testData.getTestData(method.getName() + ".amountToPay");
        detailsPageOrder = testData.getTestData(method.getName() + ".detailsPageOrder");
        chartBarOrder = testData.getTestData(method.getName() + ".chartBarOrder");
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");

        new Login(driver).navigateSIT()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionSIT(userName, userPassword);
    }

    @Test(description = "GC02- Ute user checks the bill summary page for the old months")
    @TmsLink("WFCT-12445")
    public void GC02_UteUserChecksTheInvoiceDetailsPageForOldMonths(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnChartBar(chartBarOrder);
        rechnungen.clickDetailsPage(detailsPageOrder);
        invoiceSummary.assertOnTheUnPaidAmountLabelForOldMonths();
        invoiceSummary.assertOnAmountToPayLabel();
        invoiceSummary.assertOnTheUnPaidAmountForOldMonths();
        invoiceSummary.assertOnAmountToPayForOldMonths();
    }
    @Test(description = "GC03- Ute user with credit amount checks the bill summary page for told months")
    @TmsLink("WFCT-12446")
    public void GC03_UteUserWithCreditAmountChecksTheInvoiceDetailsPageForOldMonths(Method method) {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnChartBar(chartBarOrder);
        rechnungen.clickDetailsPage(detailsPageOrder);
        invoiceSummary.assertOnTheUnPaidAmountLabelForOldMonths();
        invoiceSummary.assertOnNegativeAmountToPayLabelForOldMonths();
        invoiceSummary.assertOnTheUnPaidAmountForOldMonths();
        invoiceSummary.assertOnNegativeAmountToPayForOldMonths();

    }
}
