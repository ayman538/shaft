package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5140")
public class WFET_5140 extends STNetAssistantSetup {

    private String userName;
    private String password;
    private String deeplink;
    private String text;
    private String option;
    private String mobileNO;
    private String postalCode;
    private String familyName;
    private String customerId;
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
        text = testData.getTestData(method.getName() + ".text");
        option= testData.getTestData(method.getName() + ".option");
        postalCode = testData.getTestData(method.getName() + ".postalCode");
        familyName= testData.getTestData(method.getName() + ".familyName");
        customerId= testData.getTestData(method.getName() + ".customerId");
        mobileNO= testData.getTestData(method.getName() + ".mobileNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, password);
    }
    @Test(description = "WFET-6262: GC01 - UM user -Deeplink to Netassisstant chatbot through help form- Verify that the option picker displayed when there is 3options or less in decision tree after switch between tabs\"chatbot-tickets\"")
    @TmsLink("WFET-6262")
    public void GC01() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateOptionPickerExists()
                .selectOptionPicker(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSameOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6263: GC02 - cable user -Deeplink to Netassisstant chatbot through help form- Verify that the option picker displayed when there is 3options or less in decision tree after switch between tabs\"chatbot-tickets\"")
    @TmsLink("WFET-6263")
    public void GC02() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateOptionPickerExists()
                .selectOptionPicker(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSameOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6264: GC03 - DSL user -Deeplink to Netassisstant chatbot through help form- Verify that the option picker displayed when there is 3options or less in decision tree after switch between tabs\"chatbot-tickets\"")
    @TmsLink("WFET-6264")
    public void GC03() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateOptionPickerExists()
                .selectOptionPicker(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSameOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6265: GC04 - UM user -MeineVodafone SO- Verify that the option picker displayed when there is 3options or less in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6265")
    public void GC04() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateOptionPickerExists()
                .selectOptionPicker(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSameOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6266: GC05 - cable user -MeineVodafone SO- Verify that the option picker displayed when there is 3options or less in decision tree after switch between tabs\"chatbot-tickets\"")
    @TmsLink("WFET-6266")
    public void GC05() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateOptionPickerExists()
                .selectOptionPicker(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSameOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6267: GC06 - DSL user -MeineVodafone SO- Verify that the option picker displayed when there is 3options or less in decision tree after switch between tabs\"chatbot-tickets\"")
    @TmsLink("WFET-6267")
    public void GC06() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateOptionPickerExists()
                .selectOptionPicker(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSameOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6268-GC07 - UM user -Deeplink to Netassisstant chatbot through help form- Verify that the drop down displayed when more than 3options in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6268")
    public void GC07() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .selectdropDownOption(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSamedropDownOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6269: GC08 - Cable user -Deeplink to Netassisstant chatbot through help form- Verify that the drop down displayed when more than 3options in decision tree after switch between tickets-chatbot tabs")
    @TmsLink("WFET-6269")
    public void GC08() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .selectdropDownOption(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSamedropDownOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6270: GC08 - DSL user -Deeplink to Netassisstant chatbot through help form- Verify that the drop down displayed when more than 3options in decision tree after switch between tickets-chatbot tabs")
    @TmsLink("WFET-6270")
    public void GC09() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .selectdropDownOption(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSamedropDownOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6268-GC07 - UM user -Deeplink to Netassisstant chatbot through help form- Verify that the drop down displayed when more than 3options in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6268")
    public void GC10() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .selectdropDownOption(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSamedropDownOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6269: GC08 -Cable User- MeineVodafone SO -Verify that the drop down displayed when more than 3options in decision tree after switch between tickets-chatbot tabs")
    @TmsLink("WFET-6269")
    public void GC11() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .selectdropDownOption(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSamedropDownOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6270: GC12 - DSL user -MeineVodafone SO- Verify that the drop down displayed when more than 3options in decision tree after switch between tickets-chatbot tabs")
    @TmsLink("WFET-6270")
    public void GC12() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .selectdropDownOption(option)
                .typeIntoFormularOneColumnText(text)
                .clickFetrigBtn()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateSamedropDownOptionSelected(option)
                .validateSameTextDisplayed(text)
                .validateFetrigBtnEnabled();
    }
    @Test(description = "WFET-6274: GC13-DSL user -Navigate to netassisstant chatbot through help form-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6274")
    public void GC13() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validatePreFillGreenFrame()
                .validatecheckBoxIsSelected()
                .validateCallBackServiceSucess();
    }
    @Test(description = "WFET-6275: GC14- Cable user -Navigate to netassisstant chatbot through help form-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6275")
    public void GC14() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validatePreFillGreenFrame()
                .validatecheckBoxIsSelected()
                .validateCallBackServiceSucess();
    }
    @Test(description = "WFET-6276: GC15-UM user -Navigate to netassisstant chatbot through help form-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6276")
    public void GC15() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validatePreFillGreenFrame()
                .validatecheckBoxIsSelected()
                .validateCallBackServiceSucess();
    }
    @Test(description = "WFET-6277: GC13- DSL user -MeineVodafone SO -Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6277")
    public void GC16() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validatePreFillGreenFrame()
                .validatecheckBoxIsSelected()
                .validateCallBackServiceSucess();
    }
    @Test(description = "WFET-6278: GC17- Cable user -MeineVodafone SO -Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6278")
    public void GC17() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validatePreFillGreenFrame()
                .validatecheckBoxIsSelected()
                .validateCallBackServiceSucess();
    }
    @Test(description = "WFET-6279: GC18-UM user -MeineVodafone SO-Verify that the customer datas already filled in black letters with a green frame when Memo-field \"Memo_Einseitendefault in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6279")
    public void GC18() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateCallbackInputFieldisPrefilled()
                .selectDSLCheckboxST()
                .submitDSLButton()
                .validateCallBackServiceSucess()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validatePreFillGreenFrame()
                .validatecheckBoxIsSelected()
                .validateCallBackServiceSucess();
    }
    @Test(description = "WFET-6280: GC19-DSL user -Deeplink to netassisstant chatbot through help form-Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6280")
    public void GC19() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists().clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateFormularOneColumnInputFieldExists()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFormularFieldEmpty();
    }
    @Test(description = "WFET-6281: GC20- Cable user -Deeplink to netassisstant chatbot through help form-Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6281")
    public void GC20() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateFormularOneColumnInputFieldExists()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFormularFieldEmpty();
    }
    @Test(description = "WFET-6282: GC21- UM user -Deeplink to netassisstant chatbot through help form-Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6282")
    public void GC21() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateFormularOneColumnInputFieldExists()
                .validateTextIsMandatory()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFormularFieldEmpty()
                .validateTextIsMandatory();
    }
    @Test(description = "WFET-6283: GC22-DSL user - MeineVodafone SO -Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6283")
    public void GC22() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateFormularOneColumnInputFieldExists()
                .validateTextIsMandatory()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFormularFieldEmpty()
                .validateTextIsMandatory();
    }
    @Test(description = "WFET-6284: GC23- Cable user - MeineVodafone SO -Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6284")
    public void GC23() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateFormularOneColumnInputFieldExists()
                .validateTextIsMandatory()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFormularFieldEmpty()
                .validateTextIsMandatory();
    }
    @Test(description = "WFET-6285: GC24- UM user - MeineVodafone SO -Verify that the customer datas empty when Memo-field =empty and filled required= Mandatory in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6285")
    public void GC24() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateFormularOneColumnInputFieldExists()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFormularFieldEmpty();
    }
    @Test(description = "WFET-6286: GC25-DSL user -Deeplink to netassisstant chatbot through help form-Verify that the customer datas empty when Memo-field =empty and filled required= Optional in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6286")
    public void GC25() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsOptional()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateOptionalFieldEmptyDSL();
    }
    @Test(description = "WFET-6287: GC26- Cable user -Deeplink to netassisstant chatbot through help form-Verify that the customer datas empty when Memo-field =empty and filled required= Optional in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6287")
    public void GC26() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateOptionalFieldEmptyCableUM();
    }
    @Test(description = "WFET-6288: GC27- UM user -Deeplink to netassisstant chatbot through help form-Verify that the customer datas empty when Memo-field =empty and filled required= Optional in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6288")
    public void GC27() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsOptional()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateOptionalFieldEmptyCableUM();
    }
    @Test(description = "WFET-6289: GC28-DSL user - MeineVodafone SO -Verify that the customer datas empty when Memo-field =empty and filled required= Optional in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6289")
    public void GC28() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , dslTree)
                .validateTextIsOptional()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateOptionalFieldEmptyDSL();
    }
    @Test(description = "WFET-6290: GC29- Cable user - MeineVodafone SO -Verify that the customer datas empty when Memo-field =empty and filled required= Optional in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6290")
    public void GC29() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , cableTree)
                .validateTextIsOptional()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateOptionalFieldEmptyCableUM();
    }
    @Test(description = "WFET-6291: GC30- UM user - MeineVodafone SO -Verify that the customer datas empty when Memo-field =empty and filled required= Optional in decision tree after switch between tabs\"chatbot")
    @TmsLink("WFET-6291")
    public void GC30() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps , unityMediaTree)
                .validateTextIsOptional()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateOptionalFieldEmptyCableUM();
    }
    @Test(description = "WFET-6292: GC31-DSL user -Navigate to netassisstant chatbot through Help form-Verify that the previous answers in the dialogue are disabled when parameter APIHub BackJumps allowed = No in decision tree after switch between tabs chatbot-tickets")
    @TmsLink("WFET-6292")
    private void GC31() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(mobileNO)
                .validateCallBackServiceSucess()
                .validateJumpBackIsDimmed(Steps.size())
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateJumpBackIsDimmed(Steps.size())
                .validateSameMobileNoCallbackDisplayed(mobileNO);
    }
    @Test(description = "WFET-6293: GC32- DSL user - MeineVodafone SO -Verify that the previous answers in the dialogue are disabled when parameter APIHub BackJumps allowed = No in decision tree after switch between tabs chatbot-tickets")
    @TmsLink("WFET-6293")
    private void GC32() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(mobileNO)
                .validateCallBackServiceSucess()
                .validateJumpBackIsDimmed(Steps.size())
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateJumpBackIsDimmed(Steps.size())
                .validateSameMobileNoCallbackDisplayed(mobileNO);
    }
    @Test(description = "WFET-6294: GC33-DSL user - Deeplink to netassisstant chatbot -Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed = Yes in decision tree after switch between tickets-chatbot tabs")
    @TmsLink("WFET-6294")
    private void GC33() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsNotDimmed(Steps.size())
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateJumpBackIsNotDimmed(Steps.size());
    }
    @Test(description = "WFET-6295 -GC34- DSL user - MeineVodafone SO -Verify that the previous answers in the dialogue are enabled when parameter APIHub BackJumps allowed = Yes in decision tree after switch between tickets-chatbot tabs")
    @TmsLink("WFET-6295")
    private void GC34() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateJumpBackIsNotDimmed(Steps.size())
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateJumpBackIsNotDimmed(Steps.size());
    }
    @Issue("WFET-7533")
    @Test(description = "WFET-6296: GC35-DSL user -Navigate to netassisstant chatbot through help form-Verify that MIC form backed up when switch from tickets tab to chatbot tab")
    @TmsLink("WFET-6296")
    private void GC35() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillThreeParametersMicForm(familyName,postalCode,customerId)
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFamilyNameSavedMicForm(familyName)
                .validatePostalCodeSavedMicForm(postalCode)
                .validateCustomerIDSavedMicForm(customerId);
    }
    @Test(description = "WFET-6297: GC36-DSL user -Navigate to netassisstant chatbot through meinvodafone dashboard-Verify that MIC form backed up when switch from tickets tab to chatbot tab")
    @TmsLink("WFET-6297")
    private void GC36() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillTwoParametersMicForm(familyName,postalCode)
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateFamilyNameSavedMicForm(familyName)
                .validatePostalCodeSavedMicForm(postalCode);
    }
    @Test(description ="WFET-6298: GC37-DSL user -Deeplink to netassisstant chatbot-Verify that wait template backed up when switch from tickets tab to chatbot tab")
    @TmsLink("WFET-6298")
    private void GC37(){
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateWaitFormFinished()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWaitFormFinished();
    }
    @Test(description ="WFET-6301: GC38- DSL user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when refresh the page")
    @TmsLink("WFET-6301")
    private void GC38() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg()
                .refreshPage()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();
    }
    @Test(description ="WFET-6302: GC39- Cable user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when refresh the page")
    @TmsLink("WFET-6302")
    private void GC39() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .refreshPage()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6303: GC40- UM user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when refresh the page")
    @TmsLink("WFET-6303")
    private void GC40() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .refreshPage()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6304: GC41- DSL user - MeineVodafone SO -Verify that decision tree reset & mass outage check should be performed again when refresh the page")
    @TmsLink("WFET-6304")
    private void GC41() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg()
                .refreshPage()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();
    }
    @Test(description ="WFET-6305: GC42- Cable user - MeineVodafone SO -Verify that decision tree reset & mass outage check should be performed again when refresh the page")
    @TmsLink("WFET-6305")
    private void GC42() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .refreshPage()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6306: GC43- UM user - MeineVodafone SO -Verify that decision tree reset & mass outage check should be performed again when refresh the page")
    @TmsLink("WFET-6306")
    private void GC43() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .refreshPage()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6307: GC44- DSL user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when logout and login again with the same user")
    @TmsLink("WFET-6307")
    private void GC44() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg()
                .logout();
        new LoginPage(driver).navigateST().loginST(userName,password);
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();
    }
    @Test(description ="WFET-6308: GC45- Cable user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when logout and login again with the same user")
    @TmsLink("WFET-6308")
    private void GC45() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .logout();
        new LoginPage(driver).navigateST().loginST(userName,password);
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6309: GC46- UM user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when logout and login again with the same user")
    @TmsLink("WFET-6309")
    private void GC46() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .logout();
        new LoginPage(driver).navigateST().loginST(userName,password);
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6310: GC47- DSL user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when deeplink to same user at new browser tab")
    @TmsLink("WFET-6310")
    private void GC47() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateMassOutageMessage()
                .validateNewMassOutageMsg()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageMessage()
                .validateNewMassOutageMsg();
    }
    @Test(description ="WFET-6311: GC48- Cable user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when deeplink to same user at new browser tab")
    @TmsLink("WFET-6311")
    private void GC48() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6312: GC49- UM user -Deeplink to netassisstant chatbot -Verify that decision tree reset & mass outage check should be performed again when deeplink to same user at new browser tab")
    @TmsLink("WFET-6312")
    private void GC49() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateMassOutageUMCable();
    }
    @Test(description ="WFET-6314: GC50-DSL user -Deeplink to netassisstant chatbot- Verify that the Timer in decision tree still count when switch between tabs")
    @TmsLink("WFET-6314")
    private void GC50(){
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateTimerComponent()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateTimerComponent();
    }
    @Test(description ="WFET-6315: GC51- Cable user -Deeplink to netassisstant chatbot- Verify that the Timer in decision tree still count when switch between tabs")
    @TmsLink("WFET-6315")
    private void GC51(){
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateTimerComponent()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateTimerComponent();
    }
    @Test(description ="WFET-6316: GC52- UM user -Deeplink to netassisstant chatbot- Verify that the Timer in decision tree still count when switch between tabs")
    @TmsLink("WFET-6316")
    private void GC52(){
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateTimerComponent()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateTimerComponent();
    }
    @Test(description = "WFET-6749: GC53 -Cable user -Deeplink to Netassisstant chatbot through Meinvodafone- Verify CallBack service success when entering valid data after switch between tabs\"chatbot")
    @TmsLink("WFET-6749")
    public void GC53() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateCallbackInputFieldisPrefilled()
                .selectCableCheckbox()
                .submitDSLButton()
                .validateCallBackServiceSucess()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validatePreFillGreenFrame()
                .validatecheckBoxIsSelected();
    }
}






