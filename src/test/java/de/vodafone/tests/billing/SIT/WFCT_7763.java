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
@Story("WFCT-7763")

public class WFCT_7763 extends SIT_BillingSetup {
    String contractOrder;
    Dashboard dashboard;
    Rechnungen rechnungen;
    Kostenubersicht kostenubersicht;


    @BeforeMethod
    public void testDataSetup(Method method) {
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");
        dashboard = new Dashboard(driver);
        rechnungen = new Rechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
    }

    @Test(description = "WFCT-7763 | SIT - GC02- marie user with more than 12 bills check rechnung table in Meine Rechnungen")
    @TmsLink("WFCT-10437")
    public void GC02_MarieWithMoreThan12BillsCheckRechnungTableInMeineRechnungen() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        rechnungen.assertOnTableTitleText();
        rechnungen.assertOnTableDescriptionText_MarieNoUsageItemized();
        rechnungen.assertOnShowMoreBtnText();
        rechnungen.clickShowMore();
        rechnungen.assertThatMonthColumnExists();
        rechnungen.assertThatAmountColumnExists();
        rechnungen.assertThatDueDateColumnExists();
        rechnungen.assertThatInvoiceColumnExists();
        rechnungen.assertThatInvoiceDownloadIconExists();
        rechnungen.assertThatInvoicePreviewIconExists();
        rechnungen.assertOnShowLessBtnText();

    }

}
