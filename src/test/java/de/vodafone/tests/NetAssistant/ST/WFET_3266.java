package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3266")
public class WFET_3266 extends STNetAssistantSetup {
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;
    //Test
    @BeforeMethod
    public void setup(Method method) {
        userName=testData.getTestData(method.getName() + ".userName");
        userPassword=testData.getTestData(method.getName() + ".userPassword");
        ticketsLink = testData.getTestData(method.getName() + ".link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = " GC04 - UM user - Deeplink to Net Assistant App - Verify tickets page when there is open tickets and No close tickets displayed")
    @TmsLink("WFET-3416")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketStatusDisplayedTicketsList();

    }
    @Test(description ="GC05 - UM user - Deeplink to Net Assistant App - Verify the open ticket overview")
    @TmsLink("WFET-3417")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketStatusDisplayedTicketsList()
                .validateTicketStatusBarExistsTicketsList()
                .validateTicketTitleExistsTicketsList()
                .validateTicketNumberExistsTicketsList()
                .validateTicketDateExistsTicketsList();

    }
    @Test(description = " GC09 -UM- Deeplink to Net-Assistant App - Verify Technical Appointment date in open ticket overview")
    @TmsLink("WFET-3421")
    private void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketStatusDisplayedTicketsList()
                .validateTicketAppointmentLabelTicketDetails();


    }
/*  Old Behavior cases related to the query parameters in deeplinks
    @Test(description = "UM user - Deeplink to Net-Assistant App without query parameter \"C\" - Verify the page displayed")
    @TmsLink("WFET-3425")
    private void ST_GC13() {

        new TicketsPage(driver)
                .navigateInNewTab(ticketsLink)
                .validateTicketsHelloMsgCL()
                .validateChatbotTabHeaderExists()
                .validateTicketsTabHeaderExists()
                .validateTicketsErrorMsgCL();

    }
    @Test(description = "UM user - Deeplink to Net-Assistant App without query parameter \"I\" - Verify the page displayed")
    @TmsLink("WFET-3426")
    private void ST_GC14() {

        new TicketsPage(driver)
                .navigateInNewTab(ticketsLink)
                .validateTicketsHelloMsgCL()
                .validateChatbotTabHeaderExists()
                .validateTicketsTabHeaderExists()
                .validateTicketsErrorMsgCL();
    }
    @Test(description ="UM user - Deeplink to Net-Assistant App without query parameter \"C\" & \"I\" - Verify the page displayed")
    @TmsLink("WFET-3427")
    private void ST_GC15() {

        new TicketsPage(driver)
                .navigateInNewTab(ticketsLink)
                .validateTicketsHelloMsgCL()
                .validateChatbotTabHeaderExists()
                .validateTicketsTabHeaderExists()
                .validateTicketsErrorMsgCL();
    }

 */
}