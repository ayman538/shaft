package de.vodafone.tests.NetAssistant.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_3453 extends SITNetAssistantSetup {

    //Variables
    private String chatbot_Deeplink;
    private String tickets_Deeplink;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        chatbot_Deeplink = testData.getTestData(method.getName() + ".link");
        tickets_Deeplink = testData.getTestData(method.getName() + ".link");
        super.setup(method);

    }

    @Test(groups = {"WFET_3453", "regression"})
    @TmsLink("WFET-3619")
    @Description("UM user- Deeplink to Tickets List-verify that scheduled technician appointment appeared when the ticket status is inprogress")
    private void SIT_GC01(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);
                //.NavigateToTicketWithAppointment();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .text()
                .isEqualTo("In Arbeit");

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.getTicket_Has_Technician_Appointment())
                .exists()
                .perform();

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.get_Technician_Appointment_Label_Tickets_List())
                .text()
                .contains("Mach bitte einen Termin mit dem Technik-Service")
                .perform();
    }


    @Test(groups = {"WFET_3453", "regression"})
    @TmsLink("WFET-3621")
    @Description("UM user- Deeplink to Tickets List-verify that scheduled technician appointment appeared at ticket details section")
    private void SIT_GC03(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .ClickOnMoreInfoButtonWithAppointment()
                .scrollTo(TicketsPage.get_Manage_Technician_Appointment_Label_In_Ticket_Details());

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.get_Manage_Technician_Appointment_Label_In_Ticket_Details())
                .exists()
                .perform();
    }

    @Test(groups = {"WFET_3453", "regression"})
    @TmsLink("WFET-3622")
    @Description("UM user- Deeplink to Tickets List-verify that change appointment button displayed for scheduled technician appointment in ticket details section")
    private void SIT_GC04(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .ClickOnMoreInfoButtonWithAppointment()
                .scrollTo(TicketsPage.get_Manage_Technician_Appointment_Label_In_Ticket_Details());

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.getTechnician_Appointment_Reschedule_Button())
                .exists()
                .perform();

    }

    @Test(groups = {"WFET_3453", "regression"})
    @TmsLink("WFET-3627")
    @Description("UM user- Deeplink to Tickets List-verify that change appointment button not displayed for ticket has no scheduled technician appointment set before")
    private void SIT_GC09() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .scrollTo(TicketsPage.getTicket_Has_NO_Technician_Appointment());

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getTicket_Has_NO_Technician_Appointment())
                .text()
                .doesNotContain(new TicketsPage(driver).TechnicianAppointmentText());
    }
}
