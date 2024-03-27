package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.TopUp;
import de.vodafone.pages.Payment.TopupGPP;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
public class WFCT_10085 extends ST_PaymentSetup {
    String contract_number;
    String savedPaymentMethod_number;

    @Test
    @Description("ST | GC01- Paul user successfully delete his saved payment method for auto-recharge")
    @TmsLink("WFCT-11929")
    public void GC01_PaulUserDeleteAutoTopupSavedPaymentMethod(Method method) {
        new Dashboard(driver).clickTopUpTile(contract_number);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).clickOnDeleteSavedPaymentMethod(savedPaymentMethod_number);
        new TopupGPP(driver).assertOnAutoTopupDeletionConfirmationOverlay();
        new TopupGPP(driver).clickOnDeletionConfirmationOverlay();
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).assertOnDeletionSuccessNotification();
    }

    @Test
    @Description("GC02- Paul user successfully delete more that one of his saved payment methods")
    @TmsLink("WFCT-11930")
    public void GC02_PaulUserDeleteSavedPaymentMethod(Method method) {
        new Dashboard(driver).clickTopUpTile(contract_number);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).clickOnDeleteSavedPaymentMethod(savedPaymentMethod_number);
        new TopupGPP(driver).assertOnSavedPaymentMethodDeletionConfirmationOverlay();
        new TopupGPP(driver).clickOnDeletionConfirmationOverlay();
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).assertOnDeletionSuccessNotification();
    }

    @Test
    @Description("ST | GC03- Paul user fails to delete his saved payment method for auto-recharge")
    @TmsLink("WFCT-11931")
    public void GC03_PaulUserFailsToDeleteAutoTopupSavedPaymentMethod(Method method) {
        new Dashboard(driver).clickTopUpTile(contract_number);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).clickOnDeleteSavedPaymentMethod(savedPaymentMethod_number);
        new TopupGPP(driver).assertOnAutoTopupDeletionConfirmationOverlay();
        new TopupGPP(driver).clickOnDeletionConfirmationOverlay();
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).assertOnDeletionFailureNotification();
    }

    @Test
    @Description("GC04- Paul user fails to delete his saved payment method")
    @TmsLink("WFCT-11932")
    public void GC04_PaulUserFailsToDeleteSavedPaymentMethod(Method method) {

        new Dashboard(driver).clickTopUpTile(contract_number);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).clickOnDeleteSavedPaymentMethod(savedPaymentMethod_number);
        new TopupGPP(driver).assertOnSavedPaymentMethodDeletionConfirmationOverlay();
        new TopupGPP(driver).clickOnDeletionConfirmationOverlay();
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).assertOnDeletionFailureNotification();
    }

    @BeforeMethod
    @Description("Setting contract number and saved payment method to be deteleted")
    public void testDataSetup(Method method) {
        contract_number = testData.getTestData(method.getName() + ".contract_number");
        savedPaymentMethod_number = testData.getTestData(method.getName() + ".saved_payment_method_number");
    }
}
