package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.tests.NetAssistant.ST.STNetAssistantSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Epic("Net Assistant")
@Feature("SIT")
@Story("WFET_5794")
public class WFET_5794 extends SITNetAssistantSetup {
    //Variables
    private String Link;
    private String userName;
    private String userPassword;
    private String ContactNumber;
    private  HashMap<String,String> cookieSwitcherMap;
    private String phoneNumber;
    private String text;
    private List<String> Steps;
    private HashMap<String, ArrayList> dslTree;
    private HashMap<String, ArrayList> cableTree;
    private HashMap<String, ArrayList> unityMediaTree;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        Link = testData.getTestData(method.getName() + ".link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "WFET-5854 - GC03 - DSL user - Deeplink to net assistant from help section - Verify that User shall view contact phone number prefilled if available")
    @TmsLink("WFET-5854")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess();
    }

    @Test(description = "WFET-5856 - GC05 - DSL user - Deeplink to net assistant from help section - Verify that User shall be able to enter contact phone number if not available")
    @TmsLink("WFET-5856")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

}