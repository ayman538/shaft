package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5765")
public class WFET_5765 extends STNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String Link;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        Link = testData.getTestData(method.getName() + ".Link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);

    }

    @Test(description ="GC01 - DSL user - Deeplink to netassisstant - Verify that message displayed with no effected services when user has no mass outage")
    @TmsLink("WFET-6087")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateNoMassOutageCLDisplayed();
    }

    @Test(description ="GC02 - DSL user - Deeplink to net assistant - Verify that message displayed with no effected services when user has multiple mass outage")
    @TmsLink("WFET-6088")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();

    }

    @Test(description ="GC03 - DSL user - Deeplink to net assistant - Verify that message displayed with no effected services when user has single mass outage")
    @TmsLink("WFET-6089")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();
    }
}