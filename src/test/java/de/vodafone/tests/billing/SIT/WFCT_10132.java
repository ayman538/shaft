package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.MeineRechnungen;
import de.vodafone.pages.billing.Rechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")

public class WFCT_10132 extends SIT_BillingSetup {

    String itemizedBillBlockingIconRowNum;
    String itemizedBillWarningIconRowNum;
    String contract_number;

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Rechnungen rechnungen;

    @Test(description = "SIT - GC01 - marie has no itemized bill booked check rechnungen tab")
    @TmsLink("WFCT-12139")
    public void GC01_marieHasNoItemizedBillBookedCheckRechnungenTab() {
        dashboard.clickMeineRechnungenTile(contract_number);
        rechnungen.assertOnNotBookedItemizedBillTableDescription();
        rechnungen.assertThatNotRetrievedItemizedBillNotificationDoesNotExist();
        rechnungen.assertThatPartiallyBookedItemizedBillNotificationDoesNotExist();
        rechnungen.assertThatItemizedBillColumnDoesNotExist();
    }

    @Test(description = "SIT - GC02 - marie has itemized bill booked but no usage for a month or service doesn`t deliver check rechnungen tab")
    @TmsLink("WFCT-12140")
    public void GC02_marieHasItemizedBillBookedButNoUsageCheckRechnungenTab() {
        dashboard.expandContracts(contract_number);
        dashboard.clickMeineRechnungenTile(contract_number);
        rechnungen.assertOnNotRetrievedItemizedBillTableDescription();
        rechnungen.assertThatNotRetrievedItemizedBillNotificationExists();
        rechnungen.assertOnNotRetrievedItemizedBillNotificationCl();
        rechnungen.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        rechnungen.assertOnWarningIconCl(itemizedBillWarningIconRowNum);

    }

    @BeforeMethod
    public void testDataSetup(Method method) {
        contract_number = testData.getTestData(method.getName() + ".contract_number");
        itemizedBillWarningIconRowNum = testData.getTestData(method.getName() + ".itemizedBillWarningIconRowNum");
        itemizedBillBlockingIconRowNum = testData.getTestData(method.getName() + ".itemizedBillBlockingIconRowNum");
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        rechnungen = new Rechnungen(driver);
    }
}
