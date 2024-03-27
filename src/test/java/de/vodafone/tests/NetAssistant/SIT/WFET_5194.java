package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.tests.NetAssistant.ST.STNetAssistantSetup;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WFET_5194 extends SITNetAssistantSetup {

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

    @Test(description = "WFET-5878 - GC1-DSL user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required= true")
    @TmsLink("WFET-5878")
    public void SIT_GC01() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsOptional();
    }
    @Test(description = "WFET-5879 - GC2-DSL user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5879")
    public void SIT_GC02() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsOptional();
    }

    @Test(description = "WFET-5880- GC3-DSL user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5880")
    public void SIT_GC03() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }
    @Test(description = "WFET-5881 - GC4-DSL user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5881")
    public void SIT_GC04() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }

    @Test(description = "WFET-5882- GC5-DSL user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5882")
    public void SIT_GC05() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }

    @Test(description = "WFET-5194 -  GC6-DSL user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5883")
    public void SIT_GC06() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsMandatory();
    }

    @Test(description = "WFET-5884 - GC7-Cable user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5884")
    public void SIT_GC07() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional();
    }

    @Test(description = "WFET-5885 - GC8-Cable user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5885")
    public void SIT_GC08() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional();
    }

    @Test(description = "WFET-5886 -  GC9-Cable user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5886")
    public void SIT_GC09() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }
    @Test(description = "WFET-5887 -  GC10-Cable user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5887")
    public void SIT_GC10() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5888 -  GC11-Cable user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5888")
    public void SIT_GC11() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5889 - GC12-Cable user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5889")
    public void SIT_GC12() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5890 -  GC13-UM user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5890")
    public void SIT_GC13() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsOptional();

    }

    @Test(description = "WFET-5891 - GC14-UM user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required= \"true\"")
    @TmsLink("WFET-5891")
    public void SIT_GC14() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsOptional();

    }

    @Test(description = "WFET-5892 - GC15-UM user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5892")
    public void SIT_GC15() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5893 - GC16-UM user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is mandatory when parameter Memo_field_not_required= \"false\"")
    @TmsLink("WFET-5893")
    public void SIT_GC16() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5894 -  GC17-UM user -Deeplink to netassisstant chatbot-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5894")
    public void SIT_GC17() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsMandatory();

    }

    @Test(description = "WFET-5895 - GC18-UM user -Navigate to netassisstant chatbot through help form-Verify that phone field and reason field is optional when parameter Memo_field_not_required is not returned")
    @TmsLink("WFET-5895")
    public void SIT_GC18() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsMandatory();

    }
}





