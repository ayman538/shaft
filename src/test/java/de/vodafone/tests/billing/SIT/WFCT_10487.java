package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-10487")

public class WFCT_10487 extends SIT_BillingSetup {
    Dashboard dashboard;
    Rechnungen rechnungen;
    String contractOrder;
    String amount;



    @BeforeMethod
    public void testDataSetup(Method method) {
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        contractOrder = testData.getTestData(method.getName()+".contractOrder");
        amount = testData.getTestData(method.getName()+".amount");
    }
    @Test(description = "GC02_MarieDunningCheckAmountRepresentationInDashboardBillTableAndGraph")
    @TmsLink("WFCT-12115")

    public void GC02_MarieDunningCheckAmountRepresentationInDashboardBillTableAndGraph(){
        dashboard.expandContracts(contractOrder);
        dashboard.assertThatNotRetrievedAmountIconDoesNotExist();
        dashboard.assertOnTheDisplayedAmountInDashboard(amount);
        dashboard.assertThatCreditFlagNotDisplayed();
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.assertThatBarHeightNot2Px();
        rechnungen.assertThatFirstBarHeightIsNotZero();
        rechnungen.assertOnThatFirstAmountValue(amount);
    }

}
