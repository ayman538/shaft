package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3316")
public class WFET_3316 extends STNetAssistantSetup {
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
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "UM user - Verify scheduled technician appointment appeared when ticket status is Inprogress")
    @TmsLink("WFET-3574")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketStatus("In Arbeit")
                .validateTicketAppointmentText()
                .validateTicketDetailsAppointmentTextColour();

    }

    @Test(description = "GC04 - UM user - Verify scheduled technician appointment did not appear when ticket status is closed")
    @TmsLink("WFET-3576")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateExpandClosedTicketsDisplayed()
                .validateClosedTicketHasNoTechAppointment()
                .validateClosedTicketsExist()
                .validateClosedTicketStatus("Geschlossen");

    }

}