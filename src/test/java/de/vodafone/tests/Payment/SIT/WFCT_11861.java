package de.vodafone.tests.Payment.SIT;

import com.shaft.driver.SHAFT;
import com.shaft.tools.io.JSONFileManager;
import de.vodafone.pages.Payment.*;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.HashMap;

@Epic("Payment")
@Feature("SIT")
public class WFCT_11861 {

    public SHAFT.GUI.WebDriver driver;
    public JSONFileManager testData;
    public HashMap<String, String> cookieMap;
    public String userName;
    public String userPassword;
    public String paymentMethod;
    public String contractNumber;

    @BeforeMethod(description = "Setting User Name, Login, click accept cookies and validate login")
    public void setup(Method method) {

        userName = testData.getTestData(method.getName() + ".name");
        userPassword = testData.getTestData(method.getName() + ".password");
        contractNumber = testData.getTestData(method.getName() + ".ContractNumber");
        paymentMethod = testData.getTestData(method.getName() + ".PaymentMethod");
        driver = new SHAFT.GUI.WebDriver();
        new Login(driver).navigateSIT()
                .setCookie(cookieMap)
                .acceptCookies()
                .loginActionSIT(userName, userPassword);

    }

    @BeforeClass(description = "Setting cookie map file and test data file")
    public void beforeClass() {
        cookieMap = (HashMap<String, String>) new JSONFileManager(System.getProperty("cookieSwitchersFolderPath") + "Payment/SIT_WFCT_11861_CookieSwitcher.json").getTestDataAsMap("$");
        testData = new JSONFileManager(System.getProperty("testDataFolderPath") + "Payment/SIT/WFCT_11861.json");
    }

    @AfterMethod(description = "Close the browser after the test")
    public void tearDown() {

        driver.browser().closeCurrentWindow();

    }


    @Test(description = "User Completes Successful Dunning Flow Using Paypal")
    @TmsLink("WFCT-11943")
    public void SIT_GC01_UserCompletesSuccessfulDunningFlowUsingPaypal() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new DunningGPP(driver).payWithPayPal();
        new DunningGPP(driver).switchToPaymentPopUp();
        new PayPalPage(driver).enterPayPalCredentials(testData.getTestData("PayPalEmail"), testData.getTestData("PayPalPassword"));
        new DunningGPP(driver).switchToGPP();
        new ConfirmationPage(driver).assertConfirmationAccordionExists();
        new ConfirmationPage(driver).assertOnPaymentMethod(paymentMethod);

    }

    @Test(description = "User Completes Successful Dunning Flow Using AmazonPay")
    @TmsLink("WFCT-11944")
    public void SIT_GC02_UserCompletesSuccessfulDunningFlowUsingAmazonPay() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new DunningGPP(driver).payWithAmazonPay();
        new AmazonPayPage(driver).enterAmazonPayCredentials(testData.getTestData("AmazonPayEmail"), testData.getTestData("AmazonPayPassword"));
        new ConfirmationPage(driver).assertConfirmationAccordionExists();
        new ConfirmationPage(driver).assertOnPaymentMethod(paymentMethod);
    }

    @Test(description = "User Completes Successful Dunning Flow Using Sofort")
    @TmsLink("WFCT-11945")
    @Issue("WFCT-11722")
    public void SIT_GC03_UserCompletesSuccessfulDunningFlowUsingSofort() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new DunningGPP(driver).payWithSofort();
        new SofortPage(driver).enterSofortCredentials(testData.getTestData("SofortAccountNum"), testData.getTestData("SofortPin"), testData.getTestData("SofortTan"));
        new ConfirmationPage(driver).assertConfirmationAccordionExists();
        new ConfirmationPage(driver).assertOnPaymentMethod(paymentMethod);
    }

    @Test(description = "User Completes Successful Dunning Flow Using CreditCard Without 3D")
    @TmsLink("WFCT-11946")
    public void SIT_GC04_UserCompletesSuccessfulDunningFlowUsingCreditCardWithout3D() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new CreditCardPage(driver).enterCreditCardCredentials(testData.getTestData("CreditCardNum"), testData.getTestData("CreditCardMonth"), testData.getTestData("CreditCardYear"), testData.getTestData("CreditCardCvc"), testData.getTestData("CreditCardHolder"));
        new ConfirmationPage(driver).assertConfirmationAccordionExists();
        new ConfirmationPage(driver).assertOnPaymentMethod(paymentMethod);
    }

    @Test(description = "User Completes Successful Dunning Flow Using CreditCard Without 3D")
    @TmsLink("WFCT-11947")
    public void SIT_GC05_UserCompletesSuccessfulDunningFlowUsingCreditCardWith3D() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new CreditCardPage(driver).enterCreditCardCredentials(testData.getTestData("3D_CreditCardNum"), testData.getTestData("3D_CreditCardMonth"), testData.getTestData("3D_CreditCardYear"), testData.getTestData("3D_CreditCardCvc"), testData.getTestData("3D_CreditCardHolder"));
        new CreditCardPage(driver).enter3DSecureCredentials(testData.getTestData("3D_CreditCardPassword"));
        new ConfirmationPage(driver).assertConfirmationAccordionExists();
        new ConfirmationPage(driver).assertOnPaymentMethod(paymentMethod);
    }

    @Test(description = "User Completes Failed Dunning Flow Using Sofort")
    @TmsLink("WFCT-11948")
    public void SIT_BC01_UserCompletesFailedDunningFlowUsingSofort() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new DunningGPP(driver).payWithSofort();
        new SofortPage(driver).cancelSofortPayment();
        new DunningGPP(driver).assertOnSofortAndAmazonPayErrorNotificationExixtance();

    }

    @Test(description = "User Completes Failed Dunning Flow Using CreditCard")
    @TmsLink("WFCT-11949")
    public void SIT_BC02_UserCompletesFailedDunningFlowUsingCreditCard() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new CreditCardPage(driver).enterCreditCardCredentials(testData.getTestData("FailedCreditCardNum"), testData.getTestData("FailedCreditCardMonth"), testData.getTestData("FailedCreditCardYear"), testData.getTestData("FailedCreditCardCvc"), testData.getTestData("FailedCreditCardHolder"));
        new DunningGPP(driver).assertOnCreditCardErrorText();
    }

    @Test(description = "User Completes Failed Dunning Flow Using CreditCard with 3D")
    @TmsLink("WFCT-11950")
    public void SIT_BC03_UserCompletesFailedDunningFlowUsingCreditCardWith3D() {
        new Dashboard(driver).expandContracts(contractNumber);
        new Dashboard(driver).clickDunningTile();
        new Dunning(driver).clickContinueToGPP();
        new DunningGPP(driver).choosePaymentMethod(paymentMethod);
        new CreditCardPage(driver).enterCreditCardCredentials(testData.getTestData("3D_CreditCardNum"), testData.getTestData("3D_CreditCardMonth"), testData.getTestData("3D_CreditCardYear"), testData.getTestData("3D_CreditCardCvc"), testData.getTestData("3D_CreditCardHolder"));
        new CreditCardPage(driver).cancel3DSecure();
        new DunningGPP(driver).assertOnCreditCardErrorText();
    }

}
