package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3452")
public class WFET_3452 extends STNetAssistantSetup {

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

    @Test(description ="UM user- Deeplink to Tickets List-verify that scheduled technician appointment appeared when the ticket status is inprogress" )
    @TmsLink("WFET-3630")
    private void ST_GC01(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .searchForTicketByStatusAndGetColour("In Arbeit")
                .validateInprogressTicketStatusText()
                .validateTicketDetailsNoAppointmentTextColour()
                .validateTechnicianAppointmentCL();
    }


    @Test(description = "UM user - Deeplink to Tickets List - Verify ticket details view after opening ticket with inprogress status")
    @TmsLink("WFET-3632")
    private void ST_GC03(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1 )
                .validateSetTechnicianAppointmentLabelExists()
                .validateSetTechnicianAppointmentLabelCL()
                .validateSetTechnicianAppointmentbtnExists();
    }

    @Test(description =  "UM user- Deeplink to Tickets List-verify that change appointment button displayed for scheduled technician appointment in ticket details section")
    @TmsLink("WFET-3634")
    private void ST_GC05(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickExpandClosedTicketsButton()
                .validateClosedTicketsExist()
                .clickMoreInfoButtonClosedTicket()
                .validateSetTechnicianAppointmentLabelDoesNotExists()
                .validateTicketAppointmentLabelTicketDetailsDoesNotExist();

    }

    @Test(description = "UM user - Deeplink to Tickets List - Verify Set Appointment button click")
    @TmsLink("WFET-3635")
    private void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .clickOn(TicketsPage.getTechnician_Appointment_Set_Button())
                .clickOn(TicketsPage.get_Go_On_Button())
                .clickOn(TicketsPage.get_Reschedule_Button())
                .clickOn(TicketsPage.get_Fourth_Slot())
                .clickOn(TicketsPage.get_Calendar())
                .validateCalendarAppearsUM();

    }
}
