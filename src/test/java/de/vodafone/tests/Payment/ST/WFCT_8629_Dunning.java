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
@Story("WFCT-8629")

public class WFCT_8629_Dunning extends ST_PaymentSetup{
    Dashboard dashboard;
    TopUp topUp;
    TopupGPP topupGPP;
    ConfirmationPage confirmationPage;
    Dunning dunning;
    DunningGPP dunningGPP;
    String contractOrder;
    String paymentMethod;
    String savedPaymentMethod;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        topUp = new TopUp(driver);
        topupGPP = new TopupGPP(driver);
        confirmationPage = new ConfirmationPage(driver);
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        paymentMethod = testData.getTestData(method.getName() + ".paymentMethod");
        savedPaymentMethod = testData.getTestData(method.getName() + ".savedPaymentMethod");
        dunning = new Dunning(driver);
        dunningGPP = new DunningGPP(driver);
    }

    @Test(description = "WFCT_8629 | GC04 - Paul user checks top up with iban for dunning user")
    @TmsLink("WFCT-13049")
    public void GC04_PaulUserChecksTopUpWithIbanForDunningUser(Method method) {
        dashboard.clickDunningTile_ST();
        dunning.clickContinueToGPP();
        dunningGPP.assertThatIbanMethodNotExist();
    }
}
