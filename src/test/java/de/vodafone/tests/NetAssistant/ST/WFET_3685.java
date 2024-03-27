package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TrackMyTechiePage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3685")
public class WFET_3685 extends STNetAssistantSetup {

    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;
    //Test
    @BeforeMethod
    public void setup(Method method) {
        userName=testData.getTestData(method.getName() + ".userName");
        userPassword=testData.getTestData(method.getName() + ".userpassword");
        ticketsLink = testData.getTestData(method.getName() + ".link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description ="ST-GC01-Cable user- Deeplink to Appointment -verify the the map showing when the technician not arrived yet")
    @TmsLink("WFET-4390")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TrackMyTechiePage(driver)
                .validateTobiIconExists()
                .validateTrackTechnicianTitleText1()
                .validateTrackTechnicianSubTitleTicketNumberText()
                .validateTrackTechnicianTimeAwayText()
                .validateTrackTechnicianClockArrivalTimeAwayText()
                .validateTrackTechnicianDistanceAwayText()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed();


    }

    @Test(description ="ST-GC02-Cable user- Deeplink to Appointment -verify the the map showing when the technician is arrived to the user's location")
    @TmsLink("WFET-4391")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TrackMyTechiePage(driver)
                .validateTobiIconExists()
                .validateTrackTechnicianTitleText2()
                .validateTrackTechnicianSubTitleTicketNumberText()
                .validateTrackTechnicianArrivedRightMarkIconDisplayed()
                .validateTrackTechnicianArrivalText()
                .validateTrackMyTechieHomeIconDisplayed()
                .validateTrackMyTechieTechnicianIconDisplayed();


    }

    @Test(description ="ST-GC06-Cable user- Deeplink to Appointment -verify that chatbot and tickets page is hidden when there is an appointment")
    @TmsLink("WFET-4398")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TrackMyTechiePage(driver)
                .validateTrackMyTechieHiddenChatbotTabHeader()
                .validateTrackMyTechieHiddenTicketsTabHeader();

    }

}

