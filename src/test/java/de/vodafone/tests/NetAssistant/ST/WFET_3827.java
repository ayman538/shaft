package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3827")
public class WFET_3827 extends STNetAssistantSetup {
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsLink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap);
    }

    private void loginAction()
    {
        new LoginPage(driver)
                .navigateST()
                .setCookieSwitchers(cookieSwitcherMap)
                .acceptCookies();
    }

    @Test(description ="ST04 - Cable user -Navigate to Net Assistant Tickets List- Verify that past appointments are hidden")
    @TmsLink("WFET-4294")
    private void GC04() {

        new LoginPage(driver)
                .loginST(userName, userPassword);

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketHasNoAppointmentTicketsList();
    }

    @Test(description = "ST01 - UM user -Navigate to Net Assistant Tickets List- Verify that past appointments are hidden")
    @TmsLink("WFET-4291")
    private void GC01() {
        new LoginPage(driver)
                .loginST(userName, userPassword);

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketHasNoAppointmentTicketsList();
    }

    @Test(description = "ST03 - UM user -Deeplink to Net Assistant- Verify that past appointments are hidden")
    @TmsLink("WFET-4293")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketHasNoAppointmentTicketsList();
    }

    @Test(description = "ST06 - Cable -Deeplink to Net Assistant - Verify that past appointments are hidden")
    @TmsLink("WFET-4296")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .searchForOpenTicketByStatus("In Arbeit")
                .validateTicketHasNoAppointmentTicketsList();
    }
    @Test(description = "ST02 - UM user -Deeplink to Net Assistant ticketdetails- Verify that past appointments are hidden")
    @TmsLink("WFET-4292")
    private void GC02() {

        new LoginPage(driver)
                .loginST(userName, userPassword);

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .validateTicketAppointmentLabelTicketDetailsDoesNotExist();
    }
    @Test(description ="ST05 - Cable user -Deeplink to Net Assistant ticketsdetails- Verify that past appointments are hidden")
    @TmsLink("WFET-4295")
    private void GC05() {

        new LoginPage(driver)
                .loginST(userName, userPassword);

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .validateTicketAppointmentLabelTicketDetailsDoesNotExist();

    }
}

