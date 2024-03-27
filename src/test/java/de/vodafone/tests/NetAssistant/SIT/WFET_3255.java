package de.vodafone.tests.NetAssistant.SIT;

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
import java.util.HashMap;

@Epic("Net Assistant")
@Feature("SIT")
@Story("WFET_3255")
public class WFET_3255 extends SITNetAssistantSetup {
    //Variables
    private String userName;
    private String userPassword;
    private String Link;
    private String emailAddress;
    private String invalidEmailAddress;
    private String mobileNumber;
    private String invalidMobileNumber;
    private HashMap<String, String> cookieSwitcherMap;

    //Test
    @BeforeMethod
    public void setup(Method method) {

        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        Link = testData.getTestData(method.getName() + ".link");
        emailAddress = testData.getTestData(method.getName() + ".emailAddress");
        invalidEmailAddress = testData.getTestData(method.getName() + ".invalidEmailAddress");
        mobileNumber = testData.getTestData(method.getName() + ".mobileNumber");
        invalidMobileNumber = testData.getTestData(method.getName() + ".invalidMobileNumber");
        cookieSwitcherMap = (HashMap<String, String>) cookieMap.getTestDataAsMap(className);
        super.setup(method);
        loginAction(cookieSwitcherMap, userName, userPassword);
    }

    @Test(description = "WFET-4329 - GC02 - Cable user - Navigate to chatbot with logged in user - Verify mass outage resolved message for multiple mass outage & Network Assistant start page redirection")
    @TmsLink("WFET-4329")
    private void GC02() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateinfoZumStörungsendeMsgExists()
                .validatezurStartseiteDesNetzAssistentenBtnExists()
                .validateinfoZumStörungsendeMsgCLExists();

    }

    @Test(description = "WFET-4331 -  GC04 - Cable user - Navigate to chatbot with logged in user - Verify mass outage success message for single mass outage & Network Assistant start page redirection")
    @TmsLink("WFET-4331")
    private void GC04() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .multipleOutageSubscriptionEmailConfirmationAction(emailAddress)
                .validateMultipleOutageInfoSubscriptionSuccess();

    }

    @Test(description = "WFET-4333 - GC06 - Cable user - Navigate to chatbot with logged in user - Verify mass outage partial success message for multiple mass outage & Network Assistant start page redirection")
    @TmsLink("WFET-4333")
    private void GC06() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .resolvedMultipleOutageSubscriptionSMSConfirmationAction(mobileNumber)
                .validateMultipleOutageInfoSubscriptionError();

    }

    @Test(description = "WFET-4335 - GC08 - Cable user - Navigate to chatbot with logged in user - Verify mass outage failure message for multiple mass outage & Network Assistant start page redirection")
    @TmsLink("WFET-4335")
    private void GC08() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .resolvedMultipleOutageSubscriptionSMSConfirmationAction(mobileNumber)
                .validateMultipleOutageInfoSubscriptionError()
                .clickOnzurStartseiteDesNetzAssistentenBtn();
        new ChatbotPage(driver)
                .validateQuestion1Exists();

    }

    @Test(description = "WFET-4336 - GC09 - Cable user - Navigate to chatbot with Logged in user - Verify save button \"Speichern\" is dimmed in case unchecked service in the first time")
    @TmsLink("WFET-4336")
    private void GC09() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateSpeichernButtonDimmed();

    }

    @Test(description = "WFET-4337 - GC10 - Cable user - Navigate to chatbot with Logged in user - Verify save button \"Speichern\" is dimmed in case unchecked service for one or more checkbox in second time")
    @TmsLink("WFET-4337")
    private void GC10() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateSpeichernButtonDimmed()
                .clickOnTVAffectedServiceRadioBtn()
                .clickOnTVAffectedServiceRadioBtn()
                .validateSpeichernButtonDimmed();

    }

    @Test(description = "WFET-4339 - GC11 - Cable user - Navigate to chatbot with Logged in user - Verify communication channel will be dimmed after unchecked service check box")
    @TmsLink("WFET-4339")
    private void GC11() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateInfoSubscriptionChannelsDimmed()
                .clickOnTVAffectedServiceRadioBtn()
                .clickOnTVAffectedServiceRadioBtn()
                .validateInfoSubscriptionChannelsDimmed();

    }

    @Test(description = "WFET-4340 - GC12 - Cable user - Navigate to chatbot with Logged in user - Verify check & uncheck all check boxes \"Alle Bereiche\" behaviour in service choice field")
    @TmsLink("WFET-4340")
    private void GC12() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateAlleBereicheControlsAllAffectedServicesCheckBoxes();

    }

    @Test(description = "WFET-4341 - GC13 - Cable user - Navigate to chatbot with Logged in user - Verify entering valid mail in contact info page")
    @TmsLink("WFET-4341")
    private void GC13() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .multipleOutageSubscriptionEmailConfirmationAction(emailAddress)
                .validateMultipleOutageInfoSubscriptionSuccess();

    }

    @Test(description = "WFET-4342 - GC14 - Cable user - Navigate to chatbot with Logged in user - Verify entering invalid mail in contact info page")
    @TmsLink("WFET-4342")
    private void GC14() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateSpeichernBtnIsDimmedWithInvalidEmail(invalidEmailAddress);

    }

    @Test(description = "WFET-4343 - GC15 - Cable user - Navigate to chatbot with Logged in user - Verify entering valid mail in contact info page after refresh")
    @TmsLink("WFET-4343")
    private void GC15() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateSpeichernBtnIsDimmedWithInvalidEmail(invalidEmailAddress)
                .refreshCurrentPage()
                .multipleOutageSubscriptionEmailConfirmationAction(emailAddress);

    }

    @Test(description = "WFET-4344 - GC16 - Cable user - Navigate to chatbot with Logged in user - Verify entering valid phone in contact info page")
    @TmsLink("WFET-4344")
    private void GC16() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .resolvedMultipleOutageSubscriptionSMSConfirmationAction(mobileNumber)
                .validateMultipleOutageInfoSubscriptionError();

    }

    @Test(description = "WFET-4346 - GC18 - Cable user - Navigate to chatbot with logged in user - Verify entering valid phone in contact info page after refresh")
    @TmsLink("WFET-4346")
    private void GC18() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateSpeichernBtnIsDimmedWithInvalidMobileNumber(invalidMobileNumber)
                .refreshCurrentPage()
                .resolvedMultipleOutageSubscriptionSMSConfirmationAction(mobileNumber);

    }

    @Test(description = "WFET-4347 - GC19 - Cable user - Navigate to chatbot with logged in user - Verify data saved after clicking back button on contact info page for E-Mail")
    @TmsLink("WFET-4347")
    private void GC19() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateSpeichernBtnIsDimmedWithInvalidEmail(invalidEmailAddress)
                .clickOnAbbrechenBtn()
                .validateChoicesAreSaved();

    }

    @Test(description = "WFET-4359 - GC20 - Cable user - Navigate to chatbot with logged in user - Verify data saved after clicking back button on contact info page for phone")
    @TmsLink("WFET-4359")
    private void GC20() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateSpeichernBtnIsDimmedWithInvalidMobileNumber(invalidMobileNumber)
                .clickOnAbbrechenBtn()
                .validateChoicesAreSaved();

    }

    @Test(description = "WFET-4369 - GC21 - Cable user - Navigate to chatbot with logged in user - Verify services returned at subscription page as exists in mass outage net assistance page")
    @TmsLink("WFET-4369")
    private void GC21() {

        new NavigationPage(driver)
                .navigateInNewTabSIT(Link);
        new ChatbotPage(driver)
                .validateQuestion1Exists()
                .validateMassOutageUMCable()
                .clickOnichMöchteEineInfoBekommenBtn();
        new DashboardPage(driver)
                .validateAlleBereicheControlsAllAffectedServicesCheckBoxes();

    }
}