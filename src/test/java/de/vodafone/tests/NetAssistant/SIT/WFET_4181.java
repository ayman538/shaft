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

public class WFET_4181 extends SITNetAssistantSetup {

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

    @Test(description = "WFET-4181 - ST01 - UM user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4577")
    public void SIT_GC01() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateOptionPickerAppears();
    }
    @Test(description = "WFET-4181 - ST02 - Cable user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4578")
    public void SIT_GC02() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateOptionPickerAppears();
    }

    @Test(description = "WFET-4181 - ST03 - DSL user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4579")
    public void SIT_GC03() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateOptionPickerAppears();
    }
    @Test(description = "WFET-4181 - ST05 - UM user -Deeplink to Netassisstant chatbot- Verify that the option picker displayed when there is 3options or less in decision tree")
    @TmsLink("WFET-4580")
    public void SIT_GC04() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateOptionPickerAppears();
    }

    @Test(description = "WFET-4181 - ST07 - UM user -Deeplink to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4583")
    public void SIT_GC07() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-4181 - ST08 - Cable user -Deeplink to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4584")
    public void SIT_GC08() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-4181 - ST09 - DSL user -Deeplink to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4585")
    public void SIT_GC09() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-4181 - ST10 - UM user -Login to Netassisstant chatbot- Verify that the drop down/suggest field displayed when more than 3options in decision tree")
    @TmsLink("WFET-4583")
    public void SIT_GC10() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateDropDownAppears();
    }
}





