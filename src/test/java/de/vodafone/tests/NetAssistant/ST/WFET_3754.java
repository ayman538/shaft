package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TrackMyTechiePage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3754")
public class WFET_3754 extends STNetAssistantSetup {

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


    @Test(description ="WFET-3754 - GC01 - Cable user- Open Ticket Details - Verify that Track My Techie button is displayed if technician appointment exists")
    @TmsLink("WFET-4401")
    private void ST_GC01(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketStatusText("In Arbeit")
                .validateTrackMyTechieTechnicianButtonText()
                .validateTrackMyTechieTechnicianButtonDisplayed();
    }

    @Test(description ="WFET-3754 - GC02 - Cable user- Open Ticket Details - Verify that Map is displayed with technician location if \"Jetzt Technik-Service verfolgen\" button is pressed")
    @TmsLink("WFET-4402")
    private void ST_GC02(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTrackMyTechieTechnicianButtonDisplayed()
                .clickOn(TicketsPage.getTrackMyTechieButton());

        new TrackMyTechiePage(driver)
                .validateTrackMyTechieOverlayDisplayed()
                .validateTrackMyTechieMapDisplayed()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed();

    }

    @Test(description ="WFET-3754 - GC03 - Cable user- Open Ticket Details - Verify that Technician Details are displayed on Overlay and Map if technician name exists")
    @TmsLink("WFET-4403")
    private void ST_GC03(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .clickOn(TicketsPage.getTrackMyTechieButton());

        new TrackMyTechiePage(driver)
                .validateTrackMyTechieOverlayDisplayed()
                .validateTrackMyTechieMapDisplayed()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed()
                .validateTobiIconExists()
                .validateTrackTechnicianTitleText1()
                .validateTrackTechnicianSubTitleTicketNumberText()
                .validateTrackTechnicianTimeAwayText()
                .validateTrackTechnicianClockArrivalTimeAwayText()
                .validateTrackTechnicianTimeAwayText();

    }

    @Test(description ="WFET-3754 -GC04 - Cable user- Open Ticket Details - Verify that Technician Details are displayed on Overlay and Map if technician name does not exist")
    @TmsLink("WFET-4404")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .clickOn(TicketsPage.getTrackMyTechieButton());

        new TrackMyTechiePage(driver)
                .validateTrackMyTechieOverlayDisplayed()
                .validateTrackMyTechieMapDisplayed()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed()
                .validateTobiIconExists()
                .validateTrackTechnicianTitleText1()
                .validateTrackTechnicianSubTitleTicketNumberText()
                .validateTrackTechnicianTimeAwayText()
                .validateTrackTechnicianClockArrivalTimeAwayText()
                .validateTrackTechnicianTimeAwayText();
    }

    @Test(description = "WFET-3754 - GC05 - Cable user- Open Ticket Details - Verify that Technician Location on Map is displayed if technician appointment has arrived")
    @TmsLink("WFET-4405")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",4)
                .clickOn(TicketsPage.getTrackMyTechieButton());

        new TrackMyTechiePage(driver)
                .validateTrackMyTechieOverlayDisplayed()
                .validateTrackMyTechieMapDisplayed()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed()
                .validateTobiIconExists()
                .validateTrackTechnicianArrivalText()
                .validateTrackTechnicianTitleText2()
                .validateTrackTechnicianSubTitleTicketNumberText();
    }

}
