package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

public class WFET_5246 extends STNetAssistantSetup {

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
        loginAction(cookieSwitcherMap,userName,password);
    }


    @Test(description = "WFET-5246 - GC1-DSL user -Deeplink to netassisstant chatbot-Verify that the previous answers in the dialogue are disabled when parameter APIHub BackJumps allowed = No")
    @TmsLink("WFET-5496")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsDisabled();
    }
    @Test(description = "WFET-5246 - GC2-DSL user -Navigate to netassisstant chatbot through Help form-Verify that the previous answers in the dialogue are disabled when parameter APIHub BackJumps allowed = No")
    @TmsLink("WFET-5497")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsDisabled();
    }

    @Test(description = "WFET-5246- GC3-DSL user -Login to meinvodafone dashboard-Verify that the previous answers in the dialogue are disabled when parameter APIHub BackJumps allowed = No")
    @TmsLink("WFET-5498")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsDisabled();
    }
    @Test(description = "WFET-5246 - GC4-DSL user -Deeplink to netassisstant chatbot-Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed = Yes")
    @TmsLink("WFET-5499")
    public void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsEnabledDSL();
    }

    @Test(description = "WFET-5246- GC5-DSL user -Navigate to netassisstant chatbot through help form-Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed = Yes")
    @TmsLink("WFET-5500")
    public void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsEnabledDSL();
    }

    @Test(description = "WFET-5246 -  GC6-DSL user -Login to meinvodafone dashboard-Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed = Yes")
    @TmsLink("WFET-5501")
    public void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsEnabledDSL();
    }

    @Test(description = "WFET-5246 - GC7-DSL user -Deeplink to netassisstant chatbot-Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed is not returned")
    @TmsLink("WFET-5502")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsEnabledDSL();
    }

    @Test(description = "WFET-5246 - GC8-DSL user -Navigate to netassisstant chatbot through help form-Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed is not returned")
    @TmsLink("WFET-5503")
    public void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsEnabledDSL();
    }

    @Test(description = "WFET-5246 -  GC9-DSL user -Login to meinvodafone dashboard-Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed is not returned")
    @TmsLink("WFET-5504")
    public void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateJumpBackIsEnabledDSL();

    }
}





