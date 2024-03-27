package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11628")
public class WFBT_11628 extends ST_KDSetup {
    @TmsLink("WFBT-12261")
    @Test(description = "GC01 | WFBT-12261 | Check cancellation flow (success flow)")
    public void checkUserCanCancelOptionSuccessfully(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new CancellationConfirmationPage(driver)
                .validateConfirmationNotificationBody(
                        testData.getTestData(method.getName() + ".ConfirmationNotificationCL"));
    }

    @TmsLink("WFBT-12262")
    @Test(description = "GC02 | WFBT-12262 | Validate confirmation page details")
    public void validateConfirmationPageDetails(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new CancellationConfirmationPage(driver).assertOnConfirmationPageLink
                        (testData.getTestData(method.getName() + ".ConfirmationPageURL"))
                .validateCancellationConfirmationPageHeader
                        (testData.getTestData(method.getName() + ".ConfirmationPageHeaderCL"))
                .assertOnContractNumber
                        (testData.getTestData(method.getName() + ".ContractNumberCL"))
                .validateConfirmationNotificationBody(
                        testData.getTestData(method.getName() + ".ConfirmationNotificationCL"))
                .assertOnOpenworkOrderNotification()
                .assertOnOptionOverviewDropDown(
                        testData.getTestData(method.getName() + ".OverviewDropDownCL"))
                .validateCanceledOptionCard(
                        testData.getTestData(method.getName() + ".OptionNameCL"),
                        testData.getTestData(method.getName() + ".OptionsDescriptionCL"),
                        testData.getTestData(method.getName() + ".OptionPriceCL"))
                .validateCancellationDateCardCard(
                        testData.getTestData(method.getName() + ".CancellationHeaderCL"));
    }

    @TmsLink("WFBT-12263")
    @Test(description = "GC03 | WFBT-12263 | Validate open work notification in confirmation page")
    public void validateOpenWorkNotificationInConfirmationPage(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new CancellationConfirmationPage(driver).validateOpenworkOrderNotification(
                    testData.getTestData(method.getName() + ".OpenWorkNotificationHeaderCL"),
                    testData.getTestData(method.getName() + ".OpenWorkNotificationTextCL1"),
                    testData.getTestData(method.getName() + ".OpenWorkNotificationTextCL2"),
                    testData.getTestData(method.getName() + ".OpenWorkNotificationTextCL3"),
                    testData.getTestData(method.getName() + ".OpenWorkNotificationButtonCL"))
            .assertOnOpenWorkOrderNotificationRedirection(testData.getTestData(method.getName() + ".OpenWorkNotificationButtonURL"));
    }

    @TmsLink("WFBT-12264")
    @Test(description = "GC04 | WFBT-12264 | Validate Transaction page details.")
    public void validateTransactionPageDetails(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver)
                .assertOnTransactionPageLink(
                        testData.getTestData(method.getName() + ".TransactionPageURL"))
                .validateCancellationPageHeader(
                        testData.getTestData(method.getName() + ".CancellationTransactionPageHeaderCL"))
                .assertOnContractNumber(
                        testData.getTestData(method.getName() + ".ContractNumberCL"))
                .assertOnTextHeader(
                        testData.getTestData(method.getName() + ".TextHeaderCL"),
                        testData.getTestData(method.getName() + ".OptionNameCL"))
                .validateCanceledOptionCard(
                        testData.getTestData(method.getName() + ".OptionNameCL"),
                        testData.getTestData(method.getName() + ".OptionsDescriptionCL"),
                        testData.getTestData(method.getName() + ".OptionPriceCL"))
                .validateCancellationDateCardCard(
                        testData.getTestData(method.getName() + ".CancellationHeaderCL"))
                .validateCancellationLegalTextCard(
                        testData.getTestData(method.getName() + ".ContractSummaryPreTextCL"),
                        testData.getTestData(method.getName() + ".ContractSummaryTextCL"),
                        testData.getTestData(method.getName() + ".ContractSummaryPostTextCL"))
                .validateCancelOptionCTACL(
                        testData.getTestData(method.getName() + ".ProceedCTACL"));
    }

    @TmsLink("WFBT-12265")
    @Test(description = "GC05 | WFBT-12265 | Check that when the user clicks on hyper link, the contract summary pdf is downloaded")
    public void checkThatContractSummaryPDFIsDownloaded(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnContractSummeryToDownload().assertOnContractSummaryPDF();
    }

    @TmsLink("WFBT-12269")
    @Test(description = "BC01 | WFBT-12269 | Check cancellation flow (failure flow)")
    public void checkRedirectionToErrorPageWhenCancellationFailed(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA()
                .validateErrorScreenNotification(
                        testData.getTestData(method.getName() + ".GeneralErrorNotificationMessageHeaderCL"),
                        testData.getTestData(method.getName() + ".GeneralErrorNotificationMessageTextCL"));
    }

    @TmsLink("WFBT-12270")
    @Test(description = "BC02 | WFBT-12270 | Check BE general error when an error occurs during transaction")
    public void checkRedirectionToErrorPageDuringTransaction(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen()
                .validateBackEndErrorMessageDuringCancellationTransaction(
                        testData.getTestData(method.getName() + ".GeneralErrorNotificationMessageHeaderCL"),
                        testData.getTestData(method.getName() + ".GeneralErrorNotificationMessageTextCL"));
    }

    @TmsLink("WFBT-12272")
    @Test(description = "BC04 | WFBT-12272 | Check transaction page when order service failure (422 - available)")
    public void checkRedirectionToErrorPageWhenOrderReturns422Available(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA()
                .validateErrorScreenNotification(
                        testData.getTestData(method.getName() + ".AvailableErrorNotificationMessageHeaderCL"),
                        testData.getTestData(method.getName() + ".AvailableErrorNotificationMessageTextCL"));
    }

    @TmsLink("WFBT-12273")
    @Test(description = "BC05 | WFBT-12273 | Check transaction page when order service failure (422 - unavailable)")
    public void checkTryAgainNotificationWhenOrderReturns422Unavailable(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA()
                .validateTryAgainNotification(
                        testData.getTestData(method.getName() + ".TryAgainNotificationMessageHeaderCL"),
                        testData.getTestData(method.getName() + ".TryAgainNotificationMessageTextCL"),
                        testData.getTestData(method.getName() + ".TryAgainNotificationMessageButtonCL"));
    }

    @TmsLink("WFBT-12901")
    @Test(description = "BC06 | WFBT-12901 | Check transaction page when download contract PDF service failure (422 - available)")
    public void checkRedirectionToErrorPageWhenDownloadPDFServiceReturns422Available(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnContractSummeryToDownload()
                .validateErrorScreenNotification(
                        testData.getTestData(method.getName() + ".AvailableErrorNotificationMessageHeaderCL"),
                        testData.getTestData(method.getName() + ".AvailableErrorNotificationMessageTextCL"));
    }

    @TmsLink("WFBT-12902")
    @Test(description = "BC07 | WFBT-12902 | Check transaction page when download contract PDF service failure (422 - unavailable)")
    public void checkTryAgainNotificationWhenDownloadPDFServiceReturns422Unavailable(Method method){
        new KD_Dashboard(driver).clickOnInternetAndPhoneAccordion().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).expandBookedOptionsAccordion().clickOnOptionKündigen();
        new CancellationTransactionPage(driver).clickOnContractSummeryToDownload()
                .validateTryAgainNotification(
                        testData.getTestData(method.getName() + ".TryAgainNotificationMessageHeaderCL"),
                        testData.getTestData(method.getName() + ".TryAgainNotificationMessageTextCL"),
                        testData.getTestData(method.getName() + ".TryAgainNotificationMessageButtonCL"));
    }
}