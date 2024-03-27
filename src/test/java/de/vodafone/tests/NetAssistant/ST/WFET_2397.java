package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;


public class WFET_2397 extends STNetAssistantSetup {

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

        @Test(description = "WFET-2397 - GC01 - Cable user - Deeplink to Net Assistant Chatbot - Verify \"Nein\" Flow appear if massoutage is detected")
    @TmsLink("WFET-2507")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnNetzAssistentVerlassenBtn()
                .validateNeinMessageAppears();
    }
    @Test(description = "WFET-2397 - GC02 - Cable user - Deeplink to Net Assistant Chatbot - Verify \"Nein\" Flow appear if no massoutage is detected")
    @TmsLink("WFET-2508")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnNetzAssistentVerlassenBtn()
                .validateNeinMessageAppears();
    }

    @Test(description = "SIT - GC03 - Cable user - Deeplink to Net Assistant Chatbot - Verify \"Ja\" Flow appear and Decision Tree Proceeds if massoutage is detected")
    @TmsLink("WFET-2509")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree);
    }

    @Test(description = "WFET-2397 - GC04 - Cable user - Deeplink to Net Assistant Chatbot - Verify \"Ja\" Flow appear and Decision Tree Proceeds if no massoutage is detected")
    @TmsLink("WFET-2510")
    public void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

                new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree);
    }

    @Test(description = "WFET-2397 - GC05 - DSL user - Deeplink to Net Assistant Chatbot - Verify \"Nein\" Flow appear if massoutage is detected")
    @TmsLink("WFET-2511")
    public void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnNetzAssistentVerlassenBtn()
                .validateNeinMessageAppears();

    }

    @Test(description = "WFET-2397 - GC06 - DSL user - Deeplink to Net Assistant Chatbot - Verify \"Nein\" Flow appear if no massoutage is detected")
    @TmsLink("WFET-2512")
    public void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnNetzAssistentVerlassenBtn()
                .validateNeinMessageAppears();

    }

    @Test(description = "WFET-2397 - GC07 - DSL user - Deeplink to Net Assistant Chatbot - Verify \"Ja\" Flow appear and Decision Tree Proceeds if massoutage is detected")
    @TmsLink("WFET-2513")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);

    }

    @Test(description = "WFET-2397 - GC08 - DSL user - Deeplink to Net Assistant Chatbot - Verify \"Ja\" Flow appear and Decision Tree Proceeds if no massoutage is detected")
    @TmsLink("WFET-2514")
    public void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);

    }

}





