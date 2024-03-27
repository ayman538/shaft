package de.vodafone.tests.billing.ST;


import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_10240 extends ST_BillingSetup {
    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;
    String month;
    String mobileNum;

    @BeforeMethod
    public void beforeMethod(Method method) {
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        month = testData.getTestData(method.getName() + ".month");
        mobileNum = testData.getTestData(method.getName() + ".mobileNum");
    }

    @Test(description = "GC01 - Kay user filters Kostenübersicht tab data by month")
    @TmsLink("WFCT-10820")
    public void GC01_KayUserFiltersKostenübersichtTabDataByMonth() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(month);
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertThatInvoicesNumMoreThan1();
    }

    @Test(description = "GC02 - Bart user filters Kostenübersicht tab data by month and phone number")
    @TmsLink("WFCT-10821")
    @Issue("WFCT-15230")
    public void GC02_BartUserFiltersKostenübersichtTabDataByMonthAndPhoneNumber() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(month);
        kostenubersicht.choosePhoneNumberFilter(mobileNum);
        kostenubersicht.assertOnTableHeadLineText();
        kostenubersicht.assertOnTableDescriptionText();
        kostenubersicht.assertOnMobileNumberTitleText();
        kostenubersicht.assertOnCostOverviewTitleText();
        kostenubersicht.assertOnConnectionOverviewTitleText();
        kostenubersicht.assertThatInvoicesNumEquals1();
    }

    }
