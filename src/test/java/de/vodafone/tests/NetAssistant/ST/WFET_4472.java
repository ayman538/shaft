package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

public class WFET_4472 extends STNetAssistantSetup {

    private String userName;
    private String password;
    private String deeplink;
    private String mobileNumber;
    private  HashMap<String,String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap<String, ArrayList> dslTree;
    private HashMap<String, ArrayList> cableTree;
    private HashMap<String, ArrayList> unityMediaTree;


    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        password = testData.getTestData(method.getName() + ".password");
        deeplink = testData.getTestData(method.getName() + ".link");
        mobileNumber = testData.getTestData(method.getName() + ".mobileNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");

        super.setup(method);
        loginAction(cookieSwitcherMap, userName, password);
    }

    @Test(description = "WFET-4472 - DSL user-Deeplink to chatbot-Verify error message displayed when entering wrong regex")
    @TmsLink("WFET-4856")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateRegexFailureMsg();
    }
    @Test(description = "WFET-4472 - Cable user-Deeplink to chatbot-Verify error message displayed when entering wrong regex")
    @TmsLink("WFET-4858")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateRegexFailureMsg();
    }

    @Test(description = "WFET-4472 - UM user-Deeplink to chatbot-Verify error message displayed when entering wrong regex")
    @TmsLink("WFET-4859")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateRegexFailureMsg();
    }

    @Test(description = "WFET-4472 - DSL user-Login to mienvodafone dashboard-Verify error message displayed when entering wrong regex")
    @TmsLink("WFET-4873")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateRegexFailureMsg();
    }

    @Test(description = "WFET-4472 - Cable user-Login to mienvodafone dashboard-Verify error message displayed when entering wrong regex")
    @TmsLink("WFET-4865")
    public void ST_GC08() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateRegexFailureMsg();
    }

    @Test(description = "WFET-4472 - UM user-Login to mienvodafone dashboard-Verify error message displayed when entering wrong regex")
    @TmsLink("WFET-4867")
    public void ST_GC09() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateRegexFailureMsg();
    }

}





