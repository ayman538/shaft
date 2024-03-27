package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4807")
public class WFET_4807 extends STNetAssistantSetup {
    //Variables
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private String contractNumber;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsLink = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        contractNumber = testData.getTestData(method.getName()+".contractNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);

    }


    @Test(description = "GC01 - DSL user - Verify Page displayed when DSL user deeplink to his tickets with multiple Contracts attached to his account")
    @TmsLink("WFET-5287")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new DashboardPage(driver)
                .validateContractChooserPage();
    }
/* Old behavior
    @Test(description = "GC03 - DSL user - Verify Page displayed when multiple contracts DSL user navigate to deeplink not belonging to any of his contracts")
    @TmsLink("WFET-5289")
    private void ST_GC03() {
        new LoginPage(driver)
                .navigateST(loginDeepLink);
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginST(userName, userPassword);


        new TicketsPage(driver)
                .navigateInNewTab(ticketsLink);

        new DashboardPage(driver)
                .validateContractChooserPage()
                .clickOn(DashboardPage.getContractByName(contractNumber))
                .validateTicketsPageDisplayed();

        new TicketsPage(driver)
                .validateWarningMessage();

    }

*/
}