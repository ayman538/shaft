package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4548")
public class WFET_4548 extends STNetAssistantSetup {

    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private String tokenLink;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        ticketsLink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        tokenLink=testData.getTestData(method.getName()+".tokenLink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description ="GC01 - DSL user - Deeplink to Net Assistant Tickets List - Verify tickets list with no previous appointment view - headline" )
    @TmsLink("WFET-6208")
    private void GC01(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .searchForTicketByStatusAndGetColour("In Arbeit")
                .validateTicketStatus("In Arbeit")
                .validateTicketSetAppointmentTextColourDSL()
                .validateTicketSetAppointmentTextCLDSL();
    }


    @Test(description = "GC02 - DSL user - Deeplink to Net Assistant Tickets List - Verify ticket details view after opening ticket with in progress status")
    @TmsLink("WFET-6209")
    private void GC02(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .validateTicketDetailsSetAppointmentTextLabelExistsDSL()
                .validateTicketDetailsSetAppointmentTextCLDSL()
                .validateSetTechnicianAppointmentButtonExists();
    }

    @Test(description = "GC03 - DSL user - Deeplink to Net Assistant Tickets List - Verify ticket details view after opening ticket with resolved status")
    @TmsLink("WFET-6210")
    private void GC03(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("Gelöst",1)
                .validateSetTechnicianAppointmentLabelDoesNotExist()
                .validateManageTechnicianAppointmentLabelDoesNotExist()
                .validateSetTechnicianAppointmentButtonDoesNotExist();
    }

    @Test(description =  "GC04 - DSL user - Deeplink to Net Assistant Tickets List - Verify ticket details view after opening ticket with closed status")
    @TmsLink("WFET-6211")
    private void GC04(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickExpandClosedTicketsButton()
                .validateClosedTicketStatusExists();

        new TicketsPage(driver)
                .clickMoreInfoButtonClosedTicket()
                .validateSetTechnicianAppointmentLabelDoesNotExist()
                .validateManageTechnicianAppointmentLabelDoesNotExist();

    }

    @Test(description = "GC05 - DSL user - Deeplink to Net Assistant Tickets List - Verify Set Appointment button click")
    @TmsLink("WFET-6212")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .clickTechnicianAppointmentSetButton()
                .clickGoOnDSLButton()
                .clickCalendarDSLButton()
                .validateCalendarExistsDSL();

    }
    @Test(description = "GC15 - DSL user - Navigate to Token Deeplink - Verify ticket details view after opening ticket with in progress status")
    @TmsLink("WFET-6258")
    private void GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(tokenLink);

        new TicketsPage(driver)
                .validateTicketDetailsInprogress("In Arbeit")
                .validateTicketDetailsSetAppointmentTextLabelExistsDSL()
                .validateTicketDetailsSetAppointmentTextCLDSL()
                .validateSetTechnicianAppointmentButtonExists();
    }

    @Test(description = "GC16 - DSL user - Navigate to Token Deeplink - Verify ticket details view after opening ticket with resolved status")
    @TmsLink("WFET-6259")
    private void GC16() {

        new NavigationPage(driver)
                .navigateInNewTab(tokenLink);

        new TicketsPage(driver)
                .validateTicketDetailsResolved("Gelöst")
                .validateSetTechnicianAppointmentLabelDoesNotExist()
                .validateManageTechnicianAppointmentLabelDoesNotExist()
                .validateSetTechnicianAppointmentButtonDoesNotExist();
    }
    @Test(description = "GC17 - DSL user - Navigate to Token Deeplink - Verify Set Appointment Flow and Confirmation Action")
    @TmsLink("WFET-6260")
    private void GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(tokenLink);

        new TicketsPage(driver)
                .clickTechnicianAppointmentSetButton()
                .clickGoOnDSLButton()
                .clickCalendarDSLButton()
                .validateCalendarExistsDSL();
    }
}
