package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
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
@Story("WFET_5511")
public class WFET_5741 extends SITNetAssistantSetup {
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
    @Test(description = "GC04 - DSL user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5913")
    private void SIT_GC04() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateNaImageIsNotVisible()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible();

    }

    @Test(description = "GC05 - Cable user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5914")
    private void SIT_GC05() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateNaImageIsNotVisible()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible();
    }

    @Test(description = "GC07 - DSL user - When user navigates to Net Assistant via SO he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5916")
    private void SIT_GC07() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);

        new DashboardPage(driver)
                .getDSLSO()
                .switchToTabByIndex(1);

        new ChatbotPage(driver)
                .clickChatbotHeaderButton()
                .validateNaImageIsNotVisible();
    }
    @Test(description = "GC08 - Cable user - When user navigates to Net Assistant via SO he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5917")
    private void SIT_GC08() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);

        new DashboardPage(driver)
                .getCableSO(contractNumber)
                .switchToTabByIndex(1);

        new ChatbotPage(driver)
                .validateNaImageIsNotVisible();

    }

    @Test(description = "GC09 - UM user - When user navigates to Net Assistant via SO he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5918")
    private void SIT_GC09() {

        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword);

        new DashboardPage(driver)
                .expandContractTileUM(contractNumber)
                .getUmSOSIT(contractNumber)
                .switchToTabByIndex(1);

        new ChatbotPage(driver)
                .validateNaImageIsNotVisible();
    }

    @Test(description = "GC13 - DSL user - When non logged in user navigates to Net Assistant via helpform he should see the banner removed and CL for mint authentication")
    @TmsLink("WFET-5982")
    private void SIT_GC13() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateSIT(deeplink)
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNaImageIsNotVisible();
    }

    @Test(description = "GC14 - Cable user - When non logged in user navigates to Net Assistant via helpform he should see the banner removed and CL for mint authentication")
    @TmsLink("WFET-5983")
    private void SIT_GC14() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateSIT(deeplink)
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNaImageIsNotVisible();
    }

    @Test(description = "GC15 - UM user - When non logged in user navigates to Net Assistant via helpform he should see the banner removed and CL for mint authentication")
    @TmsLink("WFET-5984")
    private void SIT_GC15() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateSIT(deeplink)
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNaImageIsNotVisible();
    }

    @Test(description = "GC16 - DSL user - When non logged in user navigates to Net Assistant via deeplink should see the banner removed and CL for mint authentication")
    @TmsLink("WFET-5985")
    private void SIT_GC16() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateSIT(deeplink)
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNaImageIsNotVisible();
    }

    @Test(description = "GC17 - Cable user - When non logged in user navigates to Net Assistant via deeplink should see the banner removed and CL for mint authentication")
    @TmsLink("WFET-5986")
    private void SIT_GC17() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigateSIT(deeplink)
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateNaImageIsNotVisible();
    }

}