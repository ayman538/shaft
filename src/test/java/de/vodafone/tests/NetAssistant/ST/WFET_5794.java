package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5794")
public class WFET_5794 extends STNetAssistantSetup {
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

        @Test(description = "GC01 - DSL user - Deeplink to net assistant from help section - Verify that User shall be able to change contact phone number")
    @TmsLink("WFET-5852")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "GC02 - Cable user - Deeplink to net assistant from help section - Verify that User shall be able to change contact phone number")
    @TmsLink("WFET-5853")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "GC03 - DSL user - Deeplink to net assistant from help section - Verify that User shall view contact phone number prefilled if available")
    @TmsLink("WFET-5854")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

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
    @Test(description = "GC04 - Cable user - Deeplink to net assistant from help section - Verify that User shall view contact phone number prefilled if available")
    @TmsLink("WFET-5855")
    private void GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess();
    }

    @Test(description = "GC05 - DSL user - Deeplink to net assistant from help section - Verify that User shall be able to enter contact phone number if not available")
    @TmsLink("WFET-5856")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "GC06 - Cable user - Deeplink to net assistant from help section - Verify that User shall be able to enter contact phone number if not available")
    @TmsLink("WFET-5857")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

}