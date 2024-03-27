package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-9503")

public class WFCT_9503 extends SIT_BillingSetup {
    String contractOrder;
    String amount;
    String rowNum,barHeight;
    Dashboard dashboard;
    Rechnungen rechnungen;
    Kostenubersicht kostenubersicht;


    @BeforeMethod
    public void testDataSetup(Method method) {
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        amount = testData.getTestData(method.getName() + ".amount");
        rowNum = testData.getTestData(method.getName() + ".rowNum");
        barHeight = testData.getTestData(method.getName() + ".barHeight");

    }

    @Test(description = "WFCT-9503 | GC01- bart user with zero amount bill check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10347")
    public void GC01_bartZeroAmountChecksRechnungGraphAndTable() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.assertOnBarHeight(barHeight);
        rechnungen.assertOnThatFirstAmountValue(amount);
    }

    @Test(description = "WFCT-9503 | GC02- kay user with credit amount check Rechnung graph and table in Meine Rechnungen")
    @TmsLink("WFCT-10348")
    public void GC02_kayUserWithCreditAmountChecksRechnungGraphAndTableInMeineRechnungen() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.assertThatCreditIconExists(rowNum);
        rechnungen.assertOnCreditNotificationTitle(rowNum);
        rechnungen.assertOnCreditNotificationDescription(rowNum);
        rechnungen.assertThatTheAmountTextColorIsGreen(rowNum);
    }

}
