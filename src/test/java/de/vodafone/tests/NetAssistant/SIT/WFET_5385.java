package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WFET_5385 extends SITNetAssistantSetup {

    private String userName;
    private String password;
    private String deeplink;
    private String contractnumber;
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
        contractnumber = testData.getTestData(method.getName() + ".contractnumber");
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

    @Test(description = "WFET-5385 - GC01 - DSL user - Deeplink to net assistant - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is returned from CMS")
    @TmsLink("WFET-5473")
    public void SIT_GC01() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test(description = "WFET-5034 - UM user -Deeplink to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5111")
    public void SIT_GC02() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }
    @Test(description = "WFET-5034 - DSL user -Deeplink to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5112")
    public void SIT_GC03() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5034 - UM user -Login to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5114")
    public void SIT_GC04() {

        new DashboardPage(driver)
                .getUmSOSIT(contractnumber);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5034 - Cable user -Login to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5115")
    public void SIT_GC05() {

        new DashboardPage(driver)
                .getCableSO(contractnumber);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5034 - DSL user -Login to Netassisstant chatbot- Verify that the drop down displayed when more than 3options in decision tree")
    @TmsLink("WFET-5116")
    public void SIT_GC06() {

        new DashboardPage(driver)
                .getDSLSO();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateDropDownAppears();
    }

    @Test(description = "WFET-5034 - Cable user -Deeplink to Netassisstant chatbot- Verify that the Question title displayed for the option picker")
    @TmsLink("WFET-5117")
    public void SIT_GC07() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateOptionPickerQuestionExists();
    }

    @Test(description = "WFET-5034 - UM user -Deeplink to Netassisstant chatbot- Verify that the Question title displayed for the option picker")
    @TmsLink("WFET-5118")
    public void SIT_GC08() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateOptionPickerQuestionExists();
    }

    @Test(description = "WFET-5034 - DSL user -Deeplink to Netassisstant chatbot- Verify that the Question title displayed for the option picker")
    @TmsLink("WFET-5121")
    public void SIT_GC09() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateOptionPickerQuestionExists();
    }
}





