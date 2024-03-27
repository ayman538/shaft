package de.vodafone.tests.Payment.SIT;

import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;


@Epic("Payment")
@Feature("SIT")
public class WFCT_11804 extends SIT_PaymentSetup {

    JSONFileManager td = new JSONFileManager(System.getProperty("testDataFolderPath") + "Payment/SIT/WFCT_11804.json");

    @Test
    public void SIT_GC01_MobileUserCompletesPaymentFlowUsingPaypal() {
        (new Dashboard(driver)).expandContracts("2")
                .clickTopUpTile("2");
        new TopUp(driver).clickDirektAufladen();
        (new TopupGPP(driver))
                .choosePaymentMethod("PayPal")
                .waitForSpinnerInvisibility()
                .payWithPayPal();
        new TopupGPP(driver).switchToPaymentPopUp();
        new PayPalPage(driver).enterPayPalCredentials(td.getTestData("PayPalEmail"), td.getTestData("PayPalPassword"));
        new TopupGPP(driver).switchToGPP();
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("PayPal");

    }

    @Test
    public void SIT_GC02_MobileUserCompletesPaymentFlowUsingAmazonPay() {
        (new Dashboard(driver)).expandContracts("7")
                .clickTopUpTile("7");
        new TopUp(driver).clickDirektAufladen();
        (new TopupGPP(driver))
                .choosePaymentMethod("Amazon Pay")
                .payWithAmazonPay();
        new AmazonPayPage(driver).enterAmazonPayCredentials(td.getTestData("AmazonPayEmail"), td.getTestData("AmazonPayPassword"));
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("Amazon Pay");
    }

    @Test(enabled = false)
    public void SIT_GC03_MobileUserCompletesPaymentFlowUsingSofort() {
        (new Dashboard(driver)).expandContracts("7")
                .clickTopUpTile("7");
        new TopUp(driver).clickDirektAufladen();
        (new TopupGPP(driver))
                .choosePaymentMethod("Sofort")
                .payWithSofort();
        new SofortPage(driver).enterSofortCredentials(td.getTestData("SofortAccountNum"), td.getTestData("SofortPin"), td.getTestData("SofortTan"));
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("Sofort");
    }

    @Test
    public void SIT_GC04_MobileUserCompletesPaymentFlowUsingCreditCardWithout3D() {
        (new Dashboard(driver)).expandContracts("7")
                .clickTopUpTile("7");
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).choosePaymentMethod("Kreditkarte");
        new CreditCardPage(driver).enterCreditCardCredentials(td.getTestData("CreditCardNum"), td.getTestData("CreditCardMonth"), td.getTestData("CreditCardYear"), td.getTestData("CreditCardCvc"), td.getTestData("CreditCardHolder"));
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("Kreditkarte");
    }

    @Test
    public void SIT_GC05_MobileUserCompletesPaymentFlowUsingCreditCardWith3D() {
        (new Dashboard(driver)).expandContracts("7")
                .clickTopUpTile("7");
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).choosePaymentMethod("Kreditkarte");
        new CreditCardPage(driver).enterCreditCardCredentials(td.getTestData("3D_CreditCardNum"), td.getTestData("3D_CreditCardMonth"), td.getTestData("3D_CreditCardYear"), td.getTestData("3D_CreditCardCvc"), td.getTestData("3D_CreditCardHolder"));
        new CreditCardPage(driver).enter3DSecureCredentials(td.getTestData("3D_CreditCardPassword"));
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("Kreditkarte");
    }

//    @Test
//    public void SIT_GC06_MobileUserCompletesPaymentFlowUsingGooglePay() {
//        (new Dashboard(driver)).expandContracts(6)
//                .clickTopUpTile(6);
//
//        new TopUp(driver).clickDirektAufladen();
//
//        (new TopupGPP(driver))
//                .choosePaymentMethod("Google Pay")
//                .payWithGooglePay();
//
//        new TopupGPP(driver).switchToPaymentPopUp();
//        new GooglePayPage(driver).enterGooglePayCredentials(googlepayEmail, googlepayPassword);
//
//    }

    @Test
    public void SIT_GC07_MobileUserCompletesPaymentFlowForExternalNumber() {
        (new Dashboard(driver)).expandContracts("7")
                .clickTopUpTile("7");
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).switchPayExternalNumToggleBtn();
        new TopupGPP(driver).enterExternalPhoneNumber(td.getTestData("ExternalNumber"));
        new TopupGPP(driver).choosePaymentMethod("Amazon Pay");
        new TopupGPP(driver).waitForSpinnerInvisibility();
        new TopupGPP(driver).payWithAmazonPay();
        new AmazonPayPage(driver).enterAmazonPayCredentials(td.getTestData("AmazonPayEmail"), td.getTestData("AmazonPayPassword"));
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("Amazon Pay");


    }

    @Test
    public void SIT_GC08_MobileUserCompletesPaymentFlowUsingSavedPaymentMethod() {
        (new Dashboard(driver)).expandContracts("7")
                .clickTopUpTile("7");
        new TopUp(driver).clickDirektAufladen();
        new TopupGPP(driver).selectSavedPaymentMethod("PayPal");
        new TopupGPP(driver).payWithSofort();
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("PayPal");
    }

    @Test
    public void SIT_GC09_nonLoggedUserCompletesPaymentFlow() {;
        new Dashboard(driver).navigateToPaymentPage();
        new TopupGPP(driver).enterExternalPhoneNumber(td.getTestData("ExternalNumber"));
        new TopupGPP(driver).choosePaymentMethod("Kreditkarte");
        new CreditCardPage(driver).enterCreditCardCredentials(td.getTestData("CreditCardNum"), td.getTestData("CreditCardMonth"), td.getTestData("CreditCardYear"), td.getTestData("CreditCardCvc"), td.getTestData("CreditCardHolder"));
        new ConfirmationPage(driver).assertThatTopUPNotificationBodyExist();
        new ConfirmationPage(driver).assertOnPaymentMethod("Kreditkarte");
    }
}
