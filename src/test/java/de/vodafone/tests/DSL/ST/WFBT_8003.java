package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.*;
import io.qameta.allure.*;
import org.testng.annotations.Test;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-8003")
public class WFBT_8003 extends ST_DSLSetup{

    @TmsLink("WFBT-10028")
    @Test(description = "GC01 - Check booking transaction and confirmation page (Success flow)")
    private void GC01() {
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc()
                .validateOnSecureNetBody()
                .clickSecurenetPlusBookNowCTA();
        new SecureNetPlusBookingTransaction(driver).validateSecureNetTransactionPage()
                .validateBookingDate()
                .validateSecureNetCard()
                .clickConfirmBookSecureNetPlusCTA();
        new SecureNetPlusBookingConfirmation(driver).validateSuccessMessage()
                .expandOverviewAccordion()
                .validateSecureNetCard()
                .validateBookingDate();
    }

    @TmsLink("WFBT-10031")
    @Test(description = "GC03 - Check Conflict hint message")
    private void GC03() {
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc().clickSecurenetPlusBookNowCTA();
        new SecureNetPlusBookingTransaction(driver)
                .validateConflictMsgInTransactionPage().clickConfirmBookSecureNetPlusCTA();
        new SecureNetPlusBookingConfirmation(driver)
                .validateConflictMsgInConfirmationPage();
    }

    @TmsLink("WFBT-10032")
    @Test(description = "GC04 - Check add email message before booking")
    private void GC04() {
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc().clickSecurenetPlusBookNowCTA();
        new AddEmailConflictPage(driver).validateEmailConflictPage();
    }
}