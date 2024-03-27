package de.vodafone.tests.KD.ST;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.KD.BookingTransactionPage;
import de.vodafone.pages.KD.ConfirmationPage;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import de.vodafone.pages.commons.LoginPage;
import io.qameta.allure.*;
import org.testng.annotations.*;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11053")

public class WFBT_11053 {
    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String className = this.getClass().getName().replace(this.getClass().getPackageName() + ".", "");

    @TmsLink("WFBT_11540")
    @Test(description = "GC01 Check Booking Transaction when click Book Now CTA when no replace existing option Bookable Options Internet Accordion")
    public void GC01BookingTransactionNoReplaceExistingOptionInternet(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).validateAccordionHeaderTitleInternet(testData.getTestData(method.getName() + ".AccordionHeaderTitleInternetCL"))
        .validateInternetFirstOptionCard(testData.getTestData(method.getName() + ".InternetFirstOptionNameCL"),
                testData.getTestData(method.getName() + ".InternetFirstOptionPriceCL"))
                .validateInternetFirstOptionStartDateCard(testData.getTestData(method.getName() + ".StartDateInternetFirstOptionHeadlineCL"))
        .validateBookWithCostCTACL(testData.getTestData(method.getName() + ".BookWithCostCTACL")).clickBookWithCostCTA();
    }

    @TmsLink("WFBT_11541")
    @Test(description = "GC02 Check Booking Transaction in case replaces one existing option Bookable Options Internet Accordion")
    public void GC02BookingTransactionReplacesOneExistingOptionInternet(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstOptionCTA();
        new BookingTransactionPage(driver).validateConflictOptionNotification(testData.getTestData(method.getName() + ".ExistingOptionNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ExistingOptionNotificationSubLineOneOptionCL"));
    }

    @TmsLink("WFBT_11542")
    @Test(description = "GC03 Check Booking Transaction in case the option is going to replace many existing booked options Bookable Options Internet Accordion")
    public void GC03BookingTransactionReplacesManyExistingOptionInternet(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstOptionCTA();
        new BookingTransactionPage(driver).validateConflictOptionNotification(testData.getTestData(method.getName() + ".ExistingOptionNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ExistingOptionNotificationSubLineOneOptionCL"));
    }

    @TmsLink("WFBT_11545")
    @Test(description = "GC06 Check Confirmation page after user click on Kostenpflichtig buchen CTA in case no replace option Bookable Options Internet Accordion")
    public void GC06ConfirmationPageNoReplaceExistingOptionInternet(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateConfirmationPageHeader(testData.getTestData(method.getName() + ".ConfirmationPageHeaderCL"))
        .validateConfirmationCard(testData.getTestData(method.getName() + ".ConfirmationNotificationHeaderCL"))
                .validateInternetOrderNotificationCard(testData.getTestData(method.getName() + ".OrderNotificationHeaderCL")
                        ,testData.getTestData(method.getName() + ".OrderNotificationCTACL")).clickOrderViewAccordion()
                .validateInternetOptionCard(testData.getTestData(method.getName() + ".InternetOptionNameCL")
                        ,testData.getTestData(method.getName() + ".InternetOptionPriceCL"))
                .validateStartDateCard(testData.getTestData(method.getName() + ".StartDateHeadlineCL"))
                .validateCloseCTACL(testData.getTestData(method.getName() + ".CloseCTACL"));
    }

    @TmsLink("WFBT_11549")
    @Test(description = "GC09 Check Booking Transaction in case click on back button it will return to tariff page Bookable Options Internet Accordion")
    public void GC09BookingTransactionInCaseOnBackButton(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).clickBackCTA();
        new TariffPageInternetAndPhone(driver)
                .validateBookableInternetAccordionHeaderCL(testData.getTestData(method.getName() + ".BookableInternetOptionsAccordionHeaderCL"))
                .assertOnPageHeader(testData.getTestData(method.getName() + ".PageHeaderCL"));
    }

    @TmsLink("WFBT_11551")
    @Test(description = "GC10 Check Booking Transaction when click Book now CTA, no replace existing option Bookable Options Telephone Accordion")
    public void GC10BookingTransactionNoReplaceExistingOptionTelephone(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickBookNowPhoneFirstOptionCTA();
        new BookingTransactionPage(driver).validateAccordionHeaderTitleTelefon(testData.getTestData(method.getName() + ".AccordionHeaderTitleTelefonCL"))
                    .validatePhoneFirstOptionCard(testData.getTestData(method.getName() + ".PhoneFirstOptionNameCL")
                            ,testData.getTestData(method.getName() + ".PhoneFirstOptionPriceCL"))
                    .validatePhoneFirstOptionStartDateCard(testData.getTestData(method.getName() + ".StartDatePhoneFirstOptionHeadlineCL"))
                    .validateBookWithCostCTACL(testData.getTestData(method.getName() + ".BookWithCostCTACL")).clickBookWithCostCTA();
    }

    @TmsLink("WFBT_11552")
    @Test(description = "GC11 Check Booking Transaction in case replaces one existing option Bookable Options Telephone Accordion")
    public void GC11BookingTransactionReplacesOneExistingOptionTelephone(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickBookNowPhoneFirstOptionCTA();
        new BookingTransactionPage(driver).validateConflictOptionNotification(testData.getTestData(method.getName() + ".ExistingOptionNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ExistingOptionNotificationSubLineOneOptionCL"));
    }

    @TmsLink("WFBT_11553")
    @Test(description = "GC12 Check Booking Transaction in case the option is going to replace many existing booked options Bookable Options Telephone Accordion")
    public void GC12BookingTransactionReplacesManyExistingOptionTelephone(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickBookNowPhoneFirstOptionCTA();
        new BookingTransactionPage(driver).validateConflictOptionNotification(testData.getTestData(method.getName() + ".ExistingOptionNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ExistingOptionNotificationSubLineOneOptionCL"));
    }

    @TmsLink("WFBT_11556")
    @Test(description = "GC15 Check Confirmation page after user click on Kostenpflichtig buchen CTA in case no replace option Bookable Options Telephone Accordion")
    public void GC15ConfirmationPageNoReplaceExistingOptionTelephone(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickBookNowPhoneFirstOptionCTA();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateConfirmationPageHeader(testData.getTestData(method.getName() + ".ConfirmationPageHeaderCL"))
                .validateConfirmationCard(testData.getTestData(method.getName() + ".ConfirmationNotificationHeaderCL"))
                .validatePhoneOrderNotificationCard(testData.getTestData(method.getName() + ".OrderNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".OrderNotificationCTACL")).clickOrderViewAccordion()
                .validatePhoneOptionCard(testData.getTestData(method.getName() + ".PhoneOptionNameCL")
                        ,testData.getTestData(method.getName() + ".PhoneOptionPriceCL"))
                .validateStartDateCard(testData.getTestData(method.getName() + ".StartDateHeadlineCL"))
                .validateCloseCTACL(testData.getTestData(method.getName() + ".CloseCTACL"));
    }

    @TmsLink("WFBT_11559")
    @Test(description = "GC18 Check redirection while booking external booking option")
    public void GC18RedirectionWhileBookingExternalBookingOption(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookExternalOptionCTA();
    }

    @TmsLink("WFBT_11560")
    @Test(description = "GC19 Check when cancel an option before confirmation and book another option check Contract Summery")
    public void GC19CheckContractSummary(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).clickBackCTA();
        new TariffPageInternetAndPhone(driver).clickBookNowInternetSecondOptionCTA();
        new BookingTransactionPage(driver).validateInternetSecondOptionCard(testData.getTestData(method.getName() + ".InternetSecondOptionNameCL")
        ,testData.getTestData(method.getName() + ".InternetSecondOptionPriceCL"));
    }

    @TmsLink("WFBT_11688")
    @Test(description = "GC20 Check Transaction page when no return dropped options in Both internet and Telephone")
    public void GC20CheckTransactionPageWhenNoReturnOptions(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).validateNotExistOneOptionNotification().validateNotExistingMultipleOptionsNotification();
    }

    @TmsLink("WFBT_11780")
    @Test(description = "GC021 Check that Book Now CTA is missing booking channel")
    public void GC21CheckthatBookNowCTAIsMissingBookingChannel(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().validateBookNowIsMissing();
    }

    @TmsLink("WFBT_11548")
    @Test(description = "BC01 Check Booking Transaction page in case of General Error Bookable Options Internet Accordion")
    public void BC01BookingTransactionGeneralError(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateErrorNotificationMessage(testData.getTestData(method.getName() + ".ErrorNotificationHeaderCL")
                        ,testData.getTestData(method.getName() + ".ErrorNotificationSubLineCL"))
                .validateReturnCTACL(testData.getTestData(method.getName() + ".ReturnCTACL"));
    }

    @TmsLink("WFBT_11689")
    @Test(description = "BC02 Check Try again message when there is problem in order Available Buchbare Optionen Internet")
    public void BC02CheckErrorMessageOrderAvailableBookableOptionsInternetAccordion(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateErrorMessageNotification(testData.getTestData(method.getName() + ".ErrorNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ErrorNotificationSubLineCL"));
    }

    @TmsLink("WFBT_11690")
    @Test(description = "BC03 Check Try again message when there is problem in booking an option Unavailable Buchbare Optionen Internet")
    public void BC03CheckTryAgainMessageOrderUnAvailableBookableOptionsInternetAccordion(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstOptionCTA();
        new BookingTransactionPage(driver).clickBookWithCostCTA()
                .validateTryAgainNotification(testData.getTestData(method.getName() + ".TryAgainNotificationHeaderCL")
                        ,testData.getTestData(method.getName() + ".TryAgainNotificationSubLineCL")
                        ,testData.getTestData(method.getName() + ".TryAgainNotificationCTACL"));
    }

    @TmsLink("WFBT_11699")
    @Test(description = "BC04 Check Try again message when there is problem in booking an option Available Buchbare Optionen Telephone")
    public void BC04CheckErrorMessageOrderAvailableBookableOptionsTelephoneAccordion(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickBookNowPhoneFirstOptionCTA();
        new BookingTransactionPage(driver).clickBookWithCostCTA();
        new ConfirmationPage(driver).validateErrorMessageNotification(testData.getTestData(method.getName() + ".ErrorNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ErrorNotificationSubLineCL"));
    }

    @TmsLink("WFBT_11700")
    @Test(description = "BC05 Check Try again message when there is problem in booking an option Unavailable Buchbare Optionen Telephone")
    public void BC05CheckTryAgainMessageOrderUnAvailableBookableOptionsTelephoneAccordion(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickBookNowPhoneFirstOptionCTA();
        new BookingTransactionPage(driver).clickBookWithCostCTA()
                .validateTryAgainNotification(testData.getTestData(method.getName() + ".TryAgainNotificationHeaderCL")
                        ,testData.getTestData(method.getName() + ".TryAgainNotificationSubLineCL")
                        ,testData.getTestData(method.getName() + ".TryAgainNotificationCTACL"));
    }

    @BeforeClass()
    @Description("Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>)
                new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "KD/ST/ST_" + className + "_CookieSwitcher.json")
                        .getTestDataAsMap("$");
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