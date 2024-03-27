package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_4074")
public class WFET_4074 extends STNetAssistantSetup {
    //Variables

    private String userName;
    private String userPassword;
    private String link;
    private HashMap<String,String> cookieSwitcherMap;
    //Test
    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        link=testData.getTestData(method.getName()+".link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "WFET-4263 - UM user -Deeplink to net assistant - Verify that message displayed with multiple affected services when user has single mass outage")
    @TmsLink("WFET-4263")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable();

    }

    @Test(description = "WFET-4265 - UM user -Deeplink to net assistant - Verify that message displayed with no affected services when user has no mass outage")
    @TmsLink("WFET-4265")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .validateNoMassOutageCLDisplayed();
    }

    @Test(description = "WFET-4266 - UM user -Deeplink to net assistant - Verify that message displayed with multiple affected services when user has single mass outage")
    @TmsLink("WFET-4266")
    private void ST_GC03() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable();

    }

    @Test(description = "WFET-4268 - UM user -Deeplink to net assistant - Verify that message displayed with no affected services when user has no mass outage")
    @TmsLink("WFET-4268")
    private void ST_GC04() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .validateNoMassOutageCLDisplayed();
    }

}