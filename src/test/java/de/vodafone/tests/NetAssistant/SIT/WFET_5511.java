package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

import static de.vodafone.pages.NetAssistant.DashboardPage.getContractByName;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_5511 extends SITNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String loginDeepLink;
    private String Link;
    private String contractNum;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        Link = testData.getTestData(method.getName()+".Link");
        contractNum=testData.getTestData(method.getName()+".contractNumber");
        super.setup(method);
    }

    @Test(description="GC01 - DSL user - Verify that logged in user can access net assistant using helpform")
    @TmsLink("WFET-5615")
    private void GC01() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT()
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .navigateSIT(Link)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();

    }

    @Test(description="GC02 - Cable user - Verify that logged in user can access net assistant using helpform")
    @TmsLink("WFET-5616")
    private void GC02() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT()
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .navigateSIT(Link)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();

    }

    @Test(description="GC03 - UM user - Verify that logged in user can access net assistant using helpform")
    @TmsLink("WFET-5617")
    private void GC03() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT()
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .navigateSIT(Link)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();
    }


    @Test(description="GC04 - DSL user - Verify that navigating to net assistant with non-logged in user requires mint authentication")
    @TmsLink("WFET-5620")
    private void GC04() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnYaButtonFlow();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum))
                .validateErrorIconDisplayed();

        new ChatbotPage(driver)
                .validateMassOutageMessage();

    }

    @Test(description="GC05 - Cable user - Verify that navigating to net assistant with non-logged in user requires mint authentication")
    @TmsLink("WFET-5621")
    private void GC05() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnYaButtonFlow();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();

    }

    @Test(description="GC06 - UM user - Verify that navigating to net assistant with non-logged in user requires mint authentication")
    @TmsLink("WFET-5622")
    private void GC06() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnYaButtonFlow();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();

    }

    @Test(description="GC07 - DSL user - Verify that navigating to net assistant with non-logged in user and decline login will display thank you message")
    @TmsLink("WFET-5625")
    private void GC07() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnNeinButtonFlow()
                .validateEndMessageAppears();

    }

    @Test(description="GC08 - Cable user - Verify that navigating to net assistant with non-logged in user and decline login will display thank you message")
    @TmsLink("WFET-5631")
    private void GC08() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnNeinButtonFlow()
                .validateEndMessageAppears();

    }

    @Test(description="GC09 - UM user - Verify that navigating to net assistant with non-logged in user and decline login will display thank you message")
    @TmsLink("WFET-5632")
    private void GC09() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnNeinButtonFlow()
                .validateEndMessageAppears();

    }

    @Test(description="DSL user - Verify that navigating to net assistant with non-logged in user and decline login then he will not be able to show his tickets")
    @TmsLink("WFET-5634")
    private void GC10() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnNeinButtonFlow()
                .validateEndMessageAppears()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsIsNotShown();

        new ChatbotPage(driver)
                .validateRedirectionToLogin();


    }

    @Test(description="Cable user - Verify that navigating to net assistant with non-logged in user and decline login then he will not be able to show his tickets")
    @TmsLink("WFET-5636")
    private void GC11() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnNeinButtonFlow()
                .validateEndMessageAppears()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsIsNotShown();

        new ChatbotPage(driver)
                .validateRedirectionToLogin();


    }

    @Test(description="UM user - Verify that navigating to net assistant with non-logged in user and decline login then he will not be able to show his tickets")
    @TmsLink("WFET-5637")
    private void GC12() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .validateWelcomeMessageAppears()
                .clickOnNeinButtonFlow()
                .validateEndMessageAppears()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsIsNotShown();

        new ChatbotPage(driver)
                .validateRedirectionToLogin();

    }

    @Test(description="GC25 - DSL user - Verify that logged in user can access net assistant via deeplink")
    @TmsLink("WFET-5705")
    private void GC25() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT()
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .navigateSIT(Link)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();
    }

    @Test(description="GC26 - Cable user - Verify that logged in user can access net assistant via deeplink")
    @TmsLink("WFET-5707")
    private void GC26() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT()
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .navigateSIT(Link)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();
    }

    @Test(description="GC27 - UM user - Verify that logged in user can access net assistant via deeplink")
    @TmsLink("WFET-5708")
    private void GC27() {

        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .navigateSIT()
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .navigateSIT(Link)
                .validateContractChooserPage()
                .clickOn(getContractByName(contractNum));

        new ChatbotPage(driver)
                .validateMassOutageMessage();
    }

}

