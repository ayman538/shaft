package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4038")
public class WFET_4038 extends STNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String Link;
    private String Link2;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        Link = testData.getTestData(method.getName() + ".Link");
        Link2=testData.getTestData(method.getName() + ".Link2");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);

    }

    @Test(description ="ST - DSL user -Deeplink to netassisstant-verify that message displayed with no effected services when user has single mass outage")
    @TmsLink("WFET-4129")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();

    }

    @Test(description = "ST - DSL user -Deeplink to netassisstant-verify that message displayed with no effected services when user has multiple mass outage")
    @TmsLink("WFET-4130")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();

    }

    @Test(description ="ST - DSL user -Deeplink to netassisstant-verify that message displayed with no effected services when user has no mass outage")
    @TmsLink("WFET-4131")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateNoMassOutageCLDisplayed();
    }

    @Test(description ="ST- DSL user -Login to mienvodafone-verify that message displayed with no effected services when user has single mass outage")
    @TmsLink("WFET-4168")
    private void GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .readMessageWithWait(ChatbotPage.getNewMassOutageMsgDSLCL())
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();

    }
    @Test(description = "ST- DSL user -Login to mienvodafone-verify that message displayed with no effected services when user has multiple mass outage")
    @TmsLink("WFET-4169")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .readMessageWithWait(ChatbotPage.getNewMassOutageMsgDSLCL())
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();
    }
}