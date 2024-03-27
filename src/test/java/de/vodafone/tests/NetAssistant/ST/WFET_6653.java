package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_6653")
public class WFET_6653 extends STNetAssistantSetup {
    //Variables
    private String deeplink;
    private String userName;
    private String userPassword;
    private HashMap<String, String> cookieSwitcherMap;

    private List<String> Steps;
    private HashMap <String, ArrayList> cableTree;
    private HashMap <String, ArrayList> unityMediaTree;
    private HashMap <String, ArrayList> dslTree;

    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "GC01 - DSL - SO - Verify that \"<mehr infos\" is not displayed and the dialogue flow is shown normally if \"Memo_Overlay\" is not returned")
    @TmsLink("WFET-7077")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateOverlayObjectIsNotExisting();
    }

    @Test(description = "GC02 - DSL - Deeplink - Verify that \"<mehr infos\" is not displayed and the dialogue flow is shown normally if \"Memo_Overlay\" is not returned")
    @TmsLink("WFET-7078")
    private void GC02() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateOverlayObjectIsNotExisting();
    }

    @Test(description = "GC03 - UM - SO - Verify that \"<mehr infos\" is not displayed and the dialogue flow is shown normally if \"Memo_Overlay\" is not returned")
    @TmsLink("WFET-7079")
    private void GC03() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOverlayObjectIsNotExisting();
    }

    @Test(description = "GC04 - UM - deeplink - Verify that \"<mehr infos\" is not displayed and the dialogue flow is shown normally if \"Memo_Overlay\" is not returned")
    @TmsLink("WFET-7080")
    private void GC04() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateOverlayObjectIsNotExisting();
    }
    @Test(description = "GC05 - Cable - SO - Verify that \"<mehr infos\" is not displayed and the dialogue flow is shown normally if \"Memo_Overlay\" is not returned")
    @TmsLink("WFET-7081")
    private void GC05() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOverlayObjectIsNotExisting();
    }
    @Test(description = "GC06 - Cable - Depplink - Verify that \"<mehr infos\" is not displayed and the dialogue flow is shown normally if \"Memo_Overlay\" is not returned")
    @TmsLink("WFET-7082")
    private void GC06() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateOverlayObjectIsNotExisting();
    }
    @Test(description = "GC07 - DSL - SO - validate that overlay message is shown when \"Memo_Overlay\" is returned and opening and closing it will not reload the dialogue flow")
    @TmsLink("WFET-7083")
    private void GC07() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOverlayCloseBtnExistsAndClosesOverlayWithoutReload();
    }
    @Test(description = "GC08 - DSL - deeplink - validate that overlay message is shown when \"Memo_Overlay\" is returned and opening and closing it will not reload the dialogue flow")
    @TmsLink("WFET-7084")
    private void GC08() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOverlayCloseBtnExistsAndClosesOverlayWithoutReload();
    }
    @Test(description = "GC09 - UM - SO - validate that overlay message is shown when \"Memo_Overlay\" is returned and opening and closing it will not reload the dialogue flow")
    @TmsLink("WFET-7085")
    private void GC09() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOverlayCloseBtnExistsAndClosesOverlayWithoutReload();
    }
    @Test(description = "GC10 - UM - deeplink - validate that overlay message is shown when \"Memo_Overlay\" is returned and opening and closing it will not reload the dialogue flow")
    @TmsLink("WFET-7086")
    private void GC10() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOverlayCloseBtnExistsAndClosesOverlayWithoutReload();
    }
    @Test(description = "GC11 - Cable - SO - validate that overlay message is shown when \"Memo_Overlay\" is returned and opening and closing it will not reload the dialogue flow")
    @TmsLink("WFET-7087")
    private void GC11() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOverlayCloseBtnExistsAndClosesOverlayWithoutReload();
    }
    @Test(description = "GC12 - Cable - Depplink - validate that overlay message is shown when \"Memo_Overlay\" is returned and opening and closing it will not reload the dialogue flow")
    @TmsLink("WFET-7088")
    private void GC12() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayCloseBtnExistsAndClosesOverlayWithoutReload();
    }
    @Test(description = "GC13 - DSL - SO - Validate that all objects are shown correctly and aligned when they are returned in \"Memo_Overlay\" attribute")
    @TmsLink("WFET-7089")
    private void GC13() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOveryLayReturnedWithAllObjects();
    }
    @Test(description = "GC14 - DSL - deeplink - Validate that all objects are shown correctly and aligned when they are returned in \"Memo_Overlay\" attribute")
    @TmsLink("WFET-7090")
    private void GC14() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOveryLayReturnedWithAllObjects();
    }
    @Test(description = "GC15 - UM - SO - Validate that all objects are shown correctly and aligned when they are returned in \"Memo_Overlay\" attribute")
    @TmsLink("WFET-7091")
    private void GC15() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOveryLayReturnedWithAllObjects();
    }
    @Test(description = "GC16 - UM - deeplink - Validate that all objects are shown correctly and aligned when they are returned in \"Memo_Overlay\" attribute")
    @TmsLink("WFET-7092")
    private void GC16() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOveryLayReturnedWithAllObjects();
    }
    @Test(description = "GC17 - Cable - SO - Validate that all objects are shown correctly and aligned when they are returned in \"Memo_Overlay\" attribute")
    @TmsLink("WFET-7094")
    private void GC17() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOveryLayReturnedWithAllObjects();
    }
    @Test(description = "GC18 - Cable - deeplink - Validate that all objects are shown correctly and aligned when they are returned in \"Memo_Overlay\" attribute")
    @TmsLink("WFET-7095")
    private void GC18() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .clickOnOverlayMehrInfoBtn()
                .validateOverlayObjectIsExisting()
                .validateOveryLayReturnedWithAllObjects();
    }
  }