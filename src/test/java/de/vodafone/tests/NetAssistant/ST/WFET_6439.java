package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5794")
public class WFET_6439 extends STNetAssistantSetup {
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

    @Test(description = "WFET-6439 GC01- Deeplink - Validate that Callback form appears successfully and hotline message is no longer appearing")
    @TmsLink("WFET-6536")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateHotLineMsgDoesNotExist()
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "WFET-6439 GC02- MeinVodafone - Validate that Callback form appears successfully and hotline message is no longer appearing")
    @TmsLink("WFET-6537")
    private void GC02() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateHotLineMsgDoesNotExist()
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "WFET-6439 GC03 - Deeplink - Verify CallBack service success when entering valid data")
    @TmsLink("WFET-6538")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateHotLineMsgDoesNotExist()
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "WFET-6439 GC04 - MeinVodafone - Verify CallBack service success when entering valid data")
    @TmsLink("WFET-6539")
    private void GC04() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateHotLineMsgDoesNotExist()
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }


    @Test(description = "WFET-6039 GC05 - Deeplink - Verify user number is prefilled if it is available and returned from the backend")
    @TmsLink("WFET-6540")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateCallbackInputFieldisPrefilled()
                .selectCableCheckbox()
                .submitCableButton()
                .validateCallBackServiceSucess();
    }

    @Test(description = "WFET-6039 GC06 - meinVodafone - Verify user number is prefilled if it is available and returned from the backend")
    @TmsLink("WFET-6541")
    private void GC06() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateCallbackInputFieldisPrefilled()
                .selectCableCheckbox()
                .submitCableButton()
                .validateCallBackServiceSucess();
    }


    @Test(description = "WFET-6439 GC07 - Deeplink - Verify user can change the number that is prefilled and returned from the backend")
    @TmsLink("WFET-6542")
    private void GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "WFET-6439 GC08 - MeinVodafone- Verify user can change the number that is prefilled and returned from the backend")
    @TmsLink("WFET-6543")
    private void GC08() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();
    }

    @Test(description = "WFET-6439 GC09 - Deeplink - Verify that 'Rückruf anfordern' is dimmed when checkbox is not selected")
    @TmsLink("WFET-6544")
    private void GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackFormWithoutCheckBox(phoneNumber)
                .validateRuckrufBtnIsDisabled();
    }

    @Test(description = "WFET-6439 GC10 - MeinVodafone - Verify that 'Rückruf anfordern' is dimmed when checkbox is not selected")
    @TmsLink("WFET-6545")
    private void GC10() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackFormWithoutCheckBox(phoneNumber)
                .validateRuckrufBtnIsDisabled();
    }

    @Test(description = "WFET-6439 GC11 - Deeplink - Verify that 'Rückruf anfordern' is dimmed when mobile number is not entered")
    @TmsLink("WFET-6546")
    private void GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .selectCableCheckbox()
                .validateRuckrufBtnIsDisabled();
    }

    @Test(description = "WFET-6439 GC12 - MeinVodafone - Verify that 'Rückruf anfordern' is dimmed when mobile number is not entered")
    @TmsLink("WFET-6547")
    private void GC12() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .selectCableCheckbox()
                .validateRuckrufBtnIsDisabled();
    }

    @Test(description = "WFET-6439 GC13 - Deeplink - Verify that 'Rückruf anfordern' is dimmed and CL appears when phone number regex is not correct")
    @TmsLink("WFET-6548")
    private void GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackFormWithoutCheckBox(phoneNumber)
                .validateErrorCLWrongNumberFormatEnteredCallBack()
                .validateRuckrufBtnIsDisabled();
    }

    @Test(description = "WFET-6439 GC14 - meinVodafone - Verify that 'Rückruf anfordern' is dimmed and CL appears when phone number regex is not correct")
    @TmsLink("WFET-6549")
    private void GC14() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackFormWithoutCheckBox(phoneNumber)
                .validateRuckrufBtnIsDisabled();
    }
    @Test(description = "WFET-6439 GC15 - Deeplink - Verify CL appears when no number is entered")
    @TmsLink("WFET-6550")
    private void GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickCallBackMobileField()
                .selectCableCheckbox()
                .validateErrorCLNoNumberEnteredCallBack()
                .validateRuckrufBtnIsDisabled();
    }

    @Test(description = "WFET-6439 GC16 - meinVodafone - Verify CL appears when no number is entered")
    @TmsLink("WFET-6551")
    private void GC16() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickCallBackMobileField()
                .selectCableCheckbox()
                .validateErrorCLNoNumberEnteredCallBack()
                .validateRuckrufBtnIsDisabled();
    }

    @Test(description = "WFET-6439 GC17 - Deeplink- Verify error message if 'message' service is returned back with status code '500'")
    @TmsLink("WFET-6552")
    private void GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDecisionTreeErrorPage();
    }

    @Test(description = "WFET-6439 GC18 - MeinVodafone- Verify error message if 'message' service is returned back with status code '500'")
    @TmsLink("WFET-6553")
    private void GC18() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateDecisionTreeErrorPage();
    }
    @Test(description = "WFET-6439 GC19 - Deeplink - Verify error message if callback service is returned back with status code '503'")
    @TmsLink("WFET-6554")
    private void GC19() {

        new NavigationPage(driver)
                .navigateInNewTab(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackForm(phoneNumber)
                .validateDecisionTreeErrorPage();
    }

    @Test(description = "WFET-6439 GC20 - MeinVodafone-Verify error message if callback service is returned back with status code '503'")
    @TmsLink("WFET-6555")
    private void GC20() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackForm(phoneNumber)
                .validateDecisionTreeErrorPage();
    }
}