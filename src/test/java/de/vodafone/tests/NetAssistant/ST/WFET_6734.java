package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
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
@Story("WFET_6734")
public class WFET_6734 extends STNetAssistantSetup {
    //Variables
    private String deeplink;
    private String tokenLink;
    private String userName;
    private String userPassword;
    private HashMap<String, String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap <String, ArrayList> dslTree;


    @BeforeMethod
    public void setup(Method method) {
        deeplink = testData.getTestData(method.getName() + ".deeplink");
        tokenLink = testData.getTestData(method.getName() + ".tokenLink");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "WFET-7215 - GC01 - Cable - Deeplink - Validate that question appears in tickets list under tickets overview with two options when user navigates / redirects to tickets list")
    @TmsLink("WFET-7215")
    private void GC01() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnExists()
                .validateNetzAssistentBtnExists();
    }

    @Test(description = "WFET-7216 - GC02 - UM - Deeplink - Validate that question appears in tickets list under tickets overview with two options when user navigates / redirects to tickets list")
    @TmsLink("WFET-7216")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnExists()
                .validateNetzAssistentBtnExists();
    }

    @Test(description = "WFET-7217 - GC03 - DSL - Deeplink - Validate that question appears in tickets list under tickets overview with two options when user navigates / redirects to tickets list")
    @TmsLink("WFET-7217")
    private void GC03() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnExists()
                .validateNetzAssistentBtnExists();
    }

    @Test(description = "WFET-7218 - GC04 - Cable - SO - Validate that question appears in tickets list under tickets overview with two options when user navigates / redirects to tickets list")
    @TmsLink("WFET-7218")
    private void GC04() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnExists()
                .validateNetzAssistentBtnExists();
    }

    @Test(description = "WFET-7219 - GC05 - UM - SO - Validate that question appears in tickets list under tickets overview with two options when user navigates / redirects to tickets list")
    @TmsLink("WFET-7219")
    private void GC05() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnExists()
                .validateNetzAssistentBtnExists();
    }

    @Test(description = "WFET-7220 - GC06 - DSL - SO - Validate that question appears in tickets list under tickets overview with two options when user navigates / redirects to tickets list")
    @TmsLink("WFET-7220")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnExists()
                .validateNetzAssistentBtnExists();
    }

    @Test(description = "WFET-7224 - GC10 - Cable - Deeplink - Validate icmp in URL header when \"Fehlersuche starten\" is clicked")
    @TmsLink("WFET-7224")
    private void GC10() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .clickOnFehlersucheStartenBtn()
                .validateURLWhenFehlersucheStartenIsClicked();
    }

    @Test(description = "WFET-7225 - GC11 - UM - Deeplink - Validate icmp in URL header when \"Fehlersuche starten is clicked")
    @TmsLink("WFET-7225")
    private void GC11() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .clickOnFehlersucheStartenBtn()
                .validateURLWhenFehlersucheStartenIsClicked();
    }

    @Test(description = "WFET-7226 - GC12 - DSL - Deeplink - Validate icmp in URL header when \"Fehlersuche starten is clicked")
    @TmsLink("WFET-7226")
    private void GC12() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .clickOnFehlersucheStartenBtn()
                .validateURLWhenFehlersucheStartenIsClicked();
    }

    @Test(description = "WFET-7227 - GC13 - Cable - SO - Validate icmp in URL header when \"Fehlersuche starten\" is clicked")
    @TmsLink("WFET-7227")
    private void GC13() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .clickOnFehlersucheStartenBtn()
                .validateURLWhenFehlersucheStartenIsClicked();
    }

    @Test(description = "WFET-7228 - GC14 - UM - SO - Validate icmp in URL header when \"Fehlersuche starten is clicked")
    @TmsLink("WFET-7228")
    private void GC14() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .clickOnFehlersucheStartenBtn()
                .validateURLWhenFehlersucheStartenIsClicked();
    }

    @Test(description = "WFET-7229 - GC15 - DSL - SO - Validate icmp in URL header when \"Fehlersuche starten is clicked")
    @TmsLink("WFET-7229")
    private void GC15() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .clickOnFehlersucheStartenBtn()
                .validateURLWhenFehlersucheStartenIsClicked();
    }
    @Test(description = "WFET-7230 - GC16 - Cable - deeplink - Validate new question CL in tickets page")
    @TmsLink("WFET-7230")
    private void GC16() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .validateTicketsListNewMsgExistsCableUM();
    }

    @Test(description = "WFET-7231 - GC17 - UM - deeplink - Validate new question CL in tickets page")
    @TmsLink("WFET-7231")
    private void GC17() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .validateTicketsListNewMsgExistsCableUM();
    }

    @Test(description = "WFET-7232 - GC18 - DSL - deeplink - Validate new question CL in tickets page")
    @TmsLink("WFET-7232")
    private void GC18() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .validateTicketsListNewMsgExistsDSL();
    }

    @Test(description = "WFET-7233 - GC19 - Cable - SO - Validate new question CL in tickets page")
    @TmsLink("WFET-7233")
    private void GC19() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .validateTicketsListNewMsgExistsCableUM();
    }

    @Test(description = "WFET-7234 - GC20 - UM - SO - Validate new question CL in tickets page")
    @TmsLink("WFET-7234")
    private void GC20() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .validateTicketsListNewMsgExistsCableUM();
    }

    @Test(description = "WFET-7235 - GC21 - DSL - SO - Validate new question CL in tickets page")
    @TmsLink("WFET-7235")
    private void GC21() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new ChatbotPage(driver)
                .validateQuestion1Exists();
        new TicketsPage(driver)
                .clickTicketsTabHeader()
                .validateTicketsListNewMsgExistsDSL();
    }

    @Test(description = "WFET-7239 - GC25 - Cable - Token deeplink - Validate new question is not existing in tickets page via token")
    @TmsLink("WFET-7239")
    private void GC25() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(tokenLink);
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnDoesNotExist()
                .validateNetzAssistentBtnDoesNotExist()
                .validateTicketsListNewMsgDoesNotExist();
    }

    @Test(description = "WFET-7240 - GC26 - UM - Token deeplink - Validate new question is not existing in tickets page via token")
    @TmsLink("WFET-7240")
    private void GC26() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(tokenLink);
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnDoesNotExist()
                .validateNetzAssistentBtnDoesNotExist()
                .validateTicketsListNewMsgDoesNotExist();
    }

    @Test(description = "WFET-7241 - GC27 - DSL - Token deeplink - Validate new question is not existing in tickets page via token")
    @TmsLink("WFET-7241")
    private void GC27() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(tokenLink);
        new TicketsPage(driver)
                .validateFehlersucheStartenBtnDoesNotExist()
                .validateNetzAssistentBtnDoesNotExist()
                .validateTicketsListNewMsgDoesNotExist();
    }

    @Test(description = "WFET-7257 - GC28 - Cable - deeplink - Validate CL appears when user click on \"Netz-Assistetnt verlassen\"")
    @TmsLink("WFET-7257")
    private void GC28() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .clickOnnetzAssistentBtn()
                .validateTicketsListNewMsgCLWhenNetzAssistentBtnIsClicked();
    }

    @Test(description = "WFET-7242 - GC29 - UM - deeplink - Validate CL appears when user click on \"Netz-Assistetnt verlassen\"")
    @TmsLink("WFET-7242")
    private void GC29() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .clickOnnetzAssistentBtn()
                .validateTicketsListNewMsgCLWhenNetzAssistentBtnIsClicked();
    }

    @Test(description = "WFET-7243 - GC30 - DSL - deeplink - Validate CL appears when user click on \"Netz-Assistetnt verlassen\"")
    @TmsLink("WFET-7243")
    private void GC30() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .clickOnnetzAssistentBtn()
                .validateTicketsListNewMsgCLWhenNetzAssistentBtnIsClicked();
    }
    @Test(description = "WFET-7244 - GC31 - Cable - SO - Validate CL appears when user click on \"Netz-Assistetnt verlassen\"")
    @TmsLink("WFET-7244")
    private void GC31() {

        new DashboardPage(driver)
                .clickOnNetAssSOCable();
        new TicketsPage(driver)
                .clickOnnetzAssistentBtn()
                .validateTicketsListNewMsgCLWhenNetzAssistentBtnIsClicked();
    }

    @Test(description = "WFET-7245 - GC32 - UM - SO - Validate CL appears when user click on \"Netz-Assistetnt verlassen\"")
    @TmsLink("WFET-7245")
    private void GC32() {

        new DashboardPage(driver)
                .clickOnNetAssSOUM();
        new TicketsPage(driver)
                .clickOnnetzAssistentBtn()
                .validateTicketsListNewMsgCLWhenNetzAssistentBtnIsClicked();
    }

    @Test(description = "WFET-7246 - GC33 - DSL - SO - Validate CL appears when user click on \"Netz-Assistetnt verlassen\"")
    @TmsLink("WFET-7246")
    private void GC33() {

        new NavigationPage(driver)
                .navigateInNewTabWithTicketsRedirection(deeplink);
        new TicketsPage(driver)
                .clickOnnetzAssistentBtn()
                .validateTicketsListNewMsgCLWhenNetzAssistentBtnIsClicked();
    }
}