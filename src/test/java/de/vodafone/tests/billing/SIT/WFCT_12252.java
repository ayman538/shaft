package de.vodafone.tests.billing.SIT;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("SIT")
@Story("WFCT-12252")

public class WFCT_12252 extends SIT_BillingSetup {

    String itemizedBillBlockingIconRowNum;
    String itemizedBillWarningIconRowNum;
    String contract_number;
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;


    @Test(description = "GC02 - peter user has itemized bill booked but no usage for a month or service doesn`t deliver check kostenubersicht tab")
    @TmsLink("WFCT-12476")
    public void GC02_PeterUserHasItemizedBillBookedButNoUsageCheckKostenubersichtTab() {
        dashboard.expandContracts(contract_number);
        dashboard.clickMeineKostenTile(contract_number);
        kostenubersicht.assertOnPeterNotRetrievedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        kostenubersicht.assertOnWarningIconCl(itemizedBillWarningIconRowNum);

    }

    @Test(description = "GC06 - kay has itemized bill booked but no usage for a subscriber or service doesn`t deliver check kostenubersicht tab")
    @TmsLink("WFCT-12480")
    public void GC06_KayUserHasItemizedBillBookedButNoUsageCheckKostenubersichtTab() {
        dashboard.expandContracts(contract_number);
        dashboard.clickMeineRechnungenTile(contract_number);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertOnKayAndBartNotRetrievedItemizedBillTableDescription();
        kostenubersicht.assertThatNotBookedLinkDoesNotExist();
        kostenubersicht.assertThatWarningIconExists(itemizedBillWarningIconRowNum);
        kostenubersicht.assertOnWarningIconCl(itemizedBillWarningIconRowNum);
    }

    @BeforeMethod
    public void testDataSetup(Method method) {
        contract_number = testData.getTestData(method.getName() + ".contract_number");
        itemizedBillWarningIconRowNum = testData.getTestData(method.getName() + ".itemizedBillWarningIconRowNum");
        itemizedBillBlockingIconRowNum = testData.getTestData(method.getName() + ".itemizedBillBlockingIconRowNum");
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
    }

}
