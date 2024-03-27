package de.vodafone.tests.NetAssistant.SIT;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.HelpPage;
import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.tests.NetAssistant.ST.STNetAssistantSetup;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Net Assistant")
@Feature("SIT")
@Story("WFET_5522")
public class WFET_5522 extends SITNetAssistantSetup {
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

    @Test(description = "WFET-5638 - GC01 - Cable User - Verify that customer id and type will be not included in URL but icmp is existing when logged in user navigates using SO")
    @TmsLink("WFET-5638")
    private void GC01() {

        new DashboardPage(driver)
                .getCableSO(contractNumber);
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new DashboardPage(driver)
                .validateSORedirectionCable();

    }

    @Test(description = "WFET-5639 - GC02 - UM User - Verify that customer id and type will be not included in URL but icmp is existing when logged in user navigates using SO")
    @TmsLink("WFET-5639")
    private void GC02() {

        new DashboardPage(driver)
                .getUmSOSIT(contractNumber);
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new DashboardPage(driver)
                .validateSORedirectionUM();

    }

    @Test(description = "WFET-5640 - GC03 - DSL User - Verify that customer id , type ,phone number & area code will be not included in URL but icmp is existing when logged in user navigates using SO")
    @TmsLink("WFET-5640")
    private void GC03() {

        new DashboardPage(driver)
                .getDSLSO();

        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new DashboardPage(driver)
                .validateSORedirectionDSL();

    }
    @Test(description = "WFET-5641 - GC04 - Cable User - Verify that customer id and type will be not included in URL but c_id is existing when logged in user navigates using helpform")
    @TmsLink("WFET-5641")
    private void GC04() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(helpForm);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new HelpPage(driver)
                .validateHelpFormRedirectionCable();

    }
    @Test(description = "WFET-5642 - GC05 - UM User - Verify that customer id and type will be not included in URL but c_id is existing when logged in user navigates using helpform")
    @TmsLink("WFET-5642")
    private void GC05() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(helpForm);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new HelpPage(driver)
                .validateHelpFormRedirectionUM();

    }

    @Test(description = "WFET-5642 - GC06 - DSL User - Verify that customer id , type , phone number & area code will be not included in URL but c_id is existing when logged in user navigates using helpform")
    @TmsLink("WFET-5642")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(helpForm);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new HelpPage(driver)
                .validateHelpFormRedirectionDSL();

    }
   }