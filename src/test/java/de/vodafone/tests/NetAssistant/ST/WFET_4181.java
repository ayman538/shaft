package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

public class WFET_4181 extends STNetAssistantSetup {

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

        @Test(description = "WFET-4181 - UM user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4577")
    public void ST_GC01() {

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
    @Test(description = "WFET-4181 - Cable user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4578")
    public void ST_GC02() {

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

    @Test(description = "WFET-4181- DSL user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4579")
    public void ST_GC03() {

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
    @Test(description = "WFET-4181 - UM user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4580")
    public void ST_GC04() {

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

    @Test(description = "WFET-4181- UM user -Deeplink to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4583")
    public void ST_GC07() {

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

    @Test(description = "WFET-4181 - Cable user -Deeplink to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4584")
    public void ST_GC08() {

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

    @Test(description = "WFET-4181 - DSL user -Deeplink to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4585")
    public void ST_GC09() {

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

    @Test(description = "WFET-4181 - UM user -Login to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4583")
    public void ST_GC10() {

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
}





