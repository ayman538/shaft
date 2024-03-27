package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3925")
public class WFET_3925 extends STNetAssistantSetup {

    //Variables

    private String ticketsTokenDeeplink;
    private String URL;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsTokenDeeplink = testData.getTestData(method.getName() + ".tokenDeeplink");
        URL = testData.getTestData(method.getName() + ".url");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap);
    }

    @Test(description ="DSL user -Navigate with Net Assistant Token Deeplink")
    @TmsLink("WFET-4376")
    private void ST_GC03(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsTokenDeeplink);

        new TicketsPage(driver)
                .validateTokenMessageIsVisible()
                .validateTokenMessageCL()
                .validateTokenErrorMsg()
                .validateErrorMsgButtonDisplayed()
                .validateErrorMsgButtonTextMatch()
                .validateErrorMsgButtonVisible()
                .clickOn(TicketsPage.getErrorMsgButtonToken())
                .getCurruntURL()
                .validateTokenErrorRedirectionURL(URL);
    }
}
