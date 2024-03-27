package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_5508 extends SITNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String loginDeepLink;
    private String Link;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        Link = testData.getTestData(method.getName()+".Link");
        super.setup(method);
    }

    @Test(description="DSL user - Deeplink to net assistant - Verify that non logged User shall view Page after navigating to deep link to his tickets with no Contracts attached to account")
    @TmsLink("WFET-5695")
    private void GC01() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .clickOnYaButtonFlow();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateErrorIconDisplayed();

    }
    @Test(description="GC02 - Cable user - Deeplink to net assistant - Verify that non logged User shall view Page after navigating to deep link to his tickets with no Contracts attached to account")
    @TmsLink("WFET-5696")
    private void GC02() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .clickOnYaButtonFlow();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateErrorIconDisplayed();

    }
    @Test(description="UM user - Deeplink to net assistant - Verify that non logged User shall view Page after navigating to deep link to his tickets with no Contracts attached to account")
    @TmsLink("WFET-5697")
    private void GC03() {
        new ChatbotPage(driver)
                .navigateSIT();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigateSIT(Link)
                .acceptCookies()
                .clickOnYaButtonFlow();

        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateErrorIconDisplayed();

    }
}

