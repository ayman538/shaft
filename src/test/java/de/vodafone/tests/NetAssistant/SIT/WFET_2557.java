package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;


@Epic("Net Assistant")
@Feature("ST")
public class WFET_2557 extends SITNetAssistantSetup {
    //Variables
    private String chatbot_Deeplink;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        chatbot_Deeplink = testData.getTestData(method.getName()+".link");
        super.setup(method);

    }
    @Test(groups={"WFET_2557","regression"})
    @TmsLink("WFET-2569")
    @Description("DSL - Deeplink to Net Assistant Chatbot - Verify Nein Flow appear if massoutage is detected")
    private void SIT_GC01() {

        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage();

        new ChatbotPage(driver)
                .clickOn(ChatbotPage.getNeinButton())
                .validateNeinButtonExists();
    }
    @Test(groups={"WFET_2557","regression"})
    @TmsLink("WFET-2570")
    @Description("Cable - Deeplink to Net Assistant Chatbot - Verify Nein Flow appear if no massoutage is detected")
    private void SIT_GC02() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateNoMassOutageMessage()
                .clickOn(ChatbotPage.getNeinButton())
                .validateNeinButtonExists();

    }

    @Test(groups={"WFET_2557","regression"})
    @TmsLink("WFET-2572")
    @Description("Cable - Deeplink to Net Assistant Chatbot - Verify ja Flow appear if no massoutage is detected")
    private void SIT_GC04() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage()
                .clickOn(ChatbotPage.getJaButton())
                .validateJaButtonExists();

    }
    @Test(groups={"WFET_2557","regression"})
    @TmsLink("WFET-2573")
    @Description("DSL user - Deeplink to Net Assistant Chatbot - Verify Nein Flow appear if massoutage is detected")
    private void SIT_GC05() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage()
                .validateQuestion2Text()
                .clickOn(ChatbotPage.getNeinButton())
                .validateNeinButtonExists();
    }


    @Test(groups={"WFET_2557","regression"})
    @TmsLink("WFET-2574")
    @Description("DSL user - Deeplink to Net Assistant Chatbot - Verify Nein Flow appear if no massoutage is detected")
    private void SIT_GC06() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateNoMassOutageMessage()
                .validateQuestion1Exists()
                .validateQuestion2Text()
                .clickOn(ChatbotPage.getNeinButton())
                .validateNeinButtonExists();
    }


    @Test(groups={"WFET_2557","regression"})
    @TmsLink("WFET-2575")
    @Description("DSL user - Deeplink to Net Assistant Chatbot - Verify Ja Flow appear and Decision Tree Proceeds if massoutage is detected")
    private void SIT_GC07() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage()
                .validateQuestion2Text()
                .clickOn(ChatbotPage.getJaButton())
                .validateJaButtonExists();
    }

    @Test(groups={"WFET_2557","regression"})
    @TmsLink("WFET-2576")
    @Description("DSL user - Deeplink to Net Assistant Chatbot - Verify Ja Flow appear and Decision Tree Proceeds if no massoutage is detected")
    private void SIT_GC08() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateNoMassOutageMessage()
                .validateQuestion2Text()
                .clickOn(ChatbotPage.getJaButton())
                .validateJaMessage();
    }

}

