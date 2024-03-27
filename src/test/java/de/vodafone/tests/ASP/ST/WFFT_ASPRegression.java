package de.vodafone.tests.ASP.ST;

import com.shaft.validation.Validations;
import de.vodafone.pages.ASP.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("ASP")
@Feature("ST")
public class WFFT_ASPRegression extends ASPSTSetup {
    //Test
    @Test(description = "GC01 - Lion - Verify Revocation & Report Defect flow within revocation period.")
    @TmsLink("WFFT-2058")
    private void GC01(Method method) throws InterruptedException {
        // Verify Dashboard Page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardTrackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Header CL is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardTrackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline CL is displayed").perform();
        new ASPDashboard(driver).clickOn_Revocation();
        // Verify Revocation Options page.
        // driver.element().waitToBeReady(RevocationOptionsPage.Header_CL);
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsHeader"))
                .withCustomReportMessage("Check Revocation Options Page Header is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.firstOption_BTN)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsFirstOptionHeadline"))
                .withCustomReportMessage("Check Revocation Options First Option CL").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.firstOptionDescription_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsFirstOptionDescription"))
                .withCustomReportMessage("Check Revocation Options First Option Description CL").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.secondOption_BTN)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsSecondOptionHeadline"))
                .withCustomReportMessage("Check Revocation Options Second Option CL").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.secondOptionDescription_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsSecondOptionDescription"))
                .withCustomReportMessage("Check Revocation Options Second Option Description CL").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.ThirdOption_BTN)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsThirdOptionHeadline"))
                .withCustomReportMessage("Check Revocation Options Third Option CL").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.ThirdOptionDescription_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsThirdOptionDescription"))
                .withCustomReportMessage("Check Revocation Options Third Option Description CL").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.fourthOption_BTN)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsFourthOptionHeadline"))
                .withCustomReportMessage("Check Revocation Options Fourth Option CL").perform();
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.fourthOptionDescription_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsFourthOptionDescription"))
                .withCustomReportMessage("Check Revocation Options Fourth Option Description CL").perform();
        new RevocationOptionsPage(driver).navigateToExchangeHwPage();
        // Verify Exchange Hw Step One
        // driver.element().waitToBeReady(ExchangeHwStepOnePage.Header_CL);
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepOnePage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ExchangeHWStepOneHeader"))
                .withCustomReportMessage("Check ExchangeHwStepOne Header CL").perform();
        // driver.element().waitToBeReady(ExchangeHwStepOnePage.HWName_CL);
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepOnePage.HWName_CL)
                .text().contains(testData.getTestData(method.getName() + ".ExchangeHWName"))
                .withCustomReportMessage("Check ExchangeHwStepOne HW Name CL").perform();
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepOnePage.weiter_BTN)
                .isDisabled().perform();
        new ExchangeHwStepOnePage(driver).SelectHW();
        new ExchangeHwStepOnePage(driver).clickOn_Weiter();
        // Verify Exchange Hw Step Two
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepTwoPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ExchangeHWStepTwoHeader"))
                .withCustomReportMessage("Check ExchangeHwStepTwo Header CL").perform();
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepTwoPage.HWName_CL)
                .text().contains(testData.getTestData(method.getName() + ".ExchangeHWName"))
                .withCustomReportMessage("Check ExchangeHwStepTwo HW Name CL").perform();
        new ExchangeHwStepTwoPage(driver).clickOn_Weiter();
        // Verify Exchange Hw Step Three
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepThreePage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ExchangeHWStepThreeHeader"))
                .withCustomReportMessage("Check ExchangeHwStepThree Header CL").perform();
        new ExchangeHwStepThreePage(driver).clickOn_GerateTauschen();
        // Verify Revocation Confirmation Page
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationPageHeader"))
                .withCustomReportMessage("Check Confirmation page Header CL").perform();
        driver.browser().navigateBack();
        // Back to Dashboard
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_Revocation();
        new RevocationOptionsPage(driver).navigateToSalesAgentPage();
        // Verify Sales Agent Page
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), SalesAgentPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SalesAgentPageHeader"))
                .withCustomReportMessage("Check Sales Agent page Header CL").perform();
        driver.browser().navigateBack();
        // Back to Dashboard
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_Revocation();
        new RevocationOptionsPage(driver).navigateToOpenQuestionsPage();
        // Verify Open Questions Page
        // driver.element().waitToBeReady(OpenQuestionsPage.Header_CL);
        Validations.assertThat().element(driver.getDriver(), OpenQuestionsPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".OpenQuestionsPageHeader"))
                .withCustomReportMessage("Check Open Questions page Header CL").perform();
        new OpenQuestionsPage(driver).clickOn_DeineMitteilung();
        // Verify Service Agent Page
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ServiceAgentPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ServiceAgentPageHeader"))
                .withCustomReportMessage("Check Service Agent Page Header CL").perform();
        driver.browser().navigateBack();
        // Back to Dashboard
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_Revocation();
        new RevocationOptionsPage(driver).navigateToWinbackPage();
        // Verify Winback Page
        // driver.element().waitToBeReady(WinbackPage.Header_CL);
        Validations.assertThat().element(driver.getDriver(), WinbackPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".WinbackPageHeader"))
                .withCustomReportMessage("Check Winback page Header CL").perform();
        new WinbackPage(driver).clickOn_CancelContract();
        // Verify Revocation Review Page
        // Thread.Sleep(5000);
        Validations.assertThat().element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SingleHWRevocationReviewPageHeader"))
                .withCustomReportMessage("Check Single HW Revocation Review page Header CL").perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Revocation Confirmation Page
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationPageHeader"))
                .withCustomReportMessage("Check Confirmation page Header CL").perform();
        driver.browser().navigateBack();
        // Back to Dashboard
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_ReportDefect();
        // Verify Single HW Report Defect Page
        // Thread.Sleep(5000);
        Validations.assertThat().element(driver.getDriver(), SingleHWReportDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SingleHWReportDefectPageHeader"))
                .withCustomReportMessage("Check Single HW Report Defect page Header CL").perform();
        new SingleHWReportDefectPage(driver).clickOn_HW();
        // Verify Single HW Specifying Defect Page
        // Thread.Sleep(5000);
        Validations.assertThat().element(driver.getDriver(), SpecifyingDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SpecifyingDefectPageHeader"))
                .withCustomReportMessage("Check Specifying Defect page Header CL").perform();
        new SpecifyingDefectPage(driver).selectFirstDefectReason();
        new SpecifyingDefectPage(driver).selectSecondDefectReason();
        new SpecifyingDefectPage(driver).clickOn_Weiter();
        // Verify Report Defect Review Page
        // Thread.Sleep(5000);
        Validations.assertThat().element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".HWReportDefectReviewpage"))
                .withCustomReportMessage("Check HW Report Defect Review page Header CL").perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Report Defect Confirmation Page
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".HWReportDefectConfirmationpage"))
                .withCustomReportMessage("Check Confirmation page Header CL").perform();
        driver.browser().navigateBack();
        // Back to Dashboard
        // Thread.Sleep(7000);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_ReportDefect();
        // Verify Single HW Report Defect Page
        // Thread.Sleep(5000);
        Validations.assertThat().element(driver.getDriver(), SingleHWReportDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SingleHWReportDefectPageHeader"))
                .withCustomReportMessage("Check Single HW Report Defect page Header CL").perform();
        new SingleHWReportDefectPage(driver).clickOn_SIM();
        // Verify Service Agent Page
        // driver.element().waitToBeReady(ServiceAgentPage.Header_CL);
        Validations.assertThat().element(driver.getDriver(), ServiceAgentPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SIMReportDefectpage"))
                .withCustomReportMessage("Check SIM Report Defect page Header CL").perform();
    }
    @Test(description = "GC02 - NeoLion - Verify Revocation & Report Defect flow within revocation period.")
    @TmsLink("WFFT-2059")
    private void GC02(Method method) throws InterruptedException {
        // Verify Dashboard Page
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardTrackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Header CL is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardTrackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline CL is displayed").perform();
        new ASPDashboard(driver).clickOn_Revocation();
        // Verify Revocation Options page.
        // driver.element().waitToBeReady(RevocationOptionsPage.Header_CL);
        Validations.assertThat().element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationOptionsHeader"))
                .withCustomReportMessage("Check Revocation Options Page Header is displayed").perform();
        new RevocationOptionsPage(driver).navigateToExchangeHwPage();
        // Verify Exchange Hw Step One
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepOnePage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ExchangeHWStepOneHeader"))
                .withCustomReportMessage("Check ExchangeHwStepOne Header CL").perform();
        new ExchangeHwStepOnePage(driver).SelectHW();
        new ExchangeHwStepOnePage(driver).clickOn_Weiter();
        // Verify Exchange Hw Step Two
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepTwoPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ExchangeHWStepTwoHeader"))
                .withCustomReportMessage("Check ExchangeHwStepTwo Header CL").perform();
        new ExchangeHwStepTwoPage(driver).clickOn_Weiter();
        // Verify Exchange Hw Step Three
        Validations.assertThat().element(driver.getDriver(), ExchangeHwStepThreePage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ExchangeHWStepThreeHeader"))
                .withCustomReportMessage("Check ExchangeHwStepThree Header CL").perform();
        new ExchangeHwStepThreePage(driver).clickOn_GerateTauschen();
        // Verify Revocation Confirmation Page
        // Thread.Sleep(5000) ;
        Validations.assertThat().element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ConfirmationPageHeader"))
                .withCustomReportMessage("Check Confirmation page Header CL").perform();
        driver.browser().navigateBack();
        // Back to Dashboard
        // Thread.Sleep(5000) ;
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_ReportDefect();
        // Verify Single HW Report Defect Page
        // driver.element().waitToBeReady(SingleHWReportDefectPage.Header_CL);
        Validations.assertThat().element(driver.getDriver(), SingleHWReportDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SingleHWReportDefectPageHeader"))
                .withCustomReportMessage("Check Single HW Report Defect page Header CL").perform();
        new SingleHWReportDefectPage(driver).clickOn_HW();
        // Verify Single HW Specifying Defect Page
        Validations.assertThat().element(driver.getDriver(), SpecifyingDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SpecifyingDefectPageHeader"))
                .withCustomReportMessage("Check Specifying Defect page Header CL").perform();
        new SpecifyingDefectPage(driver).selectFirstDefectReason();
        new SpecifyingDefectPage(driver).selectSecondDefectReason();
        new SpecifyingDefectPage(driver).clickOn_Weiter();
        // Verify Report Defect Review Page
        // driver.element().waitToBeReady(RevocationReviewPage.revocationReview_Header_CL);
        Validations.assertThat().element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".HWReportDefectReviewpage"))
                .withCustomReportMessage("Check HW Report Defect Review page Header CL").perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Report Defect Confirmation Page
        Validations.assertThat().element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".HWReportDefectConfirmationpage"))
                .withCustomReportMessage("Check Confirmation page Header CL").perform();
        driver.browser().navigateBack();
        // Back to Dashboard
        // Thread.Sleep(5000) ;
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_ReportDefect();
        // Verify Single HW Report Defect Page
        Validations.assertThat().element(driver.getDriver(), SingleHWReportDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".SingleHWReportDefectPageHeader"))
                .withCustomReportMessage("Check Single HW Report Defect page Header CL").perform();
        new SingleHWReportDefectPage(driver).clickOn_SIM();
        // Verify ESIM Report Defect Page
        Validations.assertThat().element(driver.getDriver(), EsimReportDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".ESIMReportDefectpageHeader"))
                .withCustomReportMessage("Check Esim Report Defect Page Header CL").perform();
    }
    @Test(description = "GC03 - Lion With multiple HWs - Verify Revocation flow within revocation period.")
    @TmsLink("WFFT-2060")
    private void GC03(Method method) throws InterruptedException {
        // Verify Dashboard Page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardTrackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Header CL is displayed").perform();
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardTrackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline CL is displayed").perform();
        new ASPDashboard(driver).clickOn_Revocation();
        // Verify Revocation Selection Page
        // driver.element().waitToBeReady(RevocationSelectionPage.revocationSelection_Header_CL);
        Validations.assertThat().element(driver.getDriver(), RevocationSelectionPage.revocationSelection_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".RevocationSelectionHeader"))
                .withCustomReportMessage("Check Revocation Selection Page header is displayed").perform();
        new RevocationSelectionPage(driver).select_changedHW();
        new RevocationSelectionPage(driver).clickOn_Weiter();
        // Verify Multiple HW Revocation Review Page
        // driver.element().waitToBeReady(RevocationReviewPage.revocationReview_Header_CL);
        Validations.assertThat().element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".MultipleHWRevocationReviewHeader"))
                .withCustomReportMessage("Check Multiple HW Revocation Review Page header is displayed").perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Multiple HW Revocation Confirmation Page
        // Thread.Sleep(5000);
        Validations.assertThat().element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".MultipleHWRevocationConfirmationHeader"))
                .withCustomReportMessage("Check Multiple HW Revocation Confirmation Page header is displayed").perform();
    }
    @Test(description = "GC04 - Verify polarbear report defect & revocation")
    @TmsLink("WFFT-2061")
    private void GC04(Method method) throws InterruptedException {
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_revoke_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationBtn"))
                .withCustomReportMessage("Check Revocation button is displayed probably")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_reportDefect_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectBtn"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new ASPDashboard(driver).clickOn_PolarBear_tiger_NeoTigerRevocation();
        // driver.element().waitToBeReady(RevocationOptionsPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationHeader"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new RevocationOptionsPage(driver).navigateToWinbackPage();
        // driver.element().waitToBeReady(WinbackPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), WinbackPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".WinbackHeader"))
                .withCustomReportMessage("Check Winback Header is displayed probably")
                .perform();
        new WinbackPage(driver).clickOn_GigaCubeCancelContract();
        // driver.element().waitToBeReady(RevocationReviewPage.revocationReview_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationReviewHeader"))
                .withCustomReportMessage("Check Revocation Review Header is displayed probably")
                .perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Thread.Sleep(7000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
        driver.browser().navigateBack();
        // Report Defect
        new ASPDashboard(driver).clickOn_PolarBear_tiger_NeoTigerReportDefect();
        Validations.assertThat()
                .element(driver.getDriver(), ASPReportDefect.reportDefect_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectHeader"))
                .withCustomReportMessage("Check Report Defect Header is displayed probably")
                .perform();
        new ASPReportDefect(driver).clickOn_polarbear_HWReportDefect();
        Validations.assertThat()
                .element(driver.getDriver(), SpecifyingDefectPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".SpecifyingDefectHeader"))
                .withCustomReportMessage("Check Specifying Defect Header is displayed probably")
                .perform();
        new SpecifyingDefectPage(driver).selectFirstDefectReason();
        new SpecifyingDefectPage(driver).selectSecondDefectReason();
        new SpecifyingDefectPage(driver).clickOn_Weiter();
        Validations.assertThat()
                .element(driver.getDriver(), PolarBearDefectReviewPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReviewDefectHeader"))
                .withCustomReportMessage("Check Review Defect Header is displayed probably")
                .perform();
        new PolarBearDefectReviewPage(driver).clickOn_sendBackDevice();
        // Thread.Sleep(7000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
    }
    @Test(description = "GC05 - Verify Rabbit report defect & revocation")
    @TmsLink("WFFT-2062")
    private void GC05(Method method) throws InterruptedException {
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.revoke_BTN )
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationBtn"))
                .withCustomReportMessage("Check Revocation button is displayed probably")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.reportDefect_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectBtn"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new ASPDashboard(driver).clickOn_Revocation();
        // driver.element().waitToBeReady(RevocationOptionsPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationHeader"))
                .withCustomReportMessage("Check Revocation Header is displayed probably")
                .perform();
        new RevocationSelectionPage(driver).select_changedHW();
        new RevocationSelectionPage(driver).clickOn_Weiter();
        // driver.element().waitToBeReady(RevocationOptionsPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationHeader"))
                .withCustomReportMessage("Check Revocation Header is displayed probably")
                .perform();
        new RevocationReviewPage(driver).navigateToRevocationselectionPage();
        new RevocationSelectionPage(driver).select_changedHW();
        new RevocationSelectionPage(driver).clickOn_Weiter();
        new RevocationReviewPage(driver).navigateToReportDefectPage();
        // driver.element().waitToBeReady(ASPReportDefect.reportDefect_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPReportDefect.reportDefect_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectHeader"))
                .withCustomReportMessage("Check Report Defect Header is displayed probably")
                .perform();
        new ASPReportDefect(driver).clickOn_backBrowser();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Thread.Sleep(7000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
        driver.browser().navigateBack();
        // Report Defect
        new ASPDashboard(driver).clickOn_ReportDefect();
        Validations.assertThat()
                .element(driver.getDriver(), ASPReportDefect.reportDefect_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectHeader"))
                .withCustomReportMessage("Check Report Defect Header is displayed probably")
                .perform();
        new ReportDefectSelectionPage(driver).select_DefectedHW();
        new ReportDefectSelectionPage(driver).selectFirstDefectReason();
        new ReportDefectSelectionPage(driver).selectSecondDefectReason();
        new ReportDefectSelectionPage(driver).clickOn_Weiter();
        // driver.element().waitToBeReady(PolarBearDefectReviewPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), PolarBearDefectReviewPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectHeader"))
                .withCustomReportMessage("Check Review Defect Header is displayed probably")
                .perform();
        new PolarBearDefectReviewPage(driver).navigateToDefectselectionPage();
        new ReportDefectSelectionPage(driver).clickOn_Weiter();
        new PolarBearDefectReviewPage(driver).navigateToRevocationSelectionPage();
        Validations.assertThat()
                .element(driver.getDriver(), RevocationSelectionPage.revocationSelection_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationHeader"))
                .withCustomReportMessage("Check Report Defect Header is displayed probably")
                .perform();
        new ASPReportDefect(driver).clickOn_backBrowser();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Thread.Sleep(7000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
    }
    @Test(description = "GC06 - Verify tiger revocation")
    @TmsLink("WFFT-2063")
    private void GC06(Method method) throws InterruptedException {
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_revoke_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationBtn"))
                .withCustomReportMessage("Check Revocation button is displayed probably")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_reportDefect_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectBtn"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new ASPDashboard(driver).clickOn_PolarBear_tiger_NeoTigerRevocation();
        Validations.assertThat()
                .element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationHeader"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new RevocationOptionsPage(driver).navigateToWinbackPage();
        // driver.element().waitToBeReady(WinbackPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), WinbackPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".WinbackHeader"))
                .withCustomReportMessage("Check Winback Header is displayed probably")
                .perform();
        new WinbackPage(driver).clickOn_winderrufen();
        // Thread.Sleep(6000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.tiger_confirmation_subHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ". ConfirmationSubHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
    }
    @Test(description = "GC07 - Verify NeoTiger revocation")
    @TmsLink("WFFT-2064")
    private void GC07(Method method) throws InterruptedException {
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_revoke_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationBtn"))
                .withCustomReportMessage("Check Revocation button is displayed probably")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_reportDefect_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectBtn"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new ASPDashboard(driver).clickOn_PolarBear_tiger_NeoTigerRevocation();
        Validations.assertThat()
                .element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationHeader"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new RevocationOptionsPage(driver).navigateToWinbackPage();
        // Thread.Sleep(5000);
        Validations.assertThat()
                .element(driver.getDriver(), WinbackPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".WinbackHeader"))
                .withCustomReportMessage("Check Winback Header is displayed probably")
                .perform();
        new WinbackPage(driver).clickOn_winderrufen();
        // Thread.Sleep(7000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.tiger_confirmation_subHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ". ConfirmationSubHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
    }
    @Test(description = "GC08 - Verify python report defect & revocation")
    @TmsLink("WFFT-2065")
    private void GC08(Method method) throws InterruptedException {
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_revoke_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationBtn"))
                .withCustomReportMessage("Check Revocation button is displayed probably")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.polarbear_tiger_NeoTiger_reportDefect_BTN)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectBtn"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new ASPDashboard(driver).clickOn_PolarBear_tiger_NeoTigerRevocation();
        Validations.assertThat()
                .element(driver.getDriver(), RevocationOptionsPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".RevocationHeader"))
                .withCustomReportMessage("Check Report Defect btn is displayed probably")
                .perform();
        new DslReseonsofRevocationpage(driver).navigateToConfirmationPage();
        // Thread.Sleep(7000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
        driver.browser().navigateBack();
        // Report Defect
        new ASPDashboard(driver).clickOn_PolarBear_tiger_NeoTigerReportDefect();
        // driver.element().waitToBeReady(ASPReportDefect.reportDefect_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPReportDefect.reportDefect_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectHeader"))
                .withCustomReportMessage("Check Report Defect Header is displayed probably")
                .perform();
        new DslReportDefect(driver).selectFirstDefectReason();
        new DslReportDefect(driver).selectSecondDefectReason();
        new DslReportDefect(driver).clickOn_Weiter();
        Validations.assertThat()
                .element(driver.getDriver(), DslReportDefectReviewPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ReportDefectHeader"))
                .withCustomReportMessage("Check Review Defect Header is displayed probably")
                .perform();
        new DslReportDefectReviewPage(driver).clickOn_sendBackDevice();
        // Thread.Sleep(7000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Header is displayed probably")
                .perform();
    }
    @Test(description = "GC09 - Elephant - Verify Report Defect flow.")
    @TmsLink("WFFT-2066")
    private void GC09(Method method) throws InterruptedException {
        //Dashboard page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Headline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline  Title")
                .perform();
        new ASPDashboard(driver).clickOn_ElephantReportDefect();
        // Verify Defect Report Page
        // driver.element().waitToBeReady(SpecifyingDefectPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), SpecifyingDefectPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DefectReportHeader"))
                .withCustomReportMessage("Check Defect Report Page Header Title")
                .perform();
        new SpecifyingDefectPage(driver).selectCheckBox();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).selectFirstDefectReason ();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).selectSecondDefectReason ();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).clickOn_Weiter();
        // Verify Summary Page
        // driver.element().waitToBeReady(RevocationReviewPage.revocationReview_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".SummaryHeader"))
                .withCustomReportMessage("Check Summary Page Header Title")
                .perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Confirmation Page
        // Thread.Sleep(3000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Page Header Title")
                .perform();
    }
    @Test(description = "GC10 - BabyElephant - Verify Report Defect flow.")
    @TmsLink("WFFT-2067")
    private void GC10(Method method) throws InterruptedException {
        //Dashboard page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Headline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline  Title")
                .perform();
        new ASPDashboard(driver).clickOn_BabyElephantReportDefect();
        // Verify Defect Report Page
        // driver.element().waitToBeReady(SpecifyingDefectPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), SpecifyingDefectPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DefectReportHeader"))
                .withCustomReportMessage("Check Defect Report Page Header Title")
                .perform();
        new SpecifyingDefectPage(driver).selectCheckBox();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).selectFirstDefectReason ();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).selectSecondDefectReason ();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).clickOn_Weiter();
        // Verify Summary Page
        Validations.assertThat()
                .element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".SummaryHeader"))
                .withCustomReportMessage("Check Summary Page Header Title")
                .perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Confirmation Page
        // Thread.Sleep(3000);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Page Header Title")
                .perform();
    }
    @Test(description = "GC11 - Panda - Verify Revocation & Report Defect flow within revocation period.")
    @TmsLink("WFFT-2068")
    private void GC11(Method method) throws InterruptedException {
        //Dashboard page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.PandAtrackingHeader_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Headline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.PandAtrackingSubHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline  Title")
                .perform();
        new ASPDashboard(driver).clickOn_ZumWiderruf();
        // Verify Summary Page
        Validations.assertThat()
                .element(driver.getDriver(), RevocationReviewPage.revocationReview_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".SummaryHeader"))
                .withCustomReportMessage("Check Defect Report Page Header Title")
                .perform();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Confirmation Page
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Page Header Title")
                .perform();
        new ASPConfirmationPage(driver).clickOn_ZurückzurStartseite();
        //Dashboard page
        new ASPDashboard(driver).clickOn_ReportDefect();
        // Verify Defect Report Page
        Validations.assertThat()
                .element(driver.getDriver(), SpecifyingDefectPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DefectReportHeader"))
                .withCustomReportMessage("Check Defect Report Page Header Title")
                .perform();
        new SingleHWReportDefectPage(driver).clickOn_HW();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).selectFirstDefectReason ();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).selectSecondDefectReason ();
        // Thread.Sleep(200);
        new SpecifyingDefectPage(driver).clickOn_Weiter();
        new RevocationReviewPage(driver).clickOn_sendBackDevice();
        // Verify Confirmation Page
        // driver.element().waitToBeReady(ASPConfirmationPage.confirmation_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPConfirmationPage.confirmation_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".ConfirmationHeader"))
                .withCustomReportMessage("Check Confirmation Page Header Title")
                .perform();
        new ASPConfirmationPage(driver).clickOn_ZurückzurStartseite();
        //Dashboard page
        new ASPDashboard(driver).clickOn_ReportDefect();
        // Verify Defect Report Page
        // driver.element().waitToBeReady(SpecifyingDefectPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), SpecifyingDefectPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DefectReportHeader"))
                .withCustomReportMessage("Check Defect Report Page Header Title")
                .perform();
        new SingleHWReportDefectPage(driver).clickOn_SIM();
    }
    @Test(description = "GC12 - SnowLion - Verify Second delivery flow While second delivery not expired.")
    @TmsLink("WFFT-2069")
    private void GC12(Method method) throws InterruptedException {
        //Dashboard page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Headline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline  Title")
                .perform();
        new ASPDashboard(driver).clickOn_ArtikleErneutZusenden();
        // Verify Second Delivery Confirmation Page
        // driver.element().waitToBeReady(SecondDeliveryConfirmationPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), SecondDeliveryConfirmationPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Header"))
                .withCustomReportMessage("Check Second Delivery Confirmation Page Header Title")
                .perform();
        new SecondDeliveryConfirmationPage(driver).clickOn_ArtikelErneutZusenden();
    }
    @Test(description = "GC13 - SnowNeoLion - Verify Second delivery flow While second delivery not expired.")
    @TmsLink("WFFT-2070")
    private void GC13(Method method) throws InterruptedException {
        //Dashboard page
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Headline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline  Title")
                .perform();
        new ASPDashboard(driver).clickOn_ArtikleErneutZusenden();
        // Verify Second Delivery Confirmation Page
        // driver.element().waitToBeReady(SecondDeliveryConfirmationPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), SecondDeliveryConfirmationPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Header"))
                .withCustomReportMessage("Check Second Delivery Confirmation Page Header Title")
                .perform();
        new SecondDeliveryConfirmationPage(driver).clickOn_ArtikelErneutZusenden();
    }
    @Test(description = "GC14 - SnowPolarbear - Verify Second delivery flow While second delivery not")
    @TmsLink("WFFT-2071")
    private void GC14(Method method) throws InterruptedException {
        //Dashboard page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingHeader_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingHeader"))
                .withCustomReportMessage("Check Dashboard tracking Headline Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.trackingSubHeadline_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".trackingSubHeadline"))
                .withCustomReportMessage("Check Dashboard tracking SubHeadline  Title")
                .perform();
        new ASPDashboard(driver).clickOn_ArtikleErneutZusenden();
        // Verify Second Delivery Confirmation Page
        // driver.element().waitToBeReady(SecondDeliveryConfirmationPage.Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), SecondDeliveryConfirmationPage.Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".Header"))
                .withCustomReportMessage("Check Second Delivery Confirmation Page Header Title")
                .perform();
        new SecondDeliveryConfirmationPage(driver).clickOn_ArtikelErneutZusenden();
    }
    @Test(description = "GC15 - Verify Dashboard view for Cobra user.")
    @TmsLink("WFFT-2131")
    private void GC15(Method method) throws InterruptedException {
        //Dashboard page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard Page Header Title")
                .perform();
        Validations.assertThat()
                .element(driver.getDriver(), ASPDashboard.CobraWarningText_CL)
                .text()
                .isEqualTo(testData.getTestData(method.getName() + ".CobraWarningText"))
                .withCustomReportMessage("Check Dashboard tacking headline Title")
                .perform();
    }
    @Test(description = "GC16 - Monkey- Verify Revocation & Report Defect flow within revocation period.")
    @TmsLink("WFFT-2132")
    private void GC16(Method method) throws InterruptedException {
        // Verify Dashboard Page
        // driver.element().waitToBeReady(ASPDashboard.dashboard_Header_CL);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_ReportDefect();
        // Verify Otelo SIM Report Defect Page
        Validations.assertThat().element(driver.getDriver(), OteloSimReportDefectPage.Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".OteloSIMReportDefectHeader"))
                .withCustomReportMessage("Check Otelo SIM Report Defect Page header is displayed").perform();
        driver.browser().navigateBack();
        // Verify Dashboard Page
        // Thread.Sleep(5000);
        Validations.assertThat().element(driver.getDriver(), ASPDashboard.dashboard_Header_CL)
                .text().isEqualTo(testData.getTestData(method.getName() + ".DashboardHeader"))
                .withCustomReportMessage("Check Dashboard header is displayed").perform();
        new ASPDashboard(driver).clickOn_Revocation();
        // Verify Otelo Revocation Page
        Validations.assertThat().browser(driver.getDriver())
                .url().isEqualTo(testData.getTestData(method.getName() + ".OteloRevocationURL"))
                .withCustomReportMessage("Check Otelo Revocation URL is displayed").perform();
    }
}