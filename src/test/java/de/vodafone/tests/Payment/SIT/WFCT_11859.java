package de.vodafone.tests.Payment.SIT;

import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("SIT")
public class WFCT_11859 extends SIT_PaymentSetup {
    String contractNumber;

    @Test(description = "SIT - GC01 - paul user fail to pay using PayPal")
    @TmsLink("WFCT-11896")
    public void SIT_GC01_paulUserFailToPayUsingPayPal()
    {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(contractNumber);
        new TopUp(driver).clickDirektAufladen();
//        new TopupGPP(driver).switchPayExternalNumToggleBtn();
//        new TopupGPP(driver).enterExternalPhoneNumber(testData.getTestData("InvalidExternalNumber"));
        new TopupGPP(driver).choosePaymentMethod("PayPal");
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).payWithPayPal();
        new TopupGPP(driver).switchToPaymentPopUp();
        new PayPalPage(driver).enterPayPalCredentials(testData.getTestData("PayPalEmail"), testData.getTestData("PayPalPassword"));
        new TopupGPP(driver).switchToGPP();
        new TopupGPP(driver).assertOnPayPalErrorText();
    }

    @Test(description = "SIT - GC02 - paul user fails to pay using Amazon Pay")
    @TmsLink("WFCT-11897")
    public void SIT_GC02_paulUserFailToPayUsingAmazonPay() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(contractNumber);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).choosePaymentMethod("Amazon Pay");
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).payWithAmazonPay();
        new AmazonPayPage(driver).cancelAmazonFlow(testData.getTestData("AmazonPayEmail"), testData.getTestData("AmazonPayPassword"));
        new TopupGPP(driver).assertOnSofortAndAmazonPayErrorTitle();
        new TopupGPP(driver).assertOnSofortAndAmazonPayErrorText();
    }

    @Test(description = "SIT - GC03 - paul user fails to pay using Sofort")
    @TmsLink("WFCT-11898")
    public void SIT_GC03_paulUserFailToPayUsingSofort() {

        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(contractNumber);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).choosePaymentMethod("Sofort");
        new TopupGPP(driver).payWithSofort();
        new SofortPage(driver).cancelSofortPayment();
        new TopupGPP(driver).assertOnSofortAndAmazonPayErrorTitle();
        new TopupGPP(driver).assertOnSofortAndAmazonPayErrorText();
    }

    @Test(description = "SIT - GC04- paul user fails to pay using credit card")
    @TmsLink("WFCT-11900")
    public void SIT_GC04_paulUserFailToPayUsingCreditCard()
    {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(contractNumber);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).choosePaymentMethod("Kreditkarte");
        new CreditCardPage(driver).enterCreditCardCredentials(testData.getTestData("InvalidCreditCardNum"), testData.getTestData("InvalidCreditCardMonth"), testData.getTestData("InvalidCreditCardYear"), testData.getTestData("InvalidCreditCardCvc"), testData.getTestData("InvalidCreditCardHolder"));
        new TopupGPP(driver).assertOnCreditCardErrorText();

    }

    @Test(description = "SIT - GC05 - paul user fails to pay using credit card with 3D secure")
    @TmsLink("WFCT-11901")
    public void SIT_GC05_paulUserFailToPayUsingCreditCard3DSecure()
    {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(contractNumber);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).choosePaymentMethod("Kreditkarte");
        new CreditCardPage(driver).enterCreditCardCredentials(testData.getTestData("3D_CreditCardNum"), testData.getTestData("3D_CreditCardMonth"), testData.getTestData("3D_CreditCardYear"), testData.getTestData("3D_CreditCardCvc"), testData.getTestData("3D_CreditCardHolder"));
        new CreditCardPage(driver).cancel3DSecure();
        new TopupGPP(driver).assertOnCreditCardErrorText();
    }


    @Test(description = "SIT - GC06 - paul user fails to pay using saved payment method")
    @TmsLink("WFCT-11902")
    public void SIT_GC06_paulUserFailToPayUsingSavedPaymentMethod() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickTopUpTile(contractNumber);
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).switchPayExternalNumToggleBtn();
        new TopupGPP(driver).enterExternalPhoneNumber(testData.getTestData("InvalidExternalNumber"));
        new TopupGPP(driver).selectSavedPaymentMethod("PayPal");
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).payWithSofort();
        new TopupGPP(driver).assertOnPaymentErrorMsgTitle();
        new TopupGPP(driver).assertOnPaymentErrorMsgDescription();

    }


    @Test(description = "SIT - GC07 - non-logged in user fails to pay")
    @TmsLink("WFCT-11904")
    public void SIT_GC07_nonLoggedInUserFailToPay() {
        new Dashboard(driver).logOut();
        new Dashboard(driver).navigateToPaymentPage();
        new TopupGPP(driver).enterExternalPhoneNumber(testData.getTestData("ExternalNumber"));
        new TopupGPP(driver).choosePaymentMethod("Amazon Pay");
        new TopupGPP(driver).payWithAmazonPay();
        new AmazonPayPage(driver).cancelAmazonFlow(testData.getTestData("AmazonPayEmail"), testData.getTestData("AmazonPayPassword"));
        new TopupGPP(driver).assertOnSofortAndAmazonPayErrorTitle();
        new TopupGPP(driver).assertOnSofortAndAmazonPayErrorText();    }

    @BeforeMethod
            public void beforeMethod(Method method) {
         contractNumber = testData.getTestData(method.getName() + ".ContractNumber");
    }

}
