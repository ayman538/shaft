package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4806")
public class WFET_4806 extends STNetAssistantSetup {
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsLink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "GC01 - DSL user - Verify Page displayed when no contract user navigates to tickets deeplink for another user")
    @TmsLink("WFET-5286")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new DashboardPage(driver)
                .validateNoContractError()
                .validateAddContractBtnExists();
    }

}