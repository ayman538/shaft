package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3298")
public class WFET_3298 extends STNetAssistantSetup {
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


  /*  @Test(enabled = false , groups={"WFET_3298"})
    @TmsLink("WFET-3867")
    @Description("ST02 - non logged in UM user -verify that ticket listing displayed when navigate to netassisstant app through  deep link")
    private void GC02() {

        new DashboardPage(driver)
                .navigateInNewTab(ticketsLink)
                .validateTicketsPageDisplayed()
                .validateLogoutButtonDisplayed();

    }
   */
    @Test(description = "logged in UM user -verify behavior of logout button at tickets screen")
    @TmsLink("WFET-3868")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new DashboardPage(driver)
                .validateTicketsPageDisplayed()
                .validateLogoutButtonDisplayed()
                .clickOn(DashboardPage.getLogoutButton());


    }
}
