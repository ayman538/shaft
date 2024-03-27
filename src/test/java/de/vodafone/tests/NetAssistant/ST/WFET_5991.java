package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

public class WFET_5991 extends STNetAssistantSetup {

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

        @Test(description = "WFET-5991 - GC1-DSL user -Deeplink to netassisstant chatbot-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault\"")
    @TmsLink("WFET-6003")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validatePreFill("Filled Test");
    }
    @Test(description = "WFET-5991 - GC2-DSL user -Navigate to netassisstant chatbot through help form-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault")
    @TmsLink("WFET-6004")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validatePreFillGreenFrame();
    }

    @Test(description = "WFET-5991- GC3-DSL user -Deeplink to netassisstant chatbot-Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory")
    @TmsLink("WFET-6005")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory()
                .validateNotPreFilled();
    }
    @Test(description = "WFET-5991 - GC4-DSL user -Deeplink to netassisstant chatbot-Verify that the customer datas empty when Memo-field =empty and filled required= Optional")
    @TmsLink("WFET-6006")
    public void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsOptional()
                .validateNotPreFilled();
    }

    @Test(description = "WFET-5991- GC5-Cable user -Deeplink to netassisstant chatbot-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault\"")
    @TmsLink("WFET-6007")
    public void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validatePreFill("Test Filled");
    }

    @Test(description = "WFET-5991 -  GC6-Cable user -Deeplink to netassisstant chatbot-Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory")
    @TmsLink("WFET-6008")
    public void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory()
                .validateNotPreFilled();
    }

    @Test(description = "WFET-5991 - GC7-Cable user -Deeplink to netassisstant chatbot-Verify that the customer datas empty when Memo-field =empty and filled required= Optional")
    @TmsLink("WFET-6009")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional()
                .validateNotPreFilled();
    }

    @Test(description = "GC8-UM user -Deeplink to netassisstant chatbot-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault\"")
    @TmsLink("WFET-6010")
    public void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validatePreFill("Filled Test")
                .validatePreFillGreenFrame();
    }

    @Test(description = "WFET-5991 -  GC9-UM user -Deeplink to netassisstant chatbot-Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory")
    @TmsLink("WFET-6011")
    public void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory()
                .validateNotPreFilled();

    }
    @Test(description = "GC10-UM user -Deeplink to netassisstant chatbot-Verify that the customer datas empty when Memo-field =empty and filled required= Optional")
    @TmsLink("WFET-6012")
    public void ST_GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional()
                .validateNotPreFilled();

    }
}





