package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

public class WFET_5034 extends STNetAssistantSetup {

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

    @Test(description = "WFET-5034 - Cable user -Deeplink to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5110")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateDropDownAppears();
    }
    @Test(description = "WFET-5034 - UM user -Deeplink to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5111")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5034- DSL user -Deeplink to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5112")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateDropDownAppears();
    }
    @Test(description = "WFET-5034 - UM user -Login to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5113")
    public void ST_GC04() {

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
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5034- Cable user -Login to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5514")
    public void ST_GC05() {

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
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5134 -  DSL user -Login to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5516")
    public void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5134 - Cable user -Deeplink to Netassisstant chatbot- Verify that the Question title displayed for the option picker")
    @TmsLink("WFET-5517")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateOptionPickerAppears();
    }

    @Test(description = "WFET-5134 - UM user -Deeplink to Netassisstant chatbot- Verify that the Question title displayed for the option picker")
    @TmsLink("WFET-5518")
    public void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateOptionPickerAppears();
    }

    @Test(description = "WFET-5134 -  DSL user -Deeplink to Netassisstant chatbot- Verify that the Question title displayed for the option picker")
    @TmsLink("WFET-5121")
    public void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateOptionPickerAppears();
    }
}





