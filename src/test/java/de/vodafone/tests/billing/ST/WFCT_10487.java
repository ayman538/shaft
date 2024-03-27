package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")


public class WFCT_10487 extends ST_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    String amount;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        amount = testData.getTestData(method.getName()+ ".amount");
    }

    @Test(description = "ST - GC01 - Bart user with 0 amount check amount representation in Dashboard & bill`s Table and Graph",enabled = false)
    @TmsLink("WFCT-10789")
    public void GC01_BartZeroAmountChecksAmountRepresentationInDashboardAndBillTableAndGraph(Method method) {
        dashboard.assertThatNotRetrievedAmountIconDoesNotExist();
        dashboard.assertOnTheDisplayedAmountInDashboard(amount);
        dashboard.assertThatCreditFlagNotDisplayed();
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertThatBarHeight2px();
        rechnungen.assertOnThatFirstAmountValue(amount);
    }

    @Test(description = "ST - GC02 - Kay user with positive amount check amount representation in Dashboard & bill`s Table and Graph",enabled = false)
    @TmsLink("WFCT-10790")
    public void GC02_KayPositiveAmountChecksAmountRepresentationInDashboardAndBillTableAndGraph(Method method) {
        dashboard.assertThatNotRetrievedAmountIconDoesNotExist();
        dashboard.assertOnTheDisplayedAmountInDashboard(amount);
        dashboard.assertThatCreditFlagNotDisplayed();
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertThatBarHeightNot2Px();
        rechnungen.assertThatFirstBarHeightIsNotZero();
        rechnungen.assertOnThatFirstAmountValue(amount);
    }

    @Test(description = "ST - GC03 - Bart user with negative amount check amount representation in Dashboard & bill`s Table and Graph",enabled = false)
    @TmsLink("WFCT-10791")
    public void GC03_BartNegativeAmountChecksAmountRepresentationInDashboardAndBillTableAndGraph() {
        dashboard.assertThatNotRetrievedAmountIconDoesNotExist();
        dashboard.assertOnTheDisplayedAmountInDashboard(amount);
        dashboard.assertThatCreditCardFlagDisplayed();
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertThatGuthabenWordExists();
        rechnungen.assertThatCreditIconExists();
        rechnungen.assertOnCreditNotificationTitle();
        rechnungen.assertOnCreditNotificationDescription();
        rechnungen.assertThatTheAmountTextColorIsGreen();
    }

    @Test(description = "ST - GC04 - kay user with not retrieved amount check amount representation in Dashboard & bill`s Table and Graph",enabled = false)
    @TmsLink("WFCT-10792")
    public void GC04_KayAmountNotRetrievedChecksAmountRepresentationInDashboardAndBillTableAndGraph() {
        dashboard.assertThatNotRetrievedAmountIconExist();
        dashboard.assertOnNotRetrievedAmount();
        dashboard.clickMeineRechnungenTile();
        rechnungen.assertOnNotRetrievedAmountText();
        rechnungen.assertThatTheFirstBarHeightIsZero();


    }

}
