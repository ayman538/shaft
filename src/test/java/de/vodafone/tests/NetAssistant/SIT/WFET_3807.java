package de.vodafone.tests.NetAssistant.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.NetAssistant.DashboardPage;
import de.vodafone.pages.NetAssistant.TicketsPage;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.HelpPage;

import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_3807 extends SITNetAssistantSetup {
    //Variables
    private String user_Name;
    private String user_Password;
    private String chatbot_Deeplink;
    private String tickets_Deeplink;

    //Test
    @BeforeMethod
    public void setup(Method method) {
        user_Name = testData.getTestData(method.getName() + ".name");
        user_Password = testData.getTestData(method.getName() + ".password");
        chatbot_Deeplink = testData.getTestData(method.getName() + ".link");
        tickets_Deeplink = testData.getTestData(method.getName() + ".link");
        super.setup(method);

    }
    //diaa
    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-697")
    @Description("CABLE user - Navigate to meinVodafone dashboard - Verify Netz-assistent smart object - Click on Smart object")
    private void SIT01_CABLE_USER(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate()
                .acceptCookies();

        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .closeStickyNotifications()
                .clickOn(DashboardPage.getCableAccordion())
                .clickOn(DashboardPage.getInternetAndPhoneAccordion())
                .validateNetAssistantSmartObjectLocatorExist()
                .validateNetAssistantSmartObjectHeaderLocatorText()
                .validateNetAssistantSmartObjectFooterLocatorText();



    }

    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-705")
    @Description("DSL User - Navigate to meinVodafone DashboardPage - Verify Netz-assistent smart object - Click on Smart object")
    private void SIT01_DSL_USER(){
        new DashboardPage(driver)
                .navigate();
        setCookieECHO();

        new DashboardPage(driver)
                .navigate()
                .acceptCookies();

        new LoginPage(driver)
                .loginSIT(user_Name,user_Password);

        new DashboardPage(driver)
                .closeStickyNotifications()
                .clickOn(DashboardPage.getDslAccordion())
                .clickOn(DashboardPage.getDslProducteAccordionInternet())
                .validateNetAssistantSmartObjectLocatorExist()
                .validateNetAssistantSmartObjectHeaderLocatorText()
                .validateNetAssistantSmartObjectFooterLocatorText();
    }

    //hadeer
    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-596")
    @Description("SIT - GC01 -Cable user -Deeplink to Net-Assistant App - Verify Two tabs added on the top of the page")
    private void SIT_GC01() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Chatbot_Tab_Header())
                .exists()
                .withCustomReportMessage("chatbot tab should be displayed")
                .perform();
        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Tab_Header())
                .exists()
                .withCustomReportMessage("tickets tab should be displayed")
                .perform();


    }

    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-597")
    @Description("SIT - GC02 -DSL user- Deeplink to Net-Assistant App - Verify Two tabs added on the top of the page")
    private void SIT_GC02() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink);

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Chatbot_Tab_Header())
                .exists()
                .withCustomReportMessage("chatbot tab should be displayed")
                .perform();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Tab_Header())
                .exists()
                .withCustomReportMessage("tickets tab should be displayed")
                .perform();


    }
    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-610")
    @Description("SIT - GC03 -cable user- Deeplink to Net-Assistant App -  Click on Ticket Tab - Verify the page")
    private void SIT_GC03() {
        new TicketsPage(driver)
                .navigate();
        setCookieECHO();

        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .clickOn(TicketsPage.get_Tickets_Tab_Header())
                .searchForOpenTicketByStatus("In Arbeit");


        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.getInprogressTicketStatus())
                .exists()
                .withCustomReportMessage("ticket with status inprogress displayed ")
                .perform();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Number())
                .exists()
                .withCustomReportMessage("tickets number displayed ")
                .perform();

        Validations.assertThat()
                .element(driver.getDriver(), TicketsPage.get_Ticket_Creation_Date())
                .exists()
                .withCustomReportMessage("tickets creation date displayed")
                .perform();
    }

    //mostafa
    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-3146")
    @Description("UM user - Go to Net Assistant through Deeplink - Verify the C_ID Value is Updated in URL")
    private void SIT_GC02_UM_User() {

        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink);

        new HelpPage(driver)
                .getCurruntURL();
        Validations
                .assertThat()
                .browser(driver.getDriver())
                .url()
                .contains("c_id=hilfe_netzass_um")
                .withCustomReportMessage("C_ID updated")
                .perform();
    }

    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-2872")
    @Description("Unity Media user - Login with Deep Link - Check if Decision Tree appear in chatbot")
    private void SIT_GC03_UM_User() {

        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .clickOn(ChatbotPage.getGoonButton())
                .validateChatbotDecesionTree();


    }
    @Test(groups = {"WFET_3807", "regression"})
    @TmsLink("WFET-834")
    @Description("DSL user- Chrome - Deeplink to Net-Assistant App - Click on Ticket Tab - Verify the page")
    private void SIT_GC04_DSL_User() {

        new TicketsPage(driver)
                .navigate();
        setCookieECHO();
        new TicketsPage(driver)
                .acceptCookies()
                .navigate(tickets_Deeplink)
                .clickOn(TicketsPage.get_Tickets_Tab_Header());

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Tab_Header())
                .text()
                .isEqualTo("Meine Störungstickets")
                .perform();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tobi_Clock_Icon())
                .exists()
                .withCustomReportMessage("Tobi Clock Icon Exists")
                .perform();

        Validations
                .assertThat()
                .element(driver.getDriver(), TicketsPage.get_Tickets_Message())
                .text()
                .isEqualTo("Hallo!")
                .perform();

    }
}
