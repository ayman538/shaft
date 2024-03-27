package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WFET_3926 extends SITNetAssistantSetup {

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
        loginSITAction();
    }
    private void loginSITAction()
    {
        new LoginPage(driver)
                .navigateSIT()
                .setCookieSwitchers(cookieSwitcherMap)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();
    }

    @Test(description = "WFET-3926 - SIT - GC02 - DSL user- Navigate to Chatbot Deeplink - Verify that Regex Failure Message is changed in case of chatbot decision tree")
    @TmsLink("WFET-4123")
    public void SIT_GC02() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateRegexFailureMsg();
    }
    @Test(description = "WFET-3926 - SIT - GC04 - Cable user- Navigate to Chatbot Deeplink - Verify that Regex Failure Message is changed in case of chatbot decision tree")
    @TmsLink("WFET-4125")
    public void SIT_GC04() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateRegexFailureMsg();
    }

    @Test(description = "WFET-3926 - SIT - GC06 - UM user- Navigate to Chatbot Deeplink - Verify that Regex Failure Message is changed in case of chatbot decision tree")
    @TmsLink("WFET-4127")
    public void SIT_GC06() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateRegexFailureMsg();
    }

}





