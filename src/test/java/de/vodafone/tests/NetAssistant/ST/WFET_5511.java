package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.*;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_5511")
public class WFET_5511 extends STNetAssistantSetup {
    //Variables

    private String userName;
    private String userPassword;
    private String ticketsDeepLink;
    private String contractNumber;
    private HashMap<String,String> cookieSwitcherMap;
    //Test
    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        ticketsDeepLink=testData.getTestData(method.getName()+".link");
        contractNumber=testData.getTestData(method.getName()+".customerNo");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "GC14 - Cable user - Verify that logged in user can access net assistant via MeineVodafone")
    @TmsLink("WFET-5681")
    private void ST_GC14() {

        new DashboardPage(driver)
                .clickOn(DashboardPage.cableAccordionST)
                .getCableSO(contractNumber);

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateNoMassOutageMessage();

    }

    @Test(description = "GC15 - UM user - Verify that logged in user can access net assistant via MeineVodafone")
    @TmsLink("WFET-5682")
    private void ST_GC15() {

        new DashboardPage(driver)
                .clickOn(DashboardPage.umAccordion)
                .getUmSO(contractNumber);

        new NavigationPage(driver)
                .netassitantRedirection();

        new ChatbotPage(driver)
                .validateNoMassOutageMessage();
    }

}