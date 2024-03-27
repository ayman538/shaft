package de.vodafone.tests.kableDeutschland.ST;

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

@Epic("KableDeutschland")
@Feature("ST")
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


        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @AfterMethod()
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_WFCT_12502_CookieSwitcher.json").getTestDataAsMap("$");


        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/WFCT_12502.json");
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

    @Test(description = "GC02 - Martin user with ' paper bill, validated eMail address and switched off notification ' checks einstellungen tab")
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

    @Test(description = "GC03 - Martin user with ' paper bill, not validated eMail address ' checks einstellungen tab")
    @TmsLink("WFCT-12818")
    public void GC03_MartinWith_PaperBill_NotValidatedEmailChecksEinstellungenTab(){
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
        einstellungen.assertThatEmailAddressValueRed();
        einstellungen.assertOnCrossIcon();
        einstellungen.assertThatEmailStatusNotVerified();
        einstellungen.assertOnNotVerifiedEmailNotificationHeader();
        einstellungen.assertOnNotVerifiedEmailNotificationDescription();
        einstellungen.clickSendNewConfirmationBtn();
        einstellungen.assertThatUserNavigatedToSendNewConfirmationPage();
        einstellungen.navigateToEinstellungenPage();
        einstellungen.clickEmailBearbeitenBtn();
        einstellungen.assertThatUserNavigatedToEditEmailPage();

    }

    @Test(description = "GC04 - Martin user with ' online bill, No eMail address ' checks einstellungen tab")
    @TmsLink("WFCT-12819")
    public void GC04_MartinWith_OnlineBill_NoEmailChecksEinstellungenTab(){
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
        einstellungen.assertOnNoEmailText();
        einstellungen.assertOnNoEmailNotificationHeader();
        einstellungen.assertOnNoEmailNotificationDescription();
        einstellungen.assertOnEmailAdresseEintragenBtnText();
        einstellungen.clickAddEmailBtn();
        einstellungen.assertThatUserNavigatedToEditEmailPage();
    }

    @Test(description = "GC05 - Martin user changes his bills from paper to online successfully")
    @TmsLink("WFCT-12820")
    public void GC05_MartinChangesHisBillsFromPaperToOnlineSuccessfully(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeSectionHeader();
        einstellungen.assertOnOnlineTypeLabel();
        einstellungen.assertOnPaperTypeLabel();
        einstellungen.assertThatPaperRadioBtnChecked();
        einstellungen.assertThatAnderungSpeichernBtnDimmed();
        einstellungen.clickOnlineRadioBtn();
        einstellungen.assertOnChangeToOnlineNotificationHeader();
        einstellungen.assertOnChangeToOnlineNotificationDescription();
        einstellungen.clickAnderungSpeichernBtn();
        einstellungen.assertOnConfirmationNotificationHeader();
        einstellungen.assertOnConfirmationNotificationDescription();
        einstellungen.assertThatPaperLabelNotExist();
    }

    @Test(description = "GC06 - Martin user fails to change his bills from paper to online")
    @TmsLink("WFCT-12821")
    public void GC06_MartinFailsToChangeHisBillsFromPaperToOnline(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeSectionHeader();
        einstellungen.assertOnOnlineTypeLabel();
        einstellungen.assertOnPaperTypeLabel();
        einstellungen.assertThatPaperRadioBtnChecked();
        einstellungen.assertThatAnderungSpeichernBtnDimmed();
        einstellungen.clickOnlineRadioBtn();
        einstellungen.assertOnChangeToOnlineNotificationHeader();
        einstellungen.assertOnChangeToOnlineNotificationDescription();
        einstellungen.clickAnderungSpeichernBtn();
        einstellungen.assertOnDispatchErrorNotificationHeader();
        einstellungen.assertOnDispatchErrorNotificationDescription();
    }

    @Test(description = "GC07 - Martin user changes his bills from ' paper and online ' to online successfully")
    @TmsLink("WFCT-12822")
    public void GC07_MartinChangesHisBillsFrom_PaperAndOnline_To_OnlineSuccessfully(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeSectionHeader();
        einstellungen.assertOnOnlineTypeLabel();
        einstellungen.assertOnPaperAndOnlineTypeLabel();
        einstellungen.assertThatPaperAndOnlineRadioBtnChecked();
        einstellungen.assertOnPaperAndOnlineNotification();
        einstellungen.assertThatAnderungSpeichernBtnDimmed();
        einstellungen.clickOnlineRadioBtn();
        einstellungen.clickAnderungSpeichernBtn();
        einstellungen.assertOnConfirmationNotificationHeader();
        einstellungen.assertOnConfirmationNotificationDescription();
        einstellungen.assertThatPaperAndOnlineLabelNotExist();
    }

    @Test(description = "BC01 - Martin user with a dispatch service error checks einstellungen tab",enabled = false)
    @TmsLink("WFCT-12823")
    public void BC01_MartinWthDispatchServiceErrorCheckEinstellungenTab(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnDispatchErrorNotificationHeader();
        einstellungen.assertOnDispatchErrorNotificationDescription();
    }

    @Test(description = "BC02 - Martin user with a dispatch and itemized bill settings service error checks einstellungen tab",enabled = false)
    @TmsLink("WFCT-12824")
    public void BC02_MartinWithDispatchAndItemizedBillSettingsServiceErrorChecksEinstellungenTab(){
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnGeneralErrorNotificationTitle();
        einstellungen.assertOnGeneralErrorNotificationDescription();
    }
}
