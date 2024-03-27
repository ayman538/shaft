package de.vodafone.tests.billing.SIT;

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
@Feature("SIT")

public class WFCT_11275 extends SIT_BillingSetup {
    String amountRow;
    String firstPhoneNumber;
    String secondPhoneNumber;
    String contract_number;
    String msisdn;
    String Month;

    Dashboard dashboard;
    MeineRechnungen meineRechnungen;
    Kostenubersicht kostenubersicht;


    @Test(description = "GC01 - Kay user check cost overview page in case of tariff change")
    @TmsLink("WFCT-12290")
    public void GC01_KayUserCheckCostOverviewPageInCaseOfTariffChange() {
        dashboard.clickMeineRechnungenTile(contract_number);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.assertThatAmountColumnExists();
        kostenubersicht.chooseMonthFilter(Month);
        kostenubersicht.assertThatMonthIsSelected(Month);
        kostenubersicht.assertThatNumberIsDuplicated(firstPhoneNumber);
        kostenubersicht.assertThatNumberIsDuplicated(secondPhoneNumber);
        kostenubersicht.choosePhoneNumberFilter(msisdn);
        kostenubersicht.assertThatOnlyTheSelectedNumberIsDisplayed(firstPhoneNumber);

    }


    @Test(description = "GC02 - bart user check cost overview page in case of credit amount")
    @TmsLink("WFCT-12291")
    public void GC02_BartUserCheckCostOverviewPageInCaseOfCreditAmount() {
        dashboard.expandContracts(contract_number);
        dashboard.clickMeineRechnungenTile(contract_number);
        meineRechnungen.clickKostenübersichtTab();
        kostenubersicht.chooseMonthFilter(Month);
        kostenubersicht.assertThatCreditIconNotificationTitleIsCorrect(amountRow);
        kostenubersicht.assertThatCreditIconNotificationDescriptionIsCorrect(amountRow);
        kostenubersicht.hoverOnCreditAmountIcon();
        kostenubersicht.assertThatCreditAmountWrittenInGreen(amountRow);


    }

    @BeforeMethod
    public void testDataSetup(Method method) {
        contract_number = testData.getTestData(method.getName() + ".contract_number");
        amountRow = testData.getTestData(method.getName() + ".amountRowNum");
        firstPhoneNumber = testData.getTestData(method.getName() + ".firstPhoneNumber");
        secondPhoneNumber = testData.getTestData(method.getName() + ".secondPhoneNumber");
        Month = testData.getTestData(method.getName() + ".Month");
        dashboard = new Dashboard(driver);
        meineRechnungen = new MeineRechnungen(driver);
        kostenubersicht = new Kostenubersicht(driver);
        msisdn = testData.getTestData(method.getName() + ".msisdn");

    }
}
