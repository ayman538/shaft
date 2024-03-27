package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
@Story("WFET_4548")
public class WFET_4548 extends SITNetAssistantSetup {

    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private String tokenLink;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        ticketsLink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        tokenLink=testData.getTestData(method.getName()+".tokenLink");
        super.setup(method);

    }

    @Test(description ="GC01 - DSL user - Deeplink to Net Assistant Tickets List - Verify tickets list with no previous appointment view - headline" )
    @TmsLink("WFET-6208")
    private void GC01(){
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)
                .navigateSIT(ticketsLink)
                .searchForTicketByStatusAndGetColour("In Arbeit")
                .validateTicketStatus("In Arbeit")
                .validateTicketSetAppointmentTextColourDSL()
                .validateTicketSetAppointmentTextCLDSL();
    }


    @Test(description = "GC02 - DSL user - Deeplink to Net Assistant Tickets List - Verify ticket details view after opening ticket with in progress status")
    @TmsLink("WFET-6209")
    private void GC02(){
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)
                .navigateSIT(ticketsLink)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .validateTicketDetailsSetAppointmentTextLabelExistsDSL()
                .validateTicketDetailsSetAppointmentTextCLDSL()
                .validateSetTechnicianAppointmentButtonExists();
    }

    @Test(description = "GC03 - DSL user - Deeplink to Net Assistant Tickets List - Verify ticket details view after opening ticket with resolved status")
    @TmsLink("WFET-6210")
    private void GC03(){
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)
                .navigateSIT(ticketsLink)
                .clickMoreInfoTicketStatusIndex("Gelöst",1)
                .validateTicketDetailsSetAppointmentTextLabelExistsDSL()
                .validateTicketDetailsSetAppointmentTextCLDSL()
                .validateSetTechnicianAppointmentButtonExists();
    }

    @Test(description =  "GC04 - DSL user - Deeplink to Net Assistant Tickets List - Verify ticket details view after opening ticket with closed status")
    @TmsLink("WFET-6211")
    private void GC04(){

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)
                .navigateSIT(ticketsLink)
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
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);

        new TicketsPage(driver)
                .navigateSIT(ticketsLink)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .clickOn(TicketsPage.getTechnician_Appointment_Set_Button())
                .clickOn(TicketsPage.get_Go_On_Button())
                .clickOn(TicketsPage.get_Reschedule_Button())
                .clickOn(TicketsPage.get_Fourth_Slot())
                .clickOn(TicketsPage.get_Calendar())
                .validateCalendarExistsDSL();

    }
    @Test(description = "GC15 - DSL user - Navigate to Token Deeplink - Verify ticket details view after opening ticket with in progress status")
    @TmsLink("WFET-6258")
    private void GC15() {
        new TicketsPage(driver)
                .navigateSIT();
        setCookieECHO();

        new TicketsPage(driver)
                .navigateSIT(tokenLink)
                .acceptCookies()
                .validateTicketStatus("In Arbeit")
                .validateTicketDetailsSetAppointmentTextLabelExistsDSL()
                .validateTicketDetailsSetAppointmentTextCLDSL()
                .validateSetTechnicianAppointmentButtonExists();
    }

    @Test(description = "GC16 - DSL user - Navigate to Token Deeplink - Verify ticket details view after opening ticket with resolved status")
    @TmsLink("WFET-6259")
    private void GC16() {
        new TicketsPage(driver)
                .navigateSIT();
        setCookieECHO();

        new TicketsPage(driver)
                .navigateSIT(tokenLink)
                .acceptCookies()
                .validateTicketStatusResolved("Gelöst")
                .validateTicketDetailsSetAppointmentTextLabelExistsDSL()
                .validateTicketDetailsSetAppointmentTextCLDSL()
                .validateSetTechnicianAppointmentButtonExists();
    }
    @Test(description = "GC17 - DSL user - Navigate to Token Deeplink - Verify Set Appointment Flow and Confirmation Action")
    @TmsLink("WFET-6260")
    private void GC17() {
        new TicketsPage(driver)
                .navigateSIT();
        setCookieECHO();

        new TicketsPage(driver)
                .navigateSIT(tokenLink)
                .acceptCookies()
                .clickOn(TicketsPage.getTechnician_Appointment_Set_Button())
                .clickOn(TicketsPage.get_Go_On_Button())
                .clickOn(TicketsPage.get_Reschedule_Button())
                .clickOn(TicketsPage.get_Fourth_Slot())
                .clickOn(TicketsPage.get_Calendar())
                .validateCalendarExistsDSL();
    }
}
