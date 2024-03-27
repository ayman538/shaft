package de.vodafone.tests.billing.ST;

import de.vodafone.pages.billing.Dashboard;
import de.vodafone.pages.billing.Kostenubersicht;
import de.vodafone.pages.billing.MeineRechnungen;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.TmsLink;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

@Epic("Billing")
@Feature("ST")

public class WFCT_11275 extends ST_BillingSetup {

    String amountRow;
    String firstPhoneNumber;
    String secondPhoneNumber;
    String msisdn;

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;

    @Test(description = "GC01 - Kay user check cost overview page in case of tariff change")
    @TmsLink("WFCT-12290")
    public void GC01_KayUserCheckCostOverviewPageInCaseOfTariffChange() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertThatAmountColumnExists();
        kostenubersicht.assertThatNumberIsDuplicated(firstPhoneNumber);
        kostenubersicht.assertThatNumberIsDuplicated(secondPhoneNumber);
        kostenubersicht.choosePhoneNumberFilter(msisdn);
        kostenubersicht.assertThatOnlyTheSelectedNumberIsDisplayed(firstPhoneNumber);

    }


    @Test(description = "GC02 - bart user check cost overview page in case of credit amount")
    @TmsLink("WFCT-12291")
    public void GC02_BartUserCheckCostOverviewPageInCaseOfCreditAmount() {
        dashboard.clickMeineRechnungenTile();
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertThatCreditAmountWrittenInGreen(amountRow);
        kostenubersicht.assertThatCreditIconNotificationTitleIsCorrect(amountRow);
        kostenubersicht.assertThatCreditIconNotificationDescriptionIsCorrect(amountRow);

    }

    @BeforeMethod
    public void testDataSetup(Method method) {
        amountRow = testData.getTestData(method.getName() + ".amountRowNum");
        firstPhoneNumber = testData.getTestData(method.getName() + ".firstPhoneNumber");
        secondPhoneNumber = testData.getTestData(method.getName() + ".secondPhoneNumber");
        msisdn = testData.getTestData(method.getName() + ".msisdn");
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
    }
}
