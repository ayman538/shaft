package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.DashboardPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Net Assistant")
@Feature("SIT")
@Story("WFET_3345")
public class WFET_3345 extends SITNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String Link;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName()+".name");
        userPassword = testData.getTestData(method.getName()+".password");
        Link = testData.getTestData(method.getName()+".Link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description ="WFET-3835 - Cable user - Login to MeinVodafone DashboardPage portal - Verify contact details updated for Unsubscribed user" )
    @TmsLink("WFET-3835")
    private void GC01() {

        new DashboardPage(driver)
                .clickOnCableInfoSubscriptionSO()
                .validateBackButtonExists()
                .validateSaveIndicatorExists()
                .validateCheckBoxExists()
                .validateEmailRadioButtonExists()
                .validateSmsRadioButtonExists()
                .validateSaveIndicatorExists();

    }
    @Test(description = "WFET-3836 - Cable user - Login to MeinVodafone DashboardPage portal - Verify SMS/Email Subscription Type enabled after checkbox selection for Unsubscribed user")
    @TmsLink("WFET-3836")
    private void GC02() {

        new DashboardPage(driver)
                .clickOnCableInfoSubscriptionSO()
                .validateBackButtonExists()
                .validateSaveIndicatorExists()
                .validateCheckBoxExists()
                .validateEmailRadioButtonExists()
                .validateSmsRadioButtonExists()
                .validateEmailRadioButtonVisible()
                .validateSmsRadioButtonVisible();

    }

    @Test(description ="WFET-3839 - Cable user - Login to MeinVodafone DashboardPage portal - Verify Subscription Type disabled after no checkbox selection for Unsubscribed user" )
    @TmsLink("WFET-3839")
    private void GC05() {

        new DashboardPage(driver)
                .clickOnCableInfoSubscriptionSO()
                .validateBackButtonExists()
                .validateSaveIndicatorExists()
                .validateCheckBoxExists()
                .validateEmailRadioButtonExists()
                .validateSmsRadioButtonExists()
                .validateEmailRadioButtonVisible()
                .validateSmsRadioButtonVisible();
    }

}
