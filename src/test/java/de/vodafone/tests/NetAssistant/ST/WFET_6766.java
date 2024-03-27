package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.*;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_6766")
public class WFET_6766 extends STNetAssistantSetup {
    //Variables
    private String deeplink;
    private String userName;
    private String userPassword;
    private String mobileNumber;
    private HashMap<String, String> cookieSwitcherMap;

    private List<String> Steps;
    private HashMap <String, ArrayList> cableTree;
    private HashMap <String, ArrayList> unityMediaTree;
    private HashMap <String, ArrayList> dslTree;

    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        mobileNumber = testData.getTestData(method.getName() + ".phoneNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "GC01 - UM user - Open Net Assistant via Mein Vodafone SO - Verify that error message is presented if customer didn't fill in mandatory field")
    @TmsLink("WFET-6873")
    private void GC01() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickMandatoryFieldWithoutTyping()
                .validateRedBorderDisplayed()
                .validateErrorCLNoTextEntered();
    }

    @Test(description = "GC03 - VKD user - Open Net Assistant via Mein Vodafone SO - Verify that error message is presented if customer didn't fill in mandatory field")
    @TmsLink("WFET-6875")
    private void GC03() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .clickMandatoryFieldWithoutTyping()
                .validateRedBorderDisplayed()
                .validateErrorCLNoTextEntered();
    }

    @Test(description = "GC04 - UM user - Open Net Assistant via Mein Vodafone SO - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6876")
    private void GC04() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }

    @Test(description = "GC06 - VKD user - Open Net Assistant via Mein Vodafone SO - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6878")
    private void GC06() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }

    @Test(description = "GC07 - UM user - Open Net Assistant via Mein Vodafone SO - Verify that error message appears and border becomes red when customer fill in mandatory field in a correct format then deleted it")
    @TmsLink("WFET-6882")
    private void GC07() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickMandatoryFieldThenDelete()
                .validateRedBorderDisplayed()
                .validateErrorCLNoTextEntered();
    }

    @Test(description = "GC09 - VKD user - Open Net Assistant via Mein Vodafone SO - Verify that error message appears and border becomes red when customer fill in mandatory field in a correct format then deleted it")
    @TmsLink("WFET-6884")
    private void GC09() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickMandatoryFieldThenDelete()
                .validateRedBorderDisplayed()
                .validateErrorCLNoTextEntered();

    }

    @Test(description = "GC10 - UM user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red if customer didn't fill mandatory field")
    @TmsLink("WFET-6886")
    private void GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickMandatoryFieldWithoutTyping()
                .validateRedBorderDisplayed();
    }

    @Test(description = "GC11 - DSL user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red if customer didn't fill mandatory field")
    @TmsLink("WFET-6887")
    private void GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickMandatoryFieldWithoutTyping()
                .validateRedBorderDisplayed();
    }

    @Test(description = "GC12 - VKD user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red if customer didn't fill mandatory field")
    @TmsLink("WFET-6888")
    private void GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .clickMandatoryFieldWithoutTyping()
                .validateRedBorderDisplayed();
    }

    @Test(description = "GC13 - UM user - Deeplink to net assistant chatbot - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6889")
    private void GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }

    @Test(description = "GC14 - DSL user - Deeplink to net assistant chatbot - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6890")
    private void GC14() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }

    @Test(description = "GC15 - VDK user - Deeplink to net assistant chatbot - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6891")
    private void GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }

    @Test(description = "GC16 - UM user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red when customer fill in mandatory field in a correct format then deleted it")
    @TmsLink("WFET-6895")
    private void GC16() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickMandatoryFieldThenDelete()
                .validateRedBorderDisplayed()
                .validateErrorCLNoTextEntered();
    }

    @Test(description = "GC17 - DSL user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red when user fill in mandatory field in a correct format then deleted it")
    @TmsLink("WFET-6896")
    private void GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickMandatoryFieldWithoutTyping()
                .validateRedBorderDisplayed()
                .validateErrorCLNoTextEntered();
    }

    @Test(description = "GC18 - VKD user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red when user fill in mandatory field in a correct format then deleted it")
    @TmsLink("WFET-6897")
    private void GC18() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .typeIntoMandatoryField(mobileNumber)
                .clickMandatoryFieldThenDelete()
                .validateRedBorderDisplayed()
                .validateErrorCLNoTextEntered();
    }
}