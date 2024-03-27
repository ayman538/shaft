package de.vodafone.tests.kableDeutschland.SIT;


import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Kabledeutschland.Dashboard;
import de.vodafone.pages.Kabledeutschland.EditEmailNotificationPage;
import de.vodafone.pages.Kabledeutschland.Einstellungen;
import de.vodafone.pages.Kabledeutschland.EmailNotificationConfirmationPage;
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
@Story("WFCT-12607")
public class WFCT_12607 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public JSONFileManager cookieSettings;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;

    public String className= this.getClass().getName().replace(this.getClass().getPackageName()+".","");
    Dashboard dashboard;
    Einstellungen einstellungen;
    EditEmailNotificationPage editEmailNotificationPage;
    EmailNotificationConfirmationPage emailNotificationConfirmationPage;
    String contractOrder;
    String CTA_Text;
    String ConfirmCTA_CL;


    @BeforeMethod
    public void beforeMethod(Method method) {
        driver= new SHAFT.GUI.WebDriver();
        dashboard = new Dashboard(driver);
        einstellungen = new Einstellungen(driver);
        editEmailNotificationPage = new EditEmailNotificationPage(driver);
        emailNotificationConfirmationPage = new EmailNotificationConfirmationPage(driver);
        contractOrder = testData.getTestData(method.getName() + ".conractOrder");
        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        CTA_Text = testData.getTestData(method.getName() + ".CTA_Text");
        ConfirmCTA_CL = testData.getTestData(method.getName() + ".ConfirmCTA_CL");


        //make new Login to SIT environment
        new LoginPage(driver).navigateSIT()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginSIT(userName,userPassword);
    }


    @Test(description = "WFCT-12607 | SIT | GC02 - Martin user has (validated email address and switched off notification) then activates online bill notification")
    @TmsLink("WFCT-12846")
    public void userHas_ValidatedEmailAddressAndSwitchedOffNotification_ThenActivatesOnlineBillNotification(){
        dashboard.expandContractAccordion();
        dashboard.clickOnMeineRehnungenSO();
        einstellungen.clickOnInvoiceSettings_Rechnungseinstellungen();
        einstellungen.clickOnNotificationEditCTA();
        editEmailNotificationPage.clickOnToggleBtn();
        editEmailNotificationPage.clickOnConfirmButton();
        einstellungen.clickBackButton();
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
        emailNotificationConfirmationPage.expandUbersichAccordion();
        emailNotificationConfirmationPage.assertOnEmailNotificationField();
        emailNotificationConfirmationPage.assertOnNotificationActivatedColor();
        emailNotificationConfirmationPage.assertOnCloseCTAUnderAccordionNotExists();
        emailNotificationConfirmationPage.assertOnNotificationFieldStatus();
    }


    @AfterMethod(alwaysRun = true)
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }

    @BeforeClass(alwaysRun = true)
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {

        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KableDeutschland/SIT_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KableDeutschland/SIT/" + className + ".json");
    }
}


