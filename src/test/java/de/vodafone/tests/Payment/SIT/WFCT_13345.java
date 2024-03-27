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
@Feature("SIT")
@Story("WFCT-13345")

public class WFCT_13345 extends SIT_PaymentSetup{

    Dashboard dashboard;
    TopUp topUp;
    TopupGPP topupGPP;
    ConfirmationPage confirmationPage;
    SofortPage sofortPage;
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
        sofortPage = new SofortPage(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        paymentMethod = testData.getTestData( "paymentMethod");
        savedPaymentMethod = testData.getTestData(method.getName() + ".savedPaymentMethod");
        rufnummerValue = testData.getTestData(method.getName() + ".rufnummerValue");
        amountValue = testData.getTestData(method.getName() + ".amountValue");
        paymentMethodValue = testData.getTestData(method.getName() + ".paymentMethodValue");

    }


    @Test(description = "WFCT_13345 | GC01 - Paul user completes one time payment using Sofort and save it as a saved payment method")
    @TmsLink("WFCT-13706")
    public void GC01_PaulUserCompletesOneTimePaymentUsingSofortAndSaveIt(Method method) {
        dashboard.expandContracts(contractOrder);
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertThatIbanMethodNotExist();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertThatSaveSofortCheckBoxEnabled();
        topupGPP.payWithSofort();
        sofortPage.enterSofortCredentials(testData.getTestData("SofortAccountNum"), testData.getTestData("SofortPin"), testData.getTestData("SofortTan"));
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnIbanConfirmationAccordion(rufnummerValue ,  amountValue ,  paymentMethodValue);
        confirmationPage.clickOnNotificationLink();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkNavigation();

    }

    @Test(description = "WFCT_13345 | GC02 - Paul user completes one time payment using IBAN saved payment method")
    @TmsLink("WFCT-13707")
    public void GC02_PaulUserCompletesOneTimePaymentUsingIbanSavedPaymentMethod(Method method) {
        dashboard.clickTopUpTile(contractOrder);
        topUp.clickDirektAufladen();
        topupGPP.assertThatIbanMethodExists();
        topupGPP.choosePaymentMethod(paymentMethod);
        topupGPP.assertThatSaveSofortCheckBoxDisabled();
        topupGPP.clickIbanMethod();
        topupGPP.clickPayNowButton();
        confirmationPage.waitForPageLoad();
        confirmationPage.assertOnIbanConfirmationAccordion(rufnummerValue ,  amountValue ,  paymentMethodValue);
        confirmationPage.clickOnNotificationLink();
        confirmationPage.assertOnConfirmationPageTopUpNotificationLinkNavigation();
    }




   
}
