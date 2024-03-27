package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_4649 extends SITNetAssistantSetup
{
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsLink = testData.getTestData(method.getName() + ".link");
        userName=testData.getTestData(method.getName() + ".name");
        userPassword=testData.getTestData(method.getName() + ".password");
        super.setup(method);

    }
    @Test(description = "SIT-GC01-Cable user- Using token deeplink - Verify that appointment management and appointment canceling is disabled when appointment takes place in less than 4 hours")
    @TmsLink("WFET-4876")
    private void SIT_GC01(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT(ticketsLink)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)

                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsNotVisible()
                .validateCloseTicketBtnIsNotVisible();
    }

    @Test(description="SIT-GC02-Cable user-Using Tickets list-Verify that history details of ticket will show the latest status in the first line and the oldest status on the last line")
    @TmsLink("WFET-4877")
    private void SIT_GC02(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT(ticketsLink)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)

                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2) //Based on ticket
                .clickExpandTicketHistoryAccordion()
                .validateTicketHistoryLogArrangedFromRecentlyToOlder();

    }
    @Test(description = "SIT-GC03-Cable user-Using tickets list- Verify that appointment management and appointment canceling options are existing when appointment takes place in more than 4 hours")
    @TmsLink("WFET-4878")
    private void SIT_GC03(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT(ticketsLink)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)

                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsVisible()
                .validateCloseTicketBtnIsVisible();

    }
    @Test(description = "SIT-GC04- UM user- Using tickets list - Verify that appointment management and appointment canceling is disabled when appointment takes place in less than 4 hours")
    @TmsLink("WFET-4879")
    private void SIT_GC04(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT(ticketsLink)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)

                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsNotVisible()
                .validateCloseTicketBtnIsNotVisible();

    }
    @Test(description="UM user-Using token deeplink - Verify that history details of ticket will show the latest status in the first line and the oldest status on the last line")
    @TmsLink("WFET-4881")
    private void SIT_GC05(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT(ticketsLink)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)

                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2) //Based on ticket
                .clickExpandTicketHistoryAccordion()
                .validateTicketHistoryLogArrangedFromRecentlyToOlder();

    }

    @Test(description = "SIT- GC06- UM user-Using token deeplink- Verify that appointment management and appointment canceling options are existing when appointment takes place in more than 4 hours")
    @TmsLink("WFET-4882")
    private void SIT_GC06(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT(ticketsLink)
                .acceptCookies()
                .loginSIT(userName,userPassword);


        new TicketsPage(driver)

                .clickMoreInfoTicketStatusIndex("In Arbeit" ,  2)
                .validateTicketDetailsAppointmentTextColour()
                .validateRescheduleBtnIsVisible()
                .validateCloseTicketBtnIsVisible();

    }
}

