package de.vodafone.tests.Payment.SIT;


import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
@Story("WFCT-8629")
public class WFCT_8629 extends SIT_PaymentSetup {
    Dashboard dashboard;
    TopUp topUp;
    TopupGPP topupGPP;
    ConfirmationPage confirmationPage;
    String contractOrder;
    String paymentMethod;
    String savedPaymentMethod;
    String rufnummerValue;
    String amountValue;
    String paymentMethodValue;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        topUp = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        confirmationPage = new ConfirmationPage(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        paymentMethod = testData.getTestData(method.getName() + ".paymentMethod");
        savedPaymentMethod = testData.getTestData(method.getName() + ".savedPaymentMethod");
        rufnummerValue = testData.getTestData(method.getName() + ".rufnummerValue");
        amountValue = testData.getTestData(method.getName() + ".amountValue");
        paymentMethodValue = testData.getTestData(method.getName() + ".paymentMethodValue");
    }

    @Test(description = "WFCT_8629 | GC01 - Paul user completes successful top up using iban")
    @TmsLink("WFCT-13046")
    public void GC01_PaulUserCompletesSuccessfulTopUpUsingIban() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertOnSavedPaymentMethodCL();
        topupGPP.clickIbanMethod();
        topupGPP.clickPayNowButton();
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkText();
        confirmationPage.assertOnIbanConfirmationAccordion(rufnummerValue ,  amountValue ,  paymentMethodValue);
        confirmationPage.clickOnNotificationLink();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkNavigation();


    }

    @Test(description = "WFCT_8629 | GC02 - Paul user checks top up with iban for another number")
    @TmsLink("WFCT-13047")
    public void GC02_PaulUserChecksTopUpWithIbanForAnotherNumber() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertOnSavedPaymentMethodCL();
        topupGPP.switchPayExternalNumToggleBtn();
        topupGPP.assertThatIbanMethodNotExist();
    }
}
