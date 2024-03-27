package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_1984 extends SITNetAssistantSetup {
    //Variables
    private String user_Name;
    private String user_Password;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        user_Name = testData.getTestData(method.getName()+".name");
        user_Password = testData.getTestData(method.getName()+".password");
        super.setup(method);
    }
    @Test(groups={"WFET_1984","regression"})
    @TmsLink("WFET-1984")
    @Description("Cable user - Login to MeinVodafone DashboardPage portal - Verify Navigation of new tile (SO) with details appearing for Unsubscribed user")
    private void SIT_GC01() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .closeStickyNotifications()
                .clickOn(DashboardPage.getCableAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject());

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateSaveIndicatorExists();

    }

    @Test(groups={"WFET_1984"})
    @TmsLink("WFET-2966")
    @Description("Cable user - Login to MeinVodafone DashboardPage portal - Verify User able to subscribe/confirm via email for Unsubcribed user with success message")
    private void SIT_GC02() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .closeStickyNotifications()
                .clickOn(DashboardPage.getCableAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject())
                .subscriptionEmailConfirmationAction();

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateSubscriptionSuccessMessageHeaderText();

    }

    @Test(groups={"WFET_1984"})
    @TmsLink("WFET-2985")
    @Description("Cable user - Login to MeinVodafone DashboardPage portal - Verify Unsubscription from email service for Subscribed user")
    private void SIT_GC04() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .closeStickyNotifications()
                .clickOn(DashboardPage.getCableAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject())
                .unsubscribeAction()
                .closeStickyNotifications()
                .clickOn(DashboardPage.getCableAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject());

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateSaveIndicatorExists();

    }

}
