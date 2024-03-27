package de.vodafone.tests.KD.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.KD.BookingTransactionPage;
import de.vodafone.pages.KD.ConfirmationPage;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11257")
public class WFBT_11257 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @TmsLink("WFBT_12060")
    @Test(description = "GC01 | WFBT-11257 | Check when I try to book an available option through Book now CTA with no conflict with no smartcard")
    public void GC01_CheckBookingFlowWithNoConflictWithNoSmartCard(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateConfirmationPageHeader(testData.getTestData(method.getName() + ".ConfirmationPageHeaderCL"))
                                    .validateConfirmationMessageWithNoDroppedOptions(testData.getTestData(method.getName() + ".ConfirmationMessageTVOptionCL"))
                                    .validateOpenWorkOrderForTVOption(testData.getTestData(method.getName() + ".OrderNotificationHeaderCL")
                                            , testData.getTestData(method.getName() + ".OrderNotificationCTACL")).clickOverviewAccordionFirstOptionTV()
                                    .validateFirstTVOptionHeader(testData.getTestData(method.getName() + ".FirstTVOptionNameCL"))
                                    .validateStartDateCard(testData.getTestData(method.getName() + ".StartDateHeadlineCL"));
    }

    @TmsLink("WFBT_12061")
    @Test(description = "GC02 | WFBT-11257 | Check Booking Transaction when no replace existing option one smartcard")
    public void GC02_CheckBookingTransactionWhenNoReplaceExistingOptionOneSmartCard(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion()
                                .validateOneSmartCardForTV(testData.getTestData(method.getName() + ".OneSmartCardNameTVCL"),
                                        testData.getTestData(method.getName() + ".OneSmartCardNumberTVCL"));
    }

    @TmsLink("WFBT_12063")
    @Test(description = "GC04 | WFBT-11257 | Check Booking Transaction in case replaces one existing option")
    public void GC04_CheckBookingTransactionInCaseReplacesOneExistingOption(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookThirdOptionTVWithCost();
        new BookingTransactionPage(driver)
                .validateOneDroppedOptionTVNotificationMessage(testData.getTestData(method.getName() + ".DroppedOptionTVNotificationMessageHeaderCL")
                        ,testData.getTestData(method.getName() + ".DropOneOptionTVNotificationMessageBodyCL"));
    }

    @TmsLink("WFBT_12064")
    @Test(description = "GC05 | WFBT-11257 | Check Booking Transaction in case the option is going to replace many existing booked options")
    public void GC05_CheckBookingTransactionInCaseTheOptionIsGoingToReplaceManyExistingBookedOptions(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFourthOptionTVWithCost();
        new BookingTransactionPage(driver)
                .validateMultipleDroppedOptionsTVNotificationMessage(testData.getTestData(method.getName() + ".DroppedOptionTVNotificationMessageHeaderCL")
                        ,testData.getTestData(method.getName() + ".SecondDroppedOptionTVCL")
                        ,testData.getTestData(method.getName() + ".ThirdDroppedOptionTVCL"));
    }

    @TmsLink("WFBT_12067")
    @Test(description = "GC08 | WFBT-11257 |  Check Confirmation page In case replacing existing option")
    public void GC08_CheckConfirmationPageInCaseReplacingExistingOption(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookThirdOptionTVWithCost();
        new BookingTransactionPage(driver)
                .validateOneDroppedOptionTVNotificationMessage(testData.getTestData(method.getName() + ".DroppedOptionTVNotificationMessageHeaderCL")
                        ,testData.getTestData(method.getName() + ".DropOneOptionTVNotificationMessageBodyCL"));
    }

    @TmsLink("WFBT_12071")
    @Test(description = "GC11 | WFBT-11257 | Check Booking Transaction page in case click on back button it will return to tariff page")
    public void GC11_CheckBookingTransactionPageInCaseClickOnBackButtonItWillReturnToTariffPage(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).clickBackCTA();
        new KabelTVPage(driver).validateBookableAccordionTitle(testData.getTestData(method.getName() + ".BookableAccordionTitleCL"))
                .validateKabelTVTitle(testData.getTestData(method.getName() + ".KabelTVTitleCL"));
    }

    @TmsLink("WFBT_12072")
    @Test(description = "GC12 | WFBT-11257 | Check Redirection while booking external bookable option")
    public void GC12_CheckRedirectionWhileBookingExternalBookableOption(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
    }

    @TmsLink("WFBT_12073")
    @Test(description = "GC13 | WFBT-11257 | Check after book an option then go back to try to book another option")
    public void GC13_CheckAfterBookAnOptionThenGoBackToTryToBookAnotherOption(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).clickOverviewAccordionFirstOptionTV()
                                    .validateFirstTVOptionHeader(testData.getTestData(method.getName() + ".FirstTVOptionNameCL"))
                                    .clickCloseCTA();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookSecondOptionTVWithCost();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateConfirmationPageHeader(testData.getTestData(method.getName() + ".ConfirmationPageHeaderCL"))
                                    .clickOverviewAccordionSecondOptionTV()
                                    .validateSecondTVOptionHeader(testData.getTestData(method.getName() + ".SecondDroppedOptionTVCL"));
    }

    @TmsLink("WFBT_12074")
    @Test(description = "GC14 | WFBT-11257 | Check the CL of legal text in the transaction page")
    public void GC14_CheckTheCLOfLegalTextInTheTransactionPage(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).validateLegalTextCard(testData.getTestData(method.getName() + ".ContractSummaryPreTextCL")
                ,testData.getTestData(method.getName() + ".ContractSummaryPostTextCL")
                ,testData.getTestData(method.getName() + ".ContractSummaryTextCL"));
    }

    @TmsLink("WFBT_12075")
    @Test(description = "GC15 | WFBT-11257 | Check that when the user clicks on hyper link, the contract summary pdf is downloaded")
    public void GC15_CheckThatWhenTheUserClicksOnHyperLinkTheContractSummaryPdfIsDownloaded(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).clickContractSummaryPDFHyperLink();
    }

    @TmsLink("WFBT_12076")
    @Test(description = "BC01 | WFBT-11257 | Check Booking Transaction page in case of General Error Screen with status code 422 Available")
    public void BC01_CheckBookingTransactionPageInCaseOfGeneralErrorScreenWithStatusCode422Available(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTvFree();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateErrorScreenNotificationAvailableMessage(testData.getTestData(method.getName() + ".ErrorNotificationHeaderCL"),testData.getTestData(method.getName() + ".ErrorScreenAvailableNotificationSubLineCL"));
    }

    @TmsLink("WFBT_12077")
    @Test(description = "BC02 | WFBT-11257 | Check Booking Transaction page in case of General Error Page")
    public void BC02_CheckBookingTransactionPageInCaseOfGeneralErrorPage(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateErrorNotificationMessage(testData.getTestData(method.getName() + ".ErrorNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ErrorNotificationSubLineCL"));
    }

    @TmsLink("WFBT_12078")
    @Test(description = "BC03 | WFBT-11257 | Check try again Notification message when click on hyper link and fail")
    public void BC03_CheckTryAgainNotificationMessageWhenClickOnHyperLinkAndFail(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).clickContractSummaryPDFHyperLink()
                                         .validateTryAgainNotification(testData.getTestData(method.getName() + ".TryAgainNotificationHeaderCL")
                                                                        ,testData.getTestData(method.getName() + ".TryAgainNotificationSubLineCL")
                                                                        ,testData.getTestData(method.getName() + ".TryAgainNotificationCTACL"));
    }

    @TmsLink("WFBT_12543")
    @Test(description = "BC04 | WFBT-11257 | Check Booking Transaction page in case of Try again notification with status code 422 Unavailable")
    public void BC04_CheckBookingTransactionPageInCaseOfTryAgainNotificationWithStatusCode422Unavailable(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookableOptionAccordion().clickBookFirstOptionTVWithCost();
        new BookingTransactionPage(driver).clickBookWithCostCTA()
                                        .validateTryAgainNotification(testData.getTestData(method.getName() + ".TryAgainNotificationHeaderCL")
                                                                     ,testData.getTestData(method.getName() + ".TryAgainNotificationSubLineCL")
                                                                     ,testData.getTestData(method.getName() + ".TryAgainNotificationCTACL"));
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KD/ST/ST_" + className + "_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "KD/ST/" + className + ".json");
    }

    @BeforeMethod
    @Description("Setting User Name, Login and Click accept cookies")
    public void setup(Method method) {
        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        driver = new SHAFT.GUI.WebDriver();
        new LoginPage(driver).navigateST()
                .setCookieSwitchers(cookieMap)
                .acceptCookies()
                .loginST(userName, userPassword);
    }

    @AfterMethod
    @Description("Close the browser after the test")
    public void tearDown() {
        driver.browser().closeCurrentWindow();
    }
}