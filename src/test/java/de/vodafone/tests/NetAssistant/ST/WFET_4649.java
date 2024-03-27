package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4649")
public class WFET_4649 extends STNetAssistantSetup {
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

    @Test(description = "ST-GC01-Cable user- Using token deeplink - Verify that appointment management and appointment canceling is disabled when appointment takes place in less than 4 hours")
    @TmsLink("WFET-4848")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsNotVisible()
                .validateCloseTicketBtnIsNotVisible();
    }

    @Test(description = "ST-GC02-Cable user- Using tickets list - Verify that appointment management and appointment canceling is disabled when appointment takes place in less than 4 hours")
    @TmsLink("WFET-4852")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsNotVisible()
                .validateCloseTicketBtnIsNotVisible();
    } //Tickets List

    @Test(description = "ST-GC03-Cable user-Using token deeplink-Verify that history details of ticket will show the latest status in the first line and the oldest status on the last line")
    @TmsLink("WFET-4853")
    private void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickExpandTicketHistoryAccordion()
                .validateTicketHistoryLogArrangedFromRecentlyToOlder();

    } //Token Deeplink

    @Test(description = "ST-GC04-Cable user-Using Tickets list-Verify that history details of ticket will show the latest status in the first line and the oldest status on the last line")
    @TmsLink("WFET-4854")
    private void ST_GC04() throws InterruptedException {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2) //Based on ticket
                .clickExpandTicketHistoryAccordion()
                .validateTicketHistoryLogArrangedFromRecentlyToOlder();
    }//Tickets List

    @Test(description = "ST-GC05-Cable user-Using token deeplink- Verify that appointment management and appointment canceling options are existing when appointment takes place in more than 4 hours")
    @TmsLink("WFET-4855")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsVisible()
                .validateCloseTicketBtnIsVisible();

    }

    @Test(description = "ST-GC06-Cable user-Using tickets list- Verify that appointment management and appointment canceling options are existing when appointment takes place in more than 4 hours")
    @TmsLink("WFET-4857")
    private void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  1)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsVisible()
                .validateCloseTicketBtnIsVisible();
    }

    @Test(description = "ST-GC07-UM user- Using token deeplink - Verify that appointment management and appointment canceling is disabled when appointment takes place in less than 4 hours")
    @TmsLink("WFET-4866")
    private void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsNotVisible()
                .validateCloseTicketBtnIsNotVisible();

    }


    @Test(description = "ST-GC08- UM user- Using tickets list - Verify that appointment management and appointment canceling is disabled when appointment takes place in less than 4 hours")
    @TmsLink("WFET-4868")
    private void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  1)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsNotVisible()
                .validateCloseTicketBtnIsNotVisible();
    }

    @Test(description = "ST-GC09 - UM user-Using token deeplink - Verify that history details of ticket will show the latest status in the first line and the oldest status on the last line")
    @TmsLink("WFET-4869")
    private void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickExpandTicketHistoryAccordion()
                .validateTicketHistoryLogArrangedFromRecentlyToOlder();
    }

    @Test(description = "ST- GC10 - UM user - Using Tickets list-Verify that history details of ticket will show the latest status in the first line and the oldest status on the last line")
    @TmsLink("WFET-4870")
    private void ST_GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  1)
                .clickExpandTicketHistoryAccordion()
                .validateTicketHistoryLogArrangedFromRecentlyToOlder();

    }//Tickets List

    @Test(description = "ST- GC11- UM user-Using token deeplink- Verify that appointment management and appointment canceling options are existing when appointment takes place in more than 4 hours")
    @TmsLink("WFET-4871")
    private void ST_GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsVisible()
                .validateCloseTicketBtnIsVisible();

    }//Tpken Deeplink

    @Test(description = "ST- GC012 - UM user-Using tickets list- Verify that appointment management and appointment canceling options are existing when appointment takes place in more than 4 hours")
    @TmsLink("WFET-4871")
    private void ST_GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsVisible()
                .validateCloseTicketBtnIsVisible();

    }
}