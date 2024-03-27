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
public class WFET_3316 extends SITNetAssistantSetup {
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

    @Test(groups = {"WFET_3316", "regression"})
    @TmsLink("WFET-3574")
    @Description("UM user - Verify scheduled technician appointment appeared when ticket status is Inprogress")
    private void SIT_GC02() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .searchForTicketByStatusAndGetColour("In Arbeit");

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .text()
                .isEqualTo("In Arbeit")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTechnicianAppointment())
                .text()
                .contains("Der Technik-Service kommt am")
                .perform();

        Validations.assertThat()
                .object(TicketsPage.get_Technician_Appointment_Text_Colour())
                .isEqualTo("rgb(230, 0, 0)")
                .perform();

    }

    @Test(groups = {"WFET_3316", "regression"})
    @TmsLink("WFET-3576")
    @Description("SIT - GC04 - UM user - Verify scheduled technician appointment did not appear when ticket status is closed")
    private void SIT_GC04() {

        int first_count=0;
        int second_count=0;

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .scrollTo(TicketsPage.get_Expand_Closed_Tickets());

        first_count=new TicketsPage(driver).Get_Appointments_Count();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Expand_Closed_Tickets())
                .exists()
                .withCustomReportMessage("expand closed ticket button displayed")
                .perform();

        new TicketsPage(driver)
                .navigate(tickets_Deeplink)
                .scrollTo(TicketsPage.get_Expand_Closed_Tickets())
                .clickExpandClosedTicketsButton()
                .searchForOpenTicketByStatus("Geschlossen");

        second_count = new TicketsPage(driver).Get_Appointments_Count();
        System.out.println("first count"+first_count);
        System.out.println("second count"+second_count);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Closed_Ticket_Status())
                .exists()
                .withCustomReportMessage("status is closed in tickets list")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Closed_Ticket_Status())
                .text()
                .isEqualTo("Geschlossen")
                .perform();

        Validations.verifyThat()
                .object(first_count)
                .isEqualTo(second_count)
                .withCustomReportMessage("Closed Tickets has no Technician Appointments")
                .perform();
    }


    @Test(groups = {"WFET_3316", "regression"})
    @TmsLink("WFET-3578")
    @Description("UM user - Verify scheduled technician appointments for multiple tickets")
    private void SIT_GC06() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        int Appointments_count=new TicketsPage(driver).Get_Appointments_Count();
        System.out.println("Appointments count "+ TicketsPage.get_Technician_Appointment_Count());

        Validations.verifyThat()
                .number(Appointments_count)
                .isGreaterThan(1)
                .withCustomReportMessage("Multiple Tickets has more than 1 Technician Appointments")
                .perform();

    }
}
