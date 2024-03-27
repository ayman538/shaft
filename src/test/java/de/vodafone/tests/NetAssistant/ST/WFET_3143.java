package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3143")
public class WFET_3143 extends STNetAssistantSetup {
    //Variables
    private String ticketDeeplink;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketDeeplink = testData.getTestData(method.getName() + ".tokenDeeplink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap);

    }

    @Test(description = "GC01 - cable user - Deeplink to Cable ticket then verify ticket details view Displayed")
    @TmsLink("WFET-3595")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketDeeplink);

        new TicketsPage(driver)
                .validateGelostTicketsHeaderDetails();

    }

    @Test(description = "ST - GC04 - cable user - Deeplink to Cable ticket then verify user redirection in-case token number doesn't exist")
    @TmsLink("WFET-3598")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketDeeplink);

        new TicketsPage(driver)
                .validateErrorMsgIsDisplayed();


    }
    @Test(description = "GC03 - cable user - Deeplink to Cable ticket then verify vodafone icon navigation")
    @TmsLink("WFET-3597")
    private void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketDeeplink);

        new TicketsPage(driver)
                .validateGelostTicketsHeaderDetails()
                .clickOn(TicketsPage.getVodafone_icon())
                .validateVodafoneIconExists();

    }
}
