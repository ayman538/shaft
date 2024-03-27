package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3269")
public class WFET_3269 extends STNetAssistantSetup {
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsLink = testData.getTestData(method.getName() + ".link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);

    }

    @Test(description ="UM - Deeplink to Net Assistant tickets- Check ticket details view with text description when clicking on more info button for inprogress ticket status")
    @TmsLink("WFET-3538")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoButton()
                .validateTicketsDetailsStatusExsits()
                .validateTicketStatusText("In Arbeit")
                .validateTicketStatusDescriptionExists();
    }

    @Test(description = "UM -  Deeplink to Net Assistant Ticket Details View - verify previous steps for ticket with status inprogress")
    @TmsLink("WFET-3546")
    private void ST_GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoButton()
                .validateTicketStatusText("In Arbeit")
                .validatePreviouStepsAccordionExists();
    }

    @Test(description = "UM -  Deeplink to Net Assistant Ticket Details View - Check back button behavior")
    @TmsLink("WFET-3540")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoButton()
                .validateTicketsDetailsStatusExsits()
                .validateCloseTicketBtnIsVisible()
                .Click_Close_Ticket_Button()
                .clickOn(TicketsPage.get_Go_On_Button())
                .clickOn(TicketsPage.get_Back_Button());
    }

    @Test(description ="UM - Deeplink to Net Assistant Ticket Details View - Verify more info button exists in closed tickets" )
    @TmsLink("WFET-3537")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateExpandClosedTicketsDisplayed()
                .clickExpandClosedTicketsButton()
                .validateClosedTicketsMoreInfoBtnExsits();

    }
    @Test(description ="UM - Deeplink to Net Assistant Ticket Details View - verify previous steps for ticket with status closed")
    @TmsLink("WFET-3548")
    private void ST_GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickExpandClosedTicketsButton()
                .clickMoreInfoButtonClosedTicket()
                .validateTicketStatusText("Geschlossen")
                .validatePreviouStepsAccordionExists();
    }
}
