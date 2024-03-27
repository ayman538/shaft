package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-12295")
public class WFBT_12295 extends ST_KDSetup {
    @TmsLink("WFBT_12498")
    @Test(description = "GC01 | WFBT_12498 | Check cancellation flow (success flow)")
    public void GC01_CheckCancellationFlowSuccessFlow(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonSecondBookedOption();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new CancellationConfirmationPage(driver).validateConfirmationNotificationBody(testData.getTestData(method.getName() + ".ConfirmationNotificationBodyCL"));
    }

    @TmsLink("WFBT_12499")
    @Test(description = "GC02 | WFBT_12499 | Check confirmation page Details (success flow)")
    public void GC02_CheckConfirmationPageDetailsSuccessFlow(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonSecondBookedOption();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new CancellationConfirmationPage(driver).validateCancellationConfirmationPageHeader(testData.getTestData(method.getName() + ".CancellationConfirmationPageHeaderCL"))
                                    .validateConfirmationNotificationBody(testData.getTestData(method.getName() + ".ConfirmationNotificationBodyCL"))
                                    .validateWorkOrderNotificationCard(testData.getTestData(method.getName() + ".WorkOrderNotificationHeaderCL"),
                                            testData.getTestData(method.getName() + ".WorkOrderCTACL"))
                                    .clickOnOverviewAccordion()
                                    .validateCancellableOptionTileHeader(testData.getTestData(method.getName() + ".CancellableOptionTileHeaderCL"))
                                    .validateStartCancellingDateHeader(testData.getTestData(method.getName() + ".StartCancellingDateHeaderCL"))
                                    .clickOnWorkOrderCTA();
        new OrderPage(driver).validateWorkOrderCardTitle(testData.getTestData(method.getName() + ".WorkOrderCardCL"));
    }

    @TmsLink("WFBT_12500")
    @Test(description = "GC03 | WFBT_12500 | Check Cancellation Transaction page details")
    public void GC03_CheckCancellationTransactionPageDetails(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonSecondBookedOption();
        new CancellationTransactionPage(driver).validateCancellationDetailsAccordionHeader(testData.getTestData(method.getName() + ".CancellationDetailsAccordionHeaderCL"))
                                    .validateCancellationPageHeader(testData.getTestData(method.getName() + ".CancellationTransactionPageHeaderCL"))
                                    .validateCancellationOptionTileExist()
                                    .validateStartCancellingDateTitle(testData.getTestData(method.getName() + ".StartCancellingDateTitleCL"))
                                    .validateCancellationLegalTextCard(testData.getTestData(method.getName() + ".ContractSummaryPreTextCL"),
                                            testData.getTestData(method.getName() + ".ContractSummaryTextCL"),
                                            testData.getTestData(method.getName() + ".ContractSummaryPostTextCL"))
                                    .validateCancelOptionCTACL(testData.getTestData(method.getName() + ".CancelOptionCTACL"));
    }

    @TmsLink("WFBT_12501")
    @Test(description = "GC04 | WFBT_12501 | Check that when the user clicks on hyper link, the contract summary pdf is downloaded")
    public void GC04_CheckWhenUserClicksOnHyperLinkContractSummaryPdfIsDownloaded(){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonSecondBookedOption();
        new CancellationTransactionPage(driver).clickOnContractSummeryToDownload();
    }

    @TmsLink("WFBT_12502")
    @Test(description = "GC05 | WFBT_12502 | Check after cancel a booked option then go back to try to cancel another booked option")
    public void GC05_CheckAfterCancelBookedOptionThenGoBackToTryToCancelAnotherBookedOption(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonSecondBookedOption();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new CancellationConfirmationPage(driver).validateConfirmationNotificationBody(testData.getTestData(method.getName() + ".ConfirmationNotificationBodyCL"))
                                    .clickBackLink();
        new KabelTVPage(driver).clickCancelButtonThirdBookedOption();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new CancellationConfirmationPage(driver).validateConfirmationNotificationBody(testData.getTestData(method.getName() + ".ConfirmationNotificationBodyCL"));
    }

    @TmsLink("WFBT_12769")
    @Test(description = "GC09 | WFBT_12769 | Check cancellation flow (success flow) when user has two smartcards" , enabled = false)
    public void GC09_CheckCancellationFlowSuccessFlowWhenUserHasTwoSmartcards(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion()
                .validateTheTwoSmartcards(testData.getTestData(method.getName() + ".CancellationOptionWithFirstSmartCardHeadline"),
                        testData.getTestData(method.getName() + ".CancellationBookedOptionHeadline"),
                        testData.getTestData(method.getName() + ".CancellationBookedOptionSubHeadline"),
                        testData.getTestData(method.getName() + ".CancellationOptionWithSecondSmartCardHeadline"));
    }

    @TmsLink("WFBT_12506")
    @Test(description = "BC01 | WFBT_12506 | Check BE general error when an error occurs during confirmation")
    public void BC01_CheckBEGeneralErrorWhenAnErrorOccursDuringConfirmation(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonFirstBookedOption();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA();
        new GeneralErrorPage(driver).validateGeneralErrorNotificationMessage(testData.getTestData(method.getName() + ".GeneralErrorNotificationHeaderCL"),
                testData.getTestData(method.getName() + ".GeneralErrorNotificationBodyCL"));
    }

    @TmsLink("WFBT_12507")
    @Test(description = "BC02 | WFBT_12507 | Check BE general error when an error occurs during transaction")
    public void BC02_CheckBEGeneralErrorWhenAnErrorOccursDuringTransaction(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonFirstBookedOption();
        new GeneralErrorPage(driver).validateGeneralErrorNotificationMessage(testData.getTestData(method.getName() + ".GeneralErrorNotificationHeaderCL"),
                testData.getTestData(method.getName() + ".GeneralErrorNotificationBodyCL"));
    }

    @TmsLink("WFBT_12508")
    @Test(description = "BC03 | WFBT_12508 | Check transaction page when order service failure with 422 available")
    public void BC03_CheckTransactionPageWhenOrderServiceFailureWith422Available(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonFirstBookedOption();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA()
                                    .validateErrorScreenNotification(testData.getTestData(method.getName() + ".ErrorScreenNotificationHeaderCL"),
                                            testData.getTestData(method.getName() + ".ErrorScreenNotificationBodyCL"));
    }

    @TmsLink("WFBT_12509")
    @Test(description = "BC04 | WFBT_12509 | Check transaction page when order service failure (422 - unavailable)")
    public void BC04_CheckTransactionPageWhenOrderServiceFailure422Unavailable(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonFirstBookedOptionWithoutSmartcard();
        new CancellationTransactionPage(driver).clickOnCancelOptionCTA()
                                    .validateTryAgainNotification(testData.getTestData(method.getName() + ".TryAgainNotificationHeaderCL"),
                                            testData.getTestData(method.getName() + ".TryAgainNotificationBodyCL"),
                                            testData.getTestData(method.getName() + ".TryAgainNotificationCTACL"));
    }

    @TmsLink("WFBT_12771")
    @Test(description = "BC06 | WFBT_12771 | Check transaction page when download service failure with 422 available")
    public void BC06_CheckTransactionPageWhenDownloadServiceFailureWith422Available(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonFirstBookedOption();
        new CancellationTransactionPage(driver).clickOnContractSummeryToDownload()
                                    .validateErrorScreenNotification(testData.getTestData(method.getName() + ".ErrorScreenNotificationHeaderCL"),
                                            testData.getTestData(method.getName() + ".ErrorScreenNotificationBodyCL"));
    }

    @TmsLink("WFBT_12772")
    @Test(description = "BC07 | WFBT_12772 | Check transaction page when download service failure with 422 not-available")
    public void BC07_CheckTransactionPageWhenDownloadServiceFailureWith422NotAvailable(Method method){
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).expandBookedOptionAccordion().clickCancelButtonFirstBookedOptionWithoutSmartcard();
        new CancellationTransactionPage(driver).clickOnContractSummeryToDownload()
                                    .validateTryAgainNotification(testData.getTestData(method.getName() + ".TryAgainNotificationHeaderCL"),
                                            testData.getTestData(method.getName() + ".TryAgainNotificationBodyCL"),
                                            testData.getTestData(method.getName() + ".TryAgainNotificationCTACL"));
    }
}