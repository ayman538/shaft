package de.vodafone.tests.Payment.ST;

import de.vodafone.pages.Payment.ConfirmationPage;
import de.vodafone.pages.Payment.Dashboard;
import de.vodafone.pages.Payment.TopUp;
import de.vodafone.pages.Payment.TopupGPP;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Payment")
@Feature("ST")
@Story("WFGT-1170")
public class WFGT_1170 extends ST_PaymentSetup {
    @Test(description = "GC01 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP when user is reached the maximum amount for top-ups per payment method. RESTRICTED paymentMethod for single payment method (paypal)")
    @TmsLink("WFGT-1363")
    private void GC01(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .validateTopupGppHeader(testData.getTestData(method.getName() + ".GPPHeader"))
                .validateErrorMessageForRestrictedPaymentMethod(testData.getTestData(method.getName() + ".restrictedPaypalPaymentMethod"))
                .assertOnPaypalMethodNotExist()
                .assertOnKreditkarteMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnSofortMethodExist()
                .assertOnGooglePayMethodExist();
    }

    @Test(description = "GC02 | paul user | Payment | Integration of new DXL service | validate GPP for highest priority error when user has all errors (RESTRICTED maxBalanceReached 10, RESTRICTED paymentMethodLimitExceeded Amazon,RESTRICTED paymentMethod creditcard)")
    @TmsLink("WFGT-1364")
    private void GC02(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .validateErrorMessageForRestrictedMaxBalanceReached(testData.getTestData(method.getName() + ".restrictedMaxBalanceReached"))
                .assertOnSofortMethodExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnKreditkarteMethodExist()
                .assertOnPaypalMethodExist();
    }

    @Test(description = "GC03 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP for highest priority error when user is reached RESTRICTED paymentMethodLimitExceeded creditcard&ApplePay AND RESTRICTED paymentMethod sofort")
    @TmsLink("WFGT-1365")
    private void GC03(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .validateErrorMessageForRestrictedPaymentMethod(testData.getTestData(method.getName() + ".restrictedSofortPaymentMethod"))
                .assertOnSofortMethodNotExist()
                .assertOnKreditkarteMethodNotExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnPaypalMethodExist();
    }

    @Test(description = "GC04 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP for highest priority error when user is reached RESTRICTED maxBalanceReached is 15 AND RESTRICTED paymentMethodLimitExceeded creditcard")
    @TmsLink("WFGT-1362")
    private void GC04(Method method) {
        new Dashboard(driver)
                .clickOnJetztAufladenTile();
        new TopUp(driver)
                .clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .validateErrorMessageForRestrictedMaxBalanceReached(testData.getTestData(method.getName() + ".restrictedMaxBalanceReached"))
                .assertOnSofortMethodExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnKreditkarteMethodExist()
                .assertOnPaypalMethodExist();
    }

    @Test(description = "GC05 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP when user is reached the maximum amount for top-ups per payment method. RESTRICTED paymentMethod for multiple payment method paypal,sofort")
    @TmsLink("WFGT-1360")
    private void GC05(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .switchPayExternalNumToggleBtn().enterExternalPhoneNumber(testData.getTestData(method.getName() + ".externalNumber"))
                .clickOnGuthabenTitle().validateErrorMessageForRestrictedSofortPaymentMethod(testData.getTestData(method.getName() + ".restrictedPaypalSofortPaymentMethod"))
                .assertOnSofortMethodNotExist()
                .assertOnPaypalMethodNotExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnKreditkarteMethodExist();

    }

    @Test(description = "GC06 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP when user is reached the maximum amount of top-ups. RESTRICTED paymentMethodLimitExceeded for multiple payment method credit card,paypal")
    @TmsLink("WFGT-1361")
    private void GC06(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver).
                switchPayExternalNumToggleBtn().enterExternalPhoneNumber(testData.getTestData(method.getName() + ".externalNumber")).
                clickOnGuthabenTitle().validateErrorMessageForRestrictedMultiplePaymentMethod(testData.getTestData(method.getName() + ".restrictedPaypalCreditCardPaymentMethod"))
                .assertOnKreditkarteMethodNotExist()
                .assertOnPaypalMethodNotExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnSofortMethodExist();
    }

    @Test(description = "GC08 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP when user is eligible to complete the flow | Validate the service update to DXL")
    @TmsLink("WFGT-1367")
    private void GC08(Method method) {
        new Dashboard(driver)
                .expandContracts(testData.getTestData(method.getName() + ".contractOrder"))
                .clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .clickCallYaRufnummerDropDownList()
                .clickChosenCallYaRufnummer(testData.getTestData(method.getName() + ".numberIndex"))
                .choosePaymentMethod(testData.getTestData(method.getName() + ".paymentMethod"))
                .payWithSofort();
        new ConfirmationPage(driver)
                .waitForPageLoad()
                .assertOnConfirmationPageTopUpNotificationBody()
                .assertOnConfirmationPageTopUpNotificationLinkText();
    }

    @Test(description = "GC10 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP when user entered incorrect phone number for logged in user (code:APA000014)")
    @TmsLink("WFGT-1402")
    private void GC10(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .switchPayExternalNumToggleBtn()
                .enterExternalPhoneNumber(testData.getTestData(method.getName() + ".InvalidNumber"))
                .validateErrorMessageForInvalidNumber(testData.getTestData(method.getName() + ".InvalidNumberErrorMsg"))
                .clickOnGuthabenTitle()
                .validateNotifiationMessageForIncorrectPhoneNumber(testData.getTestData(method.getName() + ".InvalidNumberNotificationMsgBackend"))
                .validateErrorMessageForInvalidNumberBackend(testData.getTestData(method.getName() + ".InvalidNumberBackend"));
    }
    @Test(description = "GC13 paul user with multiple contracts | Payment | Integration of new DXL service | Validate Receiver | Deeplink with loggedin user to GPP when user is BARRED for any barring reason")
    @TmsLink("WFGT-1405")
    private void GC13(Method method) {
        new Dashboard(driver).navigateToPaymentPage_ST();
        new TopupGPP(driver)
                .clickCallYaRufnummerDropDownList().clickChosenCallYaRufnummer(testData.getTestData(method.getName() + ".numberIndex"))
                .validateBarredForAnyBarringReason(testData.getTestData(method.getName() + ".BarredForAnyBarringReasonErrorMessage"))
                .assertOnKreditkarteMethodExist()
                .assertOnPaypalMethodExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnSofortMethodExist();
    }

    @Test(description = "GC15 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP when service is failed (code:APA000001)")
    @TmsLink("WFGT-1407")
    private void GC15(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .validateGeneralErrorPage(testData.getTestData(method.getName() + ".GeneralErrorHeader"),testData.getTestData(method.getName() + ".GeneralErrorContent"));

    }
    @Test(description = "GC16 | paul user | Payment | Integration of new DXL service | Validate Receiver | validate GPP when user is BARRED for any barring reason")
    @TmsLink("WFGT-1408")
    private void GC16(Method method) {
        new Dashboard(driver).clickOnJetztAufladenTile();
        new TopUp(driver).clickOnEinmaligeDirektaufladungTile();
        new TopupGPP(driver)
                .validateBarredForAnyBarringReason(testData.getTestData(method.getName() + ".BarredForAnyBarringReasonErrorMessage"))
                .assertOnKreditkarteMethodExist()
                .assertOnPaypalMethodExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodExist()
                .assertOnSofortMethodExist();
    }
    @Test(description = "GC17 | paul user | Payment | Integration of new DXL service | validate GPP for highest priority error when user has all errors (RESTRICTED BarringReason, RESTRICTED maxBalanceReached, RESTRICTED paymentMethodLimitExceeded,RESTRICTED paymentMethod)")
    @TmsLink("WFGT-1413")
    private void GC17(Method method) {
        new Dashboard(driver).navigateToPaymentPage_ST();
        new TopupGPP(driver)
                .validateBarredForAnyBarringReason(testData.getTestData(method.getName() + ".BarredForAnyBarringReasonErrorMessage"))
                .assertOnKreditkarteMethodNotExist()
                .assertOnPaypalMethodExist()
                .assertOnGooglePayMethodExist()
                .assertOnAmazonPayMethodNotExist()
                .assertOnSofortMethodExist();
    }
}
