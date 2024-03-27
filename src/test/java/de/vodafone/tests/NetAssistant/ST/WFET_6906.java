package de.vodafone.tests.NetAssistant.ST;
import de.vodafone.pages.NetAssistant.ChatbotPage;
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
@Story("WFET_6906")
public class WFET_6906 extends STNetAssistantSetup {
    private String deeplink;
    private String userName;
    private String userPassword;
    private String hyperlink;
    private HashMap<String, String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap<String, ArrayList> cableTree;
    private HashMap<String, ArrayList> unityMediaTree;

    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        hyperlink = testData.getTestData(method.getName() + ".hyperlink");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }
    @Test(description = "WFET-7012 :GC05 - UM user - Mein Vodafone SO - Verify that \"i\"icon appears and clickable when \"Memo_InputInfo\" field returned for Form component")
    @TmsLink("WFET-7012")
    private void GC05() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg();
    }
    @Test(description = "WFET-7013 :GC06 - VKD user SO - Verify that \"i\"icon appears and clickable when \"Memo_InputInfo\" field returned for Form component")
    @TmsLink("WFET-7013")
    private void GC06() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg();
    }
    @Test(description = "WFET-7018 :GC11 - UM user - Mein Vodafone SO - Verify that \"x\" is displayed and clickable when \"Memo_InputInfo\" field is displayed for form component")
    @TmsLink("WFET-7018")
    private void GC11() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg()
                .validateXIconExists()
                .closeMemoInfoIcon();
    }
    @Test(description = "WFET-7019 :GC12 - VKD user - Mein Vodafone SO - Verify that \"x\" is displayed and clickable when \"Memo_InputInfo\" field is displayed for form component for form component")
    @TmsLink("WFET-7019")
    private void GC12() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg()
                .validateXIconExists()
                .closeMemoInfoIcon();
    }
    @Test(description = "WFET-7024 :GC17 - UM user -Mein Vodafone SO - Verify hyperlink in the \"Memo_InputInfo\" functionality for form component")
    @TmsLink("WFET-7024")
    private void GC17() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoHyperlinkCL()
                .clickHyperlink()
                .verifyUserNavigatedToNewPage();
    }
    @Test(description = "WFET-7025 :GC18 - VKD user - Mein Vodafone SO - Verify the functionality of the hyperlink presented in the\"Memo_InputInfo\" for form component")
    @TmsLink("WFET-7025")
    private void GC18() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoHyperlinkCL()
                .clickHyperlink()
                .verifyUserNavigatedToNewPage();
    }
    @Test(description = "WFET-7030 :GC23 - UM user - Through deeplink - Verify that \"i\"icon appears and clickable when \"Memo_InputInfo\" field returned for form component")
    @TmsLink("WFET-7030")
    private void GC23() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg();
    }
    @Test(description = "WFET-7031 :GC24 - VKD user - Through deeplink - Verify that \"i\"icon appears and clickable when \"Memo_InputInfo\" field returned for form component")
    @TmsLink("WFET-7031")
    private void GC24() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg();
    }
    @Test(description = "WFET-7036 :GC29 - UM user - Through deeplink -Verify that \"x\" is displayed and clickable when \"Memo_InputInfo\" field is displayed for form component")
    @TmsLink("WFET-7036")
    private void GC29() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg()
                .validateXIconExists()
                .closeMemoInfoIcon();
    }
    @Test(description = "WFET-7037 :GC30 - VKD user - Through deeplink -Verify that \"x\" is displayed and clickable when \"Memo_InputInfo\" field is displayed for form component")
    @TmsLink("WFET-7037")
    private void GC30() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .openMemoInfoIcon()
                .verifyMemoInputInfoMsg()
                .validateXIconExists()
                .closeMemoInfoIcon();
    }
    @Test(description = "WFET-7042 :GC35 - UM user - Through deeplink - Verify hyperlink in the \"Memo_InputInfo\" functionality for Form component")
    @TmsLink("WFET-7042")
    private void GC35() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoHyperlinkCL()
                .clickHyperlink()
                .verifyUserNavigatedToNewPage();
    }
    @Test(description = "WFET-7043 :GC36 - VKD user - Through deeplink - Verify hyperlink in the \"Memo_InputInfo\" functionality for Form component")
    @TmsLink("WFET-7043")
    private void GC36() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateMemoInfoIconExists()
                .openMemoInfoIcon()
                .verifyMemoInputInfoHyperlinkCL()
                .clickHyperlink()
                .verifyUserNavigatedToNewPage();
    }
    @Test(description = "WFET-7045 :GC38 - VKD user - Mein Vodafone SO - verify that \"i\" icon is not displayed when \"Memo_InputInfo\" isn't returned for Form component")
    @TmsLink("WFET-7045")
    private void GC38() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();
        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .verifyInfoIconDoesNotExist();
    }
}
