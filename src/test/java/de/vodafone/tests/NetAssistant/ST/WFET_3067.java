package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.HelpPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3067")
public class WFET_3067 extends STNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String chatbot_Deeplink;
    private HashMap<String,String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        chatbot_Deeplink = testData.getTestData(method.getName()+".link");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap,userName,userPassword);
    }

    @Test(description = "UM - Deeplink to Net Assistant Chatbot - Verify the C_ID Value is Updated in URL")
    @TmsLink("WFET-3144")
    private void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbot_Deeplink);

        new ChatbotPage(driver)
                .clickOnJaButton();

        new HelpPage(driver)
                .getCurruntURL()
                .validateUMDeeplinkC_idUpdated();
    }
    @Test(description = "UM - Deeplink to help form - Verify the C_ID Value is Updated in URL")
    @TmsLink("WFET-3146")
    private void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbot_Deeplink);

        new ChatbotPage(driver)
                .clickOnJaButton();

        new HelpPage(driver)
                .getCurruntURL()
                .validateUMDeeplinkC_idUpdated();

    }


};

