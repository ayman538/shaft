package de.vodafone.tests.NetAssistant.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_3016 extends SITNetAssistantSetup {
    //Variables
    private String chatbot_Deeplink;
    private String tickets_Deeplink;
    private String userName;
    private String password;
    private String deeplink;
    private String mobileNumber;
    private  HashMap<String,String> cookieSwitcherMap;
    private List<String> Steps;
    private HashMap<String, ArrayList> dslTree;
    private HashMap<String, ArrayList> cableTree;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        chatbot_Deeplink = testData.getTestData(method.getName()+".link");
        tickets_Deeplink = testData.getTestData(method.getName()+".link");
        userName = testData.getTestData(method.getName() + ".name");
        password = testData.getTestData(method.getName() + ".password");
        deeplink = testData.getTestData(method.getName() + ".link");
        mobileNumber = testData.getTestData(method.getName() + ".mobileNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        Steps = (List<String>) testData.getTestDataAsList(method.getName() + ".Steps");
        dslTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("dslTree");
        cableTree = (HashMap) chatbotDecisionTreeJSONFile.getTestDataAsMap("cableTree");
        super.setup(method);

    }

    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("SIT - GC09 - DSL user - Verify Chatbot with no massoutage")
    private void SIT_GC09() {

        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .navigate(chatbot_Deeplink)
                .acceptCookies()
                .validateNoMassOutageMessage();

    }
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("SIT - GC19 - Cable user - Verify Chatbot with massoutage")
    private void SIT_GC19() {

        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();
        new ChatbotPage(driver)
                .navigate(chatbot_Deeplink)
                .acceptCookies()
                .validateMassOutageMessage();

    }
    @Test(description = "WFET-3016 - SIT - GC11 - DSL user - Verify Chatbot callback service success")
    @TmsLink("WFET-3016")
    private void SIT_GC11() {
        new LoginPage(driver)
                .navigateSIT()
                .setCookieSwitchers(cookieSwitcherMap)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, dslTree)
                .fillCallbackForm(mobileNumber)
                .validateCallBackServiceSucess();

    }
    @Test(description = "WFET-3016 - SIT - GC18 - DSL user - Verify Chatbot callback service success")
    @TmsLink("WFET-3016")
    private void SIT_GC18() {
        new LoginPage(driver)
                .navigateSIT()
                .setCookieSwitchers(cookieSwitcherMap)
                .acceptCookies()
                .loginSIT(userName, password)
                .validateLoginIndicatorExists();

        new ChatbotPage(driver)
                .navigateInNewTabSIT(deeplink)
                .validateQuestion1Exists()
                .clickOnJaButton();

        new ChatbotPage(driver)
                .getDecisionButton(Steps.size(), Steps, cableTree)
                .fillCallbackForm(mobileNumber)
                .validateCallBackServiceSucess();

    }

    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("Cable user  - Verify Chatbot with no massoutage")
    private void SIT_GC20() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateNoMassOutageMessage()
                .validateQuestion1Exists()
                .validateJaButtonExists()
                .validateNeinButtonExists();

    }

    //Hadeer
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("DSL - Deeplink to Net Assistant tickets- Verify Close ticket button with ticket State Inprogress")
    private void SIT_GC01() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .exists()
                .withCustomReportMessage("ticket with status inprogess displayed")
                .perform();
        new TicketsPage(driver)
                .clickMoreInfoButton();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Close_Ticket_Button())
                .exists()
                .withCustomReportMessage("close ticket button displayed for inprogress ticket")
                .perform();
    }
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("DSL - Deeplink to Net Assistant Tickets - Verify Close ticket button with ticket State Solved")
    private void SIT_GC02() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getResolvedTicketStatus())
                .exists()
                .withCustomReportMessage(" ticket with status solved displayed")
                .perform();
        new TicketsPage(driver)
                .clickMoreInfoButton();


        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Reopen_Ticket_Button() )
                .exists()
                .withCustomReportMessage("reopen ticket button should displayed for solved ticket")
                .perform();

    }

    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("DSL - Deeplink to Net Assistant tickets- Check ticket details view with text description when clicking on more info button for inprogress ticket status")
    private void SIT_GC04() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .exists()
                .withCustomReportMessage("ticket with status inprogess displayed")
                .perform();
        new TicketsPage(driver)
                .clickMoreInfoButton();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status())
                .exists()
                .withCustomReportMessage("status=inprogress in ticket details")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status_Bar())
                .exists()
                .withCustomReportMessage("status bar displayed in ticket details for inprogress tickets")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_ticket_status_description())
                .exists()
                .withCustomReportMessage("ticket status description displayed")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTicket_tittle())
                .exists()
                .withCustomReportMessage("ticket tittle displayed")
                .perform();
    }
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("DSL - Deeplink to Net Assistant Tickets - Check ticket details view with text description when clicking on more info button for resolved ticket status")
    private void SIT_GC05() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getResolvedTicketStatus())
                .exists()
                .withCustomReportMessage(" ticket with status solved displayed")
                .perform();
        new TicketsPage(driver)
                .clickMoreInfoButton();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status())
                .exists()
                .withCustomReportMessage("status= solved at ticket details")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Details_Status_Bar())
                .exists()
                .withCustomReportMessage("status bar displayed in ticket details for solved tickets")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_ticket_status_description())
                .exists()
                .withCustomReportMessage("ticket status solved description displayed")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getTicket_tittle())
                .exists()
                .withCustomReportMessage("ticket tittle displayed")
                .perform();

    }
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("DSL - Deeplink to Net Assistant Tickets - Verify Reopen ticket button with ticket state solved")
    private void SIT_GC03() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getResolvedTicketStatus())
                .exists()
                .withCustomReportMessage(" ticket with status solved displayed")
                .perform();
        new TicketsPage(driver)
                .clickMoreInfoButton();
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
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("Cable - Deeplink to Net Assistant tickets- Verify Close ticket button with ticket State Inprogress")
    private void SIT_GC13() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .exists()
                .withCustomReportMessage("ticket with status inprogess displayed")
                .perform();
        new TicketsPage(driver)
                .clickMoreInfoButton();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Close_Ticket_Button())
                .exists()
                .withCustomReportMessage("close ticket button displayed for inprogress ticket")
                .perform();
    }
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("Cable - Deeplink to Net Assistant Tickets - Verify Close ticket button with ticket State Solved")
    private void SIT_GC14() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.getResolvedTicketStatus())
                .exists()
                .withCustomReportMessage(" ticket with status solved displayed")
                .perform();
        new TicketsPage(driver)
                .clickMoreInfoButton();
        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Close_Ticket_Button())
                .doesNotExist()
                .withCustomReportMessage("close ticket button should not displayed for solved ticket")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Reopen_Ticket_Button())
                .exists()
                .withCustomReportMessage("reopen ticket button should displayed for solved ticket")
                .perform();
    }
    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("SIT - GC15 - Cable user - Deeplink to Net Assistant App - Verify Refresh Button and choices behaviour after Session ends")
    private void SIT_GC15() {
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink);

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.getOpenTicketDetailsInfoButtonText()).
                exists().
                perform();

        new TicketsPage(driver).
                clickMoreInfoButton();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Reopen_Ticket_Button())
                .text()
                .isEqualTo("Ticket wieder öffnen");

        new TicketsPage(driver).
                Click_Reopen_Ticket_Button().
                clickOn(TicketsPage.get_Go_On_Button()).
                Click_Reopen_Ticket_Button().
                Click_Problem_Still_Exists_Button().
                Enter_Data(TicketsPage.get_Contact_Number_Text_Field(),"012312321333").
                Enter_Data(TicketsPage.get_Problem_Description_Text_Field(),"facing some issues").
                clickOn(TicketsPage.get_Ready_Button()).
                clickOn(TicketsPage.get_Ja_Button());

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Refresh_Button())
                .text().
                isEqualTo(" Neu starten").
                perform();
    }

    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3016")
    @Description("SIT - GC16 - Cable user - Deeplink to Net Assistant Ticket Details View - Check ticket details view with text description when clicking on \" more info \" button for \"inprogress\" ticket status")
    private void SIT_GC16(){
        new TicketsPage(driver).
                navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink);

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.getOpenTicketDetailsInfoButtonText()).
                text().
                isEqualTo("Mehr info").
                perform();

        new TicketsPage(driver).
                clickMoreInfoButton();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Ticket_Details_Ticket_Title()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Ticket_Creation_Date()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Ticket_Number()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.getStatus()).
                text().
                isEqualTo("In Arbeit").
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Status_Bar()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Current_Ticket_Status()).
                exists().
                perform();
    }

    @Test(groups={"WFET_3016","regression"})
    @TmsLink("WFET-3187")
    @Description("SIT - GC17 - Cable user - Deeplink to Net Assistant Ticket Details View - Check ticket details view with text description when clicking on \" more info \" button for \"resolved\" ticket status")
    private void SIT_GC17() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver).
                acceptCookies().
                navigate(tickets_Deeplink);

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.getOpenTicketDetailsInfoButtonText()).
                text().
                isEqualTo("Mehr info").
                perform();

        new TicketsPage(driver).
                clickMoreInfoButton();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Ticket_Details_Ticket_Title()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Ticket_Creation_Date()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Ticket_Number()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.getStatus()).
                text().
                isEqualTo("Gelöst").
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Status_Bar()).
                exists().
                perform();

        Validations.assertThat().
                element(driver.getDriver(), TicketsPage.get_Current_Ticket_Status()).
                exists().
                perform();
    }
}




