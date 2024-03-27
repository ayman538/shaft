package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_1984")
public class WFET_1984 extends STNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);

        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "Cable user - Login to MeinVodafone DashboardPage portal - Verify Navigation of new tile (SO) with details appearing for Unsubscribed user")
    @TmsLink("WFET-1984")
    private void ST_GC01() {

        new DashboardPage(driver)
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObjectST())
                .switchToTab();

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateSaveIndicatorExists();

    }

    @Test(description ="Cable user - Login to MeinVodafone DashboardPage portal - Verify User able to subscribe/confirm via email for Unsubcribed user with success message" )
    @TmsLink("WFET-2966")
    private void ST_GC02() {

        new DashboardPage(driver)
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject())
                .switchToTab()
                .subscriptionEmailConfirmationAction();

        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateSubscriptionSuccessMessageHeaderText();

    }

    @Test(description = "Cable user - Login to MeinVodafone DashboardPage portal - Verify Unsubscription from email service for Subscribed user")
    @TmsLink("WFET-2985")
    private void ST_GC04() {

        new DashboardPage(driver)
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .clickOn(DashboardPage.getInfoServiceSmartObject())
                .switchToTab();


        new LoginPage(driver)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateSaveIndicatorExists();

    }

}
