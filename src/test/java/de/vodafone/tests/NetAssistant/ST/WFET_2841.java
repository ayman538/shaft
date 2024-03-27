package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_2841")
public class WFET_2841 extends STNetAssistantSetup {
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

    /*
//NON Logged in user is not doable in ST environment
   @Test(enabled = false)
    @TmsLink("WFET-3203")
    @Description("SIT04 - non logged in Cable user -verify that ticket listing displayed when navigate to netassisstant app through  deep link")
    private void GC04() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate(loginDeepLink)
                .acceptCookies();

        new LoginPage(driver)
                .loginST(userName,userPassword);

        new DashboardPage(driver)
                .validateTicketsPageDisplayed()
                .validateLogoutButtonDisplayed();


    }
*/
    @Test(description ="logged in Cable user -verify behavior of logout button at tickets screen" )
    @TmsLink("WFET-3204")
    private void GC05() {
        new NavigationPage(driver)
                .navigateInNewTab(ticketsDeeplink);

        new DashboardPage(driver)
                .validateTicketsPageDisplayed()
                .validateLogoutButtonDisplayed()
                .clickOn(DashboardPage.getLogoutButton());
    }
}
