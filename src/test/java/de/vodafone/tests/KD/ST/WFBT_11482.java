package de.vodafone.tests.KD.ST;

import de.vodafone.pages.KD.BookingTransactionPage;
import de.vodafone.pages.KD.ConfirmationPage;
import de.vodafone.pages.KD.KD_Dashboard;
import de.vodafone.pages.KD.TariffPageInternetAndPhone;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("KD")
@Feature("ST")
@Story("WFBT-11482")
public class WFBT_11482 extends ST_KDSetup{
    @TmsLink("WFBT_11484")
    @Test(description = "GC01 Check the CL of legal text in the transaction page.")
    public void GC01CheckCLOfLegalTextTransactionPage(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).validateAccordionHeaderTitleInternet(testData.getTestData(method.getName() + ".AccordionHeaderTitleInternetCL"))
                .validateLegalTextCard(testData.getTestData(method.getName() + ".ContractSummaryPreTextCL")
                        ,testData.getTestData(method.getName() + ".ContractSummaryPostTextCL")
                        ,testData.getTestData(method.getName() + ".ContractSummaryTextCL"));
    }

    @TmsLink("WFBT_11495")
    @Test(description = "GC02 Check that when the user clicks on hyper link, the contract summary pdf is downloaded")
    public void GC02CheckContractSummaryPDFDownloaded(){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).clickContractSummaryPDFHyperLink();
    }

    @TmsLink("WFBT_11692")
    @Test(description = "BC01 Check when click on hyper link in case of contract summery available")
    public void BC01CheckInCaseOfContractSummaryAvailableInternet(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickInternetBookableOptionsAccordion().clickBookNowInternetFirstFreeOptionCTA();
        new BookingTransactionPage(driver).clickContractSummaryPDFHyperLink();
        new ConfirmationPage(driver).validateErrorMessageNotification(testData.getTestData(method.getName() + ".ErrorNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".ErrorNotificationSubLineCL"));
    }

    @TmsLink("WFBT_11693")
    @Test(description = "BC02 Check when click on hyper link in case of contract summary unavailable")
    public void BC02CheckInCaseOfContractSummaryUnAvailableTelefon(Method method){
        new KD_Dashboard(driver).expandKabelInternetAndPhoneAcc().clickMeinTariffSmartObject();
        new TariffPageInternetAndPhone(driver).clickPhoneBookableOptionsAccordion().clickBookNowPhoneFirstOptionCTA();
        new BookingTransactionPage(driver).clickContractSummaryPDFHyperLink()
                .validateTryAgainNotification(testData.getTestData(method.getName() + ".TryAgainNotificationHeaderCL")
                ,testData.getTestData(method.getName() + ".TryAgainNotificationSubLineCL")
                ,testData.getTestData(method.getName() + ".TryAgainNotificationCTACL"));
    }
}