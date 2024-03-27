package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.DSL_Dashboard;
import de.vodafone.pages.DSL.DSL_MeineRechnungen;
import de.vodafone.pages.DSL.KontostandPage;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("DSL")
@Feature("ST")
public class WFFT_4268 extends ST_DSLSetup{
    @Test(description="GC01 - Verify the account balance page in case the open amount.")
    @TmsLink("WFFT-4853")
    private void GC01(Method method) {
        new DSL_Dashboard(driver).clickOnMeineRechnungen();
        new DSL_MeineRechnungen(driver).clickOnRechnungsübersichtAccordion().clickOnAccountBalanceBtn();
        new KontostandPage(driver).validateKontostandPageIsOpened(testData.getTestData(method.getName() + ".header"),testData.getTestData(method.getName() + ".subHeader"))
                .validateInvoicesWhiteBox(testData.getTestData(method.getName() + ".whiteBox_Headline"),testData.getTestData(method.getName() + ".whiteBox_InvoiceTitle"),testData.getTestData(method.getName() + ".whiteBox_InvoiceAmount"))
                .validatePaymentOptionsWhiteBox(testData.getTestData(method.getName() + ".paymentOption_Headline"),testData.getTestData(method.getName() + ".paymentOption_Button"))
                .validateThePageInfo(testData.getTestData(method.getName() + ".firstInfo_SubHeadline"),testData.getTestData(method.getName() + ".secondInfo_SubHeadline"))
                .validateTheDocumentsInfo(testData.getTestData(method.getName() + ".document_Headline"),testData.getTestData(method.getName() + ".firstDocument_Title"),testData.getTestData(method.getName() + ".secondDocument_Title"));
    }
    @Test(description="GC02 - Verify the account balance page in case the dunning amount And due amount == open amount")
    @TmsLink("WFFT-4854")
    private void GC02(Method method) {
        new DSL_Dashboard(driver).clickOnMeineRechnungen();
        new DSL_MeineRechnungen(driver).clickOnRechnungsübersichtAccordion().clickOnAccountBalanceBtn();
        new KontostandPage(driver).validateKontostandPageIsOpened(testData.getTestData(method.getName() + ".header"),testData.getTestData(method.getName() + ".subHeader"))
                .validateInvoicesWhiteBox(testData.getTestData(method.getName() + ".whiteBox_Headline"),testData.getTestData(method.getName() + ".whiteBox_InvoiceTitle"),testData.getTestData(method.getName() + ".whiteBox_InvoiceAmount"))
                .validatePaymentOptionsWhiteBox(testData.getTestData(method.getName() + ".paymentOption_Headline"),testData.getTestData(method.getName() + ".paymentOption_Button"))
                .validateThePageInfo(testData.getTestData(method.getName() + ".firstInfo_SubHeadline"),testData.getTestData(method.getName() + ".secondInfo_SubHeadline"))
                .validateTheDocumentsInfo(testData.getTestData(method.getName() + ".document_Headline"),testData.getTestData(method.getName() + ".firstDocument_Title"),testData.getTestData(method.getName() + ".secondDocument_Title"))
                .validateDunningCase(testData.getTestData(method.getName() + ".dunningNotif_Headline"));
    }
    @Test(description="GC03 - Verify the account balance page in case the user having dunning amount & open amount And open amount > due amount")
    @TmsLink("WFFT-4855")
    private void GC03(Method method) {
        new DSL_Dashboard(driver).clickOnMeineRechnungen();
        new DSL_MeineRechnungen(driver).clickOnRechnungsübersichtAccordion().clickOnAccountBalanceBtn();
        new KontostandPage(driver).validateKontostandPageIsOpened(testData.getTestData(method.getName() + ".header"),testData.getTestData(method.getName() + ".subHeader"))
                .validateInvoicesWhiteBox(testData.getTestData(method.getName() + ".whiteBox_Headline"),testData.getTestData(method.getName() + ".whiteBox_InvoiceTitle"),testData.getTestData(method.getName() + ".whiteBox_InvoiceAmount"))
                .validatePaymentOptionsWhiteBox(testData.getTestData(method.getName() + ".paymentOption_Headline"),testData.getTestData(method.getName() + ".paymentOption_Button"))
                .validateThePageInfo(testData.getTestData(method.getName() + ".firstInfo_SubHeadline"),testData.getTestData(method.getName() + ".secondInfo_SubHeadline"))
                .validateTheDocumentsInfo(testData.getTestData(method.getName() + ".document_Headline"),testData.getTestData(method.getName() + ".firstDocument_Title"),testData.getTestData(method.getName() + ".secondDocument_Title"))
                .validateDunningCase(testData.getTestData(method.getName() + ".dunningNotif_Headline"));
    }

    @Test(description="GC04 - Verify the account balance page in case the general error.")
    @TmsLink("WFFT-4856")
    private void GC04(Method method) {
        new KontostandPage(driver).deepLinkToAccountBalancePage().validateGeneralErrorCase(testData.getTestData(method.getName() + ".generalErrorNotif_Headline"));
    }
    @Test(description="GC05 - Verify the account balance page in case the user not eligible for the page.")
    @TmsLink("WFFT-4857")
    private void GC05(Method method) {
       new KontostandPage(driver).deepLinkToAccountBalancePage().validateEligibleErrorCase(testData.getTestData(method.getName() + ".eligibleErrorNotif_Headline"));
    }
}
