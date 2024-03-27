package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5508")
public class WFET_5508 extends STNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String Link;
    private HashMap<String, String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        Link = testData.getTestData(method.getName() + ".link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "WFET-5508 - GC07 - DSL user - Navigate to Help form - Verify that logged in User shall view Page after navigating to deep link to his tickets with no Contracts attached to account")
    @TmsLink("WFET-5726")
    private void GC07() {

        new NavigationPage(driver)
            .navigateInNewTabWithTicketsRedirection(Link);

        new DashboardPage(driver)
                .validateNoContractError()
                .validateAddContractBtnExists();
    }

    @Test(description = "WFET-5508 - GC08 - Cable user - Navigate to Help form - Verify that logged in User shall view Page after navigating to deep link to his tickets with no Contracts attached to account")
    @TmsLink("WFET-5727")
    private void GC08() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(Link);

        new DashboardPage(driver)
                .validateNoContractError()
                .validateAddContractBtnExists();

    }

    @Test(description = "WFET-5508 - GC09 - UM user - Navigate to Help form - Verify that logged in User shall view Page after navigating to deep link to his tickets with no Contracts attached to account")
    @TmsLink("WFET-5728")
    private void GC09() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(Link);

        new DashboardPage(driver)
                .validateNoContractError()
                .validateAddContractBtnExists();

    }

}