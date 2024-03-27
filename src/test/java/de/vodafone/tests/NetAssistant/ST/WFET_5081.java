package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5081")
public class WFET_5081 extends STNetAssistantSetup {
    //Variables
    private String Link;
    private String userName;
    private String userPassword;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        Link = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "GC06 - Cable user - Logged in User - Deeplink to net assistant from Mein Vodafone SO - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5946")
    private void GC06() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .navigate(Link)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }

    @Test(description = "GC07 - UM user - Logged in User - Deeplink to net assistant from Mein Vodafone SO - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5947")
    private void GC07() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .navigate(Link)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }


    @Test(description = "GC08 - DSL user - Logged in User - Deeplink to net assistant - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5951")
    private void GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }

    @Test(description = "GC09 - Cable user - Logged in User - Deeplink to net assistant - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5952")
    private void GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }

    @Test(description = "GC10 - UM user - Logged in User - Deeplink to net assistant - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5953")
    private void GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }

}