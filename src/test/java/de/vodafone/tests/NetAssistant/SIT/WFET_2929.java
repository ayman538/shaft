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
public class WFET_2929 extends SITNetAssistantSetup {
    //Variables
    private String user_Name;
    private String user_Password;
    private String Link;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        user_Name = testData.getTestData(method.getName()+".name");
        user_Password = testData.getTestData(method.getName()+".password");
        Link = testData.getTestData(method.getName()+".Link");
        super.setup(method);
    }

    @Test(groups={"WFET_2929"})
    @TmsLink("WFET-3197")
    @Description("SIT06 - Cable user - Verify Page Displayed After Choosing Cable Contract from the list")
    private void GC06() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate(Link)
                .acceptCookies();

        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .validateContractsExist()
                .clickOn(DashboardPage.getFirstContract())
                .validateTicketsPageDisplayed()
                .validateLogoutButtonDisplayed();


    }
    @Test(groups={"WFET_2929"})
    @TmsLink("WFET-3198")
    @Description("SIT07 - Cable user - Verify Logout button redirection when user is already logged In to his tickets list")
    private void GC07() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate(Link)
                .acceptCookies();


        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .validateContractsExist()
                .clickOn(DashboardPage.getFirstContract())
                .validateTicketsPageDisplayed()
                .clickOn(DashboardPage.getLogoutButton())
                .validateLogoutButtonDisplayed();



    }
}
