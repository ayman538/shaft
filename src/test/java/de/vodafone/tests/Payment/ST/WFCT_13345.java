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
@Story("WFCT-13345")

public class WFCT_13345 extends ST_PaymentSetup {
    Dashboard dashboard;
    TopUp topUp;
    TopupGPP topupGPP;
    ConfirmationPage confirmationPage;
    String contractOrder;
    String paymentMethod;
    String externalNumber;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        topUp = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        confirmationPage = new ConfirmationPage(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        paymentMethod = testData.getTestData( "paymentMethod");
        externalNumber = testData.getTestData(method.getName() + ".externalNumber");


    }

    @Test(description = "WFCT_13345 | GC01 - Paul user completes one time payment using Sofort and save it as a saved payment method")
    @TmsLink("WFCT-13706")
    public void GC01_PaulUserCompletesOneTimePaymentUsingSofortAndSaveIt(Method method) {
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertThatIbanMethodNotExist();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertOnSaveSofortStatementText();
        topupGPP.assertOnSaveSofortToolTipText_NoIbanSaved();
        topupGPP.assertThatSaveSofortCheckBoxEnabled();
        topupGPP.payWithSofort();
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkText();
    }

    @Test(description = "WFCT_13345 | GC02 - Paul user completes one time payment using IBAN saved payment method")
    @TmsLink("WFCT-13707")
    public void GC02_PaulUserCompletesOneTimePaymentUsingIbanSavedPaymentMethod(Method method) {
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertThatIbanMethodExists();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertOnSaveSofortStatementText();
        topupGPP.assertOnSaveSofortToolTipText_IbanSaved();
        topupGPP.assertThatSaveSofortCheckBoxDisabled();
        topupGPP.clickIbanMethod();
        topupGPP.clickPayNowButton();
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkText();

    }

    @Test(description = "WFCT_13345 | GC04 - non logged user completes one time payment using Sofort")
    @TmsLink("WFCT-13709")
    public void GC04_NonLoggedUserCompletesOneTimePaymentUsingSofort(Method method) {
        dashboard.navigateToPaymentPage_ST();
        topupGPP.enterExternalPhoneNumber(externalNumber);
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertThatSaveSofortCheckboxNotExists();
        topupGPP.assertThatSaveSofortStatementNotExists();
        topupGPP.assertThatSaveSofortToolTipNotExists();
    }

    @Test(description = "WFCT_13345 | GC05 - Paul user with more than 1 saved payment method completes one time payment using IBAN")
    @TmsLink("WFCT-13710")
    public void GC05_PaulUserWithMoreThan1SavedPaymentMethodCompletesOneTimePaymentUsingSofort(Method method) {
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertThatIbanMethodNotExist();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertOnSaveSofortStatementText();
        topupGPP.assertOnSaveSofortToolTipText_NoIbanSaved();
        topupGPP.assertThatSaveSofortCheckBoxEnabled();
        topupGPP.payWithSofort();
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkText();
    }

    @Test(description = "WFCT_13345 | GC06 - Paul user competes one time payment using sofort without saving it")
    @TmsLink("WFCT-13711")
    public void GC06_PaulUserCompetesOneTimePaymentUsingSofortWithoutSavingIt(Method method) {
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertThatIbanMethodNotExist();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertOnSaveSofortStatementText();
        topupGPP.assertOnSaveSofortToolTipText_NoIbanSaved();
        topupGPP.assertThatSaveSofortCheckBoxEnabled();
        topupGPP.clickOnSaveSofortCheckBox();
        topupGPP.payWithSofort();
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkText();

    }

    @Test(description = "WFCT_13345 | GC07 - Paul user with saved IBAN competes one time payment using sofort and checks save checkbox")
    @TmsLink("WFCT-13712")
    public void GC07_PaulUserWithSavedIbanCompletesOneTimePaymentUsingSofortAndChecksSaveCheckbox(Method method) {
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertThatIbanMethodExists();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertOnSaveSofortStatementText();
        topupGPP.assertOnSaveSofortToolTipText_IbanSaved();
        topupGPP.assertThatSaveSofortCheckBoxDisabled();
        topupGPP.clickPayNowButton();
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkText();

    }

    @Test(description = "WFCT_13345 | BC01 - Paul user fails to save Sofort as a saved payment method")
    @TmsLink("WFCT-13715")
    public void BC01_PaulUserFailsToSaveSofortAsSavedPaymentMethod(Method method) {
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.clickPayNowButton();
        topupGPP.assertOnPaymentErrorMsgTitle();
        topupGPP.assertOnPaymentErrorMsgDescription();

    }



}
