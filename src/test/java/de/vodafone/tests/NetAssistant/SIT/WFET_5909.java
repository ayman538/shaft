package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
@Story("WFET_5909")
public class WFET_5909 extends SITNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String helpForm;
    private String deeplink;
    private String tokenLink;
    private String contractNumber;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        helpForm=testData.getTestData(method.getName()+".helpform");
        deeplink=testData.getTestData(method.getName()+".link");
        tokenLink=testData.getTestData(method.getName()+".tokenLink");
        contractNumber=testData.getTestData(method.getName()+".contractNumber");
        super.setup(method);
    }
    @Test(description = "WFET-6050-GC1-Non logged in DSL user -Navigate to netassisstant chatbot through help form-Verify that three new buttons displayed for welcome page of netassisstant chatbot")
    @TmsLink("WFET-6050")
    private void SIT_GC01() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateWelcomeMessageAppears()
                .validateLoginButtonExist()
                .validateRegisterButtonExist()
                .validateNeinButtonExist();
    }

    @Test(description = "WFET-6051-GC2-Non logged in Cable user -Navigate to netassisstant chatbot through help form-Verify that three new buttons displayed for welcome page of netassisstant chatbot")
    @TmsLink("WFET-6051")
    private void SIT_GC02() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateWelcomeMessageAppears()
                .validateLoginButtonExist()
                .validateRegisterButtonExist()
                .validateNeinButtonExist();
    }

    @Test(description = "WFET-6052-GC3-Non logged in DSL user -Navigate to netassisstant chatbot through help form-Verify redirection of 1st button \"Ich möchte mich einloggen\"")
    @TmsLink("WFET-6052")
    private void SIT_GC03() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateWelcomeMessageAppears()
                .validateLoginButtonExist()
                .clickOnLoginButton()
                .validateNavigateToLoginPage();
    }

    @Test(description = "WFET-6053GC4-Non logged in cable user -Navigate to netassisstant chatbot through help form-Verify redirection of 1st button \"Ich möchte mich einloggen\"")
    @TmsLink("WFET-6053")
    private void SIT_GC04() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateWelcomeMessageAppears()
                .validateLoginButtonExist()
                .clickOnLoginButton()
                .validateNavigateToLoginPage();
    }

    @Test(description = "WFET-6054-GC5-Non logged in DSL user -Navigate to netassisstant chatbot through help form-Verify redirection of 2nd button \"Ich möchte mich registrieren\"")
    @TmsLink("WFET-6054")
    private void SIT_GC05() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateLoginButtonExist()
                .validateRegisterButtonExist()
                .validateWelcomeMessageAppears()
                .clickOnRegisterButton()
               // .switchToTab()
                .validateRegisterPage();
    }

    @Test(description = "WFET-6055-GC6-Non logged in cable user -Navigate to netassisstant chatbot through help form-Verify redirection of 2nd button \"Ich möchte mich registrieren\"")
    @TmsLink("WFET-6055")
    private void SIT_GC06() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateLoginButtonExist()
                .validateRegisterButtonExist()
                .validateWelcomeMessageAppears()
                .clickOnRegisterButton()
              //  .switchToTab()
                .validateRegisterPage();

    }

    @Test(description = " WFET-6056-GC7-Non logged in DSL user -Navigate to netassisstant chatbot through help form-Verify redirection of 3nd button \"Nein\"")
    @TmsLink("WFET-6056")
    private void SIT_GC07() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateWelcomeMessageAppears()
                .validateNeinButtonExist()
                .clickOnNeinButton()
                .validateThanksMsgForNeinFlow()
                .validate1stHyperlinkForThanksMsg()
                .validate2ndHyperlinkForThanksMsg()
                .validateRefreshButton();
    }

    @Test(description = "WFET-6057-GC8-Non logged in Cable user -Navigate to netassisstant chatbot through help form-Verify redirection of 3nd button \"Nein\"")
    @TmsLink("WFET-6057")
    private void SIT_GC08() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateWelcomeMessageAppears()
                .validateNeinButtonExist()
                .clickOnNeinButton()
                .validateThanksMsgForNeinFlow()
                .validate1stHyperlinkForThanksMsg()
                .validate2ndHyperlinkForThanksMsg()
                .validateRefreshButton();
    }

    @Test(description = "WFET-6058- GC9-Non logged in DSL user -Navigate to netassisstant chatbot through help form-Verify redirection of two hyperlinks displayed at thanks message")
    @TmsLink("WFET-6058")
    private void SIT_GC09() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateNeinButtonExist()
                .clickOnNeinButton()
                .validateThanksMsgForNeinFlow()
                .validate1stHyperlinkForThanksMsg()
                .validateWelcomeMessageAppears()
                .click1stHyperlink()
             //   .switchToTab()
                .validateForgetLoginDataPage();

    }

    @Test(description = "WFET-6059- GC10-Non logged in cable user -Navigate to netassisstant chatbot through help form-Verify redirection of two hyperlinks displayed at thanks message")
    @TmsLink("WFET-6059")
    private void SIT_GC10() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateInNewTabSIT(helpForm)
                .validateNeinButtonExist()
                .clickOnNeinButton()
                .validateThanksMsgForNeinFlow()
                .validate2ndHyperlinkForThanksMsg()
                .validateWelcomeMessageAppears()
                .click2ndHyperlink()
               // .switchToTab()
                .validateHelpLoginPage();

    }
}