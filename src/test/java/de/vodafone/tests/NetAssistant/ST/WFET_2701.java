package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_2701")
public class WFET_2701 extends STNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String ticketsDeeplink;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        ticketsDeeplink = testData.getTestData(method.getName()+".deeplink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);

        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);

    }

    @Test(description ="Cable - Deeplink to Net assistant Cable ticket Details - Verify icon removed behind previous steps when accordion is closed")
    @TmsLink("WFET-3030")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .validateTicketStatusDisplayedTicketsList()
                .clickMoreInfoButton()
                .validatePreviouStepsAccordionIsClosed()
                .validatePreviouStepsIconIsNotDisplayed();

    }

    @Test(description = "Cable user - Deeplink to Net Assistant Cable ticket Details - Verify icon removed behind previous steps when accordion is closed")
    @TmsLink("WFET-3034")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new TicketsPage(driver)
                .clickExpandClosedTicketsButton()
                .validateTicketStatusDisplayed()
                .clickOn(TicketsPage.getClosedTicketDetailsButton())
                .validatePreviouStepsAccordionExists()
                .validatePreviousStepsGreenIconDoesNotExist();


    }
}
