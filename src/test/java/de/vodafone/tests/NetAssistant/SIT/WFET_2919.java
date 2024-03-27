package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_2919 extends SITNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String Link;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        Link = testData.getTestData(method.getName()+".Link");
        super.setup(method);
    }

    @Test(groups={"WFET_2919"})
    @TmsLink("WFET-3235")
    @Description("Cable user - Verify Page displayed when non logged in Cable user deeplink to his tickets with no Contract attached to his account")
    private void GC01() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .acceptCookies()
                .navigate(Link);


        new LoginPage(driver)
                .loginSIT(userName,userPassword)
                .validateLoginIndicatorExists();

        new DashboardPage(driver)
                .validateErrorIconDisplayed();

    }
}
