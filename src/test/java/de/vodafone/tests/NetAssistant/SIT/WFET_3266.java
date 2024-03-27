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
public class WFET_3266 extends SITNetAssistantSetup {
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

    @Test(groups = {"WFET_3266", "regression"})
    @TmsLink("WFET-3416")
    @Description("SIT - GC04 - UM user - Deeplink to Net Assistant App - Verify tickets page when there is open tickets and No close tickets displayed")
    private void SIT_GC04() {
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink);
        Validations.assertThat()

                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .exists()
                .withCustomReportMessage("ticket page has open tickets")
                .perform();

    }
    @Test(groups = {"WFET_3266", "regression"})
    @TmsLink("WFET-3417")
    @Description("SIT - GC05 - UM user - Deeplink to Net Assistant App - Verify the open ticket overview")
    private void SIT_GC05() {
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .exists()
                .withCustomReportMessage("ticket with inprogress status displayed")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getStatus_bar_inprogress_tcktlst())
                .exists()
                .withCustomReportMessage("inprogress status bar displayed")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTicket_tittle())
                .exists()
                .withCustomReportMessage("ticket tittle displayed")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Number())
                .exists()
                .withCustomReportMessage("ticket number displayed")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Creation_Date())
                .exists()
                .withCustomReportMessage("ticket creation date displayed")
                .perform();

    }
    @Test(groups = {"WFET_3266", "regression"})
    @TmsLink("WFET-3421")
    @Description("SIT - GC09 -UM- Deeplink to Net-Assistant App - Verify Technical Appointment date in open ticket overview")
    private void SIT_GC09() {
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink);
        Validations.assertThat()

                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .exists()
                .withCustomReportMessage("ticket page has open tickets")
                .perform();
        Validations.assertThat()

                .element(driver.getDriver(), TicketsPage.getTechnicianAppointment())
                .exists()
                .withCustomReportMessage("tecthnician appointment displayed for open ticket")
                .perform();


    }

    @Test(groups={"WFET_3266","regression"})
    @TmsLink("WFET-3425")
    @Description("UM user - Deeplink to Net-Assistant App without query parameter \"C\" - Verify the page displayed")
    private void SIT_GC13() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Message())
                .text()
                .contains("Hallo!")
                .withCustomReportMessage("Hello Message displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Chatbot_Tab_Header())
                .exists()
                .withCustomReportMessage("Chatbot Tab Header displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Tab_Header())
                .exists()
                .withCustomReportMessage("Tickets Tab Header displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Error_Message())
                .text()
                .contains("Wir können Deine Kundendaten nicht identifizieren. Starte bitte den Netz-Assistenten über diesen Link nochmal neu.")
                .withCustomReportMessage(" tickets error message displayed")
                .perform();

    }
    @Test(groups={"WFET_3266","regression"})
    @TmsLink("WFET-3426")
    @Description("UM user - Deeplink to Net-Assistant App without query parameter \"I\" - Verify the page displayed")
    private void SIT_GC14() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Message())
                .text()
                .contains("Hallo!")
                .withCustomReportMessage("Hello Message displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Chatbot_Tab_Header())
                .exists()
                .withCustomReportMessage("Chatbot Tab Header displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Tab_Header())
                .exists()
                .withCustomReportMessage("Tickets Tab Header displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Error_Message())
                .text()
                .contains("Wir können Deine Kundendaten nicht identifizieren. Starte bitte den Netz-Assistenten über diesen Link nochmal neu.")
                .withCustomReportMessage(" tickets error message displayed")
                .perform();
    }
    @Test(groups={"WFET_3266","regression"})
    @TmsLink("WFET-3427")
    @Description("UM user - Deeplink to Net-Assistant App without query parameter \"C\" & \"I\" - Verify the page displayed")
    private void SIT_GC15() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Message())
                .text()
                .contains("Hallo!")
                .withCustomReportMessage("Hello Message displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Chatbot_Tab_Header())
                .exists()
                .withCustomReportMessage("Chatbot Tab Header displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Tab_Header())
                .exists()
                .withCustomReportMessage("Tickets Tab Header displayed Successfully")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Error_Message())
                .text()
                .contains("Wir können Deine Kundendaten nicht identifizieren. Starte bitte den Netz-Assistenten über diesen Link nochmal neu.")
                .withCustomReportMessage(" tickets error message displayed")
                .perform();
    }
}