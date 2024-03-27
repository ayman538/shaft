package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.InvoicePage;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13089")
public class WFBT_13089 extends ST_KDSetup{

    @TmsLink("WFBT-13219")
    @Test(description = "GC01 | WFBT-13219 | Validate the notification message of the pending cancelled tariff on Tariff SO and accordion in Tariff page when user has CLS tariff and cancelled Main Tariff")
    public void GC01(Method method) {
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateCancellationMessage(testData.getTestData(method.getName() + ".cancellationMessageMainTariffSO"))
                .validateMainTariffAccCancellationMessage(testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionHeaderCL")
                        ,testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionBodyCL"))
                .validateCancelContractHintMSG(testData.getTestData(method.getName() + ".CancelContractHintCL"))
                .validateActiveTariffHeader(testData.getTestData(method.getName() + ".ActiveTariffHeaderCL"));
    }

    @TmsLink("WFBT-13220")
    @Test(description = "GC02 | WFBT-13220 | Validate the notification message of the pending cancelled tariff on Tariff SO and accordion in Tariff Page when user has Cancelled CLS Tariff only")
    public void GC02(Method method) {
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc()
                .clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateCancellationMessage(testData.getTestData(method.getName() + ".cancellationMessageMainTariffSO"))
                .validateMainTariffAccCancellationMessage(testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionHeaderCL")
                        ,testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionBodyCL"))
                .validateCancelContractHintMSG(testData.getTestData(method.getName() + ".CancelContractHintCL"));
    }

    @TmsLink("WFBT-13461")
    @Test(description = "GC03 | WFBT-13461 | Validate the notification message of the pending cancelled tariff on Tariff SO and accordion in tariff page when user has Cancelled Mein Tariff only")
    public void GC03(Method method) {
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateCancellationMessage(testData.getTestData(method.getName() + ".cancellationMessageMainTariffSO"))
                .validateMainTariffAccCancellationMessage(testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionHeaderCL")
                        ,testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionBodyCL"))
                .validateCancelContractHintMSG(testData.getTestData(method.getName() + ".CancelContractHintCL"));
    }

    @TmsLink("WFBT-13462")
    @Test(description = "GC04 | WFBT-13462 | Validate the notification message of the pending Cancelled tariff on Tariff SO and accordion in tariff page when user has cancelled Main Tariff and Cancelled CLS Tariff")
    public void GC04(Method method) {
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateCancellationMessage(testData.getTestData(method.getName() + ".cancellationMessageMainTariffSO"))
                .validateMainTariffAccCancellationMessage(testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionHeaderCL")
                        ,testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionBodyCL"))
                .validateCancelContractHintMSG(testData.getTestData(method.getName() + ".CancelContractHintCL"))
                .validateMainTariffAccCancellationMessageSec(testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionHeaderSecCL")
                ,testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionBodySecCL"));
    }

    @TmsLink("WFBT-13463")
    @Test(description = "GC05 | WFBT-13463 | Validate the notification message of the pending cancelled tariff on Tariff Accordion in tariff page when user has Mein Tariff and cancelled CLS Tariff")
    public void GC05(Method method) {
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver)
                .validateMainTariffSODetails(testData.getTestData(method.getName() + ".MainTariffNameCL")
                        ,testData.getTestData(method.getName() + ".MainTariffDateCL"))
                .validateMainTariffAccCancellationMessage(testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionHeaderCL")
                        ,testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionBodyCL"))
                .validateCancelContractHintMSG(testData.getTestData(method.getName() + ".CancelContractHintCL"));
    }

    @TmsLink("WFBT-13474")
    @Test(description = "GC06 | WFBT-13474 | Check CL for contract details card")
    public void GC06(Method method) {
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateCancelledContractDetailsCard(testData.getTestData(method.getName() + ".ContractEndDateContractDetailsCL")
        ,testData.getTestData(method.getName() + ".CancelContractHintCL")
        ,testData.getTestData(method.getName() + ".CancelContractHintSecCL")
        ,testData.getTestData(method.getName() + ".BillSectionCurrentPriceCL")
        ,testData.getTestData(method.getName() + ".GoToBookedOptionsAccordionCTACL"))
                .clickOnGoToBookedOptionsCTA().validateBookedOptionAccHeadline(testData.getTestData(method.getName() + ".bookedOptionsHeadlineCL"))
                .clickOnMeinTariffAccordion().clickOnBillSectionHyperlink();
        new InvoicePage(driver).validateInvoicePageOpenSuccessfully();
    }

    @TmsLink("WFBT-13648")
    @Test(description = "GC07 | WFBT-13648 | Validate the notification message of the pending cancelled tariff on Tariff Accordion in tariff page when user has only multiple CLS Tariff and one cancelled CLS tariff")
    public void GC07(Method method) {
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).validateCancellationMessage(testData.getTestData(method.getName() + ".cancellationMessageMainTariffSO"))
                .validateMainTariffAccCancellationMessage(testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionHeaderCL")
                        ,testData.getTestData(method.getName() + ".CancellationMSGMainTarifAccordionBodyCL"));
    }
}