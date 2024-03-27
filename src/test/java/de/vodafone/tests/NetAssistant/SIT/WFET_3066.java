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
public class WFET_3066 extends SITNetAssistantSetup {
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

    @Test(groups = {"WFET_3066", "regression"})
    @TmsLink("WFET-3361")
    @Description("Cable user- Deeplink to Tickets List-verify that scheduled technician appointment appeared when the ticket status is inprogress")
    private void SIT_GC01() {
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTechnicianAppointment())
                .exists()
                .withCustomReportMessage("ticket has technician appointment")
                .perform();
    }
    @Test(groups = {"WFET_3066", "regression"})
    @TmsLink("WFET-3363")
    @Description("Cable user- Deeplink to Tickets List-verify that scheduled technician appointment appeared at ticket details section")
    private void SIT_GC03() {
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink).
                clickMoreInfoButtonClosedTicket();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTechnicianAppointment())
                .exists()
                .withCustomReportMessage("ticket has technician appointment")
                .perform();
    }
    @Test(groups = {"WFET_3066", "regression"})
    @TmsLink("WFET-3364")
    @Description("Cable user- Deeplink to Tickets List-verify that change appointment button displayed for scheduled technician appointment in ticket details section")
    private void SIT_GC04() {
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink)
                .clickMoreInfoButton();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTechnicianAppointment())
                .exists()
                .withCustomReportMessage("ticket has technician appointment")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Change_Appointment_Button())
                .text()
                .isEqualTo("Termin ändern")
                .perform();
    }
}