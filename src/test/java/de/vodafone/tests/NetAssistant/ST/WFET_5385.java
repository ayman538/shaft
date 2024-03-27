package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

public class WFET_5385 extends STNetAssistantSetup {

    private String userName;
    private String password;
    private String deeplink;
    private String mobileNumber;
    private  HashMap<String,String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap<String, ArrayList> dslTree;
    private HashMap<String, ArrayList> cableTree;
    private HashMap<String, ArrayList> unityMediaTree;


    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        password = testData.getTestData(method.getName() + ".password");
        deeplink = testData.getTestData(method.getName() + ".link");
        mobileNumber = testData.getTestData(method.getName() + ".mobileNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");

        super.setup(method);
        loginAction(cookieSwitcherMap,userName,password);
    }


    @Test(description = "WFET-5385 - GC01 - DSL user - Deeplink to net assistant - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is returned from CMS")
    @TmsLink("WFET-5473")
    public void ST_GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }
    @Test(description = "WFET-5385 - GC02 - DSL user - Deeplink to net assistant - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is not returned from CMS")
    @TmsLink("WFET-5474")
    public void ST_GC02() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test(description = "WFET-5385- GC03 - DSL user - Deeplink to net assistant - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is not returned from Backend on 1st time but returned on 2nd time")
    @TmsLink("WFET-5475")
    public void ST_GC03() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }
    @Test(description = "WFET-5835 - GC04 - DSL user - Navigate to Help Form - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is returned from CMS")
    @TmsLink("WFET-5476")
    public void ST_GC04() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test(description = "WFET-5385- GC05 - DSL user - Navigate to Help Form - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is not returned from CMS")
    @TmsLink("WFET-5477")
    public void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test(description = "WFET-5385 -  GC06 - DSL user - Navigate to Help Form - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is not returned from Backend on 1st time but returned on 2nd time")
    @TmsLink("WFET-5478")
    public void ST_GC06() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test(description = "WFET-5385 - GC07 - DSL user - Navigate to Mein Vodafone SO - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is returned from CMS")
    @TmsLink("WFET-5479")
    public void ST_GC07() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test(description = "WFET-5385 - GC08 - DSL user - Navigate to Mein Vodafone SO - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is not returned from CMS")
    @TmsLink("WFET-5480")
    public void ST_GC08() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);
    }

    @Test(description = "WFET-5385 -  GC09 - DSL user - Navigate to Mein Vodafone SO - Verify that User shall view Wait Template returned from Backend in less than 2 mins and Memo Internal Template is not returned from Backend on 1st time but returned on 2nd time")
    @TmsLink("WFET-5481")
    public void ST_GC09() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps , dslTree);

    }
}





