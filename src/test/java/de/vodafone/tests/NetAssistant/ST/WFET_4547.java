package de.vodafone.tests.NetAssistant.ST;


import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4547")
public class WFET_4547 extends STNetAssistantSetup {

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
        loginAction(cookieSwitcherMap);

    }

    @Test(description = "ST - GC01- DSL user - Verify scheduled technician appointment appeared when ticket status is Inprogress")
    @TmsLink("WFET-4899")
    private void ST_GC01(){

        new LoginPage(driver)
                .loginST(userName, userPassword);

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateTicketAppointmentValidityWithTicketStatus("In Arbeit",2)
                .searchForTicketByStatusAndGetColourAndIndex("In Arbeit",2)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketAppointmentTextColourDSLTicketDetails()
                .validateTicketDetailsAppointmentText();

    }

    @Test(description = "ST - GC02 - DSL user - Verify scheduled technician appointment did not appear when ticket status is closed")
    @TmsLink("WFET-4900")
    private void ST_GC02(){

        new LoginPage(driver)
                .loginST(userName, userPassword);

        int firstCount=0;
        int secondCount=0;

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        firstCount=new TicketsPage(driver).Get_Appointments_Count();

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateExpandClosedTicketsDisplayed()
                .clickExpandClosedTicketsButton()
                .searchForOpenTicketByStatus("Geschlossen");

        secondCount = new TicketsPage(driver).Get_Appointments_Count();
        System.out.println("first count"+firstCount);
        System.out.println("second count"+secondCount);

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .clickExpandClosedTicketsButton()
                .validateClosedTicketsExist()
                .validateClosedTicketStatus("Geschlossen")
                .validateClosedTicketHasNoTechnicianAppointment(firstCount,secondCount);

    }

    @Test(description = "ST - GC04 - DSL user - Verify scheduled technician appointments for multiple tickets")
    @TmsLink("WFET-4902")
    private void ST_GC04(){

        new LoginPage(driver)
                .loginST(userName, userPassword);

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateTechnicianAppointmentsMultipleTickets();

    }

    @Test(description = "ST - GC05 - DSL user - Verify scheduled technician appointments for Token Deeplink")
    @TmsLink("WFET-4906")
    private void ST_GC05(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateTicketStatusText("In Arbeit")
                .validateTicketDetailsAppointmentText();

    }

   /* @Test(description = "ST - GC07 - DSL user - Verify scheduled technician appointments for Net Asisstant Smart Object in Status Menu")
    @TmsLink("WFET-4923")
    private void ST_GC07(){

        new LoginPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .navigate(ticketsDeeplink)
                .acceptCookies()
                .loginActionST(userName,userPassword);


        new DashboardPage(driver)
                //.closeStickyNotifications()
                .openNetAssistantSmartObjectBurgerMenu()
                .validateLoginIndicatorExists()
                .switchToTab();

        new TicketsPage(driver)
                .redirect()
                .validateTicketAppointmentValidityWithTicketStatus("In Arbeit",2)
                .searchForTicketByStatusAndGetColourAndIndex("In Arbeit",2)
                .validateTicketAppointmentTextWithIndex(1)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketDetailsAppointmentText();

    }*/
}
