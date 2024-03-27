package de.vodafone.tests.NetAssistant.ST;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.LoginPage;
import de.vodafone.pages.commons.NavigationPage;
import io.qameta.allure.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static de.vodafone.pages.commons.UtilitiesPage.getCurrentDate;
import static de.vodafone.pages.commons.UtilitiesPage.getCurrentTime;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_7004")
public class WFET_7004 extends STNetAssistantSetup{
    //Variables
    private String deeplink;
    private String userName;
    private String userPassword;
    private HashMap<String, String> cookieSwitcherMap;
    private String date;
    private String time;
    private List<String> Steps;
    private HashMap <String, ArrayList> cableTree;
    private HashMap <String, ArrayList> unityMediaTree;
    private HashMap <String, ArrayList> dslTree;
    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        date = getCurrentDate();
        time = getCurrentTime();
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".steps");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }
    @Test(description = "WFET-7298: GC01 -UM user- Mein Vodafone SO- Verify that Info Overlay is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7298")
    private void GC01() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateInfoOverlayEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayEnabled();
    }
    @Test(description = "WFET-7299: GC01 -VKD user- Mein Vodafone SO- Verify that Info Overlay is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7299")
    private void GC02() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateInfoOverlayEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayEnabled();
    }
    @Test(description = "WFET-7300: GC03 -DSL user- Mein Vodafone SO- Verify that Info Overlay is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7300")
    private void GC03() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree )
                .validateInfoOverlayEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayEnabled();
    }
    @Test(description = "WFET-7301: GC04 -UM user- Mein Vodafone SO -Verify that date time picker is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7301")
    private void GC04() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(date , time)
                .validateWeiterButtonEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterButtonEnabled();
    }
    @Test(description = "WFET-7303: GC05 -VKD user- Mein Vodafone SO -Verify that date time picker is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7302")
    private void GC05() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterButtonEnabled();
    }
    @Test(description = "7308: GC08 -VKD user- Mein Vodafone SO -Verify that decision tree reset & info overlay flow should be performed again when refreshing the page.")
    @TmsLink("WFET-7308")
    private void GC08() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateInfoOverlayEnabled()
                .refreshPageWithAlert()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description = "7308: GC09 -DSL user- Mein Vodafone SO -Verify that decision tree reset & info overlay flow should be performed again when refreshing the page.")
    @TmsLink("WFET-7309")
    private void GC09() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateInfoOverlayEnabled()
                .refreshPageWithAlert()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description = "WFET-7310: GC10 -UM user- Mein Vodafone SO -Verify that decision tree reset & date time picker flow should be performed again when refreshing the page.")
    @TmsLink("WFET-7310")
    private void GC10() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .refreshPageWithAlert()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterBtnNotExists();
    }
    @Test(description = "WFET-7311: GC11 -VKD user- Mein Vodafone SO -Verify that decision tree reset & date time picker flow should be performed again when refreshing the page.")
    @TmsLink("WFET-7311")
    private void GC11() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .refreshPageWithAlert()
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterBtnNotExists();
    }
    @Test(description = "WFET-7315: GC13 -UM user- Mein Vodafone SO -Verify that decision tree reset & info overlay flow should be performed again when logout and login again.")
    @TmsLink("WFET-7315")
    private void GC13() {
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateInfoOverlayEnabled()
                .logoutWithAlert();
        new LoginPage(driver).navigateST().loginST(userName,userPassword);
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description = "WFET-7316: GC14 -VKD user- Mein Vodafone SO -Verify that decision tree reset & info overlay flow should be performed again when logout and login again.")
    @TmsLink("WFET-7316")
    private void GC14() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateInfoOverlayEnabled()
                .logoutWithAlert();
        new LoginPage(driver).navigateST().loginST(userName,userPassword);
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description = "WFET-7317: GC15 - DSL user- Mein Vodafone SO -Verify that decision tree reset & info overlay flow should be performed again when logout and login again.")
    @TmsLink("WFET-7316")
    private void GC15() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree )
                .validateInfoOverlayEnabled()
                .logoutWithAlert();
        new LoginPage(driver).navigateST().loginST(userName,userPassword);
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description = "WFET-7318: GC16 -UM user- Deeplink to netassistant chatbot -Verify that decision tree reset &date time picker flow should be performed again when logout and login again.")
    @TmsLink("WFET-7318")
    private void GC16() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .logoutWithAlert();
        new LoginPage(driver).navigateST().loginST(userName,userPassword);
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterBtnNotExists();
    }
    @Test(description = "WFET-7319: GC17 -VKD user- Mein Vodafone SO -Verify that decision tree reset &date time picker flow should be performed again when logout and login again.")
    @TmsLink("WFET-7319")
    private void GC17() {
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(date , time)
                .validateWeiterButtonEnabled()
                .logoutWithAlert();
        new LoginPage(driver).navigateST().loginST(userName,userPassword);
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterBtnNotExists();
    }
    @Test(description="WFET-7321: GC19 -UM user- Mein Vodafone SO -Verify that decision tree reset & info overlay flow should be performed again when deeplink to chatbot for same user in a new tab.")
    @TmsLink("WFET-7321")
    public void GC19(){
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateInfoOverlayEnabled()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description="WFET-7322: GC20 -VKD user- Mein Vodafone SO -Verify that decision tree reset & info overlay flow should be performed again when deeplink to chatbot for same user in a new tab.")
    @TmsLink("WFET-7322")
    public void GC20(){
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateInfoOverlayEnabled()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description="WFET-7323: GC21 -DSL user- Through Deeplink -Verify that decision tree reset & info overlay flow should be performed again when deeplink to chatbot for same user in a new tab.")
    @TmsLink("WFET-7323")
    public void GC21(){
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .validateInfoOverlayEnabled()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayNotExists();
    }
    @Test(description="WFET-7324: GC22 -UM user- Mein Vodafone SO -Verify that decision tree reset & date time picker flow should be performed again when deeplink to chatbot for same user in a new tab.")
    @TmsLink("WFET-7324")
    public void GC22(){
        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterBtnNotExists();
    }
    @Test(description="WFET-7325: GC23 -VKD user- Mein Vodafone SO -Verify that decision tree reset & date time picker flow should be performed again when deeplink to chatbot for same user in a new tab.")
    @TmsLink("WFET-7325")
    public void GC23(){
        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new NavigationPage(driver)
                .netassitantRedirection();
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .duplicateCurrentTab();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterBtnNotExists();
    }
    @Test(description = "WFET-7327: GC25 -UM user- Through Deeplink- Verify that Info Overlay is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7327")
    private void GC25() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .validateInfoOverlayEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayEnabled();
    }
    @Test(description = "WFET-7328: GC26 -VKD user- Through Deeplink- Verify that Info Overlay is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7328")
    private void GC26() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .validateInfoOverlayEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayEnabled();
    }
    @Test(description = "WFET-7329: GC27 -DSL user- Through Deeplink - Verify that Info Overlay is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7329")
    private void GC27() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, dslTree )
                .validateInfoOverlayEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateInfoOverlayEnabled();
    }
    @Test(description = "WFET-7330: GC28 -UM user- Deeplink to net-assistant chatBot -Verify that date time picker is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7330")
    private void GC28() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, unityMediaTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterButtonEnabled();
    }
    @Test(description = "WFET-7330: GC29 -VKD user- DeepLink to net-assistant chatBot -Verify that date time picker is still displayed after switching between \"chatbot-tickets\" tabs.")
    @TmsLink("WFET-7331")
    private void GC29() {
        new NavigationPage(driver)
                .navigateInNewTab(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton()
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillDateTimePickerForm(date, time)
                .validateWeiterButtonEnabled()
                .switchToTickets();
        new TicketsPage(driver)
                .validateUserInTicketsPage()
                .clickOnFehlersucheStartenBtn();
        new ChatbotPage(driver)
                .validateUserInChatbot()
                .validateTobiIconExistsWeb()
                .validateWeiterButtonEnabled();
    }
}
