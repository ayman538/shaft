package de.vodafone.tests.NetAssistant.SIT;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.lang.reflect.Method;
import java.util.*;

public class WFET_6906 extends SITNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String deeplink;
    private String hyperlink;
    private HashMap<String, String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap <String, ArrayList> cableTree;
    private HashMap <String, ArrayList> unityMediaTree;
    @BeforeMethod
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        hyperlink = testData.getTestData(method.getName() + ".hyperlink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }
    @Test(description = "GC05 - UM user - Mein Vodafone SO - Verify that \"i\"icon appears and clickable when \"Memo_InputInfo\" field returned for Form component")
    @TmsLink("WFET-7012")
    private void GC05() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsgSIT();
    }
    @Test(description = "GC11 - UM user - Mein Vodafone SO - Verify that \"x\" is displayed and clickable when \"Memo_InputInfo\" field is displayed for form component")
    @TmsLink("WFET-7018")
    private void GC11() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsgSIT()
                .validateXIconExists()
                .closeMemoInfoIcon();
    }
    @Test(description = "GC18 - VKD user - Mein Vodafone SO - Verify hyperlink in the \"Memo_InputInfo\" functionality for Form component")
    @TmsLink("WFET-7042")
    private void GC18() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoHyperlinkCLSIT()
                .clickHyperlink()
                .verifyUserNavigatedToNewPageSIT();
    }
    @Test(description = "GC24 - VKD user - Through deeplink - Verify that \"i\"icon appears and clickable when \"Memo_InputInfo\" field returned for form component")
    @TmsLink("WFET-7031")
    private void GC24() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsgSIT();
    }
    @Test(description = "GC30 - VKD user - Through deeplink -Verify that \"x\" is displayed and clickable when \"Memo_InputInfo\" field is displayed for form component")
    @TmsLink("WFET-7037")
    private void GC30() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsgSIT()
                .validateXIconExists()
                .closeMemoInfoIcon();
    }
    @Test(description = "GC35 - UM user - Through deeplink - Verify hyperlink in the \"Memo_InputInfo\" functionality for Form component")
    @TmsLink("WFET-7042")
    private void GC35() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoHyperlinkCLSIT()
                .clickHyperlink()
                .verifyUserNavigatedToNewPageSIT();
    }
    @Test(description = "GC38 - UM user - Mein Vodafone SO - verify that \"i\" icon is not displayed when \"Memo_InputInfo\" isn't returned for Form component")
    @TmsLink("WFET-7045")
    private void GC38() {
        new NavigationPage(driver)
                .navigateInNewTabSIT(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .verifyInfoIconDoesNotExist();
    }
}
