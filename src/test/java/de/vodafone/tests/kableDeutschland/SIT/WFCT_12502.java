package de.vodafone.tests.kableDeutschland.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.Einstellungen;
import de.vodafone.pages.Kabledeutschland.MeineRechnungen;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;
@Epic("Kable Deutschland")
@Feature("SIT")
@Story("WFCT_12502")

public class WFCT_12502 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String email;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Einstellungen einstellungen;

    @BeforeMethod()
    public void setup(Method method) {
        driver= new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        einstellungen = new Einstellungen(driver);
        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        email = testData.getTestData(method.getName()+".email");


        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName, userPassword);
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/SIT_WFCT_12502_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/SIT/WFCT_12502.json");
    }

    @Test(description = "GC01 - Martin user with 'online bill, validated eMail address and switched on notification' checks einstellungen tab")
    @TmsLink("WFCT-12816")
    public void GC01_MartinWith_OnlineBill_ValidatedEmail_SwitchedOnNotificationChecksEinstellungenTab(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeSectionHeader();
        einstellungen.assertThatOnlineRadioBtnNotExist();
        einstellungen.assertOnOnlineTypeLabel();
        einstellungen.clickToolTip();
        einstellungen.assertOnToolTipText();
        einstellungen.assertOnEmailSectionHeader();
        einstellungen.assertOnEmailSectionSubTitle();
        einstellungen.assertOnEmailAddressLabelText();
        einstellungen.assertOnEmailAddressValueText(email);
        einstellungen.assertThatEmailAddressValueGreen();
        einstellungen.assertOnCheckIcon();
        einstellungen.assertThatEmailStatusVerified();
        einstellungen.clickEmailBearbeitenBtn();
        einstellungen.assertThatUserNavigatedToEditEmailPage();

    }

    @Test(description = "GC02 - Martin user with ' paper bill, validated eMail address and switched off notification ' checks einstellungen tab",enabled = false)
    @TmsLink("WFCT-12817")
    public void GC02_MartinWith_PaperBill_ValidatedEmail_SwitchedOffNotificationChecksEinstellungenTab(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeSectionHeader();
        einstellungen.assertOnOnlineTypeLabel();
        einstellungen.assertOnPaperTypeLabel();
        einstellungen.assertThatPaperRadioBtnChecked();
        einstellungen.assertThatAnderungSpeichernBtnDimmed();
        einstellungen.assertOnBillTypeSectionHeader();
        einstellungen.assertOnBillTypeSectionDescription();
        einstellungen.assertOnBillTypeSectionNotificationText();
        einstellungen.assertOnBillTypeSectionNotificationLink();
        einstellungen.clickNotificationLink();
        einstellungen.assertOnBillTypeSectionNotificationLinkNavigation();
        einstellungen.navigateToEinstellungenPage();
        einstellungen.assertOnEmailSectionHeader();
        einstellungen.assertOnEmailSectionSubTitle();
        einstellungen.assertOnEmailAddressLabelText();
        einstellungen.assertOnEmailAddressValueText(email);
        einstellungen.assertThatEmailAddressValueGreen();
        einstellungen.assertOnCheckIcon();
        einstellungen.assertThatEmailStatusVerified();
        einstellungen.assertOnNotActivatedNotificationText();
        einstellungen.clickEmailBearbeitenBtn();
        einstellungen.assertThatUserNavigatedToEditEmailPage();
        einstellungen.navigateToEinstellungenPage();
        einstellungen.clickNotificationLink();
        einstellungen.assertOnBillTypeSectionNotificationLinkNavigation();

    }
}
