package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

public class WFET_5194 extends STNetAssistantSetup {

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

    @Test(description = "WFET-5194 - GC1-DSL user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required= true")
    @TmsLink("WFET-5878")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsOptional();
    }
    @Test(description = "WFET-5194 - GC2-DSL user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5879")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsOptional();
    }

    @Test(description = "WFET-5194- GC3-DSL user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5880")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }
    @Test(description = "WFET-5194 - GC4-DSL user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5881")
    public void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }

    @Test(description = "WFET-5194- GC5-DSL user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5882")
    public void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }

    @Test(description = "WFET-5194 -  GC6-DSL user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5883")
    public void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }

    @Test(description = "WFET-5194 - GC7-Cable user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5884")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional();
    }

    @Test(description = "WFET-5194 - GC8-Cable user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5885")
    public void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional();
    }

    @Test(description = "WFET-5194 -  GC9-Cable user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5886")
    public void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }
    @Test(description = "WFET-5194 -  GC10-Cable user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5887")
    public void ST_GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5194 -  GC11-Cable user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5888")
    public void ST_GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5194 - GC12-Cable user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5889")
    public void ST_GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5194 -  GC13-UM user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5890")
    public void ST_GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional();

    }

    @Test(description = "WFET-5194 - GC14-UM user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5891")
    public void ST_GC14() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional();

    }

    @Test(description = "WFET-5194 - GC15-UM user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5892")
    public void ST_GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateJumpBackIsEnabledDSL();

    }

    @Test(description = "WFET-5194 - GC16-UM user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5893")
    public void ST_GC16() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5194 -  GC17-UM user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5894")
    public void ST_GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5194 - GC18-UM user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5895")
    public void ST_GC18() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }
}





