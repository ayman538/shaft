package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_4087 extends SITNetAssistantSetup {
    //Variables
    private String user_Name;
    private String user_Password;
    private String Link;
    String KD_User ="KD332881148";
    String KD_Pass ="TEST@1234";
    WebDriverWait waitForHeader;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        user_Name = testData.getTestData(method.getName()+".name");
        user_Password = testData.getTestData(method.getName()+".password");
        Link = testData.getTestData(method.getName()+".Link");
        super.setup(method);
    }

    @Test(groups={"WFET_4087","regression"})
    @TmsLink("WFET-4136")
    @Description("SIT GC01 - E2E - Cable- Subscribe then Unsubscribe and Update Fault Info Subscription for Cable Customer")
    //Do Fault Info Subscription for SMS or Email Service for Cable Customer then Do Unsubscribtion for all Fault Info Services
    private void GC01() throws InterruptedException {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .closeStickyNotificationsWithWait(DashboardPage.getCableAccordion())
                .clickOn(DashboardPage.getCableAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject())
                .switchToTab();

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateBackButtonExists()
                .validateSaveIndicatorExists()
                .validateCheckBoxExists()
                .validateEmailRadioButtonExists()
                .validateSmsRadioButtonExists()
                .validateEmailRadioButtonDisabled()
                .validateSmsRadioButtonDisabled()
                .validateSaveButtonDisabled();

        //click on kontaktdaten link
        new DashboardPage(driver)
                .clickOn(DashboardPage.getKontaktdatenLink())
                .switchToTab();

        Assert.
                assertEquals(driver.browser().getCurrentURL(),"https://kabel.vodafone.de/meinkabel/meine_kundendaten/kontaktdaten");

        new DashboardPage(driver)
                .switchToTab()
                .clickOn(DashboardPage.getCheckBox());
                //click check box

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateBackButtonExists()
                .validateSaveIndicatorExists()
                .validateCheckBoxExists()
                .validateEmailRadioButtonExists()
                .validateSmsRadioButtonExists()
                .validateEmailRadioButtonVisible()
                .validateSmsRadioButtonVisible();

        //subscribe email confirmation
        new DashboardPage(driver)
                .subscriptionEmailConfirmationAction();

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateSubscriptionSuccessMessageHeaderText()
                .validateSubscriptionSuccessMessageTitleText()
                .validateSubscriptionSuccessMessageBodyText()
                .clickOn(DashboardPage.getBackButton())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject())
                .unsubscribeAction();

    }

    @Test(groups={"WFET_4087", "regression"})
    @TmsLink("WFET-4139")
    @Description("OPWEB5 GC04 -E2E- Cable - Show Error Message in case of Customer Authentication with no Contract")
    //Check Error Message Displayed in case of Loginng in with a Cable Customer with no contract
    private void GC04() {
        new DashboardPage(driver)
                .navigate()
                .acceptCookies();
        setCookieECHO();

        // we use navigate using selenium because navigate using shaft will make error due to assertion on URL
        driver.browser().navigateToURL( Link);
        new LoginPage(driver)
                .loginSIT(user_Name,user_Password)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateErrorIconDisplayed();

    }
    @Test(groups={"WFET_4087","regression"})
    @TmsLink("WFET-4140")
    @Description("OPWEB5 GC05 -E2E- Cable -Customer Authentication with Multiple Contracts")
    //Check Tickets View for Logged in and Non Logged in and Logut Behaviour for Cable Customers with Multiple Contracts
    private void GC05() {
        new DashboardPage(driver)
                .navigate()
                .acceptCookies();
        setCookieECHO();

        driver.browser().navigateToURL( Link);

        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .validateContractsExist()
                .clickOn(DashboardPage.getFirstContract())
                .validateTicketsPageDisplayed()
                .clickOn(DashboardPage.getLogoutButton())
                .validateLogoutPageDisplayed();
    }
    @Test(groups={"WFET_4087","regression"})
    @TmsLink("WFET-4144")
    @Description("OPWEB5 GC06 -E2E- Cable - Customer Authentication with Single Contract")
    //Check Tickets View for Logged in and Non Logged in and Logout Behaviour for Cable Customers with Single Contract
    private void GC06() {
        new DashboardPage(driver)
                .navigate()
                .acceptCookies();
        setCookieECHO();

        driver.browser().navigateToURL( Link);
        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .validateTicketsPageDisplayed()
                .clickOn(DashboardPage.getLogoutButton())
                .validateLogoutPageDisplayed();

    }

    @Test(groups = {"WFET_4087", "regression"})
    @TmsLink("WFET-4145")
    @Description("SIT GC10 - E2E -ecare -UM | cable | DSL - Open Net Assistant Smart object in mein vodafone then check redirection")
    //Login to Mein Vodafone Dashboard with the Customer Type Needed then Navigate to Contract and Choose required accordion , Click Net Assistant Smart Object , Verify Redirection to its correct Customer Type in Link then Logout and Repeat the process till all customer types are covered
    private void GC10() throws InterruptedException {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate()
                .acceptCookies();

        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .closeStickyNotificationsWithWait(DashboardPage.getDslAccordion())
                .clickOn(DashboardPage.getDslAccordion())
                .clickOn(DashboardPage.getNetAssistantSOLocator());

        Thread.sleep(7000);
        new DashboardPage(driver)
                .switchToTab();
        Assert.assertTrue(driver.browser().getCurrentURL().contains("icmp=mvw_db_netzass_dsl") );

        new DashboardPage(driver)
                .switchToTab()
                .closeStickyNotificationsWithWait(DashboardPage.getUnityMediaAccordion())
                .clickOn(DashboardPage.getUnityMediaAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneUMAccordion())
                .clickOn(DashboardPage.getNetAssistantSOHeaderLocator());

        Thread.sleep(5000);
        new DashboardPage(driver)
                .switchToTab();
        Assert.assertTrue(driver.browser().getCurrentURL().contains("icmp=mvw_db_netzass_um") );

        new DashboardPage(driver)
                .switchToTab();

        new LoginPage(driver)
                .clickMeinVodafoneIcon()
                .clickLogoutButtonIcon()
                .clickLoginAgainButton()
                .loginSIT(KD_User,KD_Pass);

        new DashboardPage(driver)
                .closeStickyNotificationsWithWait(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getNetAssistantSOLocator());

        Thread.sleep(5000);
        new DashboardPage(driver)
                .switchToTab();
        Assert.assertTrue(driver.browser().getCurrentURL().contains("icmp=mvw_db_netzass_kip") );

        new DashboardPage(driver)
                .switchToTab();

    }
    @Test(groups={"WFET_4087","regression"})
    @TmsLink("WFET-4190")
    @Description("SIT GC11 - E2E - UM - Customer Authentication ")
    //Check Tickets View for Logged in and Non Logged in and Logout Behaviour for Unity Media Customers with Single Contract
    private void GC11() {
        new DashboardPage(driver)
                .navigate()
                .acceptCookies();
        setCookieECHO();

        driver.browser().navigateToURL( Link);
        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .validateTicketsPageDisplayed()
                .clickOn(DashboardPage.getLogoutButton())
                .validateLogoutPageDisplayed();

    }

}
