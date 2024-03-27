package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

public class WFET_6170 extends SITNetAssistantSetup {

    private String userName;
    private String password;
    private String deeplink;
    private String mobileNumber;
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
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");

        super.setup(method);
    }

    @Test
    public void SIT_GC01() {
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree);

    }

    @Test
    public void SIT_GC02() {
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test
    public void SIT_GC03() {
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillCallbackForm(mobileNumber)
                .validateCallBackServiceSucess();

    }

    @Test
    public void SIT_GC04() {
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , unityMediaTree);
    }
    @Test
    public void SIT_GC05() {
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree);

    }
}





