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
public class WFET_3452 extends SITNetAssistantSetup {

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

    @Test(groups = {"WFET_3452", "regression"})
    @TmsLink("WFET-3630")
    @Description("UM user- Deeplink to Tickets List-verify that scheduled technician appointment appeared when the ticket status is inprogress")
    private void SIT_GC01(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .searchForTicketByStatusAndGetColour("In Arbeit");

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .text()
                .isEqualTo("In Arbeit");



        Validations.assertThat()
                .object(TicketsPage.get_Technician_Appointment_Text_Colour())
                .isEqualTo("rgb(230, 0, 0)")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Technician_Appointment_Label_Tickets_List())
                .text()
                .contains("Mach bitte einen Termin mit dem Technik-Service")
                .perform();
    }


    @Test(groups = {"WFET_3452", "regression"})
    @TmsLink("WFET-3632")
    @Description("UM user - Deeplink to Tickets List - Verify ticket details view after opening ticket with inprogress status")
    private void SIT_GC03(){
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .searchForTicketByStatusAndClickMoreInfo("In Arbeit");

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.get_Set_Technician_Appointment_Label_In_Ticket_Details())
                .exists()
                .perform();

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.get_Set_Technician_Appointment_Label_In_Ticket_Details())
                .text()
                .contains("Wähl Deinen Technik-Service-Termin")
                .perform();

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.getTechnician_Appointment_Set_Button())
                .exists()
                .withCustomReportMessage(" Set Appointment Button Exists Successfully")
                .perform();
    }

    @Test(groups = {"WFET_3452", "regression"})
    @TmsLink("WFET-3634")
    @Description("UM user- Deeplink to Tickets List-verify that change appointment button displayed for scheduled technician appointment in ticket details section")
    private void SIT_GC05(){

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .scrollTo(TicketsPage.get_Expand_Closed_Tickets())
                .clickExpandClosedTicketsButton()
                .clickMoreInfoButtonClosedTicket();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Closed_Ticket_Status())
                .exists()
                .withCustomReportMessage("status is closed in tickets list")
                .perform();

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.get_Set_Technician_Appointment_Label_In_Ticket_Details())
                .doesNotExist()
                .perform();

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.get_Manage_Technician_Appointment_Label_In_Ticket_Details())
                .doesNotExist()
                .perform();

    }

    @Test(groups = {"WFET_3452", "regression"})
    @TmsLink("WFET-3635")
    @Description("UM user - Deeplink to Tickets List - Verify Set Appointment button click")
    private void SIT_GC06() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .searchForTicketByStatusAndClickMoreInfo("In Arbeit")
                .clickOn(TicketsPage.getTechnician_Appointment_Set_Button())
                .clickOn(TicketsPage.get_Go_On_Button())
                .clickOn(TicketsPage.get_Reschedule_Button())
                .clickOn(TicketsPage.get_Fourth_Slot())
                .clickOn(TicketsPage.get_Calendar());

        Validations
                .verifyThat()
                .element(driver.getDriver(), TicketsPage.get_Calendar())
                .exists()
                .withCustomReportMessage(" Calendar Exists Successfully")
                .perform();

    }
}
