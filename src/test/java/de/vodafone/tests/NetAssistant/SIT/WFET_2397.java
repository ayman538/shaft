package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WFET_2397 extends SITNetAssistantSetup {

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
        loginSITAction();
    }
    private void loginSITAction()
    {
        new LoginPage(driver)
                .navigateSIT()
                .setCookieSwitchers(cookieSwitcherMap)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();
    }

    @Test(description = "WFET-2397 - SIT - GC01 - Cable user - Deeplink to Net Assistant Chatbot - Verify \"Nein\" Flow appear if massoutage is detected")
    @TmsLink("WFET-2507")
    public void SIT_GC01() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnNetzAssistentVerlassenBtn()
                .validateNeinMessageAppears();
    }
    @Test(description = "WFET-2397 - SIT - GC02 - Cable user - Deeplink to Net Assistant Chatbot - Verify \"Nein\" Flow appear if no massoutage is detected")
    @TmsLink("WFET-2508")
    public void SIT_GC02() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnNetzAssistentVerlassenBtn()
                .validateNeinMessageAppears();
    }

    @Test(description = "WFET-2397 - SIT - GC04 - Cable user - Deeplink to Net Assistant Chatbot - Verify \"Ja\" Flow appear and Decision Tree Proceeds if no massoutage is detected")
    @TmsLink("WFET-2510")
    public void SIT_GC03() {

                new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , cableTree);
    }

    @Test(description = "WFET-2397 - SIT - GC06 - DSL user - Deeplink to Net Assistant Chatbot - Verify \"Nein\" Flow appear if no massoutage is detected")
    @TmsLink("WFET-2512")
    public void SIT_GC04() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnNetzAssistentVerlassenBtn()
                .validateNeinMessageAppears();

    }

    @Test(description = "WFET-2397 - SIT - GC08 - DSL user - Deeplink to Net Assistant Chatbot - Verify \"Ja\" Flow appear and Decision Tree Proceeds if no massoutage is detected")
    @TmsLink("WFET-2514")
    public void SIT_GC05() {

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .validateNoMassOutageMessage()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
        List x;
        x = driver.getDriver().findElements(By.id("chatbot-container"));
        for(int i=0;i<x.size();i++)
            System.out.println("list items : "+ x.get(i));


    }

}





