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
public class WFET_3269 extends SITNetAssistantSetup {
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

    @Test(groups = {"WFET_3269", "regression"})
    @TmsLink("WFET-3538")
    @Description("UM - Deeplink to Net Assistant tickets- Check ticket details view with text description when clicking on more info button for inprogress ticket status")
    private void SIT_GC02() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .clickMoreInfoButton();


        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status())
                .exists()
                .withCustomReportMessage("status is inprogress in ticket details")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status())
                .text()
                .isEqualTo("In Arbeit")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status_Bar())
                .exists()
                .withCustomReportMessage("status bar displayed in ticket details for inprogress tickets")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_ticket_status_description())
                .exists()
                .withCustomReportMessage("ticket status description displayed")
                .perform();
    }

    @Test(groups = {"WFET_3269", "regression"})
    @TmsLink("WFET-3546")
    @Description("UM -  Deeplink to Net Assistant Ticket Details View - verify previous steps for ticket with status inprogress")
    private void SIT_GC10() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .clickMoreInfoButton();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status())
                .text()
                .isEqualTo("In Arbeit")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Previous_Steps_Accordion())
                .exists()
                .withCustomReportMessage("ticket previous steps displayed")
                .perform();
    }

    @Test(groups = {"WFET_3269", "regression"})
    @TmsLink("WFET-3540")
    @Description("UM -  Deeplink to Net Assistant Ticket Details View - Check back button behavior")
    private void SIT_GC04() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .clickMoreInfoButton();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status())
                .exists()
                .withCustomReportMessage("status=inprogress in ticket details")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Close_Ticket_Button())
                .exists()
                .withCustomReportMessage("close ticket button displayed for inprogress ticket")
                .perform();

        new TicketsPage(driver)
                .Click_Close_Ticket_Button()
                .scrollTo(TicketsPage.get_Back_Button())
                .clickOn(TicketsPage.get_Go_On_Button())
                .clickOn(TicketsPage.get_Back_Button());
    }

    @Test(groups = {"WFET_3269", "regression"})
    @TmsLink("WFET-3537")
    @Description("UM - Deeplink to Net Assistant Ticket Details View - Verify more info button exists in closed tickets")
    private void SIT_GC01() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .scrollTo(TicketsPage.get_Expand_Closed_Tickets());

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Expand_Closed_Tickets())
                .exists()
                .withCustomReportMessage("expand closed ticket button displayed")
                .perform();

        new TicketsPage(driver)
                .clickExpandClosedTicketsButton();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getMore_info_btn_closed())
                .exists()
                .withCustomReportMessage("more info button displayed for closed tickets")
                .perform();

    }
    @Test(groups ={"WFET_3269","regression"})
    @TmsLink("WFET-3548")
    @Description("UM - Deeplink to Net Assistant Ticket Details View - verify previous steps for ticket with status closed")
    private void SIT_GC12() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .scrollTo(TicketsPage.get_Expand_Closed_Tickets())
                .clickExpandClosedTicketsButton()
                .clickMoreInfoButtonClosedTicket();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status())
                .text()
                .isEqualTo("Geschlossen")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Previous_Steps_Accordion())
                .exists()
                .withCustomReportMessage("ticket previous steps displayed")
                .perform();
    }
}
