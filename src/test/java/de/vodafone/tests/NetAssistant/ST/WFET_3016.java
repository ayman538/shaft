package de.vodafone.tests.NetAssistant.ST;

import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.commons.NavigationPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import io.qameta.allure.*;
import org.testng.annotations.*;
import java.util.*;
import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("ST")
@Story("WFET_3016")
public class WFET_3016 extends STNetAssistantSetup {
    //Variables
    private String chatbot_Deeplink;
    private String ticketsLink;
    private String userName;
    private String userPassword;
    private String phoneNumber;
    private String text;
    private HashMap<String,String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap<String, ArrayList> dslTree;
    private HashMap<String, ArrayList> cableTree;
    private HashMap<String, ArrayList> unityMediaTree;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        chatbot_Deeplink = testData.getTestData(method.getName() + ".link");
        ticketsLink = testData.getTestData(method.getName() + ".link");
        userName = testData.getTestData(method.getName() + ".userName");
        userPassword = testData.getTestData(method.getName() + ".password");
        phoneNumber = testData.getTestData(method.getName() + ".phoneNumber");
        text = testData.getTestData(method.getName() + ".text");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        unityMediaTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("unityMediaTree");
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

        @Test(description = "GC09 - DSL user - Verify Chatbot with no massoutage")
    @TmsLink("WFET-3016")
    private void ST_GC09() {
        new NavigationPage(driver)
                .navigateInNewTab(chatbot_Deeplink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage();

    }
    @Test(description = "GC19 - Cable user - Verify Chatbot with massoutage")
    @TmsLink("WFET-3016")
    private void ST_GC19() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbot_Deeplink);

        new ChatbotPage(driver)
                .validateMassOutageUMCable();

    }
    @Test(description = "GC11 DSL user - Verify Chatbot callback service success")
    @TmsLink("WFET-3016")
    private void ST_GC11() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbot_Deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();

    }
    @Test(description = "GC18 Cable user - Verify Chatbot callback service success")
    @TmsLink("WFET-3016")
    private void ST_GC18() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbot_Deeplink);

        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillCallbackForm(phoneNumber)
                .validateCallBackServiceSucess();

    }

    @Test(description = "GC20 Cable user  - Verify Chatbot with no massoutage")
    @TmsLink("WFET-3016")
    private void ST_GC20() {

        new NavigationPage(driver)
                .navigateInNewTab(chatbot_Deeplink);

        new ChatbotPage(driver)
                .validateNoMassOutageMessage()
                .validateQuestion1Exists()
                .validateJaButtonExists()
                .validateNeinButtonExists();

    }
/*
    //Hadeer
    @Test(enabled = false , description = "DSL - Deeplink to Net Assistant tickets- Verify Close ticket button with ticket State Inprogress")
    @TmsLink("WFET-3016")
    private void ST_GC01() {

        new TicketsPage(driver)
                .navigateInNewTab(ticketsLink)
                .validateTicketStatusDisplayedTicketsList()
                .ClickMoreInfoButton()
                .validateGetClosedTicketsButtonExists();
    }
    @Test(enabled = false , description = "DSL - Deeplink to Net Assistant Tickets - Verify Close ticket button with ticket State Solved")
    @TmsLink("WFET-3016")
    private void ST_GC02() {

        new TicketsPage(driver)
                .navigateInNewTab(ticketsLink)
                .ClickMoreInfoButton()
                .validateSolvedTicketsStatusIsDisplayed()
                .validateReopenButtonExistsForSolvedTickets();

    }
*/

    @Test(description = "GC04 DSL - Deeplink to Net Assistant tickets- Check ticket details view with text description when clicking on more info button for inprogress ticket status")
    @TmsLink("WFET-3016")
    private void ST_GC04() {
        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateTicketStatusDisplayedTicketsList()
                .clickMoreInfoButton()
                .validateTicketsDetailsStatusExsits()
                .validateTicketStatusBarExists()
                .validateTicketStatusDescriptionExists()
                .validateTicketDetailsTitle();

    }
    @Test(description = "GC05 DSL - Deeplink to Net Assistant Tickets - Check ticket details view with text description when clicking on more info button for resolved ticket status")
    @TmsLink("WFET-3016")
    private void ST_GC05() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateSolvedTicketsStatusIsDisplayed()
                .clickMoreInfoButton()
                .validateTicketsDetailsStatusExsits()
                .validateTicketStatusBarExists()
                .validateTicketStatusDescriptionExists()
                .validateTicketDetailsTitle();

    }
    /*
    @Test(enabled = false , description = "DSL - Deeplink to Net Assistant Tickets - Verify Reopen ticket button with ticket state solved")
    @TmsLink("WFET-3016")
    private void ST_GC03() {

        new TicketsPage(driver)
                .navigateInNewTab(ticketsLink)
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTicket_solved_status())
                .exists()
                .withCustomReportMessage(" ticket with status solved displayed")
                .perform();
        new TicketsPage(driver)
                .ClickMoreInfoButton();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Reopen_Ticket_Button())
                .exists()
                .withCustomReportMessage("reopen ticket button displayed for solved ticket")
                .perform();
        new TicketsPage(driver)
                .Click_Reopen_Ticket_Button();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getReopen_form_question())
                .exists()
                .withCustomReportMessage(" reopen ticket button clicked successfully ")
                .perform();

    }
     */

    @Test(description = "GC13 Cable - Deeplink to Net Assistant tickets- Verify Close ticket button with ticket State Inprogress")
    @TmsLink("WFET-3016")
    private void ST_GC13() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateCloseTicketBtnIsVisible();
    }
    @Test(description ="GC14 Cable - Deeplink to Net Assistant Tickets - Verify Close ticket button with ticket State Solved")
    @TmsLink("WFET-3016")
    private void ST_GC14() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .validateCloseTicketBtnIsNotVisible()
                .validateReopenButtonExistsForSolvedTickets();
    }
    @Test(description = "GC15 - Cable user - Deeplink to Net Assistant App - Verify Refresh Button and choices behaviour after Session ends")
    @TmsLink("WFET-3016")
    private void ST_GC15() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .validateMoreInfoButtonIsDisplayed()
                .clickMoreInfoButton()
                .validateReopenButtonCL()
                .Click_Reopen_Ticket_Button()
                .clickOn(TicketsPage.get_Go_On_Button())
                .clickOnReOpenTicketDecisionTree()
                .Click_Problem_Still_Exists_Button()
                .Enter_Data(TicketsPage.get_Contact_Number_Text_Field(),phoneNumber)
                .Enter_Data(TicketsPage.get_Problem_Description_Text_Field(),text)
                .clickOn(TicketsPage.get_Ready_Button())
                .clickOn(TicketsPage.get_Ja_Button())
                .validateNeuStartenButtonCL();

    }

    @Test(description = "GC16 - Cable user - Deeplink to Net Assistant Ticket Details View - Check ticket details view with text description when clicking on \" more info \" button for \"inprogress\" ticket status")
    @TmsLink("WFET-3016")
    private void ST_GC16(){

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",2)
                .validateTicketStatusDescriptionExists()
                .validateTicketCreationDateExists()
                .validateTicketNumberExists()
                .validateTicketStatusCL()
                .validateTicketStatusBarExists()
                .validateCurrentTicketStatusExists();
    }

    @Test(description ="GC17 - Cable user - Deeplink to Net Assistant Ticket Details View - Check ticket details view with text description when clicking on \" more info \" button for \"resolved\" ticket status")
    @TmsLink("WFET-3187")
    private void ST_GC17() {

        new NavigationPage(driver)
                .navigateInNewTab(ticketsLink);

        new TicketsPage(driver)
                .clickMoreInfoTicketStatusIndex("In Arbeit",1)
                .validateTicketStatusDescriptionExists()
                .validateTicketCreationDateExists()
                .validateTicketNumberExists()
                .validateClosedTicketCL()
                .validateTicketStatusBarExists()
                .validateCurrentTicketStatusExists();


    }
}




