package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5511")
public class WFET_5741 extends STNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String helpForm;
    private String deeplink;
    private String tokenLink;
    private String contractNumber;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        helpForm=testData.getTestData(method.getName()+".helpform");
        deeplink=testData.getTestData(method.getName()+".link");
        tokenLink=testData.getTestData(method.getName()+".tokenLink");
        contractNumber=testData.getTestData(method.getName()+".contractNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "GC04 - DSL user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5913")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateNaImageIsNotVisible()
                .validateWelcomeMsgNewCL()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();

    }

    @Test(description = "GC05 - Cable user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5914")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateNaImageIsNotVisible()
                .validateWelcomeMsgNewCL()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();

    }

    @Test(description = "GC06 - UM user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5915")
    private void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateNaImageIsNotVisible()
                .validateWelcomeMsgNewCL()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();

    }

    @Test(description = "GC08 - Cable user - When user navigates to Net Assistant via SO he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5917")
    private void ST_GC08() {

        new DashboardPage(driver)
                .getCableSO(contractNumber);

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateNaImageIsNotVisible()
                .validateWelcomeMsgNewCL()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();

    }

    @Test(description = "GC09 - UM user - When user navigates to Net Assistant via SO he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5918")
    private void ST_GC09() {

        new DashboardPage(driver)
                .getUmSO(contractNumber);

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateNaImageIsNotVisible()
                .validateWelcomeMsgNewCL()
                .clickTicketsHeader();

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();

    }

    @Test(description = "GC10 - UM user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5919")
    private void ST_GC10() {

        new NavigationPage(driver)
                .navigateInNewTab(tokenLink);

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();
    }

    @Test(description = "GC11 - UM user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5920")
    private void ST_GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(tokenLink);

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();
    }

    @Test(description = "GC12 - UM user - When user navigates to Net Assistant via deeplink he should see the banner removed and the welcoming message CL is updated")
    @TmsLink("WFET-5921")
    private void ST_GC12() {

        new NavigationPage(driver)
                .navigateInNewTab(tokenLink);

        new TicketsPage(driver)
                .validateTicketsImageIsNotVisible()
                .validateWelcomeMsgNewCL();

    }

}