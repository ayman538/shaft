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
@Story("WFET_6090")
public class WFET_6090 extends STNetAssistantSetup {
    //Variables
    private String deeplink;
    private String userName;
    private String userPassword;
    private  HashMap<String,String> cookieSwitcherMap;

    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);

        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "WFET-6188 - GC01 - Cable User | Logged in | If user has an open ticket with status \"New\" and navigating to chatbot deeplink he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6188")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6189 - GC02 - Cable User | Logged in | If user has an open ticket with status \"In Progress\" and navigating to chatbot deeplink he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6189")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6190 - GC03 - UM User | Logged in | If user has an open ticket with status \"New\" and navigating to chatbot deeplink he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6190")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "GC04 - UM User | Logged in | If user has an open ticket with status \"In Progress\" and navigating to chatbot deeplink he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6191")
    private void GC04() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6192 - GC05 - DSL User | Logged in | If user has an open ticket with status \"New\" and navigating to chatbot deeplink he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6192")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6193 - GC06 - DSL User | Logged in | If user has an open ticket with status \"In Progress\" and navigating to chatbot deeplink he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6193")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateTicketsPage();
    }


    @Test(description = "WFET-6194 - GC07 - Cable User | Logged in | If user has an open ticket with status \"New\" and navigating to chatbot using SO he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6194")
    private void GC07() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6229 - GC08 - Cable User | Logged in | If user has an open ticket with status \"In Progress\" and navigating to chatbot using SO he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6229")
    private void GC08() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6230 - GC09 - UM User | Logged in | If user has an open ticket with status \"New\" and navigating to chatbot using SO he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6230")
    private void GC09() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6231 - GC10 - UM User | Logged in | If user has an open ticket with status \"In Progress\" and navigating to chatbot using SO he should be redirected to \"Meine Störungtickets\" tab to see his opened tickets status")
    @TmsLink("WFET-6231")
    private void GC10() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new ChatbotPage(driver)
                .validateTicketsPage();
    }

    @Test(description = "WFET-6238 - GC17 - DSL User | Logged in | If user has no tickets and navigating to chatbot using deeplink he should be redirected to \"Netz-Assisstent\" tab")
    @TmsLink("WFET-6238")
    private void GC17() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateChatbotPage();
    }

    @Test(description = "WFET-6238 - GC18 - DSL User | Logged in | If user has closed ticket and navigating to chatbot using deeplink he should be redirected to Netz-Assisstent")
    @TmsLink("WFET-6238")
    private void GC18() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateChatbotPage();
    }

    @Test(description = "WFET-6251 - GC19 - Cable User | Logged in | If user has no tickets and navigating to chatbot using deeplink he should be redirected to Netz-Assisstent")
    @TmsLink("WFET-6251")
    private void GC19() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateChatbotPage();
    }

    @Test(description = "WFET-6252 - GC20 - Cable User | Logged in | If user has closed ticket and navigating to chatbot using deeplink he should be redirected to Netz-Assisstent")
    @TmsLink("WFET-6252")
    private void GC20() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateChatbotPage();
    }

    @Test(description = "WFET-6251 - GC21 - Cable User | Logged in | If user has a resolved ticket and navigating to chatbot using deeplink he should be redirected to \"Netz-Assisstent\" tab")
    @TmsLink("WFET-6251")
    private void GC21() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);

        new ChatbotPage(driver)
                .validateChatbotPage();
    }

    @Test(description = "WFET-6240 - GC22 - UM User | Logged in | If user has no open tickets and navigating to chatbot using SO he should be redirected to \"Netz-Assisstent\" tab")
    @TmsLink("WFET-6240")
    private void GC22() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new ChatbotPage(driver)
                .validateChatbotPage();
    }

    @Test(description = "WFET-6253 - GC23 - UM User | Logged in | If user has resolved ticket and navigating to chatbot using SO he should be redirected to \"Netz-Assisstent\" tab")
    @TmsLink("WFET-6253")
    private void GC23() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new ChatbotPage(driver)
                .validateChatbotPage();
    }

    @Test(description = "GC24 - UM User | Logged in | If user has closed ticket and navigating to chatbot using SO he should be redirected to \"Netz-Assisstent\" tab")
    @TmsLink("WFET-6254")
    private void GC24() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new ChatbotPage(driver)
                .validateChatbotPage();
    }
}