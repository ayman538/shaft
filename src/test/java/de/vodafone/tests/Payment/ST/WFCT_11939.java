package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
@Story("WFCT-11939")

public class WFCT_11939 extends ST_PaymentSetup {
    String contractNumber;
    String burgerMenuOrder;
    String quickCheckListOrder;
    String autoTopupAmount;
    Dashboard dashboard;
    TopUp topup;
    TopupGPP topupGPP;
    QuickCheckPage quickcheck;
    DeleteAutoTopUpPage deleteAutoTopUp;


    @TmsLink("WFCT-12286")
    @Test(description = "GC01- Paul user with active auto topup (lower balance) checks the auto topup SO in quick check page")
    public void GC01_PaulUserWithLowerBalanceAutoTopupChecksAutoTopupSO() {
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(quickCheckListOrder);
        quickcheck.assertOnLowerBalanceCLInAutoTopupSO();
    }

    @TmsLink("WFCT-12287")
    @Test(description = "GC02- Paul user with active auto topup (lower balance) checks the auto topup accordion in quick check page")
    public void GC02_PaulUserWithLowerBalanceAutoTopupChecksAutoTopupAccordion() {
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(quickCheckListOrder);
        quickcheck.clickAutomAufladenSmartObject();
        quickcheck.assertThatNextPaymentDateFieldDoesNotExist();
        quickcheck.assertOnLowerBalanceCLInAutoTopupAccordion();
    }

    @TmsLink("WFCT-12288")
    @Test(description = "GC03- Paul user with active auto topup (lower balance) deletes his auto top-up")
    public void GC03_PaulUserWithLowerBalanceAutoTopupDeletesHisAutoTopup() {
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(quickCheckListOrder);
        quickcheck.clickAutomAufladenSmartObject();
        quickcheck.clickDeleteButton();
        deleteAutoTopUp.assertOnLowerBalanceCLinTypeField();
        deleteAutoTopUp.clickPermanentlyDeleteButton();
        deleteAutoTopUp.assertOnConfirmationNotificationSublineCl();
    }

    @TmsLink("WFCT-12289")
    @Test(description = "GC04- Paul user with active auto topup (lower balance) checks the auto topup payment method CL in GPP")
    public void GC04_PaulUserWithActiveLowerBalanceAutoTopupChecksSavedPaymentMethodCL() {
        dashboard.clickTopUpTile(contractNumber);
        topup.clickDirektAufladen();
        topupGPP.assertThatAutoTopupSavedPaymentMethodlessthan5EurosCL(autoTopupAmount);
    }

    @TmsLink("WFCT-12292")
    @Test(description = "GC05- Paul user with Paused auto topup (lower balance) checks the auto topup payment method CL in GPP")
    public void GC05_PaulUserWithPausedLowerBalanceAutoTopupChecksSavedPaymentMethodCL() {
        dashboard.clickTopUpTile(contractNumber);
        topup.clickDirektAufladen();
        topupGPP.assertOnSavedPaymentMethodCLForPausedAutoTopup();
        topupGPP.assertThatElementIsOrange(topupGPP.getAutoTopupSavedPaymentMethod_label());
    }

    @TmsLink("WFCT-12293")
    @Test(description = "GC06- Paul user with Blocked auto topup (28 days) checks the auto topup payment method CL in GPP")
    public void GC06_PaulUserWithBlocked28DaysAutoTopupChecksSavedPaymentMethodCL() {
        dashboard.clickTopUpTile(contractNumber);
        topup.clickDirektAufladen();
        topupGPP.assertOnSavedPaymentMethodCLForBlockedAutoTopup();
        topupGPP.assertThatElementIsRed(topupGPP.getAutoTopupSavedPaymentMethod_label());
    }

    @TmsLink("WFCT-12294")
    @Test(description = "GC07- Paul user with In Progress auto topup (lower balance) checks the auto topup payment method CL in GPP")
    public void GC07_PaulUserWithInProgressLowerBalanceAutoTopupChecksSavedPaymentMethodCL() {
        dashboard.clickTopUpTile(contractNumber);
        topup.clickDirektAufladen();
        topupGPP.assertThatNoSpecialTextIsDisplayedForSavedPaymentMethod();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        topup = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        quickcheck = new QuickCheckPage(driver);
        deleteAutoTopUp = new DeleteAutoTopUpPage(driver);
        burgerMenuOrder = testData.getTestData(method.getName() + ".burgerMenuOrder");
        quickCheckListOrder = testData.getTestData(method.getName() + ".quickCheckListOrder");
        autoTopupAmount = testData.getTestData(method.getName() + ".autoTopupAmount");
        contractNumber = testData.getTestData(method.getName() + ".contract_number");
    }
}
