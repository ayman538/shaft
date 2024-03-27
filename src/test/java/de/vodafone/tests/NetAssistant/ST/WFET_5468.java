package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.*;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5468")
public class WFET_5468 extends STNetAssistantSetup {
    //Variables
    private String chatbotLink;
    private String userName;
    private String userPassword;
    private String contractNumber;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        chatbotLink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        contractNumber = testData.getTestData(method.getName() + ".contractNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }


    @Test(description = "WFET-5662 - GC19 - Net assistant - logged in DSL user - Deeplink to Chatbot-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5662")
    private void ST_GC19() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();

    }

    @Test(description = "WFET-5663 - GC20 - Net assistant - logged in DSL user - Navigate to chatbot through help form-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5663")
    private void ST_GC20() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();

    }

    @Test(description = "WFET-5664 - GC21 - Net assistant - logged in DSL user - Navigate to chatbot through help form-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5664")
    private void ST_GC21() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();

    }

    @Test(description = "WFET-5666 - GC22 - Net assistant - logged in UM user - Navigate to chatbot through meinvodafone dashboard-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5666")
    private void ST_GC22() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();

    }

    @Test(description = "WFET-5667 - GC23 - Net assistant - logged in UM user - Navigate to chatbot through help form-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5667")
    private void ST_GC23() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();

    }

    @Test(description = "WFET-5668 - GC24 - Net assistant - logged in UM user - Navigate to chatbot through meinvodafone dashboard-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5668")
    private void ST_GC24() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();

    }

    @Test(description = "WFET-5669 - GC25 - Net assistant - logged in Cable user - Deeplink to Chatbot-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5669")
    private void ST_GC25() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();
    }

    @Test(description = "WFET-5670 - GC26 - Net assistant - logged in Cable user -Navigate to chatbot throught help form -Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5670")
    private void ST_GC26() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();
    }

    @Test(description = "WFET-5671 - GC27 - Net assistant - logged in Cable user - Navigate to chatbot throught mienvodafone dashboard-Verify that mass outage message displayed for chatbot page with logout button")
    @TmsLink("WFET-5671")
    private void ST_GC27() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateLogoutButtonExist();
    }

    @Test(description = "WFET-5712 - GC31- Net assistant - logged in DSL user - Navigate to chatbot through help form-Verify that login screen not displayed when navigate from chatbot tab to ticket tab and vice versa")
    @TmsLink("WFET-5712")
    private void ST_GC31() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .clickOnTicketTab();

        new TicketsPage(driver)
                .validateTicketStatusDisplayed()
                .validateTicketLogoutButtonExist()
                .clickOnChatbotTab();

        new ChatbotPage(driver)
                .validateLogoutButtonExist();
    }

    @Test(description = "WFET-5713 - GC32- Net assistant - logged in UM user - Navigate to chatbot through help form-Verify that login screen not displayed when navigate from chatbot tab to ticket tab and vice versa")
    @TmsLink("WFET-5713")
    private void ST_GC32() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .clickOnTicketTab();

        new TicketsPage(driver)
                .validateTicketStatusDisplayed()
                .validateTicketLogoutButtonExist()
                .clickOnChatbotTab();

        new ChatbotPage(driver)
                .validateLogoutButtonExist();
    }
    @Test(description = "WFET-5714 - GC33- Net assistant - logged in cable user - Navigate to chatbot through help form-Verify that login screen not displayed when navigate from chatbot tab to ticket tab and vice versa")
    @TmsLink("WFET-5714")
    private void ST_GC33() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbotLink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .clickOnTicketTab();

        new TicketsPage(driver)
                .validateTicketStatusDisplayed()
                .validateTicketLogoutButtonExist()
                .clickOnChatbotTab();

        new ChatbotPage(driver)
                .validateLogoutButtonExist();
    }
}