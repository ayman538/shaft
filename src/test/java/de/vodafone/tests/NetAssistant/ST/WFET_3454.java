package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;


@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3454")
public class WFET_3454 extends STNetAssistantSetup {
    //Variables
    private String ticketsTokenLink;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        ticketsTokenLink = testData.getTestData(method.getName() + ".tokenlink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".userPassword");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "GC01 - UM user - Deeplink to UM ticket then verify ticket details view Displayed")
    @TmsLink("WFET-3720")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsTokenLink);

        new TicketsPage(driver)
                .validateTicketsHelloMsgExists()
                .validateTicketsDetailsStatusExsits();

    }
    @Test(description = "GC02 - UM user - Deeplink to UM ticket then verify back button is removed")
    @TmsLink("WFET-3721")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsTokenLink);

        new TicketsPage(driver)
                .validateBackButtonDoesNotExist();
    }
    @Test(description = "GC03 - UM user - Deeplink to UM ticket then Verify vodafone icon navigation")
    @TmsLink("WFET-3722")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsTokenLink);

        new TicketsPage(driver)
                .clickOn(TicketsPage.getVodafone_icon())
                .getCurruntURL()
                .validateVodafoneIconexists()
                .validateURL();
    }
}
