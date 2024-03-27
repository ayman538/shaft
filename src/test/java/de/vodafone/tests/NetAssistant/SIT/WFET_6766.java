package de.vodafone.tests.NetAssistant.SIT;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.*;

@Epic("Net Assistant")
@Feature("SIT")
@Story("WFET_6766")
public class WFET_6766 extends SITNetAssistantSetup {
    private String userName;
    private String userPassword;
    private String link;
    private String mobileNumber;
    private HashMap<String, String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap <String, ArrayList> cableTree;
    private HashMap <String, ArrayList> unityMediaTree;
    private HashMap <String, ArrayList> dslTree;
    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        link = testData.getTestData(method.getName() + ".link");
        mobileNumber = testData.getTestData(method.getName() + ".phoneNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }
    @Test(description = "WFET-6874: GC02 - DSL user - Open Net Assistant via Mein Vodafone SO - Verify that error message is presented if customer didn't fill in mandatory field")
    @TmsLink("WFET-6874")
    private void GC02() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickMandatoryFieldWithoutTypingSIT()
                .validateRedBorderDisplayedSIT()
                .validateErrorCLNoTextEnteredSIT();
    }
    @Test(description = "WFET-6877: GC05 - DSL user - Open Net Assistant via Mein Vodafone SO - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6877")
    private void GC05() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .typeIntoMandatoryFieldSIT(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }
    @Test(description = "WFET-6878: GC06 - VKD user - Open Net Assistant via Mein Vodafone SO - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6878")
    private void GC06() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .typeIntoMandatoryFieldSIT(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }
    @Test(description = "WFET-6883: GC08 - DSL user - Open Net Assistant via Mein Vodafone SO - Verify that error message appears and border becomes red when customer fill in mandatory field in a correct format then deleted it")
    @TmsLink("WFET-6883")
    private void GC08() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .typeIntoMandatoryFieldSIT(mobileNumber)
                .clickMandatoryFieldThenDeleteSIT()
                .validateRedBorderDisplayedSIT()
                .validateErrorCLNoTextEnteredSIT();
    }
    @Test(description = "WFET-6884: GC09 - VKD user - Open Net Assistant via Mein Vodafone SO - Verify that error message appears and border becomes red when customer fill in mandatory field in a correct format then deleted it")
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
                .typeIntoMandatoryFieldSIT(mobileNumber)
                .clickMandatoryFieldThenDeleteSIT()
                .validateRedBorderDisplayedSIT()
                .validateErrorCLNoTextEnteredSIT();
    }
    @Test(description = "WFET-6886: GC10 - UM user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red if customer didn't fill mandatory field")
    @TmsLink("WFET-6886")
    private void GC10() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickMandatoryFieldWithoutTypingSIT()
                .validateRedBorderDisplayedSIT()
                .validateErrorCLNoTextEnteredSIT();
    }
    @Test(description = "GC11 - DSL user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red if customer didn't fill mandatory field")
    @TmsLink("WFET-6887")
    private void GC11() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickMandatoryFieldWithoutTypingSIT()
                .validateRedBorderDisplayedSIT()
                .validateErrorCLNoTextEnteredSIT();
    }
    @Test(description = "WFET-6886: GC12 - VKD user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red if customer didn't fill mandatory field")
    @TmsLink("WFET-6886")
    private void GC12() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .clickMandatoryFieldWithoutTypingSIT()
                .validateRedBorderDisplayedSIT()
                .validateErrorCLNoTextEnteredSIT();
    }
    @Test(description = "WFET-6889: GC13 - UM user - Deeplink to net assistant chatbot - Verify that border becomes green if customer fill mandatory fields in correct format")
    @TmsLink("WFET-6889")
    private void GC13() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .typeIntoMandatoryFieldSIT(mobileNumber)
                .clickSubmitMandatoryFieldButton();
    }
    @Test(description = "WFET-6895: GC16 - UM user - Deeplink to net assistant chatbot - Verify that error message appears and border becomes red when customer fill in mandatory field in a correct format then deleted it")
    @TmsLink("WFET-6895")
    private void GC16() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .typeIntoMandatoryFieldSIT(mobileNumber)
                .clickMandatoryFieldThenDeleteSIT()
                .validateRedBorderDisplayedSIT()
                .validateErrorCLNoTextEnteredSIT();
    }
}