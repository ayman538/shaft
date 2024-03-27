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
@Story("WFCT-10240")

public class WFCT_10240 extends SIT_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;
    String month;
    String mobileNum;
    String contractOrder;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        month = testData.getTestData(method.getName() + ".month");
        mobileNum = testData.getTestData(method.getName() + ".mobileNum");
        contractOrder = testData.getTestData(method.getName() + ".contractOrder");

    }

    @Test(description = "GC01 - Kay user filters Kostenübersicht tab data by month")
    @TmsLink("WFCT-10822")
    public void GC01_KayUserFiltersKostenübersichtTabDataByMonth() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(month);
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertThatInvoicesNumMoreThan1();
    }

    @Test(description = "GC02 - Bart user filters Kostenübersicht tab data by month and phone number")
    @TmsLink("WFCT-11095")
    public void GC02_BartUserFiltersKostenübersichtTabDataByMonthAndPhoneNumber() {
        dashboard.expandContracts(contractOrder);
        dashboard.clickMeineRechnungenTile(contractOrder);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(month);
        kostenubersicht.choosePhoneNumberFilter(mobileNum);
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertThatInvoicesNumEquals1();
    }

    }
