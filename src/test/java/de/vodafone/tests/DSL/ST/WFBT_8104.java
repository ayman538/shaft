package de.vodafone.tests.DSL.ST;

import de.vodafone.pages.DSL.*;
import io.qameta.allure.*;

import org.testng.annotations.Test;

@Epic("DSL")
@Feature("ST")
@Story("WFBT-8104")
public class WFBT_8104 extends ST_DSLSetup {

    @TmsLink("WFBT-10304")
    @Test(description = "GC01 | WFBT-10304 | Check cancel confirmation page when user has non-booked old security package")
    public void GC01() {
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).expandSecureNetAcc().clickCancelSecureNetPlus();
        new CancelSecureNetPlusReviewPage(driver).validateReviewPageElements().validateCancellationDate()
                .clickOnCancelNowCTA();
        new CancelSecureNetPlusConfirmationPage(driver).validateConfirmationPageElements()
                .expandOverviewMenu()
                .validateConfirmationMessage()
                .validateCancellationDate();
    }

    @TmsLink("WFBT-10306")
    @Test(description = "GC02 | WFBT-10305 | Check add email notification when canceling secure net")
    public void GC02() {
        new DSL_Dashboard(driver).chooseMyProductsFromMyProductsAcc();
        new MyDSLProducts(driver).clickSecureNetSO_expandSecureNetAcc().clickCancelSecureNetPlus();
        new CancelSecureNetPlusReviewPage(driver).validateEmailNotification();
    }

    @TmsLink("WFBT-10307")
    @Test(description = "GC03 | WFBT-10306 | Check old security package notification in review and confirmation pages")
    public void GC03() {
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).expandSecureNetAcc().clickCancelSecureNetPlus();
        new CancelSecureNetPlusReviewPage(driver).validateReviewPageElements().validateCancellationDate()
                .validateOldSecurityPackageNotification()
                .clickOnCancelNowCTA();
        new CancelSecureNetPlusConfirmationPage(driver).validateConfirmationPageElements()
                .expandOverviewMenu()
                .validateConfirmationMessage()
                .validateOldSecurityPackageNotification()
                .validateCancellationDate();
    }

    @TmsLink("WFBT-14277")
    @Test(description = "GC06 | WFBT-14277 | check when secure net plus is already cancelled")
    public void GC04(){
        new DSL_Dashboard(driver).clickOnMeinTarifSO();
        new MyDSLProducts(driver).expandSecureNetAcc().validateOnCancelCTAForSecureNet();
    }
}