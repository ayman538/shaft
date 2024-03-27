package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.*;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5522")
public class WFET_5522 extends STNetAssistantSetup {
    //Variables
    private String helpForm;
    private String userName;
    private String userPassword;
    private String contractNumber;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        helpForm = testData.getTestData(method.getName() + ".helpForm");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        contractNumber= testData.getTestData(method.getName() + ".contractNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "GC01 - Cable User - Verify that customer id and type will be not included in URL but icmp is existing when logged in user navigates using SO")
    @TmsLink("WFET-5638")
    private void ST_GC01() {

        new DashboardPage(driver)
                .getCableSO(contractNumber);

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists();

        new DashboardPage(driver)
                .validateSORedirectionCable();
    }

    @Test(description = "GC02 - UM User - Verify that customer id and type will be not included in URL but icmp is existing when logged in user navigates using SO")
    @TmsLink("WFET-5639")
    private void ST_GC02() {

        new DashboardPage(driver)
                .getUmSO(contractNumber);

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateQuestion1Exists();

        new DashboardPage(driver)
                .validateSORedirectionUM();


    }
    @Test(description = "GC04 - Cable User - Verify that customer id and type will be not included in URL but c_id is existing when logged in user navigates using helpform")
    @TmsLink("WFET-5641")
    private void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(helpForm);

        new ChatbotPage(driver)
                .validateQuestion1Exists();

        new HelpPage(driver)
                .validateHelpFormRedirectionCable();

    }
    @Test(description = "GC05 - UM User - Verify that customer id and type will be not included in URL but c_id is existing when logged in user navigates using helpform")
    @TmsLink("WFET-5642")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(helpForm);

        new ChatbotPage(driver)
                .validateQuestion1Exists();

        new HelpPage(driver)
                .validateHelpFormRedirectionUM();

    }

    @Test(description = "GC06 - DSL User - Verify that customer id , type , phone number & area code will be not included in URL but c_id is existing when logged in user navigates using helpform")
    @TmsLink("WFET-5642")
    private void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(helpForm);

        new ChatbotPage(driver)
                .validateQuestion1Exists();

        new HelpPage(driver)
                .validateHelpFormRedirectionDSL();

    }

   }