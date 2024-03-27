package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3066")
public class WFET_3066 extends STNetAssistantSetup {
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsLink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);

    }

    @Test(description ="Cable user- Deeplink to Tickets List-verify that scheduled technician appointment appeared when the ticket status is inprogress")
    @TmsLink("WFET-3361")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketAppointmentText();
    }
    @Test(description = "Cable user- Deeplink to Tickets List-verify that scheduled technician appointment appeared at ticket details section")
    @TmsLink("WFET-3363")
    private void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoButton()
                .validateTicketAppointmentText();

    }
    @Test(description =    "Cable user- Deeplink to Tickets List-verify that change appointment button displayed for scheduled technician appointment in ticket details section")
    @TmsLink("WFET-3364")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketAppointmentText()
                .clickMoreInfoButton()
                .validateRescheduleBtnIsVisible();
    }
}