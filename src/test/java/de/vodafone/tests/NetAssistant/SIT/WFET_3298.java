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
public class WFET_3298 extends SITNetAssistantSetup {
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

    @Test(groups={"WFET_3298"})
    @TmsLink("WFET-3867")
    @Description("SIT02 - non logged in UM user -verify that ticket listing displayed when navigate to netassisstant app through  deep link")
    private void GC02() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate(Link)
                .acceptCookies();

        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .validateTicketsPageDisplayed()
                .validateLogoutButtonDisplayed();


    }
    @Test(groups={"WFET_3298"})
    @TmsLink("WFET-3868")
    @Description("SIT03- logged in UM user -verify behavior of logout button at tickets screen")
    private void GC03() {
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate(Link)
                .acceptCookies();


        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .validateTicketsPageDisplayed()
                .clickOn(DashboardPage.getLogoutButton())
                .validateLogoutButtonDisplayed();

    }
}
