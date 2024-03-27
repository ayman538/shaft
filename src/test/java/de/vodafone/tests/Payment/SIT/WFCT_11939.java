package de.vodafone.tests.Payment.SIT;

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

public class WFCT_11939 extends SIT_PaymentSetup {
    String contractNumber;
    String burgerMenuOrder;
    String quickCheckListOrder;
    String autoTopupAmount;
    String paypalEmail;
    String paypalPassword;
    Dashboard dashboard;
    TopUp topup;
    TopupGPP topupGPP;
    QuickCheckPage quickcheck;
    DeleteAutoTopUpPage deleteAutoTopUp;
    PayPalPage paypal;

   /** pre condition to run this class make sure that the account in the test data file has ana ctive auto topup **/

    @TmsLink("WFCT-12286")
    @Test(description = "GC01- Paul user with active auto topup (lower balance) checks the auto topup SO in quick check page")
    public void GC01_PaulUserWithLowerBalanceAutoTopupChecksAutoTopupSO() {
        dashboard.expandContracts(contractNumber);
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(quickCheckListOrder);
        quickcheck.assertOnLowerBalanceCLInAutoTopupSO();
    }

    @TmsLink("WFCT-12287")
    @Test(description = "GC02- Paul user with active auto topup (lower balance) checks the auto topup accordion in quick check page")
    public void GC02_PaulUserWithLowerBalanceAutoTopupChecksAutoTopupAccordion() {
        dashboard.expandContracts(contractNumber);
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(quickCheckListOrder);
        quickcheck.clickDeineAutomAufladungenAccordion();
        quickcheck.assertThatNextPaymentDateFieldDoesNotExist();
        quickcheck.assertOnLowerBalanceCLInAutoTopupAccordion();
    }

    @TmsLink("WFCT-12288")
    @Test(description = "GC03- Paul user with active auto topup (lower balance) deletes his auto top-up")
    public void GC03_PaulUserWithLowerBalanceAutoTopupDeletesHisAutoTopup() {
        dashboard.expandContracts(contractNumber);
        dashboard.clickBurgerMenuIcon(burgerMenuOrder);
        dashboard.clickQuickCheckList(quickCheckListOrder);
        quickcheck.clickDeineAutomAufladungenAccordion();
        quickcheck.clickDeleteButton();
        deleteAutoTopUp.assertOnLowerBalanceCLinTypeField();
        deleteAutoTopUp.clickPermanentlyDeleteButton();
        deleteAutoTopUp.assertOnConfirmationNotificationSublineCl();
    }

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        topup = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        quickcheck = new QuickCheckPage(driver);
        deleteAutoTopUp = new DeleteAutoTopUpPage(driver);
        paypal = new PayPalPage(driver);
        paypalPassword = testData.getTestData("PayPalPassword");
        burgerMenuOrder = testData.getTestData(method.getName() + ".burgerMenuOrder");
        quickCheckListOrder = testData.getTestData(method.getName() + ".quickCheckListOrder");
        autoTopupAmount = testData.getTestData(method.getName() + ".autoTopupAmount");
        contractNumber = testData.getTestData(method.getName() + ".contractNumber");
        paypalEmail = testData.getTestData("PayPalEmail");
    }
}
