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
@Story("WFET_5991")
public class WFET_5991 extends SITNetAssistantSetup {

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

    @Test(description = "WFET-6004 - GC2-DSL user -Navigate to netassisstant chatbot through help form-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault")
    @TmsLink("WFET-6004")
    public void SIT_GC02() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validatePreFillGreenFrame();
    }


    @Test(description = "WFET-6007- GC5-Cable user -Deeplink to netassisstant chatbot-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault\"")
    @TmsLink("WFET-6007")
    public void SIT_GC05() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validatePreFill("Test Filled");
    }

    @Test(description = "WFET-6010 - GC8-UM user -Deeplink to netassisstant chatbot-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault\"")
    @TmsLink("WFET-6010")
    public void SIT_GC08() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validatePreFill("Filled Test")
                .validatePreFillGreenFrame();
    }

}





