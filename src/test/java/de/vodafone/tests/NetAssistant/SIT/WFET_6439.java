package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
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
public class WFET_6439 extends SITNetAssistantSetup {
    //Variables
    private String Link;
    private String userName;
    private String userPassword;
    private  HashMap<String,String> cookieSwitcherMap;
    private String phoneNumber;
    private List<String> Steps;
    private HashMap<String, ArrayList> unityMediaTree;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        Link = testData.getTestData(method.getName() + ".link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "WFET-6439 GC03 - Deeplink - Verify CallBack service success when entering valid data")
    @TmsLink("WFET-6538")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);

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
                .navigateInNewTabSIT(Link);

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
                .navigateInNewTabSIT(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackFormWithoutCheckBox(phoneNumber)
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
                .navigateInNewTabSIT(Link);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillCallbackFormWithoutCheckBox(phoneNumber)
                .validateErrorCLWrongNumberFormatEnteredCallBack()
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
                .selectCableCheckbox()
                .validateErrorCLNoNumberEnteredCallBack()
                .validateRuckrufBtnIsDisabled();
    }
}