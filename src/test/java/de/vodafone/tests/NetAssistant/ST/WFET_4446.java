package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4446")
public class WFET_4446 extends STNetAssistantSetup {

    //Variables
    private String tickets_Deeplink;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        tickets_Deeplink = testData.getTestData(method.getName() + ".link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap);

    }

    @Test(description = "ST01 - DSL user -Navigate with Net Assistant Token Deeplink- Verify that general error page is displayed and CL is Updated in case of expired deeplink")
    @TmsLink("WFET-4361")
    private void ST_GC01(){

        new NavigationPage(driver)
                .navigateInNewTab(tickets_Deeplink);

        new TicketsPage(driver)
                .validateErrorMsgIconDisplayed()
                .validateErrorMsgTextMatch()
                .validateErrorMsgTextMatch2()
                .validateErrorMsgButtonDisplayed()
                .validateErrorMsgButtonTextMatch()
                .validateErrorMsgButtonVisible();
    }
    //Obsolete Old Business Scope
    /*
    @Test(description = "ST02 - DSL user -Navigate with Net Assistant Token Deeplink- Verify that button in error page redirects to help form in case of expired Deeplink")
    @TmsLink("WFET-4363")
    private void ST_GC02(){

        new TicketsPage(driver)
                .navigateInNewTab(tickets_Deeplink)
                .validateErrorMsgButtonDisplayed()
                .validateErrorMsgButtonTextMatch()
                .validateErrorMsgButtonVisible();

        new TicketsPage(driver)
                .navigate(tickets_Deeplink)
                .clickOn(TicketsPage.getErrorMsgButtonToken())
                .getCurruntURL();

        new HelpPage(driver)
                .validateErrorMsgButtonRedirection();
    }
    */
}
