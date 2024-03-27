package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3453")
public class WFET_3453 extends STNetAssistantSetup {

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

    @Test(description = "UM user- Deeplink to Tickets List-verify that scheduled technician appointment appeared when the ticket status is inprogress")
    @TmsLink("WFET-3619")
    private void ST_GC01(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                //.validateInprogressTicketStatusText()
                .validateSetTechnicianAppointmentLabelExists()
                .validateTechnicianAppointmentCL();
    }


    @Test(description ="UM user- Deeplink to Tickets List-verify that scheduled technician appointment appeared at ticket details section")
    @TmsLink("WFET-3621")
    private void ST_GC03(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketAppointmentLabelTicketDetails();
    }

    @Test(description ="UM user- Deeplink to Tickets List-verify that change appointment button displayed for scheduled technician appointment in ticket details section")
    @TmsLink("WFET-3622")
    private void ST_GC04(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateRescheduleBtnIsVisible();

    }

    @Test(description ="UM user- Deeplink to Tickets List-verify that change appointment button not displayed for ticket has no scheduled technician appointment set before")
    @TmsLink("WFET-3627")
    private void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateNoAppointmentTicketCL();
    }
}
