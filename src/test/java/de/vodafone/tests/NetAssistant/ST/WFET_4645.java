package de.vodafone.tests.NetAssistant.ST;


import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4645")
public class WFET_4645 extends STNetAssistantSetup {

    //Variables
    private String ticketsDeeplink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsDeeplink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);

    }

    @Test(description = "ST - GC01- DSL user - Verify YouTube Button appear in ticket details when ticket has scheduled technician appointment in less than 24 hours")
    @TmsLink("WFET-4946")
    private void ST_GC01(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateTicketAppointmentValidityWithTicketStatus("In Arbeit",2)
                .searchForTicketByStatusAndGetColourAndIndex("In Arbeit",2)
                .validateTicketAppointmentTextIndex(1)
                .validateTicketAppointmentTextColourDSLTicketList(1);

        new TicketsPage(driver)
                .navigate(ticketsDeeplink)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketDetailsAppointmentText()
                .validateYoutubeButtonFound();
    }

    @Test(description = "ST - GC02- DSL user - Verify YouTube link redirection occurs when YouTube Button is clicked")
    @TmsLink("WFET-4948")
    private void ST_GC02(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateTicketAppointmentValidityWithTicketStatus("In Arbeit",2)
                .searchForTicketByStatusAndGetColourAndIndex("In Arbeit",2)
                .validateTicketAppointmentTextIndex(1)
                .validateTicketAppointmentTextColourDSLTicketList(1);

        new TicketsPage(driver)
                .navigate(ticketsDeeplink)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketDetailsAppointmentText()
                .clickYoutubeButton()
                .validateYoutubeButtonRedirection();
    }

    @Test(description = "ST - GC03- DSL user - Verify YouTube Button disappear from ticket details when ticket has scheduled technician appointment in more than 24 hours")
    @TmsLink("WFET-4952")
    private void ST_GC03(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateTicketAppointmentInvalidityWithTicketStatus("In Arbeit",4);

        new TicketsPage(driver)
                .navigate(ticketsDeeplink)
                .clickMoreInfoTicketStatusIndex("In Arbeit",4)
                .validateYoutubeButtonNotFound();
    }
}
