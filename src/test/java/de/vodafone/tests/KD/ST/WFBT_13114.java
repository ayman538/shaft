package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.KabelTVPage;
import io.qameta.allure.*;
import org.testng.annotations.Test;
import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-13114")
public class WFBT_13114 extends ST_KDSetup {
    @TmsLink("WFBT-13638")
    @Test(description = "GC01 | WFBT-13638 | Check Mein Tarif Accordion & SO when User has Only one Main Tarif Cancelled")
    public void GC01(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateCancellationMSGBodyMainTariffSO(testData.getTestData(method.getName() + ".CancellationNotificationBodySOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"))
                .validateContractDetailsCardCancelledTariff(testData.getTestData(method.getName() + ".ContractEndDateLabelCL")
                        ,testData.getTestData(method.getName() + ".CancelledContractFirstHintCL")
                        ,testData.getTestData(method.getName() + ".CancelledContractSecondHintCL")
                        ,testData.getTestData(method.getName() + ".BillSectionHyperLinkCL")
                        ,testData.getTestData(method.getName() + ".GoToBookedOptionsAccCTACL"))
                .clickOnGoToBookedOptionCTA().validateBookedOptionFAccordionDetails();
    }

    @TmsLink("WFBT-13639")
    @Test(description = "GC02 | WFBT-13639 | Check Mein Tarif Accordion & SO when User has Only CLS Tarif Cancelled")
    public void GC02(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateCancellationMSGBodyMainTariffSO(testData.getTestData(method.getName() + ".CancellationNotificationBodySOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"))
                .validateContractDetailsCardCancelledTariff(testData.getTestData(method.getName() + ".ContractEndDateLabelCL")
                        ,testData.getTestData(method.getName() + ".CancelledContractFirstHintCL")
                        ,testData.getTestData(method.getName() + ".CancelledContractSecondHintCL")
                        ,testData.getTestData(method.getName() + ".BillSectionHyperLinkCL")
                        ,testData.getTestData(method.getName() + ".GoToBookedOptionsAccCTACL"));
    }

    @TmsLink("WFBT-13640")
    @Test(description = "GC03 | WFBT-13640 | Check Mein Tarif Accordion & SO when User has Mixed Tariffs and the main tarif is cancelled")
    public void GC03(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateCancellationMSGBodyMainTariffSO(testData.getTestData(method.getName() + ".CancellationNotificationBodySOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"));
    }

    @TmsLink("WFBT-13641")
    @Test(description = "GC04 | WFBT-13641 | Check Mein Tarif Accordion & SO when User has Mixed Tariffs and the CLS tarif is cancelled")
    public void GC04(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateMainTariffNameSO(testData.getTestData(method.getName() + ".MainTariffNameSOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"));
    }

    @TmsLink("WFBT-13642")
    @Test(description = "GC05 | WFBT-13642 | Check Mein Tarif Accordion & SO when User has Mixed Tariffs (multiple TV tariffs) and one of the TV tariffs is cancelled")
    public void GC05(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateCancellationMSGBodyMainTariffSO(testData.getTestData(method.getName() + ".CancellationNotificationBodySOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"));
    }

    @TmsLink("WFBT-13643")
    @Test(description = "GC06 | WFBT-13643 | Check Mein Tarif Accordion & SO when User has Mixed Tariffs (multiple TV tariffs) and both TV tariffs are cancelled")
    public void GC06(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateCancellationMSGBodyMainTariffSO(testData.getTestData(method.getName() + ".CancellationNotificationBodySOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"))
                .validateCancellationSecondMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"));
    }

    @TmsLink("WFBT-13544")
    @Test(description = "GC07 | WFBT-13544 | Check Mein Tarif Accordion & SO when User has Mixed Tariffs and both tariffs are cancelled")
    public void GC07(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateCancellationMSGBodyMainTariffSO(testData.getTestData(method.getName() + ".CancellationNotificationBodySOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"))
                .validateCancellationSecondMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"));
    }

    @TmsLink("WFBT-13670")
    @Test(description = "GC08 | WFBT-13670 | Check Mein Tarif Accordion & SO when User has only multiple CLS tariff and one CLS Tariff is cancelled")
    public void GC08(Method method) {
        new KD_Dashboard(driver).expandKabelTvAccordion().clickOnMainTarifTVSO();
        new KabelTVPage(driver).validateCancellationMSGBodyMainTariffSO(testData.getTestData(method.getName() + ".CancellationNotificationBodySOCL"))
                .validateCancellationFirstMSGBodyMainTariffAcc(testData.getTestData(method.getName() + ".CancellationNotificationBodyMainTariffAccCL"));
    }
}