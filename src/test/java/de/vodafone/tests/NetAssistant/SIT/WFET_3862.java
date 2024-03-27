package de.vodafone.tests.NetAssistant.SIT;

import com.shaft.validation.Validations;
import de.vodafone.pages.NetAssistant.ChatbotPage;
import de.vodafone.pages.NetAssistant.HelpPage;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Net Assistant")
@Feature("SIT")
public class WFET_3862 extends SITNetAssistantSetup {
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

    @Test(groups = {"WFET_3862", "regression"})
    @TmsLink("WFET-584")
    @Description("Cable user - Deeplink to Net-Assistant App without query parameter \"C\" - Verify the page")
    private void GC01_Cable_user(){
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();
        (new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage())
                .validateTobiIconExists()
                .validateQuestion1Exists()
                .validateChatbotHeaderExists()
                .validateTicketsHeaderExists();
    }

    @Test(groups = {"WFET_3862", "regression"})
    @TmsLink("WFET-586")
    @Description("Cable user - Deeplink to Net-Assistant App without query parameter \"I\" - Verify the page")
    private void GC02_Cable_user() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage()
                .validateTobiIconExists()
                .validateQuestion1Exists()
                .validateInfoIconExists()
                .validateChatbotHeaderExists()
                .validateTicketsHeaderExists();
    }

    @Test(groups = {"WFET_3862", "regression"})
    @TmsLink("WFET-587")
    @Description("Cable user - Deeplink to Net-Assistant App without query parameter \"C\" & \"I\" - Verify the page")
    private void GC03_Cable_user() {
        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage()
                .validateTobiIconExists()
                .validateQuestion1Exists()
                .validateInfoIconExists()
                .validateChatbotHeaderExists()
                .validateTicketsHeaderExists();

    }

    @Test(groups = {"WFET_3862", "regression"})
    @TmsLink("WFET-3144")
    @Description("UM user - Deeplink to Net Assistant through Help Form - Verify the C_ID Value is Updated in URL")
    private void GC01_UM_user() {
        new ChatbotPage(driver)
                .navigate(chatbot_Deeplink);
        setCookieECHO();
        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateQuestion1Exists();

        new HelpPage(driver)
                .getCurruntURL();
        Validations.assertThat().browser(driver.getDriver()).url().contains("c_id=hilfe_netzass_um")
                .withCustomReportMessage("C_ID updated")
                .perform();
    }
    // hadeer Tests
    @Test(groups = {"WFET_3862", "regression"})
    @TmsLink("WFET-2741")
    @Description("Cable user - Navigate to Net Assisstant Portal through entry form - Check Redirection with Valid Cable Customer ID + UM Region")
    private void SIT_GC2741() {
        new ChatbotPage(driver)
                .navigate(chatbot_Deeplink);
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateHelpHeaderExists();

        new HelpPage(driver)
                .EnterCustomerID()
                .Clicklosgehst();

        Validations.assertThat()
                .element(driver.getDriver(), HelpPage.getQrCodePageHeader())
                .exists()
                .withCustomReportMessage("Qr code page displayed")
                .perform();

        new HelpPage(driver)
                .ClickZurversiondesktop()
                .SwitchToTab();

        Validations.verifyThat()
                .element(driver.getDriver(),ChatbotPage.getChatboTabHeader() )
                .exists()
                .withCustomReportMessage("exists")
                .perform();

    }
    @Test(groups = {"WFET_3862", "regression"})
    @TmsLink("WFET-495")
    @Description("Cable user - Deeplink to NetAssistant App with user has one faultinfo - Verify specific message returned || FF")
    private void GC495_Cable_user() {

        new ChatbotPage(driver)
                .navigate();
        setCookieECHO();

        new ChatbotPage(driver)
                .acceptCookies()
                .navigate(chatbot_Deeplink)
                .validateMassOutageMessage()
                .validateTobiIconExists()
                .validateQuestion1Exists();


    }
}
