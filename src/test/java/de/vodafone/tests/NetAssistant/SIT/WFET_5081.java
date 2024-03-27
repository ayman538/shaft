package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
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
@Story("WFET_5081")
public class WFET_5081 extends SITNetAssistantSetup {
    //Variables
    private String Link;
    private String userName;
    private String userPassword;
    private String contractNumber;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        Link = testData.getTestData(method.getName() + ".Link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        contractNumber=testData.getTestData(method.getName()+".contractNumber");
        super.setup(method);

    }

    @Test(description = " GC01 - DSL user - Non-Logged in User - Deeplink to net assistant - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added ")
    @TmsLink("WFET-5942")
    private void GC01() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }


    @Test(description = "GC02 - Cable user - Non-Logged in User - Deeplink to net assistant - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5943")
    private void GC02() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateContractChooserPage()
                .clickOn(DashboardPage.getContractByName(contractNumber));

        new ChatbotPage(driver)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }


    @Test(description = "GC03 - UM user - Non-Logged in User - Deeplink to net assistant - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5944")
    private void GC03() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .clickJaWelcomeScreen();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateContractChooserPage()
                .clickOn(DashboardPage.getContractByName(contractNumber));

        new ChatbotPage(driver)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }

    @Test(description = "GC05 - DSL user - Logged in User - Deeplink to net assistant from Mein Vodafone SO - Verify that User shall view buttons CL as changed and button that directs users to tickets list is added")
    @TmsLink("WFET-5945")
    private void GC05() {
        new LoginPage(driver)
                .navigateSIT();
        setCookieECHO();

        new LoginPage(driver)
                .acceptCookies()
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateNetAssistantSmartObjectLocatorExist()
                .getDSLSO()
                .switchToTab();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .validateJaButtonExists()
                .validateNeinButtonExists()
                .validateMeinTicketsButtonExists()
                .clickOnZuMeinenTicketsButtonFlow();
    }
}