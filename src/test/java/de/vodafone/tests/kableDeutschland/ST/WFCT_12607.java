package de.vodafone.tests.kableDeutschland.ST;


import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.*;
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
@Story("WFCT-12607")
public class WFCT_12607 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    Dashboard dashboard;
    Einstellungen einstellungen;
    EditEmailNotificationPage editEmailNotificationPage;
    EmailNotificationConfirmationPage emailNotificationConfirmationPage;
    MeineRechnungen meineRechnungen;
    String contractOrder;
    String CTA_Text;
    String ConfirmCTA_CL;


    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");



    @BeforeMethod
    public void beforeMethod(Method method) {
        driver= new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        einstellungen = new Einstellungen(driver);
        editEmailNotificationPage = new EditEmailNotificationPage(driver);
        emailNotificationConfirmationPage = new EmailNotificationConfirmationPage(driver);
        meineRechnungen = new MeineRechnungen(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        CTA_Text = testData.getTestData(method.getName() + ".CTA_Text");
        ConfirmCTA_CL = testData.getTestData(method.getName() + ".ConfirmCTA_CL");



        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName,userPassword);
    }

    @Test(description = "WFCT-12607 | ST | GC01 - Martin user has (validated email address and switched on notification) then deactivates online bill notification")
    @TmsLink("WFCT-12844")
    public void gc01_userHas_ValidatedEmailAddressAndSwitchedOnNotification_ThenDeactivatesOnlineBillNotification(){
        dashboard.clickOnMeineRehnungenSO();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeHeader();
        einstellungen.assertOnInvoiceType();
        einstellungen.assertOnInvoiceEmailSectionHeadline();
        einstellungen.assertOnInvoiceEmailSectionBody();
        einstellungen.assertOnEmailAdressField();
        einstellungen.assertOnEmailAdressColor();
        einstellungen.assertThatEmailIsVerified();
        einstellungen.assertOnNotificationEditCTAText(CTA_Text);
        einstellungen.clickOnNotificationEditCTA();
        editEmailNotificationPage.assertOnTableHeader();
        editEmailNotificationPage.assertOnEmailNotificationStatus_CL();
        editEmailNotificationPage.assertOnEmailNotificationBody_CL();
        editEmailNotificationPage.assertOnPageTitle();
        editEmailNotificationPage.assertThatConfirmButtonIsDimmed();
        editEmailNotificationPage.clickOnToggleBtn();
        editEmailNotificationPage.clickOnConfirmButton();
        emailNotificationConfirmationPage.assertOnConfirmationNotificationHeadline();
        emailNotificationConfirmationPage.assertOnConfirmationNotificationBody();
        emailNotificationConfirmationPage.expandUbersichAccordion();
        emailNotificationConfirmationPage.assertOnEmailNotificationField();
        emailNotificationConfirmationPage.assertOnCloseCTAUnderAccordionNotExists();
    }

    @Test(description = "WFCT-12607 | ST | GC02 - Martin user has (validated email address and switched off notification) then activates online bill notification")
    @TmsLink("WFCT-12846")
    public void gc02_userHas_ValidatedEmailAddressAndSwitchedOffNotification_ThenActivatesOnlineBillNotification(){
        dashboard.clickOnMeineRehnungenSO();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeHeader();
        einstellungen.assertOnInvoiceType();
        einstellungen.assertOnInvoiceEmailSectionHeadline();
        einstellungen.assertOnInvoiceEmailSectionBody();
        einstellungen.assertOnEmailAdressField();
        einstellungen.assertOnEmailAdressColor();
        einstellungen.assertThatEmailIsVerified();
        einstellungen.assertOnSwitchedOffNotificationMessage();
        einstellungen.assertOnNotificationEditCTAText_ActivationCase(CTA_Text);
        einstellungen.clickOnNotificationEditCTA_ActivateBtn();
        editEmailNotificationPage.assertOnTableHeader();
        editEmailNotificationPage.assertOnEmailNotificationStatus_CL();
        editEmailNotificationPage.assertOnEmailNotificationBody_CL();
        editEmailNotificationPage.assertOnPageTitle();
        editEmailNotificationPage.assertThatConfirmButtonIsDimmed();
        editEmailNotificationPage.clickOnToggleBtn();
        editEmailNotificationPage.clickOnConfirmButton();
        emailNotificationConfirmationPage.assertOnConfirmationNotificationHeadline();
        emailNotificationConfirmationPage.assertOnConfirmationNotificationBody();
        emailNotificationConfirmationPage.expandUbersichAccordion();
        emailNotificationConfirmationPage.assertOnEmailNotificationField();
        emailNotificationConfirmationPage.assertOnCloseCTAUnderAccordionNotExists();
        emailNotificationConfirmationPage.assertOnNotificationActivatedColor();
        emailNotificationConfirmationPage.assertOnNotificationFieldStatus();
    }

    @Test(description = "WFCT-12607 | ST | GC03 - Martin user fails to activate online bill notification")
    @TmsLink("WFCT-12847")
    public void gc03_userHas_ValidatedEmailAddressAndSwitchedOffNotification_ThenFailedToActivateOnlineBillNotification(){
        dashboard.clickOnMeineRehnungenSO();
        meineRechnungen.clickEinstellungenTab();
        einstellungen.assertOnInvoiceTypeHeader();
        einstellungen.assertOnInvoiceType();
        einstellungen.assertOnInvoiceEmailSectionHeadline();
        einstellungen.assertOnInvoiceEmailSectionBody();
        einstellungen.assertOnEmailAdressField();
        einstellungen.assertOnEmailAdressColor();
        einstellungen.assertThatEmailIsVerified();
        einstellungen.assertOnSwitchedOffNotificationMessage();
        einstellungen.assertOnNotificationEditCTAText_ActivationCase(CTA_Text);
        einstellungen.clickOnNotificationEditCTA_ActivateBtn();
        editEmailNotificationPage.assertOnTableHeader();
        editEmailNotificationPage.assertOnEmailNotificationStatus_CL();
        editEmailNotificationPage.assertOnEmailNotificationBody_CL();
        editEmailNotificationPage.assertOnPageTitle();
        editEmailNotificationPage.assertThatConfirmButtonIsDimmed();
        editEmailNotificationPage.clickOnToggleBtn();
        editEmailNotificationPage.clickOnConfirmButton();
        emailNotificationConfirmationPage.assertOnErrorMessageHL();
        emailNotificationConfirmationPage.assertOnErrorMessageBody();
        emailNotificationConfirmationPage.assertOnBackButtonUnderAccordionNotExists();
    }

    @AfterMethod(alwaysRun = true)
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass(alwaysRun = true)
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/ST/" + className + ".json");
    }
}


