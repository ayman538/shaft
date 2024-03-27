package de.vodafone.tests.unityMedia.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Payment.Login;
import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.InvoiceSummary;
import de.vodafone.pages.billing.Rechnungen;
import de.vodafone.pages.unityMedia.Rechnungseinstellungen;
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
@Story("WFCT-13469")

public class WFCT_13469 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    Rechnungen rechnungen;
    Rechnungseinstellungen rechnungseinstellungen;
    String suspendedNotificationHeadLine;
    String suspendedNotificationBody;


    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "UnityMedia/SIT_WFCT_13469_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "UnityMedia/SIT/WFCT_13469.json");
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
        rechnungseinstellungen = new Rechnungseinstellungen(driver);
        suspendedNotificationHeadLine = testData.getTestData(method.getName() + ".suspendedNotificationHeadLine");
        suspendedNotificationBody = testData.getTestData(method.getName() + ".suspendedNotificationBody");

        new Login(driver).navigateSIT()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionSIT(userName, userPassword);
    }


    @Test(description = "GC01-Ute user checks bill settings accordion when (suspended)")
    @TmsLink("WFCT-7559")
    public void GC01_SuspendedUteUserChecksBillSettingsAccordion() {
        dashboard.clickMeineRechnungenTile();
        rechnungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        rechnungseinstellungen.assertOnNotificationMessageHeadLine(suspendedNotificationHeadLine);
        rechnungseinstellungen.assertOnNotificationMessageBody(suspendedNotificationBody);
        rechnungseinstellungen.assertThatEditButtonIsDimmed();
    }
}
