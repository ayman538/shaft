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
@Story("WFET_3703")
public class WFET_3703 extends STNetAssistantSetup {

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

    @Test(description ="WFET-3703 - GC01 - Cable user - Deeplink to Tickets List- verify the icon of the technician and the icon of the user")
    @TmsLink("WFET-4394")
    private void ST_GC01(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketStatusText("In Arbeit")
                .validateTrackMyTechieTechnicianButtonText()
                .validateTrackMyTechieTechnicianButtonDisplayed()
                .clickOn(TicketsPage.getTrackMyTechieButton());

        new TrackMyTechiePage(driver)
                .validateTrackMyTechieOverlayDisplayed()
                .validateTrackMyTechieMapDisplayed()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed();
    }

    @Test(description ="WFET-3703 - GC03 - Cable user - Deeplink to Tickets List - verify the tracking of technician when he reaches the user's location")
    @TmsLink("WFET-4397")
    private void ST_GC03(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",4)
                .validateTrackMyTechieTechnicianButtonDisplayed()
                .clickOn(TicketsPage.getTrackMyTechieButton());

        new TrackMyTechiePage(driver)
                .validateTrackMyTechieOverlayDisplayed()
                .validateTrackMyTechieMapDisplayed()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed();
    }

}
